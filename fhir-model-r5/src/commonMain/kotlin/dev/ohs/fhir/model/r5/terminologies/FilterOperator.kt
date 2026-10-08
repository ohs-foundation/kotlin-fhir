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

/** The kind of operation to perform as a part of a property based filter. */
public enum class FilterOperator(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  EqualTo("=", "http://hl7.org/fhir/filter-operator", "Equals"),
  Is_A("is-a", "http://hl7.org/fhir/filter-operator", "Is A (by subsumption)"),
  Descendent_Of(
    "descendent-of",
    "http://hl7.org/fhir/filter-operator",
    "Descendent Of (by subsumption)",
  ),
  Is_Not_A("is-not-a", "http://hl7.org/fhir/filter-operator", "Not (Is A) (by subsumption)"),
  Regex("regex", "http://hl7.org/fhir/filter-operator", "Regular Expression"),
  In("in", "http://hl7.org/fhir/filter-operator", "In Set"),
  Not_In("not-in", "http://hl7.org/fhir/filter-operator", "Not in Set"),
  Generalizes("generalizes", "http://hl7.org/fhir/filter-operator", "Generalizes (by Subsumption)"),
  Child_Of("child-of", "http://hl7.org/fhir/filter-operator", "Child Of"),
  Descendent_Leaf("descendent-leaf", "http://hl7.org/fhir/filter-operator", "Descendent Leaf"),
  Exists("exists", "http://hl7.org/fhir/filter-operator", "Exists");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): FilterOperator =
      when (code) {
        "=" -> EqualTo
        "is-a" -> Is_A
        "descendent-of" -> Descendent_Of
        "is-not-a" -> Is_Not_A
        "regex" -> Regex
        "in" -> In
        "not-in" -> Not_In
        "generalizes" -> Generalizes
        "child-of" -> Child_Of
        "descendent-leaf" -> Descendent_Leaf
        "exists" -> Exists
        else -> throw IllegalArgumentException("Unknown code $code for enum FilterOperator")
      }
  }
}
