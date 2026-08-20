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

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.Count
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object CountSerializer : KSerializer<Count> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Count") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("value", FhirDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Count) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Count {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          `value` =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        3 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        4 -> comparator = decoder.decodeStringElement(descriptor, i)
        5 ->
          _comparator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        6 -> unit = decoder.decodeStringElement(descriptor, i)
        7 ->
          _unit = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        8 -> system = decoder.decodeStringElement(descriptor, i)
        9 ->
          _system = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        10 -> code = decoder.decodeStringElement(descriptor, i)
        11 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Count: " + i)
      }
    }
    return Count(
      id = id,
      extension = extension ?: listOf(),
      `value` = Decimal.of(`value`, _value),
      comparator =
        Enumeration.of(comparator?.let { Quantity.QuantityComparator.fromCode(it) }, _comparator),
      unit = R4String.of(unit, _unit),
      system = Uri.of(system, _system),
      code = Code.of(code, _code),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Count) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.`value`?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 2, FhirDecimalSerializer, it)
    }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.valueSer, it)
    }
    ((value.comparator?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.comparator?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueSer, it)
    }
    ((value.unit?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.unit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueSer, it)
    }
    ((value.system?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueSer, it)
    }
    ((value.code?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}
