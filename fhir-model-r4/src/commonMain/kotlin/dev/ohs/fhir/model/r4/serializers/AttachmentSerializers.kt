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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.ExtensibleEnumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.terminologies.CommonLanguages
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object AttachmentSerializer : FhirSerializer<Attachment> {
  override val descriptor: SerialDescriptor = buildDescriptor("Attachment", this)

  @JvmField internal val listSerializer: KSerializer<List<Attachment>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("contentType")
    b.strPrim("language")
    b.strPrim("data")
    b.strPrim("url")
    b.intPrim("size")
    b.strPrim("hash")
    b.strPrim("title")
    b.strPrim("creation")
  }

  override fun deserialize(decoder: Decoder): Attachment {
    val descriptor = this.descriptor
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
    var creation: FhirDateTime? = null
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
        16 ->
          creation = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        17 ->
          _creation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Attachment(
      id = id,
      extension = listOrEmpty(extension),
      contentType = Code.of(contentType, _contentType),
      language = ExtensibleEnumeration.of<CommonLanguages>(language, _language),
      `data` = Base64Binary.of(`data`, _data),
      url = Url.of(url, _url),
      size = UnsignedInt.of(size, _size),
      hash = Base64Binary.of(hash, _hash),
      title = R4String.of(title, _title),
      creation = DateTime.of(creation, _creation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Attachment) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
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
