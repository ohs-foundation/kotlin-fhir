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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceAmount
import dev.ohs.fhir.model.r4.SubstancePolymer
import dev.ohs.fhir.model.r4.Uri
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

internal object SubstancePolymerMonomerSetSerializer : KSerializer<SubstancePolymer.MonomerSet> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MonomerSet") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("ratioType", CodeableConceptSerializer.descriptor)
      optionalElement(
        "startingMaterial",
        SubstancePolymerMonomerSetStartingMaterialSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<SubstancePolymer.MonomerSet>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var ratioType: CodeableConcept? = null
      var startingMaterial: List<SubstancePolymer.MonomerSet.StartingMaterial>? = null
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
            ratioType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            startingMaterial =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstancePolymerMonomerSetStartingMaterialSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MonomerSet: " + i)
        }
      }
      SubstancePolymer.MonomerSet(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        ratioType = ratioType,
        startingMaterial = startingMaterial ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.ratioType)
      if (value.startingMaterial.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          SubstancePolymerMonomerSetStartingMaterialSerializer.listSerializer,
          value.startingMaterial,
        )
    }
  }
}

internal object SubstancePolymerMonomerSetStartingMaterialSerializer :
  KSerializer<SubstancePolymer.MonomerSet.StartingMaterial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StartingMaterial") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("material", CodeableConceptSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("isDefining", KotlinBoolean.serializer().descriptor)
      optionalElement("_isDefining", ElementSerializer.descriptor)
      optionalElement("amount", SubstanceAmountSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstancePolymer.MonomerSet.StartingMaterial>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet.StartingMaterial =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var material: CodeableConcept? = null
      var type: CodeableConcept? = null
      var isDefining: KotlinBoolean? = null
      var _isDefining: Element? = null
      var amount: SubstanceAmount? = null
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
            material =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> isDefining = decodeBooleanElement(descriptor, i)
          6 ->
            _isDefining = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            amount =
              decodeNullableSerializableElement(descriptor, i, SubstanceAmountSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding StartingMaterial: " + i)
        }
      }
      SubstancePolymer.MonomerSet.StartingMaterial(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        material = material,
        type = type,
        isDefining = R4Boolean.of(isDefining, _isDefining),
        amount = amount,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet.StartingMaterial) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.material)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeBooleanIfNotNull(descriptor, 5, value.isDefining?.value)
      encodeElementIfNotNull(descriptor, 6, value.isDefining)
      encodeSerializableIfNotNull(descriptor, 7, SubstanceAmountSerializer, value.amount)
    }
  }
}

internal object SubstancePolymerRepeatSerializer : KSerializer<SubstancePolymer.Repeat> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Repeat") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("numberOfUnits", Int.serializer().descriptor)
      optionalElement("_numberOfUnits", ElementSerializer.descriptor)
      optionalElement("averageMolecularFormula", KotlinString.serializer().descriptor)
      optionalElement("_averageMolecularFormula", ElementSerializer.descriptor)
      optionalElement("repeatUnitAmountType", CodeableConceptSerializer.descriptor)
      optionalElement(
        "repeatUnit",
        SubstancePolymerRepeatRepeatUnitSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<SubstancePolymer.Repeat>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstancePolymer.Repeat =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var numberOfUnits: Int? = null
      var _numberOfUnits: Element? = null
      var averageMolecularFormula: KotlinString? = null
      var _averageMolecularFormula: Element? = null
      var repeatUnitAmountType: CodeableConcept? = null
      var repeatUnit: List<SubstancePolymer.Repeat.RepeatUnit>? = null
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
          3 -> numberOfUnits = decodeIntElement(descriptor, i)
          4 ->
            _numberOfUnits =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> averageMolecularFormula = decodeStringElement(descriptor, i)
          6 ->
            _averageMolecularFormula =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            repeatUnitAmountType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            repeatUnit =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstancePolymerRepeatRepeatUnitSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Repeat: " + i)
        }
      }
      SubstancePolymer.Repeat(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        numberOfUnits = Integer.of(numberOfUnits, _numberOfUnits),
        averageMolecularFormula = R4String.of(averageMolecularFormula, _averageMolecularFormula),
        repeatUnitAmountType = repeatUnitAmountType,
        repeatUnit = repeatUnit ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat) {
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
      encodeIntIfNotNull(descriptor, 3, value.numberOfUnits?.value)
      encodeElementIfNotNull(descriptor, 4, value.numberOfUnits)
      encodeStringIfNotNull(descriptor, 5, value.averageMolecularFormula?.value)
      encodeElementIfNotNull(descriptor, 6, value.averageMolecularFormula)
      encodeSerializableIfNotNull(
        descriptor,
        7,
        CodeableConceptSerializer,
        value.repeatUnitAmountType,
      )
      if (value.repeatUnit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          SubstancePolymerRepeatRepeatUnitSerializer.listSerializer,
          value.repeatUnit,
        )
    }
  }
}

