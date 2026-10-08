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

/** The meaning of the hierarchy of concepts in a code system. */
public enum class CodeSystemHierarchyMeaning(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Grouped_By("grouped-by", "http://hl7.org/fhir/codesystem-hierarchy-meaning", "Grouped By"),
  Is_A("is-a", "http://hl7.org/fhir/codesystem-hierarchy-meaning", "Is-A"),
  Part_Of("part-of", "http://hl7.org/fhir/codesystem-hierarchy-meaning", "Part Of"),
  Classified_With(
    "classified-with",
    "http://hl7.org/fhir/codesystem-hierarchy-meaning",
    "Classified With",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): CodeSystemHierarchyMeaning =
      when (code) {
        "grouped-by" -> Grouped_By
        "is-a" -> Is_A
        "part-of" -> Part_Of
        "classified-with" -> Classified_With
        else ->
          throw IllegalArgumentException("Unknown code $code for enum CodeSystemHierarchyMeaning")
      }
  }
}
