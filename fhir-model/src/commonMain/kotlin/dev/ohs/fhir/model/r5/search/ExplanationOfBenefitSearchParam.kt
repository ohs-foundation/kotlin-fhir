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

import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.ExplanationOfBenefit
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Organization
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
public object ExplanationOfBenefitSearchParam {
  public val CareTeam: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "care-team",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.careTeam.provider",
      target = listOf(Organization::class, PractitionerRole::class, Practitioner::class),
      extractor = { resource -> resource.careTeam.map { it.provider } },
    )

  public val Claim: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "claim",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.claim",
      target = listOf(dev.ohs.fhir.model.r5.Claim::class),
      extractor = { resource -> listOfNotNull(resource.claim) },
    )

  public val Coverage: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "coverage",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.insurance.coverage",
      target = listOf(dev.ohs.fhir.model.r5.Coverage::class),
      extractor = { resource -> resource.insurance.map { it.coverage } },
    )

  public val Created: SearchParam<ExplanationOfBenefit, DateTime> =
    SimpleSearchParam<ExplanationOfBenefit, DateTime>(
      name = "created",
      type = SearchParamType.fromCode("date"),
      expression = "ExplanationOfBenefit.created",
      extractor = { resource -> listOf(resource.created) },
    )

  public val DetailUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "detail-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.item.detail.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.detail }.flatMap { it.udi } },
    )

  public val Disposition: SearchParam<ExplanationOfBenefit, String> =
    SimpleSearchParam<ExplanationOfBenefit, String>(
      name = "disposition",
      type = SearchParamType.fromCode("string"),
      expression = "ExplanationOfBenefit.disposition",
      extractor = { resource -> listOfNotNull(resource.disposition) },
    )

  public val Encounter: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "encounter",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.item.encounter",
      target = listOf(dev.ohs.fhir.model.r5.Encounter::class),
      extractor = { resource -> resource.item.flatMap { it.encounter } },
    )

  public val Enterer: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "enterer",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.enterer",
      target =
        listOf(
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.enterer) },
    )

  public val Facility: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "facility",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.facility",
      target = listOf(Organization::class, Location::class),
      extractor = { resource -> listOfNotNull(resource.facility) },
    )

  public val Identifier: SearchParam<ExplanationOfBenefit, Identifier> =
    SimpleSearchParam<ExplanationOfBenefit, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ExplanationOfBenefit.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ItemUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "item-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.item.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.item.flatMap { it.udi } },
    )

  public val Patient: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "patient",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.patient",
      target = listOf(dev.ohs.fhir.model.r5.Patient::class),
      extractor = { resource -> listOf(resource.patient) },
    )

  public val Payee: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "payee",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.payee.party",
      target =
        listOf(
          Organization::class,
          RelatedPerson::class,
          PractitionerRole::class,
          Practitioner::class,
          dev.ohs.fhir.model.r5.Patient::class,
        ),
      extractor = { resource -> listOfNotNull(resource.payee?.party) },
    )

  public val ProcedureUdi: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "procedure-udi",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.procedure.udi",
      target = listOf(Device::class),
      extractor = { resource -> resource.procedure.flatMap { it.udi } },
    )

  public val Provider: SearchParam<ExplanationOfBenefit, Reference> =
    SimpleSearchParam<ExplanationOfBenefit, Reference>(
      name = "provider",
      type = SearchParamType.fromCode("reference"),
      expression = "ExplanationOfBenefit.provider",
      target = listOf(Organization::class, PractitionerRole::class, Practitioner::class),
      extractor = { resource -> listOfNotNull(resource.provider) },
    )

  public val Status: SearchParam<ExplanationOfBenefit, Any> =
    SimpleSearchParam<ExplanationOfBenefit, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ExplanationOfBenefit.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val SubdetailUdi: SearchParam<ExplanationOfBenefit, Reference> =
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
  public val ALL: List<SearchParam<ExplanationOfBenefit, *>> =
    listOf(
      CareTeam,
      Claim,
      Coverage,
      Created,
      DetailUdi,
      Disposition,
      Encounter,
      Enterer,
      Facility,
      Identifier,
      ItemUdi,
      Patient,
      Payee,
      ProcedureUdi,
      Provider,
      Status,
      SubdetailUdi,
    )
}
