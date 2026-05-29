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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.String as R4String
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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

internal object HumanNameSerializer : KSerializer<HumanName> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("HumanName") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("family", KotlinString.serializer().descriptor, isOptional = true)
      element("_family", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element(
        "given",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_given",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "prefix",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_prefix",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "suffix",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_suffix",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element("period", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): HumanName =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: HumanName) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): HumanName {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var family: KotlinString? = null
    var _family: Element? = null
    var given: List<KotlinString?>? = null
    var _given: List<Element?>? = null
    var prefix: List<KotlinString?>? = null
    var _prefix: List<Element?>? = null
    var suffix: List<KotlinString?>? = null
    var _suffix: List<Element?>? = null
    var period: Period? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> use = decoder.decodeStringElement(descriptor, i)
        3 -> _use = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        4 -> text = decoder.decodeStringElement(descriptor, i)
        5 -> _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        6 -> family = decoder.decodeStringElement(descriptor, i)
        7 ->
          _family = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        8 ->
          given = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.givenSer, null)
        9 ->
          _given = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.givenSer2, null)
        10 ->
          prefix = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.givenSer, null)
        11 ->
          _prefix =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.givenSer2, null)
        12 ->
          suffix = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.givenSer, null)
        13 ->
          _suffix =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.givenSer2, null)
        14 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding HumanName: " + i)
      }
    }
    return HumanName(
      id = id,
      extension = extension ?: listOf(),
      use = use?.let { Enumeration.of(HumanName.NameUse.fromCode(it), _use) },
      text = R4String.of(text, _text),
      family = R4String.of(family, _family),
      given =
        (kotlin.collections.List(maxOf(given?.size ?: 0, _given?.size ?: 0)) { index ->
          R4String.of(given?.getOrNull(index)?.let { it }, _given?.getOrNull(index))!!
        }),
      prefix =
        (kotlin.collections.List(maxOf(prefix?.size ?: 0, _prefix?.size ?: 0)) { index ->
          R4String.of(prefix?.getOrNull(index)?.let { it }, _prefix?.getOrNull(index))!!
        }),
      suffix =
        (kotlin.collections.List(maxOf(suffix?.size ?: 0, _suffix?.size ?: 0)) { index ->
          R4String.of(suffix?.getOrNull(index)?.let { it }, _suffix?.getOrNull(index))!!
        }),
      period = period,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: HumanName) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.use?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.use?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.useSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.useSer, it)
    }
    ((value.family?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.family?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.useSer, it)
    }
    (value.given.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.givenSer, it)
    }
    (value.given.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.givenSer2, it)
    }
    (value.prefix.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.givenSer, it)
    }
    (value.prefix.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.givenSer2, it)
    }
    (value.suffix.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.givenSer, it)
    }
    (value.suffix.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.givenSer2, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 14, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val useSer: KSerializer<Element> = Element.serializer()

    public val givenSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val givenSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.givenSerInner).nullable)

    public val givenSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.useSer).nullable)

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}
