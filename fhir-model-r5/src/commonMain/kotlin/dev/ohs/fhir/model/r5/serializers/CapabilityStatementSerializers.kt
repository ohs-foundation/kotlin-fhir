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
import dev.ohs.fhir.model.r5.CapabilityStatement
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
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.FHIRVersion
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.ResourceType
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
      optionalElement("releaseDate", KotlinString.serializer().descriptor)
      optionalElement("_releaseDate", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Software>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Software =
    decoder.decodeStructure(descriptor) {
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
          7 -> releaseDate = decodeStringElement(descriptor, i)
          8 ->
            _releaseDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Software: " + i)
        }
      }
      CapabilityStatement.Software(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R5String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on CapabilityStatement.Software"
            ),
        version = R5String.of(version, _version),
        releaseDate =
          DateTime.of(
            if (releaseDate != null) FhirDateTime.fromString(releaseDate) else null,
            _releaseDate,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Software) {
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
      encodeStringIfNotNull(descriptor, 7, value.releaseDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.releaseDate)
    }
  }
}

internal object CapabilityStatementImplementationSerializer :
  KSerializer<CapabilityStatement.Implementation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Implementation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
      optionalElement("custodian", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Implementation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Implementation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var url: KotlinString? = null
      var _url: Element? = null
      var custodian: Reference? = null
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
          7 ->
            custodian = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Implementation: " + i)
        }
      }
      CapabilityStatement.Implementation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description =
          Markdown.of(description, _description)
            ?: throw SerializationException(
              "Missing required property 'description' on CapabilityStatement.Implementation"
            ),
        url = Url.of(url, _url),
        custodian = custodian,
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Implementation) {
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
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.custodian)
    }
  }
}

internal object CapabilityStatementRestSerializer : KSerializer<CapabilityStatement.Rest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rest") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
      optionalElement("security", CapabilityStatementRestSecuritySerializer.descriptor)
      optionalElement(
        "resource",
        CapabilityStatementRestResourceSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "interaction",
        CapabilityStatementRestInteractionSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "searchParam",
        CapabilityStatementRestResourceSearchParamSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "operation",
        CapabilityStatementRestResourceOperationSerializer.listSerializer.descriptor,
      )
      optionalElement("compartment", stringNullableListSerializer.descriptor)
      optionalElement("_compartment", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest =
    decoder.decodeStructure(descriptor) {
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
          3 -> mode = decodeStringElement(descriptor, i)
          4 -> _mode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> documentation = decodeStringElement(descriptor, i)
          6 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            security =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementRestSecuritySerializer,
                null,
              )
          8 ->
            resource =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementRestResourceSerializer.listSerializer,
                null,
              )
          9 ->
            interaction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementRestInteractionSerializer.listSerializer,
                null,
              )
          10 ->
            searchParam =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
                null,
              )
          11 ->
            operation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementRestResourceOperationSerializer.listSerializer,
                null,
              )
          12 ->
            compartment =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          13 ->
            _compartment =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Rest: " + i)
        }
      }
      CapabilityStatement.Rest(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        mode =
          Enumeration.of(
            if (mode != null) CapabilityStatement.RestfulCapabilityMode.fromCode(mode) else null,
            _mode,
          )
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
          (kotlin.collections.List(maxOf(compartment?.size ?: 0, _compartment?.size ?: 0)) { index
            ->
            Canonical.of(compartment?.getOrNull(index), _compartment?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'compartment' on CapabilityStatement.Rest has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest) {
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
      encodeStringIfNotNull(descriptor, 3, value.mode.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.mode)
      encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 6, value.documentation)
      encodeSerializableIfNotNull(
        descriptor,
        7,
        CapabilityStatementRestSecuritySerializer,
        value.security,
      )
      if (value.resource.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CapabilityStatementRestResourceSerializer.listSerializer,
          value.resource,
        )
      if (value.interaction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CapabilityStatementRestInteractionSerializer.listSerializer,
          value.interaction,
        )
      if (value.searchParam.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
          value.searchParam,
        )
      if (value.operation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CapabilityStatementRestResourceOperationSerializer.listSerializer,
          value.operation,
        )
      if (value.compartment.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          12,
          stringNullableListSerializer,
          value.compartment.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 13, value.compartment)
      }
    }
  }
}

