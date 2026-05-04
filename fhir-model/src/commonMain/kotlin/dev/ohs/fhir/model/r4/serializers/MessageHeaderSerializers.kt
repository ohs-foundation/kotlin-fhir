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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.MessageHeader
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("target", Reference.serializer().descriptor, isOptional = true)
      element("endpoint", KotlinString.serializer().descriptor, isOptional = true)
      element("_endpoint", Element.serializer().descriptor, isOptional = true)
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
    var name: KotlinString? = null
    var _name: Element? = null
    var target: Reference? = null
    var endpoint: KotlinString? = null
    var _endpoint: Element? = null
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
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> target = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.targetSer, null)
        6 -> endpoint = decoder.decodeStringElement(__desc, 6)
        7 -> _endpoint = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.nameSer, null)
        8 ->
          `receiver` = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Destination: " + __i)
      }
    }
    return MessageHeader.Destination(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name),
      target = target,
      endpoint = Url.of(endpoint, _endpoint)!!,
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
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    (value.target)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.targetSer, it) }
    ((value.endpoint.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.endpoint.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.nameSer, it)
    }
    (value.`receiver`)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.targetSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val targetSer: KSerializer<Reference> = Reference.serializer()
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("software", KotlinString.serializer().descriptor, isOptional = true)
      element("_software", Element.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("contact", ContactPoint.serializer().descriptor, isOptional = true)
      element("endpoint", KotlinString.serializer().descriptor, isOptional = true)
      element("_endpoint", Element.serializer().descriptor, isOptional = true)
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
    var name: KotlinString? = null
    var _name: Element? = null
    var software: KotlinString? = null
    var _software: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var contact: ContactPoint? = null
    var endpoint: KotlinString? = null
    var _endpoint: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> software = decoder.decodeStringElement(__desc, 5)
        6 -> _software = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> version = decoder.decodeStringElement(__desc, 7)
        8 -> _version = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        9 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.contactSer, null)
        10 -> endpoint = decoder.decodeStringElement(__desc, 10)
        11 ->
          _endpoint = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Source: " + __i)
      }
    }
    return MessageHeader.Source(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name),
      software = R4String.of(software, _software),
      version = R4String.of(version, _version),
      contact = contact,
      endpoint = Url.of(endpoint, _endpoint)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MessageHeader.Source) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.software?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.software?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
    }
    (value.contact)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.contactSer, it) }
    ((value.endpoint.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.endpoint.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

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
      element("identifier", KotlinString.serializer().descriptor, isOptional = true)
      element("_identifier", Element.serializer().descriptor, isOptional = true)
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
    var identifier: KotlinString? = null
    var _identifier: Element? = null
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
        3 -> identifier = decoder.decodeStringElement(__desc, 3)
        4 ->
          _identifier =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.identifierSer, null)
        5 -> code = decoder.decodeStringElement(__desc, 5)
        6 ->
          _code = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.identifierSer, null)
        7 ->
          details = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.detailsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Response: " + __i)
      }
    }
    return MessageHeader.Response(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = Id.of(identifier, _identifier)!!,
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
    ((value.identifier.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.identifier.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.identifierSer, it)
    }
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.identifierSer, it)
    }
    (value.details)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.detailsSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Element> = Element.serializer()

    public val detailsSer: KSerializer<Reference> = Reference.serializer()
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
      element("eventUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_eventUri", Element.serializer().descriptor, isOptional = true)
      element(
        "destination",
        listSerialDescriptor(lazyDescriptor { MessageHeader.Destination.serializer().descriptor }),
        isOptional = true,
      )
      element("sender", Reference.serializer().descriptor, isOptional = true)
      element("enterer", Reference.serializer().descriptor, isOptional = true)
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
    var eventUri: KotlinString? = null
    var _eventUri: Element? = null
    var destination: List<MessageHeader.Destination>? = null
    var sender: Reference? = null
    var enterer: Reference? = null
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
        12 -> eventUri = decoder.decodeStringElement(__desc, 12)
        13 ->
          _eventUri =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          destination =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.destinationSer, null)
        15 ->
          sender = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.senderSer, null)
        16 ->
          enterer = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.senderSer, null)
        17 ->
          author = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.senderSer, null)
        18 ->
          source = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.sourceSer, null)
        19 ->
          responsible =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.senderSer, null)
        20 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.reasonSer, null)
        21 ->
          response =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.responseSer, null)
        22 -> focus = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.focusSer, null)
        23 -> definition = decoder.decodeStringElement(__desc, 23)
        24 ->
          _definition =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
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
      event = MessageHeader.Event.from(eventCoding, Uri.of(eventUri, _eventUri))!!,
      destination = destination ?: listOf(),
      sender = sender,
      enterer = enterer,
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
      is MessageHeader.Event.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.destination.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.destinationSer, value.destination)
    (value.sender)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.senderSer, it) }
    (value.enterer)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.senderSer, it) }
    (value.author)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.senderSer, it) }
    (value.source)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.sourceSer, it) }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.senderSer, it)
    }
    (value.reason)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.reasonSer, it) }
    (value.response)?.let { encoder.encodeSerializableElement(__desc, 21, Hoisted.responseSer, it) }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.focusSer, value.focus)
    ((value.definition?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
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
