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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DataRequirement
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.TriggerDefinition
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object TriggerDefinitionSerializer : KSerializer<TriggerDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TriggerDefinition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("subscriptionTopic", KotlinString.serializer().descriptor)
      optionalElement("_subscriptionTopic", ElementSerializer.descriptor)
      optionalElement("timingTiming", TimingSerializer.descriptor)
      optionalElement("timingReference", ReferenceSerializer.descriptor)
      optionalElement("timingDate", KotlinString.serializer().descriptor)
      optionalElement("_timingDate", ElementSerializer.descriptor)
      optionalElement("timingDateTime", KotlinString.serializer().descriptor)
      optionalElement("_timingDateTime", ElementSerializer.descriptor)
      optionalElement("data", DataRequirementSerializer.listSerializer.descriptor)
      optionalElement("condition", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TriggerDefinition>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TriggerDefinition =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var code: CodeableConcept? = null
      var subscriptionTopic: KotlinString? = null
      var _subscriptionTopic: Element? = null
      var timingTiming: Timing? = null
      var timingReference: Reference? = null
      var timingDate: KotlinString? = null
      var _timingDate: Element? = null
      var timingDateTime: KotlinString? = null
      var _timingDateTime: Element? = null
      var `data`: List<DataRequirement>? = null
      var condition: Expression? = null
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
          2 -> type = decodeStringElement(descriptor, i)
          3 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> name = decodeStringElement(descriptor, i)
          5 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> subscriptionTopic = decodeStringElement(descriptor, i)
          8 ->
            _subscriptionTopic =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            timingTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          10 ->
            timingReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          11 -> timingDate = decodeStringElement(descriptor, i)
          12 ->
            _timingDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> timingDateTime = decodeStringElement(descriptor, i)
          14 ->
            _timingDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            `data` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DataRequirementSerializer.listSerializer,
                null,
              )
          16 ->
            condition = decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TriggerDefinition: " + i)
        }
      }
      TriggerDefinition(
        id = id,
        extension = extension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) TriggerDefinition.TriggerType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on TriggerDefinition"
            ),
        name = R5String.of(name, _name),
        code = code,
        subscriptionTopic = Canonical.of(subscriptionTopic, _subscriptionTopic),
        timing =
          TriggerDefinition.Timing.from(
            timingTiming,
            timingReference,
            Date.of(if (timingDate != null) FhirDate.fromString(timingDate) else null, _timingDate),
            DateTime.of(
              if (timingDateTime != null) FhirDateTime.fromString(timingDateTime) else null,
              _timingDateTime,
            ),
          ),
        `data` = `data` ?: listOf(),
        condition = condition,
      )
    }

  override fun serialize(encoder: Encoder, `value`: TriggerDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.type)
      encodeStringIfNotNull(descriptor, 4, value.name?.value)
      encodeElementIfNotNull(descriptor, 5, value.name)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.code)
      encodeStringIfNotNull(descriptor, 7, value.subscriptionTopic?.value)
      encodeElementIfNotNull(descriptor, 8, value.subscriptionTopic)
      when (val choice = value.timing) {
        null -> {}
        is TriggerDefinition.Timing.Timing -> {
          encodeSerializableElement(descriptor, 9, TimingSerializer, choice.value)
        }
        is TriggerDefinition.Timing.Reference -> {
          encodeSerializableElement(descriptor, 10, ReferenceSerializer, choice.value)
        }
        is TriggerDefinition.Timing.Date -> {
          encodeStringIfNotNull(descriptor, 11, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is TriggerDefinition.Timing.DateTime -> {
          encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
      }
      if (value.`data`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          DataRequirementSerializer.listSerializer,
          value.`data`,
        )
      encodeSerializableIfNotNull(descriptor, 16, ExpressionSerializer, value.condition)
    }
  }
}
