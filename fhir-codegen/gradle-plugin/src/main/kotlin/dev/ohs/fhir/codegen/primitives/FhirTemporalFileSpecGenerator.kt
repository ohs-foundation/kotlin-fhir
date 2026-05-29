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
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeAliasSpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName

/**
 * Generates `FhirTemporal.kt`, which is the shared foundation for the FHIR `date`/`dateTime`
 * primitive value types.
 *
 * Because FHIR's `date` and `dateTime` partial-precision values overlap (a year, a year-month, or a
 * full date are valid for *both*), the concrete value classes are declared **once** as nested types
 * of [FhirTemporal] and implement whichever of the sealed [FhirDate]/[FhirDateTime] interfaces
 * apply:
 * - `FhirTemporal.Year`, `FhirTemporal.YearMonth` and `FhirTemporal.Date` implement both `FhirDate`
 *   and `FhirDateTime`.
 * - `FhirTemporal.DateTime` (carrying a time and offset) implements `FhirDateTime` only.
 *
 * Nesting them under [FhirTemporal] keeps their natural names (`Date`, `DateTime`) without clashing
 * with the top-level FHIR `Date`/`DateTime` primitive wrappers. The parent [FhirTemporal] interface
 * is the common supertype of `FhirDate` and `FhirDateTime`, so a single value can be handled
 * uniformly.
 *
 * `FhirDate` and `FhirDateTime` re-expose these nested classes via `typealias`es (e.g.
 * `FhirDate.Date` = `FhirTemporal.Date`), preserving the original names for source compatibility
 * and giving exhaustive `when` branches like `is FhirDateTime.Date`. See [nestedTypeAliasesFor].
 */
object FhirTemporalFileSpecGenerator {
  // Simple names of the value types nested under FhirTemporal — also the names the FhirDate /
  // FhirDateTime typealiases re-expose, so they must match the original (pre-refactor) names.
  internal const val YEAR = "Year"
  internal const val YEAR_MONTH = "YearMonth"
  internal const val DATE = "Date"
  internal const val DATE_TIME = "DateTime"

  fun generate(packageName: String): FileSpec {
    val fhirTemporal = ClassName(packageName, "FhirTemporal")
    val fhirDate = ClassName(packageName, "FhirDate")
    val fhirDateTime = ClassName(packageName, "FhirDateTime")

    return FileSpec.builder(fhirTemporal)
      // The `format` and `toInstant` extensions on LocalDateTime are used by FhirTemporal.DateTime.
      .addImport("kotlinx.datetime", "LocalDateTime", "format", "toInstant")
      .addType(
        TypeSpec.interfaceBuilder(fhirTemporal)
          .addModifiers(KModifier.SEALED)
          .addKdoc(
            "Common supertype of the FHIR `date` ([FhirDate]) and `dateTime` ([FhirDateTime]) " +
              "primitive value types. The concrete partial-precision values are nested here and " +
              "shared between both."
          )
          .addFunction(
            FunSpec.builder("toString")
              .addModifiers(KModifier.OVERRIDE, KModifier.ABSTRACT)
              .returns(String::class)
              .build()
          )
          // Year — a year-only value, valid as both a date and a dateTime.
          .addType(
            sharedValueClass(
              name = YEAR,
              kdoc =
                "A FHIR `date`/`dateTime` value with year-only precision (e.g. `2025`). Valid as " +
                  "both a [FhirDate] and a [FhirDateTime].",
              propertyName = "value",
              propertyType = ClassName("kotlin", "Int"),
              toStringExpression = "value.toString()",
              superinterfaces = listOf(fhirDate, fhirDateTime),
            )
          )
          // YearMonth — a year-month value, valid as both a date and a dateTime.
          .addType(
            sharedValueClass(
              name = YEAR_MONTH,
              kdoc =
                "A FHIR `date`/`dateTime` value with year-month precision (e.g. `2025-01`). Valid " +
                  "as both a [FhirDate] and a [FhirDateTime].",
              propertyName = "value",
              propertyType = ClassName("kotlinx.datetime", "YearMonth"),
              toStringExpression = "value.toString()",
              superinterfaces = listOf(fhirDate, fhirDateTime),
            )
          )
          // Date — a full calendar date, valid as both a date and a dateTime.
          .addType(
            sharedValueClass(
              name = DATE,
              kdoc =
                "A FHIR `date`/`dateTime` value with full calendar-date precision (e.g. " +
                  "`2025-01-08`). Valid as both a [FhirDate] and a [FhirDateTime].",
              propertyName = "date",
              propertyType = ClassName("kotlinx.datetime", "LocalDate"),
              toStringExpression = "date.toString()",
              superinterfaces = listOf(fhirDate, fhirDateTime),
            )
          )
          // DateTime — a date and time with offset, valid as a dateTime only.
          .addType(dateTimeClass(fhirTemporal, fhirDateTime))
          .build()
      )
      .build()
  }

