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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Dosage
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MedicationKnowledge
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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

internal object MedicationKnowledgeRelatedMedicationKnowledgeSerializer :
  KSerializer<MedicationKnowledge.RelatedMedicationKnowledge> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedMedicationKnowledge") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.RelatedMedicationKnowledge>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.RelatedMedicationKnowledge =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var reference: List<Reference>? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            reference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException(
              "Unexpected index decoding RelatedMedicationKnowledge: " + i
            )
        }
      }
      MedicationKnowledge.RelatedMedicationKnowledge(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.RelatedMedicationKnowledge"
            ),
        reference = reference ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.RelatedMedicationKnowledge,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      if (value.reference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ReferenceSerializer.listSerializer,
          value.reference,
        )
    }
  }
}

internal object MedicationKnowledgeMonographSerializer :
  KSerializer<MedicationKnowledge.Monograph> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Monograph") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Monograph>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Monograph =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var source: Reference? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> source = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Monograph: " + i)
        }
      }
      MedicationKnowledge.Monograph(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        source = source,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Monograph) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.source)
    }
  }
}

internal object MedicationKnowledgeCostSerializer : KSerializer<MedicationKnowledge.Cost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Cost") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("effectiveDate", PeriodSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("source", KotlinString.serializer().descriptor)
      optionalElement("_source", ElementSerializer.descriptor)
      optionalElement("costMoney", MoneySerializer.descriptor)
      optionalElement("costCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Cost>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Cost =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var effectiveDate: List<Period>? = null
      var type: CodeableConcept? = null
      var source: KotlinString? = null
      var _source: Element? = null
      var costMoney: Money? = null
      var costCodeableConcept: CodeableConcept? = null
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
          3 ->
            effectiveDate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PeriodSerializer.listSerializer,
                null,
              )
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> source = decodeStringElement(descriptor, i)
          6 -> _source = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> costMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          8 ->
            costCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Cost: " + i)
        }
      }
      MedicationKnowledge.Cost(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        effectiveDate = effectiveDate ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.Cost"
            ),
        source = R5String.of(source, _source),
        cost =
          MedicationKnowledge.Cost.Cost.from(costMoney, costCodeableConcept)
            ?: throw SerializationException(
              "Missing required property 'cost' on MedicationKnowledge.Cost"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Cost) {
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
      if (value.effectiveDate.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          PeriodSerializer.listSerializer,
          value.effectiveDate,
        )
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 5, value.source?.value)
      encodeElementIfNotNull(descriptor, 6, value.source)
      when (val choice = value.cost) {
        is MedicationKnowledge.Cost.Cost.Money -> {
          encodeSerializableElement(descriptor, 7, MoneySerializer, choice.value)
        }
        is MedicationKnowledge.Cost.Cost.CodeableConcept -> {
          encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
        }
      }
    }
  }
}

internal object MedicationKnowledgeMonitoringProgramSerializer :
  KSerializer<MedicationKnowledge.MonitoringProgram> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MonitoringProgram") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.MonitoringProgram>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.MonitoringProgram =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var name: KotlinString? = null
      var _name: Element? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> name = decodeStringElement(descriptor, i)
          5 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MonitoringProgram: " + i)
        }
      }
      MedicationKnowledge.MonitoringProgram(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        name = R5String.of(name, _name),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MonitoringProgram) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.name?.value)
      encodeElementIfNotNull(descriptor, 5, value.name)
    }
  }
}

internal object MedicationKnowledgeIndicationGuidelineSerializer :
  KSerializer<MedicationKnowledge.IndicationGuideline> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("IndicationGuideline") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("indication", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "dosingGuideline",
        MedicationKnowledgeIndicationGuidelineDosingGuidelineSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.IndicationGuideline>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.IndicationGuideline =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var indication: List<CodeableReference>? = null
      var dosingGuideline: List<MedicationKnowledge.IndicationGuideline.DosingGuideline>? = null
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
          3 ->
            indication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            dosingGuideline =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeIndicationGuidelineDosingGuidelineSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding IndicationGuideline: " + i)
        }
      }
      MedicationKnowledge.IndicationGuideline(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        indication = indication ?: listOf(),
        dosingGuideline = dosingGuideline ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.IndicationGuideline) {
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
      if (value.indication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableReferenceSerializer.listSerializer,
          value.indication,
        )
      if (value.dosingGuideline.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          MedicationKnowledgeIndicationGuidelineDosingGuidelineSerializer.listSerializer,
          value.dosingGuideline,
        )
    }
  }
}

