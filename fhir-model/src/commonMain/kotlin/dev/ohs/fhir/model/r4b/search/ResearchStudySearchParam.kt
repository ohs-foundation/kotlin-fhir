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
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchStudy] resource type. */
public sealed class ResearchStudySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ResearchStudy): List<T>

  public data object Category : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.category"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.category
  }

  public data object Date : ResearchStudySearchParam<Period>() {
    public override val paramName: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ResearchStudy.period"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Focus : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.focus"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.focus
  }

  public data object Identifier : ResearchStudySearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ResearchStudy): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object Keyword : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.keyword"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.keyword
  }

  public data object Location : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.location"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.location
  }

  public data object Partof : ResearchStudySearchParam<Reference>() {
    public override val paramName: KotlinString = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.partOf"

    public override val target: List<KotlinString> = listOf("ResearchStudy")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.partOf
  }

  public data object Principalinvestigator : ResearchStudySearchParam<Reference>() {
    public override val paramName: KotlinString = "principalinvestigator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.principalInvestigator"

    public override val target: List<KotlinString> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: ResearchStudy): List<Reference> =
      listOfNotNull(resource.principalInvestigator)
  }

  public data object Protocol : ResearchStudySearchParam<Reference>() {
    public override val paramName: KotlinString = "protocol"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.protocol"

    public override val target: List<KotlinString> = listOf("PlanDefinition")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.protocol
  }

  public data object Site : ResearchStudySearchParam<Reference>() {
    public override val paramName: KotlinString = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.site"

    public override val target: List<KotlinString> = listOf("Location")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.site
  }

  public data object Sponsor : ResearchStudySearchParam<Reference>() {
    public override val paramName: KotlinString = "sponsor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.sponsor"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: ResearchStudy): List<Reference> =
      listOfNotNull(resource.sponsor)
  }

  public data object Status : ResearchStudySearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = listOf(resource.status)
  }

  public data object Title : ResearchStudySearchParam<R4bString>() {
    public override val paramName: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ResearchStudy.title"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ResearchStudy): List<R4bString> =
      listOfNotNull(resource.title)
  }

  public companion object {
    /** All search parameters for the ResearchStudy resource type. */
    public val ALL: List<ResearchStudySearchParam<*>> =
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
  }
}
