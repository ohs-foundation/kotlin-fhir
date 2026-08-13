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

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.ClaimResponse
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.NoteType
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

internal object ClaimResponseItemSerializer : KSerializer<ClaimResponse.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
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
      element("itemSequence", Int.serializer().descriptor, isOptional = true)
      element("_itemSequence", Element.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "detail",
        listSerialDescriptor(lazyDescriptor { ClaimResponse.Item.Detail.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.Item {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> itemSequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        5 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        6 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        7 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        8 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return ClaimResponse.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence =
        PositiveInt.of(itemSequence, _itemSequence)
          ?: throw SerializationException(
            "Missing required property 'itemSequence' on ClaimResponse.Item"
          ),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.Item) {
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
    ((value.itemSequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.itemSequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemSequenceSer, it)
    }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSequenceSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.itemSequenceSer).nullable)

    public val adjudicationSerInner: KSerializer<ClaimResponse.Item.Adjudication> =
      ClaimResponse.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ClaimResponse.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val detailSerInner: KSerializer<ClaimResponse.Item.Detail> =
      ClaimResponse.Item.Detail.serializer()

    public val detailSer: KSerializer<List<ClaimResponse.Item.Detail>> =
      ListSerializer(Hoisted.detailSerInner)
  }
}

internal object ClaimResponseItemAdjudicationSerializer :
  KSerializer<ClaimResponse.Item.Adjudication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Adjudication") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
      element("value", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item.Adjudication =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Adjudication) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.Item.Adjudication {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var reason: CodeableConcept? = null
    var amount: Money? = null
    var `value`: FhirDecimal? = null
    var _value: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        5 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        6 ->
          `value` =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        7 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Adjudication: " + i)
      }
    }
    return ClaimResponse.Item.Adjudication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ClaimResponse.Item.Adjudication"
          ),
      reason = reason,
      amount = amount,
      `value` = Decimal.of(`value`, _value),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClaimResponse.Item.Adjudication,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, value.category)
    (value.reason)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.categorySer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.amountSer, it) }
    ((value.`value`?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 6, FhirDecimalSerializer, it)
    }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ClaimResponseItemDetailSerializer : KSerializer<ClaimResponse.Item.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
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
      element("detailSequence", Int.serializer().descriptor, isOptional = true)
      element("_detailSequence", Element.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "subDetail",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.Item.Detail.SubDetail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item.Detail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Detail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.Item.Detail {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> detailSequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.detailSequenceSer,
              null,
            )
        5 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        6 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        7 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        8 ->
          subDetail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    return ClaimResponse.Item.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      detailSequence =
        PositiveInt.of(detailSequence, _detailSequence)
          ?: throw SerializationException(
            "Missing required property 'detailSequence' on ClaimResponse.Item.Detail"
          ),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.Item.Detail) {
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
    ((value.detailSequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.detailSequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.detailSequenceSer, it)
    }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.subDetailSer, value.subDetail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val detailSequenceSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.detailSequenceSer).nullable)

    public val adjudicationSerInner: KSerializer<ClaimResponse.Item.Adjudication> =
      ClaimResponse.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ClaimResponse.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val subDetailSerInner: KSerializer<ClaimResponse.Item.Detail.SubDetail> =
      ClaimResponse.Item.Detail.SubDetail.serializer()

    public val subDetailSer: KSerializer<List<ClaimResponse.Item.Detail.SubDetail>> =
      ListSerializer(Hoisted.subDetailSerInner)
  }
}

internal object ClaimResponseItemDetailSubDetailSerializer :
  KSerializer<ClaimResponse.Item.Detail.SubDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubDetail") {
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
      element("subDetailSequence", Int.serializer().descriptor, isOptional = true)
      element("_subDetailSequence", Element.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item.Detail.SubDetail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.Item.Detail.SubDetail {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var subDetailSequence: Int? = null
    var _subDetailSequence: Element? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> subDetailSequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _subDetailSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subDetailSequenceSer,
              null,
            )
        5 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        6 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        7 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
      }
    }
    return ClaimResponse.Item.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      subDetailSequence =
        PositiveInt.of(subDetailSequence, _subDetailSequence)
          ?: throw SerializationException(
            "Missing required property 'subDetailSequence' on ClaimResponse.Item.Detail.SubDetail"
          ),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      adjudication = adjudication ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClaimResponse.Item.Detail.SubDetail,
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
    ((value.subDetailSequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.subDetailSequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.subDetailSequenceSer, it)
    }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.adjudicationSer, value.adjudication)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val subDetailSequenceSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.subDetailSequenceSer).nullable)

    public val adjudicationSerInner: KSerializer<ClaimResponse.Item.Adjudication> =
      ClaimResponse.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ClaimResponse.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)
  }
}

