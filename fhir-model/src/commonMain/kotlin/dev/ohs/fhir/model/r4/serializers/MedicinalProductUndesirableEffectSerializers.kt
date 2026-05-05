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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.MedicinalProductUndesirableEffect
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Population
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object MedicinalProductUndesirableEffectSerializer :
  KSerializer<MedicinalProductUndesirableEffect> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductUndesirableEffect") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("symptomConditionEffect", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("classification", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("frequencyOfOccurrence", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "population",
      listSerialDescriptor(Population.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductUndesirableEffect =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductUndesirableEffect) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductUndesirableEffect")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): MedicinalProductUndesirableEffect {
    val __desc = desc
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var subject: List<Reference>? = null
    var symptomConditionEffect: CodeableConcept? = null
    var classification: CodeableConcept? = null
    var frequencyOfOccurrence: CodeableConcept? = null
    var population: List<Population>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        11 ->
          symptomConditionEffect =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.symptomConditionEffectSer,
              null,
            )
        12 ->
          classification =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.symptomConditionEffectSer,
              null,
            )
        13 ->
          frequencyOfOccurrence =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.symptomConditionEffectSer,
              null,
            )
        14 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.populationSer, null)
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductUndesirableEffect: " + __i
          )
      }
    }
    return MedicinalProductUndesirableEffect(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      subject = subject ?: listOf(),
      symptomConditionEffect = symptomConditionEffect,
      classification = classification,
      frequencyOfOccurrence = frequencyOfOccurrence,
      population = population ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: MedicinalProductUndesirableEffect,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.subjectSer, value.subject)
    (value.symptomConditionEffect)?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.symptomConditionEffectSer, it)
    }
    (value.classification)?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.symptomConditionEffectSer, it)
    }
    (value.frequencyOfOccurrence)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.symptomConditionEffectSer, it)
    }
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.populationSer, value.population)
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val subjectSerInner: KSerializer<Reference> = Reference.serializer()

    public val subjectSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSerInner)

    public val symptomConditionEffectSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val populationSerInner: KSerializer<Population> = Population.serializer()

    public val populationSer: KSerializer<List<Population>> =
      ListSerializer(Hoisted.populationSerInner)
  }
}

internal object MedicinalProductUndesirableEffectPolymorphicSerializer :
  KSerializer<MedicinalProductUndesirableEffect> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductUndesirableEffect") {
      MedicinalProductUndesirableEffectSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductUndesirableEffect) {
    encoder.encodeStructure(descriptor) {
      MedicinalProductUndesirableEffectSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductUndesirableEffect =
    decoder.decodeStructure(descriptor) {
      MedicinalProductUndesirableEffectSerializer.deserializeJson(this, descriptor, 0)
    }
}
