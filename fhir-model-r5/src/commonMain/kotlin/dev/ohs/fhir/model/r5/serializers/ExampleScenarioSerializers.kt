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
import dev.ohs.fhir.model.r5.ExampleScenario
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
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ExampleScenarioActorSerializer : KSerializer<ExampleScenario.Actor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Actor") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("key", KotlinString.serializer().descriptor)
      optionalElement("_key", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Actor>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Actor =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var key: KotlinString? = null
      var _key: Element? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var title: KotlinString? = null
      var _title: Element? = null
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
          3 -> key = decodeStringElement(descriptor, i)
          4 -> _key = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeStringElement(descriptor, i)
          6 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> title = decodeStringElement(descriptor, i)
          8 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> description = decodeStringElement(descriptor, i)
          10 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Actor: " + i)
        }
      }
      ExampleScenario.Actor(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        key =
          R5String.of(key, _key)
            ?: throw SerializationException(
              "Missing required property 'key' on ExampleScenario.Actor"
            ),
        type =
          Enumeration.of(
            if (type != null) ExampleScenario.ExampleScenarioActorType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on ExampleScenario.Actor"
            ),
        title =
          R5String.of(title, _title)
            ?: throw SerializationException(
              "Missing required property 'title' on ExampleScenario.Actor"
            ),
        description = Markdown.of(description, _description),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Actor) {
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
      encodeStringIfNotNull(descriptor, 3, value.key.value)
      encodeElementIfNotNull(descriptor, 4, value.key)
      encodeStringIfNotNull(descriptor, 5, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.type)
      encodeStringIfNotNull(descriptor, 7, value.title.value)
      encodeElementIfNotNull(descriptor, 8, value.title)
      encodeStringIfNotNull(descriptor, 9, value.description?.value)
      encodeElementIfNotNull(descriptor, 10, value.description)
    }
  }
}

internal object ExampleScenarioInstanceSerializer : KSerializer<ExampleScenario.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("key", KotlinString.serializer().descriptor)
      optionalElement("_key", ElementSerializer.descriptor)
      optionalElement("structureType", CodingSerializer.descriptor)
      optionalElement("structureVersion", KotlinString.serializer().descriptor)
      optionalElement("_structureVersion", ElementSerializer.descriptor)
      optionalElement("structureProfileCanonical", KotlinString.serializer().descriptor)
      optionalElement("_structureProfileCanonical", ElementSerializer.descriptor)
      optionalElement("structureProfileUri", KotlinString.serializer().descriptor)
      optionalElement("_structureProfileUri", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("content", ReferenceSerializer.descriptor)
      optionalElement("version", ExampleScenarioInstanceVersionSerializer.listSerializer.descriptor)
      optionalElement(
        "containedInstance",
        ExampleScenarioInstanceContainedInstanceSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Instance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var key: KotlinString? = null
      var _key: Element? = null
      var structureType: Coding? = null
      var structureVersion: KotlinString? = null
      var _structureVersion: Element? = null
      var structureProfileCanonical: KotlinString? = null
      var _structureProfileCanonical: Element? = null
      var structureProfileUri: KotlinString? = null
      var _structureProfileUri: Element? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var content: Reference? = null
      var version: List<ExampleScenario.Instance.Version>? = null
      var containedInstance: List<ExampleScenario.Instance.ContainedInstance>? = null
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
          3 -> key = decodeStringElement(descriptor, i)
          4 -> _key = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            structureType = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          6 -> structureVersion = decodeStringElement(descriptor, i)
          7 ->
            _structureVersion =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> structureProfileCanonical = decodeStringElement(descriptor, i)
          9 ->
            _structureProfileCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> structureProfileUri = decodeStringElement(descriptor, i)
          11 ->
            _structureProfileUri =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> title = decodeStringElement(descriptor, i)
          13 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> description = decodeStringElement(descriptor, i)
          15 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            content = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          17 ->
            version =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioInstanceVersionSerializer.listSerializer,
                null,
              )
          18 ->
            containedInstance =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioInstanceContainedInstanceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Instance: " + i)
        }
      }
      ExampleScenario.Instance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        key =
          R5String.of(key, _key)
            ?: throw SerializationException(
              "Missing required property 'key' on ExampleScenario.Instance"
            ),
        structureType =
          structureType
            ?: throw SerializationException(
              "Missing required property 'structureType' on ExampleScenario.Instance"
            ),
        structureVersion = R5String.of(structureVersion, _structureVersion),
        structureProfile =
          ExampleScenario.Instance.StructureProfile.from(
            Canonical.of(structureProfileCanonical, _structureProfileCanonical),
            Uri.of(structureProfileUri, _structureProfileUri),
          ),
        title =
          R5String.of(title, _title)
            ?: throw SerializationException(
              "Missing required property 'title' on ExampleScenario.Instance"
            ),
        description = Markdown.of(description, _description),
        content = content,
        version = version ?: listOf(),
        containedInstance = containedInstance ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance) {
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
      encodeStringIfNotNull(descriptor, 3, value.key.value)
      encodeElementIfNotNull(descriptor, 4, value.key)
      encodeSerializableElement(descriptor, 5, CodingSerializer, value.structureType)
      encodeStringIfNotNull(descriptor, 6, value.structureVersion?.value)
      encodeElementIfNotNull(descriptor, 7, value.structureVersion)
      when (val choice = value.structureProfile) {
        null -> {}
        is ExampleScenario.Instance.StructureProfile.Canonical -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is ExampleScenario.Instance.StructureProfile.Uri -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 12, value.title.value)
      encodeElementIfNotNull(descriptor, 13, value.title)
      encodeStringIfNotNull(descriptor, 14, value.description?.value)
      encodeElementIfNotNull(descriptor, 15, value.description)
      encodeSerializableIfNotNull(descriptor, 16, ReferenceSerializer, value.content)
      if (value.version.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          17,
          ExampleScenarioInstanceVersionSerializer.listSerializer,
          value.version,
        )
      if (value.containedInstance.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          ExampleScenarioInstanceContainedInstanceSerializer.listSerializer,
          value.containedInstance,
        )
    }
  }
}

