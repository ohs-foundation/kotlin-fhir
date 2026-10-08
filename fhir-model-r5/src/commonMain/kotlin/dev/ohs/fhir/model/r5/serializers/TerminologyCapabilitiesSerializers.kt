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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.TerminologyCapabilities
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.CapabilityStatementKind
import dev.ohs.fhir.model.r5.terminologies.CodeSearchSupport
import dev.ohs.fhir.model.r5.terminologies.CodeSystemContentMode
import dev.ohs.fhir.model.r5.terminologies.CommonLanguages
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Software {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
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
        5 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Software: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Software(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on TerminologyCapabilities.Software"
          ),
      version = R5String.of(version, _version),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Software) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.version)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Implementation {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
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
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Implementation: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Implementation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description =
        R5String.of(description, _description)
          ?: throw SerializationException(
            "Missing required property 'description' on TerminologyCapabilities.Implementation"
          ),
      url = Url.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Implementation) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.url)
    compositeEncoder.endStructure(descriptor)
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
      optionalElement("content", KotlinString.serializer().descriptor)
      optionalElement("_content", ElementSerializer.descriptor)
      optionalElement("subsumption", KotlinBoolean.serializer().descriptor)
      optionalElement("_subsumption", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TerminologyCapabilities.CodeSystem>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var version: List<TerminologyCapabilities.CodeSystem.Version>? = null
    var content: KotlinString? = null
    var _content: Element? = null
    var subsumption: KotlinBoolean? = null
    var _subsumption: Element? = null
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
        3 -> uri = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _uri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesCodeSystemVersionSerializer.listSerializer,
              null,
            )
        6 -> content = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _content =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> subsumption = compositeDecoder.decodeBooleanElement(descriptor, i)
        9 ->
          _subsumption =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CodeSystem: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.CodeSystem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      uri = Canonical.of(uri, _uri),
      version = version ?: listOf(),
      content =
        Enumeration.of(
          if (content != null) CodeSystemContentMode.fromCode(content) else null,
          _content,
        )
          ?: throw SerializationException(
            "Missing required property 'content' on TerminologyCapabilities.CodeSystem"
          ),
      subsumption = R5Boolean.of(subsumption, _subsumption),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.uri?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.uri)
    if (value.version.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        TerminologyCapabilitiesCodeSystemVersionSerializer.listSerializer,
        value.version,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.content.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.content)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 8, value.subsumption?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.subsumption)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> isDefault = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _isDefault =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> compositional = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _compositional =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        10 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 ->
          filter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesCodeSystemVersionFilterSerializer.listSerializer,
              null,
            )
        12 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        13 ->
          _property =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.CodeSystem.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = R5String.of(code, _code),
      isDefault = R5Boolean.of(isDefault, _isDefault),
      compositional = R5Boolean.of(compositional, _compositional),
      language =
        (kotlin.collections.List(maxOf(language?.size ?: 0, _language?.size ?: 0)) { index ->
          Enumeration.of(
            language?.getOrNull(index)?.let { CommonLanguages.fromCode(it) },
            _language?.getOrNull(index),
          )
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.isDefault?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.isDefault)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, value.compositional?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.compositional)
    if (value.language.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        stringNullableListSerializer,
        value.language.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.language)
    }
    if (value.filter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        TerminologyCapabilitiesCodeSystemVersionFilterSerializer.listSerializer,
        value.filter,
      )
    if (value.`property`.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        12,
        stringNullableListSerializer,
        value.`property`.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 13, value.`property`)
    }
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version.Filter {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var op: List<KotlinString?>? = null
    var _op: List<Element?>? = null
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
        3 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          op =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        6 ->
          _op =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.CodeSystem.Version.Filter(
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    if (value.op.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        stringNullableListSerializer,
        value.op.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.op)
    }
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> hierarchical = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _hierarchical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> paging = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _paging =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> incomplete = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _incomplete =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesExpansionParameterSerializer.listSerializer,
              null,
            )
        10 -> textFilter = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _textFilter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Expansion: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Expansion(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      hierarchical = R5Boolean.of(hierarchical, _hierarchical),
      paging = R5Boolean.of(paging, _paging),
      incomplete = R5Boolean.of(incomplete, _incomplete),
      parameter = parameter ?: listOf(),
      textFilter = Markdown.of(textFilter, _textFilter),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.hierarchical?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.hierarchical)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.paging?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.paging)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, value.incomplete?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.incomplete)
    if (value.parameter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        TerminologyCapabilitiesExpansionParameterSerializer.listSerializer,
        value.parameter,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.textFilter?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.textFilter)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion.Parameter {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        5 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Expansion.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        Code.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on TerminologyCapabilities.Expansion.Parameter"
          ),
      documentation = R5String.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion.Parameter) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.documentation)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.ValidateCode {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var translations: KotlinBoolean? = null
    var _translations: Element? = null
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
        3 -> translations = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _translations =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ValidateCode: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.ValidateCode(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      translations =
        R5Boolean.of(translations, _translations)
          ?: throw SerializationException(
            "Missing required property 'translations' on TerminologyCapabilities.ValidateCode"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.ValidateCode) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.translations.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.translations)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Translation {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var needsMap: KotlinBoolean? = null
    var _needsMap: Element? = null
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
        3 -> needsMap = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _needsMap =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Translation: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Translation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      needsMap =
        R5Boolean.of(needsMap, _needsMap)
          ?: throw SerializationException(
            "Missing required property 'needsMap' on TerminologyCapabilities.Translation"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Translation) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.needsMap.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.needsMap)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Closure {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var translation: KotlinBoolean? = null
    var _translation: Element? = null
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
        3 -> translation = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _translation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Closure: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Closure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      translation = R5Boolean.of(translation, _translation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Closure) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.translation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.translation)
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
        22 -> status = compositeDecoder.decodeStringElement(descriptor, i)
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
        26 -> date = compositeDecoder.decodeStringElement(descriptor, i)
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
        41 -> kind = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _kind =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 ->
          software =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesSoftwareSerializer,
              null,
            )
        44 ->
          implementation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesImplementationSerializer,
              null,
            )
        45 -> lockedDate = compositeDecoder.decodeBooleanElement(descriptor, i)
        46 ->
          _lockedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 ->
          codeSystem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesCodeSystemSerializer.listSerializer,
              null,
            )
        48 ->
          expansion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesExpansionSerializer,
              null,
            )
        49 -> codeSearch = compositeDecoder.decodeStringElement(descriptor, i)
        50 ->
          _codeSearch =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        51 ->
          validateCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesValidateCodeSerializer,
              null,
            )
        52 ->
          translation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TerminologyCapabilitiesTranslationSerializer,
              null,
            )
        53 ->
          closure =
            compositeDecoder.decodeNullableSerializableElement(
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
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        TerminologyCapabilities.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on TerminologyCapabilities"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      date =
        DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date)
          ?: throw SerializationException(
            "Missing required property 'date' on TerminologyCapabilities"
          ),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      kind =
        Enumeration.of(if (kind != null) CapabilityStatementKind.fromCode(kind) else null, _kind)
          ?: throw SerializationException(
            "Missing required property 'kind' on TerminologyCapabilities"
          ),
      software = software,
      implementation = implementation,
      lockedDate = R5Boolean.of(lockedDate, _lockedDate),
      codeSystem = codeSystem ?: listOf(),
      expansion = expansion,
      codeSearch =
        Enumeration.of(
          if (codeSearch != null) CodeSearchSupport.fromCode(codeSearch) else null,
          _codeSearch,
        ),
      validateCode = validateCode,
      translation = translation,
      closure = closure,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TerminologyCapabilities,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is TerminologyCapabilities.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is TerminologyCapabilities.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
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
      value.date.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.kind.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.kind)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      TerminologyCapabilitiesSoftwareSerializer,
      value.software,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      TerminologyCapabilitiesImplementationSerializer,
      value.implementation,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.lockedDate?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.lockedDate)
    if (value.codeSystem.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        TerminologyCapabilitiesCodeSystemSerializer.listSerializer,
        value.codeSystem,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      48 + descriptorOffset,
      TerminologyCapabilitiesExpansionSerializer,
      value.expansion,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      49 + descriptorOffset,
      value.codeSearch?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.codeSearch)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      TerminologyCapabilitiesValidateCodeSerializer,
      value.validateCode,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      52 + descriptorOffset,
      TerminologyCapabilitiesTranslationSerializer,
      value.translation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      53 + descriptorOffset,
      TerminologyCapabilitiesClosureSerializer,
      value.closure,
    )
  }
}
