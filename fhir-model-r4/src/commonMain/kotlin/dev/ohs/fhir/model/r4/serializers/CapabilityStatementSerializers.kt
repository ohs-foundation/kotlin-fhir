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
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.FHIRVersion
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
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
import kotlinx.serialization.builtins.nullable
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> version = decoder.decodeStringElement(descriptor, i)
        6 ->
          _version = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 -> releaseDate = decoder.decodeStringElement(descriptor, i)
        8 ->
          _releaseDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Software: " + i)
      }
    }
    return CapabilityStatement.Software(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on CapabilityStatement.Software"
          ),
      version = R4String.of(version, _version),
      releaseDate = DateTime.of(FhirDateTime.fromString(releaseDate), _releaseDate),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CapabilityStatement.Software) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    ((value.releaseDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.releaseDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> url = decoder.decodeStringElement(descriptor, i)
        6 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        7 ->
          custodian =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.custodianSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Implementation: " + i)
      }
    }
    return CapabilityStatement.Implementation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description =
        R4String.of(description, _description)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.description.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.descriptionSer, it)
    }
    (value.custodian)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.custodianSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val custodianSer: KSerializer<Reference> = Reference.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(descriptor, i)
        4 -> _mode = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
        7 ->
          security =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securitySer, null)
        8 ->
          resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        9 ->
          interaction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.interactionSer, null)
        10 ->
          searchParam =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.searchParamSer, null)
        11 ->
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        12 ->
          compartment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.compartmentSer, null)
        13 ->
          _compartment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.compartmentSer2, null)
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
          Canonical.of(compartment?.getOrNull(index)?.let { it }, _compartment?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CapabilityStatement.Rest) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.mode.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.modeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.modeSer, it)
    }
    (value.security)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.securitySer, it)
    }
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.resourceSer, value.resource)
    if (value.interaction.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.interactionSer, value.interaction)
    if (value.searchParam.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.searchParamSer, value.searchParam)
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.operationSer, value.operation)
    (value.compartment.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.compartmentSer, it)
    }
    (value.compartment.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.compartmentSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<Element> = Element.serializer()

    public val securitySer: KSerializer<CapabilityStatement.Rest.Security> =
      CapabilityStatement.Rest.Security.serializer()

    public val resourceSerInner: KSerializer<CapabilityStatement.Rest.Resource> =
      CapabilityStatement.Rest.Resource.serializer()

    public val resourceSer: KSerializer<List<CapabilityStatement.Rest.Resource>> =
      ListSerializer(Hoisted.resourceSerInner)

    public val interactionSerInner: KSerializer<CapabilityStatement.Rest.Interaction> =
      CapabilityStatement.Rest.Interaction.serializer()

    public val interactionSer: KSerializer<List<CapabilityStatement.Rest.Interaction>> =
      ListSerializer(Hoisted.interactionSerInner)

    public val searchParamSerInner: KSerializer<CapabilityStatement.Rest.Resource.SearchParam> =
      CapabilityStatement.Rest.Resource.SearchParam.serializer()

    public val searchParamSer: KSerializer<List<CapabilityStatement.Rest.Resource.SearchParam>> =
      ListSerializer(Hoisted.searchParamSerInner)

    public val operationSerInner: KSerializer<CapabilityStatement.Rest.Resource.Operation> =
      CapabilityStatement.Rest.Resource.Operation.serializer()

    public val operationSer: KSerializer<List<CapabilityStatement.Rest.Resource.Operation>> =
      ListSerializer(Hoisted.operationSerInner)

    public val compartmentSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val compartmentSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.compartmentSerInner).nullable)

    public val compartmentSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.modeSer).nullable)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> cors = decoder.decodeBooleanElement(descriptor, i)
        4 -> _cors = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.corsSer, null)
        5 ->
          service =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.serviceSer, null)
        6 -> description = decoder.decodeStringElement(descriptor, i)
        7 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.corsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Security: " + i)
      }
    }
    return CapabilityStatement.Rest.Security(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      cors = R4Boolean.of(cors, _cors),
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.cors?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.cors?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.corsSer, it)
    }
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.serviceSer, value.service)
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.corsSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val corsSer: KSerializer<Element> = Element.serializer()

    public val serviceSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val serviceSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.serviceSerInner)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> profile = decoder.decodeStringElement(descriptor, i)
        6 ->
          _profile = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          supportedProfile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedProfileSer,
              null,
            )
        8 ->
          _supportedProfile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedProfileSer2,
              null,
            )
        9 -> documentation = decoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        11 ->
          interaction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.interactionSer, null)
        12 -> versioning = decoder.decodeStringElement(descriptor, i)
        13 ->
          _versioning =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 -> readHistory = decoder.decodeBooleanElement(descriptor, i)
        15 ->
          _readHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        16 -> updateCreate = decoder.decodeBooleanElement(descriptor, i)
        17 ->
          _updateCreate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        18 -> conditionalCreate = decoder.decodeBooleanElement(descriptor, i)
        19 ->
          _conditionalCreate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        20 -> conditionalRead = decoder.decodeStringElement(descriptor, i)
        21 ->
          _conditionalRead =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        22 -> conditionalUpdate = decoder.decodeBooleanElement(descriptor, i)
        23 ->
          _conditionalUpdate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        24 -> conditionalDelete = decoder.decodeStringElement(descriptor, i)
        25 ->
          _conditionalDelete =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        26 ->
          referencePolicy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedProfileSer,
              null,
            )
        27 ->
          _referencePolicy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedProfileSer2,
              null,
            )
        28 ->
          searchInclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedProfileSer,
              null,
            )
        29 ->
          _searchInclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedProfileSer2,
              null,
            )
        30 ->
          searchRevInclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedProfileSer,
              null,
            )
        31 ->
          _searchRevInclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedProfileSer2,
              null,
            )
        32 ->
          searchParam =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.searchParamSer, null)
        33 ->
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
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
          )!!
        }),
      documentation = Markdown.of(documentation, _documentation),
      interaction = interaction ?: listOf(),
      versioning =
        Enumeration.of(
          versioning?.let { CapabilityStatement.ResourceVersionPolicy.fromCode(it) },
          _versioning,
        ),
      readHistory = R4Boolean.of(readHistory, _readHistory),
      updateCreate = R4Boolean.of(updateCreate, _updateCreate),
      conditionalCreate = R4Boolean.of(conditionalCreate, _conditionalCreate),
      conditionalRead =
        Enumeration.of(
          conditionalRead?.let { CapabilityStatement.ConditionalReadStatus.fromCode(it) },
          _conditionalRead,
        ),
      conditionalUpdate = R4Boolean.of(conditionalUpdate, _conditionalUpdate),
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
          )!!
        }),
      searchInclude =
        (kotlin.collections.List(maxOf(searchInclude?.size ?: 0, _searchInclude?.size ?: 0)) { index
          ->
          R4String.of(
            searchInclude?.getOrNull(index)?.let { it },
            _searchInclude?.getOrNull(index),
          )!!
        }),
      searchRevInclude =
        (kotlin.collections.List(
          maxOf(searchRevInclude?.size ?: 0, _searchRevInclude?.size ?: 0)
        ) { index ->
          R4String.of(
            searchRevInclude?.getOrNull(index)?.let { it },
            _searchRevInclude?.getOrNull(index),
          )!!
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
    (value.supportedProfile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.supportedProfileSer, it)
    }
    (value.supportedProfile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.supportedProfileSer2, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.typeSer, it)
    }
    if (value.interaction.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.interactionSer, value.interaction)
    ((value.versioning?.value?.code))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.versioning?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.typeSer, it)
    }
    ((value.readHistory?.value))?.let { encoder.encodeBooleanElement(descriptor, 14, it) }
    (value.readHistory?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.typeSer, it)
    }
    ((value.updateCreate?.value))?.let { encoder.encodeBooleanElement(descriptor, 16, it) }
    (value.updateCreate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.typeSer, it)
    }
    ((value.conditionalCreate?.value))?.let { encoder.encodeBooleanElement(descriptor, 18, it) }
    (value.conditionalCreate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.typeSer, it)
    }
    ((value.conditionalRead?.value?.code))?.let { encoder.encodeStringElement(descriptor, 20, it) }
    (value.conditionalRead?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.typeSer, it)
    }
    ((value.conditionalUpdate?.value))?.let { encoder.encodeBooleanElement(descriptor, 22, it) }
    (value.conditionalUpdate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.typeSer, it)
    }
    ((value.conditionalDelete?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 24, it)
    }
    (value.conditionalDelete?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.typeSer, it)
    }
    (value.referencePolicy.map { it.value?.code }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.supportedProfileSer, it)
    }
    (value.referencePolicy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.supportedProfileSer2, it)
    }
    (value.searchInclude.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.supportedProfileSer, it)
    }
    (value.searchInclude.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.supportedProfileSer2, it)
    }
    (value.searchRevInclude.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 30, Hoisted.supportedProfileSer, it)
    }
    (value.searchRevInclude.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 31, Hoisted.supportedProfileSer2, it)
    }
    if (value.searchParam.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 32, Hoisted.searchParamSer, value.searchParam)
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 33, Hoisted.operationSer, value.operation)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val supportedProfileSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val supportedProfileSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.supportedProfileSerInner).nullable)

    public val supportedProfileSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.typeSer).nullable)

    public val interactionSerInner: KSerializer<CapabilityStatement.Rest.Resource.Interaction> =
      CapabilityStatement.Rest.Resource.Interaction.serializer()

    public val interactionSer: KSerializer<List<CapabilityStatement.Rest.Resource.Interaction>> =
      ListSerializer(Hoisted.interactionSerInner)

    public val searchParamSerInner: KSerializer<CapabilityStatement.Rest.Resource.SearchParam> =
      CapabilityStatement.Rest.Resource.SearchParam.serializer()

    public val searchParamSer: KSerializer<List<CapabilityStatement.Rest.Resource.SearchParam>> =
      ListSerializer(Hoisted.searchParamSerInner)

    public val operationSerInner: KSerializer<CapabilityStatement.Rest.Resource.Operation> =
      CapabilityStatement.Rest.Resource.Operation.serializer()

    public val operationSer: KSerializer<List<CapabilityStatement.Rest.Resource.Operation>> =
      ListSerializer(Hoisted.operationSerInner)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.code.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> definition = decoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 -> type = decoder.decodeStringElement(descriptor, i)
        8 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        9 -> documentation = decoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SearchParam: " + i)
      }
    }
    return CapabilityStatement.Rest.Resource.SearchParam(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4String.of(name, _name)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> definition = decoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 -> documentation = decoder.decodeStringElement(descriptor, i)
        8 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + i)
      }
    }
    return CapabilityStatement.Rest.Resource.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4String.of(name, _name)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.definition.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.definition.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.code.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointSer, null)
        4 -> reliableCache = decoder.decodeIntElement(descriptor, i)
        5 ->
          _reliableCache =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reliableCacheSer, null)
        6 -> documentation = decoder.decodeStringElement(descriptor, i)
        7 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reliableCacheSer, null)
        8 ->
          supportedMessage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedMessageSer,
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.endpointSer, value.endpoint)
    ((value.reliableCache?.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
    (value.reliableCache?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.reliableCacheSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.reliableCacheSer, it)
    }
    if (value.supportedMessage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        Hoisted.supportedMessageSer,
        value.supportedMessage,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val endpointSerInner: KSerializer<CapabilityStatement.Messaging.Endpoint> =
      CapabilityStatement.Messaging.Endpoint.serializer()

    public val endpointSer: KSerializer<List<CapabilityStatement.Messaging.Endpoint>> =
      ListSerializer(Hoisted.endpointSerInner)

    public val reliableCacheSer: KSerializer<Element> = Element.serializer()

    public val supportedMessageSerInner:
      KSerializer<CapabilityStatement.Messaging.SupportedMessage> =
      CapabilityStatement.Messaging.SupportedMessage.serializer()

    public val supportedMessageSer:
      KSerializer<List<CapabilityStatement.Messaging.SupportedMessage>> =
      ListSerializer(Hoisted.supportedMessageSerInner)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          protocol =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        4 -> address = decoder.decodeStringElement(descriptor, i)
        5 ->
          _address =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.protocolSer, value.protocol)
    ((value.address.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.address.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.addressSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val protocolSer: KSerializer<Coding> = Coding.serializer()

    public val addressSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(descriptor, i)
        4 -> _mode = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
        5 -> definition = decoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.mode.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.modeSer, it)
    }
    ((value.definition.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.definition.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.modeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(descriptor, i)
        4 -> _mode = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
        5 -> documentation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
        7 -> profile = decoder.decodeStringElement(descriptor, i)
        8 ->
          _profile = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.mode.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.modeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.modeSer, it)
    }
    ((value.profile.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.profile.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.modeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CapabilityStatementSerializer : KSerializer<CapabilityStatement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CapabilityStatement") {
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

  override fun deserialize(decoder: Decoder): CapabilityStatement =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CapabilityStatement")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 -> version = decoder.decodeStringElement(descriptor, i)
        13 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 -> title = decoder.decodeStringElement(descriptor, i)
        17 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        21 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> date = decoder.decodeStringElement(descriptor, i)
        23 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> publisher = decoder.decodeStringElement(descriptor, i)
        25 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        27 -> description = decoder.decodeStringElement(descriptor, i)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        30 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        31 -> purpose = decoder.decodeStringElement(descriptor, i)
        32 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> copyright = decoder.decodeStringElement(descriptor, i)
        34 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> kind = decoder.decodeStringElement(descriptor, i)
        36 ->
          _kind =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 ->
          instantiates =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer, null)
        38 ->
          _instantiates =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer2, null)
        39 ->
          imports =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer, null)
        40 ->
          _imports =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer2, null)
        41 ->
          software =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.softwareSer, null)
        42 ->
          implementation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.implementationSer,
              null,
            )
        43 -> fhirVersion = decoder.decodeStringElement(descriptor, i)
        44 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 ->
          format =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer, null)
        46 ->
          _format =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer2, null)
        47 ->
          patchFormat =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer, null)
        48 ->
          _patchFormat =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer2, null)
        49 ->
          implementationGuide =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer, null)
        50 ->
          _implementationGuide =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instantiatesSer2, null)
        51 -> rest = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.restSer, null)
        52 ->
          messaging =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.messagingSer, null)
        53 ->
          document =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentSer, null)
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on CapabilityStatement"
          ),
      experimental = R4Boolean.of(experimental, _experimental),
      date =
        DateTime.of(FhirDateTime.fromString(date), _date)
          ?: throw SerializationException(
            "Missing required property 'date' on CapabilityStatement"
          ),
      publisher = R4String.of(publisher, _publisher),
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
          Canonical.of(
            instantiates?.getOrNull(index)?.let { it },
            _instantiates?.getOrNull(index),
          )!!
        }),
      imports =
        (kotlin.collections.List(maxOf(imports?.size ?: 0, _imports?.size ?: 0)) { index ->
          Canonical.of(imports?.getOrNull(index)?.let { it }, _imports?.getOrNull(index))!!
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
          Code.of(format?.getOrNull(index)?.let { it }, _format?.getOrNull(index))!!
        }),
      patchFormat =
        (kotlin.collections.List(maxOf(patchFormat?.size ?: 0, _patchFormat?.size ?: 0)) { index ->
          Code.of(patchFormat?.getOrNull(index)?.let { it }, _patchFormat?.getOrNull(index))!!
        }),
      implementationGuide =
        (kotlin.collections.List(
          maxOf(implementationGuide?.size ?: 0, _implementationGuide?.size ?: 0)
        ) { index ->
          Canonical.of(
            implementationGuide?.getOrNull(index)?.let { it },
            _implementationGuide?.getOrNull(index),
          )!!
        }),
      rest = rest ?: listOf(),
      messaging = messaging ?: listOf(),
      document = document ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CapabilityStatement,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.kind.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.instantiates.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.instantiatesSer,
        it,
      )
    }
    (value.instantiates.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.instantiatesSer2,
        it,
      )
    }
    (value.imports.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.instantiatesSer,
        it,
      )
    }
    (value.imports.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.instantiatesSer2,
        it,
      )
    }
    (value.software)?.let {
      encoder.encodeSerializableElement(descriptor, 41 + descriptorOffset, Hoisted.softwareSer, it)
    }
    (value.implementation)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implementationSer,
        it,
      )
    }
    ((value.fhirVersion.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.fhirVersion.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.format.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.instantiatesSer,
        it,
      )
    }
    (value.format.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.instantiatesSer2,
        it,
      )
    }
    (value.patchFormat.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.instantiatesSer,
        it,
      )
    }
    (value.patchFormat.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.instantiatesSer2,
        it,
      )
    }
    (value.implementationGuide.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.instantiatesSer,
        it,
      )
    }
    (value.implementationGuide.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.instantiatesSer2,
        it,
      )
    }
    if (value.rest.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.restSer,
        value.rest,
      )
    if (value.messaging.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.messagingSer,
        value.messaging,
      )
    if (value.document.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.documentSer,
        value.document,
      )
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val instantiatesSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesSerInner).nullable)

    public val instantiatesSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val softwareSer: KSerializer<CapabilityStatement.Software> =
      CapabilityStatement.Software.serializer()

    public val implementationSer: KSerializer<CapabilityStatement.Implementation> =
      CapabilityStatement.Implementation.serializer()

    public val restSerInner: KSerializer<CapabilityStatement.Rest> =
      CapabilityStatement.Rest.serializer()

    public val restSer: KSerializer<List<CapabilityStatement.Rest>> =
      ListSerializer(Hoisted.restSerInner)

    public val messagingSerInner: KSerializer<CapabilityStatement.Messaging> =
      CapabilityStatement.Messaging.serializer()

    public val messagingSer: KSerializer<List<CapabilityStatement.Messaging>> =
      ListSerializer(Hoisted.messagingSerInner)

    public val documentSerInner: KSerializer<CapabilityStatement.Document> =
      CapabilityStatement.Document.serializer()

    public val documentSer: KSerializer<List<CapabilityStatement.Document>> =
      ListSerializer(Hoisted.documentSerInner)
  }
}

internal object CapabilityStatementPolymorphicSerializer : KSerializer<CapabilityStatement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CapabilityStatement") {
      CapabilityStatementSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement) {
    encoder.encodeStructure(descriptor) {
      CapabilityStatementSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement =
    decoder.decodeStructure(descriptor) {
      CapabilityStatementSerializer.deserializeInternal(this, descriptor, 0)
    }
}
