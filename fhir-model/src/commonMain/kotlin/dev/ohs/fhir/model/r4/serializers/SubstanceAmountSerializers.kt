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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceAmount
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

internal object SubstanceAmountReferenceRangeSerializer :
  KSerializer<SubstanceAmount.ReferenceRange> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceRange") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("lowLimit", Quantity.serializer().descriptor, isOptional = true)
      element("highLimit", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceAmount.ReferenceRange =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceAmount.ReferenceRange) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceAmount.ReferenceRange {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var lowLimit: Quantity? = null
    var highLimit: Quantity? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          lowLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lowLimitSer, null)
        3 ->
          highLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lowLimitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceRange: " + i)
      }
    }
    return SubstanceAmount.ReferenceRange(
      id = id,
      extension = extension ?: listOf(),
      lowLimit = lowLimit,
      highLimit = highLimit,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceAmount.ReferenceRange,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    (value.lowLimit)?.let {
      encoder.encodeSerializableElement(descriptor, 2, Hoisted.lowLimitSer, it)
    }
    (value.highLimit)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.lowLimitSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val lowLimitSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object SubstanceAmountSerializer : KSerializer<SubstanceAmount> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceAmount") {
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
      element("amountQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("amountRange", Range.serializer().descriptor, isOptional = true)
      element("amountString", KotlinString.serializer().descriptor, isOptional = true)
      element("_amountString", Element.serializer().descriptor, isOptional = true)
      element("amountType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amountText", KotlinString.serializer().descriptor, isOptional = true)
      element("_amountText", Element.serializer().descriptor, isOptional = true)
      element(
        "referenceRange",
        lazyDescriptor { SubstanceAmount.ReferenceRange.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceAmount =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceAmount) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceAmount {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var amountQuantity: Quantity? = null
    var amountRange: Range? = null
    var amountString: KotlinString? = null
    var _amountString: Element? = null
    var amountType: CodeableConcept? = null
    var amountText: KotlinString? = null
    var _amountText: Element? = null
    var referenceRange: SubstanceAmount.ReferenceRange? = null
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
          amountQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.amountQuantitySer,
              null,
            )
        4 ->
          amountRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountRangeSer, null)
        5 -> amountString = decoder.decodeStringElement(descriptor, i)
        6 ->
          _amountString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountStringSer, null)
        7 ->
          amountType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountTypeSer, null)
        8 -> amountText = decoder.decodeStringElement(descriptor, i)
        9 ->
          _amountText =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountStringSer, null)
        10 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referenceRangeSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubstanceAmount: " + i)
      }
    }
    return SubstanceAmount(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      amount =
        SubstanceAmount.Amount.from(
          amountQuantity,
          amountRange,
          R4String.of(amountString, _amountString),
        ),
      amountType = amountType,
      amountText = R4String.of(amountText, _amountText),
      referenceRange = referenceRange,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceAmount) {
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
    when (val choice = value.amount) {
      null -> {}
      is SubstanceAmount.Amount.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.amountQuantitySer, choice.value)
      }
      is SubstanceAmount.Amount.Range -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.amountRangeSer, choice.value)
      }
      is SubstanceAmount.Amount.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.amountStringSer, it)
        }
      }
    }
    (value.amountType)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.amountTypeSer, it)
    }
    ((value.amountText?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.amountText?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.amountStringSer, it)
    }
    (value.referenceRange)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.referenceRangeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val amountQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val amountRangeSer: KSerializer<Range> = Range.serializer()

    public val amountStringSer: KSerializer<Element> = Element.serializer()

    public val amountTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val referenceRangeSer: KSerializer<SubstanceAmount.ReferenceRange> =
      SubstanceAmount.ReferenceRange.serializer()
  }
}
