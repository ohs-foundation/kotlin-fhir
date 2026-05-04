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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.SubstanceDefinition
import dev.ohs.fhir.model.r4b.Uri
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

internal object SubstanceDefinitionMoietySerializer : KSerializer<SubstanceDefinition.Moiety> {
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
      element("measurementType", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Moiety =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Moiety) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.Moiety {
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
    var measurementType: CodeableConcept? = null
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
        14 ->
          measurementType =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Moiety: " + __i)
      }
    }
    return SubstanceDefinition.Moiety(
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceDefinition.Moiety) {
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
      is SubstanceDefinition.Moiety.Amount.Quantity -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.amountQuantitySer, __d.value)
      }
      is SubstanceDefinition.Moiety.Amount.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.nameSer, it)
        }
      }
    }
    (value.measurementType)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.roleSer, it)
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

internal object SubstanceDefinitionPropertySerializer : KSerializer<SubstanceDefinition.Property> {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.Property {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueDateSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return SubstanceDefinition.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        SubstanceDefinition.Property.Value.from(
          valueCodeableConcept,
          valueQuantity,
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceDefinition.Property) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is SubstanceDefinition.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is SubstanceDefinition.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueQuantitySer, __d.value)
      }
      is SubstanceDefinition.Property.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueDateSer, it)
        }
      }
      is SubstanceDefinition.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueDateSer, it)
        }
      }
      is SubstanceDefinition.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueDateSer: KSerializer<Element> = Element.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object SubstanceDefinitionMolecularWeightSerializer :
  KSerializer<SubstanceDefinition.MolecularWeight> {
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

  override fun deserialize(decoder: Decoder): SubstanceDefinition.MolecularWeight =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.MolecularWeight) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.MolecularWeight {
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
    return SubstanceDefinition.MolecularWeight(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      method = method,
      type = type,
      amount = amount!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceDefinition.MolecularWeight,
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

internal object SubstanceDefinitionStructureSerializer :
  KSerializer<SubstanceDefinition.Structure> {
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
        "molecularWeight",
        lazyDescriptor { SubstanceDefinition.MolecularWeight.serializer().descriptor },
        isOptional = true,
      )
      element(
        "technique",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "sourceDocument",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "representation",
        listSerialDescriptor(
          lazyDescriptor { SubstanceDefinition.Structure.Representation.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Structure =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.Structure {
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
    var molecularWeight: SubstanceDefinition.MolecularWeight? = null
    var technique: List<CodeableConcept>? = null
    var sourceDocument: List<Reference>? = null
    var representation: List<SubstanceDefinition.Structure.Representation>? = null
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
          molecularWeight =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.molecularWeightSer, null)
        10 ->
          technique =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.techniqueSer, null)
        11 ->
          sourceDocument =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.sourceDocumentSer, null)
        12 ->
          representation =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.representationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Structure: " + __i)
      }
    }
    return SubstanceDefinition.Structure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      stereochemistry = stereochemistry,
      opticalActivity = opticalActivity,
      molecularFormula = R4bString.of(molecularFormula, _molecularFormula),
      molecularFormulaByMoiety = R4bString.of(molecularFormulaByMoiety, _molecularFormulaByMoiety),
      molecularWeight = molecularWeight,
      technique = technique ?: listOf(),
      sourceDocument = sourceDocument ?: listOf(),
      representation = representation ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceDefinition.Structure) {
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
    (value.molecularWeight)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.molecularWeightSer, it)
    }
    if (value.technique.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.techniqueSer, value.technique)
    if (value.sourceDocument.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.sourceDocumentSer, value.sourceDocument)
    if (value.representation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.representationSer, value.representation)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val stereochemistrySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val molecularFormulaSer: KSerializer<Element> = Element.serializer()

    public val molecularWeightSer: KSerializer<SubstanceDefinition.MolecularWeight> =
      SubstanceDefinition.MolecularWeight.serializer()

    public val techniqueSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.stereochemistrySer)

    public val sourceDocumentSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceDocumentSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.sourceDocumentSerInner)

    public val representationSerInner: KSerializer<SubstanceDefinition.Structure.Representation> =
      SubstanceDefinition.Structure.Representation.serializer()

    public val representationSer: KSerializer<List<SubstanceDefinition.Structure.Representation>> =
      ListSerializer(Hoisted.representationSerInner)
  }
}

