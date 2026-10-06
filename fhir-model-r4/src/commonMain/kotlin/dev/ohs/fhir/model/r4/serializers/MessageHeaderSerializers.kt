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
import dev.ohs.fhir.model.r4.FhirResourceSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("target", ReferenceSerializer.descriptor)
      optionalElement("endpoint", KotlinString.serializer().descriptor)
      optionalElement("_endpoint", ElementSerializer.descriptor)
      optionalElement("receiver", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MessageHeader.Destination>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageHeader.Destination =
    decoder.decodeStructure(descriptor) {
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> target = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> endpoint = decodeStringElement(descriptor, i)
          7 -> _endpoint = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            `receiver` = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Destination: " + i)
        }
      }
      MessageHeader.Destination(
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
      encodeStringIfNotNull(descriptor, 3, value.name?.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.target)
      encodeStringIfNotNull(descriptor, 6, value.endpoint.value)
      encodeElementIfNotNull(descriptor, 7, value.endpoint)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.`receiver`)
    }
  }
}

internal object MessageHeaderSourceSerializer : KSerializer<MessageHeader.Source> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Source") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("software", KotlinString.serializer().descriptor)
      optionalElement("_software", ElementSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
      optionalElement("contact", ContactPointSerializer.descriptor)
      optionalElement("endpoint", KotlinString.serializer().descriptor)
      optionalElement("_endpoint", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MessageHeader.Source>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MessageHeader.Source =
    decoder.decodeStructure(descriptor) {
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> software = decodeStringElement(descriptor, i)
          6 -> _software = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> version = decodeStringElement(descriptor, i)
          8 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            contact = decodeNullableSerializableElement(descriptor, i, ContactPointSerializer, null)
          10 -> endpoint = decodeStringElement(descriptor, i)
          11 ->
            _endpoint = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Source: " + i)
        }
      }
      MessageHeader.Source(
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
      encodeStringIfNotNull(descriptor, 3, value.name?.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.software?.value)
      encodeElementIfNotNull(descriptor, 6, value.software)
      encodeStringIfNotNull(descriptor, 7, value.version?.value)
      encodeElementIfNotNull(descriptor, 8, value.version)
      encodeSerializableIfNotNull(descriptor, 9, ContactPointSerializer, value.contact)
      encodeStringIfNotNull(descriptor, 10, value.endpoint.value)
      encodeElementIfNotNull(descriptor, 11, value.endpoint)
    }
  }
}

internal object MessageHeaderResponseSerializer : KSerializer<MessageHeader.Response> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Response") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", KotlinString.serializer().descriptor)
      optionalElement("_identifier", ElementSerializer.descriptor)
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
      var identifier: KotlinString? = null
      var _identifier: Element? = null
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
          3 -> identifier = decodeStringElement(descriptor, i)
          4 ->
            _identifier = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> code = decodeStringElement(descriptor, i)
          6 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> details = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Response: " + i)
        }
      }
      MessageHeader.Response(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier =
          Id.of(identifier, _identifier)
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
      encodeStringIfNotNull(descriptor, 3, value.identifier.value)
      encodeElementIfNotNull(descriptor, 4, value.identifier)
      encodeStringIfNotNull(descriptor, 5, value.code.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.code)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.details)
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
    b.optionalElement("eventUri", KotlinString.serializer().descriptor)
    b.optionalElement("_eventUri", ElementSerializer.descriptor)
    b.optionalElement("destination", MessageHeaderDestinationSerializer.listSerializer.descriptor)
    b.optionalElement("sender", ReferenceSerializer.descriptor)
    b.optionalElement("enterer", ReferenceSerializer.descriptor)
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
      is MessageHeader.Event.Uri -> {
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
      value.enterer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      MessageHeaderSourceSerializer,
      value.source,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.responsible,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.reason,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      MessageHeaderResponseSerializer,
      value.response,
    )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.focus,
      )
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.definition?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.definition)
  }
}