internal object ExampleScenarioInstanceVersionSerializer :
  KSerializer<ExampleScenario.Instance.Version> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Version") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("key", KotlinString.serializer().descriptor)
      optionalElement("_key", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("content", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Instance.Version>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.Version =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var key: KotlinString? = null
      var _key: Element? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var content: Reference? = null
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
          3 -> key = decodeStringElement(descriptor, i)
          4 -> _key = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> title = decodeStringElement(descriptor, i)
          6 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> description = decodeStringElement(descriptor, i)
          8 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> content = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Version: " + i)
        }
      }
      ExampleScenario.Instance.Version(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        key =
          R5String.of(key, _key)
            ?: throw SerializationException(
              "Missing required property 'key' on ExampleScenario.Instance.Version"
            ),
        title =
          R5String.of(title, _title)
            ?: throw SerializationException(
              "Missing required property 'title' on ExampleScenario.Instance.Version"
            ),
        description = Markdown.of(description, _description),
        content = content,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.Version) {
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
      encodeStringIfNotNull(descriptor, 3, value.key.value)
      encodeElementIfNotNull(descriptor, 4, value.key)
      encodeStringIfNotNull(descriptor, 5, value.title.value)
      encodeElementIfNotNull(descriptor, 6, value.title)
      encodeStringIfNotNull(descriptor, 7, value.description?.value)
      encodeElementIfNotNull(descriptor, 8, value.description)
      encodeSerializableIfNotNull(descriptor, 9, ReferenceSerializer, value.content)
    }
  }
}