internal object MedicationKnowledgeIndicationGuidelineDosingGuidelineSerializer :
  KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DosingGuideline") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("treatmentIntent", CodeableConceptSerializer.descriptor)
      optionalElement(
        "dosage",
        MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSerializer.listSerializer
          .descriptor,
      )
      optionalElement("administrationTreatment", CodeableConceptSerializer.descriptor)
      optionalElement(
        "patientCharacteristic",
        MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSerializer
          .listSerializer
          .descriptor,
      )
    }

  internal val listSerializer:
    KSerializer<List<MedicationKnowledge.IndicationGuideline.DosingGuideline>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var treatmentIntent: CodeableConcept? = null
      var dosage: List<MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage>? = null
      var administrationTreatment: CodeableConcept? = null
      var patientCharacteristic:
        List<MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic>? =
        null
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
          3 ->
            treatmentIntent =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            dosage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSerializer
                  .listSerializer,
                null,
              )
          5 ->
            administrationTreatment =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            patientCharacteristic =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSerializer
                  .listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DosingGuideline: " + i)
        }
      }
      MedicationKnowledge.IndicationGuideline.DosingGuideline(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        treatmentIntent = treatmentIntent,
        dosage = dosage ?: listOf(),
        administrationTreatment = administrationTreatment,
        patientCharacteristic = patientCharacteristic ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.treatmentIntent)
      if (value.dosage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSerializer.listSerializer,
          value.dosage,
        )
      encodeSerializableIfNotNull(
        descriptor,
        5,
        CodeableConceptSerializer,
        value.administrationTreatment,
      )
      if (value.patientCharacteristic.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSerializer
            .listSerializer,
          value.patientCharacteristic,
        )
    }
  }
}

internal object MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSerializer :
  KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("dosage", DosageSerializer.listSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var dosage: List<Dosage>? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            dosage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DosageSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Dosage: " + i)
        }
      }
      MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage"
            ),
        dosage = dosage ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      if (value.dosage.isNotEmpty())
        encodeSerializableElement(descriptor, 4, DosageSerializer.listSerializer, value.dosage)
    }
  }
}

internal object MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSerializer :
  KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PatientCharacteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<
      List<MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic>
    > =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueRange: Range? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding PatientCharacteristic: " + i)
        }
      }
      MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic"
            ),
        `value` =
          MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.from(
            valueCodeableConcept,
            valueQuantity,
            valueRange,
          ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        null -> {}
        is MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.Quantity -> {
          encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
        }
        is MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.Range -> {
          encodeSerializableElement(descriptor, 6, RangeSerializer, choice.value)
        }
      }
    }
  }
}

internal object MedicationKnowledgeMedicineClassificationSerializer :
  KSerializer<MedicationKnowledge.MedicineClassification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicineClassification") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("sourceString", KotlinString.serializer().descriptor)
      optionalElement("_sourceString", ElementSerializer.descriptor)
      optionalElement("sourceUri", KotlinString.serializer().descriptor)
      optionalElement("_sourceUri", ElementSerializer.descriptor)
      optionalElement("classification", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.MedicineClassification>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.MedicineClassification =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var sourceString: KotlinString? = null
      var _sourceString: Element? = null
      var sourceUri: KotlinString? = null
      var _sourceUri: Element? = null
      var classification: List<CodeableConcept>? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> sourceString = decodeStringElement(descriptor, i)
          5 ->
            _sourceString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> sourceUri = decodeStringElement(descriptor, i)
          7 ->
            _sourceUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            classification =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding MedicineClassification: " + i)
        }
      }
      MedicationKnowledge.MedicineClassification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.MedicineClassification"
            ),
        source =
          MedicationKnowledge.MedicineClassification.Source.from(
            R5String.of(sourceString, _sourceString),
            Uri.of(sourceUri, _sourceUri),
          ),
        classification = classification ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MedicineClassification) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.source) {
        null -> {}
        is MedicationKnowledge.MedicineClassification.Source.String -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is MedicationKnowledge.MedicineClassification.Source.Uri -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
      }
      if (value.classification.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.classification,
        )
    }
  }
}

