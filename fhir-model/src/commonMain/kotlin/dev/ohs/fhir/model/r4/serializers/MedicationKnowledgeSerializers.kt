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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.RelatedMedicationKnowledge,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.RelatedMedicationKnowledge {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var reference: List<Reference>? = null
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
          reference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding RelatedMedicationKnowledge: " + __i
          )
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.RelatedMedicationKnowledge,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.reference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.referenceSer, value.reference)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Monograph) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.Monograph {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var source: Reference? = null
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
        4 -> source = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Monograph: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Monograph) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.source)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.sourceSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Ingredient) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.Ingredient {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var isActive: KotlinBoolean? = null
    var _isActive: Element? = null
    var strength: Ratio? = null
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
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        4 ->
          itemReference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemReferenceSer, null)
        5 -> isActive = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _isActive =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.isActiveSer, null)
        7 ->
          strength = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Ingredient) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.item) {
      null -> {}
      is MedicationKnowledge.Ingredient.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.itemCodeableConceptSer, __d.value)
      }
      is MedicationKnowledge.Ingredient.Item.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.itemReferenceSer, __d.value)
      }
    }
    ((value.isActive?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.isActive?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.isActiveSer, it)
    }
    (value.strength)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.strengthSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Cost) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.Cost {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var cost: Money? = null
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
        4 -> source = decoder.decodeStringElement(__desc, 4)
        5 -> _source = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.sourceSer, null)
        6 -> cost = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.costSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Cost: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Cost) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    ((value.source?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.sourceSer, it)
    }
    (value.cost)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.costSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MonitoringProgram) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.MonitoringProgram {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
        4 -> name = decoder.decodeStringElement(__desc, 4)
        5 -> _name = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonitoringProgram: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.MonitoringProgram,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.AdministrationGuidelines) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.AdministrationGuidelines {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> dosage = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.dosageSer, null)
        4 ->
          indicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.indicationCodeableConceptSer,
              null,
            )
        5 ->
          indicationReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.indicationReferenceSer,
              null,
            )
        6 ->
          patientCharacteristics =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.patientCharacteristicsSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding AdministrationGuidelines: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.AdministrationGuidelines,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.dosageSer, value.dosage)
    when (val __d = value.indication) {
      null -> {}
      is MedicationKnowledge.AdministrationGuidelines.Indication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          4,
          Hoisted.indicationCodeableConceptSer,
          __d.value,
        )
      }
      is MedicationKnowledge.AdministrationGuidelines.Indication.Reference -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.indicationReferenceSer, __d.value)
      }
    }
    if (value.patientCharacteristics.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.Dosage,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.AdministrationGuidelines.Dosage {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var dosage: List<Dosage>? = null
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
        4 -> dosage = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.dosageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.Dosage,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.dosageSer, value.dosage)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var characteristicCodeableConcept: CodeableConcept? = null
    var characteristicQuantity: Quantity? = null
    var `value`: List<KotlinString?>? = null
    var _value: List<Element?>? = null
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
          characteristicCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.characteristicCodeableConceptSer,
              null,
            )
        4 ->
          characteristicQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.characteristicQuantitySer,
              null,
            )
        5 -> `value` = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueSer, null)
        6 -> _value = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding PatientCharacteristics: " + __i)
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
        (kotlin.collections.List(maxOf(`value`?.size ?: 0, _value?.size ?: 0)) { __i ->
          R4String.of(`value`?.getOrNull(__i)?.let { it }, _value?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.characteristic) {
      null -> {}
      is MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          3,
          Hoisted.characteristicCodeableConceptSer,
          __d.value,
        )
      }
      is MedicationKnowledge.AdministrationGuidelines.PatientCharacteristics.Characteristic.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.characteristicQuantitySer, __d.value)
      }
    }
    (value.`value`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.valueSer, it)
    }
    (value.`value`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.valueSer2, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.MedicineClassification) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.MedicineClassification {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var classification: List<CodeableConcept>? = null
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
          classification =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.classificationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding MedicineClassification: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.MedicineClassification,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.classificationSer, value.classification)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Packaging) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.Packaging {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
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
          quantity = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.quantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Packaging: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Packaging) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.quantitySer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.DrugCharacteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.DrugCharacteristic {
    val __desc = descriptor
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
        5 -> valueString = decoder.decodeStringElement(__desc, 5)
        6 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueStringSer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueQuantitySer, null)
        8 -> valueBase64Binary = decoder.decodeStringElement(__desc, 8)
        9 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueStringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DrugCharacteristic: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.DrugCharacteristic,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is MedicationKnowledge.DrugCharacteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is MedicationKnowledge.DrugCharacteristic.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueStringSer, it)
        }
      }
      is MedicationKnowledge.DrugCharacteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueQuantitySer, __d.value)
      }
      is MedicationKnowledge.DrugCharacteristic.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueStringSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.Regulatory {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var regulatoryAuthority: Reference? = null
    var substitution: List<MedicationKnowledge.Regulatory.Substitution>? = null
    var schedule: List<MedicationKnowledge.Regulatory.Schedule>? = null
    var maxDispense: MedicationKnowledge.Regulatory.MaxDispense? = null
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
          regulatoryAuthority =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.regulatoryAuthoritySer,
              null,
            )
        4 ->
          substitution =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.substitutionSer, null)
        5 ->
          schedule = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.scheduleSer, null)
        6 ->
          maxDispense =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.maxDispenseSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Regulatory: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Regulatory) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.regulatoryAuthority)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.regulatoryAuthoritySer, it)
    }
    if (value.substitution.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.substitutionSer, value.substitution)
    if (value.schedule.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.scheduleSer, value.schedule)
    (value.maxDispense)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.maxDispenseSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Substitution) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.Regulatory.Substitution {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var allowed: KotlinBoolean? = null
    var _allowed: Element? = null
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
        4 -> allowed = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _allowed = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.allowedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Regulatory.Substitution,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    ((value.allowed.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.allowed.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.allowedSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.Schedule) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.Regulatory.Schedule {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var schedule: CodeableConcept? = null
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
          schedule = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.scheduleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Schedule: " + __i)
      }
    }
    return MedicationKnowledge.Regulatory.Schedule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      schedule = schedule!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Regulatory.Schedule,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.schedule)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.scheduleSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Regulatory.MaxDispense) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.Regulatory.MaxDispense {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Quantity? = null
    var period: Duration? = null
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
          quantity = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.quantitySer, null)
        4 -> period = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MaxDispense: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Regulatory.MaxDispense,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.quantitySer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.periodSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Kinetics) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.Kinetics {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var areaUnderCurve: List<Quantity>? = null
    var lethalDose50: List<Quantity>? = null
    var halfLifePeriod: Duration? = null
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
          areaUnderCurve =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.areaUnderCurveSer, null)
        4 ->
          lethalDose50 =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.areaUnderCurveSer, null)
        5 ->
          halfLifePeriod =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.halfLifePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Kinetics: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Kinetics) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.areaUnderCurve.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.areaUnderCurveSer, value.areaUnderCurve)
    if (value.lethalDose50.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.areaUnderCurveSer, value.lethalDose50)
    (value.halfLifePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.halfLifePeriodSer, it)
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("manufacturer", Reference.serializer().descriptor, isOptional = true)
      element("doseForm", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Quantity.serializer().descriptor, isOptional = true)
      element(
        "synonym",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_synonym", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "relatedMedicationKnowledge",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.RelatedMedicationKnowledge.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "associatedMedication",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "productType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "monograph",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.Monograph.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "ingredient",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.Ingredient.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("preparationInstruction", KotlinString.serializer().descriptor, isOptional = true)
      element("_preparationInstruction", Element.serializer().descriptor, isOptional = true)
      element(
        "intendedRoute",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "cost",
        listSerialDescriptor(lazyDescriptor { MedicationKnowledge.Cost.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "monitoringProgram",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.MonitoringProgram.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "administrationGuidelines",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.AdministrationGuidelines.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "medicineClassification",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.MedicineClassification.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "packaging",
        lazyDescriptor { MedicationKnowledge.Packaging.serializer().descriptor },
        isOptional = true,
      )
      element(
        "drugCharacteristic",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.DrugCharacteristic.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "contraindication",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "regulatory",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.Regulatory.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "kinetics",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.Kinetics.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge {
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
        11 -> code = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.codeSer, null)
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.manufacturerSer, null)
        15 ->
          doseForm = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.codeSer, null)
        16 ->
          amount = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.amountSer, null)
        17 ->
          synonym = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.synonymSer, null)
        18 ->
          _synonym =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.synonymSer2, null)
        19 ->
          relatedMedicationKnowledge =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.relatedMedicationKnowledgeSer,
              null,
            )
        20 ->
          associatedMedication =
            decoder.decodeNullableSerializableElement(
              __desc,
              20,
              Hoisted.associatedMedicationSer,
              null,
            )
        21 ->
          productType =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.productTypeSer, null)
        22 ->
          monograph =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.monographSer, null)
        23 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.ingredientSer, null)
        24 -> preparationInstruction = decoder.decodeStringElement(__desc, 24)
        25 ->
          _preparationInstruction =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          intendedRoute =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.productTypeSer, null)
        27 -> cost = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.costSer, null)
        28 ->
          monitoringProgram =
            decoder.decodeNullableSerializableElement(
              __desc,
              28,
              Hoisted.monitoringProgramSer,
              null,
            )
        29 ->
          administrationGuidelines =
            decoder.decodeNullableSerializableElement(
              __desc,
              29,
              Hoisted.administrationGuidelinesSer,
              null,
            )
        30 ->
          medicineClassification =
            decoder.decodeNullableSerializableElement(
              __desc,
              30,
              Hoisted.medicineClassificationSer,
              null,
            )
        31 ->
          packaging =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.packagingSer, null)
        32 ->
          drugCharacteristic =
            decoder.decodeNullableSerializableElement(
              __desc,
              32,
              Hoisted.drugCharacteristicSer,
              null,
            )
        33 ->
          contraindication =
            decoder.decodeNullableSerializableElement(
              __desc,
              33,
              Hoisted.associatedMedicationSer,
              null,
            )
        34 ->
          regulatory =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.regulatorySer, null)
        35 ->
          kinetics =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.kineticsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding MedicationKnowledge: " + __i)
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
        (kotlin.collections.List(maxOf(synonym?.size ?: 0, _synonym?.size ?: 0)) { __i ->
          R4String.of(synonym?.getOrNull(__i)?.let { it }, _synonym?.getOrNull(__i))!!
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MedicationKnowledge")
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
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.codeSer, it) }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.manufacturerSer, it)
    }
    (value.doseForm)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.codeSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.amountSer, it) }
    (value.synonym.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.synonymSer, it)
    }
    (value.synonym.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.synonymSer2, it)
    }
    if (value.relatedMedicationKnowledge.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19,
        Hoisted.relatedMedicationKnowledgeSer,
        value.relatedMedicationKnowledge,
      )
    if (value.associatedMedication.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20,
        Hoisted.associatedMedicationSer,
        value.associatedMedication,
      )
    if (value.productType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.productTypeSer, value.productType)
    if (value.monograph.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.monographSer, value.monograph)
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.ingredientSer, value.ingredient)
    ((value.preparationInstruction?.value))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.preparationInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    if (value.intendedRoute.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.productTypeSer, value.intendedRoute)
    if (value.cost.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.costSer, value.cost)
    if (value.monitoringProgram.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        28,
        Hoisted.monitoringProgramSer,
        value.monitoringProgram,
      )
    if (value.administrationGuidelines.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29,
        Hoisted.administrationGuidelinesSer,
        value.administrationGuidelines,
      )
    if (value.medicineClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30,
        Hoisted.medicineClassificationSer,
        value.medicineClassification,
      )
    (value.packaging)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.packagingSer, it)
    }
    if (value.drugCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        32,
        Hoisted.drugCharacteristicSer,
        value.drugCharacteristic,
      )
    if (value.contraindication.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        33,
        Hoisted.associatedMedicationSer,
        value.contraindication,
      )
    if (value.regulatory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.regulatorySer, value.regulatory)
    if (value.kinetics.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.kineticsSer, value.kinetics)
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
