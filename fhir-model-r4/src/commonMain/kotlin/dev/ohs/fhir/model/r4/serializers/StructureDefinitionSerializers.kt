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
import dev.ohs.fhir.model.r4.ElementDefinition
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.StructureDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.FHIRVersion
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identity", KotlinString.serializer().descriptor)
      optionalElement("_identity", ElementSerializer.descriptor)
      optionalElement("uri", KotlinString.serializer().descriptor)
      optionalElement("_uri", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("comment", KotlinString.serializer().descriptor)
      optionalElement("_comment", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureDefinition.Mapping>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureDefinition.Mapping =
    decoder.decodeStructure(descriptor) {
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
          3 -> identity = decodeStringElement(descriptor, i)
          4 -> _identity = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> uri = decodeStringElement(descriptor, i)
          6 -> _uri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> name = decodeStringElement(descriptor, i)
          8 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> comment = decodeStringElement(descriptor, i)
          10 -> _comment = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Mapping: " + i)
        }
      }
      StructureDefinition.Mapping(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identity =
          Id.of(identity, _identity)
            ?: throw SerializationException(
              "Missing required property 'identity' on StructureDefinition.Mapping"
            ),
        uri = Uri.of(uri, _uri),
        name = R4String.of(name, _name),
        comment = R4String.of(comment, _comment),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Mapping) {
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
      encodeStringIfNotNull(descriptor, 3, value.identity.value)
      encodeElementIfNotNull(descriptor, 4, value.identity)
      encodeStringIfNotNull(descriptor, 5, value.uri?.value)
      encodeElementIfNotNull(descriptor, 6, value.uri)
      encodeStringIfNotNull(descriptor, 7, value.name?.value)
      encodeElementIfNotNull(descriptor, 8, value.name)
      encodeStringIfNotNull(descriptor, 9, value.comment?.value)
      encodeElementIfNotNull(descriptor, 10, value.comment)
    }
  }
}

internal object StructureDefinitionContextSerializer : KSerializer<StructureDefinition.Context> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Context") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureDefinition.Context>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureDefinition.Context =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var expression: KotlinString? = null
      var _expression: Element? = null
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> expression = decodeStringElement(descriptor, i)
          6 ->
            _expression = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Context: " + i)
        }
      }
      StructureDefinition.Context(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) StructureDefinition.ExtensionContextType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on StructureDefinition.Context"
            ),
        expression =
          R4String.of(expression, _expression)
            ?: throw SerializationException(
              "Missing required property 'expression' on StructureDefinition.Context"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Context) {
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
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.expression.value)
      encodeElementIfNotNull(descriptor, 6, value.expression)
    }
  }
}

internal object StructureDefinitionSnapshotSerializer : KSerializer<StructureDefinition.Snapshot> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Snapshot") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("element", ElementDefinitionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureDefinition.Snapshot>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureDefinition.Snapshot =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var element: List<ElementDefinition>? = null
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
            element =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Snapshot: " + i)
        }
      }
      StructureDefinition.Snapshot(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        element = element ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Snapshot) {
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
      if (value.element.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ElementDefinitionSerializer.listSerializer,
          value.element,
        )
    }
  }
}

internal object StructureDefinitionDifferentialSerializer :
  KSerializer<StructureDefinition.Differential> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Differential") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("element", ElementDefinitionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<StructureDefinition.Differential>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): StructureDefinition.Differential =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var element: List<ElementDefinition>? = null
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
            element =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementDefinitionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Differential: " + i)
        }
      }
      StructureDefinition.Differential(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        element = element ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Differential) {
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
      if (value.element.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ElementDefinitionSerializer.listSerializer,
          value.element,
        )
    }
  }
}

