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
import dev.ohs.fhir.model.r5.EvidenceVariable
import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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

  public data object Classifier : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "classifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.classifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      resource.classifier
  }

  public data object Condition : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "condition"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.condition"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.condition
  }

  public data object Date : SearchParam<ResearchStudy, Period> {
    public override val name: KotlinString = "date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ResearchStudy.period"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Period> =
      listOfNotNull(resource.period)
  }

  public data object Description : SearchParam<ResearchStudy, Markdown> {
    public override val name: KotlinString = "description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ResearchStudy.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Markdown> =
      listOfNotNull(resource.description)
  }

  public data object Eligibility : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "eligibility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.recruitment.eligibility"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, EvidenceVariable::class)

    public override fun extract(resource: ResearchStudy): List<Reference> =
      listOfNotNull(resource.recruitment?.eligibility)
  }

  public data object FocusCode : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "focus-code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.focus.concept"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      resource.focus.mapNotNull { it.concept }
  }

  public data object FocusReference : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "focus-reference"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.focus.reference"

    public override val target: List<KClass<out Resource>> =
      listOf(
        MedicinalProductDefinition::class,
        EvidenceVariable::class,
        SubstanceDefinition::class,
        Medication::class,
      )

    public override fun extract(resource: ResearchStudy): List<Reference> =
      resource.focus.mapNotNull { it.reference }
  }

  public data object Identifier : SearchParam<ResearchStudy, dev.ohs.fhir.model.r5.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Keyword : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "keyword"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.keyword"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.keyword
  }

  public data object Name : SearchParam<ResearchStudy, R5String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ResearchStudy.name"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<R5String> =
      listOfNotNull(resource.name)
  }

  public data object ObjectiveDescription : SearchParam<ResearchStudy, Markdown> {
    public override val name: KotlinString = "objective-description"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ResearchStudy.objective.description"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Markdown> =
      resource.objective.mapNotNull { it.description }
  }

  public data object ObjectiveType : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "objective-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.objective.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      resource.objective.mapNotNull { it.type }
  }

  public data object PartOf : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "part-of"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.partOf"

    public override val target: List<KClass<out Resource>> = listOf(ResearchStudy::class)

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.partOf
  }

  public data object Phase : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "phase"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.phase"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      listOfNotNull(resource.phase)
  }

  public data object ProgressStatusStateActual :
    SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> {
    public override val name: KotlinString = "progress-status-state-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ResearchStudy.progressStatus"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<ResearchStudy.ProgressStatus> =
      resource.progressStatus
  }

  public data object ProgressStatusStatePeriod :
    SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> {
    public override val name: KotlinString = "progress-status-state-period"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ResearchStudy.progressStatus"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<ResearchStudy.ProgressStatus> =
      resource.progressStatus
  }

  public data object ProgressStatusStatePeriodActual :
    SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> {
    public override val name: KotlinString = "progress-status-state-period-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: KotlinString = "ResearchStudy.progressStatus"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<ResearchStudy.ProgressStatus> =
      resource.progressStatus
  }

  public data object Protocol : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "protocol"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.protocol"

    public override val target: List<KClass<out Resource>> = listOf(PlanDefinition::class)

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.protocol
  }

  public data object RecruitmentActual : SearchParam<ResearchStudy, UnsignedInt> {
    public override val name: KotlinString = "recruitment-actual"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: KotlinString = "ResearchStudy.recruitment.actualNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<UnsignedInt> =
      listOfNotNull(resource.recruitment?.actualNumber)
  }

  public data object RecruitmentTarget : SearchParam<ResearchStudy, UnsignedInt> {
    public override val name: KotlinString = "recruitment-target"

    public override val type: SearchParamType = SearchParamType.fromCode("number")

    public override val expression: KotlinString = "ResearchStudy.recruitment.targetNumber"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<UnsignedInt> =
      listOfNotNull(resource.recruitment?.targetNumber)
  }

  public data object Region : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "region"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.region"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> = resource.region
  }

  public data object Site : SearchParam<ResearchStudy, Reference> {
    public override val name: KotlinString = "site"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ResearchStudy.site"

    public override val target: List<KClass<out Resource>> =
      listOf(Organization::class, ResearchStudy::class, Location::class)

    public override fun extract(resource: ResearchStudy): List<Reference> = resource.site
  }

  public data object Status : SearchParam<ResearchStudy, Any> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<Any> = listOf(resource.status)
  }

  public data object StudyDesign : SearchParam<ResearchStudy, CodeableConcept> {
    public override val name: KotlinString = "study-design"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ResearchStudy.studyDesign"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<CodeableConcept> =
      resource.studyDesign
  }

  public data object Title : SearchParam<ResearchStudy, R5String> {
    public override val name: KotlinString = "title"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ResearchStudy.title"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: ResearchStudy): List<R5String> =
      listOfNotNull(resource.title)
  }
}
