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
import dev.ohs.fhir.model.r4b.terminologies.ExampleScenarioActorType
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
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

internal object ExampleScenarioActorSerializer : FhirSerializer<ExampleScenario.Actor> {
  override val descriptor: SerialDescriptor = buildDescriptor("Actor", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExampleScenario.Actor>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("actorId")
    b.strPrim("type")
    b.strPrim("name")
    b.strPrim("description")
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Actor {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var actorId: KotlinString? = null
    var _actorId: Element? = null
    var type: ExampleScenarioActorType? = null
    var _type: Element? = null
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
        3 -> actorId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _actorId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          type =
            ExampleScenarioActorType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
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
    return ExampleScenario.Actor(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      actorId = required(R4bString.of(actorId, _actorId), "ExampleScenario.Actor", "actorId"),
      type = required(Enumeration.of(type, _type), "ExampleScenario.Actor", "type"),
      name = R4bString.of(name, _name),
      description = Markdown.of(description, _description),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Actor) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.actorId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.actorId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.description)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExampleScenarioInstanceSerializer : FhirSerializer<ExampleScenario.Instance> {
  override val descriptor: SerialDescriptor = buildDescriptor("Instance", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExampleScenario.Instance>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("resourceId")
    b.strPrim("resourceType")
    b.strPrim("name")
    b.strPrim("description")
    b.optionalElement("version", ExampleScenarioInstanceVersionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "containedInstance",
      ExampleScenarioInstanceContainedInstanceSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var resourceId: KotlinString? = null
    var _resourceId: Element? = null
    var resourceType: ResourceType? = null
    var _resourceType: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var version: List<ExampleScenario.Instance.Version>? = null
    var containedInstance: List<ExampleScenario.Instance.ContainedInstance>? = null
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
        3 -> resourceId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _resourceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          resourceType = ResourceType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _resourceType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceVersionSerializer.listSerializer,
              null,
            )
        12 ->
          containedInstance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceContainedInstanceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExampleScenario.Instance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      resourceId =
        required(R4bString.of(resourceId, _resourceId), "ExampleScenario.Instance", "resourceId"),
      resourceType =
        required(
          Enumeration.of(resourceType, _resourceType),
          "ExampleScenario.Instance",
          "resourceType",
        ),
      name = R4bString.of(name, _name),
      description = Markdown.of(description, _description),
      version = listOrEmpty(version),
      containedInstance = listOrEmpty(containedInstance),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.resourceId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.resourceId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.resourceType.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.resourceType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ExampleScenarioInstanceVersionSerializer.listSerializer,
      value.version,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      ExampleScenarioInstanceContainedInstanceSerializer.listSerializer,
      value.containedInstance,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExampleScenarioInstanceVersionSerializer :
  FhirSerializer<ExampleScenario.Instance.Version> {
  override val descriptor: SerialDescriptor = buildDescriptor("Version", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExampleScenario.Instance.Version>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("versionId")
    b.strPrim("description")
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.Version {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var versionId: KotlinString? = null
    var _versionId: Element? = null
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
        3 -> versionId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _versionId =
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
    return ExampleScenario.Instance.Version(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      versionId =
        required(
          R4bString.of(versionId, _versionId),
          "ExampleScenario.Instance.Version",
          "versionId",
        ),
      description =
        required(
          Markdown.of(description, _description),
          "ExampleScenario.Instance.Version",
          "description",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.Version) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.versionId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.versionId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExampleScenarioInstanceContainedInstanceSerializer :
  FhirSerializer<ExampleScenario.Instance.ContainedInstance> {
  override val descriptor: SerialDescriptor = buildDescriptor("ContainedInstance", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExampleScenario.Instance.ContainedInstance>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("resourceId")
    b.strPrim("versionId")
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.ContainedInstance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var resourceId: KotlinString? = null
    var _resourceId: Element? = null
    var versionId: KotlinString? = null
    var _versionId: Element? = null
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
        3 -> resourceId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _resourceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> versionId = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _versionId =
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
    return ExampleScenario.Instance.ContainedInstance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      resourceId =
        required(
          R4bString.of(resourceId, _resourceId),
          "ExampleScenario.Instance.ContainedInstance",
          "resourceId",
        ),
      versionId = R4bString.of(versionId, _versionId),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.ContainedInstance) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.resourceId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.resourceId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.versionId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.versionId)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExampleScenarioProcessSerializer : FhirSerializer<ExampleScenario.Process> {
  override val descriptor: SerialDescriptor = buildDescriptor("Process", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExampleScenario.Process>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("title")
    b.strPrim("description")
    b.strPrim("preConditions")
    b.strPrim("postConditions")
    b.optionalElement("step", ExampleScenarioProcessStepSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _title =
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
        7 -> preConditions = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _preConditions =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> postConditions = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _postConditions =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          step =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessStepSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExampleScenario.Process(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      title = required(R4bString.of(title, _title), "ExampleScenario.Process", "title"),
      description = Markdown.of(description, _description),
      preConditions = Markdown.of(preConditions, _preConditions),
      postConditions = Markdown.of(postConditions, _postConditions),
      step = listOrEmpty(step),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.title.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.preConditions?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.preConditions)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.postConditions?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.postConditions)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ExampleScenarioProcessStepSerializer.listSerializer,
      value.step,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExampleScenarioProcessStepSerializer :
  FhirSerializer<ExampleScenario.Process.Step> {
  override val descriptor: SerialDescriptor = buildDescriptor("Step", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExampleScenario.Process.Step>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "process",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExampleScenarioProcessSerializer)),
    )
    b.boolPrim("pause")
    b.optionalElement("operation", ExampleScenarioProcessStepOperationSerializer.descriptor)
    b.optionalElement(
      "alternative",
      ExampleScenarioProcessStepAlternativeSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var process: List<ExampleScenario.Process>? = null
    var pause: KotlinBoolean? = null
    var _pause: Element? = null
    var operation: ExampleScenario.Process.Step.Operation? = null
    var alternative: List<ExampleScenario.Process.Step.Alternative>? = null
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
          process =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessSerializer.listSerializer,
              null,
            )
        4 -> pause = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _pause =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessStepOperationSerializer,
              null,
            )
        7 ->
          alternative =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessStepAlternativeSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExampleScenario.Process.Step(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      process = listOrEmpty(process),
      pause = R4bBoolean.of(pause, _pause),
      operation = operation,
      alternative = listOrEmpty(alternative),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step) {
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
      ExampleScenarioProcessSerializer.listSerializer,
      value.process,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.pause?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.pause)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      ExampleScenarioProcessStepOperationSerializer,
      value.operation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ExampleScenarioProcessStepAlternativeSerializer.listSerializer,
      value.alternative,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExampleScenarioProcessStepOperationSerializer :
  FhirSerializer<ExampleScenario.Process.Step.Operation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Operation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExampleScenario.Process.Step.Operation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("number")
    b.strPrim("type")
    b.strPrim("name")
    b.strPrim("initiator")
    b.strPrim("receiver")
    b.strPrim("description")
    b.boolPrim("initiatorActive")
    b.boolPrim("receiverActive")
    b.optionalElement(
      "request",
      lazyDescriptor(LazyDescriptorId.ExampleScenarioInstanceContainedInstanceSerializer),
    )
    b.optionalElement(
      "response",
      lazyDescriptor(LazyDescriptorId.ExampleScenarioInstanceContainedInstanceSerializer),
    )
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Operation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> number = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _number =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> initiator = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _initiator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> `receiver` = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _receiver =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> initiatorActive = compositeDecoder.decodeBooleanElement(descriptor, i)
        16 ->
          _initiatorActive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> receiverActive = compositeDecoder.decodeBooleanElement(descriptor, i)
        18 ->
          _receiverActive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          request =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceContainedInstanceSerializer,
              null,
            )
        20 ->
          response =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceContainedInstanceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExampleScenario.Process.Step.Operation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      number =
        required(R4bString.of(number, _number), "ExampleScenario.Process.Step.Operation", "number"),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.number.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.number)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.initiator?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.initiator)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.`receiver`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.`receiver`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.description)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 15, value.initiatorActive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.initiatorActive)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 17, value.receiverActive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.receiverActive)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19,
      ExampleScenarioInstanceContainedInstanceSerializer,
      value.request,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20,
      ExampleScenarioInstanceContainedInstanceSerializer,
      value.response,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExampleScenarioProcessStepAlternativeSerializer :
  FhirSerializer<ExampleScenario.Process.Step.Alternative> {
  override val descriptor: SerialDescriptor = buildDescriptor("Alternative", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExampleScenario.Process.Step.Alternative>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("title")
    b.strPrim("description")
    b.optionalElement(
      "step",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExampleScenarioProcessStepSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Alternative {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var step: List<ExampleScenario.Process.Step>? = null
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
        3 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _title =
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
        7 ->
          step =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessStepSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExampleScenario.Process.Step.Alternative(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      title =
        required(R4bString.of(title, _title), "ExampleScenario.Process.Step.Alternative", "title"),
      description = Markdown.of(description, _description),
      step = listOrEmpty(step),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Alternative) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.title.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ExampleScenarioProcessStepSerializer.listSerializer,
      value.step,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExampleScenarioSerializer : FhirResourceSerializer<ExampleScenario> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ExampleScenario")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("version")
    b.strPrim("name")
    b.strPrim("status")
    b.boolPrim("experimental")
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("copyright")
    b.strPrim("purpose")
    b.optionalElement("actor", ExampleScenarioActorSerializer.listSerializer.descriptor)
    b.optionalElement("instance", ExampleScenarioInstanceSerializer.listSerializer.descriptor)
    b.optionalElement("process", ExampleScenarioProcessSerializer.listSerializer.descriptor)
    b.strPrimList("workflow")
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: PublicationStatus? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: FhirDateTime? = null
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
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        20 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        22 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        26 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        27 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        28 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioActorSerializer.listSerializer,
              null,
            )
        33 ->
          instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceSerializer.listSerializer,
              null,
            )
        34 ->
          process =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessSerializer.listSerializer,
              null,
            )
        35 ->
          workflow =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        36 ->
          _workflow =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val workflow_ =
      List(maxSize(workflow, _workflow)) { index ->
        entryRequired(
          Canonical.of(at(workflow, index), at(_workflow, index)),
          "ExampleScenario",
          "workflow",
        )
      }
    return ExampleScenario(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      identifier = listOrEmpty(identifier),
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      status = required(Enumeration.of(status, _status), "ExampleScenario", "status"),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      copyright = Markdown.of(copyright, _copyright),
      purpose = Markdown.of(purpose, _purpose),
      actor = listOrEmpty(actor),
      instance = listOrEmpty(instance),
      process = listOrEmpty(process),
      workflow = workflow_,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ExampleScenario,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      26 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.purpose)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ExampleScenarioActorSerializer.listSerializer,
      value.actor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      ExampleScenarioInstanceSerializer.listSerializer,
      value.instance,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      ExampleScenarioProcessSerializer.listSerializer,
      value.process,
    )
    if (!value.workflow.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        35 + descriptorOffset,
        stringNullableListSerializer,
        value.workflow.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 36 + descriptorOffset, value.workflow)
    }
  }
}
