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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.TestScript
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.FHIRDefinedType
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object TestScriptOriginSerializer : KSerializer<TestScript.Origin> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Origin") {
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
      element("index", Int.serializer().descriptor, isOptional = true)
      element("_index", Element.serializer().descriptor, isOptional = true)
      element("profile", Coding.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Origin =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Origin) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Origin {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var index: Int? = null
    var _index: Element? = null
    var profile: Coding? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> index = decoder.decodeIntElement(descriptor, i)
        4 ->
          _index = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.indexSer, null)
        5 ->
          profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Origin: " + i)
      }
    }
    return TestScript.Origin(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      index =
        Integer.of(index, _index)
          ?: throw SerializationException("Missing required property 'index' on TestScript.Origin"),
      profile =
        profile
          ?: throw SerializationException(
            "Missing required property 'profile' on TestScript.Origin"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Origin) {
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
    ((value.index.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.index.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.indexSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.profileSer, value.profile)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val indexSer: KSerializer<Element> = Element.serializer()

    public val profileSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object TestScriptDestinationSerializer : KSerializer<TestScript.Destination> {
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
      element("index", Int.serializer().descriptor, isOptional = true)
      element("_index", Element.serializer().descriptor, isOptional = true)
      element("profile", Coding.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Destination =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Destination) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Destination {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var index: Int? = null
    var _index: Element? = null
    var profile: Coding? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> index = decoder.decodeIntElement(descriptor, i)
        4 ->
          _index = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.indexSer, null)
        5 ->
          profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Destination: " + i)
      }
    }
    return TestScript.Destination(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      index =
        Integer.of(index, _index)
          ?: throw SerializationException(
            "Missing required property 'index' on TestScript.Destination"
          ),
      profile =
        profile
          ?: throw SerializationException(
            "Missing required property 'profile' on TestScript.Destination"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Destination) {
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
    ((value.index.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.index.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.indexSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.profileSer, value.profile)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val indexSer: KSerializer<Element> = Element.serializer()

    public val profileSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object TestScriptMetadataSerializer : KSerializer<TestScript.Metadata> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Metadata") {
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
      element(
        "link",
        listSerialDescriptor(lazyDescriptor { TestScript.Metadata.Link.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "capability",
        listSerialDescriptor(
          lazyDescriptor { TestScript.Metadata.Capability.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestScript.Metadata =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Metadata {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var link: List<TestScript.Metadata.Link>? = null
    var capability: List<TestScript.Metadata.Capability>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> link = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkSer, null)
        4 ->
          capability =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.capabilitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Metadata: " + i)
      }
    }
    return TestScript.Metadata(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      link = link ?: listOf(),
      capability = capability ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Metadata) {
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
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.linkSer, value.link)
    if (value.capability.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.capabilitySer, value.capability)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkSerInner: KSerializer<TestScript.Metadata.Link> =
      TestScript.Metadata.Link.serializer()

    public val linkSer: KSerializer<List<TestScript.Metadata.Link>> =
      ListSerializer(Hoisted.linkSerInner)

    public val capabilitySerInner: KSerializer<TestScript.Metadata.Capability> =
      TestScript.Metadata.Capability.serializer()

    public val capabilitySer: KSerializer<List<TestScript.Metadata.Capability>> =
      ListSerializer(Hoisted.capabilitySerInner)
  }
}

internal object TestScriptMetadataLinkSerializer : KSerializer<TestScript.Metadata.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Metadata.Link =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Link) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Metadata.Link {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> url = decoder.decodeStringElement(descriptor, i)
        4 -> _url = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.urlSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.urlSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + i)
      }
    }
    return TestScript.Metadata.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException(
            "Missing required property 'url' on TestScript.Metadata.Link"
          ),
      description = R4String.of(description, _description),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Metadata.Link) {
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
    ((value.url.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.urlSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.urlSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val urlSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TestScriptMetadataCapabilitySerializer :
  KSerializer<TestScript.Metadata.Capability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Capability") {
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
      element("required", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_required", Element.serializer().descriptor, isOptional = true)
      element("validated", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_validated", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("origin", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element("_origin", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("destination", Int.serializer().descriptor, isOptional = true)
      element("_destination", Element.serializer().descriptor, isOptional = true)
      element("link", listSerialDescriptor(KotlinString.serializer().descriptor), isOptional = true)
      element("_link", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("capabilities", KotlinString.serializer().descriptor, isOptional = true)
      element("_capabilities", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Metadata.Capability =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Capability) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Metadata.Capability {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var required: KotlinBoolean? = null
    var _required: Element? = null
    var validated: KotlinBoolean? = null
    var _validated: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var origin: List<Int?>? = null
    var _origin: List<Element?>? = null
    var destination: Int? = null
    var _destination: Element? = null
    var link: List<KotlinString?>? = null
    var _link: List<Element?>? = null
    var capabilities: KotlinString? = null
    var _capabilities: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> required = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _required =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
        5 -> validated = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _validated =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
        7 -> description = decoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
        9 ->
          origin = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.originSer, null)
        10 ->
          _origin =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.originSer2, null)
        11 -> destination = decoder.decodeIntElement(descriptor, i)
        12 ->
          _destination =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
        13 -> link = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkSer, null)
        14 ->
          _link = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.originSer2, null)
        15 -> capabilities = decoder.decodeStringElement(descriptor, i)
        16 ->
          _capabilities =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Capability: " + i)
      }
    }
    return TestScript.Metadata.Capability(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      required =
        R4Boolean.of(required, _required)
          ?: throw SerializationException(
            "Missing required property 'required' on TestScript.Metadata.Capability"
          ),
      validated =
        R4Boolean.of(validated, _validated)
          ?: throw SerializationException(
            "Missing required property 'validated' on TestScript.Metadata.Capability"
          ),
      description = R4String.of(description, _description),
      origin =
        (kotlin.collections.List(maxOf(origin?.size ?: 0, _origin?.size ?: 0)) { index ->
          Integer.of(origin?.getOrNull(index)?.let { it }, _origin?.getOrNull(index))!!
        }),
      destination = Integer.of(destination, _destination),
      link =
        (kotlin.collections.List(maxOf(link?.size ?: 0, _link?.size ?: 0)) { index ->
          Uri.of(link?.getOrNull(index)?.let { it }, _link?.getOrNull(index))!!
        }),
      capabilities =
        Canonical.of(capabilities, _capabilities)
          ?: throw SerializationException(
            "Missing required property 'capabilities' on TestScript.Metadata.Capability"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TestScript.Metadata.Capability,
  ) {
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
    ((value.required.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.required.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.requiredSer, it)
    }
    ((value.validated.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.validated.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.requiredSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.requiredSer, it)
    }
    (value.origin.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.originSer, it)
    }
    (value.origin.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.originSer2, it)
    }
    ((value.destination?.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
    (value.destination?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.requiredSer, it)
    }
    (value.link.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.linkSer, it)
    }
    (value.link.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.originSer2, it)
    }
    ((value.capabilities.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.capabilities.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.requiredSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val requiredSer: KSerializer<Element> = Element.serializer()

    public val originSerInner: KSerializer<Int> = Int.serializer()

    public val originSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.originSerInner).nullable)

    public val originSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.requiredSer).nullable)

    public val linkSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val linkSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.linkSerInner).nullable)
  }
}

