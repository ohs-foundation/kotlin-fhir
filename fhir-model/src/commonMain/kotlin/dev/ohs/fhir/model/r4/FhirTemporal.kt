/*
 * Copyright 2026 Open Health Stack Foundation
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

package dev.ohs.fhir.model.r4

import kotlin.Any
import kotlin.Boolean
import kotlin.Comparable
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmInline
import kotlin.time.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.format
import kotlinx.datetime.toInstant

/**
 * Common supertype of the FHIR `date` ([FhirDate]) and `dateTime` ([FhirDateTime]) primitive value
 * types. The concrete partial-precision values are nested here and shared between both.
 */
public sealed interface FhirTemporal {
  override fun toString(): String

  /**
   * A FHIR `date`/`dateTime` value with year-only precision (e.g. `2025`). Valid as both a
   * [FhirDate] and a [FhirDateTime].
   */
  @JvmInline
  public value class Year(public val `value`: Int) : FhirDate, FhirDateTime {
    override fun toString(): String = value.toString()
  }

  /**
   * A FHIR `date`/`dateTime` value with year-month precision (e.g. `2025-01`). Valid as both a
   * [FhirDate] and a [FhirDateTime].
   */
  @JvmInline
  public value class YearMonth(public val `value`: kotlinx.datetime.YearMonth) :
    FhirDate, FhirDateTime {
    override fun toString(): String = value.toString()
  }

  /**
   * A FHIR `date`/`dateTime` value with full calendar-date precision (e.g. `2025-01-08`). Valid as
   * both a [FhirDate] and a [FhirDateTime].
   */
  @JvmInline
  public value class Date(public val date: LocalDate) : FhirDate, FhirDateTime {
    override fun toString(): String = date.toString()
  }

  /**
   * A FHIR `dateTime` value with a date, time and UTC offset (e.g. `2025-01-08T11:49:01Z`), valid
   * as a [FhirDateTime].
   *
   * Equality, hashing and ordering are delegated to the represented [instant], so two values that
   * denote the same moment in different UTC offsets compare equal.
   */
  public data class DateTime(public val dateTime: LocalDateTime, public val utcOffset: UtcOffset) :
    FhirDateTime, Comparable<DateTime> {
    /** The instant this value denotes, computed from [dateTime] at [utcOffset]. */
    public val instant: Instant = dateTime.toInstant(utcOffset)

    override fun toString(): String =
      dateTime.format(LocalDateTime.Formats.ISO) + utcOffset.toString()

    override fun compareTo(other: DateTime): Int = instant.compareTo(other.instant)

    override fun equals(other: Any?): Boolean = other is DateTime && instant == other.instant

    override fun hashCode(): Int = instant.hashCode()
  }
}
