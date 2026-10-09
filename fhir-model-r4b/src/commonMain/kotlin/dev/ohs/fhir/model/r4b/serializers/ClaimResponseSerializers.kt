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

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.ClaimResponse
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.FinancialResourceStatusCodes
import dev.ohs.fhir.model.r4b.terminologies.NoteType
import dev.ohs.fhir.model.r4b.terminologies.RemittanceOutcome
import dev.ohs.fhir.model.r4b.terminologies.Use
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

internal object ClaimResponseItemSerializer : FhirSerializer<ClaimResponse.Item> {
  override val descriptor: SerialDescriptor = buildDescriptor("Item", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.Item>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("itemSequence")
    b.intPrimList("noteNumber")
    b.optionalElement(
      "adjudication",
      ClaimResponseItemAdjudicationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("detail", ClaimResponseItemDetailSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemSequence: Int? = null
    var _itemSequence: Element? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var detail: List<ClaimResponse.Item.Detail>? = null
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
        3 -> itemSequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _itemSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemAdjudicationSerializer.listSerializer,
              null,
            )
        8 ->
          detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val noteNumber_ =
      List(maxSize(noteNumber, _noteNumber)) { index ->
        entryRequired(
          PositiveInt.of(at(noteNumber, index), at(_noteNumber, index)),
          "ClaimResponse.Item",
          "noteNumber",
        )
      }
    return ClaimResponse.Item(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      itemSequence =
        required(PositiveInt.of(itemSequence, _itemSequence), "ClaimResponse.Item", "itemSequence"),
      noteNumber = noteNumber_,
      adjudication = listOrEmpty(adjudication),
      detail = listOrEmpty(detail),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.itemSequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.itemSequence)
    if (!value.noteNumber.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.noteNumber)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ClaimResponseItemAdjudicationSerializer.listSerializer,
      value.adjudication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      ClaimResponseItemDetailSerializer.listSerializer,
      value.detail,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseItemAdjudicationSerializer :
  FhirSerializer<ClaimResponse.Item.Adjudication> {
  override val descriptor: SerialDescriptor = buildDescriptor("Adjudication", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.Item.Adjudication>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("reason", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", MoneySerializer.descriptor)
    b.prim("value", FhirDecimalSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item.Adjudication {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var reason: CodeableConcept? = null
    var amount: Money? = null
    var `value`: FhirDecimal? = null
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
        3 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        6 ->
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        7 ->
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
    return ClaimResponse.Item.Adjudication(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      category = required(category, "ClaimResponse.Item.Adjudication", "category"),
      reason = reason,
      amount = amount,
      `value` = Decimal.of(`value`, _value),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Adjudication) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.reason,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, MoneySerializer, value.amount)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      FhirDecimalSerializer,
      value.`value`?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseItemDetailSerializer : FhirSerializer<ClaimResponse.Item.Detail> {
  override val descriptor: SerialDescriptor = buildDescriptor("Detail", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.Item.Detail>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("detailSequence")
    b.intPrimList("noteNumber")
    b.optionalElement(
      "adjudication",
      listSerialDescriptor(
        lazyDescriptor(LazyDescriptorId.ClaimResponseItemAdjudicationSerializer)
      ),
    )
    b.optionalElement(
      "subDetail",
      ClaimResponseItemDetailSubDetailSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item.Detail {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var detailSequence: Int? = null
    var _detailSequence: Element? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var subDetail: List<ClaimResponse.Item.Detail.SubDetail>? = null
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
        3 -> detailSequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _detailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemAdjudicationSerializer.listSerializer,
              null,
            )
        8 ->
          subDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemDetailSubDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val noteNumber_ =
      List(maxSize(noteNumber, _noteNumber)) { index ->
        entryRequired(
          PositiveInt.of(at(noteNumber, index), at(_noteNumber, index)),
          "ClaimResponse.Item.Detail",
          "noteNumber",
        )
      }
    return ClaimResponse.Item.Detail(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      detailSequence =
        required(
          PositiveInt.of(detailSequence, _detailSequence),
          "ClaimResponse.Item.Detail",
          "detailSequence",
        ),
      noteNumber = noteNumber_,
      adjudication = listOrEmpty(adjudication),
      subDetail = listOrEmpty(subDetail),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Detail) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.detailSequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.detailSequence)
    if (!value.noteNumber.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.noteNumber)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ClaimResponseItemAdjudicationSerializer.listSerializer,
      value.adjudication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      ClaimResponseItemDetailSubDetailSerializer.listSerializer,
      value.subDetail,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseItemDetailSubDetailSerializer :
  FhirSerializer<ClaimResponse.Item.Detail.SubDetail> {
  override val descriptor: SerialDescriptor = buildDescriptor("SubDetail", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.Item.Detail.SubDetail>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("subDetailSequence")
    b.intPrimList("noteNumber")
    b.optionalElement(
      "adjudication",
      listSerialDescriptor(
        lazyDescriptor(LazyDescriptorId.ClaimResponseItemAdjudicationSerializer)
      ),
    )
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item.Detail.SubDetail {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var subDetailSequence: Int? = null
    var _subDetailSequence: Element? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
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
        3 -> subDetailSequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _subDetailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemAdjudicationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val noteNumber_ =
      List(maxSize(noteNumber, _noteNumber)) { index ->
        entryRequired(
          PositiveInt.of(at(noteNumber, index), at(_noteNumber, index)),
          "ClaimResponse.Item.Detail.SubDetail",
          "noteNumber",
        )
      }
    return ClaimResponse.Item.Detail.SubDetail(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      subDetailSequence =
        required(
          PositiveInt.of(subDetailSequence, _subDetailSequence),
          "ClaimResponse.Item.Detail.SubDetail",
          "subDetailSequence",
        ),
      noteNumber = noteNumber_,
      adjudication = listOrEmpty(adjudication),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Detail.SubDetail) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.subDetailSequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.subDetailSequence)
    if (!value.noteNumber.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.noteNumber)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ClaimResponseItemAdjudicationSerializer.listSerializer,
      value.adjudication,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseAddItemSerializer : FhirSerializer<ClaimResponse.AddItem> {
  override val descriptor: SerialDescriptor = buildDescriptor("AddItem", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.AddItem>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrimList("itemSequence")
    b.intPrimList("detailSequence")
    b.intPrimList("subdetailSequence")
    b.optionalElement("provider", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("productOrService", CodeableConceptSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("servicedDate")
    b.optionalElement("servicedPeriod", PeriodSerializer.descriptor)
    b.optionalElement("locationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("locationAddress", AddressSerializer.descriptor)
    b.optionalElement("locationReference", ReferenceSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("unitPrice", MoneySerializer.descriptor)
    b.prim("factor", FhirDecimalSerializer.descriptor)
    b.optionalElement("net", MoneySerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.descriptor)
    b.optionalElement("subSite", CodeableConceptSerializer.listSerializer.descriptor)
    b.intPrimList("noteNumber")
    b.optionalElement(
      "adjudication",
      ClaimResponseItemAdjudicationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("detail", ClaimResponseAddItemDetailSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemSequence: List<Int?>? = null
    var _itemSequence: List<Element?>? = null
    var detailSequence: List<Int?>? = null
    var _detailSequence: List<Element?>? = null
    var subdetailSequence: List<Int?>? = null
    var _subdetailSequence: List<Element?>? = null
    var provider: List<Reference>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var servicedDate: FhirDate? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var locationCodeableConcept: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var bodySite: CodeableConcept? = null
    var subSite: List<CodeableConcept>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var detail: List<ClaimResponse.AddItem.Detail>? = null
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
          itemSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        4 ->
          _itemSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 ->
          detailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _detailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          subdetailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        8 ->
          _subdetailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 ->
          provider =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        10 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          programCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          servicedDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _servicedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          servicedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        16 ->
          locationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          locationAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        18 ->
          locationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        20 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        21 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        22 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        24 ->
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          subSite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        26 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        27 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        28 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemAdjudicationSerializer.listSerializer,
              null,
            )
        29 ->
          detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseAddItemDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val itemSequence_ =
      List(maxSize(itemSequence, _itemSequence)) { index ->
        entryRequired(
          PositiveInt.of(at(itemSequence, index), at(_itemSequence, index)),
          "ClaimResponse.AddItem",
          "itemSequence",
        )
      }
    val detailSequence_ =
      List(maxSize(detailSequence, _detailSequence)) { index ->
        entryRequired(
          PositiveInt.of(at(detailSequence, index), at(_detailSequence, index)),
          "ClaimResponse.AddItem",
          "detailSequence",
        )
      }
    val subdetailSequence_ =
      List(maxSize(subdetailSequence, _subdetailSequence)) { index ->
        entryRequired(
          PositiveInt.of(at(subdetailSequence, index), at(_subdetailSequence, index)),
          "ClaimResponse.AddItem",
          "subdetailSequence",
        )
      }
    val noteNumber_ =
      List(maxSize(noteNumber, _noteNumber)) { index ->
        entryRequired(
          PositiveInt.of(at(noteNumber, index), at(_noteNumber, index)),
          "ClaimResponse.AddItem",
          "noteNumber",
        )
      }
    return ClaimResponse.AddItem(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      itemSequence = itemSequence_,
      detailSequence = detailSequence_,
      subdetailSequence = subdetailSequence_,
      provider = listOrEmpty(provider),
      productOrService = required(productOrService, "ClaimResponse.AddItem", "productOrService"),
      modifier = listOrEmpty(modifier),
      programCode = listOrEmpty(programCode),
      serviced =
        ClaimResponse.AddItem.Serviced.from(Date.of(servicedDate, _servicedDate), servicedPeriod),
      location =
        ClaimResponse.AddItem.Location.from(
          locationCodeableConcept,
          locationAddress,
          locationReference,
        ),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      bodySite = bodySite,
      subSite = listOrEmpty(subSite),
      noteNumber = noteNumber_,
      adjudication = listOrEmpty(adjudication),
      detail = listOrEmpty(detail),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem) {
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
    if (!value.itemSequence.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        3,
        intNullableListSerializer,
        value.itemSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 4, value.itemSequence)
    }
    if (!value.detailSequence.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        intNullableListSerializer,
        value.detailSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.detailSequence)
    }
    if (!value.subdetailSequence.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        intNullableListSerializer,
        value.subdetailSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.subdetailSequence)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      ReferenceSerializer.listSerializer,
      value.provider,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      10,
      CodeableConceptSerializer,
      value.productOrService,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      CodeableConceptSerializer.listSerializer,
      value.modifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      CodeableConceptSerializer.listSerializer,
      value.programCode,
    )
    when (val choice = value.serviced) {
      null -> {}
      is ClaimResponse.AddItem.Serviced.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is ClaimResponse.AddItem.Serviced.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 15, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is ClaimResponse.AddItem.Location.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          16,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ClaimResponse.AddItem.Location.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 17, AddressSerializer, choice.value)
      }
      is ClaimResponse.AddItem.Location.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          18,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 19, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 20, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 23, MoneySerializer, value.net)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24,
      CodeableConceptSerializer,
      value.bodySite,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25,
      CodeableConceptSerializer.listSerializer,
      value.subSite,
    )
    if (!value.noteNumber.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        26,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 27, value.noteNumber)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      28,
      ClaimResponseItemAdjudicationSerializer.listSerializer,
      value.adjudication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29,
      ClaimResponseAddItemDetailSerializer.listSerializer,
      value.detail,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseAddItemDetailSerializer :
  FhirSerializer<ClaimResponse.AddItem.Detail> {
  override val descriptor: SerialDescriptor = buildDescriptor("Detail", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.AddItem.Detail>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("productOrService", CodeableConceptSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("unitPrice", MoneySerializer.descriptor)
    b.prim("factor", FhirDecimalSerializer.descriptor)
    b.optionalElement("net", MoneySerializer.descriptor)
    b.intPrimList("noteNumber")
    b.optionalElement(
      "adjudication",
      listSerialDescriptor(
        lazyDescriptor(LazyDescriptorId.ClaimResponseItemAdjudicationSerializer)
      ),
    )
    b.optionalElement(
      "subDetail",
      ClaimResponseAddItemDetailSubDetailSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem.Detail {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var subDetail: List<ClaimResponse.AddItem.Detail.SubDetail>? = null
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
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        7 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        8 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        10 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        11 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        12 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemAdjudicationSerializer.listSerializer,
              null,
            )
        13 ->
          subDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseAddItemDetailSubDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val noteNumber_ =
      List(maxSize(noteNumber, _noteNumber)) { index ->
        entryRequired(
          PositiveInt.of(at(noteNumber, index), at(_noteNumber, index)),
          "ClaimResponse.AddItem.Detail",
          "noteNumber",
        )
      }
    return ClaimResponse.AddItem.Detail(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      productOrService =
        required(productOrService, "ClaimResponse.AddItem.Detail", "productOrService"),
      modifier = listOrEmpty(modifier),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      noteNumber = noteNumber_,
      adjudication = listOrEmpty(adjudication),
      subDetail = listOrEmpty(subDetail),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.Detail) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.productOrService,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.modifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 9, MoneySerializer, value.net)
    if (!value.noteNumber.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        10,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 11, value.noteNumber)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      ClaimResponseItemAdjudicationSerializer.listSerializer,
      value.adjudication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      ClaimResponseAddItemDetailSubDetailSerializer.listSerializer,
      value.subDetail,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseAddItemDetailSubDetailSerializer :
  FhirSerializer<ClaimResponse.AddItem.Detail.SubDetail> {
  override val descriptor: SerialDescriptor = buildDescriptor("SubDetail", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.AddItem.Detail.SubDetail>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("productOrService", CodeableConceptSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("unitPrice", MoneySerializer.descriptor)
    b.prim("factor", FhirDecimalSerializer.descriptor)
    b.optionalElement("net", MoneySerializer.descriptor)
    b.intPrimList("noteNumber")
    b.optionalElement(
      "adjudication",
      listSerialDescriptor(
        lazyDescriptor(LazyDescriptorId.ClaimResponseItemAdjudicationSerializer)
      ),
    )
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem.Detail.SubDetail {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
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
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        7 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        8 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        10 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        11 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        12 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemAdjudicationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val noteNumber_ =
      List(maxSize(noteNumber, _noteNumber)) { index ->
        entryRequired(
          PositiveInt.of(at(noteNumber, index), at(_noteNumber, index)),
          "ClaimResponse.AddItem.Detail.SubDetail",
          "noteNumber",
        )
      }
    return ClaimResponse.AddItem.Detail.SubDetail(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      productOrService =
        required(productOrService, "ClaimResponse.AddItem.Detail.SubDetail", "productOrService"),
      modifier = listOrEmpty(modifier),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      noteNumber = noteNumber_,
      adjudication = listOrEmpty(adjudication),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.Detail.SubDetail) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.productOrService,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.modifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 9, MoneySerializer, value.net)
    if (!value.noteNumber.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        10,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 11, value.noteNumber)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      ClaimResponseItemAdjudicationSerializer.listSerializer,
      value.adjudication,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseTotalSerializer : FhirSerializer<ClaimResponse.Total> {
  override val descriptor: SerialDescriptor = buildDescriptor("Total", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.Total>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", MoneySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Total {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var amount: Money? = null
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
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ClaimResponse.Total(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      category = required(category, "ClaimResponse.Total", "category"),
      amount = required(amount, "ClaimResponse.Total", "amount"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Total) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, MoneySerializer, value.amount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponsePaymentSerializer : FhirSerializer<ClaimResponse.Payment> {
  override val descriptor: SerialDescriptor = buildDescriptor("Payment", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.Payment>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("adjustment", MoneySerializer.descriptor)
    b.optionalElement("adjustmentReason", CodeableConceptSerializer.descriptor)
    b.strPrim("date")
    b.optionalElement("amount", MoneySerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Payment {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var adjustment: Money? = null
    var adjustmentReason: CodeableConcept? = null
    var date: FhirDate? = null
    var _date: Element? = null
    var amount: Money? = null
    var identifier: Identifier? = null
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
              CodeableConceptSerializer,
              null,
            )
        4 ->
          adjustment =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        5 ->
          adjustmentReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> date = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        7 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        9 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ClaimResponse.Payment(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "ClaimResponse.Payment", "type"),
      adjustment = adjustment,
      adjustmentReason = adjustmentReason,
      date = Date.of(date, _date),
      amount = required(amount, "ClaimResponse.Payment", "amount"),
      identifier = identifier,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Payment) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, MoneySerializer, value.adjustment)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.adjustmentReason,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.date)
    compositeEncoder.encodeSerializableElement(descriptor, 8, MoneySerializer, value.amount)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseProcessNoteSerializer : FhirSerializer<ClaimResponse.ProcessNote> {
  override val descriptor: SerialDescriptor = buildDescriptor("ProcessNote", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.ProcessNote>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("number")
    b.strPrim("type")
    b.strPrim("text")
    b.optionalElement("language", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.ProcessNote {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var number: Int? = null
    var _number: Element? = null
    var type: NoteType? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var language: CodeableConcept? = null
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
        3 -> number = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _number =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> type = NoteType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ClaimResponse.ProcessNote(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      number = PositiveInt.of(number, _number),
      type = Enumeration.of(type, _type),
      text = required(R4bString.of(text, _text), "ClaimResponse.ProcessNote", "text"),
      language = language,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.ProcessNote) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.number?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.number)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.text.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.text)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.language,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseInsuranceSerializer : FhirSerializer<ClaimResponse.Insurance> {
  override val descriptor: SerialDescriptor = buildDescriptor("Insurance", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.Insurance>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.boolPrim("focal")
    b.optionalElement("coverage", ReferenceSerializer.descriptor)
    b.strPrim("businessArrangement")
    b.optionalElement("claimResponse", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Insurance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var focal: KotlinBoolean? = null
    var _focal: Element? = null
    var coverage: Reference? = null
    var businessArrangement: KotlinString? = null
    var _businessArrangement: Element? = null
    var claimResponse: Reference? = null
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
        3 -> sequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> focal = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _focal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          coverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 -> businessArrangement = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _businessArrangement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          claimResponse =
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
    return ClaimResponse.Insurance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence =
        required(PositiveInt.of(sequence, _sequence), "ClaimResponse.Insurance", "sequence"),
      focal = required(R4bBoolean.of(focal, _focal), "ClaimResponse.Insurance", "focal"),
      coverage = required(coverage, "ClaimResponse.Insurance", "coverage"),
      businessArrangement = R4bString.of(businessArrangement, _businessArrangement),
      claimResponse = claimResponse,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Insurance) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.focal.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.focal)
    compositeEncoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, value.coverage)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.businessArrangement?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.businessArrangement)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      ReferenceSerializer,
      value.claimResponse,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseErrorSerializer : FhirSerializer<ClaimResponse.Error> {
  override val descriptor: SerialDescriptor = buildDescriptor("Error", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClaimResponse.Error>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("itemSequence")
    b.intPrim("detailSequence")
    b.intPrim("subDetailSequence")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Error {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemSequence: Int? = null
    var _itemSequence: Element? = null
    var detailSequence: Int? = null
    var _detailSequence: Element? = null
    var subDetailSequence: Int? = null
    var _subDetailSequence: Element? = null
    var code: CodeableConcept? = null
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
        3 -> itemSequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _itemSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> detailSequence = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _detailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> subDetailSequence = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _subDetailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ClaimResponse.Error(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      itemSequence = PositiveInt.of(itemSequence, _itemSequence),
      detailSequence = PositiveInt.of(detailSequence, _detailSequence),
      subDetailSequence = PositiveInt.of(subDetailSequence, _subDetailSequence),
      code = required(code, "ClaimResponse.Error", "code"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Error) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.itemSequence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.itemSequence)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.detailSequence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.detailSequence)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.subDetailSequence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.subDetailSequence)
    compositeEncoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, value.code)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimResponseSerializer : FhirResourceSerializer<ClaimResponse> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ClaimResponse")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("subType", CodeableConceptSerializer.descriptor)
    b.strPrim("use")
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.strPrim("created")
    b.optionalElement("insurer", ReferenceSerializer.descriptor)
    b.optionalElement("requestor", ReferenceSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.descriptor)
    b.strPrim("outcome")
    b.strPrim("disposition")
    b.strPrim("preAuthRef")
    b.optionalElement("preAuthPeriod", PeriodSerializer.descriptor)
    b.optionalElement("payeeType", CodeableConceptSerializer.descriptor)
    b.optionalElement("item", ClaimResponseItemSerializer.listSerializer.descriptor)
    b.optionalElement("addItem", ClaimResponseAddItemSerializer.listSerializer.descriptor)
    b.optionalElement(
      "adjudication",
      ClaimResponseItemAdjudicationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("total", ClaimResponseTotalSerializer.listSerializer.descriptor)
    b.optionalElement("payment", ClaimResponsePaymentSerializer.descriptor)
    b.optionalElement("fundsReserve", CodeableConceptSerializer.descriptor)
    b.optionalElement("formCode", CodeableConceptSerializer.descriptor)
    b.optionalElement("form", AttachmentSerializer.descriptor)
    b.optionalElement("processNote", ClaimResponseProcessNoteSerializer.listSerializer.descriptor)
    b.optionalElement("communicationRequest", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("insurance", ClaimResponseInsuranceSerializer.listSerializer.descriptor)
    b.optionalElement("error", ClaimResponseErrorSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ClaimResponse {
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
    var status: FinancialResourceStatusCodes? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var subType: CodeableConcept? = null
    var use: Use? = null
    var _use: Element? = null
    var patient: Reference? = null
    var created: FhirDateTime? = null
    var _created: Element? = null
    var insurer: Reference? = null
    var requestor: Reference? = null
    var request: Reference? = null
    var outcome: RemittanceOutcome? = null
    var _outcome: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var preAuthRef: KotlinString? = null
    var _preAuthRef: Element? = null
    var preAuthPeriod: Period? = null
    var payeeType: CodeableConcept? = null
    var item: List<ClaimResponse.Item>? = null
    var addItem: List<ClaimResponse.AddItem>? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var total: List<ClaimResponse.Total>? = null
    var payment: ClaimResponse.Payment? = null
    var fundsReserve: CodeableConcept? = null
    var formCode: CodeableConcept? = null
    var form: Attachment? = null
    var processNote: List<ClaimResponse.ProcessNote>? = null
    var communicationRequest: List<Reference>? = null
    var insurance: List<ClaimResponse.Insurance>? = null
    var error: List<ClaimResponse.Error>? = null
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
        11 ->
          status =
            FinancialResourceStatusCodes.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          subType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 -> use = Use.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 -> created = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        19 ->
          _created =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          insurer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 ->
          requestor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          request =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 ->
          outcome = RemittanceOutcome.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> disposition = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _disposition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> preAuthRef = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _preAuthRef =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 ->
          preAuthPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        30 ->
          payeeType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        31 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemSerializer.listSerializer,
              null,
            )
        32 ->
          addItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseAddItemSerializer.listSerializer,
              null,
            )
        33 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseItemAdjudicationSerializer.listSerializer,
              null,
            )
        34 ->
          total =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseTotalSerializer.listSerializer,
              null,
            )
        35 ->
          payment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponsePaymentSerializer,
              null,
            )
        36 ->
          fundsReserve =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        37 ->
          formCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        38 ->
          form =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        39 ->
          processNote =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseProcessNoteSerializer.listSerializer,
              null,
            )
        40 ->
          communicationRequest =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        41 ->
          insurance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseInsuranceSerializer.listSerializer,
              null,
            )
        42 ->
          error =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimResponseErrorSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return ClaimResponse(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      status = required(Enumeration.of(status, _status), "ClaimResponse", "status"),
      type = required(type, "ClaimResponse", "type"),
      subType = subType,
      use = required(Enumeration.of(use, _use), "ClaimResponse", "use"),
      patient = required(patient, "ClaimResponse", "patient"),
      created = required(DateTime.of(created, _created), "ClaimResponse", "created"),
      insurer = required(insurer, "ClaimResponse", "insurer"),
      requestor = requestor,
      request = request,
      outcome = required(Enumeration.of(outcome, _outcome), "ClaimResponse", "outcome"),
      disposition = R4bString.of(disposition, _disposition),
      preAuthRef = R4bString.of(preAuthRef, _preAuthRef),
      preAuthPeriod = preAuthPeriod,
      payeeType = payeeType,
      item = listOrEmpty(item),
      addItem = listOrEmpty(addItem),
      adjudication = listOrEmpty(adjudication),
      total = listOrEmpty(total),
      payment = payment,
      fundsReserve = fundsReserve,
      formCode = formCode,
      form = form,
      processNote = listOrEmpty(processNote),
      communicationRequest = listOrEmpty(communicationRequest),
      insurance = listOrEmpty(insurance),
      error = listOrEmpty(error),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ClaimResponse,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.subType,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.use.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.use)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.created.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.created)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.insurer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.requestor,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.request,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.outcome.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.outcome)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.disposition?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.disposition)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.preAuthRef?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.preAuthRef)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      PeriodSerializer,
      value.preAuthPeriod,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      CodeableConceptSerializer,
      value.payeeType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      ClaimResponseItemSerializer.listSerializer,
      value.item,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ClaimResponseAddItemSerializer.listSerializer,
      value.addItem,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      ClaimResponseItemAdjudicationSerializer.listSerializer,
      value.adjudication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      ClaimResponseTotalSerializer.listSerializer,
      value.total,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      ClaimResponsePaymentSerializer,
      value.payment,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      36 + descriptorOffset,
      CodeableConceptSerializer,
      value.fundsReserve,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      CodeableConceptSerializer,
      value.formCode,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      AttachmentSerializer,
      value.form,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      39 + descriptorOffset,
      ClaimResponseProcessNoteSerializer.listSerializer,
      value.processNote,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      40 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.communicationRequest,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      41 + descriptorOffset,
      ClaimResponseInsuranceSerializer.listSerializer,
      value.insurance,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      42 + descriptorOffset,
      ClaimResponseErrorSerializer.listSerializer,
      value.error,
    )
  }
}
