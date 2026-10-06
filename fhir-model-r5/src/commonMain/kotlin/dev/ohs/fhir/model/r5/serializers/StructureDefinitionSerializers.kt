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
import dev.ohs.fhir.model.r5.ElementDefinition
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.StructureDefinition
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.FHIRVersion
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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
        name = R5String.of(name, _name),
        comment = R5String.of(comment, _comment),
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
          R5String.of(expression, _expression)
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
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
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
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
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
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          keyword =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        42 -> fhirVersion = decoder.decodeStringElement(descriptor, i)
        43 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 ->
          mapping =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureDefinitionMappingSerializer.listSerializer,
              null,
            )
        45 -> kind = decoder.decodeStringElement(descriptor, i)
        46 ->
          _kind = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 -> `abstract` = decoder.decodeBooleanElement(descriptor, i)
        48 ->
          _abstract =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        49 ->
          context =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureDefinitionContextSerializer.listSerializer,
              null,
            )
        50 ->
          contextInvariant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        51 ->
          _contextInvariant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        52 -> type = decoder.decodeStringElement(descriptor, i)
        53 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        54 -> baseDefinition = decoder.decodeStringElement(descriptor, i)
        55 ->
          _baseDefinition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        56 -> derivation = decoder.decodeStringElement(descriptor, i)
        57 ->
          _derivation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        58 ->
          snapshot =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureDefinitionSnapshotSerializer,
              null,
            )
        59 ->
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        StructureDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on StructureDefinition"
          ),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on StructureDefinition"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
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
        R5Boolean.of(`abstract`, _abstract)
          ?: throw SerializationException(
            "Missing required property 'abstract' on StructureDefinition"
          ),
      context = context ?: listOf(),
      contextInvariant =
        (kotlin.collections.List(
          maxOf(contextInvariant?.size ?: 0, _contextInvariant?.size ?: 0)
        ) { index ->
          R5String.of(contextInvariant?.getOrNull(index), _contextInvariant?.getOrNull(index))
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
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is StructureDefinition.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is StructureDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyrightLabel)
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        CodingSerializer.listSerializer,
        value.keyword,
      )
    encoder.encodeStringIfNotNull(descriptor, 42 + descriptorOffset, value.fhirVersion?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.fhirVersion)
    if (value.mapping.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        StructureDefinitionMappingSerializer.listSerializer,
        value.mapping,
      )
    encoder.encodeStringIfNotNull(descriptor, 45 + descriptorOffset, value.kind.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.kind)
    encoder.encodeBooleanIfNotNull(descriptor, 47 + descriptorOffset, value.`abstract`.value)
    encoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.`abstract`)
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        StructureDefinitionContextSerializer.listSerializer,
        value.context,
      )
    if (value.contextInvariant.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        50 + descriptorOffset,
        stringNullableListSerializer,
        value.contextInvariant.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 51 + descriptorOffset, value.contextInvariant)
    }
    encoder.encodeStringIfNotNull(descriptor, 52 + descriptorOffset, value.type.value)
    encoder.encodeElementIfNotNull(descriptor, 53 + descriptorOffset, value.type)
    encoder.encodeStringIfNotNull(descriptor, 54 + descriptorOffset, value.baseDefinition?.value)
    encoder.encodeElementIfNotNull(descriptor, 55 + descriptorOffset, value.baseDefinition)
    encoder.encodeStringIfNotNull(descriptor, 56 + descriptorOffset, value.derivation?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 57 + descriptorOffset, value.derivation)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      58 + descriptorOffset,
      StructureDefinitionSnapshotSerializer,
      value.snapshot,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      59 + descriptorOffset,
      StructureDefinitionDifferentialSerializer,
      value.differential,
    )
  }
}