internal object CapabilityStatementRestSecuritySerializer :
  KSerializer<CapabilityStatement.Rest.Security> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Security") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("cors", KotlinBoolean.serializer().descriptor)
      optionalElement("_cors", ElementSerializer.descriptor)
      optionalElement("service", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Security>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Security =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var cors: KotlinBoolean? = null
      var _cors: Element? = null
      var service: List<CodeableConcept>? = null
      var description: KotlinString? = null
      var _description: Element? = null
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
          3 -> cors = decodeBooleanElement(descriptor, i)
          4 -> _cors = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            service =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 -> description = decodeStringElement(descriptor, i)
          7 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Security: " + i)
        }
      }
      CapabilityStatement.Rest.Security(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        cors = R5Boolean.of(cors, _cors),
        service = service ?: listOf(),
        description = Markdown.of(description, _description),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Security) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.cors?.value)
      encodeElementIfNotNull(descriptor, 4, value.cors)
      if (value.service.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.service,
        )
      encodeStringIfNotNull(descriptor, 6, value.description?.value)
      encodeElementIfNotNull(descriptor, 7, value.description)
    }
  }
}

internal object CapabilityStatementRestResourceSerializer :
  KSerializer<CapabilityStatement.Rest.Resource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("profile", KotlinString.serializer().descriptor)
      optionalElement("_profile", ElementSerializer.descriptor)
      optionalElement("supportedProfile", stringNullableListSerializer.descriptor)
      optionalElement("_supportedProfile", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
      optionalElement(
        "interaction",
        CapabilityStatementRestResourceInteractionSerializer.listSerializer.descriptor,
      )
      optionalElement("versioning", KotlinString.serializer().descriptor)
      optionalElement("_versioning", ElementSerializer.descriptor)
      optionalElement("readHistory", KotlinBoolean.serializer().descriptor)
      optionalElement("_readHistory", ElementSerializer.descriptor)
      optionalElement("updateCreate", KotlinBoolean.serializer().descriptor)
      optionalElement("_updateCreate", ElementSerializer.descriptor)
      optionalElement("conditionalCreate", KotlinBoolean.serializer().descriptor)
      optionalElement("_conditionalCreate", ElementSerializer.descriptor)
      optionalElement("conditionalRead", KotlinString.serializer().descriptor)
      optionalElement("_conditionalRead", ElementSerializer.descriptor)
      optionalElement("conditionalUpdate", KotlinBoolean.serializer().descriptor)
      optionalElement("_conditionalUpdate", ElementSerializer.descriptor)
      optionalElement("conditionalPatch", KotlinBoolean.serializer().descriptor)
      optionalElement("_conditionalPatch", ElementSerializer.descriptor)
      optionalElement("conditionalDelete", KotlinString.serializer().descriptor)
      optionalElement("_conditionalDelete", ElementSerializer.descriptor)
      optionalElement("referencePolicy", stringNullableListSerializer.descriptor)
      optionalElement("_referencePolicy", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("searchInclude", stringNullableListSerializer.descriptor)
      optionalElement("_searchInclude", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("searchRevInclude", stringNullableListSerializer.descriptor)
      optionalElement("_searchRevInclude", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "searchParam",
        CapabilityStatementRestResourceSearchParamSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "operation",
        CapabilityStatementRestResourceOperationSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource =
    decoder.decodeStructure(descriptor) {
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
      var conditionalPatch: KotlinBoolean? = null
      var _conditionalPatch: Element? = null
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
          5 -> profile = decodeStringElement(descriptor, i)
          6 -> _profile = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            supportedProfile =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          8 ->
            _supportedProfile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 -> documentation = decodeStringElement(descriptor, i)
          10 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            interaction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementRestResourceInteractionSerializer.listSerializer,
                null,
              )
          12 -> versioning = decodeStringElement(descriptor, i)
          13 ->
            _versioning = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> readHistory = decodeBooleanElement(descriptor, i)
          15 ->
            _readHistory = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 -> updateCreate = decodeBooleanElement(descriptor, i)
          17 ->
            _updateCreate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 -> conditionalCreate = decodeBooleanElement(descriptor, i)
          19 ->
            _conditionalCreate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          20 -> conditionalRead = decodeStringElement(descriptor, i)
          21 ->
            _conditionalRead =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          22 -> conditionalUpdate = decodeBooleanElement(descriptor, i)
          23 ->
            _conditionalUpdate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 -> conditionalPatch = decodeBooleanElement(descriptor, i)
          25 ->
            _conditionalPatch =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          26 -> conditionalDelete = decodeStringElement(descriptor, i)
          27 ->
            _conditionalDelete =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          28 ->
            referencePolicy =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          29 ->
            _referencePolicy =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          30 ->
            searchInclude =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          31 ->
            _searchInclude =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          32 ->
            searchRevInclude =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          33 ->
            _searchRevInclude =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          34 ->
            searchParam =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
                null,
              )
          35 ->
            operation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementRestResourceOperationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Resource: " + i)
        }
      }
      CapabilityStatement.Rest.Resource(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(if (type != null) ResourceType.fromCode(type) else null, _type)
            ?: throw SerializationException(
              "Missing required property 'type' on CapabilityStatement.Rest.Resource"
            ),
        profile = Canonical.of(profile, _profile),
        supportedProfile =
          (kotlin.collections.List(
            maxOf(supportedProfile?.size ?: 0, _supportedProfile?.size ?: 0)
          ) { index ->
            Canonical.of(supportedProfile?.getOrNull(index), _supportedProfile?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'supportedProfile' on CapabilityStatement.Rest.Resource has neither a value nor an id/extension"
              )
          }),
        documentation = Markdown.of(documentation, _documentation),
        interaction = interaction ?: listOf(),
        versioning =
          Enumeration.of(
            if (versioning != null) CapabilityStatement.ResourceVersionPolicy.fromCode(versioning)
            else null,
            _versioning,
          ),
        readHistory = R5Boolean.of(readHistory, _readHistory),
        updateCreate = R5Boolean.of(updateCreate, _updateCreate),
        conditionalCreate = R5Boolean.of(conditionalCreate, _conditionalCreate),
        conditionalRead =
          Enumeration.of(
            if (conditionalRead != null)
              CapabilityStatement.ConditionalReadStatus.fromCode(conditionalRead)
            else null,
            _conditionalRead,
          ),
        conditionalUpdate = R5Boolean.of(conditionalUpdate, _conditionalUpdate),
        conditionalPatch = R5Boolean.of(conditionalPatch, _conditionalPatch),
        conditionalDelete =
          Enumeration.of(
            if (conditionalDelete != null)
              CapabilityStatement.ConditionalDeleteStatus.fromCode(conditionalDelete)
            else null,
            _conditionalDelete,
          ),
        referencePolicy =
          (kotlin.collections.List(
            maxOf(referencePolicy?.size ?: 0, _referencePolicy?.size ?: 0)
          ) { index ->
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
          (kotlin.collections.List(maxOf(searchInclude?.size ?: 0, _searchInclude?.size ?: 0)) {
            index ->
            R5String.of(searchInclude?.getOrNull(index), _searchInclude?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'searchInclude' on CapabilityStatement.Rest.Resource has neither a value nor an id/extension"
              )
          }),
        searchRevInclude =
          (kotlin.collections.List(
            maxOf(searchRevInclude?.size ?: 0, _searchRevInclude?.size ?: 0)
          ) { index ->
            R5String.of(searchRevInclude?.getOrNull(index), _searchRevInclude?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'searchRevInclude' on CapabilityStatement.Rest.Resource has neither a value nor an id/extension"
              )
          }),
        searchParam = searchParam ?: listOf(),
        operation = operation ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource) {
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
      encodeStringIfNotNull(descriptor, 5, value.profile?.value)
      encodeElementIfNotNull(descriptor, 6, value.profile)
      if (value.supportedProfile.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          stringNullableListSerializer,
          value.supportedProfile.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 8, value.supportedProfile)
      }
      encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 10, value.documentation)
      if (value.interaction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CapabilityStatementRestResourceInteractionSerializer.listSerializer,
          value.interaction,
        )
      encodeStringIfNotNull(descriptor, 12, value.versioning?.value?.code)
      encodeElementIfNotNull(descriptor, 13, value.versioning)
      encodeBooleanIfNotNull(descriptor, 14, value.readHistory?.value)
      encodeElementIfNotNull(descriptor, 15, value.readHistory)
      encodeBooleanIfNotNull(descriptor, 16, value.updateCreate?.value)
      encodeElementIfNotNull(descriptor, 17, value.updateCreate)
      encodeBooleanIfNotNull(descriptor, 18, value.conditionalCreate?.value)
      encodeElementIfNotNull(descriptor, 19, value.conditionalCreate)
      encodeStringIfNotNull(descriptor, 20, value.conditionalRead?.value?.code)
      encodeElementIfNotNull(descriptor, 21, value.conditionalRead)
      encodeBooleanIfNotNull(descriptor, 22, value.conditionalUpdate?.value)
      encodeElementIfNotNull(descriptor, 23, value.conditionalUpdate)
      encodeBooleanIfNotNull(descriptor, 24, value.conditionalPatch?.value)
      encodeElementIfNotNull(descriptor, 25, value.conditionalPatch)
      encodeStringIfNotNull(descriptor, 26, value.conditionalDelete?.value?.code)
      encodeElementIfNotNull(descriptor, 27, value.conditionalDelete)
      if (value.referencePolicy.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          28,
          stringNullableListSerializer,
          value.referencePolicy.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 29, value.referencePolicy)
      }
      if (value.searchInclude.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          30,
          stringNullableListSerializer,
          value.searchInclude.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 31, value.searchInclude)
      }
      if (value.searchRevInclude.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          32,
          stringNullableListSerializer,
          value.searchRevInclude.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 33, value.searchRevInclude)
      }
      if (value.searchParam.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          34,
          CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
          value.searchParam,
        )
      if (value.operation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          35,
          CapabilityStatementRestResourceOperationSerializer.listSerializer,
          value.operation,
        )
    }
  }
}

internal object CapabilityStatementRestResourceInteractionSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.Interaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Interaction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.Interaction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.Interaction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
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
          3 -> code = decodeStringElement(descriptor, i)
          4 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> documentation = decodeStringElement(descriptor, i)
          6 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Interaction: " + i)
        }
      }
      CapabilityStatement.Rest.Resource.Interaction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Enumeration.of(
            if (code != null) CapabilityStatement.TypeRestfulInteraction.fromCode(code) else null,
            _code,
          )
            ?: throw SerializationException(
              "Missing required property 'code' on CapabilityStatement.Rest.Resource.Interaction"
            ),
        documentation = Markdown.of(documentation, _documentation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Interaction) {
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
      encodeStringIfNotNull(descriptor, 3, value.code.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.code)
      encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 6, value.documentation)
    }
  }
}

internal object CapabilityStatementRestResourceSearchParamSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.SearchParam> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SearchParam") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("definition", KotlinString.serializer().descriptor)
      optionalElement("_definition", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.SearchParam>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.SearchParam =
    decoder.decodeStructure(descriptor) {
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
          5 -> definition = decodeStringElement(descriptor, i)
          6 ->
            _definition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> type = decodeStringElement(descriptor, i)
          8 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> documentation = decodeStringElement(descriptor, i)
          10 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SearchParam: " + i)
        }
      }
      CapabilityStatement.Rest.Resource.SearchParam(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R5String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on CapabilityStatement.Rest.Resource.SearchParam"
            ),
        definition = Canonical.of(definition, _definition),
        type =
          Enumeration.of(if (type != null) SearchParamType.fromCode(type) else null, _type)
            ?: throw SerializationException(
              "Missing required property 'type' on CapabilityStatement.Rest.Resource.SearchParam"
            ),
        documentation = Markdown.of(documentation, _documentation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.SearchParam) {
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
      encodeStringIfNotNull(descriptor, 5, value.definition?.value)
      encodeElementIfNotNull(descriptor, 6, value.definition)
      encodeStringIfNotNull(descriptor, 7, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 8, value.type)
      encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 10, value.documentation)
    }
  }
}

internal object CapabilityStatementRestResourceOperationSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("definition", KotlinString.serializer().descriptor)
      optionalElement("_definition", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.Operation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.Operation =
    decoder.decodeStructure(descriptor) {
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
          5 -> definition = decodeStringElement(descriptor, i)
          6 ->
            _definition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> documentation = decodeStringElement(descriptor, i)
          8 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Operation: " + i)
        }
      }
      CapabilityStatement.Rest.Resource.Operation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R5String.of(name, _name)
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

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Operation) {
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
      encodeStringIfNotNull(descriptor, 5, value.definition.value)
      encodeElementIfNotNull(descriptor, 6, value.definition)
      encodeStringIfNotNull(descriptor, 7, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 8, value.documentation)
    }
  }
}

internal object CapabilityStatementRestInteractionSerializer :
  KSerializer<CapabilityStatement.Rest.Interaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Interaction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Interaction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Interaction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
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
          3 -> code = decodeStringElement(descriptor, i)
          4 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> documentation = decodeStringElement(descriptor, i)
          6 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Interaction: " + i)
        }
      }
      CapabilityStatement.Rest.Interaction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Enumeration.of(
            if (code != null) CapabilityStatement.SystemRestfulInteraction.fromCode(code) else null,
            _code,
          )
            ?: throw SerializationException(
              "Missing required property 'code' on CapabilityStatement.Rest.Interaction"
            ),
        documentation = Markdown.of(documentation, _documentation),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Interaction) {
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
      encodeStringIfNotNull(descriptor, 3, value.code.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.code)
      encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 6, value.documentation)
    }
  }
}

