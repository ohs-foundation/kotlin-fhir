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
import dev.ohs.fhir.model.r4.ExampleScenario
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object ExampleScenarioActorSerializer : KSerializer<ExampleScenario.Actor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Actor") {
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
      element("actorId", KotlinString.serializer().descriptor, isOptional = true)
      element("_actorId", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExampleScenario.Actor =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Actor) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExampleScenario.Actor {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> actorId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _actorId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorIdSer, null)
        5 -> type = decoder.decodeStringElement(descriptor, i)
        6 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorIdSer, null)
        7 -> name = decoder.decodeStringElement(descriptor, i)
        8 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorIdSer, null)
        9 -> description = decoder.decodeStringElement(descriptor, i)
        10 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorIdSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Actor: " + i)
      }
    }
    return ExampleScenario.Actor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actorId =
        R4String.of(actorId, _actorId)
          ?: throw SerializationException(
            "Missing required property 'actorId' on ExampleScenario.Actor"
          ),
      type =
        Enumeration.of(type?.let { ExampleScenario.ExampleScenarioActorType.fromCode(it) }, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on ExampleScenario.Actor"
          ),
      name = R4String.of(name, _name),
      description = Markdown.of(description, _description),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExampleScenario.Actor) {
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
    ((value.actorId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.actorId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorIdSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.actorIdSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.actorIdSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.actorIdSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actorIdSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ExampleScenarioInstanceSerializer : KSerializer<ExampleScenario.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
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
      element("resourceId", KotlinString.serializer().descriptor, isOptional = true)
      element("_resourceId", Element.serializer().descriptor, isOptional = true)
      element("resourceType", KotlinString.serializer().descriptor, isOptional = true)
      element("_resourceType", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "version",
        listSerialDescriptor(
          lazyDescriptor { ExampleScenario.Instance.Version.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "containedInstance",
        listSerialDescriptor(
          lazyDescriptor { ExampleScenario.Instance.ContainedInstance.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExampleScenario.Instance {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> resourceId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _resourceId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceIdSer, null)
        5 -> resourceType = decoder.decodeStringElement(descriptor, i)
        6 ->
          _resourceType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceIdSer, null)
        7 -> name = decoder.decodeStringElement(descriptor, i)
        8 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceIdSer, null)
        9 -> description = decoder.decodeStringElement(descriptor, i)
        10 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceIdSer, null)
        11 ->
          version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionSer, null)
        12 ->
          containedInstance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.containedInstanceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + i)
      }
    }
    return ExampleScenario.Instance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      resourceId =
        R4String.of(resourceId, _resourceId)
          ?: throw SerializationException(
            "Missing required property 'resourceId' on ExampleScenario.Instance"
          ),
      resourceType =
        Enumeration.of(
          resourceType?.let { ExampleScenario.ResourceType.fromCode(it) },
          _resourceType,
        )
          ?: throw SerializationException(
            "Missing required property 'resourceType' on ExampleScenario.Instance"
          ),
      name = R4String.of(name, _name),
      description = Markdown.of(description, _description),
      version = version ?: listOf(),
      containedInstance = containedInstance ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExampleScenario.Instance) {
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
    ((value.resourceId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.resourceId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.resourceIdSer, it)
    }
    ((value.resourceType.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.resourceType.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.resourceIdSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.resourceIdSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.resourceIdSer, it)
    }
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.versionSer, value.version)
    if (value.containedInstance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12,
        Hoisted.containedInstanceSer,
        value.containedInstance,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val resourceIdSer: KSerializer<Element> = Element.serializer()

    public val versionSerInner: KSerializer<ExampleScenario.Instance.Version> =
      ExampleScenario.Instance.Version.serializer()

    public val versionSer: KSerializer<List<ExampleScenario.Instance.Version>> =
      ListSerializer(Hoisted.versionSerInner)

    public val containedInstanceSerInner: KSerializer<ExampleScenario.Instance.ContainedInstance> =
      ExampleScenario.Instance.ContainedInstance.serializer()

    public val containedInstanceSer: KSerializer<List<ExampleScenario.Instance.ContainedInstance>> =
      ListSerializer(Hoisted.containedInstanceSerInner)
  }
}

