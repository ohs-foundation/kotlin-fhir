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

/** Defines behavior for an action or a group for how many times that item may be repeated. */
public enum class ActionCardinalityBehavior(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Single("single", "http://hl7.org/fhir/action-cardinality-behavior", "Single"),
  Multiple("multiple", "http://hl7.org/fhir/action-cardinality-behavior", "Multiple");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ActionCardinalityBehavior =
      when (code) {
        "single" -> Single
        "multiple" -> Multiple
        else ->
          throw IllegalArgumentException("Unknown code $code for enum ActionCardinalityBehavior")
      }
  }
}
