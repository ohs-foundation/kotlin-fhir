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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.ProductShelfLife
import dev.ohs.fhir.model.r5.String as R5String
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

internal object ProductShelfLifeSerializer : KSerializer<ProductShelfLife> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProductShelfLife") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("periodDuration", Duration.serializer().descriptor, isOptional = true)
      element("periodString", KotlinString.serializer().descriptor, isOptional = true)
      element("_periodString", Element.serializer().descriptor, isOptional = true)
      element(
        "specialPrecautionsForStorage",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ProductShelfLife =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ProductShelfLife) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ProductShelfLife {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var periodDuration: Duration? = null
    var periodString: KotlinString? = null
    var _periodString: Element? = null
    var specialPrecautionsForStorage: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          periodDuration =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.periodDurationSer, null)
        5 -> periodString = decoder.decodeStringElement(__desc, 5)
        6 ->
          _periodString =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.periodStringSer, null)
        7 ->
          specialPrecautionsForStorage =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.specialPrecautionsForStorageSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProductShelfLife: " + __i)
      }
    }
    return ProductShelfLife(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      period =
        ProductShelfLife.Period.from(periodDuration, R5String.of(periodString, _periodString)),
      specialPrecautionsForStorage = specialPrecautionsForStorage ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ProductShelfLife) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.period) {
      null -> {}
      is ProductShelfLife.Period.Duration -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.periodDurationSer, __d.value)
      }
      is ProductShelfLife.Period.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.periodStringSer, it)
        }
      }
    }
    if (value.specialPrecautionsForStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.specialPrecautionsForStorageSer,
        value.specialPrecautionsForStorage,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodDurationSer: KSerializer<Duration> = Duration.serializer()

    public val periodStringSer: KSerializer<Element> = Element.serializer()

    public val specialPrecautionsForStorageSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)
  }
}
