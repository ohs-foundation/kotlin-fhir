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
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.StructureMap
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.StructureMapGroupTypeMode
import dev.ohs.fhir.model.r5.terminologies.StructureMapInputMode
import dev.ohs.fhir.model.r5.terminologies.StructureMapModelMode
import dev.ohs.fhir.model.r5.terminologies.StructureMapSourceListMode
import dev.ohs.fhir.model.r5.terminologies.StructureMapTargetListMode
import dev.ohs.fhir.model.r5.terminologies.StructureMapTransform
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.datetime.LocalTime
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

internal object StructureMapStructureSerializer : FhirSerializer<StructureMap.Structure> {
  override val descriptor: SerialDescriptor = buildDescriptor("Structure", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Structure>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("url")
    b.strPrim("mode")
    b.strPrim("alias")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Structure {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var mode: StructureMapModelMode? = null
    var _mode: Element? = null
    var alias: KotlinString? = null
    var _alias: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          mode = StructureMapModelMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _mode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> alias = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _alias =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
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
    return StructureMap.Structure(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = required(Canonical.of(url, _url), "StructureMap.Structure", "url"),
      mode = required(Enumeration.of(mode, _mode), "StructureMap.Structure", "mode"),
      alias = R5String.of(alias, _alias),
      documentation = R5String.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Structure) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.mode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.mode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.alias?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.alias)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapConstSerializer : FhirSerializer<StructureMap.Const> {
  override val descriptor: SerialDescriptor = buildDescriptor("Const", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Const>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("value")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Const {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _value =
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
    return StructureMap.Const(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = Id.of(name, _name),
      `value` = R5String.of(`value`, _value),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Const) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.`value`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupSerializer : FhirSerializer<StructureMap.Group> {
  override val descriptor: SerialDescriptor = buildDescriptor("Group", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("extends")
    b.strPrim("typeMode")
    b.strPrim("documentation")
    b.optionalElement("input", StructureMapGroupInputSerializer.listSerializer.descriptor)
    b.optionalElement("rule", StructureMapGroupRuleSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var extends: KotlinString? = null
    var _extends: Element? = null
    var typeMode: StructureMapGroupTypeMode? = null
    var _typeMode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var input: List<StructureMap.Group.Input>? = null
    var rule: List<StructureMap.Group.Rule>? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> extends = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _extends =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          typeMode =
            StructureMapGroupTypeMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _typeMode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          input =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupInputSerializer.listSerializer,
              null,
            )
        12 ->
          rule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Id.of(name, _name), "StructureMap.Group", "name"),
      extends = Id.of(extends, _extends),
      typeMode = Enumeration.of(typeMode, _typeMode),
      documentation = R5String.of(documentation, _documentation),
      input = listOrEmpty(input),
      rule = listOrEmpty(rule),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.extends?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.extends)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.typeMode?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.typeMode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      StructureMapGroupInputSerializer.listSerializer,
      value.input,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      StructureMapGroupRuleSerializer.listSerializer,
      value.rule,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupInputSerializer : FhirSerializer<StructureMap.Group.Input> {
  override val descriptor: SerialDescriptor = buildDescriptor("Input", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Input>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("type")
    b.strPrim("mode")
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Input {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var mode: StructureMapInputMode? = null
    var _mode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
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
        7 ->
          mode = StructureMapInputMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _mode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
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
    return StructureMap.Group.Input(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Id.of(name, _name), "StructureMap.Group.Input", "name"),
      type = R5String.of(type, _type),
      mode = required(Enumeration.of(mode, _mode), "StructureMap.Group.Input", "mode"),
      documentation = R5String.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Input) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.mode.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.mode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleSerializer : FhirSerializer<StructureMap.Group.Rule> {
  override val descriptor: SerialDescriptor = buildDescriptor("Rule", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.optionalElement("source", StructureMapGroupRuleSourceSerializer.listSerializer.descriptor)
    b.optionalElement("target", StructureMapGroupRuleTargetSerializer.listSerializer.descriptor)
    b.optionalElement(
      "rule",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.StructureMapGroupRuleSerializer)),
    )
    b.optionalElement(
      "dependent",
      StructureMapGroupRuleDependentSerializer.listSerializer.descriptor,
    )
    b.strPrim("documentation")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var source: List<StructureMap.Group.Rule.Source>? = null
    var target: List<StructureMap.Group.Rule.Target>? = null
    var rule: List<StructureMap.Group.Rule>? = null
    var dependent: List<StructureMap.Group.Rule.Dependent>? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleSourceSerializer.listSerializer,
              null,
            )
        6 ->
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleTargetSerializer.listSerializer,
              null,
            )
        7 ->
          rule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleSerializer.listSerializer,
              null,
            )
        8 ->
          dependent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleDependentSerializer.listSerializer,
              null,
            )
        9 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _documentation =
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
    return StructureMap.Group.Rule(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = Id.of(name, _name),
      source = listOrEmpty(source),
      target = listOrEmpty(target),
      rule = listOrEmpty(rule),
      dependent = listOrEmpty(dependent),
      documentation = R5String.of(documentation, _documentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      StructureMapGroupRuleSourceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      StructureMapGroupRuleTargetSerializer.listSerializer,
      value.target,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      StructureMapGroupRuleSerializer.listSerializer,
      value.rule,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      StructureMapGroupRuleDependentSerializer.listSerializer,
      value.dependent,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.documentation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleSourceSerializer :
  FhirSerializer<StructureMap.Group.Rule.Source> {
  override val descriptor: SerialDescriptor = buildDescriptor("Source", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Source>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("context")
    b.intPrim("min")
    b.strPrim("max")
    b.strPrim("type")
    b.strPrim("defaultValue")
    b.strPrim("element")
    b.strPrim("listMode")
    b.strPrim("variable")
    b.strPrim("condition")
    b.strPrim("check")
    b.strPrim("logMessage")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Source {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var context: KotlinString? = null
    var _context: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var defaultValue: KotlinString? = null
    var _defaultValue: Element? = null
    var element: KotlinString? = null
    var _element: Element? = null
    var listMode: StructureMapSourceListMode? = null
    var _listMode: Element? = null
    var variable: KotlinString? = null
    var _variable: Element? = null
    var condition: KotlinString? = null
    var _condition: Element? = null
    var check: KotlinString? = null
    var _check: Element? = null
    var logMessage: KotlinString? = null
    var _logMessage: Element? = null
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
        3 -> context = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _context =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> defaultValue = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _defaultValue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> element = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _element =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          listMode =
            StructureMapSourceListMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _listMode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> variable = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> condition = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> check = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _check =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> logMessage = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _logMessage =
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
    return StructureMap.Group.Rule.Source(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      context = required(Id.of(context, _context), "StructureMap.Group.Rule.Source", "context"),
      min = Integer.of(min, _min),
      max = R5String.of(max, _max),
      type = R5String.of(type, _type),
      defaultValue = R5String.of(defaultValue, _defaultValue),
      element = R5String.of(element, _element),
      listMode = Enumeration.of(listMode, _listMode),
      variable = Id.of(variable, _variable),
      condition = R5String.of(condition, _condition),
      check = R5String.of(check, _check),
      logMessage = R5String.of(logMessage, _logMessage),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Source) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.context.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.context)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.min?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.max?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.max)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.type?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.defaultValue?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.defaultValue)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.element?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.element)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.listMode?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.listMode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17, value.variable?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.variable)
    compositeEncoder.encodeStringIfNotNull(descriptor, 19, value.condition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20, value.condition)
    compositeEncoder.encodeStringIfNotNull(descriptor, 21, value.check?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.check)
    compositeEncoder.encodeStringIfNotNull(descriptor, 23, value.logMessage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 24, value.logMessage)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleTargetSerializer :
  FhirSerializer<StructureMap.Group.Rule.Target> {
  override val descriptor: SerialDescriptor = buildDescriptor("Target", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Target>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("context")
    b.strPrim("element")
    b.strPrim("variable")
    b.strPrimList("listMode")
    b.strPrim("listRuleId")
    b.strPrim("transform")
    b.optionalElement(
      "parameter",
      StructureMapGroupRuleTargetParameterSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var context: KotlinString? = null
    var _context: Element? = null
    var element: KotlinString? = null
    var _element: Element? = null
    var variable: KotlinString? = null
    var _variable: Element? = null
    var listMode: List<KotlinString?>? = null
    var _listMode: List<Element?>? = null
    var listRuleId: KotlinString? = null
    var _listRuleId: Element? = null
    var transform: StructureMapTransform? = null
    var _transform: Element? = null
    var parameter: List<StructureMap.Group.Rule.Target.Parameter>? = null
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
        3 -> context = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _context =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> element = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _element =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> variable = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          listMode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        10 ->
          _listMode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 -> listRuleId = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _listRuleId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          transform =
            StructureMapTransform.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _transform =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleTargetParameterSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val listMode_ =
      List(maxSize(listMode, _listMode)) { index ->
        entryRequired(
          Enumeration.of(
            at(listMode, index)?.let { StructureMapTargetListMode.fromCode(it) },
            at(_listMode, index),
          ),
          "StructureMap.Group.Rule.Target",
          "listMode",
        )
      }
    return StructureMap.Group.Rule.Target(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      context = R5String.of(context, _context),
      element = R5String.of(element, _element),
      variable = Id.of(variable, _variable),
      listMode = listMode_,
      listRuleId = Id.of(listRuleId, _listRuleId),
      transform = Enumeration.of(transform, _transform),
      parameter = listOrEmpty(parameter),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.context?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.context)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.element?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.element)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.variable?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.variable)
    if (!value.listMode.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        stringNullableListSerializer,
        value.listMode.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.listMode)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.listRuleId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.listRuleId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.transform?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.transform)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      StructureMapGroupRuleTargetParameterSerializer.listSerializer,
      value.parameter,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleTargetParameterSerializer :
  FhirSerializer<StructureMap.Group.Rule.Target.Parameter> {
  override val descriptor: SerialDescriptor = buildDescriptor("Parameter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Target.Parameter>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("valueId")
    b.strPrim("valueString")
    b.boolPrim("valueBoolean")
    b.intPrim("valueInteger")
    b.prim("valueDecimal", FhirDecimalSerializer.descriptor)
    b.strPrim("valueDate")
    b.prim("valueTime", LocalTimeSerializer.descriptor)
    b.strPrim("valueDateTime")
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target.Parameter {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueId: KotlinString? = null
    var _valueId: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
    var valueDate: FhirDate? = null
    var _valueDate: Element? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueDateTime: FhirDateTime? = null
    var _valueDateTime: Element? = null
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
        3 -> valueId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _valueId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        12 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        16 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _valueDateTime =
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
    return StructureMap.Group.Rule.Target.Parameter(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `value` =
        required(
          StructureMap.Group.Rule.Target.Parameter.Value.from(
            Id.of(valueId, _valueId),
            R5String.of(valueString, _valueString),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Integer.of(valueInteger, _valueInteger),
            Decimal.of(valueDecimal, _valueDecimal),
            Date.of(valueDate, _valueDate),
            Time.of(valueTime, _valueTime),
            DateTime.of(valueDateTime, _valueDateTime),
          ),
          "StructureMap.Group.Rule.Target.Parameter",
          "value",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target.Parameter) {
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
    when (val choice = value.`value`) {
      is StructureMap.Group.Rule.Target.Parameter.Value.Id -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          11,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          15,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 17, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapGroupRuleDependentSerializer :
  FhirSerializer<StructureMap.Group.Rule.Dependent> {
  override val descriptor: SerialDescriptor = buildDescriptor("Dependent", this)

  @JvmField
  internal val listSerializer: KSerializer<List<StructureMap.Group.Rule.Dependent>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.optionalElement(
      "parameter",
      StructureMapGroupRuleTargetParameterSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Dependent {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var parameter: List<StructureMap.Group.Rule.Target.Parameter>? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupRuleTargetParameterSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return StructureMap.Group.Rule.Dependent(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(Id.of(name, _name), "StructureMap.Group.Rule.Dependent", "name"),
      parameter = listOrEmpty(parameter),
    )
  }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Dependent) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      StructureMapGroupRuleTargetParameterSerializer.listSerializer,
      value.parameter,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object StructureMapSerializer : FhirResourceSerializer<StructureMap> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("StructureMap")

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
    b.optionalElement("structure", StructureMapStructureSerializer.listSerializer.descriptor)
    b.strPrimList("import")
    b.optionalElement("const", StructureMapConstSerializer.listSerializer.descriptor)
    b.optionalElement("group", StructureMapGroupSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): StructureMap {
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
    var structure: List<StructureMap.Structure>? = null
    var `import`: List<KotlinString?>? = null
    var _import: List<Element?>? = null
    var `const`: List<StructureMap.Const>? = null
    var group: List<StructureMap.Group>? = null
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
          structure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapStructureSerializer.listSerializer,
              null,
            )
        42 ->
          `import` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        43 ->
          _import =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        44 ->
          `const` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapConstSerializer.listSerializer,
              null,
            )
        45 ->
          group =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              StructureMapGroupSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val import_ =
      List(maxSize(`import`, _import)) { index ->
        entryRequired(
          Canonical.of(at(`import`, index), at(_import, index)),
          "StructureMap",
          "import",
        )
      }
    return StructureMap(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = required(Uri.of(url, _url), "StructureMap", "url"),
      identifier = listOrEmpty(identifier),
      version = R5String.of(version, _version),
      versionAlgorithm =
        StructureMap.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = required(R5String.of(name, _name), "StructureMap", "name"),
      title = R5String.of(title, _title),
      status = required(Enumeration.of(status, _status), "StructureMap", "status"),
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
      structure = listOrEmpty(structure),
      `import` = import_,
      `const` = listOrEmpty(`const`),
      group = listOrEmpty(group),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: StructureMap,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
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
      is StructureMap.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is StructureMap.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name.value)
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
      StructureMapStructureSerializer.listSerializer,
      value.structure,
    )
    if (!value.`import`.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        42 + descriptorOffset,
        stringNullableListSerializer,
        value.`import`.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 43 + descriptorOffset, value.`import`)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      44 + descriptorOffset,
      StructureMapConstSerializer.listSerializer,
      value.`const`,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      45 + descriptorOffset,
      StructureMapGroupSerializer.listSerializer,
      value.group,
    )
  }
}
