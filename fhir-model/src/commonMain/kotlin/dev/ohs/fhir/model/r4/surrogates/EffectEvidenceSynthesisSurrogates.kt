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

package com.google.fhir.model.r4.surrogates

import com.google.fhir.model.r4.Annotation
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.ContactDetail
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Decimal
import com.google.fhir.model.r4.EffectEvidenceSynthesis
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDate
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Integer
import com.google.fhir.model.r4.Markdown
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.RelatedArtifact
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.UsageContext
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class EffectEvidenceSynthesisSampleSizeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var numberOfStudies: Int? = null,
  public var _numberOfStudies: Element? = null,
  public var numberOfParticipants: Int? = null,
  public var _numberOfParticipants: Element? = null,
) {
  public fun toModel(): EffectEvidenceSynthesis.SampleSize =
    EffectEvidenceSynthesis.SampleSize(
      id = this@EffectEvidenceSynthesisSampleSizeSurrogate.id,
      extension = this@EffectEvidenceSynthesisSampleSizeSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EffectEvidenceSynthesisSampleSizeSurrogate.modifierExtension ?: listOf(),
      description =
        R4String.of(
          this@EffectEvidenceSynthesisSampleSizeSurrogate.description,
          this@EffectEvidenceSynthesisSampleSizeSurrogate._description,
        ),
      numberOfStudies =
        Integer.of(
          this@EffectEvidenceSynthesisSampleSizeSurrogate.numberOfStudies,
          this@EffectEvidenceSynthesisSampleSizeSurrogate._numberOfStudies,
        ),
      numberOfParticipants =
        Integer.of(
          this@EffectEvidenceSynthesisSampleSizeSurrogate.numberOfParticipants,
          this@EffectEvidenceSynthesisSampleSizeSurrogate._numberOfParticipants,
        ),
    )

  public companion object {
    public fun fromModel(
      model: EffectEvidenceSynthesis.SampleSize
    ): EffectEvidenceSynthesisSampleSizeSurrogate =
      with(model) {
        EffectEvidenceSynthesisSampleSizeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          numberOfStudies = this@with.numberOfStudies?.value,
          _numberOfStudies = this@with.numberOfStudies?.toElement(),
          numberOfParticipants = this@with.numberOfParticipants?.value,
          _numberOfParticipants = this@with.numberOfParticipants?.toElement(),
        )
      }
  }
}

@Serializable
internal data class EffectEvidenceSynthesisResultsByExposureSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var exposureState: KotlinString? = null,
  public var _exposureState: Element? = null,
  public var variantState: CodeableConcept? = null,
  public var riskEvidenceSynthesis: Reference,
) {
  public fun toModel(): EffectEvidenceSynthesis.ResultsByExposure =
    EffectEvidenceSynthesis.ResultsByExposure(
      id = this@EffectEvidenceSynthesisResultsByExposureSurrogate.id,
      extension = this@EffectEvidenceSynthesisResultsByExposureSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EffectEvidenceSynthesisResultsByExposureSurrogate.modifierExtension ?: listOf(),
      description =
        R4String.of(
          this@EffectEvidenceSynthesisResultsByExposureSurrogate.description,
          this@EffectEvidenceSynthesisResultsByExposureSurrogate._description,
        ),
      exposureState =
        this@EffectEvidenceSynthesisResultsByExposureSurrogate.exposureState?.let {
          Enumeration.of(
            EffectEvidenceSynthesis.ExposureState.fromCode(it),
            this@EffectEvidenceSynthesisResultsByExposureSurrogate._exposureState,
          )
        },
      variantState = this@EffectEvidenceSynthesisResultsByExposureSurrogate.variantState,
      riskEvidenceSynthesis =
        this@EffectEvidenceSynthesisResultsByExposureSurrogate.riskEvidenceSynthesis,
    )

  public companion object {
    public fun fromModel(
      model: EffectEvidenceSynthesis.ResultsByExposure
    ): EffectEvidenceSynthesisResultsByExposureSurrogate =
      with(model) {
        EffectEvidenceSynthesisResultsByExposureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          exposureState = this@with.exposureState?.value?.getCode(),
          _exposureState = this@with.exposureState?.toElement(),
          variantState = this@with.variantState,
          riskEvidenceSynthesis = this@with.riskEvidenceSynthesis,
        )
      }
  }
}

