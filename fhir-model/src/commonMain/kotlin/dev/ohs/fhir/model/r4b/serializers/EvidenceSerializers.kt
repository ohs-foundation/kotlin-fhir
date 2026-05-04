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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Evidence
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Int
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

internal object EvidenceVariableDefinitionSerializer : KSerializer<Evidence.VariableDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("VariableDefinition") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("variableRole", CodeableConcept.serializer().descriptor, isOptional = true)
      element("observed", Reference.serializer().descriptor, isOptional = true)
      element("intended", Reference.serializer().descriptor, isOptional = true)
      element("directnessMatch", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Evidence.VariableDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Evidence.VariableDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Evidence.VariableDefinition {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var variableRole: CodeableConcept? = null
    var observed: Reference? = null
    var intended: Reference? = null
    var directnessMatch: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.noteSer, null)
        6 ->
          variableRole =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.variableRoleSer, null)
        7 ->
          observed = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.observedSer, null)
        8 ->
          intended = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.observedSer, null)
        9 ->
          directnessMatch =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.variableRoleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding VariableDefinition: " + __i)
      }
    }
    return Evidence.VariableDefinition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      variableRole = variableRole!!,
      observed = observed,
      intended = intended,
      directnessMatch = directnessMatch,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Evidence.VariableDefinition) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.noteSer, value.note)
    (value.variableRole)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.variableRoleSer, it)
    }
    (value.observed)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.observedSer, it) }
    (value.intended)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.observedSer, it) }
    (value.directnessMatch)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.variableRoleSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val variableRoleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val observedSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object EvidenceStatisticSerializer : KSerializer<Evidence.Statistic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Statistic") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("statisticType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("numberOfEvents", Int.serializer().descriptor, isOptional = true)
      element("_numberOfEvents", Element.serializer().descriptor, isOptional = true)
      element("numberAffected", Int.serializer().descriptor, isOptional = true)
      element("_numberAffected", Element.serializer().descriptor, isOptional = true)
      element(
        "sampleSize",
        lazyDescriptor { Evidence.Statistic.SampleSize.serializer().descriptor },
        isOptional = true,
      )
      element(
        "attributeEstimate",
        listSerialDescriptor(
          lazyDescriptor { Evidence.Statistic.AttributeEstimate.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "modelCharacteristic",
        listSerialDescriptor(
          lazyDescriptor { Evidence.Statistic.ModelCharacteristic.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Evidence.Statistic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Evidence.Statistic {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var statisticType: CodeableConcept? = null
    var category: CodeableConcept? = null
    var quantity: Quantity? = null
    var numberOfEvents: Int? = null
    var _numberOfEvents: Element? = null
    var numberAffected: Int? = null
    var _numberAffected: Element? = null
    var sampleSize: Evidence.Statistic.SampleSize? = null
    var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null
    var modelCharacteristic: List<Evidence.Statistic.ModelCharacteristic>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.noteSer, null)
        6 ->
          statisticType =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.statisticTypeSer, null)
        7 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.statisticTypeSer, null)
        8 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.quantitySer, null)
        9 -> numberOfEvents = decoder.decodeIntElement(__desc, 9)
        10 ->
          _numberOfEvents =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.descriptionSer, null)
        11 -> numberAffected = decoder.decodeIntElement(__desc, 11)
        12 ->
          _numberAffected =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.descriptionSer, null)
        13 ->
          sampleSize =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.sampleSizeSer, null)
        14 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.attributeEstimateSer,
              null,
            )
        15 ->
          modelCharacteristic =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.modelCharacteristicSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Statistic: " + __i)
      }
    }
    return Evidence.Statistic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4bString.of(description, _description),
      note = note ?: listOf(),
      statisticType = statisticType,
      category = category,
      quantity = quantity,
      numberOfEvents = UnsignedInt.of(numberOfEvents, _numberOfEvents),
      numberAffected = UnsignedInt.of(numberAffected, _numberAffected),
      sampleSize = sampleSize,
      attributeEstimate = attributeEstimate ?: listOf(),
      modelCharacteristic = modelCharacteristic ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Evidence.Statistic) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.noteSer, value.note)
    (value.statisticType)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.statisticTypeSer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.statisticTypeSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.quantitySer, it) }
    ((value.numberOfEvents?.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
    (value.numberOfEvents?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.descriptionSer, it)
    }
    ((value.numberAffected?.value))?.let { encoder.encodeIntElement(__desc, 11, it) }
    (value.numberAffected?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.descriptionSer, it)
    }
    (value.sampleSize)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.sampleSizeSer, it)
    }
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        14,
        Hoisted.attributeEstimateSer,
        value.attributeEstimate,
      )
    if (value.modelCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15,
        Hoisted.modelCharacteristicSer,
        value.modelCharacteristic,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val statisticTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val sampleSizeSer: KSerializer<Evidence.Statistic.SampleSize> =
      Evidence.Statistic.SampleSize.serializer()

    public val attributeEstimateSerInner: KSerializer<Evidence.Statistic.AttributeEstimate> =
      Evidence.Statistic.AttributeEstimate.serializer()

    public val attributeEstimateSer: KSerializer<List<Evidence.Statistic.AttributeEstimate>> =
      ListSerializer(Hoisted.attributeEstimateSerInner)

    public val modelCharacteristicSerInner: KSerializer<Evidence.Statistic.ModelCharacteristic> =
      Evidence.Statistic.ModelCharacteristic.serializer()

    public val modelCharacteristicSer: KSerializer<List<Evidence.Statistic.ModelCharacteristic>> =
      ListSerializer(Hoisted.modelCharacteristicSerInner)
  }
}

