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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Origin) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Origin {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var index: Int? = null
    var _index: Element? = null
    var profile: Coding? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> index = decoder.decodeIntElement(__desc, 3)
        4 -> _index = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.indexSer, null)
        5 ->
          profile = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.profileSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Origin: " + __i)
      }
    }
    return TestScript.Origin(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      index = Integer.of(index, _index)!!,
      profile = profile!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Origin) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.index.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.index.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.indexSer, it)
    }
    (value.profile)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.profileSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Destination) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Destination {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var index: Int? = null
    var _index: Element? = null
    var profile: Coding? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> index = decoder.decodeIntElement(__desc, 3)
        4 -> _index = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.indexSer, null)
        5 ->
          profile = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.profileSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Destination: " + __i)
      }
    }
    return TestScript.Destination(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      index = Integer.of(index, _index)!!,
      profile = profile!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Destination) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.index.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.index.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.indexSer, it)
    }
    (value.profile)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.profileSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Metadata {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var link: List<TestScript.Metadata.Link>? = null
    var capability: List<TestScript.Metadata.Capability>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> link = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.linkSer, null)
        4 ->
          capability =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.capabilitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Metadata: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Metadata) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.linkSer, value.link)
    if (value.capability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.capabilitySer, value.capability)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Link) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Metadata.Link {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> url = decoder.decodeStringElement(__desc, 3)
        4 -> _url = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.urlSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.urlSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + __i)
      }
    }
    return TestScript.Metadata.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url)!!,
      description = R4String.of(description, _description),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Metadata.Link) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.urlSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.urlSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Capability) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Metadata.Capability {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> required = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _required =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.requiredSer, null)
        5 -> validated = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _validated =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.requiredSer, null)
        7 -> description = decoder.decodeStringElement(__desc, 7)
        8 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.requiredSer, null)
        9 -> origin = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.originSer, null)
        10 ->
          _origin = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.originSer2, null)
        11 -> destination = decoder.decodeIntElement(__desc, 11)
        12 ->
          _destination =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.requiredSer, null)
        13 -> link = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.linkSer, null)
        14 ->
          _link = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.originSer2, null)
        15 -> capabilities = decoder.decodeStringElement(__desc, 15)
        16 ->
          _capabilities =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.requiredSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Capability: " + __i)
      }
    }
    return TestScript.Metadata.Capability(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      required = R4Boolean.of(required, _required)!!,
      validated = R4Boolean.of(validated, _validated)!!,
      description = R4String.of(description, _description),
      origin =
        (kotlin.collections.List(maxOf(origin?.size ?: 0, _origin?.size ?: 0)) { __i ->
          Integer.of(origin?.getOrNull(__i)?.let { it }, _origin?.getOrNull(__i))!!
        }),
      destination = Integer.of(destination, _destination),
      link =
        (kotlin.collections.List(maxOf(link?.size ?: 0, _link?.size ?: 0)) { __i ->
          Uri.of(link?.getOrNull(__i)?.let { it }, _link?.getOrNull(__i))!!
        }),
      capabilities = Canonical.of(capabilities, _capabilities)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Metadata.Capability) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.required.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.required.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.requiredSer, it)
    }
    ((value.validated.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.validated.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.requiredSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.requiredSer, it)
    }
    (value.origin.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.originSer, it)
    }
    (value.origin.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.originSer2, it)
    }
    ((value.destination?.value))?.let { encoder.encodeIntElement(__desc, 11, it) }
    (value.destination?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.requiredSer, it)
    }
    (value.link.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.linkSer, it)
    }
    (value.link.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.originSer2, it)
    }
    ((value.capabilities.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.capabilities.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.requiredSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Fixture) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Fixture {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var autocreate: KotlinBoolean? = null
    var _autocreate: Element? = null
    var autodelete: KotlinBoolean? = null
    var _autodelete: Element? = null
    var resource: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> autocreate = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _autocreate =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.autocreateSer, null)
        5 -> autodelete = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _autodelete =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.autocreateSer, null)
        7 ->
          resource = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.resourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Fixture: " + __i)
      }
    }
    return TestScript.Fixture(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      autocreate = R4Boolean.of(autocreate, _autocreate)!!,
      autodelete = R4Boolean.of(autodelete, _autodelete)!!,
      resource = resource,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Fixture) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.autocreate.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.autocreate.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.autocreateSer, it)
    }
    ((value.autodelete.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.autodelete.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.autocreateSer, it)
    }
    (value.resource)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.resourceSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Variable) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Variable {
    val __desc = descriptor
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
        5 -> defaultValue = decoder.decodeStringElement(__desc, 5)
        6 ->
          _defaultValue =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> description = decoder.decodeStringElement(__desc, 7)
        8 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        9 -> expression = decoder.decodeStringElement(__desc, 9)
        10 ->
          _expression = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.nameSer, null)
        11 -> headerField = decoder.decodeStringElement(__desc, 11)
        12 ->
          _headerField =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.nameSer, null)
        13 -> hint = decoder.decodeStringElement(__desc, 13)
        14 -> _hint = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.nameSer, null)
        15 -> path = decoder.decodeStringElement(__desc, 15)
        16 -> _path = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.nameSer, null)
        17 -> sourceId = decoder.decodeStringElement(__desc, 17)
        18 ->
          _sourceId = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variable: " + __i)
      }
    }
    return TestScript.Variable(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name)!!,
      defaultValue = R4String.of(defaultValue, _defaultValue),
      description = R4String.of(description, _description),
      expression = R4String.of(expression, _expression),
      headerField = R4String.of(headerField, _headerField),
      hint = R4String.of(hint, _hint),
      path = R4String.of(path, _path),
      sourceId = Id.of(sourceId, _sourceId),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Variable) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.defaultValue?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.defaultValue?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
    }
    ((value.headerField?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.headerField?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.nameSer, it)
    }
    ((value.hint?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.hint?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.nameSer, it)
    }
    ((value.path?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.nameSer, it)
    }
    ((value.sourceId?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.sourceId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Setup {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestScript.Setup.Action>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> action = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Setup: " + __i)
      }
    }
    return TestScript.Setup(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Setup) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.actionSer, value.action)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Setup.Action {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
    var assert: TestScript.Setup.Action.Assert? = null
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
          operation =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.operationSer, null)
        4 -> assert = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.assertSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Setup.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.operation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.operationSer, it)
    }
    (value.assert)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.assertSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Operation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Setup.Action.Operation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> resource = decoder.decodeStringElement(__desc, 4)
        5 ->
          _resource =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.resourceSer, null)
        6 -> label = decoder.decodeStringElement(__desc, 6)
        7 ->
          _label = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.resourceSer, null)
        8 -> description = decoder.decodeStringElement(__desc, 8)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.resourceSer, null)
        10 -> accept = decoder.decodeStringElement(__desc, 10)
        11 ->
          _accept = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.resourceSer, null)
        12 -> contentType = decoder.decodeStringElement(__desc, 12)
        13 ->
          _contentType =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.resourceSer, null)
        14 -> destination = decoder.decodeIntElement(__desc, 14)
        15 ->
          _destination =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.resourceSer, null)
        16 -> encodeRequestUrl = decoder.decodeBooleanElement(__desc, 16)
        17 ->
          _encodeRequestUrl =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.resourceSer, null)
        18 -> method = decoder.decodeStringElement(__desc, 18)
        19 ->
          _method = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.resourceSer, null)
        20 -> origin = decoder.decodeIntElement(__desc, 20)
        21 ->
          _origin = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.resourceSer, null)
        22 -> params = decoder.decodeStringElement(__desc, 22)
        23 ->
          _params = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.resourceSer, null)
        24 ->
          requestHeader =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.requestHeaderSer, null)
        25 -> requestId = decoder.decodeStringElement(__desc, 25)
        26 ->
          _requestId =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.resourceSer, null)
        27 -> responseId = decoder.decodeStringElement(__desc, 27)
        28 ->
          _responseId =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.resourceSer, null)
        29 -> sourceId = decoder.decodeStringElement(__desc, 29)
        30 ->
          _sourceId =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.resourceSer, null)
        31 -> targetId = decoder.decodeStringElement(__desc, 31)
        32 ->
          _targetId =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.resourceSer, null)
        33 -> url = decoder.decodeStringElement(__desc, 33)
        34 ->
          _url = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.resourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + __i)
      }
    }
    return TestScript.Setup.Action.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      resource = resource?.let { Enumeration.of(FHIRDefinedType.fromCode(it), _resource) },
      label = R4String.of(label, _label),
      description = R4String.of(description, _description),
      accept = Code.of(accept, _accept),
      contentType = Code.of(contentType, _contentType),
      destination = Integer.of(destination, _destination),
      encodeRequestUrl = R4Boolean.of(encodeRequestUrl, _encodeRequestUrl)!!,
      method =
        method?.let {
          Enumeration.of(TestScript.TestScriptRequestMethodCode.fromCode(it), _method)
        },
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Setup.Action.Operation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    ((value.resource?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.resourceSer, it)
    }
    ((value.label?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.resourceSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.resourceSer, it)
    }
    ((value.accept?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.accept?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.resourceSer, it)
    }
    ((value.contentType?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.contentType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.resourceSer, it)
    }
    ((value.destination?.value))?.let { encoder.encodeIntElement(__desc, 14, it) }
    (value.destination?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.resourceSer, it)
    }
    ((value.encodeRequestUrl.value))?.let { encoder.encodeBooleanElement(__desc, 16, it) }
    (value.encodeRequestUrl.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.resourceSer, it)
    }
    ((value.method?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.method?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.resourceSer, it)
    }
    ((value.origin?.value))?.let { encoder.encodeIntElement(__desc, 20, it) }
    (value.origin?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.resourceSer, it)
    }
    ((value.params?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.params?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.resourceSer, it)
    }
    if (value.requestHeader.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.requestHeaderSer, value.requestHeader)
    ((value.requestId?.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.requestId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.resourceSer, it)
    }
    ((value.responseId?.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.responseId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.resourceSer, it)
    }
    ((value.sourceId?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.sourceId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.resourceSer, it)
    }
    ((value.targetId?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.targetId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.resourceSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.resourceSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: TestScript.Setup.Action.Operation.RequestHeader,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): TestScript.Setup.Action.Operation.RequestHeader {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `field`: KotlinString? = null
    var _field: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> `field` = decoder.decodeStringElement(__desc, 3)
        4 -> _field = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.fieldSer, null)
        5 -> `value` = decoder.decodeStringElement(__desc, 5)
        6 -> _value = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.fieldSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RequestHeader: " + __i)
      }
    }
    return TestScript.Setup.Action.Operation.RequestHeader(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `field` = R4String.of(`field`, _field)!!,
      `value` = R4String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: TestScript.Setup.Action.Operation.RequestHeader,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.`field`.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.`field`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.fieldSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.fieldSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Assert) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Setup.Action.Assert {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> label = decoder.decodeStringElement(__desc, 3)
        4 -> _label = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.labelSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.labelSer, null)
        7 -> direction = decoder.decodeStringElement(__desc, 7)
        8 ->
          _direction = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.labelSer, null)
        9 -> compareToSourceId = decoder.decodeStringElement(__desc, 9)
        10 ->
          _compareToSourceId =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.labelSer, null)
        11 -> compareToSourceExpression = decoder.decodeStringElement(__desc, 11)
        12 ->
          _compareToSourceExpression =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.labelSer, null)
        13 -> compareToSourcePath = decoder.decodeStringElement(__desc, 13)
        14 ->
          _compareToSourcePath =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.labelSer, null)
        15 -> contentType = decoder.decodeStringElement(__desc, 15)
        16 ->
          _contentType =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.labelSer, null)
        17 -> expression = decoder.decodeStringElement(__desc, 17)
        18 ->
          _expression =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.labelSer, null)
        19 -> headerField = decoder.decodeStringElement(__desc, 19)
        20 ->
          _headerField =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.labelSer, null)
        21 -> minimumId = decoder.decodeStringElement(__desc, 21)
        22 ->
          _minimumId = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.labelSer, null)
        23 -> navigationLinks = decoder.decodeBooleanElement(__desc, 23)
        24 ->
          _navigationLinks =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.labelSer, null)
        25 -> `operator` = decoder.decodeStringElement(__desc, 25)
        26 ->
          _operator = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.labelSer, null)
        27 -> path = decoder.decodeStringElement(__desc, 27)
        28 -> _path = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.labelSer, null)
        29 -> requestMethod = decoder.decodeStringElement(__desc, 29)
        30 ->
          _requestMethod =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.labelSer, null)
        31 -> requestURL = decoder.decodeStringElement(__desc, 31)
        32 ->
          _requestURL =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.labelSer, null)
        33 -> resource = decoder.decodeStringElement(__desc, 33)
        34 ->
          _resource = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.labelSer, null)
        35 -> response = decoder.decodeStringElement(__desc, 35)
        36 ->
          _response = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.labelSer, null)
        37 -> responseCode = decoder.decodeStringElement(__desc, 37)
        38 ->
          _responseCode =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.labelSer, null)
        39 -> sourceId = decoder.decodeStringElement(__desc, 39)
        40 ->
          _sourceId = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.labelSer, null)
        41 -> validateProfileId = decoder.decodeStringElement(__desc, 41)
        42 ->
          _validateProfileId =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.labelSer, null)
        43 -> `value` = decoder.decodeStringElement(__desc, 43)
        44 -> _value = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.labelSer, null)
        45 -> warningOnly = decoder.decodeBooleanElement(__desc, 45)
        46 ->
          _warningOnly =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.labelSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Assert: " + __i)
      }
    }
    return TestScript.Setup.Action.Assert(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      label = R4String.of(label, _label),
      description = R4String.of(description, _description),
      direction =
        direction?.let {
          Enumeration.of(TestScript.AssertionDirectionType.fromCode(it), _direction)
        },
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
        `operator`?.let {
          Enumeration.of(TestScript.AssertionOperatorType.fromCode(it), _operator)
        },
      path = R4String.of(path, _path),
      requestMethod =
        requestMethod?.let {
          Enumeration.of(TestScript.TestScriptRequestMethodCode.fromCode(it), _requestMethod)
        },
      requestURL = R4String.of(requestURL, _requestURL),
      resource = resource?.let { Enumeration.of(FHIRDefinedType.fromCode(it), _resource) },
      response =
        response?.let { Enumeration.of(TestScript.AssertionResponseTypes.fromCode(it), _response) },
      responseCode = R4String.of(responseCode, _responseCode),
      sourceId = Id.of(sourceId, _sourceId),
      validateProfileId = Id.of(validateProfileId, _validateProfileId),
      `value` = R4String.of(`value`, _value),
      warningOnly = R4Boolean.of(warningOnly, _warningOnly)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Setup.Action.Assert) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.label?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.labelSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.labelSer, it)
    }
    ((value.direction?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.direction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.labelSer, it)
    }
    ((value.compareToSourceId?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.compareToSourceId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.labelSer, it)
    }
    ((value.compareToSourceExpression?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.compareToSourceExpression?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.labelSer, it)
    }
    ((value.compareToSourcePath?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.compareToSourcePath?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.labelSer, it)
    }
    ((value.contentType?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.contentType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.labelSer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.labelSer, it)
    }
    ((value.headerField?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.headerField?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.labelSer, it)
    }
    ((value.minimumId?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.minimumId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.labelSer, it)
    }
    ((value.navigationLinks?.value))?.let { encoder.encodeBooleanElement(__desc, 23, it) }
    (value.navigationLinks?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.labelSer, it)
    }
    ((value.`operator`?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.`operator`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.labelSer, it)
    }
    ((value.path?.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.labelSer, it)
    }
    ((value.requestMethod?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.requestMethod?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.labelSer, it)
    }
    ((value.requestURL?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.requestURL?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.labelSer, it)
    }
    ((value.resource?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.labelSer, it)
    }
    ((value.response?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.response?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.labelSer, it)
    }
    ((value.responseCode?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.responseCode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.labelSer, it)
    }
    ((value.sourceId?.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
    (value.sourceId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.labelSer, it)
    }
    ((value.validateProfileId?.value))?.let { encoder.encodeStringElement(__desc, 41, it) }
    (value.validateProfileId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.labelSer, it)
    }
    ((value.`value`?.value))?.let { encoder.encodeStringElement(__desc, 43, it) }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.labelSer, it)
    }
    ((value.warningOnly.value))?.let { encoder.encodeBooleanElement(__desc, 45, it) }
    (value.warningOnly.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.labelSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Test) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Test {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var action: List<TestScript.Test.Action>? = null
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
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> action = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Test: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Test) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.actionSer, value.action)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Test.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Test.Action {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
    var assert: TestScript.Setup.Action.Assert? = null
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
          operation =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.operationSer, null)
        4 -> assert = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.assertSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Test.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.operation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.operationSer, it)
    }
    (value.assert)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.assertSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Teardown {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestScript.Teardown.Action>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> action = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Teardown: " + __i)
      }
    }
    return TestScript.Teardown(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Teardown) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.actionSer, value.action)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestScript.Teardown.Action {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
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
          operation =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.operationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
      }
    }
    return TestScript.Teardown.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation = operation!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript.Teardown.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.operation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.operationSer, it)
    }
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element(
        "origin",
        listSerialDescriptor(lazyDescriptor { TestScript.Origin.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "destination",
        listSerialDescriptor(lazyDescriptor { TestScript.Destination.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "metadata",
        lazyDescriptor { TestScript.Metadata.serializer().descriptor },
        isOptional = true,
      )
      element(
        "fixture",
        listSerialDescriptor(lazyDescriptor { TestScript.Fixture.serializer().descriptor }),
        isOptional = true,
      )
      element("profile", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "variable",
        listSerialDescriptor(lazyDescriptor { TestScript.Variable.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "setup",
        lazyDescriptor { TestScript.Setup.serializer().descriptor },
        isOptional = true,
      )
      element(
        "test",
        listSerialDescriptor(lazyDescriptor { TestScript.Test.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "teardown",
        lazyDescriptor { TestScript.Teardown.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestScript =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestScript) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): TestScript {
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> name = decoder.decodeStringElement(__desc, 16)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> title = decoder.decodeStringElement(__desc, 18)
        19 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> status = decoder.decodeStringElement(__desc, 20)
        21 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> experimental = decoder.decodeBooleanElement(__desc, 22)
        23 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> date = decoder.decodeStringElement(__desc, 24)
        25 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> publisher = decoder.decodeStringElement(__desc, 26)
        27 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.contactSer, null)
        29 -> description = decoder.decodeStringElement(__desc, 29)
        30 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.useContextSer, null)
        32 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.jurisdictionSer, null)
        33 -> purpose = decoder.decodeStringElement(__desc, 33)
        34 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 -> copyright = decoder.decodeStringElement(__desc, 35)
        36 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 ->
          origin = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.originSer, null)
        38 ->
          destination =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.destinationSer, null)
        39 ->
          metadata =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.metadataSer, null)
        40 ->
          fixture = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.fixtureSer, null)
        41 ->
          profile = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.profileSer, null)
        42 ->
          variable =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.variableSer, null)
        43 -> setup = decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.setupSer, null)
        44 -> test = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.testSer, null)
        45 ->
          teardown =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.teardownSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestScript: " + __i)
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
      url = Uri.of(url, _url)!!,
      identifier = identifier,
      version = R4String.of(version, _version),
      name = R4String.of(name, _name)!!,
      title = R4String.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestScript) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "TestScript")
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
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 22, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    if (value.origin.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.originSer, value.origin)
    if (value.destination.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.destinationSer, value.destination)
    (value.metadata)?.let { encoder.encodeSerializableElement(__desc, 39, Hoisted.metadataSer, it) }
    if (value.fixture.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.fixtureSer, value.fixture)
    if (value.profile.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.profileSer, value.profile)
    if (value.variable.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.variableSer, value.variable)
    (value.setup)?.let { encoder.encodeSerializableElement(__desc, 43, Hoisted.setupSer, it) }
    if (value.test.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.testSer, value.test)
    (value.teardown)?.let { encoder.encodeSerializableElement(__desc, 45, Hoisted.teardownSer, it) }
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
