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

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Expression
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Measure
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.RelatedArtifact
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MeasureGroupSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var population: List<Measure.Group.Population>? = null,
  public var stratifier: List<Measure.Group.Stratifier>? = null,
) {
  public fun toModel(): Measure.Group =
    Measure.Group(
      id = this@MeasureGroupSurrogate.id,
      extension = this@MeasureGroupSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureGroupSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureGroupSurrogate.code,
      description =
        R4bString.of(
          this@MeasureGroupSurrogate.description,
          this@MeasureGroupSurrogate._description,
        ),
      population = this@MeasureGroupSurrogate.population ?: listOf(),
      stratifier = this@MeasureGroupSurrogate.stratifier ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Measure.Group): MeasureGroupSurrogate =
      with(model) {
        MeasureGroupSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          population = this@with.population.takeIf { it.isNotEmpty() },
          stratifier = this@with.stratifier.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MeasureGroupPopulationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var criteria: Expression,
) {
  public fun toModel(): Measure.Group.Population =
    Measure.Group.Population(
      id = this@MeasureGroupPopulationSurrogate.id,
      extension = this@MeasureGroupPopulationSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureGroupPopulationSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureGroupPopulationSurrogate.code,
      description =
        R4bString.of(
          this@MeasureGroupPopulationSurrogate.description,
          this@MeasureGroupPopulationSurrogate._description,
        ),
      criteria = this@MeasureGroupPopulationSurrogate.criteria,
    )

  public companion object {
    public fun fromModel(model: Measure.Group.Population): MeasureGroupPopulationSurrogate =
      with(model) {
        MeasureGroupPopulationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          criteria = this@with.criteria,
        )
      }
  }
}

@Serializable
internal data class MeasureGroupStratifierSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var criteria: Expression? = null,
  public var component: List<Measure.Group.Stratifier.Component>? = null,
) {
  public fun toModel(): Measure.Group.Stratifier =
    Measure.Group.Stratifier(
      id = this@MeasureGroupStratifierSurrogate.id,
      extension = this@MeasureGroupStratifierSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureGroupStratifierSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureGroupStratifierSurrogate.code,
      description =
        R4bString.of(
          this@MeasureGroupStratifierSurrogate.description,
          this@MeasureGroupStratifierSurrogate._description,
        ),
      criteria = this@MeasureGroupStratifierSurrogate.criteria,
      component = this@MeasureGroupStratifierSurrogate.component ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Measure.Group.Stratifier): MeasureGroupStratifierSurrogate =
      with(model) {
        MeasureGroupStratifierSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          criteria = this@with.criteria,
          component = this@with.component.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MeasureGroupStratifierComponentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var criteria: Expression,
) {
  public fun toModel(): Measure.Group.Stratifier.Component =
    Measure.Group.Stratifier.Component(
      id = this@MeasureGroupStratifierComponentSurrogate.id,
      extension = this@MeasureGroupStratifierComponentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MeasureGroupStratifierComponentSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureGroupStratifierComponentSurrogate.code,
      description =
        R4bString.of(
          this@MeasureGroupStratifierComponentSurrogate.description,
          this@MeasureGroupStratifierComponentSurrogate._description,
        ),
      criteria = this@MeasureGroupStratifierComponentSurrogate.criteria,
    )

  public companion object {
    public fun fromModel(
      model: Measure.Group.Stratifier.Component
    ): MeasureGroupStratifierComponentSurrogate =
      with(model) {
        MeasureGroupStratifierComponentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          criteria = this@with.criteria,
        )
      }
  }
}

@Serializable
internal data class MeasureSupplementalDataSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var usage: List<CodeableConcept>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var criteria: Expression,
) {
  public fun toModel(): Measure.SupplementalData =
    Measure.SupplementalData(
      id = this@MeasureSupplementalDataSurrogate.id,
      extension = this@MeasureSupplementalDataSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureSupplementalDataSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureSupplementalDataSurrogate.code,
      usage = this@MeasureSupplementalDataSurrogate.usage ?: listOf(),
      description =
        R4bString.of(
          this@MeasureSupplementalDataSurrogate.description,
          this@MeasureSupplementalDataSurrogate._description,
        ),
      criteria = this@MeasureSupplementalDataSurrogate.criteria,
    )

  public companion object {
    public fun fromModel(model: Measure.SupplementalData): MeasureSupplementalDataSurrogate =
      with(model) {
        MeasureSupplementalDataSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          usage = this@with.usage.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          criteria = this@with.criteria,
        )
      }
  }
}

