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

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DeviceMetric
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
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

internal object DeviceMetricCalibrationSerializer : KSerializer<DeviceMetric.Calibration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Calibration") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("type", String.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("state", String.serializer().descriptor, isOptional = true)
      element("_state", Element.serializer().descriptor, isOptional = true)
      element("time", String.serializer().descriptor, isOptional = true)
      element("_time", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceMetric.Calibration =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceMetric.Calibration) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceMetric.Calibration {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: String? = null
    var _type: Element? = null
    var state: String? = null
    var _state: Element? = null
    var time: String? = null
    var _time: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, __i)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 -> state = decoder.decodeStringElement(__desc, __i)
        6 -> _state = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        7 -> time = decoder.decodeStringElement(__desc, __i)
        8 -> _time = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Calibration: " + __i)
      }
    }
    return DeviceMetric.Calibration(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type?.let { Enumeration.of(DeviceMetric.DeviceMetricCalibrationType.fromCode(it), _type) },
      state =
        state?.let {
          Enumeration.of(DeviceMetric.DeviceMetricCalibrationState.fromCode(it), _state)
        },
      time = Instant.of(FhirDateTime.fromString(time), _time),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceMetric.Calibration) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    ((value.state?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.state?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceMetricSerializer : KSerializer<DeviceMetric> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceMetric") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("unit", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("source", Reference.serializer().descriptor, isOptional = true)
    b.element("parent", Reference.serializer().descriptor, isOptional = true)
    b.element("operationalStatus", String.serializer().descriptor, isOptional = true)
    b.element("_operationalStatus", Element.serializer().descriptor, isOptional = true)
    b.element("color", String.serializer().descriptor, isOptional = true)
    b.element("_color", Element.serializer().descriptor, isOptional = true)
    b.element("category", String.serializer().descriptor, isOptional = true)
    b.element("_category", Element.serializer().descriptor, isOptional = true)
    b.element("measurementPeriod", Timing.serializer().descriptor, isOptional = true)
    b.element(
      "calibration",
      listSerialDescriptor(lazyDescriptor { DeviceMetric.Calibration.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): DeviceMetric =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: DeviceMetric) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DeviceMetric")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): DeviceMetric {
    val __desc = desc
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var type: CodeableConcept? = null
    var unit: CodeableConcept? = null
    var source: Reference? = null
    var parent: Reference? = null
    var operationalStatus: String? = null
    var _operationalStatus: Element? = null
    var color: String? = null
    var _color: Element? = null
    var category: String? = null
    var _category: Element? = null
    var measurementPeriod: Timing? = null
    var calibration: List<DeviceMetric.Calibration>? = null
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
        11 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        12 -> unit = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        13 ->
          source = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        14 ->
          parent = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sourceSer, null)
        15 -> operationalStatus = decoder.decodeStringElement(__desc, __i)
        16 ->
          _operationalStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 -> color = decoder.decodeStringElement(__desc, __i)
        18 ->
          _color =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> category = decoder.decodeStringElement(__desc, __i)
        20 ->
          _category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 ->
          measurementPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.measurementPeriodSer,
              null,
            )
        22 ->
          calibration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.calibrationSer, null)
        else -> throw SerializationException("Unexpected index decoding DeviceMetric: " + __i)
      }
    }
    return DeviceMetric(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type = type!!,
      unit = unit,
      source = source,
      parent = parent,
      operationalStatus =
        operationalStatus?.let {
          Enumeration.of(
            DeviceMetric.DeviceMetricOperationalStatus.fromCode(it),
            _operationalStatus,
          )
        },
      color = color?.let { Enumeration.of(DeviceMetric.DeviceMetricColor.fromCode(it), _color) },
      category = Enumeration.of(DeviceMetric.DeviceMetricCategory.fromCode(category!!), _category),
      measurementPeriod = measurementPeriod,
      calibration = calibration ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: DeviceMetric,
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
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.typeSer, it) }
    (value.unit)?.let { encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.typeSer, it) }
    (value.source)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.sourceSer, it)
    }
    (value.parent)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.sourceSer, it)
    }
    ((value.operationalStatus?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 15 + __off, it)
    }
    (value.operationalStatus?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.color?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.color?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.category.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.category.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.measurementPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.measurementPeriodSer, it)
    }
    if (value.calibration.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22 + __off,
        Hoisted.calibrationSer,
        value.calibration,
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sourceSer: KSerializer<Reference> = Reference.serializer()

    public val measurementPeriodSer: KSerializer<Timing> = Timing.serializer()

    public val calibrationSerInner: KSerializer<DeviceMetric.Calibration> =
      DeviceMetric.Calibration.serializer()

    public val calibrationSer: KSerializer<List<DeviceMetric.Calibration>> =
      ListSerializer(Hoisted.calibrationSerInner)
  }
}

internal object DeviceMetricPolymorphicSerializer : KSerializer<DeviceMetric> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceMetric") { DeviceMetricSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceMetric) {
    encoder.encodeStructure(descriptor) {
      DeviceMetricSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DeviceMetric =
    decoder.decodeStructure(descriptor) {
      DeviceMetricSerializer.deserializeJson(this, descriptor, 0)
    }
}
