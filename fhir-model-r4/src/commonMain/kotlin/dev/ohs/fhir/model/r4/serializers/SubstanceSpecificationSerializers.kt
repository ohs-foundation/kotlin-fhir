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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceSpecification
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

internal object SubstanceSpecificationMoietySerializer :
  KSerializer<SubstanceSpecification.Moiety> {
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
    }

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Moiety>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Moiety =
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
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Moiety: " + i)
        }
      }
      SubstanceSpecification.Moiety(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        role = role,
        identifier = identifier,
        name = R4String.of(name, _name),
        stereochemistry = stereochemistry,
        opticalActivity = opticalActivity,
        molecularFormula = R4String.of(molecularFormula, _molecularFormula),
        amount =
          SubstanceSpecification.Moiety.Amount.from(
            amountQuantity,
            R4String.of(amountString, _amountString),
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Moiety) {
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
        is SubstanceSpecification.Moiety.Amount.Quantity -> {
          encodeSerializableElement(descriptor, 11, QuantitySerializer, choice.value)
        }
        is SubstanceSpecification.Moiety.Amount.String -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value)
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
      }
    }
  }
}

internal object SubstanceSpecificationPropertySerializer :
  KSerializer<SubstanceSpecification.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("parameters", KotlinString.serializer().descriptor)
      optionalElement("_parameters", ElementSerializer.descriptor)
      optionalElement("definingSubstanceReference", ReferenceSerializer.descriptor)
      optionalElement("definingSubstanceCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("amountQuantity", QuantitySerializer.descriptor)
      optionalElement("amountString", KotlinString.serializer().descriptor)
      optionalElement("_amountString", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Property>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Property =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var code: CodeableConcept? = null
      var parameters: KotlinString? = null
      var _parameters: Element? = null
      var definingSubstanceReference: Reference? = null
      var definingSubstanceCodeableConcept: CodeableConcept? = null
      var amountQuantity: Quantity? = null
      var amountString: KotlinString? = null
      var _amountString: Element? = null
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
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> parameters = decodeStringElement(descriptor, i)
          6 ->
            _parameters = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            definingSubstanceReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            definingSubstanceCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            amountQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          10 -> amountString = decodeStringElement(descriptor, i)
          11 ->
            _amountString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      SubstanceSpecification.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category = category,
        code = code,
        parameters = R4String.of(parameters, _parameters),
        definingSubstance =
          SubstanceSpecification.Property.DefiningSubstance.from(
            definingSubstanceReference,
            definingSubstanceCodeableConcept,
          ),
        amount =
          SubstanceSpecification.Property.Amount.from(
            amountQuantity,
            R4String.of(amountString, _amountString),
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Property) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.code)
      encodeStringIfNotNull(descriptor, 5, value.parameters?.value)
      encodeElementIfNotNull(descriptor, 6, value.parameters)
      when (val choice = value.definingSubstance) {
        null -> {}
        is SubstanceSpecification.Property.DefiningSubstance.Reference -> {
          encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
        }
        is SubstanceSpecification.Property.DefiningSubstance.CodeableConcept -> {
          encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
        }
      }
      when (val choice = value.amount) {
        null -> {}
        is SubstanceSpecification.Property.Amount.Quantity -> {
          encodeSerializableElement(descriptor, 9, QuantitySerializer, choice.value)
        }
        is SubstanceSpecification.Property.Amount.String -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
      }
    }
  }
}

internal object SubstanceSpecificationStructureSerializer :
  KSerializer<SubstanceSpecification.Structure> {
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
        "isotope",
        SubstanceSpecificationStructureIsotopeSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "molecularWeight",
        SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.descriptor,
      )
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "representation",
        SubstanceSpecificationStructureRepresentationSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Structure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure =
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
      var isotope: List<SubstanceSpecification.Structure.Isotope>? = null
      var molecularWeight: SubstanceSpecification.Structure.Isotope.MolecularWeight? = null
      var source: List<Reference>? = null
      var representation: List<SubstanceSpecification.Structure.Representation>? = null
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
            isotope =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceSpecificationStructureIsotopeSerializer.listSerializer,
                null,
              )
          10 ->
            molecularWeight =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceSpecificationStructureIsotopeMolecularWeightSerializer,
                null,
              )
          11 ->
            source =
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
                SubstanceSpecificationStructureRepresentationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Structure: " + i)
        }
      }
      SubstanceSpecification.Structure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        stereochemistry = stereochemistry,
        opticalActivity = opticalActivity,
        molecularFormula = R4String.of(molecularFormula, _molecularFormula),
        molecularFormulaByMoiety = R4String.of(molecularFormulaByMoiety, _molecularFormulaByMoiety),
        isotope = isotope ?: listOf(),
        molecularWeight = molecularWeight,
        source = source ?: listOf(),
        representation = representation ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure) {
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
      if (value.isotope.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          SubstanceSpecificationStructureIsotopeSerializer.listSerializer,
          value.isotope,
        )
      encodeSerializableIfNotNull(
        descriptor,
        10,
        SubstanceSpecificationStructureIsotopeMolecularWeightSerializer,
        value.molecularWeight,
      )
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 11, ReferenceSerializer.listSerializer, value.source)
      if (value.representation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          SubstanceSpecificationStructureRepresentationSerializer.listSerializer,
          value.representation,
        )
    }
  }
}

