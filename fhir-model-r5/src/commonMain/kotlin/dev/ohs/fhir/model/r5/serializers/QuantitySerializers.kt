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
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object QuantitySerializer : KSerializer<Quantity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Quantity") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("value", FhirDecimalSerializer.descriptor)
      optionalElement("_value", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("comparator", KotlinString.serializer().descriptor)
      optionalElement("_comparator", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("unit", KotlinString.serializer().descriptor)
      optionalElement("_unit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("system", KotlinString.serializer().descriptor)
      optionalElement("_system", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Quantity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Quantity {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        3 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> comparator = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _comparator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> unit = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _unit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> system = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Quantity: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Quantity(
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

  override fun serialize(encoder: Encoder, `value`: Quantity) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      2,
      FhirDecimalSerializer,
      value.`value`?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.`value`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.comparator?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.comparator)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.unit?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.unit)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.system?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.system)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.code)
    compositeEncoder.endStructure(descriptor)
  }
}
