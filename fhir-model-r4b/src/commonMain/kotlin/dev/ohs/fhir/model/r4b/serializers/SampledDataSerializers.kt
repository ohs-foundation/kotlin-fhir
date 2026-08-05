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

import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.SampledData
import dev.ohs.fhir.model.r4b.String as R4bString
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
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object SampledDataSerializer : KSerializer<SampledData> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SampledData") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("origin", lazyDescriptor { Quantity.serializer().descriptor }, isOptional = true)
      element("period", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_period", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("lowerLimit", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_lowerLimit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("upperLimit", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_upperLimit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("dimensions", Int.serializer().descriptor, isOptional = true)
      element("_dimensions", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("data", KotlinString.serializer().descriptor, isOptional = true)
      element("_data", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SampledData =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SampledData) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SampledData {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var origin: Quantity? = null
    var period: FhirDecimal? = null
    var _period: Element? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var lowerLimit: FhirDecimal? = null
    var _lowerLimit: Element? = null
    var upperLimit: FhirDecimal? = null
    var _upperLimit: Element? = null
    var dimensions: Int? = null
    var _dimensions: Element? = null
    var `data`: KotlinString? = null
    var _data: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          origin = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.originSer, null)
        3 ->
          period =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        4 ->
          _period =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        5 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        6 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        7 ->
          lowerLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        8 ->
          _lowerLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        9 ->
          upperLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        10 ->
          _upperLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        11 -> dimensions = decoder.decodeIntElement(descriptor, i)
        12 ->
          _dimensions =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        13 -> `data` = decoder.decodeStringElement(descriptor, i)
        14 ->
          _data = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampledData: " + i)
      }
    }
    return SampledData(
      id = id,
      extension = extension ?: listOf(),
      origin =
        origin ?: throw SerializationException("Missing required property 'origin' on SampledData"),
      period =
        Decimal.of(period, _period)
          ?: throw SerializationException("Missing required property 'period' on SampledData"),
      factor = Decimal.of(factor, _factor),
      lowerLimit = Decimal.of(lowerLimit, _lowerLimit),
      upperLimit = Decimal.of(upperLimit, _upperLimit),
      dimensions =
        PositiveInt.of(dimensions, _dimensions)
          ?: throw SerializationException("Missing required property 'dimensions' on SampledData"),
      `data` = R4bString.of(`data`, _data),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SampledData) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    encoder.encodeSerializableElement(descriptor, 2, Hoisted.originSer, value.origin)
    ((value.period.value))?.let {
      encoder.encodeSerializableElement(descriptor, 3, FhirDecimalSerializer, it)
    }
    (value.period.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.periodSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 5, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.periodSer, it)
    }
    ((value.lowerLimit?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 7, FhirDecimalSerializer, it)
    }
    (value.lowerLimit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.periodSer, it)
    }
    ((value.upperLimit?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 9, FhirDecimalSerializer, it)
    }
    (value.upperLimit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.periodSer, it)
    }
    ((value.dimensions.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
    (value.dimensions.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.periodSer, it)
    }
    ((value.`data`?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.periodSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val originSer: KSerializer<Quantity> = Quantity.serializer()

    public val periodSer: KSerializer<Element> = Element.serializer()
  }
}
