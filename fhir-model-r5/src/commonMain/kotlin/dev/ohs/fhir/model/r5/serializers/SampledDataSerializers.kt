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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.SampledData
import dev.ohs.fhir.model.r5.String as R5String
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
      element("interval", BigDecimalSerializer.descriptor, isOptional = true)
      element("_interval", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("intervalUnit", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_intervalUnit",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("lowerLimit", BigDecimalSerializer.descriptor, isOptional = true)
      element("_lowerLimit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("upperLimit", BigDecimalSerializer.descriptor, isOptional = true)
      element("_upperLimit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("dimensions", Int.serializer().descriptor, isOptional = true)
      element("_dimensions", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("codeMap", KotlinString.serializer().descriptor, isOptional = true)
      element("_codeMap", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("offsets", KotlinString.serializer().descriptor, isOptional = true)
      element("_offsets", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("data", KotlinString.serializer().descriptor, isOptional = true)
      element("_data", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SampledData =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SampledData) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SampledData {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var origin: Quantity? = null
    var interval: BigDecimal? = null
    var _interval: Element? = null
    var intervalUnit: KotlinString? = null
    var _intervalUnit: Element? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var lowerLimit: BigDecimal? = null
    var _lowerLimit: Element? = null
    var upperLimit: BigDecimal? = null
    var _upperLimit: Element? = null
    var dimensions: Int? = null
    var _dimensions: Element? = null
    var codeMap: KotlinString? = null
    var _codeMap: Element? = null
    var offsets: KotlinString? = null
    var _offsets: Element? = null
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
          interval =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        4 ->
          _interval =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        5 -> intervalUnit = decoder.decodeStringElement(descriptor, i)
        6 ->
          _intervalUnit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        7 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        8 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        9 ->
          lowerLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        10 ->
          _lowerLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        11 ->
          upperLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        12 ->
          _upperLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        13 -> dimensions = decoder.decodeIntElement(descriptor, i)
        14 ->
          _dimensions =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        15 -> codeMap = decoder.decodeStringElement(descriptor, i)
        16 ->
          _codeMap =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        17 -> offsets = decoder.decodeStringElement(descriptor, i)
        18 ->
          _offsets =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        19 -> `data` = decoder.decodeStringElement(descriptor, i)
        20 ->
          _data =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.intervalSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampledData: " + i)
      }
    }
    return SampledData(
      id = id,
      extension = extension ?: listOf(),
      origin = origin!!,
      interval = Decimal.of(interval, _interval),
      intervalUnit = Code.of(intervalUnit, _intervalUnit)!!,
      factor = Decimal.of(factor, _factor),
      lowerLimit = Decimal.of(lowerLimit, _lowerLimit),
      upperLimit = Decimal.of(upperLimit, _upperLimit),
      dimensions = PositiveInt.of(dimensions, _dimensions)!!,
      codeMap = Canonical.of(codeMap, _codeMap),
      offsets = R5String.of(offsets, _offsets),
      `data` = R5String.of(`data`, _data),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SampledData) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    encoder.encodeSerializableElement(descriptor, 2, Hoisted.originSer, value.origin)
    ((value.interval?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 3, BigDecimalSerializer, it)
    }
    (value.interval?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.intervalSer, it)
    }
    ((value.intervalUnit.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.intervalUnit.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.intervalSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 7, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.intervalSer, it)
    }
    ((value.lowerLimit?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 9, BigDecimalSerializer, it)
    }
    (value.lowerLimit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.intervalSer, it)
    }
    ((value.upperLimit?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 11, BigDecimalSerializer, it)
    }
    (value.upperLimit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.intervalSer, it)
    }
    ((value.dimensions.value))?.let { encoder.encodeIntElement(descriptor, 13, it) }
    (value.dimensions.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.intervalSer, it)
    }
    ((value.codeMap?.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.codeMap?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.intervalSer, it)
    }
    ((value.offsets?.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
    (value.offsets?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.intervalSer, it)
    }
    ((value.`data`?.value))?.let { encoder.encodeStringElement(descriptor, 19, it) }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.intervalSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val originSer: KSerializer<Quantity> = Quantity.serializer()

    public val intervalSer: KSerializer<Element> = Element.serializer()
  }
}
