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
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.ExtensibleEnumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.ImplementationGuide
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.FHIRVersion
import dev.ohs.fhir.model.r4.terminologies.GuidePageGeneration
import dev.ohs.fhir.model.r4.terminologies.GuideParameterCode
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import dev.ohs.fhir.model.r4.terminologies.SPDXLicense
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

internal object ImplementationGuideDependsOnSerializer :
  FhirSerializer<ImplementationGuide.DependsOn> {
  override val descriptor: SerialDescriptor = buildDescriptor("DependsOn", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.DependsOn>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("uri")
    b.strPrim("packageId")
    b.strPrim("version")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.DependsOn {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var packageId: KotlinString? = null
    var _packageId: Element? = null
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
        3 -> uri = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _uri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> packageId = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _packageId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
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
    return ImplementationGuide.DependsOn(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      uri = required(Canonical.of(uri, _uri), "ImplementationGuide.DependsOn", "uri"),
      packageId = Id.of(packageId, _packageId),
      version = R4String.of(version, _version),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.DependsOn) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.uri.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.uri)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.packageId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.packageId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.version)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideGlobalSerializer : FhirSerializer<ImplementationGuide.Global> {
  override val descriptor: SerialDescriptor = buildDescriptor("Global", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Global>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("profile")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Global {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: ResourceType? = null
    var _type: Element? = null
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
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ImplementationGuide.Global(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "ImplementationGuide.Global", "type"),
      profile = required(Canonical.of(profile, _profile), "ImplementationGuide.Global", "profile"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Global) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.profile.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.profile)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideDefinitionSerializer :
  FhirSerializer<ImplementationGuide.Definition> {
  override val descriptor: SerialDescriptor = buildDescriptor("Definition", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "grouping",
      ImplementationGuideDefinitionGroupingSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "resource",
      ImplementationGuideDefinitionResourceSerializer.listSerializer.descriptor,
    )
    b.optionalElement("page", ImplementationGuideDefinitionPageSerializer.descriptor)
    b.optionalElement(
      "parameter",
      ImplementationGuideDefinitionParameterSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "template",
      ImplementationGuideDefinitionTemplateSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var grouping: List<ImplementationGuide.Definition.Grouping>? = null
    var resource: List<ImplementationGuide.Definition.Resource>? = null
    var page: ImplementationGuide.Definition.Page? = null
    var parameter: List<ImplementationGuide.Definition.Parameter>? = null
    var template: List<ImplementationGuide.Definition.Template>? = null
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
          grouping =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDefinitionGroupingSerializer.listSerializer,
              null,
            )
        4 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDefinitionResourceSerializer.listSerializer,
              null,
            )
        5 ->
          page =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDefinitionPageSerializer,
              null,
            )
        6 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDefinitionParameterSerializer.listSerializer,
              null,
            )
        7 ->
          template =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDefinitionTemplateSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ImplementationGuide.Definition(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      grouping = listOrEmpty(grouping),
      resource = listOrEmpty(resource),
      page = page,
      parameter = listOrEmpty(parameter),
      template = listOrEmpty(template),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition) {
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
      ImplementationGuideDefinitionGroupingSerializer.listSerializer,
      value.grouping,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      ImplementationGuideDefinitionResourceSerializer.listSerializer,
      value.resource,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      ImplementationGuideDefinitionPageSerializer,
      value.page,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      ImplementationGuideDefinitionParameterSerializer.listSerializer,
      value.parameter,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ImplementationGuideDefinitionTemplateSerializer.listSerializer,
      value.template,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideDefinitionGroupingSerializer :
  FhirSerializer<ImplementationGuide.Definition.Grouping> {
  override val descriptor: SerialDescriptor = buildDescriptor("Grouping", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Grouping>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("description")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Grouping {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
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
    return ImplementationGuide.Definition.Grouping(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R4String.of(name, _name), "ImplementationGuide.Definition.Grouping", "name"),
      description = R4String.of(description, _description),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Grouping) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideDefinitionResourceSerializer :
  FhirSerializer<ImplementationGuide.Definition.Resource> {
  override val descriptor: SerialDescriptor = buildDescriptor("Resource", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Resource>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("reference", ReferenceSerializer.descriptor)
    b.strPrimList("fhirVersion")
    b.strPrim("name")
    b.strPrim("description")
    b.boolPrim("exampleBoolean")
    b.strPrim("exampleCanonical")
    b.strPrim("groupingId")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Resource {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var fhirVersion: List<KotlinString?>? = null
    var _fhirVersion: List<Element?>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var exampleBoolean: KotlinBoolean? = null
    var _exampleBoolean: Element? = null
    var exampleCanonical: KotlinString? = null
    var _exampleCanonical: Element? = null
    var groupingId: KotlinString? = null
    var _groupingId: Element? = null
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
          reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          fhirVersion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        5 ->
          _fhirVersion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        6 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> exampleBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _exampleBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> exampleCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _exampleCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> groupingId = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _groupingId =
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
    val fhirVersion_ =
      List(maxSize(fhirVersion, _fhirVersion)) { index ->
        entryRequired(
          Enumeration.of(
            at(fhirVersion, index)?.let { FHIRVersion.fromCode(it) },
            at(_fhirVersion, index),
          ),
          "ImplementationGuide.Definition.Resource",
          "fhirVersion",
        )
      }
    return ImplementationGuide.Definition.Resource(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      reference = required(reference, "ImplementationGuide.Definition.Resource", "reference"),
      fhirVersion = fhirVersion_,
      name = R4String.of(name, _name),
      description = R4String.of(description, _description),
      example =
        ImplementationGuide.Definition.Resource.Example.from(
          R4Boolean.of(exampleBoolean, _exampleBoolean),
          Canonical.of(exampleCanonical, _exampleCanonical),
        ),
      groupingId = Id.of(groupingId, _groupingId),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Resource) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.reference)
    if (!value.fhirVersion.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        4,
        stringNullableListSerializer,
        value.fhirVersion.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 5, value.fhirVersion)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.description)
    when (val choice = value.example) {
      null -> {}
      is ImplementationGuide.Definition.Resource.Example.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is ImplementationGuide.Definition.Resource.Example.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 14, value.groupingId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.groupingId)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideDefinitionPageSerializer :
  FhirSerializer<ImplementationGuide.Definition.Page> {
  override val descriptor: SerialDescriptor = buildDescriptor("Page", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Page>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("nameUrl")
    b.optionalElement("nameReference", ReferenceSerializer.descriptor)
    b.strPrim("title")
    b.strPrim("generation")
    b.optionalElement(
      "page",
      listSerialDescriptor(
        lazyDescriptor(LazyDescriptorId.ImplementationGuideDefinitionPageSerializer)
      ),
    )
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Page {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var nameUrl: KotlinString? = null
    var _nameUrl: Element? = null
    var nameReference: Reference? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var generation: GuidePageGeneration? = null
    var _generation: Element? = null
    var page: List<ImplementationGuide.Definition.Page>? = null
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
        3 -> nameUrl = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _nameUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          nameReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          generation =
            GuidePageGeneration.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        9 ->
          _generation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          page =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDefinitionPageSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ImplementationGuide.Definition.Page(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name =
        required(
          ImplementationGuide.Definition.Page.Name.from(Url.of(nameUrl, _nameUrl), nameReference),
          "ImplementationGuide.Definition.Page",
          "name",
        ),
      title = required(R4String.of(title, _title), "ImplementationGuide.Definition.Page", "title"),
      generation =
        required(
          Enumeration.of(generation, _generation),
          "ImplementationGuide.Definition.Page",
          "generation",
        ),
      page = listOrEmpty(page),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Page) {
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
    when (val choice = value.name) {
      is ImplementationGuide.Definition.Page.Name.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is ImplementationGuide.Definition.Page.Name.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.title.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.generation.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.generation)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      ImplementationGuideDefinitionPageSerializer.listSerializer,
      value.page,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideDefinitionParameterSerializer :
  FhirSerializer<ImplementationGuide.Definition.Parameter> {
  override val descriptor: SerialDescriptor = buildDescriptor("Parameter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Parameter>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrim("value")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Parameter {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: GuideParameterCode? = null
    var _code: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
        3 -> code = GuideParameterCode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _value =
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
    return ImplementationGuide.Definition.Parameter(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code =
        required(Enumeration.of(code, _code), "ImplementationGuide.Definition.Parameter", "code"),
      `value` =
        required(R4String.of(`value`, _value), "ImplementationGuide.Definition.Parameter", "value"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Parameter) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideDefinitionTemplateSerializer :
  FhirSerializer<ImplementationGuide.Definition.Template> {
  override val descriptor: SerialDescriptor = buildDescriptor("Template", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Template>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrim("source")
    b.strPrim("scope")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Template {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var scope: KotlinString? = null
    var _scope: Element? = null
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
        5 -> source = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> scope = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _scope =
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
    return ImplementationGuide.Definition.Template(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(Code.of(code, _code), "ImplementationGuide.Definition.Template", "code"),
      source =
        required(R4String.of(source, _source), "ImplementationGuide.Definition.Template", "source"),
      scope = R4String.of(scope, _scope),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Template) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.source.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.source)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.scope?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.scope)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideManifestSerializer :
  FhirSerializer<ImplementationGuide.Manifest> {
  override val descriptor: SerialDescriptor = buildDescriptor("Manifest", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Manifest>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("rendering")
    b.optionalElement(
      "resource",
      ImplementationGuideManifestResourceSerializer.listSerializer.descriptor,
    )
    b.optionalElement("page", ImplementationGuideManifestPageSerializer.listSerializer.descriptor)
    b.strPrimList("image")
    b.strPrimList("other")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var rendering: KotlinString? = null
    var _rendering: Element? = null
    var resource: List<ImplementationGuide.Manifest.Resource>? = null
    var page: List<ImplementationGuide.Manifest.Page>? = null
    var image: List<KotlinString?>? = null
    var _image: List<Element?>? = null
    var other: List<KotlinString?>? = null
    var _other: List<Element?>? = null
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
        3 -> rendering = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _rendering =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideManifestResourceSerializer.listSerializer,
              null,
            )
        6 ->
          page =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideManifestPageSerializer.listSerializer,
              null,
            )
        7 ->
          image =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        8 ->
          _image =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 ->
          other =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        10 ->
          _other =
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
    val image_ =
      List(maxSize(image, _image)) { index ->
        entryRequired(
          R4String.of(at(image, index), at(_image, index)),
          "ImplementationGuide.Manifest",
          "image",
        )
      }
    val other_ =
      List(maxSize(other, _other)) { index ->
        entryRequired(
          R4String.of(at(other, index), at(_other, index)),
          "ImplementationGuide.Manifest",
          "other",
        )
      }
    return ImplementationGuide.Manifest(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      rendering = Url.of(rendering, _rendering),
      resource = listOrEmpty(resource),
      page = listOrEmpty(page),
      image = image_,
      other = other_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.rendering?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.rendering)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      ImplementationGuideManifestResourceSerializer.listSerializer,
      value.resource,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      ImplementationGuideManifestPageSerializer.listSerializer,
      value.page,
    )
    if (!value.image.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        stringNullableListSerializer,
        value.image.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.image)
    }
    if (!value.other.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        stringNullableListSerializer,
        value.other.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.other)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideManifestResourceSerializer :
  FhirSerializer<ImplementationGuide.Manifest.Resource> {
  override val descriptor: SerialDescriptor = buildDescriptor("Resource", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Manifest.Resource>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("reference", ReferenceSerializer.descriptor)
    b.boolPrim("exampleBoolean")
    b.strPrim("exampleCanonical")
    b.strPrim("relativePath")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest.Resource {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var exampleBoolean: KotlinBoolean? = null
    var _exampleBoolean: Element? = null
    var exampleCanonical: KotlinString? = null
    var _exampleCanonical: Element? = null
    var relativePath: KotlinString? = null
    var _relativePath: Element? = null
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
          reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> exampleBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _exampleBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> exampleCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _exampleCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> relativePath = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _relativePath =
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
    return ImplementationGuide.Manifest.Resource(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      reference = required(reference, "ImplementationGuide.Manifest.Resource", "reference"),
      example =
        ImplementationGuide.Manifest.Resource.Example.from(
          R4Boolean.of(exampleBoolean, _exampleBoolean),
          Canonical.of(exampleCanonical, _exampleCanonical),
        ),
      relativePath = Url.of(relativePath, _relativePath),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Resource) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.reference)
    when (val choice = value.example) {
      null -> {}
      is ImplementationGuide.Manifest.Resource.Example.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is ImplementationGuide.Manifest.Resource.Example.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.relativePath?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.relativePath)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideManifestPageSerializer :
  FhirSerializer<ImplementationGuide.Manifest.Page> {
  override val descriptor: SerialDescriptor = buildDescriptor("Page", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImplementationGuide.Manifest.Page>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("title")
    b.strPrimList("anchor")
  }

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest.Page {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var anchor: List<KotlinString?>? = null
    var _anchor: List<Element?>? = null
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
        5 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          anchor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        8 ->
          _anchor =
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
    val anchor_ =
      List(maxSize(anchor, _anchor)) { index ->
        entryRequired(
          R4String.of(at(anchor, index), at(_anchor, index)),
          "ImplementationGuide.Manifest.Page",
          "anchor",
        )
      }
    return ImplementationGuide.Manifest.Page(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R4String.of(name, _name), "ImplementationGuide.Manifest.Page", "name"),
      title = R4String.of(title, _title),
      anchor = anchor_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Page) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.title)
    if (!value.anchor.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        stringNullableListSerializer,
        value.anchor.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.anchor)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImplementationGuideSerializer : FhirResourceSerializer<ImplementationGuide> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ImplementationGuide")

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
    b.strPrim("copyright")
    b.strPrim("packageId")
    b.strPrim("license")
    b.strPrimList("fhirVersion")
    b.optionalElement("dependsOn", ImplementationGuideDependsOnSerializer.listSerializer.descriptor)
    b.optionalElement("global", ImplementationGuideGlobalSerializer.listSerializer.descriptor)
    b.optionalElement("definition", ImplementationGuideDefinitionSerializer.descriptor)
    b.optionalElement("manifest", ImplementationGuideManifestSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ImplementationGuide {
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
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var packageId: KotlinString? = null
    var _packageId: Element? = null
    var license: KotlinString? = null
    var _license: Element? = null
    var fhirVersion: List<KotlinString?>? = null
    var _fhirVersion: List<Element?>? = null
    var dependsOn: List<ImplementationGuide.DependsOn>? = null
    var global: List<ImplementationGuide.Global>? = null
    var definition: ImplementationGuide.Definition? = null
    var manifest: ImplementationGuide.Manifest? = null
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
        31 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> packageId = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _packageId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 -> license = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _license =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 ->
          fhirVersion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        38 ->
          _fhirVersion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        39 ->
          dependsOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDependsOnSerializer.listSerializer,
              null,
            )
        40 ->
          global =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideGlobalSerializer.listSerializer,
              null,
            )
        41 ->
          definition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDefinitionSerializer,
              null,
            )
        42 ->
          manifest =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideManifestSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val fhirVersion_ =
      List(maxSize(fhirVersion, _fhirVersion)) { index ->
        entryRequired(
          Enumeration.of(
            at(fhirVersion, index)?.let { FHIRVersion.fromCode(it) },
            at(_fhirVersion, index),
          ),
          "ImplementationGuide",
          "fhirVersion",
        )
      }
    return ImplementationGuide(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = required(Uri.of(url, _url), "ImplementationGuide", "url"),
      version = R4String.of(version, _version),
      name = required(R4String.of(name, _name), "ImplementationGuide", "name"),
      title = R4String.of(title, _title),
      status = required(Enumeration.of(status, _status), "ImplementationGuide", "status"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      copyright = Markdown.of(copyright, _copyright),
      packageId = required(Id.of(packageId, _packageId), "ImplementationGuide", "packageId"),
      license = ExtensibleEnumeration.of<SPDXLicense>(license, _license),
      fhirVersion = fhirVersion_,
      dependsOn = listOrEmpty(dependsOn),
      global = listOrEmpty(global),
      definition = definition,
      manifest = manifest,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImplementationGuide,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name.value)
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
      value.date?.value?.toString(),
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.packageId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.packageId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.license?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.license)
    if (!value.fhirVersion.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        37 + descriptorOffset,
        stringNullableListSerializer,
        value.fhirVersion.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        38 + descriptorOffset,
        value.fhirVersion,
      )
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      39 + descriptorOffset,
      ImplementationGuideDependsOnSerializer.listSerializer,
      value.dependsOn,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      40 + descriptorOffset,
      ImplementationGuideGlobalSerializer.listSerializer,
      value.global,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      ImplementationGuideDefinitionSerializer,
      value.definition,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      ImplementationGuideManifestSerializer,
      value.manifest,
    )
  }
}
