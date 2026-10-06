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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.ClinicalUseDefinition
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object ClinicalUseDefinitionContraindicationSerializer :
  KSerializer<ClinicalUseDefinition.Contraindication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contraindication") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("diseaseSymptomProcedure", CodeableReferenceSerializer.descriptor)
      optionalElement("diseaseStatus", CodeableReferenceSerializer.descriptor)
      optionalElement("comorbidity", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("indication", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("applicability", ExpressionSerializer.descriptor)
      optionalElement(
        "otherTherapy",
        ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Contraindication>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Contraindication =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var diseaseSymptomProcedure: CodeableReference? = null
      var diseaseStatus: CodeableReference? = null
      var comorbidity: List<CodeableReference>? = null
      var indication: List<Reference>? = null
      var applicability: Expression? = null
      var otherTherapy: List<ClinicalUseDefinition.Contraindication.OtherTherapy>? = null
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
            diseaseSymptomProcedure =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            diseaseStatus =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          5 ->
            comorbidity =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          6 ->
            indication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          7 ->
            applicability =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          8 ->
            otherTherapy =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Contraindication: " + i)
        }
      }
      ClinicalUseDefinition.Contraindication(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        diseaseSymptomProcedure = diseaseSymptomProcedure,
        diseaseStatus = diseaseStatus,
        comorbidity = comorbidity ?: listOf(),
        indication = indication ?: listOf(),
        applicability = applicability,
        otherTherapy = otherTherapy ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Contraindication) {
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
      encodeSerializableIfNotNull(
        descriptor,
        3,
        CodeableReferenceSerializer,
        value.diseaseSymptomProcedure,
      )
      encodeSerializableIfNotNull(descriptor, 4, CodeableReferenceSerializer, value.diseaseStatus)
      if (value.comorbidity.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableReferenceSerializer.listSerializer,
          value.comorbidity,
        )
      if (value.indication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ReferenceSerializer.listSerializer,
          value.indication,
        )
      encodeSerializableIfNotNull(descriptor, 7, ExpressionSerializer, value.applicability)
      if (value.otherTherapy.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer,
          value.otherTherapy,
        )
    }
  }
}

internal object ClinicalUseDefinitionContraindicationOtherTherapySerializer :
  KSerializer<ClinicalUseDefinition.Contraindication.OtherTherapy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OtherTherapy") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("relationshipType", CodeableConceptSerializer.descriptor)
      optionalElement("treatment", CodeableReferenceSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<ClinicalUseDefinition.Contraindication.OtherTherapy>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Contraindication.OtherTherapy =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var relationshipType: CodeableConcept? = null
      var treatment: CodeableReference? = null
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
            relationshipType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            treatment =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding OtherTherapy: " + i)
        }
      }
      ClinicalUseDefinition.Contraindication.OtherTherapy(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        relationshipType =
          relationshipType
            ?: throw SerializationException(
              "Missing required property 'relationshipType' on ClinicalUseDefinition.Contraindication.OtherTherapy"
            ),
        treatment =
          treatment
            ?: throw SerializationException(
              "Missing required property 'treatment' on ClinicalUseDefinition.Contraindication.OtherTherapy"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: ClinicalUseDefinition.Contraindication.OtherTherapy,
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.relationshipType)
      encodeSerializableElement(descriptor, 4, CodeableReferenceSerializer, value.treatment)
    }
  }
}

