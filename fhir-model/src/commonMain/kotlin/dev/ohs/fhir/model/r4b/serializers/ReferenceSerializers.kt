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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Reference) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Reference {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> reference = decoder.decodeStringElement(descriptor, i)
        3 ->
          _reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        4 -> type = decoder.decodeStringElement(descriptor, i)
        5 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        6 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        7 -> display = decoder.decodeStringElement(descriptor, i)
        8 ->
          _display =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reference: " + i)
      }
    }
    return Reference(
      id = id,
      extension = extension ?: listOf(),
      reference = R4bString.of(reference, _reference),
      type = Uri.of(type, _type),
      identifier = identifier,
      display = R4bString.of(display, _display),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Reference) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.reference?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.reference?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.referenceSer, it)
    }
    ((value.type?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.referenceSer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.identifierSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.referenceSer, it)
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
