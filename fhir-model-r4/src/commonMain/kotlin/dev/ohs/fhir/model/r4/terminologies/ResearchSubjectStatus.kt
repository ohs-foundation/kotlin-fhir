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

package dev.ohs.fhir.model.r4.terminologies

import dev.ohs.fhir.model.r4.FhirEnum
import kotlin.String

/** Indicates the progression of a study subject through a study. */
public enum class ResearchSubjectStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Candidate("candidate", "http://hl7.org/fhir/research-subject-status", "Candidate"),
  Eligible("eligible", "http://hl7.org/fhir/research-subject-status", "Eligible"),
  Follow_Up("follow-up", "http://hl7.org/fhir/research-subject-status", "Follow-up"),
  Ineligible("ineligible", "http://hl7.org/fhir/research-subject-status", "Ineligible"),
  Not_Registered("not-registered", "http://hl7.org/fhir/research-subject-status", "Not Registered"),
  Off_Study("off-study", "http://hl7.org/fhir/research-subject-status", "Off-study"),
  On_Study("on-study", "http://hl7.org/fhir/research-subject-status", "On-study"),
  On_Study_Intervention(
    "on-study-intervention",
    "http://hl7.org/fhir/research-subject-status",
    "On-study-intervention",
  ),
  On_Study_Observation(
    "on-study-observation",
    "http://hl7.org/fhir/research-subject-status",
    "On-study-observation",
  ),
  Pending_On_Study(
    "pending-on-study",
    "http://hl7.org/fhir/research-subject-status",
    "Pending on-study",
  ),
  Potential_Candidate(
    "potential-candidate",
    "http://hl7.org/fhir/research-subject-status",
    "Potential Candidate",
  ),
  Screening("screening", "http://hl7.org/fhir/research-subject-status", "Screening"),
  Withdrawn("withdrawn", "http://hl7.org/fhir/research-subject-status", "Withdrawn");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ResearchSubjectStatus =
      when (code) {
        "candidate" -> Candidate
        "eligible" -> Eligible
        "follow-up" -> Follow_Up
        "ineligible" -> Ineligible
        "not-registered" -> Not_Registered
        "off-study" -> Off_Study
        "on-study" -> On_Study
        "on-study-intervention" -> On_Study_Intervention
        "on-study-observation" -> On_Study_Observation
        "pending-on-study" -> Pending_On_Study
        "potential-candidate" -> Potential_Candidate
        "screening" -> Screening
        "withdrawn" -> Withdrawn
        else -> throw IllegalArgumentException("Unknown code $code for enum ResearchSubjectStatus")
      }
  }
}
