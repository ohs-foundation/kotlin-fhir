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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.MedicationKnowledge
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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

internal object MedicationKnowledgeRelatedMedicationKnowledgeSerializer :
  KSerializer<MedicationKnowledge.RelatedMedicationKnowledge> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedMedicationKnowledge") {
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
      element(
        "reference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.RelatedMedicationKnowledge =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.RelatedMedicationKnowledge,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.RelatedMedicationKnowledge {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var reference: List<Reference>? = null
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
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding RelatedMedicationKnowledge: " + i)
      }
    }
    return MedicationKnowledge.RelatedMedicationKnowledge(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      reference = reference ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.RelatedMedicationKnowledge,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    if (value.reference.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.referenceSer, value.reference)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val referenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val referenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.referenceSerInner)
  }
}

internal object MedicationKnowledgeMonographSerializer :
  KSerializer<MedicationKnowledge.Monograph> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Monograph") {
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
      element("source", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Monograph =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Monograph) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationKnowledge.Monograph {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var source: Reference? = null
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
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Monograph: " + i)
      }
    }
    return MedicationKnowledge.Monograph(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      source = source,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MedicationKnowledge.Monograph) {
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
    (value.source)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.sourceSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sourceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MedicationKnowledgeIngredientSerializer :
  KSerializer<MedicationKnowledge.Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") {
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
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
      element("isActive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_isActive", Element.serializer().descriptor, isOptional = true)
      element("strength", Ratio.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Ingredient =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Ingredient) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationKnowledge.Ingredient {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var isActive: KotlinBoolean? = null
    var _isActive: Element? = null
    var strength: Ratio? = null
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
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        4 ->
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        5 -> isActive = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _isActive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.isActiveSer, null)
        7 ->
          strength =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
      }
    }
    return MedicationKnowledge.Ingredient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = MedicationKnowledge.Ingredient.Item.from(itemCodeableConcept, itemReference)!!,
      isActive = R4Boolean.of(isActive, _isActive),
      strength = strength,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Ingredient,
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
    when (val choice = value.item) {
      is MedicationKnowledge.Ingredient.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.itemCodeableConceptSer,
          choice.value,
        )
      }
      is MedicationKnowledge.Ingredient.Item.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemReferenceSer, choice.value)
      }
    }
    ((value.isActive?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.isActive?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.isActiveSer, it)
    }
    (value.strength)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.strengthSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val isActiveSer: KSerializer<Element> = Element.serializer()

    public val strengthSer: KSerializer<Ratio> = Ratio.serializer()
  }
}

internal object MedicationKnowledgeCostSerializer : KSerializer<MedicationKnowledge.Cost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Cost") {
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
      element("source", KotlinString.serializer().descriptor, isOptional = true)
      element("_source", Element.serializer().descriptor, isOptional = true)
      element("cost", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Cost =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Cost) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationKnowledge.Cost {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var cost: Money? = null
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
        4 -> source = decoder.decodeStringElement(descriptor, i)
        5 ->
          _source =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        6 -> cost = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.costSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Cost: " + i)
      }
    }
    return MedicationKnowledge.Cost(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      source = R4String.of(source, _source),
      cost = cost!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MedicationKnowledge.Cost) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    ((value.source?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.sourceSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 6, Hoisted.costSer, value.cost)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sourceSer: KSerializer<Element> = Element.serializer()

    public val costSer: KSerializer<Money> = Money.serializer()
  }
}

