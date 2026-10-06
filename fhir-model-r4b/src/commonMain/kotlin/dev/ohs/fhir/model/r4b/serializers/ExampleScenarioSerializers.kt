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
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.ExampleScenario
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
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
      optionalElement("actorId", KotlinString.serializer().descriptor)
      optionalElement("_actorId", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Actor>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Actor =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var actorId: KotlinString? = null
      var _actorId: Element? = null
      var type: KotlinString? = null
      var _type: Element? = null
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
          3 -> actorId = decodeStringElement(descriptor, i)
          4 -> _actorId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeStringElement(descriptor, i)
          6 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> name = decodeStringElement(descriptor, i)
          8 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
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
        actorId =
          R4bString.of(actorId, _actorId)
            ?: throw SerializationException(
              "Missing required property 'actorId' on ExampleScenario.Actor"
            ),
        type =
          Enumeration.of(
            if (type != null) ExampleScenario.ExampleScenarioActorType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on ExampleScenario.Actor"
            ),
        name = R4bString.of(name, _name),
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
      encodeStringIfNotNull(descriptor, 3, value.actorId.value)
      encodeElementIfNotNull(descriptor, 4, value.actorId)
      encodeStringIfNotNull(descriptor, 5, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.type)
      encodeStringIfNotNull(descriptor, 7, value.name?.value)
      encodeElementIfNotNull(descriptor, 8, value.name)
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
      optionalElement("resourceId", KotlinString.serializer().descriptor)
      optionalElement("_resourceId", ElementSerializer.descriptor)
      optionalElement("resourceType", KotlinString.serializer().descriptor)
      optionalElement("_resourceType", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
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
      var resourceId: KotlinString? = null
      var _resourceId: Element? = null
      var resourceType: KotlinString? = null
      var _resourceType: Element? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
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
          3 -> resourceId = decodeStringElement(descriptor, i)
          4 ->
            _resourceId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> resourceType = decodeStringElement(descriptor, i)
          6 ->
            _resourceType =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> name = decodeStringElement(descriptor, i)
          8 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> description = decodeStringElement(descriptor, i)
          10 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            version =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioInstanceVersionSerializer.listSerializer,
                null,
              )
          12 ->
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
        resourceId =
          R4bString.of(resourceId, _resourceId)
            ?: throw SerializationException(
              "Missing required property 'resourceId' on ExampleScenario.Instance"
            ),
        resourceType =
          Enumeration.of(
            if (resourceType != null) ResourceType.fromCode(resourceType) else null,
            _resourceType,
          )
            ?: throw SerializationException(
              "Missing required property 'resourceType' on ExampleScenario.Instance"
            ),
        name = R4bString.of(name, _name),
        description = Markdown.of(description, _description),
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
      encodeStringIfNotNull(descriptor, 3, value.resourceId.value)
      encodeElementIfNotNull(descriptor, 4, value.resourceId)
      encodeStringIfNotNull(descriptor, 5, value.resourceType.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.resourceType)
      encodeStringIfNotNull(descriptor, 7, value.name?.value)
      encodeElementIfNotNull(descriptor, 8, value.name)
      encodeStringIfNotNull(descriptor, 9, value.description?.value)
      encodeElementIfNotNull(descriptor, 10, value.description)
      if (value.version.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          ExampleScenarioInstanceVersionSerializer.listSerializer,
          value.version,
        )
      if (value.containedInstance.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
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
      optionalElement("versionId", KotlinString.serializer().descriptor)
      optionalElement("_versionId", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Instance.Version>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.Version =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var versionId: KotlinString? = null
      var _versionId: Element? = null
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
          3 -> versionId = decodeStringElement(descriptor, i)
          4 ->
            _versionId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Version: " + i)
        }
      }
      ExampleScenario.Instance.Version(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        versionId =
          R4bString.of(versionId, _versionId)
            ?: throw SerializationException(
              "Missing required property 'versionId' on ExampleScenario.Instance.Version"
            ),
        description =
          Markdown.of(description, _description)
            ?: throw SerializationException(
              "Missing required property 'description' on ExampleScenario.Instance.Version"
            ),
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
      encodeStringIfNotNull(descriptor, 3, value.versionId.value)
      encodeElementIfNotNull(descriptor, 4, value.versionId)
      encodeStringIfNotNull(descriptor, 5, value.description.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
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
      optionalElement("resourceId", KotlinString.serializer().descriptor)
      optionalElement("_resourceId", ElementSerializer.descriptor)
      optionalElement("versionId", KotlinString.serializer().descriptor)
      optionalElement("_versionId", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Instance.ContainedInstance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.ContainedInstance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var resourceId: KotlinString? = null
      var _resourceId: Element? = null
      var versionId: KotlinString? = null
      var _versionId: Element? = null
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
          3 -> resourceId = decodeStringElement(descriptor, i)
          4 ->
            _resourceId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> versionId = decodeStringElement(descriptor, i)
          6 ->
            _versionId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ContainedInstance: " + i)
        }
      }
      ExampleScenario.Instance.ContainedInstance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        resourceId =
          R4bString.of(resourceId, _resourceId)
            ?: throw SerializationException(
              "Missing required property 'resourceId' on ExampleScenario.Instance.ContainedInstance"
            ),
        versionId = R4bString.of(versionId, _versionId),
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
      encodeStringIfNotNull(descriptor, 3, value.resourceId.value)
      encodeElementIfNotNull(descriptor, 4, value.resourceId)
      encodeStringIfNotNull(descriptor, 5, value.versionId?.value)
      encodeElementIfNotNull(descriptor, 6, value.versionId)
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
          R4bString.of(title, _title)
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
      optionalElement(
        "process",
        listSerialDescriptor(lazyDescriptor { ExampleScenarioProcessSerializer.descriptor }),
      )
      optionalElement("pause", KotlinBoolean.serializer().descriptor)
      optionalElement("_pause", ElementSerializer.descriptor)
      optionalElement("operation", ExampleScenarioProcessStepOperationSerializer.descriptor)
      optionalElement(
        "alternative",
        ExampleScenarioProcessStepAlternativeSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ExampleScenario.Process.Step>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var process: List<ExampleScenario.Process>? = null
      var pause: KotlinBoolean? = null
      var _pause: Element? = null
      var operation: ExampleScenario.Process.Step.Operation? = null
      var alternative: List<ExampleScenario.Process.Step.Alternative>? = null
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
            process =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioProcessSerializer.listSerializer,
                null,
              )
          4 -> pause = decodeBooleanElement(descriptor, i)
          5 -> _pause = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            operation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioProcessStepOperationSerializer,
                null,
              )
          7 ->
            alternative =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioProcessStepAlternativeSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Step: " + i)
        }
      }
      ExampleScenario.Process.Step(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        process = process ?: listOf(),
        pause = R4bBoolean.of(pause, _pause),
        operation = operation,
        alternative = alternative ?: listOf(),
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
      if (value.process.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ExampleScenarioProcessSerializer.listSerializer,
          value.process,
        )
      encodeBooleanIfNotNull(descriptor, 4, value.pause?.value)
      encodeElementIfNotNull(descriptor, 5, value.pause)
      encodeSerializableIfNotNull(
        descriptor,
        6,
        ExampleScenarioProcessStepOperationSerializer,
        value.operation,
      )
      if (value.alternative.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          ExampleScenarioProcessStepAlternativeSerializer.listSerializer,
          value.alternative,
        )
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
      optionalElement("number", KotlinString.serializer().descriptor)
      optionalElement("_number", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
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
      var number: KotlinString? = null
      var _number: Element? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var name: KotlinString? = null
      var _name: Element? = null
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
          3 -> number = decodeStringElement(descriptor, i)
          4 -> _number = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeStringElement(descriptor, i)
          6 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> name = decodeStringElement(descriptor, i)
          8 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> initiator = decodeStringElement(descriptor, i)
          10 ->
            _initiator = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> `receiver` = decodeStringElement(descriptor, i)
          12 ->
            _receiver = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> description = decodeStringElement(descriptor, i)
          14 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> initiatorActive = decodeBooleanElement(descriptor, i)
          16 ->
            _initiatorActive =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> receiverActive = decodeBooleanElement(descriptor, i)
          18 ->
            _receiverActive =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 ->
            request =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExampleScenarioInstanceContainedInstanceSerializer,
                null,
              )
          20 ->
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
        number =
          R4bString.of(number, _number)
            ?: throw SerializationException(
              "Missing required property 'number' on ExampleScenario.Process.Step.Operation"
            ),
        type = R4bString.of(type, _type),
        name = R4bString.of(name, _name),
        initiator = R4bString.of(initiator, _initiator),
        `receiver` = R4bString.of(`receiver`, _receiver),
        description = Markdown.of(description, _description),
        initiatorActive = R4bBoolean.of(initiatorActive, _initiatorActive),
        receiverActive = R4bBoolean.of(receiverActive, _receiverActive),
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
      encodeStringIfNotNull(descriptor, 3, value.number.value)
      encodeElementIfNotNull(descriptor, 4, value.number)
      encodeStringIfNotNull(descriptor, 5, value.type?.value)
      encodeElementIfNotNull(descriptor, 6, value.type)
      encodeStringIfNotNull(descriptor, 7, value.name?.value)
      encodeElementIfNotNull(descriptor, 8, value.name)
      encodeStringIfNotNull(descriptor, 9, value.initiator?.value)
      encodeElementIfNotNull(descriptor, 10, value.initiator)
      encodeStringIfNotNull(descriptor, 11, value.`receiver`?.value)
      encodeElementIfNotNull(descriptor, 12, value.`receiver`)
      encodeStringIfNotNull(descriptor, 13, value.description?.value)
      encodeElementIfNotNull(descriptor, 14, value.description)
      encodeBooleanIfNotNull(descriptor, 15, value.initiatorActive?.value)
      encodeElementIfNotNull(descriptor, 16, value.initiatorActive)
      encodeBooleanIfNotNull(descriptor, 17, value.receiverActive?.value)
      encodeElementIfNotNull(descriptor, 18, value.receiverActive)
      encodeSerializableIfNotNull(
        descriptor,
        19,
        ExampleScenarioInstanceContainedInstanceSerializer,
        value.request,
      )
      encodeSerializableIfNotNull(
        descriptor,
        20,
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
          R4bString.of(title, _title)
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
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("actor", ExampleScenarioActorSerializer.listSerializer.descriptor)
    b.optionalElement("instance", ExampleScenarioInstanceSerializer.listSerializer.descriptor)
    b.optionalElement("process", ExampleScenarioProcessSerializer.listSerializer.descriptor)
    b.optionalElement("workflow", stringNullableListSerializer.descriptor)
    b.optionalElement("_workflow", ElementSerializer.nullableListSerializer.descriptor)
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
    var name: KotlinString? = null
    var _name: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var actor: List<ExampleScenario.Actor>? = null
    var instance: List<ExampleScenario.Instance>? = null
    var process: List<ExampleScenario.Process>? = null
    var workflow: List<KotlinString?>? = null
    var _workflow: List<Element?>? = null
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
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> status = decoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        20 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> date = decoder.decodeStringElement(descriptor, i)
        22 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> publisher = decoder.decodeStringElement(descriptor, i)
        24 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        26 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        27 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        28 -> copyright = decoder.decodeStringElement(descriptor, i)
        29 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> purpose = decoder.decodeStringElement(descriptor, i)
        31 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          actor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioActorSerializer.listSerializer,
              null,
            )
        33 ->
          instance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceSerializer.listSerializer,
              null,
            )
        34 ->
          process =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessSerializer.listSerializer,
              null,
            )
        35 ->
          workflow =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        36 ->
          _workflow =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on ExampleScenario"),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      copyright = Markdown.of(copyright, _copyright),
      purpose = Markdown.of(purpose, _purpose),
      actor = actor ?: listOf(),
      instance = instance ?: listOf(),
      process = process ?: listOf(),
      workflow =
        (kotlin.collections.List(maxOf(workflow?.size ?: 0, _workflow?.size ?: 0)) { index ->
          Canonical.of(workflow?.getOrNull(index), _workflow?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'workflow' on ExampleScenario has neither a value nor an id/extension"
            )
        }),
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
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 19 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.purpose)
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ExampleScenarioActorSerializer.listSerializer,
        value.actor,
      )
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ExampleScenarioInstanceSerializer.listSerializer,
        value.instance,
      )
    if (value.process.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ExampleScenarioProcessSerializer.listSerializer,
        value.process,
      )
    if (value.workflow.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        35 + descriptorOffset,
        stringNullableListSerializer,
        value.workflow.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 36 + descriptorOffset, value.workflow)
    }
  }
}
