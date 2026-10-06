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
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.TerminologyCapabilities
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.UsageContext
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

internal object TerminologyCapabilitiesSoftwareSerializer :
  KSerializer<TerminologyCapabilities.Software> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Software") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Software>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Software =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var version: KotlinString? = null
      var _version: Element? = null
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
          5 -> version = decodeStringElement(descriptor, i)
          6 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Software: " + i)
        }
      }
      TerminologyCapabilities.Software(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R4bString.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on TerminologyCapabilities.Software"
            ),
        version = R4bString.of(version, _version),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Software) {
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
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.version?.value)
      encodeElementIfNotNull(descriptor, 6, value.version)
    }
  }
}

internal object TerminologyCapabilitiesImplementationSerializer :
  KSerializer<TerminologyCapabilities.Implementation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Implementation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Implementation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Implementation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var url: KotlinString? = null
      var _url: Element? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> url = decodeStringElement(descriptor, i)
          6 -> _url = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Implementation: " + i)
        }
      }
      TerminologyCapabilities.Implementation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description =
          R4bString.of(description, _description)
            ?: throw SerializationException(
              "Missing required property 'description' on TerminologyCapabilities.Implementation"
            ),
        url = Url.of(url, _url),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Implementation) {
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
      encodeStringIfNotNull(descriptor, 3, value.description.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeStringIfNotNull(descriptor, 5, value.url?.value)
      encodeElementIfNotNull(descriptor, 6, value.url)
    }
  }
}

internal object TerminologyCapabilitiesCodeSystemSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CodeSystem") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("uri", KotlinString.serializer().descriptor)
      optionalElement("_uri", ElementSerializer.descriptor)
      optionalElement(
        "version",
        TerminologyCapabilitiesCodeSystemVersionSerializer.listSerializer.descriptor,
      )
      optionalElement("subsumption", KotlinBoolean.serializer().descriptor)
      optionalElement("_subsumption", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.CodeSystem>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var uri: KotlinString? = null
      var _uri: Element? = null
      var version: List<TerminologyCapabilities.CodeSystem.Version>? = null
      var subsumption: KotlinBoolean? = null
      var _subsumption: Element? = null
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
          3 -> uri = decodeStringElement(descriptor, i)
          4 -> _uri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            version =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TerminologyCapabilitiesCodeSystemVersionSerializer.listSerializer,
                null,
              )
          6 -> subsumption = decodeBooleanElement(descriptor, i)
          7 ->
            _subsumption = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CodeSystem: " + i)
        }
      }
      TerminologyCapabilities.CodeSystem(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        uri = Canonical.of(uri, _uri),
        version = version ?: listOf(),
        subsumption = R4bBoolean.of(subsumption, _subsumption),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem) {
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
      encodeStringIfNotNull(descriptor, 3, value.uri?.value)
      encodeElementIfNotNull(descriptor, 4, value.uri)
      if (value.version.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          TerminologyCapabilitiesCodeSystemVersionSerializer.listSerializer,
          value.version,
        )
      encodeBooleanIfNotNull(descriptor, 6, value.subsumption?.value)
      encodeElementIfNotNull(descriptor, 7, value.subsumption)
    }
  }
}