internal object MedicationKnowledgePackagingSerializer :
  KSerializer<MedicationKnowledge.Packaging> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Packaging") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "cost",
        listSerialDescriptor(lazyDescriptor { MedicationKnowledgeCostSerializer.descriptor }),
      )
      optionalElement("packagedProduct", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Packaging>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Packaging =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var cost: List<MedicationKnowledge.Cost>? = null
      var packagedProduct: Reference? = null
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
          3 ->
            cost =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeCostSerializer.listSerializer,
                null,
              )
          4 ->
            packagedProduct =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Packaging: " + i)
        }
      }
      MedicationKnowledge.Packaging(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        cost = cost ?: listOf(),
        packagedProduct = packagedProduct,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Packaging) {
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
      if (value.cost.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          MedicationKnowledgeCostSerializer.listSerializer,
          value.cost,
        )
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.packagedProduct)
    }
  }
}

internal object MedicationKnowledgeStorageGuidelineSerializer :
  KSerializer<MedicationKnowledge.StorageGuideline> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StorageGuideline") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", KotlinString.serializer().descriptor)
      optionalElement("_reference", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("stabilityDuration", DurationSerializer.descriptor)
      optionalElement(
        "environmentalSetting",
        MedicationKnowledgeStorageGuidelineEnvironmentalSettingSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.StorageGuideline>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.StorageGuideline =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var reference: KotlinString? = null
      var _reference: Element? = null
      var note: List<Annotation>? = null
      var stabilityDuration: Duration? = null
      var environmentalSetting: List<MedicationKnowledge.StorageGuideline.EnvironmentalSetting>? =
        null
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
          3 -> reference = decodeStringElement(descriptor, i)
          4 ->
            _reference = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          6 ->
            stabilityDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          7 ->
            environmentalSetting =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeStorageGuidelineEnvironmentalSettingSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding StorageGuideline: " + i)
        }
      }
      MedicationKnowledge.StorageGuideline(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        reference = Uri.of(reference, _reference),
        note = note ?: listOf(),
        stabilityDuration = stabilityDuration,
        environmentalSetting = environmentalSetting ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.StorageGuideline) {
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
      encodeStringIfNotNull(descriptor, 3, value.reference?.value)
      encodeElementIfNotNull(descriptor, 4, value.reference)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 5, AnnotationSerializer.listSerializer, value.note)
      encodeSerializableIfNotNull(descriptor, 6, DurationSerializer, value.stabilityDuration)
      if (value.environmentalSetting.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          MedicationKnowledgeStorageGuidelineEnvironmentalSettingSerializer.listSerializer,
          value.environmentalSetting,
        )
    }
  }
}

internal object MedicationKnowledgeStorageGuidelineEnvironmentalSettingSerializer :
  KSerializer<MedicationKnowledge.StorageGuideline.EnvironmentalSetting> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EnvironmentalSetting") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MedicationKnowledge.StorageGuideline.EnvironmentalSetting>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.StorageGuideline.EnvironmentalSetting =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueRange: Range? = null
      var valueCodeableConcept: CodeableConcept? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          6 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding EnvironmentalSetting: " + i)
        }
      }
      MedicationKnowledge.StorageGuideline.EnvironmentalSetting(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.StorageGuideline.EnvironmentalSetting"
            ),
        `value` =
          MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.from(
            valueQuantity,
            valueRange,
            valueCodeableConcept,
          )
            ?: throw SerializationException(
              "Missing required property 'value' on MedicationKnowledge.StorageGuideline.EnvironmentalSetting"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.StorageGuideline.EnvironmentalSetting,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        is MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.Range -> {
          encodeSerializableElement(descriptor, 5, RangeSerializer, choice.value)
        }
        is MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
      }
    }
  }
}

