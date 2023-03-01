# Organization ID and Discovery


## Use cases:

Various linked data exports require IDs for identifying (parts) of an administration as publisher, maintainer or responsible party:
- BOSA "linked data dashboard" registry applications like GDPR registry, website registry... 
- EU Regulations/Directives requiring regional/national portals to be harvested, e.g. PSI/Open Data, Single Digital Gateway...

## Linking to non-official sources

It is recommended to link the URI from the official source(s) to well-known but unofficial linked data sources like 
[KBOData.be](http://kbodata.be/) (a private initiative of Paul Hermans, but used by some Flemish agencies) and
[OpenCorporates](https://opencorporates.com) (a award-winning semi-commercial initiave harvesting company information from around the globe),
using a `owl:sameAs` or `skos:exactMatch`

## Other metadata

This is out of the scope of this document, though the use of [W3C ORG](https://www.w3.org/TR/vocab-org/) and [W3C ROV](https://www.w3.org/TR/vocab-regorg/) are recommended.

## Discovery

As the BCE can contain the link to the homepage of an (registered) organization or establishment unit, 
this homepage could contain semantic markup in RDFa/JSON-LD format.
Or, as an alternative approach, by using [Well-Known URIs](https://tools.ietf.org/html/rfc8615) as locator of a file containing the organogram in RDF, e.g. the assigned URI [openorg](https://www.iana.org/assignments/well-known-uris/well-known-uris.xhtml).
