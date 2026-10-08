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

package dev.ohs.fhir.model.r5.terminologies

import dev.ohs.fhir.model.r5.FhirEnum
import kotlin.String

/** Defines selection behavior of a group. */
public enum class ActionSelectionBehavior(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Any("any", "http://hl7.org/fhir/action-selection-behavior", "Any"),
  All("all", "http://hl7.org/fhir/action-selection-behavior", "All"),
  All_Or_None("all-or-none", "http://hl7.org/fhir/action-selection-behavior", "All Or None"),
  Exactly_One("exactly-one", "http://hl7.org/fhir/action-selection-behavior", "Exactly One"),
  At_Most_One("at-most-one", "http://hl7.org/fhir/action-selection-behavior", "At Most One"),
  One_Or_More("one-or-more", "http://hl7.org/fhir/action-selection-behavior", "One Or More");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ActionSelectionBehavior =
      when (code) {
        "any" -> Any
        "all" -> All
        "all-or-none" -> All_Or_None
        "exactly-one" -> Exactly_One
        "at-most-one" -> At_Most_One
        "one-or-more" -> One_Or_More
        else ->
          throw IllegalArgumentException("Unknown code $code for enum ActionSelectionBehavior")
      }
  }
}
