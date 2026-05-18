---
title: "ICEG Person: Kick-off Minutes"
date: 2026-05-11
trajectory: ICEG-Person
type: meeting-minutes
status: draft-for-review
tags:
  - ICEG
  - ICEG_Person
  - semantics
  - minutes
  - kickoff
---

# Kick-off Meeting - ICEG Person

> [!info] Working conventions
> To keep the meetings running smoothly, please raise your hand or post your question in the chat. For quick polls:
> - **+1** : agree
> - **−1** : disagree
> - **0** : no opinion

## Agenda
1. Welcome and Presentations
2. What is ICEG?
3. Context and Objectives
4. Scope
5. Method and Governance
6. Next Steps

---

## 1. Welcome and Presentations

| Name                    | Organisation        |
| ----------------------- | ------------------- |
| Bart Hanssens           | FOD BOSA (DGVD)     |
| Pauline De Wolf         | Digitaal Vlaanderen |
| Nicolas Duval           | BCED                |
| Jonas De Meulenaere     | KSZ-BCSS            |
| Dominique Le Grelle      | Paradigm            |
| Liesbet D'hondt        | FOD BOSA (DGVD)     |
| Marc Bruyland           | FOD BOSA (DGVD)     |
| Peter Van den Bosch       | SMALS               |
| Jean-Christophe Trigaux | SPW Digital / BCED  |
| Dylan Van Assche         | Digitaal Vlaanderen |
| Lieven Verreycken        | Digitaal Vlaanderen |
| Vincent Turine          | KSZ-BCSS            |
| Vincent Vandenkerckhove | IBZ                 |
| Bart Vrancken           | IBZ                 |
| Eveline Vlassenroot     | Digitaal Vlaanderen |

---

## 2. What is ICEG?