internal object CapabilityStatementMessagingSerializer :
  KSerializer<CapabilityStatement.Messaging> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Messaging") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "endpoint",
        CapabilityStatementMessagingEndpointSerializer.listSerializer.descriptor,
      )
      optionalElement("reliableCache", Int.serializer().descriptor)
      optionalElement("_reliableCache", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
      optionalElement(
        "supportedMessage",
        CapabilityStatementMessagingSupportedMessageSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging =
    decoder.decodeStructure(descriptor) {
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
            endpoint =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementMessagingEndpointSerializer.listSerializer,
                null,
              )
          4 -> reliableCache = decodeIntElement(descriptor, i)
          5 ->
            _reliableCache =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> documentation = decodeStringElement(descriptor, i)
          7 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            supportedMessage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CapabilityStatementMessagingSupportedMessageSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Messaging: " + i)
        }
      }
      CapabilityStatement.Messaging(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        endpoint = endpoint ?: listOf(),
        reliableCache = UnsignedInt.of(reliableCache, _reliableCache),
        documentation = Markdown.of(documentation, _documentation),
        supportedMessage = supportedMessage ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging) {
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
      if (value.endpoint.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CapabilityStatementMessagingEndpointSerializer.listSerializer,
          value.endpoint,
        )
      encodeIntIfNotNull(descriptor, 4, value.reliableCache?.value)
      encodeElementIfNotNull(descriptor, 5, value.reliableCache)
      encodeStringIfNotNull(descriptor, 6, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 7, value.documentation)
      if (value.supportedMessage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CapabilityStatementMessagingSupportedMessageSerializer.listSerializer,
          value.supportedMessage,
        )
    }
  }
}

internal object CapabilityStatementMessagingEndpointSerializer :
  KSerializer<CapabilityStatement.Messaging.Endpoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Endpoint") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("protocol", CodingSerializer.descriptor)
      optionalElement("address", KotlinString.serializer().descriptor)
      optionalElement("_address", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging.Endpoint>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging.Endpoint =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var protocol: Coding? = null
      var address: KotlinString? = null
      var _address: Element? = null
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
          3 -> protocol = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 -> address = decodeStringElement(descriptor, i)
          5 -> _address = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Endpoint: " + i)
        }
      }
      CapabilityStatement.Messaging.Endpoint(
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

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging.Endpoint) {
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
      encodeSerializableElement(descriptor, 3, CodingSerializer, value.protocol)
      encodeStringIfNotNull(descriptor, 4, value.address.value)
      encodeElementIfNotNull(descriptor, 5, value.address)
    }
  }
}

