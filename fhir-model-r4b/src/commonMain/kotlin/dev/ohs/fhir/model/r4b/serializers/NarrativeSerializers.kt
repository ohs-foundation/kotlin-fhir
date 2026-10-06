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

import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Xhtml
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

internal object NarrativeSerializer : KSerializer<Narrative> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Narrative") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("status", String.serializer().descriptor)
      optionalElement("_status", ElementSerializer.descriptor)
      optionalElement("div", String.serializer().descriptor)
      optionalElement("_div", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Narrative>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Narrative =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var status: String? = null
      var _status: Element? = null
      var div: String? = null
      var _div: Element? = null
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
          2 -> status = decodeStringElement(descriptor, i)
          3 -> _status = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> div = decodeStringElement(descriptor, i)
          5 -> _div = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Narrative: " + i)
        }
      }
      Narrative(
        id = id,
        extension = extension ?: listOf(),
        status =
          Enumeration.of(
            if (status != null) Narrative.NarrativeStatus.fromCode(status) else null,
            _status,
          ) ?: throw SerializationException("Missing required property 'status' on Narrative"),
        div =
          Xhtml.of(
            div ?: throw SerializationException("Missing required property 'div' on Narrative"),
            _div,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Narrative) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.status.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.status)
      encodeStringElement(descriptor, 4, value.div.value)
      encodeElementIfNotNull(descriptor, 5, value.div)
    }
  }
}
