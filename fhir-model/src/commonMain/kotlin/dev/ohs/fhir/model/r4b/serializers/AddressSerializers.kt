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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.String as R4bString
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object AddressSerializer : KSerializer<Address> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Address") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("line", listSerialDescriptor(KotlinString.serializer().descriptor), isOptional = true)
      element(
        "_line",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element("city", KotlinString.serializer().descriptor, isOptional = true)
      element("_city", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("district", KotlinString.serializer().descriptor, isOptional = true)
      element("_district", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("state", KotlinString.serializer().descriptor, isOptional = true)
      element("_state", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("postalCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_postalCode", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("country", KotlinString.serializer().descriptor, isOptional = true)
      element("_country", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("period", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Address =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Address) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Address {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var line: List<KotlinString?>? = null
    var _line: List<Element?>? = null
    var city: KotlinString? = null
    var _city: Element? = null
    var district: KotlinString? = null
    var _district: Element? = null
    var state: KotlinString? = null
    var _state: Element? = null
    var postalCode: KotlinString? = null
    var _postalCode: Element? = null
    var country: KotlinString? = null
    var _country: Element? = null
    var period: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 -> use = decoder.decodeStringElement(__desc, __i)
        3 -> _use = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        4 -> type = decoder.decodeStringElement(__desc, __i)
        5 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        6 -> text = decoder.decodeStringElement(__desc, __i)
        7 -> _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        8 -> line = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lineSer, null)
        9 -> _line = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lineSer2, null)
        10 -> city = decoder.decodeStringElement(__desc, __i)
        11 -> _city = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        12 -> district = decoder.decodeStringElement(__desc, __i)
        13 ->
          _district = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        14 -> state = decoder.decodeStringElement(__desc, __i)
        15 -> _state = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        16 -> postalCode = decoder.decodeStringElement(__desc, __i)
        17 ->
          _postalCode = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        18 -> country = decoder.decodeStringElement(__desc, __i)
        19 ->
          _country = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        20 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Address: " + __i)
      }
    }
    return Address(
      id = id,
      extension = extension ?: listOf(),
      use = use?.let { Enumeration.of(Address.AddressUse.fromCode(it), _use) },
      type = type?.let { Enumeration.of(Address.AddressType.fromCode(it), _type) },
      text = R4bString.of(text, _text),
      line =
        (kotlin.collections.List(maxOf(line?.size ?: 0, _line?.size ?: 0)) { __i ->
          R4bString.of(line?.getOrNull(__i)?.let { it }, _line?.getOrNull(__i))!!
        }),
      city = R4bString.of(city, _city),
      district = R4bString.of(district, _district),
      state = R4bString.of(state, _state),
      postalCode = R4bString.of(postalCode, _postalCode),
      country = R4bString.of(country, _country),
      period = period,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Address) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.use?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.use?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.useSer, it)
    }
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.useSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.useSer, it)
    }
    (value.line.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.lineSer, it)
    }
    (value.line.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.lineSer2, it)
    }
    ((value.city?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.city?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.useSer, it)
    }
    ((value.district?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.district?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.useSer, it)
    }
    ((value.state?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.state?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.useSer, it)
    }
    ((value.postalCode?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.postalCode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.useSer, it)
    }
    ((value.country?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.country?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.useSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val useSer: KSerializer<Element> = Element.serializer()

    public val lineSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val lineSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.lineSerInner).nullable)

    public val lineSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.useSer).nullable)

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}
