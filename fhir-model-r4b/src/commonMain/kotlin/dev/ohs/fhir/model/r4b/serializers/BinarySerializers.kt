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

import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Binary
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder

internal object BinarySerializer : FhirResourceSerializer<Binary> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Binary")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("contentType", String.serializer().descriptor)
    b.optionalElement("_contentType", ElementSerializer.descriptor)
    b.optionalElement("securityContext", ReferenceSerializer.descriptor)
    b.optionalElement("data", String.serializer().descriptor)
    b.optionalElement("_data", ElementSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Binary {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var contentType: String? = null
    var _contentType: Element? = null
    var securityContext: Reference? = null
    var `data`: String? = null
    var _data: Element? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> contentType = decoder.decodeStringElement(descriptor, i)
        7 ->
          _contentType =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          securityContext =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        9 -> `data` = decoder.decodeStringElement(descriptor, i)
        10 ->
          _data = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        else -> throw SerializationException("Unexpected index decoding Binary: " + i)
      }
    }
    return Binary(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      contentType =
        Code.of(contentType, _contentType)
          ?: throw SerializationException("Missing required property 'contentType' on Binary"),
      securityContext = securityContext,
      `data` = Base64Binary.of(`data`, _data),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Binary,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeStringIfNotNull(descriptor, 6 + descriptorOffset, value.contentType.value)
    encoder.encodeElementIfNotNull(descriptor, 7 + descriptorOffset, value.contentType)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      8 + descriptorOffset,
      ReferenceSerializer,
      value.securityContext,
    )
    encoder.encodeStringIfNotNull(descriptor, 9 + descriptorOffset, value.`data`?.value)
    encoder.encodeElementIfNotNull(descriptor, 10 + descriptorOffset, value.`data`)
  }
}
