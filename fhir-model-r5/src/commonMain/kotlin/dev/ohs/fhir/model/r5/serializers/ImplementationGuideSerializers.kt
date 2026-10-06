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
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImplementationGuide
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.FHIRVersion
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.ResourceType
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

internal object ImplementationGuideDependsOnSerializer :
  KSerializer<ImplementationGuide.DependsOn> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DependsOn") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("uri", KotlinString.serializer().descriptor)
      optionalElement("_uri", ElementSerializer.descriptor)
      optionalElement("packageId", KotlinString.serializer().descriptor)
      optionalElement("_packageId", ElementSerializer.descriptor)
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", ElementSerializer.descriptor)
      optionalElement("reason", KotlinString.serializer().descriptor)
      optionalElement("_reason", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.DependsOn>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.DependsOn =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var uri: KotlinString? = null
      var _uri: Element? = null
      var packageId: KotlinString? = null
      var _packageId: Element? = null
      var version: KotlinString? = null
      var _version: Element? = null
      var reason: KotlinString? = null
      var _reason: Element? = null
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
          5 -> packageId = decodeStringElement(descriptor, i)
          6 ->
            _packageId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> version = decodeStringElement(descriptor, i)
          8 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> reason = decodeStringElement(descriptor, i)
          10 -> _reason = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DependsOn: " + i)
        }
      }
      ImplementationGuide.DependsOn(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        uri =
          Canonical.of(uri, _uri)
            ?: throw SerializationException(
              "Missing required property 'uri' on ImplementationGuide.DependsOn"
            ),
        packageId = Id.of(packageId, _packageId),
        version = R5String.of(version, _version),
        reason = Markdown.of(reason, _reason),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.DependsOn) {
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
      encodeStringIfNotNull(descriptor, 3, value.uri.value)
      encodeElementIfNotNull(descriptor, 4, value.uri)
      encodeStringIfNotNull(descriptor, 5, value.packageId?.value)
      encodeElementIfNotNull(descriptor, 6, value.packageId)
      encodeStringIfNotNull(descriptor, 7, value.version?.value)
      encodeElementIfNotNull(descriptor, 8, value.version)
      encodeStringIfNotNull(descriptor, 9, value.reason?.value)
      encodeElementIfNotNull(descriptor, 10, value.reason)
    }
  }
}

internal object ImplementationGuideGlobalSerializer : KSerializer<ImplementationGuide.Global> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Global") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("profile", KotlinString.serializer().descriptor)
      optionalElement("_profile", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Global>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Global =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> profile = decodeStringElement(descriptor, i)
          6 -> _profile = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Global: " + i)
        }
      }
      ImplementationGuide.Global(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(if (type != null) ResourceType.fromCode(type) else null, _type)
            ?: throw SerializationException(
              "Missing required property 'type' on ImplementationGuide.Global"
            ),
        profile =
          Canonical.of(profile, _profile)
            ?: throw SerializationException(
              "Missing required property 'profile' on ImplementationGuide.Global"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Global) {
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
      encodeStringIfNotNull(descriptor, 5, value.profile.value)
      encodeElementIfNotNull(descriptor, 6, value.profile)
    }
  }
}

