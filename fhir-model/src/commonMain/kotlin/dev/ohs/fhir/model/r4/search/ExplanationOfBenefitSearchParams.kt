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

import dev.ohs.fhir.model.r4.Claim
import dev.ohs.fhir.model.r4.Coverage
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Encounter
import dev.ohs.fhir.model.r4.ExplanationOfBenefit
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Location
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ExplanationOfBenefit] resource type. */
public object ExplanationOfBenefitSearchParams {
  public val careTeam: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "care-team",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.careTeam.provider",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> resource.careTeam.map { it.provider } },
    )

  public val claim: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "claim",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.claim",
      target = listOf(Claim::class),
      extractor = { resource -> listOfNotNull(resource.claim) },
    )

  public val coverage: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "coverage",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.insurance.coverage",
      target = listOf(Coverage::class),
      extractor = { resource -> resource.insurance.map { it.coverage } },
    )

  public val created: SearchParam<ExplanationOfBenefit, DateTime> =
    SimpleSearchParam<ExplanationOfBenefit, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "ExplanationOfBenefit.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val detailUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "detail-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.item.detail.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.detail }.flatMap { it.udi } },
    )

  public val disposition: SearchParam<ExplanationOfBenefit, String> =
    SimpleSearchParam<ExplanationOfBenefit, String>(
      name = "disposition",
      type = SearchParamType.fromCode("string"),
      expression = "ExplanationOfBenefit.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val encounter: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.item.encounter",
      target = listOf(Encounter::class),
      extractor = { resource -> resource.item.flatMap { it.encounter } },
    )

  public val enterer: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "enterer",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.enterer",
      target = listOf(Practitioner::class, PractitionerRole::class),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val facility: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "facility",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.facility",
      target = listOf(Location::class),
      extractor = { resource -> listOfNotNull(resource.facility) },
    )

  public val identifier: SearchParam<ExplanationOfBenefit, Identifier> =
    SimpleSearchParam<ExplanationOfBenefit, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ExplanationOfBenefit.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val itemUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "item-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.item.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.udi } },
    )

  public val patient: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.patient",
      target = listOf(Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val payee: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "payee",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.payee.party",
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

  public val procedureUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "procedure-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.procedure.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.procedure.flatMap { it.udi } },
    )

  public val provider: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "provider",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.provider",
      target = listOf(Practitioner::class, Organization::class, PractitionerRole::class),
      extractor = { resource -> listOf(resource.provider) },
    )

  public val status: SearchParam<ExplanationOfBenefit, Any> =
    SimpleSearchParam<ExplanationOfBenefit, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ExplanationOfBenefit.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val subdetailUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "subdetail-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.item.detail.subDetail.udi",
      target = listOf(Device::class),
      extractor = { resource ->
        resource.item.flatMap { it.detail }.flatMap { it.subDetail }.flatMap { it.udi }
      },
    )

  /** All search parameters for the ExplanationOfBenefit resource type. */
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
