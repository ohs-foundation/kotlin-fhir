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
import dev.ohs.fhir.model.r4.MedicinalProductIndication
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Population
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
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

internal object MedicinalProductIndicationOtherTherapySerializer :
  KSerializer<MedicinalProductIndication.OtherTherapy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OtherTherapy") {
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
      element("therapyRelationshipType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "medicationCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("medicationReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicinalProductIndication.OtherTherapy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIndication.OtherTherapy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductIndication.OtherTherapy {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var therapyRelationshipType: CodeableConcept? = null
    var medicationCodeableConcept: CodeableConcept? = null
    var medicationReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          therapyRelationshipType =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.therapyRelationshipTypeSer,
              null,
            )
        4 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.therapyRelationshipTypeSer,
              null,
            )
        5 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.medicationReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OtherTherapy: " + __i)
      }
    }
    return MedicinalProductIndication.OtherTherapy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      therapyRelationshipType = therapyRelationshipType!!,
      medication =
        MedicinalProductIndication.OtherTherapy.Medication.from(
          medicationCodeableConcept,
          medicationReference,
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIndication.OtherTherapy,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.therapyRelationshipType)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.therapyRelationshipTypeSer, it)
    }
    when (val __d = value.medication) {
      null -> {}
      is MedicinalProductIndication.OtherTherapy.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.therapyRelationshipTypeSer, __d.value)
      }
      is MedicinalProductIndication.OtherTherapy.Medication.Reference -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.medicationReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val therapyRelationshipTypeSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val medicationReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MedicinalProductIndicationSerializer : KSerializer<MedicinalProductIndication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductIndication") {
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
    b.element("diseaseSymptomProcedure", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("diseaseStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "comorbidity",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("intendedEffect", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("duration", Quantity.serializer().descriptor, isOptional = true)
    b.element(
      "otherTherapy",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductIndication.OtherTherapy.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "undesirableEffect",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "population",
      listSerialDescriptor(Population.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIndication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIndication) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductIndication")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicinalProductIndication {
    val __desc = descriptor
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
    var diseaseSymptomProcedure: CodeableConcept? = null
    var diseaseStatus: CodeableConcept? = null
    var comorbidity: List<CodeableConcept>? = null
    var intendedEffect: CodeableConcept? = null
    var duration: Quantity? = null
    var otherTherapy: List<MedicinalProductIndication.OtherTherapy>? = null
    var undesirableEffect: List<Reference>? = null
    var population: List<Population>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.subjectSer, null)
        12 ->
          diseaseSymptomProcedure =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        13 ->
          diseaseStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        14 ->
          comorbidity =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.comorbiditySer, null)
        15 ->
          intendedEffect =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        16 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.durationSer, null)
        17 ->
          otherTherapy =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.otherTherapySer, null)
        18 ->
          undesirableEffect =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.populationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductIndication: " + __i
          )
      }
    }
    return MedicinalProductIndication(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      subject = subject ?: listOf(),
      diseaseSymptomProcedure = diseaseSymptomProcedure,
      diseaseStatus = diseaseStatus,
      comorbidity = comorbidity ?: listOf(),
      intendedEffect = intendedEffect,
      duration = duration,
      otherTherapy = otherTherapy ?: listOf(),
      undesirableEffect = undesirableEffect ?: listOf(),
      population = population ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProductIndication) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.subjectSer, value.subject)
    (value.diseaseSymptomProcedure)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.diseaseSymptomProcedureSer, it)
    }
    (value.diseaseStatus)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.diseaseSymptomProcedureSer, it)
    }
    if (value.comorbidity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.comorbiditySer, value.comorbidity)
    (value.intendedEffect)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.diseaseSymptomProcedureSer, it)
    }
    (value.duration)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.durationSer, it) }
    if (value.otherTherapy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.otherTherapySer, value.otherTherapy)
    if (value.undesirableEffect.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, value.undesirableEffect)
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.populationSer, value.population)
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

    public val diseaseSymptomProcedureSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val comorbiditySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.diseaseSymptomProcedureSer)

    public val durationSer: KSerializer<Quantity> = Quantity.serializer()

    public val otherTherapySerInner: KSerializer<MedicinalProductIndication.OtherTherapy> =
      MedicinalProductIndication.OtherTherapy.serializer()

    public val otherTherapySer: KSerializer<List<MedicinalProductIndication.OtherTherapy>> =
      ListSerializer(Hoisted.otherTherapySerInner)

    public val populationSerInner: KSerializer<Population> = Population.serializer()

    public val populationSer: KSerializer<List<Population>> =
      ListSerializer(Hoisted.populationSerInner)
  }
}

internal object MedicinalProductIndicationPolymorphicSerializer :
  KSerializer<MedicinalProductIndication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductIndication") {
      MedicinalProductIndicationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIndication) {
    encoder.encodeStructure(descriptor) {
      MedicinalProductIndicationSerializer.serializeJson(this, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIndication =
    decoder.decodeStructure(descriptor) {
      MedicinalProductIndicationSerializer.deserializeJson(this)
    }
}
