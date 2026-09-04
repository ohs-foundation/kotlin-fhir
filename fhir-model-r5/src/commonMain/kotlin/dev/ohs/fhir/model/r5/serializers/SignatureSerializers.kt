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

import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Signature
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
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object SignatureSerializer : KSerializer<Signature> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Signature") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "type",
        listSerialDescriptor(lazyDescriptor { Coding.serializer().descriptor }),
        isOptional = true,
      )
      element("when", String.serializer().descriptor, isOptional = true)
      element("_when", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("who", lazyDescriptor { Reference.serializer().descriptor }, isOptional = true)
      element("onBehalfOf", lazyDescriptor { Reference.serializer().descriptor }, isOptional = true)
      element("targetFormat", String.serializer().descriptor, isOptional = true)
      element(
        "_targetFormat",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("sigFormat", String.serializer().descriptor, isOptional = true)
      element("_sigFormat", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("data", String.serializer().descriptor, isOptional = true)
      element("_data", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Signature =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Signature) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Signature {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        3 -> `when` = decoder.decodeStringElement(descriptor, i)
        4 -> _when = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whenSer, null)
        5 -> who = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whoSer, null)
        6 ->
          onBehalfOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whoSer, null)
        7 -> targetFormat = decoder.decodeStringElement(descriptor, i)
        8 ->
          _targetFormat =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whenSer, null)
        9 -> sigFormat = decoder.decodeStringElement(descriptor, i)
        10 ->
          _sigFormat =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whenSer, null)
        11 -> `data` = decoder.decodeStringElement(descriptor, i)
        12 ->
          _data = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whenSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Signature: " + i)
      }
    }
    return Signature(
      id = id,
      extension = extension ?: listOf(),
      type = type ?: listOf(),
      `when` = Instant.of(`when`?.let { FhirDateTime.fromString(it) }, _when),
      who = who,
      onBehalfOf = onBehalfOf,
      targetFormat = Code.of(targetFormat, _targetFormat),
      sigFormat = Code.of(sigFormat, _sigFormat),
      `data` = Base64Binary.of(`data`, _data),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Signature) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 2, Hoisted.typeSer, value.type)
    ((value.`when`?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.`when`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.whenSer, it)
    }
    (value.who)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.whoSer, it) }
    (value.onBehalfOf)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.whoSer, it) }
    ((value.targetFormat?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.targetFormat?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.whenSer, it)
    }
    ((value.sigFormat?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.sigFormat?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.whenSer, it)
    }
    ((value.`data`?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.whenSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSerInner: KSerializer<Coding> = Coding.serializer()

    public val typeSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.typeSerInner)

    public val whenSer: KSerializer<Element> = Element.serializer()

    public val whoSer: KSerializer<Reference> = Reference.serializer()
  }
}
