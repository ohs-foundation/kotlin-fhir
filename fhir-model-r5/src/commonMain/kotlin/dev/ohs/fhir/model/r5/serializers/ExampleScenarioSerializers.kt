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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
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
      element("key", KotlinString.serializer().descriptor, isOptional = true)
      element("_key", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
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
    var key: KotlinString? = null
    var _key: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
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
        3 -> key = decoder.decodeStringElement(descriptor, i)
        4 -> _key = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        5 -> type = decoder.decodeStringElement(descriptor, i)
        6 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        7 -> title = decoder.decodeStringElement(descriptor, i)
        8 -> _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        9 -> description = decoder.decodeStringElement(descriptor, i)
        10 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Actor: " + i)
      }
    }
    return ExampleScenario.Actor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      key = R5String.of(key, _key)!!,
      type = Enumeration.of(ExampleScenario.ExampleScenarioActorType.fromCode(type!!), _type),
      title = R5String.of(title, _title)!!,
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
    ((value.key.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.key.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.keySer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.keySer, it)
    }
    ((value.title.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.keySer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.keySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val keySer: KSerializer<Element> = Element.serializer()
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
      element("key", KotlinString.serializer().descriptor, isOptional = true)
      element("_key", Element.serializer().descriptor, isOptional = true)
      element("structureType", Coding.serializer().descriptor, isOptional = true)
      element("structureVersion", KotlinString.serializer().descriptor, isOptional = true)
      element("_structureVersion", Element.serializer().descriptor, isOptional = true)
      element("structureProfileCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_structureProfileCanonical", Element.serializer().descriptor, isOptional = true)
      element("structureProfileUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_structureProfileUri", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("content", Reference.serializer().descriptor, isOptional = true)
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> key = decoder.decodeStringElement(descriptor, i)
        4 -> _key = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        5 ->
          structureType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.structureTypeSer, null)
        6 -> structureVersion = decoder.decodeStringElement(descriptor, i)
        7 ->
          _structureVersion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        8 -> structureProfileCanonical = decoder.decodeStringElement(descriptor, i)
        9 ->
          _structureProfileCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        10 -> structureProfileUri = decoder.decodeStringElement(descriptor, i)
        11 ->
          _structureProfileUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        12 -> title = decoder.decodeStringElement(descriptor, i)
        13 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        14 -> description = decoder.decodeStringElement(descriptor, i)
        15 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        16 ->
          content =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentSer, null)
        17 ->
          version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionSer, null)
        18 ->
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
      key = R5String.of(key, _key)!!,
      structureType = structureType!!,
      structureVersion = R5String.of(structureVersion, _structureVersion),
      structureProfile =
        ExampleScenario.Instance.StructureProfile.from(
          Canonical.of(structureProfileCanonical, _structureProfileCanonical),
          Uri.of(structureProfileUri, _structureProfileUri),
        ),
      title = R5String.of(title, _title)!!,
      description = Markdown.of(description, _description),
      content = content,
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
    ((value.key.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.key.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.keySer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.structureTypeSer, value.structureType)
    ((value.structureVersion?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.structureVersion?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.keySer, it)
    }
    when (val choice = value.structureProfile) {
      null -> {}
      is ExampleScenario.Instance.StructureProfile.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.keySer, it)
        }
      }
      is ExampleScenario.Instance.StructureProfile.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.keySer, it)
        }
      }
    }
    ((value.title.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.keySer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.keySer, it)
    }
    (value.content)?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.contentSer, it)
    }
    if (value.version.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.versionSer, value.version)
    if (value.containedInstance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18,
        Hoisted.containedInstanceSer,
        value.containedInstance,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val keySer: KSerializer<Element> = Element.serializer()

    public val structureTypeSer: KSerializer<Coding> = Coding.serializer()

    public val contentSer: KSerializer<Reference> = Reference.serializer()

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
      element("key", KotlinString.serializer().descriptor, isOptional = true)
      element("_key", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("content", Reference.serializer().descriptor, isOptional = true)
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
    var key: KotlinString? = null
    var _key: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var content: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> key = decoder.decodeStringElement(descriptor, i)
        4 -> _key = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        5 -> title = decoder.decodeStringElement(descriptor, i)
        6 -> _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        7 -> description = decoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.keySer, null)
        9 ->
          content =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + i)
      }
    }
    return ExampleScenario.Instance.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      key = R5String.of(key, _key)!!,
      title = R5String.of(title, _title)!!,
      description = Markdown.of(description, _description),
      content = content,
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
    ((value.key.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.key.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.keySer, it)
    }
    ((value.title.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.keySer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.keySer, it)
    }
    (value.content)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.contentSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val keySer: KSerializer<Element> = Element.serializer()

    public val contentSer: KSerializer<Reference> = Reference.serializer()
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
      element("instanceReference", KotlinString.serializer().descriptor, isOptional = true)
      element("_instanceReference", Element.serializer().descriptor, isOptional = true)
      element("versionReference", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionReference", Element.serializer().descriptor, isOptional = true)
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
    var instanceReference: KotlinString? = null
    var _instanceReference: Element? = null
    var versionReference: KotlinString? = null
    var _versionReference: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> instanceReference = decoder.decodeStringElement(descriptor, i)
        4 ->
          _instanceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instanceReferenceSer,
              null,
            )
        5 -> versionReference = decoder.decodeStringElement(descriptor, i)
        6 ->
          _versionReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instanceReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContainedInstance: " + i)
      }
    }
    return ExampleScenario.Instance.ContainedInstance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      instanceReference = R5String.of(instanceReference, _instanceReference)!!,
      versionReference = R5String.of(versionReference, _versionReference),
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
    ((value.instanceReference.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.instanceReference.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.instanceReferenceSer, it)
    }
    ((value.versionReference?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.versionReference?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.instanceReferenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val instanceReferenceSer: KSerializer<Element> = Element.serializer()
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
      title = R5String.of(title, _title)!!,
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
      element("number", KotlinString.serializer().descriptor, isOptional = true)
      element("_number", Element.serializer().descriptor, isOptional = true)
      element(
        "process",
        lazyDescriptor { ExampleScenario.Process.serializer().descriptor },
        isOptional = true,
      )
      element("workflow", KotlinString.serializer().descriptor, isOptional = true)
      element("_workflow", Element.serializer().descriptor, isOptional = true)
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
      element("pause", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_pause", Element.serializer().descriptor, isOptional = true)
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
        5 ->
          process =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processSer, null)
        6 -> workflow = decoder.decodeStringElement(descriptor, i)
        7 ->
          _workflow =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        8 ->
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        9 ->
          alternative =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.alternativeSer, null)
        10 -> pause = decoder.decodeBooleanElement(descriptor, i)
        11 ->
          _pause = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Step: " + i)
      }
    }
    return ExampleScenario.Process.Step(
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
    ((value.number?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.numberSer, it)
    }
    (value.process)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.processSer, it)
    }
    ((value.workflow?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.workflow?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.numberSer, it)
    }
    (value.operation)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.operationSer, it)
    }
    if (value.alternative.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.alternativeSer, value.alternative)
    ((value.pause?.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
    (value.pause?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.numberSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val numberSer: KSerializer<Element> = Element.serializer()

    public val processSer: KSerializer<ExampleScenario.Process> =
      ExampleScenario.Process.serializer()

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
      element("type", Coding.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> title = decoder.decodeStringElement(descriptor, i)
        5 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        6 -> initiator = decoder.decodeStringElement(descriptor, i)
        7 ->
          _initiator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        8 -> `receiver` = decoder.decodeStringElement(descriptor, i)
        9 ->
          _receiver =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        10 -> description = decoder.decodeStringElement(descriptor, i)
        11 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        12 -> initiatorActive = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _initiatorActive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        14 -> receiverActive = decoder.decodeBooleanElement(descriptor, i)
        15 ->
          _receiverActive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        16 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        17 ->
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
      type = type,
      title = R5String.of(title, _title)!!,
      initiator = R5String.of(initiator, _initiator),
      `receiver` = R5String.of(`receiver`, _receiver),
      description = Markdown.of(description, _description),
      initiatorActive = R5Boolean.of(initiatorActive, _initiatorActive),
      receiverActive = R5Boolean.of(receiverActive, _receiverActive),
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    ((value.title.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.titleSer, it)
    }
    ((value.initiator?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.initiator?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.titleSer, it)
    }
    ((value.`receiver`?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.`receiver`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.titleSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.titleSer, it)
    }
    ((value.initiatorActive?.value))?.let { encoder.encodeBooleanElement(descriptor, 12, it) }
    (value.initiatorActive?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.titleSer, it)
    }
    ((value.receiverActive?.value))?.let { encoder.encodeBooleanElement(descriptor, 14, it) }
    (value.receiverActive?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.titleSer, it)
    }
    (value.request)?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.requestSer, it)
    }
    (value.response)?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.requestSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Coding> = Coding.serializer()

    public val titleSer: KSerializer<Element> = Element.serializer()

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
      title = R5String.of(title, _title)!!,
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
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        42 ->
          instance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instanceSer, null)
        43 ->
          process =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processSer, null)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
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
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is ExampleScenario.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ExampleScenario.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.actorSer,
        value.actor,
      )
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.instanceSer,
        value.instance,
      )
    if (value.process.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.processSer,
        value.process,
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
