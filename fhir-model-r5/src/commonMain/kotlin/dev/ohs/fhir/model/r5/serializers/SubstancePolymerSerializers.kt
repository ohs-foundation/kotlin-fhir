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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Resource
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
      element("ratioType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "startingMaterial",
        listSerialDescriptor(
          lazyDescriptor { SubstancePolymer.MonomerSet.StartingMaterial.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstancePolymer.MonomerSet {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var ratioType: CodeableConcept? = null
    var startingMaterial: List<SubstancePolymer.MonomerSet.StartingMaterial>? = null
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
          ratioType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ratioTypeSer, null)
        4 ->
          startingMaterial =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.startingMaterialSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonomerSet: " + i)
      }
    }
    return SubstancePolymer.MonomerSet(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      ratioType = ratioType,
      startingMaterial = startingMaterial ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstancePolymer.MonomerSet) {
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
    (value.ratioType)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.ratioTypeSer, it)
    }
    if (value.startingMaterial.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        Hoisted.startingMaterialSer,
        value.startingMaterial,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val ratioTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val startingMaterialSerInner: KSerializer<SubstancePolymer.MonomerSet.StartingMaterial> =
      SubstancePolymer.MonomerSet.StartingMaterial.serializer()

    public val startingMaterialSer:
      KSerializer<List<SubstancePolymer.MonomerSet.StartingMaterial>> =
      ListSerializer(Hoisted.startingMaterialSerInner)
  }
}

internal object SubstancePolymerMonomerSetStartingMaterialSerializer :
  KSerializer<SubstancePolymer.MonomerSet.StartingMaterial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StartingMaterial") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("isDefining", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isDefining", Element.serializer().descriptor, isOptional = true)
      element("amount", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet.StartingMaterial =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet.StartingMaterial) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstancePolymer.MonomerSet.StartingMaterial {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var category: CodeableConcept? = null
    var isDefining: KotlinBoolean? = null
    var _isDefining: Element? = null
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
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          category = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> isDefining = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _isDefining =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.isDefiningSer, null)
        7 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StartingMaterial: " + i)
      }
    }
    return SubstancePolymer.MonomerSet.StartingMaterial(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      category = category,
      isDefining = R5Boolean.of(isDefining, _isDefining),
      amount = amount,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstancePolymer.MonomerSet.StartingMaterial,
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
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, it) }
    (value.category)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
    ((value.isDefining?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.isDefining?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.isDefiningSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val isDefiningSer: KSerializer<Element> = Element.serializer()

    public val amountSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object SubstancePolymerRepeatSerializer : KSerializer<SubstancePolymer.Repeat> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Repeat") {
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
      element("averageMolecularFormula", KotlinString.serializer().descriptor, isOptional = true)
      element("_averageMolecularFormula", Element.serializer().descriptor, isOptional = true)
      element("repeatUnitAmountType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "repeatUnit",
        listSerialDescriptor(
          lazyDescriptor { SubstancePolymer.Repeat.RepeatUnit.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstancePolymer.Repeat =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstancePolymer.Repeat {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var averageMolecularFormula: KotlinString? = null
    var _averageMolecularFormula: Element? = null
    var repeatUnitAmountType: CodeableConcept? = null
    var repeatUnit: List<SubstancePolymer.Repeat.RepeatUnit>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> averageMolecularFormula = decoder.decodeStringElement(descriptor, i)
        4 ->
          _averageMolecularFormula =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.averageMolecularFormulaSer,
              null,
            )
        5 ->
          repeatUnitAmountType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.repeatUnitAmountTypeSer,
              null,
            )
        6 ->
          repeatUnit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.repeatUnitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Repeat: " + i)
      }
    }
    return SubstancePolymer.Repeat(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      averageMolecularFormula = R5String.of(averageMolecularFormula, _averageMolecularFormula),
      repeatUnitAmountType = repeatUnitAmountType,
      repeatUnit = repeatUnit ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstancePolymer.Repeat) {
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
    ((value.averageMolecularFormula?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.averageMolecularFormula?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.averageMolecularFormulaSer, it)
    }
    (value.repeatUnitAmountType)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.repeatUnitAmountTypeSer, it)
    }
    if (value.repeatUnit.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.repeatUnitSer, value.repeatUnit)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val averageMolecularFormulaSer: KSerializer<Element> = Element.serializer()

    public val repeatUnitAmountTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val repeatUnitSerInner: KSerializer<SubstancePolymer.Repeat.RepeatUnit> =
      SubstancePolymer.Repeat.RepeatUnit.serializer()

    public val repeatUnitSer: KSerializer<List<SubstancePolymer.Repeat.RepeatUnit>> =
      ListSerializer(Hoisted.repeatUnitSerInner)
  }
}

