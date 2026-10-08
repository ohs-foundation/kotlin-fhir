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

package dev.ohs.fhir.model.r4b.serializers

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
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.EvidenceVariableHandling
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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

internal object EvidenceVariableDefinitionSerializer : KSerializer<Evidence.VariableDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("VariableDefinition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("variableRole", CodeableConceptSerializer.descriptor)
      optionalElement("observed", ReferenceSerializer.descriptor)
      optionalElement("intended", ReferenceSerializer.descriptor)
      optionalElement("directnessMatch", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Evidence.VariableDefinition>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Evidence.VariableDefinition {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          variableRole =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          observed =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 ->
          intended =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 ->
          directnessMatch =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding VariableDefinition: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Evidence.VariableDefinition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      variableRole =
        variableRole
          ?: throw SerializationException(
            "Missing required property 'variableRole' on Evidence.VariableDefinition"
          ),
      observed = observed,
      intended = intended,
      directnessMatch = directnessMatch,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Evidence.VariableDefinition) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.variableRole,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.observed)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.intended)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.directnessMatch,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceStatisticSerializer : KSerializer<Evidence.Statistic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Statistic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("statisticType", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("numberOfEvents", Int.serializer().descriptor)
      optionalElement("_numberOfEvents", ElementSerializer.descriptor)
      optionalElement("numberAffected", Int.serializer().descriptor)
      optionalElement("_numberAffected", ElementSerializer.descriptor)
      optionalElement("sampleSize", EvidenceStatisticSampleSizeSerializer.descriptor)
      optionalElement(
        "attributeEstimate",
        EvidenceStatisticAttributeEstimateSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "modelCharacteristic",
        EvidenceStatisticModelCharacteristicSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Evidence.Statistic>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Evidence.Statistic {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          statisticType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        9 -> numberOfEvents = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _numberOfEvents =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> numberAffected = compositeDecoder.decodeIntElement(descriptor, i)
        12 ->
          _numberAffected =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          sampleSize =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticSampleSizeSerializer,
              null,
            )
        14 ->
          attributeEstimate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticAttributeEstimateSerializer.listSerializer,
              null,
            )
        15 ->
          modelCharacteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticModelCharacteristicSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Statistic: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.statisticType,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.quantity)
    compositeEncoder.encodeIntIfNotNull(descriptor, 9, value.numberOfEvents?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.numberOfEvents)
    compositeEncoder.encodeIntIfNotNull(descriptor, 11, value.numberAffected?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.numberAffected)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      EvidenceStatisticSampleSizeSerializer,
      value.sampleSize,
    )
    if (value.attributeEstimate.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        14,
        EvidenceStatisticAttributeEstimateSerializer.listSerializer,
        value.attributeEstimate,
      )
    if (value.modelCharacteristic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15,
        EvidenceStatisticModelCharacteristicSerializer.listSerializer,
        value.modelCharacteristic,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceStatisticSampleSizeSerializer : KSerializer<Evidence.Statistic.SampleSize> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SampleSize") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("numberOfStudies", Int.serializer().descriptor)
      optionalElement("_numberOfStudies", ElementSerializer.descriptor)
      optionalElement("numberOfParticipants", Int.serializer().descriptor)
      optionalElement("_numberOfParticipants", ElementSerializer.descriptor)
      optionalElement("knownDataCount", Int.serializer().descriptor)
      optionalElement("_knownDataCount", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Evidence.Statistic.SampleSize>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Evidence.Statistic.SampleSize {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 -> numberOfStudies = compositeDecoder.decodeIntElement(descriptor, i)
        7 ->
          _numberOfStudies =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> numberOfParticipants = compositeDecoder.decodeIntElement(descriptor, i)
        9 ->
          _numberOfParticipants =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> knownDataCount = compositeDecoder.decodeIntElement(descriptor, i)
        11 ->
          _knownDataCount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampleSize: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.SampleSize) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 6, value.numberOfStudies?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.numberOfStudies)
    compositeEncoder.encodeIntIfNotNull(descriptor, 8, value.numberOfParticipants?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.numberOfParticipants)
    compositeEncoder.encodeIntIfNotNull(descriptor, 10, value.knownDataCount?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.knownDataCount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceStatisticAttributeEstimateSerializer :
  KSerializer<Evidence.Statistic.AttributeEstimate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AttributeEstimate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("level", FhirDecimalSerializer.descriptor)
      optionalElement("_level", ElementSerializer.descriptor)
      optionalElement("range", RangeSerializer.descriptor)
      optionalElement(
        "attributeEstimate",
        listSerialDescriptor(
          lazyDescriptor { EvidenceStatisticAttributeEstimateSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<Evidence.Statistic.AttributeEstimate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Evidence.Statistic.AttributeEstimate {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        8 ->
          level =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        9 ->
          _level =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          range =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        11 ->
          attributeEstimate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticAttributeEstimateSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AttributeEstimate: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.AttributeEstimate) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      FhirDecimalSerializer,
      value.level?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.level)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 10, RangeSerializer, value.range)
    if (value.attributeEstimate.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        EvidenceStatisticAttributeEstimateSerializer.listSerializer,
        value.attributeEstimate,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceStatisticModelCharacteristicSerializer :
  KSerializer<Evidence.Statistic.ModelCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ModelCharacteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("value", QuantitySerializer.descriptor)
      optionalElement(
        "variable",
        EvidenceStatisticModelCharacteristicVariableSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "attributeEstimate",
        listSerialDescriptor(
          lazyDescriptor { EvidenceStatisticAttributeEstimateSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<Evidence.Statistic.ModelCharacteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Evidence.Statistic.ModelCharacteristic {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var `value`: Quantity? = null
    var variable: List<Evidence.Statistic.ModelCharacteristic.Variable>? = null
    var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          variable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticModelCharacteristicVariableSerializer.listSerializer,
              null,
            )
        6 ->
          attributeEstimate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticAttributeEstimateSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ModelCharacteristic: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Evidence.Statistic.ModelCharacteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on Evidence.Statistic.ModelCharacteristic"
          ),
      `value` = `value`,
      variable = variable ?: listOf(),
      attributeEstimate = attributeEstimate ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.ModelCharacteristic) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.`value`)
    if (value.variable.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        EvidenceStatisticModelCharacteristicVariableSerializer.listSerializer,
        value.variable,
      )
    if (value.attributeEstimate.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        EvidenceStatisticAttributeEstimateSerializer.listSerializer,
        value.attributeEstimate,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceStatisticModelCharacteristicVariableSerializer :
  KSerializer<Evidence.Statistic.ModelCharacteristic.Variable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Variable") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("variableDefinition", ReferenceSerializer.descriptor)
      optionalElement("handling", KotlinString.serializer().descriptor)
      optionalElement("_handling", ElementSerializer.descriptor)
      optionalElement("valueCategory", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.listSerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Evidence.Statistic.ModelCharacteristic.Variable>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Evidence.Statistic.ModelCharacteristic.Variable {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          variableDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> handling = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _handling =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          valueCategory =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        7 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        8 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RangeSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variable: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Evidence.Statistic.ModelCharacteristic.Variable(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      variableDefinition =
        variableDefinition
          ?: throw SerializationException(
            "Missing required property 'variableDefinition' on Evidence.Statistic.ModelCharacteristic.Variable"
          ),
      handling =
        Enumeration.of(
          if (handling != null) EvidenceVariableHandling.fromCode(handling) else null,
          _handling,
        ),
      valueCategory = valueCategory ?: listOf(),
      valueQuantity = valueQuantity ?: listOf(),
      valueRange = valueRange ?: listOf(),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: Evidence.Statistic.ModelCharacteristic.Variable,
  ) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      ReferenceSerializer,
      value.variableDefinition,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.handling?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.handling)
    if (value.valueCategory.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        CodeableConceptSerializer.listSerializer,
        value.valueCategory,
      )
    if (value.valueQuantity.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        QuantitySerializer.listSerializer,
        value.valueQuantity,
      )
    if (value.valueRange.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        RangeSerializer.listSerializer,
        value.valueRange,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceCertaintySerializer : KSerializer<Evidence.Certainty> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Certainty") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("rating", CodeableConceptSerializer.descriptor)
      optionalElement("rater", KotlinString.serializer().descriptor)
      optionalElement("_rater", ElementSerializer.descriptor)
      optionalElement(
        "subcomponent",
        listSerialDescriptor(lazyDescriptor { EvidenceCertaintySerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Evidence.Certainty>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Evidence.Certainty {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          rating =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 -> rater = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _rater =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          subcomponent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceCertaintySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Certainty: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: Evidence.Certainty) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.description)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.rating,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.rater?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.rater)
    if (value.subcomponent.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        EvidenceCertaintySerializer.listSerializer,
        value.subcomponent,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EvidenceSerializer : FhirResourceSerializer<Evidence> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Evidence")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("citeAsReference", ReferenceSerializer.descriptor)
    b.optionalElement("citeAsMarkdown", KotlinString.serializer().descriptor)
    b.optionalElement("_citeAsMarkdown", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("assertion", KotlinString.serializer().descriptor)
    b.optionalElement("_assertion", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement(
      "variableDefinition",
      EvidenceVariableDefinitionSerializer.listSerializer.descriptor,
    )
    b.optionalElement("synthesisType", CodeableConceptSerializer.descriptor)
    b.optionalElement("studyType", CodeableConceptSerializer.descriptor)
    b.optionalElement("statistic", EvidenceStatisticSerializer.listSerializer.descriptor)
    b.optionalElement("certainty", EvidenceCertaintySerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          citeAsReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 -> citeAsMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _citeAsMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        25 -> approvalDate = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> lastReviewDate = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        32 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 ->
          editor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        34 ->
          reviewer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        35 ->
          endorser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        36 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        37 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> assertion = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _assertion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        42 ->
          variableDefinition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableDefinitionSerializer.listSerializer,
              null,
            )
        43 ->
          synthesisType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        44 ->
          studyType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        45 ->
          statistic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticSerializer.listSerializer,
              null,
            )
        46 ->
          certainty =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceCertaintySerializer.listSerializer,
              null,
            )
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
      version = R4bString.of(version, _version),
      title = R4bString.of(title, _title),
      citeAs = Evidence.CiteAs.from(citeAsReference, Markdown.of(citeAsMarkdown, _citeAsMarkdown)),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Evidence"),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      useContext = useContext ?: listOf(),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
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

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Evidence,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.title)
    when (val choice = value.citeAs) {
      null -> {}
      is Evidence.CiteAs.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Evidence.CiteAs.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          18 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.date)
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    if (value.author.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.description)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.assertion?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.assertion)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.variableDefinition.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        EvidenceVariableDefinitionSerializer.listSerializer,
        value.variableDefinition,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      CodeableConceptSerializer,
      value.synthesisType,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      CodeableConceptSerializer,
      value.studyType,
    )
    if (value.statistic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        EvidenceStatisticSerializer.listSerializer,
        value.statistic,
      )
    if (value.certainty.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        EvidenceCertaintySerializer.listSerializer,
        value.certainty,
      )
  }
}
