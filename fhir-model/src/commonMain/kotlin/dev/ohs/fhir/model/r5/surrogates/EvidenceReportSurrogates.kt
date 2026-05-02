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
import com.google.fhir.model.r5.ContactDetail
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.EvidenceReport
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class EvidenceReportSubjectSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var characteristic: List<EvidenceReport.Subject.Characteristic>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): EvidenceReport.Subject =
    EvidenceReport.Subject(
      id = this@EvidenceReportSubjectSurrogate.id,
      extension = this@EvidenceReportSubjectSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceReportSubjectSurrogate.modifierExtension ?: listOf(),
      characteristic = this@EvidenceReportSubjectSurrogate.characteristic ?: listOf(),
      note = this@EvidenceReportSubjectSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: EvidenceReport.Subject): EvidenceReportSubjectSurrogate =
      with(model) {
        EvidenceReportSubjectSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EvidenceReportSubjectCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var `value`: EvidenceReport.Subject.Characteristic.Value,
  public var exclude: KotlinBoolean? = null,
  public var _exclude: Element? = null,
  public var period: Period? = null,
) {
  public fun toModel(): EvidenceReport.Subject.Characteristic =
    EvidenceReport.Subject.Characteristic(
      id = this@EvidenceReportSubjectCharacteristicSurrogate.id,
      extension = this@EvidenceReportSubjectCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EvidenceReportSubjectCharacteristicSurrogate.modifierExtension ?: listOf(),
      code = this@EvidenceReportSubjectCharacteristicSurrogate.code,
      `value` = this@EvidenceReportSubjectCharacteristicSurrogate.`value`,
      exclude =
        R5Boolean.of(
          this@EvidenceReportSubjectCharacteristicSurrogate.exclude,
          this@EvidenceReportSubjectCharacteristicSurrogate._exclude,
        ),
      period = this@EvidenceReportSubjectCharacteristicSurrogate.period,
    )

  public companion object {
    public fun fromModel(
      model: EvidenceReport.Subject.Characteristic
    ): EvidenceReportSubjectCharacteristicSurrogate =
      with(model) {
        EvidenceReportSubjectCharacteristicSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          `value` = this@with.`value`,
          exclude = this@with.exclude?.value,
          _exclude = this@with.exclude?.toElement(),
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class EvidenceReportRelatesToSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var target: EvidenceReport.RelatesTo.Target,
) {
  public fun toModel(): EvidenceReport.RelatesTo =
    EvidenceReport.RelatesTo(
      id = this@EvidenceReportRelatesToSurrogate.id,
      extension = this@EvidenceReportRelatesToSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceReportRelatesToSurrogate.modifierExtension ?: listOf(),
      code =
        Enumeration.of(
          EvidenceReport.ReportRelationshipType.fromCode(
            this@EvidenceReportRelatesToSurrogate.code!!
          ),
          this@EvidenceReportRelatesToSurrogate._code,
        ),
      target = this@EvidenceReportRelatesToSurrogate.target,
    )

  public companion object {
    public fun fromModel(model: EvidenceReport.RelatesTo): EvidenceReportRelatesToSurrogate =
      with(model) {
        EvidenceReportRelatesToSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          target = this@with.target,
        )
      }
  }
}

@Serializable
internal data class EvidenceReportRelatesToTargetSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: Identifier? = null,
  public var display: KotlinString? = null,
  public var _display: Element? = null,
  public var resource: Reference? = null,
) {
  public fun toModel(): EvidenceReport.RelatesTo.Target =
    EvidenceReport.RelatesTo.Target(
      id = this@EvidenceReportRelatesToTargetSurrogate.id,
      extension = this@EvidenceReportRelatesToTargetSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceReportRelatesToTargetSurrogate.modifierExtension ?: listOf(),
      url =
        Uri.of(
          this@EvidenceReportRelatesToTargetSurrogate.url,
          this@EvidenceReportRelatesToTargetSurrogate._url,
        ),
      identifier = this@EvidenceReportRelatesToTargetSurrogate.identifier,
      display =
        Markdown.of(
          this@EvidenceReportRelatesToTargetSurrogate.display,
          this@EvidenceReportRelatesToTargetSurrogate._display,
        ),
      resource = this@EvidenceReportRelatesToTargetSurrogate.resource,
    )

  public companion object {
    public fun fromModel(
      model: EvidenceReport.RelatesTo.Target
    ): EvidenceReportRelatesToTargetSurrogate =
      with(model) {
        EvidenceReportRelatesToTargetSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier,
          display = this@with.display?.value,
          _display = this@with.display?.toElement(),
          resource = this@with.resource,
        )
      }
  }
}

