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
import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Dosage
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MedicationKnowledge
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          source = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
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
      element(
        "effectiveDate",
        listSerialDescriptor(Period.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("source", KotlinString.serializer().descriptor, isOptional = true)
      element("_source", Element.serializer().descriptor, isOptional = true)
      element("costMoney", Money.serializer().descriptor, isOptional = true)
      element("costCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
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
    var effectiveDate: List<Period>? = null
    var type: CodeableConcept? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var costMoney: Money? = null
    var costCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          effectiveDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectiveDateSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 -> source = decoder.decodeStringElement(__desc, __i)
        6 ->
          _source = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        7 ->
          costMoney =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.costMoneySer, null)
        8 ->
          costCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Cost: " + __i)
      }
    }
    return MedicationKnowledge.Cost(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      effectiveDate = effectiveDate ?: listOf(),
      type = type!!,
      source = R5String.of(source, _source),
      cost = MedicationKnowledge.Cost.Cost.from(costMoney, costCodeableConcept)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Cost) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.effectiveDate.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.effectiveDateSer, value.effectiveDate)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    ((value.source?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.sourceSer, it)
    }
    when (val __d = value.cost) {
      null -> {}
      is MedicationKnowledge.Cost.Cost.Money -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.costMoneySer, __d.value)
      }
      is MedicationKnowledge.Cost.Cost.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val effectiveDateSerInner: KSerializer<Period> = Period.serializer()

    public val effectiveDateSer: KSerializer<List<Period>> =
      ListSerializer(Hoisted.effectiveDateSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sourceSer: KSerializer<Element> = Element.serializer()

    public val costMoneySer: KSerializer<Money> = Money.serializer()
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> name = decoder.decodeStringElement(__desc, __i)
        5 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonitoringProgram: " + __i)
      }
    }
    return MedicationKnowledge.MonitoringProgram(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      name = R5String.of(name, _name),
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

internal object MedicationKnowledgeIndicationGuidelineSerializer :
  KSerializer<MedicationKnowledge.IndicationGuideline> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("IndicationGuideline") {
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
        "indication",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "dosingGuideline",
        listSerialDescriptor(
          lazyDescriptor {
            MedicationKnowledge.IndicationGuideline.DosingGuideline.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.IndicationGuideline =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.IndicationGuideline) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.IndicationGuideline {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var indication: List<CodeableReference>? = null
    var dosingGuideline: List<MedicationKnowledge.IndicationGuideline.DosingGuideline>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          indication =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.indicationSer, null)
        4 ->
          dosingGuideline =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dosingGuidelineSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding IndicationGuideline: " + __i)
      }
    }
    return MedicationKnowledge.IndicationGuideline(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      indication = indication ?: listOf(),
      dosingGuideline = dosingGuideline ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.IndicationGuideline,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.indication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.indicationSer, value.indication)
    if (value.dosingGuideline.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        4,
        Hoisted.dosingGuidelineSer,
        value.dosingGuideline,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val indicationSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val indicationSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.indicationSerInner)

    public val dosingGuidelineSerInner:
      KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline> =
      MedicationKnowledge.IndicationGuideline.DosingGuideline.serializer()

    public val dosingGuidelineSer:
      KSerializer<List<MedicationKnowledge.IndicationGuideline.DosingGuideline>> =
      ListSerializer(Hoisted.dosingGuidelineSerInner)
  }
}

