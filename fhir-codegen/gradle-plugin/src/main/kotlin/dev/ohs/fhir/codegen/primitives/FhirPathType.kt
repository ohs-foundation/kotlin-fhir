/*
 * Copyright 2025-2026 Google LLC
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
 *   "integer", "positiveInt", "unsignedInt" are all associated with the FHIRPath Integer type, and
 *   should be handled in the generated data class and surrogate class accordingly).
 * - **Kotlin Type in Data Class:** The Kotlin class used for representing the value in the data
 *   class (e.g. FHIRPath DateTime is represented in the data class as FHIRDateTime, an interface
 *   generated to handle the DateTime type in FHIR specifically).
 * - **Kotlin Type in Surrogate Class:** The Kotlin class used for representing the value in the
 *   surrogate classes (e.g., FHIRPath DateTime is mapped to a Kotlin String in the surrogate
 *   class).
 *
 * N.B. The Kotlin type in data class is retrieved by calling [getTypeInModelClass] with the package
 * name.
 */
enum class FhirPathType(
  val uri: String,
  val fhirTypeCodes: List<String>,
  val typeInSurrogateClass: ClassName,
) {
  BOOLEAN(
    uri = "http://hl7.org/fhirpath/System.Boolean",
    fhirTypeCodes = listOf("boolean"),
    typeInSurrogateClass = Boolean::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = Boolean::class.asClassName()

    override fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      surrogateClassName: ClassName,
      propertyName: String,
    ) {
      codeBlock.add("this@%T.%N", surrogateClassName, propertyName)
    }

    override fun addCodeToConvertTypeInSurrogateToTypeInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  INTEGER(
    uri = "http://hl7.org/fhirpath/System.Integer",
    fhirTypeCodes = listOf("integer", "positiveInt", "unsignedInt"),
    typeInSurrogateClass = Int::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = Int::class.asClassName()

    override fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      surrogateClassName: ClassName,
      propertyName: String,
    ) {
      codeBlock.add("this@%T.%N", surrogateClassName, propertyName)
    }

    override fun addCodeToConvertTypeInSurrogateToTypeInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  LONG(
    uri = "http://hl7.org/fhirpath/System.Long",
    fhirTypeCodes = listOf("integer64"),
    typeInSurrogateClass = String::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = Long::class.asClassName()

    override fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      surrogateClassName: ClassName,
      propertyName: String,
    ) {
      codeBlock.add("this@%T.%N?.toLong()", surrogateClassName, propertyName)
    }

    override fun addCodeToConvertTypeInSurrogateToTypeInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%N?.toLong()", varName)
    }

    override fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value?.toString()")
    }
  },
  DECIMAL(
    uri = "http://hl7.org/fhirpath/System.Decimal",
    fhirTypeCodes = listOf("decimal"),
    typeInSurrogateClass = Double::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) =
      ClassName("com.ionspin.kotlin.bignum.decimal", "BigDecimal")

    override fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      surrogateClassName: ClassName,
      propertyName: String,
    ) {
      codeBlock.add("this@%T.%N", surrogateClassName, propertyName)
    }

    override fun addCodeToConvertTypeInSurrogateToTypeInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value?.toString()?.toDouble()")
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
    typeInSurrogateClass = String::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = String::class.asClassName()

    override fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      surrogateClassName: ClassName,
      propertyName: String,
    ) {
      codeBlock.add("this@%T.%N", surrogateClassName, propertyName)
    }

    override fun addCodeToConvertTypeInSurrogateToTypeInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  DATE(
    uri = "http://hl7.org/fhirpath/System.Date",
    fhirTypeCodes = listOf("date"),
    typeInSurrogateClass = String::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = ClassName(packageName, "FhirDate")

    override fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      surrogateClassName: ClassName,
      propertyName: String,
    ) {
      codeBlock.add(
        "%T.fromString(this@%T.%N)",
        getTypeInModelClass(packageName),
        surrogateClassName,
        propertyName,
      )
    }

    override fun addCodeToConvertTypeInSurrogateToTypeInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%T.fromString(%L)", getTypeInModelClass(packageName), varName)
    }

    override fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value?.toString()")
    }
  },
  TIME(
    uri = "http://hl7.org/fhirpath/System.Time",
    fhirTypeCodes = listOf("time"),
    typeInSurrogateClass = LocalTime::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = LocalTime::class.asClassName()

    override fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      surrogateClassName: ClassName,
      propertyName: String,
    ) {
      codeBlock.add("this@%T.%N", surrogateClassName, propertyName)
    }

    override fun addCodeToConvertTypeInSurrogateToTypeInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%L", varName)
    }

    override fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value")
    }
  },
  DATETIME(
    uri = "http://hl7.org/fhirpath/System.DateTime",
    fhirTypeCodes = listOf("dateTime", "instant"),
    typeInSurrogateClass = String::class.asClassName(),
  ) {
    override fun getTypeInModelClass(packageName: String) = ClassName(packageName, "FhirDateTime")

    override fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      surrogateClassName: ClassName,
      propertyName: String,
    ) {
      codeBlock.add(
        "%T.fromString(this@%T.%N)",
        getTypeInModelClass(packageName),
        surrogateClassName,
        propertyName,
      )
    }

    override fun addCodeToConvertTypeInSurrogateToTypeInModel(
      codeBlock: CodeBlock.Builder,
      packageName: String,
      varName: String,
    ) {
      codeBlock.add("%T.fromString(%L)", getTypeInModelClass(packageName), varName)
    }

    override fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder) {
      codeBlock.add(".value?.toString()")
    }
  };

  /**
   * Returns the corresponding type in the model class.
   *
   * Used to construct the properties for primitive FHIR types in the model class, e.g. [Boolean]
   * for FHIR's Boolean type or the custom `FhirDateTime` class for FHIR's DateTime type.
   *
   * Also used by [addCodeToConvertPropertyInSurrogateToPropertyInModel] and
   * [addCodeToConvertTypeInSurrogateToTypeInModel] to generate code to convert a property in the
   * surrogate class to a property in the model class.
   */
  abstract fun getTypeInModelClass(packageName: String): ClassName

  /**
   * Adds code to the `codeBlock` to convert a property of this [FhirPathType] in the surrogate
   * class to a property in the model class.
   *
   * For example, for boolean this generates `this@surrogateClass.elementName`; and for integer64,
   * this generates `this@surrogateClass.elementName?.toLong()` since integer64 is represented in
   * the surrogate class as a string and needs to be converted to a [Long] in the model class.
   */
  abstract fun addCodeToConvertPropertyInSurrogateToPropertyInModel(
    codeBlock: CodeBlock.Builder,
    packageName: String,
    surrogateClassName: ClassName,
    propertyName: String,
  )

  /**
   * Adds code to the `codeBlock` to convert a variable of this [FhirPathType] in the model class to
   * a variable in the surrogate class.
   *
   * For example, for boolean variable `value` this simply generates `value`; and for integer64,
   * this generates `value?.toLong()` since integer64 is represented in the surrogate class as a
   * [String] and needs to be converted to a [Long] in the model class.
   */
  abstract fun addCodeToConvertTypeInSurrogateToTypeInModel(
    codeBlock: CodeBlock.Builder,
    packageName: String,
    varName: String,
  )

  /**
   * Adds code to the `codeBlock` to convert a variable of this [FhirPathType] in the surrogate
   * class to a variable in the model class.
   *
   * For example, for a boolean variable this will generate the code `.value` for the underlying
   * property in the surrogate class; and for integer64, this generates `.value?.toString()` to get
   * the underlying [Long] in the model class and convert it to a [String] in the surrogate class.
   */
  abstract fun addCodeToConvertTypeInModelToTypeInSurrogate(codeBlock: CodeBlock.Builder)

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
     * Whether any [FhirPathType] contains the given [fhirTypeCode]. This function is used to
     * determine whether a type code is a supported FHIR primitive type. This is used to generate
     * code in the surrogate class since FHIR primitive types are mapped to fields in the surrogate
     * class corresponding to two JSON properties.
     */
    fun containsFhirTypeCode(fhirTypeCode: String) =
      entries.any { it.fhirTypeCodes.contains(fhirTypeCode) }

    /**
     * Returns the [FhirPathType] corresponding to the given FHIR type code. This function is used
     * to determine the type of a primitive field in the surrogate class.
     */
    fun getFromFhirTypeCode(fhirTypeCode: String) =
      entries.find { it.fhirTypeCodes.contains(fhirTypeCode) }
  }
}
