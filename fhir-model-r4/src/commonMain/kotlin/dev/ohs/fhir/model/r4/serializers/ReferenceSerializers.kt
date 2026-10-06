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

import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ReferenceSerializer : KSerializer<Reference> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Reference") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", KotlinString.serializer().descriptor)
      optionalElement("_reference", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("identifier", lazyDescriptor { IdentifierSerializer.descriptor })
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Reference>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Reference =
    decoder.decodeStructure(descriptor) {
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
          2 -> reference = decodeStringElement(descriptor, i)
          3 ->
            _reference = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> type = decodeStringElement(descriptor, i)
          5 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          7 -> display = decodeStringElement(descriptor, i)
          8 -> _display = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Reference: " + i)
        }
      }
      Reference(
        id = id,
        extension = extension ?: listOf(),
        reference = R4String.of(reference, _reference),
        type = Uri.of(type, _type),
        identifier = identifier,
        display = R4String.of(display, _display),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Reference) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.reference?.value)
      encodeElementIfNotNull(descriptor, 3, value.reference)
      encodeStringIfNotNull(descriptor, 4, value.type?.value)
      encodeElementIfNotNull(descriptor, 5, value.type)
      encodeSerializableIfNotNull(descriptor, 6, IdentifierSerializer, value.identifier)
      encodeStringIfNotNull(descriptor, 7, value.display?.value)
      encodeElementIfNotNull(descriptor, 8, value.display)
    }
  }
}