internal object EvidenceStatisticSampleSizeSerializer : KSerializer<Evidence.Statistic.SampleSize> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SampleSize") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("numberOfStudies", Int.serializer().descriptor, isOptional = true)
      element("_numberOfStudies", Element.serializer().descriptor, isOptional = true)
      element("numberOfParticipants", Int.serializer().descriptor, isOptional = true)
      element("_numberOfParticipants", Element.serializer().descriptor, isOptional = true)
      element("knownDataCount", Int.serializer().descriptor, isOptional = true)
      element("_knownDataCount", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Evidence.Statistic.SampleSize =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.SampleSize) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Evidence.Statistic.SampleSize {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var numberOfStudies: Int? = null
    var _numberOfStudies: Element? = null
    var numberOfParticipants: Int? = null
    var _numberOfParticipants: Element? = null
    var knownDataCount: Int? = null
    var _knownDataCount: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.noteSer, null)
        6 -> numberOfStudies = decoder.decodeIntElement(__desc, 6)
        7 ->
          _numberOfStudies =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.descriptionSer, null)
        8 -> numberOfParticipants = decoder.decodeIntElement(__desc, 8)
        9 ->
          _numberOfParticipants =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.descriptionSer, null)
        10 -> knownDataCount = decoder.decodeIntElement(__desc, 10)
        11 ->
          _knownDataCount =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampleSize: " + __i)
      }
    }
    return Evidence.Statistic.SampleSize(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4bString.of(description, _description),
      note = note ?: listOf(),
      numberOfStudies = UnsignedInt.of(numberOfStudies, _numberOfStudies),
      numberOfParticipants = UnsignedInt.of(numberOfParticipants, _numberOfParticipants),
      knownDataCount = UnsignedInt.of(knownDataCount, _knownDataCount),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Evidence.Statistic.SampleSize) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.noteSer, value.note)
    ((value.numberOfStudies?.value))?.let { encoder.encodeIntElement(__desc, 6, it) }
    (value.numberOfStudies?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.descriptionSer, it)
    }
    ((value.numberOfParticipants?.value))?.let { encoder.encodeIntElement(__desc, 8, it) }
    (value.numberOfParticipants?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.descriptionSer, it)
    }
    ((value.knownDataCount?.value))?.let { encoder.encodeIntElement(__desc, 10, it) }
    (value.knownDataCount?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object EvidenceStatisticAttributeEstimateSerializer :
  KSerializer<Evidence.Statistic.AttributeEstimate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AttributeEstimate") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("level", BigDecimalSerializer.descriptor, isOptional = true)
      element("_level", Element.serializer().descriptor, isOptional = true)
      element("range", Range.serializer().descriptor, isOptional = true)
      element(
        "attributeEstimate",
        listSerialDescriptor(
          lazyDescriptor { Evidence.Statistic.AttributeEstimate.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Evidence.Statistic.AttributeEstimate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.AttributeEstimate) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Evidence.Statistic.AttributeEstimate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
    var level: BigDecimal? = null
    var _level: Element? = null
    var range: Range? = null
    var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.noteSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.quantitySer, null)
        8 ->
          level = decoder.decodeNullableSerializableElement(__desc, 8, BigDecimalSerializer, null)
        9 ->
          _level =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.descriptionSer, null)
        10 -> range = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.rangeSer, null)
        11 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.attributeEstimateSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AttributeEstimate: " + __i)
      }
    }
    return Evidence.Statistic.AttributeEstimate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4bString.of(description, _description),
      note = note ?: listOf(),
      type = type,
      quantity = quantity,
      level = Decimal.of(level, _level),
      range = range,
      attributeEstimate = attributeEstimate ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Evidence.Statistic.AttributeEstimate,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.noteSer, value.note)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.quantitySer, it) }
    ((value.level?.value))?.let {
      encoder.encodeSerializableElement(__desc, 8, BigDecimalSerializer, it)
    }
    (value.level?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.descriptionSer, it)
    }
    (value.range)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.rangeSer, it) }
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        11,
        Hoisted.attributeEstimateSer,
        value.attributeEstimate,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val rangeSer: KSerializer<Range> = Range.serializer()

    public val attributeEstimateSerInner: KSerializer<Evidence.Statistic.AttributeEstimate> =
      Evidence.Statistic.AttributeEstimate.serializer()

    public val attributeEstimateSer: KSerializer<List<Evidence.Statistic.AttributeEstimate>> =
      ListSerializer(Hoisted.attributeEstimateSerInner)
  }
}

