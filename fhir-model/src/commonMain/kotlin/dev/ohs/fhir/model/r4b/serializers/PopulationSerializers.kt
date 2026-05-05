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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Population
import dev.ohs.fhir.model.r4b.Range
import kotlin.String
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

internal object PopulationSerializer : KSerializer<Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("ageRange", Range.serializer().descriptor, isOptional = true)
      element("ageCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("gender", CodeableConcept.serializer().descriptor, isOptional = true)
      element("race", CodeableConcept.serializer().descriptor, isOptional = true)
      element("physiologicalCondition", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Population =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Population) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Population {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var ageRange: Range? = null
    var ageCodeableConcept: CodeableConcept? = null
    var gender: CodeableConcept? = null
    var race: CodeableConcept? = null
    var physiologicalCondition: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          ageRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ageRangeSer, null)
        4 ->
          ageCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.ageCodeableConceptSer,
              null,
            )
        5 ->
          gender =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.ageCodeableConceptSer,
              null,
            )
        6 ->
          race =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.ageCodeableConceptSer,
              null,
            )
        7 ->
          physiologicalCondition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.ageCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + __i)
      }
    }
    return Population(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      age = Population.Age.from(ageRange, ageCodeableConcept),
      gender = gender,
      race = race,
      physiologicalCondition = physiologicalCondition,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Population) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.age) {
      null -> {}
      is Population.Age.Range -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.ageRangeSer, __d.value)
      }
      is Population.Age.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.ageCodeableConceptSer, __d.value)
      }
    }
    (value.gender)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.ageCodeableConceptSer, it)
    }
    (value.race)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.ageCodeableConceptSer, it)
    }
    (value.physiologicalCondition)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.ageCodeableConceptSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val ageRangeSer: KSerializer<Range> = Range.serializer()

    public val ageCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}
