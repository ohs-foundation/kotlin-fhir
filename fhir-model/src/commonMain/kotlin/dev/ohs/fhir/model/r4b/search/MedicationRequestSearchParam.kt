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
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationRequest] resource type. */
public object MedicationRequestSearchParam {
  /** All search parameters for the MedicationRequest resource type. */
  public val ALL: List<SearchParam<MedicationRequest, *>> =
    listOf(
      Authoredon,
      Category,
      Code,
      Date,
      Encounter,
      Identifier,
      IntendedDispenser,
      IntendedPerformer,
      IntendedPerformertype,
      Intent,
      Medication,
      Patient,
      Priority,
      Requester,
      Status,
      Subject,
    )

  public data object Authoredon : SearchParam<MedicationRequest, DateTime> {
    public override val paramName: String = "authoredon"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object Category : SearchParam<MedicationRequest, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      resource.category
  }

  public data object Code : SearchParam<MedicationRequest, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(MedicationRequest.medication as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      listOfNotNull((resource.medication as? MedicationRequest.Medication.CodeableConcept)?.value)
  }

  public data object Date : SearchParam<MedicationRequest, DateTime> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationRequest.dosageInstruction.timing.event"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<DateTime> =
      resource.dosageInstruction.mapNotNull { it.timing }.flatMap { it.event }
  }

  public data object Encounter : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier :
    SearchParam<MedicationRequest, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: MedicationRequest
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object IntendedDispenser : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "intended-dispenser"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.dispenseRequest.performer"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.dispenseRequest?.performer)
  }

  public data object IntendedPerformer : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "intended-performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.performer"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "CareTeam",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.performer)
  }

  public data object IntendedPerformertype : SearchParam<MedicationRequest, CodeableConcept> {
    public override val paramName: String = "intended-performertype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.performerType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      listOfNotNull(resource.performerType)
  }

  public data object Intent : SearchParam<MedicationRequest, Any> {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> = listOf(resource.intent)
  }

  public data object Medication : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(MedicationRequest.medication as Reference)"

    public override val target: List<String> = listOf("Medication")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull((resource.medication as? MedicationRequest.Medication.Reference)?.value)
  }

  public data object Patient : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Priority : SearchParam<MedicationRequest, Any> {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Requester : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.requester"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Organization",
        "Device",
        "Patient",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : SearchParam<MedicationRequest, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOf(resource.subject)
  }
}
