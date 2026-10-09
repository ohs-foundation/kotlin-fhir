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
import dev.ohs.fhir.model.r5.terminologies.ExampleScenarioActorType
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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
    b.strPrim("key")
    b.strPrim("type")
    b.strPrim("title")
    b.strPrim("description")
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Actor {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var key: KotlinString? = null
    var _key: Element? = null
    var type: ExampleScenarioActorType? = null
    var _type: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
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
        3 -> key = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _key =
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
        7 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _title =
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
      key = required(R5String.of(key, _key), "ExampleScenario.Actor", "key"),
      type = required(Enumeration.of(type, _type), "ExampleScenario.Actor", "type"),
      title = required(R5String.of(title, _title), "ExampleScenario.Actor", "title"),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.key.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.key)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.title.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.title)
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
    b.strPrim("key")
    b.optionalElement("structureType", CodingSerializer.descriptor)
    b.strPrim("structureVersion")
    b.strPrim("structureProfileCanonical")
    b.strPrim("structureProfileUri")
    b.strPrim("title")
    b.strPrim("description")
    b.optionalElement("content", ReferenceSerializer.descriptor)
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
        3 -> key = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _key =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          structureType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        6 -> structureVersion = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _structureVersion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> structureProfileCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _structureProfileCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> structureProfileUri = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _structureProfileUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          content =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 ->
          version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceVersionSerializer.listSerializer,
              null,
            )
        18 ->
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
      key = required(R5String.of(key, _key), "ExampleScenario.Instance", "key"),
      structureType = required(structureType, "ExampleScenario.Instance", "structureType"),
      structureVersion = R5String.of(structureVersion, _structureVersion),
      structureProfile =
        ExampleScenario.Instance.StructureProfile.from(
          Canonical.of(structureProfileCanonical, _structureProfileCanonical),
          Uri.of(structureProfileUri, _structureProfileUri),
        ),
      title = required(R5String.of(title, _title), "ExampleScenario.Instance", "title"),
      description = Markdown.of(description, _description),
      content = content,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.key.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.key)
    compositeEncoder.encodeSerializableElement(descriptor, 5, CodingSerializer, value.structureType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.structureVersion?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.structureVersion)
    when (val choice = value.structureProfile) {
      null -> {}
      is ExampleScenario.Instance.StructureProfile.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is ExampleScenario.Instance.StructureProfile.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.title.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.description)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 16, ReferenceSerializer, value.content)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17,
      ExampleScenarioInstanceVersionSerializer.listSerializer,
      value.version,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18,
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
    b.strPrim("key")
    b.strPrim("title")
    b.strPrim("description")
    b.optionalElement("content", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.Version {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> key = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _key =
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
        7 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          content =
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
    return ExampleScenario.Instance.Version(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      key = required(R5String.of(key, _key), "ExampleScenario.Instance.Version", "key"),
      title = required(R5String.of(title, _title), "ExampleScenario.Instance.Version", "title"),
      description = Markdown.of(description, _description),
      content = content,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.key.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.key)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.title.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.description)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 9, ReferenceSerializer, value.content)
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
    b.strPrim("instanceReference")
    b.strPrim("versionReference")
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.ContainedInstance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instanceReference: KotlinString? = null
    var _instanceReference: Element? = null
    var versionReference: KotlinString? = null
    var _versionReference: Element? = null
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
        3 -> instanceReference = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _instanceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> versionReference = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _versionReference =
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
      instanceReference =
        required(
          R5String.of(instanceReference, _instanceReference),
          "ExampleScenario.Instance.ContainedInstance",
          "instanceReference",
        ),
      versionReference = R5String.of(versionReference, _versionReference),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.instanceReference.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.instanceReference)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.versionReference?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.versionReference)
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
      title = required(R5String.of(title, _title), "ExampleScenario.Process", "title"),
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
    b.strPrim("number")
    b.optionalElement("process", lazyDescriptor(LazyDescriptorId.ExampleScenarioProcessSerializer))
    b.strPrim("workflow")
    b.optionalElement("operation", ExampleScenarioProcessStepOperationSerializer.descriptor)
    b.optionalElement(
      "alternative",
      ExampleScenarioProcessStepAlternativeSerializer.listSerializer.descriptor,
    )
    b.boolPrim("pause")
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        5 ->
          process =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessSerializer,
              null,
            )
        6 -> workflow = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _workflow =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessStepOperationSerializer,
              null,
            )
        9 ->
          alternative =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessStepAlternativeSerializer.listSerializer,
              null,
            )
        10 -> pause = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _pause =
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
    return ExampleScenario.Process.Step(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      number = R5String.of(number, _number),
      process = process,
      workflow = Canonical.of(workflow, _workflow),
      operation = operation,
      alternative = listOrEmpty(alternative),
      pause = R5Boolean.of(pause, _pause),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.number?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.number)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      ExampleScenarioProcessSerializer,
      value.process,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.workflow?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.workflow)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      ExampleScenarioProcessStepOperationSerializer,
      value.operation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      ExampleScenarioProcessStepAlternativeSerializer.listSerializer,
      value.alternative,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, value.pause?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.pause)
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
    b.optionalElement("type", CodingSerializer.descriptor)
    b.strPrim("title")
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        4 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> initiator = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _initiator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> `receiver` = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _receiver =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> initiatorActive = compositeDecoder.decodeBooleanElement(descriptor, i)
        13 ->
          _initiatorActive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> receiverActive = compositeDecoder.decodeBooleanElement(descriptor, i)
        15 ->
          _receiverActive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          request =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceContainedInstanceSerializer,
              null,
            )
        17 ->
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
      type = type,
      title =
        required(R5String.of(title, _title), "ExampleScenario.Process.Step.Operation", "title"),
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
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, CodingSerializer, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.title.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.initiator?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.initiator)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.`receiver`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.`receiver`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.description)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 12, value.initiatorActive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.initiatorActive)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 14, value.receiverActive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.receiverActive)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16,
      ExampleScenarioInstanceContainedInstanceSerializer,
      value.request,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17,
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
        required(R5String.of(title, _title), "ExampleScenario.Process.Step.Alternative", "title"),
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
    b.strPrim("versionAlgorithmString")
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
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
    b.strPrim("copyrightLabel")
    b.optionalElement("actor", ExampleScenarioActorSerializer.listSerializer.descriptor)
    b.optionalElement("instance", ExampleScenarioInstanceSerializer.listSerializer.descriptor)
    b.optionalElement("process", ExampleScenarioProcessSerializer.listSerializer.descriptor)
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var actor: List<ExampleScenario.Actor>? = null
    var instance: List<ExampleScenario.Instance>? = null
    var process: List<ExampleScenario.Process>? = null
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
        15 -> versionAlgorithmString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          versionAlgorithmCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        18 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        23 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        27 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> copyrightLabel = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioActorSerializer.listSerializer,
              null,
            )
        42 ->
          instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioInstanceSerializer.listSerializer,
              null,
            )
        43 ->
          process =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExampleScenarioProcessSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        ExampleScenario.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status = required(Enumeration.of(status, _status), "ExampleScenario", "status"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      actor = listOrEmpty(actor),
      instance = listOrEmpty(instance),
      process = listOrEmpty(process),
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
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is ExampleScenario.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is ExampleScenario.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.copyrightLabel?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyrightLabel)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      41 + descriptorOffset,
      ExampleScenarioActorSerializer.listSerializer,
      value.actor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      42 + descriptorOffset,
      ExampleScenarioInstanceSerializer.listSerializer,
      value.instance,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      43 + descriptorOffset,
      ExampleScenarioProcessSerializer.listSerializer,
      value.process,
    )
  }
}