internal object MedicationKnowledgeIndicationGuidelineDosingGuidelineSerializer :
  KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DosingGuideline") {
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
      element("treatmentIntent", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "dosage",
        listSerialDescriptor(
          lazyDescriptor {
            MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element("administrationTreatment", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "patientCharacteristic",
        listSerialDescriptor(
          lazyDescriptor {
            MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic
              .serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var treatmentIntent: CodeableConcept? = null
    var dosage: List<MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage>? = null
    var administrationTreatment: CodeableConcept? = null
    var patientCharacteristic:
      List<MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic>? =
      null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          treatmentIntent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.treatmentIntentSer, null)
        4 ->
          dosage = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dosageSer, null)
        5 ->
          administrationTreatment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.treatmentIntentSer, null)
        6 ->
          patientCharacteristic =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.patientCharacteristicSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DosingGuideline: " + __i)
      }
    }
    return MedicationKnowledge.IndicationGuideline.DosingGuideline(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      treatmentIntent = treatmentIntent,
      dosage = dosage ?: listOf(),
      administrationTreatment = administrationTreatment,
      patientCharacteristic = patientCharacteristic ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.treatmentIntent)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.treatmentIntentSer, it)
    }
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.dosageSer, value.dosage)
    (value.administrationTreatment)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.treatmentIntentSer, it)
    }
    if (value.patientCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        6,
        Hoisted.patientCharacteristicSer,
        value.patientCharacteristic,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val treatmentIntentSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val dosageSerInner:
      KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage> =
      MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage.serializer()

    public val dosageSer:
      KSerializer<List<MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage>> =
      ListSerializer(Hoisted.dosageSerInner)

    public val patientCharacteristicSerInner:
      KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic> =
      MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.serializer()

    public val patientCharacteristicSer:
      KSerializer<
        List<MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic>
      > =
      ListSerializer(Hoisted.patientCharacteristicSerInner)
  }
}

internal object MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageSerializer :
  KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage> {
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

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var dosage: List<Dosage>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          dosage = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dosageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage: " + __i)
      }
    }
    return MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      dosage = dosage ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline.Dosage,
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

internal object MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicSerializer :
  KSerializer<MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PatientCharacteristic") {
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
      element("valueRange", Range.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        6 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding PatientCharacteristic: " + __i)
      }
    }
    return MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.from(
          valueCodeableConcept,
          valueQuantity,
          valueRange,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic,
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
      is MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueQuantitySer, __d.value)
      }
      is MedicationKnowledge.IndicationGuideline.DosingGuideline.PatientCharacteristic.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.valueRangeSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()
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
      element("sourceString", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceString", Element.serializer().descriptor, isOptional = true)
      element("sourceUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceUri", Element.serializer().descriptor, isOptional = true)
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
    var sourceString: KotlinString? = null
    var _sourceString: Element? = null
    var sourceUri: KotlinString? = null
    var _sourceUri: Element? = null
    var classification: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> sourceString = decoder.decodeStringElement(__desc, __i)
        5 ->
          _sourceString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceStringSer, null)
        6 -> sourceUri = decoder.decodeStringElement(__desc, __i)
        7 ->
          _sourceUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceStringSer, null)
        8 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.classificationSer, null)
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
      source =
        MedicationKnowledge.MedicineClassification.Source.from(
          R5String.of(sourceString, _sourceString),
          Uri.of(sourceUri, _sourceUri),
        ),
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
    when (val __d = value.source) {
      null -> {}
      is MedicationKnowledge.MedicineClassification.Source.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.sourceStringSer, it)
        }
      }
      is MedicationKnowledge.MedicineClassification.Source.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.sourceStringSer, it)
        }
      }
    }
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.classificationSer, value.classification)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sourceStringSer: KSerializer<Element> = Element.serializer()

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
      element(
        "cost",
        listSerialDescriptor(lazyDescriptor { MedicationKnowledge.Cost.serializer().descriptor }),
        isOptional = true,
      )
      element("packagedProduct", Reference.serializer().descriptor, isOptional = true)
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
    var cost: List<MedicationKnowledge.Cost>? = null
    var packagedProduct: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> cost = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.costSer, null)
        4 ->
          packagedProduct =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.packagedProductSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Packaging: " + __i)
      }
    }
    return MedicationKnowledge.Packaging(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      cost = cost ?: listOf(),
      packagedProduct = packagedProduct,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Packaging) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.cost.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.costSer, value.cost)
    (value.packagedProduct)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.packagedProductSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val costSerInner: KSerializer<MedicationKnowledge.Cost> =
      MedicationKnowledge.Cost.serializer()

    public val costSer: KSerializer<List<MedicationKnowledge.Cost>> =
      ListSerializer(Hoisted.costSerInner)

    public val packagedProductSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MedicationKnowledgeStorageGuidelineSerializer :
  KSerializer<MedicationKnowledge.StorageGuideline> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StorageGuideline") {
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
      element("reference", KotlinString.serializer().descriptor, isOptional = true)
      element("_reference", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("stabilityDuration", Duration.serializer().descriptor, isOptional = true)
      element(
        "environmentalSetting",
        listSerialDescriptor(
          lazyDescriptor {
            MedicationKnowledge.StorageGuideline.EnvironmentalSetting.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.StorageGuideline =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.StorageGuideline) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.StorageGuideline {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: KotlinString? = null
    var _reference: Element? = null
    var note: List<Annotation>? = null
    var stabilityDuration: Duration? = null
    var environmentalSetting: List<MedicationKnowledge.StorageGuideline.EnvironmentalSetting>? =
      null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> reference = decoder.decodeStringElement(__desc, __i)
        4 ->
          _reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        6 ->
          stabilityDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.stabilityDurationSer,
              null,
            )
        7 ->
          environmentalSetting =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.environmentalSettingSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StorageGuideline: " + __i)
      }
    }
    return MedicationKnowledge.StorageGuideline(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = Uri.of(reference, _reference),
      note = note ?: listOf(),
      stabilityDuration = stabilityDuration,
      environmentalSetting = environmentalSetting ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.StorageGuideline,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.reference?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.reference?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.referenceSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.noteSer, value.note)
    (value.stabilityDuration)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.stabilityDurationSer, it)
    }
    if (value.environmentalSetting.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.environmentalSettingSer,
        value.environmentalSetting,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val stabilityDurationSer: KSerializer<Duration> = Duration.serializer()

    public val environmentalSettingSerInner:
      KSerializer<MedicationKnowledge.StorageGuideline.EnvironmentalSetting> =
      MedicationKnowledge.StorageGuideline.EnvironmentalSetting.serializer()

    public val environmentalSettingSer:
      KSerializer<List<MedicationKnowledge.StorageGuideline.EnvironmentalSetting>> =
      ListSerializer(Hoisted.environmentalSettingSerInner)
  }
}

