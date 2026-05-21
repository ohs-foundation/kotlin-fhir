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
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.MedicationDispense
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

/** Search parameters for the [MedicationDispense] resource type. */
public object MedicationDispenseSearchParam {
  /** All search parameters for the MedicationDispense resource type. */
  public val ALL: List<SearchParam<MedicationDispense, *>> =
    listOf(
      Code,
      Destination,
      Encounter,
      Identifier,
      Location,
      Medication,
      Patient,
      Performer,
      Prescription,
      Receiver,
      Recorded,
      Responsibleparty,
      Status,
      Subject,
      Type,
      Whenhandedover,
      Whenprepared,
    )

  public data object Code : SearchParam<MedicationDispense, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.medication.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationDispense): List<CodeableConcept> =
      listOfNotNull(resource.medication.concept)
  }

  public data object Destination : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.destination"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.destination)
  }

  public data object Encounter : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Encounter::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object Identifier :
    SearchParam<MedicationDispense, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationDispense
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Location : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.location"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Location::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.location)
  }

  public data object Medication : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.medication.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Medication::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.medication.reference)
  }

  public data object Patient : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationDispense.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.performer.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Organization::class,
        Device::class,
        CareTeam::class,
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: MedicationDispense): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object Prescription : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "prescription"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.authorizingPrescription"

    public override val target: List<KClass<out Resource>> = listOf(MedicationRequest::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      resource.authorizingPrescription
  }

  public data object Receiver : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "receiver"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.receiver"

    public override val target: List<KClass<out Resource>> =
      listOf(
        RelatedPerson::class,
        PractitionerRole::class,
        Practitioner::class,
        dev.ohs.fhir.model.r5.Location::class,
        dev.ohs.fhir.model.r5.Patient::class,
      )

    public override fun extract(resource: MedicationDispense): List<Reference> = resource.receiver
  }

  public data object Recorded : SearchParam<MedicationDispense, DateTime> {
    public override val name: String = "recorded"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.recorded"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationDispense): List<DateTime> =
      listOfNotNull(resource.recorded)
  }

  public data object Responsibleparty : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "responsibleparty"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.substitution.responsibleParty"

    public override val target: List<KClass<out Resource>> =
      listOf(Organization::class, PractitionerRole::class, Practitioner::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.substitution?.responsibleParty)
  }

  public data object Status : SearchParam<MedicationDispense, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationDispense): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOf(resource.subject)
  }

  public data object Type : SearchParam<MedicationDispense, CodeableConcept> {
    public override val name: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationDispense): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public data object Whenhandedover : SearchParam<MedicationDispense, DateTime> {
    public override val name: String = "whenhandedover"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.whenHandedOver"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationDispense): List<DateTime> =
      listOfNotNull(resource.whenHandedOver)
  }

  public data object Whenprepared : SearchParam<MedicationDispense, DateTime> {
    public override val name: String = "whenprepared"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationDispense.whenPrepared"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationDispense): List<DateTime> =
      listOfNotNull(resource.whenPrepared)
  }
}
