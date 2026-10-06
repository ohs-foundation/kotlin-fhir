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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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

  override fun deserialize(decoder: Decoder): Evidence.VariableDefinition =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          6 ->
            variableRole =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            observed = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            intended = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            directnessMatch =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding VariableDefinition: " + i)
        }
      }
      Evidence.VariableDefinition(
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 5, AnnotationSerializer.listSerializer, value.note)
      encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, value.variableRole)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.observed)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.intended)
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.directnessMatch)
    }
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

  override fun deserialize(decoder: Decoder): Evidence.Statistic =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          6 ->
            statisticType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> numberOfEvents = decodeIntElement(descriptor, i)
          10 ->
            _numberOfEvents =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> numberAffected = decodeIntElement(descriptor, i)
          12 ->
            _numberAffected =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            sampleSize =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceStatisticSampleSizeSerializer,
                null,
              )
          14 ->
            attributeEstimate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceStatisticAttributeEstimateSerializer.listSerializer,
                null,
              )
          15 ->
            modelCharacteristic =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceStatisticModelCharacteristicSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Statistic: " + i)
        }
      }
      Evidence.Statistic(
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

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 5, AnnotationSerializer.listSerializer, value.note)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.statisticType)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.quantity)
      encodeIntIfNotNull(descriptor, 9, value.numberOfEvents?.value)
      encodeElementIfNotNull(descriptor, 10, value.numberOfEvents)
      encodeIntIfNotNull(descriptor, 11, value.numberAffected?.value)
      encodeElementIfNotNull(descriptor, 12, value.numberAffected)
      encodeSerializableIfNotNull(
        descriptor,
        13,
        EvidenceStatisticSampleSizeSerializer,
        value.sampleSize,
      )
      if (value.attributeEstimate.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          EvidenceStatisticAttributeEstimateSerializer.listSerializer,
          value.attributeEstimate,
        )
      if (value.modelCharacteristic.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          EvidenceStatisticModelCharacteristicSerializer.listSerializer,
          value.modelCharacteristic,
        )
    }
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

  override fun deserialize(decoder: Decoder): Evidence.Statistic.SampleSize =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          6 -> numberOfStudies = decodeIntElement(descriptor, i)
          7 ->
            _numberOfStudies =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> numberOfParticipants = decodeIntElement(descriptor, i)
          9 ->
            _numberOfParticipants =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> knownDataCount = decodeIntElement(descriptor, i)
          11 ->
            _knownDataCount =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SampleSize: " + i)
        }
      }
      Evidence.Statistic.SampleSize(
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

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.SampleSize) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 5, AnnotationSerializer.listSerializer, value.note)
      encodeIntIfNotNull(descriptor, 6, value.numberOfStudies?.value)
      encodeElementIfNotNull(descriptor, 7, value.numberOfStudies)
      encodeIntIfNotNull(descriptor, 8, value.numberOfParticipants?.value)
      encodeElementIfNotNull(descriptor, 9, value.numberOfParticipants)
      encodeIntIfNotNull(descriptor, 10, value.knownDataCount?.value)
      encodeElementIfNotNull(descriptor, 11, value.knownDataCount)
    }
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

  override fun deserialize(decoder: Decoder): Evidence.Statistic.AttributeEstimate =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          6 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          8 -> level = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          9 -> _level = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> range = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          11 ->
            attributeEstimate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceStatisticAttributeEstimateSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding AttributeEstimate: " + i)
        }
      }
      Evidence.Statistic.AttributeEstimate(
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

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.AttributeEstimate) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 5, AnnotationSerializer.listSerializer, value.note)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 8, FhirDecimalSerializer, value.level?.value)
      encodeElementIfNotNull(descriptor, 9, value.level)
      encodeSerializableIfNotNull(descriptor, 10, RangeSerializer, value.range)
      if (value.attributeEstimate.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          EvidenceStatisticAttributeEstimateSerializer.listSerializer,
          value.attributeEstimate,
        )
    }
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

  override fun deserialize(decoder: Decoder): Evidence.Statistic.ModelCharacteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var `value`: Quantity? = null
      var variable: List<Evidence.Statistic.ModelCharacteristic.Variable>? = null
      var attributeEstimate: List<Evidence.Statistic.AttributeEstimate>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> `value` = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            variable =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceStatisticModelCharacteristicVariableSerializer.listSerializer,
                null,
              )
          6 ->
            attributeEstimate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceStatisticAttributeEstimateSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding ModelCharacteristic: " + i)
        }
      }
      Evidence.Statistic.ModelCharacteristic(
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.`value`)
      if (value.variable.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          EvidenceStatisticModelCharacteristicVariableSerializer.listSerializer,
          value.variable,
        )
      if (value.attributeEstimate.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          EvidenceStatisticAttributeEstimateSerializer.listSerializer,
          value.attributeEstimate,
        )
    }
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

  override fun deserialize(decoder: Decoder): Evidence.Statistic.ModelCharacteristic.Variable =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            variableDefinition =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> handling = decodeStringElement(descriptor, i)
          5 -> _handling = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            valueCategory =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          7 ->
            valueQuantity =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuantitySerializer.listSerializer,
                null,
              )
          8 ->
            valueRange =
              decodeNullableSerializableElement(descriptor, i, RangeSerializer.listSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Variable: " + i)
        }
      }
      Evidence.Statistic.ModelCharacteristic.Variable(
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
            if (handling != null) Evidence.EvidenceVariableHandling.fromCode(handling) else null,
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.variableDefinition)
      encodeStringIfNotNull(descriptor, 4, value.handling?.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.handling)
      if (value.valueCategory.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer.listSerializer,
          value.valueCategory,
        )
      if (value.valueQuantity.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          QuantitySerializer.listSerializer,
          value.valueQuantity,
        )
      if (value.valueRange.isNotEmpty())
        encodeSerializableElement(descriptor, 8, RangeSerializer.listSerializer, value.valueRange)
    }
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

  override fun deserialize(decoder: Decoder): Evidence.Certainty =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          6 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            rating =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 -> rater = decodeStringElement(descriptor, i)
          9 -> _rater = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            subcomponent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceCertaintySerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Certainty: " + i)
        }
      }
      Evidence.Certainty(
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

  override fun serialize(encoder: Encoder, `value`: Evidence.Certainty) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 5, AnnotationSerializer.listSerializer, value.note)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.rating)
      encodeStringIfNotNull(descriptor, 8, value.rater?.value)
      encodeElementIfNotNull(descriptor, 9, value.rater)
      if (value.subcomponent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          EvidenceCertaintySerializer.listSerializer,
          value.subcomponent,
        )
    }
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
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("citeAsReference", ReferenceSerializer.descriptor)
    b.optionalElement("citeAsMarkdown", KotlinString.serializer().descriptor)
    b.optionalElement("_citeAsMarkdown", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
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
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
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
    b.optionalElement("studyDesign", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("statistic", EvidenceStatisticSerializer.listSerializer.descriptor)
    b.optionalElement("certainty", EvidenceCertaintySerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          citeAsReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 -> citeAsMarkdown = decoder.decodeStringElement(descriptor, i)
        24 ->
          _citeAsMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> status = decoder.decodeStringElement(descriptor, i)
        26 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        28 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> date = decoder.decodeStringElement(descriptor, i)
        30 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        32 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        34 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> publisher = decoder.decodeStringElement(descriptor, i)
        36 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        38 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        39 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        40 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        41 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        42 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        43 -> purpose = decoder.decodeStringElement(descriptor, i)
        44 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 -> copyright = decoder.decodeStringElement(descriptor, i)
        46 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        48 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        49 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        50 -> description = decoder.decodeStringElement(descriptor, i)
        51 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        52 -> assertion = decoder.decodeStringElement(descriptor, i)
        53 ->
          _assertion =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        54 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        55 ->
          variableDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableDefinitionSerializer.listSerializer,
              null,
            )
        56 ->
          synthesisType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        57 ->
          studyDesign =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        58 ->
          statistic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceStatisticSerializer.listSerializer,
              null,
            )
        59 ->
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        Evidence.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      citeAs = Evidence.CiteAs.from(citeAsReference, Markdown.of(citeAsMarkdown, _citeAsMarkdown)),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Evidence"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Evidence,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is Evidence.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is Evidence.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    when (val choice = value.citeAs) {
      null -> {}
      is Evidence.CiteAs.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Evidence.CiteAs.Markdown -> {
        encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 27 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.lastReviewDate)
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 45 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 47 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.copyrightLabel)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    encoder.encodeStringIfNotNull(descriptor, 50 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 51 + descriptorOffset, value.description)
    encoder.encodeStringIfNotNull(descriptor, 52 + descriptorOffset, value.assertion?.value)
    encoder.encodeElementIfNotNull(descriptor, 53 + descriptorOffset, value.assertion)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.variableDefinition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        EvidenceVariableDefinitionSerializer.listSerializer,
        value.variableDefinition,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      56 + descriptorOffset,
      CodeableConceptSerializer,
      value.synthesisType,
    )
    if (value.studyDesign.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.studyDesign,
      )
    if (value.statistic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        EvidenceStatisticSerializer.listSerializer,
        value.statistic,
      )
    if (value.certainty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        EvidenceCertaintySerializer.listSerializer,
        value.certainty,
      )
  }
}
