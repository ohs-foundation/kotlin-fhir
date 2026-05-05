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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.SampledData
import dev.ohs.fhir.model.r4.String as R4String
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
      element("period", BigDecimalSerializer.descriptor, isOptional = true)
      element("_period", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("lowerLimit", BigDecimalSerializer.descriptor, isOptional = true)
      element("_lowerLimit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("upperLimit", BigDecimalSerializer.descriptor, isOptional = true)
      element("_upperLimit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("dimensions", Int.serializer().descriptor, isOptional = true)
      element("_dimensions", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("data", KotlinString.serializer().descriptor, isOptional = true)
      element("_data", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SampledData =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SampledData) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SampledData {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var origin: Quantity? = null
    var period: BigDecimal? = null
    var _period: Element? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var lowerLimit: BigDecimal? = null
    var _lowerLimit: Element? = null
    var upperLimit: BigDecimal? = null
    var _upperLimit: Element? = null
    var dimensions: Int? = null
    var _dimensions: Element? = null
    var `data`: KotlinString? = null
    var _data: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          origin = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.originSer, null)
        3 ->
          period =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        4 ->
          _period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        5 ->
          factor =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        6 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        7 ->
          lowerLimit =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        8 ->
          _lowerLimit =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        9 ->
          upperLimit =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        10 ->
          _upperLimit =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        11 -> dimensions = decoder.decodeIntElement(__desc, __i)
        12 ->
          _dimensions =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        13 -> `data` = decoder.decodeStringElement(__desc, __i)
        14 ->
          _data = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampledData: " + __i)
      }
    }
    return SampledData(
      id = id,
      extension = extension ?: listOf(),
      origin = origin!!,
      period = Decimal.of(period, _period)!!,
      factor = Decimal.of(factor, _factor),
      lowerLimit = Decimal.of(lowerLimit, _lowerLimit),
      upperLimit = Decimal.of(upperLimit, _upperLimit),
      dimensions = PositiveInt.of(dimensions, _dimensions)!!,
      `data` = R4String.of(`data`, _data),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SampledData) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    (value.origin)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.originSer, it) }
    ((value.period.value))?.let {
      encoder.encodeSerializableElement(__desc, 3, BigDecimalSerializer, it)
    }
    (value.period.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.periodSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 5, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.periodSer, it)
    }
    ((value.lowerLimit?.value))?.let {
      encoder.encodeSerializableElement(__desc, 7, BigDecimalSerializer, it)
    }
    (value.lowerLimit?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.periodSer, it)
    }
    ((value.upperLimit?.value))?.let {
      encoder.encodeSerializableElement(__desc, 9, BigDecimalSerializer, it)
    }
    (value.upperLimit?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.periodSer, it)
    }
    ((value.dimensions.value))?.let { encoder.encodeIntElement(__desc, 11, it) }
    (value.dimensions.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.periodSer, it)
    }
    ((value.`data`?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.periodSer, it)
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
