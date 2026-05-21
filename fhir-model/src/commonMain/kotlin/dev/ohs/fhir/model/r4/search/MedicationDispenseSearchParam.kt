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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.EpisodeOfCare
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.MedicationDispense
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

/** Search parameters for the [MedicationDispense] resource type. */
public object MedicationDispenseSearchParam {
  /** All search parameters for the MedicationDispense resource type. */
  public val ALL: List<SearchParam<MedicationDispense, *>> =
    listOf(
      Code,
      Context,
      Destination,
      Identifier,
      Medication,
      Patient,
      Performer,
      Prescription,
      Receiver,
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

    public override val expression: String = "(MedicationDispense.medication as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationDispense): List<CodeableConcept> =
      listOfNotNull((resource.medication as? MedicationDispense.Medication.CodeableConcept)?.value)
  }

  public data object Context : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.context"

    public override val target: List<KClass<out Resource>> =
      listOf(EpisodeOfCare::class, Encounter::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.context)
  }

  public data object Destination : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "destination"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.destination"

    public override val target: List<KClass<out Resource>> = listOf(Location::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.destination)
  }

  public data object Identifier :
    SearchParam<MedicationDispense, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationDispense.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationDispense
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Medication : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(MedicationDispense.medication as Reference)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Medication::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull((resource.medication as? MedicationDispense.Medication.Reference)?.value)
  }

  public data object Patient : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationDispense.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class, Group::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.performer.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
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
      listOf(Practitioner::class, dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: MedicationDispense): List<Reference> = resource.receiver
  }

  public data object Responsibleparty : SearchParam<MedicationDispense, Reference> {
    public override val name: String = "responsibleparty"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationDispense.substitution.responsibleParty"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      resource.substitution?.responsibleParty ?: emptyList()
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
      listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: MedicationDispense): List<Reference> =
      listOfNotNull(resource.subject)
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