**ICEG** promotes inter-federal cooperation between the entities involved in coordinating an intra-Belgian digital strategy. A key part of this work is the standardisation of semantic models for the Belgian government, where federal and regional administrations collaborate on shared reference models. These models are published on [**belgif.be**]([Belgian Interoperability Framework · GitHub](https://github.com/belgif)) as open and reusable resources, building on previous initiatives such as [**Hydrants]([thematic/hydrants at master · belgif/thematic · GitHub](https://github.com/belgif/thematic/tree/master/hydrants)). The work is aligned with the **[European Interoperability Framework (EIF)**]([The European Interoperability Framework in detail | Interoperable Europe Portal](https://interoperable-europe.ec.europa.eu/collection/iopeu-monitoring/european-interoperability-framework-detail)) and **[SEMIC (Semantic Interoperability Community)]([SEMIC Support Centre | Interoperable Europe Portal](https://interoperable-europe.ec.europa.eu/collection/semic-support-centre))**.

---

## 3. Context and Objectives

Personal data is currently fragmented across administrations, with different structures, definitions, and identifiers in use. These inconsistencies complicate the exchange of data between entities and underline the need for a common national reference aligned with European interoperability frameworks.

**Goal:** establish one shared semantic ICEG Person model.

![[Pasted image 20260515105855.png]]

---

## 4. Scope of the standardisation track

> *Reference document: Scope and Charter - ICEG Person.*

The scope discussion surfaced several recurring themes. No final scoping decisions were taken in this session, these inputs feed the use-case analysis and the Business Workshop.
### 4.1 All information types vs. a basic data set
The opening question was how to bound the scope: should the track examine **[all information types (ITs)]([Lijst van de informatietypes | IBZ - FOD Binnenlandse Zaken](https://www.ibz.rrn.fgov.be/nl/professioneel/rijksregister/onderrichtingen/lijst-van-de-informatietypes))** that exist, or focus on basic data such as name, address, family relations and is there room for items like identity cards and work permits?

A complementary view: at minimum, all ITs of the National Register should be examined, to verify that the semantic model can express most of them. ITs not covered today should still be evaluated rather than excluded by default.
### 4.2 Historical data: two different "histories"
A clarification surfaced that needs to be carried forward:

- **History of reality** (in-scope): a person changing address, changing name, etc.
- **History of registration / data storage** (implementation-specific): creation date, modification date in a given system (out-of-scope).

Argument *for* including some registration timestamps: when someone moves, they declare the move at the municipality and obtain a temporary address; this becomes the official address only after the local police officer's visit, which can be 2 days, 2 weeks, or 2 months later and the address is then validated retroactively to the date of declaration. The inception/creation date can therefore explain why correspondence ended up at the wrong address. So while pure storage timestamps are implementation-specific, business-relevant temporal attributes (declaration date, validity date, validation date) may need to be modelled.


> [!todo] Open question
> Distinguish historical reality (in scope) from registration audit trail (out of scope), while still capturing business-relevant validity dates explicitly.
### 4.3 Domain-specific attributes that surface as cross-domain
The charter currently lists domain-specific profiles (health, social security, taxation) as out of scope. Some attributes blur that line, i.e. gender :
- The National Register holds primarily the administrative gender.
- Healthcare typically requires the biological / birth gender.

> [!todo] Open question
> Decide whether attributes that are domain-specific in source but cross-domain in use belong in the base model.
### 4.4 Person ↔ Person and Person ↔ Organisation relations
Relations between persons (family composition, parent-child, etc.) should be included. The relation between a person and an organisation (e.g. the function a person performs within a company) is more ambiguous, it leans toward authorisation mechanisms, which the charter places out of scope.

Reference point: the KBO/CBE already records function-holders, but only via the INSZ/NISS number.
### 4.5 Prioritisation: semantics first, implementation later
Strong recommendation to prioritise the conceptual/semantic layer first, and only afterwards look at how things are registered today. Reasoning: anchoring discussions to current implementations (e.g. registration dates as modelled in existing systems) risks pulling implementation constraints into the semantic discussion and complicating consensus.
### 4.6 Authentic source per concept and per relation
Open question: will the authentic source of each concept and each relation be discussed within scope? It is sometimes hard to define, but the authentic source typically has the final word on the data format, making it important to capture in the semantic model.

---

## 5. Method and Governance

The approach is **iterative and consensus-based**, following the decision rule of **U-1 (unanimity minus one)**. The work is structured around **1 Business Workshop and 4 Thematic Workshops**, with workshop reports and the resulting model made publicly available on **GitHub / belgif**.

**Roles**
- **Core team**: one representative per administration. Responsible for substantive preparation, coordination, and setting guidelines within the ICEG Person trajectory. Prepares the standardisation workshops with the working group and sets priorities.
- **Working group / community group**: engaged to bring expertise, formulate suggestions, and validate the model through the workshops.
- **ICEG Review Committee**: involved in the initiative and follows progress.

![[Pasted image 20260515175832.png]]

---

## 6. Next Steps

- **Core-team prep meeting** to prepare the Business Workshop: **21/05/2026, 11:00–12:00**
- **Business Workshop**: define use cases: how does your organisation use person-related data, what person-related data do you take in / put out, etc.

### Planning

| Period | Activity |
|---|---|
| May 2026 | Business Workshop |
| June 2026 | Thematic Workshop 1 |
| September - November 2026 | Thematic Workshops 2, 3, 4 |
| December 2026 | First iteration (v1) of the Person model |

### To-Do's

| #   | Action                                                                                     |
| --- | ------------------------------------------------------------------------------------------ |
| A1  | Gather existing documentation of the current (AS-IS) person model used to serve as input   |
| A2  | Prepare potential use cases                                                                |
| A3  | Define a core-team member per administration/organisation                                  |
| A4  | Complete the list of experts to invite to the Business Workshop and the Thematic Workshops |

---

## 7. Other remarks

- **Authorisation-driven prioritisation**: there is an initiative at the National Register level to identify the data most used to facilitate authorisations. This could become a priority criterion for which data is tackled first.
- **Belgian / Foreign / EU registrations**: we take registrations of persons registered in Belgium (RNN, BCE). Open question: do we also include registrations from other European countries (registration numbers from other countries), or limit ourselves to registrations within Belgium?
- **Link register**: KSZ is working on a link register connecting the Belgian identifier (national-register number and BIS register) with all known foreign identifiers (foreign ID numbers, passport numbers, identity-card numbers) so that when a person returns, they can be re-registered via that number. A similar link register already exists in Luxembourg. Flagged as a nice-to-have to consider in scope.



