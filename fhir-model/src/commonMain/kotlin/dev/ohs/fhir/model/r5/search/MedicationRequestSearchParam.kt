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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicationRequest] resource type. */
public sealed class MedicationRequestSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicationRequest): List<T>

  public data object Authoredon : MedicationRequestSearchParam<DateTime>() {
    public override val paramName: String = "authoredon"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationRequest.authoredOn"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object Category : MedicationRequestSearchParam<CodeableConcept>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      resource.category
  }

  public data object Code : MedicationRequestSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.medication.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      listOfNotNull(resource.medication.concept)
  }

  public data object ComboDate : MedicationRequestSearchParam<DateTime>() {
    public override val paramName: String = "combo-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationRequest.dosageInstruction.timing.event"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<DateTime> =
      resource.dosageInstruction.mapNotNull { it.timing }.flatMap { it.event }
  }

  public data object Encounter : MedicationRequestSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object GroupIdentifier :
    MedicationRequestSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.groupIdentifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: MedicationRequest
    ): List<dev.ohs.fhir.model.r5.Identifier> = listOfNotNull(resource.groupIdentifier)
  }

  public data object Identifier : MedicationRequestSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: MedicationRequest
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object IntendedDispenser : MedicationRequestSearchParam<Reference>() {
    public override val paramName: String = "intended-dispenser"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.dispenseRequest.dispenser"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.dispenseRequest?.dispenser)
  }

  public data object IntendedPerformer : MedicationRequestSearchParam<Reference>() {
    public override val paramName: String = "intended-performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.performer"

    public override val target: List<String> =
      listOf(
        "HealthcareService",
        "Organization",
        "CareTeam",
        "RelatedPerson",
        "PractitionerRole",
        "DeviceDefinition",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: MedicationRequest): List<Reference> = resource.performer
  }

  public data object IntendedPerformertype : MedicationRequestSearchParam<CodeableConcept>() {
    public override val paramName: String = "intended-performertype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.performerType"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      listOfNotNull(resource.performerType)
  }

  public data object Intent : MedicationRequestSearchParam<Any>() {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.intent"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> = listOf(resource.intent)
  }

  public data object Medication : MedicationRequestSearchParam<Reference>() {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.medication.reference"

    public override val target: List<String> = listOf("Medication")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.medication.reference)
  }

  public data object Patient : MedicationRequestSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Priority : MedicationRequestSearchParam<Any>() {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Requester : MedicationRequestSearchParam<Reference>() {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.requester"

    public override val target: List<String> =
      listOf(
        "Organization",
        "Device",
        "RelatedPerson",
        "PractitionerRole",
        "Practitioner",
        "Patient",
      )

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : MedicationRequestSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> = listOf(resource.status)
  }

  public data object Subject : MedicationRequestSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the MedicationRequest resource type. */
    public val ALL: List<MedicationRequestSearchParam<*>> =
      listOf(
        Authoredon,
        Category,
        Code,
        ComboDate,
        Encounter,
        GroupIdentifier,
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
  }
}
