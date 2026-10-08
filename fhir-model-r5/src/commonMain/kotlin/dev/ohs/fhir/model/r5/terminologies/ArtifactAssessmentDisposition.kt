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
 * Possible values for the disposition of a comment or change request, typically used for comments
 * and change requests, to indicate the disposition of the responsible party towards the changes
 * suggested by the comment or change request.
 */
public enum class ArtifactAssessmentDisposition(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Unresolved("unresolved", "http://hl7.org/fhir/artifactassessment-disposition", "Unresolved"),
  Not_Persuasive(
    "not-persuasive",
    "http://hl7.org/fhir/artifactassessment-disposition",
    "Not Persuasive",
  ),
  Persuasive("persuasive", "http://hl7.org/fhir/artifactassessment-disposition", "Persuasive"),
  Persuasive_With_Modification(
    "persuasive-with-modification",
    "http://hl7.org/fhir/artifactassessment-disposition",
    "Persuasive with Modification",
  ),
  Not_Persuasive_With_Modification(
    "not-persuasive-with-modification",
    "http://hl7.org/fhir/artifactassessment-disposition",
    "Not Persuasive with Modification",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ArtifactAssessmentDisposition =
      when (code) {
        "unresolved" -> Unresolved
        "not-persuasive" -> Not_Persuasive
        "persuasive" -> Persuasive
        "persuasive-with-modification" -> Persuasive_With_Modification
        "not-persuasive-with-modification" -> Not_Persuasive_With_Modification
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum ArtifactAssessmentDisposition"
          )
      }
  }
}
