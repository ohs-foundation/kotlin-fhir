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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Population
import dev.ohs.fhir.model.r4b.Range
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Population) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Population {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var ageRange: Range? = null
    var ageCodeableConcept: CodeableConcept? = null
    var gender: CodeableConcept? = null
    var race: CodeableConcept? = null
    var physiologicalCondition: CodeableConcept? = null
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
          ageRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageRangeSer, null)
        4 ->
          ageCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.ageCodeableConceptSer,
              null,
            )
        5 ->
          gender =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.ageCodeableConceptSer,
              null,
            )
        6 ->
          race =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.ageCodeableConceptSer,
              null,
            )
        7 ->
          physiologicalCondition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.ageCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Population) {
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
    when (val choice = value.age) {
      null -> {}
      is Population.Age.Range -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.ageRangeSer, choice.value)
      }
      is Population.Age.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.ageCodeableConceptSer,
          choice.value,
        )
      }
    }
    (value.gender)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.ageCodeableConceptSer, it)
    }
    (value.race)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.ageCodeableConceptSer, it)
    }
    (value.physiologicalCondition)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.ageCodeableConceptSer, it)
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
