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

import dev.ohs.fhir.model.r4b.ClinicalUseDefinition
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CodeableReference
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.ClinicalUseDefinitionType
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

internal object ClinicalUseDefinitionContraindicationSerializer :
  FhirSerializer<ClinicalUseDefinition.Contraindication> {
  override val descriptor: SerialDescriptor = buildDescriptor("Contraindication", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Contraindication>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("diseaseSymptomProcedure", CodeableReferenceSerializer.descriptor)
    b.optionalElement("diseaseStatus", CodeableReferenceSerializer.descriptor)
    b.optionalElement("comorbidity", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("indication", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "otherTherapy",
      ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Contraindication {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var diseaseSymptomProcedure: CodeableReference? = null
    var diseaseStatus: CodeableReference? = null
    var comorbidity: List<CodeableReference>? = null
    var indication: List<Reference>? = null
    var otherTherapy: List<ClinicalUseDefinition.Contraindication.OtherTherapy>? = null
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
          diseaseSymptomProcedure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          diseaseStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        5 ->
          comorbidity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        6 ->
          indication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        7 ->
          otherTherapy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ClinicalUseDefinition.Contraindication(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      diseaseSymptomProcedure = diseaseSymptomProcedure,
      diseaseStatus = diseaseStatus,
      comorbidity = listOrEmpty(comorbidity),
      indication = listOrEmpty(indication),
      otherTherapy = listOrEmpty(otherTherapy),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Contraindication) {
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
      CodeableReferenceSerializer,
      value.diseaseSymptomProcedure,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableReferenceSerializer,
      value.diseaseStatus,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      CodeableReferenceSerializer.listSerializer,
      value.comorbidity,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      ReferenceSerializer.listSerializer,
      value.indication,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer,
      value.otherTherapy,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalUseDefinitionContraindicationOtherTherapySerializer :
  FhirSerializer<ClinicalUseDefinition.Contraindication.OtherTherapy> {
  override val descriptor: SerialDescriptor = buildDescriptor("OtherTherapy", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<ClinicalUseDefinition.Contraindication.OtherTherapy>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("relationshipType", CodeableConceptSerializer.descriptor)
    b.optionalElement("therapy", CodeableReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Contraindication.OtherTherapy {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationshipType: CodeableConcept? = null
    var therapy: CodeableReference? = null
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
          relationshipType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          therapy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ClinicalUseDefinition.Contraindication.OtherTherapy(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      relationshipType =
        required(
          relationshipType,
          "ClinicalUseDefinition.Contraindication.OtherTherapy",
          "relationshipType",
        ),
      therapy = required(therapy, "ClinicalUseDefinition.Contraindication.OtherTherapy", "therapy"),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: ClinicalUseDefinition.Contraindication.OtherTherapy,
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.relationshipType,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      4,
      CodeableReferenceSerializer,
      value.therapy,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalUseDefinitionIndicationSerializer :
  FhirSerializer<ClinicalUseDefinition.Indication> {
  override val descriptor: SerialDescriptor = buildDescriptor("Indication", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Indication>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("diseaseSymptomProcedure", CodeableReferenceSerializer.descriptor)
    b.optionalElement("diseaseStatus", CodeableReferenceSerializer.descriptor)
    b.optionalElement("comorbidity", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("intendedEffect", CodeableReferenceSerializer.descriptor)
    b.optionalElement("durationRange", RangeSerializer.descriptor)
    b.strPrim("durationString")
    b.optionalElement("undesirableEffect", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "otherTherapy",
      ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Indication {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var diseaseSymptomProcedure: CodeableReference? = null
    var diseaseStatus: CodeableReference? = null
    var comorbidity: List<CodeableReference>? = null
    var intendedEffect: CodeableReference? = null
    var durationRange: Range? = null
    var durationString: KotlinString? = null
    var _durationString: Element? = null
    var undesirableEffect: List<Reference>? = null
    var otherTherapy: List<ClinicalUseDefinition.Contraindication.OtherTherapy>? = null
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
          diseaseSymptomProcedure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          diseaseStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        5 ->
          comorbidity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        6 ->
          intendedEffect =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        7 ->
          durationRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        8 -> durationString = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _durationString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          undesirableEffect =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        11 ->
          otherTherapy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ClinicalUseDefinition.Indication(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      diseaseSymptomProcedure = diseaseSymptomProcedure,
      diseaseStatus = diseaseStatus,
      comorbidity = listOrEmpty(comorbidity),
      intendedEffect = intendedEffect,
      duration =
        ClinicalUseDefinition.Indication.Duration.from(
          durationRange,
          R4bString.of(durationString, _durationString),
        ),
      undesirableEffect = listOrEmpty(undesirableEffect),
      otherTherapy = listOrEmpty(otherTherapy),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Indication) {
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
      CodeableReferenceSerializer,
      value.diseaseSymptomProcedure,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableReferenceSerializer,
      value.diseaseStatus,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      CodeableReferenceSerializer.listSerializer,
      value.comorbidity,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableReferenceSerializer,
      value.intendedEffect,
    )
    when (val choice = value.duration) {
      null -> {}
      is ClinicalUseDefinition.Indication.Duration.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, RangeSerializer, choice.value)
      }
      is ClinicalUseDefinition.Indication.Duration.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      ReferenceSerializer.listSerializer,
      value.undesirableEffect,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer,
      value.otherTherapy,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalUseDefinitionInteractionSerializer :
  FhirSerializer<ClinicalUseDefinition.Interaction> {
  override val descriptor: SerialDescriptor = buildDescriptor("Interaction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Interaction>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "interactant",
      ClinicalUseDefinitionInteractionInteractantSerializer.listSerializer.descriptor,
    )
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("effect", CodeableReferenceSerializer.descriptor)
    b.optionalElement("incidence", CodeableConceptSerializer.descriptor)
    b.optionalElement("management", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Interaction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var interactant: List<ClinicalUseDefinition.Interaction.Interactant>? = null
    var type: CodeableConcept? = null
    var effect: CodeableReference? = null
    var incidence: CodeableConcept? = null
    var management: List<CodeableConcept>? = null
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
          interactant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionInteractionInteractantSerializer.listSerializer,
              null,
            )
        4 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          effect =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        6 ->
          incidence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          management =
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
    return ClinicalUseDefinition.Interaction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      interactant = listOrEmpty(interactant),
      type = type,
      effect = effect,
      incidence = incidence,
      management = listOrEmpty(management),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Interaction) {
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
      ClinicalUseDefinitionInteractionInteractantSerializer.listSerializer,
      value.interactant,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableReferenceSerializer,
      value.effect,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.incidence,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.management,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalUseDefinitionInteractionInteractantSerializer :
  FhirSerializer<ClinicalUseDefinition.Interaction.Interactant> {
  override val descriptor: SerialDescriptor = buildDescriptor("Interactant", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Interaction.Interactant>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("itemReference", ReferenceSerializer.descriptor)
    b.optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Interaction.Interactant {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          itemCodeableConcept =
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
    return ClinicalUseDefinition.Interaction.Interactant(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      item =
        required(
          ClinicalUseDefinition.Interaction.Interactant.Item.from(
            itemReference,
            itemCodeableConcept,
          ),
          "ClinicalUseDefinition.Interaction.Interactant",
          "item",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Interaction.Interactant) {
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
      is ClinicalUseDefinition.Interaction.Interactant.Item.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
      }
      is ClinicalUseDefinition.Interaction.Interactant.Item.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalUseDefinitionUndesirableEffectSerializer :
  FhirSerializer<ClinicalUseDefinition.UndesirableEffect> {
  override val descriptor: SerialDescriptor = buildDescriptor("UndesirableEffect", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.UndesirableEffect>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("symptomConditionEffect", CodeableReferenceSerializer.descriptor)
    b.optionalElement("classification", CodeableConceptSerializer.descriptor)
    b.optionalElement("frequencyOfOccurrence", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.UndesirableEffect {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var symptomConditionEffect: CodeableReference? = null
    var classification: CodeableConcept? = null
    var frequencyOfOccurrence: CodeableConcept? = null
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
          symptomConditionEffect =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          classification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          frequencyOfOccurrence =
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
    return ClinicalUseDefinition.UndesirableEffect(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      symptomConditionEffect = symptomConditionEffect,
      classification = classification,
      frequencyOfOccurrence = frequencyOfOccurrence,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.UndesirableEffect) {
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
      CodeableReferenceSerializer,
      value.symptomConditionEffect,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.classification,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.frequencyOfOccurrence,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalUseDefinitionWarningSerializer :
  FhirSerializer<ClinicalUseDefinition.Warning> {
  override val descriptor: SerialDescriptor = buildDescriptor("Warning", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Warning>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Warning {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var code: CodeableConcept? = null
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
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          code =
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
    return ClinicalUseDefinition.Warning(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      description = Markdown.of(description, _description),
      code = code,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Warning) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalUseDefinitionSerializer : FhirResourceSerializer<ClinicalUseDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ClinicalUseDefinition")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "contraindication",
      ClinicalUseDefinitionContraindicationSerializer.descriptor,
    )
    b.optionalElement("indication", ClinicalUseDefinitionIndicationSerializer.descriptor)
    b.optionalElement("interaction", ClinicalUseDefinitionInteractionSerializer.descriptor)
    b.optionalElement("population", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "undesirableEffect",
      ClinicalUseDefinitionUndesirableEffectSerializer.descriptor,
    )
    b.optionalElement("warning", ClinicalUseDefinitionWarningSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ClinicalUseDefinition {
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
    var type: ClinicalUseDefinitionType? = null
    var _type: Element? = null
    var category: List<CodeableConcept>? = null
    var subject: List<Reference>? = null
    var status: CodeableConcept? = null
    var contraindication: ClinicalUseDefinition.Contraindication? = null
    var indication: ClinicalUseDefinition.Indication? = null
    var interaction: ClinicalUseDefinition.Interaction? = null
    var population: List<Reference>? = null
    var undesirableEffect: ClinicalUseDefinition.UndesirableEffect? = null
    var warning: ClinicalUseDefinition.Warning? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          type =
            ClinicalUseDefinitionType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          contraindication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionContraindicationSerializer,
              null,
            )
        17 ->
          indication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionIndicationSerializer,
              null,
            )
        18 ->
          interaction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionInteractionSerializer,
              null,
            )
        19 ->
          population =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          undesirableEffect =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionUndesirableEffectSerializer,
              null,
            )
        21 ->
          warning =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionWarningSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return ClinicalUseDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      type = required(Enumeration.of(type, _type), "ClinicalUseDefinition", "type"),
      category = listOrEmpty(category),
      subject = listOrEmpty(subject),
      status = status,
      contraindication = contraindication,
      indication = indication,
      interaction = interaction,
      population = listOrEmpty(population),
      undesirableEffect = undesirableEffect,
      warning = warning,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ClinicalUseDefinition,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.type.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.type)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.category,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ClinicalUseDefinitionContraindicationSerializer,
      value.contraindication,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ClinicalUseDefinitionIndicationSerializer,
      value.indication,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ClinicalUseDefinitionInteractionSerializer,
      value.interaction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.population,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ClinicalUseDefinitionUndesirableEffectSerializer,
      value.undesirableEffect,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ClinicalUseDefinitionWarningSerializer,
      value.warning,
    )
  }
}