internal object ExampleScenarioInstanceContainedInstanceSerializer :
  KSerializer<ExampleScenario.Instance.ContainedInstance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContainedInstance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("instanceReference", KotlinString.serializer().descriptor)
      optionalElement("_instanceReference", ElementSerializer.descriptor)
      optionalElement("versionReference", KotlinString.serializer().descriptor)
      optionalElement("_versionReference", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Instance.ContainedInstance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.ContainedInstance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var instanceReference: KotlinString? = null
      var _instanceReference: Element? = null
      var versionReference: KotlinString? = null
      var _versionReference: Element? = null
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
          3 -> instanceReference = decodeStringElement(descriptor, i)
          4 ->
            _instanceReference =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> versionReference = decodeStringElement(descriptor, i)
          6 ->
            _versionReference =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ContainedInstance: " + i)
        }
      }
      ExampleScenario.Instance.ContainedInstance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        instanceReference =
          R5String.of(instanceReference, _instanceReference)
            ?: throw SerializationException(
              "Missing required property 'instanceReference' on ExampleScenario.Instance.ContainedInstance"
            ),
        versionReference = R5String.of(versionReference, _versionReference),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.ContainedInstance) {
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
      encodeStringIfNotNull(descriptor, 3, value.instanceReference.value)
      encodeElementIfNotNull(descriptor, 4, value.instanceReference)
      encodeStringIfNotNull(descriptor, 5, value.versionReference?.value)
      encodeElementIfNotNull(descriptor, 6, value.versionReference)
    }
  }
}

internal object ExampleScenarioProcessSerializer : KSerializer<ExampleScenario.Process> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Process") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("preConditions", KotlinString.serializer().descriptor)
      optionalElement("_preConditions", ElementSerializer.descriptor)
      optionalElement("postConditions", KotlinString.serializer().descriptor)
      optionalElement("_postConditions", ElementSerializer.descriptor)
      optionalElement("step", ExampleScenarioProcessStepSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Process>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Process =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var preConditions: KotlinString? = null
      var _preConditions: Element? = null
      var postConditions: KotlinString? = null
      var _postConditions: Element? = null
      var step: List<ExampleScenario.Process.Step>? = null
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
          3 -> title = decodeStringElement(descriptor, i)
          4 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> preConditions = decodeStringElement(descriptor, i)
          8 ->
            _preConditions =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> postConditions = decodeStringElement(descriptor, i)
          10 ->
            _postConditions =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            step =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioProcessStepSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Process: " + i)
        }
      }
      ExampleScenario.Process(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title =
          R5String.of(title, _title)
            ?: throw SerializationException(
              "Missing required property 'title' on ExampleScenario.Process"
            ),
        description = Markdown.of(description, _description),
        preConditions = Markdown.of(preConditions, _preConditions),
        postConditions = Markdown.of(postConditions, _postConditions),
        step = step ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process) {
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
      encodeStringIfNotNull(descriptor, 3, value.title.value)
      encodeElementIfNotNull(descriptor, 4, value.title)
      encodeStringIfNotNull(descriptor, 5, value.description?.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
      encodeStringIfNotNull(descriptor, 7, value.preConditions?.value)
      encodeElementIfNotNull(descriptor, 8, value.preConditions)
      encodeStringIfNotNull(descriptor, 9, value.postConditions?.value)
      encodeElementIfNotNull(descriptor, 10, value.postConditions)
      if (value.step.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          ExampleScenarioProcessStepSerializer.listSerializer,
          value.step,
        )
    }
  }
}

