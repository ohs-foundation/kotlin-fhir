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

import com.google.fhir.model.r4.Canonical
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Coding
import com.google.fhir.model.r4.ContactPoint
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Id
import com.google.fhir.model.r4.MessageHeader
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.Url
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MessageHeaderDestinationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var target: Reference? = null,
  public var endpoint: KotlinString? = null,
  public var _endpoint: Element? = null,
  public var `receiver`: Reference? = null,
) {
  public fun toModel(): MessageHeader.Destination =
    MessageHeader.Destination(
      id = this@MessageHeaderDestinationSurrogate.id,
      extension = this@MessageHeaderDestinationSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageHeaderDestinationSurrogate.modifierExtension ?: listOf(),
      name =
        R4String.of(
          this@MessageHeaderDestinationSurrogate.name,
          this@MessageHeaderDestinationSurrogate._name,
        ),
      target = this@MessageHeaderDestinationSurrogate.target,
      endpoint =
        Url.of(
          this@MessageHeaderDestinationSurrogate.endpoint,
          this@MessageHeaderDestinationSurrogate._endpoint,
        )!!,
      `receiver` = this@MessageHeaderDestinationSurrogate.`receiver`,
    )

  public companion object {
    public fun fromModel(model: MessageHeader.Destination): MessageHeaderDestinationSurrogate =
      with(model) {
        MessageHeaderDestinationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          target = this@with.target,
          endpoint = this@with.endpoint.value,
          _endpoint = this@with.endpoint.toElement(),
          `receiver` = this@with.`receiver`,
        )
      }
  }
}

@Serializable
internal data class MessageHeaderSourceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var software: KotlinString? = null,
  public var _software: Element? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var contact: ContactPoint? = null,
  public var endpoint: KotlinString? = null,
  public var _endpoint: Element? = null,
) {
  public fun toModel(): MessageHeader.Source =
    MessageHeader.Source(
      id = this@MessageHeaderSourceSurrogate.id,
      extension = this@MessageHeaderSourceSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageHeaderSourceSurrogate.modifierExtension ?: listOf(),
      name =
        R4String.of(
          this@MessageHeaderSourceSurrogate.name,
          this@MessageHeaderSourceSurrogate._name,
        ),
      software =
        R4String.of(
          this@MessageHeaderSourceSurrogate.software,
          this@MessageHeaderSourceSurrogate._software,
        ),
      version =
        R4String.of(
          this@MessageHeaderSourceSurrogate.version,
          this@MessageHeaderSourceSurrogate._version,
        ),
      contact = this@MessageHeaderSourceSurrogate.contact,
      endpoint =
        Url.of(
          this@MessageHeaderSourceSurrogate.endpoint,
          this@MessageHeaderSourceSurrogate._endpoint,
        )!!,
    )

  public companion object {
    public fun fromModel(model: MessageHeader.Source): MessageHeaderSourceSurrogate =
      with(model) {
        MessageHeaderSourceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          software = this@with.software?.value,
          _software = this@with.software?.toElement(),
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          contact = this@with.contact,
          endpoint = this@with.endpoint.value,
          _endpoint = this@with.endpoint.toElement(),
        )
      }
  }
}

@Serializable
internal data class MessageHeaderResponseSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: KotlinString? = null,
  public var _identifier: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var details: Reference? = null,
) {
  public fun toModel(): MessageHeader.Response =
    MessageHeader.Response(
      id = this@MessageHeaderResponseSurrogate.id,
      extension = this@MessageHeaderResponseSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageHeaderResponseSurrogate.modifierExtension ?: listOf(),
      identifier =
        Id.of(
          this@MessageHeaderResponseSurrogate.identifier,
          this@MessageHeaderResponseSurrogate._identifier,
        )!!,
      code =
        Enumeration.of(
          MessageHeader.ResponseType.fromCode(this@MessageHeaderResponseSurrogate.code!!),
          this@MessageHeaderResponseSurrogate._code,
        ),
      details = this@MessageHeaderResponseSurrogate.details,
    )

  public companion object {
    public fun fromModel(model: MessageHeader.Response): MessageHeaderResponseSurrogate =
      with(model) {
        MessageHeaderResponseSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.value,
          _identifier = this@with.identifier.toElement(),
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          details = this@with.details,
        )
      }
  }
}

@Serializable
internal data class MessageHeaderEventSurrogate(
  public var eventCoding: Coding? = null,
  public var eventUri: KotlinString? = null,
  public var _eventUri: Element? = null,
) {
  public fun toModel(): MessageHeader.Event =
    MessageHeader.Event.from(
      this@MessageHeaderEventSurrogate.eventCoding,
      Uri.of(this@MessageHeaderEventSurrogate.eventUri, this@MessageHeaderEventSurrogate._eventUri),
    )!!

  public companion object {
    public fun fromModel(model: MessageHeader.Event): MessageHeaderEventSurrogate =
      with(model) {
        MessageHeaderEventSurrogate(
          eventCoding = this@with.asCoding()?.value,
          eventUri = this@with.asUri()?.value?.value,
          _eventUri = this@with.asUri()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MessageHeaderSurrogate(
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
  public var event: MessageHeader.Event,
  public var destination: List<MessageHeader.Destination>? = null,
  public var sender: Reference? = null,
  public var enterer: Reference? = null,
  public var author: Reference? = null,
  public var source: MessageHeader.Source,
  public var responsible: Reference? = null,
  public var reason: CodeableConcept? = null,
  public var response: MessageHeader.Response? = null,
  public var focus: List<Reference>? = null,
  public var definition: KotlinString? = null,
  public var _definition: Element? = null,
) {
  public fun toModel(): MessageHeader =
    MessageHeader(
      id = this@MessageHeaderSurrogate.id,
      meta = this@MessageHeaderSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MessageHeaderSurrogate.implicitRules,
          this@MessageHeaderSurrogate._implicitRules,
        ),
      language =
        Code.of(this@MessageHeaderSurrogate.language, this@MessageHeaderSurrogate._language),
      text = this@MessageHeaderSurrogate.text,
      contained = this@MessageHeaderSurrogate.contained ?: listOf(),
      extension = this@MessageHeaderSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageHeaderSurrogate.modifierExtension ?: listOf(),
      event = this@MessageHeaderSurrogate.event,
      destination = this@MessageHeaderSurrogate.destination ?: listOf(),
      sender = this@MessageHeaderSurrogate.sender,
      enterer = this@MessageHeaderSurrogate.enterer,
      author = this@MessageHeaderSurrogate.author,
      source = this@MessageHeaderSurrogate.source,
      responsible = this@MessageHeaderSurrogate.responsible,
      reason = this@MessageHeaderSurrogate.reason,
      response = this@MessageHeaderSurrogate.response,
      focus = this@MessageHeaderSurrogate.focus ?: listOf(),
      definition =
        Canonical.of(
          this@MessageHeaderSurrogate.definition,
          this@MessageHeaderSurrogate._definition,
        ),
    )

  public companion object {
    public fun fromModel(model: MessageHeader): MessageHeaderSurrogate =
      with(model) {
        MessageHeaderSurrogate(
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
          event = this@with.event,
          destination = this@with.destination.takeIf { it.isNotEmpty() },
          sender = this@with.sender,
          enterer = this@with.enterer,
          author = this@with.author,
          source = this@with.source,
          responsible = this@with.responsible,
          reason = this@with.reason,
          response = this@with.response,
          focus = this@with.focus.takeIf { it.isNotEmpty() },
          definition = this@with.definition?.value,
          _definition = this@with.definition?.toElement(),
        )
      }
  }
}