internal object MedicationKnowledgeRegulatorySerializer :
  KSerializer<MedicationKnowledge.Regulatory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Regulatory") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("regulatoryAuthority", ReferenceSerializer.descriptor)
      optionalElement(
        "substitution",
        MedicationKnowledgeRegulatorySubstitutionSerializer.listSerializer.descriptor,
      )
      optionalElement("schedule", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("maxDispense", MedicationKnowledgeRegulatoryMaxDispenseSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Regulatory>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var regulatoryAuthority: Reference? = null
      var substitution: List<MedicationKnowledge.Regulatory.Substitution>? = null
      var schedule: List<CodeableConcept>? = null
      var maxDispense: MedicationKnowledge.Regulatory.MaxDispense? = null
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
          3 ->
            regulatoryAuthority =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            substitution =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeRegulatorySubstitutionSerializer.listSerializer,
                null,
              )
          5 ->
            schedule =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            maxDispense =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeRegulatoryMaxDispenseSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Regulatory: " + i)
        }
      }
      MedicationKnowledge.Regulatory(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        regulatoryAuthority =
          regulatoryAuthority
            ?: throw SerializationException(
              "Missing required property 'regulatoryAuthority' on MedicationKnowledge.Regulatory"
            ),
        substitution = substitution ?: listOf(),
        schedule = schedule ?: listOf(),
        maxDispense = maxDispense,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.regulatoryAuthority)
      if (value.substitution.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          MedicationKnowledgeRegulatorySubstitutionSerializer.listSerializer,
          value.substitution,
        )
      if (value.schedule.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.schedule,
        )
      encodeSerializableIfNotNull(
        descriptor,
        6,
        MedicationKnowledgeRegulatoryMaxDispenseSerializer,
        value.maxDispense,
      )
    }
  }
}

internal object MedicationKnowledgeRegulatorySubstitutionSerializer :
  KSerializer<MedicationKnowledge.Regulatory.Substitution> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substitution") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("allowed", KotlinBoolean.serializer().descriptor)
      optionalElement("_allowed", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Regulatory.Substitution>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.Substitution =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var allowed: KotlinBoolean? = null
      var _allowed: Element? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> allowed = decodeBooleanElement(descriptor, i)
          5 -> _allowed = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Substitution: " + i)
        }
      }
      MedicationKnowledge.Regulatory.Substitution(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.Regulatory.Substitution"
            ),
        allowed =
          R5Boolean.of(allowed, _allowed)
            ?: throw SerializationException(
              "Missing required property 'allowed' on MedicationKnowledge.Regulatory.Substitution"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Substitution) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeBooleanIfNotNull(descriptor, 4, value.allowed.value)
      encodeElementIfNotNull(descriptor, 5, value.allowed)
    }
  }
}

internal object MedicationKnowledgeRegulatoryMaxDispenseSerializer :
  KSerializer<MedicationKnowledge.Regulatory.MaxDispense> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MaxDispense") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("period", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Regulatory.MaxDispense>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.MaxDispense =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var quantity: Quantity? = null
      var period: Duration? = null
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
          3 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          4 -> period = decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MaxDispense: " + i)
        }
      }
      MedicationKnowledge.Regulatory.MaxDispense(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        quantity =
          quantity
            ?: throw SerializationException(
              "Missing required property 'quantity' on MedicationKnowledge.Regulatory.MaxDispense"
            ),
        period = period,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.MaxDispense) {
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
      encodeSerializableElement(descriptor, 3, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 4, DurationSerializer, value.period)
    }
  }
}