internal object TestScriptFixtureSerializer : KSerializer<TestScript.Fixture> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Fixture") {
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
      element("autocreate", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_autocreate", Element.serializer().descriptor, isOptional = true)
      element("autodelete", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_autodelete", Element.serializer().descriptor, isOptional = true)
      element("resource", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Fixture =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Fixture) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Fixture {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var autocreate: KotlinBoolean? = null
    var _autocreate: Element? = null
    var autodelete: KotlinBoolean? = null
    var _autodelete: Element? = null
    var resource: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> autocreate = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _autocreate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.autocreateSer, null)
        5 -> autodelete = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _autodelete =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.autocreateSer, null)
        7 ->
          resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Fixture: " + i)
      }
    }
    return TestScript.Fixture(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      autocreate =
        R4Boolean.of(autocreate, _autocreate)
          ?: throw SerializationException(
            "Missing required property 'autocreate' on TestScript.Fixture"
          ),
      autodelete =
        R4Boolean.of(autodelete, _autodelete)
          ?: throw SerializationException(
            "Missing required property 'autodelete' on TestScript.Fixture"
          ),
      resource = resource,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Fixture) {
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
    ((value.autocreate.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.autocreate.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.autocreateSer, it)
    }
    ((value.autodelete.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.autodelete.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.autocreateSer, it)
    }
    (value.resource)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.resourceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val autocreateSer: KSerializer<Element> = Element.serializer()

    public val resourceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object TestScriptVariableSerializer : KSerializer<TestScript.Variable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Variable") {
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
      element("defaultValue", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValue", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
      element("headerField", KotlinString.serializer().descriptor, isOptional = true)
      element("_headerField", Element.serializer().descriptor, isOptional = true)
      element("hint", KotlinString.serializer().descriptor, isOptional = true)
      element("_hint", Element.serializer().descriptor, isOptional = true)
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element("sourceId", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceId", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Variable =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Variable) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Variable {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var defaultValue: KotlinString? = null
    var _defaultValue: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var headerField: KotlinString? = null
    var _headerField: Element? = null
    var hint: KotlinString? = null
    var _hint: Element? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> defaultValue = decoder.decodeStringElement(descriptor, i)
        6 ->
          _defaultValue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 -> description = decoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        9 -> expression = decoder.decodeStringElement(descriptor, i)
        10 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        11 -> headerField = decoder.decodeStringElement(descriptor, i)
        12 ->
          _headerField =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        13 -> hint = decoder.decodeStringElement(descriptor, i)
        14 ->
          _hint = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        15 -> path = decoder.decodeStringElement(descriptor, i)
        16 ->
          _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        17 -> sourceId = decoder.decodeStringElement(descriptor, i)
        18 ->
          _sourceId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variable: " + i)
      }
    }
    return TestScript.Variable(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on TestScript.Variable"
          ),
      defaultValue = R4String.of(defaultValue, _defaultValue),
      description = R4String.of(description, _description),
      expression = R4String.of(expression, _expression),
      headerField = R4String.of(headerField, _headerField),
      hint = R4String.of(hint, _hint),
      path = R4String.of(path, _path),
      sourceId = Id.of(sourceId, _sourceId),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Variable) {
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.defaultValue?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.defaultValue?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.nameSer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.nameSer, it)
    }
    ((value.headerField?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.headerField?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.nameSer, it)
    }
    ((value.hint?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.hint?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.nameSer, it)
    }
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.nameSer, it)
    }
    ((value.sourceId?.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
    (value.sourceId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TestScriptSetupSerializer : KSerializer<TestScript.Setup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Setup") {
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
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { TestScript.Setup.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestScript.Setup =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Setup {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestScript.Setup.Action>? = null
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
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Setup: " + i)
      }
    }
    return TestScript.Setup(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Setup) {
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
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actionSerInner: KSerializer<TestScript.Setup.Action> =
      TestScript.Setup.Action.serializer()

    public val actionSer: KSerializer<List<TestScript.Setup.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object TestScriptSetupActionSerializer : KSerializer<TestScript.Setup.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
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
      element(
        "operation",
        lazyDescriptor { TestScript.Setup.Action.Operation.serializer().descriptor },
        isOptional = true,
      )
      element(
        "assert",
        lazyDescriptor { TestScript.Setup.Action.Assert.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Setup.Action {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
    var assert: TestScript.Setup.Action.Assert? = null
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
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        4 ->
          assert = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.assertSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    return TestScript.Setup.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation = operation,
      assert = assert,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Setup.Action) {
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
    (value.operation)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.operationSer, it)
    }
    (value.assert)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.assertSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val operationSer: KSerializer<TestScript.Setup.Action.Operation> =
      TestScript.Setup.Action.Operation.serializer()

    public val assertSer: KSerializer<TestScript.Setup.Action.Assert> =
      TestScript.Setup.Action.Assert.serializer()
  }
}

internal object TestScriptSetupActionOperationSerializer :
  KSerializer<TestScript.Setup.Action.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
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
      element("type", Coding.serializer().descriptor, isOptional = true)
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", Element.serializer().descriptor, isOptional = true)
      element("label", KotlinString.serializer().descriptor, isOptional = true)
      element("_label", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("accept", KotlinString.serializer().descriptor, isOptional = true)
      element("_accept", Element.serializer().descriptor, isOptional = true)
      element("contentType", KotlinString.serializer().descriptor, isOptional = true)
      element("_contentType", Element.serializer().descriptor, isOptional = true)
      element("destination", Int.serializer().descriptor, isOptional = true)
      element("_destination", Element.serializer().descriptor, isOptional = true)
      element("encodeRequestUrl", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_encodeRequestUrl", Element.serializer().descriptor, isOptional = true)
      element("method", KotlinString.serializer().descriptor, isOptional = true)
      element("_method", Element.serializer().descriptor, isOptional = true)
      element("origin", Int.serializer().descriptor, isOptional = true)
      element("_origin", Element.serializer().descriptor, isOptional = true)
      element("params", KotlinString.serializer().descriptor, isOptional = true)
      element("_params", Element.serializer().descriptor, isOptional = true)
      element(
        "requestHeader",
        listSerialDescriptor(
          lazyDescriptor { TestScript.Setup.Action.Operation.RequestHeader.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("requestId", KotlinString.serializer().descriptor, isOptional = true)
      element("_requestId", Element.serializer().descriptor, isOptional = true)
      element("responseId", KotlinString.serializer().descriptor, isOptional = true)
      element("_responseId", Element.serializer().descriptor, isOptional = true)
      element("sourceId", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceId", Element.serializer().descriptor, isOptional = true)
      element("targetId", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetId", Element.serializer().descriptor, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Operation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Operation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Setup.Action.Operation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: Coding? = null
    var resource: KotlinString? = null
    var _resource: Element? = null
    var label: KotlinString? = null
    var _label: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var accept: KotlinString? = null
    var _accept: Element? = null
    var contentType: KotlinString? = null
    var _contentType: Element? = null
    var destination: Int? = null
    var _destination: Element? = null
    var encodeRequestUrl: KotlinBoolean? = null
    var _encodeRequestUrl: Element? = null
    var method: KotlinString? = null
    var _method: Element? = null
    var origin: Int? = null
    var _origin: Element? = null
    var params: KotlinString? = null
    var _params: Element? = null
    var requestHeader: List<TestScript.Setup.Action.Operation.RequestHeader>? = null
    var requestId: KotlinString? = null
    var _requestId: Element? = null
    var responseId: KotlinString? = null
    var _responseId: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
    var targetId: KotlinString? = null
    var _targetId: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> resource = decoder.decodeStringElement(descriptor, i)
        5 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        6 -> label = decoder.decodeStringElement(descriptor, i)
        7 ->
          _label =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        8 -> description = decoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        10 -> accept = decoder.decodeStringElement(descriptor, i)
        11 ->
          _accept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        12 -> contentType = decoder.decodeStringElement(descriptor, i)
        13 ->
          _contentType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        14 -> destination = decoder.decodeIntElement(descriptor, i)
        15 ->
          _destination =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        16 -> encodeRequestUrl = decoder.decodeBooleanElement(descriptor, i)
        17 ->
          _encodeRequestUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        18 -> method = decoder.decodeStringElement(descriptor, i)
        19 ->
          _method =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        20 -> origin = decoder.decodeIntElement(descriptor, i)
        21 ->
          _origin =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        22 -> params = decoder.decodeStringElement(descriptor, i)
        23 ->
          _params =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        24 ->
          requestHeader =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestHeaderSer, null)
        25 -> requestId = decoder.decodeStringElement(descriptor, i)
        26 ->
          _requestId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        27 -> responseId = decoder.decodeStringElement(descriptor, i)
        28 ->
          _responseId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        29 -> sourceId = decoder.decodeStringElement(descriptor, i)
        30 ->
          _sourceId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        31 -> targetId = decoder.decodeStringElement(descriptor, i)
        32 ->
          _targetId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        33 -> url = decoder.decodeStringElement(descriptor, i)
        34 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + i)
      }
    }
    return TestScript.Setup.Action.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      resource = Enumeration.of(resource?.let { FHIRDefinedType.fromCode(it) }, _resource),
      label = R4String.of(label, _label),
      description = R4String.of(description, _description),
      accept = Code.of(accept, _accept),
      contentType = Code.of(contentType, _contentType),
      destination = Integer.of(destination, _destination),
      encodeRequestUrl =
        R4Boolean.of(encodeRequestUrl, _encodeRequestUrl)
          ?: throw SerializationException(
            "Missing required property 'encodeRequestUrl' on TestScript.Setup.Action.Operation"
          ),
      method =
        Enumeration.of(
          method?.let { TestScript.TestScriptRequestMethodCode.fromCode(it) },
          _method,
        ),
      origin = Integer.of(origin, _origin),
      params = R4String.of(params, _params),
      requestHeader = requestHeader ?: listOf(),
      requestId = Id.of(requestId, _requestId),
      responseId = Id.of(responseId, _responseId),
      sourceId = Id.of(sourceId, _sourceId),
      targetId = Id.of(targetId, _targetId),
      url = R4String.of(url, _url),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TestScript.Setup.Action.Operation,
  ) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    ((value.resource?.value?.code))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.resourceSer, it)
    }
    ((value.label?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.resourceSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.resourceSer, it)
    }
    ((value.accept?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.accept?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.resourceSer, it)
    }
    ((value.contentType?.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.contentType?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.resourceSer, it)
    }
    ((value.destination?.value))?.let { encoder.encodeIntElement(descriptor, 14, it) }
    (value.destination?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.resourceSer, it)
    }
    ((value.encodeRequestUrl.value))?.let { encoder.encodeBooleanElement(descriptor, 16, it) }
    (value.encodeRequestUrl.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.resourceSer, it)
    }
    ((value.method?.value?.code))?.let { encoder.encodeStringElement(descriptor, 18, it) }
    (value.method?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.resourceSer, it)
    }
    ((value.origin?.value))?.let { encoder.encodeIntElement(descriptor, 20, it) }
    (value.origin?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.resourceSer, it)
    }
    ((value.params?.value))?.let { encoder.encodeStringElement(descriptor, 22, it) }
    (value.params?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.resourceSer, it)
    }
    if (value.requestHeader.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24,
        Hoisted.requestHeaderSer,
        value.requestHeader,
      )
    ((value.requestId?.value))?.let { encoder.encodeStringElement(descriptor, 25, it) }
    (value.requestId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.resourceSer, it)
    }
    ((value.responseId?.value))?.let { encoder.encodeStringElement(descriptor, 27, it) }
    (value.responseId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.resourceSer, it)
    }
    ((value.sourceId?.value))?.let { encoder.encodeStringElement(descriptor, 29, it) }
    (value.sourceId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 30, Hoisted.resourceSer, it)
    }
    ((value.targetId?.value))?.let { encoder.encodeStringElement(descriptor, 31, it) }
    (value.targetId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 32, Hoisted.resourceSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 33, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 34, Hoisted.resourceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Coding> = Coding.serializer()

    public val resourceSer: KSerializer<Element> = Element.serializer()

    public val requestHeaderSerInner: KSerializer<TestScript.Setup.Action.Operation.RequestHeader> =
      TestScript.Setup.Action.Operation.RequestHeader.serializer()

    public val requestHeaderSer:
      KSerializer<List<TestScript.Setup.Action.Operation.RequestHeader>> =
      ListSerializer(Hoisted.requestHeaderSerInner)
  }
}

