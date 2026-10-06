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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object DurationSerializer : KSerializer<Duration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Duration") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("value", FhirDecimalSerializer.descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("comparator", KotlinString.serializer().descriptor)
      optionalElement("_comparator", ElementSerializer.descriptor)
      optionalElement("unit", KotlinString.serializer().descriptor)
      optionalElement("_unit", ElementSerializer.descriptor)
      optionalElement("system", KotlinString.serializer().descriptor)
      optionalElement("_system", ElementSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Duration>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Duration =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var `value`: FhirDecimal? = null
      var _value: Element? = null
      var comparator: KotlinString? = null
      var _comparator: Element? = null
      var unit: KotlinString? = null
      var _unit: Element? = null
      var system: KotlinString? = null
      var _system: Element? = null
      var code: KotlinString? = null
      var _code: Element? = null
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
            `value` = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          3 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> comparator = decodeStringElement(descriptor, i)
          5 ->
            _comparator = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> unit = decodeStringElement(descriptor, i)
          7 -> _unit = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> system = decodeStringElement(descriptor, i)
          9 -> _system = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> code = decodeStringElement(descriptor, i)
          11 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Duration: " + i)
        }
      }
      Duration(
        id = id,
        extension = extension ?: listOf(),
        `value` = Decimal.of(`value`, _value),
        comparator =
          Enumeration.of(
            if (comparator != null) Quantity.QuantityComparator.fromCode(comparator) else null,
            _comparator,
          ),
        unit = R5String.of(unit, _unit),
        system = Uri.of(system, _system),
        code = Code.of(code, _code),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Duration) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeSerializableIfNotNull(descriptor, 2, FhirDecimalSerializer, value.`value`?.value)
      encodeElementIfNotNull(descriptor, 3, value.`value`)
      encodeStringIfNotNull(descriptor, 4, value.comparator?.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.comparator)
      encodeStringIfNotNull(descriptor, 6, value.unit?.value)
      encodeElementIfNotNull(descriptor, 7, value.unit)
      encodeStringIfNotNull(descriptor, 8, value.system?.value)
      encodeElementIfNotNull(descriptor, 9, value.system)
      encodeStringIfNotNull(descriptor, 10, value.code?.value)
      encodeElementIfNotNull(descriptor, 11, value.code)
    }
  }
}