internal object MedicationKnowledgeDefinitionalSerializer :
  KSerializer<MedicationKnowledge.Definitional> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Definitional") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("definition", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("doseForm", CodeableConceptSerializer.descriptor)
      optionalElement("intendedRoute", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "ingredient",
        MedicationKnowledgeDefinitionalIngredientSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "drugCharacteristic",
        MedicationKnowledgeDefinitionalDrugCharacteristicSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Definitional>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Definitional =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var definition: List<Reference>? = null
      var doseForm: CodeableConcept? = null
      var intendedRoute: List<CodeableConcept>? = null
      var ingredient: List<MedicationKnowledge.Definitional.Ingredient>? = null
      var drugCharacteristic: List<MedicationKnowledge.Definitional.DrugCharacteristic>? = null
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
          3 ->
            definition =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            doseForm =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            intendedRoute =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            ingredient =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeDefinitionalIngredientSerializer.listSerializer,
                null,
              )
          7 ->
            drugCharacteristic =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeDefinitionalDrugCharacteristicSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Definitional: " + i)
        }
      }
      MedicationKnowledge.Definitional(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        definition = definition ?: listOf(),
        doseForm = doseForm,
        intendedRoute = intendedRoute ?: listOf(),
        ingredient = ingredient ?: listOf(),
        drugCharacteristic = drugCharacteristic ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Definitional) {
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
      if (value.definition.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ReferenceSerializer.listSerializer,
          value.definition,
        )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.doseForm)
      if (value.intendedRoute.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.intendedRoute,
        )
      if (value.ingredient.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MedicationKnowledgeDefinitionalIngredientSerializer.listSerializer,
          value.ingredient,
        )
      if (value.drugCharacteristic.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          MedicationKnowledgeDefinitionalDrugCharacteristicSerializer.listSerializer,
          value.drugCharacteristic,
        )
    }
  }
}

internal object MedicationKnowledgeDefinitionalIngredientSerializer :
  KSerializer<MedicationKnowledge.Definitional.Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("item", CodeableReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("strengthRatio", RatioSerializer.descriptor)
      optionalElement("strengthCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("strengthQuantity", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Definitional.Ingredient>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Definitional.Ingredient =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var item: CodeableReference? = null
      var type: CodeableConcept? = null
      var strengthRatio: Ratio? = null
      var strengthCodeableConcept: CodeableConcept? = null
      var strengthQuantity: Quantity? = null
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
          3 ->
            item =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            strengthRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          6 ->
            strengthCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            strengthQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
        }
      }
      MedicationKnowledge.Definitional.Ingredient(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item =
          item
            ?: throw SerializationException(
              "Missing required property 'item' on MedicationKnowledge.Definitional.Ingredient"
            ),
        type = type,
        strength =
          MedicationKnowledge.Definitional.Ingredient.Strength.from(
            strengthRatio,
            strengthCodeableConcept,
            strengthQuantity,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Definitional.Ingredient) {
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
      encodeSerializableElement(descriptor, 3, CodeableReferenceSerializer, value.item)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      when (val choice = value.strength) {
        null -> {}
        is MedicationKnowledge.Definitional.Ingredient.Strength.Ratio -> {
          encodeSerializableElement(descriptor, 5, RatioSerializer, choice.value)
        }
        is MedicationKnowledge.Definitional.Ingredient.Strength.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
        is MedicationKnowledge.Definitional.Ingredient.Strength.Quantity -> {
          encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
        }
      }
    }
  }
}

