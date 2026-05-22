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

import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
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

internal object ContactPointSerializer : KSerializer<ContactPoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContactPoint") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("system", KotlinString.serializer().descriptor, isOptional = true)
      element("_system", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("rank", Int.serializer().descriptor, isOptional = true)
      element("_rank", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("period", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ContactPoint =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: ContactPoint) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ContactPoint {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var system: KotlinString? = null
    var _system: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var rank: Int? = null
    var _rank: Element? = null
    var period: Period? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> system = decoder.decodeStringElement(descriptor, i)
        3 ->
          _system =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        4 -> `value` = decoder.decodeStringElement(descriptor, i)
        5 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        6 -> use = decoder.decodeStringElement(descriptor, i)
        7 ->
          _use = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        8 -> rank = decoder.decodeIntElement(descriptor, i)
        9 ->
          _rank = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.systemSer, null)
        10 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContactPoint: " + i)
      }
    }
    return ContactPoint(
      id = id,
      extension = extension ?: listOf(),
      system =
        system?.let { Enumeration.of(ContactPoint.ContactPointSystem.fromCode(it), _system) },
      `value` = R5String.of(`value`, _value),
      use = use?.let { Enumeration.of(ContactPoint.ContactPointUse.fromCode(it), _use) },
      rank = PositiveInt.of(rank, _rank),
      period = period,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ContactPoint) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.system?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.systemSer, it)
    }
    ((value.`value`?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.systemSer, it)
    }
    ((value.use?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.use?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.systemSer, it)
    }
    ((value.rank?.value))?.let { encoder.encodeIntElement(descriptor, 8, it) }
    (value.rank?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.systemSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 10, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val systemSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}