@Serializable
internal data class EffectEvidenceSynthesisEffectEstimateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var type: CodeableConcept? = null,
  public var variantState: CodeableConcept? = null,
  public var `value`: Double? = null,
  public var _value: Element? = null,
  public var unitOfMeasure: CodeableConcept? = null,
  public var precisionEstimate: List<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate>? =
    null,
) {
  public fun toModel(): EffectEvidenceSynthesis.EffectEstimate =
    EffectEvidenceSynthesis.EffectEstimate(
      id = this@EffectEvidenceSynthesisEffectEstimateSurrogate.id,
      extension = this@EffectEvidenceSynthesisEffectEstimateSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EffectEvidenceSynthesisEffectEstimateSurrogate.modifierExtension ?: listOf(),
      description =
        R4String.of(
          this@EffectEvidenceSynthesisEffectEstimateSurrogate.description,
          this@EffectEvidenceSynthesisEffectEstimateSurrogate._description,
        ),
      type = this@EffectEvidenceSynthesisEffectEstimateSurrogate.type,
      variantState = this@EffectEvidenceSynthesisEffectEstimateSurrogate.variantState,
      `value` =
        Decimal.of(
          this@EffectEvidenceSynthesisEffectEstimateSurrogate.`value`,
          this@EffectEvidenceSynthesisEffectEstimateSurrogate._value,
        ),
      unitOfMeasure = this@EffectEvidenceSynthesisEffectEstimateSurrogate.unitOfMeasure,
      precisionEstimate =
        this@EffectEvidenceSynthesisEffectEstimateSurrogate.precisionEstimate ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: EffectEvidenceSynthesis.EffectEstimate
    ): EffectEvidenceSynthesisEffectEstimateSurrogate =
      with(model) {
        EffectEvidenceSynthesisEffectEstimateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          type = this@with.type,
          variantState = this@with.variantState,
          `value` = this@with.`value`?.value?.toString()?.toDouble(),
          _value = this@with.`value`?.toElement(),
          unitOfMeasure = this@with.unitOfMeasure,
          precisionEstimate = this@with.precisionEstimate.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var level: Double? = null,
  public var _level: Element? = null,
  public var from: Double? = null,
  public var _from: Element? = null,
  public var to: Double? = null,
  public var _to: Element? = null,
) {
  public fun toModel(): EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate =
    EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate(
      id = this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.id,
      extension =
        this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.modifierExtension
          ?: listOf(),
      type = this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.type,
      level =
        Decimal.of(
          this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.level,
          this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate._level,
        ),
      from =
        Decimal.of(
          this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.from,
          this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate._from,
        ),
      to =
        Decimal.of(
          this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.to,
          this@EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate._to,
        ),
    )

  public companion object {
    public fun fromModel(
      model: EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate
    ): EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate =
      with(model) {
        EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          level = this@with.level?.value?.toString()?.toDouble(),
          _level = this@with.level?.toElement(),
          from = this@with.from?.value?.toString()?.toDouble(),
          _from = this@with.from?.toElement(),
          to = this@with.to?.value?.toString()?.toDouble(),
          _to = this@with.to?.toElement(),
        )
      }
  }
}

