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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coverage
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Coverage] resource type. */
public sealed class CoverageSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Coverage): List<T>

  public data object Beneficiary : CoverageSearchParam<Reference>() {
    public override val paramName: KotlinString = "beneficiary"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.beneficiary"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Coverage): List<Reference> = listOf(resource.beneficiary)
  }

  public data object ClassType : CoverageSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "class-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.class.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<CodeableConcept> =
      resource.`class`.map { it.type }
  }

  public data object ClassValue : CoverageSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "class-value"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.class.value"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.`class`.map { it.value }
  }

  public data object Dependent : CoverageSearchParam<R5String>() {
    public override val paramName: KotlinString = "dependent"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Coverage.dependent"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<R5String> =
      listOfNotNull(resource.dependent)
  }

  public data object Identifier : CoverageSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Insurer : CoverageSearchParam<Reference>() {
    public override val paramName: KotlinString = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.insurer"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: Coverage): List<Reference> =
      listOfNotNull(resource.insurer)
  }

  public data object Patient : CoverageSearchParam<Reference>() {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.beneficiary"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Coverage): List<Reference> = listOf(resource.beneficiary)
  }

  public data object PaymentbyParty : CoverageSearchParam<Reference>() {
    public override val paramName: KotlinString = "paymentby-party"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.paymentBy.party"

    public override val target: List<KotlinString> =
      listOf("Organization", "RelatedPerson", "Patient")

    public override fun extract(resource: Coverage): List<Reference> =
      resource.paymentBy.map { it.party }
  }

  public data object PolicyHolder : CoverageSearchParam<Reference>() {
    public override val paramName: KotlinString = "policy-holder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.policyHolder"

    public override val target: List<KotlinString> =
      listOf("Organization", "RelatedPerson", "Patient")

    public override fun extract(resource: Coverage): List<Reference> =
      listOfNotNull(resource.policyHolder)
  }

  public data object Status : CoverageSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = listOf(resource.status)
  }

  public data object Subscriber : CoverageSearchParam<Reference>() {
    public override val paramName: KotlinString = "subscriber"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.subscriber"

    public override val target: List<KotlinString> = listOf("RelatedPerson", "Patient")

    public override fun extract(resource: Coverage): List<Reference> =
      listOfNotNull(resource.subscriber)
  }

  public data object Subscriberid : CoverageSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "subscriberid"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.subscriberId"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.subscriberId
  }

  public data object Type : CoverageSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public companion object {
    /** All search parameters for the Coverage resource type. */
    public val ALL: List<CoverageSearchParam<*>> =
      listOf(
        Beneficiary,
        ClassType,
        ClassValue,
        Dependent,
        Identifier,
        Insurer,
        Patient,
        PaymentbyParty,
        PolicyHolder,
        Status,
        Subscriber,
        Subscriberid,
        Type,
      )
  }
}
