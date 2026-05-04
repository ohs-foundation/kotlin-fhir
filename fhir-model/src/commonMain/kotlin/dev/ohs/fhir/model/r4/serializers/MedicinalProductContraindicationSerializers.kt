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
import dev.ohs.fhir.model.r4.MedicinalProductContraindication
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Population
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
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object MedicinalProductContraindicationOtherTherapySerializer :
  KSerializer<MedicinalProductContraindication.OtherTherapy> {
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

  override fun deserialize(decoder: Decoder): MedicinalProductContraindication.OtherTherapy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductContraindication.OtherTherapy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductContraindication.OtherTherapy {
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
    return MedicinalProductContraindication.OtherTherapy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      therapyRelationshipType = therapyRelationshipType!!,
      medication =
        MedicinalProductContraindication.OtherTherapy.Medication.from(
          medicationCodeableConcept,
          medicationReference,
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductContraindication.OtherTherapy,
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
      is MedicinalProductContraindication.OtherTherapy.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.therapyRelationshipTypeSer, __d.value)
      }
      is MedicinalProductContraindication.OtherTherapy.Medication.Reference -> {
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

internal object MedicinalProductContraindicationSerializer :
  KSerializer<MedicinalProductContraindication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductContraindication") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("disease", CodeableConcept.serializer().descriptor, isOptional = true)
      element("diseaseStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "comorbidity",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "therapeuticIndication",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "otherTherapy",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductContraindication.OtherTherapy.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "population",
        listSerialDescriptor(Population.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicinalProductContraindication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductContraindication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicinalProductContraindication {
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
    var disease: CodeableConcept? = null
    var diseaseStatus: CodeableConcept? = null
    var comorbidity: List<CodeableConcept>? = null
    var therapeuticIndication: List<Reference>? = null
    var otherTherapy: List<MedicinalProductContraindication.OtherTherapy>? = null
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
          disease = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.diseaseSer, null)
        13 ->
          diseaseStatus =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.diseaseSer, null)
        14 ->
          comorbidity =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.comorbiditySer, null)
        15 ->
          therapeuticIndication =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.subjectSer, null)
        16 ->
          otherTherapy =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.otherTherapySer, null)
        17 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.populationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductContraindication: " + __i
          )
      }
    }
    return MedicinalProductContraindication(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      subject = subject ?: listOf(),
      disease = disease,
      diseaseStatus = diseaseStatus,
      comorbidity = comorbidity ?: listOf(),
      therapeuticIndication = therapeuticIndication ?: listOf(),
      otherTherapy = otherTherapy ?: listOf(),
      population = population ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProductContraindication) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MedicinalProductContraindication")
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
    (value.disease)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.diseaseSer, it) }
    (value.diseaseStatus)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.diseaseSer, it)
    }
    if (value.comorbidity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.comorbiditySer, value.comorbidity)
    if (value.therapeuticIndication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.subjectSer, value.therapeuticIndication)
    if (value.otherTherapy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.otherTherapySer, value.otherTherapy)
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.populationSer, value.population)
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

    public val diseaseSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val comorbiditySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.diseaseSer)

    public val otherTherapySerInner: KSerializer<MedicinalProductContraindication.OtherTherapy> =
      MedicinalProductContraindication.OtherTherapy.serializer()

    public val otherTherapySer: KSerializer<List<MedicinalProductContraindication.OtherTherapy>> =
      ListSerializer(Hoisted.otherTherapySerInner)

    public val populationSerInner: KSerializer<Population> = Population.serializer()

    public val populationSer: KSerializer<List<Population>> =
      ListSerializer(Hoisted.populationSerInner)
  }
}
