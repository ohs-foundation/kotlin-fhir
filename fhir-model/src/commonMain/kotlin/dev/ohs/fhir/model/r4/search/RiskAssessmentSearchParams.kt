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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Condition
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RiskAssessment
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RiskAssessment] resource type. */
public object RiskAssessmentSearchParams {
  public val condition: SearchParam<RiskAssessment, Reference> =
    SearchParam<RiskAssessment, Reference>(
      name = "condition",
      type = SearchParamType.fromCode("reference"),
      expression = "RiskAssessment.condition",
      target = listOf(Condition::class),
      extractor = { resource -> listOfNotNull(resource.condition) },
    )

  public val date: SearchParam<RiskAssessment, DateTime> =
    SearchParam<RiskAssessment, DateTime>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "(RiskAssessment.occurrence as dateTime)",
      extractor = { resource ->
        listOfNotNull((resource.occurrence as? RiskAssessment.Occurrence.DateTime)?.value)
      },
    )

  public val encounter: SearchParam<RiskAssessment, Reference> =
    SearchParam<RiskAssessment, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "RiskAssessment.encounter",
      target = listOf(Encounter::class, EpisodeOfCare::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<RiskAssessment, Identifier> =
    SearchParam<RiskAssessment, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "RiskAssessment.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val method: SearchParam<RiskAssessment, CodeableConcept> =
    SearchParam<RiskAssessment, CodeableConcept>(
      name = "method",
      type = SearchParamType.fromCode("token"),
      expression = "RiskAssessment.method",
      extractor = { resource -> listOfNotNull(resource.method) },
    )

  public val patient: SearchParam<RiskAssessment, Reference> =
    SearchParam<RiskAssessment, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "RiskAssessment.subject.where(resolve() is Patient)",
      target = listOf(Patient::class, Group::class),
      extractor = { resource ->
        listOf(resource.subject).filter {
          it.reference?.value?.toString()?.contains("Patient/") == true
        }
      },
    )

  public val performer: SearchParam<RiskAssessment, Reference> =
    SearchParam<RiskAssessment, Reference>(
      name = "performer",
      type = SearchParamType.fromCode("reference"),
      expression = "RiskAssessment.performer",
      target = listOf(Practitioner::class, Device::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.performer) },
    )

  public val probability: SearchParam<RiskAssessment, RiskAssessment.Prediction.Probability> =
    SearchParam<RiskAssessment, RiskAssessment.Prediction.Probability>(
      name = "probability",
      type = SearchParamType.fromCode("number"),
      expression = "RiskAssessment.prediction.probability",
      extractor = { resource -> resource.prediction.mapNotNull { it.probability } },
    )

  public val risk: SearchParam<RiskAssessment, CodeableConcept> =
    SearchParam<RiskAssessment, CodeableConcept>(
      name = "risk",
      type = SearchParamType.fromCode("token"),
      expression = "RiskAssessment.prediction.qualitativeRisk",
      extractor = { resource -> resource.prediction.mapNotNull { it.qualitativeRisk } },
    )

  public val subject: SearchParam<RiskAssessment, Reference> =
    SearchParam<RiskAssessment, Reference>(
      name = "subject",
      type = SearchParamType.fromCode("reference"),
      expression = "RiskAssessment.subject",
      target = listOf(Group::class, Patient::class),
      extractor = { resource -> listOf(resource.subject) },
    )

  /** All search parameters for the RiskAssessment resource type. */
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
