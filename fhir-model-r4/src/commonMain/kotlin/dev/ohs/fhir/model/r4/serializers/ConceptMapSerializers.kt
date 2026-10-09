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
import dev.ohs.fhir.model.r4.ConceptMap
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.ConceptMapEquivalence
import dev.ohs.fhir.model.r4.terminologies.ConceptMapGroupUnmappedMode
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object ConceptMapGroupSerializer : FhirSerializer<ConceptMap.Group> {
  override val descriptor: SerialDescriptor = buildDescriptor("Group", this)

  @JvmField internal val listSerializer: KSerializer<List<ConceptMap.Group>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("source")
    b.strPrim("sourceVersion")
    b.strPrim("target")
    b.strPrim("targetVersion")
    b.optionalElement("element", ConceptMapGroupElementSerializer.listSerializer.descriptor)
    b.optionalElement("unmapped", ConceptMapGroupUnmappedSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> source = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> sourceVersion = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _sourceVersion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> target = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> targetVersion = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _targetVersion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          element =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupElementSerializer.listSerializer,
              null,
            )
        12 ->
          unmapped =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupUnmappedSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ConceptMap.Group(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      source = Uri.of(source, _source),
      sourceVersion = R4String.of(sourceVersion, _sourceVersion),
      target = Uri.of(target, _target),
      targetVersion = R4String.of(targetVersion, _targetVersion),
      element = listOrEmpty(element),
      unmapped = unmapped,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.source?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.source)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.sourceVersion?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.sourceVersion)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.target?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.target)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.targetVersion?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.targetVersion)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ConceptMapGroupElementSerializer.listSerializer,
      value.element,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      ConceptMapGroupUnmappedSerializer,
      value.unmapped,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConceptMapGroupElementSerializer : FhirSerializer<ConceptMap.Group.Element> {
  override val descriptor: SerialDescriptor = buildDescriptor("Element", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ConceptMap.Group.Element>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrim("display")
    b.optionalElement("target", ConceptMapGroupElementTargetSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var target: List<ConceptMap.Group.Element.Target>? = null
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
        5 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupElementTargetSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ConceptMap.Group.Element(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = Code.of(code, _code),
      display = R4String.of(display, _display),
      target = listOrEmpty(target),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.display)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ConceptMapGroupElementTargetSerializer.listSerializer,
      value.target,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConceptMapGroupElementTargetSerializer :
  FhirSerializer<ConceptMap.Group.Element.Target> {
  override val descriptor: SerialDescriptor = buildDescriptor("Target", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ConceptMap.Group.Element.Target>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrim("display")
    b.strPrim("equivalence")
    b.strPrim("comment")
    b.optionalElement(
      "dependsOn",
      ConceptMapGroupElementTargetDependsOnSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "product",
      ConceptMapGroupElementTargetDependsOnSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var equivalence: ConceptMapEquivalence? = null
    var _equivalence: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var dependsOn: List<ConceptMap.Group.Element.Target.DependsOn>? = null
    var product: List<ConceptMap.Group.Element.Target.DependsOn>? = null
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
        5 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          equivalence =
            ConceptMapEquivalence.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _equivalence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          dependsOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupElementTargetDependsOnSerializer.listSerializer,
              null,
            )
        12 ->
          product =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupElementTargetDependsOnSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ConceptMap.Group.Element.Target(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = Code.of(code, _code),
      display = R4String.of(display, _display),
      equivalence =
        required(
          Enumeration.of(equivalence, _equivalence),
          "ConceptMap.Group.Element.Target",
          "equivalence",
        ),
      comment = R4String.of(comment, _comment),
      dependsOn = listOrEmpty(dependsOn),
      product = listOrEmpty(product),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.display)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.equivalence.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.equivalence)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.comment)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ConceptMapGroupElementTargetDependsOnSerializer.listSerializer,
      value.dependsOn,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      ConceptMapGroupElementTargetDependsOnSerializer.listSerializer,
      value.product,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConceptMapGroupElementTargetDependsOnSerializer :
  FhirSerializer<ConceptMap.Group.Element.Target.DependsOn> {
  override val descriptor: SerialDescriptor = buildDescriptor("DependsOn", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ConceptMap.Group.Element.Target.DependsOn>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("property")
    b.strPrim("system")
    b.strPrim("value")
    b.strPrim("display")
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target.DependsOn {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> `property` = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _property =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> system = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _display =
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
    return ConceptMap.Group.Element.Target.DependsOn(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `property` =
        required(
          Uri.of(`property`, _property),
          "ConceptMap.Group.Element.Target.DependsOn",
          "property",
        ),
      system = Canonical.of(system, _system),
      `value` =
        required(
          R4String.of(`value`, _value),
          "ConceptMap.Group.Element.Target.DependsOn",
          "value",
        ),
      display = R4String.of(display, _display),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target.DependsOn) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.`property`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.`property`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.system?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.system)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.`value`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.display)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConceptMapGroupUnmappedSerializer : FhirSerializer<ConceptMap.Group.Unmapped> {
  override val descriptor: SerialDescriptor = buildDescriptor("Unmapped", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ConceptMap.Group.Unmapped>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("mode")
    b.strPrim("code")
    b.strPrim("display")
    b.strPrim("url")
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Unmapped {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: ConceptMapGroupUnmappedMode? = null
    var _mode: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
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
          mode =
            ConceptMapGroupUnmappedMode.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        4 ->
          _mode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _url =
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
    return ConceptMap.Group.Unmapped(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      mode = required(Enumeration.of(mode, _mode), "ConceptMap.Group.Unmapped", "mode"),
      code = Code.of(code, _code),
      display = R4String.of(display, _display),
      url = Canonical.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Unmapped) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.mode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.mode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.display)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.url)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConceptMapSerializer : FhirResourceSerializer<ConceptMap> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ConceptMap")

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
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
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
    b.strPrim("purpose")
    b.strPrim("copyright")
    b.strPrim("sourceUri")
    b.strPrim("sourceCanonical")
    b.strPrim("targetUri")
    b.strPrim("targetCanonical")
    b.optionalElement("group", ConceptMapGroupSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ConceptMap {
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
              IdentifierSerializer,
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
        17 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> sourceUri = compositeDecoder.decodeStringElement(descriptor, i)
        37 ->
          _sourceUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 -> sourceCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _sourceCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 -> targetUri = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _targetUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 -> targetCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        43 ->
          _targetCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 ->
          group =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return ConceptMap(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      identifier = identifier,
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      status = required(Enumeration.of(status, _status), "ConceptMap", "status"),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
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
      group = listOrEmpty(group),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ConceptMap,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    when (val choice = value.source) {
      null -> {}
      is ConceptMap.Source.Uri -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          36 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, choice.value)
      }
      is ConceptMap.Source.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          38 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, choice.value)
      }
    }
    when (val choice = value.target) {
      null -> {}
      is ConceptMap.Target.Uri -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          40 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, choice.value)
      }
      is ConceptMap.Target.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          42 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      44 + descriptorOffset,
      ConceptMapGroupSerializer.listSerializer,
      value.group,
    )
  }
}
