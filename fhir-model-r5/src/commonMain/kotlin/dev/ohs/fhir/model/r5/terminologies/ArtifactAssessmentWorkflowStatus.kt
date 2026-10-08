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

/**
 * Possible values for the workflow status of the comment or assessment, typically used to
 * coordinate workflow around the process of accepting and rejecting changes and comments on the
 * artifact.
 */
public enum class ArtifactAssessmentWorkflowStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Submitted("submitted", "http://hl7.org/fhir/artifactassessment-workflow-status", "Submitted"),
  Triaged("triaged", "http://hl7.org/fhir/artifactassessment-workflow-status", "Triaged"),
  Waiting_For_Input(
    "waiting-for-input",
    "http://hl7.org/fhir/artifactassessment-workflow-status",
    "Waiting for Input",
  ),
  Resolved_No_Change(
    "resolved-no-change",
    "http://hl7.org/fhir/artifactassessment-workflow-status",
    "Resolved - No Change",
  ),
  Resolved_Change_Required(
    "resolved-change-required",
    "http://hl7.org/fhir/artifactassessment-workflow-status",
    "Resolved - Change Required",
  ),
  Deferred("deferred", "http://hl7.org/fhir/artifactassessment-workflow-status", "Deferred"),
  Duplicate("duplicate", "http://hl7.org/fhir/artifactassessment-workflow-status", "Duplicate"),
  Applied("applied", "http://hl7.org/fhir/artifactassessment-workflow-status", "Applied"),
  Published("published", "http://hl7.org/fhir/artifactassessment-workflow-status", "Published"),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/artifactassessment-workflow-status",
    "Entered in Error",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ArtifactAssessmentWorkflowStatus =
      when (code) {
        "submitted" -> Submitted
        "triaged" -> Triaged
        "waiting-for-input" -> Waiting_For_Input
        "resolved-no-change" -> Resolved_No_Change
        "resolved-change-required" -> Resolved_Change_Required
        "deferred" -> Deferred
        "duplicate" -> Duplicate
        "applied" -> Applied
        "published" -> Published
        "entered-in-error" -> Entered_In_Error
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum ArtifactAssessmentWorkflowStatus"
          )
      }
  }
}
