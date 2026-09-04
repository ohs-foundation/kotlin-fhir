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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Url
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
      element("size", Int.serializer().descriptor, isOptional = true)
      element("_size", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("hash", KotlinString.serializer().descriptor, isOptional = true)
      element("_hash", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("creation", KotlinString.serializer().descriptor, isOptional = true)
      element("_creation", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Attachment =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Attachment) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Attachment {
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
    var size: Int? = null
    var _size: Element? = null
    var hash: KotlinString? = null
    var _hash: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var creation: KotlinString? = null
    var _creation: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> contentType = decoder.decodeStringElement(descriptor, i)
        3 ->
          _contentType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentTypeSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentTypeSer, null)
        6 -> `data` = decoder.decodeStringElement(descriptor, i)
        7 ->
          _data =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentTypeSer, null)
        8 -> url = decoder.decodeStringElement(descriptor, i)
        9 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentTypeSer, null)
        10 -> size = decoder.decodeIntElement(descriptor, i)
        11 ->
          _size =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentTypeSer, null)
        12 -> hash = decoder.decodeStringElement(descriptor, i)
        13 ->
          _hash =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentTypeSer, null)
        14 -> title = decoder.decodeStringElement(descriptor, i)
        15 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentTypeSer, null)
        16 -> creation = decoder.decodeStringElement(descriptor, i)
        17 ->
          _creation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attachment: " + i)
      }
    }
    return Attachment(
      id = id,
      extension = extension ?: listOf(),
      contentType = Code.of(contentType, _contentType),
      language = Code.of(language, _language),
      `data` = Base64Binary.of(`data`, _data),
      url = Url.of(url, _url),
      size = UnsignedInt.of(size, _size),
      hash = Base64Binary.of(hash, _hash),
      title = R4bString.of(title, _title),
      creation = DateTime.of(creation?.let { FhirDateTime.fromString(it) }, _creation),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Attachment) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.contentType?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.contentType?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.contentTypeSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.contentTypeSer, it)
    }
    ((value.`data`?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.contentTypeSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.contentTypeSer, it)
    }
    ((value.size?.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
    (value.size?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.contentTypeSer, it)
    }
    ((value.hash?.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.hash?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.contentTypeSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.contentTypeSer, it)
    }
    ((value.creation?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 16, it) }
    (value.creation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.contentTypeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contentTypeSer: KSerializer<Element> = Element.serializer()
  }
}
