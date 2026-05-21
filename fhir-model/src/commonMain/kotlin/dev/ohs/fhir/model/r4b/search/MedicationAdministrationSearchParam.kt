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
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.EpisodeOfCare
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.MedicationAdministration
import dev.ohs.fhir.model.r4b.MedicationRequest
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [MedicationAdministration] resource type. */
public object MedicationAdministrationSearchParam {
  /** All search parameters for the MedicationAdministration resource type. */
  public val ALL: List<SearchParam<MedicationAdministration, *>> =
    listOf(
      Code,
      Context,
      Device,
      EffectiveTime,
      Identifier,
      Medication,
      Patient,
      Performer,
      ReasonGiven,
      ReasonNotGiven,
      Request,
      Status,
      Subject,
    )

  public data object Code : SearchParam<MedicationAdministration, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "(MedicationAdministration.medication as CodeableConcept)"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<CodeableConcept> =
      listOfNotNull(
        (resource.medication as? MedicationAdministration.Medication.CodeableConcept)?.value
      )
  }

  public data object Context : SearchParam<MedicationAdministration, Reference> {
    public override val name: String = "context"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.context"

    public override val target: List<KClass<out Resource>> =
      listOf(EpisodeOfCare::class, Encounter::class)

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOfNotNull(resource.context)
  }

  public data object Device : SearchParam<MedicationAdministration, Reference> {
    public override val name: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.device"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Device::class)

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      resource.device
  }

  public data object EffectiveTime :
    SearchParam<MedicationAdministration, MedicationAdministration.Effective> {
    public override val name: String = "effective-time"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "MedicationAdministration.effective"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationAdministration
    ): List<MedicationAdministration.Effective> = listOf(resource.effective)
  }

  public data object Identifier :
    SearchParam<MedicationAdministration, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicationAdministration
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Medication : SearchParam<MedicationAdministration, Reference> {
    public override val name: String = "medication"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "(MedicationAdministration.medication as Reference)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Medication::class)

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOfNotNull((resource.medication as? MedicationAdministration.Medication.Reference)?.value)
  }

  public data object Patient : SearchParam<MedicationAdministration, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "MedicationAdministration.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Performer : SearchParam<MedicationAdministration, Reference> {
    public override val name: String = "performer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.performer.actor"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        dev.ohs.fhir.model.r4b.Device::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      resource.performer.map { it.actor }
  }

  public data object ReasonGiven : SearchParam<MedicationAdministration, CodeableConcept> {
    public override val name: String = "reason-given"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.reasonCode"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<CodeableConcept> =
      resource.reasonCode
  }

  public data object ReasonNotGiven : SearchParam<MedicationAdministration, CodeableConcept> {
    public override val name: String = "reason-not-given"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.statusReason"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<CodeableConcept> =
      resource.statusReason
  }

  public data object Request : SearchParam<MedicationAdministration, Reference> {
    public override val name: String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.request"

    public override val target: List<KClass<out Resource>> = listOf(MedicationRequest::class)

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOfNotNull(resource.request)
  }

  public data object Status : SearchParam<MedicationAdministration, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicationAdministration.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicationAdministration): List<Any> =
      listOf(resource.status)
  }

  public data object Subject : SearchParam<MedicationAdministration, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicationAdministration.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: MedicationAdministration): List<Reference> =
      listOf(resource.subject)
  }
}