internal object ClaimResponseAddItemSerializer : KSerializer<ClaimResponse.AddItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AddItem") {
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
      element("itemSequence", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_itemSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "detailSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_detailSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "subdetailSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_subdetailSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "provider",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
      element("locationCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("locationAddress", Address.serializer().descriptor, isOptional = true)
      element("locationReference", Reference.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "subSite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "detail",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.AddItem.Detail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.AddItem {
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
    var servicedDate: KotlinString? = null
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          itemSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer2, null)
        5 ->
          detailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        6 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer2, null)
        7 ->
          subdetailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        8 ->
          _subdetailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer2, null)
        9 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSer, null)
        10 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.productOrServiceSer,
              null,
            )
        11 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        12 ->
          programCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        13 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        14 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        15 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.servicedPeriodSer,
              null,
            )
        16 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.productOrServiceSer,
              null,
            )
        17 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.locationAddressSer,
              null,
            )
        18 ->
          locationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSerInner, null)
        19 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        20 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        21 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        22 ->
          _factor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        23 ->
          net = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        24 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.productOrServiceSer,
              null,
            )
        25 ->
          subSite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        26 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        27 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer2, null)
        28 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        29 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AddItem: " + i)
      }
    }
    return ClaimResponse.AddItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence =
        (kotlin.collections.List(maxOf(itemSequence?.size ?: 0, _itemSequence?.size ?: 0)) { index
          ->
          PositiveInt.of(
            itemSequence?.getOrNull(index)?.let { it },
            _itemSequence?.getOrNull(index),
          )!!
        }),
      detailSequence =
        (kotlin.collections.List(maxOf(detailSequence?.size ?: 0, _detailSequence?.size ?: 0)) {
          index ->
          PositiveInt.of(
            detailSequence?.getOrNull(index)?.let { it },
            _detailSequence?.getOrNull(index),
          )!!
        }),
      subdetailSequence =
        (kotlin.collections.List(
          maxOf(subdetailSequence?.size ?: 0, _subdetailSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            subdetailSequence?.getOrNull(index)?.let { it },
            _subdetailSequence?.getOrNull(index),
          )!!
        }),
      provider = provider ?: listOf(),
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ClaimResponse.AddItem"
          ),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      serviced =
        ClaimResponse.AddItem.Serviced.from(
          Date.of(servicedDate?.let { FhirDate.fromString(it) }, _servicedDate),
          servicedPeriod,
        ),
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
      subSite = subSite ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.AddItem) {
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
    (value.itemSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemSequenceSer, it)
    }
    (value.itemSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemSequenceSer2, it)
    }
    (value.detailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.itemSequenceSer, it)
    }
    (value.detailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.itemSequenceSer2, it)
    }
    (value.subdetailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.itemSequenceSer, it)
    }
    (value.subdetailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.itemSequenceSer2, it)
    }
    if (value.provider.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.providerSer, value.provider)
    encoder.encodeSerializableElement(
      descriptor,
      10,
      Hoisted.productOrServiceSer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.modifierSer, value.programCode)
    when (val choice = value.serviced) {
      null -> {}
      is ClaimResponse.AddItem.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.itemSequenceSerInner2, it)
        }
      }
      is ClaimResponse.AddItem.Serviced.Period -> {
        encoder.encodeSerializableElement(descriptor, 15, Hoisted.servicedPeriodSer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is ClaimResponse.AddItem.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 16, Hoisted.productOrServiceSer, choice.value)
      }
      is ClaimResponse.AddItem.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 17, Hoisted.locationAddressSer, choice.value)
      }
      is ClaimResponse.AddItem.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 18, Hoisted.providerSerInner, choice.value)
      }
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 21, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.itemSequenceSerInner2, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 23, Hoisted.unitPriceSer, it) }
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.productOrServiceSer, it)
    }
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.modifierSer, value.subSite)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.itemSequenceSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.itemSequenceSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSequenceSerInner: KSerializer<Int> = Int.serializer()

    public val itemSequenceSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.itemSequenceSerInner).nullable)

    public val itemSequenceSerInner2: KSerializer<Element> = Element.serializer()

    public val itemSequenceSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.itemSequenceSerInner2).nullable)

    public val providerSerInner: KSerializer<Reference> = Reference.serializer()

    public val providerSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.providerSerInner)

    public val productOrServiceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.productOrServiceSer)

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val adjudicationSerInner: KSerializer<ClaimResponse.Item.Adjudication> =
      ClaimResponse.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ClaimResponse.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val detailSerInner: KSerializer<ClaimResponse.AddItem.Detail> =
      ClaimResponse.AddItem.Detail.serializer()

    public val detailSer: KSerializer<List<ClaimResponse.AddItem.Detail>> =
      ListSerializer(Hoisted.detailSerInner)
  }
}

