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

package dev.ohs.fhir.model.r5.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.StructureMap
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object StructureMapStructureSerializer : KSerializer<StructureMap.Structure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Structure") {
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("alias", KotlinString.serializer().descriptor, isOptional = true)
      element("_alias", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): StructureMap.Structure =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Structure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Structure {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var alias: KotlinString? = null
    var _alias: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> url = decoder.decodeStringElement(__desc, 3)
        4 -> _url = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.urlSer, null)
        5 -> mode = decoder.decodeStringElement(__desc, 5)
        6 -> _mode = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.urlSer, null)
        7 -> alias = decoder.decodeStringElement(__desc, 7)
        8 -> _alias = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.urlSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, 9)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.urlSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Structure: " + __i)
      }
    }
    return StructureMap.Structure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Canonical.of(url, _url)!!,
      mode = Enumeration.of(StructureMap.StructureMapModelMode.fromCode(mode!!), _mode),
      alias = R5String.of(alias, _alias),
      documentation = R5String.of(documentation, _documentation),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Structure) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.urlSer, it)
    }
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.urlSer, it)
    }
    ((value.alias?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.alias?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.urlSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.urlSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val urlSer: KSerializer<Element> = Element.serializer()
  }
}

internal object StructureMapConstSerializer : KSerializer<StructureMap.Const> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Const") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): StructureMap.Const =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Const) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Const {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> `value` = decoder.decodeStringElement(__desc, 5)
        6 -> _value = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Const: " + __i)
      }
    }
    return StructureMap.Const(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Id.of(name, _name),
      `value` = R5String.of(`value`, _value),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Const) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.`value`?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object StructureMapGroupSerializer : KSerializer<StructureMap.Group> {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("extends", KotlinString.serializer().descriptor, isOptional = true)
      element("_extends", Element.serializer().descriptor, isOptional = true)
      element("typeMode", KotlinString.serializer().descriptor, isOptional = true)
      element("_typeMode", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
      element(
        "input",
        listSerialDescriptor(lazyDescriptor { StructureMap.Group.Input.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "rule",
        listSerialDescriptor(lazyDescriptor { StructureMap.Group.Rule.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): StructureMap.Group =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Group {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var extends: KotlinString? = null
    var _extends: Element? = null
    var typeMode: KotlinString? = null
    var _typeMode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var input: List<StructureMap.Group.Input>? = null
    var rule: List<StructureMap.Group.Rule>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> extends = decoder.decodeStringElement(__desc, 5)
        6 -> _extends = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> typeMode = decoder.decodeStringElement(__desc, 7)
        8 -> _typeMode = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, 9)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.nameSer, null)
        11 -> input = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.inputSer, null)
        12 -> rule = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.ruleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Group: " + __i)
      }
    }
    return StructureMap.Group(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Id.of(name, _name)!!,
      extends = Id.of(extends, _extends),
      typeMode =
        typeMode?.let {
          Enumeration.of(StructureMap.StructureMapGroupTypeMode.fromCode(it), _typeMode)
        },
      documentation = R5String.of(documentation, _documentation),
      input = input ?: listOf(),
      rule = rule ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Group) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.extends?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.extends?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    ((value.typeMode?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.typeMode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
    }
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.inputSer, value.input)
    if (value.rule.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.ruleSer, value.rule)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val inputSerInner: KSerializer<StructureMap.Group.Input> =
      StructureMap.Group.Input.serializer()

    public val inputSer: KSerializer<List<StructureMap.Group.Input>> =
      ListSerializer(Hoisted.inputSerInner)

    public val ruleSerInner: KSerializer<StructureMap.Group.Rule> =
      StructureMap.Group.Rule.serializer()

    public val ruleSer: KSerializer<List<StructureMap.Group.Rule>> =
      ListSerializer(Hoisted.ruleSerInner)
  }
}

