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

internal object TerminologyCapabilitiesSoftwareSerializer :
  FhirSerializer<TerminologyCapabilities.Software> {
  override val descriptor: SerialDescriptor = buildDescriptor("Software", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Software>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("version")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Software {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Software(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R5String.of(name, _name), "TerminologyCapabilities.Software", "name"),
      version = R5String.of(version, _version),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Software) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.version)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TerminologyCapabilitiesImplementationSerializer :
  FhirSerializer<TerminologyCapabilities.Implementation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Implementation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Implementation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.strPrim("url")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Implementation {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Implementation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      description =
        required(
          R5String.of(description, _description),
          "TerminologyCapabilities.Implementation",
          "description",
        ),
      url = Url.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Implementation) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.url)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TerminologyCapabilitiesCodeSystemSerializer :
  FhirSerializer<TerminologyCapabilities.CodeSystem> {
  override val descriptor: SerialDescriptor = buildDescriptor("CodeSystem", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.CodeSystem>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("uri")
    b.optionalElement(
      "version",
      TerminologyCapabilitiesCodeSystemVersionSerializer.listSerializer.descriptor,
    )
    b.strPrim("content")
    b.boolPrim("subsumption")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var version: List<TerminologyCapabilities.CodeSystem.Version>? = null
    var content: CodeSystemContentMode? = null
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
        6 ->
          content =
            CodeSystemContentMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.CodeSystem(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      uri = Canonical.of(uri, _uri),
      version = listOrEmpty(version),
      content =
        required(
          Enumeration.of(content, _content),
          "TerminologyCapabilities.CodeSystem",
          "content",
        ),
      subsumption = R5Boolean.of(subsumption, _subsumption),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.uri?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.uri)
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<TerminologyCapabilities.CodeSystem.Version> {
  override val descriptor: SerialDescriptor = buildDescriptor("Version", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.CodeSystem.Version>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.boolPrim("isDefault")
    b.boolPrim("compositional")
    b.strPrimList("language")
    b.optionalElement(
      "filter",
      TerminologyCapabilitiesCodeSystemVersionFilterSerializer.listSerializer.descriptor,
    )
    b.strPrimList("property")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val language_ =
      List(maxSize(language, _language)) { index ->
        entryRequired(
          Enumeration.of(
            at(language, index)?.let { CommonLanguages.fromCode(it) },
            at(_language, index),
          ),
          "TerminologyCapabilities.CodeSystem.Version",
          "language",
        )
      }
    val property_ =
      List(maxSize(`property`, _property)) { index ->
        entryRequired(
          Code.of(at(`property`, index), at(_property, index)),
          "TerminologyCapabilities.CodeSystem.Version",
          "property",
        )
      }
    return TerminologyCapabilities.CodeSystem.Version(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = R5String.of(code, _code),
      isDefault = R5Boolean.of(isDefault, _isDefault),
      compositional = R5Boolean.of(compositional, _compositional),
      language = language_,
      filter = listOrEmpty(filter),
      `property` = property_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.CodeSystem.Version) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.isDefault?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.isDefault)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, value.compositional?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.compositional)
    if (!value.language.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        stringNullableListSerializer,
        value.language.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.language)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      TerminologyCapabilitiesCodeSystemVersionFilterSerializer.listSerializer,
      value.filter,
    )
    if (!value.`property`.isEmpty()) {
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
  FhirSerializer<TerminologyCapabilities.CodeSystem.Version.Filter> {
  override val descriptor: SerialDescriptor = buildDescriptor("Filter", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<TerminologyCapabilities.CodeSystem.Version.Filter>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrimList("op")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.CodeSystem.Version.Filter {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val op_ =
      List(maxSize(op, _op)) { index ->
        entryRequired(
          Code.of(at(op, index), at(_op, index)),
          "TerminologyCapabilities.CodeSystem.Version.Filter",
          "op",
        )
      }
    return TerminologyCapabilities.CodeSystem.Version.Filter(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code =
        required(Code.of(code, _code), "TerminologyCapabilities.CodeSystem.Version.Filter", "code"),
      op = op_,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: TerminologyCapabilities.CodeSystem.Version.Filter,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    if (!value.op.isEmpty()) {
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
  FhirSerializer<TerminologyCapabilities.Expansion> {
  override val descriptor: SerialDescriptor = buildDescriptor("Expansion", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Expansion>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("hierarchical")
    b.boolPrim("paging")
    b.boolPrim("incomplete")
    b.optionalElement(
      "parameter",
      TerminologyCapabilitiesExpansionParameterSerializer.listSerializer.descriptor,
    )
    b.strPrim("textFilter")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Expansion(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      hierarchical = R5Boolean.of(hierarchical, _hierarchical),
      paging = R5Boolean.of(paging, _paging),
      incomplete = R5Boolean.of(incomplete, _incomplete),
      parameter = listOrEmpty(parameter),
      textFilter = Markdown.of(textFilter, _textFilter),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.hierarchical?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.hierarchical)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.paging?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.paging)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, value.incomplete?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.incomplete)
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<TerminologyCapabilities.Expansion.Parameter> {
  override val descriptor: SerialDescriptor = buildDescriptor("Parameter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Expansion.Parameter>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Expansion.Parameter {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Expansion.Parameter(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Code.of(name, _name), "TerminologyCapabilities.Expansion.Parameter", "name"),
      documentation = R5String.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Expansion.Parameter) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TerminologyCapabilitiesValidateCodeSerializer :
  FhirSerializer<TerminologyCapabilities.ValidateCode> {
  override val descriptor: SerialDescriptor = buildDescriptor("ValidateCode", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.ValidateCode>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("translations")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.ValidateCode {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.ValidateCode(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      translations =
        required(
          R5Boolean.of(translations, _translations),
          "TerminologyCapabilities.ValidateCode",
          "translations",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.ValidateCode) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.translations.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.translations)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TerminologyCapabilitiesTranslationSerializer :
  FhirSerializer<TerminologyCapabilities.Translation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Translation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Translation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("needsMap")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Translation {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Translation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      needsMap =
        required(
          R5Boolean.of(needsMap, _needsMap),
          "TerminologyCapabilities.Translation",
          "needsMap",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Translation) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.needsMap.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.needsMap)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TerminologyCapabilitiesClosureSerializer :
  FhirSerializer<TerminologyCapabilities.Closure> {
  override val descriptor: SerialDescriptor = buildDescriptor("Closure", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TerminologyCapabilities.Closure>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("translation")
  }

  override fun deserialize(decoder: Decoder): TerminologyCapabilities.Closure {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TerminologyCapabilities.Closure(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      translation = R5Boolean.of(translation, _translation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TerminologyCapabilities.Closure) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.translation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.translation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TerminologyCapabilitiesSerializer :
  FhirResourceSerializer<TerminologyCapabilities> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("TerminologyCapabilities")

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
    b.strPrim("kind")
    b.optionalElement("software", TerminologyCapabilitiesSoftwareSerializer.descriptor)
    b.optionalElement("implementation", TerminologyCapabilitiesImplementationSerializer.descriptor)
    b.boolPrim("lockedDate")
    b.optionalElement(
      "codeSystem",
      TerminologyCapabilitiesCodeSystemSerializer.listSerializer.descriptor,
    )
    b.optionalElement("expansion", TerminologyCapabilitiesExpansionSerializer.descriptor)
    b.strPrim("codeSearch")
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
    var kind: CapabilityStatementKind? = null
    var _kind: Element? = null
    var software: TerminologyCapabilities.Software? = null
    var implementation: TerminologyCapabilities.Implementation? = null
    var lockedDate: KotlinBoolean? = null
    var _lockedDate: Element? = null
    var codeSystem: List<TerminologyCapabilities.CodeSystem>? = null
    var expansion: TerminologyCapabilities.Expansion? = null
    var codeSearch: CodeSearchSupport? = null
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
          kind =
            CapabilityStatementKind.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        49 ->
          codeSearch =
            CodeSearchSupport.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    return TerminologyCapabilities(
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
        TerminologyCapabilities.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status = required(Enumeration.of(status, _status), "TerminologyCapabilities", "status"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = required(DateTime.of(date, _date), "TerminologyCapabilities", "date"),
      publisher = R5String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      kind = required(Enumeration.of(kind, _kind), "TerminologyCapabilities", "kind"),
      software = software,
      implementation = implementation,
      lockedDate = R5Boolean.of(lockedDate, _lockedDate),
      codeSystem = listOrEmpty(codeSystem),
      expansion = expansion,
      codeSearch = Enumeration.of(codeSearch, _codeSearch),
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
    compositeEncoder.encodeListIfNotEmpty(
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
