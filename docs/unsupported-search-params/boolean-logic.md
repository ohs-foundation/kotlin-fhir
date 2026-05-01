# Unsupported: boolean logic (`and`, `or`)

These search parameters use FHIRPath boolean operators. Currently, only the `Patient` / `Person` / `Practitioner` `deceased` token parameters use this pattern (`Resource.deceased.exists() and Resource.deceased != false`).

**Total:** 5 (R4: 1, R4B: 1, R5: 3)

| Version | Resource       | Param name | Type    | Target   | Expression                                                          | Source JSON                                  | Canonical URL                                               |
|:--------|:---------------|:-----------|:--------|:---------|:--------------------------------------------------------------------|:---------------------------------------------|:------------------------------------------------------------|
| R4      | `Patient`      | `deceased` | `token` | _(none)_ | `Patient.deceased.exists() and Patient.deceased != false`           | `SearchParameter-Patient-deceased.json`      | `http://hl7.org/fhir/SearchParameter/Patient-deceased`      |
| R4B     | `Patient`      | `deceased` | `token` | _(none)_ | `Patient.deceased.exists() and Patient.deceased != false`           | `SearchParameter-Patient-deceased.json`      | `http://hl7.org/fhir/SearchParameter/Patient-deceased`      |
| R5      | `Patient`      | `deceased` | `token` | _(none)_ | `Patient.deceased.exists() and Patient.deceased != false`           | `SearchParameter-Patient-deceased.json`      | `http://hl7.org/fhir/SearchParameter/Patient-deceased`      |
| R5      | `Person`       | `deceased` | `token` | _(none)_ | `Person.deceased.exists() and Person.deceased != false`             | `SearchParameter-Person-deceased.json`       | `http://hl7.org/fhir/SearchParameter/Person-deceased`       |
| R5      | `Practitioner` | `deceased` | `token` | _(none)_ | `Practitioner.deceased.exists() and Practitioner.deceased != false` | `SearchParameter-Practitioner-deceased.json` | `http://hl7.org/fhir/SearchParameter/Practitioner-deceased` |

