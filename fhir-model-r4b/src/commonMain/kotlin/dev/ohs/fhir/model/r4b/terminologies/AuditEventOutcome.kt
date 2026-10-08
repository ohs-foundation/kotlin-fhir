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

package dev.ohs.fhir.model.r4b.terminologies

import dev.ohs.fhir.model.r4b.FhirEnum
import kotlin.String

/** Indicates whether the event succeeded or failed. */
public enum class AuditEventOutcome(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  _0("0", "http://hl7.org/fhir/audit-event-outcome", "Success"),
  _4("4", "http://hl7.org/fhir/audit-event-outcome", "Minor failure"),
  _8("8", "http://hl7.org/fhir/audit-event-outcome", "Serious failure"),
  _12("12", "http://hl7.org/fhir/audit-event-outcome", "Major failure");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AuditEventOutcome =
      when (code) {
        "0" -> _0
        "4" -> _4
        "8" -> _8
        "12" -> _12
        else -> throw IllegalArgumentException("Unknown code $code for enum AuditEventOutcome")
      }
  }
}
