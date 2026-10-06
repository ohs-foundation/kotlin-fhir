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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.OptIn
import kotlin.String as KotlinString
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object CodingSerializer : KSerializer<Coding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coding") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("system", KotlinString.serializer().descriptor)
      optionalElement("_system", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("version", KotlinString.serializer().descriptor)
      optionalElement("_version", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("userSelected", KotlinBoolean.serializer().descriptor)
      optionalElement("_userSelected", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Coding>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Coding =
    decoder.decodeStructure(descriptor) {
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
          2 -> system = decodeStringElement(descriptor, i)
          3 -> _system = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> version = decodeStringElement(descriptor, i)
          5 -> _version = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> code = decodeStringElement(descriptor, i)
          7 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> display = decodeStringElement(descriptor, i)
          9 -> _display = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> userSelected = decodeBooleanElement(descriptor, i)
          11 ->
            _userSelected =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Coding: " + i)
        }
      }
      Coding(
        id = id,
        extension = extension ?: listOf(),
        system = Uri.of(system, _system),
        version = R4String.of(version, _version),
        code = Code.of(code, _code),
        display = R4String.of(display, _display),
        userSelected = R4Boolean.of(userSelected, _userSelected),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Coding) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.system?.value)
      encodeElementIfNotNull(descriptor, 3, value.system)
      encodeStringIfNotNull(descriptor, 4, value.version?.value)
      encodeElementIfNotNull(descriptor, 5, value.version)
      encodeStringIfNotNull(descriptor, 6, value.code?.value)
      encodeElementIfNotNull(descriptor, 7, value.code)
      encodeStringIfNotNull(descriptor, 8, value.display?.value)
      encodeElementIfNotNull(descriptor, 9, value.display)
      encodeBooleanIfNotNull(descriptor, 10, value.userSelected?.value)
      encodeElementIfNotNull(descriptor, 11, value.userSelected)
    }
  }
}
