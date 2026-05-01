# Unsupported: multi-resource union without a resource prefix

These expressions are pipe-unions (`A | B | ...`) where no branch begins with the search parameter's own resource name. The codegen's expression slicer looks for a `Resource.`-prefixed branch and falls through when none is found.

**Total:** 3 (R4: 1, R4B: 1, R5: 1)

| Version | Resource           | Param name | Type     | Target   | Expression                                                                                                                                                                                    | Source JSON                                   | Canonical URL                                                |
|:--------|:-------------------|:-----------|:---------|:---------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:----------------------------------------------|:-------------------------------------------------------------|
| R4      | `InsurancePlan`    | `name`     | `string` | _(none)_ | `name \| alias`                                                                                                                                                                               | `SearchParameter-InsurancePlan-name.json`     | `http://hl7.org/fhir/SearchParameter/InsurancePlan-name`     |
| R4B     | `InsurancePlan`    | `name`     | `string` | _(none)_ | `name \| alias`                                                                                                                                                                               | `SearchParameter-InsurancePlan-name.json`     | `http://hl7.org/fhir/SearchParameter/InsurancePlan-name`     |
| R5      | `EvidenceVariable` | `topic`    | `token`  | _(none)_ | `ActivityDefinition.topic \| CodeSystem.topic \| ConceptMap.topic \| EventDefinition.topic \| Library.topic \| Measure.topic \| NamingSystem.topic \| PlanDefinition.topic \| ValueSet.topic` | `SearchParameter-MetadataResource-topic.json` | `http://hl7.org/fhir/SearchParameter/MetadataResource-topic` |