internal object StructureMapGroupInputSerializer : KSerializer<StructureMap.Group.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Input =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Input) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Group.Input {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> type = decoder.decodeStringElement(__desc, 5)
        6 -> _type = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> mode = decoder.decodeStringElement(__desc, 7)
        8 -> _mode = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, 9)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Input: " + __i)
      }
    }
    return StructureMap.Group.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Id.of(name, _name)!!,
      type = R5String.of(type, _type),
      mode = Enumeration.of(StructureMap.StructureMapInputMode.fromCode(mode!!), _mode),
      documentation = R5String.of(documentation, _documentation),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Group.Input) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.type?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object StructureMapGroupRuleSerializer : KSerializer<StructureMap.Group.Rule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rule") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element(
        "source",
        listSerialDescriptor(
          lazyDescriptor { StructureMap.Group.Rule.Source.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "target",
        listSerialDescriptor(
          lazyDescriptor { StructureMap.Group.Rule.Target.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "rule",
        listSerialDescriptor(lazyDescriptor { StructureMap.Group.Rule.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "dependent",
        listSerialDescriptor(
          lazyDescriptor { StructureMap.Group.Rule.Dependent.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_documentation", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Group.Rule {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> source = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.sourceSer, null)
        6 -> target = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.targetSer, null)
        7 -> rule = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.ruleSer, null)
        8 ->
          dependent =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.dependentSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, 9)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Rule: " + __i)
      }
    }
    return StructureMap.Group.Rule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Id.of(name, _name),
      source = source ?: listOf(),
      target = target ?: listOf(),
      rule = rule ?: listOf(),
      dependent = dependent ?: listOf(),
      documentation = R5String.of(documentation, _documentation),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Group.Rule) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.sourceSer, value.source)
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.targetSer, value.target)
    if (value.rule.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.ruleSer, value.rule)
    if (value.dependent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.dependentSer, value.dependent)
    ((value.documentation?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val sourceSerInner: KSerializer<StructureMap.Group.Rule.Source> =
      StructureMap.Group.Rule.Source.serializer()

    public val sourceSer: KSerializer<List<StructureMap.Group.Rule.Source>> =
      ListSerializer(Hoisted.sourceSerInner)

    public val targetSerInner: KSerializer<StructureMap.Group.Rule.Target> =
      StructureMap.Group.Rule.Target.serializer()

    public val targetSer: KSerializer<List<StructureMap.Group.Rule.Target>> =
      ListSerializer(Hoisted.targetSerInner)

    public val ruleSerInner: KSerializer<StructureMap.Group.Rule> =
      StructureMap.Group.Rule.serializer()

    public val ruleSer: KSerializer<List<StructureMap.Group.Rule>> =
      ListSerializer(Hoisted.ruleSerInner)

    public val dependentSerInner: KSerializer<StructureMap.Group.Rule.Dependent> =
      StructureMap.Group.Rule.Dependent.serializer()

    public val dependentSer: KSerializer<List<StructureMap.Group.Rule.Dependent>> =
      ListSerializer(Hoisted.dependentSerInner)
  }
}

