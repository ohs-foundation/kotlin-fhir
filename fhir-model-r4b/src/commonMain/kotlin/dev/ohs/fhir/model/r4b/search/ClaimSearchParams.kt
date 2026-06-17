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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

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
    SearchParam(
      name = "care-team",
      type = SearchParamType.Reference,
      expression = "Claim.careTeam.provider",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> resource.careTeam.map { it.provider } },
    )

  public val created: SearchParam<Claim, DateTime> =
    SearchParam(
      name = "created",
      type = SearchParamType.Date,
      expression = "Claim.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val detailUdi: SearchParam<Claim, Reference> =
    SearchParam(
      name = "detail-udi",
      type = SearchParamType.Reference,
      expression = "Claim.item.detail.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.detail }.flatMap { it.udi } },
    )

  public val encounter: SearchParam<Claim, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "Claim.item.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> resource.item.flatMap { it.encounter } },
    )

  public val enterer: SearchParam<Claim, Reference> =
    SearchParam(
      name = "enterer",
      type = SearchParamType.Reference,
      expression = "Claim.enterer",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val facility: SearchParam<Claim, Reference> =
    SearchParam(
      name = "facility",
      type = SearchParamType.Reference,
      expression = "Claim.facility",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.facility) },
    )

  public val identifier: SearchParam<Claim, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Claim.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val insurer: SearchParam<Claim, Reference> =
    SearchParam(
      name = "insurer",
      type = SearchParamType.Reference,
      expression = "Claim.insurer",
      target = listOf(Organization::class),
      extractor = { resource -> listOfNotNull(resource.insurer) },
    )

  public val itemUdi: SearchParam<Claim, Reference> =
    SearchParam(
      name = "item-udi",
      type = SearchParamType.Reference,
      expression = "Claim.item.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.udi } },
    )

  public val patient: SearchParam<Claim, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "Claim.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val payee: SearchParam<Claim, Reference> =
    SearchParam(
      name = "payee",
      type = SearchParamType.Reference,
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
    SearchParam(
      name = "priority",
      type = SearchParamType.Token,
      expression = "Claim.priority",
      extractor = { resource -> listOf(resource.priority) },
    )

  public val procedureUdi: SearchParam<Claim, Reference> =
    SearchParam(
      name = "procedure-udi",
      type = SearchParamType.Reference,
      expression = "Claim.procedure.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.procedure.flatMap { it.udi } },
    )

  public val provider: SearchParam<Claim, Reference> =
    SearchParam(
      name = "provider",
      type = SearchParamType.Reference,
      expression = "Claim.provider",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOf(resource.provider) },
    )

  public val status: SearchParam<Claim, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "Claim.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subdetailUdi: SearchParam<Claim, Reference> =
    SearchParam(
      name = "subdetail-udi",
      type = SearchParamType.Reference,
      expression = "Claim.item.detail.subDetail.udi",
      target = listOf(Device::class),
      extractor = { resource ->
        resource.item.flatMap { it.detail }.flatMap { it.subDetail }.flatMap { it.udi }
      },
    )

  public val use: SearchParam<Claim, Any> =
    SearchParam(
      name = "use",
      type = SearchParamType.Token,
      expression = "Claim.use",
      extractor = { resource -> listOf(resource.use) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<Claim, *>> = listOf()

  /**
   * Supported search parameters for the Claim resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
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
