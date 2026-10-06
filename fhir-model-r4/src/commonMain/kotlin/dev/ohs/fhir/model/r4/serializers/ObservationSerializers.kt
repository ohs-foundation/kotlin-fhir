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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Observation
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.SampledData
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
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

internal object ObservationReferenceRangeSerializer : KSerializer<Observation.ReferenceRange> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceRange") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("low", QuantitySerializer.descriptor)
      optionalElement("high", QuantitySerializer.descriptor)
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            appliesTo =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          7 -> age = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          8 -> text = decodeStringElement(descriptor, i)
          9 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
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
        type = type,
        appliesTo = appliesTo ?: listOf(),
        age = age,
        text = R4String.of(text, _text),
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
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      if (value.appliesTo.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer.listSerializer,
          value.appliesTo,
        )
      encodeSerializableIfNotNull(descriptor, 7, RangeSerializer, value.age)
      encodeStringIfNotNull(descriptor, 8, value.text?.value)
      encodeElementIfNotNull(descriptor, 9, value.text)
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
            dataAbsentReason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          21 ->
            interpretation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          22 ->
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
            R4String.of(valueString, _valueString),
            R4Boolean.of(valueBoolean, _valueBoolean),
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
      }
      encodeSerializableIfNotNull(descriptor, 20, CodeableConceptSerializer, value.dataAbsentReason)
      if (value.interpretation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          21,
          CodeableConceptSerializer.listSerializer,
          value.interpretation,
        )
      if (value.referenceRange.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          22,
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
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
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
    b.optionalElement("dataAbsentReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("interpretation", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.descriptor)
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
    var basedOn: List<Reference>? = null
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
    var dataAbsentReason: CodeableConcept? = null
    var interpretation: List<CodeableConcept>? = null
    var note: List<Annotation>? = null
    var bodySite: CodeableConcept? = null
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
        11 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 -> effectiveDateTime = decoder.decodeStringElement(descriptor, i)
        21 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        23 ->
          effectiveTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        24 -> effectiveInstant = decoder.decodeStringElement(descriptor, i)
        25 ->
          _effectiveInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> issued = decoder.decodeStringElement(descriptor, i)
        27 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        30 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        31 -> valueString = decoder.decodeStringElement(descriptor, i)
        32 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        34 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        36 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        38 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        39 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(descriptor, i, SampledDataSerializer, null)
        40 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        41 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        42 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        43 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        45 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        46 ->
          interpretation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        47 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        48 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        49 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        50 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        51 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        52 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationReferenceRangeSerializer.listSerializer,
              null,
            )
        53 ->
          hasMember =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        54 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        55 ->
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
      basedOn = basedOn ?: listOf(),
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
          R4String.of(valueString, _valueString),
          R4Boolean.of(valueBoolean, _valueBoolean),
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
        ),
      dataAbsentReason = dataAbsentReason,
      interpretation = interpretation ?: listOf(),
      note = note ?: listOf(),
      bodySite = bodySite,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.focus,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.effective) {
      null -> {}
      is Observation.Effective.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          20 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, choice.value)
      }
      is Observation.Effective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is Observation.Effective.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
      is Observation.Effective.Instant -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          24 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.issued?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.issued)
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.performer,
      )
    when (val choice = value.`value`) {
      null -> {}
      is Observation.Value.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          29 + descriptorOffset,
          QuantitySerializer,
          choice.value,
        )
      }
      is Observation.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Observation.Value.String -> {
        encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, choice.value)
      }
      is Observation.Value.Boolean -> {
        encoder.encodeBooleanIfNotNull(descriptor, 33 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, choice.value)
      }
      is Observation.Value.Integer -> {
        encoder.encodeIntIfNotNull(descriptor, 35 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, choice.value)
      }
      is Observation.Value.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          37 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is Observation.Value.Ratio -> {
        encoder.encodeSerializableElement(
          descriptor,
          38 + descriptorOffset,
          RatioSerializer,
          choice.value,
        )
      }
      is Observation.Value.SampledData -> {
        encoder.encodeSerializableElement(
          descriptor,
          39 + descriptorOffset,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Observation.Value.Time -> {
        encoder.encodeSerializableIfNotNull(
          descriptor,
          40 + descriptorOffset,
          LocalTimeSerializer,
          choice.value.value,
        )
        encoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, choice.value)
      }
      is Observation.Value.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          42 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, choice.value)
      }
      is Observation.Value.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          44 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      CodeableConceptSerializer,
      value.dataAbsentReason,
    )
    if (value.interpretation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.interpretation,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      48 + descriptorOffset,
      CodeableConceptSerializer,
      value.bodySite,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      50 + descriptorOffset,
      ReferenceSerializer,
      value.specimen,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    if (value.referenceRange.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        ObservationReferenceRangeSerializer.listSerializer,
        value.referenceRange,
      )
    if (value.hasMember.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.hasMember,
      )
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.derivedFrom,
      )
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        ObservationComponentSerializer.listSerializer,
        value.component,
      )
  }
}