internal object CapabilityStatementMessagingSupportedMessageSerializer :
  KSerializer<CapabilityStatement.Messaging.SupportedMessage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportedMessage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
      optionalElement("definition", KotlinString.serializer().descriptor)
      optionalElement("_definition", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging.SupportedMessage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging.SupportedMessage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var mode: KotlinString? = null
      var _mode: Element? = null
      var definition: KotlinString? = null
      var _definition: Element? = null
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
          3 -> mode = decodeStringElement(descriptor, i)
          4 -> _mode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> definition = decodeStringElement(descriptor, i)
          6 ->
            _definition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SupportedMessage: " + i)
        }
      }
      CapabilityStatement.Messaging.SupportedMessage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        mode =
          Enumeration.of(
            if (mode != null) CapabilityStatement.EventCapabilityMode.fromCode(mode) else null,
            _mode,
          )
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

  override fun serialize(
    encoder: Encoder,
    `value`: CapabilityStatement.Messaging.SupportedMessage,
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
      encodeStringIfNotNull(descriptor, 3, value.mode.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.mode)
      encodeStringIfNotNull(descriptor, 5, value.definition.value)
      encodeElementIfNotNull(descriptor, 6, value.definition)
    }
  }
}

internal object CapabilityStatementDocumentSerializer : KSerializer<CapabilityStatement.Document> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Document") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", ElementSerializer.descriptor)
      optionalElement("profile", KotlinString.serializer().descriptor)
      optionalElement("_profile", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CapabilityStatement.Document>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CapabilityStatement.Document =
    decoder.decodeStructure(descriptor) {
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
          3 -> mode = decodeStringElement(descriptor, i)
          4 -> _mode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> documentation = decodeStringElement(descriptor, i)
          6 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> profile = decodeStringElement(descriptor, i)
          8 -> _profile = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Document: " + i)
        }
      }
      CapabilityStatement.Document(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        mode =
          Enumeration.of(
            if (mode != null) CapabilityStatement.DocumentMode.fromCode(mode) else null,
            _mode,
          )
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

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Document) {
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
      encodeStringIfNotNull(descriptor, 3, value.mode.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.mode)
      encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 6, value.documentation)
      encodeStringIfNotNull(descriptor, 7, value.profile.value)
      encodeElementIfNotNull(descriptor, 8, value.profile)
    }
  }
}

