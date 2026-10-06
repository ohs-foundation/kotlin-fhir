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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.SubstanceDefinition
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

internal object SubstanceDefinitionMoietySerializer : KSerializer<SubstanceDefinition.Moiety> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Moiety") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("stereochemistry", CodeableConceptSerializer.descriptor)
      optionalElement("opticalActivity", CodeableConceptSerializer.descriptor)
      optionalElement("molecularFormula", KotlinString.serializer().descriptor)
      optionalElement("_molecularFormula", ElementSerializer.descriptor)
      optionalElement("amountQuantity", QuantitySerializer.descriptor)
      optionalElement("amountString", KotlinString.serializer().descriptor)
      optionalElement("_amountString", ElementSerializer.descriptor)
      optionalElement("measurementType", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.Moiety>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Moiety =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var role: CodeableConcept? = null
      var identifier: Identifier? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var stereochemistry: CodeableConcept? = null
      var opticalActivity: CodeableConcept? = null
      var molecularFormula: KotlinString? = null
      var _molecularFormula: Element? = null
      var amountQuantity: Quantity? = null
      var amountString: KotlinString? = null
      var _amountString: Element? = null
      var measurementType: CodeableConcept? = null
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
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          5 -> name = decodeStringElement(descriptor, i)
          6 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            stereochemistry =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            opticalActivity =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 -> molecularFormula = decodeStringElement(descriptor, i)
          10 ->
            _molecularFormula =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            amountQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          12 -> amountString = decodeStringElement(descriptor, i)
          13 ->
            _amountString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            measurementType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Moiety: " + i)
        }
      }
      SubstanceDefinition.Moiety(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        role = role,
        identifier = identifier,
        name = R4bString.of(name, _name),
        stereochemistry = stereochemistry,
        opticalActivity = opticalActivity,
        molecularFormula = R4bString.of(molecularFormula, _molecularFormula),
        amount =
          SubstanceDefinition.Moiety.Amount.from(
            amountQuantity,
            R4bString.of(amountString, _amountString),
          ),
        measurementType = measurementType,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Moiety) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.role)
      encodeSerializableIfNotNull(descriptor, 4, IdentifierSerializer, value.identifier)
      encodeStringIfNotNull(descriptor, 5, value.name?.value)
      encodeElementIfNotNull(descriptor, 6, value.name)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.stereochemistry)
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.opticalActivity)
      encodeStringIfNotNull(descriptor, 9, value.molecularFormula?.value)
      encodeElementIfNotNull(descriptor, 10, value.molecularFormula)
      when (val choice = value.amount) {
        null -> {}
        is SubstanceDefinition.Moiety.Amount.Quantity -> {
          encodeSerializableElement(descriptor, 11, QuantitySerializer, choice.value)
        }
        is SubstanceDefinition.Moiety.Amount.String -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value)
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 14, CodeableConceptSerializer, value.measurementType)
    }
  }
}

internal object SubstanceDefinitionPropertySerializer : KSerializer<SubstanceDefinition.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.Property>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Property =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueDate: KotlinString? = null
      var _valueDate: Element? = null
      var valueBoolean: KotlinBoolean? = null
      var _valueBoolean: Element? = null
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
          5 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> valueDate = decodeStringElement(descriptor, i)
          7 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueBoolean = decodeBooleanElement(descriptor, i)
          9 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      SubstanceDefinition.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on SubstanceDefinition.Property"
            ),
        `value` =
          SubstanceDefinition.Property.Value.from(
            valueCodeableConcept,
            valueQuantity,
            Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
            R4bBoolean.of(valueBoolean, _valueBoolean),
            valueAttachment,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Property) {
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
        is SubstanceDefinition.Property.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is SubstanceDefinition.Property.Value.Quantity -> {
          encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
        }
        is SubstanceDefinition.Property.Value.Date -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is SubstanceDefinition.Property.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is SubstanceDefinition.Property.Value.Attachment -> {
          encodeSerializableElement(descriptor, 10, AttachmentSerializer, choice.value)
        }
      }
    }
  }
}

internal object SubstanceDefinitionMolecularWeightSerializer :
  KSerializer<SubstanceDefinition.MolecularWeight> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MolecularWeight") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("amount", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.MolecularWeight>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.MolecularWeight =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var method: CodeableConcept? = null
      var type: CodeableConcept? = null
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
            method =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> amount = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MolecularWeight: " + i)
        }
      }
      SubstanceDefinition.MolecularWeight(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        method = method,
        type = type,
        amount =
          amount
            ?: throw SerializationException(
              "Missing required property 'amount' on SubstanceDefinition.MolecularWeight"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.MolecularWeight) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.method)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeSerializableElement(descriptor, 5, QuantitySerializer, value.amount)
    }
  }
}

