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
import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.ClaimResponse
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object ClaimResponseEventSerializer : KSerializer<ClaimResponse.Event> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Event") {
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
      element("whenDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_whenDateTime", Element.serializer().descriptor, isOptional = true)
      element("whenPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Event =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Event) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Event {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var whenDateTime: KotlinString? = null
    var _whenDateTime: Element? = null
    var whenPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> whenDateTime = decoder.decodeStringElement(__desc, 4)
        5 ->
          _whenDateTime =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.whenDateTimeSer, null)
        6 ->
          whenPeriod =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.whenPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Event: " + __i)
      }
    }
    return ClaimResponse.Event(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `when` =
        ClaimResponse.Event.When.from(
          DateTime.of(FhirDateTime.fromString(whenDateTime), _whenDateTime),
          whenPeriod,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Event) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`when`) {
      null -> {}
      is ClaimResponse.Event.When.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.whenDateTimeSer, it)
        }
      }
      is ClaimResponse.Event.When.Period -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.whenPeriodSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val whenDateTimeSer: KSerializer<Element> = Element.serializer()

    public val whenPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ClaimResponse.Item.ReviewOutcome.serializer().descriptor },
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Item {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemSequence: Int? = null
    var _itemSequence: Element? = null
    var traceNumber: List<Identifier>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ClaimResponse.Item.ReviewOutcome? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var detail: List<ClaimResponse.Item.Detail>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> itemSequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemSequenceSer, null)
        5 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.traceNumberSer, null)
        6 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.noteNumberSer, null)
        7 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.noteNumberSer2, null)
        8 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.reviewOutcomeSer, null)
        9 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.adjudicationSer, null)
        10 ->
          detail = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + __i)
      }
    }
    return ClaimResponse.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence = PositiveInt.of(itemSequence, _itemSequence)!!,
      traceNumber = traceNumber ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Item) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.itemSequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.itemSequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.itemSequenceSer, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.traceNumberSer, value.traceNumber)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSequenceSer: KSerializer<Element> = Element.serializer()

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.itemSequenceSer).nullable)

    public val reviewOutcomeSer: KSerializer<ClaimResponse.Item.ReviewOutcome> =
      ClaimResponse.Item.ReviewOutcome.serializer()

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

