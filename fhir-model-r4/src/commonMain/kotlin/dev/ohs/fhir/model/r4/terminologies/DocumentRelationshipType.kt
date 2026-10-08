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

/** The type of relationship between documents. */
public enum class DocumentRelationshipType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Replaces("replaces", "http://hl7.org/fhir/document-relationship-type", "Replaces"),
  Transforms("transforms", "http://hl7.org/fhir/document-relationship-type", "Transforms"),
  Signs("signs", "http://hl7.org/fhir/document-relationship-type", "Signs"),
  Appends("appends", "http://hl7.org/fhir/document-relationship-type", "Appends");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): DocumentRelationshipType =
      when (code) {
        "replaces" -> Replaces
        "transforms" -> Transforms
        "signs" -> Signs
        "appends" -> Appends
        else ->
          throw IllegalArgumentException("Unknown code $code for enum DocumentRelationshipType")
      }
  }
}