@Serializable
internal data class EvidenceReportSectionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var focus: CodeableConcept? = null,
  public var focusReference: Reference? = null,
  public var author: List<Reference>? = null,
  public var text: Narrative? = null,
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
  public var orderedBy: CodeableConcept? = null,
  public var entryClassifier: List<CodeableConcept>? = null,
  public var entryReference: List<Reference>? = null,
  public var entryQuantity: List<Quantity>? = null,
  public var emptyReason: CodeableConcept? = null,
  public var section: List<EvidenceReport.Section>? = null,
) {
  public fun toModel(): EvidenceReport.Section =
    EvidenceReport.Section(
      id = this@EvidenceReportSectionSurrogate.id,
      extension = this@EvidenceReportSectionSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceReportSectionSurrogate.modifierExtension ?: listOf(),
      title =
        R5String.of(
          this@EvidenceReportSectionSurrogate.title,
          this@EvidenceReportSectionSurrogate._title,
        ),
      focus = this@EvidenceReportSectionSurrogate.focus,
      focusReference = this@EvidenceReportSectionSurrogate.focusReference,
      author = this@EvidenceReportSectionSurrogate.author ?: listOf(),
      text = this@EvidenceReportSectionSurrogate.text,
      mode =
        this@EvidenceReportSectionSurrogate.mode?.let {
          Enumeration.of(
            EvidenceReport.ListMode.fromCode(it),
            this@EvidenceReportSectionSurrogate._mode,
          )
        },
      orderedBy = this@EvidenceReportSectionSurrogate.orderedBy,
      entryClassifier = this@EvidenceReportSectionSurrogate.entryClassifier ?: listOf(),
      entryReference = this@EvidenceReportSectionSurrogate.entryReference ?: listOf(),
      entryQuantity = this@EvidenceReportSectionSurrogate.entryQuantity ?: listOf(),
      emptyReason = this@EvidenceReportSectionSurrogate.emptyReason,
      section = this@EvidenceReportSectionSurrogate.section ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: EvidenceReport.Section): EvidenceReportSectionSurrogate =
      with(model) {
        EvidenceReportSectionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          focus = this@with.focus,
          focusReference = this@with.focusReference,
          author = this@with.author.takeIf { it.isNotEmpty() },
          text = this@with.text,
          mode = this@with.mode?.value?.getCode(),
          _mode = this@with.mode?.toElement(),
          orderedBy = this@with.orderedBy,
          entryClassifier = this@with.entryClassifier.takeIf { it.isNotEmpty() },
          entryReference = this@with.entryReference.takeIf { it.isNotEmpty() },
          entryQuantity = this@with.entryQuantity.takeIf { it.isNotEmpty() },
          emptyReason = this@with.emptyReason,
          section = this@with.section.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EvidenceReportCiteAsSurrogate(
  public var citeAsReference: Reference? = null,
  public var citeAsMarkdown: KotlinString? = null,
  public var _citeAsMarkdown: Element? = null,
) {
  public fun toModel(): EvidenceReport.CiteAs =
    EvidenceReport.CiteAs.from(
      this@EvidenceReportCiteAsSurrogate.citeAsReference,
      Markdown.of(
        this@EvidenceReportCiteAsSurrogate.citeAsMarkdown,
        this@EvidenceReportCiteAsSurrogate._citeAsMarkdown,
      ),
    )!!

  public companion object {
    public fun fromModel(model: EvidenceReport.CiteAs): EvidenceReportCiteAsSurrogate =
      with(model) {
        EvidenceReportCiteAsSurrogate(
          citeAsReference = this@with.asReference()?.value,
          citeAsMarkdown = this@with.asMarkdown()?.value?.value,
          _citeAsMarkdown = this@with.asMarkdown()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class EvidenceReportSubjectCharacteristicValueSurrogate(
  public var valueReference: Reference? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
) {
  public fun toModel(): EvidenceReport.Subject.Characteristic.Value =
    EvidenceReport.Subject.Characteristic.Value.from(
      this@EvidenceReportSubjectCharacteristicValueSurrogate.valueReference,
      this@EvidenceReportSubjectCharacteristicValueSurrogate.valueCodeableConcept,
      R5Boolean.of(
        this@EvidenceReportSubjectCharacteristicValueSurrogate.valueBoolean,
        this@EvidenceReportSubjectCharacteristicValueSurrogate._valueBoolean,
      ),
      this@EvidenceReportSubjectCharacteristicValueSurrogate.valueQuantity,
      this@EvidenceReportSubjectCharacteristicValueSurrogate.valueRange,
    )!!

  public companion object {
    public fun fromModel(
      model: EvidenceReport.Subject.Characteristic.Value
    ): EvidenceReportSubjectCharacteristicValueSurrogate =
      with(model) {
        EvidenceReportSubjectCharacteristicValueSurrogate(
          valueReference = this@with.asReference()?.value,
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
        )
      }
  }
}

@Serializable
internal data class EvidenceReportSurrogate(
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
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var identifier: List<Identifier>? = null,
  public var relatedIdentifier: List<Identifier>? = null,
  public var citeAs: EvidenceReport.CiteAs? = null,
  public var type: CodeableConcept? = null,
  public var note: List<Annotation>? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var subject: EvidenceReport.Subject,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var author: List<ContactDetail>? = null,
  public var editor: List<ContactDetail>? = null,
  public var reviewer: List<ContactDetail>? = null,
  public var endorser: List<ContactDetail>? = null,
  public var relatesTo: List<EvidenceReport.RelatesTo>? = null,
  public var section: List<EvidenceReport.Section>? = null,
) {
  public fun toModel(): EvidenceReport =
    EvidenceReport(
      id = this@EvidenceReportSurrogate.id,
      meta = this@EvidenceReportSurrogate.meta,
      implicitRules =
        Uri.of(
          this@EvidenceReportSurrogate.implicitRules,
          this@EvidenceReportSurrogate._implicitRules,
        ),
      language =
        Code.of(this@EvidenceReportSurrogate.language, this@EvidenceReportSurrogate._language),
      text = this@EvidenceReportSurrogate.text,
      contained = this@EvidenceReportSurrogate.contained ?: listOf(),
      extension = this@EvidenceReportSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceReportSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@EvidenceReportSurrogate.url, this@EvidenceReportSurrogate._url),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@EvidenceReportSurrogate.status!!),
          this@EvidenceReportSurrogate._status,
        ),
      useContext = this@EvidenceReportSurrogate.useContext ?: listOf(),
      identifier = this@EvidenceReportSurrogate.identifier ?: listOf(),
      relatedIdentifier = this@EvidenceReportSurrogate.relatedIdentifier ?: listOf(),
      citeAs = this@EvidenceReportSurrogate.citeAs,
      type = this@EvidenceReportSurrogate.type,
      note = this@EvidenceReportSurrogate.note ?: listOf(),
      relatedArtifact = this@EvidenceReportSurrogate.relatedArtifact ?: listOf(),
      subject = this@EvidenceReportSurrogate.subject,
      publisher =
        R5String.of(
          this@EvidenceReportSurrogate.publisher,
          this@EvidenceReportSurrogate._publisher,
        ),
      contact = this@EvidenceReportSurrogate.contact ?: listOf(),
      author = this@EvidenceReportSurrogate.author ?: listOf(),
      editor = this@EvidenceReportSurrogate.editor ?: listOf(),
      reviewer = this@EvidenceReportSurrogate.reviewer ?: listOf(),
      endorser = this@EvidenceReportSurrogate.endorser ?: listOf(),
      relatesTo = this@EvidenceReportSurrogate.relatesTo ?: listOf(),
      section = this@EvidenceReportSurrogate.section ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: EvidenceReport): EvidenceReportSurrogate =
      with(model) {
        EvidenceReportSurrogate(
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          relatedIdentifier = this@with.relatedIdentifier.takeIf { it.isNotEmpty() },
          citeAs = this@with.citeAs,
          type = this@with.type,
          note = this@with.note.takeIf { it.isNotEmpty() },
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          author = this@with.author.takeIf { it.isNotEmpty() },
          editor = this@with.editor.takeIf { it.isNotEmpty() },
          reviewer = this@with.reviewer.takeIf { it.isNotEmpty() },
          endorser = this@with.endorser.takeIf { it.isNotEmpty() },
          relatesTo = this@with.relatesTo.takeIf { it.isNotEmpty() },
          section = this@with.section.takeIf { it.isNotEmpty() },
        )
      }
  }
}
