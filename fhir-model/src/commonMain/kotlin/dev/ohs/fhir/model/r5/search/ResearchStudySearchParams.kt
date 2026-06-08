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
    SearchParam(
      name = "classifier",
      type = SearchParamType.Token,
      expression = "ResearchStudy.classifier",
      extractor = { resource -> resource.classifier },
    )

  public val condition: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "condition",
      type = SearchParamType.Token,
      expression = "ResearchStudy.condition",
      extractor = { resource -> resource.condition },
    )

  public val date: SearchParam<ResearchStudy, Period> =
    SearchParam(
      name = "date",
      type = SearchParamType.Date,
      expression = "ResearchStudy.period",
      extractor = { resource -> listOfNotNull(resource.period) },
    )

  public val description: SearchParam<ResearchStudy, Markdown> =
    SearchParam(
      name = "description",
      type = SearchParamType.String,
      expression = "ResearchStudy.description",
      extractor = { resource -> listOfNotNull(resource.description) },
    )

  public val eligibility: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "eligibility",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.recruitment.eligibility",
      target = listOf(Group::class, EvidenceVariable::class),
      extractor = { resource -> listOfNotNull(resource.recruitment?.eligibility) },
    )

  public val focusCode: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "focus-code",
      type = SearchParamType.Token,
      expression = "ResearchStudy.focus.concept",
      extractor = { resource -> resource.focus.mapNotNull { it.concept } },
    )

  public val focusReference: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "focus-reference",
      type = SearchParamType.Reference,
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
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "ResearchStudy.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val keyword: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "keyword",
      type = SearchParamType.Token,
      expression = "ResearchStudy.keyword",
      extractor = { resource -> resource.keyword },
    )

  public val name: SearchParam<ResearchStudy, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.String,
      expression = "ResearchStudy.name",
      extractor = { resource -> listOfNotNull(resource.name) },
    )

  public val objectiveDescription: SearchParam<ResearchStudy, Markdown> =
    SearchParam(
      name = "objective-description",
      type = SearchParamType.String,
      expression = "ResearchStudy.objective.description",
      extractor = { resource -> resource.objective.mapNotNull { it.description } },
    )

  public val objectiveType: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "objective-type",
      type = SearchParamType.Token,
      expression = "ResearchStudy.objective.type",
      extractor = { resource -> resource.objective.mapNotNull { it.type } },
    )

  public val partOf: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "part-of",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.partOf",
      target = listOf(ResearchStudy::class),
      extractor = { resource -> resource.partOf },
    )

  public val phase: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "phase",
      type = SearchParamType.Token,
      expression = "ResearchStudy.phase",
      extractor = { resource -> listOfNotNull(resource.phase) },
    )

  public val progressStatusStateActual: SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> =
    SearchParam(
      name = "progress-status-state-actual",
      type = SearchParamType.Composite,
      expression = "ResearchStudy.progressStatus",
      extractor = { resource -> resource.progressStatus },
    )

  public val progressStatusStatePeriod: SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> =
    SearchParam(
      name = "progress-status-state-period",
      type = SearchParamType.Composite,
      expression = "ResearchStudy.progressStatus",
      extractor = { resource -> resource.progressStatus },
    )

  public val progressStatusStatePeriodActual:
    SearchParam<ResearchStudy, ResearchStudy.ProgressStatus> =
    SearchParam(
      name = "progress-status-state-period-actual",
      type = SearchParamType.Composite,
      expression = "ResearchStudy.progressStatus",
      extractor = { resource -> resource.progressStatus },
    )

  public val protocol: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "protocol",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.protocol",
      target = listOf(PlanDefinition::class),
      extractor = { resource -> resource.protocol },
    )

  public val recruitmentActual: SearchParam<ResearchStudy, UnsignedInt> =
    SearchParam(
      name = "recruitment-actual",
      type = SearchParamType.Number,
      expression = "ResearchStudy.recruitment.actualNumber",
      extractor = { resource -> listOfNotNull(resource.recruitment?.actualNumber) },
    )

  public val recruitmentTarget: SearchParam<ResearchStudy, UnsignedInt> =
    SearchParam(
      name = "recruitment-target",
      type = SearchParamType.Number,
      expression = "ResearchStudy.recruitment.targetNumber",
      extractor = { resource -> listOfNotNull(resource.recruitment?.targetNumber) },
    )

  public val region: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "region",
      type = SearchParamType.Token,
      expression = "ResearchStudy.region",
      extractor = { resource -> resource.region },
    )

  public val site: SearchParam<ResearchStudy, Reference> =
    SearchParam(
      name = "site",
      type = SearchParamType.Reference,
      expression = "ResearchStudy.site",
      target = listOf(Organization::class, ResearchStudy::class, Location::class),
      extractor = { resource -> resource.site },
    )

  public val status: SearchParam<ResearchStudy, Any> =
    SearchParam(
      name = "status",
      type = SearchParamType.Token,
      expression = "ResearchStudy.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val studyDesign: SearchParam<ResearchStudy, CodeableConcept> =
    SearchParam(
      name = "study-design",
      type = SearchParamType.Token,
      expression = "ResearchStudy.studyDesign",
      extractor = { resource -> resource.studyDesign },
    )

  public val title: SearchParam<ResearchStudy, String> =
    SearchParam(
      name = "title",
      type = SearchParamType.String,
      expression = "ResearchStudy.title",
      extractor = { resource -> listOfNotNull(resource.title) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<ResearchStudy, *>> = listOf()

  /**
   * Supported search parameters for the ResearchStudy resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
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
