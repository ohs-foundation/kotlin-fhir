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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.MedicationKnowledge
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.MedicationKnowledgeStatusCodes
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.RelatedMedicationKnowledge {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var reference: List<Reference>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding RelatedMedicationKnowledge: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.RelatedMedicationKnowledge(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    if (value.reference.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        ReferenceSerializer.listSerializer,
        value.reference,
      )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Monograph {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var source: Reference? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Monograph: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Monograph(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      source = source,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Monograph) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.source)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Ingredient {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var isActive: KotlinBoolean? = null
    var _isActive: Element? = null
    var strength: Ratio? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          itemCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          itemReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 -> isActive = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _isActive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          strength =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Ingredient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item =
        MedicationKnowledge.Ingredient.Item.from(itemCodeableConcept, itemReference)
          ?: throw SerializationException(
            "Missing required property 'item' on MedicationKnowledge.Ingredient"
          ),
      isActive = R4Boolean.of(isActive, _isActive),
      strength = strength,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Ingredient) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.item) {
      is MedicationKnowledge.Ingredient.Item.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicationKnowledge.Ingredient.Item.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.isActive?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.isActive)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, RatioSerializer, value.strength)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Cost {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var cost: Money? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> source = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          cost =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Cost: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Cost(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on MedicationKnowledge.Cost"
          ),
      source = R4String.of(source, _source),
      cost =
        cost
          ?: throw SerializationException(
            "Missing required property 'cost' on MedicationKnowledge.Cost"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Cost) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.source?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.source)
    compositeEncoder.encodeSerializableElement(descriptor, 6, MoneySerializer, value.cost)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.MonitoringProgram {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var name: KotlinString? = null
    var _name: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonitoringProgram: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.MonitoringProgram(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      name = R4String.of(name, _name),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MonitoringProgram) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.name)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.AdministrationGuidelines {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          dosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeAdministrationGuidelinesDosageSerializer.listSerializer,
              null,
            )
        4 ->
          indicationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          indicationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 ->
          patientCharacteristics =
            compositeDecoder.decodeNullableSerializableElement(
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
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.AdministrationGuidelines(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.dosage.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        MedicationKnowledgeAdministrationGuidelinesDosageSerializer.listSerializer,
        value.dosage,
      )
    when (val choice = value.indication) {
      null -> {}
      is MedicationKnowledge.AdministrationGuidelines.Indication.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicationKnowledge.AdministrationGuidelines.Indication.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
      }
    }
    if (value.patientCharacteristics.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer.listSerializer,
        value.patientCharacteristics,
      )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.AdministrationGuidelines.Dosage {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var dosage: List<Dosage>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          dosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.AdministrationGuidelines.Dosage(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    if (value.dosage.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        DosageSerializer.listSerializer,
        value.dosage,
      )
    compositeEncoder.endStructure(descriptor)
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
  ): MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var characteristicCodeableConcept: CodeableConcept? = null
    var characteristicQuantity: Quantity? = null
    var `value`: List<KotlinString?>? = null
    var _value: List<Element?>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          characteristicCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          characteristicQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        6 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
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
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics(
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
          R4String.of(`value`?.getOrNull(index), _value?.getOrNull(index))
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.characteristic) {
      is MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
      }
    }
    if (value.`value`.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        stringNullableListSerializer,
        value.`value`.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.`value`)
    }
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.MedicineClassification {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var classification: List<CodeableConcept>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          classification =
            compositeDecoder.decodeNullableSerializableElement(
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
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.MedicineClassification(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    if (value.classification.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.classification,
      )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Packaging {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Packaging: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Packaging(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      quantity = quantity,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Packaging) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.quantity)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.DrugCharacteristic {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        8 -> valueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _valueBase64Binary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DrugCharacteristic: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.DrugCharacteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      `value` =
        MedicationKnowledge.DrugCharacteristic.Value.from(
          valueCodeableConcept,
          R4String.of(valueString, _valueString),
          valueQuantity,
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.DrugCharacteristic) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    when (val choice = value.`value`) {
      null -> {}
      is MedicationKnowledge.DrugCharacteristic.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicationKnowledge.DrugCharacteristic.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is MedicationKnowledge.DrugCharacteristic.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
      }
      is MedicationKnowledge.DrugCharacteristic.Value.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var regulatoryAuthority: Reference? = null
    var substitution: List<MedicationKnowledge.Regulatory.Substitution>? = null
    var schedule: List<MedicationKnowledge.Regulatory.Schedule>? = null
    var maxDispense: MedicationKnowledge.Regulatory.MaxDispense? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          regulatoryAuthority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          substitution =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeRegulatorySubstitutionSerializer.listSerializer,
              null,
            )
        5 ->
          schedule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeRegulatoryScheduleSerializer.listSerializer,
              null,
            )
        6 ->
          maxDispense =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeRegulatoryMaxDispenseSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Regulatory: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Regulatory(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      ReferenceSerializer,
      value.regulatoryAuthority,
    )
    if (value.substitution.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        MedicationKnowledgeRegulatorySubstitutionSerializer.listSerializer,
        value.substitution,
      )
    if (value.schedule.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        MedicationKnowledgeRegulatoryScheduleSerializer.listSerializer,
        value.schedule,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      MedicationKnowledgeRegulatoryMaxDispenseSerializer,
      value.maxDispense,
    )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.Substitution {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var allowed: KotlinBoolean? = null
    var _allowed: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> allowed = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _allowed =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Regulatory.Substitution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on MedicationKnowledge.Regulatory.Substitution"
          ),
      allowed =
        R4Boolean.of(allowed, _allowed)
          ?: throw SerializationException(
            "Missing required property 'allowed' on MedicationKnowledge.Regulatory.Substitution"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Substitution) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.allowed.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.allowed)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.Schedule {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var schedule: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          schedule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Schedule: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Regulatory.Schedule(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.schedule,
    )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.MaxDispense {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Quantity? = null
    var period: Duration? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        4 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MaxDispense: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Regulatory.MaxDispense(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, DurationSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Kinetics {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var areaUnderCurve: List<Quantity>? = null
    var lethalDose50: List<Quantity>? = null
    var halfLifePeriod: Duration? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          areaUnderCurve =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        4 ->
          lethalDose50 =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        5 ->
          halfLifePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Kinetics: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Kinetics(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      areaUnderCurve = areaUnderCurve ?: listOf(),
      lethalDose50 = lethalDose50 ?: listOf(),
      halfLifePeriod = halfLifePeriod,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Kinetics) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.areaUnderCurve.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        QuantitySerializer.listSerializer,
        value.areaUnderCurve,
      )
    if (value.lethalDose50.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        QuantitySerializer.listSerializer,
        value.lethalDose50,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      DurationSerializer,
      value.halfLifePeriod,
    )
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        14 ->
          doseForm =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        16 ->
          synonym =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _synonym =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          relatedMedicationKnowledge =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeRelatedMedicationKnowledgeSerializer.listSerializer,
              null,
            )
        19 ->
          associatedMedication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          productType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        21 ->
          monograph =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeMonographSerializer.listSerializer,
              null,
            )
        22 ->
          ingredient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeIngredientSerializer.listSerializer,
              null,
            )
        23 -> preparationInstruction = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _preparationInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          intendedRoute =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        26 ->
          cost =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeCostSerializer.listSerializer,
              null,
            )
        27 ->
          monitoringProgram =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeMonitoringProgramSerializer.listSerializer,
              null,
            )
        28 ->
          administrationGuidelines =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeAdministrationGuidelinesSerializer.listSerializer,
              null,
            )
        29 ->
          medicineClassification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeMedicineClassificationSerializer.listSerializer,
              null,
            )
        30 ->
          packaging =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgePackagingSerializer,
              null,
            )
        31 ->
          drugCharacteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeDrugCharacteristicSerializer.listSerializer,
              null,
            )
        32 ->
          contraindication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          regulatory =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationKnowledgeRegulatorySerializer.listSerializer,
              null,
            )
        34 ->
          kinetics =
            compositeDecoder.decodeNullableSerializableElement(
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
          if (status != null) MedicationKnowledgeStatusCodes.fromCode(status) else null,
          _status,
        ),
      manufacturer = manufacturer,
      doseForm = doseForm,
      amount = amount,
      synonym =
        (kotlin.collections.List(maxOf(synonym?.size ?: 0, _synonym?.size ?: 0)) { index ->
          R4String.of(synonym?.getOrNull(index), _synonym?.getOrNull(index))
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationKnowledge,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.doseForm,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      QuantitySerializer,
      value.amount,
    )
    if (value.synonym.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.synonym.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 17 + descriptorOffset, value.synonym)
    }
    if (value.relatedMedicationKnowledge.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        MedicationKnowledgeRelatedMedicationKnowledgeSerializer.listSerializer,
        value.relatedMedicationKnowledge,
      )
    if (value.associatedMedication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.associatedMedication,
      )
    if (value.productType.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.productType,
      )
    if (value.monograph.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        MedicationKnowledgeMonographSerializer.listSerializer,
        value.monograph,
      )
    if (value.ingredient.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        MedicationKnowledgeIngredientSerializer.listSerializer,
        value.ingredient,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.preparationInstruction?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.preparationInstruction,
    )
    if (value.intendedRoute.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.intendedRoute,
      )
    if (value.cost.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        MedicationKnowledgeCostSerializer.listSerializer,
        value.cost,
      )
    if (value.monitoringProgram.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        MedicationKnowledgeMonitoringProgramSerializer.listSerializer,
        value.monitoringProgram,
      )
    if (value.administrationGuidelines.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        MedicationKnowledgeAdministrationGuidelinesSerializer.listSerializer,
        value.administrationGuidelines,
      )
    if (value.medicineClassification.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        MedicationKnowledgeMedicineClassificationSerializer.listSerializer,
        value.medicineClassification,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      MedicationKnowledgePackagingSerializer,
      value.packaging,
    )
    if (value.drugCharacteristic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        MedicationKnowledgeDrugCharacteristicSerializer.listSerializer,
        value.drugCharacteristic,
      )
    if (value.contraindication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.contraindication,
      )
    if (value.regulatory.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        MedicationKnowledgeRegulatorySerializer.listSerializer,
        value.regulatory,
      )
    if (value.kinetics.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        MedicationKnowledgeKineticsSerializer.listSerializer,
        value.kinetics,
      )
  }
}