internal object SubstanceDefinitionStructureRepresentationSerializer :
  KSerializer<SubstanceDefinition.Structure.Representation> {
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
      element("format", CodeableConcept.serializer().descriptor, isOptional = true)
      element("document", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Structure.Representation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure.Representation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SubstanceDefinition.Structure.Representation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var representation: KotlinString? = null
    var _representation: Element? = null
    var format: CodeableConcept? = null
    var document: Reference? = null
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
        6 -> format = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          document = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.documentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Representation: " + __i)
      }
    }
    return SubstanceDefinition.Structure.Representation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      representation = R4bString.of(representation, _representation),
      format = format,
      document = document,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceDefinition.Structure.Representation,
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
    (value.format)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    (value.document)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.documentSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val representationSer: KSerializer<Element> = Element.serializer()

    public val documentSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object SubstanceDefinitionCodeSerializer : KSerializer<SubstanceDefinition.Code> {
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
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Code =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Code) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.Code {
    val __desc = descriptor
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
        7 -> note = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.noteSer, null)
        8 -> source = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Code: " + __i)
      }
    }
    return SubstanceDefinition.Code(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      status = status,
      statusDate = DateTime.of(FhirDateTime.fromString(statusDate), _statusDate),
      note = note ?: listOf(),
      source = source ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceDefinition.Code) {
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
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.noteSer, value.note)
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val statusDateSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object SubstanceDefinitionNameSerializer : KSerializer<SubstanceDefinition.Name> {
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
        listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Name.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "translation",
        listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Name.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "official",
        listSerialDescriptor(
          lazyDescriptor { SubstanceDefinition.Name.Official.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Name =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.Name {
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
    var synonym: List<SubstanceDefinition.Name>? = null
    var translation: List<SubstanceDefinition.Name>? = null
    var official: List<SubstanceDefinition.Name.Official>? = null
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
    return SubstanceDefinition.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name)!!,
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceDefinition.Name) {
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

    public val synonymSerInner: KSerializer<SubstanceDefinition.Name> =
      SubstanceDefinition.Name.serializer()

    public val synonymSer: KSerializer<List<SubstanceDefinition.Name>> =
      ListSerializer(Hoisted.synonymSerInner)

    public val officialSerInner: KSerializer<SubstanceDefinition.Name.Official> =
      SubstanceDefinition.Name.Official.serializer()

    public val officialSer: KSerializer<List<SubstanceDefinition.Name.Official>> =
      ListSerializer(Hoisted.officialSerInner)

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object SubstanceDefinitionNameOfficialSerializer :
  KSerializer<SubstanceDefinition.Name.Official> {
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

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Name.Official =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name.Official) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.Name.Official {
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
    return SubstanceDefinition.Name.Official(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      authority = authority,
      status = status,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceDefinition.Name.Official) {
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

internal object SubstanceDefinitionRelationshipSerializer :
  KSerializer<SubstanceDefinition.Relationship> {
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
      element("substanceDefinitionReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "substanceDefinitionCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("isDefining", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isDefining", Element.serializer().descriptor, isOptional = true)
      element("amountQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("amountRatio", Ratio.serializer().descriptor, isOptional = true)
      element("amountString", KotlinString.serializer().descriptor, isOptional = true)
      element("_amountString", Element.serializer().descriptor, isOptional = true)
      element("ratioHighLimitAmount", Ratio.serializer().descriptor, isOptional = true)
      element("comparator", CodeableConcept.serializer().descriptor, isOptional = true)
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Relationship =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Relationship) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.Relationship {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          substanceDefinitionReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.substanceDefinitionReferenceSer,
              null,
            )
        4 ->
          substanceDefinitionCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.substanceDefinitionCodeableConceptSer,
              null,
            )
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.substanceDefinitionCodeableConceptSer,
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
          amountRatio =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.amountRatioSer, null)
        10 -> amountString = decoder.decodeStringElement(__desc, 10)
        11 ->
          _amountString =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.isDefiningSer, null)
        12 ->
          ratioHighLimitAmount =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.amountRatioSer, null)
        13 ->
          comparator =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.substanceDefinitionCodeableConceptSer,
              null,
            )
        14 ->
          source = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Relationship: " + __i)
      }
    }
    return SubstanceDefinition.Relationship(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      substanceDefinition =
        SubstanceDefinition.Relationship.SubstanceDefinition.from(
          substanceDefinitionReference,
          substanceDefinitionCodeableConcept,
        ),
      type = type!!,
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceDefinition.Relationship) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.substanceDefinition) {
      null -> {}
      is SubstanceDefinition.Relationship.SubstanceDefinition.Reference -> {
        encoder.encodeSerializableElement(
          __desc,
          3,
          Hoisted.substanceDefinitionReferenceSer,
          __d.value,
        )
      }
      is SubstanceDefinition.Relationship.SubstanceDefinition.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          4,
          Hoisted.substanceDefinitionCodeableConceptSer,
          __d.value,
        )
      }
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(
        __desc,
        5,
        Hoisted.substanceDefinitionCodeableConceptSer,
        it,
      )
    }
    ((value.isDefining?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.isDefining?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.isDefiningSer, it)
    }
    when (val __d = value.amount) {
      null -> {}
      is SubstanceDefinition.Relationship.Amount.Quantity -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.amountQuantitySer, __d.value)
      }
      is SubstanceDefinition.Relationship.Amount.Ratio -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.amountRatioSer, __d.value)
      }
      is SubstanceDefinition.Relationship.Amount.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.isDefiningSer, it)
        }
      }
    }
    (value.ratioHighLimitAmount)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.amountRatioSer, it)
    }
    (value.comparator)?.let {
      encoder.encodeSerializableElement(
        __desc,
        13,
        Hoisted.substanceDefinitionCodeableConceptSer,
        it,
      )
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val substanceDefinitionReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val substanceDefinitionCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val isDefiningSer: KSerializer<Element> = Element.serializer()

    public val amountQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val amountRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val sourceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.substanceDefinitionReferenceSer)
  }
}