internal object ClinicalUseDefinitionIndicationSerializer :
  KSerializer<ClinicalUseDefinition.Indication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Indication") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("diseaseSymptomProcedure", CodeableReferenceSerializer.descriptor)
      optionalElement("diseaseStatus", CodeableReferenceSerializer.descriptor)
      optionalElement("comorbidity", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("intendedEffect", CodeableReferenceSerializer.descriptor)
      optionalElement("durationRange", RangeSerializer.descriptor)
      optionalElement("durationString", KotlinString.serializer().descriptor)
      optionalElement("_durationString", ElementSerializer.descriptor)
      optionalElement("undesirableEffect", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("applicability", ExpressionSerializer.descriptor)
      optionalElement(
        "otherTherapy",
        ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Indication>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Indication =
    decoder.decodeStructure(descriptor) {
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
      var applicability: Expression? = null
      var otherTherapy: List<ClinicalUseDefinition.Contraindication.OtherTherapy>? = null
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
            diseaseSymptomProcedure =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            diseaseStatus =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          5 ->
            comorbidity =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          6 ->
            intendedEffect =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          7 ->
            durationRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          8 -> durationString = decodeStringElement(descriptor, i)
          9 ->
            _durationString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            undesirableEffect =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          11 ->
            applicability =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          12 ->
            otherTherapy =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Indication: " + i)
        }
      }
      ClinicalUseDefinition.Indication(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        diseaseSymptomProcedure = diseaseSymptomProcedure,
        diseaseStatus = diseaseStatus,
        comorbidity = comorbidity ?: listOf(),
        intendedEffect = intendedEffect,
        duration =
          ClinicalUseDefinition.Indication.Duration.from(
            durationRange,
            R5String.of(durationString, _durationString),
          ),
        undesirableEffect = undesirableEffect ?: listOf(),
        applicability = applicability,
        otherTherapy = otherTherapy ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Indication) {
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
      encodeSerializableIfNotNull(
        descriptor,
        3,
        CodeableReferenceSerializer,
        value.diseaseSymptomProcedure,
      )
      encodeSerializableIfNotNull(descriptor, 4, CodeableReferenceSerializer, value.diseaseStatus)
      if (value.comorbidity.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableReferenceSerializer.listSerializer,
          value.comorbidity,
        )
      encodeSerializableIfNotNull(descriptor, 6, CodeableReferenceSerializer, value.intendedEffect)
      when (val choice = value.duration) {
        null -> {}
        is ClinicalUseDefinition.Indication.Duration.Range -> {
          encodeSerializableElement(descriptor, 7, RangeSerializer, choice.value)
        }
        is ClinicalUseDefinition.Indication.Duration.String -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
      }
      if (value.undesirableEffect.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          ReferenceSerializer.listSerializer,
          value.undesirableEffect,
        )
      encodeSerializableIfNotNull(descriptor, 11, ExpressionSerializer, value.applicability)
      if (value.otherTherapy.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          ClinicalUseDefinitionContraindicationOtherTherapySerializer.listSerializer,
          value.otherTherapy,
        )
    }
  }
}

internal object ClinicalUseDefinitionInteractionSerializer :
  KSerializer<ClinicalUseDefinition.Interaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Interaction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "interactant",
        ClinicalUseDefinitionInteractionInteractantSerializer.listSerializer.descriptor,
      )
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("effect", CodeableReferenceSerializer.descriptor)
      optionalElement("incidence", CodeableConceptSerializer.descriptor)
      optionalElement("management", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Interaction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Interaction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var interactant: List<ClinicalUseDefinition.Interaction.Interactant>? = null
      var type: CodeableConcept? = null
      var effect: CodeableReference? = null
      var incidence: CodeableConcept? = null
      var management: List<CodeableConcept>? = null
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
            interactant =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ClinicalUseDefinitionInteractionInteractantSerializer.listSerializer,
                null,
              )
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            effect =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          6 ->
            incidence =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            management =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Interaction: " + i)
        }
      }
      ClinicalUseDefinition.Interaction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        interactant = interactant ?: listOf(),
        type = type,
        effect = effect,
        incidence = incidence,
        management = management ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Interaction) {
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
      if (value.interactant.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ClinicalUseDefinitionInteractionInteractantSerializer.listSerializer,
          value.interactant,
        )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 5, CodeableReferenceSerializer, value.effect)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.incidence)
      if (value.management.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.management,
        )
    }
  }
}

internal object ClinicalUseDefinitionInteractionInteractantSerializer :
  KSerializer<ClinicalUseDefinition.Interaction.Interactant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Interactant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemReference", ReferenceSerializer.descriptor)
      optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Interaction.Interactant>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Interaction.Interactant =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var itemReference: Reference? = null
      var itemCodeableConcept: CodeableConcept? = null
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
            itemReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            itemCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Interactant: " + i)
        }
      }
      ClinicalUseDefinition.Interaction.Interactant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item =
          ClinicalUseDefinition.Interaction.Interactant.Item.from(
            itemReference,
            itemCodeableConcept,
          )
            ?: throw SerializationException(
              "Missing required property 'item' on ClinicalUseDefinition.Interaction.Interactant"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Interaction.Interactant) {
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
        is ClinicalUseDefinition.Interaction.Interactant.Item.Reference -> {
          encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
        }
        is ClinicalUseDefinition.Interaction.Interactant.Item.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
      }
    }
  }
}

