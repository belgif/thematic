# ICEG Hydrants
## Specification (Under Public Review)
The current version of the Hydrants model is available as:

* [HTML as a specification - Hydrants](https://belgif.github.io/thematic/models/hydrants/index_en.html) including a visual diagram of all classes and properties of the model.

If you have any comments on the specification, please open an issue from [here](https://github.com/belgif/thematic/issues).

## Detailed changes during public review

| Nr | Concern | Request | Status | Resolution |
| -- | ------------ | ------------ | --------- | --------------- |
| 1 | ContactPoint |Modify the reference to the required information in the definition to enhance clarity | Accepted | Modified definition: "Information (i.e., e-mail address and telephone number) of a person or department through which the user can get in touch with." |
| 2 | PeriodOfTime:endtime - xsd:dateTime | PeriodOfTime:endtime - time:Instant | The URIs from W3C are used but they have the wrong range for endTime. | [#52](https://github.com/SEMICeu/CCCEV/issues/52) |