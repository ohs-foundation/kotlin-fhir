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

internal object SubstanceDefinitionMoietySerializer : FhirSerializer<SubstanceDefinition.Moiety> {
  override val descriptor: SerialDescriptor = buildDescriptor("Moiety", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.Moiety>> = ListSerializer(this)

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
    b.optionalElement("measurementType", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Moiety {
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
    var measurementType: CodeableConcept? = null
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
        14 ->
          measurementType =
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
    return SubstanceDefinition.Moiety(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      is SubstanceDefinition.Moiety.Amount.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 11, QuantitySerializer, choice.value)
      }
      is SubstanceDefinition.Moiety.Amount.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      CodeableConceptSerializer,
      value.measurementType,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceDefinitionPropertySerializer :
  FhirSerializer<SubstanceDefinition.Property> {
  override val descriptor: SerialDescriptor = buildDescriptor("Property", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.Property>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.strPrim("valueDate")
    b.boolPrim("valueBoolean")
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Property {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueDate: FhirDate? = null
    var _valueDate: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueAttachment: Attachment? = null
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
        5 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        7 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          valueAttachment =
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
    return SubstanceDefinition.Property(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "SubstanceDefinition.Property", "type"),
      `value` =
        SubstanceDefinition.Property.Value.from(
          valueCodeableConcept,
          valueQuantity,
          Date.of(valueDate, _valueDate),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Property) {
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
    when (val choice = value.`value`) {
      null -> {}
      is SubstanceDefinition.Property.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is SubstanceDefinition.Property.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
      }
      is SubstanceDefinition.Property.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is SubstanceDefinition.Property.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is SubstanceDefinition.Property.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          10,
          AttachmentSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceDefinitionMolecularWeightSerializer :
  FhirSerializer<SubstanceDefinition.MolecularWeight> {
  override val descriptor: SerialDescriptor = buildDescriptor("MolecularWeight", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.MolecularWeight>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", QuantitySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.MolecularWeight {
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
    return SubstanceDefinition.MolecularWeight(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      method = method,
      type = type,
      amount = required(amount, "SubstanceDefinition.MolecularWeight", "amount"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.MolecularWeight) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 5, QuantitySerializer, value.amount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceDefinitionStructureSerializer :
  FhirSerializer<SubstanceDefinition.Structure> {
  override val descriptor: SerialDescriptor = buildDescriptor("Structure", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.Structure>> =
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
      "molecularWeight",
      lazyDescriptor(LazyDescriptorId.SubstanceDefinitionMolecularWeightSerializer),
    )
    b.optionalElement("technique", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("sourceDocument", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "representation",
      SubstanceDefinitionStructureRepresentationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Structure {
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
    var molecularWeight: SubstanceDefinition.MolecularWeight? = null
    var technique: List<CodeableConcept>? = null
    var sourceDocument: List<Reference>? = null
    var representation: List<SubstanceDefinition.Structure.Representation>? = null
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
          molecularWeight =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionMolecularWeightSerializer,
              null,
            )
        10 ->
          technique =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          sourceDocument =
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
              SubstanceDefinitionStructureRepresentationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceDefinition.Structure(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      stereochemistry = stereochemistry,
      opticalActivity = opticalActivity,
      molecularFormula = R4bString.of(molecularFormula, _molecularFormula),
      molecularFormulaByMoiety = R4bString.of(molecularFormulaByMoiety, _molecularFormulaByMoiety),
      molecularWeight = molecularWeight,
      technique = listOrEmpty(technique),
      sourceDocument = listOrEmpty(sourceDocument),
      representation = listOrEmpty(representation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      SubstanceDefinitionMolecularWeightSerializer,
      value.molecularWeight,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      CodeableConceptSerializer.listSerializer,
      value.technique,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ReferenceSerializer.listSerializer,
      value.sourceDocument,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      SubstanceDefinitionStructureRepresentationSerializer.listSerializer,
      value.representation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceDefinitionStructureRepresentationSerializer :
  FhirSerializer<SubstanceDefinition.Structure.Representation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Representation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.Structure.Representation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("representation")
    b.optionalElement("format", CodeableConceptSerializer.descriptor)
    b.optionalElement("document", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Structure.Representation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var representation: KotlinString? = null
    var _representation: Element? = null
    var format: CodeableConcept? = null
    var document: Reference? = null
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
          format =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          document =
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
    return SubstanceDefinition.Structure.Representation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      representation = R4bString.of(representation, _representation),
      format = format,
      document = document,
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure.Representation) {
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
      CodeableConceptSerializer,
      value.format,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.document)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceDefinitionCodeSerializer : FhirSerializer<SubstanceDefinition.Code> {
  override val descriptor: SerialDescriptor = buildDescriptor("Code", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.Code>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.strPrim("statusDate")
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Code {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var status: CodeableConcept? = null
    var statusDate: FhirDateTime? = null
    var _statusDate: Element? = null
    var note: List<Annotation>? = null
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
        7 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        8 ->
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
    return SubstanceDefinition.Code(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = code,
      status = status,
      statusDate = DateTime.of(statusDate, _statusDate),
      note = listOrEmpty(note),
      source = listOrEmpty(source),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Code) {
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      ReferenceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceDefinitionNameSerializer : FhirSerializer<SubstanceDefinition.Name> {
  override val descriptor: SerialDescriptor = buildDescriptor("Name", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.Name>> = ListSerializer(this)

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
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.SubstanceDefinitionNameSerializer)),
    )
    b.optionalElement(
      "translation",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.SubstanceDefinitionNameSerializer)),
    )
    b.optionalElement(
      "official",
      SubstanceDefinitionNameOfficialSerializer.listSerializer.descriptor,
    )
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Name {
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
    var synonym: List<SubstanceDefinition.Name>? = null
    var translation: List<SubstanceDefinition.Name>? = null
    var official: List<SubstanceDefinition.Name.Official>? = null
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
              SubstanceDefinitionNameSerializer.listSerializer,
              null,
            )
        13 ->
          translation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionNameSerializer.listSerializer,
              null,
            )
        14 ->
          official =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionNameOfficialSerializer.listSerializer,
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
    return SubstanceDefinition.Name(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R4bString.of(name, _name), "SubstanceDefinition.Name", "name"),
      type = type,
      status = status,
      preferred = R4bBoolean.of(preferred, _preferred),
      language = listOrEmpty(language),
      domain = listOrEmpty(domain),
      jurisdiction = listOrEmpty(jurisdiction),
      synonym = listOrEmpty(synonym),
      translation = listOrEmpty(translation),
      official = listOrEmpty(official),
      source = listOrEmpty(source),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name) {
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
      SubstanceDefinitionNameSerializer.listSerializer,
      value.synonym,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      SubstanceDefinitionNameSerializer.listSerializer,
      value.translation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      SubstanceDefinitionNameOfficialSerializer.listSerializer,
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

internal object SubstanceDefinitionNameOfficialSerializer :
  FhirSerializer<SubstanceDefinition.Name.Official> {
  override val descriptor: SerialDescriptor = buildDescriptor("Official", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.Name.Official>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("authority", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.strPrim("date")
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Name.Official {
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
    return SubstanceDefinition.Name.Official(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      authority = authority,
      status = status,
      date = DateTime.of(date, _date),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name.Official) {
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

internal object SubstanceDefinitionRelationshipSerializer :
  FhirSerializer<SubstanceDefinition.Relationship> {
  override val descriptor: SerialDescriptor = buildDescriptor("Relationship", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.Relationship>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("substanceDefinitionReference", ReferenceSerializer.descriptor)
    b.optionalElement("substanceDefinitionCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.boolPrim("isDefining")
    b.optionalElement("amountQuantity", QuantitySerializer.descriptor)
    b.optionalElement("amountRatio", RatioSerializer.descriptor)
    b.strPrim("amountString")
    b.optionalElement("ratioHighLimitAmount", RatioSerializer.descriptor)
    b.optionalElement("comparator", CodeableConceptSerializer.descriptor)
    b.optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Relationship {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          substanceDefinitionReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          substanceDefinitionCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
          amountRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        10 -> amountString = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _amountString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          ratioHighLimitAmount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        13 ->
          comparator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
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
    return SubstanceDefinition.Relationship(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      substanceDefinition =
        SubstanceDefinition.Relationship.SubstanceDefinition.from(
          substanceDefinitionReference,
          substanceDefinitionCodeableConcept,
        ),
      type = required(type, "SubstanceDefinition.Relationship", "type"),
      isDefining = R4bBoolean.of(isDefining, _isDefining),
      amount =
        SubstanceDefinition.Relationship.Amount.from(
          amountQuantity,
          amountRatio,
          R4bString.of(amountString, _amountString),
        ),
      ratioHighLimitAmount = ratioHighLimitAmount,
      comparator = comparator,
      source = listOrEmpty(source),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Relationship) {
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
    when (val choice = value.substanceDefinition) {
      null -> {}
      is SubstanceDefinition.Relationship.SubstanceDefinition.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
      }
      is SubstanceDefinition.Relationship.SubstanceDefinition.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 6, value.isDefining?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.isDefining)
    when (val choice = value.amount) {
      null -> {}
      is SubstanceDefinition.Relationship.Amount.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
      }
      is SubstanceDefinition.Relationship.Amount.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, RatioSerializer, choice.value)
      }
      is SubstanceDefinition.Relationship.Amount.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      RatioSerializer,
      value.ratioHighLimitAmount,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      CodeableConceptSerializer,
      value.comparator,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      ReferenceSerializer.listSerializer,
      value.source,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceDefinitionSourceMaterialSerializer :
  FhirSerializer<SubstanceDefinition.SourceMaterial> {
  override val descriptor: SerialDescriptor = buildDescriptor("SourceMaterial", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceDefinition.SourceMaterial>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("genus", CodeableConceptSerializer.descriptor)
    b.optionalElement("species", CodeableConceptSerializer.descriptor)
    b.optionalElement("part", CodeableConceptSerializer.descriptor)
    b.optionalElement("countryOfOrigin", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.SourceMaterial {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var genus: CodeableConcept? = null
    var species: CodeableConcept? = null
    var part: CodeableConcept? = null
    var countryOfOrigin: List<CodeableConcept>? = null
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
          genus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          species =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          part =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          countryOfOrigin =
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
    return SubstanceDefinition.SourceMaterial(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      genus = genus,
      species = species,
      part = part,
      countryOfOrigin = listOrEmpty(countryOfOrigin),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.SourceMaterial) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.genus,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.species,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.part,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.countryOfOrigin,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceDefinitionSerializer : FhirResourceSerializer<SubstanceDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstanceDefinition")

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
    b.strPrim("version")
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.optionalElement("classification", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("domain", CodeableConceptSerializer.descriptor)
    b.optionalElement("grade", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("description")
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
    compositeDecoder: CompositeDecoder,
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
        11 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          classification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          domain =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          grade =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          informationSource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        21 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          supplier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          moiety =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionMoietySerializer.listSerializer,
              null,
            )
        24 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionPropertySerializer.listSerializer,
              null,
            )
        25 ->
          molecularWeight =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionMolecularWeightSerializer.listSerializer,
              null,
            )
        26 ->
          structure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionStructureSerializer,
              null,
            )
        27 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionCodeSerializer.listSerializer,
              null,
            )
        28 ->
          name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionNameSerializer.listSerializer,
              null,
            )
        29 ->
          relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionRelationshipSerializer.listSerializer,
              null,
            )
        30 ->
          sourceMaterial =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceDefinitionSourceMaterialSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return SubstanceDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      version = R4bString.of(version, _version),
      status = status,
      classification = listOrEmpty(classification),
      domain = domain,
      grade = listOrEmpty(grade),
      description = Markdown.of(description, _description),
      informationSource = listOrEmpty(informationSource),
      note = listOrEmpty(note),
      manufacturer = listOrEmpty(manufacturer),
      supplier = listOrEmpty(supplier),
      moiety = listOrEmpty(moiety),
      `property` = listOrEmpty(`property`),
      molecularWeight = listOrEmpty(molecularWeight),
      structure = structure,
      code = listOrEmpty(code),
      name = listOrEmpty(name),
      relationship = listOrEmpty(relationship),
      sourceMaterial = sourceMaterial,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceDefinition,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.version)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.classification,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.domain,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.grade,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.informationSource,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.supplier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      SubstanceDefinitionMoietySerializer.listSerializer,
      value.moiety,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24 + descriptorOffset,
      SubstanceDefinitionPropertySerializer.listSerializer,
      value.`property`,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      SubstanceDefinitionMolecularWeightSerializer.listSerializer,
      value.molecularWeight,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      SubstanceDefinitionStructureSerializer,
      value.structure,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      SubstanceDefinitionCodeSerializer.listSerializer,
      value.code,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      28 + descriptorOffset,
      SubstanceDefinitionNameSerializer.listSerializer,
      value.name,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29 + descriptorOffset,
      SubstanceDefinitionRelationshipSerializer.listSerializer,
      value.relationship,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      SubstanceDefinitionSourceMaterialSerializer,
      value.sourceMaterial,
    )
  }
}
