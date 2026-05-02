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

import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Canonical
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.ContactDetail
import com.google.fhir.model.r4.DataRequirement
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Duration
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Expression
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDate
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Markdown
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.RelatedArtifact
import com.google.fhir.model.r4.ResearchElementDefinition
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Timing
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.UsageContext
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ResearchElementDefinitionCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var definition: ResearchElementDefinition.Characteristic.Definition,
  public var usageContext: List<UsageContext>? = null,
  public var exclude: KotlinBoolean? = null,
  public var _exclude: Element? = null,
  public var unitOfMeasure: CodeableConcept? = null,
  public var studyEffectiveDescription: KotlinString? = null,
  public var _studyEffectiveDescription: Element? = null,
  public var studyEffective: ResearchElementDefinition.Characteristic.StudyEffective? = null,
  public var studyEffectiveTimeFromStart: Duration? = null,
  public var studyEffectiveGroupMeasure: KotlinString? = null,
  public var _studyEffectiveGroupMeasure: Element? = null,
  public var participantEffectiveDescription: KotlinString? = null,
  public var _participantEffectiveDescription: Element? = null,
  public var participantEffective: ResearchElementDefinition.Characteristic.ParticipantEffective? =
    null,
  public var participantEffectiveTimeFromStart: Duration? = null,
  public var participantEffectiveGroupMeasure: KotlinString? = null,
  public var _participantEffectiveGroupMeasure: Element? = null,
) {
  public fun toModel(): ResearchElementDefinition.Characteristic =
    ResearchElementDefinition.Characteristic(
      id = this@ResearchElementDefinitionCharacteristicSurrogate.id,
      extension = this@ResearchElementDefinitionCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ResearchElementDefinitionCharacteristicSurrogate.modifierExtension ?: listOf(),
      definition = this@ResearchElementDefinitionCharacteristicSurrogate.definition,
      usageContext = this@ResearchElementDefinitionCharacteristicSurrogate.usageContext ?: listOf(),
      exclude =
        R4Boolean.of(
          this@ResearchElementDefinitionCharacteristicSurrogate.exclude,
          this@ResearchElementDefinitionCharacteristicSurrogate._exclude,
        ),
      unitOfMeasure = this@ResearchElementDefinitionCharacteristicSurrogate.unitOfMeasure,
      studyEffectiveDescription =
        R4String.of(
          this@ResearchElementDefinitionCharacteristicSurrogate.studyEffectiveDescription,
          this@ResearchElementDefinitionCharacteristicSurrogate._studyEffectiveDescription,
        ),
      studyEffective = this@ResearchElementDefinitionCharacteristicSurrogate.studyEffective,
      studyEffectiveTimeFromStart =
        this@ResearchElementDefinitionCharacteristicSurrogate.studyEffectiveTimeFromStart,
      studyEffectiveGroupMeasure =
        this@ResearchElementDefinitionCharacteristicSurrogate.studyEffectiveGroupMeasure?.let {
          Enumeration.of(
            ResearchElementDefinition.GroupMeasure.fromCode(it),
            this@ResearchElementDefinitionCharacteristicSurrogate._studyEffectiveGroupMeasure,
          )
        },
      participantEffectiveDescription =
        R4String.of(
          this@ResearchElementDefinitionCharacteristicSurrogate.participantEffectiveDescription,
          this@ResearchElementDefinitionCharacteristicSurrogate._participantEffectiveDescription,
        ),
      participantEffective =
        this@ResearchElementDefinitionCharacteristicSurrogate.participantEffective,
      participantEffectiveTimeFromStart =
        this@ResearchElementDefinitionCharacteristicSurrogate.participantEffectiveTimeFromStart,
      participantEffectiveGroupMeasure =
        this@ResearchElementDefinitionCharacteristicSurrogate.participantEffectiveGroupMeasure
          ?.let {
            Enumeration.of(
              ResearchElementDefinition.GroupMeasure.fromCode(it),
              this@ResearchElementDefinitionCharacteristicSurrogate
                ._participantEffectiveGroupMeasure,
            )
          },
    )

  public companion object {
    public fun fromModel(
      model: ResearchElementDefinition.Characteristic
    ): ResearchElementDefinitionCharacteristicSurrogate =
      with(model) {
        ResearchElementDefinitionCharacteristicSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          definition = this@with.definition,
          usageContext = this@with.usageContext.takeIf { it.isNotEmpty() },
          exclude = this@with.exclude?.value,
          _exclude = this@with.exclude?.toElement(),
          unitOfMeasure = this@with.unitOfMeasure,
          studyEffectiveDescription = this@with.studyEffectiveDescription?.value,
          _studyEffectiveDescription = this@with.studyEffectiveDescription?.toElement(),
          studyEffective = this@with.studyEffective,
          studyEffectiveTimeFromStart = this@with.studyEffectiveTimeFromStart,
          studyEffectiveGroupMeasure = this@with.studyEffectiveGroupMeasure?.value?.getCode(),
          _studyEffectiveGroupMeasure = this@with.studyEffectiveGroupMeasure?.toElement(),
          participantEffectiveDescription = this@with.participantEffectiveDescription?.value,
          _participantEffectiveDescription = this@with.participantEffectiveDescription?.toElement(),
          participantEffective = this@with.participantEffective,
          participantEffectiveTimeFromStart = this@with.participantEffectiveTimeFromStart,
          participantEffectiveGroupMeasure =
            this@with.participantEffectiveGroupMeasure?.value?.getCode(),
          _participantEffectiveGroupMeasure =
            this@with.participantEffectiveGroupMeasure?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ResearchElementDefinitionSubjectSurrogate(
  public var subjectCodeableConcept: CodeableConcept? = null,
  public var subjectReference: Reference? = null,
) {
  public fun toModel(): ResearchElementDefinition.Subject =
    ResearchElementDefinition.Subject.from(
      this@ResearchElementDefinitionSubjectSurrogate.subjectCodeableConcept,
      this@ResearchElementDefinitionSubjectSurrogate.subjectReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ResearchElementDefinition.Subject
    ): ResearchElementDefinitionSubjectSurrogate =
      with(model) {
        ResearchElementDefinitionSubjectSurrogate(
          subjectCodeableConcept = this@with.asCodeableConcept()?.value,
          subjectReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ResearchElementDefinitionCharacteristicDefinitionSurrogate(
  public var definitionCodeableConcept: CodeableConcept? = null,
  public var definitionCanonical: KotlinString? = null,
  public var _definitionCanonical: Element? = null,
  public var definitionExpression: Expression? = null,
  public var definitionDataRequirement: DataRequirement? = null,
) {
  public fun toModel(): ResearchElementDefinition.Characteristic.Definition =
    ResearchElementDefinition.Characteristic.Definition.from(
      this@ResearchElementDefinitionCharacteristicDefinitionSurrogate.definitionCodeableConcept,
      Canonical.of(
        this@ResearchElementDefinitionCharacteristicDefinitionSurrogate.definitionCanonical,
        this@ResearchElementDefinitionCharacteristicDefinitionSurrogate._definitionCanonical,
      ),
      this@ResearchElementDefinitionCharacteristicDefinitionSurrogate.definitionExpression,
      this@ResearchElementDefinitionCharacteristicDefinitionSurrogate.definitionDataRequirement,
    )!!

  public companion object {
    public fun fromModel(
      model: ResearchElementDefinition.Characteristic.Definition
    ): ResearchElementDefinitionCharacteristicDefinitionSurrogate =
      with(model) {
        ResearchElementDefinitionCharacteristicDefinitionSurrogate(
          definitionCodeableConcept = this@with.asCodeableConcept()?.value,
          definitionCanonical = this@with.asCanonical()?.value?.value,
          _definitionCanonical = this@with.asCanonical()?.value?.toElement(),
          definitionExpression = this@with.asExpression()?.value,
          definitionDataRequirement = this@with.asDataRequirement()?.value,
        )
      }
  }
}

@Serializable
internal data class ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate(
  public var studyEffectiveDateTime: KotlinString? = null,
  public var _studyEffectiveDateTime: Element? = null,
  public var studyEffectivePeriod: Period? = null,
  public var studyEffectiveDuration: Duration? = null,
  public var studyEffectiveTiming: Timing? = null,
) {
  public fun toModel(): ResearchElementDefinition.Characteristic.StudyEffective =
    ResearchElementDefinition.Characteristic.StudyEffective.from(
      DateTime.of(
        FhirDateTime.fromString(
          this@ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate.studyEffectiveDateTime
        ),
        this@ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate._studyEffectiveDateTime,
      ),
      this@ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate.studyEffectivePeriod,
      this@ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate.studyEffectiveDuration,
      this@ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate.studyEffectiveTiming,
    )!!

  public companion object {
    public fun fromModel(
      model: ResearchElementDefinition.Characteristic.StudyEffective
    ): ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate =
      with(model) {
        ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate(
          studyEffectiveDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _studyEffectiveDateTime = this@with.asDateTime()?.value?.toElement(),
          studyEffectivePeriod = this@with.asPeriod()?.value,
          studyEffectiveDuration = this@with.asDuration()?.value,
          studyEffectiveTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate(
  public var participantEffectiveDateTime: KotlinString? = null,
  public var _participantEffectiveDateTime: Element? = null,
  public var participantEffectivePeriod: Period? = null,
  public var participantEffectiveDuration: Duration? = null,
  public var participantEffectiveTiming: Timing? = null,
) {
  public fun toModel(): ResearchElementDefinition.Characteristic.ParticipantEffective =
    ResearchElementDefinition.Characteristic.ParticipantEffective.from(
      DateTime.of(
        FhirDateTime.fromString(
          this@ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate
            .participantEffectiveDateTime
        ),
        this@ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate
          ._participantEffectiveDateTime,
      ),
      this@ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate
        .participantEffectivePeriod,
      this@ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate
        .participantEffectiveDuration,
      this@ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate
        .participantEffectiveTiming,
    )!!

  public companion object {
    public fun fromModel(
      model: ResearchElementDefinition.Characteristic.ParticipantEffective
    ): ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate =
      with(model) {
        ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate(
          participantEffectiveDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _participantEffectiveDateTime = this@with.asDateTime()?.value?.toElement(),
          participantEffectivePeriod = this@with.asPeriod()?.value,
          participantEffectiveDuration = this@with.asDuration()?.value,
          participantEffectiveTiming = this@with.asTiming()?.value,
        )
      }
  }
}

@Serializable
internal data class ResearchElementDefinitionSurrogate(
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
  public var shortTitle: KotlinString? = null,
  public var _shortTitle: Element? = null,
  public var subtitle: KotlinString? = null,
  public var _subtitle: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var experimental: KotlinBoolean? = null,
  public var _experimental: Element? = null,
  public var subject: ResearchElementDefinition.Subject? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var comment: List<KotlinString?>? = null,
  public var _comment: List<Element?>? = null,
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
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var variableType: KotlinString? = null,
  public var _variableType: Element? = null,
  public var characteristic: List<ResearchElementDefinition.Characteristic>? = null,
) {
  public fun toModel(): ResearchElementDefinition =
    ResearchElementDefinition(
      id = this@ResearchElementDefinitionSurrogate.id,
      meta = this@ResearchElementDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ResearchElementDefinitionSurrogate.implicitRules,
          this@ResearchElementDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ResearchElementDefinitionSurrogate.language,
          this@ResearchElementDefinitionSurrogate._language,
        ),
      text = this@ResearchElementDefinitionSurrogate.text,
      contained = this@ResearchElementDefinitionSurrogate.contained ?: listOf(),
      extension = this@ResearchElementDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchElementDefinitionSurrogate.modifierExtension ?: listOf(),
      url =
        Uri.of(
          this@ResearchElementDefinitionSurrogate.url,
          this@ResearchElementDefinitionSurrogate._url,
        ),
      identifier = this@ResearchElementDefinitionSurrogate.identifier ?: listOf(),
      version =
        R4String.of(
          this@ResearchElementDefinitionSurrogate.version,
          this@ResearchElementDefinitionSurrogate._version,
        ),
      name =
        R4String.of(
          this@ResearchElementDefinitionSurrogate.name,
          this@ResearchElementDefinitionSurrogate._name,
        ),
      title =
        R4String.of(
          this@ResearchElementDefinitionSurrogate.title,
          this@ResearchElementDefinitionSurrogate._title,
        ),
      shortTitle =
        R4String.of(
          this@ResearchElementDefinitionSurrogate.shortTitle,
          this@ResearchElementDefinitionSurrogate._shortTitle,
        ),
      subtitle =
        R4String.of(
          this@ResearchElementDefinitionSurrogate.subtitle,
          this@ResearchElementDefinitionSurrogate._subtitle,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ResearchElementDefinitionSurrogate.status!!),
          this@ResearchElementDefinitionSurrogate._status,
        ),
      experimental =
        R4Boolean.of(
          this@ResearchElementDefinitionSurrogate.experimental,
          this@ResearchElementDefinitionSurrogate._experimental,
        ),
      subject = this@ResearchElementDefinitionSurrogate.subject,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ResearchElementDefinitionSurrogate.date),
          this@ResearchElementDefinitionSurrogate._date,
        ),
      publisher =
        R4String.of(
          this@ResearchElementDefinitionSurrogate.publisher,
          this@ResearchElementDefinitionSurrogate._publisher,
        ),
      contact = this@ResearchElementDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@ResearchElementDefinitionSurrogate.description,
          this@ResearchElementDefinitionSurrogate._description,
        ),
      comment =
        if (
          this@ResearchElementDefinitionSurrogate.comment == null &&
            this@ResearchElementDefinitionSurrogate._comment == null
        ) {
          listOf()
        } else {
          (this@ResearchElementDefinitionSurrogate.comment
              ?: List(this@ResearchElementDefinitionSurrogate._comment!!.size) { null })
            .zip(
              this@ResearchElementDefinitionSurrogate._comment
                ?: List(this@ResearchElementDefinitionSurrogate.comment!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      useContext = this@ResearchElementDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@ResearchElementDefinitionSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(
          this@ResearchElementDefinitionSurrogate.purpose,
          this@ResearchElementDefinitionSurrogate._purpose,
        ),
      usage =
        R4String.of(
          this@ResearchElementDefinitionSurrogate.usage,
          this@ResearchElementDefinitionSurrogate._usage,
        ),
      copyright =
        Markdown.of(
          this@ResearchElementDefinitionSurrogate.copyright,
          this@ResearchElementDefinitionSurrogate._copyright,
        ),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@ResearchElementDefinitionSurrogate.approvalDate),
          this@ResearchElementDefinitionSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@ResearchElementDefinitionSurrogate.lastReviewDate),
          this@ResearchElementDefinitionSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@ResearchElementDefinitionSurrogate.effectivePeriod,
      topic = this@ResearchElementDefinitionSurrogate.topic ?: listOf(),
      author = this@ResearchElementDefinitionSurrogate.author ?: listOf(),
      editor = this@ResearchElementDefinitionSurrogate.editor ?: listOf(),
      reviewer = this@ResearchElementDefinitionSurrogate.reviewer ?: listOf(),
      endorser = this@ResearchElementDefinitionSurrogate.endorser ?: listOf(),
      relatedArtifact = this@ResearchElementDefinitionSurrogate.relatedArtifact ?: listOf(),
      library =
        if (
          this@ResearchElementDefinitionSurrogate.library == null &&
            this@ResearchElementDefinitionSurrogate._library == null
        ) {
          listOf()
        } else {
          (this@ResearchElementDefinitionSurrogate.library
              ?: List(this@ResearchElementDefinitionSurrogate._library!!.size) { null })
            .zip(
              this@ResearchElementDefinitionSurrogate._library
                ?: List(this@ResearchElementDefinitionSurrogate.library!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      type =
        Enumeration.of(
          ResearchElementDefinition.ResearchElementType.fromCode(
            this@ResearchElementDefinitionSurrogate.type!!
          ),
          this@ResearchElementDefinitionSurrogate._type,
        ),
      variableType =
        this@ResearchElementDefinitionSurrogate.variableType?.let {
          Enumeration.of(
            ResearchElementDefinition.EvidenceVariableType.fromCode(it),
            this@ResearchElementDefinitionSurrogate._variableType,
          )
        },
      characteristic = this@ResearchElementDefinitionSurrogate.characteristic ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ResearchElementDefinition): ResearchElementDefinitionSurrogate =
      with(model) {
        ResearchElementDefinitionSurrogate(
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
          shortTitle = this@with.shortTitle?.value,
          _shortTitle = this@with.shortTitle?.toElement(),
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
          comment =
            this@with.comment.map { it.value }.toList().takeUnless { it.all { it == null } },
          _comment =
            this@with.comment
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
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
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          variableType = this@with.variableType?.value?.getCode(),
          _variableType = this@with.variableType?.toElement(),
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
        )
      }
  }
}
