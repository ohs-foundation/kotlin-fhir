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
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.Patient
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Claim] resource type. */
public object ClaimSearchParams {
  public val careTeam: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "care-team",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.careTeam.provider",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> resource.careTeam.map { it.provider } },
    )

  public val created: SearchParam<Claim, DateTime> =
    SearchParam<Claim, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "Claim.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val detailUdi: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "detail-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.item.detail.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.detail }.flatMap { it.udi } },
    )

  public val encounter: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.item.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> resource.item.flatMap { it.encounter } },
    )

  public val enterer: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "enterer",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.enterer",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val facility: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "facility",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.facility",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.facility) },
    )

  public val identifier: SearchParam<Claim, Identifier> =
    SearchParam<Claim, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Claim.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val insurer: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "insurer",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.insurer) },
    )

  public val itemUdi: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "item-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.item.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.udi } },
    )

  public val patient: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val payee: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "payee",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.payee.party",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          Patient::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.payee?.party) },
    )

  public val priority: SearchParam<Claim, CodeableConcept> =
    SearchParam<Claim, CodeableConcept>(
      name = "priority",
      type = SearchParamType.fromCode("token"),
      expression = "Claim.priority",
      extractor = { resource -> listOf(resource.priority) },
    )

  public val procedureUdi: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "procedure-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.procedure.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.procedure.flatMap { it.udi } },
    )

  public val provider: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "provider",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.provider",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOf(resource.provider) },
    )

  public val status: SearchParam<Claim, Any> =
    SearchParam<Claim, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "Claim.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subdetailUdi: SearchParam<Claim, Reference> =
    SearchParam<Claim, Reference>(
      name = "subdetail-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "Claim.item.detail.subDetail.udi",
      target = listOf(Device::class),
      extractor = { resource ->
        resource.item.flatMap { it.detail }.flatMap { it.subDetail }.flatMap { it.udi }
      },
    )

  public val use: SearchParam<Claim, Any> =
    SearchParam<Claim, Any>(
      name = "use",
      type = SearchParamType.fromCode("token"),
      expression = "Claim.use",
      extractor = { resource -> listOf(resource.use) },
    )

  /** All search parameters for the Claim resource type. */
  public val all: List<SearchParam<Claim, *>> =
    listOf(
      careTeam,
      created,
      detailUdi,
      encounter,
      enterer,
      facility,
      identifier,
      insurer,
      itemUdi,
      patient,
      payee,
      priority,
      procedureUdi,
      provider,
      status,
      subdetailUdi,
      use,
    )
}
