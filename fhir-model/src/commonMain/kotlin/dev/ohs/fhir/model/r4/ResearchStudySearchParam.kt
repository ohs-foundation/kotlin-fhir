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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchStudy] resource type. */
public sealed class ResearchStudySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ResearchStudy): List<T>

  public data object Category : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.category"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.category
  }

  public data object Date : ResearchStudySearchParam<Period>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ResearchStudy.period"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Focus : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.focus"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.focus
  }

  public data object Identifier : ResearchStudySearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Keyword : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.keyword"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.keyword
  }

  public data object Location : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.location"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.location
  }

  public data object Partof : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.partOf"

    public override val target: List<kotlin.String> = listOf("ResearchStudy")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.partOf
  }

  public data object Principalinvestigator : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "principalinvestigator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.principalInvestigator"

    public override val target: List<kotlin.String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: ResearchStudy): List<Reference> =
      listOfNotNull(resource.principalInvestigator)
  }

  public data object Protocol : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "protocol"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.protocol"

    public override val target: List<kotlin.String> = listOf("PlanDefinition")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.protocol
  }

  public data object Site : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.site"

    public override val target: List<kotlin.String> = listOf("Location")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.site
  }

  public data object Sponsor : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "sponsor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.sponsor"

    public override val target: List<kotlin.String> = listOf("Organization")

    public override fun extract(resource: ResearchStudy): List<Reference> =
      listOfNotNull(resource.sponsor)
  }

  public data object Status : ResearchStudySearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = listOf(resource.status)
  }

  public data object Title : ResearchStudySearchParam<String>() {
    public override val paramName: kotlin.String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ResearchStudy.title"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<String> =
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