internal object MedicationKnowledgeDefinitionalDrugCharacteristicSerializer :
  KSerializer<MedicationKnowledge.Definitional.DrugCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DrugCharacteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_valueBase64Binary", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MedicationKnowledge.Definitional.DrugCharacteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Definitional.DrugCharacteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueString: KotlinString? = null
      var _valueString: Element? = null
      var valueQuantity: Quantity? = null
      var valueBase64Binary: KotlinString? = null
      var _valueBase64Binary: Element? = null
      var valueAttachment: Attachment? = null
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> valueString = decodeStringElement(descriptor, i)
          6 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          8 -> valueBase64Binary = decodeStringElement(descriptor, i)
          9 ->
            _valueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DrugCharacteristic: " + i)
        }
      }
      MedicationKnowledge.Definitional.DrugCharacteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        `value` =
          MedicationKnowledge.Definitional.DrugCharacteristic.Value.from(
            valueCodeableConcept,
            R5String.of(valueString, _valueString),
            valueQuantity,
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
            valueAttachment,
          ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.Definitional.DrugCharacteristic,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        null -> {}
        is MedicationKnowledge.Definitional.DrugCharacteristic.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is MedicationKnowledge.Definitional.DrugCharacteristic.Value.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is MedicationKnowledge.Definitional.DrugCharacteristic.Value.Quantity -> {
          encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
        }
        is MedicationKnowledge.Definitional.DrugCharacteristic.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is MedicationKnowledge.Definitional.DrugCharacteristic.Value.Attachment -> {
          encodeSerializableElement(descriptor, 10, AttachmentSerializer, choice.value)
        }
      }
    }
  }
}