internal object EvidenceStatisticModelCharacteristicSerializer :
  KSerializer<Evidence.Statistic.ModelCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ModelCharacteristic") {
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
      element("value", Quantity.serializer().descriptor, isOptional = true)
      element(
        "variable",
        listSerialDescriptor(
          lazyDescriptor { Evidence.Statistic.ModelCharacteristic.Variable.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "attributeEstimate",
        listSerialDescriptor(
          lazyDescriptor { Evidence.Statistic.AttributeEstimate.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Evidence.Statistic.ModelCharacteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.ModelCharacteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Evidence.Statistic.ModelCharacteristic {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var `value`: Quantity? = null
    var variable: List<Evidence.Statistic.ModelCharacteristic.Variable>? = null
    var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null
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
        4 -> `value` = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueSer, null)
        5 ->
          variable = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.variableSer, null)
        6 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.attributeEstimateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ModelCharacteristic: " + __i)
      }
    }
    return Evidence.Statistic.ModelCharacteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      `value` = `value`,
      variable = variable ?: listOf(),
      attributeEstimate = attributeEstimate ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Evidence.Statistic.ModelCharacteristic,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.`value`)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.valueSer, it) }
    if (value.variable.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.variableSer, value.variable)
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        6,
        Hoisted.attributeEstimateSer,
        value.attributeEstimate,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSer: KSerializer<Quantity> = Quantity.serializer()

    public val variableSerInner: KSerializer<Evidence.Statistic.ModelCharacteristic.Variable> =
      Evidence.Statistic.ModelCharacteristic.Variable.serializer()

    public val variableSer: KSerializer<List<Evidence.Statistic.ModelCharacteristic.Variable>> =
      ListSerializer(Hoisted.variableSerInner)

    public val attributeEstimateSerInner: KSerializer<Evidence.Statistic.AttributeEstimate> =
      Evidence.Statistic.AttributeEstimate.serializer()

    public val attributeEstimateSer: KSerializer<List<Evidence.Statistic.AttributeEstimate>> =
      ListSerializer(Hoisted.attributeEstimateSerInner)
  }
}

