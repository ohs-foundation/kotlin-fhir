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

import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.MedicationRequest
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

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
    public override val name: String = "authoredon"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationRequest.authoredOn"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object Category : SearchParam<MedicationRequest, CodeableConcept> {
    public override val name: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      resource.category
  }

  public data object Code : SearchParam<MedicationRequest, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(MedicationRequest.medication as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      listOfNotNull((resource.medication as? MedicationRequest.Medication.CodeableConcept)?.value)
  }

  public data object Date : SearchParam<MedicationRequest, DateTime> {
    public override val name: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationRequest.dosageInstruction.timing.event"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<DateTime> =
      resource.dosageInstruction.mapNotNull { it.timing }.flatMap { it.event }
  }

  public data object Encounter : SearchParam<MedicationRequest, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Encounter::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier : SearchParam<MedicationRequest, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationRequest
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object IntendedDispenser : SearchParam<MedicationRequest, Reference> {
    public override val name: String = "intended-dispenser"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.dispenseRequest.performer"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.dispenseRequest?.performer)
  }

  public data object IntendedPerformer : SearchParam<MedicationRequest, Reference> {
    public override val name: String = "intended-performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.performer"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        CareTeam::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.performer)
  }

  public data object IntendedPerformertype : SearchParam<MedicationRequest, CodeableConcept> {
    public override val name: String = "intended-performertype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.performerType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      listOfNotNull(resource.performerType)
  }

  public data object Intent : SearchParam<MedicationRequest, Any> {
    public override val name: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.intent"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> = listOf(resource.intent)
  }

  public data object Medication : SearchParam<MedicationRequest, Reference> {
    public override val name: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(MedicationRequest.medication as Reference)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Medication::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull((resource.medication as? MedicationRequest.Medication.Reference)?.value)
  }

  public data object Patient : SearchParam<MedicationRequest, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Priority : SearchParam<MedicationRequest, Any> {
    public override val name: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.priority"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Requester : SearchParam<MedicationRequest, Reference> {
    public override val name: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.requester"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : SearchParam<MedicationRequest, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<MedicationRequest, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOf(resource.subject)
  }
}
