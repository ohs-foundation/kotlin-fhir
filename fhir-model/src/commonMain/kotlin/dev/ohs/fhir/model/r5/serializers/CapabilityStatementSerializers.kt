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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Software) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Software {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> version = decoder.decodeStringElement(__desc, 5)
        6 -> _version = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> releaseDate = decoder.decodeStringElement(__desc, 7)
        8 ->
          _releaseDate = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Software: " + __i)
      }
    }
    return CapabilityStatement.Software(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      version = R5String.of(version, _version),
      releaseDate = DateTime.of(FhirDateTime.fromString(releaseDate), _releaseDate),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CapabilityStatement.Software) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    ((value.releaseDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.releaseDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Implementation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Implementation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var custodian: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> url = decoder.decodeStringElement(__desc, 5)
        6 ->
          _url = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        7 ->
          custodian =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.custodianSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Implementation: " + __i)
      }
    }
    return CapabilityStatement.Implementation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description)!!,
      url = Url.of(url, _url),
      custodian = custodian,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Implementation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    (value.custodian)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.custodianSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Rest {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(__desc, 3)
        4 -> _mode = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.modeSer, null)
        5 -> documentation = decoder.decodeStringElement(__desc, 5)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.modeSer, null)
        7 ->
          security = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.securitySer, null)
        8 ->
          resource = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.resourceSer, null)
        9 ->
          interaction =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.interactionSer, null)
        10 ->
          searchParam =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.searchParamSer, null)
        11 ->
          operation =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.operationSer, null)
        12 ->
          compartment =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.compartmentSer, null)
        13 ->
          _compartment =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.compartmentSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Rest: " + __i)
      }
    }
    return CapabilityStatement.Rest(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = Enumeration.of(CapabilityStatement.RestfulCapabilityMode.fromCode(mode!!), _mode),
      documentation = Markdown.of(documentation, _documentation),
      security = security,
      resource = resource ?: listOf(),
      interaction = interaction ?: listOf(),
      searchParam = searchParam ?: listOf(),
      operation = operation ?: listOf(),
      compartment =
        (kotlin.collections.List(maxOf(compartment?.size ?: 0, _compartment?.size ?: 0)) { __i ->
          Canonical.of(compartment?.getOrNull(__i)?.let { it }, _compartment?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CapabilityStatement.Rest) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.modeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.modeSer, it)
    }
    (value.security)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.securitySer, it) }
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.resourceSer, value.resource)
    if (value.interaction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.interactionSer, value.interaction)
    if (value.searchParam.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.searchParamSer, value.searchParam)
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.operationSer, value.operation)
    (value.compartment.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.compartmentSer, it)
    }
    (value.compartment.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.compartmentSer2, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Security) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Rest.Security {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var cors: KotlinBoolean? = null
    var _cors: Element? = null
    var service: List<CodeableConcept>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> cors = decoder.decodeBooleanElement(__desc, 3)
        4 -> _cors = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.corsSer, null)
        5 ->
          service = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.serviceSer, null)
        6 -> description = decoder.decodeStringElement(__desc, 6)
        7 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.corsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Security: " + __i)
      }
    }
    return CapabilityStatement.Rest.Security(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      cors = R5Boolean.of(cors, _cors),
      service = service ?: listOf(),
      description = Markdown.of(description, _description),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CapabilityStatement.Rest.Security) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.cors?.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.cors?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.corsSer, it)
    }
    if (value.service.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.serviceSer, value.service)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.corsSer, it)
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
      element("conditionalPatch", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_conditionalPatch", Element.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Rest.Resource {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> profile = decoder.decodeStringElement(__desc, 5)
        6 -> _profile = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          supportedProfile =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.supportedProfileSer, null)
        8 ->
          _supportedProfile =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.supportedProfileSer2, null)
        9 -> documentation = decoder.decodeStringElement(__desc, 9)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.typeSer, null)
        11 ->
          interaction =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.interactionSer, null)
        12 -> versioning = decoder.decodeStringElement(__desc, 12)
        13 ->
          _versioning = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.typeSer, null)
        14 -> readHistory = decoder.decodeBooleanElement(__desc, 14)
        15 ->
          _readHistory =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.typeSer, null)
        16 -> updateCreate = decoder.decodeBooleanElement(__desc, 16)
        17 ->
          _updateCreate =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.typeSer, null)
        18 -> conditionalCreate = decoder.decodeBooleanElement(__desc, 18)
        19 ->
          _conditionalCreate =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.typeSer, null)
        20 -> conditionalRead = decoder.decodeStringElement(__desc, 20)
        21 ->
          _conditionalRead =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.typeSer, null)
        22 -> conditionalUpdate = decoder.decodeBooleanElement(__desc, 22)
        23 ->
          _conditionalUpdate =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.typeSer, null)
        24 -> conditionalPatch = decoder.decodeBooleanElement(__desc, 24)
        25 ->
          _conditionalPatch =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.typeSer, null)
        26 -> conditionalDelete = decoder.decodeStringElement(__desc, 26)
        27 ->
          _conditionalDelete =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.typeSer, null)
        28 ->
          referencePolicy =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.supportedProfileSer, null)
        29 ->
          _referencePolicy =
            decoder.decodeNullableSerializableElement(
              __desc,
              29,
              Hoisted.supportedProfileSer2,
              null,
            )
        30 ->
          searchInclude =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.supportedProfileSer, null)
        31 ->
          _searchInclude =
            decoder.decodeNullableSerializableElement(
              __desc,
              31,
              Hoisted.supportedProfileSer2,
              null,
            )
        32 ->
          searchRevInclude =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.supportedProfileSer, null)
        33 ->
          _searchRevInclude =
            decoder.decodeNullableSerializableElement(
              __desc,
              33,
              Hoisted.supportedProfileSer2,
              null,
            )
        34 ->
          searchParam =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.searchParamSer, null)
        35 ->
          operation =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.operationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + __i)
      }
    }
    return CapabilityStatement.Rest.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(ResourceType.fromCode(type!!), _type),
      profile = Canonical.of(profile, _profile),
      supportedProfile =
        (kotlin.collections.List(
          maxOf(supportedProfile?.size ?: 0, _supportedProfile?.size ?: 0)
        ) { __i ->
          Canonical.of(
            supportedProfile?.getOrNull(__i)?.let { it },
            _supportedProfile?.getOrNull(__i),
          )!!
        }),
      documentation = Markdown.of(documentation, _documentation),
      interaction = interaction ?: listOf(),
      versioning =
        versioning?.let {
          Enumeration.of(CapabilityStatement.ResourceVersionPolicy.fromCode(it), _versioning)
        },
      readHistory = R5Boolean.of(readHistory, _readHistory),
      updateCreate = R5Boolean.of(updateCreate, _updateCreate),
      conditionalCreate = R5Boolean.of(conditionalCreate, _conditionalCreate),
      conditionalRead =
        conditionalRead?.let {
          Enumeration.of(CapabilityStatement.ConditionalReadStatus.fromCode(it), _conditionalRead)
        },
      conditionalUpdate = R5Boolean.of(conditionalUpdate, _conditionalUpdate),
      conditionalPatch = R5Boolean.of(conditionalPatch, _conditionalPatch),
      conditionalDelete =
        conditionalDelete?.let {
          Enumeration.of(
            CapabilityStatement.ConditionalDeleteStatus.fromCode(it),
            _conditionalDelete,
          )
        },
      referencePolicy =
        (kotlin.collections.List(maxOf(referencePolicy?.size ?: 0, _referencePolicy?.size ?: 0)) {
          __i ->
          Enumeration.of(
            CapabilityStatement.ReferenceHandlingPolicy.fromCode(referencePolicy?.getOrNull(__i)!!),
            _referencePolicy?.getOrNull(__i),
          )
        }),
      searchInclude =
        (kotlin.collections.List(maxOf(searchInclude?.size ?: 0, _searchInclude?.size ?: 0)) { __i
          ->
          R5String.of(searchInclude?.getOrNull(__i)?.let { it }, _searchInclude?.getOrNull(__i))!!
        }),
      searchRevInclude =
        (kotlin.collections.List(
          maxOf(searchRevInclude?.size ?: 0, _searchRevInclude?.size ?: 0)
        ) { __i ->
          R5String.of(
            searchRevInclude?.getOrNull(__i)?.let { it },
            _searchRevInclude?.getOrNull(__i),
          )!!
        }),
      searchParam = searchParam ?: listOf(),
      operation = operation ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CapabilityStatement.Rest.Resource) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
    (value.supportedProfile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.supportedProfileSer, it)
    }
    (value.supportedProfile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.supportedProfileSer2, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.typeSer, it)
    }
    if (value.interaction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.interactionSer, value.interaction)
    ((value.versioning?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.versioning?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.typeSer, it)
    }
    ((value.readHistory?.value))?.let { encoder.encodeBooleanElement(__desc, 14, it) }
    (value.readHistory?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.typeSer, it)
    }
    ((value.updateCreate?.value))?.let { encoder.encodeBooleanElement(__desc, 16, it) }
    (value.updateCreate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.typeSer, it)
    }
    ((value.conditionalCreate?.value))?.let { encoder.encodeBooleanElement(__desc, 18, it) }
    (value.conditionalCreate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.typeSer, it)
    }
    ((value.conditionalRead?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.conditionalRead?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.typeSer, it)
    }
    ((value.conditionalUpdate?.value))?.let { encoder.encodeBooleanElement(__desc, 22, it) }
    (value.conditionalUpdate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.typeSer, it)
    }
    ((value.conditionalPatch?.value))?.let { encoder.encodeBooleanElement(__desc, 24, it) }
    (value.conditionalPatch?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.typeSer, it)
    }
    ((value.conditionalDelete?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 26, it)
    }
    (value.conditionalDelete?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.typeSer, it)
    }
    (value.referencePolicy.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.supportedProfileSer, it)
    }
    (value.referencePolicy.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.supportedProfileSer2, it)
    }
    (value.searchInclude.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.supportedProfileSer, it)
    }
    (value.searchInclude.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.supportedProfileSer2, it)
    }
    (value.searchRevInclude.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.supportedProfileSer, it)
    }
    (value.searchRevInclude.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.supportedProfileSer2, it)
    }
    if (value.searchParam.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.searchParamSer, value.searchParam)
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.operationSer, value.operation)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Interaction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): CapabilityStatement.Rest.Resource.Interaction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> documentation = decoder.decodeStringElement(__desc, 5)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Interaction: " + __i)
      }
    }
    return CapabilityStatement.Rest.Resource.Interaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(CapabilityStatement.TypeRestfulInteraction.fromCode(code!!), _code),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Resource.Interaction,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.SearchParam) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): CapabilityStatement.Rest.Resource.SearchParam {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> definition = decoder.decodeStringElement(__desc, 5)
        6 ->
          _definition = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> type = decoder.decodeStringElement(__desc, 7)
        8 -> _type = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, 9)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SearchParam: " + __i)
      }
    }
    return CapabilityStatement.Rest.Resource.SearchParam(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      definition = Canonical.of(definition, _definition),
      type = Enumeration.of(SearchParamType.fromCode(type!!), _type),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Resource.SearchParam,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Operation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): CapabilityStatement.Rest.Resource.Operation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> definition = decoder.decodeStringElement(__desc, 5)
        6 ->
          _definition = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> documentation = decoder.decodeStringElement(__desc, 7)
        8 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + __i)
      }
    }
    return CapabilityStatement.Rest.Resource.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      definition = Canonical.of(definition, _definition)!!,
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Resource.Operation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.definition.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.definition.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Interaction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Rest.Interaction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> documentation = decoder.decodeStringElement(__desc, 5)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Interaction: " + __i)
      }
    }
    return CapabilityStatement.Rest.Interaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(CapabilityStatement.SystemRestfulInteraction.fromCode(code!!), _code),
      documentation = Markdown.of(documentation, _documentation),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Rest.Interaction,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Messaging {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          endpoint = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.endpointSer, null)
        4 -> reliableCache = decoder.decodeIntElement(__desc, 4)
        5 ->
          _reliableCache =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.reliableCacheSer, null)
        6 -> documentation = decoder.decodeStringElement(__desc, 6)
        7 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.reliableCacheSer, null)
        8 ->
          supportedMessage =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.supportedMessageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Messaging: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: CapabilityStatement.Messaging) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.endpointSer, value.endpoint)
    ((value.reliableCache?.value))?.let { encoder.encodeIntElement(__desc, 4, it) }
    (value.reliableCache?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.reliableCacheSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.reliableCacheSer, it)
    }
    if (value.supportedMessage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging.Endpoint) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Messaging.Endpoint {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var protocol: Coding? = null
    var address: KotlinString? = null
    var _address: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          protocol = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.protocolSer, null)
        4 -> address = decoder.decodeStringElement(__desc, 4)
        5 ->
          _address = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.addressSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Endpoint: " + __i)
      }
    }
    return CapabilityStatement.Messaging.Endpoint(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      protocol = protocol!!,
      address = Url.of(address, _address)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Messaging.Endpoint,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.protocol)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.protocolSer, it) }
    ((value.address.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.address.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.addressSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: CapabilityStatement.Messaging.SupportedMessage,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): CapabilityStatement.Messaging.SupportedMessage {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(__desc, 3)
        4 -> _mode = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.modeSer, null)
        5 -> definition = decoder.decodeStringElement(__desc, 5)
        6 ->
          _definition = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.modeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportedMessage: " + __i)
      }
    }
    return CapabilityStatement.Messaging.SupportedMessage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = Enumeration.of(CapabilityStatement.EventCapabilityMode.fromCode(mode!!), _mode),
      definition = Canonical.of(definition, _definition)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CapabilityStatement.Messaging.SupportedMessage,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.modeSer, it)
    }
    ((value.definition.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.definition.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.modeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Document) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement.Document {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(__desc, 3)
        4 -> _mode = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.modeSer, null)
        5 -> documentation = decoder.decodeStringElement(__desc, 5)
        6 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.modeSer, null)
        7 -> profile = decoder.decodeStringElement(__desc, 7)
        8 -> _profile = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.modeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Document: " + __i)
      }
    }
    return CapabilityStatement.Document(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = Enumeration.of(CapabilityStatement.DocumentMode.fromCode(mode!!), _mode),
      documentation = Markdown.of(documentation, _documentation),
      profile = Canonical.of(profile, _profile)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CapabilityStatement.Document) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.modeSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.modeSer, it)
    }
    ((value.profile.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.profile.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.modeSer, it)
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
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
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
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
      "acceptLanguage",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_acceptLanguage",
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CapabilityStatement")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CapabilityStatement {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 16)
        17 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        19 -> name = decoder.decodeStringElement(__desc, 19)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> title = decoder.decodeStringElement(__desc, 21)
        22 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> status = decoder.decodeStringElement(__desc, 23)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> experimental = decoder.decodeBooleanElement(__desc, 25)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> date = decoder.decodeStringElement(__desc, 27)
        28 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> publisher = decoder.decodeStringElement(__desc, 29)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.contactSer, null)
        32 -> description = decoder.decodeStringElement(__desc, 32)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.useContextSer, null)
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.jurisdictionSer, null)
        36 -> purpose = decoder.decodeStringElement(__desc, 36)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> copyright = decoder.decodeStringElement(__desc, 38)
        39 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> copyrightLabel = decoder.decodeStringElement(__desc, 40)
        41 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 -> kind = decoder.decodeStringElement(__desc, 42)
        43 ->
          _kind =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 ->
          instantiates =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.instantiatesSer, null)
        45 ->
          _instantiates =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.instantiatesSer2, null)
        46 ->
          imports =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.instantiatesSer, null)
        47 ->
          _imports =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.instantiatesSer2, null)
        48 ->
          software =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.softwareSer, null)
        49 ->
          implementation =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.implementationSer, null)
        50 -> fhirVersion = decoder.decodeStringElement(__desc, 50)
        51 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.implicitRulesSer, null)
        52 ->
          format =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.instantiatesSer, null)
        53 ->
          _format =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.instantiatesSer2, null)
        54 ->
          patchFormat =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.instantiatesSer, null)
        55 ->
          _patchFormat =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.instantiatesSer2, null)
        56 ->
          acceptLanguage =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.instantiatesSer, null)
        57 ->
          _acceptLanguage =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.instantiatesSer2, null)
        58 ->
          implementationGuide =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.instantiatesSer, null)
        59 ->
          _implementationGuide =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.instantiatesSer2, null)
        60 -> rest = decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.restSer, null)
        61 ->
          messaging =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.messagingSer, null)
        62 ->
          document =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.documentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding CapabilityStatement: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date)!!,
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      kind = Enumeration.of(CapabilityStatement.CapabilityStatementKind.fromCode(kind!!), _kind),
      instantiates =
        (kotlin.collections.List(maxOf(instantiates?.size ?: 0, _instantiates?.size ?: 0)) { __i ->
          Canonical.of(instantiates?.getOrNull(__i)?.let { it }, _instantiates?.getOrNull(__i))!!
        }),
      imports =
        (kotlin.collections.List(maxOf(imports?.size ?: 0, _imports?.size ?: 0)) { __i ->
          Canonical.of(imports?.getOrNull(__i)?.let { it }, _imports?.getOrNull(__i))!!
        }),
      software = software,
      implementation = implementation,
      fhirVersion = Enumeration.of(FHIRVersion.fromCode(fhirVersion!!), _fhirVersion),
      format =
        (kotlin.collections.List(maxOf(format?.size ?: 0, _format?.size ?: 0)) { __i ->
          Code.of(format?.getOrNull(__i)?.let { it }, _format?.getOrNull(__i))!!
        }),
      patchFormat =
        (kotlin.collections.List(maxOf(patchFormat?.size ?: 0, _patchFormat?.size ?: 0)) { __i ->
          Code.of(patchFormat?.getOrNull(__i)?.let { it }, _patchFormat?.getOrNull(__i))!!
        }),
      acceptLanguage =
        (kotlin.collections.List(maxOf(acceptLanguage?.size ?: 0, _acceptLanguage?.size ?: 0)) { __i
          ->
          Code.of(acceptLanguage?.getOrNull(__i)?.let { it }, _acceptLanguage?.getOrNull(__i))!!
        }),
      implementationGuide =
        (kotlin.collections.List(
          maxOf(implementationGuide?.size ?: 0, _implementationGuide?.size ?: 0)
        ) { __i ->
          Canonical.of(
            implementationGuide?.getOrNull(__i)?.let { it },
            _implementationGuide?.getOrNull(__i),
          )!!
        }),
      rest = rest ?: listOf(),
      messaging = messaging ?: listOf(),
      document = document ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: CapabilityStatement) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is CapabilityStatement.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is CapabilityStatement.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.versionAlgorithmCodingSer, __d.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 25, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    ((value.kind.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    (value.instantiates.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.instantiatesSer, it)
    }
    (value.instantiates.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.instantiatesSer2, it)
    }
    (value.imports.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.instantiatesSer, it)
    }
    (value.imports.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.instantiatesSer2, it)
    }
    (value.software)?.let { encoder.encodeSerializableElement(__desc, 48, Hoisted.softwareSer, it) }
    (value.implementation)?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.implementationSer, it)
    }
    ((value.fhirVersion.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 50, it) }
    (value.fhirVersion.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 51, Hoisted.implicitRulesSer, it)
    }
    (value.format.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 52, Hoisted.instantiatesSer, it)
    }
    (value.format.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 53, Hoisted.instantiatesSer2, it)
    }
    (value.patchFormat.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 54, Hoisted.instantiatesSer, it)
    }
    (value.patchFormat.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 55, Hoisted.instantiatesSer2, it)
    }
    (value.acceptLanguage.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 56, Hoisted.instantiatesSer, it)
    }
    (value.acceptLanguage.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 57, Hoisted.instantiatesSer2, it)
    }
    (value.implementationGuide.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 58, Hoisted.instantiatesSer, it)
    }
    (value.implementationGuide.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 59, Hoisted.instantiatesSer2, it)
    }
    if (value.rest.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 60, Hoisted.restSer, value.rest)
    if (value.messaging.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 61, Hoisted.messagingSer, value.messaging)
    if (value.document.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 62, Hoisted.documentSer, value.document)
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

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
    encoder.encodeStructure(descriptor) { CapabilityStatementSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement =
    decoder.decodeStructure(descriptor) { CapabilityStatementSerializer.deserializeJson(this) }
}
