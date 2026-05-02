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

/** Search parameters for the [ResearchStudy] resource type. */
public sealed class ResearchStudySearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: ResearchStudy): List<T>

  public data object Classifier : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "classifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.classifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      resource.classifier
  }

  public data object Condition : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "condition"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.condition"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.condition
  }

  public data object Date : ResearchStudySearchParam<Period>() {
    public override val paramName: kotlin.String = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: kotlin.String = "ResearchStudy.period"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Description : ResearchStudySearchParam<Markdown>() {
    public override val paramName: kotlin.String = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ResearchStudy.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Eligibility : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "eligibility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.recruitment.eligibility"

    public override val target: List<kotlin.String> = listOf("Group", "EvidenceVariable")

    public override fun extract(resource: ResearchStudy): List<Reference> =
      listOfNotNull(resource.recruitment?.eligibility)
  }

  public data object FocusCode : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "focus-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.focus.concept"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      resource.focus.mapNotNull { it.concept }
  }

  public data object FocusReference : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "focus-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.focus.reference"

    public override val target: List<kotlin.String> =
      listOf("MedicinalProductDefinition", "EvidenceVariable", "SubstanceDefinition", "Medication")

    public override fun extract(resource: ResearchStudy): List<Reference> =
      resource.focus.mapNotNull { it.reference }
  }

  public data object Identifier : ResearchStudySearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: kotlin.String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.identifier"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Keyword : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.keyword"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.keyword
  }

  public data object Name : ResearchStudySearchParam<String>() {
    public override val paramName: kotlin.String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ResearchStudy.name"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<String> =
      listOfNotNull(resource.name)
  }

  public data object ObjectiveDescription : ResearchStudySearchParam<Markdown>() {
    public override val paramName: kotlin.String = "objective-description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: kotlin.String = "ResearchStudy.objective.description"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Markdown> =
      resource.objective.mapNotNull { it.description }
  }

  public data object ObjectiveType : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "objective-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.objective.type"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      resource.objective.mapNotNull { it.type }
  }

  public data object PartOf : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.partOf"

    public override val target: List<kotlin.String> = listOf("ResearchStudy")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.partOf
  }

  public data object Phase : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "phase"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.phase"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      listOfNotNull(resource.phase)
  }

  public data object ProgressStatusStateActual :
    ResearchStudySearchParam<ResearchStudy.ProgressStatus>() {
    public override val paramName: kotlin.String = "progress-status-state-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ResearchStudy.progressStatus"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<ResearchStudy.ProgressStatus> =
      resource.progressStatus
  }

  public data object ProgressStatusStatePeriod :
    ResearchStudySearchParam<ResearchStudy.ProgressStatus>() {
    public override val paramName: kotlin.String = "progress-status-state-period"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ResearchStudy.progressStatus"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<ResearchStudy.ProgressStatus> =
      resource.progressStatus
  }

  public data object ProgressStatusStatePeriodActual :
    ResearchStudySearchParam<ResearchStudy.ProgressStatus>() {
    public override val paramName: kotlin.String = "progress-status-state-period-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: kotlin.String = "ResearchStudy.progressStatus"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<ResearchStudy.ProgressStatus> =
      resource.progressStatus
  }

  public data object Protocol : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "protocol"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.protocol"

    public override val target: List<kotlin.String> = listOf("PlanDefinition")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.protocol
  }

  public data object RecruitmentActual : ResearchStudySearchParam<UnsignedInt>() {
    public override val paramName: kotlin.String = "recruitment-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: kotlin.String = "ResearchStudy.recruitment.actualNumber"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<UnsignedInt> =
      listOfNotNull(resource.recruitment?.actualNumber)
  }

  public data object RecruitmentTarget : ResearchStudySearchParam<UnsignedInt>() {
    public override val paramName: kotlin.String = "recruitment-target"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: kotlin.String = "ResearchStudy.recruitment.targetNumber"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<UnsignedInt> =
      listOfNotNull(resource.recruitment?.targetNumber)
  }

  public data object Region : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "region"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.region"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.region
  }

  public data object Site : ResearchStudySearchParam<Reference>() {
    public override val paramName: kotlin.String = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: kotlin.String = "ResearchStudy.site"

    public override val target: List<kotlin.String> =
      listOf("Organization", "ResearchStudy", "Location")

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.site
  }

  public data object Status : ResearchStudySearchParam<Any>() {
    public override val paramName: kotlin.String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.status"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = listOf(resource.status)
  }

  public data object StudyDesign : ResearchStudySearchParam<CodeableConcept>() {
    public override val paramName: kotlin.String = "study-design"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: kotlin.String = "ResearchStudy.studyDesign"

    public override val target: List<kotlin.String> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      resource.studyDesign
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