internal object CapabilityStatementSerializer : FhirResourceSerializer<CapabilityStatement> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CapabilityStatement")

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
    b.optionalElement("instantiates", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiates", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("imports", stringNullableListSerializer.descriptor)
    b.optionalElement("_imports", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("software", CapabilityStatementSoftwareSerializer.descriptor)
    b.optionalElement("implementation", CapabilityStatementImplementationSerializer.descriptor)
    b.optionalElement("fhirVersion", KotlinString.serializer().descriptor)
    b.optionalElement("_fhirVersion", ElementSerializer.descriptor)
    b.optionalElement("format", stringNullableListSerializer.descriptor)
    b.optionalElement("_format", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("patchFormat", stringNullableListSerializer.descriptor)
    b.optionalElement("_patchFormat", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("acceptLanguage", stringNullableListSerializer.descriptor)
    b.optionalElement("_acceptLanguage", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("implementationGuide", stringNullableListSerializer.descriptor)
    b.optionalElement("_implementationGuide", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("rest", CapabilityStatementRestSerializer.listSerializer.descriptor)
    b.optionalElement("messaging", CapabilityStatementMessagingSerializer.listSerializer.descriptor)
    b.optionalElement("document", CapabilityStatementDocumentSerializer.listSerializer.descriptor)
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
    var acceptLanguage: List<KotlinString?>? = null
    var _acceptLanguage: List<Element?>? = null
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
        41 -> kind = decoder.decodeStringElement(descriptor, i)
        42 ->
          _kind = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          instantiates =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        44 ->
          _instantiates =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        45 ->
          imports =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _imports =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 ->
          software =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementSoftwareSerializer,
              null,
            )
        48 ->
          implementation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementImplementationSerializer,
              null,
            )
        49 -> fhirVersion = decoder.decodeStringElement(descriptor, i)
        50 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        51 ->
          format =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        52 ->
          _format =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        53 ->
          patchFormat =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        54 ->
          _patchFormat =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        55 ->
          acceptLanguage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        56 ->
          _acceptLanguage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        57 ->
          implementationGuide =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        58 ->
          _implementationGuide =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        59 ->
          rest =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestSerializer.listSerializer,
              null,
            )
        60 ->
          messaging =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementMessagingSerializer.listSerializer,
              null,
            )
        61 ->
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
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        CapabilityStatement.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on CapabilityStatement"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      date =
        DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date)
          ?: throw SerializationException(
            "Missing required property 'date' on CapabilityStatement"
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
        Enumeration.of(
          if (kind != null) CapabilityStatement.CapabilityStatementKind.fromCode(kind) else null,
          _kind,
        )
          ?: throw SerializationException(
            "Missing required property 'kind' on CapabilityStatement"
          ),
      instantiates =
        (kotlin.collections.List(maxOf(instantiates?.size ?: 0, _instantiates?.size ?: 0)) { index
          ->
          Canonical.of(instantiates?.getOrNull(index), _instantiates?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiates' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      imports =
        (kotlin.collections.List(maxOf(imports?.size ?: 0, _imports?.size ?: 0)) { index ->
          Canonical.of(imports?.getOrNull(index), _imports?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'imports' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      software = software,
      implementation = implementation,
      fhirVersion =
        Enumeration.of(
          if (fhirVersion != null) FHIRVersion.fromCode(fhirVersion) else null,
          _fhirVersion,
        )
          ?: throw SerializationException(
            "Missing required property 'fhirVersion' on CapabilityStatement"
          ),
      format =
        (kotlin.collections.List(maxOf(format?.size ?: 0, _format?.size ?: 0)) { index ->
          Code.of(format?.getOrNull(index), _format?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'format' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      patchFormat =
        (kotlin.collections.List(maxOf(patchFormat?.size ?: 0, _patchFormat?.size ?: 0)) { index ->
          Code.of(patchFormat?.getOrNull(index), _patchFormat?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'patchFormat' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      acceptLanguage =
        (kotlin.collections.List(maxOf(acceptLanguage?.size ?: 0, _acceptLanguage?.size ?: 0)) {
          index ->
          Code.of(acceptLanguage?.getOrNull(index), _acceptLanguage?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'acceptLanguage' on CapabilityStatement has neither a value nor an id/extension"
            )
        }),
      implementationGuide =
        (kotlin.collections.List(
          maxOf(implementationGuide?.size ?: 0, _implementationGuide?.size ?: 0)
        ) { index ->
          Canonical.of(
            implementationGuide?.getOrNull(index),
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
      is CapabilityStatement.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is CapabilityStatement.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.date.value?.toString())
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
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.kind.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.kind)
    if (value.instantiates.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        43 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiates.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 44 + descriptorOffset, value.instantiates)
    }
    if (value.imports.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        value.imports.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 46 + descriptorOffset, value.imports)
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      47 + descriptorOffset,
      CapabilityStatementSoftwareSerializer,
      value.software,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      48 + descriptorOffset,
      CapabilityStatementImplementationSerializer,
      value.implementation,
    )
    encoder.encodeStringIfNotNull(descriptor, 49 + descriptorOffset, value.fhirVersion.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 50 + descriptorOffset, value.fhirVersion)
    if (value.format.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        51 + descriptorOffset,
        stringNullableListSerializer,
        value.format.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 52 + descriptorOffset, value.format)
    }
    if (value.patchFormat.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        53 + descriptorOffset,
        stringNullableListSerializer,
        value.patchFormat.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 54 + descriptorOffset, value.patchFormat)
    }
    if (value.acceptLanguage.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        55 + descriptorOffset,
        stringNullableListSerializer,
        value.acceptLanguage.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 56 + descriptorOffset, value.acceptLanguage)
    }
    if (value.implementationGuide.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        57 + descriptorOffset,
        stringNullableListSerializer,
        value.implementationGuide.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        58 + descriptorOffset,
        value.implementationGuide,
      )
    }
    if (value.rest.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        CapabilityStatementRestSerializer.listSerializer,
        value.rest,
      )
    if (value.messaging.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        CapabilityStatementMessagingSerializer.listSerializer,
        value.messaging,
      )
    if (value.document.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        61 + descriptorOffset,
        CapabilityStatementDocumentSerializer.listSerializer,
        value.document,
      )
  }
}