internal object ImplementationGuideDefinitionSerializer :
  KSerializer<ImplementationGuide.Definition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Definition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "grouping",
        ImplementationGuideDefinitionGroupingSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "resource",
        ImplementationGuideDefinitionResourceSerializer.listSerializer.descriptor,
      )
      optionalElement("page", ImplementationGuideDefinitionPageSerializer.descriptor)
      optionalElement(
        "parameter",
        ImplementationGuideDefinitionParameterSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "template",
        ImplementationGuideDefinitionTemplateSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var grouping: List<ImplementationGuide.Definition.Grouping>? = null
      var resource: List<ImplementationGuide.Definition.Resource>? = null
      var page: ImplementationGuide.Definition.Page? = null
      var parameter: List<ImplementationGuide.Definition.Parameter>? = null
      var template: List<ImplementationGuide.Definition.Template>? = null
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
            grouping =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImplementationGuideDefinitionGroupingSerializer.listSerializer,
                null,
              )
          4 ->
            resource =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImplementationGuideDefinitionResourceSerializer.listSerializer,
                null,
              )
          5 ->
            page =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImplementationGuideDefinitionPageSerializer,
                null,
              )
          6 ->
            parameter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImplementationGuideDefinitionParameterSerializer.listSerializer,
                null,
              )
          7 ->
            template =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImplementationGuideDefinitionTemplateSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Definition: " + i)
        }
      }
      ImplementationGuide.Definition(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        grouping = grouping ?: listOf(),
        resource = resource ?: listOf(),
        page = page,
        parameter = parameter ?: listOf(),
        template = template ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition) {
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
      if (value.grouping.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ImplementationGuideDefinitionGroupingSerializer.listSerializer,
          value.grouping,
        )
      if (value.resource.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ImplementationGuideDefinitionResourceSerializer.listSerializer,
          value.resource,
        )
      encodeSerializableIfNotNull(
        descriptor,
        5,
        ImplementationGuideDefinitionPageSerializer,
        value.page,
      )
      if (value.parameter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ImplementationGuideDefinitionParameterSerializer.listSerializer,
          value.parameter,
        )
      if (value.template.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          ImplementationGuideDefinitionTemplateSerializer.listSerializer,
          value.template,
        )
    }
  }
}

internal object ImplementationGuideDefinitionGroupingSerializer :
  KSerializer<ImplementationGuide.Definition.Grouping> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Grouping") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Grouping>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Grouping =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Grouping: " + i)
        }
      }
      ImplementationGuide.Definition.Grouping(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R5String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on ImplementationGuide.Definition.Grouping"
            ),
        description = Markdown.of(description, _description),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Grouping) {
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
      encodeStringIfNotNull(descriptor, 5, value.description?.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
    }
  }
}

internal object ImplementationGuideDefinitionResourceSerializer :
  KSerializer<ImplementationGuide.Definition.Resource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
      optionalElement("fhirVersion", stringNullableListSerializer.descriptor)
      optionalElement("_fhirVersion", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("isExample", KotlinBoolean.serializer().descriptor)
      optionalElement("_isExample", ElementSerializer.descriptor)
      optionalElement("profile", stringNullableListSerializer.descriptor)
      optionalElement("_profile", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("groupingId", KotlinString.serializer().descriptor)
      optionalElement("_groupingId", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Resource>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Resource =
    decoder.decodeStructure(descriptor) {
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
      var isExample: KotlinBoolean? = null
      var _isExample: Element? = null
      var profile: List<KotlinString?>? = null
      var _profile: List<Element?>? = null
      var groupingId: KotlinString? = null
      var _groupingId: Element? = null
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
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            fhirVersion =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          5 ->
            _fhirVersion =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          6 -> name = decodeStringElement(descriptor, i)
          7 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> description = decodeStringElement(descriptor, i)
          9 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> isExample = decodeBooleanElement(descriptor, i)
          11 ->
            _isExample = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            profile =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          13 ->
            _profile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          14 -> groupingId = decodeStringElement(descriptor, i)
          15 ->
            _groupingId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Resource: " + i)
        }
      }
      ImplementationGuide.Definition.Resource(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        reference =
          reference
            ?: throw SerializationException(
              "Missing required property 'reference' on ImplementationGuide.Definition.Resource"
            ),
        fhirVersion =
          (kotlin.collections.List(maxOf(fhirVersion?.size ?: 0, _fhirVersion?.size ?: 0)) { index
            ->
            Enumeration.of(
              fhirVersion?.getOrNull(index)?.let { FHIRVersion.fromCode(it) },
              _fhirVersion?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'fhirVersion' on ImplementationGuide.Definition.Resource has neither a value nor an id/extension"
              )
          }),
        name = R5String.of(name, _name),
        description = Markdown.of(description, _description),
        isExample = R5Boolean.of(isExample, _isExample),
        profile =
          (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { index ->
            Canonical.of(profile?.getOrNull(index), _profile?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'profile' on ImplementationGuide.Definition.Resource has neither a value nor an id/extension"
              )
          }),
        groupingId = Id.of(groupingId, _groupingId),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Resource) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.reference)
      if (value.fhirVersion.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          4,
          stringNullableListSerializer,
          value.fhirVersion.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 5, value.fhirVersion)
      }
      encodeStringIfNotNull(descriptor, 6, value.name?.value)
      encodeElementIfNotNull(descriptor, 7, value.name)
      encodeStringIfNotNull(descriptor, 8, value.description?.value)
      encodeElementIfNotNull(descriptor, 9, value.description)
      encodeBooleanIfNotNull(descriptor, 10, value.isExample?.value)
      encodeElementIfNotNull(descriptor, 11, value.isExample)
      if (value.profile.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          12,
          stringNullableListSerializer,
          value.profile.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 13, value.profile)
      }
      encodeStringIfNotNull(descriptor, 14, value.groupingId?.value)
      encodeElementIfNotNull(descriptor, 15, value.groupingId)
    }
  }
}