internal object TerminologyCapabilitiesCodeSystemVersionSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem.Version> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Version") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("isDefault", KotlinBoolean.serializer().descriptor)
      optionalElement("_isDefault", ElementSerializer.descriptor)
      optionalElement("compositional", KotlinBoolean.serializer().descriptor)
      optionalElement("_compositional", ElementSerializer.descriptor)
      optionalElement("language", stringNullableListSerializer.descriptor)
      optionalElement("_language", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "filter",
        TerminologyCapabilitiesCodeSystemVersionFilterSerializer.listSerializer.descriptor,
      )
      optionalElement("property", stringNullableListSerializer.descriptor)
      optionalElement("_property", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.CodeSystem.Version>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var isDefault: KotlinBoolean? = null
      var _isDefault: Element? = null
      var compositional: KotlinBoolean? = null
      var _compositional: Element? = null
      var language: List<KotlinString?>? = null
      var _language: List<Element?>? = null
      var filter: List<TerminologyCapabilities.CodeSystem.Version.Filter>? = null
      var `property`: List<KotlinString?>? = null
      var _property: List<Element?>? = null
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
          3 -> code = decodeStringElement(descriptor, i)
          4 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> isDefault = decodeBooleanElement(descriptor, i)
          6 ->
            _isDefault = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> compositional = decodeBooleanElement(descriptor, i)
          8 ->
            _compositional =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            language =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          10 ->
            _language =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          11 ->
            filter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TerminologyCapabilitiesCodeSystemVersionFilterSerializer.listSerializer,
                null,
              )
          12 ->
            `property` =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          13 ->
            _property =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Version: " + i)
        }
      }
      TerminologyCapabilities.CodeSystem.Version(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = R4bString.of(code, _code),
        isDefault = R4bBoolean.of(isDefault, _isDefault),
        compositional = R4bBoolean.of(compositional, _compositional),
        language =
          (kotlin.collections.List(maxOf(language?.size ?: 0, _language?.size ?: 0)) { index ->
            Code.of(language?.getOrNull(index), _language?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'language' on TerminologyCapabilities.CodeSystem.Version has neither a value nor an id/extension"
              )
          }),
        filter = filter ?: listOf(),
        `property` =
          (kotlin.collections.List(maxOf(`property`?.size ?: 0, _property?.size ?: 0)) { index ->
            Code.of(`property`?.getOrNull(index), _property?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'property' on TerminologyCapabilities.CodeSystem.Version has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem.Version) {
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
      encodeStringIfNotNull(descriptor, 3, value.code?.value)
      encodeElementIfNotNull(descriptor, 4, value.code)
      encodeBooleanIfNotNull(descriptor, 5, value.isDefault?.value)
      encodeElementIfNotNull(descriptor, 6, value.isDefault)
      encodeBooleanIfNotNull(descriptor, 7, value.compositional?.value)
      encodeElementIfNotNull(descriptor, 8, value.compositional)
      if (value.language.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          stringNullableListSerializer,
          value.language.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 10, value.language)
      }
      if (value.filter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          TerminologyCapabilitiesCodeSystemVersionFilterSerializer.listSerializer,
          value.filter,
        )
      if (value.`property`.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          12,
          stringNullableListSerializer,
          value.`property`.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 13, value.`property`)
      }
    }
  }
}

internal object TerminologyCapabilitiesCodeSystemVersionFilterSerializer :
  KSerializer<TerminologyCapabilities.CodeSystem.Version.Filter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Filter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("op", stringNullableListSerializer.descriptor)
      optionalElement("_op", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<TerminologyCapabilities.CodeSystem.Version.Filter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version.Filter =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var op: List<KotlinString?>? = null
      var _op: List<Element?>? = null
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
          3 -> code = decodeStringElement(descriptor, i)
          4 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            op =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          6 ->
            _op =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Filter: " + i)
        }
      }
      TerminologyCapabilities.CodeSystem.Version.Filter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Code.of(code, _code)
            ?: throw SerializationException(
              "Missing required property 'code' on TerminologyCapabilities.CodeSystem.Version.Filter"
            ),
        op =
          (kotlin.collections.List(maxOf(op?.size ?: 0, _op?.size ?: 0)) { index ->
            Code.of(op?.getOrNull(index), _op?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'op' on TerminologyCapabilities.CodeSystem.Version.Filter has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: TerminologyCapabilities.CodeSystem.Version.Filter,
  ) {
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
      encodeStringIfNotNull(descriptor, 3, value.code.value)
      encodeElementIfNotNull(descriptor, 4, value.code)
      if (value.op.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          stringNullableListSerializer,
          value.op.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.op)
      }
    }
  }
}

internal object TerminologyCapabilitiesExpansionSerializer :
  KSerializer<TerminologyCapabilities.Expansion> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Expansion") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("hierarchical", KotlinBoolean.serializer().descriptor)
      optionalElement("_hierarchical", ElementSerializer.descriptor)
      optionalElement("paging", KotlinBoolean.serializer().descriptor)
      optionalElement("_paging", ElementSerializer.descriptor)
      optionalElement("incomplete", KotlinBoolean.serializer().descriptor)
      optionalElement("_incomplete", ElementSerializer.descriptor)
      optionalElement(
        "parameter",
        TerminologyCapabilitiesExpansionParameterSerializer.listSerializer.descriptor,
      )
      optionalElement("textFilter", KotlinString.serializer().descriptor)
      optionalElement("_textFilter", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Expansion>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var hierarchical: KotlinBoolean? = null
      var _hierarchical: Element? = null
      var paging: KotlinBoolean? = null
      var _paging: Element? = null
      var incomplete: KotlinBoolean? = null
      var _incomplete: Element? = null
      var parameter: List<TerminologyCapabilities.Expansion.Parameter>? = null
      var textFilter: KotlinString? = null
      var _textFilter: Element? = null
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
          3 -> hierarchical = decodeBooleanElement(descriptor, i)
          4 ->
            _hierarchical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> paging = decodeBooleanElement(descriptor, i)
          6 -> _paging = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> incomplete = decodeBooleanElement(descriptor, i)
          8 ->
            _incomplete = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            parameter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TerminologyCapabilitiesExpansionParameterSerializer.listSerializer,
                null,
              )
          10 -> textFilter = decodeStringElement(descriptor, i)
          11 ->
            _textFilter = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Expansion: " + i)
        }
      }
      TerminologyCapabilities.Expansion(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        hierarchical = R4bBoolean.of(hierarchical, _hierarchical),
        paging = R4bBoolean.of(paging, _paging),
        incomplete = R4bBoolean.of(incomplete, _incomplete),
        parameter = parameter ?: listOf(),
        textFilter = Markdown.of(textFilter, _textFilter),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.hierarchical?.value)
      encodeElementIfNotNull(descriptor, 4, value.hierarchical)
      encodeBooleanIfNotNull(descriptor, 5, value.paging?.value)
      encodeElementIfNotNull(descriptor, 6, value.paging)
      encodeBooleanIfNotNull(descriptor, 7, value.incomplete?.value)
      encodeElementIfNotNull(descriptor, 8, value.incomplete)
      if (value.parameter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          TerminologyCapabilitiesExpansionParameterSerializer.listSerializer,
          value.parameter,
        )
      encodeStringIfNotNull(descriptor, 10, value.textFilter?.value)
      encodeElementIfNotNull(descriptor, 11, value.textFilter)
    }
  }
}