internal object TestScriptSetupActionOperationRequestHeaderSerializer :
  KSerializer<TestScript.Setup.Action.Operation.RequestHeader> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RequestHeader") {
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
      element("field", KotlinString.serializer().descriptor, isOptional = true)
      element("_field", Element.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Operation.RequestHeader =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: TestScript.Setup.Action.Operation.RequestHeader,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): TestScript.Setup.Action.Operation.RequestHeader {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `field`: KotlinString? = null
    var _field: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> `field` = decoder.decodeStringElement(descriptor, i)
        4 ->
          _field = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fieldSer, null)
        5 -> `value` = decoder.decodeStringElement(descriptor, i)
        6 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fieldSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RequestHeader: " + i)
      }
    }
    return TestScript.Setup.Action.Operation.RequestHeader(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `field` =
        R4String.of(`field`, _field)
          ?: throw SerializationException(
            "Missing required property 'field' on TestScript.Setup.Action.Operation.RequestHeader"
          ),
      `value` =
        R4String.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on TestScript.Setup.Action.Operation.RequestHeader"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TestScript.Setup.Action.Operation.RequestHeader,
  ) {
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
    ((value.`field`.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.`field`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.fieldSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.fieldSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val fieldSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TestScriptSetupActionAssertSerializer :
  KSerializer<TestScript.Setup.Action.Assert> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Assert") {
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
      element("label", KotlinString.serializer().descriptor, isOptional = true)
      element("_label", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("direction", KotlinString.serializer().descriptor, isOptional = true)
      element("_direction", Element.serializer().descriptor, isOptional = true)
      element("compareToSourceId", KotlinString.serializer().descriptor, isOptional = true)
      element("_compareToSourceId", Element.serializer().descriptor, isOptional = true)
      element("compareToSourceExpression", KotlinString.serializer().descriptor, isOptional = true)
      element("_compareToSourceExpression", Element.serializer().descriptor, isOptional = true)
      element("compareToSourcePath", KotlinString.serializer().descriptor, isOptional = true)
      element("_compareToSourcePath", Element.serializer().descriptor, isOptional = true)
      element("contentType", KotlinString.serializer().descriptor, isOptional = true)
      element("_contentType", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
      element("headerField", KotlinString.serializer().descriptor, isOptional = true)
      element("_headerField", Element.serializer().descriptor, isOptional = true)
      element("minimumId", KotlinString.serializer().descriptor, isOptional = true)
      element("_minimumId", Element.serializer().descriptor, isOptional = true)
      element("navigationLinks", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_navigationLinks", Element.serializer().descriptor, isOptional = true)
      element("operator", KotlinString.serializer().descriptor, isOptional = true)
      element("_operator", Element.serializer().descriptor, isOptional = true)
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element("requestMethod", KotlinString.serializer().descriptor, isOptional = true)
      element("_requestMethod", Element.serializer().descriptor, isOptional = true)
      element("requestURL", KotlinString.serializer().descriptor, isOptional = true)
      element("_requestURL", Element.serializer().descriptor, isOptional = true)
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", Element.serializer().descriptor, isOptional = true)
      element("response", KotlinString.serializer().descriptor, isOptional = true)
      element("_response", Element.serializer().descriptor, isOptional = true)
      element("responseCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_responseCode", Element.serializer().descriptor, isOptional = true)
      element("sourceId", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceId", Element.serializer().descriptor, isOptional = true)
      element("validateProfileId", KotlinString.serializer().descriptor, isOptional = true)
      element("_validateProfileId", Element.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
      element("warningOnly", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_warningOnly", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Assert =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Assert) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Setup.Action.Assert {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var label: KotlinString? = null
    var _label: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var direction: KotlinString? = null
    var _direction: Element? = null
    var compareToSourceId: KotlinString? = null
    var _compareToSourceId: Element? = null
    var compareToSourceExpression: KotlinString? = null
    var _compareToSourceExpression: Element? = null
    var compareToSourcePath: KotlinString? = null
    var _compareToSourcePath: Element? = null
    var contentType: KotlinString? = null
    var _contentType: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var headerField: KotlinString? = null
    var _headerField: Element? = null
    var minimumId: KotlinString? = null
    var _minimumId: Element? = null
    var navigationLinks: KotlinBoolean? = null
    var _navigationLinks: Element? = null
    var `operator`: KotlinString? = null
    var _operator: Element? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var requestMethod: KotlinString? = null
    var _requestMethod: Element? = null
    var requestURL: KotlinString? = null
    var _requestURL: Element? = null
    var resource: KotlinString? = null
    var _resource: Element? = null
    var response: KotlinString? = null
    var _response: Element? = null
    var responseCode: KotlinString? = null
    var _responseCode: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
    var validateProfileId: KotlinString? = null
    var _validateProfileId: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var warningOnly: KotlinBoolean? = null
    var _warningOnly: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> label = decoder.decodeStringElement(descriptor, i)
        4 ->
          _label = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        7 -> direction = decoder.decodeStringElement(descriptor, i)
        8 ->
          _direction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        9 -> compareToSourceId = decoder.decodeStringElement(descriptor, i)
        10 ->
          _compareToSourceId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        11 -> compareToSourceExpression = decoder.decodeStringElement(descriptor, i)
        12 ->
          _compareToSourceExpression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        13 -> compareToSourcePath = decoder.decodeStringElement(descriptor, i)
        14 ->
          _compareToSourcePath =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        15 -> contentType = decoder.decodeStringElement(descriptor, i)
        16 ->
          _contentType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        17 -> expression = decoder.decodeStringElement(descriptor, i)
        18 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        19 -> headerField = decoder.decodeStringElement(descriptor, i)
        20 ->
          _headerField =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        21 -> minimumId = decoder.decodeStringElement(descriptor, i)
        22 ->
          _minimumId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        23 -> navigationLinks = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _navigationLinks =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        25 -> `operator` = decoder.decodeStringElement(descriptor, i)
        26 ->
          _operator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        27 -> path = decoder.decodeStringElement(descriptor, i)
        28 ->
          _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        29 -> requestMethod = decoder.decodeStringElement(descriptor, i)
        30 ->
          _requestMethod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        31 -> requestURL = decoder.decodeStringElement(descriptor, i)
        32 ->
          _requestURL =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        33 -> resource = decoder.decodeStringElement(descriptor, i)
        34 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        35 -> response = decoder.decodeStringElement(descriptor, i)
        36 ->
          _response =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        37 -> responseCode = decoder.decodeStringElement(descriptor, i)
        38 ->
          _responseCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        39 -> sourceId = decoder.decodeStringElement(descriptor, i)
        40 ->
          _sourceId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        41 -> validateProfileId = decoder.decodeStringElement(descriptor, i)
        42 ->
          _validateProfileId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        43 -> `value` = decoder.decodeStringElement(descriptor, i)
        44 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        45 -> warningOnly = decoder.decodeBooleanElement(descriptor, i)
        46 ->
          _warningOnly =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Assert: " + i)
      }
    }
    return TestScript.Setup.Action.Assert(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      label = R4String.of(label, _label),
      description = R4String.of(description, _description),
      direction =
        Enumeration.of(
          direction?.let { TestScript.AssertionDirectionType.fromCode(it) },
          _direction,
        ),
      compareToSourceId = R4String.of(compareToSourceId, _compareToSourceId),
      compareToSourceExpression =
        R4String.of(compareToSourceExpression, _compareToSourceExpression),
      compareToSourcePath = R4String.of(compareToSourcePath, _compareToSourcePath),
      contentType = Code.of(contentType, _contentType),
      expression = R4String.of(expression, _expression),
      headerField = R4String.of(headerField, _headerField),
      minimumId = R4String.of(minimumId, _minimumId),
      navigationLinks = R4Boolean.of(navigationLinks, _navigationLinks),
      `operator` =
        Enumeration.of(
          `operator`?.let { TestScript.AssertionOperatorType.fromCode(it) },
          _operator,
        ),
      path = R4String.of(path, _path),
      requestMethod =
        Enumeration.of(
          requestMethod?.let { TestScript.TestScriptRequestMethodCode.fromCode(it) },
          _requestMethod,
        ),
      requestURL = R4String.of(requestURL, _requestURL),
      resource = Enumeration.of(resource?.let { FHIRDefinedType.fromCode(it) }, _resource),
      response =
        Enumeration.of(response?.let { TestScript.AssertionResponseTypes.fromCode(it) }, _response),
      responseCode = R4String.of(responseCode, _responseCode),
      sourceId = Id.of(sourceId, _sourceId),
      validateProfileId = Id.of(validateProfileId, _validateProfileId),
      `value` = R4String.of(`value`, _value),
      warningOnly =
        R4Boolean.of(warningOnly, _warningOnly)
          ?: throw SerializationException(
            "Missing required property 'warningOnly' on TestScript.Setup.Action.Assert"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TestScript.Setup.Action.Assert,
  ) {
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
    ((value.label?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.labelSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.labelSer, it)
    }
    ((value.direction?.value?.code))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.direction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.labelSer, it)
    }
    ((value.compareToSourceId?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.compareToSourceId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.labelSer, it)
    }
    ((value.compareToSourceExpression?.value))?.let {
      encoder.encodeStringElement(descriptor, 11, it)
    }
    (value.compareToSourceExpression?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.labelSer, it)
    }
    ((value.compareToSourcePath?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.compareToSourcePath?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.labelSer, it)
    }
    ((value.contentType?.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.contentType?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.labelSer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.labelSer, it)
    }
    ((value.headerField?.value))?.let { encoder.encodeStringElement(descriptor, 19, it) }
    (value.headerField?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.labelSer, it)
    }
    ((value.minimumId?.value))?.let { encoder.encodeStringElement(descriptor, 21, it) }
    (value.minimumId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.labelSer, it)
    }
    ((value.navigationLinks?.value))?.let { encoder.encodeBooleanElement(descriptor, 23, it) }
    (value.navigationLinks?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.labelSer, it)
    }
    ((value.`operator`?.value?.code))?.let { encoder.encodeStringElement(descriptor, 25, it) }
    (value.`operator`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.labelSer, it)
    }
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 27, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.labelSer, it)
    }
    ((value.requestMethod?.value?.code))?.let { encoder.encodeStringElement(descriptor, 29, it) }
    (value.requestMethod?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 30, Hoisted.labelSer, it)
    }
    ((value.requestURL?.value))?.let { encoder.encodeStringElement(descriptor, 31, it) }
    (value.requestURL?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 32, Hoisted.labelSer, it)
    }
    ((value.resource?.value?.code))?.let { encoder.encodeStringElement(descriptor, 33, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 34, Hoisted.labelSer, it)
    }
    ((value.response?.value?.code))?.let { encoder.encodeStringElement(descriptor, 35, it) }
    (value.response?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 36, Hoisted.labelSer, it)
    }
    ((value.responseCode?.value))?.let { encoder.encodeStringElement(descriptor, 37, it) }
    (value.responseCode?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 38, Hoisted.labelSer, it)
    }
    ((value.sourceId?.value))?.let { encoder.encodeStringElement(descriptor, 39, it) }
    (value.sourceId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 40, Hoisted.labelSer, it)
    }
    ((value.validateProfileId?.value))?.let { encoder.encodeStringElement(descriptor, 41, it) }
    (value.validateProfileId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 42, Hoisted.labelSer, it)
    }
    ((value.`value`?.value))?.let { encoder.encodeStringElement(descriptor, 43, it) }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 44, Hoisted.labelSer, it)
    }
    ((value.warningOnly.value))?.let { encoder.encodeBooleanElement(descriptor, 45, it) }
    (value.warningOnly.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 46, Hoisted.labelSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val labelSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TestScriptTestSerializer : KSerializer<TestScript.Test> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Test") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { TestScript.Test.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestScript.Test =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Test) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Test {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var action: List<TestScript.Test.Action>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Test: " + i)
      }
    }
    return TestScript.Test(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name),
      description = R4String.of(description, _description),
      action = action ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Test) {
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
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val actionSerInner: KSerializer<TestScript.Test.Action> =
      TestScript.Test.Action.serializer()

    public val actionSer: KSerializer<List<TestScript.Test.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object TestScriptTestActionSerializer : KSerializer<TestScript.Test.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
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
      element(
        "operation",
        lazyDescriptor { TestScript.Setup.Action.Operation.serializer().descriptor },
        isOptional = true,
      )
      element(
        "assert",
        lazyDescriptor { TestScript.Setup.Action.Assert.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestScript.Test.Action =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Test.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Test.Action {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
    var assert: TestScript.Setup.Action.Assert? = null
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
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        4 ->
          assert = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.assertSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    return TestScript.Test.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation = operation,
      assert = assert,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Test.Action) {
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
    (value.operation)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.operationSer, it)
    }
    (value.assert)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.assertSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val operationSer: KSerializer<TestScript.Setup.Action.Operation> =
      TestScript.Setup.Action.Operation.serializer()

    public val assertSer: KSerializer<TestScript.Setup.Action.Assert> =
      TestScript.Setup.Action.Assert.serializer()
  }
}

