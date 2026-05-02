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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Id
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.ResearchStudy
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.UnsignedInt
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ResearchStudyLabelSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): ResearchStudy.Label =
    ResearchStudy.Label(
      id = this@ResearchStudyLabelSurrogate.id,
      extension = this@ResearchStudyLabelSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchStudyLabelSurrogate.modifierExtension ?: listOf(),
      type = this@ResearchStudyLabelSurrogate.type,
      `value` =
        R5String.of(
          this@ResearchStudyLabelSurrogate.`value`,
          this@ResearchStudyLabelSurrogate._value,
        ),
    )

  public companion object {
    public fun fromModel(model: ResearchStudy.Label): ResearchStudyLabelSurrogate =
      with(model) {
        ResearchStudyLabelSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`?.value,
          _value = this@with.`value`?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ResearchStudyAssociatedPartySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var role: CodeableConcept,
  public var period: List<Period>? = null,
  public var classifier: List<CodeableConcept>? = null,
  public var party: Reference? = null,
) {
  public fun toModel(): ResearchStudy.AssociatedParty =
    ResearchStudy.AssociatedParty(
      id = this@ResearchStudyAssociatedPartySurrogate.id,
      extension = this@ResearchStudyAssociatedPartySurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchStudyAssociatedPartySurrogate.modifierExtension ?: listOf(),
      name =
        R5String.of(
          this@ResearchStudyAssociatedPartySurrogate.name,
          this@ResearchStudyAssociatedPartySurrogate._name,
        ),
      role = this@ResearchStudyAssociatedPartySurrogate.role,
      period = this@ResearchStudyAssociatedPartySurrogate.period ?: listOf(),
      classifier = this@ResearchStudyAssociatedPartySurrogate.classifier ?: listOf(),
      party = this@ResearchStudyAssociatedPartySurrogate.party,
    )

  public companion object {
    public fun fromModel(
      model: ResearchStudy.AssociatedParty
    ): ResearchStudyAssociatedPartySurrogate =
      with(model) {
        ResearchStudyAssociatedPartySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          role = this@with.role,
          period = this@with.period.takeIf { it.isNotEmpty() },
          classifier = this@with.classifier.takeIf { it.isNotEmpty() },
          party = this@with.party,
        )
      }
  }
}

@Serializable
internal data class ResearchStudyProgressStatusSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var state: CodeableConcept,
  public var `actual`: KotlinBoolean? = null,
  public var _actual: Element? = null,
  public var period: Period? = null,
) {
  public fun toModel(): ResearchStudy.ProgressStatus =
    ResearchStudy.ProgressStatus(
      id = this@ResearchStudyProgressStatusSurrogate.id,
      extension = this@ResearchStudyProgressStatusSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchStudyProgressStatusSurrogate.modifierExtension ?: listOf(),
      state = this@ResearchStudyProgressStatusSurrogate.state,
      `actual` =
        R5Boolean.of(
          this@ResearchStudyProgressStatusSurrogate.`actual`,
          this@ResearchStudyProgressStatusSurrogate._actual,
        ),
      period = this@ResearchStudyProgressStatusSurrogate.period,
    )

  public companion object {
    public fun fromModel(
      model: ResearchStudy.ProgressStatus
    ): ResearchStudyProgressStatusSurrogate =
      with(model) {
        ResearchStudyProgressStatusSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          state = this@with.state,
          `actual` = this@with.`actual`?.value,
          _actual = this@with.`actual`?.toElement(),
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class ResearchStudyRecruitmentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var targetNumber: Int? = null,
  public var _targetNumber: Element? = null,
  public var actualNumber: Int? = null,
  public var _actualNumber: Element? = null,
  public var eligibility: Reference? = null,
  public var actualGroup: Reference? = null,
) {
  public fun toModel(): ResearchStudy.Recruitment =
    ResearchStudy.Recruitment(
      id = this@ResearchStudyRecruitmentSurrogate.id,
      extension = this@ResearchStudyRecruitmentSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchStudyRecruitmentSurrogate.modifierExtension ?: listOf(),
      targetNumber =
        UnsignedInt.of(
          this@ResearchStudyRecruitmentSurrogate.targetNumber,
          this@ResearchStudyRecruitmentSurrogate._targetNumber,
        ),
      actualNumber =
        UnsignedInt.of(
          this@ResearchStudyRecruitmentSurrogate.actualNumber,
          this@ResearchStudyRecruitmentSurrogate._actualNumber,
        ),
      eligibility = this@ResearchStudyRecruitmentSurrogate.eligibility,
      actualGroup = this@ResearchStudyRecruitmentSurrogate.actualGroup,
    )

  public companion object {
    public fun fromModel(model: ResearchStudy.Recruitment): ResearchStudyRecruitmentSurrogate =
      with(model) {
        ResearchStudyRecruitmentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          targetNumber = this@with.targetNumber?.value,
          _targetNumber = this@with.targetNumber?.toElement(),
          actualNumber = this@with.actualNumber?.value,
          _actualNumber = this@with.actualNumber?.toElement(),
          eligibility = this@with.eligibility,
          actualGroup = this@with.actualGroup,
        )
      }
  }
}

@Serializable
internal data class ResearchStudyComparisonGroupSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var linkId: KotlinString? = null,
  public var _linkId: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var type: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var intendedExposure: List<Reference>? = null,
  public var observedGroup: Reference? = null,
) {
  public fun toModel(): ResearchStudy.ComparisonGroup =
    ResearchStudy.ComparisonGroup(
      id = this@ResearchStudyComparisonGroupSurrogate.id,
      extension = this@ResearchStudyComparisonGroupSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchStudyComparisonGroupSurrogate.modifierExtension ?: listOf(),
      linkId =
        Id.of(
          this@ResearchStudyComparisonGroupSurrogate.linkId,
          this@ResearchStudyComparisonGroupSurrogate._linkId,
        ),
      name =
        R5String.of(
          this@ResearchStudyComparisonGroupSurrogate.name,
          this@ResearchStudyComparisonGroupSurrogate._name,
        )!!,
      type = this@ResearchStudyComparisonGroupSurrogate.type,
      description =
        Markdown.of(
          this@ResearchStudyComparisonGroupSurrogate.description,
          this@ResearchStudyComparisonGroupSurrogate._description,
        ),
      intendedExposure = this@ResearchStudyComparisonGroupSurrogate.intendedExposure ?: listOf(),
      observedGroup = this@ResearchStudyComparisonGroupSurrogate.observedGroup,
    )

  public companion object {
    public fun fromModel(
      model: ResearchStudy.ComparisonGroup
    ): ResearchStudyComparisonGroupSurrogate =
      with(model) {
        ResearchStudyComparisonGroupSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          linkId = this@with.linkId?.value,
          _linkId = this@with.linkId?.toElement(),
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          type = this@with.type,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          intendedExposure = this@with.intendedExposure.takeIf { it.isNotEmpty() },
          observedGroup = this@with.observedGroup,
        )
      }
  }
}

@Serializable
internal data class ResearchStudyObjectiveSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var type: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
) {
  public fun toModel(): ResearchStudy.Objective =
    ResearchStudy.Objective(
      id = this@ResearchStudyObjectiveSurrogate.id,
      extension = this@ResearchStudyObjectiveSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchStudyObjectiveSurrogate.modifierExtension ?: listOf(),
      name =
        R5String.of(
          this@ResearchStudyObjectiveSurrogate.name,
          this@ResearchStudyObjectiveSurrogate._name,
        ),
      type = this@ResearchStudyObjectiveSurrogate.type,
      description =
        Markdown.of(
          this@ResearchStudyObjectiveSurrogate.description,
          this@ResearchStudyObjectiveSurrogate._description,
        ),
    )

  public companion object {
    public fun fromModel(model: ResearchStudy.Objective): ResearchStudyObjectiveSurrogate =
      with(model) {
        ResearchStudyObjectiveSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          type = this@with.type,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ResearchStudyOutcomeMeasureSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var type: List<CodeableConcept>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var reference: Reference? = null,
) {
  public fun toModel(): ResearchStudy.OutcomeMeasure =
    ResearchStudy.OutcomeMeasure(
      id = this@ResearchStudyOutcomeMeasureSurrogate.id,
      extension = this@ResearchStudyOutcomeMeasureSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchStudyOutcomeMeasureSurrogate.modifierExtension ?: listOf(),
      name =
        R5String.of(
          this@ResearchStudyOutcomeMeasureSurrogate.name,
          this@ResearchStudyOutcomeMeasureSurrogate._name,
        ),
      type = this@ResearchStudyOutcomeMeasureSurrogate.type ?: listOf(),
      description =
        Markdown.of(
          this@ResearchStudyOutcomeMeasureSurrogate.description,
          this@ResearchStudyOutcomeMeasureSurrogate._description,
        ),
      reference = this@ResearchStudyOutcomeMeasureSurrogate.reference,
    )

  public companion object {
    public fun fromModel(
      model: ResearchStudy.OutcomeMeasure
    ): ResearchStudyOutcomeMeasureSurrogate =
      with(model) {
        ResearchStudyOutcomeMeasureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          type = this@with.type.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          reference = this@with.reference,
        )
      }
  }
}

@Serializable
internal data class ResearchStudySurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var label: List<ResearchStudy.Label>? = null,
  public var protocol: List<Reference>? = null,
  public var partOf: List<Reference>? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var primaryPurposeType: CodeableConcept? = null,
  public var phase: CodeableConcept? = null,
  public var studyDesign: List<CodeableConcept>? = null,
  public var focus: List<CodeableReference>? = null,
  public var condition: List<CodeableConcept>? = null,
  public var keyword: List<CodeableConcept>? = null,
  public var region: List<CodeableConcept>? = null,
  public var descriptionSummary: KotlinString? = null,
  public var _descriptionSummary: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var period: Period? = null,
  public var site: List<Reference>? = null,
  public var note: List<Annotation>? = null,
  public var classifier: List<CodeableConcept>? = null,
  public var associatedParty: List<ResearchStudy.AssociatedParty>? = null,
  public var progressStatus: List<ResearchStudy.ProgressStatus>? = null,
  public var whyStopped: CodeableConcept? = null,
  public var recruitment: ResearchStudy.Recruitment? = null,
  public var comparisonGroup: List<ResearchStudy.ComparisonGroup>? = null,
  public var objective: List<ResearchStudy.Objective>? = null,
  public var outcomeMeasure: List<ResearchStudy.OutcomeMeasure>? = null,
  public var result: List<Reference>? = null,
) {
  public fun toModel(): ResearchStudy =
    ResearchStudy(
      id = this@ResearchStudySurrogate.id,
      meta = this@ResearchStudySurrogate.meta,
      implicitRules =
        Uri.of(
          this@ResearchStudySurrogate.implicitRules,
          this@ResearchStudySurrogate._implicitRules,
        ),
      language =
        Code.of(this@ResearchStudySurrogate.language, this@ResearchStudySurrogate._language),
      text = this@ResearchStudySurrogate.text,
      contained = this@ResearchStudySurrogate.contained ?: listOf(),
      extension = this@ResearchStudySurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchStudySurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@ResearchStudySurrogate.url, this@ResearchStudySurrogate._url),
      identifier = this@ResearchStudySurrogate.identifier ?: listOf(),
      version =
        R5String.of(this@ResearchStudySurrogate.version, this@ResearchStudySurrogate._version),
      name = R5String.of(this@ResearchStudySurrogate.name, this@ResearchStudySurrogate._name),
      title = R5String.of(this@ResearchStudySurrogate.title, this@ResearchStudySurrogate._title),
      label = this@ResearchStudySurrogate.label ?: listOf(),
      protocol = this@ResearchStudySurrogate.protocol ?: listOf(),
      partOf = this@ResearchStudySurrogate.partOf ?: listOf(),
      relatedArtifact = this@ResearchStudySurrogate.relatedArtifact ?: listOf(),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ResearchStudySurrogate.date),
          this@ResearchStudySurrogate._date,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ResearchStudySurrogate.status!!),
          this@ResearchStudySurrogate._status,
        ),
      primaryPurposeType = this@ResearchStudySurrogate.primaryPurposeType,
      phase = this@ResearchStudySurrogate.phase,
      studyDesign = this@ResearchStudySurrogate.studyDesign ?: listOf(),
      focus = this@ResearchStudySurrogate.focus ?: listOf(),
      condition = this@ResearchStudySurrogate.condition ?: listOf(),
      keyword = this@ResearchStudySurrogate.keyword ?: listOf(),
      region = this@ResearchStudySurrogate.region ?: listOf(),
      descriptionSummary =
        Markdown.of(
          this@ResearchStudySurrogate.descriptionSummary,
          this@ResearchStudySurrogate._descriptionSummary,
        ),
      description =
        Markdown.of(
          this@ResearchStudySurrogate.description,
          this@ResearchStudySurrogate._description,
        ),
      period = this@ResearchStudySurrogate.period,
      site = this@ResearchStudySurrogate.site ?: listOf(),
      note = this@ResearchStudySurrogate.note ?: listOf(),
      classifier = this@ResearchStudySurrogate.classifier ?: listOf(),
      associatedParty = this@ResearchStudySurrogate.associatedParty ?: listOf(),
      progressStatus = this@ResearchStudySurrogate.progressStatus ?: listOf(),
      whyStopped = this@ResearchStudySurrogate.whyStopped,
      recruitment = this@ResearchStudySurrogate.recruitment,
      comparisonGroup = this@ResearchStudySurrogate.comparisonGroup ?: listOf(),
      objective = this@ResearchStudySurrogate.objective ?: listOf(),
      outcomeMeasure = this@ResearchStudySurrogate.outcomeMeasure ?: listOf(),
      result = this@ResearchStudySurrogate.result ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ResearchStudy): ResearchStudySurrogate =
      with(model) {
        ResearchStudySurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          label = this@with.label.takeIf { it.isNotEmpty() },
          protocol = this@with.protocol.takeIf { it.isNotEmpty() },
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          primaryPurposeType = this@with.primaryPurposeType,
          phase = this@with.phase,
          studyDesign = this@with.studyDesign.takeIf { it.isNotEmpty() },
          focus = this@with.focus.takeIf { it.isNotEmpty() },
          condition = this@with.condition.takeIf { it.isNotEmpty() },
          keyword = this@with.keyword.takeIf { it.isNotEmpty() },
          region = this@with.region.takeIf { it.isNotEmpty() },
          descriptionSummary = this@with.descriptionSummary?.value,
          _descriptionSummary = this@with.descriptionSummary?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          period = this@with.period,
          site = this@with.site.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          classifier = this@with.classifier.takeIf { it.isNotEmpty() },
          associatedParty = this@with.associatedParty.takeIf { it.isNotEmpty() },
          progressStatus = this@with.progressStatus.takeIf { it.isNotEmpty() },
          whyStopped = this@with.whyStopped,
          recruitment = this@with.recruitment,
          comparisonGroup = this@with.comparisonGroup.takeIf { it.isNotEmpty() },
          objective = this@with.objective.takeIf { it.isNotEmpty() },
          outcomeMeasure = this@with.outcomeMeasure.takeIf { it.isNotEmpty() },
          result = this@with.result.takeIf { it.isNotEmpty() },
        )
      }
  }
}
