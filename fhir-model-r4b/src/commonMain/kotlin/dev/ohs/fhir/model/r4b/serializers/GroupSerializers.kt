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
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.GroupType
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

internal object GroupCharacteristicSerializer : KSerializer<Group.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
      optionalElement("exclude", KotlinBoolean.serializer().descriptor)
      optionalElement("_exclude", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Group.Characteristic>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Group.Characteristic {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        8 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        9 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        10 -> exclude = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _exclude =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Group.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on Group.Characteristic"
          ),
      `value` =
        Group.Characteristic.Value.from(
          valueCodeableConcept,
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueQuantity,
          valueRange,
          valueReference,
        )
          ?: throw SerializationException(
            "Missing required property 'value' on Group.Characteristic"
          ),
      exclude =
        R4bBoolean.of(exclude, _exclude)
          ?: throw SerializationException(
            "Missing required property 'exclude' on Group.Characteristic"
          ),
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Group.Characteristic) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    when (val choice = value.`value`) {
      is Group.Characteristic.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Group.Characteristic.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is Group.Characteristic.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
      }
      is Group.Characteristic.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, RangeSerializer, choice.value)
      }
      is Group.Characteristic.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, value.exclude.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.exclude)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 12, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object GroupMemberSerializer : KSerializer<Group.Member> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Member") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("entity", ReferenceSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("inactive", KotlinBoolean.serializer().descriptor)
      optionalElement("_inactive", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Group.Member>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Group.Member {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var entity: Reference? = null
    var period: Period? = null
    var inactive: KotlinBoolean? = null
    var _inactive: Element? = null
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
          entity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        5 -> inactive = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _inactive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Member: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Group.Member(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      entity =
        entity
          ?: throw SerializationException("Missing required property 'entity' on Group.Member"),
      period = period,
      inactive = R4bBoolean.of(inactive, _inactive),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Group.Member) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.entity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.period)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.inactive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.inactive)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object GroupSerializer : FhirResourceSerializer<Group> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Group")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("active", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_active", ElementSerializer.descriptor)
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("actual", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_actual", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("quantity", Int.serializer().descriptor)
    b.optionalElement("_quantity", ElementSerializer.descriptor)
    b.optionalElement("managingEntity", ReferenceSerializer.descriptor)
    b.optionalElement("characteristic", GroupCharacteristicSerializer.listSerializer.descriptor)
    b.optionalElement("member", GroupMemberSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Group {
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
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> active = compositeDecoder.decodeBooleanElement(descriptor, i)
        12 ->
          _active =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> `actual` = compositeDecoder.decodeBooleanElement(descriptor, i)
        16 ->
          _actual =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
        20 -> quantity = compositeDecoder.decodeIntElement(descriptor, i)
        21 ->
          _quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          managingEntity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 ->
          characteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GroupCharacteristicSerializer.listSerializer,
              null,
            )
        24 ->
          member =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GroupMemberSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Group: " + i)
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
      type =
        Enumeration.of(if (type != null) GroupType.fromCode(type) else null, _type)
          ?: throw SerializationException("Missing required property 'type' on Group"),
      `actual` =
        R4bBoolean.of(`actual`, _actual)
          ?: throw SerializationException("Missing required property 'actual' on Group"),
      code = code,
      name = R4bString.of(name, _name),
      quantity = UnsignedInt.of(quantity, _quantity),
      managingEntity = managingEntity,
      characteristic = characteristic ?: listOf(),
      member = member ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Group,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 11 + descriptorOffset, value.active?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.active)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.type.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.type)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 15 + descriptorOffset, value.`actual`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.`actual`)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    compositeEncoder.encodeIntIfNotNull(descriptor, 20 + descriptorOffset, value.quantity?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.managingEntity,
    )
    if (value.characteristic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        GroupCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
    if (value.member.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        GroupMemberSerializer.listSerializer,
        value.member,
      )
  }
}