internal object ClaimResponseItemReviewOutcomeSerializer :
  KSerializer<ClaimResponse.Item.ReviewOutcome> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReviewOutcome") {
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
      element("decision", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("preAuthRef", KotlinString.serializer().descriptor, isOptional = true)
      element("_preAuthRef", Element.serializer().descriptor, isOptional = true)
      element("preAuthPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item.ReviewOutcome =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.ReviewOutcome) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Item.ReviewOutcome {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var decision: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    var preAuthRef: KotlinString? = null
    var _preAuthRef: Element? = null
    var preAuthPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          decision = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.decisionSer, null)
        4 -> reason = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.reasonSer, null)
        5 -> preAuthRef = decoder.decodeStringElement(__desc, 5)
        6 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.preAuthRefSer, null)
        7 ->
          preAuthPeriod =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.preAuthPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReviewOutcome: " + __i)
      }
    }
    return ClaimResponse.Item.ReviewOutcome(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      decision = decision,
      reason = reason ?: listOf(),
      preAuthRef = R5String.of(preAuthRef, _preAuthRef),
      preAuthPeriod = preAuthPeriod,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Item.ReviewOutcome) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.decision)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.decisionSer, it) }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.reasonSer, value.reason)
    ((value.preAuthRef?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.preAuthRef?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.preAuthRefSer, it)
    }
    (value.preAuthPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.preAuthPeriodSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val decisionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.decisionSer)

    public val preAuthRefSer: KSerializer<Element> = Element.serializer()

    public val preAuthPeriodSer: KSerializer<Period> = Period.serializer()
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Item.Adjudication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Adjudication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Item.Adjudication {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var reason: CodeableConcept? = null
    var amount: Money? = null
    var quantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        5 -> amount = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.amountSer, null)
        6 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.quantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Adjudication: " + __i)
      }
    }
    return ClaimResponse.Item.Adjudication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category!!,
      reason = reason,
      amount = amount,
      quantity = quantity,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Item.Adjudication) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.reason)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.amountSer, it) }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.quantitySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()
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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ClaimResponse.Item.ReviewOutcome.serializer().descriptor },
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Detail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Item.Detail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var detailSequence: Int? = null
    var _detailSequence: Element? = null
    var traceNumber: List<Identifier>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ClaimResponse.Item.ReviewOutcome? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var subDetail: List<ClaimResponse.Item.Detail.SubDetail>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> detailSequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.detailSequenceSer, null)
        5 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.traceNumberSer, null)
        6 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.noteNumberSer, null)
        7 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.noteNumberSer2, null)
        8 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.reviewOutcomeSer, null)
        9 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.adjudicationSer, null)
        10 ->
          subDetail =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + __i)
      }
    }
    return ClaimResponse.Item.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      detailSequence = PositiveInt.of(detailSequence, _detailSequence)!!,
      traceNumber = traceNumber ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Item.Detail) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.detailSequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.detailSequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.detailSequenceSer, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.traceNumberSer, value.traceNumber)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.subDetailSer, value.subDetail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val detailSequenceSer: KSerializer<Element> = Element.serializer()

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.detailSequenceSer).nullable)

    public val reviewOutcomeSer: KSerializer<ClaimResponse.Item.ReviewOutcome> =
      ClaimResponse.Item.ReviewOutcome.serializer()

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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ClaimResponse.Item.ReviewOutcome.serializer().descriptor },
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Item.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Item.Detail.SubDetail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var subDetailSequence: Int? = null
    var _subDetailSequence: Element? = null
    var traceNumber: List<Identifier>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ClaimResponse.Item.ReviewOutcome? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> subDetailSequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _subDetailSequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.subDetailSequenceSer, null)
        5 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.traceNumberSer, null)
        6 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.noteNumberSer, null)
        7 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.noteNumberSer2, null)
        8 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.reviewOutcomeSer, null)
        9 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + __i)
      }
    }
    return ClaimResponse.Item.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      subDetailSequence = PositiveInt.of(subDetailSequence, _subDetailSequence)!!,
      traceNumber = traceNumber ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ClaimResponse.Item.Detail.SubDetail,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.subDetailSequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.subDetailSequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.subDetailSequenceSer, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.traceNumberSer, value.traceNumber)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.adjudicationSer, value.adjudication)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val subDetailSequenceSer: KSerializer<Element> = Element.serializer()

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.subDetailSequenceSer).nullable)

    public val reviewOutcomeSer: KSerializer<ClaimResponse.Item.ReviewOutcome> =
      ClaimResponse.Item.ReviewOutcome.serializer()

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
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element(
        "provider",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
      element("request", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
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
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element(
        "bodySite",
        listSerialDescriptor(
          lazyDescriptor { ClaimResponse.AddItem.BodySite.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ClaimResponse.Item.ReviewOutcome.serializer().descriptor },
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.AddItem {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemSequence: List<Int?>? = null
    var _itemSequence: List<Element?>? = null
    var detailSequence: List<Int?>? = null
    var _detailSequence: List<Element?>? = null
    var subdetailSequence: List<Int?>? = null
    var _subdetailSequence: List<Element?>? = null
    var traceNumber: List<Identifier>? = null
    var provider: List<Reference>? = null
    var revenue: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var request: List<Reference>? = null
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
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var bodySite: List<ClaimResponse.AddItem.BodySite>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ClaimResponse.Item.ReviewOutcome? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var detail: List<ClaimResponse.AddItem.Detail>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          itemSequence =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.itemSequenceSer, null)
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemSequenceSer2, null)
        5 ->
          detailSequence =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.itemSequenceSer, null)
        6 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.itemSequenceSer2, null)
        7 ->
          subdetailSequence =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.itemSequenceSer, null)
        8 ->
          _subdetailSequence =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.itemSequenceSer2, null)
        9 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.traceNumberSer, null)
        10 ->
          provider =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.providerSer, null)
        11 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.revenueSer, null)
        12 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.revenueSer, null)
        13 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.revenueSer, null)
        14 ->
          request = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.providerSer, null)
        15 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.modifierSer, null)
        16 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.modifierSer, null)
        17 -> servicedDate = decoder.decodeStringElement(__desc, 17)
        18 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        19 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.servicedPeriodSer, null)
        20 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.revenueSer, null)
        21 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.locationAddressSer, null)
        22 ->
          locationReference =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.providerSerInner, null)
        23 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.quantitySer, null)
        24 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.unitPriceSer, null)
        25 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 25, BigDecimalSerializer, null)
        26 ->
          _factor =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        27 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.unitPriceSer, null)
        28 ->
          net = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.unitPriceSer, null)
        29 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.bodySiteSer, null)
        30 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.itemSequenceSer, null)
        31 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.itemSequenceSer2, null)
        32 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.reviewOutcomeSer, null)
        33 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.adjudicationSer, null)
        34 ->
          detail = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AddItem: " + __i)
      }
    }
    return ClaimResponse.AddItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence =
        (kotlin.collections.List(maxOf(itemSequence?.size ?: 0, _itemSequence?.size ?: 0)) { __i ->
          PositiveInt.of(itemSequence?.getOrNull(__i)?.let { it }, _itemSequence?.getOrNull(__i))!!
        }),
      detailSequence =
        (kotlin.collections.List(maxOf(detailSequence?.size ?: 0, _detailSequence?.size ?: 0)) { __i
          ->
          PositiveInt.of(
            detailSequence?.getOrNull(__i)?.let { it },
            _detailSequence?.getOrNull(__i),
          )!!
        }),
      subdetailSequence =
        (kotlin.collections.List(
          maxOf(subdetailSequence?.size ?: 0, _subdetailSequence?.size ?: 0)
        ) { __i ->
          PositiveInt.of(
            subdetailSequence?.getOrNull(__i)?.let { it },
            _subdetailSequence?.getOrNull(__i),
          )!!
        }),
      traceNumber = traceNumber ?: listOf(),
      provider = provider ?: listOf(),
      revenue = revenue,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      request = request ?: listOf(),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      serviced =
        ClaimResponse.AddItem.Serviced.from(
          Date.of(FhirDate.fromString(servicedDate), _servicedDate),
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
      tax = tax,
      net = net,
      bodySite = bodySite ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.AddItem) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.itemSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.itemSequenceSer, it)
    }
    (value.itemSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.itemSequenceSer2, it)
    }
    (value.detailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.itemSequenceSer, it)
    }
    (value.detailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.itemSequenceSer2, it)
    }
    (value.subdetailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.itemSequenceSer, it)
    }
    (value.subdetailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.itemSequenceSer2, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.traceNumberSer, value.traceNumber)
    if (value.provider.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.providerSer, value.provider)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.revenueSer, it)
    }
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.providerSer, value.request)
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.modifierSer, value.programCode)
    when (val __d = value.serviced) {
      null -> {}
      is ClaimResponse.AddItem.Serviced.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.itemSequenceSerInner2, it)
        }
      }
      is ClaimResponse.AddItem.Serviced.Period -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.servicedPeriodSer, __d.value)
      }
    }
    when (val __d = value.location) {
      null -> {}
      is ClaimResponse.AddItem.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.revenueSer, __d.value)
      }
      is ClaimResponse.AddItem.Location.Address -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.locationAddressSer, __d.value)
      }
      is ClaimResponse.AddItem.Location.Reference -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.providerSerInner, __d.value)
      }
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 25, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.itemSequenceSerInner2, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 27, Hoisted.unitPriceSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.unitPriceSer, it) }
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.bodySiteSer, value.bodySite)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.itemSequenceSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.itemSequenceSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.detailSer, value.detail)
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

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val providerSerInner: KSerializer<Reference> = Reference.serializer()

    public val providerSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.providerSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val bodySiteSerInner: KSerializer<ClaimResponse.AddItem.BodySite> =
      ClaimResponse.AddItem.BodySite.serializer()

    public val bodySiteSer: KSerializer<List<ClaimResponse.AddItem.BodySite>> =
      ListSerializer(Hoisted.bodySiteSerInner)

    public val reviewOutcomeSer: KSerializer<ClaimResponse.Item.ReviewOutcome> =
      ClaimResponse.Item.ReviewOutcome.serializer()

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

