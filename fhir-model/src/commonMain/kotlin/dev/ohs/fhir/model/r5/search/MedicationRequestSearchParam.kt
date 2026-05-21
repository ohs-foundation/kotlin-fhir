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

import dev.ohs.fhir.model.r5.CareTeam
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.DeviceDefinition
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.MedicationRequest
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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

  public data object Authoredon : SearchParam<MedicationRequest, DateTime> {
    public override val paramName: String = "authoredon"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationRequest.authoredOn"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object Category : SearchParam<MedicationRequest, CodeableConcept> {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      resource.category
  }

  public data object Code : SearchParam<MedicationRequest, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.medication.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      listOfNotNull(resource.medication.concept)
  }

  public data object ComboDate : SearchParam<MedicationRequest, DateTime> {
    public override val paramName: String = "combo-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationRequest.dosageInstruction.timing.event"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<DateTime> =
      resource.dosageInstruction.mapNotNull { it.timing }.flatMap { it.event }
  }

  public data object Encounter : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Encounter::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object GroupIdentifier :
    SearchParam<MedicationRequest, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.groupIdentifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationRequest
    ): List<dev.ohs.fhir.model.r5.Identifier> = listOfNotNull(resource.groupIdentifier)
  }

  public data object Identifier : SearchParam<MedicationRequest, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationRequest
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object IntendedDispenser : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "intended-dispenser"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.dispenseRequest.dispenser"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.dispenseRequest?.dispenser)
  }

  public data object IntendedPerformer : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "intended-performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.performer"

    public override val target: List<KClass<out Resource>> =
      listOf(
        HealthcareService::class,
        Organization::class,
        CareTeam::class,
        RelatedPerson::class,
        PractitionerRole::class,
        DeviceDefinition::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: MedicationRequest): List<Reference> = resource.performer
  }

  public data object IntendedPerformertype : SearchParam<MedicationRequest, CodeableConcept> {
    public override val paramName: String = "intended-performertype"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.performerType"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<CodeableConcept> =
      listOfNotNull(resource.performerType)
  }

  public data object Intent : SearchParam<MedicationRequest, Any> {
    public override val paramName: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.intent"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> = listOf(resource.intent)
  }

  public data object Medication : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.medication.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Medication::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.medication.reference)
  }

  public data object Patient : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Priority : SearchParam<MedicationRequest, Any> {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.priority"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Requester : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "requester"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.requester"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Organization::class,
        Device::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOfNotNull(resource.requester)
  }

  public data object Status : SearchParam<MedicationRequest, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationRequest.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationRequest): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<MedicationRequest, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationRequest.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: MedicationRequest): List<Reference> =
      listOf(resource.subject)
  }
}
