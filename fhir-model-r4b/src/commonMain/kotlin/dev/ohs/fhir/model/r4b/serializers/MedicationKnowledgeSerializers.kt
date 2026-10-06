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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.MedicationKnowledge
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object MedicationKnowledgeIngredientSerializer :
  KSerializer<MedicationKnowledge.Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("itemReference", ReferenceSerializer.descriptor)
      optionalElement("isActive", KotlinBoolean.serializer().descriptor)
      optionalElement("_isActive", ElementSerializer.descriptor)
      optionalElement("strength", RatioSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Ingredient>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Ingredient =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var itemCodeableConcept: CodeableConcept? = null
      var itemReference: Reference? = null
      var isActive: KotlinBoolean? = null
      var _isActive: Element? = null
      var strength: Ratio? = null
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
            itemCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            itemReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 -> isActive = decodeBooleanElement(descriptor, i)
          6 -> _isActive = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> strength = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
        }
      }
      MedicationKnowledge.Ingredient(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item =
          MedicationKnowledge.Ingredient.Item.from(itemCodeableConcept, itemReference)
            ?: throw SerializationException(
              "Missing required property 'item' on MedicationKnowledge.Ingredient"
            ),
        isActive = R4bBoolean.of(isActive, _isActive),
        strength = strength,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Ingredient) {
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
      when (val choice = value.item) {
        is MedicationKnowledge.Ingredient.Item.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is MedicationKnowledge.Ingredient.Item.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
      }
      encodeBooleanIfNotNull(descriptor, 5, value.isActive?.value)
      encodeElementIfNotNull(descriptor, 6, value.isActive)
      encodeSerializableIfNotNull(descriptor, 7, RatioSerializer, value.strength)
    }
  }
}

internal object MedicationKnowledgeCostSerializer : KSerializer<MedicationKnowledge.Cost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Cost") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("source", KotlinString.serializer().descriptor)
      optionalElement("_source", ElementSerializer.descriptor)
      optionalElement("cost", MoneySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Cost>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Cost =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var source: KotlinString? = null
      var _source: Element? = null
      var cost: Money? = null
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
          4 -> source = decodeStringElement(descriptor, i)
          5 -> _source = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> cost = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Cost: " + i)
        }
      }
      MedicationKnowledge.Cost(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.Cost"
            ),
        source = R4bString.of(source, _source),
        cost =
          cost
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.source?.value)
      encodeElementIfNotNull(descriptor, 5, value.source)
      encodeSerializableElement(descriptor, 6, MoneySerializer, value.cost)
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
        name = R4bString.of(name, _name),
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

internal object MedicationKnowledgeAdministrationGuidelinesSerializer :
  KSerializer<MedicationKnowledge.AdministrationGuidelines> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AdministrationGuidelines") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "dosage",
        MedicationKnowledgeAdministrationGuidelinesDosageSerializer.listSerializer.descriptor,
      )
      optionalElement("indicationCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("indicationReference", ReferenceSerializer.descriptor)
      optionalElement(
        "patientCharacteristics",
        MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer.listSerializer
          .descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.AdministrationGuidelines>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.AdministrationGuidelines =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var dosage: List<MedicationKnowledge.AdministrationGuidelines.Dosage>? = null
      var indicationCodeableConcept: CodeableConcept? = null
      var indicationReference: Reference? = null
      var patientCharacteristics:
        List<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics>? =
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
            dosage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeAdministrationGuidelinesDosageSerializer.listSerializer,
                null,
              )
          4 ->
            indicationCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            indicationReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 ->
            patientCharacteristics =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer
                  .listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding AdministrationGuidelines: " + i)
        }
      }
      MedicationKnowledge.AdministrationGuidelines(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        dosage = dosage ?: listOf(),
        indication =
          MedicationKnowledge.AdministrationGuidelines.Indication.from(
            indicationCodeableConcept,
            indicationReference,
          ),
        patientCharacteristics = patientCharacteristics ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.AdministrationGuidelines) {
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
      if (value.dosage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          MedicationKnowledgeAdministrationGuidelinesDosageSerializer.listSerializer,
          value.dosage,
        )
      when (val choice = value.indication) {
        null -> {}
        is MedicationKnowledge.AdministrationGuidelines.Indication.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is MedicationKnowledge.AdministrationGuidelines.Indication.Reference -> {
          encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
        }
      }
      if (value.patientCharacteristics.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer
            .listSerializer,
          value.patientCharacteristics,
        )
    }
  }
}