internal object StructureDefinitionSerializer : FhirResourceSerializer<StructureDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("StructureDefinition")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
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
    b.optionalElement("keyword", CodingSerializer.listSerializer.descriptor)
    b.optionalElement("fhirVersion", KotlinString.serializer().descriptor)
    b.optionalElement("_fhirVersion", ElementSerializer.descriptor)
    b.optionalElement("mapping", StructureDefinitionMappingSerializer.listSerializer.descriptor)
    b.optionalElement("kind", KotlinString.serializer().descriptor)
    b.optionalElement("_kind", ElementSerializer.descriptor)
    b.optionalElement("abstract", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_abstract", ElementSerializer.descriptor)
    b.optionalElement("context", StructureDefinitionContextSerializer.listSerializer.descriptor)
    b.optionalElement("contextInvariant", stringNullableListSerializer.descriptor)
    b.optionalElement("_contextInvariant", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("baseDefinition", KotlinString.serializer().descriptor)
    b.optionalElement("_baseDefinition", ElementSerializer.descriptor)
    b.optionalElement("derivation", KotlinString.serializer().descriptor)
    b.optionalElement("_derivation", ElementSerializer.descriptor)
    b.optionalElement("snapshot", StructureDefinitionSnapshotSerializer.descriptor)
    b.optionalElement("differential", StructureDefinitionDifferentialSerializer.descriptor)
  }

  override fun deserializeInternal(
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
      version = R4String.of(version, _version),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on StructureDefinition"
          ),
      title = R4String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on StructureDefinition"
          ),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      keyword = keyword ?: listOf(),
      fhirVersion =
        Enumeration.of(
          if (fhirVersion != null) FHIRVersion.fromCode(fhirVersion) else null,
          _fhirVersion,
        ),
      mapping = mapping ?: listOf(),
      kind =
        Enumeration.of(
          if (kind != null) StructureDefinition.StructureDefinitionKind.fromCode(kind) else null,
          _kind,
        )
          ?: throw SerializationException(
            "Missing required property 'kind' on StructureDefinition"
          ),
      `abstract` =
        R4Boolean.of(`abstract`, _abstract)
          ?: throw SerializationException(
            "Missing required property 'abstract' on StructureDefinition"
          ),
      context = context ?: listOf(),
      contextInvariant =
        (kotlin.collections.List(
          maxOf(contextInvariant?.size ?: 0, _contextInvariant?.size ?: 0)
        ) { index ->
          R4String.of(contextInvariant?.getOrNull(index), _contextInvariant?.getOrNull(index))
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
          if (derivation != null) StructureDefinition.TypeDerivationRule.fromCode(derivation)
          else null,
          _derivation,
        ),
      snapshot = snapshot,
      differential = differential,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: StructureDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 21 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
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
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodingSerializer.listSerializer,
        value.keyword,
      )
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.fhirVersion?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.fhirVersion)
    if (value.mapping.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        StructureDefinitionMappingSerializer.listSerializer,
        value.mapping,
      )
    encoder.encodeStringIfNotNull(descriptor, 40 + descriptorOffset, value.kind.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, value.kind)
    encoder.encodeBooleanIfNotNull(descriptor, 42 + descriptorOffset, value.`abstract`.value)
    encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.`abstract`)
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        StructureDefinitionContextSerializer.listSerializer,
        value.context,
      )
    if (value.contextInvariant.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        value.contextInvariant.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 46 + descriptorOffset, value.contextInvariant)
    }
    encoder.encodeStringIfNotNull(descriptor, 47 + descriptorOffset, value.type.value)
    encoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.type)
    encoder.encodeStringIfNotNull(descriptor, 49 + descriptorOffset, value.baseDefinition?.value)
    encoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.baseDefinition)
    encoder.encodeStringIfNotNull(descriptor, 51 + descriptorOffset, value.derivation?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 52 + descriptorOffset, value.derivation)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      53 + descriptorOffset,
      StructureDefinitionSnapshotSerializer,
      value.snapshot,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      54 + descriptorOffset,
      StructureDefinitionDifferentialSerializer,
      value.differential,
    )
  }
}
