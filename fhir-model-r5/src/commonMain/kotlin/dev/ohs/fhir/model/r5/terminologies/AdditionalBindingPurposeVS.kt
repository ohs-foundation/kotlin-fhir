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

/** Additional Binding Purpose */
public enum class AdditionalBindingPurposeVS(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Maximum(
    "maximum",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Maximum Binding",
  ),
  Minimum(
    "minimum",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Minimum Binding",
  ),
  Required(
    "required",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Required Binding",
  ),
  Extensible(
    "extensible",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Conformance Binding",
  ),
  Candidate(
    "candidate",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Candidate Binding",
  ),
  Current(
    "current",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Current Binding",
  ),
  Preferred(
    "preferred",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Preferred Binding",
  ),
  Ui("ui", "http://hl7.org/fhir/CodeSystem/additional-binding-purpose", "UI Suggested Binding"),
  Starter(
    "starter",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Starter Binding",
  ),
  Component(
    "component",
    "http://hl7.org/fhir/CodeSystem/additional-binding-purpose",
    "Component Binding",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AdditionalBindingPurposeVS =
      when (code) {
        "maximum" -> Maximum
        "minimum" -> Minimum
        "required" -> Required
        "extensible" -> Extensible
        "candidate" -> Candidate
        "current" -> Current
        "preferred" -> Preferred
        "ui" -> Ui
        "starter" -> Starter
        "component" -> Component
        else ->
          throw IllegalArgumentException("Unknown code $code for enum AdditionalBindingPurposeVS")
      }
  }
}