@Serializable
internal data class EffectEvidenceSynthesisCertaintySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var rating: List<CodeableConcept>? = null,
  public var note: List<Annotation>? = null,
  public var certaintySubcomponent: List<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent>? =
    null,
) {
  public fun toModel(): EffectEvidenceSynthesis.Certainty =
    EffectEvidenceSynthesis.Certainty(
      id = this@EffectEvidenceSynthesisCertaintySurrogate.id,
      extension = this@EffectEvidenceSynthesisCertaintySurrogate.extension ?: listOf(),
      modifierExtension =
        this@EffectEvidenceSynthesisCertaintySurrogate.modifierExtension ?: listOf(),
      rating = this@EffectEvidenceSynthesisCertaintySurrogate.rating ?: listOf(),
      note = this@EffectEvidenceSynthesisCertaintySurrogate.note ?: listOf(),
      certaintySubcomponent =
        this@EffectEvidenceSynthesisCertaintySurrogate.certaintySubcomponent ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: EffectEvidenceSynthesis.Certainty
    ): EffectEvidenceSynthesisCertaintySurrogate =
      with(model) {
        EffectEvidenceSynthesisCertaintySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          rating = this@with.rating.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          certaintySubcomponent = this@with.certaintySubcomponent.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var rating: List<CodeableConcept>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): EffectEvidenceSynthesis.Certainty.CertaintySubcomponent =
    EffectEvidenceSynthesis.Certainty.CertaintySubcomponent(
      id = this@EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.id,
      extension =
        this@EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.modifierExtension
          ?: listOf(),
      type = this@EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.type,
      rating =
        this@EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.rating ?: listOf(),
      note = this@EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: EffectEvidenceSynthesis.Certainty.CertaintySubcomponent
    ): EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate =
      with(model) {
        EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          rating = this@with.rating.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EffectEvidenceSynthesisSurrogate(
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
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var note: List<Annotation>? = null,
  public var useContext: List<UsageContext>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
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
  public var synthesisType: CodeableConcept? = null,
  public var studyType: CodeableConcept? = null,
  public var population: Reference,
  public var exposure: Reference,
  public var exposureAlternative: Reference,
  public var outcome: Reference,
  public var sampleSize: EffectEvidenceSynthesis.SampleSize? = null,
  public var resultsByExposure: List<EffectEvidenceSynthesis.ResultsByExposure>? = null,
  public var effectEstimate: List<EffectEvidenceSynthesis.EffectEstimate>? = null,
  public var certainty: List<EffectEvidenceSynthesis.Certainty>? = null,
) {
  public fun toModel(): EffectEvidenceSynthesis =
    EffectEvidenceSynthesis(
      id = this@EffectEvidenceSynthesisSurrogate.id,
      meta = this@EffectEvidenceSynthesisSurrogate.meta,
      implicitRules =
        Uri.of(
          this@EffectEvidenceSynthesisSurrogate.implicitRules,
          this@EffectEvidenceSynthesisSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@EffectEvidenceSynthesisSurrogate.language,
          this@EffectEvidenceSynthesisSurrogate._language,
        ),
      text = this@EffectEvidenceSynthesisSurrogate.text,
      contained = this@EffectEvidenceSynthesisSurrogate.contained ?: listOf(),
      extension = this@EffectEvidenceSynthesisSurrogate.extension ?: listOf(),
      modifierExtension = this@EffectEvidenceSynthesisSurrogate.modifierExtension ?: listOf(),
      url =
        Uri.of(
          this@EffectEvidenceSynthesisSurrogate.url,
          this@EffectEvidenceSynthesisSurrogate._url,
        ),
      identifier = this@EffectEvidenceSynthesisSurrogate.identifier ?: listOf(),
      version =
        R4String.of(
          this@EffectEvidenceSynthesisSurrogate.version,
          this@EffectEvidenceSynthesisSurrogate._version,
        ),
      name =
        R4String.of(
          this@EffectEvidenceSynthesisSurrogate.name,
          this@EffectEvidenceSynthesisSurrogate._name,
        ),
      title =
        R4String.of(
          this@EffectEvidenceSynthesisSurrogate.title,
          this@EffectEvidenceSynthesisSurrogate._title,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@EffectEvidenceSynthesisSurrogate.status!!),
          this@EffectEvidenceSynthesisSurrogate._status,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@EffectEvidenceSynthesisSurrogate.date),
          this@EffectEvidenceSynthesisSurrogate._date,
        ),
      publisher =
        R4String.of(
          this@EffectEvidenceSynthesisSurrogate.publisher,
          this@EffectEvidenceSynthesisSurrogate._publisher,
        ),
      contact = this@EffectEvidenceSynthesisSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@EffectEvidenceSynthesisSurrogate.description,
          this@EffectEvidenceSynthesisSurrogate._description,
        ),
      note = this@EffectEvidenceSynthesisSurrogate.note ?: listOf(),
      useContext = this@EffectEvidenceSynthesisSurrogate.useContext ?: listOf(),
      jurisdiction = this@EffectEvidenceSynthesisSurrogate.jurisdiction ?: listOf(),
      copyright =
        Markdown.of(
          this@EffectEvidenceSynthesisSurrogate.copyright,
          this@EffectEvidenceSynthesisSurrogate._copyright,
        ),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@EffectEvidenceSynthesisSurrogate.approvalDate),
          this@EffectEvidenceSynthesisSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@EffectEvidenceSynthesisSurrogate.lastReviewDate),
          this@EffectEvidenceSynthesisSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@EffectEvidenceSynthesisSurrogate.effectivePeriod,
      topic = this@EffectEvidenceSynthesisSurrogate.topic ?: listOf(),
      author = this@EffectEvidenceSynthesisSurrogate.author ?: listOf(),
      editor = this@EffectEvidenceSynthesisSurrogate.editor ?: listOf(),
      reviewer = this@EffectEvidenceSynthesisSurrogate.reviewer ?: listOf(),
      endorser = this@EffectEvidenceSynthesisSurrogate.endorser ?: listOf(),
      relatedArtifact = this@EffectEvidenceSynthesisSurrogate.relatedArtifact ?: listOf(),
      synthesisType = this@EffectEvidenceSynthesisSurrogate.synthesisType,
      studyType = this@EffectEvidenceSynthesisSurrogate.studyType,
      population = this@EffectEvidenceSynthesisSurrogate.population,
      exposure = this@EffectEvidenceSynthesisSurrogate.exposure,
      exposureAlternative = this@EffectEvidenceSynthesisSurrogate.exposureAlternative,
      outcome = this@EffectEvidenceSynthesisSurrogate.outcome,
      sampleSize = this@EffectEvidenceSynthesisSurrogate.sampleSize,
      resultsByExposure = this@EffectEvidenceSynthesisSurrogate.resultsByExposure ?: listOf(),
      effectEstimate = this@EffectEvidenceSynthesisSurrogate.effectEstimate ?: listOf(),
      certainty = this@EffectEvidenceSynthesisSurrogate.certainty ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: EffectEvidenceSynthesis): EffectEvidenceSynthesisSurrogate =
      with(model) {
        EffectEvidenceSynthesisSurrogate(
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
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
          synthesisType = this@with.synthesisType,
          studyType = this@with.studyType,
          population = this@with.population,
          exposure = this@with.exposure,
          exposureAlternative = this@with.exposureAlternative,
          outcome = this@with.outcome,
          sampleSize = this@with.sampleSize,
          resultsByExposure = this@with.resultsByExposure.takeIf { it.isNotEmpty() },
          effectEstimate = this@with.effectEstimate.takeIf { it.isNotEmpty() },
          certainty = this@with.certainty.takeIf { it.isNotEmpty() },
        )
      }
  }
}