internal object SubstancePolymerRepeatRepeatUnitSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RepeatUnit") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("orientationOfPolymerisation", CodeableConceptSerializer.descriptor)
      optionalElement("repeatUnit", KotlinString.serializer().descriptor)
      optionalElement("_repeatUnit", ElementSerializer.descriptor)
      optionalElement("amount", SubstanceAmountSerializer.descriptor)
      optionalElement(
        "degreeOfPolymerisation",
        SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "structuralRepresentation",
        SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer.listSerializer
          .descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<SubstancePolymer.Repeat.RepeatUnit>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstancePolymer.Repeat.RepeatUnit =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var orientationOfPolymerisation: CodeableConcept? = null
      var repeatUnit: KotlinString? = null
      var _repeatUnit: Element? = null
      var amount: SubstanceAmount? = null
      var degreeOfPolymerisation: List<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation>? =
        null
      var structuralRepresentation:
        List<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation>? =
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
            orientationOfPolymerisation =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> repeatUnit = decodeStringElement(descriptor, i)
          5 ->
            _repeatUnit = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            amount =
              decodeNullableSerializableElement(descriptor, i, SubstanceAmountSerializer, null)
          7 ->
            degreeOfPolymerisation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer.listSerializer,
                null,
              )
          8 ->
            structuralRepresentation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RepeatUnit: " + i)
        }
      }
      SubstancePolymer.Repeat.RepeatUnit(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        orientationOfPolymerisation = orientationOfPolymerisation,
        repeatUnit = R4String.of(repeatUnit, _repeatUnit),
        amount = amount,
        degreeOfPolymerisation = degreeOfPolymerisation ?: listOf(),
        structuralRepresentation = structuralRepresentation ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat.RepeatUnit) {
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
        CodeableConceptSerializer,
        value.orientationOfPolymerisation,
      )
      encodeStringIfNotNull(descriptor, 4, value.repeatUnit?.value)
      encodeElementIfNotNull(descriptor, 5, value.repeatUnit)
      encodeSerializableIfNotNull(descriptor, 6, SubstanceAmountSerializer, value.amount)
      if (value.degreeOfPolymerisation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer.listSerializer,
          value.degreeOfPolymerisation,
        )
      if (value.structuralRepresentation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer.listSerializer,
          value.structuralRepresentation,
        )
    }
  }
}

internal object SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DegreeOfPolymerisation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("degree", CodeableConceptSerializer.descriptor)
      optionalElement("amount", SubstanceAmountSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var degree: CodeableConcept? = null
      var amount: SubstanceAmount? = null
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
            degree =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            amount =
              decodeNullableSerializableElement(descriptor, i, SubstanceAmountSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding DegreeOfPolymerisation: " + i)
        }
      }
      SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        degree = degree,
        amount = amount,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation,
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.degree)
      encodeSerializableIfNotNull(descriptor, 4, SubstanceAmountSerializer, value.amount)
    }
  }
}

internal object SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructuralRepresentation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("representation", KotlinString.serializer().descriptor)
      optionalElement("_representation", ElementSerializer.descriptor)
      optionalElement("attachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var representation: KotlinString? = null
      var _representation: Element? = null
      var attachment: Attachment? = null
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
          4 -> representation = decodeStringElement(descriptor, i)
          5 ->
            _representation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            attachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding StructuralRepresentation: " + i)
        }
      }
      SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        representation = R4String.of(representation, _representation),
        attachment = attachment,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation,
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
      encodeStringIfNotNull(descriptor, 4, value.representation?.value)
      encodeElementIfNotNull(descriptor, 5, value.representation)
      encodeSerializableIfNotNull(descriptor, 6, AttachmentSerializer, value.attachment)
    }
  }
}

internal object SubstancePolymerSerializer : FhirResourceSerializer<SubstancePolymer> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstancePolymer")

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
    b.optionalElement("class", CodeableConceptSerializer.descriptor)
    b.optionalElement("geometry", CodeableConceptSerializer.descriptor)
    b.optionalElement("copolymerConnectivity", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("modification", stringNullableListSerializer.descriptor)
    b.optionalElement("_modification", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("monomerSet", SubstancePolymerMonomerSetSerializer.listSerializer.descriptor)
    b.optionalElement("repeat", SubstancePolymerRepeatSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubstancePolymer {
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
    var `class`: CodeableConcept? = null
    var geometry: CodeableConcept? = null
    var copolymerConnectivity: List<CodeableConcept>? = null
    var modification: List<KotlinString?>? = null
    var _modification: List<Element?>? = null
    var monomerSet: List<SubstancePolymer.MonomerSet>? = null
    var repeat: List<SubstancePolymer.Repeat>? = null
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
          `class` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          geometry =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          copolymerConnectivity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          modification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _modification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          monomerSet =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerMonomerSetSerializer.listSerializer,
              null,
            )
        16 ->
          repeat =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerRepeatSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SubstancePolymer: " + i)
      }
    }
    return SubstancePolymer(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `class` = `class`,
      geometry = geometry,
      copolymerConnectivity = copolymerConnectivity ?: listOf(),
      modification =
        (kotlin.collections.List(maxOf(modification?.size ?: 0, _modification?.size ?: 0)) { index
          ->
          R4String.of(modification?.getOrNull(index), _modification?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'modification' on SubstancePolymer has neither a value nor an id/extension"
            )
        }),
      monomerSet = monomerSet ?: listOf(),
      repeat = repeat ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstancePolymer,
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
      value.`class`,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.geometry,
    )
    if (value.copolymerConnectivity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.copolymerConnectivity,
      )
    if (value.modification.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.modification.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.modification)
    }
    if (value.monomerSet.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        SubstancePolymerMonomerSetSerializer.listSerializer,
        value.monomerSet,
      )
    if (value.repeat.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        SubstancePolymerRepeatSerializer.listSerializer,
        value.repeat,
      )
  }
}
