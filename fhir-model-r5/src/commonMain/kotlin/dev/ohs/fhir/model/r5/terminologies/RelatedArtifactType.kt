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

/** The type of relationship to the related artifact. */
public enum class RelatedArtifactType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Documentation("documentation", "http://hl7.org/fhir/related-artifact-type", "Documentation"),
  Justification("justification", "http://hl7.org/fhir/related-artifact-type", "Justification"),
  Citation("citation", "http://hl7.org/fhir/related-artifact-type", "Citation"),
  Predecessor("predecessor", "http://hl7.org/fhir/related-artifact-type", "Predecessor"),
  Successor("successor", "http://hl7.org/fhir/related-artifact-type", "Successor"),
  Derived_From("derived-from", "http://hl7.org/fhir/related-artifact-type", "Derived From"),
  Depends_On("depends-on", "http://hl7.org/fhir/related-artifact-type", "Depends On"),
  Composed_Of("composed-of", "http://hl7.org/fhir/related-artifact-type", "Composed Of"),
  Part_Of("part-of", "http://hl7.org/fhir/related-artifact-type", "Part Of"),
  Amends("amends", "http://hl7.org/fhir/related-artifact-type", "Amends"),
  Amended_With("amended-with", "http://hl7.org/fhir/related-artifact-type", "Amended With"),
  Appends("appends", "http://hl7.org/fhir/related-artifact-type", "Appends"),
  Appended_With("appended-with", "http://hl7.org/fhir/related-artifact-type", "Appended With"),
  Cites("cites", "http://hl7.org/fhir/related-artifact-type", "Cites"),
  Cited_By("cited-by", "http://hl7.org/fhir/related-artifact-type", "Cited By"),
  Comments_On("comments-on", "http://hl7.org/fhir/related-artifact-type", "Is Comment On"),
  Comment_In("comment-in", "http://hl7.org/fhir/related-artifact-type", "Has Comment In"),
  Contains("contains", "http://hl7.org/fhir/related-artifact-type", "Contains"),
  Contained_In("contained-in", "http://hl7.org/fhir/related-artifact-type", "Contained In"),
  Corrects("corrects", "http://hl7.org/fhir/related-artifact-type", "Corrects"),
  Correction_In("correction-in", "http://hl7.org/fhir/related-artifact-type", "Correction In"),
  Replaces("replaces", "http://hl7.org/fhir/related-artifact-type", "Replaces"),
  Replaced_With("replaced-with", "http://hl7.org/fhir/related-artifact-type", "Replaced With"),
  Retracts("retracts", "http://hl7.org/fhir/related-artifact-type", "Retracts"),
  Retracted_By("retracted-by", "http://hl7.org/fhir/related-artifact-type", "Retracted By"),
  Signs("signs", "http://hl7.org/fhir/related-artifact-type", "Signs"),
  Similar_To("similar-to", "http://hl7.org/fhir/related-artifact-type", "Similar To"),
  Supports("supports", "http://hl7.org/fhir/related-artifact-type", "Supports"),
  Supported_With("supported-with", "http://hl7.org/fhir/related-artifact-type", "Supported With"),
  Transforms("transforms", "http://hl7.org/fhir/related-artifact-type", "Transforms"),
  Transformed_Into(
    "transformed-into",
    "http://hl7.org/fhir/related-artifact-type",
    "Transformed Into",
  ),
  Transformed_With(
    "transformed-with",
    "http://hl7.org/fhir/related-artifact-type",
    "Transformed With",
  ),
  Documents("documents", "http://hl7.org/fhir/related-artifact-type", "Documents"),
  Specification_Of(
    "specification-of",
    "http://hl7.org/fhir/related-artifact-type",
    "Specification Of",
  ),
  Created_With("created-with", "http://hl7.org/fhir/related-artifact-type", "Created With"),
  Cite_As("cite-as", "http://hl7.org/fhir/related-artifact-type", "Cite As");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): RelatedArtifactType =
      when (code) {
        "documentation" -> Documentation
        "justification" -> Justification
        "citation" -> Citation
        "predecessor" -> Predecessor
        "successor" -> Successor
        "derived-from" -> Derived_From
        "depends-on" -> Depends_On
        "composed-of" -> Composed_Of
        "part-of" -> Part_Of
        "amends" -> Amends
        "amended-with" -> Amended_With
        "appends" -> Appends
        "appended-with" -> Appended_With
        "cites" -> Cites
        "cited-by" -> Cited_By
        "comments-on" -> Comments_On
        "comment-in" -> Comment_In
        "contains" -> Contains
        "contained-in" -> Contained_In
        "corrects" -> Corrects
        "correction-in" -> Correction_In
        "replaces" -> Replaces
        "replaced-with" -> Replaced_With
        "retracts" -> Retracts
        "retracted-by" -> Retracted_By
        "signs" -> Signs
        "similar-to" -> Similar_To
        "supports" -> Supports
        "supported-with" -> Supported_With
        "transforms" -> Transforms
        "transformed-into" -> Transformed_Into
        "transformed-with" -> Transformed_With
        "documents" -> Documents
        "specification-of" -> Specification_Of
        "created-with" -> Created_With
        "cite-as" -> Cite_As
        else -> throw IllegalArgumentException("Unknown code $code for enum RelatedArtifactType")
      }
  }
}
