/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ExplanationOfBenefit] resource type. */
public sealed class ExplanationOfBenefitSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ExplanationOfBenefit): List<T>

  public data object CareTeam : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.careTeam.provider"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Claim : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "claim"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.claim"

    public override val target: List<String> = listOf("Claim")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Coverage : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "coverage"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.insurance.coverage"

    public override val target: List<String> = listOf("Coverage")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Created : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ExplanationOfBenefit.created"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object DetailUdi : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "detail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.item.detail.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Disposition : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ExplanationOfBenefit.disposition"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Encounter : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.item.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Enterer : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.enterer"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Facility : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.facility"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Identifier : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ExplanationOfBenefit.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object ItemUdi : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "item-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.item.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Patient : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Payee : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "payee"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.payee.party"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object ProcedureUdi : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "procedure-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.procedure.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Provider : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.provider"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object Status : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ExplanationOfBenefit.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
  }

  public data object SubdetailUdi : ExplanationOfBenefitSearchParam<Any>() {
    public override val paramName: String = "subdetail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ExplanationOfBenefit.item.detail.subDetail.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: ExplanationOfBenefit): List<Any> = emptyList()
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
