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
import dev.ohs.fhir.model.r4.terminologies.TriggerType
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object TriggerDefinitionSerializer : FhirSerializer<TriggerDefinition> {
  override val descriptor: SerialDescriptor = buildDescriptor("TriggerDefinition", this)

  @JvmField internal val listSerializer: KSerializer<List<TriggerDefinition>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("type")
    b.strPrim("name")
    b.optionalElement("timingTiming", lazyDescriptor(LazyDescriptorId.TimingSerializer))
    b.optionalElement("timingReference", lazyDescriptor(LazyDescriptorId.ReferenceSerializer))
    b.strPrim("timingDate")
    b.strPrim("timingDateTime")
    b.optionalElement(
      "data",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.DataRequirementSerializer)),
    )
    b.optionalElement("condition", lazyDescriptor(LazyDescriptorId.ExpressionSerializer))
  }

  override fun deserialize(decoder: Decoder): TriggerDefinition {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: TriggerType? = null
    var _type: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var timingTiming: Timing? = null
    var timingReference: Reference? = null
    var timingDate: FhirDate? = null
    var _timingDate: Element? = null
    var timingDateTime: FhirDateTime? = null
    var _timingDateTime: Element? = null
    var `data`: List<DataRequirement>? = null
    var condition: Expression? = null
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
        2 -> type = TriggerType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        3 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          timingTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        7 ->
          timingReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 -> timingDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        9 ->
          _timingDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          timingDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        11 ->
          _timingDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          `data` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer.listSerializer,
              null,
            )
        13 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TriggerDefinition(
      id = id,
      extension = listOrEmpty(extension),
      type = required(Enumeration.of(type, _type), "TriggerDefinition", "type"),
      name = R4String.of(name, _name),
      timing =
        TriggerDefinition.Timing.from(
          timingTiming,
          timingReference,
          Date.of(timingDate, _timingDate),
          DateTime.of(timingDateTime, _timingDateTime),
        ),
      `data` = listOrEmpty(`data`),
      condition = condition,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TriggerDefinition) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.name)
    when (val choice = value.timing) {
      null -> {}
      is TriggerDefinition.Timing.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, TimingSerializer, choice.value)
      }
      is TriggerDefinition.Timing.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
      is TriggerDefinition.Timing.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is TriggerDefinition.Timing.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      DataRequirementSerializer.listSerializer,
      value.`data`,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      ExpressionSerializer,
      value.condition,
    )
    compositeEncoder.endStructure(descriptor)
  }
}
