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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceSpecification
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("stereochemistry", CodeableConcept.serializer().descriptor, isOptional = true)
      element("opticalActivity", CodeableConcept.serializer().descriptor, isOptional = true)
      element("molecularFormula", KotlinString.serializer().descriptor, isOptional = true)
      element("_molecularFormula", Element.serializer().descriptor, isOptional = true)
      element("amountQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("amountString", KotlinString.serializer().descriptor, isOptional = true)
      element("_amountString", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Moiety =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Moiety) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceSpecification.Moiety {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        4 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        5 -> name = decoder.decodeStringElement(descriptor, i)
        6 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 ->
          stereochemistry =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        8 ->
          opticalActivity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        9 -> molecularFormula = decoder.decodeStringElement(descriptor, i)
        10 ->
          _molecularFormula =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        11 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.amountQuantitySer,
              null,
            )
        12 -> amountString = decoder.decodeStringElement(descriptor, i)
        13 ->
          _amountString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Moiety: " + i)
      }
    }
    return SubstanceSpecification.Moiety(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceSpecification.Moiety) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.roleSer, it) }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.identifierSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    (value.stereochemistry)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.roleSer, it)
    }
    (value.opticalActivity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.roleSer, it)
    }
    ((value.molecularFormula?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.molecularFormula?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.nameSer, it)
    }
    when (val choice = value.amount) {
      null -> {}
      is SubstanceSpecification.Moiety.Amount.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.amountQuantitySer, choice.value)
      }
      is SubstanceSpecification.Moiety.Amount.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.nameSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val amountQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object SubstanceSpecificationPropertySerializer :
  KSerializer<SubstanceSpecification.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("parameters", KotlinString.serializer().descriptor, isOptional = true)
      element("_parameters", Element.serializer().descriptor, isOptional = true)
      element("definingSubstanceReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "definingSubstanceCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("amountQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("amountString", KotlinString.serializer().descriptor, isOptional = true)
      element("_amountString", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Property =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Property) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceSpecification.Property {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        5 -> parameters = decoder.decodeStringElement(descriptor, i)
        6 ->
          _parameters =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parametersSer, null)
        7 ->
          definingSubstanceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definingSubstanceReferenceSer,
              null,
            )
        8 ->
          definingSubstanceCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        9 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.amountQuantitySer,
              null,
            )
        10 -> amountString = decoder.decodeStringElement(descriptor, i)
        11 ->
          _amountString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parametersSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    return SubstanceSpecification.Property(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Property,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.categorySer, it) }
    ((value.parameters?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.parameters?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.parametersSer, it)
    }
    when (val choice = value.definingSubstance) {
      null -> {}
      is SubstanceSpecification.Property.DefiningSubstance.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          7,
          Hoisted.definingSubstanceReferenceSer,
          choice.value,
        )
      }
      is SubstanceSpecification.Property.DefiningSubstance.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.categorySer, choice.value)
      }
    }
    when (val choice = value.amount) {
      null -> {}
      is SubstanceSpecification.Property.Amount.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.amountQuantitySer, choice.value)
      }
      is SubstanceSpecification.Property.Amount.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.parametersSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val parametersSer: KSerializer<Element> = Element.serializer()

    public val definingSubstanceReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val amountQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object SubstanceSpecificationStructureSerializer :
  KSerializer<SubstanceSpecification.Structure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Structure") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("stereochemistry", CodeableConcept.serializer().descriptor, isOptional = true)
      element("opticalActivity", CodeableConcept.serializer().descriptor, isOptional = true)
      element("molecularFormula", KotlinString.serializer().descriptor, isOptional = true)
      element("_molecularFormula", Element.serializer().descriptor, isOptional = true)
      element("molecularFormulaByMoiety", KotlinString.serializer().descriptor, isOptional = true)
      element("_molecularFormulaByMoiety", Element.serializer().descriptor, isOptional = true)
      element(
        "isotope",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Structure.Isotope.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "molecularWeight",
        lazyDescriptor {
          SubstanceSpecification.Structure.Isotope.MolecularWeight.serializer().descriptor
        },
        isOptional = true,
      )
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "representation",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Structure.Representation.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceSpecification.Structure {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          stereochemistry =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.stereochemistrySer,
              null,
            )
        4 ->
          opticalActivity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.stereochemistrySer,
              null,
            )
        5 -> molecularFormula = decoder.decodeStringElement(descriptor, i)
        6 ->
          _molecularFormula =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.molecularFormulaSer,
              null,
            )
        7 -> molecularFormulaByMoiety = decoder.decodeStringElement(descriptor, i)
        8 ->
          _molecularFormulaByMoiety =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.molecularFormulaSer,
              null,
            )
        9 ->
          isotope =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.isotopeSer, null)
        10 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.molecularWeightSer,
              null,
            )
        11 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        12 ->
          representation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.representationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Structure: " + i)
      }
    }
    return SubstanceSpecification.Structure(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Structure,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.stereochemistry)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.stereochemistrySer, it)
    }
    (value.opticalActivity)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.stereochemistrySer, it)
    }
    ((value.molecularFormula?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.molecularFormula?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.molecularFormulaSer, it)
    }
    ((value.molecularFormulaByMoiety?.value))?.let {
      encoder.encodeStringElement(descriptor, 7, it)
    }
    (value.molecularFormulaByMoiety?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.molecularFormulaSer, it)
    }
    if (value.isotope.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.isotopeSer, value.isotope)
    (value.molecularWeight)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.molecularWeightSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.sourceSer, value.source)
    if (value.representation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12,
        Hoisted.representationSer,
        value.representation,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val stereochemistrySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val molecularFormulaSer: KSerializer<Element> = Element.serializer()

    public val isotopeSerInner: KSerializer<SubstanceSpecification.Structure.Isotope> =
      SubstanceSpecification.Structure.Isotope.serializer()

    public val isotopeSer: KSerializer<List<SubstanceSpecification.Structure.Isotope>> =
      ListSerializer(Hoisted.isotopeSerInner)

    public val molecularWeightSer:
      KSerializer<SubstanceSpecification.Structure.Isotope.MolecularWeight> =
      SubstanceSpecification.Structure.Isotope.MolecularWeight.serializer()

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)

    public val representationSerInner:
      KSerializer<SubstanceSpecification.Structure.Representation> =
      SubstanceSpecification.Structure.Representation.serializer()

    public val representationSer:
      KSerializer<List<SubstanceSpecification.Structure.Representation>> =
      ListSerializer(Hoisted.representationSerInner)
  }
}