internal object TerminologyCapabilitiesExpansionParameterSerializer :
  KSerializer<TerminologyCapabilities.Expansion.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Expansion.Parameter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion.Parameter =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var documentation: KotlinString? = null
      var _documentation: Element? = null
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
          5 -> documentation = decodeStringElement(descriptor, i)
          6 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      TerminologyCapabilities.Expansion.Parameter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          Code.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on TerminologyCapabilities.Expansion.Parameter"
            ),
        documentation = R4bString.of(documentation, _documentation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion.Parameter) {
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
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 6, value.documentation)
    }
  }
}

internal object TerminologyCapabilitiesValidateCodeSerializer :
  KSerializer<TerminologyCapabilities.ValidateCode> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ValidateCode") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("translations", KotlinBoolean.serializer().descriptor)
      optionalElement("_translations", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.ValidateCode>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.ValidateCode =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var translations: KotlinBoolean? = null
      var _translations: Element? = null
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
          3 -> translations = decodeBooleanElement(descriptor, i)
          4 ->
            _translations =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ValidateCode: " + i)
        }
      }
      TerminologyCapabilities.ValidateCode(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        translations =
          R4bBoolean.of(translations, _translations)
            ?: throw SerializationException(
              "Missing required property 'translations' on TerminologyCapabilities.ValidateCode"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.ValidateCode) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.translations.value)
      encodeElementIfNotNull(descriptor, 4, value.translations)
    }
  }
}

internal object TerminologyCapabilitiesTranslationSerializer :
  KSerializer<TerminologyCapabilities.Translation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Translation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("needsMap", KotlinBoolean.serializer().descriptor)
      optionalElement("_needsMap", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Translation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Translation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var needsMap: KotlinBoolean? = null
      var _needsMap: Element? = null
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
          3 -> needsMap = decodeBooleanElement(descriptor, i)
          4 -> _needsMap = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Translation: " + i)
        }
      }
      TerminologyCapabilities.Translation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        needsMap =
          R4bBoolean.of(needsMap, _needsMap)
            ?: throw SerializationException(
              "Missing required property 'needsMap' on TerminologyCapabilities.Translation"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Translation) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.needsMap.value)
      encodeElementIfNotNull(descriptor, 4, value.needsMap)
    }
  }
}

internal object TerminologyCapabilitiesClosureSerializer :
  KSerializer<TerminologyCapabilities.Closure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Closure") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("translation", KotlinBoolean.serializer().descriptor)
      optionalElement("_translation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Closure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Closure =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var translation: KotlinBoolean? = null
      var _translation: Element? = null
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
          3 -> translation = decodeBooleanElement(descriptor, i)
          4 ->
            _translation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Closure: " + i)
        }
      }
      TerminologyCapabilities.Closure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        translation = R4bBoolean.of(translation, _translation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Closure) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.translation?.value)
      encodeElementIfNotNull(descriptor, 4, value.translation)
    }
  }
}

