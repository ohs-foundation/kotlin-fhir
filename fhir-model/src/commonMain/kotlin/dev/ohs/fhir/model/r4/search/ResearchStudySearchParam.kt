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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.ResearchStudy
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [ResearchStudy] resource type. */
public object ResearchStudySearchParam {
  /** All search parameters for the ResearchStudy resource type. */
  public val ALL: List<SearchParam<ResearchStudy, *>> =
    listOf(
      Category,
      Date,
      Focus,
      Identifier,
      Keyword,
      Location,
      Partof,
      Principalinvestigator,
      Protocol,
      Site,
      Sponsor,
      Status,
      Title,
    )

  public data object Category : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.category"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.category
  }

  public data object Date : SearchParam<ResearchStudy, Period> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ResearchStudy.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Focus : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.focus"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.focus
  }

  public data object Identifier : SearchParam<ResearchStudy, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Keyword : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.keyword"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.keyword
  }

  public data object Location : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.location"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.location
  }

  public data object Partof : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.partOf"

    public override val target: List<KClass<out Resource>> = listOf(ResearchStudy::class)

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.partOf
  }

  public data object Principalinvestigator : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "principalinvestigator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.principalInvestigator"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, PractitionerRole::class)

    public override fun extract(resource: ResearchStudy): List<Reference> =
      listOfNotNull(resource.principalInvestigator)
  }

  public data object Protocol : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "protocol"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.protocol"

    public override val target: List<KClass<out Resource>> = listOf(PlanDefinition::class)

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.protocol
  }

  public data object Site : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.site"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Location::class)

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.site
  }

  public data object Sponsor : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "sponsor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.sponsor"

    public override val target: List<KClass<out Resource>> = listOf(Organization::class)

    public override fun extract(resource: ResearchStudy): List<Reference> =
      listOfNotNull(resource.sponsor)
  }

  public data object Status : SearchParam<ResearchStudy, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = listOf(resource.status)
  }

  public data object Title : SearchParam<ResearchStudy, R4String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ResearchStudy.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<R4String> =
      listOfNotNull(resource.title)
  }
}
