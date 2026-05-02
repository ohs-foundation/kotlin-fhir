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

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.DocumentReference
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Instant
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.DocumentReferenceStatus
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class DocumentReferenceAttesterSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var mode: CodeableConcept,
  public var time: KotlinString? = null,
  public var _time: Element? = null,
  public var party: Reference? = null,
) {
  public fun toModel(): DocumentReference.Attester =
    DocumentReference.Attester(
      id = this@DocumentReferenceAttesterSurrogate.id,
      extension = this@DocumentReferenceAttesterSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentReferenceAttesterSurrogate.modifierExtension ?: listOf(),
      mode = this@DocumentReferenceAttesterSurrogate.mode,
      time =
        DateTime.of(
          FhirDateTime.fromString(this@DocumentReferenceAttesterSurrogate.time),
          this@DocumentReferenceAttesterSurrogate._time,
        ),
      party = this@DocumentReferenceAttesterSurrogate.party,
    )

  public companion object {
    public fun fromModel(model: DocumentReference.Attester): DocumentReferenceAttesterSurrogate =
      with(model) {
        DocumentReferenceAttesterSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          mode = this@with.mode,
          time = this@with.time?.value?.toString(),
          _time = this@with.time?.toElement(),
          party = this@with.party,
        )
      }
  }
}

@Serializable
internal data class DocumentReferenceRelatesToSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var target: Reference,
) {
  public fun toModel(): DocumentReference.RelatesTo =
    DocumentReference.RelatesTo(
      id = this@DocumentReferenceRelatesToSurrogate.id,
      extension = this@DocumentReferenceRelatesToSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentReferenceRelatesToSurrogate.modifierExtension ?: listOf(),
      code = this@DocumentReferenceRelatesToSurrogate.code,
      target = this@DocumentReferenceRelatesToSurrogate.target,
    )

  public companion object {
    public fun fromModel(model: DocumentReference.RelatesTo): DocumentReferenceRelatesToSurrogate =
      with(model) {
        DocumentReferenceRelatesToSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          target = this@with.target,
        )
      }
  }
}

