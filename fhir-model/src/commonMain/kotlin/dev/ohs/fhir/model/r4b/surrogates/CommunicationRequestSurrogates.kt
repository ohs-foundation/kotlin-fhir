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
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.CommunicationRequest
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CommunicationRequestPayloadSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var content: CommunicationRequest.Payload.Content,
) {
  public fun toModel(): CommunicationRequest.Payload =
    CommunicationRequest.Payload(
      id = this@CommunicationRequestPayloadSurrogate.id,
      extension = this@CommunicationRequestPayloadSurrogate.extension ?: listOf(),
      modifierExtension = this@CommunicationRequestPayloadSurrogate.modifierExtension ?: listOf(),
      content = this@CommunicationRequestPayloadSurrogate.content,
    )

  public companion object {
    public fun fromModel(
      model: CommunicationRequest.Payload
    ): CommunicationRequestPayloadSurrogate =
      with(model) {
        CommunicationRequestPayloadSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          content = this@with.content,
        )
      }
  }
}

@Serializable
internal data class CommunicationRequestPayloadContentSurrogate(
  public var contentString: KotlinString? = null,
  public var _contentString: Element? = null,
  public var contentAttachment: Attachment? = null,
  public var contentReference: Reference? = null,
) {
  public fun toModel(): CommunicationRequest.Payload.Content =
    CommunicationRequest.Payload.Content.from(
      R4bString.of(
        this@CommunicationRequestPayloadContentSurrogate.contentString,
        this@CommunicationRequestPayloadContentSurrogate._contentString,
      ),
      this@CommunicationRequestPayloadContentSurrogate.contentAttachment,
      this@CommunicationRequestPayloadContentSurrogate.contentReference,
    )!!

  public companion object {
    public fun fromModel(
      model: CommunicationRequest.Payload.Content
    ): CommunicationRequestPayloadContentSurrogate =
      with(model) {
        CommunicationRequestPayloadContentSurrogate(
          contentString = this@with.asString()?.value?.value,
          _contentString = this@with.asString()?.value?.toElement(),
          contentAttachment = this@with.asAttachment()?.value,
          contentReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class CommunicationRequestOccurrenceSurrogate(
  public var occurrenceDateTime: KotlinString? = null,
  public var _occurrenceDateTime: Element? = null,
  public var occurrencePeriod: Period? = null,
) {
  public fun toModel(): CommunicationRequest.Occurrence =
    CommunicationRequest.Occurrence.from(
      DateTime.of(
        FhirDateTime.fromString(this@CommunicationRequestOccurrenceSurrogate.occurrenceDateTime),
        this@CommunicationRequestOccurrenceSurrogate._occurrenceDateTime,
      ),
      this@CommunicationRequestOccurrenceSurrogate.occurrencePeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: CommunicationRequest.Occurrence
    ): CommunicationRequestOccurrenceSurrogate =
      with(model) {
        CommunicationRequestOccurrenceSurrogate(
          occurrenceDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _occurrenceDateTime = this@with.asDateTime()?.value?.toElement(),
          occurrencePeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class CommunicationRequestSurrogate(
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
  public var basedOn: List<Reference>? = null,
  public var replaces: List<Reference>? = null,
  public var groupIdentifier: Identifier? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: CodeableConcept? = null,
  public var category: List<CodeableConcept>? = null,
  public var priority: KotlinString? = null,
  public var _priority: Element? = null,
  public var doNotPerform: KotlinBoolean? = null,
  public var _doNotPerform: Element? = null,
  public var medium: List<CodeableConcept>? = null,
  public var subject: Reference? = null,
  public var about: List<Reference>? = null,
  public var encounter: Reference? = null,
  public var payload: List<CommunicationRequest.Payload>? = null,
  public var occurrence: CommunicationRequest.Occurrence? = null,
  public var authoredOn: KotlinString? = null,
  public var _authoredOn: Element? = null,
  public var requester: Reference? = null,
  public var recipient: List<Reference>? = null,
  public var sender: Reference? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): CommunicationRequest =
    CommunicationRequest(
      id = this@CommunicationRequestSurrogate.id,
      meta = this@CommunicationRequestSurrogate.meta,
      implicitRules =
        Uri.of(
          this@CommunicationRequestSurrogate.implicitRules,
          this@CommunicationRequestSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@CommunicationRequestSurrogate.language,
          this@CommunicationRequestSurrogate._language,
        ),
      text = this@CommunicationRequestSurrogate.text,
      contained = this@CommunicationRequestSurrogate.contained ?: listOf(),
      extension = this@CommunicationRequestSurrogate.extension ?: listOf(),
      modifierExtension = this@CommunicationRequestSurrogate.modifierExtension ?: listOf(),
      identifier = this@CommunicationRequestSurrogate.identifier ?: listOf(),
      basedOn = this@CommunicationRequestSurrogate.basedOn ?: listOf(),
      replaces = this@CommunicationRequestSurrogate.replaces ?: listOf(),
      groupIdentifier = this@CommunicationRequestSurrogate.groupIdentifier,
      status =
        Enumeration.of(
          CommunicationRequest.RequestStatus.fromCode(this@CommunicationRequestSurrogate.status!!),
          this@CommunicationRequestSurrogate._status,
        ),
      statusReason = this@CommunicationRequestSurrogate.statusReason,
      category = this@CommunicationRequestSurrogate.category ?: listOf(),
      priority =
        this@CommunicationRequestSurrogate.priority?.let {
          Enumeration.of(
            CommunicationRequest.RequestPriority.fromCode(it),
            this@CommunicationRequestSurrogate._priority,
          )
        },
      doNotPerform =
        R4bBoolean.of(
          this@CommunicationRequestSurrogate.doNotPerform,
          this@CommunicationRequestSurrogate._doNotPerform,
        ),
      medium = this@CommunicationRequestSurrogate.medium ?: listOf(),
      subject = this@CommunicationRequestSurrogate.subject,
      about = this@CommunicationRequestSurrogate.about ?: listOf(),
      encounter = this@CommunicationRequestSurrogate.encounter,
      payload = this@CommunicationRequestSurrogate.payload ?: listOf(),
      occurrence = this@CommunicationRequestSurrogate.occurrence,
      authoredOn =
        DateTime.of(
          FhirDateTime.fromString(this@CommunicationRequestSurrogate.authoredOn),
          this@CommunicationRequestSurrogate._authoredOn,
        ),
      requester = this@CommunicationRequestSurrogate.requester,
      recipient = this@CommunicationRequestSurrogate.recipient ?: listOf(),
      sender = this@CommunicationRequestSurrogate.sender,
      reasonCode = this@CommunicationRequestSurrogate.reasonCode ?: listOf(),
      reasonReference = this@CommunicationRequestSurrogate.reasonReference ?: listOf(),
      note = this@CommunicationRequestSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: CommunicationRequest): CommunicationRequestSurrogate =
      with(model) {
        CommunicationRequestSurrogate(
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
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          replaces = this@with.replaces.takeIf { it.isNotEmpty() },
          groupIdentifier = this@with.groupIdentifier,
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusReason = this@with.statusReason,
          category = this@with.category.takeIf { it.isNotEmpty() },
          priority = this@with.priority?.value?.getCode(),
          _priority = this@with.priority?.toElement(),
          doNotPerform = this@with.doNotPerform?.value,
          _doNotPerform = this@with.doNotPerform?.toElement(),
          medium = this@with.medium.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          about = this@with.about.takeIf { it.isNotEmpty() },
          encounter = this@with.encounter,
          payload = this@with.payload.takeIf { it.isNotEmpty() },
          occurrence = this@with.occurrence,
          authoredOn = this@with.authoredOn?.value?.toString(),
          _authoredOn = this@with.authoredOn?.toElement(),
          requester = this@with.requester,
          recipient = this@with.recipient.takeIf { it.isNotEmpty() },
          sender = this@with.sender,
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}
