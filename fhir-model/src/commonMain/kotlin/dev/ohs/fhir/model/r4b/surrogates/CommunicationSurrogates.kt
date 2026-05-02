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
import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Communication
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CommunicationPayloadSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var content: Communication.Payload.Content,
) {
  public fun toModel(): Communication.Payload =
    Communication.Payload(
      id = this@CommunicationPayloadSurrogate.id,
      extension = this@CommunicationPayloadSurrogate.extension ?: listOf(),
      modifierExtension = this@CommunicationPayloadSurrogate.modifierExtension ?: listOf(),
      content = this@CommunicationPayloadSurrogate.content,
    )

  public companion object {
    public fun fromModel(model: Communication.Payload): CommunicationPayloadSurrogate =
      with(model) {
        CommunicationPayloadSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          content = this@with.content,
        )
      }
  }
}

@Serializable
internal data class CommunicationPayloadContentSurrogate(
  public var contentString: KotlinString? = null,
  public var _contentString: Element? = null,
  public var contentAttachment: Attachment? = null,
  public var contentReference: Reference? = null,
) {
  public fun toModel(): Communication.Payload.Content =
    Communication.Payload.Content.from(
      R4bString.of(
        this@CommunicationPayloadContentSurrogate.contentString,
        this@CommunicationPayloadContentSurrogate._contentString,
      ),
      this@CommunicationPayloadContentSurrogate.contentAttachment,
      this@CommunicationPayloadContentSurrogate.contentReference,
    )!!

  public companion object {
    public fun fromModel(
      model: Communication.Payload.Content
    ): CommunicationPayloadContentSurrogate =
      with(model) {
        CommunicationPayloadContentSurrogate(
          contentString = this@with.asString()?.value?.value,
          _contentString = this@with.asString()?.value?.toElement(),
          contentAttachment = this@with.asAttachment()?.value,
          contentReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class CommunicationSurrogate(
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
  public var instantiatesCanonical: List<KotlinString?>? = null,
  public var _instantiatesCanonical: List<Element?>? = null,
  public var instantiatesUri: List<KotlinString?>? = null,
  public var _instantiatesUri: List<Element?>? = null,
  public var basedOn: List<Reference>? = null,
  public var partOf: List<Reference>? = null,
  public var inResponseTo: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: CodeableConcept? = null,
  public var category: List<CodeableConcept>? = null,
  public var priority: KotlinString? = null,
  public var _priority: Element? = null,
  public var medium: List<CodeableConcept>? = null,
  public var subject: Reference? = null,
  public var topic: CodeableConcept? = null,
  public var about: List<Reference>? = null,
  public var encounter: Reference? = null,
  public var sent: KotlinString? = null,
  public var _sent: Element? = null,
  public var received: KotlinString? = null,
  public var _received: Element? = null,
  public var recipient: List<Reference>? = null,
  public var sender: Reference? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var payload: List<Communication.Payload>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): Communication =
    Communication(
      id = this@CommunicationSurrogate.id,
      meta = this@CommunicationSurrogate.meta,
      implicitRules =
        Uri.of(
          this@CommunicationSurrogate.implicitRules,
          this@CommunicationSurrogate._implicitRules,
        ),
      language =
        Code.of(this@CommunicationSurrogate.language, this@CommunicationSurrogate._language),
      text = this@CommunicationSurrogate.text,
      contained = this@CommunicationSurrogate.contained ?: listOf(),
      extension = this@CommunicationSurrogate.extension ?: listOf(),
      modifierExtension = this@CommunicationSurrogate.modifierExtension ?: listOf(),
      identifier = this@CommunicationSurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        if (
          this@CommunicationSurrogate.instantiatesCanonical == null &&
            this@CommunicationSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@CommunicationSurrogate.instantiatesCanonical
              ?: List(this@CommunicationSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@CommunicationSurrogate._instantiatesCanonical
                ?: List(this@CommunicationSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@CommunicationSurrogate.instantiatesUri == null &&
            this@CommunicationSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@CommunicationSurrogate.instantiatesUri
              ?: List(this@CommunicationSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@CommunicationSurrogate._instantiatesUri
                ?: List(this@CommunicationSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      basedOn = this@CommunicationSurrogate.basedOn ?: listOf(),
      partOf = this@CommunicationSurrogate.partOf ?: listOf(),
      inResponseTo = this@CommunicationSurrogate.inResponseTo ?: listOf(),
      status =
        Enumeration.of(
          Communication.EventStatus.fromCode(this@CommunicationSurrogate.status!!),
          this@CommunicationSurrogate._status,
        ),
      statusReason = this@CommunicationSurrogate.statusReason,
      category = this@CommunicationSurrogate.category ?: listOf(),
      priority =
        this@CommunicationSurrogate.priority?.let {
          Enumeration.of(
            Communication.RequestPriority.fromCode(it),
            this@CommunicationSurrogate._priority,
          )
        },
      medium = this@CommunicationSurrogate.medium ?: listOf(),
      subject = this@CommunicationSurrogate.subject,
      topic = this@CommunicationSurrogate.topic,
      about = this@CommunicationSurrogate.about ?: listOf(),
      encounter = this@CommunicationSurrogate.encounter,
      sent =
        DateTime.of(
          FhirDateTime.fromString(this@CommunicationSurrogate.sent),
          this@CommunicationSurrogate._sent,
        ),
      received =
        DateTime.of(
          FhirDateTime.fromString(this@CommunicationSurrogate.received),
          this@CommunicationSurrogate._received,
        ),
      recipient = this@CommunicationSurrogate.recipient ?: listOf(),
      sender = this@CommunicationSurrogate.sender,
      reasonCode = this@CommunicationSurrogate.reasonCode ?: listOf(),
      reasonReference = this@CommunicationSurrogate.reasonReference ?: listOf(),
      payload = this@CommunicationSurrogate.payload ?: listOf(),
      note = this@CommunicationSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Communication): CommunicationSurrogate =
      with(model) {
        CommunicationSurrogate(
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
          instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          instantiatesUri =
            this@with.instantiatesUri
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesUri =
            this@with.instantiatesUri
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          inResponseTo = this@with.inResponseTo.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusReason = this@with.statusReason,
          category = this@with.category.takeIf { it.isNotEmpty() },
          priority = this@with.priority?.value?.getCode(),
          _priority = this@with.priority?.toElement(),
          medium = this@with.medium.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          topic = this@with.topic,
          about = this@with.about.takeIf { it.isNotEmpty() },
          encounter = this@with.encounter,
          sent = this@with.sent?.value?.toString(),
          _sent = this@with.sent?.toElement(),
          received = this@with.received?.value?.toString(),
          _received = this@with.received?.toElement(),
          recipient = this@with.recipient.takeIf { it.isNotEmpty() },
          sender = this@with.sender,
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          payload = this@with.payload.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