internal object MedicationKnowledgeSerializer : FhirResourceSerializer<MedicationKnowledge> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicationKnowledge")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
    b.optionalElement("intendedJurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("name", stringNullableListSerializer.descriptor)
    b.optionalElement("_name", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement(
      "relatedMedicationKnowledge",
      MedicationKnowledgeRelatedMedicationKnowledgeSerializer.listSerializer.descriptor,
    )
    b.optionalElement("associatedMedication", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("productType", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("monograph", MedicationKnowledgeMonographSerializer.listSerializer.descriptor)
    b.optionalElement("preparationInstruction", KotlinString.serializer().descriptor)
    b.optionalElement("_preparationInstruction", ElementSerializer.descriptor)
    b.optionalElement("cost", MedicationKnowledgeCostSerializer.listSerializer.descriptor)
    b.optionalElement(
      "monitoringProgram",
      MedicationKnowledgeMonitoringProgramSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "indicationGuideline",
      MedicationKnowledgeIndicationGuidelineSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "medicineClassification",
      MedicationKnowledgeMedicineClassificationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("packaging", MedicationKnowledgePackagingSerializer.listSerializer.descriptor)
    b.optionalElement("clinicalUseIssue", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "storageGuideline",
      MedicationKnowledgeStorageGuidelineSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "regulatory",
      MedicationKnowledgeRegulatorySerializer.listSerializer.descriptor,
    )
    b.optionalElement("definitional", MedicationKnowledgeDefinitionalSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationKnowledge {
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var code: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var author: Reference? = null
    var intendedJurisdiction: List<CodeableConcept>? = null
    var name: List<KotlinString?>? = null
    var _name: List<Element?>? = null
    var relatedMedicationKnowledge: List<MedicationKnowledge.RelatedMedicationKnowledge>? = null
    var associatedMedication: List<Reference>? = null
    var productType: List<CodeableConcept>? = null
    var monograph: List<MedicationKnowledge.Monograph>? = null
    var preparationInstruction: KotlinString? = null
    var _preparationInstruction: Element? = null
    var cost: List<MedicationKnowledge.Cost>? = null
    var monitoringProgram: List<MedicationKnowledge.MonitoringProgram>? = null
    var indicationGuideline: List<MedicationKnowledge.IndicationGuideline>? = null
    var medicineClassification: List<MedicationKnowledge.MedicineClassification>? = null
    var packaging: List<MedicationKnowledge.Packaging>? = null
    var clinicalUseIssue: List<Reference>? = null
    var storageGuideline: List<MedicationKnowledge.StorageGuideline>? = null
    var regulatory: List<MedicationKnowledge.Regulatory>? = null
    var definitional: MedicationKnowledge.Definitional? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        15 ->
          intendedJurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          relatedMedicationKnowledge =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeRelatedMedicationKnowledgeSerializer.listSerializer,
              null,
            )
        19 ->
          associatedMedication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          productType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        21 ->
          monograph =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeMonographSerializer.listSerializer,
              null,
            )
        22 -> preparationInstruction = decoder.decodeStringElement(descriptor, i)
        23 ->
          _preparationInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          cost =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeCostSerializer.listSerializer,
              null,
            )
        25 ->
          monitoringProgram =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeMonitoringProgramSerializer.listSerializer,
              null,
            )
        26 ->
          indicationGuideline =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeIndicationGuidelineSerializer.listSerializer,
              null,
            )
        27 ->
          medicineClassification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeMedicineClassificationSerializer.listSerializer,
              null,
            )
        28 ->
          packaging =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgePackagingSerializer.listSerializer,
              null,
            )
        29 ->
          clinicalUseIssue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        30 ->
          storageGuideline =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeStorageGuidelineSerializer.listSerializer,
              null,
            )
        31 ->
          regulatory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeRegulatorySerializer.listSerializer,
              null,
            )
        32 ->
          definitional =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeDefinitionalSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MedicationKnowledge: " + i)
      }
    }
    return MedicationKnowledge(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      code = code,
      status =
        Enumeration.of(
          if (status != null) MedicationKnowledge.MedicationKnowledgeStatusCodes.fromCode(status)
          else null,
          _status,
        ),
      author = author,
      intendedJurisdiction = intendedJurisdiction ?: listOf(),
      name =
        (kotlin.collections.List(maxOf(name?.size ?: 0, _name?.size ?: 0)) { index ->
          R5String.of(name?.getOrNull(index), _name?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'name' on MedicationKnowledge has neither a value nor an id/extension"
            )
        }),
      relatedMedicationKnowledge = relatedMedicationKnowledge ?: listOf(),
      associatedMedication = associatedMedication ?: listOf(),
      productType = productType ?: listOf(),
      monograph = monograph ?: listOf(),
      preparationInstruction = Markdown.of(preparationInstruction, _preparationInstruction),
      cost = cost ?: listOf(),
      monitoringProgram = monitoringProgram ?: listOf(),
      indicationGuideline = indicationGuideline ?: listOf(),
      medicineClassification = medicineClassification ?: listOf(),
      packaging = packaging ?: listOf(),
      clinicalUseIssue = clinicalUseIssue ?: listOf(),
      storageGuideline = storageGuideline ?: listOf(),
      regulatory = regulatory ?: listOf(),
      definitional = definitional,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationKnowledge,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    if (value.intendedJurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.intendedJurisdiction,
      )
    if (value.name.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.name.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 17 + descriptorOffset, value.name)
    }
    if (value.relatedMedicationKnowledge.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        MedicationKnowledgeRelatedMedicationKnowledgeSerializer.listSerializer,
        value.relatedMedicationKnowledge,
      )
    if (value.associatedMedication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.associatedMedication,
      )
    if (value.productType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.productType,
      )
    if (value.monograph.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        MedicationKnowledgeMonographSerializer.listSerializer,
        value.monograph,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.preparationInstruction?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.preparationInstruction)
    if (value.cost.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        MedicationKnowledgeCostSerializer.listSerializer,
        value.cost,
      )
    if (value.monitoringProgram.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        MedicationKnowledgeMonitoringProgramSerializer.listSerializer,
        value.monitoringProgram,
      )
    if (value.indicationGuideline.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        MedicationKnowledgeIndicationGuidelineSerializer.listSerializer,
        value.indicationGuideline,
      )
    if (value.medicineClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        MedicationKnowledgeMedicineClassificationSerializer.listSerializer,
        value.medicineClassification,
      )
    if (value.packaging.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        MedicationKnowledgePackagingSerializer.listSerializer,
        value.packaging,
      )
    if (value.clinicalUseIssue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.clinicalUseIssue,
      )
    if (value.storageGuideline.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        MedicationKnowledgeStorageGuidelineSerializer.listSerializer,
        value.storageGuideline,
      )
    if (value.regulatory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        MedicationKnowledgeRegulatorySerializer.listSerializer,
        value.regulatory,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      MedicationKnowledgeDefinitionalSerializer,
      value.definitional,
    )
  }
}
