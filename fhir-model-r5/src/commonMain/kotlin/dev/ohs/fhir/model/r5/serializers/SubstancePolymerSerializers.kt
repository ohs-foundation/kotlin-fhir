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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubstancePolymer
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
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("isDefining", KotlinBoolean.serializer().descriptor)
      optionalElement("_isDefining", ElementSerializer.descriptor)
      optionalElement("amount", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstancePolymer.MonomerSet.StartingMaterial>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet.StartingMaterial =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var category: CodeableConcept? = null
      var isDefining: KotlinBoolean? = null
      var _isDefining: Element? = null
      var amount: Quantity? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> isDefining = decodeBooleanElement(descriptor, i)
          6 ->
            _isDefining = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> amount = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding StartingMaterial: " + i)
        }
      }
      SubstancePolymer.MonomerSet.StartingMaterial(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        category = category,
        isDefining = R5Boolean.of(isDefining, _isDefining),
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.category)
      encodeBooleanIfNotNull(descriptor, 5, value.isDefining?.value)
      encodeElementIfNotNull(descriptor, 6, value.isDefining)
      encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.amount)
    }
  }
}

internal object SubstancePolymerRepeatSerializer : KSerializer<SubstancePolymer.Repeat> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Repeat") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
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
          3 -> averageMolecularFormula = decodeStringElement(descriptor, i)
          4 ->
            _averageMolecularFormula =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            repeatUnitAmountType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
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
        averageMolecularFormula = R5String.of(averageMolecularFormula, _averageMolecularFormula),
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
      encodeStringIfNotNull(descriptor, 3, value.averageMolecularFormula?.value)
      encodeElementIfNotNull(descriptor, 4, value.averageMolecularFormula)
      encodeSerializableIfNotNull(
        descriptor,
        5,
        CodeableConceptSerializer,
        value.repeatUnitAmountType,
      )
      if (value.repeatUnit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
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
      optionalElement("unit", KotlinString.serializer().descriptor)
      optionalElement("_unit", ElementSerializer.descriptor)
      optionalElement("orientation", CodeableConceptSerializer.descriptor)
      optionalElement("amount", Int.serializer().descriptor)
      optionalElement("_amount", ElementSerializer.descriptor)
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
      var unit: KotlinString? = null
      var _unit: Element? = null
      var orientation: CodeableConcept? = null
      var amount: Int? = null
      var _amount: Element? = null
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
          3 -> unit = decodeStringElement(descriptor, i)
          4 -> _unit = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            orientation =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> amount = decodeIntElement(descriptor, i)
          7 -> _amount = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            degreeOfPolymerisation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer.listSerializer,
                null,
              )
          9 ->
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
        unit = R5String.of(unit, _unit),
        orientation = orientation,
        amount = Integer.of(amount, _amount),
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
      encodeStringIfNotNull(descriptor, 3, value.unit?.value)
      encodeElementIfNotNull(descriptor, 4, value.unit)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.orientation)
      encodeIntIfNotNull(descriptor, 6, value.amount?.value)
      encodeElementIfNotNull(descriptor, 7, value.amount)
      if (value.degreeOfPolymerisation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer.listSerializer,
          value.degreeOfPolymerisation,
        )
      if (value.structuralRepresentation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
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
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("average", Int.serializer().descriptor)
      optionalElement("_average", ElementSerializer.descriptor)
      optionalElement("low", Int.serializer().descriptor)
      optionalElement("_low", ElementSerializer.descriptor)
      optionalElement("high", Int.serializer().descriptor)
      optionalElement("_high", ElementSerializer.descriptor)
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
      var type: CodeableConcept? = null
      var average: Int? = null
      var _average: Element? = null
      var low: Int? = null
      var _low: Element? = null
      var high: Int? = null
      var _high: Element? = null
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
          4 -> average = decodeIntElement(descriptor, i)
          5 -> _average = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> low = decodeIntElement(descriptor, i)
          7 -> _low = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> high = decodeIntElement(descriptor, i)
          9 -> _high = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding DegreeOfPolymerisation: " + i)
        }
      }
      SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        average = Integer.of(average, _average),
        low = Integer.of(low, _low),
        high = Integer.of(high, _high),
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeIntIfNotNull(descriptor, 4, value.average?.value)
      encodeElementIfNotNull(descriptor, 5, value.average)
      encodeIntIfNotNull(descriptor, 6, value.low?.value)
      encodeElementIfNotNull(descriptor, 7, value.low)
      encodeIntIfNotNull(descriptor, 8, value.high?.value)
      encodeElementIfNotNull(descriptor, 9, value.high)
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
      optionalElement("format", CodeableConceptSerializer.descriptor)
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
      var format: CodeableConcept? = null
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
            format =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
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
        representation = R5String.of(representation, _representation),
        format = format,
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
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.format)
      encodeSerializableIfNotNull(descriptor, 7, AttachmentSerializer, value.attachment)
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
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("class", CodeableConceptSerializer.descriptor)
    b.optionalElement("geometry", CodeableConceptSerializer.descriptor)
    b.optionalElement("copolymerConnectivity", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("modification", KotlinString.serializer().descriptor)
    b.optionalElement("_modification", ElementSerializer.descriptor)
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
    var identifier: Identifier? = null
    var `class`: CodeableConcept? = null
    var geometry: CodeableConcept? = null
    var copolymerConnectivity: List<CodeableConcept>? = null
    var modification: KotlinString? = null
    var _modification: Element? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        11 ->
          `class` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          geometry =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          copolymerConnectivity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 -> modification = decoder.decodeStringElement(descriptor, i)
        15 ->
          _modification =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          monomerSet =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstancePolymerMonomerSetSerializer.listSerializer,
              null,
            )
        17 ->
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
      identifier = identifier,
      `class` = `class`,
      geometry = geometry,
      copolymerConnectivity = copolymerConnectivity ?: listOf(),
      modification = R5String.of(modification, _modification),
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
      IdentifierSerializer,
      value.identifier,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.`class`,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.geometry,
    )
    if (value.copolymerConnectivity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.copolymerConnectivity,
      )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.modification?.value)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.modification)
    if (value.monomerSet.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        SubstancePolymerMonomerSetSerializer.listSerializer,
        value.monomerSet,
      )
    if (value.repeat.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        SubstancePolymerRepeatSerializer.listSerializer,
        value.repeat,
      )
  }
}