internal object ImplementationGuideDefinitionPageSerializer :
  KSerializer<ImplementationGuide.Definition.Page> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Page") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sourceUrl", KotlinString.serializer().descriptor)
      optionalElement("_sourceUrl", ElementSerializer.descriptor)
      optionalElement("sourceString", KotlinString.serializer().descriptor)
      optionalElement("_sourceString", ElementSerializer.descriptor)
      optionalElement("sourceMarkdown", KotlinString.serializer().descriptor)
      optionalElement("_sourceMarkdown", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("generation", KotlinString.serializer().descriptor)
      optionalElement("_generation", ElementSerializer.descriptor)
      optionalElement(
        "page",
        listSerialDescriptor(
          lazyDescriptor { ImplementationGuideDefinitionPageSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Page>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Page =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sourceUrl: KotlinString? = null
      var _sourceUrl: Element? = null
      var sourceString: KotlinString? = null
      var _sourceString: Element? = null
      var sourceMarkdown: KotlinString? = null
      var _sourceMarkdown: Element? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var generation: KotlinString? = null
      var _generation: Element? = null
      var page: List<ImplementationGuide.Definition.Page>? = null
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
          3 -> sourceUrl = decodeStringElement(descriptor, i)
          4 ->
            _sourceUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> sourceString = decodeStringElement(descriptor, i)
          6 ->
            _sourceString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> sourceMarkdown = decodeStringElement(descriptor, i)
          8 ->
            _sourceMarkdown =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> name = decodeStringElement(descriptor, i)
          10 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> title = decodeStringElement(descriptor, i)
          12 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> generation = decodeStringElement(descriptor, i)
          14 ->
            _generation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            page =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImplementationGuideDefinitionPageSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Page: " + i)
        }
      }
      ImplementationGuide.Definition.Page(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        source =
          ImplementationGuide.Definition.Page.Source.from(
            Url.of(sourceUrl, _sourceUrl),
            R5String.of(sourceString, _sourceString),
            Markdown.of(sourceMarkdown, _sourceMarkdown),
          ),
        name =
          Url.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on ImplementationGuide.Definition.Page"
            ),
        title =
          R5String.of(title, _title)
            ?: throw SerializationException(
              "Missing required property 'title' on ImplementationGuide.Definition.Page"
            ),
        generation =
          Enumeration.of(
            if (generation != null) ImplementationGuide.GuidePageGeneration.fromCode(generation)
            else null,
            _generation,
          )
            ?: throw SerializationException(
              "Missing required property 'generation' on ImplementationGuide.Definition.Page"
            ),
        page = page ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Page) {
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
      when (val choice = value.source) {
        null -> {}
        is ImplementationGuide.Definition.Page.Source.Url -> {
          encodeStringIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is ImplementationGuide.Definition.Page.Source.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is ImplementationGuide.Definition.Page.Source.Markdown -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 9, value.name.value)
      encodeElementIfNotNull(descriptor, 10, value.name)
      encodeStringIfNotNull(descriptor, 11, value.title.value)
      encodeElementIfNotNull(descriptor, 12, value.title)
      encodeStringIfNotNull(descriptor, 13, value.generation.value?.code)
      encodeElementIfNotNull(descriptor, 14, value.generation)
      if (value.page.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          ImplementationGuideDefinitionPageSerializer.listSerializer,
          value.page,
        )
    }
  }
}

