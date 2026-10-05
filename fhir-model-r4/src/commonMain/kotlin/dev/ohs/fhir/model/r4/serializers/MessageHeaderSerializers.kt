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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

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
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
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

  internal val listSerializer: KSerializer<List<MessageHeader.Destination>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageHeader.Destination =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Destination) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MessageHeader.Destination {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          target =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        6 -> endpoint = decoder.decodeStringElement(descriptor, i)
        7 ->
          _endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          `receiver` =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Destination: " + i)
      }
    }
    return MessageHeader.Destination(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name),
      target = target,
      endpoint =
        Url.of(endpoint, _endpoint)
          ?: throw SerializationException(
            "Missing required property 'endpoint' on MessageHeader.Destination"
          ),
      `receiver` = `receiver`,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MessageHeader.Destination) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.target)?.let {
      encoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, it)
    }
    ((value.endpoint.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.endpoint.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.`receiver`)?.let {
      encoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<MessageHeader.Source>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageHeader.Source =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Source) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MessageHeader.Source {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> software = decoder.decodeStringElement(descriptor, i)
        6 ->
          _software =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> version = decoder.decodeStringElement(descriptor, i)
        8 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
        10 -> endpoint = decoder.decodeStringElement(descriptor, i)
        11 ->
          _endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Source: " + i)
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
      endpoint =
        Url.of(endpoint, _endpoint)
          ?: throw SerializationException(
            "Missing required property 'endpoint' on MessageHeader.Source"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MessageHeader.Source) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.software?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.software?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
    (value.contact)?.let {
      encoder.encodeSerializableElement(descriptor, 9, ContactPointSerializer, it)
    }
    ((value.endpoint.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.endpoint.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<MessageHeader.Response>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageHeader.Response =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Response) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MessageHeader.Response {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: KotlinString? = null
    var _identifier: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var details: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> identifier = decoder.decodeStringElement(descriptor, i)
        4 ->
          _identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> code = decoder.decodeStringElement(descriptor, i)
        6 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 ->
          details =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Response: " + i)
      }
    }
    return MessageHeader.Response(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier =
        Id.of(identifier, _identifier)
          ?: throw SerializationException(
            "Missing required property 'identifier' on MessageHeader.Response"
          ),
      code =
        Enumeration.of(code?.let { MessageHeader.ResponseType.fromCode(it) }, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on MessageHeader.Response"
          ),
      details = details,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MessageHeader.Response) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.identifier.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.identifier.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.code.value?.code))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    (value.details)?.let {
      encoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, it)
    }
  }
}

internal object MessageHeaderSerializer : KSerializer<MessageHeader> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MessageHeader") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("eventCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("eventUri", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_eventUri", Element.serializer().descriptor, isOptional = true)
    b.element(
      "destination",
      listSerialDescriptor(lazyDescriptor { MessageHeader.Destination.serializer().descriptor }),
      isOptional = true,
    )
    b.element("sender", Reference.serializer().descriptor, isOptional = true)
    b.element("enterer", Reference.serializer().descriptor, isOptional = true)
    b.element("author", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "source",
      lazyDescriptor { MessageHeader.Source.serializer().descriptor },
      isOptional = true,
    )
    b.element("responsible", Reference.serializer().descriptor, isOptional = true)
    b.element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "response",
      lazyDescriptor { MessageHeader.Response.serializer().descriptor },
      isOptional = true,
    )
    b.element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("definition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_definition", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): MessageHeader =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: MessageHeader) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MessageHeader")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MessageHeader {
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          eventCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        11 -> eventUri = decoder.decodeStringElement(descriptor, i)
        12 ->
          _eventUri =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          destination =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageHeaderDestinationSerializer.listSerializer,
              null,
            )
        14 ->
          sender =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        15 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          source =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageHeaderSourceSerializer,
              null,
            )
        18 ->
          responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 ->
          response =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageHeaderResponseSerializer,
              null,
            )
        21 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 -> definition = decoder.decodeStringElement(descriptor, i)
        23 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        else -> throw SerializationException("Unexpected index decoding MessageHeader: " + i)
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
        MessageHeader.Event.from(eventCoding, Uri.of(eventUri, _eventUri))
          ?: throw SerializationException("Missing required property 'event' on MessageHeader"),
      destination = destination ?: listOf(),
      sender = sender,
      enterer = enterer,
      author = author,
      source =
        source
          ?: throw SerializationException("Missing required property 'source' on MessageHeader"),
      responsible = responsible,
      reason = reason,
      response = response,
      focus = focus ?: listOf(),
      definition = Canonical.of(definition, _definition),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MessageHeader,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.event) {
      is MessageHeader.Event.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          10 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
      is MessageHeader.Event.Uri -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            12 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
    }
    if (value.destination.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        MessageHeaderDestinationSerializer.listSerializer,
        value.destination,
      )
    (value.sender)?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, ReferenceSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      MessageHeaderSourceSerializer,
      value.source,
    )
    (value.responsible)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.reason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.response)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        MessageHeaderResponseSerializer,
        it,
      )
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.focus,
      )
    ((value.definition?.value))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ElementSerializer, it)
    }
  }
}

internal object MessageHeaderPolymorphicSerializer : KSerializer<MessageHeader> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MessageHeader") { MessageHeaderSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: MessageHeader) {
    encoder.encodeStructure(descriptor) {
      MessageHeaderSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MessageHeader =
    decoder.decodeStructure(descriptor) {
      MessageHeaderSerializer.deserializeInternal(this, descriptor, 0)
    }
}
