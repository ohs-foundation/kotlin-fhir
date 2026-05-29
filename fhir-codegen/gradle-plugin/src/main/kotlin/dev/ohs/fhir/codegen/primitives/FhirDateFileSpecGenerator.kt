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
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName

/**
 * Generates a [FileSpec] for `FhirDate.kt` containing a sealed interface `FhirDate` which is the
 * implementation of the FHIR Date primitive type.
 *
 * In particular, this class handles partial dates.
 * - **Year:** Only the year (e.g. `2025`)
 * - **Year and Month:** The year and the month (e.g. `2025-01`)
 * - **Date:** The date part (e.g. `2025-01-08`)
 *
 * The concrete value classes (`Year`, `YearMonth`, `Date`) are shared with `FhirDateTime` and
 * declared once as nested types of `FhirTemporal` by [FhirTemporalFileSpecGenerator]. `FhirDate`
 * re-exposes them as `typealias`es under their original names (`FhirDate.Year`, `FhirDate.Date`) so
 * callers get exhaustive `when` branches and source compatibility is preserved. `FhirDate` is
 * sealed and extends the common `FhirTemporal` supertype.
 *
 * See e.g. [date in R4](https://hl7.org/fhir/R4/datatypes.html#date)
 */
object FhirDateFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val sealedInterfaceClassName = ClassName(packageName, "FhirDate")
    return FileSpec.builder(sealedInterfaceClassName)
      // `LocalDate.parse(...)` is used in `fromString`. The shared value classes live in a separate
      // file, so this file must import the type itself.
      .addImport("kotlinx.datetime", "LocalDate")
      .addType(
        TypeSpec.interfaceBuilder(sealedInterfaceClassName)
          .addModifiers(KModifier.SEALED)
          .addSuperinterface(ClassName(packageName, "FhirTemporal"))
          .apply {
            FhirTemporalFileSpecGenerator.nestedTypeAliasesFor(packageName, includeDateTime = false)
              .forEach { addTypeAlias(it) }
          }
          .addType(
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
                    }
                    error("Invalid string value: ${'$'}string")
                    """
                      .trimIndent()
                  )
                  .build()
              )
              .build()
          )
          .build()
      )
      .build()
  }
}