internal object SubstanceDefinitionStructureSerializer :
  KSerializer<SubstanceDefinition.Structure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Structure") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("stereochemistry", CodeableConceptSerializer.descriptor)
      optionalElement("opticalActivity", CodeableConceptSerializer.descriptor)
      optionalElement("molecularFormula", KotlinString.serializer().descriptor)
      optionalElement("_molecularFormula", ElementSerializer.descriptor)
      optionalElement("molecularFormulaByMoiety", KotlinString.serializer().descriptor)
      optionalElement("_molecularFormulaByMoiety", ElementSerializer.descriptor)
      optionalElement(
        "molecularWeight",
        lazyDescriptor { SubstanceDefinitionMolecularWeightSerializer.descriptor },
      )
      optionalElement("technique", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("sourceDocument", ReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "representation",
        SubstanceDefinitionStructureRepresentationSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.Structure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Structure =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var stereochemistry: CodeableConcept? = null
      var opticalActivity: CodeableConcept? = null
      var molecularFormula: KotlinString? = null
      var _molecularFormula: Element? = null
      var molecularFormulaByMoiety: KotlinString? = null
      var _molecularFormulaByMoiety: Element? = null
      var molecularWeight: SubstanceDefinition.MolecularWeight? = null
      var technique: List<CodeableConcept>? = null
      var sourceDocument: List<Reference>? = null
      var representation: List<SubstanceDefinition.Structure.Representation>? = null
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
            stereochemistry =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            opticalActivity =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> molecularFormula = decodeStringElement(descriptor, i)
          6 ->
            _molecularFormula =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> molecularFormulaByMoiety = decodeStringElement(descriptor, i)
          8 ->
            _molecularFormulaByMoiety =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            molecularWeight =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceDefinitionMolecularWeightSerializer,
                null,
              )
          10 ->
            technique =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          11 ->
            sourceDocument =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          12 ->
            representation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceDefinitionStructureRepresentationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Structure: " + i)
        }
      }
      SubstanceDefinition.Structure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        stereochemistry = stereochemistry,
        opticalActivity = opticalActivity,
        molecularFormula = R4bString.of(molecularFormula, _molecularFormula),
        molecularFormulaByMoiety =
          R4bString.of(molecularFormulaByMoiety, _molecularFormulaByMoiety),
        molecularWeight = molecularWeight,
        technique = technique ?: listOf(),
        sourceDocument = sourceDocument ?: listOf(),
        representation = representation ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.stereochemistry)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.opticalActivity)
      encodeStringIfNotNull(descriptor, 5, value.molecularFormula?.value)
      encodeElementIfNotNull(descriptor, 6, value.molecularFormula)
      encodeStringIfNotNull(descriptor, 7, value.molecularFormulaByMoiety?.value)
      encodeElementIfNotNull(descriptor, 8, value.molecularFormulaByMoiety)
      encodeSerializableIfNotNull(
        descriptor,
        9,
        SubstanceDefinitionMolecularWeightSerializer,
        value.molecularWeight,
      )
      if (value.technique.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CodeableConceptSerializer.listSerializer,
          value.technique,
        )
      if (value.sourceDocument.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          ReferenceSerializer.listSerializer,
          value.sourceDocument,
        )
      if (value.representation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          SubstanceDefinitionStructureRepresentationSerializer.listSerializer,
          value.representation,
        )
    }
  }
}

internal object SubstanceDefinitionStructureRepresentationSerializer :
  KSerializer<SubstanceDefinition.Structure.Representation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Representation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("representation", KotlinString.serializer().descriptor)
      optionalElement("_representation", ElementSerializer.descriptor)
      optionalElement("format", CodeableConceptSerializer.descriptor)
      optionalElement("document", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.Structure.Representation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Structure.Representation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var representation: KotlinString? = null
      var _representation: Element? = null
      var format: CodeableConcept? = null
      var document: Reference? = null
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
            document = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Representation: " + i)
        }
      }
      SubstanceDefinition.Structure.Representation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        representation = R4bString.of(representation, _representation),
        format = format,
        document = document,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure.Representation) {
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
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.document)
    }
  }
}

