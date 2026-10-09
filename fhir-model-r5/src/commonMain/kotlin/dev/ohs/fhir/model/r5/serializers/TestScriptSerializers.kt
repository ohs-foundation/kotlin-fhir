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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.TestScript
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.AssertionDirectionType
import dev.ohs.fhir.model.r5.terminologies.AssertionManualCompletionType
import dev.ohs.fhir.model.r5.terminologies.AssertionOperatorType
import dev.ohs.fhir.model.r5.terminologies.AssertionResponseTypes
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.TestScriptRequestMethodCode
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object TestScriptOriginSerializer : FhirSerializer<TestScript.Origin> {
  override val descriptor: SerialDescriptor = buildDescriptor("Origin", this)

  @JvmField internal val listSerializer: KSerializer<List<TestScript.Origin>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("index")
    b.optionalElement("profile", CodingSerializer.descriptor)
    b.strPrim("url")
  }

  override fun deserialize(decoder: Decoder): TestScript.Origin {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var index: Int? = null
    var _index: Element? = null
    var profile: Coding? = null
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
        6 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Origin(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      index = required(Integer.of(index, _index), "TestScript.Origin", "index"),
      profile = required(profile, "TestScript.Origin", "profile"),
      url = Url.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Origin) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.index.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.index)
    compositeEncoder.encodeSerializableElement(descriptor, 5, CodingSerializer, value.profile)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.url)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptDestinationSerializer : FhirSerializer<TestScript.Destination> {
  override val descriptor: SerialDescriptor = buildDescriptor("Destination", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Destination>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("index")
    b.optionalElement("profile", CodingSerializer.descriptor)
    b.strPrim("url")
  }

  override fun deserialize(decoder: Decoder): TestScript.Destination {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var index: Int? = null
    var _index: Element? = null
    var profile: Coding? = null
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
        6 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Destination(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      index = required(Integer.of(index, _index), "TestScript.Destination", "index"),
      profile = required(profile, "TestScript.Destination", "profile"),
      url = Url.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Destination) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.index.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.index)
    compositeEncoder.encodeSerializableElement(descriptor, 5, CodingSerializer, value.profile)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.url)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptMetadataSerializer : FhirSerializer<TestScript.Metadata> {
  override val descriptor: SerialDescriptor = buildDescriptor("Metadata", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Metadata>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("link", TestScriptMetadataLinkSerializer.listSerializer.descriptor)
    b.optionalElement(
      "capability",
      TestScriptMetadataCapabilitySerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): TestScript.Metadata {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Metadata(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      link = listOrEmpty(link),
      capability = listOrEmpty(capability),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      TestScriptMetadataLinkSerializer.listSerializer,
      value.link,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      TestScriptMetadataCapabilitySerializer.listSerializer,
      value.capability,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptMetadataLinkSerializer : FhirSerializer<TestScript.Metadata.Link> {
  override val descriptor: SerialDescriptor = buildDescriptor("Link", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Metadata.Link>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("url")
    b.strPrim("description")
  }

  override fun deserialize(decoder: Decoder): TestScript.Metadata.Link {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Metadata.Link(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = required(Uri.of(url, _url), "TestScript.Metadata.Link", "url"),
      description = R5String.of(description, _description),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Link) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<TestScript.Metadata.Capability> {
  override val descriptor: SerialDescriptor = buildDescriptor("Capability", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Metadata.Capability>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("required")
    b.boolPrim("validated")
    b.strPrim("description")
    b.intPrimList("origin")
    b.intPrim("destination")
    b.strPrimList("link")
    b.strPrim("capabilities")
  }

  override fun deserialize(decoder: Decoder): TestScript.Metadata.Capability {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val origin_ =
      List(maxSize(origin, _origin)) { index ->
        entryRequired(
          Integer.of(at(origin, index), at(_origin, index)),
          "TestScript.Metadata.Capability",
          "origin",
        )
      }
    val link_ =
      List(maxSize(link, _link)) { index ->
        entryRequired(
          Uri.of(at(link, index), at(_link, index)),
          "TestScript.Metadata.Capability",
          "link",
        )
      }
    return TestScript.Metadata.Capability(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      required =
        required(R5Boolean.of(required, _required), "TestScript.Metadata.Capability", "required"),
      validated =
        required(
          R5Boolean.of(validated, _validated),
          "TestScript.Metadata.Capability",
          "validated",
        ),
      description = R5String.of(description, _description),
      origin = origin_,
      destination = Integer.of(destination, _destination),
      link = link_,
      capabilities =
        required(
          Canonical.of(capabilities, _capabilities),
          "TestScript.Metadata.Capability",
          "capabilities",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Capability) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    if (!value.origin.isEmpty()) {
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
    if (!value.link.isEmpty()) {
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

internal object TestScriptScopeSerializer : FhirSerializer<TestScript.Scope> {
  override val descriptor: SerialDescriptor = buildDescriptor("Scope", this)

  @JvmField internal val listSerializer: KSerializer<List<TestScript.Scope>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("artifact")
    b.optionalElement("conformance", CodeableConceptSerializer.descriptor)
    b.optionalElement("phase", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Scope {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var artifact: KotlinString? = null
    var _artifact: Element? = null
    var conformance: CodeableConcept? = null
    var phase: CodeableConcept? = null
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
        3 -> artifact = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _artifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          conformance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          phase =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Scope(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      artifact = required(Canonical.of(artifact, _artifact), "TestScript.Scope", "artifact"),
      conformance = conformance,
      phase = phase,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Scope) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.artifact.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.artifact)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.conformance,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.phase,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptFixtureSerializer : FhirSerializer<TestScript.Fixture> {
  override val descriptor: SerialDescriptor = buildDescriptor("Fixture", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Fixture>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("autocreate")
    b.boolPrim("autodelete")
    b.optionalElement("resource", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Fixture {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Fixture(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      autocreate =
        required(R5Boolean.of(autocreate, _autocreate), "TestScript.Fixture", "autocreate"),
      autodelete =
        required(R5Boolean.of(autodelete, _autodelete), "TestScript.Fixture", "autodelete"),
      resource = resource,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Fixture) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object TestScriptVariableSerializer : FhirSerializer<TestScript.Variable> {
  override val descriptor: SerialDescriptor = buildDescriptor("Variable", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Variable>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("defaultValue")
    b.strPrim("description")
    b.strPrim("expression")
    b.strPrim("headerField")
    b.strPrim("hint")
    b.strPrim("path")
    b.strPrim("sourceId")
  }

  override fun deserialize(decoder: Decoder): TestScript.Variable {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Variable(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R5String.of(name, _name), "TestScript.Variable", "name"),
      defaultValue = R5String.of(defaultValue, _defaultValue),
      description = R5String.of(description, _description),
      expression = R5String.of(expression, _expression),
      headerField = R5String.of(headerField, _headerField),
      hint = R5String.of(hint, _hint),
      path = R5String.of(path, _path),
      sourceId = Id.of(sourceId, _sourceId),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Variable) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object TestScriptSetupSerializer : FhirSerializer<TestScript.Setup> {
  override val descriptor: SerialDescriptor = buildDescriptor("Setup", this)

  @JvmField internal val listSerializer: KSerializer<List<TestScript.Setup>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("action", TestScriptSetupActionSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      TestScriptSetupActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptSetupActionSerializer : FhirSerializer<TestScript.Setup.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Setup.Action>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("operation", TestScriptSetupActionOperationSerializer.descriptor)
    b.optionalElement("assert", TestScriptSetupActionAssertSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      operation = operation,
      assert = assert,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<TestScript.Setup.Action.Operation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Operation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Setup.Action.Operation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodingSerializer.descriptor)
    b.strPrim("resource")
    b.strPrim("label")
    b.strPrim("description")
    b.strPrim("accept")
    b.strPrim("contentType")
    b.intPrim("destination")
    b.boolPrim("encodeRequestUrl")
    b.strPrim("method")
    b.intPrim("origin")
    b.strPrim("params")
    b.optionalElement(
      "requestHeader",
      TestScriptSetupActionOperationRequestHeaderSerializer.listSerializer.descriptor,
    )
    b.strPrim("requestId")
    b.strPrim("responseId")
    b.strPrim("sourceId")
    b.strPrim("targetId")
    b.strPrim("url")
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Operation {
    val descriptor = this.descriptor
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
    var method: TestScriptRequestMethodCode? = null
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
        18 ->
          method =
            TestScriptRequestMethodCode.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action.Operation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      resource = Uri.of(resource, _resource),
      label = R5String.of(label, _label),
      description = R5String.of(description, _description),
      accept = Code.of(accept, _accept),
      contentType = Code.of(contentType, _contentType),
      destination = Integer.of(destination, _destination),
      encodeRequestUrl =
        required(
          R5Boolean.of(encodeRequestUrl, _encodeRequestUrl),
          "TestScript.Setup.Action.Operation",
          "encodeRequestUrl",
        ),
      method = Enumeration.of(method, _method),
      origin = Integer.of(origin, _origin),
      params = R5String.of(params, _params),
      requestHeader = listOrEmpty(requestHeader),
      requestId = Id.of(requestId, _requestId),
      responseId = Id.of(responseId, _responseId),
      sourceId = Id.of(sourceId, _sourceId),
      targetId = Id.of(targetId, _targetId),
      url = R5String.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Operation) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, CodingSerializer, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.resource?.value)
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
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<TestScript.Setup.Action.Operation.RequestHeader> {
  override val descriptor: SerialDescriptor = buildDescriptor("RequestHeader", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Setup.Action.Operation.RequestHeader>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("field")
    b.strPrim("value")
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Operation.RequestHeader {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action.Operation.RequestHeader(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `field` =
        required(
          R5String.of(`field`, _field),
          "TestScript.Setup.Action.Operation.RequestHeader",
          "field",
        ),
      `value` =
        required(
          R5String.of(`value`, _value),
          "TestScript.Setup.Action.Operation.RequestHeader",
          "value",
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: TestScript.Setup.Action.Operation.RequestHeader,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<TestScript.Setup.Action.Assert> {
  override val descriptor: SerialDescriptor = buildDescriptor("Assert", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Setup.Action.Assert>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("label")
    b.strPrim("description")
    b.strPrim("direction")
    b.strPrim("compareToSourceId")
    b.strPrim("compareToSourceExpression")
    b.strPrim("compareToSourcePath")
    b.strPrim("contentType")
    b.strPrim("defaultManualCompletion")
    b.strPrim("expression")
    b.strPrim("headerField")
    b.strPrim("minimumId")
    b.boolPrim("navigationLinks")
    b.strPrim("operator")
    b.strPrim("path")
    b.strPrim("requestMethod")
    b.strPrim("requestURL")
    b.strPrim("resource")
    b.strPrim("response")
    b.strPrim("responseCode")
    b.strPrim("sourceId")
    b.boolPrim("stopTestOnFail")
    b.strPrim("validateProfileId")
    b.strPrim("value")
    b.boolPrim("warningOnly")
    b.optionalElement(
      "requirement",
      TestScriptSetupActionAssertRequirementSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Assert {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var label: KotlinString? = null
    var _label: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var direction: AssertionDirectionType? = null
    var _direction: Element? = null
    var compareToSourceId: KotlinString? = null
    var _compareToSourceId: Element? = null
    var compareToSourceExpression: KotlinString? = null
    var _compareToSourceExpression: Element? = null
    var compareToSourcePath: KotlinString? = null
    var _compareToSourcePath: Element? = null
    var contentType: KotlinString? = null
    var _contentType: Element? = null
    var defaultManualCompletion: AssertionManualCompletionType? = null
    var _defaultManualCompletion: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var headerField: KotlinString? = null
    var _headerField: Element? = null
    var minimumId: KotlinString? = null
    var _minimumId: Element? = null
    var navigationLinks: KotlinBoolean? = null
    var _navigationLinks: Element? = null
    var `operator`: AssertionOperatorType? = null
    var _operator: Element? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var requestMethod: TestScriptRequestMethodCode? = null
    var _requestMethod: Element? = null
    var requestURL: KotlinString? = null
    var _requestURL: Element? = null
    var resource: KotlinString? = null
    var _resource: Element? = null
    var response: AssertionResponseTypes? = null
    var _response: Element? = null
    var responseCode: KotlinString? = null
    var _responseCode: Element? = null
    var sourceId: KotlinString? = null
    var _sourceId: Element? = null
    var stopTestOnFail: KotlinBoolean? = null
    var _stopTestOnFail: Element? = null
    var validateProfileId: KotlinString? = null
    var _validateProfileId: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var warningOnly: KotlinBoolean? = null
    var _warningOnly: Element? = null
    var requirement: List<TestScript.Setup.Action.Assert.Requirement>? = null
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
        7 ->
          direction =
            AssertionDirectionType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        17 ->
          defaultManualCompletion =
            AssertionManualCompletionType.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        18 ->
          _defaultManualCompletion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> headerField = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _headerField =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> minimumId = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _minimumId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> navigationLinks = compositeDecoder.decodeBooleanElement(descriptor, i)
        26 ->
          _navigationLinks =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          `operator` =
            AssertionOperatorType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        28 ->
          _operator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          requestMethod =
            TestScriptRequestMethodCode.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        32 ->
          _requestMethod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> requestURL = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _requestURL =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 -> resource = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 ->
          response =
            AssertionResponseTypes.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        38 ->
          _response =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> responseCode = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _responseCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> sourceId = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _sourceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> stopTestOnFail = compositeDecoder.decodeBooleanElement(descriptor, i)
        44 ->
          _stopTestOnFail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 -> validateProfileId = compositeDecoder.decodeStringElement(descriptor, i)
        46 ->
          _validateProfileId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        48 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 -> warningOnly = compositeDecoder.decodeBooleanElement(descriptor, i)
        50 ->
          _warningOnly =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        51 ->
          requirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupActionAssertRequirementSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action.Assert(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      label = R5String.of(label, _label),
      description = R5String.of(description, _description),
      direction = Enumeration.of(direction, _direction),
      compareToSourceId = R5String.of(compareToSourceId, _compareToSourceId),
      compareToSourceExpression =
        R5String.of(compareToSourceExpression, _compareToSourceExpression),
      compareToSourcePath = R5String.of(compareToSourcePath, _compareToSourcePath),
      contentType = Code.of(contentType, _contentType),
      defaultManualCompletion = Enumeration.of(defaultManualCompletion, _defaultManualCompletion),
      expression = R5String.of(expression, _expression),
      headerField = R5String.of(headerField, _headerField),
      minimumId = R5String.of(minimumId, _minimumId),
      navigationLinks = R5Boolean.of(navigationLinks, _navigationLinks),
      `operator` = Enumeration.of(`operator`, _operator),
      path = R5String.of(path, _path),
      requestMethod = Enumeration.of(requestMethod, _requestMethod),
      requestURL = R5String.of(requestURL, _requestURL),
      resource = Uri.of(resource, _resource),
      response = Enumeration.of(response, _response),
      responseCode = R5String.of(responseCode, _responseCode),
      sourceId = Id.of(sourceId, _sourceId),
      stopTestOnFail =
        required(
          R5Boolean.of(stopTestOnFail, _stopTestOnFail),
          "TestScript.Setup.Action.Assert",
          "stopTestOnFail",
        ),
      validateProfileId = Id.of(validateProfileId, _validateProfileId),
      `value` = R5String.of(`value`, _value),
      warningOnly =
        required(
          R5Boolean.of(warningOnly, _warningOnly),
          "TestScript.Setup.Action.Assert",
          "warningOnly",
        ),
      requirement = listOrEmpty(requirement),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Assert) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17,
      value.defaultManualCompletion?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.defaultManualCompletion)
    compositeEncoder.encodeStringIfNotNull(descriptor, 19, value.expression?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20, value.expression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 21, value.headerField?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.headerField)
    compositeEncoder.encodeStringIfNotNull(descriptor, 23, value.minimumId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 24, value.minimumId)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 25, value.navigationLinks?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 26, value.navigationLinks)
    compositeEncoder.encodeStringIfNotNull(descriptor, 27, value.`operator`?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 28, value.`operator`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 29, value.path?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 30, value.path)
    compositeEncoder.encodeStringIfNotNull(descriptor, 31, value.requestMethod?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 32, value.requestMethod)
    compositeEncoder.encodeStringIfNotNull(descriptor, 33, value.requestURL?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 34, value.requestURL)
    compositeEncoder.encodeStringIfNotNull(descriptor, 35, value.resource?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 36, value.resource)
    compositeEncoder.encodeStringIfNotNull(descriptor, 37, value.response?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 38, value.response)
    compositeEncoder.encodeStringIfNotNull(descriptor, 39, value.responseCode?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 40, value.responseCode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 41, value.sourceId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 42, value.sourceId)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 43, value.stopTestOnFail.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 44, value.stopTestOnFail)
    compositeEncoder.encodeStringIfNotNull(descriptor, 45, value.validateProfileId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 46, value.validateProfileId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 47, value.`value`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 48, value.`value`)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 49, value.warningOnly.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 50, value.warningOnly)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51,
      TestScriptSetupActionAssertRequirementSerializer.listSerializer,
      value.requirement,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptSetupActionAssertRequirementSerializer :
  FhirSerializer<TestScript.Setup.Action.Assert.Requirement> {
  override val descriptor: SerialDescriptor = buildDescriptor("Requirement", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Setup.Action.Assert.Requirement>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkUri")
    b.strPrim("linkCanonical")
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Assert.Requirement {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkUri: KotlinString? = null
    var _linkUri: Element? = null
    var linkCanonical: KotlinString? = null
    var _linkCanonical: Element? = null
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
        3 -> linkUri = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> linkCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _linkCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Setup.Action.Assert.Requirement(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      link =
        TestScript.Setup.Action.Assert.Requirement.Link.from(
          Uri.of(linkUri, _linkUri),
          Canonical.of(linkCanonical, _linkCanonical),
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Assert.Requirement) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    when (val choice = value.link) {
      null -> {}
      is TestScript.Setup.Action.Assert.Requirement.Link.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is TestScript.Setup.Action.Assert.Requirement.Link.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptTestSerializer : FhirSerializer<TestScript.Test> {
  override val descriptor: SerialDescriptor = buildDescriptor("Test", this)

  @JvmField internal val listSerializer: KSerializer<List<TestScript.Test>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("description")
    b.optionalElement("action", TestScriptTestActionSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Test {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Test(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = R5String.of(name, _name),
      description = R5String.of(description, _description),
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Test) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      TestScriptTestActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptTestActionSerializer : FhirSerializer<TestScript.Test.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Test.Action>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("operation", TestScriptSetupActionOperationSerializer.descriptor)
    b.optionalElement("assert", TestScriptSetupActionAssertSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Test.Action {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Test.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      operation = operation,
      assert = assert,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Test.Action) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object TestScriptTeardownSerializer : FhirSerializer<TestScript.Teardown> {
  override val descriptor: SerialDescriptor = buildDescriptor("Teardown", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Teardown>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("action", TestScriptTeardownActionSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Teardown {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Teardown(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      TestScriptTeardownActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestScriptTeardownActionSerializer : FhirSerializer<TestScript.Teardown.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestScript.Teardown.Action>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("operation", TestScriptSetupActionOperationSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Teardown.Action {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestScript.Teardown.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      operation = required(operation, "TestScript.Teardown.Action", "operation"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown.Action) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("url")
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("version")
    b.strPrim("versionAlgorithmString")
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("title")
    b.strPrim("status")
    b.boolPrim("experimental")
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("copyright")
    b.strPrim("copyrightLabel")
    b.optionalElement("origin", TestScriptOriginSerializer.listSerializer.descriptor)
    b.optionalElement("destination", TestScriptDestinationSerializer.listSerializer.descriptor)
    b.optionalElement("metadata", TestScriptMetadataSerializer.descriptor)
    b.optionalElement("scope", TestScriptScopeSerializer.listSerializer.descriptor)
    b.optionalElement("fixture", TestScriptFixtureSerializer.listSerializer.descriptor)
    b.strPrimList("profile")
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
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var status: PublicationStatus? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: FhirDateTime? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var origin: List<TestScript.Origin>? = null
    var destination: List<TestScript.Destination>? = null
    var metadata: TestScript.Metadata? = null
    var scope: List<TestScript.Scope>? = null
    var fixture: List<TestScript.Fixture>? = null
    var profile: List<KotlinString?>? = null
    var _profile: List<Element?>? = null
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
              IdentifierSerializer.listSerializer,
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
        15 -> versionAlgorithmString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          versionAlgorithmCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        18 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        23 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        27 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> copyrightLabel = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 ->
          origin =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptOriginSerializer.listSerializer,
              null,
            )
        42 ->
          destination =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptDestinationSerializer.listSerializer,
              null,
            )
        43 ->
          metadata =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptMetadataSerializer,
              null,
            )
        44 ->
          scope =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptScopeSerializer.listSerializer,
              null,
            )
        45 ->
          fixture =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptFixtureSerializer.listSerializer,
              null,
            )
        46 ->
          profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        47 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        48 ->
          variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptVariableSerializer.listSerializer,
              null,
            )
        49 ->
          setup =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptSetupSerializer,
              null,
            )
        50 ->
          test =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptTestSerializer.listSerializer,
              null,
            )
        51 ->
          teardown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestScriptTeardownSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val profile_ =
      List(maxSize(profile, _profile)) { index ->
        entryRequired(
          Canonical.of(at(profile, index), at(_profile, index)),
          "TestScript",
          "profile",
        )
      }
    return TestScript(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      identifier = listOrEmpty(identifier),
      version = R5String.of(version, _version),
      versionAlgorithm =
        TestScript.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = required(R5String.of(name, _name), "TestScript", "name"),
      title = R5String.of(title, _title),
      status = required(Enumeration.of(status, _status), "TestScript", "status"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      origin = listOrEmpty(origin),
      destination = listOrEmpty(destination),
      metadata = metadata,
      scope = listOrEmpty(scope),
      fixture = listOrEmpty(fixture),
      profile = profile_,
      variable = listOrEmpty(variable),
      setup = setup,
      test = listOrEmpty(test),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is TestScript.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is TestScript.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.copyrightLabel?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyrightLabel)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      41 + descriptorOffset,
      TestScriptOriginSerializer.listSerializer,
      value.origin,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      42 + descriptorOffset,
      TestScriptDestinationSerializer.listSerializer,
      value.destination,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      TestScriptMetadataSerializer,
      value.metadata,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      44 + descriptorOffset,
      TestScriptScopeSerializer.listSerializer,
      value.scope,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      45 + descriptorOffset,
      TestScriptFixtureSerializer.listSerializer,
      value.fixture,
    )
    if (!value.profile.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        46 + descriptorOffset,
        stringNullableListSerializer,
        value.profile.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 47 + descriptorOffset, value.profile)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      48 + descriptorOffset,
      TestScriptVariableSerializer.listSerializer,
      value.variable,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      TestScriptSetupSerializer,
      value.setup,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50 + descriptorOffset,
      TestScriptTestSerializer.listSerializer,
      value.test,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      TestScriptTeardownSerializer,
      value.teardown,
    )
  }
}