internal object SubstanceSpecificationStructureIsotopeSerializer :
  KSerializer<SubstanceSpecification.Structure.Isotope> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Isotope") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("name", CodeableConceptSerializer.descriptor)
      optionalElement("substitution", CodeableConceptSerializer.descriptor)
      optionalElement("halfLife", QuantitySerializer.descriptor)
      optionalElement(
        "molecularWeight",
        SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Structure.Isotope>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure.Isotope =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: Identifier? = null
      var name: CodeableConcept? = null
      var substitution: CodeableConcept? = null
      var halfLife: Quantity? = null
      var molecularWeight: SubstanceSpecification.Structure.Isotope.MolecularWeight? = null
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
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 ->
            name = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            substitution =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> halfLife = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          7 ->
            molecularWeight =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceSpecificationStructureIsotopeMolecularWeightSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Isotope: " + i)
        }
      }
      SubstanceSpecification.Structure.Isotope(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier,
        name = name,
        substitution = substitution,
        halfLife = halfLife,
        molecularWeight = molecularWeight,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure.Isotope) {
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
      encodeSerializableIfNotNull(descriptor, 3, IdentifierSerializer, value.identifier)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.name)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.substitution)
      encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.halfLife)
      encodeSerializableIfNotNull(
        descriptor,
        7,
        SubstanceSpecificationStructureIsotopeMolecularWeightSerializer,
        value.molecularWeight,
      )
    }
  }
}

internal object SubstanceSpecificationStructureIsotopeMolecularWeightSerializer :
  KSerializer<SubstanceSpecification.Structure.Isotope.MolecularWeight> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MolecularWeight") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("amount", QuantitySerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<SubstanceSpecification.Structure.Isotope.MolecularWeight>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): SubstanceSpecification.Structure.Isotope.MolecularWeight =
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
      SubstanceSpecification.Structure.Isotope.MolecularWeight(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        method = method,
        type = type,
        amount = amount,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Structure.Isotope.MolecularWeight,
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.method)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.amount)
    }
  }
}

