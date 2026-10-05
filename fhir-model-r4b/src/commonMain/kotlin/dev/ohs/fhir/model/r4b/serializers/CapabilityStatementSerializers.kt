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
import dev.ohs.fhir.model.r4b.CapabilityStatement
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
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.FHIRVersion
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
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

internal object CapabilityStatementSoftwareSerializer : KSerializer<CapabilityStatement.Software> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Software") {
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
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("releaseDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_releaseDate", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Software>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Software =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Software) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CapabilityStatement.Software {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var releaseDate: KotlinString? = null
    var _releaseDate: Element? = null
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
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> version = decoder.decodeStringElement(descriptor, i)
        6 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> releaseDate = decoder.decodeStringElement(descriptor, i)
        8 ->
          _releaseDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Software: " + i)
      }
    }
    return CapabilityStatement.Software(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on CapabilityStatement.Software"
          ),
      version = R4bString.of(version, _version),
      releaseDate = DateTime.of(releaseDate?.let { FhirDateTime.fromString(it) }, _releaseDate),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CapabilityStatement.Software) {
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.releaseDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.releaseDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementImplementationSerializer :
  KSerializer<CapabilityStatement.Implementation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Implementation") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element("custodian", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Implementation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Implementation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Implementation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CapabilityStatement.Implementation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var custodian: Reference? = null
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
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> url = decoder.decodeStringElement(descriptor, i)
        6 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 ->
          custodian =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Implementation: " + i)
      }
    }
    return CapabilityStatement.Implementation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description =
        R4bString.of(description, _description)
          ?: throw SerializationException(
            "Missing required property 'description' on CapabilityStatement.Implementation"
          ),
      url = Url.of(url, _url),
      custodian = custodian,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Implementation,
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
    ((value.description.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    (value.custodian)?.let {
      encoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, it)
    }
  }
}

internal object CapabilityStatementRestSerializer : KSerializer<CapabilityStatement.Rest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rest") {
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
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element(
        "security",
        lazyDescriptor { CapabilityStatement.Rest.Security.serializer().descriptor },
        isOptional = true,
      )
      element(
        "resource",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Rest.Resource.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "interaction",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Rest.Interaction.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "searchParam",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Rest.Resource.SearchParam.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "operation",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Rest.Resource.Operation.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "compartment",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_compartment",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CapabilityStatement.Rest {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var security: CapabilityStatement.Rest.Security? = null
    var resource: List<CapabilityStatement.Rest.Resource>? = null
    var interaction: List<CapabilityStatement.Rest.Interaction>? = null
    var searchParam: List<CapabilityStatement.Rest.Resource.SearchParam>? = null
    var operation: List<CapabilityStatement.Rest.Resource.Operation>? = null
    var compartment: List<KotlinString?>? = null
    var _compartment: List<Element?>? = null
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
        3 -> mode = decoder.decodeStringElement(descriptor, i)
        4 ->
          _mode = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 ->
          security =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestSecuritySerializer,
              null,
            )
        8 ->
          resource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceSerializer.listSerializer,
              null,
            )
        9 ->
          interaction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestInteractionSerializer.listSerializer,
              null,
            )
        10 ->
          searchParam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
              null,
            )
        11 ->
          operation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceOperationSerializer.listSerializer,
              null,
            )
        12 ->
          compartment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        13 ->
          _compartment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Rest: " + i)
      }
    }
    return CapabilityStatement.Rest(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode =
        Enumeration.of(mode?.let { CapabilityStatement.RestfulCapabilityMode.fromCode(it) }, _mode)
          ?: throw SerializationException(
            "Missing required property 'mode' on CapabilityStatement.Rest"
          ),
      documentation = Markdown.of(documentation, _documentation),
      security = security,
      resource = resource ?: listOf(),
      interaction = interaction ?: listOf(),
      searchParam = searchParam ?: listOf(),
      operation = operation ?: listOf(),
      compartment =
        (kotlin.collections.List(maxOf(compartment?.size ?: 0, _compartment?.size ?: 0)) { index ->
          Canonical.of(compartment?.getOrNull(index)?.let { it }, _compartment?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'compartment' on CapabilityStatement.Rest has neither a value nor an id/extension"
            )
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CapabilityStatement.Rest) {
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
    ((value.mode.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    (value.security)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        7,
        CapabilityStatementRestSecuritySerializer,
        it,
      )
    }
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        CapabilityStatementRestResourceSerializer.listSerializer,
        value.resource,
      )
    if (value.interaction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        CapabilityStatementRestInteractionSerializer.listSerializer,
        value.interaction,
      )
    if (value.searchParam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
        value.searchParam,
      )
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        CapabilityStatementRestResourceOperationSerializer.listSerializer,
        value.operation,
      )
    (value.compartment.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, stringNullableListSerializer, it)
    }
    (value.compartment.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
  }
}

