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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.String as R5String
import kotlin.String as KotlinString
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

internal object CodeableConceptSerializer : KSerializer<CodeableConcept> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CodeableConcept") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "coding",
        listSerialDescriptor(lazyDescriptor { Coding.serializer().descriptor }),
        isOptional = true,
      )
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CodeableConcept =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CodeableConcept) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CodeableConcept {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var coding: List<Coding>? = null
    var text: KotlinString? = null
    var _text: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> coding = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.codingSer, null)
        3 -> text = decoder.decodeStringElement(__desc, 3)
        4 -> _text = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.textSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CodeableConcept: " + __i)
      }
    }
    return CodeableConcept(
      id = id,
      extension = extension ?: listOf(),
      coding = coding ?: listOf(),
      text = R5String.of(text, _text),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CodeableConcept) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.coding.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.codingSer, value.coding)
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.textSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codingSerInner: KSerializer<Coding> = Coding.serializer()

    public val codingSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.codingSerInner)

    public val textSer: KSerializer<Element> = Element.serializer()
  }
}
