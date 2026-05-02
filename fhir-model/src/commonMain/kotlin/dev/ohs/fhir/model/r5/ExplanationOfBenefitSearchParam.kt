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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ExplanationOfBenefit] resource type. */
public sealed class ExplanationOfBenefitSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ExplanationOfBenefit): List<T>

  public data object CareTeam : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.careTeam.provider"

    public override val target: List<kotlin.String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.careTeam.map { it.provider }
  }

  public data object Claim : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "claim"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.claim"

    public override val target: List<kotlin.String> = listOf("Claim")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.claim)
  }

  public data object Coverage : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "coverage"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.insurance.coverage"

    public override val target: List<kotlin.String> = listOf("Coverage")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.insurance.map { it.coverage }
  }

  public data object Created : ExplanationOfBenefitSearchParam<DateTime>() {
    public override val paramName: kotlin.String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ExplanationOfBenefit.created"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<DateTime> =
      listOf(resource.created)
  }

  public data object DetailUdi : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "detail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.item.detail.udi"

    public override val target: List<kotlin.String> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.item.flatMap { it.detail }.flatMap { it.udi }
  }

  public data object Disposition : ExplanationOfBenefitSearchParam<String>() {
    public override val paramName: kotlin.String = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ExplanationOfBenefit.disposition"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<String> =
      listOfNotNull(resource.disposition)
  }

  public data object Encounter : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.item.encounter"

    public override val target: List<kotlin.String> = listOf("Encounter")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.item.flatMap { it.encounter }
  }

  public data object Enterer : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.enterer"

    public override val target: List<kotlin.String> =
      listOf("RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.enterer)
  }

  public data object Facility : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.facility"

    public override val target: List<kotlin.String> = listOf("Organization", "Location")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.facility)
  }

  public data object Identifier :
    ExplanationOfBenefitSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ExplanationOfBenefit.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(
      resource: ExplanationOfBenefit
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object ItemUdi : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "item-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.item.udi"

    public override val target: List<kotlin.String> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.item.flatMap { it.udi }
  }

  public data object Patient : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.patient"

    public override val target: List<kotlin.String> = listOf("Patient")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOf(resource.patient)
  }

  public data object Payee : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "payee"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.payee.party"

    public override val target: List<kotlin.String> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.payee?.party)
  }

  public data object ProcedureUdi : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "procedure-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.procedure.udi"

    public override val target: List<kotlin.String> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.procedure.flatMap { it.udi }
  }

  public data object Provider : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.provider"

    public override val target: List<kotlin.String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      listOfNotNull(resource.provider)
  }

  public data object Status : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ExplanationOfBenefit.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = listOf(resource.status)
  }

  public data object SubdetailUdi : ExplanationOfBenefitSearchParam<Reference>() {
    public override val paramName: kotlin.String = "subdetail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ExplanationOfBenefit.item.detail.subDetail.udi"

    public override val target: List<kotlin.String> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Reference> =
      resource.item.flatMap { it.detail }.flatMap { it.subDetail }.flatMap { it.udi }
  }

  public companion object {
    /** All search parameters for the ExplanationOfBenefit resource type. */
    public val ALL: List<ExplanationOfBenefitSearchParam<*>> =
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
}
