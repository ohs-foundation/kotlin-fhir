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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Medication
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ResearchStudy] resource type. */
public object ResearchStudySearchParams {
  public val classifier: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam<ResearchStudy, CodeableConcept>(
      name = "classifier",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.classifier",
      extractor = { resource -> resource.classifier },
    )

  public val condition: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam<ResearchStudy, CodeableConcept>(
      name = "condition",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.condition",
      extractor = { resource -> resource.condition },
    )

  public val date: SearchParam<ResearchStudy, Period> =
    SearchParam<ResearchStudy, Period>(
      name = "date",
      type = SearchParamType.fromCode("date"),
      expression = "ResearchStudy.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val description: SearchParam<ResearchStudy, Markdown> =
    SearchParam<ResearchStudy, Markdown>(
      name = "description",
      type = SearchParamType.fromCode("string"),
      expression = "ResearchStudy.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val eligibility: SearchParam<ResearchStudy, Reference> =
    SearchParam<ResearchStudy, Reference>(
      name = "eligibility",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.recruitment.eligibility",
      target = listOf(Group::class, EvidenceVariable::class),
      extractor = { resource -> listOfNotNull(resource.recruitment?.eligibility) },
    )

  public val focusCode: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam<ResearchStudy, CodeableConcept>(
      name = "focus-code",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.focus.concept",
      extractor = { resource -> resource.focus.mapNotNull { it.concept } },
    )

  public val focusReference: SearchParam<ResearchStudy, Reference> =
    SearchParam<ResearchStudy, Reference>(
      name = "focus-reference",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.focus.reference",
      target =
        listOf(
          MedicinalProductDefinition::class,
          EvidenceVariable::class,
          SubstanceDefinition::class,
          Medication::class,
        ),
      extractor = { resource -> resource.focus.mapNotNull { it.reference } },
    )

  public val identifier: SearchParam<ResearchStudy, Identifier> =
    SearchParam<ResearchStudy, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val keyword: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam<ResearchStudy, CodeableConcept>(
      name = "keyword",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.keyword",
      extractor = { resource -> resource.keyword },
    )

  public val name: SearchParam<ResearchStudy, String> =
    SearchParam<ResearchStudy, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "ResearchStudy.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val objectiveDescription: SearchParam<ResearchStudy, Markdown> =
    SearchParam<ResearchStudy, Markdown>(
      name = "objective-description",
      type = SearchParamType.fromCode("string"),
      expression = "ResearchStudy.objective.description",
      extractor = { resource -> resource.objective.mapNotNull { it.description } },
    )

  public val objectiveType: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam<ResearchStudy, CodeableConcept>(
      name = "objective-type",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.objective.type",
      extractor = { resource -> resource.objective.mapNotNull { it.type } },
    )

  public val partOf: SearchParam<ResearchStudy, Reference> =
    SearchParam<ResearchStudy, Reference>(
      name = "part-of",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.partOf",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> resource.partOf },
    )

  public val phase: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam<ResearchStudy, CodeableConcept>(
      name = "phase",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.phase",
      extractor = { resource -> listOfNotNull(resource.phase) },
    )

  public val progressStatusStateActual: SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> =
    SearchParam<ResearchStudy, ResearchStudy.ProgressStatus>(
      name = "progress-status-state-actual",
      type = SearchParamType.fromCode("composite"),
      expression = "ResearchStudy.progressStatus",
      extractor = { resource -> resource.progressStatus },
    )

  public val progressStatusStatePeriod: SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> =
    SearchParam<ResearchStudy, ResearchStudy.ProgressStatus>(
      name = "progress-status-state-period",
      type = SearchParamType.fromCode("composite"),
      expression = "ResearchStudy.progressStatus",
      extractor = { resource -> resource.progressStatus },
    )

  public val progressStatusStatePeriodActual:
    SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> =
    SearchParam<ResearchStudy, ResearchStudy.ProgressStatus>(
      name = "progress-status-state-period-actual",
      type = SearchParamType.fromCode("composite"),
      expression = "ResearchStudy.progressStatus",
      extractor = { resource -> resource.progressStatus },
    )

  public val protocol: SearchParam<ResearchStudy, Reference> =
    SearchParam<ResearchStudy, Reference>(
      name = "protocol",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.protocol",
      target = listOf(PlanDefinition::class),
      extractor = { resource -> resource.protocol },
    )

  public val recruitmentActual: SearchParam<ResearchStudy, UnsignedInt> =
    SearchParam<ResearchStudy, UnsignedInt>(
      name = "recruitment-actual",
      type = SearchParamType.fromCode("number"),
      expression = "ResearchStudy.recruitment.actualNumber",
      extractor = { resource -> listOfNotNull(resource.recruitment?.actualNumber) },
    )

  public val recruitmentTarget: SearchParam<ResearchStudy, UnsignedInt> =
    SearchParam<ResearchStudy, UnsignedInt>(
      name = "recruitment-target",
      type = SearchParamType.fromCode("number"),
      expression = "ResearchStudy.recruitment.targetNumber",
      extractor = { resource -> listOfNotNull(resource.recruitment?.targetNumber) },
    )

  public val region: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam<ResearchStudy, CodeableConcept>(
      name = "region",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.region",
      extractor = { resource -> resource.region },
    )

  public val site: SearchParam<ResearchStudy, Reference> =
    SearchParam<ResearchStudy, Reference>(
      name = "site",
      type = SearchParamType.fromCode("reference"),
      expression = "ResearchStudy.site",
      target = listOf(Organization::class, ResearchStudy::class, Location::class),
      extractor = { resource -> resource.site },
    )

  public val status: SearchParam<ResearchStudy, Any> =
    SearchParam<ResearchStudy, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val studyDesign: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam<ResearchStudy, CodeableConcept>(
      name = "study-design",
      type = SearchParamType.fromCode("token"),
      expression = "ResearchStudy.studyDesign",
      extractor = { resource -> resource.studyDesign },
    )

  public val title: SearchParam<ResearchStudy, String> =
    SearchParam<ResearchStudy, String>(
      name = "title",
      type = SearchParamType.fromCode("string"),
      expression = "ResearchStudy.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  /** All search parameters for the ResearchStudy resource type. */
  public val all: List<SearchParam<ResearchStudy, *>> =
    listOf(
      classifier,
      condition,
      date,
      description,
      eligibility,
      focusCode,
      focusReference,
      identifier,
      keyword,
      name,
      objectiveDescription,
      objectiveType,
      partOf,
      phase,
      progressStatusStateActual,
      progressStatusStatePeriod,
      progressStatusStatePeriodActual,
      protocol,
      recruitmentActual,
      recruitmentTarget,
      region,
      site,
      status,
      studyDesign,
      title,
    )
}
