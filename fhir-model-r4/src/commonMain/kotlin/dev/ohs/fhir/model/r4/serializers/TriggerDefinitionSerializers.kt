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

import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.TriggerDefinition
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
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object TriggerDefinitionSerializer : KSerializer<TriggerDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TriggerDefinition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("timingTiming", lazyDescriptor { TimingSerializer.descriptor })
      optionalElement("timingReference", lazyDescriptor { ReferenceSerializer.descriptor })
      optionalElement("timingDate", KotlinString.serializer().descriptor)
      optionalElement("_timingDate", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("timingDateTime", KotlinString.serializer().descriptor)
      optionalElement("_timingDateTime", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement(
        "data",
        listSerialDescriptor(lazyDescriptor { DataRequirementSerializer.descriptor }),
      )
      optionalElement("condition", lazyDescriptor { ExpressionSerializer.descriptor })
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
            timingTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          7 ->
            timingReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 -> timingDate = decodeStringElement(descriptor, i)
          9 ->
            _timingDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> timingDateTime = decodeStringElement(descriptor, i)
          11 ->
            _timingDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            `data` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DataRequirementSerializer.listSerializer,
                null,
              )
          13 ->
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
        name = R4String.of(name, _name),
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
      when (val choice = value.timing) {
        null -> {}
        is TriggerDefinition.Timing.Timing -> {
          encodeSerializableElement(descriptor, 6, TimingSerializer, choice.value)
        }
        is TriggerDefinition.Timing.Reference -> {
          encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
        }
        is TriggerDefinition.Timing.Date -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is TriggerDefinition.Timing.DateTime -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
      }
      if (value.`data`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          DataRequirementSerializer.listSerializer,
          value.`data`,
        )
      encodeSerializableIfNotNull(descriptor, 13, ExpressionSerializer, value.condition)
    }
  }
}