internal object ExampleScenarioInstanceVersionSerializer :
  KSerializer<ExampleScenario.Instance.Version> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Version") {
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
      element("versionId", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionId", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.Version =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.Version) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExampleScenario.Instance.Version {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var versionId: KotlinString? = null
    var _versionId: Element? = null
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
        3 -> versionId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _versionId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionIdSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionIdSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + i)
      }
    }
    return ExampleScenario.Instance.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      versionId =
        R4String.of(versionId, _versionId)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExampleScenario.Instance.Version,
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
    ((value.versionId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.versionId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.versionIdSer, it)
    }
    ((value.description.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.versionIdSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val versionIdSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ExampleScenarioInstanceContainedInstanceSerializer :
  KSerializer<ExampleScenario.Instance.ContainedInstance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContainedInstance") {
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
      element("resourceId", KotlinString.serializer().descriptor, isOptional = true)
      element("_resourceId", Element.serializer().descriptor, isOptional = true)
      element("versionId", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionId", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.ContainedInstance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.ContainedInstance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExampleScenario.Instance.ContainedInstance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var resourceId: KotlinString? = null
    var _resourceId: Element? = null
    var versionId: KotlinString? = null
    var _versionId: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> resourceId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _resourceId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceIdSer, null)
        5 -> versionId = decoder.decodeStringElement(descriptor, i)
        6 ->
          _versionId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceIdSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContainedInstance: " + i)
      }
    }
    return ExampleScenario.Instance.ContainedInstance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      resourceId =
        R4String.of(resourceId, _resourceId)
          ?: throw SerializationException(
            "Missing required property 'resourceId' on ExampleScenario.Instance.ContainedInstance"
          ),
      versionId = R4String.of(versionId, _versionId),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExampleScenario.Instance.ContainedInstance,
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
    ((value.resourceId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.resourceId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.resourceIdSer, it)
    }
    ((value.versionId?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.versionId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.resourceIdSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val resourceIdSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ExampleScenarioProcessSerializer : KSerializer<ExampleScenario.Process> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Process") {
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
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("preConditions", KotlinString.serializer().descriptor, isOptional = true)
      element("_preConditions", Element.serializer().descriptor, isOptional = true)
      element("postConditions", KotlinString.serializer().descriptor, isOptional = true)
      element("_postConditions", Element.serializer().descriptor, isOptional = true)
      element(
        "step",
        listSerialDescriptor(
          lazyDescriptor { ExampleScenario.Process.Step.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExampleScenario.Process {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> title = decoder.decodeStringElement(descriptor, i)
        4 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        7 -> preConditions = decoder.decodeStringElement(descriptor, i)
        8 ->
          _preConditions =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        9 -> postConditions = decoder.decodeStringElement(descriptor, i)
        10 ->
          _postConditions =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        11 -> step = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.stepSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Process: " + i)
      }
    }
    return ExampleScenario.Process(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title =
        R4String.of(title, _title)
          ?: throw SerializationException(
            "Missing required property 'title' on ExampleScenario.Process"
          ),
      description = Markdown.of(description, _description),
      preConditions = Markdown.of(preConditions, _preConditions),
      postConditions = Markdown.of(postConditions, _postConditions),
      step = step ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExampleScenario.Process) {
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
    ((value.title.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.titleSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.titleSer, it)
    }
    ((value.preConditions?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.preConditions?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.titleSer, it)
    }
    ((value.postConditions?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.postConditions?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.titleSer, it)
    }
    if (value.step.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.stepSer, value.step)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val stepSerInner: KSerializer<ExampleScenario.Process.Step> =
      ExampleScenario.Process.Step.serializer()

    public val stepSer: KSerializer<List<ExampleScenario.Process.Step>> =
      ListSerializer(Hoisted.stepSerInner)
  }
}

internal object ExampleScenarioProcessStepSerializer : KSerializer<ExampleScenario.Process.Step> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Step") {
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
        "process",
        listSerialDescriptor(lazyDescriptor { ExampleScenario.Process.serializer().descriptor }),
        isOptional = true,
      )
      element("pause", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_pause", Element.serializer().descriptor, isOptional = true)
      element(
        "operation",
        lazyDescriptor { ExampleScenario.Process.Step.Operation.serializer().descriptor },
        isOptional = true,
      )
      element(
        "alternative",
        listSerialDescriptor(
          lazyDescriptor { ExampleScenario.Process.Step.Alternative.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExampleScenario.Process.Step {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var process: List<ExampleScenario.Process>? = null
    var pause: KotlinBoolean? = null
    var _pause: Element? = null
    var operation: ExampleScenario.Process.Step.Operation? = null
    var alternative: List<ExampleScenario.Process.Step.Alternative>? = null
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
          process =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processSer, null)
        4 -> pause = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _pause = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pauseSer, null)
        6 ->
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        7 ->
          alternative =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.alternativeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Step: " + i)
      }
    }
    return ExampleScenario.Process.Step(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      process = process ?: listOf(),
      pause = R4Boolean.of(pause, _pause),
      operation = operation,
      alternative = alternative ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExampleScenario.Process.Step) {
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
    if (value.process.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.processSer, value.process)
    ((value.pause?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.pause?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.pauseSer, it)
    }
    (value.operation)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.operationSer, it)
    }
    if (value.alternative.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.alternativeSer, value.alternative)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val processSerInner: KSerializer<ExampleScenario.Process> =
      ExampleScenario.Process.serializer()

    public val processSer: KSerializer<List<ExampleScenario.Process>> =
      ListSerializer(Hoisted.processSerInner)

    public val pauseSer: KSerializer<Element> = Element.serializer()

    public val operationSer: KSerializer<ExampleScenario.Process.Step.Operation> =
      ExampleScenario.Process.Step.Operation.serializer()

    public val alternativeSerInner: KSerializer<ExampleScenario.Process.Step.Alternative> =
      ExampleScenario.Process.Step.Alternative.serializer()

    public val alternativeSer: KSerializer<List<ExampleScenario.Process.Step.Alternative>> =
      ListSerializer(Hoisted.alternativeSerInner)
  }
}

