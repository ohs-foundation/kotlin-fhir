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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchStudy] resource type. */
public sealed class ResearchStudySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ResearchStudy): List<T>

  public data object Classifier : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "classifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.classifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Condition : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "condition"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.condition"

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

  public data object Description : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ResearchStudy.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Eligibility : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "eligibility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.recruitment.eligibility"

    public override val target: List<String> = listOf("Group", "EvidenceVariable")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object FocusCode : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "focus-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.focus.concept"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object FocusReference : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "focus-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.focus.reference"

    public override val target: List<String> =
      listOf("MedicinalProductDefinition", "EvidenceVariable", "SubstanceDefinition", "Medication")

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

  public data object Name : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ResearchStudy.name"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object ObjectiveDescription : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "objective-description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "ResearchStudy.objective.description"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object ObjectiveType : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "objective-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.objective.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object PartOf : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.partOf"

    public override val target: List<String> = listOf("ResearchStudy")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Phase : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "phase"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.phase"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object ProgressStatusStateActual : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "progress-status-state-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ResearchStudy.progressStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object ProgressStatusStatePeriod : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "progress-status-state-period"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ResearchStudy.progressStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object ProgressStatusStatePeriodActual : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "progress-status-state-period-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "ResearchStudy.progressStatus"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Protocol : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "protocol"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.protocol"

    public override val target: List<String> = listOf("PlanDefinition")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object RecruitmentActual : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "recruitment-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "ResearchStudy.recruitment.actualNumber"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object RecruitmentTarget : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "recruitment-target"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: String = "ResearchStudy.recruitment.targetNumber"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Region : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "region"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.region"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Site : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "ResearchStudy.site"

    public override val target: List<String> = listOf("Organization", "ResearchStudy", "Location")

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object Status : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = emptyList()
  }

  public data object StudyDesign : ResearchStudySearchParam<Any>() {
    public override val paramName: String = "study-design"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "ResearchStudy.studyDesign"

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
        Classifier,
        Condition,
        Date,
        Description,
        Eligibility,
        FocusCode,
        FocusReference,
        Identifier,
        Keyword,
        Name,
        ObjectiveDescription,
        ObjectiveType,
        PartOf,
        Phase,
        ProgressStatusStateActual,
        ProgressStatusStatePeriod,
        ProgressStatusStatePeriodActual,
        Protocol,
        RecruitmentActual,
        RecruitmentTarget,
        Region,
        Site,
        Status,
        StudyDesign,
        Title,
      )
  }
}