internal object TerminologyCapabilitiesSerializer :
  FhirResourceSerializer<TerminologyCapabilities> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("TerminologyCapabilities")

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
    b.optionalElement("kind", KotlinString.serializer().descriptor)
    b.optionalElement("_kind", ElementSerializer.descriptor)
    b.optionalElement("software", TerminologyCapabilitiesSoftwareSerializer.descriptor)
    b.optionalElement("implementation", TerminologyCapabilitiesImplementationSerializer.descriptor)
    b.optionalElement("lockedDate", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_lockedDate", ElementSerializer.descriptor)
    b.optionalElement(
      "codeSystem",
      TerminologyCapabilitiesCodeSystemSerializer.listSerializer.descriptor,
    )
    b.optionalElement("expansion", TerminologyCapabilitiesExpansionSerializer.descriptor)
    b.optionalElement("codeSearch", KotlinString.serializer().descriptor)
    b.optionalElement("_codeSearch", ElementSerializer.descriptor)
    b.optionalElement("validateCode", TerminologyCapabilitiesValidateCodeSerializer.descriptor)
    b.optionalElement("translation", TerminologyCapabilitiesTranslationSerializer.descriptor)
    b.optionalElement("closure", TerminologyCapabilitiesClosureSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): TerminologyCapabilities {
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
    var kind: KotlinString? = null
    var _kind: Element? = null
    var software: TerminologyCapabilities.Software? = null
    var implementation: TerminologyCapabilities.Implementation? = null
    var lockedDate: KotlinBoolean? = null
    var _lockedDate: Element? = null
    var codeSystem: List<TerminologyCapabilities.CodeSystem>? = null
    var expansion: TerminologyCapabilities.Expansion? = null
    var codeSearch: KotlinString? = null
    var _codeSearch: Element? = null
    var validateCode: TerminologyCapabilities.ValidateCode? = null
    var translation: TerminologyCapabilities.Translation? = null
    var closure: TerminologyCapabilities.Closure? = null
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
        12 -> version = decoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> title = decoder.decodeStringElement(descriptor, i)
        17 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        21 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> date = decoder.decodeStringElement(descriptor, i)
        23 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> publisher = decoder.decodeStringElement(descriptor, i)
        25 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        27 -> description = decoder.decodeStringElement(descriptor, i)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        30 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 -> purpose = decoder.decodeStringElement(descriptor, i)
        32 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 -> copyright = decoder.decodeStringElement(descriptor, i)
        34 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> kind = decoder.decodeStringElement(descriptor, i)
        36 ->
          _kind = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 ->
          software =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesSoftwareSerializer,
              null,
            )
        38 ->
          implementation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesImplementationSerializer,
              null,
            )
        39 -> lockedDate = decoder.decodeBooleanElement(descriptor, i)
        40 ->
          _lockedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          codeSystem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesCodeSystemSerializer.listSerializer,
              null,
            )
        42 ->
          expansion =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesExpansionSerializer,
              null,
            )
        43 -> codeSearch = decoder.decodeStringElement(descriptor, i)
        44 ->
          _codeSearch =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 ->
          validateCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesValidateCodeSerializer,
              null,
            )
        46 ->
          translation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesTranslationSerializer,
              null,
            )
        47 ->
          closure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesClosureSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding TerminologyCapabilities: " + i)
      }
    }
    return TerminologyCapabilities(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on TerminologyCapabilities"
          ),
      experimental = R4bBoolean.of(experimental, _experimental),
      date =
        DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date)
          ?: throw SerializationException(
            "Missing required property 'date' on TerminologyCapabilities"
          ),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      kind =
        Enumeration.of(
          if (kind != null) TerminologyCapabilities.CapabilityStatementKind.fromCode(kind)
          else null,
          _kind,
        )
          ?: throw SerializationException(
            "Missing required property 'kind' on TerminologyCapabilities"
          ),
      software = software,
      implementation = implementation,
      lockedDate = R4bBoolean.of(lockedDate, _lockedDate),
      codeSystem = codeSystem ?: listOf(),
      expansion = expansion,
      codeSearch =
        Enumeration.of(
          if (codeSearch != null) TerminologyCapabilities.CodeSearchSupport.fromCode(codeSearch)
          else null,
          _codeSearch,
        ),
      validateCode = validateCode,
      translation = translation,
      closure = closure,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TerminologyCapabilities,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 20 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.date.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.kind.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.kind)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      TerminologyCapabilitiesSoftwareSerializer,
      value.software,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      TerminologyCapabilitiesImplementationSerializer,
      value.implementation,
    )
    encoder.encodeBooleanIfNotNull(descriptor, 39 + descriptorOffset, value.lockedDate?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.lockedDate)
    if (value.codeSystem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        TerminologyCapabilitiesCodeSystemSerializer.listSerializer,
        value.codeSystem,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      TerminologyCapabilitiesExpansionSerializer,
      value.expansion,
    )
    encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, value.codeSearch?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.codeSearch)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      TerminologyCapabilitiesValidateCodeSerializer,
      value.validateCode,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      TerminologyCapabilitiesTranslationSerializer,
      value.translation,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      47 + descriptorOffset,
      TerminologyCapabilitiesClosureSerializer,
      value.closure,
    )
  }
}