internal object StructureMapGroupRuleSourceSerializer :
  KSerializer<StructureMap.Group.Rule.Source> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Source") {
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
      element("context", KotlinString.serializer().descriptor, isOptional = true)
      element("_context", Element.serializer().descriptor, isOptional = true)
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", Element.serializer().descriptor, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("defaultValue", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValue", Element.serializer().descriptor, isOptional = true)
      element("element", KotlinString.serializer().descriptor, isOptional = true)
      element("_element", Element.serializer().descriptor, isOptional = true)
      element("listMode", KotlinString.serializer().descriptor, isOptional = true)
      element("_listMode", Element.serializer().descriptor, isOptional = true)
      element("variable", KotlinString.serializer().descriptor, isOptional = true)
      element("_variable", Element.serializer().descriptor, isOptional = true)
      element("condition", KotlinString.serializer().descriptor, isOptional = true)
      element("_condition", Element.serializer().descriptor, isOptional = true)
      element("check", KotlinString.serializer().descriptor, isOptional = true)
      element("_check", Element.serializer().descriptor, isOptional = true)
      element("logMessage", KotlinString.serializer().descriptor, isOptional = true)
      element("_logMessage", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Source =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Source) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Group.Rule.Source {
    val __desc = descriptor
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
    var listMode: KotlinString? = null
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> context = decoder.decodeStringElement(__desc, 3)
        4 ->
          _context = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.contextSer, null)
        5 -> min = decoder.decodeIntElement(__desc, 5)
        6 -> _min = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.contextSer, null)
        7 -> max = decoder.decodeStringElement(__desc, 7)
        8 -> _max = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.contextSer, null)
        9 -> type = decoder.decodeStringElement(__desc, 9)
        10 ->
          _type = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.contextSer, null)
        11 -> defaultValue = decoder.decodeStringElement(__desc, 11)
        12 ->
          _defaultValue =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.contextSer, null)
        13 -> element = decoder.decodeStringElement(__desc, 13)
        14 ->
          _element = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.contextSer, null)
        15 -> listMode = decoder.decodeStringElement(__desc, 15)
        16 ->
          _listMode =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.contextSer, null)
        17 -> variable = decoder.decodeStringElement(__desc, 17)
        18 ->
          _variable =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.contextSer, null)
        19 -> condition = decoder.decodeStringElement(__desc, 19)
        20 ->
          _condition =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.contextSer, null)
        21 -> check = decoder.decodeStringElement(__desc, 21)
        22 ->
          _check = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.contextSer, null)
        23 -> logMessage = decoder.decodeStringElement(__desc, 23)
        24 ->
          _logMessage =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.contextSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Source: " + __i)
      }
    }
    return StructureMap.Group.Rule.Source(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      context = Id.of(context, _context)!!,
      min = Integer.of(min, _min),
      max = R5String.of(max, _max),
      type = R5String.of(type, _type),
      defaultValue = R5String.of(defaultValue, _defaultValue),
      element = R5String.of(element, _element),
      listMode =
        listMode?.let {
          Enumeration.of(StructureMap.StructureMapSourceListMode.fromCode(it), _listMode)
        },
      variable = Id.of(variable, _variable),
      condition = R5String.of(condition, _condition),
      check = R5String.of(check, _check),
      logMessage = R5String.of(logMessage, _logMessage),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Group.Rule.Source) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.context.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.context.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.contextSer, it)
    }
    ((value.min?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.min?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.contextSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.contextSer, it)
    }
    ((value.type?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.contextSer, it)
    }
    ((value.defaultValue?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.defaultValue?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.contextSer, it)
    }
    ((value.element?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.element?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.contextSer, it)
    }
    ((value.listMode?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.listMode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.contextSer, it)
    }
    ((value.variable?.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.variable?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.contextSer, it)
    }
    ((value.condition?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.contextSer, it)
    }
    ((value.check?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.check?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.contextSer, it)
    }
    ((value.logMessage?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.logMessage?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.contextSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contextSer: KSerializer<Element> = Element.serializer()
  }
}