internal object MedicationKnowledgeStorageGuidelineEnvironmentalSettingSerializer :
  KSerializer<MedicationKnowledge.StorageGuideline.EnvironmentalSetting> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EnvironmentalSetting") {
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
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicationKnowledge.StorageGuideline.EnvironmentalSetting =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.StorageGuideline.EnvironmentalSetting,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.StorageGuideline.EnvironmentalSetting {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        5 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        6 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding EnvironmentalSetting: " + __i)
      }
    }
    return MedicationKnowledge.StorageGuideline.EnvironmentalSetting(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.from(
          valueQuantity,
          valueRange,
          valueCodeableConcept,
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.StorageGuideline.EnvironmentalSetting,
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
      is MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.valueQuantitySer, __d.value)
      }
      is MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueRangeSer, __d.value)
      }
      is MedicationKnowledge.StorageGuideline.EnvironmentalSetting.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()
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
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
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
    var schedule: List<CodeableConcept>? = null
    var maxDispense: MedicationKnowledge.Regulatory.MaxDispense? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          regulatoryAuthority =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.regulatoryAuthoritySer,
              null,
            )
        4 ->
          substitution =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.substitutionSer, null)
        5 ->
          schedule =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.scheduleSer, null)
        6 ->
          maxDispense =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.maxDispenseSer, null)
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

    public val scheduleSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val scheduleSer: KSerializer<List<CodeableConcept>> =
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> allowed = decoder.decodeBooleanElement(__desc, __i)
        5 ->
          _allowed =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.allowedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substitution: " + __i)
      }
    }
    return MedicationKnowledge.Regulatory.Substitution(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      allowed = R5Boolean.of(allowed, _allowed)!!,
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        4 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
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

internal object MedicationKnowledgeDefinitionalSerializer :
  KSerializer<MedicationKnowledge.Definitional> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Definitional") {
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
        "definition",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("doseForm", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "intendedRoute",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "ingredient",
        listSerialDescriptor(
          lazyDescriptor { MedicationKnowledge.Definitional.Ingredient.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "drugCharacteristic",
        listSerialDescriptor(
          lazyDescriptor {
            MedicationKnowledge.Definitional.DrugCharacteristic.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Definitional =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Definitional) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicationKnowledge.Definitional {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var definition: List<Reference>? = null
    var doseForm: CodeableConcept? = null
    var intendedRoute: List<CodeableConcept>? = null
    var ingredient: List<MedicationKnowledge.Definitional.Ingredient>? = null
    var drugCharacteristic: List<MedicationKnowledge.Definitional.DrugCharacteristic>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          definition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionSer, null)
        4 ->
          doseForm =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.doseFormSer, null)
        5 ->
          intendedRoute =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.intendedRouteSer, null)
        6 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ingredientSer, null)
        7 ->
          drugCharacteristic =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.drugCharacteristicSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Definitional: " + __i)
      }
    }
    return MedicationKnowledge.Definitional(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      definition = definition ?: listOf(),
      doseForm = doseForm,
      intendedRoute = intendedRoute ?: listOf(),
      ingredient = ingredient ?: listOf(),
      drugCharacteristic = drugCharacteristic ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicationKnowledge.Definitional) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.definition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.definitionSer, value.definition)
    (value.doseForm)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.doseFormSer, it) }
    if (value.intendedRoute.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.intendedRouteSer, value.intendedRoute)
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.ingredientSer, value.ingredient)
    if (value.drugCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.drugCharacteristicSer,
        value.drugCharacteristic,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val definitionSerInner: KSerializer<Reference> = Reference.serializer()

    public val definitionSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.definitionSerInner)

    public val doseFormSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val intendedRouteSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.doseFormSer)

    public val ingredientSerInner: KSerializer<MedicationKnowledge.Definitional.Ingredient> =
      MedicationKnowledge.Definitional.Ingredient.serializer()

    public val ingredientSer: KSerializer<List<MedicationKnowledge.Definitional.Ingredient>> =
      ListSerializer(Hoisted.ingredientSerInner)

    public val drugCharacteristicSerInner:
      KSerializer<MedicationKnowledge.Definitional.DrugCharacteristic> =
      MedicationKnowledge.Definitional.DrugCharacteristic.serializer()

    public val drugCharacteristicSer:
      KSerializer<List<MedicationKnowledge.Definitional.DrugCharacteristic>> =
      ListSerializer(Hoisted.drugCharacteristicSerInner)
  }
}

