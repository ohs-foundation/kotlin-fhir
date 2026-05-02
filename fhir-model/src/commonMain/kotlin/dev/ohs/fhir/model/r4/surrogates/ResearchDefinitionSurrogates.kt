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
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
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
import com.google.fhir.model.r4.ResearchDefinition
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
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
internal data class ResearchDefinitionSubjectSurrogate(
  public var subjectCodeableConcept: CodeableConcept? = null,
  public var subjectReference: Reference? = null,
) {
  public fun toModel(): ResearchDefinition.Subject =
    ResearchDefinition.Subject.from(
      this@ResearchDefinitionSubjectSurrogate.subjectCodeableConcept,
      this@ResearchDefinitionSubjectSurrogate.subjectReference,
    )!!

  public companion object {
    public fun fromModel(model: ResearchDefinition.Subject): ResearchDefinitionSubjectSurrogate =
      with(model) {
        ResearchDefinitionSubjectSurrogate(
          subjectCodeableConcept = this@with.asCodeableConcept()?.value,
          subjectReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ResearchDefinitionSurrogate(
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
  public var subject: ResearchDefinition.Subject? = null,
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
  public var population: Reference,
  public var exposure: Reference? = null,
  public var exposureAlternative: Reference? = null,
  public var outcome: Reference? = null,
) {
  public fun toModel(): ResearchDefinition =
    ResearchDefinition(
      id = this@ResearchDefinitionSurrogate.id,
      meta = this@ResearchDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ResearchDefinitionSurrogate.implicitRules,
          this@ResearchDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ResearchDefinitionSurrogate.language,
          this@ResearchDefinitionSurrogate._language,
        ),
      text = this@ResearchDefinitionSurrogate.text,
      contained = this@ResearchDefinitionSurrogate.contained ?: listOf(),
      extension = this@ResearchDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchDefinitionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@ResearchDefinitionSurrogate.url, this@ResearchDefinitionSurrogate._url),
      identifier = this@ResearchDefinitionSurrogate.identifier ?: listOf(),
      version =
        R4String.of(
          this@ResearchDefinitionSurrogate.version,
          this@ResearchDefinitionSurrogate._version,
        ),
      name =
        R4String.of(this@ResearchDefinitionSurrogate.name, this@ResearchDefinitionSurrogate._name),
      title =
        R4String.of(
          this@ResearchDefinitionSurrogate.title,
          this@ResearchDefinitionSurrogate._title,
        ),
      shortTitle =
        R4String.of(
          this@ResearchDefinitionSurrogate.shortTitle,
          this@ResearchDefinitionSurrogate._shortTitle,
        ),
      subtitle =
        R4String.of(
          this@ResearchDefinitionSurrogate.subtitle,
          this@ResearchDefinitionSurrogate._subtitle,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ResearchDefinitionSurrogate.status!!),
          this@ResearchDefinitionSurrogate._status,
        ),
      experimental =
        R4Boolean.of(
          this@ResearchDefinitionSurrogate.experimental,
          this@ResearchDefinitionSurrogate._experimental,
        ),
      subject = this@ResearchDefinitionSurrogate.subject,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ResearchDefinitionSurrogate.date),
          this@ResearchDefinitionSurrogate._date,
        ),
      publisher =
        R4String.of(
          this@ResearchDefinitionSurrogate.publisher,
          this@ResearchDefinitionSurrogate._publisher,
        ),
      contact = this@ResearchDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@ResearchDefinitionSurrogate.description,
          this@ResearchDefinitionSurrogate._description,
        ),
      comment =
        if (
          this@ResearchDefinitionSurrogate.comment == null &&
            this@ResearchDefinitionSurrogate._comment == null
        ) {
          listOf()
        } else {
          (this@ResearchDefinitionSurrogate.comment
              ?: List(this@ResearchDefinitionSurrogate._comment!!.size) { null })
            .zip(
              this@ResearchDefinitionSurrogate._comment
                ?: List(this@ResearchDefinitionSurrogate.comment!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      useContext = this@ResearchDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@ResearchDefinitionSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(
          this@ResearchDefinitionSurrogate.purpose,
          this@ResearchDefinitionSurrogate._purpose,
        ),
      usage =
        R4String.of(
          this@ResearchDefinitionSurrogate.usage,
          this@ResearchDefinitionSurrogate._usage,
        ),
      copyright =
        Markdown.of(
          this@ResearchDefinitionSurrogate.copyright,
          this@ResearchDefinitionSurrogate._copyright,
        ),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@ResearchDefinitionSurrogate.approvalDate),
          this@ResearchDefinitionSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@ResearchDefinitionSurrogate.lastReviewDate),
          this@ResearchDefinitionSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@ResearchDefinitionSurrogate.effectivePeriod,
      topic = this@ResearchDefinitionSurrogate.topic ?: listOf(),
      author = this@ResearchDefinitionSurrogate.author ?: listOf(),
      editor = this@ResearchDefinitionSurrogate.editor ?: listOf(),
      reviewer = this@ResearchDefinitionSurrogate.reviewer ?: listOf(),
      endorser = this@ResearchDefinitionSurrogate.endorser ?: listOf(),
      relatedArtifact = this@ResearchDefinitionSurrogate.relatedArtifact ?: listOf(),
      library =
        if (
          this@ResearchDefinitionSurrogate.library == null &&
            this@ResearchDefinitionSurrogate._library == null
        ) {
          listOf()
        } else {
          (this@ResearchDefinitionSurrogate.library
              ?: List(this@ResearchDefinitionSurrogate._library!!.size) { null })
            .zip(
              this@ResearchDefinitionSurrogate._library
                ?: List(this@ResearchDefinitionSurrogate.library!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      population = this@ResearchDefinitionSurrogate.population,
      exposure = this@ResearchDefinitionSurrogate.exposure,
      exposureAlternative = this@ResearchDefinitionSurrogate.exposureAlternative,
      outcome = this@ResearchDefinitionSurrogate.outcome,
    )

  public companion object {
    public fun fromModel(model: ResearchDefinition): ResearchDefinitionSurrogate =
      with(model) {
        ResearchDefinitionSurrogate(
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
          population = this@with.population,
          exposure = this@with.exposure,
          exposureAlternative = this@with.exposureAlternative,
          outcome = this@with.outcome,
        )
      }
  }
}