  /**
   * Builds the nested `DateTime` class — a FHIR `dateTime` carrying a date, time and UTC offset.
   *
   * Unlike the other temporal values it holds two fields (so it can't be `@JvmInline`) and it
   * exposes a derived [kotlin.time.Instant]. Equality, hashing and ordering are all delegated to
   * that instant, so two values denoting the same moment in different offsets compare equal.
   */
  private fun dateTimeClass(fhirTemporal: ClassName, fhirDateTime: ClassName): TypeSpec {
    val self = fhirTemporal.nestedClass(DATE_TIME)
    val localDateTime = ClassName("kotlinx.datetime", "LocalDateTime")
    val utcOffset = ClassName("kotlinx.datetime", "UtcOffset")
    val instant = ClassName("kotlin.time", "Instant")
    return TypeSpec.classBuilder(DATE_TIME)
      // Kept a `data class` (with explicit equals/hashCode below) so `copy`/destructuring remain
      // available; the explicit members take precedence over the generated ones.
      .addModifiers(KModifier.DATA)
      .addKdoc(
        "A FHIR `dateTime` value with a date, time and UTC offset (e.g. `2025-01-08T11:49:01Z`), " +
          "valid as a [FhirDateTime].\n\n" +
          "Equality, hashing and ordering are delegated to the represented [instant], so two " +
          "values that denote the same moment in different UTC offsets compare equal."
      )
      .addSuperinterface(fhirDateTime)
      .addSuperinterface(Comparable::class.asTypeName().parameterizedBy(self))
      .primaryConstructor(
        FunSpec.constructorBuilder()
          .addParameter("dateTime", localDateTime)
          .addParameter("utcOffset", utcOffset)
          .build()
      )
      .addProperty(PropertySpec.builder("dateTime", localDateTime).initializer("dateTime").build())
      .addProperty(PropertySpec.builder("utcOffset", utcOffset).initializer("utcOffset").build())
      .addProperty(
        PropertySpec.builder("instant", instant)
          .addKdoc("The instant this value denotes, computed from [dateTime] at [utcOffset].")
          .initializer("dateTime.toInstant(utcOffset)")
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
            localDateTime.nestedClass("Formats"),
            "ISO",
          )
          .build()
      )
      .addFunction(
        FunSpec.builder("compareTo")
          .addModifiers(KModifier.OVERRIDE)
          .addParameter("other", self)
          .returns(Int::class)
          .addStatement("return instant.compareTo(other.instant)")
          .build()
      )
      .addFunction(
        FunSpec.builder("equals")
          .addModifiers(KModifier.OVERRIDE)
          .addParameter("other", Any::class.asTypeName().copy(nullable = true))
          .returns(Boolean::class)
          .addStatement("return other is %T && instant == other.instant", self)
          .build()
      )
      .addFunction(
        FunSpec.builder("hashCode")
          .addModifiers(KModifier.OVERRIDE)
          .returns(Int::class)
          .addStatement("return instant.hashCode()")
          .build()
      )
      .build()
  }

  /**
   * Builds a single-property `@JvmInline value class` value type (e.g. `Year`, `YearMonth`, `Date`)
   * that implements the given [superinterfaces], with a `toString` override. The single wrapped
   * value means there is nothing to allocate beyond the value itself, so these are inline.
   */
  private fun sharedValueClass(
    name: String,
    kdoc: String,
    propertyName: String,
    propertyType: ClassName,
    toStringExpression: String,
    superinterfaces: List<ClassName>,
  ): TypeSpec =
    TypeSpec.classBuilder(name)
      .addModifiers(KModifier.VALUE)
      .addAnnotation(ClassName("kotlin.jvm", "JvmInline"))
      .addKdoc(kdoc)
      .apply { superinterfaces.forEach { addSuperinterface(it) } }
      .primaryConstructor(
        FunSpec.constructorBuilder().addParameter(propertyName, propertyType).build()
      )
      .addProperty(
        PropertySpec.builder(propertyName, propertyType).initializer(propertyName).build()
      )
      .addFunction(
        FunSpec.builder("toString")
          .addModifiers(KModifier.OVERRIDE)
          .returns(String::class)
          .addStatement("return %L", toStringExpression)
          .build()
      )
      .build()

  /**
   * Builds the `typealias`es a temporal sealed interface exposes for the shared nested value
   * classes — e.g. `typealias Date = FhirTemporal.Date` nested inside `FhirDate`. This lets callers
   * keep writing `FhirDate.Date` / `is FhirDateTime.YearMonth` exactly as before the values were
   * hoisted onto `FhirTemporal`.
   */
  internal fun nestedTypeAliasesFor(
    packageName: String,
    includeDateTime: Boolean,
  ): List<TypeAliasSpec> =
    buildList {
        add(YEAR)
        add(YEAR_MONTH)
        add(DATE)
        if (includeDateTime) add(DATE_TIME)
      }
      .map { simpleName -> temporalTypeAlias(packageName, simpleName) }
}

/**
 * Builds a single `typealias` (e.g. `typealias Date = FhirTemporal.Date`) re-exposing a value class
 * nested under `FhirTemporal`. The alias name and the nested class name are identical; the
 * `FhirTemporal.` qualifier on the right-hand side keeps it from being self-referential and from
 * colliding with the top-level FHIR `Date`/`DateTime` primitive wrappers.
 */
internal fun temporalTypeAlias(packageName: String, simpleName: String): TypeAliasSpec =
  TypeAliasSpec.builder(simpleName, ClassName(packageName, "FhirTemporal", simpleName)).build()