internal object SubstancePolymerRepeatRepeatUnitSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RepeatUnit") {
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
      element("unit", KotlinString.serializer().descriptor, isOptional = true)
      element("_unit", Element.serializer().descriptor, isOptional = true)
      element("orientation", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Int.serializer().descriptor, isOptional = true)
      element("_amount", Element.serializer().descriptor, isOptional = true)
      element(
        "degreeOfPolymerisation",
        listSerialDescriptor(
          lazyDescriptor {
            SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "structuralRepresentation",
        listSerialDescriptor(
          lazyDescriptor {
            SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstancePolymer.Repeat.RepeatUnit =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat.RepeatUnit) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstancePolymer.Repeat.RepeatUnit {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> unit = decoder.decodeStringElement(descriptor, i)
        4 -> _unit = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitSer, null)
        5 ->
          orientation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.orientationSer, null)
        6 -> amount = decoder.decodeIntElement(descriptor, i)
        7 ->
          _amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitSer, null)
        8 ->
          degreeOfPolymerisation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.degreeOfPolymerisationSer,
              null,
            )
        9 ->
          structuralRepresentation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.structuralRepresentationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RepeatUnit: " + i)
      }
    }
    return SubstancePolymer.Repeat.RepeatUnit(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit,
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
    ((value.unit?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.unit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.unitSer, it)
    }
    (value.orientation)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.orientationSer, it)
    }
    ((value.amount?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.amount?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.unitSer, it)
    }
    if (value.degreeOfPolymerisation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        Hoisted.degreeOfPolymerisationSer,
        value.degreeOfPolymerisation,
      )
    if (value.structuralRepresentation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        Hoisted.structuralRepresentationSer,
        value.structuralRepresentation,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val unitSer: KSerializer<Element> = Element.serializer()

    public val orientationSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val degreeOfPolymerisationSerInner:
      KSerializer<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation> =
      SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation.serializer()

    public val degreeOfPolymerisationSer:
      KSerializer<List<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation>> =
      ListSerializer(Hoisted.degreeOfPolymerisationSerInner)

    public val structuralRepresentationSerInner:
      KSerializer<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation> =
      SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation.serializer()

    public val structuralRepresentationSer:
      KSerializer<List<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation>> =
      ListSerializer(Hoisted.structuralRepresentationSerInner)
  }
}

internal object SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DegreeOfPolymerisation") {
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
      element("average", Int.serializer().descriptor, isOptional = true)
      element("_average", Element.serializer().descriptor, isOptional = true)
      element("low", Int.serializer().descriptor, isOptional = true)
      element("_low", Element.serializer().descriptor, isOptional = true)
      element("high", Int.serializer().descriptor, isOptional = true)
      element("_high", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> average = decoder.decodeIntElement(descriptor, i)
        5 ->
          _average =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.averageSer, null)
        6 -> low = decoder.decodeIntElement(descriptor, i)
        7 ->
          _low = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.averageSer, null)
        8 -> high = decoder.decodeIntElement(descriptor, i)
        9 ->
          _high = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.averageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DegreeOfPolymerisation: " + i)
      }
    }
    return SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      average = Integer.of(average, _average),
      low = Integer.of(low, _low),
      high = Integer.of(high, _high),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation,
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
    ((value.average?.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
    (value.average?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.averageSer, it)
    }
    ((value.low?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.low?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.averageSer, it)
    }
    ((value.high?.value))?.let { encoder.encodeIntElement(descriptor, 8, it) }
    (value.high?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.averageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val averageSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructuralRepresentation") {
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
      element("attachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var representation: KotlinString? = null
    var _representation: Element? = null
    var format: CodeableConcept? = null
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
          format = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          attachment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.attachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding StructuralRepresentation: " + i)
      }
    }
    return SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      representation = R5String.of(representation, _representation),
      format = format,
      attachment = attachment,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation,
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
    (value.attachment)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.attachmentSer, it)
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

internal object SubstancePolymerSerializer : KSerializer<SubstancePolymer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstancePolymer") {
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
    b.element("class", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("geometry", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "copolymerConnectivity",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("modification", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_modification", Element.serializer().descriptor, isOptional = true)
    b.element(
      "monomerSet",
      listSerialDescriptor(lazyDescriptor { SubstancePolymer.MonomerSet.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "repeat",
      listSerialDescriptor(lazyDescriptor { SubstancePolymer.Repeat.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstancePolymer")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        11 ->
          `class` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classSer, null)
        12 ->
          geometry =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classSer, null)
        13 ->
          copolymerConnectivity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.copolymerConnectivitySer,
              null,
            )
        14 -> modification = decoder.decodeStringElement(descriptor, i)
        15 ->
          _modification =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          monomerSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.monomerSetSer, null)
        17 ->
          repeat = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.repeatSer, null)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstancePolymer,
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
    (value.`class`)?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, Hoisted.classSer, it)
    }
    (value.geometry)?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, Hoisted.classSer, it)
    }
    if (value.copolymerConnectivity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.copolymerConnectivitySer,
        value.copolymerConnectivity,
      )
    ((value.modification?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.modification?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.monomerSet.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.monomerSetSer,
        value.monomerSet,
      )
    if (value.repeat.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.repeatSer,
        value.repeat,
      )
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

    public val classSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val copolymerConnectivitySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.classSer)

    public val monomerSetSerInner: KSerializer<SubstancePolymer.MonomerSet> =
      SubstancePolymer.MonomerSet.serializer()

    public val monomerSetSer: KSerializer<List<SubstancePolymer.MonomerSet>> =
      ListSerializer(Hoisted.monomerSetSerInner)

    public val repeatSerInner: KSerializer<SubstancePolymer.Repeat> =
      SubstancePolymer.Repeat.serializer()

    public val repeatSer: KSerializer<List<SubstancePolymer.Repeat>> =
      ListSerializer(Hoisted.repeatSerInner)
  }
}

internal object SubstancePolymerPolymorphicSerializer : KSerializer<SubstancePolymer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstancePolymer") {
      SubstancePolymerSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer) {
    encoder.encodeStructure(descriptor) {
      SubstancePolymerSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer =
    decoder.decodeStructure(descriptor) {
      SubstancePolymerSerializer.deserializeInternal(this, descriptor, 0)
    }
}
