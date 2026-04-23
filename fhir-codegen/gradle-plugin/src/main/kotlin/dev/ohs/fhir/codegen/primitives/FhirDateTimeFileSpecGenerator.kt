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

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.YearMonth

/**
 * Generates a [FileSpec] for `FhirDateTime.kt` containing a sealed interface `FhirDateTime` which
 * is the implementation of the FHIR DateTime primitive type.
 *
 * In particular, this class handles partial date times.
 * - **Year:** Only the year (e.g. `2025`)
 * - **Year and Month:** The year and the month (e.g. `2025-01`)
 * - **Date:** The date part (e.g. `2025-01-08`)
 * - **Date and Time:** The date and time parts with timezone offset (e.g. `2025-01-08T11:49:01Z`)
 *   conforming to [IS8601](https://www.iso.org/iso-8601-date-and-time-format.html).
 *
 * See e.g. [dateTime in R4](https://hl7.org/fhir/R4/datatypes.html#dateTime)
 */
object FhirDateTimeFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val sealedInterfaceClassName = ClassName(packageName, "FhirDateTime")
    return FileSpec.builder(sealedInterfaceClassName)
      .addImport("kotlinx.datetime", "LocalDateTime", "format") // Import extension function
      .addType(
        TypeSpec.interfaceBuilder(sealedInterfaceClassName)
          .addModifiers(KModifier.SEALED)
          .apply {
            addType(
              TypeSpec.classBuilder("Year")
                .addModifiers(KModifier.DATA)
                .addSuperinterface(sealedInterfaceClassName)
                .primaryConstructor(
                  FunSpec.constructorBuilder().addParameter("value", Int::class).build()
                )
                .addProperty(PropertySpec.builder("value", Int::class).initializer("value").build())
                .addFunction(
                  FunSpec.builder("toString")
                    .addModifiers(KModifier.OVERRIDE)
                    .returns(String::class)
                    .addStatement("return value.toString()")
                    .build()
                )
                .build()
            )
            addType(
              TypeSpec.classBuilder("YearMonth")
                .addModifiers(KModifier.DATA)
                .addSuperinterface(sealedInterfaceClassName)
                .primaryConstructor(
                  FunSpec.constructorBuilder().addParameter("value", YearMonth::class).build()
                )
                .addProperty(
                  PropertySpec.builder("value", YearMonth::class).initializer("value").build()
                )
                .addFunction(
                  FunSpec.builder("toString")
                    .addModifiers(KModifier.OVERRIDE)
                    .returns(String::class)
                    .addStatement("return value.toString()")
                    .build()
                )
                .build()
            )
            addType(
              TypeSpec.classBuilder("Date")
                .addModifiers(KModifier.DATA)
                .addSuperinterface(sealedInterfaceClassName)
                .primaryConstructor(
                  FunSpec.constructorBuilder().addParameter("date", LocalDate::class).build()
                )
                .addProperty(
                  PropertySpec.builder("date", LocalDate::class).initializer("date").build()
                )
                .addFunction(
                  FunSpec.builder("toString")
                    .addModifiers(KModifier.OVERRIDE)
                    .returns(String::class)
                    .addStatement("return date.toString()")
                    .build()
                )
                .build()
            )
            addType(
              TypeSpec.classBuilder("DateTime")
                .addModifiers(KModifier.DATA)
                .addSuperinterface(sealedInterfaceClassName)
                .primaryConstructor(
                  FunSpec.constructorBuilder()
                    .addParameter("dateTime", LocalDateTime::class)
                    .addParameter("utcOffset", UtcOffset::class)
                    .build()
                )
                .addProperty(
                  PropertySpec.builder("dateTime", LocalDateTime::class)
                    .initializer("dateTime")
                    .build()
                )
                .addProperty(
                  PropertySpec.builder("utcOffset", UtcOffset::class)
                    .initializer("utcOffset")
                    .build()
                )
                .addFunction(
                  FunSpec.builder("toString")
                    .addModifiers(KModifier.OVERRIDE)
                    .returns(String::class)
                    // Use [ISO
                    // format](https://kotlinlang.org/api/kotlinx-datetime/kotlinx-datetime/kotlinx.datetime/-local-date-time/-formats/-i-s-o.html)
                    // to make sure seconds are always included.
                    .addCode(
                      "return dateTime.format(%T.%N) + utcOffset.toString()",
                      ClassName("kotlinx.datetime", "LocalDateTime").nestedClass("Formats"),
                      "ISO",
                    )
                    .build()
                )
                .build()
            )
            addFunction(
              FunSpec.builder("toString")
                .addModifiers(KModifier.OVERRIDE)
                .addModifiers(KModifier.ABSTRACT)
                .returns(String::class)
                .build()
            )
            addType(
              TypeSpec.companionObjectBuilder()
                .addFunction(
                  FunSpec.builder("fromString")
                    .addParameter("string", String::class.asClassName().copy(nullable = true))
                    .returns(sealedInterfaceClassName.copy(nullable = true))
                    .addCode(
                      """
                      if (string == null) return null
                      if (string.matches(Regex("\\d{4}"))) {
                          return Year(string.toInt())
                      } else if (string.matches(Regex("\\d{4}-\\d{2}"))) {
                          return YearMonth(kotlinx.datetime.YearMonth.parse(string))
                      } else if (string.matches(Regex("\\d{4}-\\d{2}-\\d{2}"))) {
                          return Date(LocalDate.parse(string))
                      } else if (string.matches(Regex("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|([+\\-])\\d{2}:\\d{2})"))) {
                          val groups = Regex("(?<datetime>\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?)(?<utcoffset>Z|([+\\-])\\d{2}:\\d{2})").find(string)!!.groups
                          return DateTime(LocalDateTime.parse(groups["datetime"]!!.value), UtcOffset.parse(groups["utcoffset"]!!.value))
                      }
                      error("Invalid string value: ${'$'}string")
                      """
                        .trimIndent()
                    )
                    .build()
                )
                .build()
            )
          }
          .build()
      )
      .addAnnotation(
        AnnotationSpec.builder(Suppress::class)
          // Suppress redundant visibility modifier warning since KotlinPoet adds explicit modifiers
          // such as `public`.
          .addMember("%S", "RedundantVisibilityModifier")
          // Suppress property name warning since primitive elements may have a JSON property
          // prefixed with `_`.
          .addMember("%S", "PropertyName")
          .build()
      )
      .build()
  }
}
