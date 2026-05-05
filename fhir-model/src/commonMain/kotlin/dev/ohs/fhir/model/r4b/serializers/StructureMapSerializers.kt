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

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Age
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Contributor
import dev.ohs.fhir.model.r4b.Count
import dev.ohs.fhir.model.r4b.DataRequirement
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Distance
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Oid
import dev.ohs.fhir.model.r4b.ParameterDefinition
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.SampledData
import dev.ohs.fhir.model.r4b.Signature
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.StructureMap
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.TriggerDefinition
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.Uuid
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> url = decoder.decodeStringElement(__desc, __i)
        4 -> _url = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.urlSer, null)
        5 -> mode = decoder.decodeStringElement(__desc, __i)
        6 -> _mode = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.urlSer, null)
        7 -> alias = decoder.decodeStringElement(__desc, __i)
        8 -> _alias = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.urlSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, __i)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.urlSer, null)
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
      alias = R4bString.of(alias, _alias),
      documentation = R4bString.of(documentation, _documentation),
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 -> extends = decoder.decodeStringElement(__desc, __i)
        6 ->
          _extends = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        7 -> typeMode = decoder.decodeStringElement(__desc, __i)
        8 ->
          _typeMode = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, __i)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        11 -> input = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.inputSer, null)
        12 -> rule = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ruleSer, null)
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
        Enumeration.of(StructureMap.StructureMapGroupTypeMode.fromCode(typeMode!!), _typeMode),
      documentation = R4bString.of(documentation, _documentation),
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
    ((value.typeMode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.typeMode.toElement())?.let {
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeStringElement(__desc, __i)
        6 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        7 -> mode = decoder.decodeStringElement(__desc, __i)
        8 -> _mode = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, __i)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Input: " + __i)
      }
    }
    return StructureMap.Group.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Id.of(name, _name)!!,
      type = R4bString.of(type, _type),
      mode = Enumeration.of(StructureMap.StructureMapInputMode.fromCode(mode!!), _mode),
      documentation = R4bString.of(documentation, _documentation),
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 ->
          source = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        6 ->
          target = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetSer, null)
        7 -> rule = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ruleSer, null)
        8 ->
          dependent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dependentSer, null)
        9 -> documentation = decoder.decodeStringElement(__desc, __i)
        10 ->
          _documentation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Rule: " + __i)
      }
    }
    return StructureMap.Group.Rule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Id.of(name, _name)!!,
      source = source ?: listOf(),
      target = target ?: listOf(),
      rule = rule ?: listOf(),
      dependent = dependent ?: listOf(),
      documentation = R4bString.of(documentation, _documentation),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: StructureMap.Group.Rule) {
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
      element("defaultValueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueBase64Binary", Element.serializer().descriptor, isOptional = true)
      element("defaultValueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_defaultValueBoolean", Element.serializer().descriptor, isOptional = true)
      element("defaultValueCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueCanonical", Element.serializer().descriptor, isOptional = true)
      element("defaultValueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueCode", Element.serializer().descriptor, isOptional = true)
      element("defaultValueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueDate", Element.serializer().descriptor, isOptional = true)
      element("defaultValueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueDateTime", Element.serializer().descriptor, isOptional = true)
      element("defaultValueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_defaultValueDecimal", Element.serializer().descriptor, isOptional = true)
      element("defaultValueId", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueId", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueInstant", Element.serializer().descriptor, isOptional = true)
      element("defaultValueInteger", Int.serializer().descriptor, isOptional = true)
      element("_defaultValueInteger", Element.serializer().descriptor, isOptional = true)
      element("defaultValueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueMarkdown", Element.serializer().descriptor, isOptional = true)
      element("defaultValueOid", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueOid", Element.serializer().descriptor, isOptional = true)
      element("defaultValuePositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_defaultValuePositiveInt", Element.serializer().descriptor, isOptional = true)
      element("defaultValueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueString", Element.serializer().descriptor, isOptional = true)
      element("defaultValueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_defaultValueTime", Element.serializer().descriptor, isOptional = true)
      element("defaultValueUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_defaultValueUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("defaultValueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueUri", Element.serializer().descriptor, isOptional = true)
      element("defaultValueUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueUrl", Element.serializer().descriptor, isOptional = true)
      element("defaultValueUuid", KotlinString.serializer().descriptor, isOptional = true)
      element("_defaultValueUuid", Element.serializer().descriptor, isOptional = true)
      element("defaultValueAddress", Address.serializer().descriptor, isOptional = true)
      element("defaultValueAge", Age.serializer().descriptor, isOptional = true)
      element("defaultValueAnnotation", Annotation.serializer().descriptor, isOptional = true)
      element("defaultValueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element(
        "defaultValueCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("defaultValueCoding", Coding.serializer().descriptor, isOptional = true)
      element("defaultValueContactPoint", ContactPoint.serializer().descriptor, isOptional = true)
      element("defaultValueCount", Count.serializer().descriptor, isOptional = true)
      element("defaultValueDistance", Distance.serializer().descriptor, isOptional = true)
      element("defaultValueDuration", Duration.serializer().descriptor, isOptional = true)
      element("defaultValueHumanName", HumanName.serializer().descriptor, isOptional = true)
      element("defaultValueIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("defaultValueMoney", Money.serializer().descriptor, isOptional = true)
      element("defaultValuePeriod", Period.serializer().descriptor, isOptional = true)
      element("defaultValueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("defaultValueRange", Range.serializer().descriptor, isOptional = true)
      element("defaultValueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("defaultValueReference", Reference.serializer().descriptor, isOptional = true)
      element("defaultValueSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("defaultValueSignature", Signature.serializer().descriptor, isOptional = true)
      element("defaultValueTiming", Timing.serializer().descriptor, isOptional = true)
      element("defaultValueContactDetail", ContactDetail.serializer().descriptor, isOptional = true)
      element("defaultValueContributor", Contributor.serializer().descriptor, isOptional = true)
      element(
        "defaultValueDataRequirement",
        DataRequirement.serializer().descriptor,
        isOptional = true,
      )
      element("defaultValueExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "defaultValueParameterDefinition",
        ParameterDefinition.serializer().descriptor,
        isOptional = true,
      )
      element(
        "defaultValueRelatedArtifact",
        RelatedArtifact.serializer().descriptor,
        isOptional = true,
      )
      element(
        "defaultValueTriggerDefinition",
        TriggerDefinition.serializer().descriptor,
        isOptional = true,
      )
      element("defaultValueUsageContext", UsageContext.serializer().descriptor, isOptional = true)
      element("defaultValueDosage", Dosage.serializer().descriptor, isOptional = true)
      element("defaultValueMeta", Meta.serializer().descriptor, isOptional = true)
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
    var defaultValueBase64Binary: KotlinString? = null
    var _defaultValueBase64Binary: Element? = null
    var defaultValueBoolean: KotlinBoolean? = null
    var _defaultValueBoolean: Element? = null
    var defaultValueCanonical: KotlinString? = null
    var _defaultValueCanonical: Element? = null
    var defaultValueCode: KotlinString? = null
    var _defaultValueCode: Element? = null
    var defaultValueDate: KotlinString? = null
    var _defaultValueDate: Element? = null
    var defaultValueDateTime: KotlinString? = null
    var _defaultValueDateTime: Element? = null
    var defaultValueDecimal: BigDecimal? = null
    var _defaultValueDecimal: Element? = null
    var defaultValueId: KotlinString? = null
    var _defaultValueId: Element? = null
    var defaultValueInstant: KotlinString? = null
    var _defaultValueInstant: Element? = null
    var defaultValueInteger: Int? = null
    var _defaultValueInteger: Element? = null
    var defaultValueMarkdown: KotlinString? = null
    var _defaultValueMarkdown: Element? = null
    var defaultValueOid: KotlinString? = null
    var _defaultValueOid: Element? = null
    var defaultValuePositiveInt: Int? = null
    var _defaultValuePositiveInt: Element? = null
    var defaultValueString: KotlinString? = null
    var _defaultValueString: Element? = null
    var defaultValueTime: LocalTime? = null
    var _defaultValueTime: Element? = null
    var defaultValueUnsignedInt: Int? = null
    var _defaultValueUnsignedInt: Element? = null
    var defaultValueUri: KotlinString? = null
    var _defaultValueUri: Element? = null
    var defaultValueUrl: KotlinString? = null
    var _defaultValueUrl: Element? = null
    var defaultValueUuid: KotlinString? = null
    var _defaultValueUuid: Element? = null
    var defaultValueAddress: Address? = null
    var defaultValueAge: Age? = null
    var defaultValueAnnotation: Annotation? = null
    var defaultValueAttachment: Attachment? = null
    var defaultValueCodeableConcept: CodeableConcept? = null
    var defaultValueCoding: Coding? = null
    var defaultValueContactPoint: ContactPoint? = null
    var defaultValueCount: Count? = null
    var defaultValueDistance: Distance? = null
    var defaultValueDuration: Duration? = null
    var defaultValueHumanName: HumanName? = null
    var defaultValueIdentifier: Identifier? = null
    var defaultValueMoney: Money? = null
    var defaultValuePeriod: Period? = null
    var defaultValueQuantity: Quantity? = null
    var defaultValueRange: Range? = null
    var defaultValueRatio: Ratio? = null
    var defaultValueReference: Reference? = null
    var defaultValueSampledData: SampledData? = null
    var defaultValueSignature: Signature? = null
    var defaultValueTiming: Timing? = null
    var defaultValueContactDetail: ContactDetail? = null
    var defaultValueContributor: Contributor? = null
    var defaultValueDataRequirement: DataRequirement? = null
    var defaultValueExpression: Expression? = null
    var defaultValueParameterDefinition: ParameterDefinition? = null
    var defaultValueRelatedArtifact: RelatedArtifact? = null
    var defaultValueTriggerDefinition: TriggerDefinition? = null
    var defaultValueUsageContext: UsageContext? = null
    var defaultValueDosage: Dosage? = null
    var defaultValueMeta: Meta? = null
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> context = decoder.decodeStringElement(__desc, __i)
        4 ->
          _context =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        5 -> min = decoder.decodeIntElement(__desc, __i)
        6 -> _min = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        7 -> max = decoder.decodeStringElement(__desc, __i)
        8 -> _max = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        9 -> type = decoder.decodeStringElement(__desc, __i)
        10 ->
          _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        11 -> defaultValueBase64Binary = decoder.decodeStringElement(__desc, __i)
        12 ->
          _defaultValueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        13 -> defaultValueBoolean = decoder.decodeBooleanElement(__desc, __i)
        14 ->
          _defaultValueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        15 -> defaultValueCanonical = decoder.decodeStringElement(__desc, __i)
        16 ->
          _defaultValueCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        17 -> defaultValueCode = decoder.decodeStringElement(__desc, __i)
        18 ->
          _defaultValueCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        19 -> defaultValueDate = decoder.decodeStringElement(__desc, __i)
        20 ->
          _defaultValueDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        21 -> defaultValueDateTime = decoder.decodeStringElement(__desc, __i)
        22 ->
          _defaultValueDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        23 ->
          defaultValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        24 ->
          _defaultValueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        25 -> defaultValueId = decoder.decodeStringElement(__desc, __i)
        26 ->
          _defaultValueId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        27 -> defaultValueInstant = decoder.decodeStringElement(__desc, __i)
        28 ->
          _defaultValueInstant =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        29 -> defaultValueInteger = decoder.decodeIntElement(__desc, __i)
        30 ->
          _defaultValueInteger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        31 -> defaultValueMarkdown = decoder.decodeStringElement(__desc, __i)
        32 ->
          _defaultValueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        33 -> defaultValueOid = decoder.decodeStringElement(__desc, __i)
        34 ->
          _defaultValueOid =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        35 -> defaultValuePositiveInt = decoder.decodeIntElement(__desc, __i)
        36 ->
          _defaultValuePositiveInt =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        37 -> defaultValueString = decoder.decodeStringElement(__desc, __i)
        38 ->
          _defaultValueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        39 ->
          defaultValueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        40 ->
          _defaultValueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        41 -> defaultValueUnsignedInt = decoder.decodeIntElement(__desc, __i)
        42 ->
          _defaultValueUnsignedInt =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        43 -> defaultValueUri = decoder.decodeStringElement(__desc, __i)
        44 ->
          _defaultValueUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        45 -> defaultValueUrl = decoder.decodeStringElement(__desc, __i)
        46 ->
          _defaultValueUrl =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        47 -> defaultValueUuid = decoder.decodeStringElement(__desc, __i)
        48 ->
          _defaultValueUuid =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        49 ->
          defaultValueAddress =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueAddressSer,
              null,
            )
        50 ->
          defaultValueAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.defaultValueAgeSer, null)
        51 ->
          defaultValueAnnotation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueAnnotationSer,
              null,
            )
        52 ->
          defaultValueAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueAttachmentSer,
              null,
            )
        53 ->
          defaultValueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueCodeableConceptSer,
              null,
            )
        54 ->
          defaultValueCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueCodingSer,
              null,
            )
        55 ->
          defaultValueContactPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueContactPointSer,
              null,
            )
        56 ->
          defaultValueCount =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueCountSer,
              null,
            )
        57 ->
          defaultValueDistance =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueDistanceSer,
              null,
            )
        58 ->
          defaultValueDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueDurationSer,
              null,
            )
        59 ->
          defaultValueHumanName =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueHumanNameSer,
              null,
            )
        60 ->
          defaultValueIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueIdentifierSer,
              null,
            )
        61 ->
          defaultValueMoney =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueMoneySer,
              null,
            )
        62 ->
          defaultValuePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValuePeriodSer,
              null,
            )
        63 ->
          defaultValueQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueQuantitySer,
              null,
            )
        64 ->
          defaultValueRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueRangeSer,
              null,
            )
        65 ->
          defaultValueRatio =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueRatioSer,
              null,
            )
        66 ->
          defaultValueReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueReferenceSer,
              null,
            )
        67 ->
          defaultValueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueSampledDataSer,
              null,
            )
        68 ->
          defaultValueSignature =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueSignatureSer,
              null,
            )
        69 ->
          defaultValueTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueTimingSer,
              null,
            )
        70 ->
          defaultValueContactDetail =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueContactDetailSer,
              null,
            )
        71 ->
          defaultValueContributor =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueContributorSer,
              null,
            )
        72 ->
          defaultValueDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueDataRequirementSer,
              null,
            )
        73 ->
          defaultValueExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueExpressionSer,
              null,
            )
        74 ->
          defaultValueParameterDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueParameterDefinitionSer,
              null,
            )
        75 ->
          defaultValueRelatedArtifact =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueRelatedArtifactSer,
              null,
            )
        76 ->
          defaultValueTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueTriggerDefinitionSer,
              null,
            )
        77 ->
          defaultValueUsageContext =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueUsageContextSer,
              null,
            )
        78 ->
          defaultValueDosage =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueDosageSer,
              null,
            )
        79 ->
          defaultValueMeta =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.defaultValueMetaSer,
              null,
            )
        80 -> element = decoder.decodeStringElement(__desc, __i)
        81 ->
          _element =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        82 -> listMode = decoder.decodeStringElement(__desc, __i)
        83 ->
          _listMode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        84 -> variable = decoder.decodeStringElement(__desc, __i)
        85 ->
          _variable =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        86 -> condition = decoder.decodeStringElement(__desc, __i)
        87 ->
          _condition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        88 -> check = decoder.decodeStringElement(__desc, __i)
        89 ->
          _check = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        90 -> logMessage = decoder.decodeStringElement(__desc, __i)
        91 ->
          _logMessage =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
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
      max = R4bString.of(max, _max),
      type = R4bString.of(type, _type),
      defaultValue =
        StructureMap.Group.Rule.Source.DefaultValue.from(
          Base64Binary.of(defaultValueBase64Binary, _defaultValueBase64Binary),
          R4bBoolean.of(defaultValueBoolean, _defaultValueBoolean),
          Canonical.of(defaultValueCanonical, _defaultValueCanonical),
          Code.of(defaultValueCode, _defaultValueCode),
          Date.of(FhirDate.fromString(defaultValueDate), _defaultValueDate),
          DateTime.of(FhirDateTime.fromString(defaultValueDateTime), _defaultValueDateTime),
          Decimal.of(defaultValueDecimal, _defaultValueDecimal),
          Id.of(defaultValueId, _defaultValueId),
          Instant.of(FhirDateTime.fromString(defaultValueInstant), _defaultValueInstant),
          Integer.of(defaultValueInteger, _defaultValueInteger),
          Markdown.of(defaultValueMarkdown, _defaultValueMarkdown),
          Oid.of(defaultValueOid, _defaultValueOid),
          PositiveInt.of(defaultValuePositiveInt, _defaultValuePositiveInt),
          R4bString.of(defaultValueString, _defaultValueString),
          Time.of(defaultValueTime, _defaultValueTime),
          UnsignedInt.of(defaultValueUnsignedInt, _defaultValueUnsignedInt),
          Uri.of(defaultValueUri, _defaultValueUri),
          Url.of(defaultValueUrl, _defaultValueUrl),
          Uuid.of(defaultValueUuid, _defaultValueUuid),
          defaultValueAddress,
          defaultValueAge,
          defaultValueAnnotation,
          defaultValueAttachment,
          defaultValueCodeableConcept,
          defaultValueCoding,
          defaultValueContactPoint,
          defaultValueCount,
          defaultValueDistance,
          defaultValueDuration,
          defaultValueHumanName,
          defaultValueIdentifier,
          defaultValueMoney,
          defaultValuePeriod,
          defaultValueQuantity,
          defaultValueRange,
          defaultValueRatio,
          defaultValueReference,
          defaultValueSampledData,
          defaultValueSignature,
          defaultValueTiming,
          defaultValueContactDetail,
          defaultValueContributor,
          defaultValueDataRequirement,
          defaultValueExpression,
          defaultValueParameterDefinition,
          defaultValueRelatedArtifact,
          defaultValueTriggerDefinition,
          defaultValueUsageContext,
          defaultValueDosage,
          defaultValueMeta,
        ),
      element = R4bString.of(element, _element),
      listMode =
        listMode?.let {
          Enumeration.of(StructureMap.StructureMapSourceListMode.fromCode(it), _listMode)
        },
      variable = Id.of(variable, _variable),
      condition = R4bString.of(condition, _condition),
      check = R4bString.of(check, _check),
      logMessage = R4bString.of(logMessage, _logMessage),
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
    when (val __d = value.defaultValue) {
      null -> {}
      is StructureMap.Group.Rule.Source.DefaultValue.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 23, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 24, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Id -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 28, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 29, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 30, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 32, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Oid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 34, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 35, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 36, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 38, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 39, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 40, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 41, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 42, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 43, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 44, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 45, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 46, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Uuid -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 47, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 48, Hoisted.contextSer, it)
        }
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Address -> {
        encoder.encodeSerializableElement(__desc, 49, Hoisted.defaultValueAddressSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Age -> {
        encoder.encodeSerializableElement(__desc, 50, Hoisted.defaultValueAgeSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Annotation -> {
        encoder.encodeSerializableElement(__desc, 51, Hoisted.defaultValueAnnotationSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Attachment -> {
        encoder.encodeSerializableElement(__desc, 52, Hoisted.defaultValueAttachmentSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          53,
          Hoisted.defaultValueCodeableConceptSer,
          __d.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Coding -> {
        encoder.encodeSerializableElement(__desc, 54, Hoisted.defaultValueCodingSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.ContactPoint -> {
        encoder.encodeSerializableElement(
          __desc,
          55,
          Hoisted.defaultValueContactPointSer,
          __d.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Count -> {
        encoder.encodeSerializableElement(__desc, 56, Hoisted.defaultValueCountSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Distance -> {
        encoder.encodeSerializableElement(__desc, 57, Hoisted.defaultValueDistanceSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Duration -> {
        encoder.encodeSerializableElement(__desc, 58, Hoisted.defaultValueDurationSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.HumanName -> {
        encoder.encodeSerializableElement(__desc, 59, Hoisted.defaultValueHumanNameSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Identifier -> {
        encoder.encodeSerializableElement(__desc, 60, Hoisted.defaultValueIdentifierSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Money -> {
        encoder.encodeSerializableElement(__desc, 61, Hoisted.defaultValueMoneySer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Period -> {
        encoder.encodeSerializableElement(__desc, 62, Hoisted.defaultValuePeriodSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Quantity -> {
        encoder.encodeSerializableElement(__desc, 63, Hoisted.defaultValueQuantitySer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Range -> {
        encoder.encodeSerializableElement(__desc, 64, Hoisted.defaultValueRangeSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Ratio -> {
        encoder.encodeSerializableElement(__desc, 65, Hoisted.defaultValueRatioSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Reference -> {
        encoder.encodeSerializableElement(__desc, 66, Hoisted.defaultValueReferenceSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.SampledData -> {
        encoder.encodeSerializableElement(__desc, 67, Hoisted.defaultValueSampledDataSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Signature -> {
        encoder.encodeSerializableElement(__desc, 68, Hoisted.defaultValueSignatureSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Timing -> {
        encoder.encodeSerializableElement(__desc, 69, Hoisted.defaultValueTimingSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.ContactDetail -> {
        encoder.encodeSerializableElement(
          __desc,
          70,
          Hoisted.defaultValueContactDetailSer,
          __d.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Contributor -> {
        encoder.encodeSerializableElement(__desc, 71, Hoisted.defaultValueContributorSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.DataRequirement -> {
        encoder.encodeSerializableElement(
          __desc,
          72,
          Hoisted.defaultValueDataRequirementSer,
          __d.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Expression -> {
        encoder.encodeSerializableElement(__desc, 73, Hoisted.defaultValueExpressionSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.ParameterDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          74,
          Hoisted.defaultValueParameterDefinitionSer,
          __d.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.RelatedArtifact -> {
        encoder.encodeSerializableElement(
          __desc,
          75,
          Hoisted.defaultValueRelatedArtifactSer,
          __d.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          76,
          Hoisted.defaultValueTriggerDefinitionSer,
          __d.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.UsageContext -> {
        encoder.encodeSerializableElement(
          __desc,
          77,
          Hoisted.defaultValueUsageContextSer,
          __d.value,
        )
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Dosage -> {
        encoder.encodeSerializableElement(__desc, 78, Hoisted.defaultValueDosageSer, __d.value)
      }
      is StructureMap.Group.Rule.Source.DefaultValue.Meta -> {
        encoder.encodeSerializableElement(__desc, 79, Hoisted.defaultValueMetaSer, __d.value)
      }
    }
    ((value.element?.value))?.let { encoder.encodeStringElement(__desc, 80, it) }
    (value.element?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 81, Hoisted.contextSer, it)
    }
    ((value.listMode?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 82, it) }
    (value.listMode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 83, Hoisted.contextSer, it)
    }
    ((value.variable?.value))?.let { encoder.encodeStringElement(__desc, 84, it) }
    (value.variable?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 85, Hoisted.contextSer, it)
    }
    ((value.condition?.value))?.let { encoder.encodeStringElement(__desc, 86, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 87, Hoisted.contextSer, it)
    }
    ((value.check?.value))?.let { encoder.encodeStringElement(__desc, 88, it) }
    (value.check?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 89, Hoisted.contextSer, it)
    }
    ((value.logMessage?.value))?.let { encoder.encodeStringElement(__desc, 90, it) }
    (value.logMessage?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 91, Hoisted.contextSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contextSer: KSerializer<Element> = Element.serializer()

    public val defaultValueAddressSer: KSerializer<Address> = Address.serializer()

    public val defaultValueAgeSer: KSerializer<Age> = Age.serializer()

    public val defaultValueAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val defaultValueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val defaultValueCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val defaultValueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val defaultValueContactPointSer: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val defaultValueCountSer: KSerializer<Count> = Count.serializer()

    public val defaultValueDistanceSer: KSerializer<Distance> = Distance.serializer()

    public val defaultValueDurationSer: KSerializer<Duration> = Duration.serializer()

    public val defaultValueHumanNameSer: KSerializer<HumanName> = HumanName.serializer()

    public val defaultValueIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val defaultValueMoneySer: KSerializer<Money> = Money.serializer()

    public val defaultValuePeriodSer: KSerializer<Period> = Period.serializer()

    public val defaultValueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val defaultValueRangeSer: KSerializer<Range> = Range.serializer()

    public val defaultValueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val defaultValueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val defaultValueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val defaultValueSignatureSer: KSerializer<Signature> = Signature.serializer()

    public val defaultValueTimingSer: KSerializer<Timing> = Timing.serializer()

    public val defaultValueContactDetailSer: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val defaultValueContributorSer: KSerializer<Contributor> = Contributor.serializer()

    public val defaultValueDataRequirementSer: KSerializer<DataRequirement> =
      DataRequirement.serializer()

    public val defaultValueExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val defaultValueParameterDefinitionSer: KSerializer<ParameterDefinition> =
      ParameterDefinition.serializer()

    public val defaultValueRelatedArtifactSer: KSerializer<RelatedArtifact> =
      RelatedArtifact.serializer()

    public val defaultValueTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val defaultValueUsageContextSer: KSerializer<UsageContext> = UsageContext.serializer()

    public val defaultValueDosageSer: KSerializer<Dosage> = Dosage.serializer()

    public val defaultValueMetaSer: KSerializer<Meta> = Meta.serializer()
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
      element("contextType", KotlinString.serializer().descriptor, isOptional = true)
      element("_contextType", Element.serializer().descriptor, isOptional = true)
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
    var contextType: KotlinString? = null
    var _contextType: Element? = null
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> context = decoder.decodeStringElement(__desc, __i)
        4 ->
          _context =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        5 -> contextType = decoder.decodeStringElement(__desc, __i)
        6 ->
          _contextType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        7 -> element = decoder.decodeStringElement(__desc, __i)
        8 ->
          _element =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        9 -> variable = decoder.decodeStringElement(__desc, __i)
        10 ->
          _variable =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        11 ->
          listMode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.listModeSer, null)
        12 ->
          _listMode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.listModeSer2, null)
        13 -> listRuleId = decoder.decodeStringElement(__desc, __i)
        14 ->
          _listRuleId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        15 -> transform = decoder.decodeStringElement(__desc, __i)
        16 ->
          _transform =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        17 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.parameterSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + __i)
      }
    }
    return StructureMap.Group.Rule.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      context = Id.of(context, _context),
      contextType =
        contextType?.let {
          Enumeration.of(StructureMap.StructureMapContextType.fromCode(it), _contextType)
        },
      element = R4bString.of(element, _element),
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
    ((value.contextType?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.contextType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.contextSer, it)
    }
    ((value.element?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.element?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.contextSer, it)
    }
    ((value.variable?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.variable?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.contextSer, it)
    }
    (value.listMode.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.listModeSer, it)
    }
    (value.listMode.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.listModeSer2, it)
    }
    ((value.listRuleId?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.listRuleId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.contextSer, it)
    }
    ((value.transform?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.transform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.contextSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.parameterSer, value.parameter)
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> valueId = decoder.decodeStringElement(__desc, __i)
        4 ->
          _valueId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdSer, null)
        5 -> valueString = decoder.decodeStringElement(__desc, __i)
        6 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdSer, null)
        9 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        10 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdSer, null)
        11 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        12 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueIdSer, null)
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
          R4bString.of(valueString, _valueString),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          Decimal.of(valueDecimal, _valueDecimal),
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
        "variable",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_variable", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
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
    var variable: List<KotlinString?>? = null
    var _variable: List<Element?>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 ->
          variable =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.variableSer, null)
        6 ->
          _variable =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.variableSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dependent: " + __i)
      }
    }
    return StructureMap.Group.Rule.Dependent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = Id.of(name, _name)!!,
      variable =
        (kotlin.collections.List(maxOf(variable?.size ?: 0, _variable?.size ?: 0)) { __i ->
          R4bString.of(variable?.getOrNull(__i)?.let { it }, _variable?.getOrNull(__i))!!
        }),
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
    (value.variable.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.variableSer, it)
    }
    (value.variable.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.variableSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val variableSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val variableSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.variableSerInner).nullable)

    public val variableSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.nameSer).nullable)
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
      "group",
      listSerialDescriptor(lazyDescriptor { StructureMap.Group.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): StructureMap =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: StructureMap) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "StructureMap")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): StructureMap {
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
    var identifier: List<Identifier>? = null
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
    var structure: List<StructureMap.Structure>? = null
    var `import`: List<KotlinString?>? = null
    var _import: List<Element?>? = null
    var group: List<StructureMap.Group>? = null
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
        36 ->
          structure =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.structureSer, null)
        37 ->
          `import` = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.importSer, null)
        38 ->
          _import = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.importSer2, null)
        39 -> group = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.groupSer, null)
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name)!!,
      title = R4bString.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      structure = structure ?: listOf(),
      `import` =
        (kotlin.collections.List(maxOf(`import`?.size ?: 0, _import?.size ?: 0)) { __i ->
          Canonical.of(`import`?.getOrNull(__i)?.let { it }, _import?.getOrNull(__i))!!
        }),
      group = group ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: StructureMap,
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
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.name.toElement())?.let {
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
    if (value.structure.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.structureSer, value.structure)
    (value.`import`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.importSer, it)
    }
    (value.`import`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.importSer2, it)
    }
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.groupSer, value.group)
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

    public val structureSerInner: KSerializer<StructureMap.Structure> =
      StructureMap.Structure.serializer()

    public val structureSer: KSerializer<List<StructureMap.Structure>> =
      ListSerializer(Hoisted.structureSerInner)

    public val importSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val importSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.importSerInner).nullable)

    public val importSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val groupSerInner: KSerializer<StructureMap.Group> = StructureMap.Group.serializer()

    public val groupSer: KSerializer<List<StructureMap.Group>> =
      ListSerializer(Hoisted.groupSerInner)
  }
}

internal object StructureMapPolymorphicSerializer : KSerializer<StructureMap> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureMap") { StructureMapSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: StructureMap) {
    encoder.encodeStructure(descriptor) {
      StructureMapSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): StructureMap =
    decoder.decodeStructure(descriptor) {
      StructureMapSerializer.deserializeJson(this, descriptor, 0)
    }
}
