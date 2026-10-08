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

/** The type of information contained in a component of an artifact assessment. */
public enum class ArtifactAssessmentInformationType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Comment("comment", "http://hl7.org/fhir/artifactassessment-information-type", "Comment"),
  Classifier("classifier", "http://hl7.org/fhir/artifactassessment-information-type", "Classifier"),
  Rating("rating", "http://hl7.org/fhir/artifactassessment-information-type", "Rating"),
  Container("container", "http://hl7.org/fhir/artifactassessment-information-type", "Container"),
  Response("response", "http://hl7.org/fhir/artifactassessment-information-type", "Response"),
  Change_Request(
    "change-request",
    "http://hl7.org/fhir/artifactassessment-information-type",
    "Change Request",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ArtifactAssessmentInformationType =
      when (code) {
        "comment" -> Comment
        "classifier" -> Classifier
        "rating" -> Rating
        "container" -> Container
        "response" -> Response
        "change-request" -> Change_Request
        else ->
          throw IllegalArgumentException(
            "Unknown code $code for enum ArtifactAssessmentInformationType"
          )
      }
  }
}