internal object MedicationKnowledgeDefinitionalIngredientSerializer :
  KSerializer<MedicationKnowledge.Definitional.Ingredient> {
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
      element("item", CodeableReference.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("strengthRatio", Ratio.serializer().descriptor, isOptional = true)
      element("strengthCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("strengthQuantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Definitional.Ingredient =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge.Definitional.Ingredient) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.Definitional.Ingredient {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var type: CodeableConcept? = null
    var strengthRatio: Ratio? = null
    var strengthCodeableConcept: CodeableConcept? = null
    var strengthQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> item = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.itemSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 ->
          strengthRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.strengthRatioSer, null)
        6 ->
          strengthCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        7 ->
          strengthQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.strengthQuantitySer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + __i)
      }
    }
    return MedicationKnowledge.Definitional.Ingredient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = item!!,
      type = type,
      strength =
        MedicationKnowledge.Definitional.Ingredient.Strength.from(
          strengthRatio,
          strengthCodeableConcept,
          strengthQuantity,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Definitional.Ingredient,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.item)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.itemSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    when (val __d = value.strength) {
      null -> {}
      is MedicationKnowledge.Definitional.Ingredient.Strength.Ratio -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.strengthRatioSer, __d.value)
      }
      is MedicationKnowledge.Definitional.Ingredient.Strength.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, __d.value)
      }
      is MedicationKnowledge.Definitional.Ingredient.Strength.Quantity -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.strengthQuantitySer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val strengthRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val strengthQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object MedicationKnowledgeDefinitionalDrugCharacteristicSerializer :
  KSerializer<MedicationKnowledge.Definitional.DrugCharacteristic> {
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
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicationKnowledge.Definitional.DrugCharacteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicationKnowledge.Definitional.DrugCharacteristic,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicationKnowledge.Definitional.DrugCharacteristic {
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
    var valueAttachment: Attachment? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 -> valueString = decoder.decodeStringElement(__desc, __i)
        6 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueStringSer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        8 -> valueBase64Binary = decoder.decodeStringElement(__desc, __i)
        9 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueStringSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DrugCharacteristic: " + __i)
      }
    }
    return MedicationKnowledge.Definitional.DrugCharacteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      `value` =
        MedicationKnowledge.Definitional.DrugCharacteristic.Value.from(
          valueCodeableConcept,
          R5String.of(valueString, _valueString),
          valueQuantity,
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          valueAttachment,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicationKnowledge.Definitional.DrugCharacteristic,
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
      is MedicationKnowledge.Definitional.DrugCharacteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is MedicationKnowledge.Definitional.DrugCharacteristic.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueStringSer, it)
        }
      }
      is MedicationKnowledge.Definitional.DrugCharacteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueQuantitySer, __d.value)
      }
      is MedicationKnowledge.Definitional.DrugCharacteristic.Value.Base64Binary -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueStringSer, it)
        }
      }
      is MedicationKnowledge.Definitional.DrugCharacteristic.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, __d.value)
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

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("author", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "intendedJurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("name", listSerialDescriptor(KotlinString.serializer().descriptor), isOptional = true)
    b.element("_name", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
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
    b.element("preparationInstruction", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_preparationInstruction", Element.serializer().descriptor, isOptional = true)
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
      "indicationGuideline",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.IndicationGuideline.serializer().descriptor }
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
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.Packaging.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "clinicalUseIssue",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "storageGuideline",
      listSerialDescriptor(
        lazyDescriptor { MedicationKnowledge.StorageGuideline.serializer().descriptor }
      ),
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
      "definitional",
      lazyDescriptor { MedicationKnowledge.Definitional.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicationKnowledge")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): MedicationKnowledge {
    val __desc = desc
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
    var code: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var author: Reference? = null
    var intendedJurisdiction: List<CodeableConcept>? = null
    var name: List<KotlinString?>? = null
    var _name: List<Element?>? = null
    var relatedMedicationKnowledge: List<MedicationKnowledge.RelatedMedicationKnowledge>? = null
    var associatedMedication: List<Reference>? = null
    var productType: List<CodeableConcept>? = null
    var monograph: List<MedicationKnowledge.Monograph>? = null
    var preparationInstruction: KotlinString? = null
    var _preparationInstruction: Element? = null
    var cost: List<MedicationKnowledge.Cost>? = null
    var monitoringProgram: List<MedicationKnowledge.MonitoringProgram>? = null
    var indicationGuideline: List<MedicationKnowledge.IndicationGuideline>? = null
    var medicineClassification: List<MedicationKnowledge.MedicineClassification>? = null
    var packaging: List<MedicationKnowledge.Packaging>? = null
    var clinicalUseIssue: List<Reference>? = null
    var storageGuideline: List<MedicationKnowledge.StorageGuideline>? = null
    var regulatory: List<MedicationKnowledge.Regulatory>? = null
    var definitional: MedicationKnowledge.Definitional? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        12 -> status = decoder.decodeStringElement(__desc, __i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          author = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.authorSer, null)
        15 ->
          intendedJurisdiction =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.intendedJurisdictionSer,
              null,
            )
        16 -> name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        17 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer2, null)
        18 ->
          relatedMedicationKnowledge =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.relatedMedicationKnowledgeSer,
              null,
            )
        19 ->
          associatedMedication =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.associatedMedicationSer,
              null,
            )
        20 ->
          productType =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.intendedJurisdictionSer,
              null,
            )
        21 ->
          monograph =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.monographSer, null)
        22 -> preparationInstruction = decoder.decodeStringElement(__desc, __i)
        23 ->
          _preparationInstruction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 -> cost = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.costSer, null)
        25 ->
          monitoringProgram =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.monitoringProgramSer,
              null,
            )
        26 ->
          indicationGuideline =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.indicationGuidelineSer,
              null,
            )
        27 ->
          medicineClassification =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.medicineClassificationSer,
              null,
            )
        28 ->
          packaging =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.packagingSer, null)
        29 ->
          clinicalUseIssue =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.associatedMedicationSer,
              null,
            )
        30 ->
          storageGuideline =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.storageGuidelineSer,
              null,
            )
        31 ->
          regulatory =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.regulatorySer, null)
        32 ->
          definitional =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.definitionalSer, null)
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
      identifier = identifier ?: listOf(),
      code = code,
      status =
        status?.let {
          Enumeration.of(MedicationKnowledge.MedicationKnowledgeStatusCodes.fromCode(it), _status)
        },
      author = author,
      intendedJurisdiction = intendedJurisdiction ?: listOf(),
      name =
        (kotlin.collections.List(maxOf(name?.size ?: 0, _name?.size ?: 0)) { __i ->
          R5String.of(name?.getOrNull(__i)?.let { it }, _name?.getOrNull(__i))!!
        }),
      relatedMedicationKnowledge = relatedMedicationKnowledge ?: listOf(),
      associatedMedication = associatedMedication ?: listOf(),
      productType = productType ?: listOf(),
      monograph = monograph ?: listOf(),
      preparationInstruction = Markdown.of(preparationInstruction, _preparationInstruction),
      cost = cost ?: listOf(),
      monitoringProgram = monitoringProgram ?: listOf(),
      indicationGuideline = indicationGuideline ?: listOf(),
      medicineClassification = medicineClassification ?: listOf(),
      packaging = packaging ?: listOf(),
      clinicalUseIssue = clinicalUseIssue ?: listOf(),
      storageGuideline = storageGuideline ?: listOf(),
      regulatory = regulatory ?: listOf(),
      definitional = definitional,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: MedicationKnowledge,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.codeSer, it) }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.authorSer, it)
    }
    if (value.intendedJurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15 + __off,
        Hoisted.intendedJurisdictionSer,
        value.intendedJurisdiction,
      )
    (value.name.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.nameSer, it)
    }
    (value.name.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.nameSer2, it)
    }
    if (value.relatedMedicationKnowledge.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        18 + __off,
        Hoisted.relatedMedicationKnowledgeSer,
        value.relatedMedicationKnowledge,
      )
    if (value.associatedMedication.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19 + __off,
        Hoisted.associatedMedicationSer,
        value.associatedMedication,
      )
    if (value.productType.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20 + __off,
        Hoisted.intendedJurisdictionSer,
        value.productType,
      )
    if (value.monograph.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.monographSer, value.monograph)
    ((value.preparationInstruction?.value))?.let {
      encoder.encodeStringElement(__desc, 22 + __off, it)
    }
    (value.preparationInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.cost.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.costSer, value.cost)
    if (value.monitoringProgram.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        25 + __off,
        Hoisted.monitoringProgramSer,
        value.monitoringProgram,
      )
    if (value.indicationGuideline.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26 + __off,
        Hoisted.indicationGuidelineSer,
        value.indicationGuideline,
      )
    if (value.medicineClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        27 + __off,
        Hoisted.medicineClassificationSer,
        value.medicineClassification,
      )
    if (value.packaging.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.packagingSer, value.packaging)
    if (value.clinicalUseIssue.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
        Hoisted.associatedMedicationSer,
        value.clinicalUseIssue,
      )
    if (value.storageGuideline.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30 + __off,
        Hoisted.storageGuidelineSer,
        value.storageGuideline,
      )
    if (value.regulatory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.regulatorySer, value.regulatory)
    (value.definitional)?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.definitionalSer, it)
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

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val authorSer: KSerializer<Reference> = Reference.serializer()

    public val intendedJurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.codeSer)

    public val nameSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val nameSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.nameSerInner).nullable)

    public val nameSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val relatedMedicationKnowledgeSerInner:
      KSerializer<MedicationKnowledge.RelatedMedicationKnowledge> =
      MedicationKnowledge.RelatedMedicationKnowledge.serializer()

    public val relatedMedicationKnowledgeSer:
      KSerializer<List<MedicationKnowledge.RelatedMedicationKnowledge>> =
      ListSerializer(Hoisted.relatedMedicationKnowledgeSerInner)

    public val associatedMedicationSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.authorSer)

    public val monographSerInner: KSerializer<MedicationKnowledge.Monograph> =
      MedicationKnowledge.Monograph.serializer()

    public val monographSer: KSerializer<List<MedicationKnowledge.Monograph>> =
      ListSerializer(Hoisted.monographSerInner)

    public val costSerInner: KSerializer<MedicationKnowledge.Cost> =
      MedicationKnowledge.Cost.serializer()

    public val costSer: KSerializer<List<MedicationKnowledge.Cost>> =
      ListSerializer(Hoisted.costSerInner)

    public val monitoringProgramSerInner: KSerializer<MedicationKnowledge.MonitoringProgram> =
      MedicationKnowledge.MonitoringProgram.serializer()

    public val monitoringProgramSer: KSerializer<List<MedicationKnowledge.MonitoringProgram>> =
      ListSerializer(Hoisted.monitoringProgramSerInner)

    public val indicationGuidelineSerInner: KSerializer<MedicationKnowledge.IndicationGuideline> =
      MedicationKnowledge.IndicationGuideline.serializer()

    public val indicationGuidelineSer: KSerializer<List<MedicationKnowledge.IndicationGuideline>> =
      ListSerializer(Hoisted.indicationGuidelineSerInner)

    public val medicineClassificationSerInner:
      KSerializer<MedicationKnowledge.MedicineClassification> =
      MedicationKnowledge.MedicineClassification.serializer()

    public val medicineClassificationSer:
      KSerializer<List<MedicationKnowledge.MedicineClassification>> =
      ListSerializer(Hoisted.medicineClassificationSerInner)

    public val packagingSerInner: KSerializer<MedicationKnowledge.Packaging> =
      MedicationKnowledge.Packaging.serializer()

    public val packagingSer: KSerializer<List<MedicationKnowledge.Packaging>> =
      ListSerializer(Hoisted.packagingSerInner)

    public val storageGuidelineSerInner: KSerializer<MedicationKnowledge.StorageGuideline> =
      MedicationKnowledge.StorageGuideline.serializer()

    public val storageGuidelineSer: KSerializer<List<MedicationKnowledge.StorageGuideline>> =
      ListSerializer(Hoisted.storageGuidelineSerInner)

    public val regulatorySerInner: KSerializer<MedicationKnowledge.Regulatory> =
      MedicationKnowledge.Regulatory.serializer()

    public val regulatorySer: KSerializer<List<MedicationKnowledge.Regulatory>> =
      ListSerializer(Hoisted.regulatorySerInner)

    public val definitionalSer: KSerializer<MedicationKnowledge.Definitional> =
      MedicationKnowledge.Definitional.serializer()
  }
}

internal object MedicationKnowledgePolymorphicSerializer : KSerializer<MedicationKnowledge> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicationKnowledge") {
      MedicationKnowledgeSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicationKnowledge) {
    encoder.encodeStructure(descriptor) {
      MedicationKnowledgeSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicationKnowledge =
    decoder.decodeStructure(descriptor) {
      MedicationKnowledgeSerializer.deserializeJson(this, descriptor, 0)
    }
}