internal object ImplementationGuideDefinitionParameterSerializer :
  KSerializer<ImplementationGuide.Definition.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodingSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Parameter>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Parameter =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: Coding? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
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
          3 -> code = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 -> `value` = decodeStringElement(descriptor, i)
          5 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      ImplementationGuide.Definition.Parameter(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on ImplementationGuide.Definition.Parameter"
            ),
        `value` =
          R5String.of(`value`, _value)
            ?: throw SerializationException(
              "Missing required property 'value' on ImplementationGuide.Definition.Parameter"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Parameter) {
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
      encodeSerializableElement(descriptor, 3, CodingSerializer, value.code)
      encodeStringIfNotNull(descriptor, 4, value.`value`.value)
      encodeElementIfNotNull(descriptor, 5, value.`value`)
    }
  }
}

internal object ImplementationGuideDefinitionTemplateSerializer :
  KSerializer<ImplementationGuide.Definition.Template> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Template") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("source", KotlinString.serializer().descriptor)
      optionalElement("_source", ElementSerializer.descriptor)
      optionalElement("scope", KotlinString.serializer().descriptor)
      optionalElement("_scope", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Definition.Template>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Definition.Template =
    decoder.decodeStructure(descriptor) {
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
          5 -> source = decodeStringElement(descriptor, i)
          6 -> _source = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> scope = decodeStringElement(descriptor, i)
          8 -> _scope = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Template: " + i)
        }
      }
      ImplementationGuide.Definition.Template(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Code.of(code, _code)
            ?: throw SerializationException(
              "Missing required property 'code' on ImplementationGuide.Definition.Template"
            ),
        source =
          R5String.of(source, _source)
            ?: throw SerializationException(
              "Missing required property 'source' on ImplementationGuide.Definition.Template"
            ),
        scope = R5String.of(scope, _scope),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Definition.Template) {
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
      encodeStringIfNotNull(descriptor, 5, value.source.value)
      encodeElementIfNotNull(descriptor, 6, value.source)
      encodeStringIfNotNull(descriptor, 7, value.scope?.value)
      encodeElementIfNotNull(descriptor, 8, value.scope)
    }
  }
}

