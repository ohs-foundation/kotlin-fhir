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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object CodingSerializer : FhirSerializer<Coding> {
  override val descriptor: SerialDescriptor = buildDescriptor("Coding", this)

  @JvmField internal val listSerializer: KSerializer<List<Coding>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("system")
    b.strPrim("version")
    b.strPrim("code")
    b.strPrim("display")
    b.boolPrim("userSelected")
  }

  override fun deserialize(decoder: Decoder): Coding {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Coding(
      id = id,
      extension = listOrEmpty(extension),
      system = Uri.of(system, _system),
      version = R4bString.of(version, _version),
      code = Code.of(code, _code),
      display = R4bString.of(display, _display),
      userSelected = R4bBoolean.of(userSelected, _userSelected),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Coding) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
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
