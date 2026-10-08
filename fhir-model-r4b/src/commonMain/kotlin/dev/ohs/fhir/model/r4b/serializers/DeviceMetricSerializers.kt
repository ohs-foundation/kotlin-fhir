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

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DeviceMetric
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.DeviceMetricCalibrationState
import dev.ohs.fhir.model.r4b.terminologies.DeviceMetricCalibrationType
import dev.ohs.fhir.model.r4b.terminologies.DeviceMetricCategory
import dev.ohs.fhir.model.r4b.terminologies.DeviceMetricColor
import dev.ohs.fhir.model.r4b.terminologies.DeviceMetricOperationalStatus
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object DeviceMetricCalibrationSerializer : KSerializer<DeviceMetric.Calibration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Calibration") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", String.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("state", String.serializer().descriptor)
      optionalElement("_state", ElementSerializer.descriptor)
      optionalElement("time", String.serializer().descriptor)
      optionalElement("_time", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DeviceMetric.Calibration>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DeviceMetric.Calibration {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> state = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _state =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> time = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _time =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Calibration: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DeviceMetric.Calibration(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          if (type != null) DeviceMetricCalibrationType.fromCode(type) else null,
          _type,
        ),
      state =
        Enumeration.of(
          if (state != null) DeviceMetricCalibrationState.fromCode(state) else null,
          _state,
        ),
      time = Instant.of(if (time != null) FhirDateTime.fromString(time) else null, _time),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DeviceMetric.Calibration) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.state?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.state)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.time?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.time)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DeviceMetricSerializer : FhirResourceSerializer<DeviceMetric> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("DeviceMetric")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("unit", CodeableConceptSerializer.descriptor)
    b.optionalElement("source", ReferenceSerializer.descriptor)
    b.optionalElement("parent", ReferenceSerializer.descriptor)
    b.optionalElement("operationalStatus", String.serializer().descriptor)
    b.optionalElement("_operationalStatus", ElementSerializer.descriptor)
    b.optionalElement("color", String.serializer().descriptor)
    b.optionalElement("_color", ElementSerializer.descriptor)
    b.optionalElement("category", String.serializer().descriptor)
    b.optionalElement("_category", ElementSerializer.descriptor)
    b.optionalElement("measurementPeriod", TimingSerializer.descriptor)
    b.optionalElement("calibration", DeviceMetricCalibrationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): DeviceMetric {
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
        11 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          unit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        14 ->
          parent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        15 -> operationalStatus = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _operationalStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> color = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _color =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> category = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          measurementPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        22 ->
          calibration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DeviceMetricCalibrationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding DeviceMetric: " + i)
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
      type =
        type ?: throw SerializationException("Missing required property 'type' on DeviceMetric"),
      unit = unit,
      source = source,
      parent = parent,
      operationalStatus =
        Enumeration.of(
          if (operationalStatus != null) DeviceMetricOperationalStatus.fromCode(operationalStatus)
          else null,
          _operationalStatus,
        ),
      color =
        Enumeration.of(if (color != null) DeviceMetricColor.fromCode(color) else null, _color),
      category =
        Enumeration.of(
          if (category != null) DeviceMetricCategory.fromCode(category) else null,
          _category,
        ) ?: throw SerializationException("Missing required property 'category' on DeviceMetric"),
      measurementPeriod = measurementPeriod,
      calibration = calibration ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DeviceMetric,
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
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.unit,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.source,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.parent,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.operationalStatus?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.operationalStatus,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.color?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.color)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.category.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.category)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      TimingSerializer,
      value.measurementPeriod,
    )
    if (value.calibration.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        DeviceMetricCalibrationSerializer.listSerializer,
        value.calibration,
      )
  }
}
