/*
 * Copyright 2025-2026 Open Health Stack Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ohs.fhir.codegen.primitives

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.asClassName
import kotlinx.datetime.LocalTime

/**
 * FHIRPath data types and their properties to aid code generation. Each [FhirPathType] has the
 * following properties:
 * - **URI:** The unique identifier for the FHIRPath type (e.g.,
 *   "http://hl7.org/fhirpath/System.Boolean").
 * - **FHIR Type Codes:** A list of FHIR primitive type codes associated with this type (e.g.
 *   "integer", "positiveInt", "unsignedInt" all map to the FHIRPath Integer type).
 * - **Kotlin Type in Data Class:** The Kotlin class used to represent the value in the data class
 *   (e.g. FHIRPath DateTime is represented as FHIRDateTime, an interface generated to handle FHIR's
 *   DateTime semantics).
 * - **Kotlin Type on the Wire ([wireType]):** The Kotlin class used to decode/encode the value on
 *   the JSON wire (e.g. FHIRPath DateTime is a `String` on the wire).
 *
 * N.B. The Kotlin type in data class is retrieved by calling [getTypeInModelClass] with the package
 * name.
 */
enum class FhirPathType(val uri: String, val fhirTypeCodes: List<String>, val wireType: ClassName) {
  BOOLEAN(
    uri = "http://hl7.org/fhirpath/System.Boolean",
    fhirTypeCodes = listOf("boolean"),
    wireType = Boolean::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = Boolean::class.asClassName()

    override fun addCodeToDecodeWirePropertyToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      propertyName: String,
    ) {
      codeBlock.add("%N", propertyName)
    }

    override fun addCodeToDecodeWireVarToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  INTEGER(
    uri = "http://hl7.org/fhirpath/System.Integer",
    fhirTypeCodes = listOf("integer", "positiveInt", "unsignedInt"),
    wireType = Int::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = Int::class.asClassName()

    override fun addCodeToDecodeWirePropertyToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      propertyName: String,
    ) {
      codeBlock.add("%N", propertyName)
    }

    override fun addCodeToDecodeWireVarToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  LONG(
    uri = "http://hl7.org/fhirpath/System.Long",
    fhirTypeCodes = listOf("integer64"),
    wireType = String::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = Long::class.asClassName()

    override fun addCodeToDecodeWirePropertyToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      propertyName: String,
    ) {
      codeBlock.add("%N?.toLong()", propertyName)
    }

    override fun addCodeToDecodeWireVarToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%N?.toLong()", varName)
    }

    override fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value?.toString()")
    }
  },
  DECIMAL(
    uri = "http://hl7.org/fhirpath/System.Decimal",
    fhirTypeCodes = listOf("decimal"),
    wireType = ClassName("com.ionspin.kotlin.bignum.decimal", "BigDecimal"),
  ) {
    override fun getTypeInModelClass(packageName: String) =
      ClassName("com.ionspin.kotlin.bignum.decimal", "BigDecimal")

    override fun addCodeToDecodeWirePropertyToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      propertyName: String,
    ) {
      codeBlock.add("%N", propertyName)
    }

    override fun addCodeToDecodeWireVarToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  STRING(
    uri = "http://hl7.org/fhirpath/System.String",
    fhirTypeCodes =
      listOf(
        "base64Binary",
        "canonical",
        "code",
        "id",
        "markdown",
        "oid",
        "string",
        "uri",
        "url",
        "uuid",
        "xhtml",
      ),
    wireType = String::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = String::class.asClassName()

    override fun addCodeToDecodeWirePropertyToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      propertyName: String,
    ) {
      codeBlock.add("%N", propertyName)
    }

    override fun addCodeToDecodeWireVarToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  DATE(
    uri = "http://hl7.org/fhirpath/System.Date",
    fhirTypeCodes = listOf("date"),
    wireType = String::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = ClassName(packageName, "FhirDate")

    override fun addCodeToDecodeWirePropertyToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      propertyName: String,
    ) {
      codeBlock.add("%T.fromString(%N)", getTypeInModelClass(packageName), propertyName)
    }

    override fun addCodeToDecodeWireVarToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%T.fromString(%L)", getTypeInModelClass(packageName), varName)
    }

    override fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value?.toString()")
    }
  },
  TIME(
    uri = "http://hl7.org/fhirpath/System.Time",
    fhirTypeCodes = listOf("time"),
    wireType = LocalTime::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = LocalTime::class.asClassName()

    override fun addCodeToDecodeWirePropertyToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      propertyName: String,
    ) {
      codeBlock.add("%N", propertyName)
    }

    override fun addCodeToDecodeWireVarToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  DATETIME(
    uri = "http://hl7.org/fhirpath/System.DateTime",
    fhirTypeCodes = listOf("dateTime", "instant"),
    wireType = String::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = ClassName(packageName, "FhirDateTime")

    override fun addCodeToDecodeWirePropertyToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      propertyName: String,
    ) {
      codeBlock.add("%T.fromString(%N)", getTypeInModelClass(packageName), propertyName)
    }

    override fun addCodeToDecodeWireVarToModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%T.fromString(%L)", getTypeInModelClass(packageName), varName)
    }

    override fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value?.toString()")
    }
  };

  /**
   * Returns the corresponding type in the model class — e.g. [Boolean] for FHIR's `boolean` or the
   * custom `FhirDateTime` for FHIR's `dateTime`.
   */
  abstract fun getTypeInModelClass(packageName: String): ClassName

  /**
   * Appends code to convert a decoded wire-shaped property of this [FhirPathType] to the model
   * value type. For example, `boolean` emits `elementName`; `integer64` (string on the wire) emits
   * `elementName?.toLong()`.
   */
  abstract fun addCodeToDecodeWirePropertyToModel(
    codeBlock: CodeBlock.Builder,
    packageName: String,
    propertyName: String,
  )

  /**
   * Same as [addCodeToDecodeWirePropertyToModel] but takes a literal var name instead of a
   * kotlinpoet name token — used inside generated lambdas where `%N` would re-quote.
   */
  abstract fun addCodeToDecodeWireVarToModel(
    codeBlock: CodeBlock.Builder,
    packageName: String,
    varName: String,
  )

  /**
   * Appends code to convert a model value of this [FhirPathType] back to its wire form. For
   * example, `boolean` emits `.value`; `integer64` (`Long` in the model, string on the wire) emits
   * `.value?.toString()`.
   */
  abstract fun addCodeToEncodeModelToWire(codeBlock: CodeBlock.Builder)

  companion object {
    /**
     * Returns all URIs of supported FHIRPath types. This function is used to determine if an
     * element of FHIRPath type (always in the StructureDefinition of FHIR primitive types) should
     * be mapped to the corresponding Kotlin type. For example, element `string.value` should be
     * mapped to Kotlin [String].
     */
    fun getUris() = entries.map { it.uri }

    /**
     * Returns the [FhirPathType] corresponding to the given URI. This function is used to retrieve
     * the [FhirPathType] to map an element to the corresponding Kotlin type.
     */
    fun getFromUri(uri: String) = entries.find { it.uri == uri }

    /**
     * Whether any [FhirPathType] contains the given [fhirTypeCode] — i.e. the code names a
     * supported FHIR primitive that gets a flat `value` + `_value` pair on the wire.
     */
    fun containsFhirTypeCode(fhirTypeCode: String) =
      entries.any { it.fhirTypeCodes.contains(fhirTypeCode) }

    /**
     * Returns the [FhirPathType] for a given FHIR primitive type code, used to pick the wire
     * representation when emitting decode/encode code.
     */
    fun getFromFhirTypeCode(fhirTypeCode: String) =
      entries.find { it.fhirTypeCodes.contains(fhirTypeCode) }
  }
}
