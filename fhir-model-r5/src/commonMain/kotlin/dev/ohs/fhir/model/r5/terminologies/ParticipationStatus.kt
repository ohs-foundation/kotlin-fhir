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

/** The Participation status of an appointment. */
public enum class ParticipationStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Accepted("accepted", "http://hl7.org/fhir/participationstatus", "Accepted"),
  Declined("declined", "http://hl7.org/fhir/participationstatus", "Declined"),
  Tentative("tentative", "http://hl7.org/fhir/participationstatus", "Tentative"),
  Needs_Action("needs-action", "http://hl7.org/fhir/participationstatus", "Needs Action");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ParticipationStatus =
      when (code) {
        "accepted" -> Accepted
        "declined" -> Declined
        "tentative" -> Tentative
        "needs-action" -> Needs_Action
        else -> throw IllegalArgumentException("Unknown code $code for enum ParticipationStatus")
      }
  }
}
