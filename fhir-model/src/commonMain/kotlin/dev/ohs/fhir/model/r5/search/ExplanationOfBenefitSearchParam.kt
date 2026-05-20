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
import dev.ohs.fhir.model.r5.ExplanationOfBenefit
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ExplanationOfBenefit] resource type. */
public object ExplanationOfBenefitSearchParam {
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

  public data object CareTeam : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.careTeam.provider"

    public override val target: List<KotlinString> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.careTeam.map { it.provider }
  }

  public data object Claim : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "claim"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.claim"

    public override val target: List<KotlinString> = listOf("Claim")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.claim)
  }

  public data object Coverage : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "coverage"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.insurance.coverage"

    public override val target: List<KotlinString> = listOf("Coverage")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.insurance.map { it.coverage }
  }

  public data object Created : SearchParam<ExplanationOfBenefit, DateTime> {
    public override val paramName: KotlinString = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ExplanationOfBenefit.created"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<DateTime> =
      listOf(resource.created)
  }

  public data object DetailUdi : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "detail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.item.detail.udi"

    public override val target: List<KotlinString> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.item.flatMap { it.detail }.flatMap { it.udi }
  }

  public data object Disposition : SearchParam<ExplanationOfBenefit, R5String> {
    public override val paramName: KotlinString = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ExplanationOfBenefit.disposition"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<R5String> =
      listOfNotNull(resource.disposition)
  }

  public data object Encounter : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.item.encounter"

    public override val target: List<KotlinString> = listOf("Encounter")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.item.flatMap { it.encounter }
  }

  public data object Enterer : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.enterer"

    public override val target: List<KotlinString> =
      listOf("RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.enterer)
  }

  public data object Facility : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.facility"

    public override val target: List<KotlinString> = listOf("Organization", "Location")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.facility)
  }

  public data object Identifier :
    SearchParam<ExplanationOfBenefit, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExplanationOfBenefit.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: ExplanationOfBenefit
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object ItemUdi : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "item-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.item.udi"

    public override val target: List<KotlinString> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.item.flatMap { it.udi }
  }

  public data object Patient : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.patient"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOf(resource.patient)
  }

  public data object Payee : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "payee"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.payee.party"

    public override val target: List<KotlinString> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.payee?.party)
  }

  public data object ProcedureUdi : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "procedure-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.procedure.udi"

    public override val target: List<KotlinString> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.procedure.flatMap { it.udi }
  }

  public data object Provider : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.provider"

    public override val target: List<KotlinString> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.provider)
  }

  public data object Status : SearchParam<ExplanationOfBenefit, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ExplanationOfBenefit.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = listOf(resource.status)
  }

  public data object SubdetailUdi : SearchParam<ExplanationOfBenefit, Reference> {
    public override val paramName: KotlinString = "subdetail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ExplanationOfBenefit.item.detail.subDetail.udi"

    public override val target: List<KotlinString> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.item.flatMap { it.detail }.flatMap { it.subDetail }.flatMap { it.udi }
  }
}
