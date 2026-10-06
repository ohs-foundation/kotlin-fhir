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
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.SampledData
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object ObservationTriggeredBySerializer : KSerializer<Observation.TriggeredBy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TriggeredBy") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("observation", ReferenceSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("reason", KotlinString.serializer().descriptor)
      optionalElement("_reason", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Observation.TriggeredBy>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Observation.TriggeredBy =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var observation: Reference? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var reason: KotlinString? = null
      var _reason: Element? = null
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
            observation =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> type = decodeStringElement(descriptor, i)
          5 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> reason = decodeStringElement(descriptor, i)
          7 -> _reason = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TriggeredBy: " + i)
        }
      }
      Observation.TriggeredBy(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        observation =
          observation
            ?: throw SerializationException(
              "Missing required property 'observation' on Observation.TriggeredBy"
            ),
        type =
          Enumeration.of(
            if (type != null) Observation.TriggeredBytype.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on Observation.TriggeredBy"
            ),
        reason = R5String.of(reason, _reason),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Observation.TriggeredBy) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.observation)
      encodeStringIfNotNull(descriptor, 4, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.type)
      encodeStringIfNotNull(descriptor, 6, value.reason?.value)
      encodeElementIfNotNull(descriptor, 7, value.reason)
    }
  }
}

internal object ObservationReferenceRangeSerializer : KSerializer<Observation.ReferenceRange> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceRange") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("low", QuantitySerializer.descriptor)
      optionalElement("high", QuantitySerializer.descriptor)
      optionalElement("normalValue", CodeableConceptSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("appliesTo", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("age", RangeSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Observation.ReferenceRange>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Observation.ReferenceRange =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var low: Quantity? = null
      var high: Quantity? = null
      var normalValue: CodeableConcept? = null
      var type: CodeableConcept? = null
      var appliesTo: List<CodeableConcept>? = null
      var age: Range? = null
      var text: KotlinString? = null
      var _text: Element? = null
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
          3 -> low = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          4 -> high = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            normalValue =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            appliesTo =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 -> age = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          9 -> text = decodeStringElement(descriptor, i)
          10 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ReferenceRange: " + i)
        }
      }
      Observation.ReferenceRange(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        low = low,
        high = high,
        normalValue = normalValue,
        type = type,
        appliesTo = appliesTo ?: listOf(),
        age = age,
        text = Markdown.of(text, _text),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Observation.ReferenceRange) {
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
      encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.low)
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.high)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.normalValue)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.type)
      if (value.appliesTo.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.appliesTo,
        )
      encodeSerializableIfNotNull(descriptor, 8, RangeSerializer, value.age)
      encodeStringIfNotNull(descriptor, 9, value.text?.value)
      encodeElementIfNotNull(descriptor, 10, value.text)
    }
  }
}

