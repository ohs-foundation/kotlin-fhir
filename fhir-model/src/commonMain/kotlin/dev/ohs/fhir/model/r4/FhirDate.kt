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

public sealed interface FhirDate {
  override fun toString(): String

  public data class Year(public val `value`: Int) : FhirDate {
    override fun toString(): String = value.toString()
  }

  public data class YearMonth(public val `value`: kotlinx.datetime.YearMonth) : FhirDate {
    override fun toString(): String = value.toString()
  }

  public data class Date(public val date: LocalDate) : FhirDate {
    override fun toString(): String = date.toString()
  }

  public companion object {
    public fun fromString(string: String?): FhirDate? {
      if (string == null) return null
      if (string.matches(Regex("\\d{4}"))) {
        return Year(string.toInt())
      } else if (string.matches(Regex("\\d{4}-\\d{2}"))) {
        return YearMonth(kotlinx.datetime.YearMonth.parse(string))
      } else if (string.matches(Regex("\\d{4}-\\d{2}-\\d{2}"))) {
        return Date(LocalDate.parse(string))
      }
      error("Invalid string value: $string")
    }
  }
}
