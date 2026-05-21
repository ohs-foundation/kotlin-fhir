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

import dev.ohs.fhir.model.r4b.Claim
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Device
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
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

/** Search parameters for the [Claim] resource type. */
public object ClaimSearchParam {
  /** All search parameters for the Claim resource type. */
  public val ALL: List<SearchParam<Claim, *>> =
    listOf(
      CareTeam,
      Created,
      DetailUdi,
      Encounter,
      Enterer,
      Facility,
      Identifier,
      Insurer,
      ItemUdi,
      Patient,
      Payee,
      Priority,
      ProcedureUdi,
      Provider,
      Status,
      SubdetailUdi,
      Use,
    )

  public data object CareTeam : SearchParam<Claim, Reference> {
    public override val name: String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.careTeam.provider"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, PractitionerRole::class)

    public override fun extract(resource: Claim): List<Reference> =
      resource.careTeam.map { it.provider }
  }

  public data object Created : SearchParam<Claim, DateTime> {
    public override val name: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Claim.created"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Claim): List<DateTime> = listOf(resource.created)
  }

  public data object DetailUdi : SearchParam<Claim, Reference> {
    public override val name: String = "detail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.detail.udi"

    public override val target: List<KClass<out Resource>> = listOf(Device::class)

    public override fun extract(resource: Claim): List<Reference> =
      resource.item.flatMap { it.detail }.flatMap { it.udi }
  }

  public data object Encounter : SearchParam<Claim, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Encounter::class)

    public override fun extract(resource: Claim): List<Reference> =
      resource.item.flatMap { it.encounter }
  }

  public data object Enterer : SearchParam<Claim, Reference> {
    public override val name: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.enterer"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: Claim): List<Reference> = listOfNotNull(resource.enterer)
  }

  public data object Facility : SearchParam<Claim, Reference> {
    public override val name: String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.facility"

    public override val target: List<KClass<out Resource>> = listOf(Location::class)

    public override fun extract(resource: Claim): List<Reference> = listOfNotNull(resource.facility)
  }

  public data object Identifier : SearchParam<Claim, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Claim): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Insurer : SearchParam<Claim, Reference> {
    public override val name: String = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.insurer"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: Claim): List<Reference> = listOfNotNull(resource.insurer)
  }

  public data object ItemUdi : SearchParam<Claim, Reference> {
    public override val name: String = "item-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.udi"

    public override val target: List<KClass<out Resource>> = listOf(Device::class)

    public override fun extract(resource: Claim): List<Reference> = resource.item.flatMap { it.udi }
  }

  public data object Patient : SearchParam<Claim, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.patient"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: Claim): List<Reference> = listOf(resource.patient)
  }

  public data object Payee : SearchParam<Claim, Reference> {
    public override val name: String = "payee"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.payee.party"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Organization::class,
        dev.ohs.fhir.model.r4b.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: Claim): List<Reference> =
      listOfNotNull(resource.payee?.party)
  }

  public data object Priority : SearchParam<Claim, CodeableConcept> {
    public override val name: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.priority"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Claim): List<CodeableConcept> = listOf(resource.priority)
  }

  public data object ProcedureUdi : SearchParam<Claim, Reference> {
    public override val name: String = "procedure-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.procedure.udi"

    public override val target: List<KClass<out Resource>> = listOf(Device::class)

    public override fun extract(resource: Claim): List<Reference> =
      resource.procedure.flatMap { it.udi }
  }

  public data object Provider : SearchParam<Claim, Reference> {
    public override val name: String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.provider"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Organization::class, PractitionerRole::class)

    public override fun extract(resource: Claim): List<Reference> = listOf(resource.provider)
  }

  public data object Status : SearchParam<Claim, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Claim): List<Any> = listOf(resource.status)
  }

  public data object SubdetailUdi : SearchParam<Claim, Reference> {
    public override val name: String = "subdetail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.detail.subDetail.udi"

    public override val target: List<KClass<out Resource>> = listOf(Device::class)

    public override fun extract(resource: Claim): List<Reference> =
      resource.item.flatMap { it.detail }.flatMap { it.subDetail }.flatMap { it.udi }
  }

  public data object Use : SearchParam<Claim, Any> {
    public override val name: String = "use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.use"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: Claim): List<Any> = listOf(resource.use)
  }
}
