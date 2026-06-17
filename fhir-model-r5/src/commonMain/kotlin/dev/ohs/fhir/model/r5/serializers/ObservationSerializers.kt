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
      element("observation", Reference.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("reason", KotlinString.serializer().descriptor, isOptional = true)
      element("_reason", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Observation.TriggeredBy =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Observation.TriggeredBy) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Observation.TriggeredBy {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var observation: Reference? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var reason: KotlinString? = null
    var _reason: Element? = null
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
          observation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.observationSer, null)
        4 -> type = decoder.decodeStringElement(descriptor, i)
        5 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> reason = decoder.decodeStringElement(descriptor, i)
        7 ->
          _reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TriggeredBy: " + i)
      }
    }
    return Observation.TriggeredBy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      observation = observation!!,
      type = Enumeration.of(Observation.TriggeredBytype.fromCode(type!!), _type),
      reason = R5String.of(reason, _reason),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Observation.TriggeredBy) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.observationSer, value.observation)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it)
    }
    ((value.reason?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.reason?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val observationSer: KSerializer<Reference> = Reference.serializer()

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ObservationReferenceRangeSerializer : KSerializer<Observation.ReferenceRange> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceRange") {
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
      element("low", Quantity.serializer().descriptor, isOptional = true)
      element("high", Quantity.serializer().descriptor, isOptional = true)
      element("normalValue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "appliesTo",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("age", Range.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Observation.ReferenceRange =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Observation.ReferenceRange) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Observation.ReferenceRange {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> low = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lowSer, null)
        4 -> high = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lowSer, null)
        5 ->
          normalValue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.normalValueSer, null)
        6 ->
          type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.normalValueSer, null)
        7 ->
          appliesTo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.appliesToSer, null)
        8 -> age = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ageSer, null)
        9 -> text = decoder.decodeStringElement(descriptor, i)
        10 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceRange: " + i)
      }
    }
    return Observation.ReferenceRange(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Observation.ReferenceRange) {
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
    (value.low)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.lowSer, it) }
    (value.high)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.lowSer, it) }
    (value.normalValue)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.normalValueSer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.normalValueSer, it)
    }
    if (value.appliesTo.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.appliesToSer, value.appliesTo)
    (value.age)?.let { encoder.encodeSerializableElement(descriptor, 8, Hoisted.ageSer, it) }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.textSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val lowSer: KSerializer<Quantity> = Quantity.serializer()

    public val normalValueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val appliesToSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.normalValueSer)

    public val ageSer: KSerializer<Range> = Range.serializer()

    public val textSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ObservationComponentSerializer : KSerializer<Observation.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
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
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("valueSampledData", SampledData.serializer().descriptor, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valuePeriod", Period.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("dataAbsentReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "interpretation",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "referenceRange",
        listSerialDescriptor(lazyDescriptor { Observation.ReferenceRange.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Observation.Component =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Observation.Component) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Observation.Component {
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
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 -> valueString = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        10 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        12 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        13 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        14 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSampledDataSer,
              null,
            )
        15 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        16 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        17 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        19 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuePeriodSer, null)
        20 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        21 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        22 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        23 ->
          interpretation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.interpretationSer,
              null,
            )
        24 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referenceRangeSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + i)
      }
    }
    return Observation.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
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
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          valuePeriod,
          valueAttachment,
          valueReference,
        ),
      dataAbsentReason = dataAbsentReason,
      interpretation = interpretation ?: listOf(),
      referenceRange = referenceRange ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Observation.Component) {
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
    when (val choice = value.`value`) {
      null -> {}
      is Observation.Component.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueQuantitySer, choice.value)
      }
      is Observation.Component.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, choice.value)
      }
      is Observation.Component.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueRangeSer, choice.value)
      }
      is Observation.Component.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 13, Hoisted.valueRatioSer, choice.value)
      }
      is Observation.Component.Value.SampledData -> {
        encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueSampledDataSer, choice.value)
      }
      is Observation.Component.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 15, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.Period -> {
        encoder.encodeSerializableElement(descriptor, 19, Hoisted.valuePeriodSer, choice.value)
      }
      is Observation.Component.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 20, Hoisted.valueAttachmentSer, choice.value)
      }
      is Observation.Component.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 21, Hoisted.valueReferenceSer, choice.value)
      }
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.codeSer, it)
    }
    if (value.interpretation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23,
        Hoisted.interpretationSer,
        value.interpretation,
      )
    if (value.referenceRange.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24,
        Hoisted.referenceRangeSer,
        value.referenceRange,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueStringSer: KSerializer<Element> = Element.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val interpretationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.codeSer)

    public val referenceRangeSerInner: KSerializer<Observation.ReferenceRange> =
      Observation.ReferenceRange.serializer()

    public val referenceRangeSer: KSerializer<List<Observation.ReferenceRange>> =
      ListSerializer(Hoisted.referenceRangeSerInner)
  }
}

