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
import dev.ohs.fhir.model.r4b.ElementDefinition
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.StructureDefinition
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.FHIRVersion
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object StructureDefinitionMappingSerializer : KSerializer<StructureDefinition.Mapping> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Mapping") {
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
      element("identity", KotlinString.serializer().descriptor, isOptional = true)
      element("_identity", Element.serializer().descriptor, isOptional = true)
      element("uri", KotlinString.serializer().descriptor, isOptional = true)
      element("_uri", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<StructureDefinition.Mapping>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureDefinition.Mapping =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Mapping) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): StructureDefinition.Mapping {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identity: KotlinString? = null
    var _identity: Element? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
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
        3 -> identity = decoder.decodeStringElement(descriptor, i)
        4 ->
          _identity =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> uri = decoder.decodeStringElement(descriptor, i)
        6 ->
          _uri = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> name = decoder.decodeStringElement(descriptor, i)
        8 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 -> comment = decoder.decodeStringElement(descriptor, i)
        10 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mapping: " + i)
      }
    }
    return StructureDefinition.Mapping(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identity =
        Id.of(identity, _identity)
          ?: throw SerializationException(
            "Missing required property 'identity' on StructureDefinition.Mapping"
          ),
      uri = Uri.of(uri, _uri),
      name = R4bString.of(name, _name),
      comment = R4bString.of(comment, _comment),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: StructureDefinition.Mapping) {
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
    ((value.identity.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.identity.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.uri?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
  }
}

internal object StructureDefinitionContextSerializer : KSerializer<StructureDefinition.Context> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Context") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<StructureDefinition.Context>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureDefinition.Context =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Context) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): StructureDefinition.Context {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
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
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> expression = decoder.decodeStringElement(descriptor, i)
        6 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Context: " + i)
      }
    }
    return StructureDefinition.Context(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(type?.let { StructureDefinition.ExtensionContextType.fromCode(it) }, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on StructureDefinition.Context"
          ),
      expression =
        R4bString.of(expression, _expression)
          ?: throw SerializationException(
            "Missing required property 'expression' on StructureDefinition.Context"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: StructureDefinition.Context) {
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
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.expression.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.expression.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
  }
}

internal object StructureDefinitionSnapshotSerializer : KSerializer<StructureDefinition.Snapshot> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Snapshot") {
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
        "element",
        listSerialDescriptor(ElementDefinition.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<StructureDefinition.Snapshot>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureDefinition.Snapshot =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Snapshot) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): StructureDefinition.Snapshot {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var element: List<ElementDefinition>? = null
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
        3 ->
          element =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Snapshot: " + i)
      }
    }
    return StructureDefinition.Snapshot(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      element = element ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: StructureDefinition.Snapshot) {
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
    if (value.element.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        ElementDefinitionSerializer.listSerializer,
        value.element,
      )
  }
}

internal object StructureDefinitionDifferentialSerializer :
  KSerializer<StructureDefinition.Differential> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Differential") {
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
        "element",
        listSerialDescriptor(ElementDefinition.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<StructureDefinition.Differential>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureDefinition.Differential =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Differential) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): StructureDefinition.Differential {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var element: List<ElementDefinition>? = null
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
        3 ->
          element =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementDefinitionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Differential: " + i)
      }
    }
    return StructureDefinition.Differential(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      element = element ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: StructureDefinition.Differential,
  ) {
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
    if (value.element.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        ElementDefinitionSerializer.listSerializer,
        value.element,
      )
  }
}

