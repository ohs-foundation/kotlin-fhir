# Kotlin FHIR

[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model?color=yellow&label=fhir-model)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model)
[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model-jvm?color=yellow&label=jvm)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model-jvm)
[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model-wasm-js?color=yellow&label=wasm-js)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model-wasm-js)
[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model-wasm-wasi?color=yellow&label=wasm-wasi)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model-wasm-wasi)
[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model-js?color=yellow&label=js)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model-js)
[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model-android?color=yellow&label=android)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model-android)
[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model-iosx64?color=yellow&label=ios-x64)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model-iosx64)
[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model-iosarm64?color=yellow&label=ios-arm64)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model-iosarm64)
[![Release](https://img.shields.io/maven-central/v/dev.ohs.fhir/fhir-model-iossimulatorarm64?color=yellow&label=ios-simulator)](https://central.sonatype.com/artifact/dev.ohs.fhir/fhir-model-iossimulatorarm64)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Kotlin FHIR is a lean and fast implementation of the
[HL7® FHIR®](https://www.hl7.org/fhir/overview.html) data model on
[Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html).

## Key features

* Lightweight & fast with a minimal footprint and zero bloat[^1]
* Clean, modern & elegant Kotlin code with minimalistic class definitions
* Code generation[^2] from FHIR specifications for completeness and maintainability
* JSON only[^3], no [XML](https://build.fhir.org/xml.html)
  or [Turtle](https://build.fhir.org/rdf.html) dependencies
* Multiplatform support for Android, iOS and web development, with JVM, native
  code and JavaScript targets
* Support for multiple FHIR versions

[^1]: No dependencies on logging, XML, or networking libraries or any platform-specific
dependencies. Only essential Kotlin Multiplatform dependencies are included, e.g.,
[`kotlinx.serialization`](https://github.com/Kotlin/kotlinx.serialization),
[`kotlix.datetime`](https://github.com/Kotlin/kotlinx-datetime), and
[Kotlin Multiplatform BigNum](https://github.com/ionspin/kotlin-multiplatform-bignum).

[^2]: Using [KotlinPoet](https://square.github.io/kotlinpoet/).

[^3]: It is also possible to serialize to other formats
[`kotlinx.serialization`](https://github.com/Kotlin/kotlinx.serialization) supports, such as
[protocol buffers](https://protobuf.dev/). However, there is no XML or Turtle support as of
Jan 2025.

## Supported platforms

The library supports the following
[target platforms](https://kotlinlang.org/docs/multiplatform-dsl-reference.html#targets):

| Target platform                    | Target          | Artifact suffix | Support |
|:-----------------------------------|:----------------|:----------------|:--------|
| Kotlin/JVM                         | `jvm`           | `-jvm`          | ✅       |
| Kotlin/Wasm                        | `wasmJs`        | `-wasm-js`      | ✅       |
| Kotlin/Wasm                        | `wasmWasi`      | `-wasm-wasi`    | ✅       |
| Kotlin/JS                          | `js`            | `-js`           | ✅       |
| Android applications and libraries | `androidTarget` | `-android`      | ✅       |

as well as a subset of
[tier 1 Kotlin/Native targets](https://kotlinlang.org/docs/native-target-support.html#tier-1), detailed below:

| Gradle target name | Artifact suffix      | Support |
|:-------------------|:---------------------|:--------|
| macosX64           | `-macosx64`          | ⛔       |
| macosArm64         | `-macosarm64`        | ⛔       |
| iosSimulatorArm64  | `-iossimulatorarm64` | ✅       |
| iosX64             | `-iosx64`            | ✅       |
| iosArm64           | `-iosarm64`          | ✅       |

The library does not support `macos` targets in the tier 1 list, or any
[tier2](https://kotlinlang.org/docs/native-target-support.html#tier-2) and
[tier3](https://kotlinlang.org/docs/native-target-support.html#tier-3) Kotlin/Native targets. This
reflects their limited usage currently rather than technical difficulty. Please contact the team if
you require support for these platforms.

## Data model

### Mapping FHIR primitive data types to Kotlin

In FHIR, primitive data types (e.g. in [R4](https://hl7.org/fhir/R4/datatypes.html)) are defined
using StructureDefinitions[^4]. For instance, the `date` type is defined in
`StructureDefinition-date.json`. While primitive, these types may include an `id` and `extension`s,
preventing direct mapping to Kotlin's primitive types. To resolve this issue, the library generates
a distinct Kotlin class for each FHIR primitive data type, for example, the `Date` class in`Date.kt`
file for the `date` type.

[^4]: A "JSON Definition" link to the StructureDefinition is now included for each FHIR primitive
data type in the [Data Types](https://build.fhir.org/datatypes.html) page in FHIR CI-BUILD.

However, the actual values within these FHIR primitive data types defined using FHIRPath types (e.g.
the `integer.value` element in `StructureDefinition-integer.json` has the FHIRPath type
`System.Integer`) still need to be mapped to Kotlin types in the generated code. The mapping is as
follows:

| FHIRPath type <img src="images/fhir.png" alt="kotlin" style="height: 1em"/> | Kotlin type <img src="images/kotlin.png" alt="kotlin" style="height: 1em"/> |
|-----------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| System.Boolean                                                              | kotlin.Boolean                                                              |
| System.String                                                               | kotlin.String                                                               |
| System.Integer                                                              | kotlin.Int                                                                  |
| System.Long                                                                 | kotlin.Long                                                                 |
| System.Decimal                                                              | com.ionspin.kotlin.bignum.decimal.BigDecimal                                |
| System.Date                                                                 | FhirDate                                                                    |
| System.Time                                                                 | kotlinx.datetime.LocalTime                                                  |
| System.DateTime                                                             | FhirDateTime                                                                |

> **Note:** [Kotlin Multiplatform BigNum](https://github.com/ionspin/kotlin-multiplatform-bignum)
> library's `BigDecimal` is used to preserve and respect the precision of decimal values as required
> by the specification. See the notes section in [Datatypes](https://hl7.org/fhir/datatypes.html).
>
> **Note:**  The `System.Date` and `System.DateTime` types are mapped to sealed interfaces
> `FhirDate` and `FhirDateTime` specifically generated to handle partial dates in FHIR. They are
> implemented using `LocalDate`, `LocalDateTime` and `UtcOffset` classes in the `kotlinx-datetime`
> library.

Since all FHIR data types are defined using FHIRPath types in their StructureDefinitions, mapping
FHIRPath types to Kotlin effectively covers all FHIR data types. For brevity, the full FHIR data
type mapping to Kotlin is omitted here. However, notable exceptions exist where the FHIR data type
uses a FHIRPath type that is either inconsistent with the base data type, or is unsuitable for
represent the data in Kotlin. These exceptions are listed below:

| FHIR data type <img src="images/fhir.png" alt="kotlin" style="height: 1em"/> | FHIRPath type <img src="images/fhir.png" alt="kotlin" style="height: 1em"/> | Kotlin type <img src="images/kotlin.png" alt="kotlin" style="height: 1em"/> |
|------------------------------------------------------------------------------|-----------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| positiveInt                                                                  | System.String                                                               | Kotlin.Int                                                                  |
| unsignedInt                                                                  | System.String                                                               | Kotlin.Int                                                                  |

### Mapping FHIR data structure to Kotlin

Similarly, for more complex data structures in FHIR such as complex data types and FHIR resources,
the library maps each StructureDefinition JSON file to a dedicated Kotlin `.kt` file, each
containing a Kotlin data class representing the StructureDefinition. BackboneElements in FHIR are
represented as nested data classes since they are never reused outside the StructureDefinition. For
each occurrence of a choice type (e.g. in [R4](https://hl7.org/fhir/R4/formats.html#choice)), a
single sealed interface is generated with a subclass for each type.

| FHIR concept <img src="images/fhir.png" alt="kotlin" style="height: 1em"/> |                  Kotlin concept <img src="images/kotlin.png" alt="kotlin" style="height: 1em"/>                   |
|----------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| StructureDefinition JSON file (e.g. `StructureDefinition-Patient.json`)    | Kotlin .kt file (e.g. `Patient.kt`)                                                                               |
| StructureDefinition (e.g. `Patient`)                                       | Kotlin data class (e.g. `data class Patient`)                                                                     |
| BackboneElement (e.g. `Patient.contact`)                                   | Nested Kotlin data class (e.g. `data class Contact` nested under `Patient`)                                       |
| Choice of data types (e.g. `Patient.deceased[x]`)                          | Sealed interface (e.g. `sealed interface Deceased` nested under `Patient` with subtypes `Boolean` and `DateTime`) |

The generated FHIR resource classes are Kotlin
[data classes](https://kotlinlang.org/docs/data-classes.html). They are compact and readable, with
automatically generated methods: `equals()`/`hashCode()`, `toString()`, `componentN()` functions,
and `copy()`.

The use of sealed interfaces for choice of data types, combined with
Kotlin's [smart casts](https://kotlinlang.org/docs/typecasts.html#smart-casts), eliminates
boilerplate type checks and makes code cleaner, more type-safe, and easier to write. This is
particularly true when used in `when` statements:

```kotlin
when (val multipleBirth = patient.multipleBirth) {
    is Patient.MultipleBirth.Boolean -> {
        // Smart cast to Boolean
        println("Whether patient is part of a multiple birth: ${multipleBirth.value.value}")
    }

    is Patient.MultipleBirth.Integer -> {
        // Smart cast to Integer
        println("Birth order: ${multipleBirth.value.value}")
    }

    null -> {
        // Do nothing
    }
}
```

The generated classes reflect the inheritance hierarchy defined by FHIR. For example, `Patient`
inherits from `DomainResource`, which inherits from `Resource`.

### Mapping FHIR ValueSets to Kotlin Enums

Kotlin enums classes are generated for value sets referenced by elements via [binding](https://hl7.org/fhir/R5/terminologies.html#binding).
The constants in the generated enum classes are derived from the `code` property of the expanded `CodeSystem` concepts in the [expansion packages](https://github.com/ohs-foundation/kotlin-fhir/tree/main/third_party/). The
value sets that are not bound to elements are excluded from code generation.

#### Shared vs. Local Enums

- If the `StructureDefinition` defines an element with a [**common binding**](https://build.fhir.org/ig/HL7/fhir-extensions/StructureDefinition-elementdefinition-isCommonBinding.html), a **shared enum** is generated and placed in the `dev.ohs.fhir.model.<r4|r4b|r5>.terminologies` package.  
  **Example:** `AdministrativeGender`
- If the element uses a **non-common binding**, a **local enum** is created inside the associated parent class.  
  **Example:** `NameUse` inside the `HumanName` class

#### Enum Naming and Content

The enum constants are derived from `ValueSet` definitions in the expansion packages for [R4](https://github.com/ohs-foundation/kotlin-fhir/tree/main/third_party/hl7.fhir.r4.expansions/package), [R4B](https://github.com/ohs-foundation/kotlin-fhir/tree/main/third_party/hl7.fhir.r4b.expansions/package), and [R5](https://github.com/ohs-foundation/kotlin-fhir/tree/main/third_party/hl7.fhir.r5.expansions/package).
Each `ValueSet` includes codes from one or more `CodeSystem` resources it references.

| FHIR concept <img src="images/fhir.png" alt="kotlin" style="height: 1em"/> | Kotlin concept <img src="images/kotlin.png" alt="kotlin" style="height: 1em"/> |
|----------------------------------------------------------------------------|--------------------------------------------------------------------------------|
| ValueSet JSON file (e.g. `ValueSet-resource-types.json`)                   | Kotlin .kt file (e.g. `ResourceType`)                                          |
| ValueSet (e.g. `ResourceType`)                                             | Kotlin class (e.g. `enum class ResourceType`)                                  |

To comply with Kotlin’s enum naming convention—which requires names to start with a letter and avoid special characters—each code is transformed using a set of formatting rules.
This includes handling numeric codes,special characters, and FHIR URLs. After all transformations, the final name is converted to PascalCase to match Kotlin style guidelines.

| Rule # |                                          Description                                          |                                                           Example Input                                                           |     Example Output     |
|--------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|------------------------|
| 1      | For codes that are full URLs, extract and return the last segment after the dot               | `http://hl7.org/fhirpath/System.DateTime` from [CodeSystem-fhirpath-types](http://hl7.org/fhir/R5/codesystem-fhirpath-types.html) | `DateTime`             |
| 2      | Specific special characters are replaced with readable keywords                               | `>=` from   [CodeSystem-quantity-comparator](http://hl7.org/fhir/R5/codesystem-quantity-comparator.html)                          | `GreaterThanOrEqualTo` |
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

#### Excluded ValueSets from Enum Generation

The following FHIR value sets are excluded from Kotlin enum generation.

|                                        ValueSet URL                                        |                                           Reason for Exclusion                                            | Affected Version(s) |
|--------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|---------------------|
| [`http://hl7.org/fhir/ValueSet/mimetypes`](http://hl7.org/fhir/ValueSet/mimetypes)         | This value set cannot be expanded because of the way it is defined - it has an infinite number of members | `R4`, `R4B`, `R5`   |
| [`http://hl7.org/fhir/ValueSet/all-languages`](http://hl7.org/fhir/ValueSet/all-languages) | This value set cannot be expanded because of the way it is defined - it has an infinite number of members | `R4`, `R4B`, `R5`   |
| [`http://hl7.org/fhir/ValueSet/use-context`](http://hl7.org/fhir/ValueSet/use-context)     | This value set has >3800 codes when expanded; generated enum class code cannot compile.                   | `R4`, `R4B`, `R5`   |

## Serialization and deserialization

The [Kotlin serialization](https://github.com/Kotlin/kotlinx.serialization) library is used for JSON
serialization/deserialization. All generated FHIR resource classes are marked with annotation
`@Serializable`.

A particular challenge in the serialization/deserialization process is that FHIR primitive data
types are represented by two JSON properties (e.g.
in [R4](https://hl7.org/fhir/R4/json.html#primitive)). As a result, the Kotlin data class of any
FHIR resource or element containing primitive data types cannot be directly mapped to JSON.

To address this, the library generates one hand-rolled `KSerializer` per FHIR type (e.g.
`PatientSerializer`). Each serializer describes the flat FHIR JSON wire shape via
`buildClassSerialDescriptor` — one descriptor slot per wire key, including the `_field` sidecar
keys for primitive extensions (e.g. `gender` + `_gender`). Encode and decode stream field-by-field
through kotlinx's `CompositeEncoder` / `CompositeDecoder`: no intermediate surrogate instance, no
`JsonObject` materialization, no flatten/unflatten pass. The same body services both
`StreamingJsonDecoder` and `JsonTreeDecoder` — kotlinx picks the decoder, the generated serializer
just walks its composite.

Choice types (e.g. `Patient.multipleBirth`) are expanded into per-arm keys on the same flat
descriptor (`multipleBirthBoolean`, `_multipleBirthBoolean`, `multipleBirthInteger`,
`_multipleBirthInteger`, …). On encode, the parent serializer dispatches on the sealed subclass
via a `when` over the arm types and writes the matched arm's keys directly into the parent's
composite encoder. On decode, each arm key is read into a local and the sealed value is
synthesized via the companion `from(…)` factory during model construction. This sidesteps the
[JVM constructor argument limit](https://docs.oracle.com/javase/specs/jvms/se19/html/jvms-4.html#jvms-4.3.3)
that would otherwise be hit on FHIR fields with many possible types (e.g.,
[ElementDefinition.pattern](https://www.hl7.org/fhir/R4B/elementdefinition-definitions.html#ElementDefinition.pattern_x_))
because each arm is an individual descriptor slot rather than a constructor parameter.

By default, Kotlin only adds class discriminators for polymorphic types. This doesn't quite follow
FHIR specification as even standalone FHIR resources (i.e. `Patient`) require `resourceType`. To
solve this, polymorphic `Resource` dispatch (choosing `Patient` vs `Observation` vs … based on the
`resourceType` discriminator) is handled by `ResourcePolymorphicSerializer`. Each concrete resource
ships two serializers: the standalone `XSerializer` (descriptor includes `resourceType`, used when
the static type is the concrete class) and `XPolymorphicSerializer` (descriptor omits
`resourceType`, used as the dispatch target on the polymorphic path so kotlinx-json can inject the
class discriminator without colliding):

```mermaid
graph TB
    A["Patient instance"] -->|"json.encodeToString(patient)"| PS["PatientSerializer<br/>writes resourceType + fields"]
    A -->|"json.encodeToString&ltResource&gt(patient)"| RPS["ResourcePolymorphicSerializer<br/>(AbstractPolymorphicSerializer)"]
    RPS -->|"byClass[Patient::class]"| PPS["PatientPolymorphicSerializer<br/>writes fields only"]
    RPS -.->|"kotlinx-json injects<br/>resourceType discriminator"| O
    PS --> O["JSON output<br/>{ resourceType, ... }"]
    PPS --> O
```

*Figure 1: Polymorphic Serializer Routing*

Once the correct serializer has been found, the contents are then simply serialized/deserialized directly based on
the flat descriptors.

```mermaid
graph LR
    A["**Patient JSON**
    {
    #nbsp;#nbsp;gender: ...
    #nbsp;#nbsp;_gender: ...
    #nbsp;#nbsp;deceasedBoolean: ...
    #nbsp;#nbsp;deceasedDateTime: ...
    #nbsp;#nbsp;multipleBirthBoolean: ...
    #nbsp;#nbsp;_multipleBirthBoolean: ...
    #nbsp;#nbsp;multipleBirthInteger: ...
    #nbsp;#nbsp;contact: [...]
    }
    "]
    E["**Patient object**
    gender: Code
    deceased: Patient.Deceased
    #nbsp;#nbsp;↳ .Boolean | .DateTime
    multipleBirth: Patient.MultipleBirth
    #nbsp;#nbsp;↳ .Boolean | .Integer
    contact: List&lt;Patient.Contact&gt;
    "]

    subgraph PS["PatientSerializer  (__off = 1)"]
      direction TB
      Desc["**descriptor**
      0 → resourceType
      ... 
      16 → gender / 17 → _gender
      20 → deceasedBoolean / 21 → _deceasedBoolean
      22 → deceasedDateTime / 23 → _deceasedDateTime
      26 → multipleBirthBoolean / 27 → _multipleBirthBoolean
      28 → multipleBirthInteger / 29 → _multipleBirthInteger
      31 → contact / 32 → communication / 35 → link"]

      Loop["**while** (true) {
      #nbsp;#nbsp;val __i = decoder.decodeElementIndex(descriptor)
      #nbsp;#nbsp;if (__i == DECODE_DONE) break
      #nbsp;#nbsp;**when** (__i - __off) {
      #nbsp;#nbsp;#nbsp;#nbsp;-1 → resourceType discarded
      #nbsp;#nbsp;#nbsp;#nbsp;0..33 → arm locals
      #nbsp;#nbsp;}
      }"]

      Loop -- "JSON key → __i lookup" --> Desc
      Desc -. "return __i" .-> Loop
      Loop -- "when(15/16) gender, when(19..22) deceased arms, when(25..28) multipleBirth arms, ..." --> Locals[per-key locals]
      Locals -- "MultipleBirth.from(boolean, _boolean, integer, _integer)" --> Seal[sealed values synthesized]
      Locals -- "Deceased.from(boolean, _boolean, dateTime, _dateTime)" --> Seal
      Locals -- "PatientContact / Communication / LinkSerializer.deserialize" --> BB[backbone elements]
    end

    A --> PS
    Seal --> E
    BB --> E
    Locals --> E

    style A text-align:left
    style E text-align:left
    style Desc text-align:left
    style Loop text-align:left
    style PS stroke-dasharray: 5 5
```

*Figure 2: Deserialization of a Patient JSON*

## Implementation

### Overview

The Kotlin FHIR library uses a Gradle binary plugin to automate the generation of Kotlin code
directly
from FHIR specification. This plugin uses [
`kotlinx.serialization`](https://github.com/Kotlin/kotlinx.serialization) library to parse and load
FHIR resource `StructureDefinition`s into an in-memory representation, and then
uses [KotlinPoet](https://square.github.io/kotlinpoet/) to generate corresponding class definitions
for each FHIR resource type. Finally, these generated Kotlin classes are compiled into JVM,
Wasm, JS, Native, and Android targets, enabling their use across various platforms.

```mermaid
graph LR
    subgraph Gradle binary plugin
        A(FHIR spec<br>in JSON) -- kotlinx.serialization --> B(instances of<br>StructureDefinition<br>Kotlin data class<br>)
        B -- KotlinPoet --> C[generated FHIR Resource classes]
    end
    C -- compiler --> D[Kotlin/JVM]
    C -- compiler --> E[Kotlin/Wasm]
    C -- compiler --> F[KotlinJS]
    C -- compiler --> G[Kotlin/Native]
    C -- compiler --> H[Android]
```

*Figure 3: Architecture diagram*

### Definitions

Kotlin code is generated for StructureDefinitions in the following FHIR packages:

- [hl7.fhir.r4.core](https://simplifier.net/packages/hl7.fhir.r4.core)
- [hl7.fhir.r4b.core](https://simplifier.net/packages/hl7.fhir.r4b.core)
- [hl7.fhir.r5.core](https://simplifier.net/packages/hl7.fhir.r5.core)

> **Note:** The following are **NOT** included in the generated code:
> - [Logical](https://hl7.org/fhir/R4/valueset-structure-definition-kind.html) StructureDefinitions,
> such as [Definition](https://hl7.org/fhir/R4/definition.html),
> [Request](https://hl7.org/fhir/R4/request.html), and [Event](https://hl7.org/fhir/R4/event.html)
> in R4
> - Profiles StructureDefinitions
> - Constraints (e.g. in [R4](https://hl7.org/fhir/R4/conformance-rules.html#constraints)) and
> bindings (e.g. in [R4](https://hl7.org/fhir/R4/terminologies.html#binding)) in
> StructureDefinitions are not represented in the generated code
> - CapabilityStatements, CodeSystems, ConceptMaps, NamingSystems, OperationDefinitions,
> SearchParameters, and ValueSets

### FHIR codegen

To put all this together, the
[FHIR codegen](fhir-codegen/gradle-plugin/src/main/kotlin/dev/ohs/fhir/codegen) in the Gradle
binary plugin generates, for each FHIR resource type:

- the model class (the primary class) in the root package e.g. `dev.ohs.fhir.model.r4`, and
- a hand-rolled streaming `KSerializer` per type (e.g. `PatientSerializer`, plus one per
  BackboneElement) in the serializer package e.g. `dev.ohs.fhir.model.r4.serializers`. Resource
  types additionally get a thin `XPolymorphicSerializer` (descriptor without `resourceType`) used
  by `ResourcePolymorphicSerializer` for class-discriminator dispatch.

using
[`ModelFileSpecGenerator`](fhir-codegen/gradle-plugin/src/main/kotlin/dev/ohs/fhir/codegen/ModelFileSpecGenerator.kt)
and
[`SerializerFileSpecGenerator`](fhir-codegen/gradle-plugin/src/main/kotlin/dev/ohs/fhir/codegen/SerializerFileSpecGenerator.kt),
respectively. Each generated serializer streams
against kotlinx's `CompositeEncoder` / `CompositeDecoder` over the flat FHIR JSON wire shape.

Additionally,
the [`schema`](fhir-codegen/gradle-plugin/src/main/kotlin/dev/ohs/fhir/codegen/schema) package in
the FHIR codegen contains the schema for structure definitions and helper functions for processing
them, and the
[`primitives`](fhir-codegen/gradle-plugin/src/main/kotlin/dev/ohs/fhir/codegen/primitives)
package contains code to generate special data classes and serializers for primitive data types as
mentioned [earlier](#mapping-fhir-primitive-data-types-to-kotlin).

## User Guide

### Adding the library dependency to your project

To use the Kotlin FHIR model in your project, you need to add the Kotlin FHIR library dependency to
your project. To do that, first make sure to include the `mavenCentral()`[^5] repository in the
`build.gradle.kts` file in your project root.

[^5]: Early versions of this library (up to `1.0.0-beta02`) were published under the group ID
`com.google.fhir` on [Google Maven](https://maven.google.com/web/index.html?q=fhir-model).

```
// build.gradle.kts
repositories {
    // Other repositories such as gradlePluginPortal() and google()
    mavenCentral()
}
```

Next, follow the instructions for your specific project type.

#### Kotlin Multiplatform Projects

For Kotlin Multiplatform projects, add the dependency to the shared `commonMain` source set within
the `kotlin` block of the module's `build.gradle.kts` file (e.g., `composeApp/build.gradle.kts` or
`shared/build.gradle.kts`). This makes the library available across all platforms in your project.

```
// e.g., composeApp/build.gradle.kts or shared/build.gradle.kts
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("dev.ohs.fhir:fhir-model:1.0.0-beta03")
        }
    }
}
```

#### Android projects

For Android projects, add the dependency to the `dependency` block in the module's
`build.gradle.kts` file (e.g., `app/build.gradle.kts`).

```
// e.g., app/build.gradle.kts
dependencies {
    implementation("dev.ohs.fhir:fhir-model:1.0.0-beta03")
}
```

### Working with FHIR resources

The generated Kotlin classes for FHIR resources are organized in version-specific packages:
`dev.ohs.fhir.model.<FHIR_VERSION>` where `<FHIR_VERSION>`∈ {`r4`, `r4b`, `r5`}.

For example:

- `dev.ohs.fhir.model.r4`
- `dev.ohs.fhir.model.r4b`
- `dev.ohs.fhir.model.r5`

Within each package, you'll find the corresponding Kotlin classes for all FHIR resources of that
version. For example, the `Patient` class generated for FHIR R4 can be found in the
`dev.ohs.fhir.model.r4` package.

To create a new instance of a FHIR resource, use the provided builder class. For example:

```kotlin
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Patient

fun main() {
    val patient =
        Patient.Builder()
            .apply {
                id = "patient-01"
                name.add(
                    HumanName.Builder().apply {
                        given.add(dev.ohs.fhir.model.r4.String.Builder().apply { value = "John" })
                    }
                )
                birthDate = Date.Builder().apply { value = FhirDate.fromString("2000-01-01") }
            }
            .build()
}
```

### Non Json Serializers

The FHIR Resource models work with any serializer, but only JSON is tested against the FHIR Spec.

Other formats can change version to version due to drift in the indexing.

### Serialization and deserialization

Each generated FHIR class carries a hand-rolled `KSerializer` via `@Serializable(with = ...)`, so a
plain [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) `Json` instance can
encode and decode FHIR resources directly:

```kotlin
import dev.ohs.fhir.model.r4.OperationOutcome
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Resource
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val example = """
    {
      "resourceType": "Patient",
      "id": "example",
      "name": [
        {
          "use": "official",
          "family": "Doe",
          "given": ["Jane"]
        }
      ],
      "gender": "female",
      "birthDate": "1985-03-15"
    }
""".trimIndent()

val json = Json {
    // configure Json here
    // https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/json.md#json-configuration
    // note that most configs are ignored for FHIR resources
}

// if you know the exact FHIR type you can deserialize directly to a Patient instance
val patient = json.decodeFromString<Patient>(example)

// if you don't know the type (e.g. a FHIR Server response) deserialize as a generic FHIR Resource
val resource = json.decodeFromString<Resource>(example)

// then dispatch on the result
when (resource) {
    is OperationOutcome -> { /* parse error */ }
    is Patient -> { /* parse patient */ }
    else -> { /* other resource types */ }
}

// To serialize a FHIR resource simply call encodeToString(instance)
val serializedPatient = json.encodeToString(patient)
```

## Developer Guide

This section is for developers who want to contribute to the library.

### Running the codegen locally

You can run the codegen locally to generated FHIR models for all supported FHIR versions at once[^6]:

[^6]: To generate FHIR models for specific versions, run `./gradlew <FHIR_VERSION>` where
`<FHIR_VERSION>`∈ {`r4`, `r4b`, `r5`}. The generated code will be located in the
`fhir-model/build/generated/<FHIR_VERSION>` subdirectory.

```bash
./gradlew codegen
```

This will sync all generated code into the `fhir-model/src/commonMain/kotlin` directory and apply
consistent formatting using the [`spotless`](https://github.com/diffplug/spotless) plugin.

> **Note:** The library is designed for use as a dependency. Directly copying generated code into
> your project is generally discouraged as it can lead to maintenance issues and conflicts with
> future updates.

### Testing

The library includes comprehensive tests suites for the example resources published in the following
packages:

- [hl7.fhir.r4.examples](https://simplifier.net/packages/hl7.fhir.r4.examples) (5309 examples)
- [hl7.fhir.r4b.examples](https://simplifier.net/packages/hl7.fhir.r4b.examples) (2840 examples)
- [hl7.fhir.r5.examples](https://simplifier.net/packages/hl7.fhir.r5.examples) (2822 examples)

For each JSON example of a FHIR resource in the referenced packages, three categories of tests are
executed:

1. Equality test:
   - First instance: Deserialize the JSON into a FHIR resource object.
   - Second instance: Deserialize the same JSON into another FHIR resource object.
   - Verification: The two objects are structurally equal (using `==` operator).
2. Serialization round-trip test:
   - Deserialization: Deserialize the JSON into a FHIR resource object.
   - Serialization: Serialize the object back into JSON.
   - Verification: The regenerated JSON is compared character by character[^7] with the original
     JSON.
3. Builder round-trip test:
   - Deserialization: Deserialize the JSON into a resource object.
   - Conversion to builder: Convert the object into a builder using `toBuilder()` function.
   - Conversion to resource: Build a new FHIR resource object using `build()` function
   - Verification: The reconstructed object from the builder is equal to the original object.

[^7]: There are several exceptions. The FHIR specification allows for some variability in data
representation, which may lead to differences between the original and newly serialized JSON. For
example, additional trailing zeros in decimals and times, non-standard JSON property ordering, the
use of `+00:00` instead of `Z` for zero UTC offset, and large numbers represented in standard
notation instead of scientific notation (e.g. 1000000000000000000 instead of 1E18). The
serialization process normalizes these variations, resulting in potentially different JSON output.
However, in all of these cases, semantic equivalence is maintained.

These tests are set up to run on JVM and as Android unit tests. To run them locally:

```shell
./gradlew :fhir-model:jvmTest
./gradlew :fhir-model:testDebugUnitTest
```

### Publishing

For a comprehensive understanding of publishing KMP libraries to Maven Central, see the
[Kotlin Multiplatform Publishing Guide](https://kotlinlang.org/docs/multiplatform-publish-lib.html)
and the
[Maven Central Publishing Guide](https://central.sonatype.org/publish/publish-portal-guide/).

> **Note:** The project has already been set up to be released to Maven using the
> [`gradle-maven-publish-plugin`](https://github.com/vanniktech/gradle-maven-publish-plugin). The
> following sections outline the additional setup required for a developer to publish to Maven Local
> and Maven Central.

#### Maven Local

To publish artifacts to your local Maven repository (`~/.m2/repository`) for local development and
testing, run:

```bash
./gradlew :fhir-model:publishToMavenLocal
```

#### Maven Central

To publish a new release to Maven Central, first set up your GPG signing key and repository
credentials to Gradle following the aforementioned official guides.

**Best Practice**: Store these sensitive details in your **Global Gradle Properties** file at
`~/.gradle/gradle.properties` (User Home directory). This ensures they are available to all your
projects but are never accidentally committed to the Git repository.

Your `~/.gradle/gradle.properties` should contain:

```properties
# Maven Central Credentials
mavenCentralUsername=YOUR_USERNAME
mavenCentralPassword=YOUR_PASSWORD

# GPG Key Details
signing.keyId=YOUR_KEY_ID
signing.password=YOUR_KEY_PASSWORD
signing.secretKeyRingFile=/path/to/secring.gpg
```

You can verify your signing setup by running:

```bash
./gradlew :fhir-model:checkSigningConfiguration
```

To publish to Maven Central, run:

```bash
./gradlew :fhir-model:publishToMavenCentral
```

## Acknowledgements

Thanks to [Yigit Boyar](https://github.com/yigit) for helping bootstrap this project and generously
sharing his expertise in Kotlin Multiplatform and Gradle.