internal object CapabilityStatementRestSecuritySerializer :
  KSerializer<CapabilityStatement.Rest.Security> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Security") {
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
      element("cors", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_cors", Element.serializer().descriptor, isOptional = true)
      element(
        "service",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Security>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Security =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Security) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CapabilityStatement.Rest.Security {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var cors: KotlinBoolean? = null
    var _cors: Element? = null
    var service: List<CodeableConcept>? = null
    var description: KotlinString? = null
    var _description: Element? = null
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
        3 -> cors = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _cors = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          service =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 -> description = decoder.decodeStringElement(descriptor, i)
        7 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Security: " + i)
      }
    }
    return CapabilityStatement.Rest.Security(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      cors = R4bBoolean.of(cors, _cors),
      service = service ?: listOf(),
      description = Markdown.of(description, _description),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Security,
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
    ((value.cors?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.cors?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        CodeableConceptSerializer.listSerializer,
        value.service,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementRestResourceSerializer :
  KSerializer<CapabilityStatement.Rest.Resource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
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
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", Element.serializer().descriptor, isOptional = true)
      element(
        "supportedProfile",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_supportedProfile",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element(
        "interaction",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Rest.Resource.Interaction.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("versioning", KotlinString.serializer().descriptor, isOptional = true)
      element("_versioning", Element.serializer().descriptor, isOptional = true)
      element("readHistory", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_readHistory", Element.serializer().descriptor, isOptional = true)
      element("updateCreate", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_updateCreate", Element.serializer().descriptor, isOptional = true)
      element("conditionalCreate", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_conditionalCreate", Element.serializer().descriptor, isOptional = true)
      element("conditionalRead", KotlinString.serializer().descriptor, isOptional = true)
      element("_conditionalRead", Element.serializer().descriptor, isOptional = true)
      element("conditionalUpdate", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_conditionalUpdate", Element.serializer().descriptor, isOptional = true)
      element("conditionalDelete", KotlinString.serializer().descriptor, isOptional = true)
      element("_conditionalDelete", Element.serializer().descriptor, isOptional = true)
      element(
        "referencePolicy",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_referencePolicy",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "searchInclude",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_searchInclude",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "searchRevInclude",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_searchRevInclude",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "searchParam",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Rest.Resource.SearchParam.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "operation",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Rest.Resource.Operation.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CapabilityStatement.Rest.Resource {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    var supportedProfile: List<KotlinString?>? = null
    var _supportedProfile: List<Element?>? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var interaction: List<CapabilityStatement.Rest.Resource.Interaction>? = null
    var versioning: KotlinString? = null
    var _versioning: Element? = null
    var readHistory: KotlinBoolean? = null
    var _readHistory: Element? = null
    var updateCreate: KotlinBoolean? = null
    var _updateCreate: Element? = null
    var conditionalCreate: KotlinBoolean? = null
    var _conditionalCreate: Element? = null
    var conditionalRead: KotlinString? = null
    var _conditionalRead: Element? = null
    var conditionalUpdate: KotlinBoolean? = null
    var _conditionalUpdate: Element? = null
    var conditionalDelete: KotlinString? = null
    var _conditionalDelete: Element? = null
    var referencePolicy: List<KotlinString?>? = null
    var _referencePolicy: List<Element?>? = null
    var searchInclude: List<KotlinString?>? = null
    var _searchInclude: List<Element?>? = null
    var searchRevInclude: List<KotlinString?>? = null
    var _searchRevInclude: List<Element?>? = null
    var searchParam: List<CapabilityStatement.Rest.Resource.SearchParam>? = null
    var operation: List<CapabilityStatement.Rest.Resource.Operation>? = null
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
        5 -> profile = decoder.decodeStringElement(descriptor, i)
        6 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 ->
          supportedProfile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        8 ->
          _supportedProfile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 -> documentation = decoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 ->
          interaction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceInteractionSerializer.listSerializer,
              null,
            )
        12 -> versioning = decoder.decodeStringElement(descriptor, i)
        13 ->
          _versioning =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> readHistory = decoder.decodeBooleanElement(descriptor, i)
        15 ->
          _readHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> updateCreate = decoder.decodeBooleanElement(descriptor, i)
        17 ->
          _updateCreate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> conditionalCreate = decoder.decodeBooleanElement(descriptor, i)
        19 ->
          _conditionalCreate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> conditionalRead = decoder.decodeStringElement(descriptor, i)
        21 ->
          _conditionalRead =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> conditionalUpdate = decoder.decodeBooleanElement(descriptor, i)
        23 ->
          _conditionalUpdate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> conditionalDelete = decoder.decodeStringElement(descriptor, i)
        25 ->
          _conditionalDelete =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          referencePolicy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        27 ->
          _referencePolicy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        28 ->
          searchInclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        29 ->
          _searchInclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        30 ->
          searchRevInclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        31 ->
          _searchRevInclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        32 ->
          searchParam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
              null,
            )
        33 ->
          operation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceOperationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + i)
      }
    }
    return CapabilityStatement.Rest.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(type?.let { ResourceType.fromCode(it) }, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on CapabilityStatement.Rest.Resource"
          ),
      profile = Canonical.of(profile, _profile),
      supportedProfile =
        (kotlin.collections.List(
          maxOf(supportedProfile?.size ?: 0, _supportedProfile?.size ?: 0)
        ) { index ->
          Canonical.of(
            supportedProfile?.getOrNull(index)?.let { it },
            _supportedProfile?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'supportedProfile' on CapabilityStatement.Rest.Resource has neither a value nor an id/extension"
            )
        }),
      documentation = Markdown.of(documentation, _documentation),
      interaction = interaction ?: listOf(),
      versioning =
        Enumeration.of(
          versioning?.let { CapabilityStatement.ResourceVersionPolicy.fromCode(it) },
          _versioning,
        ),
      readHistory = R4bBoolean.of(readHistory, _readHistory),
      updateCreate = R4bBoolean.of(updateCreate, _updateCreate),
      conditionalCreate = R4bBoolean.of(conditionalCreate, _conditionalCreate),
      conditionalRead =
        Enumeration.of(
          conditionalRead?.let { CapabilityStatement.ConditionalReadStatus.fromCode(it) },
          _conditionalRead,
        ),
      conditionalUpdate = R4bBoolean.of(conditionalUpdate, _conditionalUpdate),
      conditionalDelete =
        Enumeration.of(
          conditionalDelete?.let { CapabilityStatement.ConditionalDeleteStatus.fromCode(it) },
          _conditionalDelete,
        ),
      referencePolicy =
        (kotlin.collections.List(maxOf(referencePolicy?.size ?: 0, _referencePolicy?.size ?: 0)) {
          index ->
          Enumeration.of(
            referencePolicy?.getOrNull(index)?.let {
              CapabilityStatement.ReferenceHandlingPolicy.fromCode(it)
            },
            _referencePolicy?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'referencePolicy' on CapabilityStatement.Rest.Resource has neither a value nor an id/extension"
            )
        }),
      searchInclude =
        (kotlin.collections.List(maxOf(searchInclude?.size ?: 0, _searchInclude?.size ?: 0)) { index
          ->
          R4bString.of(
            searchInclude?.getOrNull(index)?.let { it },
            _searchInclude?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'searchInclude' on CapabilityStatement.Rest.Resource has neither a value nor an id/extension"
            )
        }),
      searchRevInclude =
        (kotlin.collections.List(
          maxOf(searchRevInclude?.size ?: 0, _searchRevInclude?.size ?: 0)
        ) { index ->
          R4bString.of(
            searchRevInclude?.getOrNull(index)?.let { it },
            _searchRevInclude?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'searchRevInclude' on CapabilityStatement.Rest.Resource has neither a value nor an id/extension"
            )
        }),
      searchParam = searchParam ?: listOf(),
      operation = operation ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Resource,
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
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    (value.supportedProfile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, stringNullableListSerializer, it)
    }
    (value.supportedProfile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer.nullableListSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
    if (value.interaction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        CapabilityStatementRestResourceInteractionSerializer.listSerializer,
        value.interaction,
      )
    ((value.versioning?.value?.code))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.versioning?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
    }
    ((value.readHistory?.value))?.let { encoder.encodeBooleanElement(descriptor, 14, it) }
    (value.readHistory?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, ElementSerializer, it)
    }
    ((value.updateCreate?.value))?.let { encoder.encodeBooleanElement(descriptor, 16, it) }
    (value.updateCreate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, ElementSerializer, it)
    }
    ((value.conditionalCreate?.value))?.let { encoder.encodeBooleanElement(descriptor, 18, it) }
    (value.conditionalCreate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19, ElementSerializer, it)
    }
    ((value.conditionalRead?.value?.code))?.let { encoder.encodeStringElement(descriptor, 20, it) }
    (value.conditionalRead?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21, ElementSerializer, it)
    }
    ((value.conditionalUpdate?.value))?.let { encoder.encodeBooleanElement(descriptor, 22, it) }
    (value.conditionalUpdate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23, ElementSerializer, it)
    }
    ((value.conditionalDelete?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 24, it)
    }
    (value.conditionalDelete?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 25, ElementSerializer, it)
    }
    (value.referencePolicy.map { it.value?.code }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 26, stringNullableListSerializer, it)
    }
    (value.referencePolicy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.searchInclude.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 28, stringNullableListSerializer, it)
    }
    (value.searchInclude.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.searchRevInclude.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 30, stringNullableListSerializer, it)
    }
    (value.searchRevInclude.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.searchParam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32,
        CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
        value.searchParam,
      )
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33,
        CapabilityStatementRestResourceOperationSerializer.listSerializer,
        value.operation,
      )
  }
}

internal object CapabilityStatementRestResourceInteractionSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.Interaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Interaction") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.Interaction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.Interaction =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Interaction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CapabilityStatement.Rest.Resource.Interaction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Interaction: " + i)
      }
    }
    return CapabilityStatement.Rest.Resource.Interaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Enumeration.of(code?.let { CapabilityStatement.TypeRestfulInteraction.fromCode(it) }, _code)
          ?: throw SerializationException(
            "Missing required property 'code' on CapabilityStatement.Rest.Resource.Interaction"
          ),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Resource.Interaction,
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
    ((value.code.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementRestResourceSearchParamSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.SearchParam> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SearchParam") {
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
      element("definition", KotlinString.serializer().descriptor, isOptional = true)
      element("_definition", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.SearchParam>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.SearchParam =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.SearchParam) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CapabilityStatement.Rest.Resource.SearchParam {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> definition = decoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> type = decoder.decodeStringElement(descriptor, i)
        8 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 -> documentation = decoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SearchParam: " + i)
      }
    }
    return CapabilityStatement.Rest.Resource.SearchParam(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on CapabilityStatement.Rest.Resource.SearchParam"
          ),
      definition = Canonical.of(definition, _definition),
      type =
        Enumeration.of(type?.let { SearchParamType.fromCode(it) }, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on CapabilityStatement.Rest.Resource.SearchParam"
          ),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Resource.SearchParam,
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementRestResourceOperationSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.Operation> {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("definition", KotlinString.serializer().descriptor, isOptional = true)
      element("_definition", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.Operation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.Operation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Operation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CapabilityStatement.Rest.Resource.Operation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> definition = decoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> documentation = decoder.decodeStringElement(descriptor, i)
        8 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + i)
      }
    }
    return CapabilityStatement.Rest.Resource.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on CapabilityStatement.Rest.Resource.Operation"
          ),
      definition =
        Canonical.of(definition, _definition)
          ?: throw SerializationException(
            "Missing required property 'definition' on CapabilityStatement.Rest.Resource.Operation"
          ),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Resource.Operation,
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.definition.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.definition.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementRestInteractionSerializer :
  KSerializer<CapabilityStatement.Rest.Interaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Interaction") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Interaction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Interaction =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Interaction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CapabilityStatement.Rest.Interaction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Interaction: " + i)
      }
    }
    return CapabilityStatement.Rest.Interaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Enumeration.of(
          code?.let { CapabilityStatement.SystemRestfulInteraction.fromCode(it) },
          _code,
        )
          ?: throw SerializationException(
            "Missing required property 'code' on CapabilityStatement.Rest.Interaction"
          ),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Interaction,
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
    ((value.code.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementMessagingSerializer :
  KSerializer<CapabilityStatement.Messaging> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Messaging") {
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
        "endpoint",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Messaging.Endpoint.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("reliableCache", Int.serializer().descriptor, isOptional = true)
      element("_reliableCache", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element(
        "supportedMessage",
        listSerialDescriptor(
          lazyDescriptor { CapabilityStatement.Messaging.SupportedMessage.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CapabilityStatement.Messaging {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var endpoint: List<CapabilityStatement.Messaging.Endpoint>? = null
    var reliableCache: Int? = null
    var _reliableCache: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var supportedMessage: List<CapabilityStatement.Messaging.SupportedMessage>? = null
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
          endpoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementMessagingEndpointSerializer.listSerializer,
              null,
            )
        4 -> reliableCache = decoder.decodeIntElement(descriptor, i)
        5 ->
          _reliableCache =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> documentation = decoder.decodeStringElement(descriptor, i)
        7 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          supportedMessage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementMessagingSupportedMessageSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Messaging: " + i)
      }
    }
    return CapabilityStatement.Messaging(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      endpoint = endpoint ?: listOf(),
      reliableCache = UnsignedInt.of(reliableCache, _reliableCache),
      documentation = Markdown.of(documentation, _documentation),
      supportedMessage = supportedMessage ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CapabilityStatement.Messaging) {
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
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CapabilityStatementMessagingEndpointSerializer.listSerializer,
        value.endpoint,
      )
    ((value.reliableCache?.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
    (value.reliableCache?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    if (value.supportedMessage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        CapabilityStatementMessagingSupportedMessageSerializer.listSerializer,
        value.supportedMessage,
      )
  }
}

internal object CapabilityStatementMessagingEndpointSerializer :
  KSerializer<CapabilityStatement.Messaging.Endpoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Endpoint") {
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
      element("protocol", Coding.serializer().descriptor, isOptional = true)
      element("address", KotlinString.serializer().descriptor, isOptional = true)
      element("_address", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging.Endpoint>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging.Endpoint =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging.Endpoint) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CapabilityStatement.Messaging.Endpoint {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var protocol: Coding? = null
    var address: KotlinString? = null
    var _address: Element? = null
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
          protocol =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        4 -> address = decoder.decodeStringElement(descriptor, i)
        5 ->
          _address =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Endpoint: " + i)
      }
    }
    return CapabilityStatement.Messaging.Endpoint(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      protocol =
        protocol
          ?: throw SerializationException(
            "Missing required property 'protocol' on CapabilityStatement.Messaging.Endpoint"
          ),
      address =
        Url.of(address, _address)
          ?: throw SerializationException(
            "Missing required property 'address' on CapabilityStatement.Messaging.Endpoint"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Messaging.Endpoint,
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
    encoder.encodeSerializableElement(descriptor, 3, CodingSerializer, value.protocol)
    ((value.address.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.address.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementMessagingSupportedMessageSerializer :
  KSerializer<CapabilityStatement.Messaging.SupportedMessage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportedMessage") {
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
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("definition", KotlinString.serializer().descriptor, isOptional = true)
      element("_definition", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging.SupportedMessage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging.SupportedMessage =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: CapabilityStatement.Messaging.SupportedMessage,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CapabilityStatement.Messaging.SupportedMessage {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
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
        3 -> mode = decoder.decodeStringElement(descriptor, i)
        4 ->
          _mode = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> definition = decoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportedMessage: " + i)
      }
    }
    return CapabilityStatement.Messaging.SupportedMessage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode =
        Enumeration.of(mode?.let { CapabilityStatement.EventCapabilityMode.fromCode(it) }, _mode)
          ?: throw SerializationException(
            "Missing required property 'mode' on CapabilityStatement.Messaging.SupportedMessage"
          ),
      definition =
        Canonical.of(definition, _definition)
          ?: throw SerializationException(
            "Missing required property 'definition' on CapabilityStatement.Messaging.SupportedMessage"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Messaging.SupportedMessage,
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
    ((value.mode.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.definition.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.definition.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementDocumentSerializer : KSerializer<CapabilityStatement.Document> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Document") {
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
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Document>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Document =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Document) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CapabilityStatement.Document {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
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
        3 -> mode = decoder.decodeStringElement(descriptor, i)
        4 ->
          _mode = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> profile = decoder.decodeStringElement(descriptor, i)
        8 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Document: " + i)
      }
    }
    return CapabilityStatement.Document(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode =
        Enumeration.of(mode?.let { CapabilityStatement.DocumentMode.fromCode(it) }, _mode)
          ?: throw SerializationException(
            "Missing required property 'mode' on CapabilityStatement.Document"
          ),
      documentation = Markdown.of(documentation, _documentation),
      profile =
        Canonical.of(profile, _profile)
          ?: throw SerializationException(
            "Missing required property 'profile' on CapabilityStatement.Document"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CapabilityStatement.Document) {
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
    ((value.mode.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.profile.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.profile.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
  }
}

internal object CapabilityStatementSerializer : FhirResourceSerializer<CapabilityStatement> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CapabilityStatement")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
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
    b.element("kind", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_kind", Element.serializer().descriptor, isOptional = true)
    b.element(
      "instantiates",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiates",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "imports",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_imports", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "software",
      lazyDescriptor { CapabilityStatement.Software.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "implementation",
      lazyDescriptor { CapabilityStatement.Implementation.serializer().descriptor },
      isOptional = true,
    )
    b.element("fhirVersion", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_fhirVersion", Element.serializer().descriptor, isOptional = true)
    b.element(
      "format",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_format", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "patchFormat",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_patchFormat",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "implementationGuide",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_implementationGuide",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "rest",
      listSerialDescriptor(lazyDescriptor { CapabilityStatement.Rest.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "messaging",
      listSerialDescriptor(
        lazyDescriptor { CapabilityStatement.Messaging.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "document",
      listSerialDescriptor(lazyDescriptor { CapabilityStatement.Document.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): CapabilityStatement {
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
    var instantiates: List<KotlinString?>? = null
    var _instantiates: List<Element?>? = null
    var imports: List<KotlinString?>? = null
    var _imports: List<Element?>? = null
    var software: CapabilityStatement.Software? = null
    var implementation: CapabilityStatement.Implementation? = null
    var fhirVersion: KotlinString? = null
    var _fhirVersion: Element? = null
    var format: List<KotlinString?>? = null
    var _format: List<Element?>? = null
    var patchFormat: List<KotlinString?>? = null
    var _patchFormat: List<Element?>? = null
    var implementationGuide: List<KotlinString?>? = null
    var _implementationGuide: List<Element?>? = null
    var rest: List<CapabilityStatement.Rest>? = null
    var messaging: List<CapabilityStatement.Messaging>? = null
    var document: List<CapabilityStatement.Document>? = null
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
          instantiates =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        38 ->
          _instantiates =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        39 ->
          imports =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        40 ->
          _imports =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        41 ->
          software =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementSoftwareSerializer,
              null,
            )
        42 ->
          implementation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementImplementationSerializer,
              null,
            )
        43 -> fhirVersion = decoder.decodeStringElement(descriptor, i)
        44 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 ->
          format =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _format =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 ->
          patchFormat =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        48 ->
          _patchFormat =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        49 ->
          implementationGuide =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        50 ->
          _implementationGuide =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        51 ->
          rest =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestSerializer.listSerializer,
              null,
            )
        52 ->
          messaging =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementMessagingSerializer.listSerializer,
              null,
            )
        53 ->
          document =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementDocumentSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding CapabilityStatement: " + i)
      }
    }
    return CapabilityStatement(
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
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on CapabilityStatement"
          ),
      experimental = R4bBoolean.of(experimental, _experimental),
      date =
        DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date)
          ?: throw SerializationException(
            "Missing required property 'date' on CapabilityStatement"
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
          kind?.let { CapabilityStatement.CapabilityStatementKind.fromCode(it) },
          _kind,
        )
          ?: throw SerializationException(
            "Missing required property 'kind' on CapabilityStatement"
          ),
      instantiates =
        (kotlin.collections.List(maxOf(instantiates?.size ?: 0, _instantiates?.size ?: 0)) { index
          ->
          Canonical.of(instantiates?.getOrNull(index)?.let { it }, _instantiates?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiates' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      imports =
        (kotlin.collections.List(maxOf(imports?.size ?: 0, _imports?.size ?: 0)) { index ->
          Canonical.of(imports?.getOrNull(index)?.let { it }, _imports?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'imports' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      software = software,
      implementation = implementation,
      fhirVersion =
        Enumeration.of(fhirVersion?.let { FHIRVersion.fromCode(it) }, _fhirVersion)
          ?: throw SerializationException(
            "Missing required property 'fhirVersion' on CapabilityStatement"
          ),
      format =
        (kotlin.collections.List(maxOf(format?.size ?: 0, _format?.size ?: 0)) { index ->
          Code.of(format?.getOrNull(index)?.let { it }, _format?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'format' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      patchFormat =
        (kotlin.collections.List(maxOf(patchFormat?.size ?: 0, _patchFormat?.size ?: 0)) { index ->
          Code.of(patchFormat?.getOrNull(index)?.let { it }, _patchFormat?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'patchFormat' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      implementationGuide =
        (kotlin.collections.List(
          maxOf(implementationGuide?.size ?: 0, _implementationGuide?.size ?: 0)
        ) { index ->
          Canonical.of(
            implementationGuide?.getOrNull(index)?.let { it },
            _implementationGuide?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'implementationGuide' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      rest = rest ?: listOf(),
      messaging = messaging ?: listOf(),
      document = document ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CapabilityStatement,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, ElementSerializer, it)
    }
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, ElementSerializer, it)
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, ElementSerializer, it)
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, ElementSerializer, it)
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, ElementSerializer, it)
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, ElementSerializer, it)
    }
    ((value.date.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ElementSerializer, it)
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, ElementSerializer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, ElementSerializer, it)
    }
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
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 32 + descriptorOffset, ElementSerializer, it)
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 34 + descriptorOffset, ElementSerializer, it)
    }
    ((value.kind.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 36 + descriptorOffset, ElementSerializer, it)
    }
    (value.instantiates.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.instantiates.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.imports.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.imports.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.software)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        CapabilityStatementSoftwareSerializer,
        it,
      )
    }
    (value.implementation)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        CapabilityStatementImplementationSerializer,
        it,
      )
    }
    ((value.fhirVersion.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.fhirVersion.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 44 + descriptorOffset, ElementSerializer, it)
    }
    (value.format.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.format.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.patchFormat.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.patchFormat.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.implementationGuide.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.implementationGuide.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.rest.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        CapabilityStatementRestSerializer.listSerializer,
        value.rest,
      )
    if (value.messaging.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        CapabilityStatementMessagingSerializer.listSerializer,
        value.messaging,
      )
    if (value.document.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        CapabilityStatementDocumentSerializer.listSerializer,
        value.document,
      )
  }
}
