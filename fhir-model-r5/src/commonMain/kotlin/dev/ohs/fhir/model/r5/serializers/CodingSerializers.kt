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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

  override fun deserialize(decoder: Decoder): Coding {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        2 -> system = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> userSelected = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _userSelected =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Coding: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Coding(
      id = id,
      extension = extension ?: listOf(),
      system = Uri.of(system, _system),
      version = R5String.of(version, _version),
      code = Code.of(code, _code),
      display = R5String.of(display, _display),
      userSelected = R5Boolean.of(userSelected, _userSelected),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Coding) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.system?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.system)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.display)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, value.userSelected?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.userSelected)
    compositeEncoder.endStructure(descriptor)
  }
}