internal object SubstanceSpecificationStructureIsotopeSerializer :
  KSerializer<SubstanceSpecification.Structure.Isotope> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Isotope") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("name", CodeableConcept.serializer().descriptor, isOptional = true)
      element("substitution", CodeableConcept.serializer().descriptor, isOptional = true)
      element("halfLife", Quantity.serializer().descriptor, isOptional = true)
      element(
        "molecularWeight",
        lazyDescriptor {
          SubstanceSpecification.Structure.Isotope.MolecularWeight.serializer().descriptor
        },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure.Isotope =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure.Isotope) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceSpecification.Structure.Isotope {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var name: CodeableConcept? = null
    var substitution: CodeableConcept? = null
    var halfLife: Quantity? = null
    var molecularWeight: SubstanceSpecification.Structure.Isotope.MolecularWeight? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 -> name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 ->
          substitution =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        6 ->
          halfLife =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.halfLifeSer, null)
        7 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.molecularWeightSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Isotope: " + i)
      }
    }
    return SubstanceSpecification.Structure.Isotope(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Structure.Isotope,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, it)
    }
    (value.name)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it) }
    (value.substitution)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.nameSer, it)
    }
    (value.halfLife)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.halfLifeSer, it)
    }
    (value.molecularWeight)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.molecularWeightSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val nameSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val halfLifeSer: KSerializer<Quantity> = Quantity.serializer()

    public val molecularWeightSer:
      KSerializer<SubstanceSpecification.Structure.Isotope.MolecularWeight> =
      SubstanceSpecification.Structure.Isotope.MolecularWeight.serializer()
  }
}

