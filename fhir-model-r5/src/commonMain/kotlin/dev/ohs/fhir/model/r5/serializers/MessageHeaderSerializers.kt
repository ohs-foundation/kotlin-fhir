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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MessageHeader
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("endpointUrl", KotlinString.serializer().descriptor)
      optionalElement("_endpointUrl", ElementSerializer.descriptor)
      optionalElement("endpointReference", ReferenceSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("target", ReferenceSerializer.descriptor)
      optionalElement("receiver", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MessageHeader.Destination>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageHeader.Destination =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> endpointUrl = decodeStringElement(descriptor, i)
          4 ->
            _endpointUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            endpointReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> name = decodeStringElement(descriptor, i)
          7 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> target = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            `receiver` = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Destination: " + i)
        }
      }
      MessageHeader.Destination(
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

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Destination) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      when (val choice = value.endpoint) {
        null -> {}
        is MessageHeader.Destination.Endpoint.Url -> {
          encodeStringIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is MessageHeader.Destination.Endpoint.Reference -> {
          encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 6, value.name?.value)
      encodeElementIfNotNull(descriptor, 7, value.name)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.target)
      encodeSerializableIfNotNull(descriptor, 9, ReferenceSerializer, value.`receiver`)
    }
  }
}

internal object MessageHeaderSourceSerializer : KSerializer<MessageHeader.Source> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Source") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("endpointUrl", KotlinString.serializer().descriptor)
      optionalElement("_endpointUrl", ElementSerializer.descriptor)
      optionalElement("endpointReference", ReferenceSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("software", KotlinString.serializer().descriptor)
      optionalElement("_software", ElementSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
      optionalElement("contact", ContactPointSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MessageHeader.Source>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageHeader.Source =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> endpointUrl = decodeStringElement(descriptor, i)
          4 ->
            _endpointUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            endpointReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> name = decodeStringElement(descriptor, i)
          7 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> software = decodeStringElement(descriptor, i)
          9 -> _software = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> version = decodeStringElement(descriptor, i)
          11 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            contact = decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Source: " + i)
        }
      }
      MessageHeader.Source(
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

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Source) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      when (val choice = value.endpoint) {
        null -> {}
        is MessageHeader.Source.Endpoint.Url -> {
          encodeStringIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is MessageHeader.Source.Endpoint.Reference -> {
          encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 6, value.name?.value)
      encodeElementIfNotNull(descriptor, 7, value.name)
      encodeStringIfNotNull(descriptor, 8, value.software?.value)
      encodeElementIfNotNull(descriptor, 9, value.software)
      encodeStringIfNotNull(descriptor, 10, value.version?.value)
      encodeElementIfNotNull(descriptor, 11, value.version)
      encodeSerializableIfNotNull(descriptor, 12, ContactPointSerializer, value.contact)
    }
  }
}

internal object MessageHeaderResponseSerializer : KSerializer<MessageHeader.Response> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Response") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("details", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MessageHeader.Response>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageHeader.Response =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: Identifier? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var details: Reference? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 -> code = decodeStringElement(descriptor, i)
          5 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> details = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Response: " + i)
        }
      }
      MessageHeader.Response(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier =
          identifier
            ?: throw SerializationException(
              "Missing required property 'identifier' on MessageHeader.Response"
            ),
        code =
          Enumeration.of(
            if (code != null) MessageHeader.ResponseType.fromCode(code) else null,
            _code,
          )
            ?: throw SerializationException(
              "Missing required property 'code' on MessageHeader.Response"
            ),
        details = details,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Response) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(descriptor, 3, IdentifierSerializer, value.identifier)
      encodeStringIfNotNull(descriptor, 4, value.code.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.code)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.details)
    }
  }
}

internal object MessageHeaderSerializer : FhirResourceSerializer<MessageHeader> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MessageHeader")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("eventCoding", CodingSerializer.descriptor)
    b.optionalElement("eventCanonical", KotlinString.serializer().descriptor)
    b.optionalElement("_eventCanonical", ElementSerializer.descriptor)
    b.optionalElement("destination", MessageHeaderDestinationSerializer.listSerializer.descriptor)
    b.optionalElement("sender", ReferenceSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
    b.optionalElement("source", MessageHeaderSourceSerializer.descriptor)
    b.optionalElement("responsible", ReferenceSerializer.descriptor)
    b.optionalElement("reason", CodeableConceptSerializer.descriptor)
    b.optionalElement("response", MessageHeaderResponseSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("definition", KotlinString.serializer().descriptor)
    b.optionalElement("_definition", ElementSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        11 -> eventCanonical = decoder.decodeStringElement(descriptor, i)
        12 ->
          _eventCanonical =
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
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          source =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageHeaderSourceSerializer,
              null,
            )
        17 ->
          responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          response =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MessageHeaderResponseSerializer,
              null,
            )
        20 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        21 -> definition = decoder.decodeStringElement(descriptor, i)
        22 ->
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
        MessageHeader.Event.from(eventCoding, Canonical.of(eventCanonical, _eventCanonical))
          ?: throw SerializationException("Missing required property 'event' on MessageHeader"),
      destination = destination ?: listOf(),
      sender = sender,
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MessageHeader,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
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
      is MessageHeader.Event.Canonical -> {
        encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, choice.value)
      }
    }
    if (value.destination.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        MessageHeaderDestinationSerializer.listSerializer,
        value.destination,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.sender,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      MessageHeaderSourceSerializer,
      value.source,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.responsible,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.reason,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      MessageHeaderResponseSerializer,
      value.response,
    )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.focus,
      )
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.definition?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.definition)
  }
}