internal object ExampleScenarioProcessStepOperationSerializer :
  KSerializer<ExampleScenario.Process.Step.Operation> {
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
      element("number", KotlinString.serializer().descriptor, isOptional = true)
      element("_number", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("initiator", KotlinString.serializer().descriptor, isOptional = true)
      element("_initiator", Element.serializer().descriptor, isOptional = true)
      element("receiver", KotlinString.serializer().descriptor, isOptional = true)
      element("_receiver", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("initiatorActive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_initiatorActive", Element.serializer().descriptor, isOptional = true)
      element("receiverActive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_receiverActive", Element.serializer().descriptor, isOptional = true)
      element(
        "request",
        lazyDescriptor { ExampleScenario.Instance.ContainedInstance.serializer().descriptor },
        isOptional = true,
      )
      element(
        "response",
        lazyDescriptor { ExampleScenario.Instance.ContainedInstance.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Operation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Operation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExampleScenario.Process.Step.Operation {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> number = decoder.decodeStringElement(descriptor, i)
        4 ->
          _number =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        5 -> type = decoder.decodeStringElement(descriptor, i)
        6 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        7 -> name = decoder.decodeStringElement(descriptor, i)
        8 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        9 -> initiator = decoder.decodeStringElement(descriptor, i)
        10 ->
          _initiator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        11 -> `receiver` = decoder.decodeStringElement(descriptor, i)
        12 ->
          _receiver =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        13 -> description = decoder.decodeStringElement(descriptor, i)
        14 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        15 -> initiatorActive = decoder.decodeBooleanElement(descriptor, i)
        16 ->
          _initiatorActive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        17 -> receiverActive = decoder.decodeBooleanElement(descriptor, i)
        18 ->
          _receiverActive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        19 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        20 ->
          response =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + i)
      }
    }
    return ExampleScenario.Process.Step.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      number =
        R4String.of(number, _number)
          ?: throw SerializationException(
            "Missing required property 'number' on ExampleScenario.Process.Step.Operation"
          ),
      type = R4String.of(type, _type),
      name = R4String.of(name, _name),
      initiator = R4String.of(initiator, _initiator),
      `receiver` = R4String.of(`receiver`, _receiver),
      description = Markdown.of(description, _description),
      initiatorActive = R4Boolean.of(initiatorActive, _initiatorActive),
      receiverActive = R4Boolean.of(receiverActive, _receiverActive),
      request = request,
      response = response,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExampleScenario.Process.Step.Operation,
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
    ((value.number.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.number.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.numberSer, it)
    }
    ((value.type?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.numberSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.numberSer, it)
    }
    ((value.initiator?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.initiator?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.numberSer, it)
    }
    ((value.`receiver`?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.`receiver`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.numberSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.numberSer, it)
    }
    ((value.initiatorActive?.value))?.let { encoder.encodeBooleanElement(descriptor, 15, it) }
    (value.initiatorActive?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.numberSer, it)
    }
    ((value.receiverActive?.value))?.let { encoder.encodeBooleanElement(descriptor, 17, it) }
    (value.receiverActive?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.numberSer, it)
    }
    (value.request)?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.requestSer, it)
    }
    (value.response)?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.requestSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val numberSer: KSerializer<Element> = Element.serializer()

    public val requestSer: KSerializer<ExampleScenario.Instance.ContainedInstance> =
      ExampleScenario.Instance.ContainedInstance.serializer()
  }
}

