/*
 * Copyright 2026 Google LLC
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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4b

import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.format

public sealed interface FhirDateTime {
  override fun toString(): String

  public data class Year(public val `value`: Int) : FhirDateTime {
    override fun toString(): String = value.toString()
  }

  public data class YearMonth(public val `value`: kotlinx.datetime.YearMonth) : FhirDateTime {
    override fun toString(): String = value.toString()
  }

  public data class Date(public val date: LocalDate) : FhirDateTime {
    override fun toString(): String = date.toString()
  }

  public data class DateTime(public val dateTime: LocalDateTime, public val utcOffset: UtcOffset) :
    FhirDateTime {
    override fun toString(): String =
      dateTime.format(LocalDateTime.Formats.ISO) + utcOffset.toString()
  }

  public companion object {
    public fun fromString(string: String?): FhirDateTime? {
      if (string == null) return null
      if (string.matches(Regex("\\d{4}"))) {
        return Year(string.toInt())
      } else if (string.matches(Regex("\\d{4}-\\d{2}"))) {
        return YearMonth(kotlinx.datetime.YearMonth.parse(string))
      } else if (string.matches(Regex("\\d{4}-\\d{2}-\\d{2}"))) {
        return Date(LocalDate.parse(string))
      } else if (
        string.matches(
          Regex("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|([+\\-])\\d{2}:\\d{2})")
        )
      ) {
        val groups =
          Regex(
              "(?<datetime>\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?)(?<utcoffset>Z|([+\\-])\\d{2}:\\d{2})"
            )
            .find(string)!!
            .groups
        return DateTime(
          LocalDateTime.parse(groups["datetime"]!!.value),
          UtcOffset.parse(groups["utcoffset"]!!.value),
        )
      }
      error("Invalid string value: $string")
    }
  }
}
