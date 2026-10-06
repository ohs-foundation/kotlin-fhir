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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object SampledDataSerializer : KSerializer<SampledData> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SampledData") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("origin", lazyDescriptor { QuantitySerializer.descriptor })
      optionalElement("interval", FhirDecimalSerializer.descriptor)
      optionalElement("_interval", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("intervalUnit", KotlinString.serializer().descriptor)
      optionalElement("_intervalUnit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("lowerLimit", FhirDecimalSerializer.descriptor)
      optionalElement("_lowerLimit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("upperLimit", FhirDecimalSerializer.descriptor)
      optionalElement("_upperLimit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("dimensions", Int.serializer().descriptor)
      optionalElement("_dimensions", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("codeMap", KotlinString.serializer().descriptor)
      optionalElement("_codeMap", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("offsets", KotlinString.serializer().descriptor)
      optionalElement("_offsets", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("data", KotlinString.serializer().descriptor)
      optionalElement("_data", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<SampledData>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SampledData =
    decoder.decodeStructure(descriptor) {
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
          2 -> origin = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          3 ->
            interval = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          4 -> _interval = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> intervalUnit = decodeStringElement(descriptor, i)
          6 ->
            _intervalUnit =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          8 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            lowerLimit =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          10 ->
            _lowerLimit = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            upperLimit =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          12 ->
            _upperLimit = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> dimensions = decodeIntElement(descriptor, i)
          14 ->
            _dimensions = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> codeMap = decodeStringElement(descriptor, i)
          16 -> _codeMap = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> offsets = decodeStringElement(descriptor, i)
          18 -> _offsets = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 -> `data` = decodeStringElement(descriptor, i)
          20 -> _data = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SampledData: " + i)
        }
      }
      SampledData(
        id = id,
        extension = extension ?: listOf(),
        origin =
          origin
            ?: throw SerializationException("Missing required property 'origin' on SampledData"),
        interval = Decimal.of(interval, _interval),
        intervalUnit =
          Code.of(intervalUnit, _intervalUnit)
            ?: throw SerializationException(
              "Missing required property 'intervalUnit' on SampledData"
            ),
        factor = Decimal.of(factor, _factor),
        lowerLimit = Decimal.of(lowerLimit, _lowerLimit),
        upperLimit = Decimal.of(upperLimit, _upperLimit),
        dimensions =
          PositiveInt.of(dimensions, _dimensions)
            ?: throw SerializationException(
              "Missing required property 'dimensions' on SampledData"
            ),
        codeMap = Canonical.of(codeMap, _codeMap),
        offsets = R5String.of(offsets, _offsets),
        `data` = R5String.of(`data`, _data),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SampledData) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeSerializableElement(descriptor, 2, QuantitySerializer, value.origin)
      encodeSerializableIfNotNull(descriptor, 3, FhirDecimalSerializer, value.interval?.value)
      encodeElementIfNotNull(descriptor, 4, value.interval)
      encodeStringIfNotNull(descriptor, 5, value.intervalUnit.value)
      encodeElementIfNotNull(descriptor, 6, value.intervalUnit)
      encodeSerializableIfNotNull(descriptor, 7, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 8, value.factor)
      encodeSerializableIfNotNull(descriptor, 9, FhirDecimalSerializer, value.lowerLimit?.value)
      encodeElementIfNotNull(descriptor, 10, value.lowerLimit)
      encodeSerializableIfNotNull(descriptor, 11, FhirDecimalSerializer, value.upperLimit?.value)
      encodeElementIfNotNull(descriptor, 12, value.upperLimit)
      encodeIntIfNotNull(descriptor, 13, value.dimensions.value)
      encodeElementIfNotNull(descriptor, 14, value.dimensions)
      encodeStringIfNotNull(descriptor, 15, value.codeMap?.value)
      encodeElementIfNotNull(descriptor, 16, value.codeMap)
      encodeStringIfNotNull(descriptor, 17, value.offsets?.value)
      encodeElementIfNotNull(descriptor, 18, value.offsets)
      encodeStringIfNotNull(descriptor, 19, value.`data`?.value)
      encodeElementIfNotNull(descriptor, 20, value.`data`)
    }
  }
}