internal object StructureMapGroupRuleTargetSerializer :
  KSerializer<StructureMap.Group.Rule.Target> {
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
      element("context", KotlinString.serializer().descriptor, isOptional = true)
      element("_context", Element.serializer().descriptor, isOptional = true)
      element("element", KotlinString.serializer().descriptor, isOptional = true)
      element("_element", Element.serializer().descriptor, isOptional = true)
      element("variable", KotlinString.serializer().descriptor, isOptional = true)
      element("_variable", Element.serializer().descriptor, isOptional = true)
      element(
        "listMode",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_listMode", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("listRuleId", KotlinString.serializer().descriptor, isOptional = true)
      element("_listRuleId", Element.serializer().descriptor, isOptional = true)
      element("transform", KotlinString.serializer().descriptor, isOptional = true)
      element("_transform", Element.serializer().descriptor, isOptional = true)
      element(
        "parameter",
        listSerialDescriptor(
          lazyDescriptor { StructureMap.Group.Rule.Target.Parameter.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Group.Rule.Target {
    val __desc = descriptor
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
    var transform: KotlinString? = null
    var _transform: Element? = null
    var parameter: List<StructureMap.Group.Rule.Target.Parameter>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> context = decoder.decodeStringElement(__desc, 3)
        4 ->
          _context = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.contextSer, null)
        5 -> element = decoder.decodeStringElement(__desc, 5)
        6 ->
          _element = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.contextSer, null)
        7 -> variable = decoder.decodeStringElement(__desc, 7)
        8 ->
          _variable = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.contextSer, null)
        9 ->
          listMode = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.listModeSer, null)
        10 ->
          _listMode =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.listModeSer2, null)
        11 -> listRuleId = decoder.decodeStringElement(__desc, 11)
        12 ->
          _listRuleId =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.contextSer, null)
        13 -> transform = decoder.decodeStringElement(__desc, 13)
        14 ->
          _transform =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.contextSer, null)
        15 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.parameterSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + __i)
      }
    }
    return StructureMap.Group.Rule.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      context = R5String.of(context, _context),
      element = R5String.of(element, _element),
      variable = Id.of(variable, _variable),
      listMode =
        (kotlin.collections.List(maxOf(listMode?.size ?: 0, _listMode?.size ?: 0)) { __i ->
          Enumeration.of(
            StructureMap.StructureMapTargetListMode.fromCode(listMode?.getOrNull(__i)!!),
            _listMode?.getOrNull(__i),
          )
        }),
      listRuleId = Id.of(listRuleId, _listRuleId),
      transform =
        transform?.let {
          Enumeration.of(StructureMap.StructureMapTransform.fromCode(it), _transform)
        },
      parameter = parameter ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Group.Rule.Target) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.context?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.context?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.contextSer, it)
    }
    ((value.element?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.element?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.contextSer, it)
    }
    ((value.variable?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.variable?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.contextSer, it)
    }
    (value.listMode.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.listModeSer, it)
    }
    (value.listMode.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.listModeSer2, it)
    }
    ((value.listRuleId?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.listRuleId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.contextSer, it)
    }
    ((value.transform?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.transform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.contextSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.parameterSer, value.parameter)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contextSer: KSerializer<Element> = Element.serializer()

    public val listModeSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val listModeSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.listModeSerInner).nullable)

    public val listModeSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.contextSer).nullable)

    public val parameterSerInner: KSerializer<StructureMap.Group.Rule.Target.Parameter> =
      StructureMap.Group.Rule.Target.Parameter.serializer()

    public val parameterSer: KSerializer<List<StructureMap.Group.Rule.Target.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)
  }
}

internal object StructureMapGroupRuleTargetParameterSerializer :
  KSerializer<StructureMap.Group.Rule.Target.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
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
      element("valueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueId", Element.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Target.Parameter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Target.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Group.Rule.Target.Parameter {
    val __desc = descriptor
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
    var valueDecimal: BigDecimal? = null
    var _valueDecimal: Element? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> valueId = decoder.decodeStringElement(__desc, 3)
        4 ->
          _valueId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueIdSer, null)
        5 -> valueString = decoder.decodeStringElement(__desc, 5)
        6 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueIdSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueIdSer, null)
        9 -> valueInteger = decoder.decodeIntElement(__desc, 9)
        10 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueIdSer, null)
        11 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 11, BigDecimalSerializer, null)
        12 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueIdSer, null)
        13 -> valueDate = decoder.decodeStringElement(__desc, 13)
        14 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.valueIdSer, null)
        15 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 15, LocalTimeSerializer, null)
        16 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueIdSer, null)
        17 -> valueDateTime = decoder.decodeStringElement(__desc, 17)
        18 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.valueIdSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return StructureMap.Group.Rule.Target.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        StructureMap.Group.Rule.Target.Parameter.Value.from(
          Id.of(valueId, _valueId),
          R5String.of(valueString, _valueString),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          Decimal.of(valueDecimal, _valueDecimal),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          Time.of(valueTime, _valueTime),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: StructureMap.Group.Rule.Target.Parameter,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.`value`) {
      null -> {}
      is StructureMap.Group.Rule.Target.Parameter.Value.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.valueIdSer, it)
        }
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueIdSer, it)
        }
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueIdSer, it)
        }
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.valueIdSer, it)
        }
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 11, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.valueIdSer, it)
        }
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.valueIdSer, it)
        }
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 15, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.valueIdSer, it)
        }
      }
      is StructureMap.Group.Rule.Target.Parameter.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.valueIdSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueIdSer: KSerializer<Element> = Element.serializer()
  }
}