internal object ImplementationGuideManifestSerializer : KSerializer<ImplementationGuide.Manifest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Manifest") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("rendering", KotlinString.serializer().descriptor)
      optionalElement("_rendering", ElementSerializer.descriptor)
      optionalElement(
        "resource",
        ImplementationGuideManifestResourceSerializer.listSerializer.descriptor,
      )
      optionalElement("page", ImplementationGuideManifestPageSerializer.listSerializer.descriptor)
      optionalElement("image", stringNullableListSerializer.descriptor)
      optionalElement("_image", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("other", stringNullableListSerializer.descriptor)
      optionalElement("_other", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Manifest>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest =
    decoder.decodeStructure(descriptor) {
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
          3 -> rendering = decodeStringElement(descriptor, i)
          4 ->
            _rendering = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            resource =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImplementationGuideManifestResourceSerializer.listSerializer,
                null,
              )
          6 ->
            page =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ImplementationGuideManifestPageSerializer.listSerializer,
                null,
              )
          7 ->
            image =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          8 ->
            _image =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 ->
            other =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          10 ->
            _other =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Manifest: " + i)
        }
      }
      ImplementationGuide.Manifest(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        rendering = Url.of(rendering, _rendering),
        resource = resource ?: listOf(),
        page = page ?: listOf(),
        image =
          (kotlin.collections.List(maxOf(image?.size ?: 0, _image?.size ?: 0)) { index ->
            R5String.of(image?.getOrNull(index), _image?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'image' on ImplementationGuide.Manifest has neither a value nor an id/extension"
              )
          }),
        other =
          (kotlin.collections.List(maxOf(other?.size ?: 0, _other?.size ?: 0)) { index ->
            R5String.of(other?.getOrNull(index), _other?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'other' on ImplementationGuide.Manifest has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest) {
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
      encodeStringIfNotNull(descriptor, 3, value.rendering?.value)
      encodeElementIfNotNull(descriptor, 4, value.rendering)
      if (value.resource.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          ImplementationGuideManifestResourceSerializer.listSerializer,
          value.resource,
        )
      if (value.page.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ImplementationGuideManifestPageSerializer.listSerializer,
          value.page,
        )
      if (value.image.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          stringNullableListSerializer,
          value.image.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 8, value.image)
      }
      if (value.other.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          stringNullableListSerializer,
          value.other.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 10, value.other)
      }
    }
  }
}

internal object ImplementationGuideManifestResourceSerializer :
  KSerializer<ImplementationGuide.Manifest.Resource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
      optionalElement("isExample", KotlinBoolean.serializer().descriptor)
      optionalElement("_isExample", ElementSerializer.descriptor)
      optionalElement("profile", stringNullableListSerializer.descriptor)
      optionalElement("_profile", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("relativePath", KotlinString.serializer().descriptor)
      optionalElement("_relativePath", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Manifest.Resource>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest.Resource =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var reference: Reference? = null
      var isExample: KotlinBoolean? = null
      var _isExample: Element? = null
      var profile: List<KotlinString?>? = null
      var _profile: List<Element?>? = null
      var relativePath: KotlinString? = null
      var _relativePath: Element? = null
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
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> isExample = decodeBooleanElement(descriptor, i)
          5 ->
            _isExample = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            profile =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          7 ->
            _profile =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          8 -> relativePath = decodeStringElement(descriptor, i)
          9 ->
            _relativePath =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Resource: " + i)
        }
      }
      ImplementationGuide.Manifest.Resource(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        reference =
          reference
            ?: throw SerializationException(
              "Missing required property 'reference' on ImplementationGuide.Manifest.Resource"
            ),
        isExample = R5Boolean.of(isExample, _isExample),
        profile =
          (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { index ->
            Canonical.of(profile?.getOrNull(index), _profile?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'profile' on ImplementationGuide.Manifest.Resource has neither a value nor an id/extension"
              )
          }),
        relativePath = Url.of(relativePath, _relativePath),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Resource) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.reference)
      encodeBooleanIfNotNull(descriptor, 4, value.isExample?.value)
      encodeElementIfNotNull(descriptor, 5, value.isExample)
      if (value.profile.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          6,
          stringNullableListSerializer,
          value.profile.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 7, value.profile)
      }
      encodeStringIfNotNull(descriptor, 8, value.relativePath?.value)
      encodeElementIfNotNull(descriptor, 9, value.relativePath)
    }
  }
}

internal object ImplementationGuideManifestPageSerializer :
  KSerializer<ImplementationGuide.Manifest.Page> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Page") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("anchor", stringNullableListSerializer.descriptor)
      optionalElement("_anchor", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ImplementationGuide.Manifest.Page>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ImplementationGuide.Manifest.Page =
    decoder.decodeStructure(descriptor) {
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
          5 -> title = decodeStringElement(descriptor, i)
          6 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            anchor =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          8 ->
            _anchor =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Page: " + i)
        }
      }
      ImplementationGuide.Manifest.Page(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R5String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on ImplementationGuide.Manifest.Page"
            ),
        title = R5String.of(title, _title),
        anchor =
          (kotlin.collections.List(maxOf(anchor?.size ?: 0, _anchor?.size ?: 0)) { index ->
            R5String.of(anchor?.getOrNull(index), _anchor?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'anchor' on ImplementationGuide.Manifest.Page has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ImplementationGuide.Manifest.Page) {
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
      encodeStringIfNotNull(descriptor, 5, value.title?.value)
      encodeElementIfNotNull(descriptor, 6, value.title)
      if (value.anchor.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          stringNullableListSerializer,
          value.anchor.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 8, value.anchor)
      }
    }
  }
}

