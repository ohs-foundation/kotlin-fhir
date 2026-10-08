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

/** Codes that convey the current status of the research study. */
public enum class ResearchStudyStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Active("active", "http://hl7.org/fhir/research-study-status", "Active"),
  Administratively_Completed(
    "administratively-completed",
    "http://hl7.org/fhir/research-study-status",
    "Administratively Completed",
  ),
  Approved("approved", "http://hl7.org/fhir/research-study-status", "Approved"),
  Closed_To_Accrual(
    "closed-to-accrual",
    "http://hl7.org/fhir/research-study-status",
    "Closed to Accrual",
  ),
  Closed_To_Accrual_And_Intervention(
    "closed-to-accrual-and-intervention",
    "http://hl7.org/fhir/research-study-status",
    "Closed to Accrual and Intervention",
  ),
  Completed("completed", "http://hl7.org/fhir/research-study-status", "Completed"),
  Disapproved("disapproved", "http://hl7.org/fhir/research-study-status", "Disapproved"),
  In_Review("in-review", "http://hl7.org/fhir/research-study-status", "In Review"),
  Temporarily_Closed_To_Accrual(
    "temporarily-closed-to-accrual",
    "http://hl7.org/fhir/research-study-status",
    "Temporarily Closed to Accrual",
  ),
  Temporarily_Closed_To_Accrual_And_Intervention(
    "temporarily-closed-to-accrual-and-intervention",
    "http://hl7.org/fhir/research-study-status",
    "Temporarily Closed to Accrual and Intervention",
  ),
  Withdrawn("withdrawn", "http://hl7.org/fhir/research-study-status", "Withdrawn");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ResearchStudyStatus =
      when (code) {
        "active" -> Active
        "administratively-completed" -> Administratively_Completed
        "approved" -> Approved
        "closed-to-accrual" -> Closed_To_Accrual
        "closed-to-accrual-and-intervention" -> Closed_To_Accrual_And_Intervention
        "completed" -> Completed
        "disapproved" -> Disapproved
        "in-review" -> In_Review
        "temporarily-closed-to-accrual" -> Temporarily_Closed_To_Accrual
        "temporarily-closed-to-accrual-and-intervention" ->
          Temporarily_Closed_To_Accrual_And_Intervention
        "withdrawn" -> Withdrawn
        else -> throw IllegalArgumentException("Unknown code $code for enum ResearchStudyStatus")
      }
  }
}
