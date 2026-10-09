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

internal object SubstanceSpecificationMoietySerializer :
  FhirSerializer<SubstanceSpecification.Moiety> {
  override val descriptor: SerialDescriptor = buildDescriptor("Moiety", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Moiety>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.strPrim("name")
    b.optionalElement("stereochemistry", CodeableConceptSerializer.descriptor)
    b.optionalElement("opticalActivity", CodeableConceptSerializer.descriptor)
    b.strPrim("molecularFormula")
    b.optionalElement("amountQuantity", QuantitySerializer.descriptor)
    b.strPrim("amountString")
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Moiety {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        5 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          stereochemistry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          opticalActivity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 -> molecularFormula = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _molecularFormula =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          amountQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        12 -> amountString = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _amountString =
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
    return SubstanceSpecification.Moiety(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      value.role,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.name)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.stereochemistry,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.opticalActivity,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.molecularFormula?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.molecularFormula)
    when (val choice = value.amount) {
      null -> {}
      is SubstanceSpecification.Moiety.Amount.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 11, QuantitySerializer, choice.value)
      }
      is SubstanceSpecification.Moiety.Amount.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationPropertySerializer :
  FhirSerializer<SubstanceSpecification.Property> {
  override val descriptor: SerialDescriptor = buildDescriptor("Property", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Property>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.strPrim("parameters")
    b.optionalElement("definingSubstanceReference", ReferenceSerializer.descriptor)
    b.optionalElement("definingSubstanceCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("amountQuantity", QuantitySerializer.descriptor)
    b.strPrim("amountString")
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Property {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> parameters = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _parameters =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          definingSubstanceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 ->
          definingSubstanceCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          amountQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        10 -> amountString = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _amountString =
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
    return SubstanceSpecification.Property(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.parameters?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.parameters)
    when (val choice = value.definingSubstance) {
      null -> {}
      is SubstanceSpecification.Property.DefiningSubstance.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
      is SubstanceSpecification.Property.DefiningSubstance.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    when (val choice = value.amount) {
      null -> {}
      is SubstanceSpecification.Property.Amount.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, QuantitySerializer, choice.value)
      }
      is SubstanceSpecification.Property.Amount.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationStructureSerializer :
  FhirSerializer<SubstanceSpecification.Structure> {
  override val descriptor: SerialDescriptor = buildDescriptor("Structure", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Structure>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("stereochemistry", CodeableConceptSerializer.descriptor)
    b.optionalElement("opticalActivity", CodeableConceptSerializer.descriptor)
    b.strPrim("molecularFormula")
    b.strPrim("molecularFormulaByMoiety")
    b.optionalElement(
      "isotope",
      SubstanceSpecificationStructureIsotopeSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "molecularWeight",
      SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.descriptor,
    )
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "representation",
      SubstanceSpecificationStructureRepresentationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          stereochemistry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          opticalActivity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> molecularFormula = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _molecularFormula =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> molecularFormulaByMoiety = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _molecularFormulaByMoiety =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          isotope =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationStructureIsotopeSerializer.listSerializer,
              null,
            )
        10 ->
          molecularWeight =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationStructureIsotopeMolecularWeightSerializer,
              null,
            )
        11 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          representation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationStructureRepresentationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceSpecification.Structure(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      stereochemistry = stereochemistry,
      opticalActivity = opticalActivity,
      molecularFormula = R4String.of(molecularFormula, _molecularFormula),
      molecularFormulaByMoiety = R4String.of(molecularFormulaByMoiety, _molecularFormulaByMoiety),
      isotope = listOrEmpty(isotope),
      molecularWeight = molecularWeight,
      source = listOrEmpty(source),
      representation = listOrEmpty(representation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure) {
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
      value.stereochemistry,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.opticalActivity,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.molecularFormula?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.molecularFormula)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.molecularFormulaByMoiety?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.molecularFormulaByMoiety)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      SubstanceSpecificationStructureIsotopeSerializer.listSerializer,
      value.isotope,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      SubstanceSpecificationStructureIsotopeMolecularWeightSerializer,
      value.molecularWeight,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ReferenceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      SubstanceSpecificationStructureRepresentationSerializer.listSerializer,
      value.representation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationStructureIsotopeSerializer :
  FhirSerializer<SubstanceSpecification.Structure.Isotope> {
  override val descriptor: SerialDescriptor = buildDescriptor("Isotope", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Structure.Isotope>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("name", CodeableConceptSerializer.descriptor)
    b.optionalElement("substitution", CodeableConceptSerializer.descriptor)
    b.optionalElement("halfLife", QuantitySerializer.descriptor)
    b.optionalElement(
      "molecularWeight",
      SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure.Isotope {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var name: CodeableConcept? = null
    var substitution: CodeableConcept? = null
    var halfLife: Quantity? = null
    var molecularWeight: SubstanceSpecification.Structure.Isotope.MolecularWeight? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        4 ->
          name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          substitution =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          halfLife =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        7 ->
          molecularWeight =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationStructureIsotopeMolecularWeightSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceSpecification.Structure.Isotope(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = identifier,
      name = name,
      substitution = substitution,
      halfLife = halfLife,
      molecularWeight = molecularWeight,
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure.Isotope) {
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
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.name,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.substitution,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.halfLife)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      SubstanceSpecificationStructureIsotopeMolecularWeightSerializer,
      value.molecularWeight,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationStructureIsotopeMolecularWeightSerializer :
  FhirSerializer<SubstanceSpecification.Structure.Isotope.MolecularWeight> {
  override val descriptor: SerialDescriptor = buildDescriptor("MolecularWeight", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<SubstanceSpecification.Structure.Isotope.MolecularWeight>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", QuantitySerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): SubstanceSpecification.Structure.Isotope.MolecularWeight {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var method: CodeableConcept? = null
    var type: CodeableConcept? = null
    var amount: Quantity? = null
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
          method =
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
        5 ->
          amount =
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
    return SubstanceSpecification.Structure.Isotope.MolecularWeight(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      method = method,
      type = type,
      amount = amount,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Structure.Isotope.MolecularWeight,
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
      value.method,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.amount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationStructureRepresentationSerializer :
  FhirSerializer<SubstanceSpecification.Structure.Representation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Representation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Structure.Representation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("representation")
    b.optionalElement("attachment", AttachmentSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure.Representation {
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
    return SubstanceSpecification.Structure.Representation(
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
    `value`: SubstanceSpecification.Structure.Representation,
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

internal object SubstanceSpecificationCodeSerializer : FhirSerializer<SubstanceSpecification.Code> {
  override val descriptor: SerialDescriptor = buildDescriptor("Code", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Code>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.strPrim("statusDate")
    b.strPrim("comment")
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Code {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var status: CodeableConcept? = null
    var statusDate: FhirDateTime? = null
    var _statusDate: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var source: List<Reference>? = null
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          statusDate = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _statusDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          source =
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
    return SubstanceSpecification.Code(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = code,
      status = status,
      statusDate = DateTime.of(statusDate, _statusDate),
      comment = R4String.of(comment, _comment),
      source = listOrEmpty(source),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Code) {
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
      value.code,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.statusDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.statusDate)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.comment)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      ReferenceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationNameSerializer : FhirSerializer<SubstanceSpecification.Name> {
  override val descriptor: SerialDescriptor = buildDescriptor("Name", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Name>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.boolPrim("preferred")
    b.optionalElement("language", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("domain", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "synonym",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.SubstanceSpecificationNameSerializer)),
    )
    b.optionalElement(
      "translation",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.SubstanceSpecificationNameSerializer)),
    )
    b.optionalElement(
      "official",
      SubstanceSpecificationNameOfficialSerializer.listSerializer.descriptor,
    )
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Name {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 -> preferred = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _preferred =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        10 ->
          domain =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          synonym =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationNameSerializer.listSerializer,
              null,
            )
        13 ->
          translation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationNameSerializer.listSerializer,
              null,
            )
        14 ->
          official =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationNameOfficialSerializer.listSerializer,
              null,
            )
        15 ->
          source =
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
    return SubstanceSpecification.Name(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R4String.of(name, _name), "SubstanceSpecification.Name", "name"),
      type = type,
      status = status,
      preferred = R4Boolean.of(preferred, _preferred),
      language = listOrEmpty(language),
      domain = listOrEmpty(domain),
      jurisdiction = listOrEmpty(jurisdiction),
      synonym = listOrEmpty(synonym),
      translation = listOrEmpty(translation),
      official = listOrEmpty(official),
      source = listOrEmpty(source),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, value.preferred?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.preferred)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CodeableConceptSerializer.listSerializer,
      value.language,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      CodeableConceptSerializer.listSerializer,
      value.domain,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      SubstanceSpecificationNameSerializer.listSerializer,
      value.synonym,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      SubstanceSpecificationNameSerializer.listSerializer,
      value.translation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      SubstanceSpecificationNameOfficialSerializer.listSerializer,
      value.official,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      ReferenceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationNameOfficialSerializer :
  FhirSerializer<SubstanceSpecification.Name.Official> {
  override val descriptor: SerialDescriptor = buildDescriptor("Official", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Name.Official>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("authority", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.strPrim("date")
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Name.Official {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var authority: CodeableConcept? = null
    var status: CodeableConcept? = null
    var date: FhirDateTime? = null
    var _date: Element? = null
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
          authority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _date =
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
    return SubstanceSpecification.Name.Official(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      authority = authority,
      status = status,
      date = DateTime.of(date, _date),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name.Official) {
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
      value.authority,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.date)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationRelationshipSerializer :
  FhirSerializer<SubstanceSpecification.Relationship> {
  override val descriptor: SerialDescriptor = buildDescriptor("Relationship", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceSpecification.Relationship>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("substanceReference", ReferenceSerializer.descriptor)
    b.optionalElement("substanceCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("relationship", CodeableConceptSerializer.descriptor)
    b.boolPrim("isDefining")
    b.optionalElement("amountQuantity", QuantitySerializer.descriptor)
    b.optionalElement("amountRange", RangeSerializer.descriptor)
    b.optionalElement("amountRatio", RatioSerializer.descriptor)
    b.strPrim("amountString")
    b.optionalElement("amountRatioLowLimit", RatioSerializer.descriptor)
    b.optionalElement("amountType", CodeableConceptSerializer.descriptor)
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Relationship {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          substanceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          substanceCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> isDefining = compositeDecoder.decodeBooleanElement(descriptor, i)
        7 ->
          _isDefining =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          amountQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        9 ->
          amountRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        10 ->
          amountRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        11 -> amountString = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _amountString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          amountRatioLowLimit =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        14 ->
          amountType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          source =
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
    return SubstanceSpecification.Relationship(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      source = listOrEmpty(source),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Relationship) {
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
    when (val choice = value.substance) {
      null -> {}
      is SubstanceSpecification.Relationship.Substance.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
      }
      is SubstanceSpecification.Relationship.Substance.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.relationship,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 6, value.isDefining?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.isDefining)
    when (val choice = value.amount) {
      null -> {}
      is SubstanceSpecification.Relationship.Amount.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
      }
      is SubstanceSpecification.Relationship.Amount.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, RangeSerializer, choice.value)
      }
      is SubstanceSpecification.Relationship.Amount.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 10, RatioSerializer, choice.value)
      }
      is SubstanceSpecification.Relationship.Amount.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 11, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      RatioSerializer,
      value.amountRatioLowLimit,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      CodeableConceptSerializer,
      value.amountType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      ReferenceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceSpecificationSerializer : FhirResourceSerializer<SubstanceSpecification> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstanceSpecification")

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
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.optionalElement("domain", CodeableConceptSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("comment")
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
    compositeDecoder: CompositeDecoder,
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
              IdentifierSerializer,
              null,
            )
        11 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          domain =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          moiety =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationMoietySerializer.listSerializer,
              null,
            )
        20 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationPropertySerializer.listSerializer,
              null,
            )
        21 ->
          referenceInformation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          structure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationStructureSerializer,
              null,
            )
        23 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationCodeSerializer.listSerializer,
              null,
            )
        24 ->
          name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationNameSerializer.listSerializer,
              null,
            )
        25 ->
          molecularWeight =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.listSerializer,
              null,
            )
        26 ->
          relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSpecificationRelationshipSerializer.listSerializer,
              null,
            )
        27 ->
          nucleicAcid =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        28 ->
          polymer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        29 ->
          protein =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        30 ->
          sourceMaterial =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return SubstanceSpecification(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = identifier,
      type = type,
      status = status,
      domain = domain,
      description = R4String.of(description, _description),
      source = listOrEmpty(source),
      comment = R4String.of(comment, _comment),
      moiety = listOrEmpty(moiety),
      `property` = listOrEmpty(`property`),
      referenceInformation = referenceInformation,
      structure = structure,
      code = listOrEmpty(code),
      name = listOrEmpty(name),
      molecularWeight = listOrEmpty(molecularWeight),
      relationship = listOrEmpty(relationship),
      nucleicAcid = nucleicAcid,
      polymer = polymer,
      protein = protein,
      sourceMaterial = sourceMaterial,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceSpecification,
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
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.domain,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.comment)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      SubstanceSpecificationMoietySerializer.listSerializer,
      value.moiety,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20 + descriptorOffset,
      SubstanceSpecificationPropertySerializer.listSerializer,
      value.`property`,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.referenceInformation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      SubstanceSpecificationStructureSerializer,
      value.structure,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      SubstanceSpecificationCodeSerializer.listSerializer,
      value.code,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24 + descriptorOffset,
      SubstanceSpecificationNameSerializer.listSerializer,
      value.name,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      SubstanceSpecificationStructureIsotopeMolecularWeightSerializer.listSerializer,
      value.molecularWeight,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      26 + descriptorOffset,
      SubstanceSpecificationRelationshipSerializer.listSerializer,
      value.relationship,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.nucleicAcid,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.polymer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.protein,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.sourceMaterial,
    )
  }
}