@Serializable
internal data class DocumentReferenceContentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var attachment: Attachment,
  public var profile: List<DocumentReference.Content.Profile>? = null,
) {
  public fun toModel(): DocumentReference.Content =
    DocumentReference.Content(
      id = this@DocumentReferenceContentSurrogate.id,
      extension = this@DocumentReferenceContentSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentReferenceContentSurrogate.modifierExtension ?: listOf(),
      attachment = this@DocumentReferenceContentSurrogate.attachment,
      profile = this@DocumentReferenceContentSurrogate.profile ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DocumentReference.Content): DocumentReferenceContentSurrogate =
      with(model) {
        DocumentReferenceContentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          attachment = this@with.attachment,
          profile = this@with.profile.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class DocumentReferenceContentProfileSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: DocumentReference.Content.Profile.Value,
) {
  public fun toModel(): DocumentReference.Content.Profile =
    DocumentReference.Content.Profile(
      id = this@DocumentReferenceContentProfileSurrogate.id,
      extension = this@DocumentReferenceContentProfileSurrogate.extension ?: listOf(),
      modifierExtension =
        this@DocumentReferenceContentProfileSurrogate.modifierExtension ?: listOf(),
      `value` = this@DocumentReferenceContentProfileSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: DocumentReference.Content.Profile
    ): DocumentReferenceContentProfileSurrogate =
      with(model) {
        DocumentReferenceContentProfileSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class DocumentReferenceContentProfileValueSurrogate(
  public var valueCoding: Coding? = null,
  public var valueUri: KotlinString? = null,
  public var _valueUri: Element? = null,
  public var valueCanonical: KotlinString? = null,
  public var _valueCanonical: Element? = null,
) {
  public fun toModel(): DocumentReference.Content.Profile.Value =
    DocumentReference.Content.Profile.Value.from(
      this@DocumentReferenceContentProfileValueSurrogate.valueCoding,
      Uri.of(
        this@DocumentReferenceContentProfileValueSurrogate.valueUri,
        this@DocumentReferenceContentProfileValueSurrogate._valueUri,
      ),
      Canonical.of(
        this@DocumentReferenceContentProfileValueSurrogate.valueCanonical,
        this@DocumentReferenceContentProfileValueSurrogate._valueCanonical,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: DocumentReference.Content.Profile.Value
    ): DocumentReferenceContentProfileValueSurrogate =
      with(model) {
        DocumentReferenceContentProfileValueSurrogate(
          valueCoding = this@with.asCoding()?.value,
          valueUri = this@with.asUri()?.value?.value,
          _valueUri = this@with.asUri()?.value?.toElement(),
          valueCanonical = this@with.asCanonical()?.value?.value,
          _valueCanonical = this@with.asCanonical()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class DocumentReferenceSurrogate(
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
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var basedOn: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var docStatus: KotlinString? = null,
  public var _docStatus: Element? = null,
  public var modality: List<CodeableConcept>? = null,
  public var type: CodeableConcept? = null,
  public var category: List<CodeableConcept>? = null,
  public var subject: Reference? = null,
  public var context: List<Reference>? = null,
  public var event: List<CodeableReference>? = null,
  public var bodySite: List<CodeableReference>? = null,
  public var facilityType: CodeableConcept? = null,
  public var practiceSetting: CodeableConcept? = null,
  public var period: Period? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var author: List<Reference>? = null,
  public var attester: List<DocumentReference.Attester>? = null,
  public var custodian: Reference? = null,
  public var relatesTo: List<DocumentReference.RelatesTo>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var securityLabel: List<CodeableConcept>? = null,
  public var content: List<DocumentReference.Content>? = null,
) {
  public fun toModel(): DocumentReference =
    DocumentReference(
      id = this@DocumentReferenceSurrogate.id,
      meta = this@DocumentReferenceSurrogate.meta,
      implicitRules =
        Uri.of(
          this@DocumentReferenceSurrogate.implicitRules,
          this@DocumentReferenceSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@DocumentReferenceSurrogate.language,
          this@DocumentReferenceSurrogate._language,
        ),
      text = this@DocumentReferenceSurrogate.text,
      contained = this@DocumentReferenceSurrogate.contained ?: listOf(),
      extension = this@DocumentReferenceSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentReferenceSurrogate.modifierExtension ?: listOf(),
      identifier = this@DocumentReferenceSurrogate.identifier ?: listOf(),
      version =
        R5String.of(
          this@DocumentReferenceSurrogate.version,
          this@DocumentReferenceSurrogate._version,
        ),
      basedOn = this@DocumentReferenceSurrogate.basedOn ?: listOf(),
      status =
        Enumeration.of(
          DocumentReferenceStatus.fromCode(this@DocumentReferenceSurrogate.status!!),
          this@DocumentReferenceSurrogate._status,
        ),
      docStatus =
        this@DocumentReferenceSurrogate.docStatus?.let {
          Enumeration.of(
            DocumentReference.CompositionStatus.fromCode(it),
            this@DocumentReferenceSurrogate._docStatus,
          )
        },
      modality = this@DocumentReferenceSurrogate.modality ?: listOf(),
      type = this@DocumentReferenceSurrogate.type,
      category = this@DocumentReferenceSurrogate.category ?: listOf(),
      subject = this@DocumentReferenceSurrogate.subject,
      context = this@DocumentReferenceSurrogate.context ?: listOf(),
      event = this@DocumentReferenceSurrogate.event ?: listOf(),
      bodySite = this@DocumentReferenceSurrogate.bodySite ?: listOf(),
      facilityType = this@DocumentReferenceSurrogate.facilityType,
      practiceSetting = this@DocumentReferenceSurrogate.practiceSetting,
      period = this@DocumentReferenceSurrogate.period,
      date =
        Instant.of(
          FhirDateTime.fromString(this@DocumentReferenceSurrogate.date),
          this@DocumentReferenceSurrogate._date,
        ),
      author = this@DocumentReferenceSurrogate.author ?: listOf(),
      attester = this@DocumentReferenceSurrogate.attester ?: listOf(),
      custodian = this@DocumentReferenceSurrogate.custodian,
      relatesTo = this@DocumentReferenceSurrogate.relatesTo ?: listOf(),
      description =
        Markdown.of(
          this@DocumentReferenceSurrogate.description,
          this@DocumentReferenceSurrogate._description,
        ),
      securityLabel = this@DocumentReferenceSurrogate.securityLabel ?: listOf(),
      content = this@DocumentReferenceSurrogate.content ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DocumentReference): DocumentReferenceSurrogate =
      with(model) {
        DocumentReferenceSurrogate(
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
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          docStatus = this@with.docStatus?.value?.getCode(),
          _docStatus = this@with.docStatus?.toElement(),
          modality = this@with.modality.takeIf { it.isNotEmpty() },
          type = this@with.type,
          category = this@with.category.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          context = this@with.context.takeIf { it.isNotEmpty() },
          event = this@with.event.takeIf { it.isNotEmpty() },
          bodySite = this@with.bodySite.takeIf { it.isNotEmpty() },
          facilityType = this@with.facilityType,
          practiceSetting = this@with.practiceSetting,
          period = this@with.period,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          author = this@with.author.takeIf { it.isNotEmpty() },
          attester = this@with.attester.takeIf { it.isNotEmpty() },
          custodian = this@with.custodian,
          relatesTo = this@with.relatesTo.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          securityLabel = this@with.securityLabel.takeIf { it.isNotEmpty() },
          content = this@with.content.takeIf { it.isNotEmpty() },
        )
      }
  }
}
