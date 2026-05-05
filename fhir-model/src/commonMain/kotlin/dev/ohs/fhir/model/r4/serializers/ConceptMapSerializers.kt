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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ConceptMap
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
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
import dev.ohs.fhir.model.r4.terminologies.ConceptMapEquivalence
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object ConceptMapGroupSerializer : KSerializer<ConceptMap.Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
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
      element("source", KotlinString.serializer().descriptor, isOptional = true)
      element("_source", Element.serializer().descriptor, isOptional = true)
      element("sourceVersion", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceVersion", Element.serializer().descriptor, isOptional = true)
      element("target", KotlinString.serializer().descriptor, isOptional = true)
      element("_target", Element.serializer().descriptor, isOptional = true)
      element("targetVersion", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetVersion", Element.serializer().descriptor, isOptional = true)
      element(
        "element",
        listSerialDescriptor(lazyDescriptor { ConceptMap.Group.Element.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "unmapped",
        lazyDescriptor { ConceptMap.Group.Unmapped.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var sourceVersion: KotlinString? = null
    var _sourceVersion: Element? = null
    var target: KotlinString? = null
    var _target: Element? = null
    var targetVersion: KotlinString? = null
    var _targetVersion: Element? = null
    var element: List<ConceptMap.Group.Element>? = null
    var unmapped: ConceptMap.Group.Unmapped? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> source = decoder.decodeStringElement(__desc, __i)
        4 ->
          _source = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        5 -> sourceVersion = decoder.decodeStringElement(__desc, __i)
        6 ->
          _sourceVersion =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        7 -> target = decoder.decodeStringElement(__desc, __i)
        8 ->
          _target = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        9 -> targetVersion = decoder.decodeStringElement(__desc, __i)
        10 ->
          _targetVersion =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        11 ->
          element = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.elementSer, null)
        12 ->
          unmapped =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.unmappedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Group: " + __i)
      }
    }
    return ConceptMap.Group(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      source = Uri.of(source, _source),
      sourceVersion = R4String.of(sourceVersion, _sourceVersion),
      target = Uri.of(target, _target),
      targetVersion = R4String.of(targetVersion, _targetVersion),
      element = element ?: listOf(),
      unmapped = unmapped,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Group) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.source?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sourceSer, it)
    }
    ((value.sourceVersion?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.sourceVersion?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.sourceSer, it)
    }
    ((value.target?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.target?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.sourceSer, it)
    }
    ((value.targetVersion?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.targetVersion?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.sourceSer, it)
    }
    if (value.element.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.elementSer, value.element)
    (value.unmapped)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.unmappedSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sourceSer: KSerializer<Element> = Element.serializer()

    public val elementSerInner: KSerializer<ConceptMap.Group.Element> =
      ConceptMap.Group.Element.serializer()

    public val elementSer: KSerializer<List<ConceptMap.Group.Element>> =
      ListSerializer(Hoisted.elementSerInner)

    public val unmappedSer: KSerializer<ConceptMap.Group.Unmapped> =
      ConceptMap.Group.Unmapped.serializer()
  }
}

internal object ConceptMapGroupElementSerializer : KSerializer<ConceptMap.Group.Element> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Element") {
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
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
      element(
        "target",
        listSerialDescriptor(
          lazyDescriptor { ConceptMap.Group.Element.Target.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group.Element {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var target: List<ConceptMap.Group.Element.Target>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, __i)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> display = decoder.decodeStringElement(__desc, __i)
        6 ->
          _display = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        7 ->
          target = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Element: " + __i)
      }
    }
    return ConceptMap.Group.Element(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code),
      display = R4String.of(display, _display),
      target = target ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Group.Element) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.targetSer, value.target)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val targetSerInner: KSerializer<ConceptMap.Group.Element.Target> =
      ConceptMap.Group.Element.Target.serializer()

    public val targetSer: KSerializer<List<ConceptMap.Group.Element.Target>> =
      ListSerializer(Hoisted.targetSerInner)
  }
}