internal object MedicationKnowledgeMonitoringProgramSerializer :
  KSerializer<MedicationKnowledge.MonitoringProgram> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MonitoringProgram") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.MonitoringProgram =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MonitoringProgram) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.MonitoringProgram {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
        4 -> name = decoder.decodeStringElement(descriptor, i)
        5 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonitoringProgram: " + i)
      }
    }
    return MedicationKnowledge.MonitoringProgram(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      name = R4String.of(name, _name),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.MonitoringProgram,
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
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MedicationKnowledgeAdministrationGuidelinesSerializer :
  KSerializer<MedicationKnowledge.AdministrationGuidelines> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AdministrationGuidelines") {
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
        "dosage",
        listSerialDescriptor(
          lazyDescriptor {
            MedicationKnowledge.AdministrationGuidelines.Dosage.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "indicationCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("indicationReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "patientCharacteristics",
        listSerialDescriptor(
          lazyDescriptor {
            MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.AdministrationGuidelines =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.AdministrationGuidelines) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.AdministrationGuidelines {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var dosage: List<MedicationKnowledge.AdministrationGuidelines.Dosage>? = null
    var indicationCodeableConcept: CodeableConcept? = null
    var indicationReference: Reference? = null
    var patientCharacteristics:
      List<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics>? =
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
        3 ->
          dosage = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dosageSer, null)
        4 ->
          indicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.indicationCodeableConceptSer,
              null,
            )
        5 ->
          indicationReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.indicationReferenceSer,
              null,
            )
        6 ->
          patientCharacteristics =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.patientCharacteristicsSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding AdministrationGuidelines: " + i)
      }
    }
    return MedicationKnowledge.AdministrationGuidelines(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      dosage = dosage ?: listOf(),
      indication =
        MedicationKnowledge.AdministrationGuidelines.Indication.from(
          indicationCodeableConcept,
          indicationReference,
        ),
      patientCharacteristics = patientCharacteristics ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.AdministrationGuidelines,
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
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.dosageSer, value.dosage)
    when (val choice = value.indication) {
      null -> {}
      is MedicationKnowledge.AdministrationGuidelines.Indication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.indicationCodeableConceptSer,
          choice.value,
        )
      }
      is MedicationKnowledge.AdministrationGuidelines.Indication.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          5,
          Hoisted.indicationReferenceSer,
          choice.value,
        )
      }
    }
    if (value.patientCharacteristics.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        Hoisted.patientCharacteristicsSer,
        value.patientCharacteristics,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val dosageSerInner: KSerializer<MedicationKnowledge.AdministrationGuidelines.Dosage> =
      MedicationKnowledge.AdministrationGuidelines.Dosage.serializer()

    public val dosageSer: KSerializer<List<MedicationKnowledge.AdministrationGuidelines.Dosage>> =
      ListSerializer(Hoisted.dosageSerInner)

    public val indicationCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val indicationReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val patientCharacteristicsSerInner:
      KSerializer<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics> =
      MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.serializer()

    public val patientCharacteristicsSer:
      KSerializer<List<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics>> =
      ListSerializer(Hoisted.patientCharacteristicsSerInner)
  }
}

internal object MedicationKnowledgeAdministrationGuidelinesDosageSerializer :
  KSerializer<MedicationKnowledge.AdministrationGuidelines.Dosage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage") {
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
      element("dosage", listSerialDescriptor(Dosage.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.AdministrationGuidelines.Dosage =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.Dosage,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.AdministrationGuidelines.Dosage {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var dosage: List<Dosage>? = null
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
          dosage = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dosageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage: " + i)
      }
    }
    return MedicationKnowledge.AdministrationGuidelines.Dosage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      dosage = dosage ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.Dosage,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.dosageSer, value.dosage)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val dosageSerInner: KSerializer<Dosage> = Dosage.serializer()

    public val dosageSer: KSerializer<List<Dosage>> = ListSerializer(Hoisted.dosageSerInner)
  }
}

internal object MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsSerializer :
  KSerializer<MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PatientCharacteristics") {
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
        "characteristicCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("characteristicQuantity", Quantity.serializer().descriptor, isOptional = true)
      element(
        "value",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_value", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var characteristicCodeableConcept: CodeableConcept? = null
    var characteristicQuantity: Quantity? = null
    var `value`: List<KotlinString?>? = null
    var _value: List<Element?>? = null
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
          characteristicCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characteristicCodeableConceptSer,
              null,
            )
        4 ->
          characteristicQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characteristicQuantitySer,
              null,
            )
        5 ->
          `value` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        6 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding PatientCharacteristics: " + i)
      }
    }
    return MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      characteristic =
        MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.from(
          characteristicCodeableConcept,
          characteristicQuantity,
        )!!,
      `value` =
        (kotlin.collections.List(maxOf(`value`?.size ?: 0, _value?.size ?: 0)) { index ->
          R4String.of(`value`?.getOrNull(index)?.let { it }, _value?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics,
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
    when (val choice = value.characteristic) {
      is MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.characteristicCodeableConceptSer,
          choice.value,
        )
      }
      is MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.characteristicQuantitySer,
          choice.value,
        )
      }
    }
    (value.`value`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueSer, it)
    }
    (value.`value`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val characteristicCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val characteristicQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val valueSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.valueSerInner).nullable)

    public val valueSerInner2: KSerializer<Element> = Element.serializer()

    public val valueSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.valueSerInner2).nullable)
  }
}

