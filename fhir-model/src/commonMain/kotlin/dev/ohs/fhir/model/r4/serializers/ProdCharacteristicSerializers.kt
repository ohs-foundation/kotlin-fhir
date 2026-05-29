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
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object ProdCharacteristicSerializer : KSerializer<ProdCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProdCharacteristic") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("height", Quantity.serializer().descriptor, isOptional = true)
      element("width", Quantity.serializer().descriptor, isOptional = true)
      element("depth", Quantity.serializer().descriptor, isOptional = true)
      element("weight", Quantity.serializer().descriptor, isOptional = true)
      element("nominalVolume", Quantity.serializer().descriptor, isOptional = true)
      element("externalDiameter", Quantity.serializer().descriptor, isOptional = true)
      element("shape", KotlinString.serializer().descriptor, isOptional = true)
      element("_shape", Element.serializer().descriptor, isOptional = true)
      element(
        "color",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_color", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "imprint",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_imprint", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("image", listSerialDescriptor(Attachment.serializer().descriptor), isOptional = true)
      element("scoring", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ProdCharacteristic =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: ProdCharacteristic) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ProdCharacteristic {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          height = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.heightSer, null)
        4 ->
          width = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.heightSer, null)
        5 ->
          depth = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.heightSer, null)
        6 ->
          weight = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.heightSer, null)
        7 ->
          nominalVolume =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.heightSer, null)
        8 ->
          externalDiameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.heightSer, null)
        9 -> shape = decoder.decodeStringElement(descriptor, i)
        10 ->
          _shape = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.shapeSer, null)
        11 ->
          color = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.colorSer, null)
        12 ->
          _color = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.colorSer2, null)
        13 ->
          imprint = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.colorSer, null)
        14 ->
          _imprint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.colorSer2, null)
        15 ->
          image = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.imageSer, null)
        16 ->
          scoring =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProdCharacteristic: " + i)
      }
    }
    return ProdCharacteristic(
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
          R4String.of(color?.getOrNull(index)?.let { it }, _color?.getOrNull(index))!!
        }),
      imprint =
        (kotlin.collections.List(maxOf(imprint?.size ?: 0, _imprint?.size ?: 0)) { index ->
          R4String.of(imprint?.getOrNull(index)?.let { it }, _imprint?.getOrNull(index))!!
        }),
      image = image ?: listOf(),
      scoring = scoring,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ProdCharacteristic) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.height)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.heightSer, it) }
    (value.width)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.heightSer, it) }
    (value.depth)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.heightSer, it) }
    (value.weight)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.heightSer, it) }
    (value.nominalVolume)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.heightSer, it)
    }
    (value.externalDiameter)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.heightSer, it)
    }
    ((value.shape?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.shape?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.shapeSer, it)
    }
    (value.color.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.colorSer, it)
    }
    (value.color.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.colorSer2, it)
    }
    (value.imprint.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.colorSer, it)
    }
    (value.imprint.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.colorSer2, it)
    }
    if (value.image.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.imageSer, value.image)
    (value.scoring)?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.scoringSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val heightSer: KSerializer<Quantity> = Quantity.serializer()

    public val shapeSer: KSerializer<Element> = Element.serializer()

    public val colorSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val colorSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.colorSerInner).nullable)

    public val colorSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.shapeSer).nullable)

    public val imageSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val imageSer: KSerializer<List<Attachment>> = ListSerializer(Hoisted.imageSerInner)

    public val scoringSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}
