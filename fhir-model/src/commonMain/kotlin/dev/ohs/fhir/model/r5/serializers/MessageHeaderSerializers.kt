/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MessageHeader
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object MessageHeaderDestinationSerializer : KSerializer<MessageHeader.Destination> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Destination") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("endpointUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_endpointUrl", Element.serializer().descriptor, isOptional = true)
      element("endpointReference", Reference.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("target", Reference.serializer().descriptor, isOptional = true)
      element("receiver", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MessageHeader.Destination =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Destination) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MessageHeader.Destination {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var endpointUrl: KotlinString? = null
    var _endpointUrl: Element? = null
    var endpointReference: Reference? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var target: Reference? = null
    var `receiver`: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> endpointUrl = decoder.decodeStringElement(__desc, 3)
        4 ->
          _endpointUrl =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.endpointUrlSer, null)
        5 ->
          endpointReference =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.endpointReferenceSer, null)
        6 -> name = decoder.decodeStringElement(__desc, 6)
        7 ->
          _name = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.endpointUrlSer, null)
        8 ->
          target =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.endpointReferenceSer, null)
        9 ->
          `receiver` =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.endpointReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Destination: " + __i)
      }
    }
    return MessageHeader.Destination(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      endpoint =
        MessageHeader.Destination.Endpoint.from(
          Url.of(endpointUrl, _endpointUrl),
          endpointReference,
        ),
      name = R5String.of(name, _name),
      target = target,
      `receiver` = `receiver`,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MessageHeader.Destination) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.endpoint) {
      null -> {}
      is MessageHeader.Destination.Endpoint.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.endpointUrlSer, it)
        }
      }
      is MessageHeader.Destination.Endpoint.Reference -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.endpointReferenceSer, __d.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.endpointUrlSer, it)
    }
    (value.target)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.endpointReferenceSer, it)
    }
    (value.`receiver`)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.endpointReferenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val endpointUrlSer: KSerializer<Element> = Element.serializer()

    public val endpointReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MessageHeaderSourceSerializer : KSerializer<MessageHeader.Source> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Source") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("endpointUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_endpointUrl", Element.serializer().descriptor, isOptional = true)
      element("endpointReference", Reference.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("software", KotlinString.serializer().descriptor, isOptional = true)
      element("_software", Element.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("contact", ContactPoint.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MessageHeader.Source =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Source) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MessageHeader.Source {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var endpointUrl: KotlinString? = null
    var _endpointUrl: Element? = null
    var endpointReference: Reference? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var software: KotlinString? = null
    var _software: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var contact: ContactPoint? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> endpointUrl = decoder.decodeStringElement(__desc, 3)
        4 ->
          _endpointUrl =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.endpointUrlSer, null)
        5 ->
          endpointReference =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.endpointReferenceSer, null)
        6 -> name = decoder.decodeStringElement(__desc, 6)
        7 ->
          _name = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.endpointUrlSer, null)
        8 -> software = decoder.decodeStringElement(__desc, 8)
        9 ->
          _software =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.endpointUrlSer, null)
        10 -> version = decoder.decodeStringElement(__desc, 10)
        11 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.endpointUrlSer, null)
        12 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.contactSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Source: " + __i)
      }
    }
    return MessageHeader.Source(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      endpoint =
        MessageHeader.Source.Endpoint.from(Url.of(endpointUrl, _endpointUrl), endpointReference),
      name = R5String.of(name, _name),
      software = R5String.of(software, _software),
      version = R5String.of(version, _version),
      contact = contact,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MessageHeader.Source) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.endpoint) {
      null -> {}
      is MessageHeader.Source.Endpoint.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.endpointUrlSer, it)
        }
      }
      is MessageHeader.Source.Endpoint.Reference -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.endpointReferenceSer, __d.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.endpointUrlSer, it)
    }
    ((value.software?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.software?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.endpointUrlSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.endpointUrlSer, it)
    }
    (value.contact)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.contactSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val endpointUrlSer: KSerializer<Element> = Element.serializer()

    public val endpointReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contactSer: KSerializer<ContactPoint> = ContactPoint.serializer()
  }
}

