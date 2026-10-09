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
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object MedicationKnowledgeRelatedMedicationKnowledgeSerializer :
  FhirSerializer<MedicationKnowledge.RelatedMedicationKnowledge> {
  override val descriptor: SerialDescriptor = buildDescriptor("RelatedMedicationKnowledge", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.RelatedMedicationKnowledge>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("reference", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.RelatedMedicationKnowledge {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.RelatedMedicationKnowledge(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "MedicationKnowledge.RelatedMedicationKnowledge", "type"),
      reference = listOrEmpty(reference),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.RelatedMedicationKnowledge,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      ReferenceSerializer.listSerializer,
      value.reference,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationKnowledgeMonographSerializer :
  FhirSerializer<MedicationKnowledge.Monograph> {
  override val descriptor: SerialDescriptor = buildDescriptor("Monograph", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Monograph>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("source", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Monograph {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Monograph(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      source = source,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Monograph) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationKnowledge.Ingredient> {
  override val descriptor: SerialDescriptor = buildDescriptor("Ingredient", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Ingredient>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("itemReference", ReferenceSerializer.descriptor)
    b.boolPrim("isActive")
    b.optionalElement("strength", RatioSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Ingredient {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Ingredient(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      item =
        required(
          MedicationKnowledge.Ingredient.Item.from(itemCodeableConcept, itemReference),
          "MedicationKnowledge.Ingredient",
          "item",
        ),
      isActive = R4Boolean.of(isActive, _isActive),
      strength = strength,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Ingredient) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object MedicationKnowledgeCostSerializer : FhirSerializer<MedicationKnowledge.Cost> {
  override val descriptor: SerialDescriptor = buildDescriptor("Cost", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Cost>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("source")
    b.optionalElement("cost", MoneySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Cost {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Cost(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "MedicationKnowledge.Cost", "type"),
      source = R4String.of(source, _source),
      cost = required(cost, "MedicationKnowledge.Cost", "cost"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Cost) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationKnowledge.MonitoringProgram> {
  override val descriptor: SerialDescriptor = buildDescriptor("MonitoringProgram", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.MonitoringProgram>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("name")
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.MonitoringProgram {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.MonitoringProgram(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      name = R4String.of(name, _name),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MonitoringProgram) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationKnowledge.AdministrationGuidelines> {
  override val descriptor: SerialDescriptor = buildDescriptor("AdministrationGuidelines", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.AdministrationGuidelines>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "dosage",
      MedicationKnowledgeAdministrationGuidelinesDosageSerializer.listSerializer.descriptor,
    )
    b.optionalElement("indicationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("indicationReference", ReferenceSerializer.descriptor)
    b.optionalElement(
      "patientCharacteristics",
      MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer.listSerializer
        .descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.AdministrationGuidelines {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.AdministrationGuidelines(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      dosage = listOrEmpty(dosage),
      indication =
        MedicationKnowledge.AdministrationGuidelines.Indication.from(
          indicationCodeableConcept,
          indicationReference,
        ),
      patientCharacteristics = listOrEmpty(patientCharacteristics),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.AdministrationGuidelines) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer.listSerializer,
      value.patientCharacteristics,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationKnowledgeAdministrationGuidelinesDosageSerializer :
  FhirSerializer<MedicationKnowledge.AdministrationGuidelines.Dosage> {
  override val descriptor: SerialDescriptor = buildDescriptor("Dosage", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<MedicationKnowledge.AdministrationGuidelines.Dosage>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("dosage", DosageSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.AdministrationGuidelines.Dosage {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.AdministrationGuidelines.Dosage(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "MedicationKnowledge.AdministrationGuidelines.Dosage", "type"),
      dosage = listOrEmpty(dosage),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.Dosage,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      DosageSerializer.listSerializer,
      value.dosage,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer :
  FhirSerializer<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics> {
  override val descriptor: SerialDescriptor = buildDescriptor("PatientCharacteristics", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("characteristicCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("characteristicQuantity", QuantitySerializer.descriptor)
    b.strPrimList("value")
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val value_ =
      List(maxSize(`value`, _value)) { index ->
        entryRequired(
          R4String.of(at(`value`, index), at(_value, index)),
          "MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics",
          "value",
        )
      }
    return MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      characteristic =
        required(
          MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.from(
            characteristicCodeableConcept,
            characteristicQuantity,
          ),
          "MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics",
          "characteristic",
        ),
      `value` = value_,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    if (!value.`value`.isEmpty()) {
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
  FhirSerializer<MedicationKnowledge.MedicineClassification> {
  override val descriptor: SerialDescriptor = buildDescriptor("MedicineClassification", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.MedicineClassification>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("classification", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.MedicineClassification {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.MedicineClassification(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "MedicationKnowledge.MedicineClassification", "type"),
      classification = listOrEmpty(classification),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MedicineClassification) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.classification,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicationKnowledgePackagingSerializer :
  FhirSerializer<MedicationKnowledge.Packaging> {
  override val descriptor: SerialDescriptor = buildDescriptor("Packaging", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Packaging>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Packaging {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Packaging(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      quantity = quantity,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Packaging) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationKnowledge.DrugCharacteristic> {
  override val descriptor: SerialDescriptor = buildDescriptor("DrugCharacteristic", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.DrugCharacteristic>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.strPrim("valueString")
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.strPrim("valueBase64Binary")
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.DrugCharacteristic {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.DrugCharacteristic(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationKnowledge.Regulatory> {
  override val descriptor: SerialDescriptor = buildDescriptor("Regulatory", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Regulatory>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("regulatoryAuthority", ReferenceSerializer.descriptor)
    b.optionalElement(
      "substitution",
      MedicationKnowledgeRegulatorySubstitutionSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "schedule",
      MedicationKnowledgeRegulatoryScheduleSerializer.listSerializer.descriptor,
    )
    b.optionalElement("maxDispense", MedicationKnowledgeRegulatoryMaxDispenseSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Regulatory(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      regulatoryAuthority =
        required(regulatoryAuthority, "MedicationKnowledge.Regulatory", "regulatoryAuthority"),
      substitution = listOrEmpty(substitution),
      schedule = listOrEmpty(schedule),
      maxDispense = maxDispense,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      MedicationKnowledgeRegulatorySubstitutionSerializer.listSerializer,
      value.substitution,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationKnowledge.Regulatory.Substitution> {
  override val descriptor: SerialDescriptor = buildDescriptor("Substitution", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Regulatory.Substitution>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.boolPrim("allowed")
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.Substitution {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Regulatory.Substitution(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "MedicationKnowledge.Regulatory.Substitution", "type"),
      allowed =
        required(
          R4Boolean.of(allowed, _allowed),
          "MedicationKnowledge.Regulatory.Substitution",
          "allowed",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Substitution) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationKnowledge.Regulatory.Schedule> {
  override val descriptor: SerialDescriptor = buildDescriptor("Schedule", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Regulatory.Schedule>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("schedule", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.Schedule {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Regulatory.Schedule(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      schedule = required(schedule, "MedicationKnowledge.Regulatory.Schedule", "schedule"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Schedule) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
  FhirSerializer<MedicationKnowledge.Regulatory.MaxDispense> {
  override val descriptor: SerialDescriptor = buildDescriptor("MaxDispense", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Regulatory.MaxDispense>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("period", DurationSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.MaxDispense {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Regulatory.MaxDispense(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      quantity = required(quantity, "MedicationKnowledge.Regulatory.MaxDispense", "quantity"),
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.MaxDispense) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object MedicationKnowledgeKineticsSerializer :
  FhirSerializer<MedicationKnowledge.Kinetics> {
  override val descriptor: SerialDescriptor = buildDescriptor("Kinetics", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicationKnowledge.Kinetics>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("areaUnderCurve", QuantitySerializer.listSerializer.descriptor)
    b.optionalElement("lethalDose50", QuantitySerializer.listSerializer.descriptor)
    b.optionalElement("halfLifePeriod", DurationSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Kinetics {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicationKnowledge.Kinetics(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      areaUnderCurve = listOrEmpty(areaUnderCurve),
      lethalDose50 = listOrEmpty(lethalDose50),
      halfLifePeriod = halfLifePeriod,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Kinetics) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      QuantitySerializer.listSerializer,
      value.areaUnderCurve,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("manufacturer", ReferenceSerializer.descriptor)
    b.optionalElement("doseForm", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", QuantitySerializer.descriptor)
    b.strPrimList("synonym")
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
    b.strPrim("preparationInstruction")
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
    var status: MedicationKnowledgeStatusCodes? = null
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
        11 ->
          status =
            MedicationKnowledgeStatusCodes.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
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
        else -> unknownIndex(descriptor, i)
      }
    }
    val synonym_ =
      List(maxSize(synonym, _synonym)) { index ->
        entryRequired(
          R4String.of(at(synonym, index), at(_synonym, index)),
          "MedicationKnowledge",
          "synonym",
        )
      }
    return MedicationKnowledge(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = code,
      status = Enumeration.of(status, _status),
      manufacturer = manufacturer,
      doseForm = doseForm,
      amount = amount,
      synonym = synonym_,
      relatedMedicationKnowledge = listOrEmpty(relatedMedicationKnowledge),
      associatedMedication = listOrEmpty(associatedMedication),
      productType = listOrEmpty(productType),
      monograph = listOrEmpty(monograph),
      ingredient = listOrEmpty(ingredient),
      preparationInstruction = Markdown.of(preparationInstruction, _preparationInstruction),
      intendedRoute = listOrEmpty(intendedRoute),
      cost = listOrEmpty(cost),
      monitoringProgram = listOrEmpty(monitoringProgram),
      administrationGuidelines = listOrEmpty(administrationGuidelines),
      medicineClassification = listOrEmpty(medicineClassification),
      packaging = packaging,
      drugCharacteristic = listOrEmpty(drugCharacteristic),
      contraindication = listOrEmpty(contraindication),
      regulatory = listOrEmpty(regulatory),
      kinetics = listOrEmpty(kinetics),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    if (!value.synonym.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.synonym.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 17 + descriptorOffset, value.synonym)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18 + descriptorOffset,
      MedicationKnowledgeRelatedMedicationKnowledgeSerializer.listSerializer,
      value.relatedMedicationKnowledge,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.associatedMedication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.productType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      MedicationKnowledgeMonographSerializer.listSerializer,
      value.monograph,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.intendedRoute,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      26 + descriptorOffset,
      MedicationKnowledgeCostSerializer.listSerializer,
      value.cost,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      MedicationKnowledgeMonitoringProgramSerializer.listSerializer,
      value.monitoringProgram,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      28 + descriptorOffset,
      MedicationKnowledgeAdministrationGuidelinesSerializer.listSerializer,
      value.administrationGuidelines,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      MedicationKnowledgeDrugCharacteristicSerializer.listSerializer,
      value.drugCharacteristic,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.contraindication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      MedicationKnowledgeRegulatorySerializer.listSerializer,
      value.regulatory,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      MedicationKnowledgeKineticsSerializer.listSerializer,
      value.kinetics,
    )
  }
}
