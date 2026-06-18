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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Evidence
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Evidence.VariableDefinition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Evidence.VariableDefinition {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        6 ->
          variableRole =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.variableRoleSer, null)
        7 ->
          observed =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.observedSer, null)
        8 ->
          intended =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.observedSer, null)
        9 ->
          directnessMatch =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.variableRoleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding VariableDefinition: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Evidence.VariableDefinition) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteSer, value.note)
    encoder.encodeSerializableElement(descriptor, 6, Hoisted.variableRoleSer, value.variableRole)
    (value.observed)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.observedSer, it)
    }
    (value.intended)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.observedSer, it)
    }
    (value.directnessMatch)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.variableRoleSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Evidence.Statistic {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        6 ->
          statisticType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statisticTypeSer, null)
        7 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statisticTypeSer, null)
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        9 -> numberOfEvents = decoder.decodeIntElement(descriptor, i)
        10 ->
          _numberOfEvents =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        11 -> numberAffected = decoder.decodeIntElement(descriptor, i)
        12 ->
          _numberAffected =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        13 ->
          sampleSize =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sampleSizeSer, null)
        14 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.attributeEstimateSer,
              null,
            )
        15 ->
          modelCharacteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.modelCharacteristicSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Statistic: " + i)
      }
    }
    return Evidence.Statistic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Evidence.Statistic) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteSer, value.note)
    (value.statisticType)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.statisticTypeSer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.statisticTypeSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.quantitySer, it)
    }
    ((value.numberOfEvents?.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
    (value.numberOfEvents?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.descriptionSer, it)
    }
    ((value.numberAffected?.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
    (value.numberAffected?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.descriptionSer, it)
    }
    (value.sampleSize)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.sampleSizeSer, it)
    }
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        Hoisted.attributeEstimateSer,
        value.attributeEstimate,
      )
    if (value.modelCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.SampleSize) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Evidence.Statistic.SampleSize {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        6 -> numberOfStudies = decoder.decodeIntElement(descriptor, i)
        7 ->
          _numberOfStudies =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        8 -> numberOfParticipants = decoder.decodeIntElement(descriptor, i)
        9 ->
          _numberOfParticipants =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        10 -> knownDataCount = decoder.decodeIntElement(descriptor, i)
        11 ->
          _knownDataCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampleSize: " + i)
      }
    }
    return Evidence.Statistic.SampleSize(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      numberOfStudies = UnsignedInt.of(numberOfStudies, _numberOfStudies),
      numberOfParticipants = UnsignedInt.of(numberOfParticipants, _numberOfParticipants),
      knownDataCount = UnsignedInt.of(knownDataCount, _knownDataCount),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Evidence.Statistic.SampleSize) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteSer, value.note)
    ((value.numberOfStudies?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.numberOfStudies?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.descriptionSer, it)
    }
    ((value.numberOfParticipants?.value))?.let { encoder.encodeIntElement(descriptor, 8, it) }
    (value.numberOfParticipants?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.descriptionSer, it)
    }
    ((value.knownDataCount?.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
    (value.knownDataCount?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.descriptionSer, it)
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
      element("level", FhirDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.AttributeEstimate) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Evidence.Statistic.AttributeEstimate {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
    var level: FhirDecimal? = null
    var _level: Element? = null
    var range: Range? = null
    var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        8 ->
          level =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        9 ->
          _level =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        10 ->
          range = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rangeSer, null)
        11 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.attributeEstimateSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AttributeEstimate: " + i)
      }
    }
    return Evidence.Statistic.AttributeEstimate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      type = type,
      quantity = quantity,
      level = Decimal.of(level, _level),
      range = range,
      attributeEstimate = attributeEstimate ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Evidence.Statistic.AttributeEstimate,
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteSer, value.note)
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.quantitySer, it)
    }
    ((value.level?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 8, FhirDecimalSerializer, it)
    }
    (value.level?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.descriptionSer, it)
    }
    (value.range)?.let { encoder.encodeSerializableElement(descriptor, 10, Hoisted.rangeSer, it) }
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.ModelCharacteristic) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Evidence.Statistic.ModelCharacteristic {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var `value`: Quantity? = null
    var variable: List<Evidence.Statistic.ModelCharacteristic.Variable>? = null
    var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null
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
          `value` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        5 ->
          variable =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.variableSer, null)
        6 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.attributeEstimateSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ModelCharacteristic: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Evidence.Statistic.ModelCharacteristic,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    (value.`value`)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueSer, it) }
    if (value.variable.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.variableSer, value.variable)
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Evidence.Statistic.ModelCharacteristic.Variable,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Evidence.Statistic.ModelCharacteristic.Variable {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          variableDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.variableDefinitionSer,
              null,
            )
        4 -> handling = decoder.decodeStringElement(descriptor, i)
        5 ->
          _handling =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.handlingSer, null)
        6 ->
          valueCategory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCategorySer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        8 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variable: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Evidence.Statistic.ModelCharacteristic.Variable,
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
      Hoisted.variableDefinitionSer,
      value.variableDefinition,
    )
    ((value.handling?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.handling?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.handlingSer, it)
    }
    if (value.valueCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        Hoisted.valueCategorySer,
        value.valueCategory,
      )
    if (value.valueQuantity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        Hoisted.valueQuantitySer,
        value.valueQuantity,
      )
    if (value.valueRange.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueRangeSer, value.valueRange)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Evidence.Certainty) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Evidence.Certainty {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          rating = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 -> rater = decoder.decodeStringElement(descriptor, i)
        9 ->
          _rater =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        10 ->
          subcomponent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subcomponentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Certainty: " + i)
      }
    }
    return Evidence.Certainty(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      type = type,
      rating = rating,
      rater = R5String.of(rater, _rater),
      subcomponent = subcomponent ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Evidence.Certainty) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.noteSer, value.note)
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    (value.rating)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, it) }
    ((value.rater?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.rater?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.descriptionSer, it)
    }
    if (value.subcomponent.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.subcomponentSer, value.subcomponent)
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("citeAsReference", Reference.serializer().descriptor, isOptional = true)
    b.element("citeAsMarkdown", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_citeAsMarkdown", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("assertion", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_assertion", Element.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "variableDefinition",
      listSerialDescriptor(lazyDescriptor { Evidence.VariableDefinition.serializer().descriptor }),
      isOptional = true,
    )
    b.element("synthesisType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "studyDesign",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "statistic",
      listSerialDescriptor(lazyDescriptor { Evidence.Statistic.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "certainty",
      listSerialDescriptor(lazyDescriptor { Evidence.Certainty.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Evidence =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Evidence) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Evidence")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Evidence {
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var citeAsReference: Reference? = null
    var citeAsMarkdown: KotlinString? = null
    var _citeAsMarkdown: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
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
    var useContext: List<UsageContext>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var assertion: KotlinString? = null
    var _assertion: Element? = null
    var note: List<Annotation>? = null
    var variableDefinition: List<Evidence.VariableDefinition>? = null
    var synthesisType: CodeableConcept? = null
    var studyDesign: List<CodeableConcept>? = null
    var statistic: List<Evidence.Statistic>? = null
    var certainty: List<Evidence.Certainty>? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          citeAsReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.citeAsReferenceSer,
              null,
            )
        23 -> citeAsMarkdown = decoder.decodeStringElement(descriptor, i)
        24 ->
          _citeAsMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> status = decoder.decodeStringElement(descriptor, i)
        26 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        28 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> date = decoder.decodeStringElement(descriptor, i)
        30 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        32 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        34 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> publisher = decoder.decodeStringElement(descriptor, i)
        36 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        38 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        39 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        40 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        41 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        42 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        43 -> purpose = decoder.decodeStringElement(descriptor, i)
        44 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 -> copyright = decoder.decodeStringElement(descriptor, i)
        46 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        47 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        48 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        49 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        50 -> description = decoder.decodeStringElement(descriptor, i)
        51 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        52 -> assertion = decoder.decodeStringElement(descriptor, i)
        53 ->
          _assertion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        54 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        55 ->
          variableDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.variableDefinitionSer,
              null,
            )
        56 ->
          synthesisType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.synthesisTypeSer, null)
        57 ->
          studyDesign =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.studyDesignSer, null)
        58 ->
          statistic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statisticSer, null)
        59 ->
          certainty =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.certaintySer, null)
        else -> throw SerializationException("Unexpected index decoding Evidence: " + i)
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        Evidence.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      citeAs = Evidence.CiteAs.from(citeAsReference, Markdown.of(citeAsMarkdown, _citeAsMarkdown)),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      useContext = useContext ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      relatedArtifact = relatedArtifact ?: listOf(),
      description = Markdown.of(description, _description),
      assertion = Markdown.of(assertion, _assertion),
      note = note ?: listOf(),
      variableDefinition = variableDefinition ?: listOf(),
      synthesisType = synthesisType,
      studyDesign = studyDesign ?: listOf(),
      statistic = statistic ?: listOf(),
      certainty = certainty ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Evidence,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is Evidence.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Evidence.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.citeAs) {
      null -> {}
      is Evidence.CiteAs.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          Hoisted.citeAsReferenceSer,
          choice.value,
        )
      }
      is Evidence.CiteAs.Markdown -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            24 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 45 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 47 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 50 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.assertion?.value))?.let {
      encoder.encodeStringElement(descriptor, 52 + descriptorOffset, it)
    }
    (value.assertion?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.variableDefinition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.variableDefinitionSer,
        value.variableDefinition,
      )
    (value.synthesisType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        Hoisted.synthesisTypeSer,
        it,
      )
    }
    if (value.studyDesign.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.studyDesignSer,
        value.studyDesign,
      )
    if (value.statistic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        Hoisted.statisticSer,
        value.statistic,
      )
    if (value.certainty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        Hoisted.certaintySer,
        value.certainty,
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val citeAsReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

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

    public val studyDesignSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.synthesisTypeSer)

    public val statisticSerInner: KSerializer<Evidence.Statistic> = Evidence.Statistic.serializer()

    public val statisticSer: KSerializer<List<Evidence.Statistic>> =
      ListSerializer(Hoisted.statisticSerInner)

    public val certaintySerInner: KSerializer<Evidence.Certainty> = Evidence.Certainty.serializer()

    public val certaintySer: KSerializer<List<Evidence.Certainty>> =
      ListSerializer(Hoisted.certaintySerInner)
  }
}

internal object EvidencePolymorphicSerializer : KSerializer<Evidence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Evidence") { EvidenceSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Evidence) {
    encoder.encodeStructure(descriptor) {
      EvidenceSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Evidence =
    decoder.decodeStructure(descriptor) {
      EvidenceSerializer.deserializeInternal(this, descriptor, 0)
    }
}