@Serializable
internal data class MeasureSubjectSurrogate(
  public var subjectCodeableConcept: CodeableConcept? = null,
  public var subjectReference: Reference? = null,
) {
  public fun toModel(): Measure.Subject =
    Measure.Subject.from(
      this@MeasureSubjectSurrogate.subjectCodeableConcept,
      this@MeasureSubjectSurrogate.subjectReference,
    )!!

  public companion object {
    public fun fromModel(model: Measure.Subject): MeasureSubjectSurrogate =
      with(model) {
        MeasureSubjectSurrogate(
          subjectCodeableConcept = this@with.asCodeableConcept()?.value,
          subjectReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MeasureSurrogate(
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
  public var subtitle: KotlinString? = null,
  public var _subtitle: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var experimental: KotlinBoolean? = null,
  public var _experimental: Element? = null,
  public var subject: Measure.Subject? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var usage: KotlinString? = null,
  public var _usage: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var approvalDate: KotlinString? = null,
  public var _approvalDate: Element? = null,
  public var lastReviewDate: KotlinString? = null,
  public var _lastReviewDate: Element? = null,
  public var effectivePeriod: Period? = null,
  public var topic: List<CodeableConcept>? = null,
  public var author: List<ContactDetail>? = null,
  public var editor: List<ContactDetail>? = null,
  public var reviewer: List<ContactDetail>? = null,
  public var endorser: List<ContactDetail>? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var library: List<KotlinString?>? = null,
  public var _library: List<Element?>? = null,
  public var disclaimer: KotlinString? = null,
  public var _disclaimer: Element? = null,
  public var scoring: CodeableConcept? = null,
  public var compositeScoring: CodeableConcept? = null,
  public var type: List<CodeableConcept>? = null,
  public var riskAdjustment: KotlinString? = null,
  public var _riskAdjustment: Element? = null,
  public var rateAggregation: KotlinString? = null,
  public var _rateAggregation: Element? = null,
  public var rationale: KotlinString? = null,
  public var _rationale: Element? = null,
  public var clinicalRecommendationStatement: KotlinString? = null,
  public var _clinicalRecommendationStatement: Element? = null,
  public var improvementNotation: CodeableConcept? = null,
  public var definition: List<KotlinString?>? = null,
  public var _definition: List<Element?>? = null,
  public var guidance: KotlinString? = null,
  public var _guidance: Element? = null,
  public var group: List<Measure.Group>? = null,
  public var supplementalData: List<Measure.SupplementalData>? = null,
) {
  public fun toModel(): Measure =
    Measure(
      id = this@MeasureSurrogate.id,
      meta = this@MeasureSurrogate.meta,
      implicitRules =
        Uri.of(this@MeasureSurrogate.implicitRules, this@MeasureSurrogate._implicitRules),
      language = Code.of(this@MeasureSurrogate.language, this@MeasureSurrogate._language),
      text = this@MeasureSurrogate.text,
      contained = this@MeasureSurrogate.contained ?: listOf(),
      extension = this@MeasureSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@MeasureSurrogate.url, this@MeasureSurrogate._url),
      identifier = this@MeasureSurrogate.identifier ?: listOf(),
      version = R4bString.of(this@MeasureSurrogate.version, this@MeasureSurrogate._version),
      name = R4bString.of(this@MeasureSurrogate.name, this@MeasureSurrogate._name),
      title = R4bString.of(this@MeasureSurrogate.title, this@MeasureSurrogate._title),
      subtitle = R4bString.of(this@MeasureSurrogate.subtitle, this@MeasureSurrogate._subtitle),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@MeasureSurrogate.status!!),
          this@MeasureSurrogate._status,
        ),
      experimental =
        R4bBoolean.of(this@MeasureSurrogate.experimental, this@MeasureSurrogate._experimental),
      subject = this@MeasureSurrogate.subject,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@MeasureSurrogate.date),
          this@MeasureSurrogate._date,
        ),
      publisher = R4bString.of(this@MeasureSurrogate.publisher, this@MeasureSurrogate._publisher),
      contact = this@MeasureSurrogate.contact ?: listOf(),
      description =
        Markdown.of(this@MeasureSurrogate.description, this@MeasureSurrogate._description),
      useContext = this@MeasureSurrogate.useContext ?: listOf(),
      jurisdiction = this@MeasureSurrogate.jurisdiction ?: listOf(),
      purpose = Markdown.of(this@MeasureSurrogate.purpose, this@MeasureSurrogate._purpose),
      usage = R4bString.of(this@MeasureSurrogate.usage, this@MeasureSurrogate._usage),
      copyright = Markdown.of(this@MeasureSurrogate.copyright, this@MeasureSurrogate._copyright),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@MeasureSurrogate.approvalDate),
          this@MeasureSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@MeasureSurrogate.lastReviewDate),
          this@MeasureSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@MeasureSurrogate.effectivePeriod,
      topic = this@MeasureSurrogate.topic ?: listOf(),
      author = this@MeasureSurrogate.author ?: listOf(),
      editor = this@MeasureSurrogate.editor ?: listOf(),
      reviewer = this@MeasureSurrogate.reviewer ?: listOf(),
      endorser = this@MeasureSurrogate.endorser ?: listOf(),
      relatedArtifact = this@MeasureSurrogate.relatedArtifact ?: listOf(),
      library =
        if (this@MeasureSurrogate.library == null && this@MeasureSurrogate._library == null) {
          listOf()
        } else {
          (this@MeasureSurrogate.library ?: List(this@MeasureSurrogate._library!!.size) { null })
            .zip(
              this@MeasureSurrogate._library ?: List(this@MeasureSurrogate.library!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      disclaimer = Markdown.of(this@MeasureSurrogate.disclaimer, this@MeasureSurrogate._disclaimer),
      scoring = this@MeasureSurrogate.scoring,
      compositeScoring = this@MeasureSurrogate.compositeScoring,
      type = this@MeasureSurrogate.type ?: listOf(),
      riskAdjustment =
        R4bString.of(this@MeasureSurrogate.riskAdjustment, this@MeasureSurrogate._riskAdjustment),
      rateAggregation =
        R4bString.of(this@MeasureSurrogate.rateAggregation, this@MeasureSurrogate._rateAggregation),
      rationale = Markdown.of(this@MeasureSurrogate.rationale, this@MeasureSurrogate._rationale),
      clinicalRecommendationStatement =
        Markdown.of(
          this@MeasureSurrogate.clinicalRecommendationStatement,
          this@MeasureSurrogate._clinicalRecommendationStatement,
        ),
      improvementNotation = this@MeasureSurrogate.improvementNotation,
      definition =
        if (this@MeasureSurrogate.definition == null && this@MeasureSurrogate._definition == null) {
          listOf()
        } else {
          (this@MeasureSurrogate.definition
              ?: List(this@MeasureSurrogate._definition!!.size) { null })
            .zip(
              this@MeasureSurrogate._definition
                ?: List(this@MeasureSurrogate.definition!!.size) { null }
            )
            .map { (value, element) -> Markdown.of(value, element)!! }
            .toList()
        },
      guidance = Markdown.of(this@MeasureSurrogate.guidance, this@MeasureSurrogate._guidance),
      group = this@MeasureSurrogate.group ?: listOf(),
      supplementalData = this@MeasureSurrogate.supplementalData ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Measure): MeasureSurrogate =
      with(model) {
        MeasureSurrogate(
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
          subtitle = this@with.subtitle?.value,
          _subtitle = this@with.subtitle?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          subject = this@with.subject,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          usage = this@with.usage?.value,
          _usage = this@with.usage?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          approvalDate = this@with.approvalDate?.value?.toString(),
          _approvalDate = this@with.approvalDate?.toElement(),
          lastReviewDate = this@with.lastReviewDate?.value?.toString(),
          _lastReviewDate = this@with.lastReviewDate?.toElement(),
          effectivePeriod = this@with.effectivePeriod,
          topic = this@with.topic.takeIf { it.isNotEmpty() },
          author = this@with.author.takeIf { it.isNotEmpty() },
          editor = this@with.editor.takeIf { it.isNotEmpty() },
          reviewer = this@with.reviewer.takeIf { it.isNotEmpty() },
          endorser = this@with.endorser.takeIf { it.isNotEmpty() },
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          library =
            this@with.library.map { it.value }.toList().takeUnless { it.all { it == null } },
          _library =
            this@with.library
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          disclaimer = this@with.disclaimer?.value,
          _disclaimer = this@with.disclaimer?.toElement(),
          scoring = this@with.scoring,
          compositeScoring = this@with.compositeScoring,
          type = this@with.type.takeIf { it.isNotEmpty() },
          riskAdjustment = this@with.riskAdjustment?.value,
          _riskAdjustment = this@with.riskAdjustment?.toElement(),
          rateAggregation = this@with.rateAggregation?.value,
          _rateAggregation = this@with.rateAggregation?.toElement(),
          rationale = this@with.rationale?.value,
          _rationale = this@with.rationale?.toElement(),
          clinicalRecommendationStatement = this@with.clinicalRecommendationStatement?.value,
          _clinicalRecommendationStatement = this@with.clinicalRecommendationStatement?.toElement(),
          improvementNotation = this@with.improvementNotation,
          definition =
            this@with.definition.map { it.value }.toList().takeUnless { it.all { it == null } },
          _definition =
            this@with.definition
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          guidance = this@with.guidance?.value,
          _guidance = this@with.guidance?.toElement(),
          group = this@with.group.takeIf { it.isNotEmpty() },
          supplementalData = this@with.supplementalData.takeIf { it.isNotEmpty() },
        )
      }
  }
}
