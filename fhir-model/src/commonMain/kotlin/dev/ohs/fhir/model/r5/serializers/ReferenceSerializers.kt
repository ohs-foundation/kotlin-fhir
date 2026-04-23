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

import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object ReferenceSerializer : KSerializer<Reference> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Reference") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("reference", KotlinString.serializer().descriptor, isOptional = true)
      element("_reference", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element(
        "identifier",
        lazyDescriptor { Identifier.serializer().descriptor },
        isOptional = true,
      )
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Reference =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Reference) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Reference {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var reference: KotlinString? = null
    var _reference: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var identifier: Identifier? = null
    var display: KotlinString? = null
    var _display: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> reference = decoder.decodeStringElement(__desc, 2)
        3 ->
          _reference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.referenceSer, null)
        4 -> type = decoder.decodeStringElement(__desc, 4)
        5 ->
          _type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.referenceSer, null)
        6 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.identifierSer, null)
        7 -> display = decoder.decodeStringElement(__desc, 7)
        8 ->
          _display =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reference: " + __i)
      }
    }
    return Reference(
      id = id,
      extension = extension ?: listOf(),
      reference = R5String.of(reference, _reference),
      type = Uri.of(type, _type),
      identifier = identifier,
      display = R5String.of(display, _display),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Reference) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.reference?.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.reference?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.referenceSer, it)
    }
    ((value.type?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.referenceSer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.identifierSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.referenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSer: KSerializer<Element> = Element.serializer()

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()
  }
}
