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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

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

  override fun deserialize(decoder: Decoder): SubstanceAmount.ReferenceRange =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var lowLimit: Quantity? = null
      var highLimit: Quantity? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 -> lowLimit = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          3 ->
            highLimit = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ReferenceRange: " + i)
        }
      }
      SubstanceAmount.ReferenceRange(
        id = id,
        extension = extension ?: listOf(),
        lowLimit = lowLimit,
        highLimit = highLimit,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceAmount.ReferenceRange) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeSerializableIfNotNull(descriptor, 2, QuantitySerializer, value.lowLimit)
      encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.highLimit)
    }
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

  override fun deserialize(decoder: Decoder): SubstanceAmount =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            amountQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          4 -> amountRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          5 -> amountString = decodeStringElement(descriptor, i)
          6 ->
            _amountString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            amountType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 -> amountText = decodeStringElement(descriptor, i)
          9 ->
            _amountText = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            referenceRange =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceAmountReferenceRangeSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SubstanceAmount: " + i)
        }
      }
      SubstanceAmount(
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      when (val choice = value.amount) {
        null -> {}
        is SubstanceAmount.Amount.Quantity -> {
          encodeSerializableElement(descriptor, 3, QuantitySerializer, choice.value)
        }
        is SubstanceAmount.Amount.Range -> {
          encodeSerializableElement(descriptor, 4, RangeSerializer, choice.value)
        }
        is SubstanceAmount.Amount.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.amountType)
      encodeStringIfNotNull(descriptor, 8, value.amountText?.value)
      encodeElementIfNotNull(descriptor, 9, value.amountText)
      encodeSerializableIfNotNull(
        descriptor,
        10,
        SubstanceAmountReferenceRangeSerializer,
        value.referenceRange,
      )
    }
  }
}