internal object SubstanceDefinitionCodeSerializer : KSerializer<SubstanceDefinition.Code> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Code") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
      optionalElement("statusDate", KotlinString.serializer().descriptor)
      optionalElement("_statusDate", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.Code>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Code =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var status: CodeableConcept? = null
      var statusDate: KotlinString? = null
      var _statusDate: Element? = null
      var note: List<Annotation>? = null
      var source: List<Reference>? = null
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
            status =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> statusDate = decodeStringElement(descriptor, i)
          6 ->
            _statusDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          8 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Code: " + i)
        }
      }
      SubstanceDefinition.Code(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        status = status,
        statusDate =
          DateTime.of(
            if (statusDate != null) FhirDateTime.fromString(statusDate) else null,
            _statusDate,
          ),
        note = note ?: listOf(),
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Code) {
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
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.status)
      encodeStringIfNotNull(descriptor, 5, value.statusDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.statusDate)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 7, AnnotationSerializer.listSerializer, value.note)
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 8, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceDefinitionNameSerializer : KSerializer<SubstanceDefinition.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Name") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
      optionalElement("preferred", KotlinBoolean.serializer().descriptor)
      optionalElement("_preferred", ElementSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("domain", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "synonym",
        listSerialDescriptor(lazyDescriptor { SubstanceDefinitionNameSerializer.descriptor }),
      )
      optionalElement(
        "translation",
        listSerialDescriptor(lazyDescriptor { SubstanceDefinitionNameSerializer.descriptor }),
      )
      optionalElement(
        "official",
        SubstanceDefinitionNameOfficialSerializer.listSerializer.descriptor,
      )
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.Name>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Name =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var type: CodeableConcept? = null
      var status: CodeableConcept? = null
      var preferred: KotlinBoolean? = null
      var _preferred: Element? = null
      var language: List<CodeableConcept>? = null
      var domain: List<CodeableConcept>? = null
      var jurisdiction: List<CodeableConcept>? = null
      var synonym: List<SubstanceDefinition.Name>? = null
      var translation: List<SubstanceDefinition.Name>? = null
      var official: List<SubstanceDefinition.Name.Official>? = null
      var source: List<Reference>? = null
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            status =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> preferred = decodeBooleanElement(descriptor, i)
          8 ->
            _preferred = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            language =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          10 ->
            domain =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          11 ->
            jurisdiction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          12 ->
            synonym =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceDefinitionNameSerializer.listSerializer,
                null,
              )
          13 ->
            translation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceDefinitionNameSerializer.listSerializer,
                null,
              )
          14 ->
            official =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceDefinitionNameOfficialSerializer.listSerializer,
                null,
              )
          15 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Name: " + i)
        }
      }
      SubstanceDefinition.Name(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R4bString.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on SubstanceDefinition.Name"
            ),
        type = type,
        status = status,
        preferred = R4bBoolean.of(preferred, _preferred),
        language = language ?: listOf(),
        domain = domain ?: listOf(),
        jurisdiction = jurisdiction ?: listOf(),
        synonym = synonym ?: listOf(),
        translation = translation ?: listOf(),
        official = official ?: listOf(),
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name) {
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
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.status)
      encodeBooleanIfNotNull(descriptor, 7, value.preferred?.value)
      encodeElementIfNotNull(descriptor, 8, value.preferred)
      if (value.language.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CodeableConceptSerializer.listSerializer,
          value.language,
        )
      if (value.domain.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CodeableConceptSerializer.listSerializer,
          value.domain,
        )
      if (value.jurisdiction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer.listSerializer,
          value.jurisdiction,
        )
      if (value.synonym.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          SubstanceDefinitionNameSerializer.listSerializer,
          value.synonym,
        )
      if (value.translation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          SubstanceDefinitionNameSerializer.listSerializer,
          value.translation,
        )
      if (value.official.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          SubstanceDefinitionNameOfficialSerializer.listSerializer,
          value.official,
        )
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 15, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceDefinitionNameOfficialSerializer :
  KSerializer<SubstanceDefinition.Name.Official> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Official") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("authority", CodeableConceptSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.Name.Official>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Name.Official =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var authority: CodeableConcept? = null
      var status: CodeableConcept? = null
      var date: KotlinString? = null
      var _date: Element? = null
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
            authority =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            status =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> date = decodeStringElement(descriptor, i)
          6 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Official: " + i)
        }
      }
      SubstanceDefinition.Name.Official(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        authority = authority,
        status = status,
        date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name.Official) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.authority)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.status)
      encodeStringIfNotNull(descriptor, 5, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.date)
    }
  }
}

