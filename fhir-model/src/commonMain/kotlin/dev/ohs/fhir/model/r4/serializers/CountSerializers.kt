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
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.Count
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object CountSerializer : KSerializer<Count> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Count") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("value", BigDecimalSerializer.descriptor, isOptional = true)
      element("_value", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("comparator", KotlinString.serializer().descriptor, isOptional = true)
      element("_comparator", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("unit", KotlinString.serializer().descriptor, isOptional = true)
      element("_unit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("system", KotlinString.serializer().descriptor, isOptional = true)
      element("_system", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Count =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Count) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Count {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var `value`: BigDecimal? = null
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          `value` = decoder.decodeNullableSerializableElement(__desc, 2, BigDecimalSerializer, null)
        3 -> _value = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.valueSer, null)
        4 -> comparator = decoder.decodeStringElement(__desc, 4)
        5 ->
          _comparator = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueSer, null)
        6 -> unit = decoder.decodeStringElement(__desc, 6)
        7 -> _unit = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueSer, null)
        8 -> system = decoder.decodeStringElement(__desc, 8)
        9 -> _system = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueSer, null)
        10 -> code = decoder.decodeStringElement(__desc, 10)
        11 -> _code = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Count: " + __i)
      }
    }
    return Count(
      id = id,
      extension = extension ?: listOf(),
      `value` = Decimal.of(`value`, _value),
      comparator =
        comparator?.let { Enumeration.of(Quantity.QuantityComparator.fromCode(it), _comparator) },
      unit = R4String.of(unit, _unit),
      system = Uri.of(system, _system),
      code = Code.of(code, _code),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Count) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.`value`?.value))?.let {
      encoder.encodeSerializableElement(__desc, 2, BigDecimalSerializer, it)
    }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.valueSer, it)
    }
    ((value.comparator?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.comparator?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.valueSer, it)
    }
    ((value.unit?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.unit?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.valueSer, it)
    }
    ((value.system?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.valueSer, it)
    }
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}
