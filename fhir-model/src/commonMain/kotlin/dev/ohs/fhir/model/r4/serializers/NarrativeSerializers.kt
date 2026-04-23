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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Xhtml
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
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

internal object NarrativeSerializer : KSerializer<Narrative> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Narrative") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("div", String.serializer().descriptor, isOptional = true)
      element("_div", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Narrative =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Narrative) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Narrative {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var status: String? = null
    var _status: Element? = null
    var div: String? = null
    var _div: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> status = decoder.decodeStringElement(__desc, 2)
        3 -> _status = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.statusSer, null)
        4 -> div = decoder.decodeStringElement(__desc, 4)
        5 -> _div = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.statusSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Narrative: " + __i)
      }
    }
    return Narrative(
      id = id,
      extension = extension ?: listOf(),
      status = Enumeration.of(Narrative.NarrativeStatus.fromCode(status!!), _status),
      div = Xhtml.of(div!!, _div)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Narrative) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.statusSer, it)
    }
    ((value.div.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.div.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.statusSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val statusSer: KSerializer<Element> = Element.serializer()
  }
}
