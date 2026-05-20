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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coverage
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Coverage] resource type. */
public object CoverageSearchParam {
  /** All search parameters for the Coverage resource type. */
  public val ALL: List<SearchParam<Coverage, *>> =
    listOf(
      Beneficiary,
      ClassType,
      ClassValue,
      Dependent,
      Identifier,
      Patient,
      Payor,
      PolicyHolder,
      Status,
      Subscriber,
      Type,
    )

  public data object Beneficiary : SearchParam<Coverage, Reference> {
    public override val paramName: KotlinString = "beneficiary"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.beneficiary"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Coverage): List<Reference> = listOf(resource.beneficiary)
  }

  public data object ClassType : SearchParam<Coverage, CodeableConcept> {
    public override val paramName: KotlinString = "class-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.class.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<CodeableConcept> =
      resource.`class`.map { it.type }
  }

  public data object ClassValue : SearchParam<Coverage, R4bString> {
    public override val paramName: KotlinString = "class-value"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Coverage.class.value"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<R4bString> =
      resource.`class`.map { it.value }
  }

  public data object Dependent : SearchParam<Coverage, R4bString> {
    public override val paramName: KotlinString = "dependent"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "Coverage.dependent"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<R4bString> =
      listOfNotNull(resource.dependent)
  }

  public data object Identifier : SearchParam<Coverage, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Patient : SearchParam<Coverage, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.beneficiary"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: Coverage): List<Reference> = listOf(resource.beneficiary)
  }

  public data object Payor : SearchParam<Coverage, Reference> {
    public override val paramName: KotlinString = "payor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.payor"

    public override val target: List<KotlinString> =
      listOf("Organization", "Patient", "RelatedPerson")

    public override fun extract(resource: Coverage): List<Reference> = resource.payor
  }

  public data object PolicyHolder : SearchParam<Coverage, Reference> {
    public override val paramName: KotlinString = "policy-holder"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.policyHolder"

    public override val target: List<KotlinString> =
      listOf("Organization", "Patient", "RelatedPerson")

    public override fun extract(resource: Coverage): List<Reference> =
      listOfNotNull(resource.policyHolder)
  }

  public data object Status : SearchParam<Coverage, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<Any> = listOf(resource.status)
  }

  public data object Subscriber : SearchParam<Coverage, Reference> {
    public override val paramName: KotlinString = "subscriber"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "Coverage.subscriber"

    public override val target: List<KotlinString> = listOf("Patient", "RelatedPerson")

    public override fun extract(resource: Coverage): List<Reference> =
      listOfNotNull(resource.subscriber)
  }

  public data object Type : SearchParam<Coverage, CodeableConcept> {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "Coverage.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: Coverage): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }
}