internal object EvidenceStatisticModelCharacteristicVariableSerializer :
  KSerializer<Evidence.Statistic.ModelCharacteristic.Variable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Variable") {
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
      element("variableDefinition", Reference.serializer().descriptor, isOptional = true)
      element("handling", KotlinString.serializer().descriptor, isOptional = true)
      element("_handling", Element.serializer().descriptor, isOptional = true)
      element(
        "valueCategory",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "valueQuantity",
        listSerialDescriptor(Quantity.serializer().descriptor),
        isOptional = true,
      )
      element("valueRange", listSerialDescriptor(Range.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Evidence.Statistic.ModelCharacteristic.Variable =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: Evidence.Statistic.ModelCharacteristic.Variable,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): Evidence.Statistic.ModelCharacteristic.Variable {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var variableDefinition: Reference? = null
    var handling: KotlinString? = null
    var _handling: Element? = null
    var valueCategory: List<CodeableConcept>? = null
    var valueQuantity: List<Quantity>? = null
    var valueRange: List<Range>? = null
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
          variableDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.variableDefinitionSer,
              null,
            )
        4 -> handling = decoder.decodeStringElement(__desc, 4)
        5 ->
          _handling =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.handlingSer, null)
        6 ->
          valueCategory =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueCategorySer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueQuantitySer, null)
        8 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variable: " + __i)
      }
    }
    return Evidence.Statistic.ModelCharacteristic.Variable(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      variableDefinition = variableDefinition!!,
      handling =
        handling?.let { Enumeration.of(Evidence.EvidenceVariableHandling.fromCode(it), _handling) },
      valueCategory = valueCategory ?: listOf(),
      valueQuantity = valueQuantity ?: listOf(),
      valueRange = valueRange ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Evidence.Statistic.ModelCharacteristic.Variable,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.variableDefinition)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.variableDefinitionSer, it)
    }
    ((value.handling?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.handling?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.handlingSer, it)
    }
    if (value.valueCategory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.valueCategorySer, value.valueCategory)
    if (value.valueQuantity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.valueQuantitySer, value.valueQuantity)
    if (value.valueRange.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.valueRangeSer, value.valueRange)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val variableDefinitionSer: KSerializer<Reference> = Reference.serializer()

    public val handlingSer: KSerializer<Element> = Element.serializer()

    public val valueCategorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueCategorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.valueCategorySerInner)

    public val valueQuantitySerInner: KSerializer<Quantity> = Quantity.serializer()

    public val valueQuantitySer: KSerializer<List<Quantity>> =
      ListSerializer(Hoisted.valueQuantitySerInner)

    public val valueRangeSerInner: KSerializer<Range> = Range.serializer()

    public val valueRangeSer: KSerializer<List<Range>> = ListSerializer(Hoisted.valueRangeSerInner)
  }
}

internal object EvidenceCertaintySerializer : KSerializer<Evidence.Certainty> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Certainty") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("rating", CodeableConcept.serializer().descriptor, isOptional = true)
      element("rater", KotlinString.serializer().descriptor, isOptional = true)
      element("_rater", Element.serializer().descriptor, isOptional = true)
      element(
        "subcomponent",
        listSerialDescriptor(lazyDescriptor { Evidence.Certainty.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Evidence.Certainty =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Evidence.Certainty) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Evidence.Certainty {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var type: CodeableConcept? = null
    var rating: CodeableConcept? = null
    var rater: KotlinString? = null
    var _rater: Element? = null
    var subcomponent: List<Evidence.Certainty>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.noteSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 -> rating = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeSer, null)
        8 -> rater = decoder.decodeStringElement(__desc, 8)
        9 ->
          _rater =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.descriptionSer, null)
        10 ->
          subcomponent =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.subcomponentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Certainty: " + __i)
      }
    }
    return Evidence.Certainty(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4bString.of(description, _description),
      note = note ?: listOf(),
      type = type,
      rating = rating,
      rater = R4bString.of(rater, _rater),
      subcomponent = subcomponent ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Evidence.Certainty) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.noteSer, value.note)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    (value.rating)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it) }
    ((value.rater?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.rater?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.descriptionSer, it)
    }
    if (value.subcomponent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.subcomponentSer, value.subcomponent)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subcomponentSerInner: KSerializer<Evidence.Certainty> =
      Evidence.Certainty.serializer()

    public val subcomponentSer: KSerializer<List<Evidence.Certainty>> =
      ListSerializer(Hoisted.subcomponentSerInner)
  }
}

