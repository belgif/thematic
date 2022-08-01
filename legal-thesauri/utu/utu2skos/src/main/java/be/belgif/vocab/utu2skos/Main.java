/*
 * Copyright (c) 2022, FPS BOSA DG DT
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package be.belgif.vocab.utu2skos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.util.Statements;
import org.eclipse.rdf4j.model.util.Values;
import org.eclipse.rdf4j.model.vocabulary.DCTERMS;
import org.eclipse.rdf4j.model.vocabulary.OWL;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.ROV;
import org.eclipse.rdf4j.model.vocabulary.SKOS;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFWriter;
import org.eclipse.rdf4j.rio.Rio;

/**
 * Convert Excel UTU file into SKOS (N-Triples)
 * 
 * @author Bart.Hanssens
 */
public class Main {
	private static Logger LOG = Logger.getGlobal();

	private static String niv0;
	private static String niv1;
	private static String niv2;

	/**
	 * Create an RDF statement
	 * 
	 * @param subj
	 * @param pred
	 * @param obj
	 * @return statement
	 */
	private static Statement statement(IRI subj, IRI pred, Value obj) {
		return Statements.statement(subj, pred, obj, null);
	}

	/**
	 * Write (mostly hardcoded) info about the UTU thesaurus
	 * 
	 * @param prefix
	 * @param version
	 * @param w 
	 */
	private static void writeHeader(String prefix, String version, RDFWriter w) {
		IRI subj = Values.iri(prefix);
		w.handleStatement(statement(subj, RDF.TYPE, SKOS.CONCEPT_SCHEME));
		
		IRI cc = Values.iri("https://creativecommons.org/licenses/by/4.0/");		
		w.handleStatement(statement(subj, DCTERMS.LICENSE, cc));
		
		for (String lang: new String[] {"nl", "fr", "de", "en"}) {
			w.handleStatement(statement(subj, DCTERMS.TITLE, Values.literal("UTU 2021", lang)));
			w.handleStatement(statement(subj, DCTERMS.DESCRIPTION, Values.literal("Universele Thesaurus Universel 2021", lang)));

			w.handleStatement(statement(cc, DCTERMS.TITLE, Values.literal("Creative Commons Attribution 4.0 International", lang)));
		}

		IRI utu =  Values.iri("https://org.belgif.be/id/CbeRegisteredEntity/0808125806");
		w.handleStatement(statement(subj, DCTERMS.CREATOR, utu));
		w.handleStatement(statement(subj, DCTERMS.RIGHTS_HOLDER,utu));
		w.handleStatement(statement(subj, ROV.LEGAL_NAME, Values.literal("vzw UTU", "nl")));
		w.handleStatement(statement(subj, ROV.LEGAL_NAME, Values.literal("asbl UTU", "fr")));
		w.handleStatement(statement(subj, ROV.LEGAL_NAME, Values.literal("VoG UTU", "de")));
		w.handleStatement(statement(subj, ROV.LEGAL_NAME, Values.literal("vzw/asbl UTU", "nl")));		
		
		w.handleStatement(statement(subj, OWL.VERSIONINFO, Values.literal(version)));
		w.handleStatement(statement(subj, DCTERMS.MODIFIED, Values.literal(Instant.now().toString())));
	}

	/**
	 * Process rows
	 * 
	 * @param sheet
	 * @param prefix namespace
	 * @param w writer
	 * @throws IOException
	 */
	private static void processRows(Sheet sheet, String prefix, RDFWriter w) throws IOException {
		try (Stream<Row> rows = sheet.openStream()) {
			rows.skip(2).forEach(r -> {
				String[] cells = r.stream().map(c -> c != null ? c.getRawValue() : "").toArray(String[]::new);
				String code = cells[0];
				if (code == null || code.isBlank()) {
					LOG.warning("Empty code for line: " + String.join(";", cells) );
					return;
				}
				
				String parent = null;
				String nl = "";
				String fr = "";

				if (cells[1] != null && !cells[1].isEmpty()) {
					niv0 = code;
					parent = null;
					nl = cells[1];
					fr = cells[5];
				} else if (cells[2] != null && !cells[2].isEmpty()) {
					niv1 = code;
					parent = niv0;
					nl = cells[2];
					fr = cells[6];
				} else if (cells[3] != null && !cells[3].isEmpty()) {
					niv2 = code;
					parent = niv1;
					nl = cells[3];
					fr = cells[7];
				} else {
					parent = niv2;
					nl = cells[4];
					fr = cells[8];
				}
				IRI subj = Values.iri(prefix + "/", code);

				w.handleStatement(statement(subj, RDF.TYPE, SKOS.CONCEPT));
				w.handleStatement(statement(subj, SKOS.PREF_LABEL, Values.literal(nl, "nl")));
				w.handleStatement(statement(subj, SKOS.PREF_LABEL, Values.literal(fr, "fr")));
				
				if (parent != null) {
					IRI subjPar = Values.iri(prefix + "/", parent);
					w.handleStatement(statement(subj, SKOS.BROADER, subjPar));
					w.handleStatement(statement(subjPar, SKOS.NARROWER, subj));
				} else {
					IRI subjPar = Values.iri(prefix);
					w.handleStatement(statement(subj, SKOS.TOP_CONCEPT_OF, subjPar));
					w.handleStatement(statement(subjPar, SKOS.HAS_TOP_CONCEPT, subj));					
				}
			});
		}
	}

	/**
	 * Main
	 * 
	 * Opens reader and writer
	 * 
	 * @param args
	 * @throws IOException 
	 */
    public static void main(String[] args) throws IOException {
        if (args.length < 4) {
			LOG.severe("Usage: java -jar utu2skos.jar input.xlsx output.nt http://prefix.be/utu version-string");
			System.exit(-1);
		}
		String infile = args[0];
		String outfile = args[1];
		String prefix = args[2];
		String version = args[3];

		LOG.fine("Start conversion");
		try (InputStream is = Files.newInputStream(Paths.get(infile)); 
				ReadableWorkbook wb = new ReadableWorkbook(is);
				OutputStream os = Files.newOutputStream(Paths.get(outfile))) {
			Sheet sheet = wb.getFirstSheet();

			RDFWriter w = Rio.createWriter(RDFFormat.NTRIPLES, os);
			w.startRDF();

			writeHeader(prefix, version, w);
			processRows(sheet, prefix, w);

			w.endRDF();
		}
		LOG.fine("End conversion");
    }
}
