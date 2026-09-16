# Enum Generation

The library generates Kotlin enum classes from FHIR `ValueSet` definitions referenced by the data
model. This document details the naming transformation rules used to convert FHIR codes into valid
Kotlin identifiers, as well as the value sets excluded from enum generation.

## Enum naming rules

The enum constants are derived from `ValueSet` definitions in the expansion packages for
[R4](https://github.com/ohs-foundation/kotlin-fhir/tree/main/third_party/hl7.fhir.r4.expansions/package),
[R4B](https://github.com/ohs-foundation/kotlin-fhir/tree/main/third_party/hl7.fhir.r4b.expansions/package),
and
[R5](https://github.com/ohs-foundation/kotlin-fhir/tree/main/third_party/hl7.fhir.r5.expansions/package).
Each `ValueSet` includes codes from one or more `CodeSystem` resources it references.

| FHIR concept                                             | Kotlin concept                                |
|:---------------------------------------------------------|:----------------------------------------------|
| ValueSet JSON file (e.g. `ValueSet-resource-types.json`) | Kotlin `.kt` file (e.g. `ResourceType.kt`)    |
| ValueSet (e.g. `ResourceType`)                           | Kotlin class (e.g. `enum class ResourceType`) |

To comply with Kotlin's enum naming convention, which requires names to start with a letter and
avoid special characters, each code is transformed using a set of formatting rules. This includes
handling numeric codes, special characters, and FHIR URLs. After all transformations, the final name
is converted to PascalCase to match Kotlin style guidelines.

| Rule # | Description                                                                                   | Example Input                                                                                                                     | Example Output         |
|:-------|:----------------------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------------------------------------------------|:-----------------------|
| 1      | For codes that are full URLs, extract and return the last segment after the dot               | `http://hl7.org/fhirpath/System.DateTime` from [CodeSystem-fhirpath-types](http://hl7.org/fhir/R5/codesystem-fhirpath-types.html) | `DateTime`             |
| 2      | Specific special characters are replaced with readable keywords                               | `>=` from [CodeSystem-quantity-comparator](http://hl7.org/fhir/R5/codesystem-quantity-comparator.html)                            | `GreaterThanOrEqualTo` |
|        |                                                                                               | `>`                                                                                                                               | `GreaterThan`          |
|        |                                                                                               | `<`                                                                                                                               | `LessThan`             |
|        |                                                                                               | `<=`                                                                                                                              | `LessThanOrEqualTo`    |
|        |                                                                                               | `!=` or `<>`                                                                                                                      | `NotEqualTo`           |
|        |                                                                                               | `=`                                                                                                                               | `EqualTo`              |
|        |                                                                                               | `*`                                                                                                                               | `Multiply`             |
|        |                                                                                               | `+`                                                                                                                               | `Plus`                 |
|        |                                                                                               | `-`                                                                                                                               | `Minus`                |
|        |                                                                                               | `/`                                                                                                                               | `Divide`               |
|        |                                                                                               | `%`                                                                                                                               | `Percent`              |
| 3.1    | Replace all non-alphanumeric characters including dashes (`-`) and dots (`.`) with underscore | `4.0.1` from [CodeSystem-FHIR-version](http://hl7.org/fhir/R5/codesystem-FHIR-version.html)                                       | `4_0_1`                |
| 3.2    | Prefix codes starting with a digit with an underscore                                         | `4.0.1` from [CodeSystem-FHIR-version](http://hl7.org/fhir/R5/codesystem-FHIR-version.html)                                       | `_4_0_1`               |
| 3.3    | Apply PascalCase to each segment between underscores while preserving the underscores         | `entered-in-error` from [CodeSystem-document-reference-status](http://hl7.org/fhir/R5/codesystem-document-reference-status.html)  | `Entered_In_Error`     |

## Excluded ValueSets

The following FHIR value sets are excluded from Kotlin enum generation:

| ValueSet URL                                                                               | Reason for Exclusion                                                       | Affected Version(s) |
|:-------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------|:--------------------|
| [`http://hl7.org/fhir/ValueSet/mimetypes`](http://hl7.org/fhir/ValueSet/mimetypes)         | This value set is infinite                                                 | `R4`, `R4B`, `R5`   |
| [`http://hl7.org/fhir/ValueSet/all-languages`](http://hl7.org/fhir/ValueSet/all-languages) | This value set is infinite                                                 | `R4`, `R4B`, `R5`   |
| [`http://hl7.org/fhir/ValueSet/use-context`](http://hl7.org/fhir/ValueSet/use-context)     | This value set has >3800 codes when expanded, and hence cannot be compiled | `R4`, `R4B`, `R5`   |