internal object ConceptMapGroupElementTargetSerializer :
  KSerializer<ConceptMap.Group.Element.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
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
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
      element("equivalence", KotlinString.serializer().descriptor, isOptional = true)
      element("_equivalence", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element(
        "dependsOn",
        listSerialDescriptor(
          lazyDescriptor { ConceptMap.Group.Element.Target.DependsOn.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "product",
        listSerialDescriptor(
          lazyDescriptor { ConceptMap.Group.Element.Target.DependsOn.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group.Element.Target {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var equivalence: KotlinString? = null
    var _equivalence: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var dependsOn: List<ConceptMap.Group.Element.Target.DependsOn>? = null
    var product: List<ConceptMap.Group.Element.Target.DependsOn>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, __i)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> display = decoder.decodeStringElement(__desc, __i)
        6 ->
          _display = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        7 -> equivalence = decoder.decodeStringElement(__desc, __i)
        8 ->
          _equivalence =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        9 -> comment = decoder.decodeStringElement(__desc, __i)
        10 ->
          _comment = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        11 ->
          dependsOn =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dependsOnSer, null)
        12 ->
          product =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dependsOnSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + __i)
      }
    }
    return ConceptMap.Group.Element.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code),
      display = R4String.of(display, _display),
      equivalence = Enumeration.of(ConceptMapEquivalence.fromCode(equivalence!!), _equivalence),
      comment = R4String.of(comment, _comment),
      dependsOn = dependsOn ?: listOf(),
      product = product ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Group.Element.Target) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    ((value.equivalence.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.equivalence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.codeSer, it)
    }
    if (value.dependsOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.dependsOnSer, value.dependsOn)
    if (value.product.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.dependsOnSer, value.product)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val dependsOnSerInner: KSerializer<ConceptMap.Group.Element.Target.DependsOn> =
      ConceptMap.Group.Element.Target.DependsOn.serializer()

    public val dependsOnSer: KSerializer<List<ConceptMap.Group.Element.Target.DependsOn>> =
      ListSerializer(Hoisted.dependsOnSerInner)
  }
}

internal object ConceptMapGroupElementTargetDependsOnSerializer :
  KSerializer<ConceptMap.Group.Element.Target.DependsOn> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DependsOn") {
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
      element("property", KotlinString.serializer().descriptor, isOptional = true)
      element("_property", Element.serializer().descriptor, isOptional = true)
      element("system", KotlinString.serializer().descriptor, isOptional = true)
      element("_system", Element.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target.DependsOn =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target.DependsOn) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ConceptMap.Group.Element.Target.DependsOn {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `property`: KotlinString? = null
    var _property: Element? = null
    var system: KotlinString? = null
    var _system: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> `property` = decoder.decodeStringElement(__desc, __i)
        4 ->
          _property =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        5 -> system = decoder.decodeStringElement(__desc, __i)
        6 ->
          _system =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        7 -> `value` = decoder.decodeStringElement(__desc, __i)
        8 ->
          _value = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        9 -> display = decoder.decodeStringElement(__desc, __i)
        10 ->
          _display =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DependsOn: " + __i)
      }
    }
    return ConceptMap.Group.Element.Target.DependsOn(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `property` = Uri.of(`property`, _property)!!,
      system = Canonical.of(system, _system),
      `value` = R4String.of(`value`, _value)!!,
      display = R4String.of(display, _display),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ConceptMap.Group.Element.Target.DependsOn,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.`property`.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.`property`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.propertySer, it)
    }
    ((value.system?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.propertySer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.propertySer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.propertySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val propertySer: KSerializer<Element> = Element.serializer()
  }
}

