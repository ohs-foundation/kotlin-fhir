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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Condition
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RiskAssessment
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RiskAssessment] resource type. */
public object RiskAssessmentSearchParams {
  public val condition: SearchParam<RiskAssessment, Reference> =
    SearchParam(
      name = "condition",
      type = SearchParamType.Reference,
      expression = "RiskAssessment.condition",
      target = listOf(Condition::class),
      extractor = { resource -> listOfNotNull(resource.condition) },
    )

  public val date: SearchParam<RiskAssessment, DateTime> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "(RiskAssessment.occurrence as dateTime)",
      extractor = { resource ->
        listOfNotNull((resource.occurrence as? RiskAssessment.Occurrence.DateTime)?.value)
      },
    )

  public val encounter: SearchParam<RiskAssessment, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "RiskAssessment.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<RiskAssessment, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "RiskAssessment.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val method: SearchParam<RiskAssessment, CodeableConcept> =
    SearchParam(
      name = "method",
      type = SearchParamType.Token,
      expression = "RiskAssessment.method",
      extractor = { resource -> listOfNotNull(resource.method) },
    )

  public val patient: SearchParam<RiskAssessment, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "RiskAssessment.subject.where(resolve() is Patient)",
      target = listOf(Patient::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<RiskAssessment, Reference> =
    SearchParam(
      name = "performer",
      type = SearchParamType.Reference,
      expression = "RiskAssessment.performer",
      target = listOf(Practitioner::class, Device::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.performer) },
    )

  public val probability: SearchParam<RiskAssessment, RiskAssessment.Prediction.Probability> =
    SearchParam(
      name = "probability",
      type = SearchParamType.Number,
      expression = "RiskAssessment.prediction.probability",
      extractor = { resource -> resource.prediction.mapNotNull { it.probability } },
    )

  public val risk: SearchParam<RiskAssessment, CodeableConcept> =
    SearchParam(
      name = "risk",
      type = SearchParamType.Token,
      expression = "RiskAssessment.prediction.qualitativeRisk",
      extractor = { resource -> resource.prediction.mapNotNull { it.qualitativeRisk } },
    )

  public val subject: SearchParam<RiskAssessment, Reference> =
    SearchParam(
      name = "subject",
      type = SearchParamType.Reference,
      expression = "RiskAssessment.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<RiskAssessment, *>> = listOf()

  /**
   * Supported search parameters for the RiskAssessment resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<RiskAssessment, *>> =
    listOf(
      condition,
      date,
      encounter,
      identifier,
      method,
      patient,
      performer,
      probability,
      risk,
      subject,
    )
}