internal object ExampleScenarioProcessStepSerializer : KSerializer<ExampleScenario.Process.Step> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Step") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("number", KotlinString.serializer().descriptor)
      optionalElement("_number", ElementSerializer.descriptor)
      optionalElement("process", lazyDescriptor { ExampleScenarioProcessSerializer.descriptor })
      optionalElement("workflow", KotlinString.serializer().descriptor)
      optionalElement("_workflow", ElementSerializer.descriptor)
      optionalElement("operation", ExampleScenarioProcessStepOperationSerializer.descriptor)
      optionalElement(
        "alternative",
        ExampleScenarioProcessStepAlternativeSerializer.listSerializer.descriptor,
      )
      optionalElement("pause", KotlinBoolean.serializer().descriptor)
      optionalElement("_pause", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Process.Step>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var number: KotlinString? = null
      var _number: Element? = null
      var process: ExampleScenario.Process? = null
      var workflow: KotlinString? = null
      var _workflow: Element? = null
      var operation: ExampleScenario.Process.Step.Operation? = null
      var alternative: List<ExampleScenario.Process.Step.Alternative>? = null
      var pause: KotlinBoolean? = null
      var _pause: Element? = null
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
          3 -> number = decodeStringElement(descriptor, i)
          4 -> _number = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            process =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioProcessSerializer,
                null,
              )
          6 -> workflow = decodeStringElement(descriptor, i)
          7 -> _workflow = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            operation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioProcessStepOperationSerializer,
                null,
              )
          9 ->
            alternative =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioProcessStepAlternativeSerializer.listSerializer,
                null,
              )
          10 -> pause = decodeBooleanElement(descriptor, i)
          11 -> _pause = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Step: " + i)
        }
      }
      ExampleScenario.Process.Step(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        number = R5String.of(number, _number),
        process = process,
        workflow = Canonical.of(workflow, _workflow),
        operation = operation,
        alternative = alternative ?: listOf(),
        pause = R5Boolean.of(pause, _pause),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step) {
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
      encodeStringIfNotNull(descriptor, 3, value.number?.value)
      encodeElementIfNotNull(descriptor, 4, value.number)
      encodeSerializableIfNotNull(descriptor, 5, ExampleScenarioProcessSerializer, value.process)
      encodeStringIfNotNull(descriptor, 6, value.workflow?.value)
      encodeElementIfNotNull(descriptor, 7, value.workflow)
      encodeSerializableIfNotNull(
        descriptor,
        8,
        ExampleScenarioProcessStepOperationSerializer,
        value.operation,
      )
      if (value.alternative.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          ExampleScenarioProcessStepAlternativeSerializer.listSerializer,
          value.alternative,
        )
      encodeBooleanIfNotNull(descriptor, 10, value.pause?.value)
      encodeElementIfNotNull(descriptor, 11, value.pause)
    }
  }
}

internal object ExampleScenarioProcessStepOperationSerializer :
  KSerializer<ExampleScenario.Process.Step.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodingSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("initiator", KotlinString.serializer().descriptor)
      optionalElement("_initiator", ElementSerializer.descriptor)
      optionalElement("receiver", KotlinString.serializer().descriptor)
      optionalElement("_receiver", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("initiatorActive", KotlinBoolean.serializer().descriptor)
      optionalElement("_initiatorActive", ElementSerializer.descriptor)
      optionalElement("receiverActive", KotlinBoolean.serializer().descriptor)
      optionalElement("_receiverActive", ElementSerializer.descriptor)
      optionalElement(
        "request",
        lazyDescriptor { ExampleScenarioInstanceContainedInstanceSerializer.descriptor },
      )
      optionalElement(
        "response",
        lazyDescriptor { ExampleScenarioInstanceContainedInstanceSerializer.descriptor },
      )
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Process.Step.Operation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Operation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: Coding? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var initiator: KotlinString? = null
      var _initiator: Element? = null
      var `receiver`: KotlinString? = null
      var _receiver: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var initiatorActive: KotlinBoolean? = null
      var _initiatorActive: Element? = null
      var receiverActive: KotlinBoolean? = null
      var _receiverActive: Element? = null
      var request: ExampleScenario.Instance.ContainedInstance? = null
      var response: ExampleScenario.Instance.ContainedInstance? = null
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
          3 -> type = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 -> title = decodeStringElement(descriptor, i)
          5 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> initiator = decodeStringElement(descriptor, i)
          7 ->
            _initiator = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> `receiver` = decodeStringElement(descriptor, i)
          9 -> _receiver = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> description = decodeStringElement(descriptor, i)
          11 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> initiatorActive = decodeBooleanElement(descriptor, i)
          13 ->
            _initiatorActive =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> receiverActive = decodeBooleanElement(descriptor, i)
          15 ->
            _receiverActive =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            request =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioInstanceContainedInstanceSerializer,
                null,
              )
          17 ->
            response =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioInstanceContainedInstanceSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Operation: " + i)
        }
      }
      ExampleScenario.Process.Step.Operation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        title =
          R5String.of(title, _title)
            ?: throw SerializationException(
              "Missing required property 'title' on ExampleScenario.Process.Step.Operation"
            ),
        initiator = R5String.of(initiator, _initiator),
        `receiver` = R5String.of(`receiver`, _receiver),
        description = Markdown.of(description, _description),
        initiatorActive = R5Boolean.of(initiatorActive, _initiatorActive),
        receiverActive = R5Boolean.of(receiverActive, _receiverActive),
        request = request,
        response = response,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Operation) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodingSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.title.value)
      encodeElementIfNotNull(descriptor, 5, value.title)
      encodeStringIfNotNull(descriptor, 6, value.initiator?.value)
      encodeElementIfNotNull(descriptor, 7, value.initiator)
      encodeStringIfNotNull(descriptor, 8, value.`receiver`?.value)
      encodeElementIfNotNull(descriptor, 9, value.`receiver`)
      encodeStringIfNotNull(descriptor, 10, value.description?.value)
      encodeElementIfNotNull(descriptor, 11, value.description)
      encodeBooleanIfNotNull(descriptor, 12, value.initiatorActive?.value)
      encodeElementIfNotNull(descriptor, 13, value.initiatorActive)
      encodeBooleanIfNotNull(descriptor, 14, value.receiverActive?.value)
      encodeElementIfNotNull(descriptor, 15, value.receiverActive)
      encodeSerializableIfNotNull(
        descriptor,
        16,
        ExampleScenarioInstanceContainedInstanceSerializer,
        value.request,
      )
      encodeSerializableIfNotNull(
        descriptor,
        17,
        ExampleScenarioInstanceContainedInstanceSerializer,
        value.response,
      )
    }
  }
}

