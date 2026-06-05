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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.RiskAssessment
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [RiskAssessment] resource type. */
public object RiskAssessmentSearchParams {
  public val condition: SearchParam<RiskAssessment, Reference> =
    SearchParam(
      name = "condition",
      type = SearchParamType.fromCode("reference"),
      expression = "RiskAssessment.condition",
      target = listOf(Condition::class),
      extractor = { resource -> listOfNotNull(resource.condition) },
    )

  public val date: SearchParam<RiskAssessment, Any> =
    SearchParam(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "(RiskAssessment.occurrence.ofType(dateTime))",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'date' has expression '(RiskAssessment.occurrence.ofType(dateTime))' which is not yet supported."
        )
      },
    )

  public val encounter: SearchParam<RiskAssessment, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "RiskAssessment.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> listOfNotNull(resource.encounter) },
    )

  public val identifier: SearchParam<RiskAssessment, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "RiskAssessment.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val method: SearchParam<RiskAssessment, CodeableConcept> =
    SearchParam(
      name = "method",
      type = SearchParamType.fromCode("token"),
      expression = "RiskAssessment.method",
      extractor = { resource -> listOfNotNull(resource.method) },
    )

  public val patient: SearchParam<RiskAssessment, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
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
      type = SearchParamType.fromCode("reference"),
      expression = "RiskAssessment.performer",
      target =
        listOf(
          Device::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.performer) },
    )

  public val probability: SearchParam<RiskAssessment, Any> =
    SearchParam(
      name = "probability",
      type = SearchParamType.fromCode("number"),
      expression = "RiskAssessment.prediction.probability.ofType(decimal)",
      extractor = {
        throw NotImplementedError(
          "Search parameter 'probability' has expression 'RiskAssessment.prediction.probability.ofType(decimal)' which is not yet supported."
        )
      },
    )

  public val risk: SearchParam<RiskAssessment, CodeableConcept> =
    SearchParam(
      name = "risk",
      type = SearchParamType.fromCode("token"),
      expression = "RiskAssessment.prediction.qualitativeRisk",
      extractor = { resource -> resource.prediction.mapNotNull { it.qualitativeRisk } },
    )

  public val subject: SearchParam<RiskAssessment, Reference> =
    SearchParam(
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
