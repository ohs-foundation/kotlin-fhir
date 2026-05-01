# Unsupported: composite search parameters with no component path

Composite search parameters have `type = "composite"` and an `expression` that is just the resource name (e.g. `Observation`). Resolving them requires combining the values of two or more component search parameters, which is not yet implemented.

**Total:** 13 (R4: 4, R4B: 4, R5: 5)

| Version | Resource      | Param name            | Type        | Target   | Expression    | Source JSON                                            | Canonical URL                                                         |
|:--------|:--------------|:----------------------|:------------|:---------|:--------------|:-------------------------------------------------------|:----------------------------------------------------------------------|
| R4      | `Observation` | `code-value-concept`  | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-concept.json`  | `http://hl7.org/fhir/SearchParameter/Observation-code-value-concept`  |
| R4      | `Observation` | `code-value-date`     | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-date.json`     | `http://hl7.org/fhir/SearchParameter/Observation-code-value-date`     |
| R4      | `Observation` | `code-value-quantity` | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-quantity.json` | `http://hl7.org/fhir/SearchParameter/Observation-code-value-quantity` |
| R4      | `Observation` | `code-value-string`   | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-string.json`   | `http://hl7.org/fhir/SearchParameter/Observation-code-value-string`   |
| R4B     | `Observation` | `code-value-concept`  | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-concept.json`  | `http://hl7.org/fhir/SearchParameter/Observation-code-value-concept`  |
| R4B     | `Observation` | `code-value-date`     | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-date.json`     | `http://hl7.org/fhir/SearchParameter/Observation-code-value-date`     |
| R4B     | `Observation` | `code-value-quantity` | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-quantity.json` | `http://hl7.org/fhir/SearchParameter/Observation-code-value-quantity` |
| R4B     | `Observation` | `code-value-string`   | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-string.json`   | `http://hl7.org/fhir/SearchParameter/Observation-code-value-string`   |
| R5      | `Device`      | `code-value-concept`  | `composite` | _(none)_ | `Device`      | `SearchParameter-Device-code-value-concept.json`       | `http://hl7.org/fhir/SearchParameter/Device-code-value-concept`       |
| R5      | `Observation` | `code-value-concept`  | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-concept.json`  | `http://hl7.org/fhir/SearchParameter/Observation-code-value-concept`  |
| R5      | `Observation` | `code-value-date`     | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-date.json`     | `http://hl7.org/fhir/SearchParameter/Observation-code-value-date`     |
| R5      | `Observation` | `code-value-quantity` | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-quantity.json` | `http://hl7.org/fhir/SearchParameter/Observation-code-value-quantity` |
| R5      | `Observation` | `code-value-string`   | `composite` | _(none)_ | `Observation` | `SearchParameter-Observation-code-value-string.json`   | `http://hl7.org/fhir/SearchParameter/Observation-code-value-string`   |

