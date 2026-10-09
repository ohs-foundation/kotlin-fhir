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

internal object SubstancePolymerMonomerSetSerializer : FhirSerializer<SubstancePolymer.MonomerSet> {
  override val descriptor: SerialDescriptor = buildDescriptor("MonomerSet", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstancePolymer.MonomerSet>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("ratioType", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "startingMaterial",
      SubstancePolymerMonomerSetStartingMaterialSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var ratioType: CodeableConcept? = null
    var startingMaterial: List<SubstancePolymer.MonomerSet.StartingMaterial>? = null
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
          ratioType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          startingMaterial =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerMonomerSetStartingMaterialSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstancePolymer.MonomerSet(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      ratioType = ratioType,
      startingMaterial = listOrEmpty(startingMaterial),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet) {
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
      value.ratioType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      SubstancePolymerMonomerSetStartingMaterialSerializer.listSerializer,
      value.startingMaterial,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstancePolymerMonomerSetStartingMaterialSerializer :
  FhirSerializer<SubstancePolymer.MonomerSet.StartingMaterial> {
  override val descriptor: SerialDescriptor = buildDescriptor("StartingMaterial", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstancePolymer.MonomerSet.StartingMaterial>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("material", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.boolPrim("isDefining")
    b.optionalElement("amount", SubstanceAmountSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet.StartingMaterial {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var material: CodeableConcept? = null
    var type: CodeableConcept? = null
    var isDefining: KotlinBoolean? = null
    var _isDefining: Element? = null
    var amount: SubstanceAmount? = null
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
          material =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
        5 -> isDefining = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _isDefining =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceAmountSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstancePolymer.MonomerSet.StartingMaterial(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      material = material,
      type = type,
      isDefining = R4Boolean.of(isDefining, _isDefining),
      amount = amount,
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet.StartingMaterial) {
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
      value.material,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.isDefining?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.isDefining)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      SubstanceAmountSerializer,
      value.amount,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstancePolymerRepeatSerializer : FhirSerializer<SubstancePolymer.Repeat> {
  override val descriptor: SerialDescriptor = buildDescriptor("Repeat", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstancePolymer.Repeat>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("numberOfUnits")
    b.strPrim("averageMolecularFormula")
    b.optionalElement("repeatUnitAmountType", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "repeatUnit",
      SubstancePolymerRepeatRepeatUnitSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer.Repeat {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> numberOfUnits = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _numberOfUnits =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> averageMolecularFormula = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _averageMolecularFormula =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          repeatUnitAmountType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          repeatUnit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerRepeatRepeatUnitSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstancePolymer.Repeat(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      numberOfUnits = Integer.of(numberOfUnits, _numberOfUnits),
      averageMolecularFormula = R4String.of(averageMolecularFormula, _averageMolecularFormula),
      repeatUnitAmountType = repeatUnitAmountType,
      repeatUnit = listOrEmpty(repeatUnit),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.numberOfUnits?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.numberOfUnits)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.averageMolecularFormula?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.averageMolecularFormula)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.repeatUnitAmountType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      SubstancePolymerRepeatRepeatUnitSerializer.listSerializer,
      value.repeatUnit,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstancePolymerRepeatRepeatUnitSerializer :
  FhirSerializer<SubstancePolymer.Repeat.RepeatUnit> {
  override val descriptor: SerialDescriptor = buildDescriptor("RepeatUnit", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstancePolymer.Repeat.RepeatUnit>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("orientationOfPolymerisation", CodeableConceptSerializer.descriptor)
    b.strPrim("repeatUnit")
    b.optionalElement("amount", SubstanceAmountSerializer.descriptor)
    b.optionalElement(
      "degreeOfPolymerisation",
      SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "structuralRepresentation",
      SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer.Repeat.RepeatUnit {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          orientationOfPolymerisation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> repeatUnit = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _repeatUnit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceAmountSerializer,
              null,
            )
        7 ->
          degreeOfPolymerisation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer.listSerializer,
              null,
            )
        8 ->
          structuralRepresentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstancePolymer.Repeat.RepeatUnit(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      orientationOfPolymerisation = orientationOfPolymerisation,
      repeatUnit = R4String.of(repeatUnit, _repeatUnit),
      amount = amount,
      degreeOfPolymerisation = listOrEmpty(degreeOfPolymerisation),
      structuralRepresentation = listOrEmpty(structuralRepresentation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat.RepeatUnit) {
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
      value.orientationOfPolymerisation,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.repeatUnit?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.repeatUnit)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      SubstanceAmountSerializer,
      value.amount,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer.listSerializer,
      value.degreeOfPolymerisation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer.listSerializer,
      value.structuralRepresentation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer :
  FhirSerializer<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation> {
  override val descriptor: SerialDescriptor = buildDescriptor("DegreeOfPolymerisation", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("degree", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", SubstanceAmountSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var degree: CodeableConcept? = null
    var amount: SubstanceAmount? = null
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
          degree =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceAmountSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      degree = degree,
      amount = amount,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.degree,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      SubstanceAmountSerializer,
      value.amount,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer :
  FhirSerializer<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation> {
  override val descriptor: SerialDescriptor = buildDescriptor("StructuralRepresentation", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("representation")
    b.optionalElement("attachment", AttachmentSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var representation: KotlinString? = null
    var _representation: Element? = null
    var attachment: Attachment? = null
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
        4 -> representation = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _representation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          attachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      representation = R4String.of(representation, _representation),
      attachment = attachment,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.representation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.representation)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      AttachmentSerializer,
      value.attachment,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstancePolymerSerializer : FhirResourceSerializer<SubstancePolymer> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstancePolymer")

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
    b.optionalElement("class", CodeableConceptSerializer.descriptor)
    b.optionalElement("geometry", CodeableConceptSerializer.descriptor)
    b.optionalElement("copolymerConnectivity", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrimList("modification")
    b.optionalElement("monomerSet", SubstancePolymerMonomerSetSerializer.listSerializer.descriptor)
    b.optionalElement("repeat", SubstancePolymerRepeatSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
          `class` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          geometry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          copolymerConnectivity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          modification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _modification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          monomerSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerMonomerSetSerializer.listSerializer,
              null,
            )
        16 ->
          repeat =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerRepeatSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val modification_ =
      List(maxSize(modification, _modification)) { index ->
        entryRequired(
          R4String.of(at(modification, index), at(_modification, index)),
          "SubstancePolymer",
          "modification",
        )
      }
    return SubstancePolymer(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `class` = `class`,
      geometry = geometry,
      copolymerConnectivity = listOrEmpty(copolymerConnectivity),
      modification = modification_,
      monomerSet = listOrEmpty(monomerSet),
      repeat = listOrEmpty(repeat),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstancePolymer,
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
      value.`class`,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.geometry,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.copolymerConnectivity,
    )
    if (!value.modification.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.modification.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        14 + descriptorOffset,
        value.modification,
      )
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      SubstancePolymerMonomerSetSerializer.listSerializer,
      value.monomerSet,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      SubstancePolymerRepeatSerializer.listSerializer,
      value.repeat,
    )
  }
}
