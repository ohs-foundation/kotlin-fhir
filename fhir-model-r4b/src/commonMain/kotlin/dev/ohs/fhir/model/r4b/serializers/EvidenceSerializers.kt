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

  internal val listSerializer: KSerializer<List<Evidence.VariableDefinition>> = ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          variableRole =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          observed =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        8 ->
          intended =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        9 ->
          directnessMatch =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Evidence.VariableDefinition) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, value.variableRole)
    (value.observed)?.let {
      encoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, it)
    }
    (value.intended)?.let {
      encoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, it)
    }
    (value.directnessMatch)?.let {
      encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<Evidence.Statistic>> = ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          statisticType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        9 -> numberOfEvents = decoder.decodeIntElement(descriptor, i)
        10 ->
          _numberOfEvents =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 -> numberAffected = decoder.decodeIntElement(descriptor, i)
        12 ->
          _numberAffected =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          sampleSize =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticSampleSizeSerializer,
              null,
            )
        14 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticAttributeEstimateSerializer.listSerializer,
              null,
            )
        15 ->
          modelCharacteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticModelCharacteristicSerializer.listSerializer,
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Evidence.Statistic) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    (value.statisticType)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, it)
    }
    ((value.numberOfEvents?.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
    (value.numberOfEvents?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
    ((value.numberAffected?.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
    (value.numberAffected?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
    }
    (value.sampleSize)?.let {
      encoder.encodeSerializableElement(descriptor, 13, EvidenceStatisticSampleSizeSerializer, it)
    }
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        EvidenceStatisticAttributeEstimateSerializer.listSerializer,
        value.attributeEstimate,
      )
    if (value.modelCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15,
        EvidenceStatisticModelCharacteristicSerializer.listSerializer,
        value.modelCharacteristic,
      )
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

  internal val listSerializer: KSerializer<List<Evidence.Statistic.SampleSize>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 -> numberOfStudies = decoder.decodeIntElement(descriptor, i)
        7 ->
          _numberOfStudies =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 -> numberOfParticipants = decoder.decodeIntElement(descriptor, i)
        9 ->
          _numberOfParticipants =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        10 -> knownDataCount = decoder.decodeIntElement(descriptor, i)
        11 ->
          _knownDataCount =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampleSize: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Evidence.Statistic.SampleSize) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    ((value.numberOfStudies?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.numberOfStudies?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    ((value.numberOfParticipants?.value))?.let { encoder.encodeIntElement(descriptor, 8, it) }
    (value.numberOfParticipants?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer, it)
    }
    ((value.knownDataCount?.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
    (value.knownDataCount?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<Evidence.Statistic.AttributeEstimate>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        8 ->
          level =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        9 ->
          _level = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        10 ->
          range = decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        11 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticAttributeEstimateSerializer.listSerializer,
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
      description = R4bString.of(description, _description),
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 7, QuantitySerializer, it)
    }
    ((value.level?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 8, FhirDecimalSerializer, it)
    }
    (value.level?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer, it)
    }
    (value.range)?.let { encoder.encodeSerializableElement(descriptor, 10, RangeSerializer, it) }
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        EvidenceStatisticAttributeEstimateSerializer.listSerializer,
        value.attributeEstimate,
      )
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

  internal val listSerializer: KSerializer<List<Evidence.Statistic.ModelCharacteristic>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          `value` =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        5 ->
          variable =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticModelCharacteristicVariableSerializer.listSerializer,
              null,
            )
        6 ->
          attributeEstimate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticAttributeEstimateSerializer.listSerializer,
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Evidence.Statistic.ModelCharacteristic,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    (value.`value`)?.let {
      encoder.encodeSerializableElement(descriptor, 4, QuantitySerializer, it)
    }
    if (value.variable.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        EvidenceStatisticModelCharacteristicVariableSerializer.listSerializer,
        value.variable,
      )
    if (value.attributeEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        EvidenceStatisticAttributeEstimateSerializer.listSerializer,
        value.attributeEstimate,
      )
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

  internal val listSerializer: KSerializer<List<Evidence.Statistic.ModelCharacteristic.Variable>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          variableDefinition =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        4 -> handling = decoder.decodeStringElement(descriptor, i)
        5 ->
          _handling =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          valueCategory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        8 ->
          valueRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RangeSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variable: " + i)
      }
    }
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
        Enumeration.of(handling?.let { Evidence.EvidenceVariableHandling.fromCode(it) }, _handling),
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.variableDefinition)
    ((value.handling?.value?.code))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.handling?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    if (value.valueCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        CodeableConceptSerializer.listSerializer,
        value.valueCategory,
      )
    if (value.valueQuantity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        QuantitySerializer.listSerializer,
        value.valueQuantity,
      )
    if (value.valueRange.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        RangeSerializer.listSerializer,
        value.valueRange,
      )
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

  internal val listSerializer: KSerializer<List<Evidence.Certainty>> = ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        6 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          rating =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 -> rater = decoder.decodeStringElement(descriptor, i)
        9 ->
          _rater = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        10 ->
          subcomponent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceCertaintySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Certainty: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Evidence.Certainty) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    (value.rating)?.let {
      encoder.encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, it)
    }
    ((value.rater?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.rater?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer, it)
    }
    if (value.subcomponent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        EvidenceCertaintySerializer.listSerializer,
        value.subcomponent,
      )
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
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("citeAsReference", Reference.serializer().descriptor, isOptional = true)
    b.element("citeAsMarkdown", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_citeAsMarkdown", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
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
    b.element("studyType", CodeableConcept.serializer().descriptor, isOptional = true)
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> title = decoder.decodeStringElement(descriptor, i)
        16 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          citeAsReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 -> citeAsMarkdown = decoder.decodeStringElement(descriptor, i)
        19 ->
          _citeAsMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> status = decoder.decodeStringElement(descriptor, i)
        21 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> date = decoder.decodeStringElement(descriptor, i)
        23 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        25 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        26 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        28 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> publisher = decoder.decodeStringElement(descriptor, i)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        32 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        34 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        35 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        36 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        37 -> description = decoder.decodeStringElement(descriptor, i)
        38 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> assertion = decoder.decodeStringElement(descriptor, i)
        40 ->
          _assertion =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        42 ->
          variableDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableDefinitionSerializer.listSerializer,
              null,
            )
        43 ->
          synthesisType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        44 ->
          studyType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        45 ->
          statistic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticSerializer.listSerializer,
              null,
            )
        46 ->
          certainty =
            decoder.decodeNullableSerializableElement(
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
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Evidence"),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      useContext = useContext ?: listOf(),
      approvalDate = Date.of(approvalDate?.let { FhirDate.fromString(it) }, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate?.let { FhirDate.fromString(it) }, _lastReviewDate),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Evidence,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, ElementSerializer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ElementSerializer, it)
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, ElementSerializer, it)
    }
    when (val choice = value.citeAs) {
      null -> {}
      is Evidence.CiteAs.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Evidence.CiteAs.Markdown -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            19 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, ElementSerializer, it)
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ElementSerializer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, ElementSerializer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, ElementSerializer, it)
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, ElementSerializer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, ElementSerializer, it)
    }
    ((value.assertion?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.assertion?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 40 + descriptorOffset, ElementSerializer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.variableDefinition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        EvidenceVariableDefinitionSerializer.listSerializer,
        value.variableDefinition,
      )
    (value.synthesisType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.studyType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.statistic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        EvidenceStatisticSerializer.listSerializer,
        value.statistic,
      )
    if (value.certainty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        EvidenceCertaintySerializer.listSerializer,
        value.certainty,
      )
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
