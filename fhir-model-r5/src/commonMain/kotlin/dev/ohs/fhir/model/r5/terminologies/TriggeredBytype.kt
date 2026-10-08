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

/** Codes providing the type of triggeredBy observation. */
public enum class TriggeredBytype(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Reflex("reflex", "http://hl7.org/fhir/observation-triggeredbytype", "Reflex"),
  Repeat("repeat", "http://hl7.org/fhir/observation-triggeredbytype", "Repeat (per policy)"),
  Re_Run("re-run", "http://hl7.org/fhir/observation-triggeredbytype", "Re-run (per policy)");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): TriggeredBytype =
      when (code) {
        "reflex" -> Reflex
        "repeat" -> Repeat
        "re-run" -> Re_Run
        else -> throw IllegalArgumentException("Unknown code $code for enum TriggeredBytype")
      }
  }
}
