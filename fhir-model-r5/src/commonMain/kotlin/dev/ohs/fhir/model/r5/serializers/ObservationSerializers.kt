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
import dev.ohs.fhir.model.r5.terminologies.ObservationStatus
import dev.ohs.fhir.model.r5.terminologies.TriggeredBytype
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object ObservationTriggeredBySerializer : FhirSerializer<Observation.TriggeredBy> {
  override val descriptor: SerialDescriptor = buildDescriptor("TriggeredBy", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Observation.TriggeredBy>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("observation", ReferenceSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("reason")
  }

  override fun deserialize(decoder: Decoder): Observation.TriggeredBy {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var observation: Reference? = null
    var type: TriggeredBytype? = null
    var _type: Element? = null
    var reason: KotlinString? = null
    var _reason: Element? = null
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
          observation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> type = TriggeredBytype.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> reason = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Observation.TriggeredBy(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      observation = required(observation, "Observation.TriggeredBy", "observation"),
      type = required(Enumeration.of(type, _type), "Observation.TriggeredBy", "type"),
      reason = R5String.of(reason, _reason),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Observation.TriggeredBy) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      ReferenceSerializer,
      value.observation,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.reason?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.reason)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ObservationReferenceRangeSerializer : FhirSerializer<Observation.ReferenceRange> {
  override val descriptor: SerialDescriptor = buildDescriptor("ReferenceRange", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Observation.ReferenceRange>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("low", QuantitySerializer.descriptor)
    b.optionalElement("high", QuantitySerializer.descriptor)
    b.optionalElement("normalValue", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("appliesTo", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("age", RangeSerializer.descriptor)
    b.strPrim("text")
  }

  override fun deserialize(decoder: Decoder): Observation.ReferenceRange {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          low =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        4 ->
          high =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          normalValue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
          appliesTo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          age =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        9 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Observation.ReferenceRange(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      low = low,
      high = high,
      normalValue = normalValue,
      type = type,
      appliesTo = listOrEmpty(appliesTo),
      age = age,
      text = Markdown.of(text, _text),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Observation.ReferenceRange) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.low)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.high)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.normalValue,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.appliesTo,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 8, RangeSerializer, value.age)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.text?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.text)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ObservationComponentSerializer : FhirSerializer<Observation.Component> {
  override val descriptor: SerialDescriptor = buildDescriptor("Component", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Observation.Component>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.strPrim("valueString")
    b.boolPrim("valueBoolean")
    b.intPrim("valueInteger")
    b.optionalElement("valueRange", RangeSerializer.descriptor)
    b.optionalElement("valueRatio", RatioSerializer.descriptor)
    b.optionalElement("valueSampledData", SampledDataSerializer.descriptor)
    b.prim("valueTime", LocalTimeSerializer.descriptor)
    b.strPrim("valueDateTime")
    b.optionalElement("valuePeriod", PeriodSerializer.descriptor)
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
    b.optionalElement("dataAbsentReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("interpretation", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "referenceRange",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ObservationReferenceRangeSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): Observation.Component {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var valueDateTime: FhirDateTime? = null
    var _valueDateTime: Element? = null
    var valuePeriod: Period? = null
    var valueAttachment: Attachment? = null
    var valueReference: Reference? = null
    var dataAbsentReason: CodeableConcept? = null
    var interpretation: List<CodeableConcept>? = null
    var referenceRange: List<Observation.ReferenceRange>? = null
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
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        13 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        14 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        15 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        16 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        20 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        21 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          dataAbsentReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        23 ->
          interpretation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        24 ->
          referenceRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationReferenceRangeSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Observation.Component(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "Observation.Component", "code"),
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
          DateTime.of(valueDateTime, _valueDateTime),
          valuePeriod,
          valueAttachment,
          valueReference,
        ),
      dataAbsentReason = dataAbsentReason,
      interpretation = listOrEmpty(interpretation),
      referenceRange = listOrEmpty(referenceRange),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Observation.Component) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    when (val choice = value.`value`) {
      null -> {}
      is Observation.Component.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
      }
      is Observation.Component.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Observation.Component.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is Observation.Component.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is Observation.Component.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is Observation.Component.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 12, RangeSerializer, choice.value)
      }
      is Observation.Component.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 13, RatioSerializer, choice.value)
      }
      is Observation.Component.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          14,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Observation.Component.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          15,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is Observation.Component.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 17, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is Observation.Component.Value.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 19, PeriodSerializer, choice.value)
      }
      is Observation.Component.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          20,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Observation.Component.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          21,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22,
      CodeableConceptSerializer,
      value.dataAbsentReason,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23,
      CodeableConceptSerializer.listSerializer,
      value.interpretation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24,
      ObservationReferenceRangeSerializer.listSerializer,
      value.referenceRange,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ObservationSerializer : FhirResourceSerializer<Observation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Observation")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("instantiatesCanonical")
    b.optionalElement("instantiatesReference", ReferenceSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("triggeredBy", ObservationTriggeredBySerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.strPrim("effectiveDateTime")
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("effectiveTiming", TimingSerializer.descriptor)
    b.strPrim("effectiveInstant")
    b.strPrim("issued")
    b.optionalElement("performer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.strPrim("valueString")
    b.boolPrim("valueBoolean")
    b.intPrim("valueInteger")
    b.optionalElement("valueRange", RangeSerializer.descriptor)
    b.optionalElement("valueRatio", RatioSerializer.descriptor)
    b.optionalElement("valueSampledData", SampledDataSerializer.descriptor)
    b.prim("valueTime", LocalTimeSerializer.descriptor)
    b.strPrim("valueDateTime")
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
    compositeDecoder: CompositeDecoder,
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
    var status: ObservationStatus? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var focus: List<Reference>? = null
    var encounter: Reference? = null
    var effectiveDateTime: FhirDateTime? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var effectiveTiming: Timing? = null
    var effectiveInstant: FhirDateTime? = null
    var _effectiveInstant: Element? = null
    var issued: FhirDateTime? = null
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
    var valueDateTime: FhirDateTime? = null
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
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> instantiatesCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          instantiatesReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        14 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          triggeredBy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationTriggeredBySerializer.listSerializer,
              null,
            )
        16 ->
          partOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          status = ObservationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          focus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          effectiveDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        25 ->
          _effectiveDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        27 ->
          effectiveTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        28 ->
          effectiveInstant =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        29 ->
          _effectiveInstant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> issued = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        31 ->
          _issued =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        34 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        35 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        38 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        40 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        42 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        43 ->
          valueSampledData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SampledDataSerializer,
              null,
            )
        44 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        45 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        46 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        47 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        48 ->
          valuePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        49 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        50 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        51 ->
          dataAbsentReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        52 ->
          interpretation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        53 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        54 ->
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        55 ->
          bodyStructure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        56 ->
          method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        57 ->
          specimen =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        58 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        59 ->
          referenceRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationReferenceRangeSerializer.listSerializer,
              null,
            )
        60 ->
          hasMember =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        61 ->
          derivedFrom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        62 ->
          component =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ObservationComponentSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Observation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      instantiates =
        Observation.Instantiates.from(
          Canonical.of(instantiatesCanonical, _instantiatesCanonical),
          instantiatesReference,
        ),
      basedOn = listOrEmpty(basedOn),
      triggeredBy = listOrEmpty(triggeredBy),
      partOf = listOrEmpty(partOf),
      status = required(Enumeration.of(status, _status), "Observation", "status"),
      category = listOrEmpty(category),
      code = required(code, "Observation", "code"),
      subject = subject,
      focus = listOrEmpty(focus),
      encounter = encounter,
      effective =
        Observation.Effective.from(
          DateTime.of(effectiveDateTime, _effectiveDateTime),
          effectivePeriod,
          effectiveTiming,
          Instant.of(effectiveInstant, _effectiveInstant),
        ),
      issued = Instant.of(issued, _issued),
      performer = listOrEmpty(performer),
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
          DateTime.of(valueDateTime, _valueDateTime),
          valuePeriod,
          valueAttachment,
          valueReference,
        ),
      dataAbsentReason = dataAbsentReason,
      interpretation = listOrEmpty(interpretation),
      note = listOrEmpty(note),
      bodySite = bodySite,
      bodyStructure = bodyStructure,
      method = method,
      specimen = specimen,
      device = device,
      referenceRange = listOrEmpty(referenceRange),
      hasMember = listOrEmpty(hasMember),
      derivedFrom = listOrEmpty(derivedFrom),
      component = listOrEmpty(component),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Observation,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    when (val choice = value.instantiates) {
      null -> {}
      is Observation.Instantiates.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          11 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, choice.value)
      }
      is Observation.Instantiates.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          13 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.basedOn,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      ObservationTriggeredBySerializer.listSerializer,
      value.triggeredBy,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.partOf,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.status)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.focus,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.effective) {
      null -> {}
      is Observation.Effective.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          24 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, choice.value)
      }
      is Observation.Effective.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is Observation.Effective.Timing -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          27 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
      is Observation.Effective.Instant -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          28 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.issued?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.issued)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.performer,
    )
    when (val choice = value.`value`) {
      null -> {}
      is Observation.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          33 + descriptorOffset,
          QuantitySerializer,
          choice.value,
        )
      }
      is Observation.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          34 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Observation.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          35 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, choice.value)
      }
      is Observation.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(
          descriptor,
          37 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, choice.value)
      }
      is Observation.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 39 + descriptorOffset, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, choice.value)
      }
      is Observation.Value.Range -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is Observation.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          42 + descriptorOffset,
          RatioSerializer,
          choice.value,
        )
      }
      is Observation.Value.SampledData -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          43 + descriptorOffset,
          SampledDataSerializer,
          choice.value,
        )
      }
      is Observation.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          44 + descriptorOffset,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, choice.value)
      }
      is Observation.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          46 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, choice.value)
      }
      is Observation.Value.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          48 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is Observation.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          49 + descriptorOffset,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Observation.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          50 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      CodeableConceptSerializer,
      value.dataAbsentReason,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      52 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.interpretation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      53 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      54 + descriptorOffset,
      CodeableConceptSerializer,
      value.bodySite,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      55 + descriptorOffset,
      ReferenceSerializer,
      value.bodyStructure,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      56 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      57 + descriptorOffset,
      ReferenceSerializer,
      value.specimen,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      58 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      59 + descriptorOffset,
      ObservationReferenceRangeSerializer.listSerializer,
      value.referenceRange,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      60 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.hasMember,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      61 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.derivedFrom,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      62 + descriptorOffset,
      ObservationComponentSerializer.listSerializer,
      value.component,
    )
  }
}
