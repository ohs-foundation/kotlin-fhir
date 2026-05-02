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

import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Coding
import com.google.fhir.model.r4b.DocumentReference
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Instant
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.DocumentReferenceStatus
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class DocumentReferenceRelatesToSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var target: Reference,
) {
  public fun toModel(): DocumentReference.RelatesTo =
    DocumentReference.RelatesTo(
      id = this@DocumentReferenceRelatesToSurrogate.id,
      extension = this@DocumentReferenceRelatesToSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentReferenceRelatesToSurrogate.modifierExtension ?: listOf(),
      code =
        Enumeration.of(
          DocumentReference.DocumentRelationshipType.fromCode(
            this@DocumentReferenceRelatesToSurrogate.code!!
          ),
          this@DocumentReferenceRelatesToSurrogate._code,
        ),
      target = this@DocumentReferenceRelatesToSurrogate.target,
    )

  public companion object {
    public fun fromModel(model: DocumentReference.RelatesTo): DocumentReferenceRelatesToSurrogate =
      with(model) {
        DocumentReferenceRelatesToSurrogate(
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
internal data class DocumentReferenceContentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var attachment: Attachment,
  public var format: Coding? = null,
) {
  public fun toModel(): DocumentReference.Content =
    DocumentReference.Content(
      id = this@DocumentReferenceContentSurrogate.id,
      extension = this@DocumentReferenceContentSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentReferenceContentSurrogate.modifierExtension ?: listOf(),
      attachment = this@DocumentReferenceContentSurrogate.attachment,
      format = this@DocumentReferenceContentSurrogate.format,
    )

  public companion object {
    public fun fromModel(model: DocumentReference.Content): DocumentReferenceContentSurrogate =
      with(model) {
        DocumentReferenceContentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          attachment = this@with.attachment,
          format = this@with.format,
        )
      }
  }
}

@Serializable
internal data class DocumentReferenceContextSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var encounter: List<Reference>? = null,
  public var event: List<CodeableConcept>? = null,
  public var period: Period? = null,
  public var facilityType: CodeableConcept? = null,
  public var practiceSetting: CodeableConcept? = null,
  public var sourcePatientInfo: Reference? = null,
  public var related: List<Reference>? = null,
) {
  public fun toModel(): DocumentReference.Context =
    DocumentReference.Context(
      id = this@DocumentReferenceContextSurrogate.id,
      extension = this@DocumentReferenceContextSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentReferenceContextSurrogate.modifierExtension ?: listOf(),
      encounter = this@DocumentReferenceContextSurrogate.encounter ?: listOf(),
      event = this@DocumentReferenceContextSurrogate.event ?: listOf(),
      period = this@DocumentReferenceContextSurrogate.period,
      facilityType = this@DocumentReferenceContextSurrogate.facilityType,
      practiceSetting = this@DocumentReferenceContextSurrogate.practiceSetting,
      sourcePatientInfo = this@DocumentReferenceContextSurrogate.sourcePatientInfo,
      related = this@DocumentReferenceContextSurrogate.related ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DocumentReference.Context): DocumentReferenceContextSurrogate =
      with(model) {
        DocumentReferenceContextSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          encounter = this@with.encounter.takeIf { it.isNotEmpty() },
          event = this@with.event.takeIf { it.isNotEmpty() },
          period = this@with.period,
          facilityType = this@with.facilityType,
          practiceSetting = this@with.practiceSetting,
          sourcePatientInfo = this@with.sourcePatientInfo,
          related = this@with.related.takeIf { it.isNotEmpty() },
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
  public var masterIdentifier: Identifier? = null,
  public var identifier: List<Identifier>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var docStatus: KotlinString? = null,
  public var _docStatus: Element? = null,
  public var type: CodeableConcept? = null,
  public var category: List<CodeableConcept>? = null,
  public var subject: Reference? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var author: List<Reference>? = null,
  public var authenticator: Reference? = null,
  public var custodian: Reference? = null,
  public var relatesTo: List<DocumentReference.RelatesTo>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var securityLabel: List<CodeableConcept>? = null,
  public var content: List<DocumentReference.Content>? = null,
  public var context: DocumentReference.Context? = null,
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
      masterIdentifier = this@DocumentReferenceSurrogate.masterIdentifier,
      identifier = this@DocumentReferenceSurrogate.identifier ?: listOf(),
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
      type = this@DocumentReferenceSurrogate.type,
      category = this@DocumentReferenceSurrogate.category ?: listOf(),
      subject = this@DocumentReferenceSurrogate.subject,
      date =
        Instant.of(
          FhirDateTime.fromString(this@DocumentReferenceSurrogate.date),
          this@DocumentReferenceSurrogate._date,
        ),
      author = this@DocumentReferenceSurrogate.author ?: listOf(),
      authenticator = this@DocumentReferenceSurrogate.authenticator,
      custodian = this@DocumentReferenceSurrogate.custodian,
      relatesTo = this@DocumentReferenceSurrogate.relatesTo ?: listOf(),
      description =
        R4bString.of(
          this@DocumentReferenceSurrogate.description,
          this@DocumentReferenceSurrogate._description,
        ),
      securityLabel = this@DocumentReferenceSurrogate.securityLabel ?: listOf(),
      content = this@DocumentReferenceSurrogate.content ?: listOf(),
      context = this@DocumentReferenceSurrogate.context,
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
          masterIdentifier = this@with.masterIdentifier,
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          docStatus = this@with.docStatus?.value?.getCode(),
          _docStatus = this@with.docStatus?.toElement(),
          type = this@with.type,
          category = this@with.category.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          author = this@with.author.takeIf { it.isNotEmpty() },
          authenticator = this@with.authenticator,
          custodian = this@with.custodian,
          relatesTo = this@with.relatesTo.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          securityLabel = this@with.securityLabel.takeIf { it.isNotEmpty() },
          content = this@with.content.takeIf { it.isNotEmpty() },
          context = this@with.context,
        )
      }
  }
}
