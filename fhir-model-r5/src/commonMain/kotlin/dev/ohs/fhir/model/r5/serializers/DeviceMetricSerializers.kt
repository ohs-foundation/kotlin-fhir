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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DeviceMetric
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

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

  override fun deserialize(decoder: Decoder): DeviceMetric.Calibration =
    decoder.decodeStructure(descriptor) {
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> state = decodeStringElement(descriptor, i)
          6 -> _state = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> time = decodeStringElement(descriptor, i)
          8 -> _time = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Calibration: " + i)
        }
      }
      DeviceMetric.Calibration(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) DeviceMetric.DeviceMetricCalibrationType.fromCode(type) else null,
            _type,
          ),
        state =
          Enumeration.of(
            if (state != null) DeviceMetric.DeviceMetricCalibrationState.fromCode(state) else null,
            _state,
          ),
        time = Instant.of(if (time != null) FhirDateTime.fromString(time) else null, _time),
      )
    }

  override fun serialize(encoder: Encoder, `value`: DeviceMetric.Calibration) {
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
      encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.state?.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.state)
      encodeStringIfNotNull(descriptor, 7, value.time?.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.time)
    }
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
    b.optionalElement("device", ReferenceSerializer.descriptor)
    b.optionalElement("operationalStatus", String.serializer().descriptor)
    b.optionalElement("_operationalStatus", ElementSerializer.descriptor)
    b.optionalElement("color", String.serializer().descriptor)
    b.optionalElement("_color", ElementSerializer.descriptor)
    b.optionalElement("category", String.serializer().descriptor)
    b.optionalElement("_category", ElementSerializer.descriptor)
    b.optionalElement("measurementFrequency", QuantitySerializer.descriptor)
    b.optionalElement("calibration", DeviceMetricCalibrationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
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
    var device: Reference? = null
    var operationalStatus: String? = null
    var _operationalStatus: Element? = null
    var color: String? = null
    var _color: Element? = null
    var category: String? = null
    var _category: Element? = null
    var measurementFrequency: Quantity? = null
    var calibration: List<DeviceMetric.Calibration>? = null
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
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          unit =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        14 -> operationalStatus = decoder.decodeStringElement(descriptor, i)
        15 ->
          _operationalStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> color = decoder.decodeStringElement(descriptor, i)
        17 ->
          _color = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> category = decoder.decodeStringElement(descriptor, i)
        19 ->
          _category =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          measurementFrequency =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        21 ->
          calibration =
            decoder.decodeNullableSerializableElement(
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
      device =
        device
          ?: throw SerializationException("Missing required property 'device' on DeviceMetric"),
      operationalStatus =
        Enumeration.of(
          if (operationalStatus != null)
            DeviceMetric.DeviceMetricOperationalStatus.fromCode(operationalStatus)
          else null,
          _operationalStatus,
        ),
      color = Code.of(color, _color),
      category =
        Enumeration.of(
          if (category != null) DeviceMetric.DeviceMetricCategory.fromCode(category) else null,
          _category,
        ) ?: throw SerializationException("Missing required property 'category' on DeviceMetric"),
      measurementFrequency = measurementFrequency,
      calibration = calibration ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DeviceMetric,
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
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.unit,
    )
    encoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.operationalStatus?.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.operationalStatus)
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.color?.value)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.color)
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.category.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.category)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      QuantitySerializer,
      value.measurementFrequency,
    )
    if (value.calibration.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        DeviceMetricCalibrationSerializer.listSerializer,
        value.calibration,
      )
  }
}
