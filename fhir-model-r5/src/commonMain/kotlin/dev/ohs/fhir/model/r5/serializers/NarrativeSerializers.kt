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

import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Xhtml
import dev.ohs.fhir.model.r5.terminologies.NarrativeStatus
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

  override fun deserialize(decoder: Decoder): Narrative {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var status: String? = null
    var _status: Element? = null
    var div: String? = null
    var _div: Element? = null
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
        2 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> div = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _div =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Narrative: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Narrative(
      id = id,
      extension = extension ?: listOf(),
      status =
        Enumeration.of(if (status != null) NarrativeStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Narrative"),
      div =
        Xhtml.of(
          div ?: throw SerializationException("Missing required property 'div' on Narrative"),
          _div,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Narrative) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.status.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.status)
    compositeEncoder.encodeStringElement(descriptor, 4, value.div.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.div)
    compositeEncoder.endStructure(descriptor)
  }
}
