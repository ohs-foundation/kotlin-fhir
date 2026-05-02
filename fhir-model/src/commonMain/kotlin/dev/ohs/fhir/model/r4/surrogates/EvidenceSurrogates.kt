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
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Evidence
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
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.UsageContext
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.PublicationStatus
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

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
  public var exposureBackground: Reference,
  public var exposureVariant: List<Reference>? = null,
  public var outcome: List<Reference>? = null,
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
      version = R4String.of(this@EvidenceSurrogate.version, this@EvidenceSurrogate._version),
      name = R4String.of(this@EvidenceSurrogate.name, this@EvidenceSurrogate._name),
      title = R4String.of(this@EvidenceSurrogate.title, this@EvidenceSurrogate._title),
      shortTitle =
        R4String.of(this@EvidenceSurrogate.shortTitle, this@EvidenceSurrogate._shortTitle),
      subtitle = R4String.of(this@EvidenceSurrogate.subtitle, this@EvidenceSurrogate._subtitle),
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
      publisher = R4String.of(this@EvidenceSurrogate.publisher, this@EvidenceSurrogate._publisher),
      contact = this@EvidenceSurrogate.contact ?: listOf(),
      description =
        Markdown.of(this@EvidenceSurrogate.description, this@EvidenceSurrogate._description),
      note = this@EvidenceSurrogate.note ?: listOf(),
      useContext = this@EvidenceSurrogate.useContext ?: listOf(),
      jurisdiction = this@EvidenceSurrogate.jurisdiction ?: listOf(),
      copyright = Markdown.of(this@EvidenceSurrogate.copyright, this@EvidenceSurrogate._copyright),
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
      effectivePeriod = this@EvidenceSurrogate.effectivePeriod,
      topic = this@EvidenceSurrogate.topic ?: listOf(),
      author = this@EvidenceSurrogate.author ?: listOf(),
      editor = this@EvidenceSurrogate.editor ?: listOf(),
      reviewer = this@EvidenceSurrogate.reviewer ?: listOf(),
      endorser = this@EvidenceSurrogate.endorser ?: listOf(),
      relatedArtifact = this@EvidenceSurrogate.relatedArtifact ?: listOf(),
      exposureBackground = this@EvidenceSurrogate.exposureBackground,
      exposureVariant = this@EvidenceSurrogate.exposureVariant ?: listOf(),
      outcome = this@EvidenceSurrogate.outcome ?: listOf(),
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
          exposureBackground = this@with.exposureBackground,
          exposureVariant = this@with.exposureVariant.takeIf { it.isNotEmpty() },
          outcome = this@with.outcome.takeIf { it.isNotEmpty() },
        )
      }
  }
}
