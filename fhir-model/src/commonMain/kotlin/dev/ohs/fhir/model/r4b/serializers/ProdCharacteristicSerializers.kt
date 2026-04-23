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

import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.ProdCharacteristic
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.String as R4bString
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ProdCharacteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ProdCharacteristic {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> height = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.heightSer, null)
        4 -> width = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.heightSer, null)
        5 -> depth = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.heightSer, null)
        6 -> weight = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.heightSer, null)
        7 ->
          nominalVolume =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.heightSer, null)
        8 ->
          externalDiameter =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.heightSer, null)
        9 -> shape = decoder.decodeStringElement(__desc, 9)
        10 -> _shape = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.shapeSer, null)
        11 -> color = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.colorSer, null)
        12 ->
          _color = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.colorSer2, null)
        13 ->
          imprint = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.colorSer, null)
        14 ->
          _imprint = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.colorSer2, null)
        15 -> image = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.imageSer, null)
        16 ->
          scoring = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.scoringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProdCharacteristic: " + __i)
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
      shape = R4bString.of(shape, _shape),
      color =
        (kotlin.collections.List(maxOf(color?.size ?: 0, _color?.size ?: 0)) { __i ->
          R4bString.of(color?.getOrNull(__i)?.let { it }, _color?.getOrNull(__i))!!
        }),
      imprint =
        (kotlin.collections.List(maxOf(imprint?.size ?: 0, _imprint?.size ?: 0)) { __i ->
          R4bString.of(imprint?.getOrNull(__i)?.let { it }, _imprint?.getOrNull(__i))!!
        }),
      image = image ?: listOf(),
      scoring = scoring,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ProdCharacteristic) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.height)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.heightSer, it) }
    (value.width)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.heightSer, it) }
    (value.depth)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.heightSer, it) }
    (value.weight)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.heightSer, it) }
    (value.nominalVolume)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.heightSer, it)
    }
    (value.externalDiameter)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.heightSer, it)
    }
    ((value.shape?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.shape?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.shapeSer, it)
    }
    (value.color.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.colorSer, it)
    }
    (value.color.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.colorSer2, it)
    }
    (value.imprint.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.colorSer, it)
    }
    (value.imprint.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.colorSer2, it)
    }
    if (value.image.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.imageSer, value.image)
    (value.scoring)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.scoringSer, it) }
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
