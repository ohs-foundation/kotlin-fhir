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

import com.google.fhir.model.r4b.Annotation
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Decimal
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Evidence
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Range
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.RelatedArtifact
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.UnsignedInt
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class EvidenceVariableDefinitionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var note: List<Annotation>? = null,
  public var variableRole: CodeableConcept,
  public var observed: Reference? = null,
  public var intended: Reference? = null,
  public var directnessMatch: CodeableConcept? = null,
) {
  public fun toModel(): Evidence.VariableDefinition =
    Evidence.VariableDefinition(
      id = this@EvidenceVariableDefinitionSurrogate.id,
      extension = this@EvidenceVariableDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceVariableDefinitionSurrogate.modifierExtension ?: listOf(),
      description =
        Markdown.of(
          this@EvidenceVariableDefinitionSurrogate.description,
          this@EvidenceVariableDefinitionSurrogate._description,
        ),
      note = this@EvidenceVariableDefinitionSurrogate.note ?: listOf(),
      variableRole = this@EvidenceVariableDefinitionSurrogate.variableRole,
      observed = this@EvidenceVariableDefinitionSurrogate.observed,
      intended = this@EvidenceVariableDefinitionSurrogate.intended,
      directnessMatch = this@EvidenceVariableDefinitionSurrogate.directnessMatch,
    )

  public companion object {
    public fun fromModel(model: Evidence.VariableDefinition): EvidenceVariableDefinitionSurrogate =
      with(model) {
        EvidenceVariableDefinitionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          variableRole = this@with.variableRole,
          observed = this@with.observed,
          intended = this@with.intended,
          directnessMatch = this@with.directnessMatch,
        )
      }
  }
}

@Serializable
internal data class EvidenceStatisticSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var note: List<Annotation>? = null,
  public var statisticType: CodeableConcept? = null,
  public var category: CodeableConcept? = null,
  public var quantity: Quantity? = null,
  public var numberOfEvents: Int? = null,
  public var _numberOfEvents: Element? = null,
  public var numberAffected: Int? = null,
  public var _numberAffected: Element? = null,
  public var sampleSize: Evidence.Statistic.SampleSize? = null,
  public var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null,
  public var modelCharacteristic: List<Evidence.Statistic.ModelCharacteristic>? = null,
) {
  public fun toModel(): Evidence.Statistic =
    Evidence.Statistic(
      id = this@EvidenceStatisticSurrogate.id,
      extension = this@EvidenceStatisticSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceStatisticSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@EvidenceStatisticSurrogate.description,
          this@EvidenceStatisticSurrogate._description,
        ),
      note = this@EvidenceStatisticSurrogate.note ?: listOf(),
      statisticType = this@EvidenceStatisticSurrogate.statisticType,
      category = this@EvidenceStatisticSurrogate.category,
      quantity = this@EvidenceStatisticSurrogate.quantity,
      numberOfEvents =
        UnsignedInt.of(
          this@EvidenceStatisticSurrogate.numberOfEvents,
          this@EvidenceStatisticSurrogate._numberOfEvents,
        ),
      numberAffected =
        UnsignedInt.of(
          this@EvidenceStatisticSurrogate.numberAffected,
          this@EvidenceStatisticSurrogate._numberAffected,
        ),
      sampleSize = this@EvidenceStatisticSurrogate.sampleSize,
      attributeEstimate = this@EvidenceStatisticSurrogate.attributeEstimate ?: listOf(),
      modelCharacteristic = this@EvidenceStatisticSurrogate.modelCharacteristic ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Evidence.Statistic): EvidenceStatisticSurrogate =
      with(model) {
        EvidenceStatisticSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          statisticType = this@with.statisticType,
          category = this@with.category,
          quantity = this@with.quantity,
          numberOfEvents = this@with.numberOfEvents?.value,
          _numberOfEvents = this@with.numberOfEvents?.toElement(),
          numberAffected = this@with.numberAffected?.value,
          _numberAffected = this@with.numberAffected?.toElement(),
          sampleSize = this@with.sampleSize,
          attributeEstimate = this@with.attributeEstimate.takeIf { it.isNotEmpty() },
          modelCharacteristic = this@with.modelCharacteristic.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EvidenceStatisticSampleSizeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var note: List<Annotation>? = null,
  public var numberOfStudies: Int? = null,
  public var _numberOfStudies: Element? = null,
  public var numberOfParticipants: Int? = null,
  public var _numberOfParticipants: Element? = null,
  public var knownDataCount: Int? = null,
  public var _knownDataCount: Element? = null,
) {
  public fun toModel(): Evidence.Statistic.SampleSize =
    Evidence.Statistic.SampleSize(
      id = this@EvidenceStatisticSampleSizeSurrogate.id,
      extension = this@EvidenceStatisticSampleSizeSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceStatisticSampleSizeSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@EvidenceStatisticSampleSizeSurrogate.description,
          this@EvidenceStatisticSampleSizeSurrogate._description,
        ),
      note = this@EvidenceStatisticSampleSizeSurrogate.note ?: listOf(),
      numberOfStudies =
        UnsignedInt.of(
          this@EvidenceStatisticSampleSizeSurrogate.numberOfStudies,
          this@EvidenceStatisticSampleSizeSurrogate._numberOfStudies,
        ),
      numberOfParticipants =
        UnsignedInt.of(
          this@EvidenceStatisticSampleSizeSurrogate.numberOfParticipants,
          this@EvidenceStatisticSampleSizeSurrogate._numberOfParticipants,
        ),
      knownDataCount =
        UnsignedInt.of(
          this@EvidenceStatisticSampleSizeSurrogate.knownDataCount,
          this@EvidenceStatisticSampleSizeSurrogate._knownDataCount,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Evidence.Statistic.SampleSize
    ): EvidenceStatisticSampleSizeSurrogate =
      with(model) {
        EvidenceStatisticSampleSizeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          numberOfStudies = this@with.numberOfStudies?.value,
          _numberOfStudies = this@with.numberOfStudies?.toElement(),
          numberOfParticipants = this@with.numberOfParticipants?.value,
          _numberOfParticipants = this@with.numberOfParticipants?.toElement(),
          knownDataCount = this@with.knownDataCount?.value,
          _knownDataCount = this@with.knownDataCount?.toElement(),
        )
      }
  }
}