internal object MedicationKnowledgeAdministrationGuidelinesDosageSerializer :
  KSerializer<MedicationKnowledge.AdministrationGuidelines.Dosage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("dosage", DosageSerializer.listSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MedicationKnowledge.AdministrationGuidelines.Dosage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.AdministrationGuidelines.Dosage =
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
      MedicationKnowledge.AdministrationGuidelines.Dosage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicationKnowledge.AdministrationGuidelines.Dosage"
            ),
        dosage = dosage ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.Dosage,
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

internal object MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer :
  KSerializer<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PatientCharacteristics") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("characteristicCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("characteristicQuantity", QuantitySerializer.descriptor)
      optionalElement("value", stringNullableListSerializer.descriptor)
      optionalElement("_value", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var characteristicCodeableConcept: CodeableConcept? = null
      var characteristicQuantity: Quantity? = null
      var `value`: List<KotlinString?>? = null
      var _value: List<Element?>? = null
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
            characteristicCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            characteristicQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            `value` =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          6 ->
            _value =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding PatientCharacteristics: " + i)
        }
      }
      MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        characteristic =
          MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.from(
            characteristicCodeableConcept,
            characteristicQuantity,
          )
            ?: throw SerializationException(
              "Missing required property 'characteristic' on MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics"
            ),
        `value` =
          (kotlin.collections.List(maxOf(`value`?.size ?: 0, _value?.size ?: 0)) { index ->
            R4bString.of(`value`?.getOrNull(index), _value?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'value' on MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics,
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
      when (val choice = value.characteristic) {
        is MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
      }
      if (value.`value`.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          stringNullableListSerializer,
          value.`value`.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.`value`)
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
          4 ->
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
      if (value.classification.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
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
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Packaging>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Packaging =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var quantity: Quantity? = null
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
          4 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Packaging: " + i)
        }
      }
      MedicationKnowledge.Packaging(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        quantity = quantity,
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.quantity)
    }
  }
}

internal object MedicationKnowledgeDrugCharacteristicSerializer :
  KSerializer<MedicationKnowledge.DrugCharacteristic> {
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
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.DrugCharacteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.DrugCharacteristic =
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
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DrugCharacteristic: " + i)
        }
      }
      MedicationKnowledge.DrugCharacteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        `value` =
          MedicationKnowledge.DrugCharacteristic.Value.from(
            valueCodeableConcept,
            R4bString.of(valueString, _valueString),
            valueQuantity,
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.DrugCharacteristic) {
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
        is MedicationKnowledge.DrugCharacteristic.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is MedicationKnowledge.DrugCharacteristic.Value.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is MedicationKnowledge.DrugCharacteristic.Value.Quantity -> {
          encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
        }
        is MedicationKnowledge.DrugCharacteristic.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
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
      optionalElement(
        "schedule",
        MedicationKnowledgeRegulatoryScheduleSerializer.listSerializer.descriptor,
      )
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
      var schedule: List<MedicationKnowledge.Regulatory.Schedule>? = null
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
                MedicationKnowledgeRegulatoryScheduleSerializer.listSerializer,
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
          MedicationKnowledgeRegulatoryScheduleSerializer.listSerializer,
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
          R4bBoolean.of(allowed, _allowed)
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

internal object MedicationKnowledgeRegulatoryScheduleSerializer :
  KSerializer<MedicationKnowledge.Regulatory.Schedule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Schedule") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("schedule", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Regulatory.Schedule>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.Schedule =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var schedule: CodeableConcept? = null
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
            schedule =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Schedule: " + i)
        }
      }
      MedicationKnowledge.Regulatory.Schedule(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        schedule =
          schedule
            ?: throw SerializationException(
              "Missing required property 'schedule' on MedicationKnowledge.Regulatory.Schedule"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Schedule) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.schedule)
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

