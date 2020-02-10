# ICEG-standard for URI's in data

## Contents

* [About](#about)
  * [Revision history](#revision-history)
* [Management summary](#management-summary)
* [Introduction](#introduction)
  * [Resource](#resource)
  * [URIs](#uris)
  * [Domain name](#domain-name)
  * [Namespaces](#namespaces)
* [Rules](#rules)
  * [Domain](#domain)
  * [Type](#type)
  * [Concept](#concept)
  * [Reference](#reference)
  * [Fragment identifiers](#fragement-identifiers)
* [Exceptions](#exceptions)
* [The URI standard compliancy checklist](#the-uri-standard-compliancy-checklist)
* [References](#references)

## About

### Revision history
Current status: draft

Revision | Date | Contributor(s) | Comments
-------- | ---- | -------------- | --------
0.8      | 23/03/2017 | L. De Vocht<br>M. Van Compernolle | Processing final feedback of public working groups
0.9      | x/11/2019 | M. Bruyland<br>B. Hanssens<br>L. Dhondt<br>O-P. Bakasanda<br>Thierry Brouwer<br>R. Buyle<br>D. Van Lancker<br>B. Van Nuffelen | Document proposal as candidate recommendation
0.10     | 04/11/2019 | B. Van Nuffelen, D. Van Lancker | address issues raised in working group 
0.11     | 10/02/2020 | B. Hanssens | address remaining issues

## Management summary

This document describes the ICEG standard for the publication of resources, information and data, by the Belgian Federal State, the Regions and Communities. A checklist is included at the end of this document, which can be used as a self-evaluation instrument for the evaluation of URIs.

The standard defines the minimal requirements to which the authorities should comply in order to disclose resources in a 
uniform manner via the web. It describes how ‘Uniform Resource Identifiers’ ([URIs](#URI)) should be defined in order 
to identify these resources in a persistent way. This enables back-office systems to evolve while the URI remains stable. 

This document also applies to data disclosed via services, but does not necessarily apply to the services themselves, given that 
persistence for services is hard to realise and it is inefficient. 

All persistent URIs must be formed according the following pattern: 
```
http(s)://{domain}/{type}/{concept}(/{reference})* 
```

The parameters are placed between **{}**; __*__ indicates ‘0 or multiple times’; **()** indicates a group.

**Domain**: This part of the URI pattern is formed by the hostname and may be preceded by a _subdomain_. 
The guidelines concerning the management of subdomains are outside the scope of this document. Domains must use neutral, organization-independent and timeless terms to remain persistent. 

**Type**: This term describes the nature of the underlying resource. For the _type_, as part of the URI pattern, a classification is proposed with at least the following terms: **id** (_identification_), **doc** (_document_), **auth** (_authority tables_) and **ns** (_namespace_). 
The aim is to make a distinction between the representation on the web and the actual concept or object in the real world.

**Concept**: This term represents the category of the resource (e.g. by means of a hierarchical classification). 
The _resource-category_ obtains its meaning in the context of a domain and should be interpreted as follows: 
{_resource_} is (a) {_concept_}-{_type_}

**Reference**: refers to one particular instance of a resource and is formed by the following sub-pattern: 
{_reference-basis_}(/{_reference-version_})*

## Introduction

In the digital society, it is expected from governments to disclose databases with public sector information over the web between 
governments and third parties following a widely supported methodology. To ensure structured and identifiable processes, for both machines and humans, URIs provide a solution.


Note that there are no language or content guidelines to which the terms, as part of the URI, must comply. 
Every public service or organisation is free to develop a policy according to their own needs, to develop agreements and document these.

The example below shows the composition of a URI, containing a domain, namespace and a reference.

![URI architecture](https://github.com/belgif/thematic/blob/master/URI/images/uri_architecture.PNG)

In the example above:
*	The domain: example.com 
*	The namespace: http://example.com/id/organisation/
*	The URI: http://example.com/id/organisation/894556644566-0765433 
* Type, concept and reference are explained more in detail in Chapter 4.

### Resource

The term ‘resource’ was first introduced to refer to specialized pages and content within a website ([URL](#URL)), 
more specifically to the destinations of URLs (e.g. the contact page on a website), but later on, the definition was 
expanded to cover everything to which a URI can refer to (e.g. the address with the geolocation in Google Maps from the same contact page).

Two groups of resources are distinguished: information resources and non-information resources.
* __Information Resources__: objects that (may) have a digital representation, such as
  * __Data__: representation of objects or things stored in any electronic format on a storage medium;
  * (web-)__services__: allow access to data, taking actions with data (= modifying them). (web-)services are services that enable a machine to provide access to data and allow to perform actions on and with the data;
  * __Ontologies__ (or vocabularies): contain terms, their definitions and the relationship between the terms to describe data;
  * __Documents__: describing (non)-information resources on the web;
* __Non-information resources__: things, objects or events from the ‘real’ world without representation on a computer, but for which the description can have a representation on a machine. The description of non-information resources are included in **documents**.

Example: the report of a meeting is a document (= the report) describing a non-information resource (= the meeting).



### URIs

A URI is a formal way to refer to a resource. The most well-known form of a URI is a URL, which can be seen as an equivalent of a web 
address. A URL is a URI that makes use of the well-known HTTP URI scheme, so every URL is a URI (of an existing resource on the web).

To retrieve the resource, a URI must be ‘resolvable’. This is achieved by a service that interprets the requested URI, and either replies with a description of the content, or refers to another service that can describe this URI. All resources should be uniquely identifiable.

### Domain name

This term of the URI pattern is formed by the [DNS](#DNS) host name, possibly preceded by a subdomain.
  
### Namespaces
 
Namespaces are a way to define, among others, concepts and variables and to categorize them in order to be unique in the group they belong to. It is very common to define a namespace via the HTTP(S) URI scheme.

Example:

| Description | Domain name | Namespace | URI |
| ----------- | ----------- | --------- | --- |
| Page describing the Atomium, a monument in Brussels | dbpedia.org | http://dbpedia.org/page/ | http://dbpedia.org/page/Atomium |

## Rules 

In order to define the basic concepts of the URI standard - namespaces, identifiers, versions - in a uniform manner, a number of guidelines must be followed. 

**Rule 1**: the HTTPS or HTTP URI scheme must be used as the basis for the definition of the URIs.<br><br>
Although it is only one of the possible URI schemes allowed by [IANA](#IANA), there is a growing consensus within various standardisation communities ([OGC](#OGC), [INSPIRE](#INSPIRE), [W3C](#W3C)) to use the HTTP(S) URI scheme. 
From all possible schemes, HTTP(S) is the most universal applied scheme with support for dereferencing. Dereferencing an identifier is the process which returns information about the entity the identifier describes.    

**Rule 1.1**: HTTPS is the recommended scheme. New applications should use HTTPS for their URIs. HTTP forwarding to HTTPS may be enabled for a domain to support users, but the to-be-used and shared identifier URI is the HTTPS based. URIs which only difference in the usage of the scheme, namely HTTP and HTTPS, should identify the same entity.    


**Rule 2**: All URIs must be defined following this pattern:
```
http(s)://{domain}/{type}/{concept}(/{reference})*
```
The pattern for forming the URI is based on the guidelines from [INSPIRE](#INSPIRE) and [ISA](#ISA).
This convention has the advantage that URIs can be defined consistently.
* __Rule 2.1__: {domain}, {type} and {concept} are mandatory parts of the URI
* __Rule 2.2__: References are optional, and there can be more than one depending on the situation. 
* __Rule 2.3__: The basic combination {domain}/{type}/{concept} in the absence of a (/{reference})* may only refer to one resource ( =unique on the web) and must be invariable (since {reference} is optional).
* __Rule 2.4__: The (/{reference})* in combination with {domain}/{type}/{concept} must be unique and constant on the web. This means that once the {reference} is assigned, the reference itself as well as the semantic description of the resource cannot be changed.

### Domain

**Rule 3**: The name of the domain and all potential subdomains, must be independent of the organisation, product, brand and time. 
The domain cannot contain a name that may cease to exist, since it must remain persistent.

### Type

**Rule 4**: the {type} as part of the URI pattern is mandatory and is the main classification for resources. The {type} makes a distinction between 
(1) the actual object/concept, (2) the digital or web-representation and/or (3)/(4) a term belonging to a vocabulary or ontology.

The {type} as part of the URI pattern says something about the nature of the resource description and 
follows a classification which contains at least the following terms to make a clear distinction.
1.	**id**: _identifier_ is a reference to an object from the real world or an abstract concept;
1.	**doc**: _document_ is a representation on the web or a description of real-world objects or abstract concepts. It deals with general descriptive information (web documents).
1.	**ns**: _namespace_ for ontologies or vocabularies.
1. 	**auth**: _namespace_ for codelists or taxonomies

Additional types are possible and should be implemented following the agreed guidelines that apply to the domain. 
These additional types cannot replace one the four categories described above. The types _ns_ and _auth_ are special cases which could be supported by the _id_ & _doc_ types, but are commonly used in a slightly different way. To support the current existing practices they are supported by dedicated types. 

**Rule 5**: 
A URI for an _identifier_ should provide digital web representations via redirections. I.e. identifiers are _dereferenceable_. The recommended approach is to redirect a URI with type _id_ via a 303 HTTPredirect to a URI with the type _doc_.  


Examples:
* **https://data.belgif.be/id/waterway/8399104101108100101** – is an identifier for the real world object ‘Schelde’ or ‘Escaut’. 
This object cannot exist on the web, but it can be referred to from other applications or data. If the waterway (real world object) ‘Schelde’/‘Escaut’ ever changes its name or would no longer exist, its URI must remain by either referring to the old object ‘Escaut’/‘Schelde’ or by referring to the same object with the new name. 
* **https://data.belgif.be/doc/waterway/8399104101108100101**
  * refers to a document (e.g. HTML page) containing an explanation about the river ‘Schelde’/'Escaut'. This document can have structured data, but this is not a requirement.
  * describes meta-information such as the history, versions, source, and details of the actions made on all representations of {type}/waterway/8399104101108100101. 
* **https://data.belgif.be/ns/waterway** - is the namespace that can be used in the vocabulary dealing with waterways. E.g. ns/waterway#depth refers to the term depth from the namespace ns/waterway and serves to indicate the depth of the waterways.

### Concept

**Rule 6**: The {_concept_}, as mandatory part of the URI pattern, represents the category of the resource. 
The categorization can be done by means of an agreed (hierarchical) classification or list, but this is not mandatory. 
Overlaps with terms used for type and reuse of the terms from the domain name are not allowed.

Example: The concept in this example is waterway.
```
https://data.belgif.be/id/waterway/8399104101108100101
``` 

### Reference

**Rule 7**: the (/{_reference_})* as part of the URI pattern refers to one particular resource. 
The {_reference_} element can appear multiple times to create a hierarchical structure.

**Rule 8**: Every {_reference_} can be completed in two different ways: {_reference-basis_} or {_referencebasis_}/{_reference-version_}.

The _reference-basis_ is the part of the reference that refers to the resource. 
The _reference-version_ is the version of this resource that is managed. 
There should always be a _reference-basis_ in the reference, but not always a _reference-version_. 
The interpretation of the _reference-basis_ and -_version_ is organisation dependent (but also data management dependent).

### Fragment identifiers

Components with type **ns** may use fragment identifiers in order to define all terms from a particular vocabulary into one single web document. The fragment identifier component of the URI allows adding an indirect identification after the ‘**#**’ of the resource described in the corresponding resource identified before the ‘**#**’. 

All persistent URIs with type ns must be formed according the following pattern: 
```
http(s)://{domain}/ns/{concept}(/{reference})*(#{fragment})? 
```

Examples:

* _/ns/artefact_ - refers to the namespace in which the artefacts are described
* _/ns/artefact#Relic_ - identifies the notion Relic in the namespace _/ns/artifact_; The digital representation of the namespace _/ns/artifact_ contains the digital representation of the identifier _/ns/artifact#Relic_. 

* _/ns/artefact/Relic_ - refers either to a subnamespace _/Relic_ in the namespace _/ns/artefact_ or to a specific identifier in the namespace _/ns/artefact_. 
  * In the latter case, a redirect to the document representing the digitial representation of the identifier _/ns/artefact/Relic_ must be foreseen.  
  * In the first case, fragment identifiers can be used to identify notions as _/ns/artefact/Relic#vase_. 



## Scope & Exceptions
### REST service URLs are out of scope

When it comes to **services**: if the data coming from services must be persistent, the data entities have to follow all the rules from the URI standard. It makes little sense for services that are disclosing data, to additionally enforce persistence and/or enforce the rules. Moreover, persistence for existing services is not evident: existing services may not be adapted anymore and therefore blocking evolution in the data service offering. 

Examples:
* __https://inspire.bosa.gov.be/api/v1/waterway/8399104101108100101__ is a REST API URL to retrieve information about a waterway.
* __https://data.belgif.be/id/waterway/8399104101108100101__ is the identifier of a waterway.
The URI standard is not applicable for the first, for the second it is. The first, however, will refer in its payload to the waterway using the persistent identifier similar to the one presented in the second example. 

### Other exceptions
One **can** deviate from the rules in the following situations:
1. HTTPS or HTTP URIs that are already published (**legacy**) and were created with the aim to be persistent, must remain preserved. This does not mean that it is allowed for legacy-systems to produce new, nonconforming URIs. The only goal of this exception is to guarantee the persistence of the URIs already in use by third parties. 
1. An alternative way to make the distinction between {type} _id/doc_ is by introducing a fragment identifier. When a user resolves this URI, the fragment identifier will be ignored as part of the HTTP protocol. This approach can only be used in the case of sufficient reasons not to follow the recommended approach of rule 5. In this case, the {type} doc is used in the URI structure instead of id, and the URI must be followed by the fragment identifier ‘#id’. It is prohibited to produce URIs following both the redirect and the hash manner for resources of the same type.

### Beyond the scope of this document
This document has described the representation and processing rules for persistent identifiers. However the actual creation and maintenance of persistent identifiers requires decisions in the area of identifier management, versioning, category management, etc.
Guidelines on these topics are beyond the scope of this document. 


## The URI standard compliancy checklist

This section describes a framework to evaluate URIs. A URI is compliant with the URI standard if all questions can be answered with ‘yes’. In case the URIs are provided via a legacy service that guarantees the persistence via the domain and uses the http(s) 
protocol, then the existing URIs should not be compliant with the following checklist.

**Rules**
* Does the URI scheme make use of the http(s) protocol?
* Does the URI scheme follow the structure: {_domain_}/{_type_}/{_concept_}(/{_reference_})* ?

**Domain**
* Is the existing (sub)domain name independent of **organization**, **product**, **brand** or **time**?
* Is the domain name guaranteed persistent: can it be guaranteed that the domain name will last forever and will never change?

**Type**
* Is the **{type}** included as part of the URI pattern **AND** is there at least a distinction between representation, the actual object/concept and a term belonging to a vocabulary, thesaurus or ontology?
* Does the **{type}** of all URIs in the domain and subdomain follow the same strict classification including at least **id**, **doc**, **ns** and **auth**?

**Concept** 
* Is the **{concept}** as part of the URI pattern unique, meaning that there is no literal overlap with the terms appearing in the domain, type or references?

**Reference**
* Except in the type **“ns”**, no fragment identifiers are used.
* Does (/{**reference**}) as part of the URI pattern refer to one particular instance of a resource?
* Can the **{reference}** be completed in one of the following ways: {reference-basis} or {reference-basis}/{reference-version} ?
* Is the assigned **{reference}** persistent and is the whole in combination with {domain}/{type}/{concept} unique on the web?

## References

- <a name="DNS">[DNS]</a> [Domain Name System](https://tools.ietf.org/html/rfc1035)
- <a name="IANA">[IANA]</a> [Internet Assigned Numbers Authority](https://www.iana.org/)
- <a name="IETF">[IETF]</a> [Internet Engineering Task Force](https://www.ietf.org/)
- <a name="INSPIRE">[INSPIRE]</a> [EU Directive on geospatial data infrastructure](https://inspire.ec.europa.eu/)
- <a name="ISA">[ISA]</a> [EU programme on Interoperability Solution for Administrations](https://ec.europa.eu/isa2/home_en)
- <a name="ISO">[ISO]</a> [International Standard Organisation](https://www.iso.org/)
- <a name="OGC">[OGC]</a>	[Open Geospatial Consortium](https://www.opengeospatial.org/)
- <a name="URI">[URI]</a> [Uniform Resource Identifier](https://tools.ietf.org/html/rfc3986)
- <a name="URL">[URL]</a> [Uniform Resource Locator](https://tools.ietf.org/html/rfc1738)
- <a name="W3C">[W3C]</a> [World Wide Web Consortium](https://www.w3.org/)
