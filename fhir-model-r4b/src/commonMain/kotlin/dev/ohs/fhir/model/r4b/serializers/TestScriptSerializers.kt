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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.TestScript
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.AssertionDirectionType
import dev.ohs.fhir.model.r4b.terminologies.AssertionOperatorType
import dev.ohs.fhir.model.r4b.terminologies.AssertionResponseTypes
import dev.ohs.fhir.model.r4b.terminologies.FHIRDefinedType
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.TestScriptRequestMethodCode
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
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object TestScriptOriginSerializer : KSerializer<TestScript.Origin> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Origin") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("index", Int.serializer().descriptor)
      optionalElement("_index", ElementSerializer.descriptor)
      optionalElement("profile", CodingSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Origin>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Origin {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var index: Int? = null
    var _index: Element? = null
    var profile: Coding? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> index = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _index =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Origin: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: TestScript.Origin) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.index.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.index)
    compositeEncoder.encodeSerializableElement(descriptor, 5, CodingSerializer, value.profile)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptDestinationSerializer : KSerializer<TestScript.Destination> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Destination") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("index", Int.serializer().descriptor)
      optionalElement("_index", ElementSerializer.descriptor)
      optionalElement("profile", CodingSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Destination>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Destination {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var index: Int? = null
    var _index: Element? = null
    var profile: Coding? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> index = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _index =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Destination: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: TestScript.Destination) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.index.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.index)
    compositeEncoder.encodeSerializableElement(descriptor, 5, CodingSerializer, value.profile)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptMetadataSerializer : KSerializer<TestScript.Metadata> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Metadata") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("link", TestScriptMetadataLinkSerializer.listSerializer.descriptor)
      optionalElement(
        "capability",
        TestScriptMetadataCapabilitySerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<TestScript.Metadata>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Metadata {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var link: List<TestScript.Metadata.Link>? = null
    var capability: List<TestScript.Metadata.Capability>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          link =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptMetadataLinkSerializer.listSerializer,
              null,
            )
        4 ->
          capability =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptMetadataCapabilitySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Metadata: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Metadata(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      link = link ?: listOf(),
      capability = capability ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.link.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        TestScriptMetadataLinkSerializer.listSerializer,
        value.link,
      )
    if (value.capability.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        TestScriptMetadataCapabilitySerializer.listSerializer,
        value.capability,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptMetadataLinkSerializer : KSerializer<TestScript.Metadata.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Metadata.Link>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Metadata.Link {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Metadata.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException(
            "Missing required property 'url' on TestScript.Metadata.Link"
          ),
      description = R4bString.of(description, _description),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Link) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptMetadataCapabilitySerializer :
  KSerializer<TestScript.Metadata.Capability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Capability") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("required", KotlinBoolean.serializer().descriptor)
      optionalElement("_required", ElementSerializer.descriptor)
      optionalElement("validated", KotlinBoolean.serializer().descriptor)
      optionalElement("_validated", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("origin", intNullableListSerializer.descriptor)
      optionalElement("_origin", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("destination", Int.serializer().descriptor)
      optionalElement("_destination", ElementSerializer.descriptor)
      optionalElement("link", stringNullableListSerializer.descriptor)
      optionalElement("_link", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("capabilities", KotlinString.serializer().descriptor)
      optionalElement("_capabilities", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Metadata.Capability>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Metadata.Capability {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> required = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _required =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> validated = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _validated =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          origin =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        10 ->
          _origin =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 -> destination = compositeDecoder.decodeIntElement(descriptor, i)
        12 ->
          _destination =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          link =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _link =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 -> capabilities = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _capabilities =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Capability: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Metadata.Capability(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      required =
        R4bBoolean.of(required, _required)
          ?: throw SerializationException(
            "Missing required property 'required' on TestScript.Metadata.Capability"
          ),
      validated =
        R4bBoolean.of(validated, _validated)
          ?: throw SerializationException(
            "Missing required property 'validated' on TestScript.Metadata.Capability"
          ),
      description = R4bString.of(description, _description),
      origin =
        (kotlin.collections.List(maxOf(origin?.size ?: 0, _origin?.size ?: 0)) { index ->
          Integer.of(origin?.getOrNull(index), _origin?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'origin' on TestScript.Metadata.Capability has neither a value nor an id/extension"
            )
        }),
      destination = Integer.of(destination, _destination),
      link =
        (kotlin.collections.List(maxOf(link?.size ?: 0, _link?.size ?: 0)) { index ->
          Uri.of(link?.getOrNull(index), _link?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'link' on TestScript.Metadata.Capability has neither a value nor an id/extension"
            )
        }),
      capabilities =
        Canonical.of(capabilities, _capabilities)
          ?: throw SerializationException(
            "Missing required property 'capabilities' on TestScript.Metadata.Capability"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Capability) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.required.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.required)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.validated.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.validated)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.description)
    if (value.origin.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        intNullableListSerializer,
        value.origin.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.origin)
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 11, value.destination?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.destination)
    if (value.link.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13,
        stringNullableListSerializer,
        value.link.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 14, value.link)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.capabilities.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.capabilities)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptFixtureSerializer : KSerializer<TestScript.Fixture> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Fixture") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("autocreate", KotlinBoolean.serializer().descriptor)
      optionalElement("_autocreate", ElementSerializer.descriptor)
      optionalElement("autodelete", KotlinBoolean.serializer().descriptor)
      optionalElement("_autodelete", ElementSerializer.descriptor)
      optionalElement("resource", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Fixture>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Fixture {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var autocreate: KotlinBoolean? = null
    var _autocreate: Element? = null
    var autodelete: KotlinBoolean? = null
    var _autodelete: Element? = null
    var resource: Reference? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> autocreate = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _autocreate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> autodelete = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _autodelete =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Fixture: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Fixture(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      autocreate =
        R4bBoolean.of(autocreate, _autocreate)
          ?: throw SerializationException(
            "Missing required property 'autocreate' on TestScript.Fixture"
          ),
      autodelete =
        R4bBoolean.of(autodelete, _autodelete)
          ?: throw SerializationException(
            "Missing required property 'autodelete' on TestScript.Fixture"
          ),
      resource = resource,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Fixture) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.autocreate.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.autocreate)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.autodelete.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.autodelete)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.resource)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptVariableSerializer : KSerializer<TestScript.Variable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Variable") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("defaultValue", KotlinString.serializer().descriptor)
      optionalElement("_defaultValue", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
      optionalElement("headerField", KotlinString.serializer().descriptor)
      optionalElement("_headerField", ElementSerializer.descriptor)
      optionalElement("hint", KotlinString.serializer().descriptor)
      optionalElement("_hint", ElementSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("sourceId", KotlinString.serializer().descriptor)
      optionalElement("_sourceId", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Variable>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Variable {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> defaultValue = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _defaultValue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> headerField = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _headerField =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> hint = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _hint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> sourceId = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _sourceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variable: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Variable(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on TestScript.Variable"
          ),
      defaultValue = R4bString.of(defaultValue, _defaultValue),
      description = R4bString.of(description, _description),
      expression = R4bString.of(expression, _expression),
      headerField = R4bString.of(headerField, _headerField),
      hint = R4bString.of(hint, _hint),
      path = R4bString.of(path, _path),
      sourceId = Id.of(sourceId, _sourceId),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Variable) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.defaultValue?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.defaultValue)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.expression?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.expression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.headerField?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.headerField)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.hint?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.hint)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.path?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.path)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17, value.sourceId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.sourceId)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptSetupSerializer : KSerializer<TestScript.Setup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Setup") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("action", TestScriptSetupActionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Setup>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Setup {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestScript.Setup.Action>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Setup: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.action.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        TestScriptSetupActionSerializer.listSerializer,
        value.action,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptSetupActionSerializer : KSerializer<TestScript.Setup.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("operation", TestScriptSetupActionOperationSerializer.descriptor)
      optionalElement("assert", TestScriptSetupActionAssertSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Setup.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
    var assert: TestScript.Setup.Action.Assert? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupActionOperationSerializer,
              null,
            )
        4 ->
          assert =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupActionAssertSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation = operation,
      assert = assert,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      TestScriptSetupActionOperationSerializer,
      value.operation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      TestScriptSetupActionAssertSerializer,
      value.assert,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptSetupActionOperationSerializer :
  KSerializer<TestScript.Setup.Action.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodingSerializer.descriptor)
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", ElementSerializer.descriptor)
      optionalElement("label", KotlinString.serializer().descriptor)
      optionalElement("_label", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("accept", KotlinString.serializer().descriptor)
      optionalElement("_accept", ElementSerializer.descriptor)
      optionalElement("contentType", KotlinString.serializer().descriptor)
      optionalElement("_contentType", ElementSerializer.descriptor)
      optionalElement("destination", Int.serializer().descriptor)
      optionalElement("_destination", ElementSerializer.descriptor)
      optionalElement("encodeRequestUrl", KotlinBoolean.serializer().descriptor)
      optionalElement("_encodeRequestUrl", ElementSerializer.descriptor)
      optionalElement("method", KotlinString.serializer().descriptor)
      optionalElement("_method", ElementSerializer.descriptor)
      optionalElement("origin", Int.serializer().descriptor)
      optionalElement("_origin", ElementSerializer.descriptor)
      optionalElement("params", KotlinString.serializer().descriptor)
      optionalElement("_params", ElementSerializer.descriptor)
      optionalElement(
        "requestHeader",
        TestScriptSetupActionOperationRequestHeaderSerializer.listSerializer.descriptor,
      )
      optionalElement("requestId", KotlinString.serializer().descriptor)
      optionalElement("_requestId", ElementSerializer.descriptor)
      optionalElement("responseId", KotlinString.serializer().descriptor)
      optionalElement("_responseId", ElementSerializer.descriptor)
      optionalElement("sourceId", KotlinString.serializer().descriptor)
      optionalElement("_sourceId", ElementSerializer.descriptor)
      optionalElement("targetId", KotlinString.serializer().descriptor)
      optionalElement("_targetId", ElementSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Setup.Action.Operation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Operation {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        4 -> resource = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> label = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _label =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> accept = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _accept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> contentType = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _contentType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> destination = compositeDecoder.decodeIntElement(descriptor, i)
        15 ->
          _destination =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> encodeRequestUrl = compositeDecoder.decodeBooleanElement(descriptor, i)
        17 ->
          _encodeRequestUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> method = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> origin = compositeDecoder.decodeIntElement(descriptor, i)
        21 ->
          _origin =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> params = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _params =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          requestHeader =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupActionOperationRequestHeaderSerializer.listSerializer,
              null,
            )
        25 -> requestId = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _requestId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> responseId = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _responseId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> sourceId = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _sourceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 -> targetId = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _targetId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      resource =
        Enumeration.of(
          if (resource != null) FHIRDefinedType.fromCode(resource) else null,
          _resource,
        ),
      label = R4bString.of(label, _label),
      description = R4bString.of(description, _description),
      accept = Code.of(accept, _accept),
      contentType = Code.of(contentType, _contentType),
      destination = Integer.of(destination, _destination),
      encodeRequestUrl =
        R4bBoolean.of(encodeRequestUrl, _encodeRequestUrl)
          ?: throw SerializationException(
            "Missing required property 'encodeRequestUrl' on TestScript.Setup.Action.Operation"
          ),
      method =
        Enumeration.of(
          if (method != null) TestScriptRequestMethodCode.fromCode(method) else null,
          _method,
        ),
      origin = Integer.of(origin, _origin),
      params = R4bString.of(params, _params),
      requestHeader = requestHeader ?: listOf(),
      requestId = Id.of(requestId, _requestId),
      responseId = Id.of(responseId, _responseId),
      sourceId = Id.of(sourceId, _sourceId),
      targetId = Id.of(targetId, _targetId),
      url = R4bString.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Operation) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, CodingSerializer, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.resource?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.resource)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.label?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.label)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.accept?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.accept)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.contentType?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.contentType)
    compositeEncoder.encodeIntIfNotNull(descriptor, 14, value.destination?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.destination)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 16, value.encodeRequestUrl.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.encodeRequestUrl)
    compositeEncoder.encodeStringIfNotNull(descriptor, 18, value.method?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19, value.method)
    compositeEncoder.encodeIntIfNotNull(descriptor, 20, value.origin?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21, value.origin)
    compositeEncoder.encodeStringIfNotNull(descriptor, 22, value.params?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 23, value.params)
    if (value.requestHeader.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24,
        TestScriptSetupActionOperationRequestHeaderSerializer.listSerializer,
        value.requestHeader,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 25, value.requestId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 26, value.requestId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 27, value.responseId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 28, value.responseId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 29, value.sourceId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 30, value.sourceId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 31, value.targetId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 32, value.targetId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 33, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 34, value.url)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptSetupActionOperationRequestHeaderSerializer :
  KSerializer<TestScript.Setup.Action.Operation.RequestHeader> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RequestHeader") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("field", KotlinString.serializer().descriptor)
      optionalElement("_field", ElementSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Setup.Action.Operation.RequestHeader>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Operation.RequestHeader {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `field`: KotlinString? = null
    var _field: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> `field` = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _field =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RequestHeader: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action.Operation.RequestHeader(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `field` =
        R4bString.of(`field`, _field)
          ?: throw SerializationException(
            "Missing required property 'field' on TestScript.Setup.Action.Operation.RequestHeader"
          ),
      `value` =
        R4bString.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on TestScript.Setup.Action.Operation.RequestHeader"
          ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: TestScript.Setup.Action.Operation.RequestHeader,
  ) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.`field`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.`field`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptSetupActionAssertSerializer :
  KSerializer<TestScript.Setup.Action.Assert> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Assert") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("label", KotlinString.serializer().descriptor)
      optionalElement("_label", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("direction", KotlinString.serializer().descriptor)
      optionalElement("_direction", ElementSerializer.descriptor)
      optionalElement("compareToSourceId", KotlinString.serializer().descriptor)
      optionalElement("_compareToSourceId", ElementSerializer.descriptor)
      optionalElement("compareToSourceExpression", KotlinString.serializer().descriptor)
      optionalElement("_compareToSourceExpression", ElementSerializer.descriptor)
      optionalElement("compareToSourcePath", KotlinString.serializer().descriptor)
      optionalElement("_compareToSourcePath", ElementSerializer.descriptor)
      optionalElement("contentType", KotlinString.serializer().descriptor)
      optionalElement("_contentType", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
      optionalElement("headerField", KotlinString.serializer().descriptor)
      optionalElement("_headerField", ElementSerializer.descriptor)
      optionalElement("minimumId", KotlinString.serializer().descriptor)
      optionalElement("_minimumId", ElementSerializer.descriptor)
      optionalElement("navigationLinks", KotlinBoolean.serializer().descriptor)
      optionalElement("_navigationLinks", ElementSerializer.descriptor)
      optionalElement("operator", KotlinString.serializer().descriptor)
      optionalElement("_operator", ElementSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("requestMethod", KotlinString.serializer().descriptor)
      optionalElement("_requestMethod", ElementSerializer.descriptor)
      optionalElement("requestURL", KotlinString.serializer().descriptor)
      optionalElement("_requestURL", ElementSerializer.descriptor)
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", ElementSerializer.descriptor)
      optionalElement("response", KotlinString.serializer().descriptor)
      optionalElement("_response", ElementSerializer.descriptor)
      optionalElement("responseCode", KotlinString.serializer().descriptor)
      optionalElement("_responseCode", ElementSerializer.descriptor)
      optionalElement("sourceId", KotlinString.serializer().descriptor)
      optionalElement("_sourceId", ElementSerializer.descriptor)
      optionalElement("validateProfileId", KotlinString.serializer().descriptor)
      optionalElement("_validateProfileId", ElementSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("warningOnly", KotlinBoolean.serializer().descriptor)
      optionalElement("_warningOnly", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Setup.Action.Assert>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Assert {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> label = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _label =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> direction = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _direction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> compareToSourceId = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _compareToSourceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> compareToSourceExpression = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _compareToSourceExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> compareToSourcePath = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _compareToSourcePath =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> contentType = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _contentType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> headerField = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _headerField =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> minimumId = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _minimumId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> navigationLinks = compositeDecoder.decodeBooleanElement(descriptor, i)
        24 ->
          _navigationLinks =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> `operator` = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _operator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> requestMethod = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _requestMethod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 -> requestURL = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _requestURL =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> resource = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 -> response = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _response =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> responseCode = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _responseCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> sourceId = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _sourceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> validateProfileId = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _validateProfileId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 -> warningOnly = compositeDecoder.decodeBooleanElement(descriptor, i)
        46 ->
          _warningOnly =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Assert: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action.Assert(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      label = R4bString.of(label, _label),
      description = R4bString.of(description, _description),
      direction =
        Enumeration.of(
          if (direction != null) AssertionDirectionType.fromCode(direction) else null,
          _direction,
        ),
      compareToSourceId = R4bString.of(compareToSourceId, _compareToSourceId),
      compareToSourceExpression =
        R4bString.of(compareToSourceExpression, _compareToSourceExpression),
      compareToSourcePath = R4bString.of(compareToSourcePath, _compareToSourcePath),
      contentType = Code.of(contentType, _contentType),
      expression = R4bString.of(expression, _expression),
      headerField = R4bString.of(headerField, _headerField),
      minimumId = R4bString.of(minimumId, _minimumId),
      navigationLinks = R4bBoolean.of(navigationLinks, _navigationLinks),
      `operator` =
        Enumeration.of(
          if (`operator` != null) AssertionOperatorType.fromCode(`operator`) else null,
          _operator,
        ),
      path = R4bString.of(path, _path),
      requestMethod =
        Enumeration.of(
          if (requestMethod != null) TestScriptRequestMethodCode.fromCode(requestMethod) else null,
          _requestMethod,
        ),
      requestURL = R4bString.of(requestURL, _requestURL),
      resource =
        Enumeration.of(
          if (resource != null) FHIRDefinedType.fromCode(resource) else null,
          _resource,
        ),
      response =
        Enumeration.of(
          if (response != null) AssertionResponseTypes.fromCode(response) else null,
          _response,
        ),
      responseCode = R4bString.of(responseCode, _responseCode),
      sourceId = Id.of(sourceId, _sourceId),
      validateProfileId = Id.of(validateProfileId, _validateProfileId),
      `value` = R4bString.of(`value`, _value),
      warningOnly =
        R4bBoolean.of(warningOnly, _warningOnly)
          ?: throw SerializationException(
            "Missing required property 'warningOnly' on TestScript.Setup.Action.Assert"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Assert) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.label?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.label)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.direction?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.direction)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.compareToSourceId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.compareToSourceId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.compareToSourceExpression?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.compareToSourceExpression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.compareToSourcePath?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.compareToSourcePath)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.contentType?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.contentType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17, value.expression?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.expression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 19, value.headerField?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20, value.headerField)
    compositeEncoder.encodeStringIfNotNull(descriptor, 21, value.minimumId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.minimumId)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 23, value.navigationLinks?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 24, value.navigationLinks)
    compositeEncoder.encodeStringIfNotNull(descriptor, 25, value.`operator`?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 26, value.`operator`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 27, value.path?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 28, value.path)
    compositeEncoder.encodeStringIfNotNull(descriptor, 29, value.requestMethod?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 30, value.requestMethod)
    compositeEncoder.encodeStringIfNotNull(descriptor, 31, value.requestURL?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 32, value.requestURL)
    compositeEncoder.encodeStringIfNotNull(descriptor, 33, value.resource?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 34, value.resource)
    compositeEncoder.encodeStringIfNotNull(descriptor, 35, value.response?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 36, value.response)
    compositeEncoder.encodeStringIfNotNull(descriptor, 37, value.responseCode?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 38, value.responseCode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 39, value.sourceId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 40, value.sourceId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 41, value.validateProfileId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 42, value.validateProfileId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 43, value.`value`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 44, value.`value`)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 45, value.warningOnly.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 46, value.warningOnly)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptTestSerializer : KSerializer<TestScript.Test> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Test") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("action", TestScriptTestActionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Test>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Test {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var action: List<TestScript.Test.Action>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptTestActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Test: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Test(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name),
      description = R4bString.of(description, _description),
      action = action ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Test) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    if (value.action.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        TestScriptTestActionSerializer.listSerializer,
        value.action,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptTestActionSerializer : KSerializer<TestScript.Test.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("operation", TestScriptSetupActionOperationSerializer.descriptor)
      optionalElement("assert", TestScriptSetupActionAssertSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Test.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Test.Action {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
    var assert: TestScript.Setup.Action.Assert? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupActionOperationSerializer,
              null,
            )
        4 ->
          assert =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupActionAssertSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Test.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation = operation,
      assert = assert,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Test.Action) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      TestScriptSetupActionOperationSerializer,
      value.operation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      TestScriptSetupActionAssertSerializer,
      value.assert,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptTeardownSerializer : KSerializer<TestScript.Teardown> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Teardown") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("action", TestScriptTeardownActionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Teardown>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Teardown {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestScript.Teardown.Action>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptTeardownActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Teardown: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Teardown(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.action.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        TestScriptTeardownActionSerializer.listSerializer,
        value.action,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptTeardownActionSerializer : KSerializer<TestScript.Teardown.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("operation", TestScriptSetupActionOperationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestScript.Teardown.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestScript.Teardown.Action {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestScript.Setup.Action.Operation? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupActionOperationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown.Action) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      TestScriptSetupActionOperationSerializer,
      value.operation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptSerializer : FhirResourceSerializer<TestScript> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("TestScript")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("origin", TestScriptOriginSerializer.listSerializer.descriptor)
    b.optionalElement("destination", TestScriptDestinationSerializer.listSerializer.descriptor)
    b.optionalElement("metadata", TestScriptMetadataSerializer.descriptor)
    b.optionalElement("fixture", TestScriptFixtureSerializer.listSerializer.descriptor)
    b.optionalElement("profile", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("variable", TestScriptVariableSerializer.listSerializer.descriptor)
    b.optionalElement("setup", TestScriptSetupSerializer.descriptor)
    b.optionalElement("test", TestScriptTestSerializer.listSerializer.descriptor)
    b.optionalElement("teardown", TestScriptTeardownSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          origin =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptOriginSerializer.listSerializer,
              null,
            )
        37 ->
          destination =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptDestinationSerializer.listSerializer,
              null,
            )
        38 ->
          metadata =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptMetadataSerializer,
              null,
            )
        39 ->
          fixture =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptFixtureSerializer.listSerializer,
              null,
            )
        40 ->
          profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        41 ->
          variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptVariableSerializer.listSerializer,
              null,
            )
        42 ->
          setup =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupSerializer,
              null,
            )
        43 ->
          test =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptTestSerializer.listSerializer,
              null,
            )
        44 ->
          teardown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptTeardownSerializer,
              null,
            )
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
      version = R4bString.of(version, _version),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on TestScript"),
      title = R4bString.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on TestScript"),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4bString.of(publisher, _publisher),
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

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TestScript,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    if (value.origin.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        TestScriptOriginSerializer.listSerializer,
        value.origin,
      )
    if (value.destination.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        TestScriptDestinationSerializer.listSerializer,
        value.destination,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      TestScriptMetadataSerializer,
      value.metadata,
    )
    if (value.fixture.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        TestScriptFixtureSerializer.listSerializer,
        value.fixture,
      )
    if (value.profile.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.profile,
      )
    if (value.variable.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        TestScriptVariableSerializer.listSerializer,
        value.variable,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      TestScriptSetupSerializer,
      value.setup,
    )
    if (value.test.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        TestScriptTestSerializer.listSerializer,
        value.test,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      TestScriptTeardownSerializer,
      value.teardown,
    )
  }
}