internal object MedicationKnowledgeMedicineClassificationSerializer :
  KSerializer<MedicationKnowledge.MedicineClassification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicineClassification") {
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
      element(
        "classification",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.MedicineClassification =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MedicineClassification) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.MedicineClassification {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var classification: List<CodeableConcept>? = null
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
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding MedicineClassification: " + i)
      }
    }
    return MedicationKnowledge.MedicineClassification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      classification = classification ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.MedicineClassification,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        Hoisted.classificationSer,
        value.classification,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classificationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)
  }
}

internal object MedicationKnowledgePackagingSerializer :
  KSerializer<MedicationKnowledge.Packaging> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Packaging") {
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Packaging =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Packaging) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationKnowledge.Packaging {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
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
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Packaging: " + i)
      }
    }
    return MedicationKnowledge.Packaging(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      quantity = quantity,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MedicationKnowledge.Packaging) {
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
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.quantitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object MedicationKnowledgeDrugCharacteristicSerializer :
  KSerializer<MedicationKnowledge.DrugCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DrugCharacteristic") {
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
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueBase64Binary", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.DrugCharacteristic =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.DrugCharacteristic) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.DrugCharacteristic {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueQuantity: Quantity? = null
    var valueBase64Binary: KotlinString? = null
    var _valueBase64Binary: Element? = null
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
        5 -> valueString = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        8 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        9 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DrugCharacteristic: " + i)
      }
    }
    return MedicationKnowledge.DrugCharacteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      `value` =
        MedicationKnowledge.DrugCharacteristic.Value.from(
          valueCodeableConcept,
          R4String.of(valueString, _valueString),
          valueQuantity,
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
        ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.DrugCharacteristic,
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
    when (val choice = value.`value`) {
      null -> {}
      is MedicationKnowledge.DrugCharacteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, choice.value)
      }
      is MedicationKnowledge.DrugCharacteristic.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueStringSer, it)
        }
      }
      is MedicationKnowledge.DrugCharacteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueQuantitySer, choice.value)
      }
      is MedicationKnowledge.DrugCharacteristic.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueStringSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueStringSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object MedicationKnowledgeRegulatorySerializer :
  KSerializer<MedicationKnowledge.Regulatory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Regulatory") {
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
      element("regulatoryAuthority", Reference.serializer().descriptor, isOptional = true)
      element(
        "substitution",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.Regulatory.Substitution.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "schedule",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.Regulatory.Schedule.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "maxDispense",
        lazyDescriptor { MedicationKnowledge.Regulatory.MaxDispense.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationKnowledge.Regulatory {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var regulatoryAuthority: Reference? = null
    var substitution: List<MedicationKnowledge.Regulatory.Substitution>? = null
    var schedule: List<MedicationKnowledge.Regulatory.Schedule>? = null
    var maxDispense: MedicationKnowledge.Regulatory.MaxDispense? = null
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
          regulatoryAuthority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.regulatoryAuthoritySer,
              null,
            )
        4 ->
          substitution =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.substitutionSer, null)
        5 ->
          schedule =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scheduleSer, null)
        6 ->
          maxDispense =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.maxDispenseSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Regulatory: " + i)
      }
    }
    return MedicationKnowledge.Regulatory(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      regulatoryAuthority = regulatoryAuthority!!,
      substitution = substitution ?: listOf(),
      schedule = schedule ?: listOf(),
      maxDispense = maxDispense,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Regulatory,
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
    encoder.encodeSerializableElement(
      descriptor,
      3,
      Hoisted.regulatoryAuthoritySer,
      value.regulatoryAuthority,
    )
    if (value.substitution.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.substitutionSer, value.substitution)
    if (value.schedule.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.scheduleSer, value.schedule)
    (value.maxDispense)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.maxDispenseSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val regulatoryAuthoritySer: KSerializer<Reference> = Reference.serializer()

    public val substitutionSerInner: KSerializer<MedicationKnowledge.Regulatory.Substitution> =
      MedicationKnowledge.Regulatory.Substitution.serializer()

    public val substitutionSer: KSerializer<List<MedicationKnowledge.Regulatory.Substitution>> =
      ListSerializer(Hoisted.substitutionSerInner)

    public val scheduleSerInner: KSerializer<MedicationKnowledge.Regulatory.Schedule> =
      MedicationKnowledge.Regulatory.Schedule.serializer()

    public val scheduleSer: KSerializer<List<MedicationKnowledge.Regulatory.Schedule>> =
      ListSerializer(Hoisted.scheduleSerInner)

    public val maxDispenseSer: KSerializer<MedicationKnowledge.Regulatory.MaxDispense> =
      MedicationKnowledge.Regulatory.MaxDispense.serializer()
  }
}