internal object ConceptMapGroupUnmappedSerializer : KSerializer<ConceptMap.Group.Unmapped> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Unmapped") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Unmapped =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Unmapped) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group.Unmapped {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(__desc, __i)
        4 -> _mode = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modeSer, null)
        5 -> code = decoder.decodeStringElement(__desc, __i)
        6 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modeSer, null)
        7 -> display = decoder.decodeStringElement(__desc, __i)
        8 ->
          _display = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modeSer, null)
        9 -> url = decoder.decodeStringElement(__desc, __i)
        10 -> _url = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Unmapped: " + __i)
      }
    }
    return ConceptMap.Group.Unmapped(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = Enumeration.of(ConceptMap.ConceptMapGroupUnmappedMode.fromCode(mode!!), _mode),
      code = Code.of(code, _code),
      display = R4String.of(display, _display),
      url = Canonical.of(url, _url),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Group.Unmapped) {
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
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.modeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.modeSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.modeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ConceptMapSerializer : KSerializer<ConceptMap> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConceptMap") {
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
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
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
    b.element("sourceUri", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_sourceUri", Element.serializer().descriptor, isOptional = true)
    b.element("sourceCanonical", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_sourceCanonical", Element.serializer().descriptor, isOptional = true)
    b.element("targetUri", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_targetUri", Element.serializer().descriptor, isOptional = true)
    b.element("targetCanonical", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_targetCanonical", Element.serializer().descriptor, isOptional = true)
    b.element(
      "group",
      listSerialDescriptor(lazyDescriptor { ConceptMap.Group.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ConceptMap =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ConceptMap")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): ConceptMap {
    val __desc = desc
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
    var identifier: Identifier? = null
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
    var sourceUri: KotlinString? = null
    var _sourceUri: Element? = null
    var sourceCanonical: KotlinString? = null
    var _sourceCanonical: Element? = null
    var targetUri: KotlinString? = null
    var _targetUri: Element? = null
    var targetCanonical: KotlinString? = null
    var _targetCanonical: Element? = null
    var group: List<ConceptMap.Group>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 -> url = decoder.decodeStringElement(__desc, __i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(__desc, __i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(__desc, __i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(__desc, __i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> status = decoder.decodeStringElement(__desc, __i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> experimental = decoder.decodeBooleanElement(__desc, __i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> date = decoder.decodeStringElement(__desc, __i)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 -> publisher = decoder.decodeStringElement(__desc, __i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        28 -> description = decoder.decodeStringElement(__desc, __i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useContextSer, null)
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        32 -> purpose = decoder.decodeStringElement(__desc, __i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        34 -> copyright = decoder.decodeStringElement(__desc, __i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        36 -> sourceUri = decoder.decodeStringElement(__desc, __i)
        37 ->
          _sourceUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        38 -> sourceCanonical = decoder.decodeStringElement(__desc, __i)
        39 ->
          _sourceCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        40 -> targetUri = decoder.decodeStringElement(__desc, __i)
        41 ->
          _targetUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        42 -> targetCanonical = decoder.decodeStringElement(__desc, __i)
        43 ->
          _targetCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        44 -> group = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.groupSer, null)
        else -> throw SerializationException("Unexpected index decoding ConceptMap: " + __i)
      }
    }
    return ConceptMap(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier,
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      source =
        ConceptMap.Source.from(
          Uri.of(sourceUri, _sourceUri),
          Canonical.of(sourceCanonical, _sourceCanonical),
        ),
      target =
        ConceptMap.Target.from(
          Uri.of(targetUri, _targetUri),
          Canonical.of(targetCanonical, _targetCanonical),
        ),
      group = group ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: ConceptMap,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.identifierSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 21 + __off, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 25 + __off, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        31 + __off,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 32 + __off, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 34 + __off, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.source) {
      null -> {}
      is ConceptMap.Source.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 36 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is ConceptMap.Source.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 38 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    when (val __d = value.target) {
      null -> {}
      is ConceptMap.Target.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 40 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is ConceptMap.Target.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 42 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.groupSer, value.group)
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

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val groupSerInner: KSerializer<ConceptMap.Group> = ConceptMap.Group.serializer()

    public val groupSer: KSerializer<List<ConceptMap.Group>> = ListSerializer(Hoisted.groupSerInner)
  }
}

internal object ConceptMapPolymorphicSerializer : KSerializer<ConceptMap> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConceptMap") { ConceptMapSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap) {
    encoder.encodeStructure(descriptor) {
      ConceptMapSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ConceptMap =
    decoder.decodeStructure(descriptor) {
      ConceptMapSerializer.deserializeJson(this, descriptor, 0)
    }
}
