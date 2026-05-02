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

import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactPoint
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.MessageHeader
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.Url
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
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
  public var endpoint: MessageHeader.Destination.Endpoint? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var target: Reference? = null,
  public var `receiver`: Reference? = null,
) {
  public fun toModel(): MessageHeader.Destination =
    MessageHeader.Destination(
      id = this@MessageHeaderDestinationSurrogate.id,
      extension = this@MessageHeaderDestinationSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageHeaderDestinationSurrogate.modifierExtension ?: listOf(),
      endpoint = this@MessageHeaderDestinationSurrogate.endpoint,
      name =
        R5String.of(
          this@MessageHeaderDestinationSurrogate.name,
          this@MessageHeaderDestinationSurrogate._name,
        ),
      target = this@MessageHeaderDestinationSurrogate.target,
      `receiver` = this@MessageHeaderDestinationSurrogate.`receiver`,
    )

  public companion object {
    public fun fromModel(model: MessageHeader.Destination): MessageHeaderDestinationSurrogate =
      with(model) {
        MessageHeaderDestinationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          endpoint = this@with.endpoint,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          target = this@with.target,
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
  public var endpoint: MessageHeader.Source.Endpoint? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var software: KotlinString? = null,
  public var _software: Element? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var contact: ContactPoint? = null,
) {
  public fun toModel(): MessageHeader.Source =
    MessageHeader.Source(
      id = this@MessageHeaderSourceSurrogate.id,
      extension = this@MessageHeaderSourceSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageHeaderSourceSurrogate.modifierExtension ?: listOf(),
      endpoint = this@MessageHeaderSourceSurrogate.endpoint,
      name =
        R5String.of(
          this@MessageHeaderSourceSurrogate.name,
          this@MessageHeaderSourceSurrogate._name,
        ),
      software =
        R5String.of(
          this@MessageHeaderSourceSurrogate.software,
          this@MessageHeaderSourceSurrogate._software,
        ),
      version =
        R5String.of(
          this@MessageHeaderSourceSurrogate.version,
          this@MessageHeaderSourceSurrogate._version,
        ),
      contact = this@MessageHeaderSourceSurrogate.contact,
    )

  public companion object {
    public fun fromModel(model: MessageHeader.Source): MessageHeaderSourceSurrogate =
      with(model) {
        MessageHeaderSourceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          endpoint = this@with.endpoint,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          software = this@with.software?.value,
          _software = this@with.software?.toElement(),
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          contact = this@with.contact,
        )
      }
  }
}

@Serializable
internal data class MessageHeaderResponseSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var details: Reference? = null,
) {
  public fun toModel(): MessageHeader.Response =
    MessageHeader.Response(
      id = this@MessageHeaderResponseSurrogate.id,
      extension = this@MessageHeaderResponseSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageHeaderResponseSurrogate.modifierExtension ?: listOf(),
      identifier = this@MessageHeaderResponseSurrogate.identifier,
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
          identifier = this@with.identifier,
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
  public var eventCanonical: KotlinString? = null,
  public var _eventCanonical: Element? = null,
) {
  public fun toModel(): MessageHeader.Event =
    MessageHeader.Event.from(
      this@MessageHeaderEventSurrogate.eventCoding,
      Canonical.of(
        this@MessageHeaderEventSurrogate.eventCanonical,
        this@MessageHeaderEventSurrogate._eventCanonical,
      ),
    )!!

  public companion object {
    public fun fromModel(model: MessageHeader.Event): MessageHeaderEventSurrogate =
      with(model) {
        MessageHeaderEventSurrogate(
          eventCoding = this@with.asCoding()?.value,
          eventCanonical = this@with.asCanonical()?.value?.value,
          _eventCanonical = this@with.asCanonical()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MessageHeaderDestinationEndpointSurrogate(
  public var endpointUrl: KotlinString? = null,
  public var _endpointUrl: Element? = null,
  public var endpointReference: Reference? = null,
) {
  public fun toModel(): MessageHeader.Destination.Endpoint =
    MessageHeader.Destination.Endpoint.from(
      Url.of(
        this@MessageHeaderDestinationEndpointSurrogate.endpointUrl,
        this@MessageHeaderDestinationEndpointSurrogate._endpointUrl,
      ),
      this@MessageHeaderDestinationEndpointSurrogate.endpointReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MessageHeader.Destination.Endpoint
    ): MessageHeaderDestinationEndpointSurrogate =
      with(model) {
        MessageHeaderDestinationEndpointSurrogate(
          endpointUrl = this@with.asUrl()?.value?.value,
          _endpointUrl = this@with.asUrl()?.value?.toElement(),
          endpointReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MessageHeaderSourceEndpointSurrogate(
  public var endpointUrl: KotlinString? = null,
  public var _endpointUrl: Element? = null,
  public var endpointReference: Reference? = null,
) {
  public fun toModel(): MessageHeader.Source.Endpoint =
    MessageHeader.Source.Endpoint.from(
      Url.of(
        this@MessageHeaderSourceEndpointSurrogate.endpointUrl,
        this@MessageHeaderSourceEndpointSurrogate._endpointUrl,
      ),
      this@MessageHeaderSourceEndpointSurrogate.endpointReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MessageHeader.Source.Endpoint
    ): MessageHeaderSourceEndpointSurrogate =
      with(model) {
        MessageHeaderSourceEndpointSurrogate(
          endpointUrl = this@with.asUrl()?.value?.value,
          _endpointUrl = this@with.asUrl()?.value?.toElement(),
          endpointReference = this@with.asReference()?.value,
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