internal object TestScriptTeardownSerializer : KSerializer<TestScript.Teardown> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Teardown") {
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
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { TestScript.Teardown.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestScript.Teardown =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Teardown {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestScript.Teardown.Action>? = null
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
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Teardown: " + i)
      }
    }
    return TestScript.Teardown(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Teardown) {
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
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actionSerInner: KSerializer<TestScript.Teardown.Action> =
      TestScript.Teardown.Action.serializer()

    public val actionSer: KSerializer<List<TestScript.Teardown.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object TestScriptTeardownActionSerializer : KSerializer<TestScript.Teardown.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
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
      element(
        "operation",
        lazyDescriptor { TestScript.Setup.Action.Operation.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestScript.Teardown.Action =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestScript.Teardown.Action {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
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
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    return TestScript.Teardown.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation =
        operation
          ?: throw SerializationException(
            "Missing required property 'operation' on TestScript.Teardown.Action"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestScript.Teardown.Action) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.operationSer, value.operation)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val operationSer: KSerializer<TestScript.Setup.Action.Operation> =
      TestScript.Setup.Action.Operation.serializer()
  }
}

internal object TestScriptSerializer : KSerializer<TestScript> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestScript") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element(
      "origin",
      listSerialDescriptor(lazyDescriptor { TestScript.Origin.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "destination",
      listSerialDescriptor(lazyDescriptor { TestScript.Destination.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "metadata",
      lazyDescriptor { TestScript.Metadata.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "fixture",
      listSerialDescriptor(lazyDescriptor { TestScript.Fixture.serializer().descriptor }),
      isOptional = true,
    )
    b.element("profile", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "variable",
      listSerialDescriptor(lazyDescriptor { TestScript.Variable.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "setup",
      lazyDescriptor { TestScript.Setup.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "test",
      listSerialDescriptor(lazyDescriptor { TestScript.Test.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "teardown",
      lazyDescriptor { TestScript.Teardown.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): TestScript =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: TestScript) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "TestScript")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): TestScript {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: Identifier? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var origin: List<TestScript.Origin>? = null
    var destination: List<TestScript.Destination>? = null
    var metadata: TestScript.Metadata? = null
    var fixture: List<TestScript.Fixture>? = null
    var profile: List<Reference>? = null
    var variable: List<TestScript.Variable>? = null
    var setup: TestScript.Setup? = null
    var test: List<TestScript.Test>? = null
    var teardown: TestScript.Teardown? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> publisher = decoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        28 -> description = decoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        32 -> purpose = decoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 -> copyright = decoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 ->
          origin = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.originSer, null)
        37 ->
          destination =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.destinationSer, null)
        38 ->
          metadata =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metadataSer, null)
        39 ->
          fixture =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fixtureSer, null)
        40 ->
          profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        41 ->
          variable =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.variableSer, null)
        42 ->
          setup = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.setupSer, null)
        43 -> test = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.testSer, null)
        44 ->
          teardown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.teardownSer, null)
        else -> throw SerializationException("Unexpected index decoding TestScript: " + i)
      }
    }
    return TestScript(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException("Missing required property 'url' on TestScript"),
      identifier = identifier,
      version = R4String.of(version, _version),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on TestScript"),
      title = R4String.of(title, _title),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on TestScript"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      origin = origin ?: listOf(),
      destination = destination ?: listOf(),
      metadata = metadata,
      fixture = fixture ?: listOf(),
      profile = profile ?: listOf(),
      variable = variable ?: listOf(),
      setup = setup,
      test = test ?: listOf(),
      teardown = teardown,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TestScript,
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
    ((value.url.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        it,
      )
    }
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.origin.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.originSer,
        value.origin,
      )
    if (value.destination.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.destinationSer,
        value.destination,
      )
    (value.metadata)?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, Hoisted.metadataSer, it)
    }
    if (value.fixture.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.fixtureSer,
        value.fixture,
      )
    if (value.profile.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.profileSer,
        value.profile,
      )
    if (value.variable.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.variableSer,
        value.variable,
      )
    (value.setup)?.let {
      encoder.encodeSerializableElement(descriptor, 42 + descriptorOffset, Hoisted.setupSer, it)
    }
    if (value.test.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.testSer,
        value.test,
      )
    (value.teardown)?.let {
      encoder.encodeSerializableElement(descriptor, 44 + descriptorOffset, Hoisted.teardownSer, it)
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

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val originSerInner: KSerializer<TestScript.Origin> = TestScript.Origin.serializer()

    public val originSer: KSerializer<List<TestScript.Origin>> =
      ListSerializer(Hoisted.originSerInner)

    public val destinationSerInner: KSerializer<TestScript.Destination> =
      TestScript.Destination.serializer()

    public val destinationSer: KSerializer<List<TestScript.Destination>> =
      ListSerializer(Hoisted.destinationSerInner)

    public val metadataSer: KSerializer<TestScript.Metadata> = TestScript.Metadata.serializer()

    public val fixtureSerInner: KSerializer<TestScript.Fixture> = TestScript.Fixture.serializer()

    public val fixtureSer: KSerializer<List<TestScript.Fixture>> =
      ListSerializer(Hoisted.fixtureSerInner)

    public val profileSerInner: KSerializer<Reference> = Reference.serializer()

    public val profileSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.profileSerInner)

    public val variableSerInner: KSerializer<TestScript.Variable> = TestScript.Variable.serializer()

    public val variableSer: KSerializer<List<TestScript.Variable>> =
      ListSerializer(Hoisted.variableSerInner)

    public val setupSer: KSerializer<TestScript.Setup> = TestScript.Setup.serializer()

    public val testSerInner: KSerializer<TestScript.Test> = TestScript.Test.serializer()

    public val testSer: KSerializer<List<TestScript.Test>> = ListSerializer(Hoisted.testSerInner)

    public val teardownSer: KSerializer<TestScript.Teardown> = TestScript.Teardown.serializer()
  }
}

internal object TestScriptPolymorphicSerializer : KSerializer<TestScript> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestScript") { TestScriptSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript) {
    encoder.encodeStructure(descriptor) {
      TestScriptSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): TestScript =
    decoder.decodeStructure(descriptor) {
      TestScriptSerializer.deserializeInternal(this, descriptor, 0)
    }
}
