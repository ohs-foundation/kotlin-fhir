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
import dev.ohs.fhir.model.r4.CapabilityStatement
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.CapabilityStatementKind
import dev.ohs.fhir.model.r4.terminologies.ConditionalDeleteStatus
import dev.ohs.fhir.model.r4.terminologies.ConditionalReadStatus
import dev.ohs.fhir.model.r4.terminologies.DocumentMode
import dev.ohs.fhir.model.r4.terminologies.EventCapabilityMode
import dev.ohs.fhir.model.r4.terminologies.FHIRVersion
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ReferenceHandlingPolicy
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import dev.ohs.fhir.model.r4.terminologies.ResourceVersionPolicy
import dev.ohs.fhir.model.r4.terminologies.RestfulCapabilityMode
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import dev.ohs.fhir.model.r4.terminologies.SystemRestfulInteraction
import dev.ohs.fhir.model.r4.terminologies.TypeRestfulInteraction
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

internal object CapabilityStatementSoftwareSerializer :
  FhirSerializer<CapabilityStatement.Software> {
  override val descriptor: SerialDescriptor = buildDescriptor("Software", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Software>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("version")
    b.strPrim("releaseDate")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Software {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var releaseDate: FhirDateTime? = null
    var _releaseDate: Element? = null
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
        7 ->
          releaseDate = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _releaseDate =
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
    return CapabilityStatement.Software(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R4String.of(name, _name), "CapabilityStatement.Software", "name"),
      version = R4String.of(version, _version),
      releaseDate = DateTime.of(releaseDate, _releaseDate),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Software) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.releaseDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.releaseDate)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementImplementationSerializer :
  FhirSerializer<CapabilityStatement.Implementation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Implementation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Implementation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.strPrim("url")
    b.optionalElement("custodian", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Implementation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var custodian: Reference? = null
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
        7 ->
          custodian =
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
    return CapabilityStatement.Implementation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      description =
        required(
          R4String.of(description, _description),
          "CapabilityStatement.Implementation",
          "description",
        ),
      url = Url.of(url, _url),
      custodian = custodian,
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Implementation) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      ReferenceSerializer,
      value.custodian,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementRestSerializer : FhirSerializer<CapabilityStatement.Rest> {
  override val descriptor: SerialDescriptor = buildDescriptor("Rest", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("mode")
    b.strPrim("documentation")
    b.optionalElement("security", CapabilityStatementRestSecuritySerializer.descriptor)
    b.optionalElement(
      "resource",
      CapabilityStatementRestResourceSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "interaction",
      CapabilityStatementRestInteractionSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "searchParam",
      CapabilityStatementRestResourceSearchParamSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "operation",
      CapabilityStatementRestResourceOperationSerializer.listSerializer.descriptor,
    )
    b.strPrimList("compartment")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: RestfulCapabilityMode? = null
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
          mode = RestfulCapabilityMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _mode =
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
        7 ->
          security =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestSecuritySerializer,
              null,
            )
        8 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceSerializer.listSerializer,
              null,
            )
        9 ->
          interaction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestInteractionSerializer.listSerializer,
              null,
            )
        10 ->
          searchParam =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
              null,
            )
        11 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceOperationSerializer.listSerializer,
              null,
            )
        12 ->
          compartment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        13 ->
          _compartment =
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
    val compartment_ =
      List(maxSize(compartment, _compartment)) { index ->
        entryRequired(
          Canonical.of(at(compartment, index), at(_compartment, index)),
          "CapabilityStatement.Rest",
          "compartment",
        )
      }
    return CapabilityStatement.Rest(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      mode = required(Enumeration.of(mode, _mode), "CapabilityStatement.Rest", "mode"),
      documentation = Markdown.of(documentation, _documentation),
      security = security,
      resource = listOrEmpty(resource),
      interaction = listOrEmpty(interaction),
      searchParam = listOrEmpty(searchParam),
      operation = listOrEmpty(operation),
      compartment = compartment_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.mode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.mode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.documentation)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CapabilityStatementRestSecuritySerializer,
      value.security,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      CapabilityStatementRestResourceSerializer.listSerializer,
      value.resource,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CapabilityStatementRestInteractionSerializer.listSerializer,
      value.interaction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
      value.searchParam,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      CapabilityStatementRestResourceOperationSerializer.listSerializer,
      value.operation,
    )
    if (!value.compartment.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        12,
        stringNullableListSerializer,
        value.compartment.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 13, value.compartment)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementRestSecuritySerializer :
  FhirSerializer<CapabilityStatement.Rest.Security> {
  override val descriptor: SerialDescriptor = buildDescriptor("Security", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Security>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("cors")
    b.optionalElement("service", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("description")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Security {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var cors: KotlinBoolean? = null
    var _cors: Element? = null
    var service: List<CodeableConcept>? = null
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
        3 -> cors = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _cors =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          service =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
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
    return CapabilityStatement.Rest.Security(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      cors = R4Boolean.of(cors, _cors),
      service = listOrEmpty(service),
      description = Markdown.of(description, _description),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Security) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.cors?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.cors)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      CodeableConceptSerializer.listSerializer,
      value.service,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.description)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementRestResourceSerializer :
  FhirSerializer<CapabilityStatement.Rest.Resource> {
  override val descriptor: SerialDescriptor = buildDescriptor("Resource", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("profile")
    b.strPrimList("supportedProfile")
    b.strPrim("documentation")
    b.optionalElement(
      "interaction",
      CapabilityStatementRestResourceInteractionSerializer.listSerializer.descriptor,
    )
    b.strPrim("versioning")
    b.boolPrim("readHistory")
    b.boolPrim("updateCreate")
    b.boolPrim("conditionalCreate")
    b.strPrim("conditionalRead")
    b.boolPrim("conditionalUpdate")
    b.strPrim("conditionalDelete")
    b.strPrimList("referencePolicy")
    b.strPrimList("searchInclude")
    b.strPrimList("searchRevInclude")
    b.optionalElement(
      "searchParam",
      CapabilityStatementRestResourceSearchParamSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "operation",
      CapabilityStatementRestResourceOperationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: ResourceType? = null
    var _type: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    var supportedProfile: List<KotlinString?>? = null
    var _supportedProfile: List<Element?>? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var interaction: List<CapabilityStatement.Rest.Resource.Interaction>? = null
    var versioning: ResourceVersionPolicy? = null
    var _versioning: Element? = null
    var readHistory: KotlinBoolean? = null
    var _readHistory: Element? = null
    var updateCreate: KotlinBoolean? = null
    var _updateCreate: Element? = null
    var conditionalCreate: KotlinBoolean? = null
    var _conditionalCreate: Element? = null
    var conditionalRead: ConditionalReadStatus? = null
    var _conditionalRead: Element? = null
    var conditionalUpdate: KotlinBoolean? = null
    var _conditionalUpdate: Element? = null
    var conditionalDelete: ConditionalDeleteStatus? = null
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
        3 -> type = ResourceType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> profile = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          supportedProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        8 ->
          _supportedProfile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          interaction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceInteractionSerializer.listSerializer,
              null,
            )
        12 ->
          versioning =
            ResourceVersionPolicy.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _versioning =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> readHistory = compositeDecoder.decodeBooleanElement(descriptor, i)
        15 ->
          _readHistory =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> updateCreate = compositeDecoder.decodeBooleanElement(descriptor, i)
        17 ->
          _updateCreate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> conditionalCreate = compositeDecoder.decodeBooleanElement(descriptor, i)
        19 ->
          _conditionalCreate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          conditionalRead =
            ConditionalReadStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _conditionalRead =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> conditionalUpdate = compositeDecoder.decodeBooleanElement(descriptor, i)
        23 ->
          _conditionalUpdate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          conditionalDelete =
            ConditionalDeleteStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        25 ->
          _conditionalDelete =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          referencePolicy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        27 ->
          _referencePolicy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        28 ->
          searchInclude =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        29 ->
          _searchInclude =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        30 ->
          searchRevInclude =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        31 ->
          _searchRevInclude =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        32 ->
          searchParam =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
              null,
            )
        33 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestResourceOperationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val supportedProfile_ =
      List(maxSize(supportedProfile, _supportedProfile)) { index ->
        entryRequired(
          Canonical.of(at(supportedProfile, index), at(_supportedProfile, index)),
          "CapabilityStatement.Rest.Resource",
          "supportedProfile",
        )
      }
    val referencePolicy_ =
      List(maxSize(referencePolicy, _referencePolicy)) { index ->
        entryRequired(
          Enumeration.of(
            at(referencePolicy, index)?.let { ReferenceHandlingPolicy.fromCode(it) },
            at(_referencePolicy, index),
          ),
          "CapabilityStatement.Rest.Resource",
          "referencePolicy",
        )
      }
    val searchInclude_ =
      List(maxSize(searchInclude, _searchInclude)) { index ->
        entryRequired(
          R4String.of(at(searchInclude, index), at(_searchInclude, index)),
          "CapabilityStatement.Rest.Resource",
          "searchInclude",
        )
      }
    val searchRevInclude_ =
      List(maxSize(searchRevInclude, _searchRevInclude)) { index ->
        entryRequired(
          R4String.of(at(searchRevInclude, index), at(_searchRevInclude, index)),
          "CapabilityStatement.Rest.Resource",
          "searchRevInclude",
        )
      }
    return CapabilityStatement.Rest.Resource(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "CapabilityStatement.Rest.Resource", "type"),
      profile = Canonical.of(profile, _profile),
      supportedProfile = supportedProfile_,
      documentation = Markdown.of(documentation, _documentation),
      interaction = listOrEmpty(interaction),
      versioning = Enumeration.of(versioning, _versioning),
      readHistory = R4Boolean.of(readHistory, _readHistory),
      updateCreate = R4Boolean.of(updateCreate, _updateCreate),
      conditionalCreate = R4Boolean.of(conditionalCreate, _conditionalCreate),
      conditionalRead = Enumeration.of(conditionalRead, _conditionalRead),
      conditionalUpdate = R4Boolean.of(conditionalUpdate, _conditionalUpdate),
      conditionalDelete = Enumeration.of(conditionalDelete, _conditionalDelete),
      referencePolicy = referencePolicy_,
      searchInclude = searchInclude_,
      searchRevInclude = searchRevInclude_,
      searchParam = listOrEmpty(searchParam),
      operation = listOrEmpty(operation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.profile?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.profile)
    if (!value.supportedProfile.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        stringNullableListSerializer,
        value.supportedProfile.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.supportedProfile)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      CapabilityStatementRestResourceInteractionSerializer.listSerializer,
      value.interaction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.versioning?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.versioning)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 14, value.readHistory?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.readHistory)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 16, value.updateCreate?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.updateCreate)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 18, value.conditionalCreate?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19, value.conditionalCreate)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20, value.conditionalRead?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21, value.conditionalRead)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 22, value.conditionalUpdate?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 23, value.conditionalUpdate)
    compositeEncoder.encodeStringIfNotNull(descriptor, 24, value.conditionalDelete?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 25, value.conditionalDelete)
    if (!value.referencePolicy.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        26,
        stringNullableListSerializer,
        value.referencePolicy.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 27, value.referencePolicy)
    }
    if (!value.searchInclude.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        28,
        stringNullableListSerializer,
        value.searchInclude.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 29, value.searchInclude)
    }
    if (!value.searchRevInclude.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        30,
        stringNullableListSerializer,
        value.searchRevInclude.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 31, value.searchRevInclude)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32,
      CapabilityStatementRestResourceSearchParamSerializer.listSerializer,
      value.searchParam,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33,
      CapabilityStatementRestResourceOperationSerializer.listSerializer,
      value.operation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementRestResourceInteractionSerializer :
  FhirSerializer<CapabilityStatement.Rest.Resource.Interaction> {
  override val descriptor: SerialDescriptor = buildDescriptor("Interaction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.Interaction>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.Interaction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: TypeRestfulInteraction? = null
    var _code: Element? = null
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
        3 ->
          code =
            TypeRestfulInteraction.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _code =
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
    return CapabilityStatement.Rest.Resource.Interaction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code =
        required(
          Enumeration.of(code, _code),
          "CapabilityStatement.Rest.Resource.Interaction",
          "code",
        ),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Interaction) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementRestResourceSearchParamSerializer :
  FhirSerializer<CapabilityStatement.Rest.Resource.SearchParam> {
  override val descriptor: SerialDescriptor = buildDescriptor("SearchParam", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.SearchParam>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("definition")
    b.strPrim("type")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.SearchParam {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var type: SearchParamType? = null
    var _type: Element? = null
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
        5 -> definition = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> type = SearchParamType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
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
    return CapabilityStatement.Rest.Resource.SearchParam(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name =
        required(R4String.of(name, _name), "CapabilityStatement.Rest.Resource.SearchParam", "name"),
      definition = Canonical.of(definition, _definition),
      type =
        required(
          Enumeration.of(type, _type),
          "CapabilityStatement.Rest.Resource.SearchParam",
          "type",
        ),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.SearchParam) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.definition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.definition)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementRestResourceOperationSerializer :
  FhirSerializer<CapabilityStatement.Rest.Resource.Operation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Operation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Resource.Operation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("definition")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.Operation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        5 -> definition = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
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
    return CapabilityStatement.Rest.Resource.Operation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name =
        required(R4String.of(name, _name), "CapabilityStatement.Rest.Resource.Operation", "name"),
      definition =
        required(
          Canonical.of(definition, _definition),
          "CapabilityStatement.Rest.Resource.Operation",
          "definition",
        ),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Operation) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.definition.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.definition)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementRestInteractionSerializer :
  FhirSerializer<CapabilityStatement.Rest.Interaction> {
  override val descriptor: SerialDescriptor = buildDescriptor("Interaction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Rest.Interaction>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Interaction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: SystemRestfulInteraction? = null
    var _code: Element? = null
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
        3 ->
          code =
            SystemRestfulInteraction.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _code =
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
    return CapabilityStatement.Rest.Interaction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(Enumeration.of(code, _code), "CapabilityStatement.Rest.Interaction", "code"),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Interaction) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementMessagingSerializer :
  FhirSerializer<CapabilityStatement.Messaging> {
  override val descriptor: SerialDescriptor = buildDescriptor("Messaging", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "endpoint",
      CapabilityStatementMessagingEndpointSerializer.listSerializer.descriptor,
    )
    b.intPrim("reliableCache")
    b.strPrim("documentation")
    b.optionalElement(
      "supportedMessage",
      CapabilityStatementMessagingSupportedMessageSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          endpoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementMessagingEndpointSerializer.listSerializer,
              null,
            )
        4 -> reliableCache = compositeDecoder.decodeIntElement(descriptor, i)
        5 ->
          _reliableCache =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          supportedMessage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementMessagingSupportedMessageSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CapabilityStatement.Messaging(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      endpoint = listOrEmpty(endpoint),
      reliableCache = UnsignedInt.of(reliableCache, _reliableCache),
      documentation = Markdown.of(documentation, _documentation),
      supportedMessage = listOrEmpty(supportedMessage),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging) {
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
      CapabilityStatementMessagingEndpointSerializer.listSerializer,
      value.endpoint,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 4, value.reliableCache?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.reliableCache)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.documentation)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      CapabilityStatementMessagingSupportedMessageSerializer.listSerializer,
      value.supportedMessage,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementMessagingEndpointSerializer :
  FhirSerializer<CapabilityStatement.Messaging.Endpoint> {
  override val descriptor: SerialDescriptor = buildDescriptor("Endpoint", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging.Endpoint>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("protocol", CodingSerializer.descriptor)
    b.strPrim("address")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging.Endpoint {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var protocol: Coding? = null
    var address: KotlinString? = null
    var _address: Element? = null
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
          protocol =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        4 -> address = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _address =
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
    return CapabilityStatement.Messaging.Endpoint(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      protocol = required(protocol, "CapabilityStatement.Messaging.Endpoint", "protocol"),
      address =
        required(Url.of(address, _address), "CapabilityStatement.Messaging.Endpoint", "address"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging.Endpoint) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodingSerializer, value.protocol)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.address.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.address)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementMessagingSupportedMessageSerializer :
  FhirSerializer<CapabilityStatement.Messaging.SupportedMessage> {
  override val descriptor: SerialDescriptor = buildDescriptor("SupportedMessage", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Messaging.SupportedMessage>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("mode")
    b.strPrim("definition")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging.SupportedMessage {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: EventCapabilityMode? = null
    var _mode: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
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
          mode = EventCapabilityMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _mode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> definition = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
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
    return CapabilityStatement.Messaging.SupportedMessage(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      mode =
        required(
          Enumeration.of(mode, _mode),
          "CapabilityStatement.Messaging.SupportedMessage",
          "mode",
        ),
      definition =
        required(
          Canonical.of(definition, _definition),
          "CapabilityStatement.Messaging.SupportedMessage",
          "definition",
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: CapabilityStatement.Messaging.SupportedMessage,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.mode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.mode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.definition.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.definition)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementDocumentSerializer :
  FhirSerializer<CapabilityStatement.Document> {
  override val descriptor: SerialDescriptor = buildDescriptor("Document", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CapabilityStatement.Document>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("mode")
    b.strPrim("documentation")
    b.strPrim("profile")
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Document {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: DocumentMode? = null
    var _mode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
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
        3 -> mode = DocumentMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _mode =
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
        7 -> profile = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _profile =
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
    return CapabilityStatement.Document(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      mode = required(Enumeration.of(mode, _mode), "CapabilityStatement.Document", "mode"),
      documentation = Markdown.of(documentation, _documentation),
      profile =
        required(Canonical.of(profile, _profile), "CapabilityStatement.Document", "profile"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Document) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.mode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.mode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.documentation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.profile.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.profile)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CapabilityStatementSerializer : FhirResourceSerializer<CapabilityStatement> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CapabilityStatement")

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
    b.strPrim("version")
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
    b.strPrim("kind")
    b.strPrimList("instantiates")
    b.strPrimList("imports")
    b.optionalElement("software", CapabilityStatementSoftwareSerializer.descriptor)
    b.optionalElement("implementation", CapabilityStatementImplementationSerializer.descriptor)
    b.strPrim("fhirVersion")
    b.strPrimList("format")
    b.strPrimList("patchFormat")
    b.strPrimList("implementationGuide")
    b.optionalElement("rest", CapabilityStatementRestSerializer.listSerializer.descriptor)
    b.optionalElement("messaging", CapabilityStatementMessagingSerializer.listSerializer.descriptor)
    b.optionalElement("document", CapabilityStatementDocumentSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var kind: CapabilityStatementKind? = null
    var _kind: Element? = null
    var instantiates: List<KotlinString?>? = null
    var _instantiates: List<Element?>? = null
    var imports: List<KotlinString?>? = null
    var _imports: List<Element?>? = null
    var software: CapabilityStatement.Software? = null
    var implementation: CapabilityStatement.Implementation? = null
    var fhirVersion: FHIRVersion? = null
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
        12 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        19 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        21 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        23 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        27 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        30 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          kind =
            CapabilityStatementKind.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        36 ->
          _kind =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 ->
          instantiates =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        38 ->
          _instantiates =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        39 ->
          imports =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        40 ->
          _imports =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        41 ->
          software =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementSoftwareSerializer,
              null,
            )
        42 ->
          implementation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementImplementationSerializer,
              null,
            )
        43 ->
          fhirVersion = FHIRVersion.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        44 ->
          _fhirVersion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          format =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _format =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 ->
          patchFormat =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        48 ->
          _patchFormat =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        49 ->
          implementationGuide =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        50 ->
          _implementationGuide =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        51 ->
          rest =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementRestSerializer.listSerializer,
              null,
            )
        52 ->
          messaging =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementMessagingSerializer.listSerializer,
              null,
            )
        53 ->
          document =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CapabilityStatementDocumentSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val instantiates_ =
      List(maxSize(instantiates, _instantiates)) { index ->
        entryRequired(
          Canonical.of(at(instantiates, index), at(_instantiates, index)),
          "CapabilityStatement",
          "instantiates",
        )
      }
    val imports_ =
      List(maxSize(imports, _imports)) { index ->
        entryRequired(
          Canonical.of(at(imports, index), at(_imports, index)),
          "CapabilityStatement",
          "imports",
        )
      }
    val format_ =
      List(maxSize(format, _format)) { index ->
        entryRequired(
          Code.of(at(format, index), at(_format, index)),
          "CapabilityStatement",
          "format",
        )
      }
    val patchFormat_ =
      List(maxSize(patchFormat, _patchFormat)) { index ->
        entryRequired(
          Code.of(at(patchFormat, index), at(_patchFormat, index)),
          "CapabilityStatement",
          "patchFormat",
        )
      }
    val implementationGuide_ =
      List(maxSize(implementationGuide, _implementationGuide)) { index ->
        entryRequired(
          Canonical.of(at(implementationGuide, index), at(_implementationGuide, index)),
          "CapabilityStatement",
          "implementationGuide",
        )
      }
    return CapabilityStatement(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      status = required(Enumeration.of(status, _status), "CapabilityStatement", "status"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = required(DateTime.of(date, _date), "CapabilityStatement", "date"),
      publisher = R4String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      kind = required(Enumeration.of(kind, _kind), "CapabilityStatement", "kind"),
      instantiates = instantiates_,
      imports = imports_,
      software = software,
      implementation = implementation,
      fhirVersion =
        required(Enumeration.of(fhirVersion, _fhirVersion), "CapabilityStatement", "fhirVersion"),
      format = format_,
      patchFormat = patchFormat_,
      implementationGuide = implementationGuide_,
      rest = listOrEmpty(rest),
      messaging = listOrEmpty(messaging),
      document = listOrEmpty(document),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CapabilityStatement,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.date.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      26 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.kind.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.kind)
    if (!value.instantiates.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        37 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiates.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        38 + descriptorOffset,
        value.instantiates,
      )
    }
    if (!value.imports.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        39 + descriptorOffset,
        stringNullableListSerializer,
        value.imports.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 40 + descriptorOffset, value.imports)
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      CapabilityStatementSoftwareSerializer,
      value.software,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      CapabilityStatementImplementationSerializer,
      value.implementation,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.fhirVersion.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.fhirVersion)
    if (!value.format.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        value.format.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 46 + descriptorOffset, value.format)
    }
    if (!value.patchFormat.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        47 + descriptorOffset,
        stringNullableListSerializer,
        value.patchFormat.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        48 + descriptorOffset,
        value.patchFormat,
      )
    }
    if (!value.implementationGuide.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        49 + descriptorOffset,
        stringNullableListSerializer,
        value.implementationGuide.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        50 + descriptorOffset,
        value.implementationGuide,
      )
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51 + descriptorOffset,
      CapabilityStatementRestSerializer.listSerializer,
      value.rest,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      52 + descriptorOffset,
      CapabilityStatementMessagingSerializer.listSerializer,
      value.messaging,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      53 + descriptorOffset,
      CapabilityStatementDocumentSerializer.listSerializer,
      value.document,
    )
  }
}
