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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object CodingSerializer : KSerializer<Coding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coding") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("system", KotlinString.serializer().descriptor, isOptional = true)
      element("_system", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("userSelected", KotlinBoolean.serializer().descriptor, isOptional = true)
      element(
        "_userSelected",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Coding =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Coding) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Coding {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var system: KotlinString? = null
    var _system: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var userSelected: KotlinBoolean? = null
    var _userSelected: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 -> system = decoder.decodeStringElement(__desc, __i)
        3 ->
          _system = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.systemSer, null)
        4 -> version = decoder.decodeStringElement(__desc, __i)
        5 ->
          _version = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.systemSer, null)
        6 -> code = decoder.decodeStringElement(__desc, __i)
        7 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.systemSer, null)
        8 -> display = decoder.decodeStringElement(__desc, __i)
        9 ->
          _display = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.systemSer, null)
        10 -> userSelected = decoder.decodeBooleanElement(__desc, __i)
        11 ->
          _userSelected =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.systemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Coding: " + __i)
      }
    }
    return Coding(
      id = id,
      extension = extension ?: listOf(),
      system = Uri.of(system, _system),
      version = R4bString.of(version, _version),
      code = Code.of(code, _code),
      display = R4bString.of(display, _display),
      userSelected = R4bBoolean.of(userSelected, _userSelected),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Coding) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.system?.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.systemSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.systemSer, it)
    }
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.systemSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.systemSer, it)
    }
    ((value.userSelected?.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
    (value.userSelected?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.systemSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val systemSer: KSerializer<Element> = Element.serializer()
  }
}
