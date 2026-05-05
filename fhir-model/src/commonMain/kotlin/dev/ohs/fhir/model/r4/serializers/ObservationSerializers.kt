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
import dev.ohs.fhir.model.r4.SampledData
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
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
    var type: CodeableConcept? = null
    var appliesTo: List<CodeableConcept>? = null
    var age: Range? = null
    var text: KotlinString? = null
    var _text: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> low = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lowSer, null)
        4 -> high = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lowSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 ->
          appliesTo =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.appliesToSer, null)
        7 -> age = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ageSer, null)
        8 -> text = decoder.decodeStringElement(__desc, __i)
        9 -> _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
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
      type = type,
      appliesTo = appliesTo ?: listOf(),
      age = age,
      text = R4String.of(text, _text),
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
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    if (value.appliesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.appliesToSer, value.appliesTo)
    (value.age)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.ageSer, it) }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.textSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val lowSer: KSerializer<Quantity> = Quantity.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val appliesToSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

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
    var dataAbsentReason: CodeableConcept? = null
    var interpretation: List<CodeableConcept>? = null
    var referenceRange: List<Observation.ReferenceRange>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        6 -> valueString = decoder.decodeStringElement(__desc, __i)
        7 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueStringSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueStringSer, null)
        10 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueStringSer, null)
        12 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        13 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioSer, null)
        14 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueSampledDataSer,
              null,
            )
        15 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        16 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueStringSer, null)
        17 -> valueDateTime = decoder.decodeStringElement(__desc, __i)
        18 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueStringSer, null)
        19 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valuePeriodSer, null)
        20 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        21 ->
          interpretation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.interpretationSer, null)
        22 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceRangeSer, null)
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
          R4String.of(valueString, _valueString),
          R4Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          valueRange,
          valueRatio,
          valueSampledData,
          Time.of(valueTime, _valueTime),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          valuePeriod,
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
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.codeSer, it)
    }
    if (value.interpretation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.interpretationSer, value.interpretation)
    if (value.referenceRange.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.referenceRangeSer, value.referenceRange)
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
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
    b.element("dataAbsentReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "interpretation",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Observation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Observation")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Observation {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        12 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(__desc, __i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        16 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        18 ->
          focus = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        20 -> effectiveDateTime = decoder.decodeStringElement(__desc, __i)
        21 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectivePeriodSer, null)
        23 ->
          effectiveTiming =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectiveTimingSer, null)
        24 -> effectiveInstant = decoder.decodeStringElement(__desc, __i)
        25 ->
          _effectiveInstant =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        26 -> issued = decoder.decodeStringElement(__desc, __i)
        27 ->
          _issued =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        29 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        30 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        31 -> valueString = decoder.decodeStringElement(__desc, __i)
        32 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        33 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        34 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        35 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        36 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        37 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRangeSer, null)
        38 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueRatioSer, null)
        39 ->
          valueSampledData =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.valueSampledDataSer,
              null,
            )
        40 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        41 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        42 -> valueDateTime = decoder.decodeStringElement(__desc, __i)
        43 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        44 ->
          valuePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectivePeriodSer, null)
        45 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        46 ->
          interpretation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        47 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        48 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        49 ->
          method =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        50 ->
          specimen =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        51 ->
          device =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        52 ->
          referenceRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceRangeSer, null)
        53 ->
          hasMember =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        54 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        55 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.componentSer, null)
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
      basedOn = basedOn ?: listOf(),
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
          R4String.of(valueString, _valueString),
          R4Boolean.of(valueBoolean, _valueBoolean),
          Integer.of(valueInteger, _valueInteger),
          valueRange,
          valueRatio,
          valueSampledData,
          Time.of(valueTime, _valueTime),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Observation,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.categorySer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.categorySerInner, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.basedOnSer, value.focus)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.effective) {
      null -> {}
      is Observation.Effective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Effective.Period -> {
        encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.effectivePeriodSer, __d.value)
      }
      is Observation.Effective.Timing -> {
        encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.effectiveTimingSer, __d.value)
      }
      is Observation.Effective.Instant -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26 + __off, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.basedOnSer, value.performer)
    when (val __d = value.`value`) {
      null -> {}
      is Observation.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.valueQuantitySer, __d.value)
      }
      is Observation.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.categorySerInner, __d.value)
      }
      is Observation.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 31 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 33 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 35 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.valueRangeSer, __d.value)
      }
      is Observation.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.valueRatioSer, __d.value)
      }
      is Observation.Value.SampledData -> {
        encoder.encodeSerializableElement(
          __desc,
          39 + __off,
          Hoisted.valueSampledDataSer,
          __d.value,
        )
      }
      is Observation.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 40 + __off, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 42 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Observation.Value.Period -> {
        encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.effectivePeriodSer, __d.value)
      }
    }
    (value.dataAbsentReason)?.let {
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.categorySerInner, it)
    }
    if (value.interpretation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        46 + __off,
        Hoisted.categorySer,
        value.interpretation,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.noteSer, value.note)
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(__desc, 48 + __off, Hoisted.categorySerInner, it)
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.categorySerInner, it)
    }
    (value.specimen)?.let {
      encoder.encodeSerializableElement(__desc, 50 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(__desc, 51 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.referenceRange.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        52 + __off,
        Hoisted.referenceRangeSer,
        value.referenceRange,
      )
    if (value.hasMember.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53 + __off, Hoisted.basedOnSer, value.hasMember)
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54 + __off, Hoisted.basedOnSer, value.derivedFrom)
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 55 + __off, Hoisted.componentSer, value.component)
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val effectiveTimingSer: KSerializer<Timing> = Timing.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueSampledDataSer: KSerializer<SampledData> = SampledData.serializer()

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
      ObservationSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Observation =
    decoder.decodeStructure(descriptor) {
      ObservationSerializer.deserializeJson(this, descriptor, 0)
    }
}
