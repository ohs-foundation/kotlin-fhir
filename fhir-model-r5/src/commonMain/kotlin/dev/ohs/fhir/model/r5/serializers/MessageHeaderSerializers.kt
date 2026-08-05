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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MessageHeader
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
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
    var endpointUrl: KotlinString? = null
    var _endpointUrl: Element? = null
    var endpointReference: Reference? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var target: Reference? = null
    var `receiver`: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> endpointUrl = decoder.decodeStringElement(descriptor, i)
        4 ->
          _endpointUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointUrlSer, null)
        5 ->
          endpointReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.endpointReferenceSer,
              null,
            )
        6 -> name = decoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointUrlSer, null)
        8 ->
          target =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.endpointReferenceSer,
              null,
            )
        9 ->
          `receiver` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.endpointReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Destination: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MessageHeader.Destination) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    when (val choice = value.endpoint) {
      null -> {}
      is MessageHeader.Destination.Endpoint.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.endpointUrlSer, it)
        }
      }
      is MessageHeader.Destination.Endpoint.Reference -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.endpointReferenceSer, choice.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.endpointUrlSer, it)
    }
    (value.target)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.endpointReferenceSer, it)
    }
    (value.`receiver`)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.endpointReferenceSer, it)
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> endpointUrl = decoder.decodeStringElement(descriptor, i)
        4 ->
          _endpointUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointUrlSer, null)
        5 ->
          endpointReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.endpointReferenceSer,
              null,
            )
        6 -> name = decoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointUrlSer, null)
        8 -> software = decoder.decodeStringElement(descriptor, i)
        9 ->
          _software =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointUrlSer, null)
        10 -> version = decoder.decodeStringElement(descriptor, i)
        11 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointUrlSer, null)
        12 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Source: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MessageHeader.Source) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    when (val choice = value.endpoint) {
      null -> {}
      is MessageHeader.Source.Endpoint.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.endpointUrlSer, it)
        }
      }
      is MessageHeader.Source.Endpoint.Reference -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.endpointReferenceSer, choice.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.endpointUrlSer, it)
    }
    ((value.software?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.software?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.endpointUrlSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.endpointUrlSer, it)
    }
    (value.contact)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.contactSer, it)
    }
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
    var identifier: Identifier? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var details: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 -> code = decoder.decodeStringElement(descriptor, i)
        5 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 ->
          details =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Response: " + i)
      }
    }
    return MessageHeader.Response(
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
          MessageHeader.ResponseType.fromCode(
            code
              ?: throw SerializationException(
                "Missing required property 'code' on MessageHeader.Response"
              )
          ),
          _code,
        ),
      details = details,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MessageHeader.Response) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, value.identifier)
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, it)
    }
    (value.details)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.detailsSer, it)
    }
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
    b.element("eventCanonical", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_eventCanonical", Element.serializer().descriptor, isOptional = true)
    b.element(
      "destination",
      listSerialDescriptor(lazyDescriptor { MessageHeader.Destination.serializer().descriptor }),
      isOptional = true,
    )
    b.element("sender", Reference.serializer().descriptor, isOptional = true)
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          eventCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventCodingSer, null)
        11 -> eventCanonical = decoder.decodeStringElement(descriptor, i)
        12 ->
          _eventCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          destination =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.destinationSer, null)
        14 ->
          sender = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.senderSer, null)
        15 ->
          author = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.senderSer, null)
        16 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        17 ->
          responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.senderSer, null)
        18 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        19 ->
          response =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.responseSer, null)
        20 ->
          focus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.focusSer, null)
        21 -> definition = decoder.decodeStringElement(descriptor, i)
        22 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MessageHeader,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    when (val choice = value.event) {
      is MessageHeader.Event.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          10 + descriptorOffset,
          Hoisted.eventCodingSer,
          choice.value,
        )
      }
      is MessageHeader.Event.Canonical -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            12 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    if (value.destination.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.destinationSer,
        value.destination,
      )
    (value.sender)?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.senderSer, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.senderSer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      Hoisted.sourceSer,
      value.source,
    )
    (value.responsible)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.senderSer, it)
    }
    (value.reason)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.reasonSer, it)
    }
    (value.response)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.responseSer, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.focusSer,
        value.focus,
      )
    ((value.definition?.value))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
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
