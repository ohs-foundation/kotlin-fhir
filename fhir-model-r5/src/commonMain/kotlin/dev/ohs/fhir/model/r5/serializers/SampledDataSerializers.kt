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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.SampledData
import dev.ohs.fhir.model.r5.String as R5String
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object SampledDataSerializer : FhirSerializer<SampledData> {
  override val descriptor: SerialDescriptor = buildDescriptor("SampledData", this)

  @JvmField internal val listSerializer: KSerializer<List<SampledData>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.optionalElement("origin", lazyDescriptor(LazyDescriptorId.QuantitySerializer))
    b.prim("interval", FhirDecimalSerializer.descriptor)
    b.strPrim("intervalUnit")
    b.prim("factor", FhirDecimalSerializer.descriptor)
    b.prim("lowerLimit", FhirDecimalSerializer.descriptor)
    b.prim("upperLimit", FhirDecimalSerializer.descriptor)
    b.intPrim("dimensions")
    b.strPrim("codeMap")
    b.strPrim("offsets")
    b.strPrim("data")
  }

  override fun deserialize(decoder: Decoder): SampledData {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var origin: Quantity? = null
    var interval: FhirDecimal? = null
    var _interval: Element? = null
    var intervalUnit: KotlinString? = null
    var _intervalUnit: Element? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var lowerLimit: FhirDecimal? = null
    var _lowerLimit: Element? = null
    var upperLimit: FhirDecimal? = null
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
          origin =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        3 ->
          interval =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        4 ->
          _interval =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> intervalUnit = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _intervalUnit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
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
          lowerLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        10 ->
          _lowerLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          upperLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        12 ->
          _upperLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> dimensions = compositeDecoder.decodeIntElement(descriptor, i)
        14 ->
          _dimensions =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> codeMap = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _codeMap =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> offsets = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _offsets =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> `data` = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _data =
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
    return SampledData(
      id = id,
      extension = listOrEmpty(extension),
      origin = required(origin, "SampledData", "origin"),
      interval = Decimal.of(interval, _interval),
      intervalUnit = required(Code.of(intervalUnit, _intervalUnit), "SampledData", "intervalUnit"),
      factor = Decimal.of(factor, _factor),
      lowerLimit = Decimal.of(lowerLimit, _lowerLimit),
      upperLimit = Decimal.of(upperLimit, _upperLimit),
      dimensions = required(PositiveInt.of(dimensions, _dimensions), "SampledData", "dimensions"),
      codeMap = Canonical.of(codeMap, _codeMap),
      offsets = R5String.of(offsets, _offsets),
      `data` = R5String.of(`data`, _data),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SampledData) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 2, QuantitySerializer, value.origin)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      FhirDecimalSerializer,
      value.interval?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.interval)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.intervalUnit.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.intervalUnit)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      FhirDecimalSerializer,
      value.lowerLimit?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.lowerLimit)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      FhirDecimalSerializer,
      value.upperLimit?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.upperLimit)
    compositeEncoder.encodeIntIfNotNull(descriptor, 13, value.dimensions.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.dimensions)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.codeMap?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.codeMap)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17, value.offsets?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.offsets)
    compositeEncoder.encodeStringIfNotNull(descriptor, 19, value.`data`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20, value.`data`)
    compositeEncoder.endStructure(descriptor)
  }
}
