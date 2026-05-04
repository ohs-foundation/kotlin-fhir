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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Moiety) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification.Moiety {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.roleSer, null)
        4 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.identifierSer, null)
        5 -> name = decoder.decodeStringElement(__desc, 5)
        6 -> _name = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 ->
          stereochemistry =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.roleSer, null)
        8 ->
          opticalActivity =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.roleSer, null)
        9 -> molecularFormula = decoder.decodeStringElement(__desc, 9)
        10 ->
          _molecularFormula =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.nameSer, null)
        11 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.amountQuantitySer, null)
        12 -> amountString = decoder.decodeStringElement(__desc, 12)
        13 ->
          _amountString =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Moiety: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceSpecification.Moiety) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.roleSer, it) }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.identifierSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    (value.stereochemistry)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.roleSer, it)
    }
    (value.opticalActivity)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.roleSer, it)
    }
    ((value.molecularFormula?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.molecularFormula?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nameSer, it)
    }
    when (val __d = value.amount) {
      null -> {}
      is SubstanceSpecification.Moiety.Amount.Quantity -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.amountQuantitySer, __d.value)
      }
      is SubstanceSpecification.Moiety.Amount.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification.Property {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 -> code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        5 -> parameters = decoder.decodeStringElement(__desc, 5)
        6 ->
          _parameters =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.parametersSer, null)
        7 ->
          definingSubstanceReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.definingSubstanceReferenceSer,
              null,
            )
        8 ->
          definingSubstanceCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.categorySer, null)
        9 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.amountQuantitySer, null)
        10 -> amountString = decoder.decodeStringElement(__desc, 10)
        11 ->
          _amountString =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.parametersSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceSpecification.Property) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it) }
    ((value.parameters?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.parameters?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.parametersSer, it)
    }
    when (val __d = value.definingSubstance) {
      null -> {}
      is SubstanceSpecification.Property.DefiningSubstance.Reference -> {
        encoder.encodeSerializableElement(
          __desc,
          7,
          Hoisted.definingSubstanceReferenceSer,
          __d.value,
        )
      }
      is SubstanceSpecification.Property.DefiningSubstance.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.categorySer, __d.value)
      }
    }
    when (val __d = value.amount) {
      null -> {}
      is SubstanceSpecification.Property.Amount.Quantity -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.amountQuantitySer, __d.value)
      }
      is SubstanceSpecification.Property.Amount.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.parametersSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification.Structure {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          stereochemistry =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.stereochemistrySer, null)
        4 ->
          opticalActivity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.stereochemistrySer, null)
        5 -> molecularFormula = decoder.decodeStringElement(__desc, 5)
        6 ->
          _molecularFormula =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.molecularFormulaSer, null)
        7 -> molecularFormulaByMoiety = decoder.decodeStringElement(__desc, 7)
        8 ->
          _molecularFormulaByMoiety =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.molecularFormulaSer, null)
        9 ->
          isotope = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.isotopeSer, null)
        10 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.molecularWeightSer, null)
        11 ->
          source = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.sourceSer, null)
        12 ->
          representation =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.representationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Structure: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceSpecification.Structure) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.stereochemistry)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.stereochemistrySer, it)
    }
    (value.opticalActivity)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.stereochemistrySer, it)
    }
    ((value.molecularFormula?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.molecularFormula?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.molecularFormulaSer, it)
    }
    ((value.molecularFormulaByMoiety?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.molecularFormulaByMoiety?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.molecularFormulaSer, it)
    }
    if (value.isotope.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.isotopeSer, value.isotope)
    (value.molecularWeight)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.molecularWeightSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.sourceSer, value.source)
    if (value.representation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.representationSer, value.representation)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure.Isotope) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification.Structure.Isotope {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var name: CodeableConcept? = null
    var substitution: CodeableConcept? = null
    var halfLife: Quantity? = null
    var molecularWeight: SubstanceSpecification.Structure.Isotope.MolecularWeight? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 -> name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 ->
          substitution = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.nameSer, null)
        6 ->
          halfLife = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.halfLifeSer, null)
        7 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.molecularWeightSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Isotope: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Structure.Isotope,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, it)
    }
    (value.name)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it) }
    (value.substitution)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.nameSer, it) }
    (value.halfLife)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.halfLifeSer, it) }
    (value.molecularWeight)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.molecularWeightSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Structure.Isotope.MolecularWeight,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SubstanceSpecification.Structure.Isotope.MolecularWeight {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var method: CodeableConcept? = null
    var type: CodeableConcept? = null
    var amount: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> method = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.methodSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.methodSer, null)
        5 -> amount = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MolecularWeight: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Structure.Isotope.MolecularWeight,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.method)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.methodSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.methodSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.amountSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Structure.Representation,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SubstanceSpecification.Structure.Representation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var representation: KotlinString? = null
    var _representation: Element? = null
    var attachment: Attachment? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> representation = decoder.decodeStringElement(__desc, 4)
        5 ->
          _representation =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.representationSer, null)
        6 ->
          attachment =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.attachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Representation: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Structure.Representation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    ((value.representation?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.representation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.representationSer, it)
    }
    (value.attachment)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.attachmentSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Code) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification.Code {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> status = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> statusDate = decoder.decodeStringElement(__desc, 5)
        6 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.statusDateSer, null)
        7 -> comment = decoder.decodeStringElement(__desc, 7)
        8 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.statusDateSer, null)
        9 -> source = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Code: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceSpecification.Code) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it) }
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.statusDateSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.statusDateSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.sourceSer, value.source)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification.Name {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> status = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 -> preferred = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _preferred = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.nameSer, null)
        9 ->
          language = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.languageSer, null)
        10 ->
          domain = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.languageSer, null)
        11 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.languageSer, null)
        12 ->
          synonym = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.synonymSer, null)
        13 ->
          translation =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.synonymSer, null)
        14 ->
          official =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.officialSer, null)
        15 ->
          source = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceSpecification.Name) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    ((value.preferred?.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
    (value.preferred?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.nameSer, it)
    }
    if (value.language.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.languageSer, value.language)
    if (value.domain.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.languageSer, value.domain)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.languageSer, value.jurisdiction)
    if (value.synonym.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.synonymSer, value.synonym)
    if (value.translation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.synonymSer, value.translation)
    if (value.official.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.officialSer, value.official)
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.sourceSer, value.source)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name.Official) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification.Name.Official {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var authority: CodeableConcept? = null
    var status: CodeableConcept? = null
    var date: KotlinString? = null
    var _date: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          authority =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.authoritySer, null)
        4 ->
          status = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.authoritySer, null)
        5 -> date = decoder.decodeStringElement(__desc, 5)
        6 -> _date = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.dateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Official: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Name.Official,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.authority)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.authoritySer, it)
    }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.authoritySer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.dateSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Relationship) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification.Relationship {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          substanceReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.substanceReferenceSer,
              null,
            )
        4 ->
          substanceCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.substanceCodeableConceptSer,
              null,
            )
        5 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.substanceCodeableConceptSer,
              null,
            )
        6 -> isDefining = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _isDefining =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.isDefiningSer, null)
        8 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.amountQuantitySer, null)
        9 ->
          amountRange =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.amountRangeSer, null)
        10 ->
          amountRatio =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.amountRatioSer, null)
        11 -> amountString = decoder.decodeStringElement(__desc, 11)
        12 ->
          _amountString =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.isDefiningSer, null)
        13 ->
          amountRatioLowLimit =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.amountRatioSer, null)
        14 ->
          amountType =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.substanceCodeableConceptSer,
              null,
            )
        15 ->
          source = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Relationship: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceSpecification.Relationship,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.substance) {
      null -> {}
      is SubstanceSpecification.Relationship.Substance.Reference -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.substanceReferenceSer, __d.value)
      }
      is SubstanceSpecification.Relationship.Substance.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.substanceCodeableConceptSer, __d.value)
      }
    }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.substanceCodeableConceptSer, it)
    }
    ((value.isDefining?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.isDefining?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.isDefiningSer, it)
    }
    when (val __d = value.amount) {
      null -> {}
      is SubstanceSpecification.Relationship.Amount.Quantity -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.amountQuantitySer, __d.value)
      }
      is SubstanceSpecification.Relationship.Amount.Range -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.amountRangeSer, __d.value)
      }
      is SubstanceSpecification.Relationship.Amount.Ratio -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.amountRatioSer, __d.value)
      }
      is SubstanceSpecification.Relationship.Amount.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.isDefiningSer, it)
        }
      }
    }
    (value.amountRatioLowLimit)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.amountRatioSer, it)
    }
    (value.amountType)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.substanceCodeableConceptSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.sourceSer, value.source)
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("domain", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element(
        "moiety",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Moiety.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("referenceInformation", Reference.serializer().descriptor, isOptional = true)
      element(
        "structure",
        lazyDescriptor { SubstanceSpecification.Structure.serializer().descriptor },
        isOptional = true,
      )
      element(
        "code",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Code.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "name",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Name.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "molecularWeight",
        listSerialDescriptor(
          lazyDescriptor {
            SubstanceSpecification.Structure.Isotope.MolecularWeight.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "relationship",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSpecification.Relationship.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("nucleicAcid", Reference.serializer().descriptor, isOptional = true)
      element("polymer", Reference.serializer().descriptor, isOptional = true)
      element("protein", Reference.serializer().descriptor, isOptional = true)
      element("sourceMaterial", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSpecification =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): SubstanceSpecification {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> type = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.typeSer, null)
        13 -> status = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.typeSer, null)
        14 -> domain = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.typeSer, null)
        15 -> description = decoder.decodeStringElement(__desc, 15)
        16 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          source = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.sourceSer, null)
        18 -> comment = decoder.decodeStringElement(__desc, 18)
        19 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          moiety = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.moietySer, null)
        21 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.propertySer, null)
        22 ->
          referenceInformation =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.sourceSerInner, null)
        23 ->
          structure =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.structureSer, null)
        24 -> code = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.codeSer, null)
        25 -> name = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.nameSer, null)
        26 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.molecularWeightSer, null)
        27 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.relationshipSer, null)
        28 ->
          nucleicAcid =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.sourceSerInner, null)
        29 ->
          polymer =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.sourceSerInner, null)
        30 ->
          protein =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.sourceSerInner, null)
        31 ->
          sourceMaterial =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.sourceSerInner, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding SubstanceSpecification: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceSpecification) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "SubstanceSpecification")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.typeSer, it) }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.typeSer, it) }
    (value.domain)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.sourceSer, value.source)
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    if (value.moiety.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.moietySer, value.moiety)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.propertySer, value.`property`)
    (value.referenceInformation)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.sourceSerInner, it)
    }
    (value.structure)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.structureSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.codeSer, value.code)
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.nameSer, value.name)
    if (value.molecularWeight.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26,
        Hoisted.molecularWeightSer,
        value.molecularWeight,
      )
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.relationshipSer, value.relationship)
    (value.nucleicAcid)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.sourceSerInner, it)
    }
    (value.polymer)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.sourceSerInner, it)
    }
    (value.protein)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.sourceSerInner, it)
    }
    (value.sourceMaterial)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.sourceSerInner, it)
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
