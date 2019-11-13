# Minutes

When: 2019-11-08 14:00 - 16:00

Where: FPS BOSA DG DT, WTC3

## Invitees and Attendees
- [X] BCED (EnsembleSimplifions)
- [X] BRIC (CIRB/CIBG)
- [ ] BRPS (GOB/SPRB)
- [ ] BruLocalis
- [X] CBE (FPS Economy - KBO/BCE)
- [ ] CBSS (KSZ/BCSS)
- [X] CFWB
- [ ] DGOV (Ostbelgien)
- [ ] eHealth
- [X] FPS BOSA DG DT
- [ ] FPS Finance
- [ ] IMIO
- [X] InformatieVlaanderen
- [ ] V-ICT-OR
- [ ] VVSG

## Notes

InformatieVlaanderen presented (again) the [concept of URIs and linked data](https://github.com/belgif/thematic/blob/master/URI/Meetings/2019-10-11/iceg_uri_workinggroup_20191011_v_1_02.pptx?raw=true).

## General questions on the URI

### URI structure for general ID
Structure: http(s)://(domain)/id/(concept)/(id)

The idea is that the URI (the ID) remains stable, and redirects to the page/resource with the data (so the location of this page/resource can change)

What domain should we use for URIs / "redirect proxy" ?
- Perhaps belgif.be (not belgium.be) could be used
- (Business) owner must guarantee that it will remain exactly the same and available for "eternity"

What level of detail in concept ?
- E.g. instead of "company" it might be better to use "organization"

Who manages concepts and IDs ?
- Based on existing identifiers in "authentic source"
- Must be unique, and remain unique over time (no re-use / recycling of identifiers)
- Often based on a English abbreviation (doesn't matter for a machine, but looks nice for human experts)

### URI structure for taxonomies (code lists, thesauri etc)

Structure: http(s)://(domain)/(x)/(list)/(id)

What should (x) be: resource ? auth ?
- There are several conventions in place (e.g vocab.belgif.be/auth), most important is to come up with a (very limited) list of conventions.

Format to actually publish those taxonomies ?
- [W3C SKOS](https://www.w3.org/2004/02/skos/intro) for publication of taxonomies, lists etc in machine readable form. This is also used by the [EU Publication Office](https://op.europa.eu/en/web/eu-vocabularies/authority-tables), in addition to human readable pages.

### URI structure for vocabularies (semantic markup)

Structure: http(s)://(domain)/ns/vocabulary#Class and http(s)://(domain)/ns/vocabulary#property
- Generally the '#' notation is used, so that vocabularies are all on the same "page" (retrieved using only one HTTP GET)
- Classes start with an uppercase, in English
- properties start with a lowercase, in English
- Formats to use: RDF Schema and/or OWL


## Next meeting

When: 2019-11-22 14:00 - 16:00

Where: InformatieVlaanderen, [Ellips Building](https://www.vlaanderen.be/vlaamse-overheid/gebouwen/ellipsgebouw), Koning Albert II-laan 35 1030 Brussel

## Actions
- [ ] All: check that the right people (experts) are attending the thematic meeting
- [ ] All: review the [concept of URIs and linked data presentation](https://github.com/belgif/thematic/blob/master/URI/Meetings/2019-10-11/iceg_uri_workinggroup_20191011_v_1_02.pptx?raw=true), and let BOSA/InformatieVlaanderen know if there are questions, things that are not clear
- [ ] FPS BOSA and InformatieVlaanderen: create a full draft that can be reviewed by the other members