internal object StructureMapGroupRuleDependentSerializer :
  KSerializer<StructureMap.Group.Rule.Dependent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dependent") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element(
        "parameter",
        listSerialDescriptor(
          lazyDescriptor { StructureMap.Group.Rule.Target.Parameter.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): StructureMap.Group.Rule.Dependent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap.Group.Rule.Dependent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): StructureMap.Group.Rule.Dependent {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var parameter: List<StructureMap.Group.Rule.Target.Parameter>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.parameterSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dependent: " + __i)
      }
    }
    return StructureMap.Group.Rule.Dependent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Id.of(name, _name)!!,
      parameter = parameter ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Group.Rule.Dependent) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.parameterSer, value.parameter)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val parameterSerInner: KSerializer<StructureMap.Group.Rule.Target.Parameter> =
      StructureMap.Group.Rule.Target.Parameter.serializer()

    public val parameterSer: KSerializer<List<StructureMap.Group.Rule.Target.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)
  }
}

internal object StructureMapSerializer : KSerializer<StructureMap> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureMap") {
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
      "structure",
      listSerialDescriptor(lazyDescriptor { StructureMap.Structure.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "import",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_import", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "const",
      listSerialDescriptor(lazyDescriptor { StructureMap.Const.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "group",
      listSerialDescriptor(lazyDescriptor { StructureMap.Group.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): StructureMap =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "StructureMap")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): StructureMap {
    val __desc = descriptor
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
    var structure: List<StructureMap.Structure>? = null
    var `import`: List<KotlinString?>? = null
    var _import: List<Element?>? = null
    var `const`: List<StructureMap.Const>? = null
    var group: List<StructureMap.Group>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 16)
        17 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        19 -> name = decoder.decodeStringElement(__desc, 19)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> title = decoder.decodeStringElement(__desc, 21)
        22 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> status = decoder.decodeStringElement(__desc, 23)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> experimental = decoder.decodeBooleanElement(__desc, 25)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> date = decoder.decodeStringElement(__desc, 27)
        28 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> publisher = decoder.decodeStringElement(__desc, 29)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.contactSer, null)
        32 -> description = decoder.decodeStringElement(__desc, 32)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.useContextSer, null)
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.jurisdictionSer, null)
        36 -> purpose = decoder.decodeStringElement(__desc, 36)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> copyright = decoder.decodeStringElement(__desc, 38)
        39 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> copyrightLabel = decoder.decodeStringElement(__desc, 40)
        41 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 ->
          structure =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.structureSer, null)
        43 ->
          `import` = decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.importSer, null)
        44 ->
          _import = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.importSer2, null)
        45 ->
          `const` = decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.constSer, null)
        46 -> group = decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.groupSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StructureMap: " + __i)
      }
    }
    return StructureMap(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url)!!,
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        StructureMap.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name)!!,
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
      structure = structure ?: listOf(),
      `import` =
        (kotlin.collections.List(maxOf(`import`?.size ?: 0, _import?.size ?: 0)) { __i ->
          Canonical.of(`import`?.getOrNull(__i)?.let { it }, _import?.getOrNull(__i))!!
        }),
      `const` = `const` ?: listOf(),
      group = group ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is StructureMap.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is StructureMap.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.versionAlgorithmCodingSer, __d.value)
      }
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 25, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    if (value.structure.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.structureSer, value.structure)
    (value.`import`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.importSer, it)
    }
    (value.`import`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.importSer2, it)
    }
    if (value.`const`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.constSer, value.`const`)
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.groupSer, value.group)
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

    public val structureSerInner: KSerializer<StructureMap.Structure> =
      StructureMap.Structure.serializer()

    public val structureSer: KSerializer<List<StructureMap.Structure>> =
      ListSerializer(Hoisted.structureSerInner)

    public val importSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val importSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.importSerInner).nullable)

    public val importSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val constSerInner: KSerializer<StructureMap.Const> = StructureMap.Const.serializer()

    public val constSer: KSerializer<List<StructureMap.Const>> =
      ListSerializer(Hoisted.constSerInner)

    public val groupSerInner: KSerializer<StructureMap.Group> = StructureMap.Group.serializer()

    public val groupSer: KSerializer<List<StructureMap.Group>> =
      ListSerializer(Hoisted.groupSerInner)
  }
}

internal object StructureMapPolymorphicSerializer : KSerializer<StructureMap> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureMap") { StructureMapSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap) {
    encoder.encodeStructure(descriptor) { StructureMapSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): StructureMap =
    decoder.decodeStructure(descriptor) { StructureMapSerializer.deserializeJson(this) }
}