@Serializable
internal data class EvidenceStatisticAttributeEstimateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var note: List<Annotation>? = null,
  public var type: CodeableConcept? = null,
  public var quantity: Quantity? = null,
  public var level: Double? = null,
  public var _level: Element? = null,
  public var range: Range? = null,
  public var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null,
) {
  public fun toModel(): Evidence.Statistic.AttributeEstimate =
    Evidence.Statistic.AttributeEstimate(
      id = this@EvidenceStatisticAttributeEstimateSurrogate.id,
      extension = this@EvidenceStatisticAttributeEstimateSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EvidenceStatisticAttributeEstimateSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@EvidenceStatisticAttributeEstimateSurrogate.description,
          this@EvidenceStatisticAttributeEstimateSurrogate._description,
        ),
      note = this@EvidenceStatisticAttributeEstimateSurrogate.note ?: listOf(),
      type = this@EvidenceStatisticAttributeEstimateSurrogate.type,
      quantity = this@EvidenceStatisticAttributeEstimateSurrogate.quantity,
      level =
        Decimal.of(
          this@EvidenceStatisticAttributeEstimateSurrogate.level,
          this@EvidenceStatisticAttributeEstimateSurrogate._level,
        ),
      range = this@EvidenceStatisticAttributeEstimateSurrogate.range,
      attributeEstimate =
        this@EvidenceStatisticAttributeEstimateSurrogate.attributeEstimate ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: Evidence.Statistic.AttributeEstimate
    ): EvidenceStatisticAttributeEstimateSurrogate =
      with(model) {
        EvidenceStatisticAttributeEstimateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          type = this@with.type,
          quantity = this@with.quantity,
          level = this@with.level?.value?.toString()?.toDouble(),
          _level = this@with.level?.toElement(),
          range = this@with.range,
          attributeEstimate = this@with.attributeEstimate.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EvidenceStatisticModelCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var `value`: Quantity? = null,
  public var variable: List<Evidence.Statistic.ModelCharacteristic.Variable>? = null,
  public var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null,
) {
  public fun toModel(): Evidence.Statistic.ModelCharacteristic =
    Evidence.Statistic.ModelCharacteristic(
      id = this@EvidenceStatisticModelCharacteristicSurrogate.id,
      extension = this@EvidenceStatisticModelCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EvidenceStatisticModelCharacteristicSurrogate.modifierExtension ?: listOf(),
      code = this@EvidenceStatisticModelCharacteristicSurrogate.code,
      `value` = this@EvidenceStatisticModelCharacteristicSurrogate.`value`,
      variable = this@EvidenceStatisticModelCharacteristicSurrogate.variable ?: listOf(),
      attributeEstimate =
        this@EvidenceStatisticModelCharacteristicSurrogate.attributeEstimate ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: Evidence.Statistic.ModelCharacteristic
    ): EvidenceStatisticModelCharacteristicSurrogate =
      with(model) {
        EvidenceStatisticModelCharacteristicSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          `value` = this@with.`value`,
          variable = this@with.variable.takeIf { it.isNotEmpty() },
          attributeEstimate = this@with.attributeEstimate.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EvidenceStatisticModelCharacteristicVariableSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var variableDefinition: Reference,
  public var handling: KotlinString? = null,
  public var _handling: Element? = null,
  public var valueCategory: List<CodeableConcept>? = null,
  public var valueQuantity: List<Quantity>? = null,
  public var valueRange: List<Range>? = null,
) {
  public fun toModel(): Evidence.Statistic.ModelCharacteristic.Variable =
    Evidence.Statistic.ModelCharacteristic.Variable(
      id = this@EvidenceStatisticModelCharacteristicVariableSurrogate.id,
      extension = this@EvidenceStatisticModelCharacteristicVariableSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EvidenceStatisticModelCharacteristicVariableSurrogate.modifierExtension ?: listOf(),
      variableDefinition =
        this@EvidenceStatisticModelCharacteristicVariableSurrogate.variableDefinition,
      handling =
        this@EvidenceStatisticModelCharacteristicVariableSurrogate.handling?.let {
          Enumeration.of(
            Evidence.EvidenceVariableHandling.fromCode(it),
            this@EvidenceStatisticModelCharacteristicVariableSurrogate._handling,
          )
        },
      valueCategory =
        this@EvidenceStatisticModelCharacteristicVariableSurrogate.valueCategory ?: listOf(),
      valueQuantity =
        this@EvidenceStatisticModelCharacteristicVariableSurrogate.valueQuantity ?: listOf(),
      valueRange = this@EvidenceStatisticModelCharacteristicVariableSurrogate.valueRange ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: Evidence.Statistic.ModelCharacteristic.Variable
    ): EvidenceStatisticModelCharacteristicVariableSurrogate =
      with(model) {
        EvidenceStatisticModelCharacteristicVariableSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          variableDefinition = this@with.variableDefinition,
          handling = this@with.handling?.value?.getCode(),
          _handling = this@with.handling?.toElement(),
          valueCategory = this@with.valueCategory.takeIf { it.isNotEmpty() },
          valueQuantity = this@with.valueQuantity.takeIf { it.isNotEmpty() },
          valueRange = this@with.valueRange.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EvidenceCertaintySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var note: List<Annotation>? = null,
  public var type: CodeableConcept? = null,
  public var rating: CodeableConcept? = null,
  public var rater: KotlinString? = null,
  public var _rater: Element? = null,
  public var subcomponent: List<Evidence.Certainty>? = null,
) {
  public fun toModel(): Evidence.Certainty =
    Evidence.Certainty(
      id = this@EvidenceCertaintySurrogate.id,
      extension = this@EvidenceCertaintySurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceCertaintySurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@EvidenceCertaintySurrogate.description,
          this@EvidenceCertaintySurrogate._description,
        ),
      note = this@EvidenceCertaintySurrogate.note ?: listOf(),
      type = this@EvidenceCertaintySurrogate.type,
      rating = this@EvidenceCertaintySurrogate.rating,
      rater =
        R4bString.of(this@EvidenceCertaintySurrogate.rater, this@EvidenceCertaintySurrogate._rater),
      subcomponent = this@EvidenceCertaintySurrogate.subcomponent ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Evidence.Certainty): EvidenceCertaintySurrogate =
      with(model) {
        EvidenceCertaintySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          type = this@with.type,
          rating = this@with.rating,
          rater = this@with.rater?.value,
          _rater = this@with.rater?.toElement(),
          subcomponent = this@with.subcomponent.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EvidenceCiteAsSurrogate(
  public var citeAsReference: Reference? = null,
  public var citeAsMarkdown: KotlinString? = null,
  public var _citeAsMarkdown: Element? = null,
) {
  public fun toModel(): Evidence.CiteAs =
    Evidence.CiteAs.from(
      this@EvidenceCiteAsSurrogate.citeAsReference,
      Markdown.of(
        this@EvidenceCiteAsSurrogate.citeAsMarkdown,
        this@EvidenceCiteAsSurrogate._citeAsMarkdown,
      ),
    )!!

  public companion object {
    public fun fromModel(model: Evidence.CiteAs): EvidenceCiteAsSurrogate =
      with(model) {
        EvidenceCiteAsSurrogate(
          citeAsReference = this@with.asReference()?.value,
          citeAsMarkdown = this@with.asMarkdown()?.value?.value,
          _citeAsMarkdown = this@with.asMarkdown()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class EvidenceSurrogate(
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
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var citeAs: Evidence.CiteAs? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var approvalDate: KotlinString? = null,
  public var _approvalDate: Element? = null,
  public var lastReviewDate: KotlinString? = null,
  public var _lastReviewDate: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var author: List<ContactDetail>? = null,
  public var editor: List<ContactDetail>? = null,
  public var reviewer: List<ContactDetail>? = null,
  public var endorser: List<ContactDetail>? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var assertion: KotlinString? = null,
  public var _assertion: Element? = null,
  public var note: List<Annotation>? = null,
  public var variableDefinition: List<Evidence.VariableDefinition>? = null,
  public var synthesisType: CodeableConcept? = null,
  public var studyType: CodeableConcept? = null,
  public var statistic: List<Evidence.Statistic>? = null,
  public var certainty: List<Evidence.Certainty>? = null,
) {
  public fun toModel(): Evidence =
    Evidence(
      id = this@EvidenceSurrogate.id,
      meta = this@EvidenceSurrogate.meta,
      implicitRules =
        Uri.of(this@EvidenceSurrogate.implicitRules, this@EvidenceSurrogate._implicitRules),
      language = Code.of(this@EvidenceSurrogate.language, this@EvidenceSurrogate._language),
      text = this@EvidenceSurrogate.text,
      contained = this@EvidenceSurrogate.contained ?: listOf(),
      extension = this@EvidenceSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@EvidenceSurrogate.url, this@EvidenceSurrogate._url),
      identifier = this@EvidenceSurrogate.identifier ?: listOf(),
      version = R4bString.of(this@EvidenceSurrogate.version, this@EvidenceSurrogate._version),
      title = R4bString.of(this@EvidenceSurrogate.title, this@EvidenceSurrogate._title),
      citeAs = this@EvidenceSurrogate.citeAs,
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@EvidenceSurrogate.status!!),
          this@EvidenceSurrogate._status,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@EvidenceSurrogate.date),
          this@EvidenceSurrogate._date,
        ),
      useContext = this@EvidenceSurrogate.useContext ?: listOf(),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@EvidenceSurrogate.approvalDate),
          this@EvidenceSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@EvidenceSurrogate.lastReviewDate),
          this@EvidenceSurrogate._lastReviewDate,
        ),
      publisher = R4bString.of(this@EvidenceSurrogate.publisher, this@EvidenceSurrogate._publisher),
      contact = this@EvidenceSurrogate.contact ?: listOf(),
      author = this@EvidenceSurrogate.author ?: listOf(),
      editor = this@EvidenceSurrogate.editor ?: listOf(),
      reviewer = this@EvidenceSurrogate.reviewer ?: listOf(),
      endorser = this@EvidenceSurrogate.endorser ?: listOf(),
      relatedArtifact = this@EvidenceSurrogate.relatedArtifact ?: listOf(),
      description =
        Markdown.of(this@EvidenceSurrogate.description, this@EvidenceSurrogate._description),
      assertion = Markdown.of(this@EvidenceSurrogate.assertion, this@EvidenceSurrogate._assertion),
      note = this@EvidenceSurrogate.note ?: listOf(),
      variableDefinition = this@EvidenceSurrogate.variableDefinition ?: listOf(),
      synthesisType = this@EvidenceSurrogate.synthesisType,
      studyType = this@EvidenceSurrogate.studyType,
      statistic = this@EvidenceSurrogate.statistic ?: listOf(),
      certainty = this@EvidenceSurrogate.certainty ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Evidence): EvidenceSurrogate =
      with(model) {
        EvidenceSurrogate(
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
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          citeAs = this@with.citeAs,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          approvalDate = this@with.approvalDate?.value?.toString(),
          _approvalDate = this@with.approvalDate?.toElement(),
          lastReviewDate = this@with.lastReviewDate?.value?.toString(),
          _lastReviewDate = this@with.lastReviewDate?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          author = this@with.author.takeIf { it.isNotEmpty() },
          editor = this@with.editor.takeIf { it.isNotEmpty() },
          reviewer = this@with.reviewer.takeIf { it.isNotEmpty() },
          endorser = this@with.endorser.takeIf { it.isNotEmpty() },
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          assertion = this@with.assertion?.value,
          _assertion = this@with.assertion?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          variableDefinition = this@with.variableDefinition.takeIf { it.isNotEmpty() },
          synthesisType = this@with.synthesisType,
          studyType = this@with.studyType,
          statistic = this@with.statistic.takeIf { it.isNotEmpty() },
          certainty = this@with.certainty.takeIf { it.isNotEmpty() },
        )
      }
  }
}
