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
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Signature
import kotlin.OptIn
import kotlin.String
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

internal object SignatureSerializer : KSerializer<Signature> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Signature") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodingSerializer.listSerializer.descriptor)
      optionalElement("when", String.serializer().descriptor)
      optionalElement("_when", ElementSerializer.descriptor)
      optionalElement("who", ReferenceSerializer.descriptor)
      optionalElement("onBehalfOf", ReferenceSerializer.descriptor)
      optionalElement("targetFormat", String.serializer().descriptor)
      optionalElement("_targetFormat", ElementSerializer.descriptor)
      optionalElement("sigFormat", String.serializer().descriptor)
      optionalElement("_sigFormat", ElementSerializer.descriptor)
      optionalElement("data", String.serializer().descriptor)
      optionalElement("_data", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Signature>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Signature =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var type: List<Coding>? = null
      var `when`: String? = null
      var _when: Element? = null
      var who: Reference? = null
      var onBehalfOf: Reference? = null
      var targetFormat: String? = null
      var _targetFormat: Element? = null
      var sigFormat: String? = null
      var _sigFormat: Element? = null
      var `data`: String? = null
      var _data: Element? = null
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
          2 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          3 -> `when` = decodeStringElement(descriptor, i)
          4 -> _when = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> who = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 ->
            onBehalfOf = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 -> targetFormat = decodeStringElement(descriptor, i)
          8 ->
            _targetFormat =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> sigFormat = decodeStringElement(descriptor, i)
          10 ->
            _sigFormat = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> `data` = decodeStringElement(descriptor, i)
          12 -> _data = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Signature: " + i)
        }
      }
      Signature(
        id = id,
        extension = extension ?: listOf(),
        type = type ?: listOf(),
        `when` =
          Instant.of(if (`when` != null) FhirDateTime.fromString(`when`) else null, _when)
            ?: throw SerializationException("Missing required property 'when' on Signature"),
        who = who ?: throw SerializationException("Missing required property 'who' on Signature"),
        onBehalfOf = onBehalfOf,
        targetFormat = Code.of(targetFormat, _targetFormat),
        sigFormat = Code.of(sigFormat, _sigFormat),
        `data` = Base64Binary.of(`data`, _data),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Signature) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.type.isNotEmpty())
        encodeSerializableElement(descriptor, 2, CodingSerializer.listSerializer, value.type)
      encodeStringIfNotNull(descriptor, 3, value.`when`.value?.toString())
      encodeElementIfNotNull(descriptor, 4, value.`when`)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.who)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.onBehalfOf)
      encodeStringIfNotNull(descriptor, 7, value.targetFormat?.value)
      encodeElementIfNotNull(descriptor, 8, value.targetFormat)
      encodeStringIfNotNull(descriptor, 9, value.sigFormat?.value)
      encodeElementIfNotNull(descriptor, 10, value.sigFormat)
      encodeStringIfNotNull(descriptor, 11, value.`data`?.value)
      encodeElementIfNotNull(descriptor, 12, value.`data`)
    }
  }
}
