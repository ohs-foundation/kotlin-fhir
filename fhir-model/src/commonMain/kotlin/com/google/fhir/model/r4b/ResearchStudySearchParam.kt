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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchStudy] resource type. */
public sealed class ResearchStudySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ResearchStudy): List<T>

  public data object Category : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "category"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.category"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Date : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ResearchStudy.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Focus : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "focus"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.focus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Identifier : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Keyword : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.keyword"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Location : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "location"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.location"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Partof : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "partof"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.partOf"

    public override val target: List<String> = listOf("ResearchStudy")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Principalinvestigator : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "principalinvestigator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.principalInvestigator"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Protocol : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "protocol"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.protocol"

    public override val target: List<String> = listOf("PlanDefinition")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Site : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.site"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Sponsor : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "sponsor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.sponsor"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Status : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Title : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ResearchStudy.title"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
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
