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

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object GroupCharacteristicSerializer : KSerializer<Group.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("exclude", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exclude", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Group.Characteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Group.Characteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Group.Characteristic {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueReference: Reference? = null
    var exclude: KotlinBoolean? = null
    var _exclude: Element? = null
    var period: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> valueBoolean = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueBooleanSer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueQuantitySer, null)
        8 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueRangeSer, null)
        9 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueReferenceSer, null)
        10 -> exclude = decoder.decodeBooleanElement(__desc, 10)
        11 ->
          _exclude =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueBooleanSer, null)
        12 ->
          period = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + __i)
      }
    }
    return Group.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      `value` =
        Group.Characteristic.Value.from(
          valueCodeableConcept,
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueQuantity,
          valueRange,
          valueReference,
        )!!,
      exclude = R4bBoolean.of(exclude, _exclude)!!,
      period = period,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Group.Characteristic) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is Group.Characteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, __d.value)
      }
      is Group.Characteristic.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueBooleanSer, it)
        }
      }
      is Group.Characteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueQuantitySer, __d.value)
      }
      is Group.Characteristic.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.valueRangeSer, __d.value)
      }
      is Group.Characteristic.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.valueReferenceSer, __d.value)
      }
    }
    ((value.exclude.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
    (value.exclude.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.valueBooleanSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueBooleanSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object GroupMemberSerializer : KSerializer<Group.Member> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Member") {
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
      element("entity", Reference.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element("inactive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_inactive", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Group.Member =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Group.Member) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Group.Member {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var entity: Reference? = null
    var period: Period? = null
    var inactive: KotlinBoolean? = null
    var _inactive: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> entity = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.entitySer, null)
        4 -> period = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.periodSer, null)
        5 -> inactive = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _inactive =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.inactiveSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Member: " + __i)
      }
    }
    return Group.Member(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      entity = entity!!,
      period = period,
      inactive = R4bBoolean.of(inactive, _inactive),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Group.Member) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.entity)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.entitySer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.periodSer, it) }
    ((value.inactive?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.inactive?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.inactiveSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val entitySer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val inactiveSer: KSerializer<Element> = Element.serializer()
  }
}

internal object GroupSerializer : KSerializer<Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_active", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("actual", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_actual", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("quantity", Int.serializer().descriptor, isOptional = true)
      element("_quantity", Element.serializer().descriptor, isOptional = true)
      element("managingEntity", Reference.serializer().descriptor, isOptional = true)
      element(
        "characteristic",
        listSerialDescriptor(lazyDescriptor { Group.Characteristic.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "member",
        listSerialDescriptor(lazyDescriptor { Group.Member.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Group =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Group) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Group {
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
    var identifier: List<Identifier>? = null
    var active: KotlinBoolean? = null
    var _active: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var code: CodeableConcept? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var quantity: Int? = null
    var _quantity: Element? = null
    var managingEntity: Reference? = null
    var characteristic: List<Group.Characteristic>? = null
    var member: List<Group.Member>? = null
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
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> active = decoder.decodeBooleanElement(__desc, 12)
        13 ->
          _active =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> type = decoder.decodeStringElement(__desc, 14)
        15 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> `actual` = decoder.decodeBooleanElement(__desc, 16)
        17 ->
          _actual =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> code = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.codeSer, null)
        19 -> name = decoder.decodeStringElement(__desc, 19)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> quantity = decoder.decodeIntElement(__desc, 21)
        22 ->
          _quantity =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          managingEntity =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.managingEntitySer, null)
        24 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.characteristicSer, null)
        25 ->
          member = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.memberSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Group: " + __i)
      }
    }
    return Group(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      active = R4bBoolean.of(active, _active),
      type = Enumeration.of(Group.GroupType.fromCode(type!!), _type),
      `actual` = R4bBoolean.of(`actual`, _actual)!!,
      code = code,
      name = R4bString.of(name, _name),
      quantity = UnsignedInt.of(quantity, _quantity),
      managingEntity = managingEntity,
      characteristic = characteristic ?: listOf(),
      member = member ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Group) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Group")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.active?.value))?.let { encoder.encodeBooleanElement(__desc, 12, it) }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.`actual`.value))?.let { encoder.encodeBooleanElement(__desc, 16, it) }
    (value.`actual`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.codeSer, it) }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.quantity?.value))?.let { encoder.encodeIntElement(__desc, 21, it) }
    (value.quantity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.managingEntity)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.managingEntitySer, it)
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.characteristicSer, value.characteristic)
    if (value.member.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.memberSer, value.member)
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

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val managingEntitySer: KSerializer<Reference> = Reference.serializer()

    public val characteristicSerInner: KSerializer<Group.Characteristic> =
      Group.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<Group.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)

    public val memberSerInner: KSerializer<Group.Member> = Group.Member.serializer()

    public val memberSer: KSerializer<List<Group.Member>> = ListSerializer(Hoisted.memberSerInner)
  }
}
