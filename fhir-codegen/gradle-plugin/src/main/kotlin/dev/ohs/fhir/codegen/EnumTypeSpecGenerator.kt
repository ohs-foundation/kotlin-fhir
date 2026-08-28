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

package dev.ohs.fhir.codegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.schema.normalizeEnumName
import dev.ohs.fhir.codegen.schema.sanitizeKDoc
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/**
 * Generates a [TypeSpec] for [Enum] class representation of FHIR data. The `Enum` class is
 * generated using information derived from the [ValueSet]. Each generated enum class will contain
 * the methods for retrieving the code, system and display of each `Enum` class constant.
 */
object EnumTypeSpecGenerator {

  fun generate(enumClassName: String, valueSet: ValueSet, packageName: String): TypeSpec? {
    val fhirEnum = generateEnum(valueSet) ?: return null
    val typeSpec =
      TypeSpec.enumBuilder(enumClassName)
        .addSuperinterface(ClassName(packageName, "FhirEnum"))
        .apply {
          fhirEnum.description?.sanitizeKDoc()?.let { addKdoc(it) }
          primaryConstructor(
            FunSpec.constructorBuilder()
              .addParameter("code", String::class)
              .addParameter("system", String::class)
              .addParameter("display", String::class.asClassName().copy(nullable = true))
              .build()
          )
          addProperty(
            PropertySpec.builder("code", String::class, KModifier.OVERRIDE)
              .initializer("code")
              .build()
          )
          addProperty(
            PropertySpec.builder("system", String::class, KModifier.OVERRIDE)
              .initializer("system")
              .build()
          )
          addProperty(
            PropertySpec.builder(
                "display",
                String::class.asClassName().copy(nullable = true),
                KModifier.OVERRIDE,
              )
              .initializer("display")
              .build()
          )

          fhirEnum.constants.forEach {
            addEnumConstant(
              it.name,
              TypeSpec.anonymousClassBuilder()
                .apply {
                  addSuperclassConstructorParameter("%S", it.code)
                  addSuperclassConstructorParameter("%S", it.system)
                  if (it.display != null) {
                    addSuperclassConstructorParameter("%S", it.display)
                  } else {
                    addSuperclassConstructorParameter("null")
                  }
                }
                .build(),
            )
          }
          addFunction(
            FunSpec.builder("toString")
              .addModifiers(KModifier.OVERRIDE)
              .addStatement("return code")
              .returns(String::class)
              .build()
          )
          addType(
            TypeSpec.companionObjectBuilder()
              .addFunction(
                FunSpec.builder("fromCode")
                  .addParameter("code", String::class)
                  .returns(ClassName.bestGuess(enumClassName))
                  .addStatement(
                    "return fromCodeOrNull(code) ?: throw IllegalArgumentException(\"Unknown code \$code for enum %L\")",
                    enumClassName,
                  )
                  .build()
              )
              .addFunction(
                FunSpec.builder("fromCodeOrNull")
                  .addParameter("code", String::class.asClassName().copy(nullable = true))
                  .returns(ClassName.bestGuess(enumClassName).copy(nullable = true))
                  .beginControlFlow("return when (code)")
                  .apply {
                    fhirEnum.constants
                      .distinctBy { it.code }
                      .forEach {
                        addStatement("%S -> %L", it.code, it.name)
                      }
                    addStatement("else -> null")
                  }
                  .endControlFlow()
                  .build()
              )
              .build()
          )
        }
        .build()
    return typeSpec
  }

  /**
   * Instantiates a [FhirEnum] to facilitate the generation of Kotlin enum classes. The enum
   * constants are derived from the expanded codes defined in the `ValueSet.expansion.contains`
   * property. See
   * [ValueSet.expansion](https://www.hl7.org/fhir/R4B/valueset-definitions.html#ValueSet.expansion)
   */
  private fun generateEnum(valueSet: ValueSet): FhirEnum? {
    val enumConstants =
      valueSet.expansion.contains.map { contains ->
        FhirEnumConstant(
          code = contains.code,
          system = contains.system,
          name = contains.code.formatEnumConstantName(),
          display = contains.display,
        )
      }
    return if (enumConstants.isNotEmpty()) {
      FhirEnum(valueSet.description, enumConstants)
    } else {
      null
    }
  }

  /**
   * Transforms a FHIR code into a valid Kotlin enum constant name.
   *
   * This function applies a series of transformations to ensure the resulting name follows Kotlin
   * naming conventions and is a valid identifier. The transformations are applied in the following
   * order:
   * 1. For URLs (strings starting with "http"), extract only the last segment after the final dot
   *    Example: "http://hl7.org/fhirpath/System.DateTime" → "DateTime"
   * 2. For special characters (>, <, >=, etc.), map them to descriptive names Example: ">" →
   *    "GreaterThan", "<" → "LessThan"
   *
   * 3.1. Replace all remaining non-alphanumeric characters with underscores Example:
   * "some-value.123" → "some_value_123"
   *
   * 3.2. If the string starts with a digit, prefix it with an underscore to make it a valid
   * identifier Example: "123test" → "_123test"
   *
   * 3.3. Apply PascalCase to each segment between underscores while preserving the underscores
   * Example: "test_value" → "Test_Value"
   *
   * @return A valid Kotlin enum constant name
   */
  private fun String.formatEnumConstantName(): String {

    if (startsWith("http")) return substringAfterLast(".")

    when (this) {
      ">" -> return "GreaterThan"
      "<" -> return "LessThan"
      ">=" -> return "GreaterThanOrEqualTo"
      "<=" -> return "LessThanOrEqualTo"
      "<>",
      "!=" -> return "NotEqualTo"
      "=" -> return "EqualTo"
      "*" -> return "Multiply"
      "+" -> return "Plus"
      "-" -> return "Minus"
      "/" -> return "Divide"
      "%" -> return "Percent"
    }

    val withUnderscores = this.replace(Regex("[^a-zA-Z0-9]"), "_")

    val prefixed =
      if (withUnderscores.isNotEmpty() && withUnderscores.first().isDigit()) {
        "_$withUnderscores"
      } else {
        withUnderscores
      }
    return prefixed.split("_").joinToString("_") { part ->
      if (part.isEmpty()) "" else part.normalizeEnumName()
    }
  }
}
