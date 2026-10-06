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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.ProdCharacteristic
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.String as R4String
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

internal object ProdCharacteristicSerializer : KSerializer<ProdCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProdCharacteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("height", QuantitySerializer.descriptor)
      optionalElement("width", QuantitySerializer.descriptor)
      optionalElement("depth", QuantitySerializer.descriptor)
      optionalElement("weight", QuantitySerializer.descriptor)
      optionalElement("nominalVolume", QuantitySerializer.descriptor)
      optionalElement("externalDiameter", QuantitySerializer.descriptor)
      optionalElement("shape", KotlinString.serializer().descriptor)
      optionalElement("_shape", ElementSerializer.descriptor)
      optionalElement("color", stringNullableListSerializer.descriptor)
      optionalElement("_color", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("imprint", stringNullableListSerializer.descriptor)
      optionalElement("_imprint", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("image", AttachmentSerializer.listSerializer.descriptor)
      optionalElement("scoring", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ProdCharacteristic>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ProdCharacteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var height: Quantity? = null
      var width: Quantity? = null
      var depth: Quantity? = null
      var weight: Quantity? = null
      var nominalVolume: Quantity? = null
      var externalDiameter: Quantity? = null
      var shape: KotlinString? = null
      var _shape: Element? = null
      var color: List<KotlinString?>? = null
      var _color: List<Element?>? = null
      var imprint: List<KotlinString?>? = null
      var _imprint: List<Element?>? = null
      var image: List<Attachment>? = null
      var scoring: CodeableConcept? = null
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
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> height = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          4 -> width = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 -> depth = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> weight = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          7 ->
            nominalVolume =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          8 ->
            externalDiameter =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> shape = decodeStringElement(descriptor, i)
          10 -> _shape = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            color =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          12 ->
            _color =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          13 ->
            imprint =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          14 ->
            _imprint =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          15 ->
            image =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AttachmentSerializer.listSerializer,
                null,
              )
          16 ->
            scoring =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ProdCharacteristic: " + i)
        }
      }
      ProdCharacteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        height = height,
        width = width,
        depth = depth,
        weight = weight,
        nominalVolume = nominalVolume,
        externalDiameter = externalDiameter,
        shape = R4String.of(shape, _shape),
        color =
          (kotlin.collections.List(maxOf(color?.size ?: 0, _color?.size ?: 0)) { index ->
            R4String.of(color?.getOrNull(index), _color?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'color' on ProdCharacteristic has neither a value nor an id/extension"
              )
          }),
        imprint =
          (kotlin.collections.List(maxOf(imprint?.size ?: 0, _imprint?.size ?: 0)) { index ->
            R4String.of(imprint?.getOrNull(index), _imprint?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'imprint' on ProdCharacteristic has neither a value nor an id/extension"
              )
          }),
        image = image ?: listOf(),
        scoring = scoring,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ProdCharacteristic) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.height)
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.width)
      encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.depth)
      encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.weight)
      encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.nominalVolume)
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.externalDiameter)
      encodeStringIfNotNull(descriptor, 9, value.shape?.value)
      encodeElementIfNotNull(descriptor, 10, value.shape)
      if (value.color.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          11,
          stringNullableListSerializer,
          value.color.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 12, value.color)
      }
      if (value.imprint.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          13,
          stringNullableListSerializer,
          value.imprint.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 14, value.imprint)
      }
      if (value.image.isNotEmpty())
        encodeSerializableElement(descriptor, 15, AttachmentSerializer.listSerializer, value.image)
      encodeSerializableIfNotNull(descriptor, 16, CodeableConceptSerializer, value.scoring)
    }
  }
}
