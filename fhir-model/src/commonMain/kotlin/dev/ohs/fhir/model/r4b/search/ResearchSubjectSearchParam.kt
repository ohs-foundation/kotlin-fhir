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

import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.ResearchSubject
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchSubject] resource type. */
public object ResearchSubjectSearchParam {
  /** All search parameters for the ResearchSubject resource type. */
  public val ALL: List<SearchParam<ResearchSubject, *>> =
    listOf(Date, Identifier, Individual, Patient, Status, Study)

  public data object Date : SearchParam<ResearchSubject, Period> {
    public override val paramName: String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "ResearchSubject.period"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchSubject): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Identifier : SearchParam<ResearchSubject, dev.ohs.fhir.model.r4b.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchSubject.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: ResearchSubject
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Individual : SearchParam<ResearchSubject, Reference> {
    public override val paramName: String = "individual"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchSubject.individual"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ResearchSubject): List<Reference> =
      listOf(resource.individual)
  }

  public data object Patient : SearchParam<ResearchSubject, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchSubject.individual"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: ResearchSubject): List<Reference> =
      listOf(resource.individual)
  }

  public data object Status : SearchParam<ResearchSubject, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchSubject.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchSubject): List<Any> = listOf(resource.status)
  }

  public data object Study : SearchParam<ResearchSubject, Reference> {
    public override val paramName: String = "study"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchSubject.study"

    public override val target: List<String> = listOf("ResearchStudy")

    public override fun extract(resource: ResearchSubject): List<Reference> = listOf(resource.study)
  }
}