internal object ClaimResponseAddItemDetailSerializer : KSerializer<ClaimResponse.AddItem.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
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
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "subDetail",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.AddItem.Detail.SubDetail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem.Detail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.Detail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.AddItem.Detail {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.productOrServiceSer,
              null,
            )
        4 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        5 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        6 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        7 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        8 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.factorSer, null)
        9 ->
          net = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        10 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        11 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        12 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        13 ->
          subDetail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    return ClaimResponse.AddItem.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ClaimResponse.AddItem.Detail"
          ),
      modifier = modifier ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.AddItem.Detail) {
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
    encoder.encodeSerializableElement(
      descriptor,
      3,
      Hoisted.productOrServiceSer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.modifierSer, value.modifier)
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 7, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.factorSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 9, Hoisted.unitPriceSer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.subDetailSer, value.subDetail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productOrServiceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.productOrServiceSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val factorSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.factorSer).nullable)

    public val adjudicationSerInner: KSerializer<ClaimResponse.Item.Adjudication> =
      ClaimResponse.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ClaimResponse.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val subDetailSerInner: KSerializer<ClaimResponse.AddItem.Detail.SubDetail> =
      ClaimResponse.AddItem.Detail.SubDetail.serializer()

    public val subDetailSer: KSerializer<List<ClaimResponse.AddItem.Detail.SubDetail>> =
      ListSerializer(Hoisted.subDetailSerInner)
  }
}

internal object ClaimResponseAddItemDetailSubDetailSerializer :
  KSerializer<ClaimResponse.AddItem.Detail.SubDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubDetail") {
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
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem.Detail.SubDetail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ClaimResponse.AddItem.Detail.SubDetail {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.productOrServiceSer,
              null,
            )
        4 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        5 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        6 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        7 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        8 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.factorSer, null)
        9 ->
          net = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        10 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        11 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        12 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
      }
    }
    return ClaimResponse.AddItem.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ClaimResponse.AddItem.Detail.SubDetail"
          ),
      modifier = modifier ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      adjudication = adjudication ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClaimResponse.AddItem.Detail.SubDetail,
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
    encoder.encodeSerializableElement(
      descriptor,
      3,
      Hoisted.productOrServiceSer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.modifierSer, value.modifier)
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 7, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.factorSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 9, Hoisted.unitPriceSer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.adjudicationSer, value.adjudication)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productOrServiceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.productOrServiceSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val factorSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.factorSer).nullable)

    public val adjudicationSerInner: KSerializer<ClaimResponse.Item.Adjudication> =
      ClaimResponse.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ClaimResponse.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)
  }
}

internal object ClaimResponseTotalSerializer : KSerializer<ClaimResponse.Total> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Total") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Total =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Total) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.Total {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var amount: Money? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Total: " + i)
      }
    }
    return ClaimResponse.Total(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ClaimResponse.Total"
          ),
      amount =
        amount
          ?: throw SerializationException(
            "Missing required property 'amount' on ClaimResponse.Total"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.Total) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, value.category)
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.amountSer, value.amount)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()
  }
}

internal object ClaimResponsePaymentSerializer : KSerializer<ClaimResponse.Payment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payment") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("adjustment", Money.serializer().descriptor, isOptional = true)
      element("adjustmentReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Payment =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Payment) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.Payment {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var adjustment: Money? = null
    var adjustmentReason: CodeableConcept? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var amount: Money? = null
    var identifier: Identifier? = null
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
        4 ->
          adjustment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjustmentSer, null)
        5 ->
          adjustmentReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> date = decoder.decodeStringElement(descriptor, i)
        7 -> _date = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateSer, null)
        8 ->
          amount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjustmentSer, null)
        9 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payment: " + i)
      }
    }
    return ClaimResponse.Payment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on ClaimResponse.Payment"
          ),
      adjustment = adjustment,
      adjustmentReason = adjustmentReason,
      date = Date.of(date?.let { FhirDate.fromString(it) }, _date),
      amount =
        amount
          ?: throw SerializationException(
            "Missing required property 'amount' on ClaimResponse.Payment"
          ),
      identifier = identifier,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.Payment) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    (value.adjustment)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.adjustmentSer, it)
    }
    (value.adjustmentReason)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.dateSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 8, Hoisted.adjustmentSer, value.amount)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.identifierSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val adjustmentSer: KSerializer<Money> = Money.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()
  }
}