internal object MedicationKnowledgeRegulatorySubstitutionSerializer :
  KSerializer<MedicationKnowledge.Regulatory.Substitution> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substitution") {
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
      element("allowed", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_allowed", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.Substitution =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Substitution) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.Regulatory.Substitution {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var allowed: KotlinBoolean? = null
    var _allowed: Element? = null
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
        4 -> allowed = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _allowed =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.allowedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + i)
      }
    }
    return MedicationKnowledge.Regulatory.Substitution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      allowed = R4Boolean.of(allowed, _allowed)!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Regulatory.Substitution,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    ((value.allowed.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.allowed.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.allowedSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val allowedSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MedicationKnowledgeRegulatoryScheduleSerializer :
  KSerializer<MedicationKnowledge.Regulatory.Schedule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Schedule") {
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
      element("schedule", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.Schedule =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Schedule) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.Regulatory.Schedule {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var schedule: CodeableConcept? = null
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
          schedule =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scheduleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Schedule: " + i)
      }
    }
    return MedicationKnowledge.Regulatory.Schedule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      schedule = schedule!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Regulatory.Schedule,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.scheduleSer, value.schedule)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val scheduleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object MedicationKnowledgeRegulatoryMaxDispenseSerializer :
  KSerializer<MedicationKnowledge.Regulatory.MaxDispense> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MaxDispense") {
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("period", Duration.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Regulatory.MaxDispense =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.MaxDispense) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicationKnowledge.Regulatory.MaxDispense {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Quantity? = null
    var period: Duration? = null
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
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        4 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MaxDispense: " + i)
      }
    }
    return MedicationKnowledge.Regulatory.MaxDispense(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      quantity = quantity!!,
      period = period,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Regulatory.MaxDispense,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.quantitySer, value.quantity)
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val periodSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object MedicationKnowledgeKineticsSerializer : KSerializer<MedicationKnowledge.Kinetics> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Kinetics") {
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
        "areaUnderCurve",
        listSerialDescriptor(Quantity.serializer().descriptor),
        isOptional = true,
      )
      element(
        "lethalDose50",
        listSerialDescriptor(Quantity.serializer().descriptor),
        isOptional = true,
      )
      element("halfLifePeriod", Duration.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Kinetics =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Kinetics) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicationKnowledge.Kinetics {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var areaUnderCurve: List<Quantity>? = null
    var lethalDose50: List<Quantity>? = null
    var halfLifePeriod: Duration? = null
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
          areaUnderCurve =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.areaUnderCurveSer,
              null,
            )
        4 ->
          lethalDose50 =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.areaUnderCurveSer,
              null,
            )
        5 ->
          halfLifePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.halfLifePeriodSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Kinetics: " + i)
      }
    }
    return MedicationKnowledge.Kinetics(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      areaUnderCurve = areaUnderCurve ?: listOf(),
      lethalDose50 = lethalDose50 ?: listOf(),
      halfLifePeriod = halfLifePeriod,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MedicationKnowledge.Kinetics) {
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
    if (value.areaUnderCurve.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        Hoisted.areaUnderCurveSer,
        value.areaUnderCurve,
      )
    if (value.lethalDose50.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        Hoisted.areaUnderCurveSer,
        value.lethalDose50,
      )
    (value.halfLifePeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.halfLifePeriodSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val areaUnderCurveSerInner: KSerializer<Quantity> = Quantity.serializer()

    public val areaUnderCurveSer: KSerializer<List<Quantity>> =
      ListSerializer(Hoisted.areaUnderCurveSerInner)

    public val halfLifePeriodSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object MedicationKnowledgeSerializer : KSerializer<MedicationKnowledge> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationKnowledge") {
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
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("manufacturer", Reference.serializer().descriptor, isOptional = true)
    b.element("doseForm", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("amount", Quantity.serializer().descriptor, isOptional = true)
    b.element(
      "synonym",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_synonym", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "relatedMedicationKnowledge",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.RelatedMedicationKnowledge.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "associatedMedication",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "productType",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "monograph",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.Monograph.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "ingredient",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.Ingredient.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("preparationInstruction", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_preparationInstruction", Element.serializer().descriptor, isOptional = true)
    b.element(
      "intendedRoute",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "cost",
      listSerialDescriptor(lazyDescriptor { MedicationKnowledge.Cost.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "monitoringProgram",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.MonitoringProgram.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "administrationGuidelines",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.AdministrationGuidelines.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "medicineClassification",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.MedicineClassification.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "packaging",
      lazyDescriptor { MedicationKnowledge.Packaging.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "drugCharacteristic",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.DrugCharacteristic.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "contraindication",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "regulatory",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.Regulatory.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "kinetics",
      listSerialDescriptor(lazyDescriptor { MedicationKnowledge.Kinetics.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicationKnowledge")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationKnowledge {
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
    var code: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var manufacturer: Reference? = null
    var doseForm: CodeableConcept? = null
    var amount: Quantity? = null
    var synonym: List<KotlinString?>? = null
    var _synonym: List<Element?>? = null
    var relatedMedicationKnowledge: List<MedicationKnowledge.RelatedMedicationKnowledge>? = null
    var associatedMedication: List<Reference>? = null
    var productType: List<CodeableConcept>? = null
    var monograph: List<MedicationKnowledge.Monograph>? = null
    var ingredient: List<MedicationKnowledge.Ingredient>? = null
    var preparationInstruction: KotlinString? = null
    var _preparationInstruction: Element? = null
    var intendedRoute: List<CodeableConcept>? = null
    var cost: List<MedicationKnowledge.Cost>? = null
    var monitoringProgram: List<MedicationKnowledge.MonitoringProgram>? = null
    var administrationGuidelines: List<MedicationKnowledge.AdministrationGuidelines>? = null
    var medicineClassification: List<MedicationKnowledge.MedicineClassification>? = null
    var packaging: MedicationKnowledge.Packaging? = null
    var drugCharacteristic: List<MedicationKnowledge.DrugCharacteristic>? = null
    var contraindication: List<Reference>? = null
    var regulatory: List<MedicationKnowledge.Regulatory>? = null
    var kinetics: List<MedicationKnowledge.Kinetics>? = null
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
        10 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.manufacturerSer, null)
        14 ->
          doseForm = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        15 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        16 ->
          synonym =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.synonymSer, null)
        17 ->
          _synonym =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.synonymSer2, null)
        18 ->
          relatedMedicationKnowledge =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedMedicationKnowledgeSer,
              null,
            )
        19 ->
          associatedMedication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.associatedMedicationSer,
              null,
            )
        20 ->
          productType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.productTypeSer, null)
        21 ->
          monograph =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.monographSer, null)
        22 ->
          ingredient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ingredientSer, null)
        23 -> preparationInstruction = decoder.decodeStringElement(descriptor, i)
        24 ->
          _preparationInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          intendedRoute =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.productTypeSer, null)
        26 -> cost = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.costSer, null)
        27 ->
          monitoringProgram =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.monitoringProgramSer,
              null,
            )
        28 ->
          administrationGuidelines =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.administrationGuidelinesSer,
              null,
            )
        29 ->
          medicineClassification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.medicineClassificationSer,
              null,
            )
        30 ->
          packaging =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.packagingSer, null)
        31 ->
          drugCharacteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.drugCharacteristicSer,
              null,
            )
        32 ->
          contraindication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.associatedMedicationSer,
              null,
            )
        33 ->
          regulatory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.regulatorySer, null)
        34 ->
          kinetics =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.kineticsSer, null)
        else -> throw SerializationException("Unexpected index decoding MedicationKnowledge: " + i)
      }
    }
    return MedicationKnowledge(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      status =
        status?.let {
          Enumeration.of(MedicationKnowledge.MedicationKnowledgeStatusCodes.fromCode(it), _status)
        },
      manufacturer = manufacturer,
      doseForm = doseForm,
      amount = amount,
      synonym =
        (kotlin.collections.List(maxOf(synonym?.size ?: 0, _synonym?.size ?: 0)) { index ->
          R4String.of(synonym?.getOrNull(index)?.let { it }, _synonym?.getOrNull(index))!!
        }),
      relatedMedicationKnowledge = relatedMedicationKnowledge ?: listOf(),
      associatedMedication = associatedMedication ?: listOf(),
      productType = productType ?: listOf(),
      monograph = monograph ?: listOf(),
      ingredient = ingredient ?: listOf(),
      preparationInstruction = Markdown.of(preparationInstruction, _preparationInstruction),
      intendedRoute = intendedRoute ?: listOf(),
      cost = cost ?: listOf(),
      monitoringProgram = monitoringProgram ?: listOf(),
      administrationGuidelines = administrationGuidelines ?: listOf(),
      medicineClassification = medicineClassification ?: listOf(),
      packaging = packaging,
      drugCharacteristic = drugCharacteristic ?: listOf(),
      contraindication = contraindication ?: listOf(),
      regulatory = regulatory ?: listOf(),
      kinetics = kinetics ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationKnowledge,
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
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 10 + descriptorOffset, Hoisted.codeSer, it)
    }
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.manufacturerSer,
        it,
      )
    }
    (value.doseForm)?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.codeSer, it)
    }
    (value.amount)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.amountSer, it)
    }
    (value.synonym.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.synonymSer, it)
    }
    (value.synonym.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.synonymSer2, it)
    }
    if (value.relatedMedicationKnowledge.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.relatedMedicationKnowledgeSer,
        value.relatedMedicationKnowledge,
      )
    if (value.associatedMedication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.associatedMedicationSer,
        value.associatedMedication,
      )
    if (value.productType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.productTypeSer,
        value.productType,
      )
    if (value.monograph.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.monographSer,
        value.monograph,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.ingredientSer,
        value.ingredient,
      )
    ((value.preparationInstruction?.value))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.preparationInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.intendedRoute.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.productTypeSer,
        value.intendedRoute,
      )
    if (value.cost.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.costSer,
        value.cost,
      )
    if (value.monitoringProgram.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.monitoringProgramSer,
        value.monitoringProgram,
      )
    if (value.administrationGuidelines.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.administrationGuidelinesSer,
        value.administrationGuidelines,
      )
    if (value.medicineClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.medicineClassificationSer,
        value.medicineClassification,
      )
    (value.packaging)?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, Hoisted.packagingSer, it)
    }
    if (value.drugCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.drugCharacteristicSer,
        value.drugCharacteristic,
      )
    if (value.contraindication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.associatedMedicationSer,
        value.contraindication,
      )
    if (value.regulatory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.regulatorySer,
        value.regulatory,
      )
    if (value.kinetics.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.kineticsSer,
        value.kinetics,
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

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val manufacturerSer: KSerializer<Reference> = Reference.serializer()

    public val amountSer: KSerializer<Quantity> = Quantity.serializer()

    public val synonymSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val synonymSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.synonymSerInner).nullable)

    public val synonymSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val relatedMedicationKnowledgeSerInner:
      KSerializer<MedicationKnowledge.RelatedMedicationKnowledge> =
      MedicationKnowledge.RelatedMedicationKnowledge.serializer()

    public val relatedMedicationKnowledgeSer:
      KSerializer<List<MedicationKnowledge.RelatedMedicationKnowledge>> =
      ListSerializer(Hoisted.relatedMedicationKnowledgeSerInner)

    public val associatedMedicationSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.manufacturerSer)

    public val productTypeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSer)

    public val monographSerInner: KSerializer<MedicationKnowledge.Monograph> =
      MedicationKnowledge.Monograph.serializer()

    public val monographSer: KSerializer<List<MedicationKnowledge.Monograph>> =
      ListSerializer(Hoisted.monographSerInner)

    public val ingredientSerInner: KSerializer<MedicationKnowledge.Ingredient> =
      MedicationKnowledge.Ingredient.serializer()

    public val ingredientSer: KSerializer<List<MedicationKnowledge.Ingredient>> =
      ListSerializer(Hoisted.ingredientSerInner)

    public val costSerInner: KSerializer<MedicationKnowledge.Cost> =
      MedicationKnowledge.Cost.serializer()

    public val costSer: KSerializer<List<MedicationKnowledge.Cost>> =
      ListSerializer(Hoisted.costSerInner)

    public val monitoringProgramSerInner: KSerializer<MedicationKnowledge.MonitoringProgram> =
      MedicationKnowledge.MonitoringProgram.serializer()

    public val monitoringProgramSer: KSerializer<List<MedicationKnowledge.MonitoringProgram>> =
      ListSerializer(Hoisted.monitoringProgramSerInner)

    public val administrationGuidelinesSerInner:
      KSerializer<MedicationKnowledge.AdministrationGuidelines> =
      MedicationKnowledge.AdministrationGuidelines.serializer()

    public val administrationGuidelinesSer:
      KSerializer<List<MedicationKnowledge.AdministrationGuidelines>> =
      ListSerializer(Hoisted.administrationGuidelinesSerInner)

    public val medicineClassificationSerInner:
      KSerializer<MedicationKnowledge.MedicineClassification> =
      MedicationKnowledge.MedicineClassification.serializer()

    public val medicineClassificationSer:
      KSerializer<List<MedicationKnowledge.MedicineClassification>> =
      ListSerializer(Hoisted.medicineClassificationSerInner)

    public val packagingSer: KSerializer<MedicationKnowledge.Packaging> =
      MedicationKnowledge.Packaging.serializer()

    public val drugCharacteristicSerInner: KSerializer<MedicationKnowledge.DrugCharacteristic> =
      MedicationKnowledge.DrugCharacteristic.serializer()

    public val drugCharacteristicSer: KSerializer<List<MedicationKnowledge.DrugCharacteristic>> =
      ListSerializer(Hoisted.drugCharacteristicSerInner)

    public val regulatorySerInner: KSerializer<MedicationKnowledge.Regulatory> =
      MedicationKnowledge.Regulatory.serializer()

    public val regulatorySer: KSerializer<List<MedicationKnowledge.Regulatory>> =
      ListSerializer(Hoisted.regulatorySerInner)

    public val kineticsSerInner: KSerializer<MedicationKnowledge.Kinetics> =
      MedicationKnowledge.Kinetics.serializer()

    public val kineticsSer: KSerializer<List<MedicationKnowledge.Kinetics>> =
      ListSerializer(Hoisted.kineticsSerInner)
  }
}

internal object MedicationKnowledgePolymorphicSerializer : KSerializer<MedicationKnowledge> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationKnowledge") {
      MedicationKnowledgeSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge) {
    encoder.encodeStructure(descriptor) {
      MedicationKnowledgeSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge =
    decoder.decodeStructure(descriptor) {
      MedicationKnowledgeSerializer.deserializeInternal(this, descriptor, 0)
    }
}
