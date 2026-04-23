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

import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Signature
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Signature) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Signature {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.typeSer, null)
        3 -> `when` = decoder.decodeStringElement(__desc, 3)
        4 -> _when = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.whenSer, null)
        5 -> who = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.whoSer, null)
        6 -> onBehalfOf = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.whoSer, null)
        7 -> targetFormat = decoder.decodeStringElement(__desc, 7)
        8 ->
          _targetFormat =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.whenSer, null)
        9 -> sigFormat = decoder.decodeStringElement(__desc, 9)
        10 ->
          _sigFormat = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.whenSer, null)
        11 -> `data` = decoder.decodeStringElement(__desc, 11)
        12 -> _data = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.whenSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Signature: " + __i)
      }
    }
    return Signature(
      id = id,
      extension = extension ?: listOf(),
      type = type ?: listOf(),
      `when` = Instant.of(FhirDateTime.fromString(`when`), _when)!!,
      who = who!!,
      onBehalfOf = onBehalfOf,
      targetFormat = Code.of(targetFormat, _targetFormat),
      sigFormat = Code.of(sigFormat, _sigFormat),
      `data` = Base64Binary.of(`data`, _data),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Signature) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.typeSer, value.type)
    ((value.`when`.value?.toString()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.`when`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.whenSer, it)
    }
    (value.who)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.whoSer, it) }
    (value.onBehalfOf)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.whoSer, it) }
    ((value.targetFormat?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.targetFormat?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.whenSer, it)
    }
    ((value.sigFormat?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.sigFormat?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.whenSer, it)
    }
    ((value.`data`?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.whenSer, it)
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