internal object MessageHeaderResponseSerializer : KSerializer<MessageHeader.Response> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Response") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("details", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MessageHeader.Response =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Response) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MessageHeader.Response {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var details: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 -> code = decoder.decodeStringElement(__desc, 4)
        5 -> _code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 ->
          details = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.detailsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Response: " + __i)
      }
    }
    return MessageHeader.Response(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier!!,
      code = Enumeration.of(MessageHeader.ResponseType.fromCode(code!!), _code),
      details = details,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MessageHeader.Response) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, it)
    }
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it)
    }
    (value.details)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.detailsSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val detailsSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MessageHeaderEventSerializer : KSerializer<MessageHeader.Event> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MessageHeader.Event") {
      element("eventCoding", Coding.serializer().descriptor, isOptional = true)
      element("eventCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_eventCanonical", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Event) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is MessageHeader.Event.Coding -> {
          encodeSerializableElement(__desc, 0, Hoisted.eventCodingSer, __d.value)
        }
        is MessageHeader.Event.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 1, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 2, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Event =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): MessageHeader.Event {
    val __desc = descriptor
    var eventCoding: Coding? = null
    var eventCanonical: KotlinString? = null
    var _eventCanonical: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          eventCoding =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.eventCodingSer, null)
        1 -> eventCanonical = decoder.decodeStringElement(__desc, 1)
        2 ->
          _eventCanonical =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding MessageHeader.Event: " + __i)
      }
    }
    return MessageHeader.Event.from(eventCoding, Canonical.of(eventCanonical, _eventCanonical))!!
  }

  private object Hoisted {
    public val eventCodingSer: KSerializer<Coding> = Coding.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MessageHeaderDestinationEndpointSerializer :
  KSerializer<MessageHeader.Destination.Endpoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MessageHeader.Destination.Endpoint") {
      element("endpointUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_endpointUrl", Element.serializer().descriptor, isOptional = true)
      element("endpointReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Destination.Endpoint) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is MessageHeader.Destination.Endpoint.Url -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is MessageHeader.Destination.Endpoint.Reference -> {
          encodeSerializableElement(__desc, 2, Hoisted.endpointReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Destination.Endpoint =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): MessageHeader.Destination.Endpoint {
    val __desc = descriptor
    var endpointUrl: KotlinString? = null
    var _endpointUrl: Element? = null
    var endpointReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> endpointUrl = decoder.decodeStringElement(__desc, 0)
        1 ->
          _endpointUrl =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          endpointReference =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.endpointReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MessageHeader.Destination.Endpoint: " + __i
          )
      }
    }
    return MessageHeader.Destination.Endpoint.from(
      Url.of(endpointUrl, _endpointUrl),
      endpointReference,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val endpointReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MessageHeaderSourceEndpointSerializer : KSerializer<MessageHeader.Source.Endpoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MessageHeader.Source.Endpoint") {
      element("endpointUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_endpointUrl", Element.serializer().descriptor, isOptional = true)
      element("endpointReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Source.Endpoint) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is MessageHeader.Source.Endpoint.Url -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is MessageHeader.Source.Endpoint.Reference -> {
          encodeSerializableElement(__desc, 2, Hoisted.endpointReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Source.Endpoint =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): MessageHeader.Source.Endpoint {
    val __desc = descriptor
    var endpointUrl: KotlinString? = null
    var _endpointUrl: Element? = null
    var endpointReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> endpointUrl = decoder.decodeStringElement(__desc, 0)
        1 ->
          _endpointUrl =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          endpointReference =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.endpointReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MessageHeader.Source.Endpoint: " + __i
          )
      }
    }
    return MessageHeader.Source.Endpoint.from(
      Url.of(endpointUrl, _endpointUrl),
      endpointReference,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val endpointReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MessageHeaderSerializer : KSerializer<MessageHeader> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MessageHeader") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("eventCoding", Coding.serializer().descriptor, isOptional = true)
      element("eventCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_eventCanonical", Element.serializer().descriptor, isOptional = true)
      element(
        "destination",
        listSerialDescriptor(lazyDescriptor { MessageHeader.Destination.serializer().descriptor }),
        isOptional = true,
      )
      element("sender", Reference.serializer().descriptor, isOptional = true)
      element("author", Reference.serializer().descriptor, isOptional = true)
      element(
        "source",
        lazyDescriptor { MessageHeader.Source.serializer().descriptor },
        isOptional = true,
      )
      element("responsible", Reference.serializer().descriptor, isOptional = true)
      element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "response",
        lazyDescriptor { MessageHeader.Response.serializer().descriptor },
        isOptional = true,
      )
      element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("definition", KotlinString.serializer().descriptor, isOptional = true)
      element("_definition", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MessageHeader =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MessageHeader) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MessageHeader {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var eventCoding: Coding? = null
    var eventCanonical: KotlinString? = null
    var _eventCanonical: Element? = null
    var destination: List<MessageHeader.Destination>? = null
    var sender: Reference? = null
    var author: Reference? = null
    var source: MessageHeader.Source? = null
    var responsible: Reference? = null
    var reason: CodeableConcept? = null
    var response: MessageHeader.Response? = null
    var focus: List<Reference>? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          eventCoding =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.eventCodingSer, null)
        12 -> eventCanonical = decoder.decodeStringElement(__desc, 12)
        13 ->
          _eventCanonical =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          destination =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.destinationSer, null)
        15 ->
          sender = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.senderSer, null)
        16 ->
          author = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.senderSer, null)
        17 ->
          source = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.sourceSer, null)
        18 ->
          responsible =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.senderSer, null)
        19 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.reasonSer, null)
        20 ->
          response =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.responseSer, null)
        21 -> focus = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.focusSer, null)
        22 -> definition = decoder.decodeStringElement(__desc, 22)
        23 ->
          _definition =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MessageHeader: " + __i)
      }
    }
    return MessageHeader(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      event =
        MessageHeader.Event.from(eventCoding, Canonical.of(eventCanonical, _eventCanonical))!!,
      destination = destination ?: listOf(),
      sender = sender,
      author = author,
      source = source!!,
      responsible = responsible,
      reason = reason,
      response = response,
      focus = focus ?: listOf(),
      definition = Canonical.of(definition, _definition),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MessageHeader) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MessageHeader")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.event) {
      null -> {}
      is MessageHeader.Event.Coding -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.eventCodingSer, __d.value)
      }
      is MessageHeader.Event.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.destination.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.destinationSer, value.destination)
    (value.sender)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.senderSer, it) }
    (value.author)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.senderSer, it) }
    (value.source)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.sourceSer, it) }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.senderSer, it)
    }
    (value.reason)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.reasonSer, it) }
    (value.response)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.responseSer, it) }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.focusSer, value.focus)
    ((value.definition?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val eventCodingSer: KSerializer<Coding> = Coding.serializer()

    public val destinationSerInner: KSerializer<MessageHeader.Destination> =
      MessageHeader.Destination.serializer()

    public val destinationSer: KSerializer<List<MessageHeader.Destination>> =
      ListSerializer(Hoisted.destinationSerInner)

    public val senderSer: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<MessageHeader.Source> = MessageHeader.Source.serializer()

    public val reasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val responseSer: KSerializer<MessageHeader.Response> =
      MessageHeader.Response.serializer()

    public val focusSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.senderSer)
  }
}