internal object ClaimResponseAddItemBodySiteSerializer :
  KSerializer<ClaimResponse.AddItem.BodySite> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodySite") {
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
      element(
        "site",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "subSite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem.BodySite =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.BodySite) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.AddItem.BodySite {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: List<CodeableReference>? = null
    var subSite: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> site = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.siteSer, null)
        4 ->
          subSite = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.subSiteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BodySite: " + __i)
      }
    }
    return ClaimResponse.AddItem.BodySite(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      site = site ?: listOf(),
      subSite = subSite ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.AddItem.BodySite) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.siteSer, value.site)
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.subSiteSer, value.subSite)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val siteSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val siteSer: KSerializer<List<CodeableReference>> = ListSerializer(Hoisted.siteSerInner)

    public val subSiteSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subSiteSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.subSiteSerInner)
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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ClaimResponse.Item.ReviewOutcome.serializer().descriptor },
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.Detail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.AddItem.Detail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var traceNumber: List<Identifier>? = null
    var revenue: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ClaimResponse.Item.ReviewOutcome? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    var subDetail: List<ClaimResponse.AddItem.Detail.SubDetail>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.traceNumberSer, null)
        4 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.revenueSer, null)
        5 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.revenueSer, null)
        6 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.revenueSer, null)
        7 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.modifierSer, null)
        8 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.quantitySer, null)
        9 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.unitPriceSer, null)
        10 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 10, BigDecimalSerializer, null)
        11 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.factorSer, null)
        12 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.unitPriceSer, null)
        13 ->
          net = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.unitPriceSer, null)
        14 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.noteNumberSer, null)
        15 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.noteNumberSer2, null)
        16 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.reviewOutcomeSer, null)
        17 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.adjudicationSer, null)
        18 ->
          subDetail =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + __i)
      }
    }
    return ClaimResponse.AddItem.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      traceNumber = traceNumber ?: listOf(),
      revenue = revenue,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      modifier = modifier ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.AddItem.Detail) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.modifierSer, value.modifier)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 10, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.factorSer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.unitPriceSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.unitPriceSer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.subDetailSer, value.subDetail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val factorSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.factorSer).nullable)

    public val reviewOutcomeSer: KSerializer<ClaimResponse.Item.ReviewOutcome> =
      ClaimResponse.Item.ReviewOutcome.serializer()

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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ClaimResponse.Item.ReviewOutcome.serializer().descriptor },
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.AddItem.Detail.SubDetail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var traceNumber: List<Identifier>? = null
    var revenue: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ClaimResponse.Item.ReviewOutcome? = null
    var adjudication: List<ClaimResponse.Item.Adjudication>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.traceNumberSer, null)
        4 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.revenueSer, null)
        5 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.revenueSer, null)
        6 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.revenueSer, null)
        7 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.modifierSer, null)
        8 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.quantitySer, null)
        9 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.unitPriceSer, null)
        10 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 10, BigDecimalSerializer, null)
        11 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.factorSer, null)
        12 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.unitPriceSer, null)
        13 ->
          net = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.unitPriceSer, null)
        14 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.noteNumberSer, null)
        15 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.noteNumberSer2, null)
        16 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.reviewOutcomeSer, null)
        17 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + __i)
      }
    }
    return ClaimResponse.AddItem.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      traceNumber = traceNumber ?: listOf(),
      revenue = revenue,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      modifier = modifier ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ClaimResponse.AddItem.Detail.SubDetail,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.modifierSer, value.modifier)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 10, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.factorSer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.unitPriceSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.unitPriceSer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.adjudicationSer, value.adjudication)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val factorSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.factorSer).nullable)

    public val reviewOutcomeSer: KSerializer<ClaimResponse.Item.ReviewOutcome> =
      ClaimResponse.Item.ReviewOutcome.serializer()

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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Total) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Total {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var amount: Money? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 -> amount = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Total: " + __i)
      }
    }
    return ClaimResponse.Total(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category!!,
      amount = amount!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Total) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.amountSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Payment) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Payment {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          adjustment =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.adjustmentSer, null)
        5 ->
          adjustmentReason =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> date = decoder.decodeStringElement(__desc, 6)
        7 -> _date = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.dateSer, null)
        8 ->
          amount = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.adjustmentSer, null)
        9 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.identifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payment: " + __i)
      }
    }
    return ClaimResponse.Payment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      adjustment = adjustment,
      adjustmentReason = adjustmentReason,
      date = Date.of(FhirDate.fromString(date), _date),
      amount = amount!!,
      identifier = identifier,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Payment) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.adjustment)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.adjustmentSer, it)
    }
    (value.adjustmentReason)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.dateSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.adjustmentSer, it) }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.identifierSer, it)
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element("language", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.ProcessNote =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.ProcessNote) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.ProcessNote {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var number: Int? = null
    var _number: Element? = null
    var type: CodeableConcept? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var language: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> number = decoder.decodeIntElement(__desc, 3)
        4 -> _number = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.numberSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> text = decoder.decodeStringElement(__desc, 6)
        7 -> _text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.numberSer, null)
        8 -> language = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + __i)
      }
    }
    return ClaimResponse.ProcessNote(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      number = PositiveInt.of(number, _number),
      type = type,
      text = R5String.of(text, _text)!!,
      language = language,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.ProcessNote) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.number?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.numberSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    ((value.text.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.text.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.numberSer, it)
    }
    (value.language)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val numberSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Insurance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Insurance {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 -> focal = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _focal = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.sequenceSer, null)
        7 ->
          coverage = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.coverageSer, null)
        8 -> businessArrangement = decoder.decodeStringElement(__desc, 8)
        9 ->
          _businessArrangement =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.sequenceSer, null)
        10 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.coverageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + __i)
      }
    }
    return ClaimResponse.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      focal = R5Boolean.of(focal, _focal)!!,
      coverage = coverage!!,
      businessArrangement = R5String.of(businessArrangement, _businessArrangement),
      claimResponse = claimResponse,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Insurance) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    ((value.focal.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.focal.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.sequenceSer, it)
    }
    (value.coverage)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.coverageSer, it) }
    ((value.businessArrangement?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.businessArrangement?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.sequenceSer, it)
    }
    (value.claimResponse)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.coverageSer, it)
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
      element(
        "expression",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_expression",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse.Error =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Error) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Error {
    val __desc = descriptor
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
    var expression: List<KotlinString?>? = null
    var _expression: List<Element?>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> itemSequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemSequenceSer, null)
        5 -> detailSequence = decoder.decodeIntElement(__desc, 5)
        6 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.itemSequenceSer, null)
        7 -> subDetailSequence = decoder.decodeIntElement(__desc, 7)
        8 ->
          _subDetailSequence =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.itemSequenceSer, null)
        9 -> code = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.codeSer, null)
        10 ->
          expression =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.expressionSer, null)
        11 ->
          _expression =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.expressionSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Error: " + __i)
      }
    }
    return ClaimResponse.Error(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence = PositiveInt.of(itemSequence, _itemSequence),
      detailSequence = PositiveInt.of(detailSequence, _detailSequence),
      subDetailSequence = PositiveInt.of(subDetailSequence, _subDetailSequence),
      code = code!!,
      expression =
        (kotlin.collections.List(maxOf(expression?.size ?: 0, _expression?.size ?: 0)) { __i ->
          R5String.of(expression?.getOrNull(__i)?.let { it }, _expression?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse.Error) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.itemSequence?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.itemSequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.itemSequenceSer, it)
    }
    ((value.detailSequence?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.detailSequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.itemSequenceSer, it)
    }
    ((value.subDetailSequence?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.subDetailSequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.itemSequenceSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.codeSer, it) }
    (value.expression.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.expressionSer, it)
    }
    (value.expression.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.expressionSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSequenceSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val expressionSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val expressionSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.expressionSerInner).nullable)

    public val expressionSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.itemSequenceSer).nullable)
  }
}