internal object MedicationKnowledgeKineticsSerializer : KSerializer<MedicationKnowledge.Kinetics> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Kinetics") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("areaUnderCurve", QuantitySerializer.listSerializer.descriptor)
      optionalElement("lethalDose50", QuantitySerializer.listSerializer.descriptor)
      optionalElement("halfLifePeriod", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationKnowledge.Kinetics>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Kinetics =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var areaUnderCurve: List<Quantity>? = null
      var lethalDose50: List<Quantity>? = null
      var halfLifePeriod: Duration? = null
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
            areaUnderCurve =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuantitySerializer.listSerializer,
                null,
              )
          4 ->
            lethalDose50 =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuantitySerializer.listSerializer,
                null,
              )
          5 ->
            halfLifePeriod =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Kinetics: " + i)
        }
      }
      MedicationKnowledge.Kinetics(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        areaUnderCurve = areaUnderCurve ?: listOf(),
        lethalDose50 = lethalDose50 ?: listOf(),
        halfLifePeriod = halfLifePeriod,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Kinetics) {
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
      if (value.areaUnderCurve.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          QuantitySerializer.listSerializer,
          value.areaUnderCurve,
        )
      if (value.lethalDose50.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          QuantitySerializer.listSerializer,
          value.lethalDose50,
        )
      encodeSerializableIfNotNull(descriptor, 5, DurationSerializer, value.halfLifePeriod)
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
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.descriptor)
    b.optionalElement("doseForm", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", QuantitySerializer.descriptor)
    b.optionalElement("synonym", stringNullableListSerializer.descriptor)
    b.optionalElement("_synonym", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement(
      "relatedMedicationKnowledge",
      MedicationKnowledgeRelatedMedicationKnowledgeSerializer.listSerializer.descriptor,
    )
    b.optionalElement("associatedMedication", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("productType", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("monograph", MedicationKnowledgeMonographSerializer.listSerializer.descriptor)
    b.optionalElement(
      "ingredient",
      MedicationKnowledgeIngredientSerializer.listSerializer.descriptor,
    )
    b.optionalElement("preparationInstruction", KotlinString.serializer().descriptor)
    b.optionalElement("_preparationInstruction", ElementSerializer.descriptor)
    b.optionalElement("intendedRoute", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("cost", MedicationKnowledgeCostSerializer.listSerializer.descriptor)
    b.optionalElement(
      "monitoringProgram",
      MedicationKnowledgeMonitoringProgramSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "administrationGuidelines",
      MedicationKnowledgeAdministrationGuidelinesSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "medicineClassification",
      MedicationKnowledgeMedicineClassificationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("packaging", MedicationKnowledgePackagingSerializer.descriptor)
    b.optionalElement(
      "drugCharacteristic",
      MedicationKnowledgeDrugCharacteristicSerializer.listSerializer.descriptor,
    )
    b.optionalElement("contraindication", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "regulatory",
      MedicationKnowledgeRegulatorySerializer.listSerializer.descriptor,
    )
    b.optionalElement("kinetics", MedicationKnowledgeKineticsSerializer.listSerializer.descriptor)
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
    var code: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var manufacturer: Reference? = null
    var doseForm: CodeableConcept? = null
    var amount: Quantity? = null
    var synonym: List<KotlinString?>? = null
    var _synonym: List<Element?>? = null
    var relatedMedicationKnowledge: List<MedicationKnowledge.RelatedMedicationKnowledge>? = null
    var associatedMedication: List<Reference>? = null
    var productType: List<CodeableConcept>? = null
    var monograph: List<MedicationKnowledge.Monograph>? = null
    var ingredient: List<MedicationKnowledge.Ingredient>? = null
    var preparationInstruction: KotlinString? = null
    var _preparationInstruction: Element? = null
    var intendedRoute: List<CodeableConcept>? = null
    var cost: List<MedicationKnowledge.Cost>? = null
    var monitoringProgram: List<MedicationKnowledge.MonitoringProgram>? = null
    var administrationGuidelines: List<MedicationKnowledge.AdministrationGuidelines>? = null
    var medicineClassification: List<MedicationKnowledge.MedicineClassification>? = null
    var packaging: MedicationKnowledge.Packaging? = null
    var drugCharacteristic: List<MedicationKnowledge.DrugCharacteristic>? = null
    var contraindication: List<Reference>? = null
    var regulatory: List<MedicationKnowledge.Regulatory>? = null
    var kinetics: List<MedicationKnowledge.Kinetics>? = null
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
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        14 ->
          doseForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          amount =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        16 ->
          synonym =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _synonym =
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
        22 ->
          ingredient =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeIngredientSerializer.listSerializer,
              null,
            )
        23 -> preparationInstruction = decoder.decodeStringElement(descriptor, i)
        24 ->
          _preparationInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          intendedRoute =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        26 ->
          cost =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeCostSerializer.listSerializer,
              null,
            )
        27 ->
          monitoringProgram =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeMonitoringProgramSerializer.listSerializer,
              null,
            )
        28 ->
          administrationGuidelines =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeAdministrationGuidelinesSerializer.listSerializer,
              null,
            )
        29 ->
          medicineClassification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeMedicineClassificationSerializer.listSerializer,
              null,
            )
        30 ->
          packaging =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgePackagingSerializer,
              null,
            )
        31 ->
          drugCharacteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeDrugCharacteristicSerializer.listSerializer,
              null,
            )
        32 ->
          contraindication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          regulatory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeRegulatorySerializer.listSerializer,
              null,
            )
        34 ->
          kinetics =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeKineticsSerializer.listSerializer,
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
      code = code,
      status =
        Enumeration.of(
          if (status != null) MedicationKnowledge.MedicationKnowledgeStatusCodes.fromCode(status)
          else null,
          _status,
        ),
      manufacturer = manufacturer,
      doseForm = doseForm,
      amount = amount,
      synonym =
        (kotlin.collections.List(maxOf(synonym?.size ?: 0, _synonym?.size ?: 0)) { index ->
          R4bString.of(synonym?.getOrNull(index), _synonym?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'synonym' on MedicationKnowledge has neither a value nor an id/extension"
            )
        }),
      relatedMedicationKnowledge = relatedMedicationKnowledge ?: listOf(),
      associatedMedication = associatedMedication ?: listOf(),
      productType = productType ?: listOf(),
      monograph = monograph ?: listOf(),
      ingredient = ingredient ?: listOf(),
      preparationInstruction = Markdown.of(preparationInstruction, _preparationInstruction),
      intendedRoute = intendedRoute ?: listOf(),
      cost = cost ?: listOf(),
      monitoringProgram = monitoringProgram ?: listOf(),
      administrationGuidelines = administrationGuidelines ?: listOf(),
      medicineClassification = medicineClassification ?: listOf(),
      packaging = packaging,
      drugCharacteristic = drugCharacteristic ?: listOf(),
      contraindication = contraindication ?: listOf(),
      regulatory = regulatory ?: listOf(),
      kinetics = kinetics ?: listOf(),
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.manufacturer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.doseForm,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      QuantitySerializer,
      value.amount,
    )
    if (value.synonym.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.synonym.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 17 + descriptorOffset, value.synonym)
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
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        MedicationKnowledgeIngredientSerializer.listSerializer,
        value.ingredient,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.preparationInstruction?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.preparationInstruction)
    if (value.intendedRoute.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.intendedRoute,
      )
    if (value.cost.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        MedicationKnowledgeCostSerializer.listSerializer,
        value.cost,
      )
    if (value.monitoringProgram.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        MedicationKnowledgeMonitoringProgramSerializer.listSerializer,
        value.monitoringProgram,
      )
    if (value.administrationGuidelines.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        MedicationKnowledgeAdministrationGuidelinesSerializer.listSerializer,
        value.administrationGuidelines,
      )
    if (value.medicineClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        MedicationKnowledgeMedicineClassificationSerializer.listSerializer,
        value.medicineClassification,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      MedicationKnowledgePackagingSerializer,
      value.packaging,
    )
    if (value.drugCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        MedicationKnowledgeDrugCharacteristicSerializer.listSerializer,
        value.drugCharacteristic,
      )
    if (value.contraindication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.contraindication,
      )
    if (value.regulatory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        MedicationKnowledgeRegulatorySerializer.listSerializer,
        value.regulatory,
      )
    if (value.kinetics.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        MedicationKnowledgeKineticsSerializer.listSerializer,
        value.kinetics,
      )
  }
}