internal object ClinicalUseDefinitionUndesirableEffectSerializer :
  KSerializer<ClinicalUseDefinition.UndesirableEffect> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UndesirableEffect") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("symptomConditionEffect", CodeableReferenceSerializer.descriptor)
      optionalElement("classification", CodeableConceptSerializer.descriptor)
      optionalElement("frequencyOfOccurrence", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.UndesirableEffect>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.UndesirableEffect =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var symptomConditionEffect: CodeableReference? = null
      var classification: CodeableConcept? = null
      var frequencyOfOccurrence: CodeableConcept? = null
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
            symptomConditionEffect =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            classification =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            frequencyOfOccurrence =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding UndesirableEffect: " + i)
        }
      }
      ClinicalUseDefinition.UndesirableEffect(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        symptomConditionEffect = symptomConditionEffect,
        classification = classification,
        frequencyOfOccurrence = frequencyOfOccurrence,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.UndesirableEffect) {
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
      encodeSerializableIfNotNull(
        descriptor,
        3,
        CodeableReferenceSerializer,
        value.symptomConditionEffect,
      )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.classification)
      encodeSerializableIfNotNull(
        descriptor,
        5,
        CodeableConceptSerializer,
        value.frequencyOfOccurrence,
      )
    }
  }
}

internal object ClinicalUseDefinitionWarningSerializer :
  KSerializer<ClinicalUseDefinition.Warning> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Warning") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ClinicalUseDefinition.Warning>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Warning =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var code: CodeableConcept? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Warning: " + i)
        }
      }
      ClinicalUseDefinition.Warning(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = Markdown.of(description, _description),
        code = code,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Warning) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.code)
    }
  }
}

internal object ClinicalUseDefinitionSerializer : FhirResourceSerializer<ClinicalUseDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ClinicalUseDefinition")

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
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
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
    b.optionalElement("library", stringNullableListSerializer.descriptor)
    b.optionalElement("_library", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement(
      "undesirableEffect",
      ClinicalUseDefinitionUndesirableEffectSerializer.descriptor,
    )
    b.optionalElement("warning", ClinicalUseDefinitionWarningSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
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
    var type: KotlinString? = null
    var _type: Element? = null
    var category: List<CodeableConcept>? = null
    var subject: List<Reference>? = null
    var status: CodeableConcept? = null
    var contraindication: ClinicalUseDefinition.Contraindication? = null
    var indication: ClinicalUseDefinition.Indication? = null
    var interaction: ClinicalUseDefinition.Interaction? = null
    var population: List<Reference>? = null
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var undesirableEffect: ClinicalUseDefinition.UndesirableEffect? = null
    var warning: ClinicalUseDefinition.Warning? = null
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
        11 -> type = decoder.decodeStringElement(descriptor, i)
        12 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          status =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          contraindication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionContraindicationSerializer,
              null,
            )
        17 ->
          indication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionIndicationSerializer,
              null,
            )
        18 ->
          interaction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionInteractionSerializer,
              null,
            )
        19 ->
          population =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        21 ->
          _library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        22 ->
          undesirableEffect =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionUndesirableEffectSerializer,
              null,
            )
        23 ->
          warning =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalUseDefinitionWarningSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding ClinicalUseDefinition: " + i)
      }
    }
    return ClinicalUseDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type =
        Enumeration.of(
          if (type != null) ClinicalUseDefinition.ClinicalUseDefinitionType.fromCode(type)
          else null,
          _type,
        )
          ?: throw SerializationException(
            "Missing required property 'type' on ClinicalUseDefinition"
          ),
      category = category ?: listOf(),
      subject = subject ?: listOf(),
      status = status,
      contraindication = contraindication,
      indication = indication,
      interaction = interaction,
      population = population ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index), _library?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'library' on ClinicalUseDefinition has neither a value nor an id/extension"
            )
        }),
      undesirableEffect = undesirableEffect,
      warning = warning,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ClinicalUseDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.type.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.type)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subject,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ClinicalUseDefinitionContraindicationSerializer,
      value.contraindication,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ClinicalUseDefinitionIndicationSerializer,
      value.indication,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ClinicalUseDefinitionInteractionSerializer,
      value.interaction,
    )
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.population,
      )
    if (value.library.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        20 + descriptorOffset,
        stringNullableListSerializer,
        value.library.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 21 + descriptorOffset, value.library)
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ClinicalUseDefinitionUndesirableEffectSerializer,
      value.undesirableEffect,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ClinicalUseDefinitionWarningSerializer,
      value.warning,
    )
  }
}