internal object EvidenceSerializer : KSerializer<Evidence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Evidence") {
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("citeAsReference", Reference.serializer().descriptor, isOptional = true)
      element("citeAsMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_citeAsMarkdown", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_approvalDate", Element.serializer().descriptor, isOptional = true)
      element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "author",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "editor",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewer",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "endorser",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("assertion", KotlinString.serializer().descriptor, isOptional = true)
      element("_assertion", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "variableDefinition",
        listSerialDescriptor(
          lazyDescriptor { Evidence.VariableDefinition.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("synthesisType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("studyType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "statistic",
        listSerialDescriptor(lazyDescriptor { Evidence.Statistic.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "certainty",
        listSerialDescriptor(lazyDescriptor { Evidence.Certainty.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Evidence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Evidence) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Evidence {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var citeAsReference: Reference? = null
    var citeAsMarkdown: KotlinString? = null
    var _citeAsMarkdown: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var useContext: List<UsageContext>? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var assertion: KotlinString? = null
    var _assertion: Element? = null
    var note: List<Annotation>? = null
    var variableDefinition: List<Evidence.VariableDefinition>? = null
    var synthesisType: CodeableConcept? = null
    var studyType: CodeableConcept? = null
    var statistic: List<Evidence.Statistic>? = null
    var certainty: List<Evidence.Certainty>? = null
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> title = decoder.decodeStringElement(__desc, 16)
        17 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          citeAsReference =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.citeAsReferenceSer, null)
        19 -> citeAsMarkdown = decoder.decodeStringElement(__desc, 19)
        20 ->
          _citeAsMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> status = decoder.decodeStringElement(__desc, 21)
        22 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> date = decoder.decodeStringElement(__desc, 23)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.useContextSer, null)
        26 -> approvalDate = decoder.decodeStringElement(__desc, 26)
        27 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> lastReviewDate = decoder.decodeStringElement(__desc, 28)
        29 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> publisher = decoder.decodeStringElement(__desc, 30)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.contactSer, null)
        33 ->
          author = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.contactSer, null)
        34 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.contactSer, null)
        35 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.contactSer, null)
        36 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.contactSer, null)
        37 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.relatedArtifactSer, null)
        38 -> description = decoder.decodeStringElement(__desc, 38)
        39 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> assertion = decoder.decodeStringElement(__desc, 40)
        41 ->
          _assertion =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 -> note = decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.noteSer, null)
        43 ->
          variableDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              43,
              Hoisted.variableDefinitionSer,
              null,
            )
        44 ->
          synthesisType =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.synthesisTypeSer, null)
        45 ->
          studyType =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.synthesisTypeSer, null)
        46 ->
          statistic =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.statisticSer, null)
        47 ->
          certainty =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.certaintySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Evidence: " + __i)
      }
    }
    return Evidence(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      title = R4bString.of(title, _title),
      citeAs = Evidence.CiteAs.from(citeAsReference, Markdown.of(citeAsMarkdown, _citeAsMarkdown)),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      useContext = useContext ?: listOf(),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      description = Markdown.of(description, _description),
      assertion = Markdown.of(assertion, _assertion),
      note = note ?: listOf(),
      variableDefinition = variableDefinition ?: listOf(),
      synthesisType = synthesisType,
      studyType = studyType,
      statistic = statistic ?: listOf(),
      certainty = certainty ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Evidence) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Evidence")
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.citeAs) {
      null -> {}
      is Evidence.CiteAs.Reference -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.citeAsReferenceSer, __d.value)
      }
      is Evidence.CiteAs.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.useContextSer, value.useContext)
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.contactSer, value.contact)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        37,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.assertion?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.assertion?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.noteSer, value.note)
    if (value.variableDefinition.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        43,
        Hoisted.variableDefinitionSer,
        value.variableDefinition,
      )
    (value.synthesisType)?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.synthesisTypeSer, it)
    }
    (value.studyType)?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.synthesisTypeSer, it)
    }
    if (value.statistic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.statisticSer, value.statistic)
    if (value.certainty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.certaintySer, value.certainty)
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

    public val citeAsReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val variableDefinitionSerInner: KSerializer<Evidence.VariableDefinition> =
      Evidence.VariableDefinition.serializer()

    public val variableDefinitionSer: KSerializer<List<Evidence.VariableDefinition>> =
      ListSerializer(Hoisted.variableDefinitionSerInner)

    public val synthesisTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val statisticSerInner: KSerializer<Evidence.Statistic> = Evidence.Statistic.serializer()

    public val statisticSer: KSerializer<List<Evidence.Statistic>> =
      ListSerializer(Hoisted.statisticSerInner)

    public val certaintySerInner: KSerializer<Evidence.Certainty> = Evidence.Certainty.serializer()

    public val certaintySer: KSerializer<List<Evidence.Certainty>> =
      ListSerializer(Hoisted.certaintySerInner)
  }
}