internal object ExampleScenarioProcessStepAlternativeSerializer :
  KSerializer<ExampleScenario.Process.Step.Alternative> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Alternative") {
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
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "step",
        listSerialDescriptor(
          lazyDescriptor { ExampleScenario.Process.Step.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Alternative =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Alternative) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExampleScenario.Process.Step.Alternative {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var step: List<ExampleScenario.Process.Step>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> title = decoder.decodeStringElement(descriptor, i)
        4 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        7 -> step = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.stepSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Alternative: " + i)
      }
    }
    return ExampleScenario.Process.Step.Alternative(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title =
        R4String.of(title, _title)
          ?: throw SerializationException(
            "Missing required property 'title' on ExampleScenario.Process.Step.Alternative"
          ),
      description = Markdown.of(description, _description),
      step = step ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExampleScenario.Process.Step.Alternative,
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
    ((value.title.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.titleSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.titleSer, it)
    }
    if (value.step.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.stepSer, value.step)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val stepSerInner: KSerializer<ExampleScenario.Process.Step> =
      ExampleScenario.Process.Step.serializer()

    public val stepSer: KSerializer<List<ExampleScenario.Process.Step>> =
      ListSerializer(Hoisted.stepSerInner)
  }
}

internal object ExampleScenarioSerializer : KSerializer<ExampleScenario> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ExampleScenario") {
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
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
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
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element(
      "actor",
      listSerialDescriptor(lazyDescriptor { ExampleScenario.Actor.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "instance",
      listSerialDescriptor(lazyDescriptor { ExampleScenario.Instance.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "process",
      listSerialDescriptor(lazyDescriptor { ExampleScenario.Process.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "workflow",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_workflow", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ExampleScenario")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> status = decoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        20 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> date = decoder.decodeStringElement(descriptor, i)
        22 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> publisher = decoder.decodeStringElement(descriptor, i)
        24 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        26 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        27 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        28 -> copyright = decoder.decodeStringElement(descriptor, i)
        29 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 -> purpose = decoder.decodeStringElement(descriptor, i)
        31 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        33 ->
          instance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instanceSer, null)
        34 ->
          process =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processSer, null)
        35 ->
          workflow =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.workflowSer, null)
        36 ->
          _workflow =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.workflowSer2, null)
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on ExampleScenario"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
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
          Canonical.of(workflow?.getOrNull(index)?.let { it }, _workflow?.getOrNull(index))!!
        }),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ExampleScenario,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.actorSer,
        value.actor,
      )
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.instanceSer,
        value.instance,
      )
    if (value.process.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.processSer,
        value.process,
      )
    (value.workflow.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, Hoisted.workflowSer, it)
    }
    (value.workflow.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 36 + descriptorOffset, Hoisted.workflowSer2, it)
    }
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

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val actorSerInner: KSerializer<ExampleScenario.Actor> =
      ExampleScenario.Actor.serializer()

    public val actorSer: KSerializer<List<ExampleScenario.Actor>> =
      ListSerializer(Hoisted.actorSerInner)

    public val instanceSerInner: KSerializer<ExampleScenario.Instance> =
      ExampleScenario.Instance.serializer()

    public val instanceSer: KSerializer<List<ExampleScenario.Instance>> =
      ListSerializer(Hoisted.instanceSerInner)

    public val processSerInner: KSerializer<ExampleScenario.Process> =
      ExampleScenario.Process.serializer()

    public val processSer: KSerializer<List<ExampleScenario.Process>> =
      ListSerializer(Hoisted.processSerInner)

    public val workflowSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val workflowSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.workflowSerInner).nullable)

    public val workflowSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)
  }
}

internal object ExampleScenarioPolymorphicSerializer : KSerializer<ExampleScenario> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ExampleScenario") {
      ExampleScenarioSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario) {
    encoder.encodeStructure(descriptor) {
      ExampleScenarioSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ExampleScenario =
    decoder.decodeStructure(descriptor) {
      ExampleScenarioSerializer.deserializeInternal(this, descriptor, 0)
    }
}
