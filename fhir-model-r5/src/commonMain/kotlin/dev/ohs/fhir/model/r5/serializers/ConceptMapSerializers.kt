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
import dev.ohs.fhir.model.r5.ConceptMap
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.ConceptMapAttributeType
import dev.ohs.fhir.model.r5.terminologies.ConceptMapGroupUnmappedMode
import dev.ohs.fhir.model.r5.terminologies.ConceptMapPropertyType
import dev.ohs.fhir.model.r5.terminologies.ConceptMapRelationship
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

internal object ConceptMapPropertySerializer : FhirSerializer<ConceptMap.Property> {
  override val descriptor: SerialDescriptor = buildDescriptor("Property", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ConceptMap.Property>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrim("uri")
    b.strPrim("description")
    b.strPrim("type")
    b.strPrim("system")
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Property {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var type: ConceptMapPropertyType? = null
    var _type: Element? = null
    var system: KotlinString? = null
    var _system: Element? = null
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
        5 -> uri = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _uri =
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
          type =
            ConceptMapPropertyType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        10 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> system = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _system =
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
    return ConceptMap.Property(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(Code.of(code, _code), "ConceptMap.Property", "code"),
      uri = Uri.of(uri, _uri),
      description = R5String.of(description, _description),
      type = required(Enumeration.of(type, _type), "ConceptMap.Property", "type"),
      system = Canonical.of(system, _system),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Property) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.uri?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.uri)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.system?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.system)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConceptMapAdditionalAttributeSerializer :
  FhirSerializer<ConceptMap.AdditionalAttribute> {
  override val descriptor: SerialDescriptor = buildDescriptor("AdditionalAttribute", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ConceptMap.AdditionalAttribute>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.strPrim("uri")
    b.strPrim("description")
    b.strPrim("type")
  }

  override fun deserialize(decoder: Decoder): ConceptMap.AdditionalAttribute {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var type: ConceptMapAttributeType? = null
    var _type: Element? = null
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
        5 -> uri = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _uri =
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
          type =
            ConceptMapAttributeType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        10 ->
          _type =
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
    return ConceptMap.AdditionalAttribute(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(Code.of(code, _code), "ConceptMap.AdditionalAttribute", "code"),
      uri = Uri.of(uri, _uri),
      description = R5String.of(description, _description),
      type = required(Enumeration.of(type, _type), "ConceptMap.AdditionalAttribute", "type"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.AdditionalAttribute) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.uri?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.uri)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.type)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConceptMapGroupSerializer : FhirSerializer<ConceptMap.Group> {
  override val descriptor: SerialDescriptor = buildDescriptor("Group", this)

  @JvmField internal val listSerializer: KSerializer<List<ConceptMap.Group>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("source")
    b.strPrim("target")
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
    var target: KotlinString? = null
    var _target: Element? = null
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
        5 -> target = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          element =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupElementSerializer.listSerializer,
              null,
            )
        8 ->
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
      source = Canonical.of(source, _source),
      target = Canonical.of(target, _target),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.target?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.target)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ConceptMapGroupElementSerializer.listSerializer,
      value.element,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
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
    b.strPrim("valueSet")
    b.boolPrim("noMap")
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
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var noMap: KotlinBoolean? = null
    var _noMap: Element? = null
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
        7 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> noMap = compositeDecoder.decodeBooleanElement(descriptor, i)
        10 ->
          _noMap =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
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
      display = R5String.of(display, _display),
      valueSet = Canonical.of(valueSet, _valueSet),
      noMap = R5Boolean.of(noMap, _noMap),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.valueSet?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.valueSet)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 9, value.noMap?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.noMap)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
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
    b.strPrim("valueSet")
    b.strPrim("relationship")
    b.strPrim("comment")
    b.optionalElement(
      "property",
      ConceptMapGroupElementTargetPropertySerializer.listSerializer.descriptor,
    )
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
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var relationship: ConceptMapRelationship? = null
    var _relationship: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var `property`: List<ConceptMap.Group.Element.Target.Property>? = null
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
        7 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          relationship =
            ConceptMapRelationship.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        10 ->
          _relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupElementTargetPropertySerializer.listSerializer,
              null,
            )
        14 ->
          dependsOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapGroupElementTargetDependsOnSerializer.listSerializer,
              null,
            )
        15 ->
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
      display = R5String.of(display, _display),
      valueSet = Canonical.of(valueSet, _valueSet),
      relationship =
        required(
          Enumeration.of(relationship, _relationship),
          "ConceptMap.Group.Element.Target",
          "relationship",
        ),
      comment = R5String.of(comment, _comment),
      `property` = listOrEmpty(`property`),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.valueSet?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.valueSet)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.relationship.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.relationship)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.comment)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      ConceptMapGroupElementTargetPropertySerializer.listSerializer,
      value.`property`,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      ConceptMapGroupElementTargetDependsOnSerializer.listSerializer,
      value.dependsOn,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      ConceptMapGroupElementTargetDependsOnSerializer.listSerializer,
      value.product,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConceptMapGroupElementTargetPropertySerializer :
  FhirSerializer<ConceptMap.Group.Element.Target.Property> {
  override val descriptor: SerialDescriptor = buildDescriptor("Property", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ConceptMap.Group.Element.Target.Property>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("code")
    b.optionalElement("valueCoding", CodingSerializer.descriptor)
    b.strPrim("valueString")
    b.intPrim("valueInteger")
    b.boolPrim("valueBoolean")
    b.strPrim("valueDateTime")
    b.prim("valueDecimal", FhirDecimalSerializer.descriptor)
    b.strPrim("valueCode")
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target.Property {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var valueCoding: Coding? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueDateTime: FhirDateTime? = null
    var _valueDateTime: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
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
        5 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        6 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        9 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        15 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _valueCode =
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
    return ConceptMap.Group.Element.Target.Property(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(Code.of(code, _code), "ConceptMap.Group.Element.Target.Property", "code"),
      `value` =
        required(
          ConceptMap.Group.Element.Target.Property.Value.from(
            valueCoding,
            R5String.of(valueString, _valueString),
            Integer.of(valueInteger, _valueInteger),
            R5Boolean.of(valueBoolean, _valueBoolean),
            DateTime.of(valueDateTime, _valueDateTime),
            Decimal.of(valueDecimal, _valueDecimal),
            Code.of(valueCode, _valueCode),
          ),
          "ConceptMap.Group.Element.Target.Property",
          "value",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target.Property) {
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
    when (val choice = value.`value`) {
      is ConceptMap.Group.Element.Target.Property.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, CodingSerializer, choice.value)
      }
      is ConceptMap.Group.Element.Target.Property.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is ConceptMap.Group.Element.Target.Property.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is ConceptMap.Group.Element.Target.Property.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is ConceptMap.Group.Element.Target.Property.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is ConceptMap.Group.Element.Target.Property.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          14,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 15, choice.value)
      }
      is ConceptMap.Group.Element.Target.Property.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 16, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 17, choice.value)
      }
    }
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
    b.strPrim("attribute")
    b.strPrim("valueCode")
    b.optionalElement("valueCoding", CodingSerializer.descriptor)
    b.strPrim("valueString")
    b.boolPrim("valueBoolean")
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.strPrim("valueSet")
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target.DependsOn {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var attribute: KotlinString? = null
    var _attribute: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueCoding: Coding? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueQuantity: Quantity? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
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
        3 -> attribute = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _attribute =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueCode = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        8 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        13 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _valueSet =
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
      attribute =
        required(
          Code.of(attribute, _attribute),
          "ConceptMap.Group.Element.Target.DependsOn",
          "attribute",
        ),
      `value` =
        ConceptMap.Group.Element.Target.DependsOn.Value.from(
          Code.of(valueCode, _valueCode),
          valueCoding,
          R5String.of(valueString, _valueString),
          R5Boolean.of(valueBoolean, _valueBoolean),
          valueQuantity,
        ),
      valueSet = Canonical.of(valueSet, _valueSet),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.attribute.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.attribute)
    when (val choice = value.`value`) {
      null -> {}
      is ConceptMap.Group.Element.Target.DependsOn.Value.Code -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is ConceptMap.Group.Element.Target.DependsOn.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, CodingSerializer, choice.value)
      }
      is ConceptMap.Group.Element.Target.DependsOn.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is ConceptMap.Group.Element.Target.DependsOn.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is ConceptMap.Group.Element.Target.DependsOn.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 12, QuantitySerializer, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.valueSet?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.valueSet)
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
    b.strPrim("valueSet")
    b.strPrim("relationship")
    b.strPrim("otherMap")
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
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var relationship: ConceptMapRelationship? = null
    var _relationship: Element? = null
    var otherMap: KotlinString? = null
    var _otherMap: Element? = null
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
        9 -> valueSet = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _valueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          relationship =
            ConceptMapRelationship.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> otherMap = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _otherMap =
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
      display = R5String.of(display, _display),
      valueSet = Canonical.of(valueSet, _valueSet),
      relationship = Enumeration.of(relationship, _relationship),
      otherMap = Canonical.of(otherMap, _otherMap),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.valueSet?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.valueSet)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.relationship?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.relationship)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.otherMap?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.otherMap)
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
    b.strPrim("approvalDate")
    b.strPrim("lastReviewDate")
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("property", ConceptMapPropertySerializer.listSerializer.descriptor)
    b.optionalElement(
      "additionalAttribute",
      ConceptMapAdditionalAttributeSerializer.listSerializer.descriptor,
    )
    b.strPrim("sourceScopeUri")
    b.strPrim("sourceScopeCanonical")
    b.strPrim("targetScopeUri")
    b.strPrim("targetScopeCanonical")
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
    var approvalDate: FhirDate? = null
    var _approvalDate: Element? = null
    var lastReviewDate: FhirDate? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var `property`: List<ConceptMap.Property>? = null
    var additionalAttribute: List<ConceptMap.AdditionalAttribute>? = null
    var sourceScopeUri: KotlinString? = null
    var _sourceScopeUri: Element? = null
    var sourceScopeCanonical: KotlinString? = null
    var _sourceScopeCanonical: Element? = null
    var targetScopeUri: KotlinString? = null
    var _targetScopeUri: Element? = null
    var targetScopeCanonical: KotlinString? = null
    var _targetScopeCanonical: Element? = null
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
          approvalDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        42 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 ->
          lastReviewDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        44 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        46 ->
          topic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        47 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        48 ->
          editor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        49 ->
          reviewer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        50 ->
          endorser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        51 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        52 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapPropertySerializer.listSerializer,
              null,
            )
        53 ->
          additionalAttribute =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConceptMapAdditionalAttributeSerializer.listSerializer,
              null,
            )
        54 -> sourceScopeUri = compositeDecoder.decodeStringElement(descriptor, i)
        55 ->
          _sourceScopeUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        56 -> sourceScopeCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        57 ->
          _sourceScopeCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        58 -> targetScopeUri = compositeDecoder.decodeStringElement(descriptor, i)
        59 ->
          _targetScopeUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        60 -> targetScopeCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        61 ->
          _targetScopeCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        62 ->
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
      identifier = listOrEmpty(identifier),
      version = R5String.of(version, _version),
      versionAlgorithm =
        ConceptMap.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status = required(Enumeration.of(status, _status), "ConceptMap", "status"),
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
      approvalDate = Date.of(approvalDate, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      topic = listOrEmpty(topic),
      author = listOrEmpty(author),
      editor = listOrEmpty(editor),
      reviewer = listOrEmpty(reviewer),
      endorser = listOrEmpty(endorser),
      relatedArtifact = listOrEmpty(relatedArtifact),
      `property` = listOrEmpty(`property`),
      additionalAttribute = listOrEmpty(additionalAttribute),
      sourceScope =
        ConceptMap.SourceScope.from(
          Uri.of(sourceScopeUri, _sourceScopeUri),
          Canonical.of(sourceScopeCanonical, _sourceScopeCanonical),
        ),
      targetScope =
        ConceptMap.TargetScope.from(
          Uri.of(targetScopeUri, _targetScopeUri),
          Canonical.of(targetScopeCanonical, _targetScopeCanonical),
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
      is ConceptMap.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is ConceptMap.VersionAlgorithm.Coding -> {
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      46 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.topic,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      47 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.author,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      48 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.editor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      49 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.reviewer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.endorser,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51 + descriptorOffset,
      RelatedArtifactSerializer.listSerializer,
      value.relatedArtifact,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      52 + descriptorOffset,
      ConceptMapPropertySerializer.listSerializer,
      value.`property`,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      53 + descriptorOffset,
      ConceptMapAdditionalAttributeSerializer.listSerializer,
      value.additionalAttribute,
    )
    when (val choice = value.sourceScope) {
      null -> {}
      is ConceptMap.SourceScope.Uri -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          54 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 55 + descriptorOffset, choice.value)
      }
      is ConceptMap.SourceScope.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          56 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 57 + descriptorOffset, choice.value)
      }
    }
    when (val choice = value.targetScope) {
      null -> {}
      is ConceptMap.TargetScope.Uri -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          58 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 59 + descriptorOffset, choice.value)
      }
      is ConceptMap.TargetScope.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          60 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 61 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      62 + descriptorOffset,
      ConceptMapGroupSerializer.listSerializer,
      value.group,
    )
  }
}
