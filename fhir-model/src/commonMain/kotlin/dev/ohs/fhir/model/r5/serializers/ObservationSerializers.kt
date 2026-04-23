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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Observation.TriggeredBy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Observation.TriggeredBy {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var observation: Reference? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var reason: KotlinString? = null
    var _reason: Element? = null
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
          observation =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.observationSer, null)
        4 -> type = decoder.decodeStringElement(__desc, 4)
        5 -> _type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> reason = decoder.decodeStringElement(__desc, 6)
        7 -> _reason = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TriggeredBy: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Observation.TriggeredBy) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.observation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.observationSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it)
    }
    ((value.reason?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.reason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Observation.ReferenceRange) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Observation.ReferenceRange {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> low = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.lowSer, null)
        4 -> high = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.lowSer, null)
        5 ->
          normalValue =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.normalValueSer, null)
        6 ->
          type = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.normalValueSer, null)
        7 ->
          appliesTo =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.appliesToSer, null)
        8 -> age = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.ageSer, null)
        9 -> text = decoder.decodeStringElement(__desc, 9)
        10 -> _text = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.textSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceRange: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Observation.ReferenceRange) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.low)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.lowSer, it) }
    (value.high)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.lowSer, it) }
    (value.normalValue)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.normalValueSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.normalValueSer, it) }
    if (value.appliesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.appliesToSer, value.appliesTo)
    (value.age)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.ageSer, it) }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.textSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Observation.Component) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Observation.Component {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueQuantitySer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 -> valueString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueStringSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueStringSer, null)
        10 -> valueInteger = decoder.decodeIntElement(__desc, 10)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueStringSer, null)
        12 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueRangeSer, null)
        13 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.valueRatioSer, null)
        14 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.valueSampledDataSer, null)
        15 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 15, LocalTimeSerializer, null)
        16 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueStringSer, null)
        17 -> valueDateTime = decoder.decodeStringElement(__desc, 17)
        18 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.valueStringSer, null)
        19 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.valuePeriodSer, null)
        20 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.valueAttachmentSer, null)
        21 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.valueReferenceSer, null)
        22 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.codeSer, null)
        23 ->
          interpretation =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.interpretationSer, null)
        24 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.referenceRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Observation.Component) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is Observation.Component.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.valueQuantitySer, __d.value)
      }
      is Observation.Component.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, __d.value)
      }
      is Observation.Component.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valueRangeSer, __d.value)
      }
      is Observation.Component.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 13, Hoisted.valueRatioSer, __d.value)
      }
      is Observation.Component.Value.SampledData -> {
        encoder.encodeSerializableElement(__desc, 14, Hoisted.valueSampledDataSer, __d.value)
      }
      is Observation.Component.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 15, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.valueStringSer, it)
        }
      }
      is Observation.Component.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.valuePeriodSer, __d.value)
      }
      is Observation.Component.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.valueAttachmentSer, __d.value)
      }
      is Observation.Component.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.valueReferenceSer, __d.value)
      }
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.codeSer, it)
    }
    if (value.interpretation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.interpretationSer, value.interpretation)
    if (value.referenceRange.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.referenceRangeSer, value.referenceRange)
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

