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

/** The type of relationship between reports. */
public enum class ReportRelationshipType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Replaces("replaces", "http://hl7.org/fhir/report-relation-type", "Replaces"),
  Amends("amends", "http://hl7.org/fhir/report-relation-type", "Amends"),
  Appends("appends", "http://hl7.org/fhir/report-relation-type", "Appends"),
  Transforms("transforms", "http://hl7.org/fhir/report-relation-type", "Transforms"),
  ReplacedWith("replacedWith", "http://hl7.org/fhir/report-relation-type", "Replaced With"),
  AmendedWith("amendedWith", "http://hl7.org/fhir/report-relation-type", "Amended With"),
  AppendedWith("appendedWith", "http://hl7.org/fhir/report-relation-type", "Appended With"),
  TransformedWith(
    "transformedWith",
    "http://hl7.org/fhir/report-relation-type",
    "Transformed With",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ReportRelationshipType =
      when (code) {
        "replaces" -> Replaces
        "amends" -> Amends
        "appends" -> Appends
        "transforms" -> Transforms
        "replacedWith" -> ReplacedWith
        "amendedWith" -> AmendedWith
        "appendedWith" -> AppendedWith
        "transformedWith" -> TransformedWith
        else -> throw IllegalArgumentException("Unknown code $code for enum ReportRelationshipType")
      }
  }
}
