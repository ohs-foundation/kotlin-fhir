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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceAmount
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object SubstanceAmountReferenceRangeSerializer :
  KSerializer<SubstanceAmount.ReferenceRange> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceRange") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("lowLimit", QuantitySerializer.descriptor)
      optionalElement("highLimit", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceAmount.ReferenceRange>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceAmount.ReferenceRange {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var lowLimit: Quantity? = null
    var highLimit: Quantity? = null
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
          lowLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        3 ->
          highLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceRange: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceAmount.ReferenceRange(
      id = id,
      extension = extension ?: listOf(),
      lowLimit = lowLimit,
      highLimit = highLimit,
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceAmount.ReferenceRange) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 2, QuantitySerializer, value.lowLimit)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.highLimit)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceAmountSerializer : KSerializer<SubstanceAmount> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceAmount") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("amountQuantity", QuantitySerializer.descriptor)
      optionalElement("amountRange", RangeSerializer.descriptor)
      optionalElement("amountString", KotlinString.serializer().descriptor)
      optionalElement("_amountString", ElementSerializer.descriptor)
      optionalElement("amountType", CodeableConceptSerializer.descriptor)
      optionalElement("amountText", KotlinString.serializer().descriptor)
      optionalElement("_amountText", ElementSerializer.descriptor)
      optionalElement("referenceRange", SubstanceAmountReferenceRangeSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceAmount>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceAmount {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          amountQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        4 ->
          amountRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        5 -> amountString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _amountString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          amountType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 -> amountText = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _amountText =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          referenceRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceAmountReferenceRangeSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubstanceAmount: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: SubstanceAmount) {
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
    when (val choice = value.amount) {
      null -> {}
      is SubstanceAmount.Amount.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, QuantitySerializer, choice.value)
      }
      is SubstanceAmount.Amount.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, RangeSerializer, choice.value)
      }
      is SubstanceAmount.Amount.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.amountType,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.amountText?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.amountText)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      SubstanceAmountReferenceRangeSerializer,
      value.referenceRange,
    )
    compositeEncoder.endStructure(descriptor)
  }
}
