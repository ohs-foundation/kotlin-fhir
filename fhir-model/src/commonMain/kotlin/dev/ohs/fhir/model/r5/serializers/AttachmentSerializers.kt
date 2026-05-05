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

package dev.ohs.fhir.model.r5.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Integer64
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Url
import kotlin.Int
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

internal object AttachmentSerializer : KSerializer<Attachment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Attachment") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("contentType", KotlinString.serializer().descriptor, isOptional = true)
      element("_contentType", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("data", KotlinString.serializer().descriptor, isOptional = true)
      element("_data", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("size", KotlinString.serializer().descriptor, isOptional = true)
      element("_size", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("hash", KotlinString.serializer().descriptor, isOptional = true)
      element("_hash", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("creation", KotlinString.serializer().descriptor, isOptional = true)
      element("_creation", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("height", Int.serializer().descriptor, isOptional = true)
      element("_height", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("width", Int.serializer().descriptor, isOptional = true)
      element("_width", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("frames", Int.serializer().descriptor, isOptional = true)
      element("_frames", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("duration", BigDecimalSerializer.descriptor, isOptional = true)
      element("_duration", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("pages", Int.serializer().descriptor, isOptional = true)
      element("_pages", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Attachment =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Attachment) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Attachment {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var contentType: KotlinString? = null
    var _contentType: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var `data`: KotlinString? = null
    var _data: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var size: KotlinString? = null
    var _size: Element? = null
    var hash: KotlinString? = null
    var _hash: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var creation: KotlinString? = null
    var _creation: Element? = null
    var height: Int? = null
    var _height: Element? = null
    var width: Int? = null
    var _width: Element? = null
    var frames: Int? = null
    var _frames: Element? = null
    var duration: BigDecimal? = null
    var _duration: Element? = null
    var pages: Int? = null
    var _pages: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 -> contentType = decoder.decodeStringElement(__desc, __i)
        3 ->
          _contentType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        6 -> `data` = decoder.decodeStringElement(__desc, __i)
        7 ->
          _data =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        8 -> url = decoder.decodeStringElement(__desc, __i)
        9 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        10 -> size = decoder.decodeStringElement(__desc, __i)
        11 ->
          _size =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        12 -> hash = decoder.decodeStringElement(__desc, __i)
        13 ->
          _hash =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        14 -> title = decoder.decodeStringElement(__desc, __i)
        15 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        16 -> creation = decoder.decodeStringElement(__desc, __i)
        17 ->
          _creation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        18 -> height = decoder.decodeIntElement(__desc, __i)
        19 ->
          _height =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        20 -> width = decoder.decodeIntElement(__desc, __i)
        21 ->
          _width =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        22 -> frames = decoder.decodeIntElement(__desc, __i)
        23 ->
          _frames =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        24 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        25 ->
          _duration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        26 -> pages = decoder.decodeIntElement(__desc, __i)
        27 ->
          _pages =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attachment: " + __i)
      }
    }
    return Attachment(
      id = id,
      extension = extension ?: listOf(),
      contentType = Code.of(contentType, _contentType),
      language = Code.of(language, _language),
      `data` = Base64Binary.of(`data`, _data),
      url = Url.of(url, _url),
      size = Integer64.of(size?.toLong(), _size),
      hash = Base64Binary.of(hash, _hash),
      title = R5String.of(title, _title),
      creation = DateTime.of(FhirDateTime.fromString(creation), _creation),
      height = PositiveInt.of(height, _height),
      width = PositiveInt.of(width, _width),
      frames = PositiveInt.of(frames, _frames),
      duration = Decimal.of(duration, _duration),
      pages = PositiveInt.of(pages, _pages),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Attachment) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.contentType?.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.contentType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.contentTypeSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.contentTypeSer, it)
    }
    ((value.`data`?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.contentTypeSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.contentTypeSer, it)
    }
    ((value.size?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.size?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.contentTypeSer, it)
    }
    ((value.hash?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.hash?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.contentTypeSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.contentTypeSer, it)
    }
    ((value.creation?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.creation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.contentTypeSer, it)
    }
    ((value.height?.value))?.let { encoder.encodeIntElement(__desc, 18, it) }
    (value.height?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.contentTypeSer, it)
    }
    ((value.width?.value))?.let { encoder.encodeIntElement(__desc, 20, it) }
    (value.width?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.contentTypeSer, it)
    }
    ((value.frames?.value))?.let { encoder.encodeIntElement(__desc, 22, it) }
    (value.frames?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.contentTypeSer, it)
    }
    ((value.duration?.value))?.let {
      encoder.encodeSerializableElement(__desc, 24, BigDecimalSerializer, it)
    }
    (value.duration?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.contentTypeSer, it)
    }
    ((value.pages?.value))?.let { encoder.encodeIntElement(__desc, 26, it) }
    (value.pages?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.contentTypeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contentTypeSer: KSerializer<Element> = Element.serializer()
  }
}