internal object SubstanceDefinitionRelationshipSerializer :
  KSerializer<SubstanceDefinition.Relationship> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Relationship") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("substanceDefinitionReference", ReferenceSerializer.descriptor)
      optionalElement("substanceDefinitionCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("isDefining", KotlinBoolean.serializer().descriptor)
      optionalElement("_isDefining", ElementSerializer.descriptor)
      optionalElement("amountQuantity", QuantitySerializer.descriptor)
      optionalElement("amountRatio", RatioSerializer.descriptor)
      optionalElement("amountString", KotlinString.serializer().descriptor)
      optionalElement("_amountString", ElementSerializer.descriptor)
      optionalElement("ratioHighLimitAmount", RatioSerializer.descriptor)
      optionalElement("comparator", CodeableConceptSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.Relationship>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Relationship =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var substanceDefinitionReference: Reference? = null
      var substanceDefinitionCodeableConcept: CodeableConcept? = null
      var type: CodeableConcept? = null
      var isDefining: KotlinBoolean? = null
      var _isDefining: Element? = null
      var amountQuantity: Quantity? = null
      var amountRatio: Ratio? = null
      var amountString: KotlinString? = null
      var _amountString: Element? = null
      var ratioHighLimitAmount: Ratio? = null
      var comparator: CodeableConcept? = null
      var source: List<Reference>? = null
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
            substanceDefinitionReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            substanceDefinitionCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> isDefining = decodeBooleanElement(descriptor, i)
          7 ->
            _isDefining = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            amountQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> amountRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          10 -> amountString = decodeStringElement(descriptor, i)
          11 ->
            _amountString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            ratioHighLimitAmount =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          13 ->
            comparator =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          14 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Relationship: " + i)
        }
      }
      SubstanceDefinition.Relationship(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        substanceDefinition =
          SubstanceDefinition.Relationship.SubstanceDefinition.from(
            substanceDefinitionReference,
            substanceDefinitionCodeableConcept,
          ),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on SubstanceDefinition.Relationship"
            ),
        isDefining = R4bBoolean.of(isDefining, _isDefining),
        amount =
          SubstanceDefinition.Relationship.Amount.from(
            amountQuantity,
            amountRatio,
            R4bString.of(amountString, _amountString),
          ),
        ratioHighLimitAmount = ratioHighLimitAmount,
        comparator = comparator,
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Relationship) {
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
      when (val choice = value.substanceDefinition) {
        null -> {}
        is SubstanceDefinition.Relationship.SubstanceDefinition.Reference -> {
          encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
        }
        is SubstanceDefinition.Relationship.SubstanceDefinition.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
      }
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.type)
      encodeBooleanIfNotNull(descriptor, 6, value.isDefining?.value)
      encodeElementIfNotNull(descriptor, 7, value.isDefining)
      when (val choice = value.amount) {
        null -> {}
        is SubstanceDefinition.Relationship.Amount.Quantity -> {
          encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
        }
        is SubstanceDefinition.Relationship.Amount.Ratio -> {
          encodeSerializableElement(descriptor, 9, RatioSerializer, choice.value)
        }
        is SubstanceDefinition.Relationship.Amount.String -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 12, RatioSerializer, value.ratioHighLimitAmount)
      encodeSerializableIfNotNull(descriptor, 13, CodeableConceptSerializer, value.comparator)
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 14, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceDefinitionSourceMaterialSerializer :
  KSerializer<SubstanceDefinition.SourceMaterial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SourceMaterial") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("genus", CodeableConceptSerializer.descriptor)
      optionalElement("species", CodeableConceptSerializer.descriptor)
      optionalElement("part", CodeableConceptSerializer.descriptor)
      optionalElement("countryOfOrigin", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceDefinition.SourceMaterial>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceDefinition.SourceMaterial =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var genus: CodeableConcept? = null
      var species: CodeableConcept? = null
      var part: CodeableConcept? = null
      var countryOfOrigin: List<CodeableConcept>? = null
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
            genus =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            species =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            part = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            countryOfOrigin =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SourceMaterial: " + i)
        }
      }
      SubstanceDefinition.SourceMaterial(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        genus = genus,
        species = species,
        part = part,
        countryOfOrigin = countryOfOrigin ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.SourceMaterial) {
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
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.genus)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.species)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.part)
      if (value.countryOfOrigin.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.countryOfOrigin,
        )
    }
  }
}

