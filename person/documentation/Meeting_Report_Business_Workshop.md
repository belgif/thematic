# ICEG Person

# Meeting Report Business Workshop + Scope + Next Steps

## Meeting Details

| **Date** | June 24, 2026 |
| --- | --- |
| **Time** | 11:00 – 12:00 |
| **Duration** | 1h |
| **Format** | Virtual Meeting (Microsoft Teams) |

## Attendees

| **Name** | **Organisation** |
| --- | --- |
| Van den Broeck Valy | Digitaal Vlaanderen |
| Van Assche Dylan | Digitaal Vlaanderen |
| Verreycken Lieven | Digitaal Vlaanderen / MAGDA |
| De Cock Jitse | Digitaal Vlaanderen |
| Vlassenroot Eveline | Digitaal Vlaanderen / ICEG Review Committee |
| Vrancken Bart | IBZ - National Registry |
| Liesbet D'hondt | BOSA |
| Bart Hanssens | BOSA |
| Vincent Turine | KSZ-BCSS |
| Jonas De Meulenaere | KSZ-BCSS |
| Peter Van den Bosch | Smals |
| Miguel Discart | FOD Economie - SPF Economie (CBE) |
| DELALIEU Alexandre | Fédération Wallonie-Bruxelles |
| LESJOURS Corentin | Paradigm (Fidus) |

Total Participants: 14

## Agenda

1. Welcome and Introduction

2. Presentations

- National Registry (IBZ)
- Crossroads Bank for Enterprises (CBE)
- Crossroads Bank for Social Security (BCSS)
- BOSA
- MAGDA (Flanders)
- FIDUS (Brussels)
- BCED (Wallonia/Federation)
- Smals
3. Closing and Next Steps

## Background Information: ICEG Trajectory

The ICEG (Interoperability Committee for E-Government) Person trajectory aims to establish a consensus-based semantic data model for person data in Belgium. This standardisation effort brings together:

- Authoritative Sources: National Registry (RN), BCSS Registers, Crossroads Bank for Enterprises (CBE)
- Integrators: BOSA (Federal), MAGDA (Flanders), FIDUS (Brussels), BCED (Wallonia-Brussels Federation)
- End Users: Various government administrations and public services
The objective is to create an interoperable model that facilitates data exchange while respecting the Once Only principle and ensuring data quality across all levels of Belgian government.

## Expected Outputs of this Trajectory

The ICEG Person trajectory will deliver a comprehensive set of standardised semantic artifacts designed to enable consistent, interoperable exchange of person data across Belgian public administrations. The expected outputs are structured as follows:

### 1. ICEG Person Application Profile

A semantically aligned **Application Profile for Person** will be developed, covering the use cases presented during the business workshop. This application profile will:

- Define a common semantic structure for person data based on the information types ([TI](https://www.ibz.rrn.fgov.be/fr/professionnel/registre-national/instructions/liste-des-types-dinformation)/[IT](https://www.ibz.rrn.fgov.be/nl/professioneel/rijksregister/onderrichtingen/lijst-van-de-informatietypes)) from the National Register
- Align with European reference models (SEMIC Core Person Vocabulary) while addressing Belgian-specific requirements
- Provide shared terms, definitions, and data structures enabling semantically consistent exchange, linking, and reuse of person data
- Serve as the national reference model for all government levels (federal, regional, local)
### 2. Technical Deliverables

The application profile will be accompanied by the following technical artifacts:

| **Artifact** | **Description** |
| --- | --- |
| RDF Vocabulary | Formal semantic vocabulary defining classes and properties for person data |
| HTML Documentation | Human-readable documentation of terms, definitions, and usage guidelines |
| UML Diagram | Visual representation of the information model and relationships |
| SHACL Validation Rules | Validation constraints for data quality assurance |
| JSON-LD Context File | Context file enabling JSON-based Linked Data serialization |
| OpenAPI/Swagger 3.0 Specification | API specification that integrators and consumers can use as a reference to build or adapt their implementation models |
| Code Lists | Standardized reference data (nationalities, civil status codes, register types, etc.) |

### 3. Implementation Support

The **OpenAPI/Swagger 3.0 specification** will serve as a key reference document allowing organisations to:

- Derive implementation models tailored to their specific use cases and technical environments
- Ensure semantic alignment when building or adapting REST-based services
- Validate their implementations against the common reference model
- Facilitate migration from legacy SOAP services to modern REST/Linked Data approaches
- All deliverables will be published on belgif.be and integrated into the ICEG system of vocabularies, ensuring discoverability and reusability across the Belgian e-government ecosystem.
### 4. Scope Alignment with Use Cases

Based on the use cases presented during this business workshop, the scope of the application profile will cover:

#### In-Scope:

| **Domain** | **Coverage** |
| --- | --- |
| Natural Person | Identity, identifiers (SSIN), name, date/place of birth, gender, nationality, domicile, residence, contact information, civil status, legal capacity |
| Registered Person | Registration in official registers (i.e: National Register, BIS register) |
| Links to Other Domains | Address (aligned with BeSt-Address), possible relation to organization (via CBE), jurisdiction, household composition, filiation |

#### Out-of-Scope for this trajectory:

- Domain-specific person profiles (health, taxation, profession, etc)
- Authentication and authorisation mechanisms
- Internal database properties, schemas, or storage implementations
## Presentation Summaries Business Workshop

### 1. National Registry (IBZ) - Bart Vrancken

The National Registry maintains legal information, but not all carry equal reliability, i.e. profession data is no longer actively maintained since 2014. The newest contact data allows direct citizen updates but cannot be guaranteed for accuracy. A central concern is the national number itself: embedded birth date and gender create cascading administrative impacts when these values change, while privacy regulations block broader usage discussions.

The National Registry presented the comprehensive list of the main legal information types (TI) registered for each person in Belgium. The key categories include:

Legal Information Types:
- Name and first names (TI 010)
- Place and date of birth (TI 100, 101)
- Gender (TI 004)
- Nationality (TI 031)
- Main residence (TI 020)
- Place and date of death (TI 150)
- Profession (TI 070)
- Civil status (TI 120)
- Family composition (TI 140, 141)
- Registry mention (TI 210)
- Administrative status (TI 206)
- Identity certificate existence (TI 180)
- Legal cohabitation (TI 123)
- Residence situation for foreigners (TI 195)
- Ascending lineage - father/mother (TI 110) - since 2015
- Descending lineage - first degree children (TI 114) - since 2015
- Contact data (TI 247) - new

#### Key Issues Raised – The National Number

| **Problem** | **Description** |
| --- | --- |
| Binary gender information | Current encoding only supports M/F, not accommodating modern requirements |
| Century ambiguity | Birth year encoding using only 2 digits causes confusion (1900 vs 2000) |
| Embedded business data | Gender and birth date encoded in the number leads to replacements when these change |
| Administrative impact | Changes trigger number replacements with cascading effects on all connected systems |

For more information we refer to the consolidated slidedeck on slide X-Y

### 2. Crossroads Bank for Social Security (BCSS) - Vincent Turine

BCSS operates as both integrator for social security and manager of registers for persons outside the National Registry (BIS, Radiated, Annulated). Services enable partners to determine benefit eligibility, detect benefit cessation triggers (death, relocation, household changes), and establish contact addresses. Beyond consultations, BCSS supports population determination for specific programs like breast cancer screening and mandatory schooling. The upcoming eGov 3.0 initiative will introduce relationship determination services between persons.

Role of BCSS:

- Integrator for Social Security network
- Provides uniform services for consulting all registers (RN and BCSS)
- Manager of BCSS-specific registers
BCSS Registers:

| **Register** | **Description** |
| --- | --- |
| BIS Register | Persons without a National Register number |
| Radiated Register | Persons with NISS but no municipality managing their file |
| Annulated Register | Persons with annulled files without reference to another file |

Data Available in BCSS Registers:

- Name/First name
- Birth information
- Gender
- Death information
- Civil status
- Nationality(ies)
- Addresses (foreign or contact addresses in Belgium)
Use Cases Presented:

- Consultation services for partner institutions
- Mutation notifications to subscribed institutions
- Population determination (breast cancer screening, mandatory schooling, integration pathways)
- EIDAS integration for European identification
- eGov 3.0: Relationship determination between persons
For more information we refer to the consolidated slidedeck on slide:

### 3. Crossroads Bank for Enterprises (CBE) - Miguel Discart

CBE functions as a data consumer, accessing person data via BOSA services without distinguishing between National Registry and BIS register sources. Public applications display limited data => enterprise names and function holders (show only names). Administrative users with GDPR authorization can access addresses and national numbers. Search tools enable staff to identify persons when creating enterprise functions with partial information.

- CBE does not directly create or manage data in the National Register
- Exception: Creation of "Bis Person" via BOSA DTO Person web service
- CBE acts mainly as a data consumer
- Administrative access to entity data: name, surname, address (from National Register)
For more information we refer to the consolidated slidedeck on slide:

### 4. BOSA - Liesbet D'hondt

BOSA combines both authentic sources (IBZ & BCSS) into unified services with a consistent data model. Beyond basic person retrieval, BOSA increasingly develops "smart services" returning contextual answers rather than raw data. Example use case: the National Lottery receives only true/false for residency and age, lacking authorisation for complete details. These context-specific services embed business logic in the integrator layer, reducing data exposure while meeting specific regulatory requirements.

BOSA provides a collection of web services/APIs consulting different types of Person Data:

- getPerson [MINIMAL REQUIRED FOR THE TRAJECTORY]
- getExtendedPerson
- Household
- VerifyPersonName
- Filiation
- PersonNumberHistory
- VerifyEIDCard
- eIDPhoto
- eIDSignature
Context-Specific Services:

- RemoteSigning IBZ: Verify if a person can sign in their own name
- VotingEligibility: Determine petition rights and administrative municipality
- InternetGamingValidation: National Lottery age verification
For more information we refer to the consolidated slidedeck on slide:

### 5. MAGDA / Digitaal Vlaanderen - Lieven Verreycken

Most Used Information Types: INSZ (000), Name (010), Gender (004), Birth (100 + 101), Death (150), Addresses, Person relations, Civil status (120), Legal cohabitation (123)

Nearly all information types from the National Register are used by MAGDA consumers, with each organization-finality combination counted as a separate consumer. MAGDA provides particular value for local authorities needing combined access to both National Registry and BCSS registers in a single consultation. A key distinction: mutations from BCSS include full person data, while National Registry mutations arrive as notifications only—requiring subsequent consultation to retrieve changed data. Since 2006, services operate via SOAP and file-based protocols; Digitaal Vlaanderen is currently developing a Linked Data REST version under the OSLO initiative.

Services Available:

- Consultations: Persoon, HistoriekPersoon, Gezin, HistoriekGezin
- Mutations: Same scope as consultations
- Linked Data: OSLO REST Person service in development
For more information we refer to the consolidated slidedeck on slide:

### 6. FIDUS / Paradigm Brussels - Corentin Lesjours

FIDUS implements the Once Only principle for Brussels. Administrations cannot request data already accessible via authentic sources without legally passing through FIDUS. Primary needs cover SSIN, name, address, birth/death dates, nationality, and gender; complementary data includes household composition and official documents. Main obstacles are regulatory as access authorization involves lengthy procedures. Implementation testing also proves challenging due to difficulties obtaining representative test cases under data protection constraints.

- Regional integrator for Brussels Capital Region (equivalent to MAGDA in Flanders)
- Mandatory use since ordinance of 8 May 2014
- Implements Once Only principle since
ICEG Business Needs:

- Primary Identification: SSIN, Name/First name, Address, Date of birth, Date of death, Nationality, Gender
- Complementary Data: Household composition, Official documents (acts/certificates)
### 7. BCED (Wallonia-Brussels Federation) - NOT PRESENTED

BCED re-exposes BCSS web services for Wallonia and the Federation, supporting ~500 active data streams. High-volume consumers include ETNIC's "Mon Espace" portal, Walloon personal space, FOREM employment services, AVIQ disability files, and SPW Finance tax assessments. Priority data follows a hierarchy: administrator-level types (name, birth, death, civil status, address) first, then identification data (birthplace, nationality, gender, register).

- Integrator for Walloon Region and Wallonia-Brussels Federation (FWB)
- Re-exposes BCSS web services (RN/BIS register)
- Approx. 500 data streams open for PersonV4
**Key Legal Contexts:**

- ETNIC: "MON ESPACE" portal procedures (FWB)
- SPW SG: Personal Space for Wallonia Online procedures
- FOREM: Job seeker support & career services
- AVIQ: Integration files for persons with disabilities
- SPW Finance: Tax assessment file management
**Priority Data (Based on BCED Filter):**

- Administrator ITs: 010, 101, 150, 120, 020 & 001
- Identification ITs: 100, 031, 002, 210 & 123
For more information we refer to the consolidated slidedeck on slide:

### 8. Smals - Peter Van den Bosch

Smals identifies semantic inconsistencies complicating interoperability. The nationality field has overloaded meaning, i.e. sometimes NIS country codes, sometimes RRN-specific refugee origin codes. These should be separate concepts. The register notion similarly contains data source, recognition status (citizen/refugee/diplomat), and historical status (radiated). These ambiguities, combined with SSIN's embedded business data, create challenges for consistent datasets across social security.

Common Issues Identified:

- Overloaded "nationality" concept (NIS-code vs RRN-specific code for refugees)
- SSIN includes business data leading to unnecessary replacements
- Ambiguous "(sub)registers" notion mixing different concepts
For more information we refer to the consolidated slidedeck on slide:

## Next Steps:

- The core team will review the scope based on the use cases presented.
- The information types from the National Register will serve as the starting point (see below).
- The application profile and API specification will cover the use cases presented by the stakeholders.
## Planning: Thematic Workshops

| **Workshop** | **Tentative Date** | **Theme** |
| --- | --- | --- |
| Thematic Workshop 1 | August Option 1: Monday 24/8 (10-12) Option 2: Tuesday 25/8 (10-12) Option 3: Thursday 27/8 (10-12) | Core Identity |
| Thematic Workshop 2 | September Option 1: Monday 21/9 (10-12) Option 2: Tuesday 22/9 (10-12) Option 3: Thursday 24/9 (10-12) | Address & Residence |
| Thematic Workshop 3 | October Option 1: Monday 19/10 (10-12) Option 2: Tuesday 20/10 (10-12) Option 3: Thursday 22/10 (10-12) | Family & Relations |
| Thematic Workshop 4 | November Option 1: Monday 16/11 (10-12) Option 2: Tuesday 17/11 (10-12) Option 3: Thursday 19/11 (10-12) | Status & Registers |

#### Theme 1: Core Person Identification

- Identification Number (TI 000)
- Referencefile (TI 002)
- Name and First Names (TI 010, 011, 012, 013)
- Birth Information (TI 100, 101)
- Gender (TI 004)
#### Theme 2: Address and Residence

- Main Residence (TI 001, 003, 020)
- Temporary Absence (TI 026)
- Foreign Addresses (TI 022, 023)
- Reference Address (TI 024)
- Legal Domicile (TI 027)
#### Theme 3: Family Relations and Civil Status

- Civil Status (TI 120)
- Legal Cohabitation (TI 123)
- Filiation – Ascending (TI 110)
- Filiation – Descending (TI 114)
- Household Composition (TI 140, 141)
#### Theme 4: Status, Documents, and Special Cases

- Nationality (TI 031, 032)
- Death Information (TI 150, 151, 152)
- Identity Documents (TI 180, 195, 199)
- Registry Mention (TI 210)

