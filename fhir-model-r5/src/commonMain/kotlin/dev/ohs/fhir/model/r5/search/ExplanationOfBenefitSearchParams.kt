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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Claim
import dev.ohs.fhir.model.r5.Coverage
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.ExplanationOfBenefit
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedPerson
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ExplanationOfBenefit] resource type. */
public object ExplanationOfBenefitSearchParams {
  public val careTeam: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "care-team",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.careTeam.provider",
      target = listOf(Organization::class, PractitionerRole::class, Practitioner::class),
      extractor = { resource -> resource.careTeam.map { it.provider } },
    )

  public val claim: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "claim",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.claim",
      target = listOf(Claim::class),
      extractor = { resource -> listOfNotNull(resource.claim) },
    )

  public val coverage: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "coverage",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.insurance.coverage",
      target = listOf(Coverage::class),
      extractor = { resource -> resource.insurance.map { it.coverage } },
    )

  public val created: SearchParam<ExplanationOfBenefit, DateTime> =
    SearchParam(
      name = "created",
      type = SearchParamType.Date,
      expression = "ExplanationOfBenefit.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val detailUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "detail-udi",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.item.detail.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.detail }.flatMap { it.udi } },
    )

  public val disposition: SearchParam<ExplanationOfBenefit, String> =
    SearchParam(
      name = "disposition",
      type = SearchParamType.String,
      expression = "ExplanationOfBenefit.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val encounter: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "encounter",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.item.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> resource.item.flatMap { it.encounter } },
    )

  public val enterer: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "enterer",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.enterer",
      target =
        listOf(RelatedPerson::class, PractitionerRole::class, Practitioner::class, Patient::class),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val facility: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "facility",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.facility",
      target = listOf(Organization::class, Location::class),
      extractor = { resource -> listOfNotNull(resource.facility) },
    )

  public val identifier: SearchParam<ExplanationOfBenefit, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ExplanationOfBenefit.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val itemUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "item-udi",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.item.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.udi } },
    )

  public val patient: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "patient",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val payee: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "payee",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.payee.party",
      target =
        listOf(
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.payee?.party) },
    )

  public val procedureUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "procedure-udi",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.procedure.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.procedure.flatMap { it.udi } },
    )

  public val provider: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "provider",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.provider",
      target = listOf(Organization::class, PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.provider) },
    )

  public val status: SearchParam<ExplanationOfBenefit, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ExplanationOfBenefit.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subdetailUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SearchParam(
      name = "subdetail-udi",
      type = SearchParamType.Reference,
      expression = "ExplanationOfBenefit.item.detail.subDetail.udi",
      target = listOf(Device::class),
      extractor = { resource ->
        resource.item.flatMap { it.detail }.flatMap { it.subDetail }.flatMap { it.udi }
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<ExplanationOfBenefit, *>> = listOf()

  /**
   * Supported search parameters for the ExplanationOfBenefit resource type. Iterating `all` and
   * calling `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from
   * this list.
   */
  public val all: List<SearchParam<ExplanationOfBenefit, *>> =
    listOf(
      careTeam,
      claim,
      coverage,
      created,
      detailUdi,
      disposition,
      encounter,
      enterer,
      facility,
      identifier,
      itemUdi,
      patient,
      payee,
      procedureUdi,
      provider,
      status,
      subdetailUdi,
    )
}