internal object SubstanceSpecificationStructureIsotopeMolecularWeightSerializer :
  KSerializer<SubstanceSpecification.Structure.Isotope.MolecularWeight> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MolecularWeight") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): SubstanceSpecification.Structure.Isotope.MolecularWeight =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Structure.Isotope.MolecularWeight,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceSpecification.Structure.Isotope.MolecularWeight {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var method: CodeableConcept? = null
    var type: CodeableConcept? = null
    var amount: Quantity? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          method = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        4 ->
          type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        5 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MolecularWeight: " + i)
      }
    }
    return SubstanceSpecification.Structure.Isotope.MolecularWeight(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      method = method,
      type = type,
      amount = amount,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Structure.Isotope.MolecularWeight,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.method)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.methodSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.methodSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val methodSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object SubstanceSpecificationStructureRepresentationSerializer :
  KSerializer<SubstanceSpecification.Structure.Representation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Representation") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("representation", KotlinString.serializer().descriptor, isOptional = true)
      element("_representation", Element.serializer().descriptor, isOptional = true)
      element("attachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure.Representation =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Structure.Representation,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceSpecification.Structure.Representation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var representation: KotlinString? = null
    var _representation: Element? = null
    var attachment: Attachment? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> representation = decoder.decodeStringElement(descriptor, i)
        5 ->
          _representation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.representationSer,
              null,
            )
        6 ->
          attachment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.attachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Representation: " + i)
      }
    }
    return SubstanceSpecification.Structure.Representation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      representation = R4String.of(representation, _representation),
      attachment = attachment,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Structure.Representation,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    ((value.representation?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.representation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.representationSer, it)
    }
    (value.attachment)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.attachmentSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val representationSer: KSerializer<Element> = Element.serializer()

    public val attachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object SubstanceSpecificationCodeSerializer : KSerializer<SubstanceSpecification.Code> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Code") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_statusDate", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Code =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Code) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceSpecification.Code {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          status = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> statusDate = decoder.decodeStringElement(descriptor, i)
        6 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusDateSer, null)
        7 -> comment = decoder.decodeStringElement(descriptor, i)
        8 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusDateSer, null)
        9 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Code: " + i)
      }
    }
    return SubstanceSpecification.Code(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      status = status,
      statusDate = DateTime.of(FhirDateTime.fromString(statusDate), _statusDate),
      comment = R4String.of(comment, _comment),
      source = source ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceSpecification.Code) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, it) }
    (value.status)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.statusDateSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.statusDateSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val statusDateSer: KSerializer<Element> = Element.serializer()

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object SubstanceSpecificationNameSerializer : KSerializer<SubstanceSpecification.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Name") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("preferred", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_preferred", Element.serializer().descriptor, isOptional = true)
      element(
        "language",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "domain",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "synonym",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Name.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "translation",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Name.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "official",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Name.Official.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Name =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceSpecification.Name {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 ->
          status = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> preferred = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _preferred =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        9 ->
          language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        10 ->
          domain =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        11 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        12 ->
          synonym =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.synonymSer, null)
        13 ->
          translation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.synonymSer, null)
        14 ->
          official =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.officialSer, null)
        15 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + i)
      }
    }
    return SubstanceSpecification.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name)!!,
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceSpecification.Name) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    (value.status)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    ((value.preferred?.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
    (value.preferred?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.nameSer, it)
    }
    if (value.language.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.languageSer, value.language)
    if (value.domain.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.languageSer, value.domain)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.languageSer, value.jurisdiction)
    if (value.synonym.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.synonymSer, value.synonym)
    if (value.translation.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.synonymSer, value.translation)
    if (value.official.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.officialSer, value.official)
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val languageSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val synonymSerInner: KSerializer<SubstanceSpecification.Name> =
      SubstanceSpecification.Name.serializer()

    public val synonymSer: KSerializer<List<SubstanceSpecification.Name>> =
      ListSerializer(Hoisted.synonymSerInner)

    public val officialSerInner: KSerializer<SubstanceSpecification.Name.Official> =
      SubstanceSpecification.Name.Official.serializer()

    public val officialSer: KSerializer<List<SubstanceSpecification.Name.Official>> =
      ListSerializer(Hoisted.officialSerInner)

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object SubstanceSpecificationNameOfficialSerializer :
  KSerializer<SubstanceSpecification.Name.Official> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Official") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("authority", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Name.Official =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name.Official) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceSpecification.Name.Official {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var authority: CodeableConcept? = null
    var status: CodeableConcept? = null
    var date: KotlinString? = null
    var _date: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          authority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authoritySer, null)
        4 ->
          status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authoritySer, null)
        5 -> date = decoder.decodeStringElement(descriptor, i)
        6 -> _date = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Official: " + i)
      }
    }
    return SubstanceSpecification.Name.Official(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      authority = authority,
      status = status,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Name.Official,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.authority)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.authoritySer, it)
    }
    (value.status)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.authoritySer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.dateSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val authoritySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SubstanceSpecificationRelationshipSerializer :
  KSerializer<SubstanceSpecification.Relationship> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Relationship") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("substanceReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "substanceCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("relationship", CodeableConcept.serializer().descriptor, isOptional = true)
      element("isDefining", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isDefining", Element.serializer().descriptor, isOptional = true)
      element("amountQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("amountRange", Range.serializer().descriptor, isOptional = true)
      element("amountRatio", Ratio.serializer().descriptor, isOptional = true)
      element("amountString", KotlinString.serializer().descriptor, isOptional = true)
      element("_amountString", Element.serializer().descriptor, isOptional = true)
      element("amountRatioLowLimit", Ratio.serializer().descriptor, isOptional = true)
      element("amountType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Relationship =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Relationship) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceSpecification.Relationship {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          substanceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.substanceReferenceSer,
              null,
            )
        4 ->
          substanceCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.substanceCodeableConceptSer,
              null,
            )
        5 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.substanceCodeableConceptSer,
              null,
            )
        6 -> isDefining = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _isDefining =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.isDefiningSer, null)
        8 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.amountQuantitySer,
              null,
            )
        9 ->
          amountRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountRangeSer, null)
        10 ->
          amountRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountRatioSer, null)
        11 -> amountString = decoder.decodeStringElement(descriptor, i)
        12 ->
          _amountString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.isDefiningSer, null)
        13 ->
          amountRatioLowLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountRatioSer, null)
        14 ->
          amountType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.substanceCodeableConceptSer,
              null,
            )
        15 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Relationship: " + i)
      }
    }
    return SubstanceSpecification.Relationship(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Relationship,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    when (val choice = value.substance) {
      null -> {}
      is SubstanceSpecification.Relationship.Substance.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.substanceReferenceSer,
          choice.value,
        )
      }
      is SubstanceSpecification.Relationship.Substance.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.substanceCodeableConceptSer,
          choice.value,
        )
      }
    }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.substanceCodeableConceptSer, it)
    }
    ((value.isDefining?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.isDefining?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.isDefiningSer, it)
    }
    when (val choice = value.amount) {
      null -> {}
      is SubstanceSpecification.Relationship.Amount.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.amountQuantitySer, choice.value)
      }
      is SubstanceSpecification.Relationship.Amount.Range -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.amountRangeSer, choice.value)
      }
      is SubstanceSpecification.Relationship.Amount.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.amountRatioSer, choice.value)
      }
      is SubstanceSpecification.Relationship.Amount.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.isDefiningSer, it)
        }
      }
    }
    (value.amountRatioLowLimit)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.amountRatioSer, it)
    }
    (value.amountType)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.substanceCodeableConceptSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val substanceReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val substanceCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val isDefiningSer: KSerializer<Element> = Element.serializer()

    public val amountQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val amountRangeSer: KSerializer<Range> = Range.serializer()

    public val amountRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val sourceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.substanceReferenceSer)
  }
}

