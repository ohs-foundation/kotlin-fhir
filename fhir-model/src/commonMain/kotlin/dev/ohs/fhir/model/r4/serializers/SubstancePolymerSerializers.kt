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
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceAmount
import dev.ohs.fhir.model.r4.SubstancePolymer
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstancePolymer.MonomerSet {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var ratioType: CodeableConcept? = null
    var startingMaterial: List<SubstancePolymer.MonomerSet.StartingMaterial>? = null
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
          ratioType =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.ratioTypeSer, null)
        4 ->
          startingMaterial =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.startingMaterialSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonomerSet: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstancePolymer.MonomerSet) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.ratioType)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.ratioTypeSer, it)
    }
    if (value.startingMaterial.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
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
      element("material", CodeableConcept.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("isDefining", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isDefining", Element.serializer().descriptor, isOptional = true)
      element("amount", SubstanceAmount.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet.StartingMaterial =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet.StartingMaterial) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SubstancePolymer.MonomerSet.StartingMaterial {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var material: CodeableConcept? = null
    var type: CodeableConcept? = null
    var isDefining: KotlinBoolean? = null
    var _isDefining: Element? = null
    var amount: SubstanceAmount? = null
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
          material = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.materialSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.materialSer, null)
        5 -> isDefining = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _isDefining =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.isDefiningSer, null)
        7 -> amount = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StartingMaterial: " + __i)
      }
    }
    return SubstancePolymer.MonomerSet.StartingMaterial(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      material = material,
      type = type,
      isDefining = R4Boolean.of(isDefining, _isDefining),
      amount = amount,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstancePolymer.MonomerSet.StartingMaterial,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.material)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.materialSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.materialSer, it) }
    ((value.isDefining?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.isDefining?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.isDefiningSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val materialSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val isDefiningSer: KSerializer<Element> = Element.serializer()

    public val amountSer: KSerializer<SubstanceAmount> = SubstanceAmount.serializer()
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
      element("numberOfUnits", Int.serializer().descriptor, isOptional = true)
      element("_numberOfUnits", Element.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstancePolymer.Repeat {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var numberOfUnits: Int? = null
    var _numberOfUnits: Element? = null
    var averageMolecularFormula: KotlinString? = null
    var _averageMolecularFormula: Element? = null
    var repeatUnitAmountType: CodeableConcept? = null
    var repeatUnit: List<SubstancePolymer.Repeat.RepeatUnit>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> numberOfUnits = decoder.decodeIntElement(__desc, 3)
        4 ->
          _numberOfUnits =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.numberOfUnitsSer, null)
        5 -> averageMolecularFormula = decoder.decodeStringElement(__desc, 5)
        6 ->
          _averageMolecularFormula =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.numberOfUnitsSer, null)
        7 ->
          repeatUnitAmountType =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.repeatUnitAmountTypeSer,
              null,
            )
        8 ->
          repeatUnit =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.repeatUnitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Repeat: " + __i)
      }
    }
    return SubstancePolymer.Repeat(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      numberOfUnits = Integer.of(numberOfUnits, _numberOfUnits),
      averageMolecularFormula = R4String.of(averageMolecularFormula, _averageMolecularFormula),
      repeatUnitAmountType = repeatUnitAmountType,
      repeatUnit = repeatUnit ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstancePolymer.Repeat) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.numberOfUnits?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.numberOfUnits?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.numberOfUnitsSer, it)
    }
    ((value.averageMolecularFormula?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.averageMolecularFormula?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.numberOfUnitsSer, it)
    }
    (value.repeatUnitAmountType)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.repeatUnitAmountTypeSer, it)
    }
    if (value.repeatUnit.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.repeatUnitSer, value.repeatUnit)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val numberOfUnitsSer: KSerializer<Element> = Element.serializer()

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
      element(
        "orientationOfPolymerisation",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("repeatUnit", KotlinString.serializer().descriptor, isOptional = true)
      element("_repeatUnit", Element.serializer().descriptor, isOptional = true)
      element("amount", SubstanceAmount.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat.RepeatUnit) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstancePolymer.Repeat.RepeatUnit {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var orientationOfPolymerisation: CodeableConcept? = null
    var repeatUnit: KotlinString? = null
    var _repeatUnit: Element? = null
    var amount: SubstanceAmount? = null
    var degreeOfPolymerisation: List<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation>? =
      null
    var structuralRepresentation:
      List<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation>? =
      null
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
          orientationOfPolymerisation =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.orientationOfPolymerisationSer,
              null,
            )
        4 -> repeatUnit = decoder.decodeStringElement(__desc, 4)
        5 ->
          _repeatUnit =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.repeatUnitSer, null)
        6 -> amount = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.amountSer, null)
        7 ->
          degreeOfPolymerisation =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.degreeOfPolymerisationSer,
              null,
            )
        8 ->
          structuralRepresentation =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.structuralRepresentationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RepeatUnit: " + __i)
      }
    }
    return SubstancePolymer.Repeat.RepeatUnit(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      orientationOfPolymerisation = orientationOfPolymerisation,
      repeatUnit = R4String.of(repeatUnit, _repeatUnit),
      amount = amount,
      degreeOfPolymerisation = degreeOfPolymerisation ?: listOf(),
      structuralRepresentation = structuralRepresentation ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.orientationOfPolymerisation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.orientationOfPolymerisationSer, it)
    }
    ((value.repeatUnit?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.repeatUnit?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.repeatUnitSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.amountSer, it) }
    if (value.degreeOfPolymerisation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.degreeOfPolymerisationSer,
        value.degreeOfPolymerisation,
      )
    if (value.structuralRepresentation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        8,
        Hoisted.structuralRepresentationSer,
        value.structuralRepresentation,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val orientationOfPolymerisationSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val repeatUnitSer: KSerializer<Element> = Element.serializer()

    public val amountSer: KSerializer<SubstanceAmount> = SubstanceAmount.serializer()

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
      element("degree", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", SubstanceAmount.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var degree: CodeableConcept? = null
    var amount: SubstanceAmount? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> degree = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.degreeSer, null)
        4 -> amount = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding DegreeOfPolymerisation: " + __i)
      }
    }
    return SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      degree = degree,
      amount = amount,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.degree)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.degreeSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val degreeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<SubstanceAmount> = SubstanceAmount.serializer()
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
      element("attachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation {
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
        else ->
          throw SerializationException("Unexpected index decoding StructuralRepresentation: " + __i)
      }
    }
    return SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation(
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
    `value`: SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation,
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
    b.element("class", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("geometry", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "copolymerConnectivity",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modification",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_modification",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstancePolymer")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): SubstancePolymer {
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
    var `class`: CodeableConcept? = null
    var geometry: CodeableConcept? = null
    var copolymerConnectivity: List<CodeableConcept>? = null
    var modification: List<KotlinString?>? = null
    var _modification: List<Element?>? = null
    var monomerSet: List<SubstancePolymer.MonomerSet>? = null
    var repeat: List<SubstancePolymer.Repeat>? = null
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
          `class` = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.classSer, null)
        12 ->
          geometry = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.classSer, null)
        13 ->
          copolymerConnectivity =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.copolymerConnectivitySer,
              null,
            )
        14 ->
          modification =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.modificationSer, null)
        15 ->
          _modification =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.modificationSer2, null)
        16 ->
          monomerSet =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.monomerSetSer, null)
        17 ->
          repeat = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.repeatSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubstancePolymer: " + __i)
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
      `class` = `class`,
      geometry = geometry,
      copolymerConnectivity = copolymerConnectivity ?: listOf(),
      modification =
        (kotlin.collections.List(maxOf(modification?.size ?: 0, _modification?.size ?: 0)) { __i ->
          R4String.of(modification?.getOrNull(__i)?.let { it }, _modification?.getOrNull(__i))!!
        }),
      monomerSet = monomerSet ?: listOf(),
      repeat = repeat ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: SubstancePolymer) {
    val __desc = descriptor
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
    (value.`class`)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.classSer, it) }
    (value.geometry)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.classSer, it) }
    if (value.copolymerConnectivity.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        13,
        Hoisted.copolymerConnectivitySer,
        value.copolymerConnectivity,
      )
    (value.modification.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.modificationSer, it)
    }
    (value.modification.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.modificationSer2, it)
    }
    if (value.monomerSet.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.monomerSetSer, value.monomerSet)
    if (value.repeat.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.repeatSer, value.repeat)
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

    public val classSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val copolymerConnectivitySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.classSer)

    public val modificationSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val modificationSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.modificationSerInner).nullable)

    public val modificationSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

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
    encoder.encodeStructure(descriptor) { SubstancePolymerSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer =
    decoder.decodeStructure(descriptor) { SubstancePolymerSerializer.deserializeJson(this) }
}
