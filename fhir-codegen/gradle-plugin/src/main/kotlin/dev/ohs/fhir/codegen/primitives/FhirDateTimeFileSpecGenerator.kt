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
 * The concrete value classes (`Year`, `YearMonth`, `Date`, `DateTime`) are declared once as nested
 * types of `FhirTemporal` by [FhirTemporalFileSpecGenerator]; `Year`, `YearMonth` and `Date` are
 * shared with `FhirDate`. `FhirDateTime` re-exposes all four as `typealias`es under their original
 * names (`FhirDateTime.Date`, `FhirDateTime.DateTime`) so callers get exhaustive `when` branches
 * and source compatibility is preserved. `FhirDateTime` is sealed and extends the common
 * `FhirTemporal` supertype.
 *
 * See e.g. [dateTime in R4](https://hl7.org/fhir/R4/datatypes.html#dateTime)
 */
object FhirDateTimeFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val sealedInterfaceClassName = ClassName(packageName, "FhirDateTime")
    return FileSpec.builder(sealedInterfaceClassName)
      // `fromString` references these types directly; the shared value classes live in a separate
      // file, so this file must import them itself.
      .addImport("kotlinx.datetime", "LocalDate", "LocalDateTime", "UtcOffset")
      .addType(
        TypeSpec.interfaceBuilder(sealedInterfaceClassName)
          .addModifiers(KModifier.SEALED)
          .addSuperinterface(ClassName(packageName, "FhirTemporal"))
          .apply {
            FhirTemporalFileSpecGenerator.nestedTypeAliasesFor(packageName, includeDateTime = true)
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
          .build()
      )
      .build()
  }
}