internal object SubstanceSpecificationSerializer : KSerializer<SubstanceSpecification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceSpecification") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("domain", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("comment", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_comment", Element.serializer().descriptor, isOptional = true)
    b.element(
      "moiety",
      listSerialDescriptor(
        lazyDescriptor { SubstanceSpecification.Moiety.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "property",
      listSerialDescriptor(
        lazyDescriptor { SubstanceSpecification.Property.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("referenceInformation", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "structure",
      lazyDescriptor { SubstanceSpecification.Structure.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "code",
      listSerialDescriptor(lazyDescriptor { SubstanceSpecification.Code.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "name",
      listSerialDescriptor(lazyDescriptor { SubstanceSpecification.Name.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "molecularWeight",
      listSerialDescriptor(
        lazyDescriptor {
          SubstanceSpecification.Structure.Isotope.MolecularWeight.serializer().descriptor
        }
      ),
      isOptional = true,
    )
    b.element(
      "relationship",
      listSerialDescriptor(
        lazyDescriptor { SubstanceSpecification.Relationship.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("nucleicAcid", Reference.serializer().descriptor, isOptional = true)
    b.element("polymer", Reference.serializer().descriptor, isOptional = true)
    b.element("protein", Reference.serializer().descriptor, isOptional = true)
    b.element("sourceMaterial", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstanceSpecification")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        12 ->
          status = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        13 ->
          domain = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 -> description = decoder.decodeStringElement(descriptor, i)
        15 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        17 -> comment = decoder.decodeStringElement(descriptor, i)
        18 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          moiety = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.moietySer, null)
        20 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        21 ->
          referenceInformation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSerInner, null)
        22 ->
          structure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.structureSer, null)
        23 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        24 -> name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        25 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.molecularWeightSer,
              null,
            )
        26 ->
          relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relationshipSer, null)
        27 ->
          nucleicAcid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSerInner, null)
        28 ->
          polymer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSerInner, null)
        29 ->
          protein =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSerInner, null)
        30 ->
          sourceMaterial =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSerInner, null)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceSpecification,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.status)?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.domain)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.sourceSer,
        value.source,
      )
    ((value.comment?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.moiety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.moietySer,
        value.moiety,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.propertySer,
        value.`property`,
      )
    (value.referenceInformation)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.sourceSerInner,
        it,
      )
    }
    (value.structure)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.structureSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.codeSer,
        value.code,
      )
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.nameSer,
        value.name,
      )
    if (value.molecularWeight.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.molecularWeightSer,
        value.molecularWeight,
      )
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.relationshipSer,
        value.relationship,
      )
    (value.nucleicAcid)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.sourceSerInner,
        it,
      )
    }
    (value.polymer)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.sourceSerInner,
        it,
      )
    }
    (value.protein)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.sourceSerInner,
        it,
      )
    }
    (value.sourceMaterial)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.sourceSerInner,
        it,
      )
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)

    public val moietySerInner: KSerializer<SubstanceSpecification.Moiety> =
      SubstanceSpecification.Moiety.serializer()

    public val moietySer: KSerializer<List<SubstanceSpecification.Moiety>> =
      ListSerializer(Hoisted.moietySerInner)

    public val propertySerInner: KSerializer<SubstanceSpecification.Property> =
      SubstanceSpecification.Property.serializer()

    public val propertySer: KSerializer<List<SubstanceSpecification.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val structureSer: KSerializer<SubstanceSpecification.Structure> =
      SubstanceSpecification.Structure.serializer()

    public val codeSerInner: KSerializer<SubstanceSpecification.Code> =
      SubstanceSpecification.Code.serializer()

    public val codeSer: KSerializer<List<SubstanceSpecification.Code>> =
      ListSerializer(Hoisted.codeSerInner)

    public val nameSerInner: KSerializer<SubstanceSpecification.Name> =
      SubstanceSpecification.Name.serializer()

    public val nameSer: KSerializer<List<SubstanceSpecification.Name>> =
      ListSerializer(Hoisted.nameSerInner)

    public val molecularWeightSerInner:
      KSerializer<SubstanceSpecification.Structure.Isotope.MolecularWeight> =
      SubstanceSpecification.Structure.Isotope.MolecularWeight.serializer()

    public val molecularWeightSer:
      KSerializer<List<SubstanceSpecification.Structure.Isotope.MolecularWeight>> =
      ListSerializer(Hoisted.molecularWeightSerInner)

    public val relationshipSerInner: KSerializer<SubstanceSpecification.Relationship> =
      SubstanceSpecification.Relationship.serializer()

    public val relationshipSer: KSerializer<List<SubstanceSpecification.Relationship>> =
      ListSerializer(Hoisted.relationshipSerInner)
  }
}

internal object SubstanceSpecificationPolymorphicSerializer : KSerializer<SubstanceSpecification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceSpecification") {
      SubstanceSpecificationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification) {
    encoder.encodeStructure(descriptor) {
      SubstanceSpecificationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification =
    decoder.decodeStructure(descriptor) {
      SubstanceSpecificationSerializer.deserializeInternal(this, descriptor, 0)
    }
}