internal object ObservationComponentSerializer : KSerializer<Observation.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueRatio", RatioSerializer.descriptor)
      optionalElement("valueSampledData", SampledDataSerializer.descriptor)
      optionalElement("valueTime", LocalTimeSerializer.descriptor)
      optionalElement("_valueTime", ElementSerializer.descriptor)
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", ElementSerializer.descriptor)
      optionalElement("valuePeriod", PeriodSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
      optionalElement("dataAbsentReason", CodeableConceptSerializer.descriptor)
      optionalElement("interpretation", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "referenceRange",
        listSerialDescriptor(lazyDescriptor { ObservationReferenceRangeSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Observation.Component>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Observation.Component =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueString: KotlinString? = null
      var _valueString: Element? = null
      var valueBoolean: KotlinBoolean? = null
      var _valueBoolean: Element? = null
      var valueInteger: Int? = null
      var _valueInteger: Element? = null
      var valueRange: Range? = null
      var valueRatio: Ratio? = null
      var valueSampledData: SampledData? = null
      var valueTime: LocalTime? = null
      var _valueTime: Element? = null
      var valueDateTime: KotlinString? = null
      var _valueDateTime: Element? = null
      var valuePeriod: Period? = null
      var valueAttachment: Attachment? = null
      var valueReference: Reference? = null
      var dataAbsentReason: CodeableConcept? = null
      var interpretation: List<CodeableConcept>? = null
      var referenceRange: List<Observation.ReferenceRange>? = null
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
          4 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> valueString = decodeStringElement(descriptor, i)
          7 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueBoolean = decodeBooleanElement(descriptor, i)
          9 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueInteger = decodeIntElement(descriptor, i)
          11 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          13 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          14 ->
            valueSampledData =
              decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
          15 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          16 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> valueDateTime = decodeStringElement(descriptor, i)
          18 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 ->
            valuePeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          20 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          21 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          22 ->
            dataAbsentReason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          23 ->
            interpretation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          24 ->
            referenceRange =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ObservationReferenceRangeSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Component: " + i)
        }
      }
      Observation.Component(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on Observation.Component"
            ),
        `value` =
          Observation.Component.Value.from(
            valueQuantity,
            valueCodeableConcept,
            R5String.of(valueString, _valueString),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Integer.of(valueInteger, _valueInteger),
            valueRange,
            valueRatio,
            valueSampledData,
            Time.of(valueTime, _valueTime),
            DateTime.of(
              if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
              _valueDateTime,
            ),
            valuePeriod,
            valueAttachment,
            valueReference,
          ),
        dataAbsentReason = dataAbsentReason,
        interpretation = interpretation ?: listOf(),
        referenceRange = referenceRange ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Observation.Component) {
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
      when (val choice = value.`value`) {
        null -> {}
        is Observation.Component.Value.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is Observation.Component.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is Observation.Component.Value.String -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is Observation.Component.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is Observation.Component.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is Observation.Component.Value.Range -> {
          encodeSerializableElement(descriptor, 12, RangeSerializer, choice.value)
        }
        is Observation.Component.Value.Ratio -> {
          encodeSerializableElement(descriptor, 13, RatioSerializer, choice.value)
        }
        is Observation.Component.Value.SampledData -> {
          encodeSerializableElement(descriptor, 14, SampledDataSerializer, choice.value)
        }
        is Observation.Component.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 15, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is Observation.Component.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 17, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is Observation.Component.Value.Period -> {
          encodeSerializableElement(descriptor, 19, PeriodSerializer, choice.value)
        }
        is Observation.Component.Value.Attachment -> {
          encodeSerializableElement(descriptor, 20, AttachmentSerializer, choice.value)
        }
        is Observation.Component.Value.Reference -> {
          encodeSerializableElement(descriptor, 21, ReferenceSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 22, CodeableConceptSerializer, value.dataAbsentReason)
      if (value.interpretation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          23,
          CodeableConceptSerializer.listSerializer,
          value.interpretation,
        )
      if (value.referenceRange.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          24,
          ObservationReferenceRangeSerializer.listSerializer,
          value.referenceRange,
        )
    }
  }
}

internal object ObservationSerializer : FhirResourceSerializer<Observation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Observation")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", KotlinString.serializer().descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.descriptor)
    b.optionalElement("instantiatesReference", ReferenceSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("triggeredBy", ObservationTriggeredBySerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("effectiveDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_effectiveDateTime", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("effectiveTiming", TimingSerializer.descriptor)
    b.optionalElement("effectiveInstant", KotlinString.serializer().descriptor)
    b.optionalElement("_effectiveInstant", ElementSerializer.descriptor)
    b.optionalElement("issued", KotlinString.serializer().descriptor)
    b.optionalElement("_issued", ElementSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueString", KotlinString.serializer().descriptor)
    b.optionalElement("_valueString", ElementSerializer.descriptor)
    b.optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_valueBoolean", ElementSerializer.descriptor)
    b.optionalElement("valueInteger", Int.serializer().descriptor)
    b.optionalElement("_valueInteger", ElementSerializer.descriptor)
    b.optionalElement("valueRange", RangeSerializer.descriptor)
    b.optionalElement("valueRatio", RatioSerializer.descriptor)
    b.optionalElement("valueSampledData", SampledDataSerializer.descriptor)
    b.optionalElement("valueTime", LocalTimeSerializer.descriptor)
    b.optionalElement("_valueTime", ElementSerializer.descriptor)
    b.optionalElement("valueDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_valueDateTime", ElementSerializer.descriptor)
    b.optionalElement("valuePeriod", PeriodSerializer.descriptor)
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
    b.optionalElement("dataAbsentReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("interpretation", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.descriptor)
    b.optionalElement("bodyStructure", ReferenceSerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.optionalElement("specimen", ReferenceSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.descriptor)
    b.optionalElement(
      "referenceRange",
      ObservationReferenceRangeSerializer.listSerializer.descriptor,
    )
    b.optionalElement("hasMember", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("derivedFrom", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("component", ObservationComponentSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Observation {
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
    var instantiatesCanonical: KotlinString? = null
    var _instantiatesCanonical: Element? = null
    var instantiatesReference: Reference? = null
    var basedOn: List<Reference>? = null
    var triggeredBy: List<Observation.TriggeredBy>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var focus: List<Reference>? = null
    var encounter: Reference? = null
    var effectiveDateTime: KotlinString? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var effectiveTiming: Timing? = null
    var effectiveInstant: KotlinString? = null
    var _effectiveInstant: Element? = null
    var issued: KotlinString? = null
    var _issued: Element? = null
    var performer: List<Reference>? = null
    var valueQuantity: Quantity? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueRange: Range? = null
    var valueRatio: Ratio? = null
    var valueSampledData: SampledData? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valuePeriod: Period? = null
    var valueAttachment: Attachment? = null
    var valueReference: Reference? = null
    var dataAbsentReason: CodeableConcept? = null
    var interpretation: List<CodeableConcept>? = null
    var note: List<Annotation>? = null
    var bodySite: CodeableConcept? = null
    var bodyStructure: Reference? = null
    var method: CodeableConcept? = null
    var specimen: Reference? = null
    var device: Reference? = null
    var referenceRange: List<Observation.ReferenceRange>? = null
    var hasMember: List<Reference>? = null
    var derivedFrom: List<Reference>? = null
    var component: List<Observation.Component>? = null
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> instantiatesCanonical = decoder.decodeStringElement(descriptor, i)
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          instantiatesReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        14 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          triggeredBy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationTriggeredBySerializer.listSerializer,
              null,
            )
        16 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 -> status = decoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 -> effectiveDateTime = decoder.decodeStringElement(descriptor, i)
        25 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        27 ->
          effectiveTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        28 -> effectiveInstant = decoder.decodeStringElement(descriptor, i)
        29 ->
          _effectiveInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> issued = decoder.decodeStringElement(descriptor, i)
        31 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        34 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        35 -> valueString = decoder.decodeStringElement(descriptor, i)
        36 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        38 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        40 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        42 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        43 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
        44 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        45 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        46 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        47 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        48 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        49 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        50 ->
          valueReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        51 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        52 ->
          interpretation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        53 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        54 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        55 ->
          bodyStructure =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        56 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        57 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        58 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        59 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationReferenceRangeSerializer.listSerializer,
              null,
            )
        60 ->
          hasMember =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        61 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        62 ->
          component =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationComponentSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Observation: " + i)
      }
    }
    return Observation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiates =
        Observation.Instantiates.from(
          Canonical.of(instantiatesCanonical, _instantiatesCanonical),
          instantiatesReference,
        ),
      basedOn = basedOn ?: listOf(),
      triggeredBy = triggeredBy ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) Observation.ObservationStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Observation"),
      category = category ?: listOf(),
      code =
        code ?: throw SerializationException("Missing required property 'code' on Observation"),
      subject = subject,
      focus = focus ?: listOf(),
      encounter = encounter,
      effective =
        Observation.Effective.from(
          DateTime.of(
            if (effectiveDateTime != null) FhirDateTime.fromString(effectiveDateTime) else null,
            _effectiveDateTime,
          ),
          effectivePeriod,
          effectiveTiming,
          Instant.of(
            if (effectiveInstant != null) FhirDateTime.fromString(effectiveInstant) else null,
            _effectiveInstant,
          ),
        ),
      issued = Instant.of(if (issued != null) FhirDateTime.fromString(issued) else null, _issued),
      performer = performer ?: listOf(),
      `value` =
        Observation.Value.from(
          valueQuantity,
          valueCodeableConcept,
          R5String.of(valueString, _valueString),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          valueRange,
          valueRatio,
          valueSampledData,
          Time.of(valueTime, _valueTime),
          DateTime.of(
            if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
            _valueDateTime,
          ),
          valuePeriod,
          valueAttachment,
          valueReference,
        ),
      dataAbsentReason = dataAbsentReason,
      interpretation = interpretation ?: listOf(),
      note = note ?: listOf(),
      bodySite = bodySite,
      bodyStructure = bodyStructure,
      method = method,
      specimen = specimen,
      device = device,
      referenceRange = referenceRange ?: listOf(),
      hasMember = hasMember ?: listOf(),
      derivedFrom = derivedFrom ?: listOf(),
      component = component ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Observation,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    when (val choice = value.instantiates) {
      null -> {}
      is Observation.Instantiates.Canonical -> {
        encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, choice.value)
      }
      is Observation.Instantiates.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          13 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.triggeredBy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        ObservationTriggeredBySerializer.listSerializer,
        value.triggeredBy,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.status)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.focus,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.effective) {
      null -> {}
      is Observation.Effective.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          24 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, choice.value)
      }
      is Observation.Effective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is Observation.Effective.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          27 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
      is Observation.Effective.Instant -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          28 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.issued?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.issued)
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.performer,
      )
    when (val choice = value.`value`) {
      null -> {}
      is Observation.Value.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          33 + descriptorOffset,
          QuantitySerializer,
          choice.value,
        )
      }
      is Observation.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          34 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Observation.Value.String -> {
        encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, choice.value)
      }
      is Observation.Value.Boolean -> {
        encoder.encodeBooleanIfNotNull(descriptor, 37 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, choice.value)
      }
      is Observation.Value.Integer -> {
        encoder.encodeIntIfNotNull(descriptor, 39 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, choice.value)
      }
      is Observation.Value.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is Observation.Value.Ratio -> {
        encoder.encodeSerializableElement(
          descriptor,
          42 + descriptorOffset,
          RatioSerializer,
          choice.value,
        )
      }
      is Observation.Value.SampledData -> {
        encoder.encodeSerializableElement(
          descriptor,
          43 + descriptorOffset,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Observation.Value.Time -> {
        encoder.encodeSerializableIfNotNull(
          descriptor,
          44 + descriptorOffset,
          LocalTimeSerializer,
          choice.value.value,
        )
        encoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, choice.value)
      }
      is Observation.Value.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          46 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, choice.value)
      }
      is Observation.Value.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          48 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is Observation.Value.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          49 + descriptorOffset,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Observation.Value.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          50 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      CodeableConceptSerializer,
      value.dataAbsentReason,
    )
    if (value.interpretation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.interpretation,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      54 + descriptorOffset,
      CodeableConceptSerializer,
      value.bodySite,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      55 + descriptorOffset,
      ReferenceSerializer,
      value.bodyStructure,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      56 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      57 + descriptorOffset,
      ReferenceSerializer,
      value.specimen,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      58 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    if (value.referenceRange.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        ObservationReferenceRangeSerializer.listSerializer,
        value.referenceRange,
      )
    if (value.hasMember.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.hasMember,
      )
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        61 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.derivedFrom,
      )
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        62 + descriptorOffset,
        ObservationComponentSerializer.listSerializer,
        value.component,
      )
  }
}