internal object ClaimResponseEventWhenSerializer : KSerializer<ClaimResponse.Event.When> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClaimResponse.Event.When") {
      element("whenDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_whenDateTime", Element.serializer().descriptor, isOptional = true)
      element("whenPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.Event.When) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ClaimResponse.Event.When.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ClaimResponse.Event.When.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.whenPeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.Event.When =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.Event.When {
    val __desc = descriptor
    var whenDateTime: KotlinString? = null
    var _whenDateTime: Element? = null
    var whenPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> whenDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _whenDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          whenPeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.whenPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ClaimResponse.Event.When: " + __i)
      }
    }
    return ClaimResponse.Event.When.from(
      DateTime.of(FhirDateTime.fromString(whenDateTime), _whenDateTime),
      whenPeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val whenPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object ClaimResponseAddItemServicedSerializer :
  KSerializer<ClaimResponse.AddItem.Serviced> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClaimResponse.AddItem.Serviced") {
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.Serviced) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ClaimResponse.AddItem.Serviced.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ClaimResponse.AddItem.Serviced.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.servicedPeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem.Serviced =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.AddItem.Serviced {
    val __desc = descriptor
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> servicedDate = decoder.decodeStringElement(__desc, 0)
        1 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.servicedPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ClaimResponse.AddItem.Serviced: " + __i
          )
      }
    }
    return ClaimResponse.AddItem.Serviced.from(
      Date.of(FhirDate.fromString(servicedDate), _servicedDate),
      servicedPeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object ClaimResponseAddItemLocationSerializer :
  KSerializer<ClaimResponse.AddItem.Location> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClaimResponse.AddItem.Location") {
      element("locationCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("locationAddress", Address.serializer().descriptor, isOptional = true)
      element("locationReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse.AddItem.Location) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ClaimResponse.AddItem.Location.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.locationCodeableConceptSer, __d.value)
        }
        is ClaimResponse.AddItem.Location.Address -> {
          encodeSerializableElement(__desc, 1, Hoisted.locationAddressSer, __d.value)
        }
        is ClaimResponse.AddItem.Location.Reference -> {
          encodeSerializableElement(__desc, 2, Hoisted.locationReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ClaimResponse.AddItem.Location =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ClaimResponse.AddItem.Location {
    val __desc = descriptor
    var locationCodeableConcept: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.locationCodeableConceptSer,
              null,
            )
        1 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.locationAddressSer, null)
        2 ->
          locationReference =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.locationReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ClaimResponse.AddItem.Location: " + __i
          )
      }
    }
    return ClaimResponse.AddItem.Location.from(
      locationCodeableConcept,
      locationAddress,
      locationReference,
    )!!
  }

  private object Hoisted {
    public val locationCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val locationReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ClaimResponseSerializer : KSerializer<ClaimResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClaimResponse") {
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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", Element.serializer().descriptor, isOptional = true)
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("created", KotlinString.serializer().descriptor, isOptional = true)
      element("_created", Element.serializer().descriptor, isOptional = true)
      element("insurer", Reference.serializer().descriptor, isOptional = true)
      element("requestor", Reference.serializer().descriptor, isOptional = true)
      element("request", Reference.serializer().descriptor, isOptional = true)
      element("outcome", KotlinString.serializer().descriptor, isOptional = true)
      element("_outcome", Element.serializer().descriptor, isOptional = true)
      element("decision", CodeableConcept.serializer().descriptor, isOptional = true)
      element("disposition", KotlinString.serializer().descriptor, isOptional = true)
      element("_disposition", Element.serializer().descriptor, isOptional = true)
      element("preAuthRef", KotlinString.serializer().descriptor, isOptional = true)
      element("_preAuthRef", Element.serializer().descriptor, isOptional = true)
      element("preAuthPeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "event",
        listSerialDescriptor(lazyDescriptor { ClaimResponse.Event.serializer().descriptor }),
        isOptional = true,
      )
      element("payeeType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "encounter",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("diagnosisRelatedGroup", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "item",
        listSerialDescriptor(lazyDescriptor { ClaimResponse.Item.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "addItem",
        listSerialDescriptor(lazyDescriptor { ClaimResponse.AddItem.serializer().descriptor }),
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
        "total",
        listSerialDescriptor(lazyDescriptor { ClaimResponse.Total.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "payment",
        lazyDescriptor { ClaimResponse.Payment.serializer().descriptor },
        isOptional = true,
      )
      element("fundsReserve", CodeableConcept.serializer().descriptor, isOptional = true)
      element("formCode", CodeableConcept.serializer().descriptor, isOptional = true)
      element("form", Attachment.serializer().descriptor, isOptional = true)
      element(
        "processNote",
        listSerialDescriptor(lazyDescriptor { ClaimResponse.ProcessNote.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "communicationRequest",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "insurance",
        listSerialDescriptor(lazyDescriptor { ClaimResponse.Insurance.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "error",
        listSerialDescriptor(lazyDescriptor { ClaimResponse.Error.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClaimResponse =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClaimResponse) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ClaimResponse {
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
    var traceNumber: List<Identifier>? = null
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
    var decision: CodeableConcept? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var preAuthRef: KotlinString? = null
    var _preAuthRef: Element? = null
    var preAuthPeriod: Period? = null
    var event: List<ClaimResponse.Event>? = null
    var payeeType: CodeableConcept? = null
    var encounter: List<Reference>? = null
    var diagnosisRelatedGroup: CodeableConcept? = null
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
        12 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.identifierSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> type = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.typeSer, null)
        16 -> subType = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.typeSer, null)
        17 -> use = decoder.decodeStringElement(__desc, 17)
        18 ->
          _use =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.patientSer, null)
        20 -> created = decoder.decodeStringElement(__desc, 20)
        21 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          insurer = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.patientSer, null)
        23 ->
          requestor =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.patientSer, null)
        24 ->
          request = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.patientSer, null)
        25 -> outcome = decoder.decodeStringElement(__desc, 25)
        26 ->
          _outcome =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          decision = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.typeSer, null)
        28 -> disposition = decoder.decodeStringElement(__desc, 28)
        29 ->
          _disposition =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> preAuthRef = decoder.decodeStringElement(__desc, 30)
        31 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          preAuthPeriod =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.preAuthPeriodSer, null)
        33 -> event = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.eventSer, null)
        34 ->
          payeeType = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.typeSer, null)
        35 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.encounterSer, null)
        36 ->
          diagnosisRelatedGroup =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.typeSer, null)
        37 -> item = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.itemSer, null)
        38 ->
          addItem = decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.addItemSer, null)
        39 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.adjudicationSer, null)
        40 -> total = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.totalSer, null)
        41 ->
          payment = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.paymentSer, null)
        42 ->
          fundsReserve =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.typeSer, null)
        43 ->
          formCode = decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.typeSer, null)
        44 -> form = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.formSer, null)
        45 ->
          processNote =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.processNoteSer, null)
        46 ->
          communicationRequest =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.encounterSer, null)
        47 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.insuranceSer, null)
        48 -> error = decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.errorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ClaimResponse: " + __i)
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
      traceNumber = traceNumber ?: listOf(),
      status =
        Enumeration.of(ClaimResponse.FinancialResourceStatusCodes.fromCode(status!!), _status),
      type = type!!,
      subType = subType,
      use = Enumeration.of(ClaimResponse.Use.fromCode(use!!), _use),
      patient = patient!!,
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      insurer = insurer,
      requestor = requestor,
      request = request,
      outcome = Enumeration.of(ClaimResponse.ClaimProcessingCodes.fromCode(outcome!!), _outcome),
      decision = decision,
      disposition = R5String.of(disposition, _disposition),
      preAuthRef = R5String.of(preAuthRef, _preAuthRef),
      preAuthPeriod = preAuthPeriod,
      event = event ?: listOf(),
      payeeType = payeeType,
      encounter = encounter ?: listOf(),
      diagnosisRelatedGroup = diagnosisRelatedGroup,
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClaimResponse) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ClaimResponse")
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.identifierSer, value.traceNumber)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.typeSer, it) }
    (value.subType)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.typeSer, it) }
    ((value.use.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.patientSer, it) }
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    (value.insurer)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.patientSer, it) }
    (value.requestor)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.patientSer, it) }
    (value.request)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.patientSer, it) }
    ((value.outcome.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.outcome.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    (value.decision)?.let { encoder.encodeSerializableElement(__desc, 27, Hoisted.typeSer, it) }
    ((value.disposition?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    ((value.preAuthRef?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.preAuthRef?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    (value.preAuthPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.preAuthPeriodSer, it)
    }
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.eventSer, value.event)
    (value.payeeType)?.let { encoder.encodeSerializableElement(__desc, 34, Hoisted.typeSer, it) }
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.encounterSer, value.encounter)
    (value.diagnosisRelatedGroup)?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.typeSer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.itemSer, value.item)
    if (value.addItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.addItemSer, value.addItem)
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.adjudicationSer, value.adjudication)
    if (value.total.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.totalSer, value.total)
    (value.payment)?.let { encoder.encodeSerializableElement(__desc, 41, Hoisted.paymentSer, it) }
    (value.fundsReserve)?.let { encoder.encodeSerializableElement(__desc, 42, Hoisted.typeSer, it) }
    (value.formCode)?.let { encoder.encodeSerializableElement(__desc, 43, Hoisted.typeSer, it) }
    (value.form)?.let { encoder.encodeSerializableElement(__desc, 44, Hoisted.formSer, it) }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.processNoteSer, value.processNote)
    if (value.communicationRequest.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        46,
        Hoisted.encounterSer,
        value.communicationRequest,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.insuranceSer, value.insurance)
    if (value.error.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.errorSer, value.error)
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

    public val eventSerInner: KSerializer<ClaimResponse.Event> = ClaimResponse.Event.serializer()

    public val eventSer: KSerializer<List<ClaimResponse.Event>> =
      ListSerializer(Hoisted.eventSerInner)

    public val encounterSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)

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

    public val insuranceSerInner: KSerializer<ClaimResponse.Insurance> =
      ClaimResponse.Insurance.serializer()

    public val insuranceSer: KSerializer<List<ClaimResponse.Insurance>> =
      ListSerializer(Hoisted.insuranceSerInner)

    public val errorSerInner: KSerializer<ClaimResponse.Error> = ClaimResponse.Error.serializer()

    public val errorSer: KSerializer<List<ClaimResponse.Error>> =
      ListSerializer(Hoisted.errorSerInner)
  }
}
