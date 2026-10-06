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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.UsageContext
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object UsageContextSerializer : KSerializer<UsageContext> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UsageContext") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("code", lazyDescriptor { CodingSerializer.descriptor })
      optionalElement(
        "valueCodeableConcept",
        lazyDescriptor { CodeableConceptSerializer.descriptor },
      )
      optionalElement("valueQuantity", lazyDescriptor { QuantitySerializer.descriptor })
      optionalElement("valueRange", lazyDescriptor { RangeSerializer.descriptor })
      optionalElement("valueReference", lazyDescriptor { ReferenceSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<UsageContext>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): UsageContext =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var code: Coding? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueRange: Range? = null
      var valueReference: Reference? = null
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
          2 -> code = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          3 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          6 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding UsageContext: " + i)
        }
      }
      UsageContext(
        id = id,
        extension = extension ?: listOf(),
        code =
          code ?: throw SerializationException("Missing required property 'code' on UsageContext"),
        `value` =
          UsageContext.Value.from(valueCodeableConcept, valueQuantity, valueRange, valueReference)
            ?: throw SerializationException("Missing required property 'value' on UsageContext"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: UsageContext) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeSerializableElement(descriptor, 2, CodingSerializer, value.code)
      when (val choice = value.`value`) {
        is UsageContext.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is UsageContext.Value.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is UsageContext.Value.Range -> {
          encodeSerializableElement(descriptor, 5, RangeSerializer, choice.value)
        }
        is UsageContext.Value.Reference -> {
          encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}