internal object ExampleScenarioProcessStepAlternativeSerializer :
  KSerializer<ExampleScenario.Process.Step.Alternative> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Alternative") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement(
        "step",
        listSerialDescriptor(lazyDescriptor { ExampleScenarioProcessStepSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Process.Step.Alternative>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Alternative =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var step: List<ExampleScenario.Process.Step>? = null
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
          3 -> title = decodeStringElement(descriptor, i)
          4 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            step =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioProcessStepSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Alternative: " + i)
        }
      }
      ExampleScenario.Process.Step.Alternative(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title =
          R5String.of(title, _title)
            ?: throw SerializationException(
              "Missing required property 'title' on ExampleScenario.Process.Step.Alternative"
            ),
        description = Markdown.of(description, _description),
        step = step ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Alternative) {
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
      encodeStringIfNotNull(descriptor, 3, value.title.value)
      encodeElementIfNotNull(descriptor, 4, value.title)
      encodeStringIfNotNull(descriptor, 5, value.description?.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
      if (value.step.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          ExampleScenarioProcessStepSerializer.listSerializer,
          value.step,
        )
    }
  }
}

internal object ExampleScenarioSerializer : FhirResourceSerializer<ExampleScenario> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ExampleScenario")

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
    b.optionalElement("actor", ExampleScenarioActorSerializer.listSerializer.descriptor)
    b.optionalElement("instance", ExampleScenarioInstanceSerializer.listSerializer.descriptor)
    b.optionalElement("process", ExampleScenarioProcessSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ExampleScenario {
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
    var actor: List<ExampleScenario.Actor>? = null
    var instance: List<ExampleScenario.Instance>? = null
    var process: List<ExampleScenario.Process>? = null
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
        41 ->
          actor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioActorSerializer.listSerializer,
              null,
            )
        42 ->
          instance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceSerializer.listSerializer,
              null,
            )
        43 ->
          process =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ExampleScenario: " + i)
      }
    }
    return ExampleScenario(
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
        ExampleScenario.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on ExampleScenario"),
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
      actor = actor ?: listOf(),
      instance = instance ?: listOf(),
      process = process ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ExampleScenario,
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
      is ExampleScenario.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is ExampleScenario.VersionAlgorithm.Coding -> {
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
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        ExampleScenarioActorSerializer.listSerializer,
        value.actor,
      )
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ExampleScenarioInstanceSerializer.listSerializer,
        value.instance,
      )
    if (value.process.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ExampleScenarioProcessSerializer.listSerializer,
        value.process,
      )
  }
}
