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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
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

@OptIn(
  ExperimentalSerializationApi::class,
  InternalSerializationApi::class,
)
internal object DateTimeSerializer : KSerializer<DateTime> {
  private val extensionListSerializer: KSerializer<List<Extension>> =
    ListSerializer(Extension.serializer())

  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DateTime") {
      element("id", String.serializer().descriptor)
      element("extension", extensionListSerializer.descriptor)
      element("value", FhirDateTimeSerializer.descriptor)
    }

  override fun serialize(encoder: Encoder, `value`: DateTime) {
    encoder.encodeStructure(descriptor) {
      encodeNullableSerializableElement(descriptor, 0, String.serializer(), value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(descriptor, 1, extensionListSerializer, value.extension)
      encodeNullableSerializableElement(descriptor, 2, FhirDateTimeSerializer, value.`value`)
    }
  }

  override fun deserialize(decoder: Decoder): DateTime =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension> = emptyList()
      var `value`: FhirDateTime? = null
      while (true) {
        when (val index = decodeElementIndex(descriptor)) {
          0 -> id = decodeNullableSerializableElement(descriptor, 0, String.serializer())
          1 -> extension = decodeSerializableElement(descriptor, 1, extensionListSerializer)
          2 -> `value` = decodeNullableSerializableElement(descriptor, 2, FhirDateTimeSerializer)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException(
              """Unexpected index $index decoding ${descriptor.serialName}"""
            )
        }
      }
      DateTime(id = id, extension = extension, `value` = `value`)
    }
}