internal object ImplementationGuideSerializer : FhirResourceSerializer<ImplementationGuide> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ImplementationGuide")

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
    b.optionalElement("packageId", KotlinString.serializer().descriptor)
    b.optionalElement("_packageId", ElementSerializer.descriptor)
    b.optionalElement("license", KotlinString.serializer().descriptor)
    b.optionalElement("_license", ElementSerializer.descriptor)
    b.optionalElement("fhirVersion", stringNullableListSerializer.descriptor)
    b.optionalElement("_fhirVersion", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("dependsOn", ImplementationGuideDependsOnSerializer.listSerializer.descriptor)
    b.optionalElement("global", ImplementationGuideGlobalSerializer.listSerializer.descriptor)
    b.optionalElement("definition", ImplementationGuideDefinitionSerializer.descriptor)
    b.optionalElement("manifest", ImplementationGuideManifestSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
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
        41 -> packageId = decoder.decodeStringElement(descriptor, i)
        42 ->
          _packageId =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 -> license = decoder.decodeStringElement(descriptor, i)
        44 ->
          _license =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 ->
          fhirVersion =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        46 ->
          _fhirVersion =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        47 ->
          dependsOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDependsOnSerializer.listSerializer,
              null,
            )
        48 ->
          global =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideGlobalSerializer.listSerializer,
              null,
            )
        49 ->
          definition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideDefinitionSerializer,
              null,
            )
        50 ->
          manifest =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImplementationGuideManifestSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ImplementationGuide: " + i)
      }
    }
    return ImplementationGuide(
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
          ?: throw SerializationException("Missing required property 'url' on ImplementationGuide"),
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        ImplementationGuide.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on ImplementationGuide"
          ),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on ImplementationGuide"
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
      packageId =
        Id.of(packageId, _packageId)
          ?: throw SerializationException(
            "Missing required property 'packageId' on ImplementationGuide"
          ),
      license =
        Enumeration.of(
          if (license != null) ImplementationGuide.SPDXLicense.fromCode(license) else null,
          _license,
        ),
      fhirVersion =
        (kotlin.collections.List(maxOf(fhirVersion?.size ?: 0, _fhirVersion?.size ?: 0)) { index ->
          Enumeration.of(
            fhirVersion?.getOrNull(index)?.let { FHIRVersion.fromCode(it) },
            _fhirVersion?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'fhirVersion' on ImplementationGuide has neither a value nor an id/extension"
            )
        }),
      dependsOn = dependsOn ?: listOf(),
      global = global ?: listOf(),
      definition = definition,
      manifest = manifest,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImplementationGuide,
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
      is ImplementationGuide.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is ImplementationGuide.VersionAlgorithm.Coding -> {
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
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.packageId.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.packageId)
    encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, value.license?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.license)
    if (value.fhirVersion.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        45 + descriptorOffset,
        stringNullableListSerializer,
        value.fhirVersion.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 46 + descriptorOffset, value.fhirVersion)
    }
    if (value.dependsOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        ImplementationGuideDependsOnSerializer.listSerializer,
        value.dependsOn,
      )
    if (value.global.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ImplementationGuideGlobalSerializer.listSerializer,
        value.global,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      ImplementationGuideDefinitionSerializer,
      value.definition,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      50 + descriptorOffset,
      ImplementationGuideManifestSerializer,
      value.manifest,
    )
  }
}