internal object SubstanceSpecificationStructureRepresentationSerializer :
  KSerializer<SubstanceSpecification.Structure.Representation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Representation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("representation", KotlinString.serializer().descriptor)
      optionalElement("_representation", ElementSerializer.descriptor)
      optionalElement("attachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Structure.Representation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure.Representation =
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
          else -> throw SerializationException("Unexpected index decoding Representation: " + i)
        }
      }
      SubstanceSpecification.Structure.Representation(
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
    `value`: SubstanceSpecification.Structure.Representation,
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

internal object SubstanceSpecificationCodeSerializer : KSerializer<SubstanceSpecification.Code> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Code") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
      optionalElement("statusDate", KotlinString.serializer().descriptor)
      optionalElement("_statusDate", ElementSerializer.descriptor)
      optionalElement("comment", KotlinString.serializer().descriptor)
      optionalElement("_comment", ElementSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Code>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Code =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var status: CodeableConcept? = null
      var statusDate: KotlinString? = null
      var _statusDate: Element? = null
      var comment: KotlinString? = null
      var _comment: Element? = null
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
          7 -> comment = decodeStringElement(descriptor, i)
          8 -> _comment = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
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
      SubstanceSpecification.Code(
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
        comment = R4String.of(comment, _comment),
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Code) {
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
      encodeStringIfNotNull(descriptor, 7, value.comment?.value)
      encodeElementIfNotNull(descriptor, 8, value.comment)
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 9, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceSpecificationNameSerializer : KSerializer<SubstanceSpecification.Name> {
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
        listSerialDescriptor(lazyDescriptor { SubstanceSpecificationNameSerializer.descriptor }),
      )
      optionalElement(
        "translation",
        listSerialDescriptor(lazyDescriptor { SubstanceSpecificationNameSerializer.descriptor }),
      )
      optionalElement(
        "official",
        SubstanceSpecificationNameOfficialSerializer.listSerializer.descriptor,
      )
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Name>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Name =
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
      var synonym: List<SubstanceSpecification.Name>? = null
      var translation: List<SubstanceSpecification.Name>? = null
      var official: List<SubstanceSpecification.Name.Official>? = null
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
                SubstanceSpecificationNameSerializer.listSerializer,
                null,
              )
          13 ->
            translation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceSpecificationNameSerializer.listSerializer,
                null,
              )
          14 ->
            official =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceSpecificationNameOfficialSerializer.listSerializer,
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
      SubstanceSpecification.Name(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name =
          R4String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on SubstanceSpecification.Name"
            ),
        type = type,
        status = status,
        preferred = R4Boolean.of(preferred, _preferred),
        language = language ?: listOf(),
        domain = domain ?: listOf(),
        jurisdiction = jurisdiction ?: listOf(),
        synonym = synonym ?: listOf(),
        translation = translation ?: listOf(),
        official = official ?: listOf(),
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name) {
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
          SubstanceSpecificationNameSerializer.listSerializer,
          value.synonym,
        )
      if (value.translation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          SubstanceSpecificationNameSerializer.listSerializer,
          value.translation,
        )
      if (value.official.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          SubstanceSpecificationNameOfficialSerializer.listSerializer,
          value.official,
        )
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 15, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceSpecificationNameOfficialSerializer :
  KSerializer<SubstanceSpecification.Name.Official> {
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

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Name.Official>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Name.Official =
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
      SubstanceSpecification.Name.Official(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        authority = authority,
        status = status,
        date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name.Official) {
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

internal object SubstanceSpecificationRelationshipSerializer :
  KSerializer<SubstanceSpecification.Relationship> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Relationship") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("substanceReference", ReferenceSerializer.descriptor)
      optionalElement("substanceCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("relationship", CodeableConceptSerializer.descriptor)
      optionalElement("isDefining", KotlinBoolean.serializer().descriptor)
      optionalElement("_isDefining", ElementSerializer.descriptor)
      optionalElement("amountQuantity", QuantitySerializer.descriptor)
      optionalElement("amountRange", RangeSerializer.descriptor)
      optionalElement("amountRatio", RatioSerializer.descriptor)
      optionalElement("amountString", KotlinString.serializer().descriptor)
      optionalElement("_amountString", ElementSerializer.descriptor)
      optionalElement("amountRatioLowLimit", RatioSerializer.descriptor)
      optionalElement("amountType", CodeableConceptSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSpecification.Relationship>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Relationship =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var substanceReference: Reference? = null
      var substanceCodeableConcept: CodeableConcept? = null
      var relationship: CodeableConcept? = null
      var isDefining: KotlinBoolean? = null
      var _isDefining: Element? = null
      var amountQuantity: Quantity? = null
      var amountRange: Range? = null
      var amountRatio: Ratio? = null
      var amountString: KotlinString? = null
      var _amountString: Element? = null
      var amountRatioLowLimit: Ratio? = null
      var amountType: CodeableConcept? = null
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
            substanceReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            substanceCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            relationship =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> isDefining = decodeBooleanElement(descriptor, i)
          7 ->
            _isDefining = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            amountQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> amountRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          10 ->
            amountRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          11 -> amountString = decodeStringElement(descriptor, i)
          12 ->
            _amountString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            amountRatioLowLimit =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          14 ->
            amountType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          15 ->
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
      SubstanceSpecification.Relationship(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        substance =
          SubstanceSpecification.Relationship.Substance.from(
            substanceReference,
            substanceCodeableConcept,
          ),
        relationship = relationship,
        isDefining = R4Boolean.of(isDefining, _isDefining),
        amount =
          SubstanceSpecification.Relationship.Amount.from(
            amountQuantity,
            amountRange,
            amountRatio,
            R4String.of(amountString, _amountString),
          ),
        amountRatioLowLimit = amountRatioLowLimit,
        amountType = amountType,
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Relationship) {
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
      when (val choice = value.substance) {
        null -> {}
        is SubstanceSpecification.Relationship.Substance.Reference -> {
          encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
        }
        is SubstanceSpecification.Relationship.Substance.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.relationship)
      encodeBooleanIfNotNull(descriptor, 6, value.isDefining?.value)
      encodeElementIfNotNull(descriptor, 7, value.isDefining)
      when (val choice = value.amount) {
        null -> {}
        is SubstanceSpecification.Relationship.Amount.Quantity -> {
          encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
        }
        is SubstanceSpecification.Relationship.Amount.Range -> {
          encodeSerializableElement(descriptor, 9, RangeSerializer, choice.value)
        }
        is SubstanceSpecification.Relationship.Amount.Ratio -> {
          encodeSerializableElement(descriptor, 10, RatioSerializer, choice.value)
        }
        is SubstanceSpecification.Relationship.Amount.String -> {
          encodeStringIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 13, RatioSerializer, value.amountRatioLowLimit)
      encodeSerializableIfNotNull(descriptor, 14, CodeableConceptSerializer, value.amountType)
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 15, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceSpecificationSerializer : FhirResourceSerializer<SubstanceSpecification> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstanceSpecification")

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
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.optionalElement("domain", CodeableConceptSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("comment", KotlinString.serializer().descriptor)
    b.optionalElement("_comment", ElementSerializer.descriptor)
    b.optionalElement("moiety", SubstanceSpecificationMoietySerializer.listSerializer.descriptor)
    b.optionalElement(
      "property",
      SubstanceSpecificationPropertySerializer.listSerializer.descriptor,
    )
    b.optionalElement("referenceInformation", ReferenceSerializer.descriptor)
    b.optionalElement("structure", SubstanceSpecificationStructureSerializer.descriptor)
    b.optionalElement("code", SubstanceSpecificationCodeSerializer.listSerializer.descriptor)
    b.optionalElement("name", SubstanceSpecificationNameSerializer.listSerializer.descriptor)
    b.optionalElement(
      "molecularWeight",
      SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "relationship",
      SubstanceSpecificationRelationshipSerializer.listSerializer.descriptor,
    )
    b.optionalElement("nucleicAcid", ReferenceSerializer.descriptor)
    b.optionalElement("polymer", ReferenceSerializer.descriptor)
    b.optionalElement("protein", ReferenceSerializer.descriptor)
    b.optionalElement("sourceMaterial", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubstanceSpecification {
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
    var type: CodeableConcept? = null
    var status: CodeableConcept? = null
    var domain: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var source: List<Reference>? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var moiety: List<SubstanceSpecification.Moiety>? = null
    var `property`: List<SubstanceSpecification.Property>? = null
    var referenceInformation: Reference? = null
    var structure: SubstanceSpecification.Structure? = null
    var code: List<SubstanceSpecification.Code>? = null
    var name: List<SubstanceSpecification.Name>? = null
    var molecularWeight: List<SubstanceSpecification.Structure.Isotope.MolecularWeight>? = null
    var relationship: List<SubstanceSpecification.Relationship>? = null
    var nucleicAcid: Reference? = null
    var polymer: Reference? = null
    var protein: Reference? = null
    var sourceMaterial: Reference? = null
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
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          status =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          domain =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 -> description = decoder.decodeStringElement(descriptor, i)
        15 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          source =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 -> comment = decoder.decodeStringElement(descriptor, i)
        18 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          moiety =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationMoietySerializer.listSerializer,
              null,
            )
        20 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationPropertySerializer.listSerializer,
              null,
            )
        21 ->
          referenceInformation =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          structure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationStructureSerializer,
              null,
            )
        23 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationCodeSerializer.listSerializer,
              null,
            )
        24 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationNameSerializer.listSerializer,
              null,
            )
        25 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.listSerializer,
              null,
            )
        26 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationRelationshipSerializer.listSerializer,
              null,
            )
        27 ->
          nucleicAcid =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          polymer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          protein =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        30 ->
          sourceMaterial =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        else ->
          throw SerializationException("Unexpected index decoding SubstanceSpecification: " + i)
      }
    }
    return SubstanceSpecification(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      type = type,
      status = status,
      domain = domain,
      description = R4String.of(description, _description),
      source = source ?: listOf(),
      comment = R4String.of(comment, _comment),
      moiety = moiety ?: listOf(),
      `property` = `property` ?: listOf(),
      referenceInformation = referenceInformation,
      structure = structure,
      code = code ?: listOf(),
      name = name ?: listOf(),
      molecularWeight = molecularWeight ?: listOf(),
      relationship = relationship ?: listOf(),
      nucleicAcid = nucleicAcid,
      polymer = polymer,
      protein = protein,
      sourceMaterial = sourceMaterial,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceSpecification,
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
      value.type,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.domain,
    )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.description)
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.source,
      )
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.comment?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.comment)
    if (value.moiety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        SubstanceSpecificationMoietySerializer.listSerializer,
        value.moiety,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        SubstanceSpecificationPropertySerializer.listSerializer,
        value.`property`,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.referenceInformation,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      SubstanceSpecificationStructureSerializer,
      value.structure,
    )
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        SubstanceSpecificationCodeSerializer.listSerializer,
        value.code,
      )
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        SubstanceSpecificationNameSerializer.listSerializer,
        value.name,
      )
    if (value.molecularWeight.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.listSerializer,
        value.molecularWeight,
      )
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        SubstanceSpecificationRelationshipSerializer.listSerializer,
        value.relationship,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.nucleicAcid,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.polymer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.protein,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.sourceMaterial,
    )
  }
}