internal object SubstanceDefinitionSerializer : FhirResourceSerializer<SubstanceDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstanceDefinition")

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
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.optionalElement("classification", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("domain", CodeableConceptSerializer.descriptor)
    b.optionalElement("grade", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("informationSource", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("supplier", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("moiety", SubstanceDefinitionMoietySerializer.listSerializer.descriptor)
    b.optionalElement("property", SubstanceDefinitionPropertySerializer.listSerializer.descriptor)
    b.optionalElement(
      "molecularWeight",
      SubstanceDefinitionMolecularWeightSerializer.listSerializer.descriptor,
    )
    b.optionalElement("structure", SubstanceDefinitionStructureSerializer.descriptor)
    b.optionalElement("code", SubstanceDefinitionCodeSerializer.listSerializer.descriptor)
    b.optionalElement("name", SubstanceDefinitionNameSerializer.listSerializer.descriptor)
    b.optionalElement(
      "relationship",
      SubstanceDefinitionRelationshipSerializer.listSerializer.descriptor,
    )
    b.optionalElement("sourceMaterial", SubstanceDefinitionSourceMaterialSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubstanceDefinition {
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
    var version: KotlinString? = null
    var _version: Element? = null
    var status: CodeableConcept? = null
    var classification: List<CodeableConcept>? = null
    var domain: CodeableConcept? = null
    var grade: List<CodeableConcept>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var informationSource: List<Reference>? = null
    var note: List<Annotation>? = null
    var manufacturer: List<Reference>? = null
    var supplier: List<Reference>? = null
    var moiety: List<SubstanceDefinition.Moiety>? = null
    var `property`: List<SubstanceDefinition.Property>? = null
    var molecularWeight: List<SubstanceDefinition.MolecularWeight>? = null
    var structure: SubstanceDefinition.Structure? = null
    var code: List<SubstanceDefinition.Code>? = null
    var name: List<SubstanceDefinition.Name>? = null
    var relationship: List<SubstanceDefinition.Relationship>? = null
    var sourceMaterial: SubstanceDefinition.SourceMaterial? = null
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
        11 -> version = decoder.decodeStringElement(descriptor, i)
        12 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          status =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          domain =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          grade =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 -> description = decoder.decodeStringElement(descriptor, i)
        18 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          informationSource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        21 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          supplier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          moiety =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionMoietySerializer.listSerializer,
              null,
            )
        24 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionPropertySerializer.listSerializer,
              null,
            )
        25 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionMolecularWeightSerializer.listSerializer,
              null,
            )
        26 ->
          structure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionStructureSerializer,
              null,
            )
        27 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionCodeSerializer.listSerializer,
              null,
            )
        28 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionNameSerializer.listSerializer,
              null,
            )
        29 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionRelationshipSerializer.listSerializer,
              null,
            )
        30 ->
          sourceMaterial =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionSourceMaterialSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SubstanceDefinition: " + i)
      }
    }
    return SubstanceDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      status = status,
      classification = classification ?: listOf(),
      domain = domain,
      grade = grade ?: listOf(),
      description = Markdown.of(description, _description),
      informationSource = informationSource ?: listOf(),
      note = note ?: listOf(),
      manufacturer = manufacturer ?: listOf(),
      supplier = supplier ?: listOf(),
      moiety = moiety ?: listOf(),
      `property` = `property` ?: listOf(),
      molecularWeight = molecularWeight ?: listOf(),
      structure = structure,
      code = code ?: listOf(),
      name = name ?: listOf(),
      relationship = relationship ?: listOf(),
      sourceMaterial = sourceMaterial,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.version)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.classification,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.domain,
    )
    if (value.grade.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.grade,
      )
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.description)
    if (value.informationSource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.informationSource,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manufacturer,
      )
    if (value.supplier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supplier,
      )
    if (value.moiety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        SubstanceDefinitionMoietySerializer.listSerializer,
        value.moiety,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        SubstanceDefinitionPropertySerializer.listSerializer,
        value.`property`,
      )
    if (value.molecularWeight.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        SubstanceDefinitionMolecularWeightSerializer.listSerializer,
        value.molecularWeight,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      SubstanceDefinitionStructureSerializer,
      value.structure,
    )
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        SubstanceDefinitionCodeSerializer.listSerializer,
        value.code,
      )
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        SubstanceDefinitionNameSerializer.listSerializer,
        value.name,
      )
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        SubstanceDefinitionRelationshipSerializer.listSerializer,
        value.relationship,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      SubstanceDefinitionSourceMaterialSerializer,
      value.sourceMaterial,
    )
  }
}