internal object ClaimResponseProcessNoteSerializer : KSerializer<ClaimResponse.ProcessNote> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProcessNote") {
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
      element("number", Int.serializer().descriptor, isOptional = true)
      element("_number", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element("language", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.ProcessNote =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.ProcessNote) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.ProcessNote {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var number: Int? = null
    var _number: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var language: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> number = decoder.decodeIntElement(descriptor, i)
        4 ->
          _number =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        5 -> type = decoder.decodeStringElement(descriptor, i)
        6 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        7 -> text = decoder.decodeStringElement(descriptor, i)
        8 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        9 ->
          language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + i)
      }
    }
    return ClaimResponse.ProcessNote(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      number = PositiveInt.of(number, _number),
      type = type?.let { Enumeration.of(NoteType.fromCode(it), _type) },
      text =
        R4String.of(text, _text)
          ?: throw SerializationException(
            "Missing required property 'text' on ClaimResponse.ProcessNote"
          ),
      language = language,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.ProcessNote) {
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
    ((value.number?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.numberSer, it)
    }
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.numberSer, it)
    }
    ((value.text.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.text.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.numberSer, it)
    }
    (value.language)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.languageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val numberSer: KSerializer<Element> = Element.serializer()

    public val languageSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ClaimResponseInsuranceSerializer : KSerializer<ClaimResponse.Insurance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Insurance") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("focal", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_focal", Element.serializer().descriptor, isOptional = true)
      element("coverage", Reference.serializer().descriptor, isOptional = true)
      element("businessArrangement", KotlinString.serializer().descriptor, isOptional = true)
      element("_businessArrangement", Element.serializer().descriptor, isOptional = true)
      element("claimResponse", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Insurance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Insurance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.Insurance {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        5 -> focal = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _focal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        7 ->
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        8 -> businessArrangement = decoder.decodeStringElement(descriptor, i)
        9 ->
          _businessArrangement =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        10 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
      }
    }
    return ClaimResponse.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ClaimResponse.Insurance"
          ),
      focal =
        R4Boolean.of(focal, _focal)
          ?: throw SerializationException(
            "Missing required property 'focal' on ClaimResponse.Insurance"
          ),
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on ClaimResponse.Insurance"
          ),
      businessArrangement = R4String.of(businessArrangement, _businessArrangement),
      claimResponse = claimResponse,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.Insurance) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    ((value.focal.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.focal.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.sequenceSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 7, Hoisted.coverageSer, value.coverage)
    ((value.businessArrangement?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.businessArrangement?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.sequenceSer, it)
    }
    (value.claimResponse)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.coverageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val coverageSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ClaimResponseErrorSerializer : KSerializer<ClaimResponse.Error> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Error") {
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
      element("itemSequence", Int.serializer().descriptor, isOptional = true)
      element("_itemSequence", Element.serializer().descriptor, isOptional = true)
      element("detailSequence", Int.serializer().descriptor, isOptional = true)
      element("_detailSequence", Element.serializer().descriptor, isOptional = true)
      element("subDetailSequence", Int.serializer().descriptor, isOptional = true)
      element("_subDetailSequence", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Error =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Error) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClaimResponse.Error {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> itemSequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        5 -> detailSequence = decoder.decodeIntElement(descriptor, i)
        6 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        7 -> subDetailSequence = decoder.decodeIntElement(descriptor, i)
        8 ->
          _subDetailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        9 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Error: " + i)
      }
    }
    return ClaimResponse.Error(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence = PositiveInt.of(itemSequence, _itemSequence),
      detailSequence = PositiveInt.of(detailSequence, _detailSequence),
      subDetailSequence = PositiveInt.of(subDetailSequence, _subDetailSequence),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on ClaimResponse.Error"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClaimResponse.Error) {
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
    ((value.itemSequence?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.itemSequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemSequenceSer, it)
    }
    ((value.detailSequence?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.detailSequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.itemSequenceSer, it)
    }
    ((value.subDetailSequence?.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.subDetailSequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.itemSequenceSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 9, Hoisted.codeSer, value.code)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSequenceSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ClaimResponseSerializer : KSerializer<ClaimResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClaimResponse") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("use", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_use", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("insurer", Reference.serializer().descriptor, isOptional = true)
    b.element("requestor", Reference.serializer().descriptor, isOptional = true)
    b.element("request", Reference.serializer().descriptor, isOptional = true)
    b.element("outcome", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outcome", Element.serializer().descriptor, isOptional = true)
    b.element("disposition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_disposition", Element.serializer().descriptor, isOptional = true)
    b.element("preAuthRef", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_preAuthRef", Element.serializer().descriptor, isOptional = true)
    b.element("preAuthPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("payeeType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "item",
      listSerialDescriptor(lazyDescriptor { ClaimResponse.Item.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "addItem",
      listSerialDescriptor(lazyDescriptor { ClaimResponse.AddItem.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "adjudication",
      listSerialDescriptor(
        lazyDescriptor { ClaimResponse.Item.Adjudication.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "total",
      listSerialDescriptor(lazyDescriptor { ClaimResponse.Total.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "payment",
      lazyDescriptor { ClaimResponse.Payment.serializer().descriptor },
      isOptional = true,
    )
    b.element("fundsReserve", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("formCode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("form", Attachment.serializer().descriptor, isOptional = true)
    b.element(
      "processNote",
      listSerialDescriptor(lazyDescriptor { ClaimResponse.ProcessNote.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "communicationRequest",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "insurance",
      listSerialDescriptor(lazyDescriptor { ClaimResponse.Insurance.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "error",
      listSerialDescriptor(lazyDescriptor { ClaimResponse.Error.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ClaimResponse =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ClaimResponse")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
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
    var status: KotlinString? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var subType: CodeableConcept? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var patient: Reference? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var insurer: Reference? = null
    var requestor: Reference? = null
    var request: Reference? = null
    var outcome: KotlinString? = null
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 ->
          subType = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        15 -> use = decoder.decodeStringElement(descriptor, i)
        16 ->
          _use =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        18 -> created = decoder.decodeStringElement(descriptor, i)
        19 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        21 ->
          requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        22 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        23 -> outcome = decoder.decodeStringElement(descriptor, i)
        24 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> disposition = decoder.decodeStringElement(descriptor, i)
        26 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> preAuthRef = decoder.decodeStringElement(descriptor, i)
        28 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          preAuthPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthPeriodSer, null)
        30 ->
          payeeType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        31 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        32 ->
          addItem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addItemSer, null)
        33 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        34 ->
          total = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.totalSer, null)
        35 ->
          payment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.paymentSer, null)
        36 ->
          fundsReserve =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        37 ->
          formCode = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        38 -> form = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.formSer, null)
        39 ->
          processNote =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processNoteSer, null)
        40 ->
          communicationRequest =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.communicationRequestSer,
              null,
            )
        41 ->
          insurance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.insuranceSer, null)
        42 ->
          error = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.errorSer, null)
        else -> throw SerializationException("Unexpected index decoding ClaimResponse: " + i)
      }
    }
    return ClaimResponse(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          ClaimResponse.FinancialResourceStatusCodes.fromCode(
            status
              ?: throw SerializationException("Missing required property 'status' on ClaimResponse")
          ),
          _status,
        ),
      type =
        type ?: throw SerializationException("Missing required property 'type' on ClaimResponse"),
      subType = subType,
      use =
        Enumeration.of(
          ClaimResponse.Use.fromCode(
            use ?: throw SerializationException("Missing required property 'use' on ClaimResponse")
          ),
          _use,
        ),
      patient =
        patient
          ?: throw SerializationException("Missing required property 'patient' on ClaimResponse"),
      created =
        DateTime.of(created?.let { FhirDateTime.fromString(it) }, _created)
          ?: throw SerializationException("Missing required property 'created' on ClaimResponse"),
      insurer =
        insurer
          ?: throw SerializationException("Missing required property 'insurer' on ClaimResponse"),
      requestor = requestor,
      request = request,
      outcome =
        Enumeration.of(
          ClaimResponse.ClaimProcessingCodes.fromCode(
            outcome
              ?: throw SerializationException(
                "Missing required property 'outcome' on ClaimResponse"
              )
          ),
          _outcome,
        ),
      disposition = R4String.of(disposition, _disposition),
      preAuthRef = R4String.of(preAuthRef, _preAuthRef),
      preAuthPeriod = preAuthPeriod,
      payeeType = payeeType,
      item = item ?: listOf(),
      addItem = addItem ?: listOf(),
      adjudication = adjudication ?: listOf(),
      total = total ?: listOf(),
      payment = payment,
      fundsReserve = fundsReserve,
      formCode = formCode,
      form = form,
      processNote = processNote ?: listOf(),
      communicationRequest = communicationRequest ?: listOf(),
      insurance = insurance ?: listOf(),
      error = error ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ClaimResponse,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      Hoisted.typeSer,
      value.type,
    )
    (value.subType)?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.use.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      Hoisted.patientSer,
      value.patient,
    )
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      20 + descriptorOffset,
      Hoisted.patientSer,
      value.insurer,
    )
    (value.requestor)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.request)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.patientSer, it)
    }
    ((value.outcome.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.outcome.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.disposition?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.preAuthRef?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.preAuthRef?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.preAuthPeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.preAuthPeriodSer,
        it,
      )
    }
    (value.payeeType)?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.itemSer,
        value.item,
      )
    if (value.addItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.addItemSer,
        value.addItem,
      )
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.adjudicationSer,
        value.adjudication,
      )
    if (value.total.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.totalSer,
        value.total,
      )
    (value.payment)?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, Hoisted.paymentSer, it)
    }
    (value.fundsReserve)?.let {
      encoder.encodeSerializableElement(descriptor, 36 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.formCode)?.let {
      encoder.encodeSerializableElement(descriptor, 37 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.form)?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, Hoisted.formSer, it)
    }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.processNoteSer,
        value.processNote,
      )
    if (value.communicationRequest.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.communicationRequestSer,
        value.communicationRequest,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.insuranceSer,
        value.insurance,
      )
    if (value.error.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.errorSer,
        value.error,
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val preAuthPeriodSer: KSerializer<Period> = Period.serializer()

    public val itemSerInner: KSerializer<ClaimResponse.Item> = ClaimResponse.Item.serializer()

    public val itemSer: KSerializer<List<ClaimResponse.Item>> = ListSerializer(Hoisted.itemSerInner)

    public val addItemSerInner: KSerializer<ClaimResponse.AddItem> =
      ClaimResponse.AddItem.serializer()

    public val addItemSer: KSerializer<List<ClaimResponse.AddItem>> =
      ListSerializer(Hoisted.addItemSerInner)

    public val adjudicationSerInner: KSerializer<ClaimResponse.Item.Adjudication> =
      ClaimResponse.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ClaimResponse.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val totalSerInner: KSerializer<ClaimResponse.Total> = ClaimResponse.Total.serializer()

    public val totalSer: KSerializer<List<ClaimResponse.Total>> =
      ListSerializer(Hoisted.totalSerInner)

    public val paymentSer: KSerializer<ClaimResponse.Payment> = ClaimResponse.Payment.serializer()

    public val formSer: KSerializer<Attachment> = Attachment.serializer()

    public val processNoteSerInner: KSerializer<ClaimResponse.ProcessNote> =
      ClaimResponse.ProcessNote.serializer()

    public val processNoteSer: KSerializer<List<ClaimResponse.ProcessNote>> =
      ListSerializer(Hoisted.processNoteSerInner)

    public val communicationRequestSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.patientSer)

    public val insuranceSerInner: KSerializer<ClaimResponse.Insurance> =
      ClaimResponse.Insurance.serializer()

    public val insuranceSer: KSerializer<List<ClaimResponse.Insurance>> =
      ListSerializer(Hoisted.insuranceSerInner)

    public val errorSerInner: KSerializer<ClaimResponse.Error> = ClaimResponse.Error.serializer()

    public val errorSer: KSerializer<List<ClaimResponse.Error>> =
      ListSerializer(Hoisted.errorSerInner)
  }
}

internal object ClaimResponsePolymorphicSerializer : KSerializer<ClaimResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClaimResponse") { ClaimResponseSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse) {
    encoder.encodeStructure(descriptor) {
      ClaimResponseSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ClaimResponse =
    decoder.decodeStructure(descriptor) {
      ClaimResponseSerializer.deserializeInternal(this, descriptor, 0)
    }
}
