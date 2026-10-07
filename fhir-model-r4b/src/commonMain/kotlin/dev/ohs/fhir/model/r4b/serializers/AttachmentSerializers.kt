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
import dev.ohs.fhir.model.r4b.ExtensibleEnumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.terminologies.CommonLanguages
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object AttachmentSerializer : KSerializer<Attachment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Attachment") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("contentType", KotlinString.serializer().descriptor)
      optionalElement("_contentType", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("data", KotlinString.serializer().descriptor)
      optionalElement("_data", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("size", Int.serializer().descriptor)
      optionalElement("_size", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("hash", KotlinString.serializer().descriptor)
      optionalElement("_hash", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("creation", KotlinString.serializer().descriptor)
      optionalElement("_creation", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Attachment>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Attachment {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        2 -> contentType = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _contentType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> `data` = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _data =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> size = compositeDecoder.decodeIntElement(descriptor, i)
        11 ->
          _size =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> hash = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _hash =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> creation = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _creation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attachment: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Attachment(
      id = id,
      extension = extension ?: listOf(),
      contentType = Code.of(contentType, _contentType),
      language = ExtensibleEnumeration.of<CommonLanguages>(language, _language),
      `data` = Base64Binary.of(`data`, _data),
      url = Url.of(url, _url),
      size = UnsignedInt.of(size, _size),
      hash = Base64Binary.of(hash, _hash),
      title = R4bString.of(title, _title),
      creation =
        DateTime.of(if (creation != null) FhirDateTime.fromString(creation) else null, _creation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Attachment) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.contentType?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.contentType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.language?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.language)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.`data`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.`data`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.url)
    compositeEncoder.encodeIntIfNotNull(descriptor, 10, value.size?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.size)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.hash?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.hash)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 16, value.creation?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.creation)
    compositeEncoder.endStructure(descriptor)
  }
}
