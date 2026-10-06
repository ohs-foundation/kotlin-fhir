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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.Integer64
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Url
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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object AttachmentSerializer : KSerializer<Attachment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Attachment") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("contentType", KotlinString.serializer().descriptor)
      optionalElement("_contentType", ElementSerializer.descriptor)
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", ElementSerializer.descriptor)
      optionalElement("data", KotlinString.serializer().descriptor)
      optionalElement("_data", ElementSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
      optionalElement("size", KotlinString.serializer().descriptor)
      optionalElement("_size", ElementSerializer.descriptor)
      optionalElement("hash", KotlinString.serializer().descriptor)
      optionalElement("_hash", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("creation", KotlinString.serializer().descriptor)
      optionalElement("_creation", ElementSerializer.descriptor)
      optionalElement("height", Int.serializer().descriptor)
      optionalElement("_height", ElementSerializer.descriptor)
      optionalElement("width", Int.serializer().descriptor)
      optionalElement("_width", ElementSerializer.descriptor)
      optionalElement("frames", Int.serializer().descriptor)
      optionalElement("_frames", ElementSerializer.descriptor)
      optionalElement("duration", FhirDecimalSerializer.descriptor)
      optionalElement("_duration", ElementSerializer.descriptor)
      optionalElement("pages", Int.serializer().descriptor)
      optionalElement("_pages", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Attachment>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Attachment =
    decoder.decodeStructure(descriptor) {
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
      var duration: FhirDecimal? = null
      var _duration: Element? = null
      var pages: Int? = null
      var _pages: Element? = null
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
          2 -> contentType = decodeStringElement(descriptor, i)
          3 ->
            _contentType = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> language = decodeStringElement(descriptor, i)
          5 -> _language = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> `data` = decodeStringElement(descriptor, i)
          7 -> _data = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> url = decodeStringElement(descriptor, i)
          9 -> _url = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> size = decodeStringElement(descriptor, i)
          11 -> _size = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> hash = decodeStringElement(descriptor, i)
          13 -> _hash = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> title = decodeStringElement(descriptor, i)
          15 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 -> creation = decodeStringElement(descriptor, i)
          17 ->
            _creation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 -> height = decodeIntElement(descriptor, i)
          19 -> _height = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          20 -> width = decodeIntElement(descriptor, i)
          21 -> _width = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          22 -> frames = decodeIntElement(descriptor, i)
          23 -> _frames = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 ->
            duration = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          25 ->
            _duration = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          26 -> pages = decodeIntElement(descriptor, i)
          27 -> _pages = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Attachment: " + i)
        }
      }
      Attachment(
        id = id,
        extension = extension ?: listOf(),
        contentType = Code.of(contentType, _contentType),
        language = Code.of(language, _language),
        `data` = Base64Binary.of(`data`, _data),
        url = Url.of(url, _url),
        size = Integer64.of(size?.toLong(), _size),
        hash = Base64Binary.of(hash, _hash),
        title = R5String.of(title, _title),
        creation =
          DateTime.of(if (creation != null) FhirDateTime.fromString(creation) else null, _creation),
        height = PositiveInt.of(height, _height),
        width = PositiveInt.of(width, _width),
        frames = PositiveInt.of(frames, _frames),
        duration = Decimal.of(duration, _duration),
        pages = PositiveInt.of(pages, _pages),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Attachment) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.contentType?.value)
      encodeElementIfNotNull(descriptor, 3, value.contentType)
      encodeStringIfNotNull(descriptor, 4, value.language?.value)
      encodeElementIfNotNull(descriptor, 5, value.language)
      encodeStringIfNotNull(descriptor, 6, value.`data`?.value)
      encodeElementIfNotNull(descriptor, 7, value.`data`)
      encodeStringIfNotNull(descriptor, 8, value.url?.value)
      encodeElementIfNotNull(descriptor, 9, value.url)
      encodeStringIfNotNull(descriptor, 10, value.size?.value?.toString())
      encodeElementIfNotNull(descriptor, 11, value.size)
      encodeStringIfNotNull(descriptor, 12, value.hash?.value)
      encodeElementIfNotNull(descriptor, 13, value.hash)
      encodeStringIfNotNull(descriptor, 14, value.title?.value)
      encodeElementIfNotNull(descriptor, 15, value.title)
      encodeStringIfNotNull(descriptor, 16, value.creation?.value?.toString())
      encodeElementIfNotNull(descriptor, 17, value.creation)
      encodeIntIfNotNull(descriptor, 18, value.height?.value)
      encodeElementIfNotNull(descriptor, 19, value.height)
      encodeIntIfNotNull(descriptor, 20, value.width?.value)
      encodeElementIfNotNull(descriptor, 21, value.width)
      encodeIntIfNotNull(descriptor, 22, value.frames?.value)
      encodeElementIfNotNull(descriptor, 23, value.frames)
      encodeSerializableIfNotNull(descriptor, 24, FhirDecimalSerializer, value.duration?.value)
      encodeElementIfNotNull(descriptor, 25, value.duration)
      encodeIntIfNotNull(descriptor, 26, value.pages?.value)
      encodeElementIfNotNull(descriptor, 27, value.pages)
    }
  }
}