internal object StructureDefinitionSerializer : KSerializer<StructureDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureDefinition") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
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
    b.element("keyword", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
    b.element("fhirVersion", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_fhirVersion", Element.serializer().descriptor, isOptional = true)
    b.element(
      "mapping",
      listSerialDescriptor(lazyDescriptor { StructureDefinition.Mapping.serializer().descriptor }),
      isOptional = true,
    )
    b.element("kind", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_kind", Element.serializer().descriptor, isOptional = true)
    b.element("abstract", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_abstract", Element.serializer().descriptor, isOptional = true)
    b.element(
      "context",
      listSerialDescriptor(lazyDescriptor { StructureDefinition.Context.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "contextInvariant",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_contextInvariant",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("baseDefinition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_baseDefinition", Element.serializer().descriptor, isOptional = true)
    b.element("derivation", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_derivation", Element.serializer().descriptor, isOptional = true)
    b.element(
      "snapshot",
      lazyDescriptor { StructureDefinition.Snapshot.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "differential",
      lazyDescriptor { StructureDefinition.Differential.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): StructureDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "StructureDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): StructureDefinition {
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
    var keyword: List<Coding>? = null
    var fhirVersion: KotlinString? = null
    var _fhirVersion: Element? = null
    var mapping: List<StructureDefinition.Mapping>? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var `abstract`: KotlinBoolean? = null
    var _abstract: Element? = null
    var context: List<StructureDefinition.Context>? = null
    var contextInvariant: List<KotlinString?>? = null
    var _contextInvariant: List<Element?>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var baseDefinition: KotlinString? = null
    var _baseDefinition: Element? = null
    var derivation: KotlinString? = null
    var _derivation: Element? = null
    var snapshot: StructureDefinition.Snapshot? = null
    var differential: StructureDefinition.Differential? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> publisher = decoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = decoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = decoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> copyright = decoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          keyword =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        37 -> fhirVersion = decoder.decodeStringElement(descriptor, i)
        38 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 ->
          mapping =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureDefinitionMappingSerializer.listSerializer,
              null,
            )
        40 -> kind = decoder.decodeStringElement(descriptor, i)
        41 ->
          _kind = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        42 -> `abstract` = decoder.decodeBooleanElement(descriptor, i)
        43 ->
          _abstract =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 ->
          context =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureDefinitionContextSerializer.listSerializer,
              null,
            )
        45 ->
          contextInvariant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _contextInvariant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 -> type = decoder.decodeStringElement(descriptor, i)
        48 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        49 -> baseDefinition = decoder.decodeStringElement(descriptor, i)
        50 ->
          _baseDefinition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        51 -> derivation = decoder.decodeStringElement(descriptor, i)
        52 ->
          _derivation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        53 ->
          snapshot =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureDefinitionSnapshotSerializer,
              null,
            )
        54 ->
          differential =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureDefinitionDifferentialSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding StructureDefinition: " + i)
      }
    }
    return StructureDefinition(
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
          ?: throw SerializationException("Missing required property 'url' on StructureDefinition"),
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on StructureDefinition"
          ),
      title = R4bString.of(title, _title),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on StructureDefinition"
          ),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      keyword = keyword ?: listOf(),
      fhirVersion = Enumeration.of(fhirVersion?.let { FHIRVersion.fromCode(it) }, _fhirVersion),
      mapping = mapping ?: listOf(),
      kind =
        Enumeration.of(
          kind?.let { StructureDefinition.StructureDefinitionKind.fromCode(it) },
          _kind,
        )
          ?: throw SerializationException(
            "Missing required property 'kind' on StructureDefinition"
          ),
      `abstract` =
        R4bBoolean.of(`abstract`, _abstract)
          ?: throw SerializationException(
            "Missing required property 'abstract' on StructureDefinition"
          ),
      context = context ?: listOf(),
      contextInvariant =
        (kotlin.collections.List(
          maxOf(contextInvariant?.size ?: 0, _contextInvariant?.size ?: 0)
        ) { index ->
          R4bString.of(
            contextInvariant?.getOrNull(index)?.let { it },
            _contextInvariant?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'contextInvariant' on StructureDefinition has neither a value nor an id/extension"
            )
        }),
      type =
        Uri.of(type, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on StructureDefinition"
          ),
      baseDefinition = Canonical.of(baseDefinition, _baseDefinition),
      derivation =
        Enumeration.of(
          derivation?.let { StructureDefinition.TypeDerivationRule.fromCode(it) },
          _derivation,
        ),
      snapshot = snapshot,
      differential = differential,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: StructureDefinition,
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
    ((value.url.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, ElementSerializer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ElementSerializer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, ElementSerializer, it)
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ElementSerializer, it)
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, ElementSerializer, it)
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, ElementSerializer, it)
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, ElementSerializer, it)
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, ElementSerializer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, ElementSerializer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, ElementSerializer, it)
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, ElementSerializer, it)
    }
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodingSerializer.listSerializer,
        value.keyword,
      )
    ((value.fhirVersion?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.fhirVersion?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, ElementSerializer, it)
    }
    if (value.mapping.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        StructureDefinitionMappingSerializer.listSerializer,
        value.mapping,
      )
    ((value.kind.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 40 + descriptorOffset, it)
    }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 41 + descriptorOffset, ElementSerializer, it)
    }
    ((value.`abstract`.value))?.let {
      encoder.encodeBooleanElement(descriptor, 42 + descriptorOffset, it)
    }
    (value.`abstract`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 43 + descriptorOffset, ElementSerializer, it)
    }
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        StructureDefinitionContextSerializer.listSerializer,
        value.context,
      )
    (value.contextInvariant.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.contextInvariant.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    ((value.type.value))?.let { encoder.encodeStringElement(descriptor, 47 + descriptorOffset, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 48 + descriptorOffset, ElementSerializer, it)
    }
    ((value.baseDefinition?.value))?.let {
      encoder.encodeStringElement(descriptor, 49 + descriptorOffset, it)
    }
    (value.baseDefinition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 50 + descriptorOffset, ElementSerializer, it)
    }
    ((value.derivation?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 51 + descriptorOffset, it)
    }
    (value.derivation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 52 + descriptorOffset, ElementSerializer, it)
    }
    (value.snapshot)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        StructureDefinitionSnapshotSerializer,
        it,
      )
    }
    (value.differential)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        StructureDefinitionDifferentialSerializer,
        it,
      )
    }
  }
}

internal object StructureDefinitionPolymorphicSerializer : KSerializer<StructureDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureDefinition") {
      StructureDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition) {
    encoder.encodeStructure(descriptor) {
      StructureDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): StructureDefinition =
    decoder.decodeStructure(descriptor) {
      StructureDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