internal object ObservationSerializer : KSerializer<Observation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Observation") {
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
    b.element("instantiatesCanonical", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_instantiatesCanonical", Element.serializer().descriptor, isOptional = true)
    b.element("instantiatesReference", Reference.serializer().descriptor, isOptional = true)
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "triggeredBy",
      listSerialDescriptor(lazyDescriptor { Observation.TriggeredBy.serializer().descriptor }),
      isOptional = true,
    )
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("effectiveTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("effectiveInstant", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_effectiveInstant", Element.serializer().descriptor, isOptional = true)
    b.element("issued", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_issued", Element.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
    b.element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("valueString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_valueString", Element.serializer().descriptor, isOptional = true)
    b.element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
    b.element("valueInteger", Int.serializer().descriptor, isOptional = true)
    b.element("_valueInteger", Element.serializer().descriptor, isOptional = true)
    b.element("valueRange", Range.serializer().descriptor, isOptional = true)
    b.element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
    b.element("valueSampledData", SampledData.serializer().descriptor, isOptional = true)
    b.element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
    b.element("_valueTime", Element.serializer().descriptor, isOptional = true)
    b.element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("valuePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    b.element("valueReference", Reference.serializer().descriptor, isOptional = true)
    b.element("dataAbsentReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "interpretation",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("bodyStructure", Reference.serializer().descriptor, isOptional = true)
    b.element("method", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("specimen", Reference.serializer().descriptor, isOptional = true)
    b.element("device", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "referenceRange",
      listSerialDescriptor(lazyDescriptor { Observation.ReferenceRange.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "hasMember",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "derivedFrom",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "component",
      listSerialDescriptor(lazyDescriptor { Observation.Component.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Observation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Observation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Observation")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> instantiatesCanonical = decoder.decodeStringElement(descriptor, i)
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          instantiatesReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        14 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        15 ->
          triggeredBy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.triggeredBySer, null)
        16 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        17 -> status = decoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        20 ->
          code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        21 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        22 ->
          focus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        23 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        24 -> effectiveDateTime = decoder.decodeStringElement(descriptor, i)
        25 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        27 ->
          effectiveTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectiveTimingSer,
              null,
            )
        28 -> effectiveInstant = decoder.decodeStringElement(descriptor, i)
        29 ->
          _effectiveInstant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 -> issued = decoder.decodeStringElement(descriptor, i)
        31 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        33 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        34 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        35 -> valueString = decoder.decodeStringElement(descriptor, i)
        36 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        38 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        40 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        42 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRatioSer, null)
        43 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueSampledDataSer,
              null,
            )
        44 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        45 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        46 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        47 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        48 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        49 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        50 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        51 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        52 ->
          interpretation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        53 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        54 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        55 ->
          bodyStructure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        56 ->
          method =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        57 ->
          specimen =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        58 ->
          device =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        59 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referenceRangeSer,
              null,
            )
        60 ->
          hasMember =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        61 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        62 ->
          component =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentSer, null)
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
      status = Enumeration.of(Observation.ObservationStatus.fromCode(status!!), _status),
      category = category ?: listOf(),
      code = code!!,
      subject = subject,
      focus = focus ?: listOf(),
      encounter = encounter,
      effective =
        Observation.Effective.from(
          DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
          effectivePeriod,
          effectiveTiming,
          Instant.of(FhirDateTime.fromString(effectiveInstant), _effectiveInstant),
        ),
      issued = Instant.of(FhirDateTime.fromString(issued), _issued),
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
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Observation,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    when (val choice = value.instantiates) {
      null -> {}
      is Observation.Instantiates.Canonical -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            12 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Observation.Instantiates.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          13 + descriptorOffset,
          Hoisted.instantiatesReferenceSer,
          choice.value,
        )
      }
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    if (value.triggeredBy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.triggeredBySer,
        value.triggeredBy,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.basedOnSer,
        value.partOf,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      20 + descriptorOffset,
      Hoisted.categorySerInner,
      value.code,
    )
    (value.subject)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.instantiatesReferenceSer,
        it,
      )
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.basedOnSer,
        value.focus,
      )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.instantiatesReferenceSer,
        it,
      )
    }
    when (val choice = value.effective) {
      null -> {}
      is Observation.Effective.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            25 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Observation.Effective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          Hoisted.effectivePeriodSer,
          choice.value,
        )
      }
      is Observation.Effective.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          27 + descriptorOffset,
          Hoisted.effectiveTimingSer,
          choice.value,
        )
      }
      is Observation.Effective.Instant -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            29 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.issued?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.basedOnSer,
        value.performer,
      )
    when (val choice = value.`value`) {
      null -> {}
      is Observation.Value.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          33 + descriptorOffset,
          Hoisted.valueQuantitySer,
          choice.value,
        )
      }
      is Observation.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          34 + descriptorOffset,
          Hoisted.categorySerInner,
          choice.value,
        )
      }
      is Observation.Value.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            36 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Observation.Value.Boolean -> {
        ((choice.value.value))?.let {
          encoder.encodeBooleanElement(descriptor, 37 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            38 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Observation.Value.Integer -> {
        ((choice.value.value))?.let {
          encoder.encodeIntElement(descriptor, 39 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            40 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Observation.Value.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          Hoisted.valueRangeSer,
          choice.value,
        )
      }
      is Observation.Value.Ratio -> {
        encoder.encodeSerializableElement(
          descriptor,
          42 + descriptorOffset,
          Hoisted.valueRatioSer,
          choice.value,
        )
      }
      is Observation.Value.SampledData -> {
        encoder.encodeSerializableElement(
          descriptor,
          43 + descriptorOffset,
          Hoisted.valueSampledDataSer,
          choice.value,
        )
      }
      is Observation.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(
            descriptor,
            44 + descriptorOffset,
            LocalTimeSerializer,
            it,
          )
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            45 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Observation.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 46 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            47 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Observation.Value.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          48 + descriptorOffset,
          Hoisted.effectivePeriodSer,
          choice.value,
        )
      }
      is Observation.Value.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          49 + descriptorOffset,
          Hoisted.valueAttachmentSer,
          choice.value,
        )
      }
      is Observation.Value.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          50 + descriptorOffset,
          Hoisted.instantiatesReferenceSer,
          choice.value,
        )
      }
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    if (value.interpretation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.categorySer,
        value.interpretation,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    (value.bodyStructure)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.instantiatesReferenceSer,
        it,
      )
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    (value.specimen)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.instantiatesReferenceSer,
        it,
      )
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        Hoisted.instantiatesReferenceSer,
        it,
      )
    }
    if (value.referenceRange.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        Hoisted.referenceRangeSer,
        value.referenceRange,
      )
    if (value.hasMember.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        Hoisted.basedOnSer,
        value.hasMember,
      )
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        61 + descriptorOffset,
        Hoisted.basedOnSer,
        value.derivedFrom,
      )
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        62 + descriptorOffset,
        Hoisted.componentSer,
        value.component,
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

    public val instantiatesReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.instantiatesReferenceSer)

    public val triggeredBySerInner: KSerializer<Observation.TriggeredBy> =
      Observation.TriggeredBy.serializer()

    public val triggeredBySer: KSerializer<List<Observation.TriggeredBy>> =
      ListSerializer(Hoisted.triggeredBySerInner)

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val effectiveTimingSer: KSerializer<Timing> = Timing.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val referenceRangeSerInner: KSerializer<Observation.ReferenceRange> =
      Observation.ReferenceRange.serializer()

    public val referenceRangeSer: KSerializer<List<Observation.ReferenceRange>> =
      ListSerializer(Hoisted.referenceRangeSerInner)

    public val componentSerInner: KSerializer<Observation.Component> =
      Observation.Component.serializer()

    public val componentSer: KSerializer<List<Observation.Component>> =
      ListSerializer(Hoisted.componentSerInner)
  }
}

internal object ObservationPolymorphicSerializer : KSerializer<Observation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Observation") { ObservationSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Observation) {
    encoder.encodeStructure(descriptor) {
      ObservationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Observation =
    decoder.decodeStructure(descriptor) {
      ObservationSerializer.deserializeInternal(this, descriptor, 0)
    }
}
