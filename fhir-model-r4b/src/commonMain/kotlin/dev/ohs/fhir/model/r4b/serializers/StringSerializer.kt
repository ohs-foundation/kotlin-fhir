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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.String as R4bString
import kotlin.OptIn
import kotlin.String as KotlinString
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
internal object StringSerializer : KSerializer<R4bString> {
  private val extensionListSerializer: KSerializer<List<Extension>> =
    ListSerializer(Extension.serializer())

  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("String") {
      element("id", KotlinString.serializer().descriptor)
      element("extension", extensionListSerializer.descriptor)
      element("value", KotlinString.serializer().descriptor)
    }

  override fun serialize(encoder: Encoder, `value`: R4bString) {
    encoder.encodeStructure(descriptor) {
      encodeNullableSerializableElement(descriptor, 0, KotlinString.serializer(), value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(descriptor, 1, extensionListSerializer, value.extension)
      encodeNullableSerializableElement(descriptor, 2, KotlinString.serializer(), value.`value`)
    }
  }

  override fun deserialize(decoder: Decoder): R4bString =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension> = emptyList()
      var `value`: KotlinString? = null
      while (true) {
        when (val index = decodeElementIndex(descriptor)) {
          0 -> id = decodeNullableSerializableElement(descriptor, 0, KotlinString.serializer())
          1 -> extension = decodeSerializableElement(descriptor, 1, extensionListSerializer)
          2 -> `value` = decodeNullableSerializableElement(descriptor, 2, KotlinString.serializer())
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException(
              """Unexpected index $index decoding ${descriptor.serialName}"""
            )
        }
      }
      R4bString(id = id, extension = extension, `value` = `value`)
    }
}
