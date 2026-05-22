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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubstanceDefinition
import dev.ohs.fhir.model.r5.Uri
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Moiety) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.Moiety {
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
        14 ->
          measurementType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Moiety: " + i)
      }
    }
    return SubstanceDefinition.Moiety(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role = role,
      identifier = identifier,
      name = R5String.of(name, _name),
      stereochemistry = stereochemistry,
      opticalActivity = opticalActivity,
      molecularFormula = R5String.of(molecularFormula, _molecularFormula),
      amount =
        SubstanceDefinition.Moiety.Amount.from(
          amountQuantity,
          R5String.of(amountString, _amountString),
        ),
      measurementType = measurementType,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceDefinition.Moiety) {
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
      is SubstanceDefinition.Moiety.Amount.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.amountQuantitySer, choice.value)
      }
      is SubstanceDefinition.Moiety.Amount.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.nameSer, it)
        }
      }
    }
    (value.measurementType)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.roleSer, it)
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

internal object SubstanceDefinitionCharacterizationSerializer :
  KSerializer<SubstanceDefinition.Characterization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characterization") {
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
      element("technique", CodeableConcept.serializer().descriptor, isOptional = true)
      element("form", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("file", listSerialDescriptor(Attachment.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Characterization =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Characterization) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.Characterization {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var technique: CodeableConcept? = null
    var form: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var `file`: List<Attachment>? = null
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
          technique =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.techniqueSer, null)
        4 ->
          form =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.techniqueSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        7 ->
          `file` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fileSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characterization: " + i)
      }
    }
    return SubstanceDefinition.Characterization(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      technique = technique,
      form = form,
      description = Markdown.of(description, _description),
      `file` = `file` ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceDefinition.Characterization,
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
    (value.technique)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.techniqueSer, it)
    }
    (value.form)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.techniqueSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.descriptionSer, it)
    }
    if (value.`file`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.fileSer, value.`file`)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val techniqueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val fileSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val fileSer: KSerializer<List<Attachment>> = ListSerializer(Hoisted.fileSerInner)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Property) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.Property {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDateSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
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
          R5Boolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceDefinition.Property) {
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
    when (val choice = value.`value`) {
      null -> {}
      is SubstanceDefinition.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, choice.value)
      }
      is SubstanceDefinition.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueQuantitySer, choice.value)
      }
      is SubstanceDefinition.Property.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueDateSer, it)
        }
      }
      is SubstanceDefinition.Property.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueDateSer, it)
        }
      }
      is SubstanceDefinition.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueAttachmentSer, choice.value)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.MolecularWeight) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.MolecularWeight {
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
    return SubstanceDefinition.MolecularWeight(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      method = method,
      type = type,
      amount = amount!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceDefinition.MolecularWeight,
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.Structure {
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
          molecularWeight =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.molecularWeightSer,
              null,
            )
        10 ->
          technique =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.techniqueSer, null)
        11 ->
          sourceDocument =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sourceDocumentSer,
              null,
            )
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
    return SubstanceDefinition.Structure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      stereochemistry = stereochemistry,
      opticalActivity = opticalActivity,
      molecularFormula = R5String.of(molecularFormula, _molecularFormula),
      molecularFormulaByMoiety = R5String.of(molecularFormulaByMoiety, _molecularFormulaByMoiety),
      molecularWeight = molecularWeight,
      technique = technique ?: listOf(),
      sourceDocument = sourceDocument ?: listOf(),
      representation = representation ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceDefinition.Structure) {
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
    (value.molecularWeight)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.molecularWeightSer, it)
    }
    if (value.technique.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.techniqueSer, value.technique)
    if (value.sourceDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        Hoisted.sourceDocumentSer,
        value.sourceDocument,
      )
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure.Representation) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceDefinition.Structure.Representation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var representation: KotlinString? = null
    var _representation: Element? = null
    var format: CodeableConcept? = null
    var document: Reference? = null
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
          format = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          document =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Representation: " + i)
      }
    }
    return SubstanceDefinition.Structure.Representation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      representation = R5String.of(representation, _representation),
      format = format,
      document = document,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceDefinition.Structure.Representation,
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
    (value.format)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    (value.document)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.documentSer, it)
    }
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Code) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.Code {
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
        7 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        8 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Code: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceDefinition.Code) {
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
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.noteSer, value.note)
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.sourceSer, value.source)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.Name {
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
    return SubstanceDefinition.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      type = type,
      status = status,
      preferred = R5Boolean.of(preferred, _preferred),
      language = language ?: listOf(),
      domain = domain ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      synonym = synonym ?: listOf(),
      translation = translation ?: listOf(),
      official = official ?: listOf(),
      source = source ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceDefinition.Name) {
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name.Official) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.Name.Official {
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
    return SubstanceDefinition.Name.Official(
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
    `value`: SubstanceDefinition.Name.Official,
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Relationship) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.Relationship {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          substanceDefinitionReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.substanceDefinitionReferenceSer,
              null,
            )
        4 ->
          substanceDefinitionCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.substanceDefinitionCodeableConceptSer,
              null,
            )
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.substanceDefinitionCodeableConceptSer,
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
          amountRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountRatioSer, null)
        10 -> amountString = decoder.decodeStringElement(descriptor, i)
        11 ->
          _amountString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.isDefiningSer, null)
        12 ->
          ratioHighLimitAmount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountRatioSer, null)
        13 ->
          comparator =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.substanceDefinitionCodeableConceptSer,
              null,
            )
        14 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Relationship: " + i)
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
      isDefining = R5Boolean.of(isDefining, _isDefining),
      amount =
        SubstanceDefinition.Relationship.Amount.from(
          amountQuantity,
          amountRatio,
          R5String.of(amountString, _amountString),
        ),
      ratioHighLimitAmount = ratioHighLimitAmount,
      comparator = comparator,
      source = source ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceDefinition.Relationship,
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
    when (val choice = value.substanceDefinition) {
      null -> {}
      is SubstanceDefinition.Relationship.SubstanceDefinition.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.substanceDefinitionReferenceSer,
          choice.value,
        )
      }
      is SubstanceDefinition.Relationship.SubstanceDefinition.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.substanceDefinitionCodeableConceptSer,
          choice.value,
        )
      }
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5,
        Hoisted.substanceDefinitionCodeableConceptSer,
        it,
      )
    }
    ((value.isDefining?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.isDefining?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.isDefiningSer, it)
    }
    when (val choice = value.amount) {
      null -> {}
      is SubstanceDefinition.Relationship.Amount.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.amountQuantitySer, choice.value)
      }
      is SubstanceDefinition.Relationship.Amount.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.amountRatioSer, choice.value)
      }
      is SubstanceDefinition.Relationship.Amount.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.isDefiningSer, it)
        }
      }
    }
    (value.ratioHighLimitAmount)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.amountRatioSer, it)
    }
    (value.comparator)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13,
        Hoisted.substanceDefinitionCodeableConceptSer,
        it,
      )
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.sourceSer, value.source)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.SourceMaterial) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceDefinition.SourceMaterial {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var genus: CodeableConcept? = null
    var species: CodeableConcept? = null
    var part: CodeableConcept? = null
    var countryOfOrigin: List<CodeableConcept>? = null
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
        4 -> genus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          species = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> part = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          countryOfOrigin =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.countryOfOriginSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SourceMaterial: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceDefinition.SourceMaterial,
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
    (value.genus)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    (value.species)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    (value.part)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    if (value.countryOfOrigin.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "classification",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("domain", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "grade",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "informationSource",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "manufacturer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "supplier",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "moiety",
      listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Moiety.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "characterization",
      listSerialDescriptor(
        lazyDescriptor { SubstanceDefinition.Characterization.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "property",
      listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Property.serializer().descriptor }),
      isOptional = true,
    )
    b.element("referenceInformation", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "molecularWeight",
      listSerialDescriptor(
        lazyDescriptor { SubstanceDefinition.MolecularWeight.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "structure",
      lazyDescriptor { SubstanceDefinition.Structure.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "code",
      listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Code.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "name",
      listSerialDescriptor(lazyDescriptor { SubstanceDefinition.Name.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "relationship",
      listSerialDescriptor(
        lazyDescriptor { SubstanceDefinition.Relationship.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("nucleicAcid", Reference.serializer().descriptor, isOptional = true)
    b.element("polymer", Reference.serializer().descriptor, isOptional = true)
    b.element("protein", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "sourceMaterial",
      lazyDescriptor { SubstanceDefinition.SourceMaterial.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstanceDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
    var characterization: List<SubstanceDefinition.Characterization>? = null
    var `property`: List<SubstanceDefinition.Property>? = null
    var referenceInformation: Reference? = null
    var molecularWeight: List<SubstanceDefinition.MolecularWeight>? = null
    var structure: SubstanceDefinition.Structure? = null
    var code: List<SubstanceDefinition.Code>? = null
    var name: List<SubstanceDefinition.Name>? = null
    var relationship: List<SubstanceDefinition.Relationship>? = null
    var nucleicAcid: Reference? = null
    var polymer: Reference? = null
    var protein: Reference? = null
    var sourceMaterial: SubstanceDefinition.SourceMaterial? = null
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
        11 -> version = decoder.decodeStringElement(descriptor, i)
        12 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          status = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        14 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        15 ->
          domain = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        16 ->
          grade =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        17 -> description = decoder.decodeStringElement(descriptor, i)
        18 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          informationSource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.informationSourceSer,
              null,
            )
        20 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        21 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.informationSourceSer,
              null,
            )
        22 ->
          supplier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.informationSourceSer,
              null,
            )
        23 ->
          moiety = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.moietySer, null)
        24 ->
          characterization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characterizationSer,
              null,
            )
        25 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        26 ->
          referenceInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.informationSourceSerInner,
              null,
            )
        27 ->
          molecularWeight =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.molecularWeightSer,
              null,
            )
        28 ->
          structure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.structureSer, null)
        29 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        30 -> name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        31 ->
          relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relationshipSer, null)
        32 ->
          nucleicAcid =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.informationSourceSerInner,
              null,
            )
        33 ->
          polymer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.informationSourceSerInner,
              null,
            )
        34 ->
          protein =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.informationSourceSerInner,
              null,
            )
        35 ->
          sourceMaterial =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sourceMaterialSer,
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
      version = R5String.of(version, _version),
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
      characterization = characterization ?: listOf(),
      `property` = `property` ?: listOf(),
      referenceInformation = referenceInformation,
      molecularWeight = molecularWeight ?: listOf(),
      structure = structure,
      code = code ?: listOf(),
      name = name ?: listOf(),
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
    `value`: SubstanceDefinition,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.status)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.statusSer, it)
    }
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.classificationSer,
        value.classification,
      )
    (value.domain)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.statusSer, it)
    }
    if (value.grade.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.classificationSer,
        value.grade,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.informationSource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.informationSourceSer,
        value.informationSource,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.informationSourceSer,
        value.manufacturer,
      )
    if (value.supplier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.informationSourceSer,
        value.supplier,
      )
    if (value.moiety.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.moietySer,
        value.moiety,
      )
    if (value.characterization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.characterizationSer,
        value.characterization,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.propertySer,
        value.`property`,
      )
    (value.referenceInformation)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.informationSourceSerInner,
        it,
      )
    }
    if (value.molecularWeight.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.molecularWeightSer,
        value.molecularWeight,
      )
    (value.structure)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.structureSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.codeSer,
        value.code,
      )
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.nameSer,
        value.name,
      )
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.relationshipSer,
        value.relationship,
      )
    (value.nucleicAcid)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.informationSourceSerInner,
        it,
      )
    }
    (value.polymer)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.informationSourceSerInner,
        it,
      )
    }
    (value.protein)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.informationSourceSerInner,
        it,
      )
    }
    (value.sourceMaterial)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.sourceMaterialSer,
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

    public val characterizationSerInner: KSerializer<SubstanceDefinition.Characterization> =
      SubstanceDefinition.Characterization.serializer()

    public val characterizationSer: KSerializer<List<SubstanceDefinition.Characterization>> =
      ListSerializer(Hoisted.characterizationSerInner)

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

internal object SubstanceDefinitionPolymorphicSerializer : KSerializer<SubstanceDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceDefinition") {
      SubstanceDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition) {
    encoder.encodeStructure(descriptor) {
      SubstanceDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition =
    decoder.decodeStructure(descriptor) {
      SubstanceDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