internal object SubstanceDefinitionSourceMaterialSerializer :
  KSerializer<SubstanceDefinition.SourceMaterial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SourceMaterial") {
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
      element("genus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("species", CodeableConcept.serializer().descriptor, isOptional = true)
      element("part", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "countryOfOrigin",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.SourceMaterial =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.SourceMaterial) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition.SourceMaterial {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var genus: CodeableConcept? = null
    var species: CodeableConcept? = null
    var part: CodeableConcept? = null
    var countryOfOrigin: List<CodeableConcept>? = null
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
        4 -> genus = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> species = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> part = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          countryOfOrigin =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.countryOfOriginSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SourceMaterial: " + __i)
      }
    }
    return SubstanceDefinition.SourceMaterial(
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceDefinition.SourceMaterial,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.genus)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    (value.species)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    (value.part)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    if (value.countryOfOrigin.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.countryOfOriginSer,
        value.countryOfOrigin,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val countryOfOriginSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)
  }
}

internal object SubstanceDefinitionSerializer : KSerializer<SubstanceDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceDefinition") {
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "classification",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("domain", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "grade",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "informationSource",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "manufacturer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "supplier",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "moiety",
        listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Moiety.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(
          lazyDescriptor { SubstanceDefinition.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "molecularWeight",
        listSerialDescriptor(
          lazyDescriptor { SubstanceDefinition.MolecularWeight.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "structure",
        lazyDescriptor { SubstanceDefinition.Structure.serializer().descriptor },
        isOptional = true,
      )
      element(
        "code",
        listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Code.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "name",
        listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Name.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "relationship",
        listSerialDescriptor(
          lazyDescriptor { SubstanceDefinition.Relationship.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "sourceMaterial",
        lazyDescriptor { SubstanceDefinition.SourceMaterial.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): SubstanceDefinition {
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
        12 -> version = decoder.decodeStringElement(__desc, 12)
        13 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          status = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.statusSer, null)
        15 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.classificationSer, null)
        16 ->
          domain = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.statusSer, null)
        17 ->
          grade =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.classificationSer, null)
        18 -> description = decoder.decodeStringElement(__desc, 18)
        19 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          informationSource =
            decoder.decodeNullableSerializableElement(
              __desc,
              20,
              Hoisted.informationSourceSer,
              null,
            )
        21 -> note = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.noteSer, null)
        22 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.informationSourceSer,
              null,
            )
        23 ->
          supplier =
            decoder.decodeNullableSerializableElement(
              __desc,
              23,
              Hoisted.informationSourceSer,
              null,
            )
        24 ->
          moiety = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.moietySer, null)
        25 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.propertySer, null)
        26 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.molecularWeightSer, null)
        27 ->
          structure =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.structureSer, null)
        28 -> code = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.codeSer, null)
        29 -> name = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.nameSer, null)
        30 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.relationshipSer, null)
        31 ->
          sourceMaterial =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.sourceMaterialSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding SubstanceDefinition: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "SubstanceDefinition")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.statusSer, it) }
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.classificationSer, value.classification)
    (value.domain)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.statusSer, it) }
    if (value.grade.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.classificationSer, value.grade)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    if (value.informationSource.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20,
        Hoisted.informationSourceSer,
        value.informationSource,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.noteSer, value.note)
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22,
        Hoisted.informationSourceSer,
        value.manufacturer,
      )
    if (value.supplier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.informationSourceSer, value.supplier)
    if (value.moiety.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.moietySer, value.moiety)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.propertySer, value.`property`)
    if (value.molecularWeight.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26,
        Hoisted.molecularWeightSer,
        value.molecularWeight,
      )
    (value.structure)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.structureSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.codeSer, value.code)
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.nameSer, value.name)
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.relationshipSer, value.relationship)
    (value.sourceMaterial)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.sourceMaterialSer, it)
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val statusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classificationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusSer)

    public val informationSourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val informationSourceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.informationSourceSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val moietySerInner: KSerializer<SubstanceDefinition.Moiety> =
      SubstanceDefinition.Moiety.serializer()

    public val moietySer: KSerializer<List<SubstanceDefinition.Moiety>> =
      ListSerializer(Hoisted.moietySerInner)

    public val propertySerInner: KSerializer<SubstanceDefinition.Property> =
      SubstanceDefinition.Property.serializer()

    public val propertySer: KSerializer<List<SubstanceDefinition.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val molecularWeightSerInner: KSerializer<SubstanceDefinition.MolecularWeight> =
      SubstanceDefinition.MolecularWeight.serializer()

    public val molecularWeightSer: KSerializer<List<SubstanceDefinition.MolecularWeight>> =
      ListSerializer(Hoisted.molecularWeightSerInner)

    public val structureSer: KSerializer<SubstanceDefinition.Structure> =
      SubstanceDefinition.Structure.serializer()

    public val codeSerInner: KSerializer<SubstanceDefinition.Code> =
      SubstanceDefinition.Code.serializer()

    public val codeSer: KSerializer<List<SubstanceDefinition.Code>> =
      ListSerializer(Hoisted.codeSerInner)

    public val nameSerInner: KSerializer<SubstanceDefinition.Name> =
      SubstanceDefinition.Name.serializer()

    public val nameSer: KSerializer<List<SubstanceDefinition.Name>> =
      ListSerializer(Hoisted.nameSerInner)

    public val relationshipSerInner: KSerializer<SubstanceDefinition.Relationship> =
      SubstanceDefinition.Relationship.serializer()

    public val relationshipSer: KSerializer<List<SubstanceDefinition.Relationship>> =
      ListSerializer(Hoisted.relationshipSerInner)

    public val sourceMaterialSer: KSerializer<SubstanceDefinition.SourceMaterial> =
      SubstanceDefinition.SourceMaterial.serializer()
  }
}