internal object ObservationInstantiatesSerializer : KSerializer<Observation.Instantiates> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Observation.Instantiates") {
      element("instantiatesCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_instantiatesCanonical", Element.serializer().descriptor, isOptional = true)
      element("instantiatesReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Observation.Instantiates) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Observation.Instantiates.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Observation.Instantiates.Reference -> {
          encodeSerializableElement(__desc, 2, Hoisted.instantiatesReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Observation.Instantiates =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Observation.Instantiates {
    val __desc = descriptor
    var instantiatesCanonical: KotlinString? = null
    var _instantiatesCanonical: Element? = null
    var instantiatesReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> instantiatesCanonical = decoder.decodeStringElement(__desc, 0)
        1 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          instantiatesReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              2,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding Observation.Instantiates: " + __i)
      }
    }
    return Observation.Instantiates.from(
      Canonical.of(instantiatesCanonical, _instantiatesCanonical),
      instantiatesReference,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val instantiatesReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ObservationEffectiveSerializer : KSerializer<Observation.Effective> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Observation.Effective") {
      element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("effectiveTiming", Timing.serializer().descriptor, isOptional = true)
      element("effectiveInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveInstant", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Observation.Effective) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Observation.Effective.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Observation.Effective.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.effectivePeriodSer, __d.value)
        }
        is Observation.Effective.Timing -> {
          encodeSerializableElement(__desc, 3, Hoisted.effectiveTimingSer, __d.value)
        }
        is Observation.Effective.Instant -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Observation.Effective =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Observation.Effective {
    val __desc = descriptor
    var effectiveDateTime: KotlinString? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var effectiveTiming: Timing? = null
    var effectiveInstant: KotlinString? = null
    var _effectiveInstant: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> effectiveDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.effectivePeriodSer, null)
        3 ->
          effectiveTiming =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.effectiveTimingSer, null)
        4 -> effectiveInstant = decoder.decodeStringElement(__desc, 4)
        5 ->
          _effectiveInstant =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding Observation.Effective: " + __i)
      }
    }
    return Observation.Effective.from(
      DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
      effectivePeriod,
      effectiveTiming,
      Instant.of(FhirDateTime.fromString(effectiveInstant), _effectiveInstant),
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val effectiveTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object ObservationValueSerializer : KSerializer<Observation.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Observation.Value") {
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
    }

  override fun serialize(encoder: Encoder, `value`: Observation.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Observation.Value.Quantity -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueQuantitySer, __d.value)
        }
        is Observation.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 1, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is Observation.Value.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is Observation.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is Observation.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is Observation.Value.Range -> {
          encodeSerializableElement(__desc, 8, Hoisted.valueRangeSer, __d.value)
        }
        is Observation.Value.Ratio -> {
          encodeSerializableElement(__desc, 9, Hoisted.valueRatioSer, __d.value)
        }
        is Observation.Value.SampledData -> {
          encodeSerializableElement(__desc, 10, Hoisted.valueSampledDataSer, __d.value)
        }
        is Observation.Value.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 11, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 12, Hoisted.elementSer, it)
          }
        }
        is Observation.Value.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 13, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 14, Hoisted.elementSer, it)
          }
        }
        is Observation.Value.Period -> {
          encodeSerializableElement(__desc, 15, Hoisted.valuePeriodSer, __d.value)
        }
        is Observation.Value.Attachment -> {
          encodeSerializableElement(__desc, 16, Hoisted.valueAttachmentSer, __d.value)
        }
        is Observation.Value.Reference -> {
          encodeSerializableElement(__desc, 17, Hoisted.valueReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Observation.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Observation.Value {
    val __desc = descriptor
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.valueQuantitySer, null)
        1 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        2 -> valueString = decoder.decodeStringElement(__desc, 2)
        3 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> valueBoolean = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> valueInteger = decoder.decodeIntElement(__desc, 6)
        7 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueRangeSer, null)
        9 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueRatioSer, null)
        10 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueSampledDataSer, null)
        11 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 11, LocalTimeSerializer, null)
        12 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.elementSer, null)
        13 -> valueDateTime = decoder.decodeStringElement(__desc, 13)
        14 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.elementSer, null)
        15 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.valuePeriodSer, null)
        16 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueAttachmentSer, null)
        17 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.valueReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Observation.Value: " + __i)
      }
    }
    return Observation.Value.from(
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
    )!!
  }

  private object Hoisted {
    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ObservationComponentValueSerializer : KSerializer<Observation.Component.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Observation.Component.Value") {
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
    }

  override fun serialize(encoder: Encoder, `value`: Observation.Component.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Observation.Component.Value.Quantity -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueQuantitySer, __d.value)
        }
        is Observation.Component.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 1, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is Observation.Component.Value.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is Observation.Component.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is Observation.Component.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is Observation.Component.Value.Range -> {
          encodeSerializableElement(__desc, 8, Hoisted.valueRangeSer, __d.value)
        }
        is Observation.Component.Value.Ratio -> {
          encodeSerializableElement(__desc, 9, Hoisted.valueRatioSer, __d.value)
        }
        is Observation.Component.Value.SampledData -> {
          encodeSerializableElement(__desc, 10, Hoisted.valueSampledDataSer, __d.value)
        }
        is Observation.Component.Value.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 11, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 12, Hoisted.elementSer, it)
          }
        }
        is Observation.Component.Value.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 13, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 14, Hoisted.elementSer, it)
          }
        }
        is Observation.Component.Value.Period -> {
          encodeSerializableElement(__desc, 15, Hoisted.valuePeriodSer, __d.value)
        }
        is Observation.Component.Value.Attachment -> {
          encodeSerializableElement(__desc, 16, Hoisted.valueAttachmentSer, __d.value)
        }
        is Observation.Component.Value.Reference -> {
          encodeSerializableElement(__desc, 17, Hoisted.valueReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Observation.Component.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Observation.Component.Value {
    val __desc = descriptor
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.valueQuantitySer, null)
        1 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        2 -> valueString = decoder.decodeStringElement(__desc, 2)
        3 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> valueBoolean = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> valueInteger = decoder.decodeIntElement(__desc, 6)
        7 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueRangeSer, null)
        9 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueRatioSer, null)
        10 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueSampledDataSer, null)
        11 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 11, LocalTimeSerializer, null)
        12 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.elementSer, null)
        13 -> valueDateTime = decoder.decodeStringElement(__desc, 13)
        14 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.elementSer, null)
        15 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.valuePeriodSer, null)
        16 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueAttachmentSer, null)
        17 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.valueReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Observation.Component.Value: " + __i
          )
      }
    }
    return Observation.Component.Value.from(
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
    )!!
  }

  private object Hoisted {
    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

    public val valuePeriodSer: KSerializer<Period> = Period.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ObservationSerializer : KSerializer<Observation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Observation") {
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("instantiatesCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_instantiatesCanonical", Element.serializer().descriptor, isOptional = true)
      element("instantiatesReference", Reference.serializer().descriptor, isOptional = true)
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "triggeredBy",
        listSerialDescriptor(lazyDescriptor { Observation.TriggeredBy.serializer().descriptor }),
        isOptional = true,
      )
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("effectiveTiming", Timing.serializer().descriptor, isOptional = true)
      element("effectiveInstant", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveInstant", Element.serializer().descriptor, isOptional = true)
      element("issued", KotlinString.serializer().descriptor, isOptional = true)
      element("_issued", Element.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
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
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element("bodyStructure", Reference.serializer().descriptor, isOptional = true)
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
      element("specimen", Reference.serializer().descriptor, isOptional = true)
      element("device", Reference.serializer().descriptor, isOptional = true)
      element(
        "referenceRange",
        listSerialDescriptor(lazyDescriptor { Observation.ReferenceRange.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "hasMember",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "derivedFrom",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "component",
        listSerialDescriptor(lazyDescriptor { Observation.Component.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Observation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Observation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Observation {
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
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> instantiatesCanonical = decoder.decodeStringElement(__desc, 12)
        13 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          instantiatesReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        15 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.basedOnSer, null)
        16 ->
          triggeredBy =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.triggeredBySer, null)
        17 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSer, null)
        18 -> status = decoder.decodeStringElement(__desc, 18)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.categorySer, null)
        21 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.categorySerInner, null)
        22 ->
          subject =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        23 ->
          focus = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.basedOnSer, null)
        24 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              __desc,
              24,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        25 -> effectiveDateTime = decoder.decodeStringElement(__desc, 25)
        26 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.effectivePeriodSer, null)
        28 ->
          effectiveTiming =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.effectiveTimingSer, null)
        29 -> effectiveInstant = decoder.decodeStringElement(__desc, 29)
        30 ->
          _effectiveInstant =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> issued = decoder.decodeStringElement(__desc, 31)
        32 ->
          _issued =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.basedOnSer, null)
        34 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.valueQuantitySer, null)
        35 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.categorySerInner, null)
        36 -> valueString = decoder.decodeStringElement(__desc, 36)
        37 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> valueBoolean = decoder.decodeBooleanElement(__desc, 38)
        39 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> valueInteger = decoder.decodeIntElement(__desc, 40)
        41 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.valueRangeSer, null)
        43 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.valueRatioSer, null)
        44 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.valueSampledDataSer, null)
        45 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 45, LocalTimeSerializer, null)
        46 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.implicitRulesSer, null)
        47 -> valueDateTime = decoder.decodeStringElement(__desc, 47)
        48 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.implicitRulesSer, null)
        49 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.effectivePeriodSer, null)
        50 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.valueAttachmentSer, null)
        51 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              51,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        52 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.categorySerInner, null)
        53 ->
          interpretation =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.categorySer, null)
        54 -> note = decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.noteSer, null)
        55 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.categorySerInner, null)
        56 ->
          bodyStructure =
            decoder.decodeNullableSerializableElement(
              __desc,
              56,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        57 ->
          method =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.categorySerInner, null)
        58 ->
          specimen =
            decoder.decodeNullableSerializableElement(
              __desc,
              58,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        59 ->
          device =
            decoder.decodeNullableSerializableElement(
              __desc,
              59,
              Hoisted.instantiatesReferenceSer,
              null,
            )
        60 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.referenceRangeSer, null)
        61 ->
          hasMember =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.basedOnSer, null)
        62 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.basedOnSer, null)
        63 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, 63, Hoisted.componentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Observation: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Observation) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Observation")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    when (val __d = value.instantiates) {
      null -> {}
      is Observation.Instantiates.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Instantiates.Reference -> {
        encoder.encodeSerializableElement(__desc, 14, Hoisted.instantiatesReferenceSer, __d.value)
      }
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.basedOnSer, value.basedOn)
    if (value.triggeredBy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.triggeredBySer, value.triggeredBy)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.categorySer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.categorySerInner, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.instantiatesReferenceSer, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.basedOnSer, value.focus)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.instantiatesReferenceSer, it)
    }
    when (val __d = value.effective) {
      null -> {}
      is Observation.Effective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 25, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Effective.Period -> {
        encoder.encodeSerializableElement(__desc, 27, Hoisted.effectivePeriodSer, __d.value)
      }
      is Observation.Effective.Timing -> {
        encoder.encodeSerializableElement(__desc, 28, Hoisted.effectiveTimingSer, __d.value)
      }
      is Observation.Effective.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 29, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.basedOnSer, value.performer)
    when (val __d = value.`value`) {
      null -> {}
      is Observation.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 34, Hoisted.valueQuantitySer, __d.value)
      }
      is Observation.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 35, Hoisted.categorySerInner, __d.value)
      }
      is Observation.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 36, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 38, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 40, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 42, Hoisted.valueRangeSer, __d.value)
      }
      is Observation.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 43, Hoisted.valueRatioSer, __d.value)
      }
      is Observation.Value.SampledData -> {
        encoder.encodeSerializableElement(__desc, 44, Hoisted.valueSampledDataSer, __d.value)
      }
      is Observation.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 45, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 46, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 47, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 48, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 49, Hoisted.effectivePeriodSer, __d.value)
      }
      is Observation.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 50, Hoisted.valueAttachmentSer, __d.value)
      }
      is Observation.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 51, Hoisted.instantiatesReferenceSer, __d.value)
      }
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(__desc, 52, Hoisted.categorySerInner, it)
    }
    if (value.interpretation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.categorySer, value.interpretation)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54, Hoisted.noteSer, value.note)
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(__desc, 55, Hoisted.categorySerInner, it)
    }
    (value.bodyStructure)?.let {
      encoder.encodeSerializableElement(__desc, 56, Hoisted.instantiatesReferenceSer, it)
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(__desc, 57, Hoisted.categorySerInner, it)
    }
    (value.specimen)?.let {
      encoder.encodeSerializableElement(__desc, 58, Hoisted.instantiatesReferenceSer, it)
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(__desc, 59, Hoisted.instantiatesReferenceSer, it)
    }
    if (value.referenceRange.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 60, Hoisted.referenceRangeSer, value.referenceRange)
    if (value.hasMember.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 61, Hoisted.basedOnSer, value.hasMember)
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 62, Hoisted.basedOnSer, value.derivedFrom)
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 63, Hoisted.componentSer, value.component)
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
