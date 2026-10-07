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

import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.SampledData
import dev.ohs.fhir.model.r4.String as R4String
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object SampledDataSerializer : KSerializer<SampledData> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SampledData") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("origin", lazyDescriptor { QuantitySerializer.descriptor })
      optionalElement("period", FhirDecimalSerializer.descriptor)
      optionalElement("_period", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("lowerLimit", FhirDecimalSerializer.descriptor)
      optionalElement("_lowerLimit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("upperLimit", FhirDecimalSerializer.descriptor)
      optionalElement("_upperLimit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("dimensions", Int.serializer().descriptor)
      optionalElement("_dimensions", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("data", KotlinString.serializer().descriptor)
      optionalElement("_data", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<SampledData>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SampledData {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        4 ->
          _period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        6 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          lowerLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        8 ->
          _lowerLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          upperLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        10 ->
          _upperLimit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> dimensions = compositeDecoder.decodeIntElement(descriptor, i)
        12 ->
          _dimensions =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> `data` = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _data =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampledData: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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
      `data` = R4String.of(`data`, _data),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SampledData) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
      value.period.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.period)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      FhirDecimalSerializer,
      value.lowerLimit?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.lowerLimit)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      FhirDecimalSerializer,
      value.upperLimit?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.upperLimit)
    compositeEncoder.encodeIntIfNotNull(descriptor, 11, value.dimensions.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.dimensions)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.`data`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.`data`)
    compositeEncoder.endStructure(descriptor)
  }
}
