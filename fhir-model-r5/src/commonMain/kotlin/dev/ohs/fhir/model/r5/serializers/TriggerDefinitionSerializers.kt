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
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object TriggerDefinitionSerializer : KSerializer<TriggerDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TriggerDefinition") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("code", lazyDescriptor { CodeableConcept.serializer().descriptor }, isOptional = true)
      element("subscriptionTopic", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_subscriptionTopic",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("timingTiming", lazyDescriptor { Timing.serializer().descriptor }, isOptional = true)
      element(
        "timingReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element("timingDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_timingDate", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("timingDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_timingDateTime",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element(
        "data",
        listSerialDescriptor(lazyDescriptor { DataRequirement.serializer().descriptor }),
        isOptional = true,
      )
      element("condition", lazyDescriptor { Expression.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TriggerDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TriggerDefinition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TriggerDefinition {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(descriptor, i)
        3 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> name = decoder.decodeStringElement(descriptor, i)
        5 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 -> subscriptionTopic = decoder.decodeStringElement(descriptor, i)
        8 ->
          _subscriptionTopic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        9 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingTimingSer, null)
        10 ->
          timingReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.timingReferenceSer,
              null,
            )
        11 -> timingDate = decoder.decodeStringElement(descriptor, i)
        12 ->
          _timingDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        13 -> timingDateTime = decoder.decodeStringElement(descriptor, i)
        14 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        15 ->
          `data` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dataSer, null)
        16 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TriggerDefinition: " + i)
      }
    }
    return TriggerDefinition(
      id = id,
      extension = extension ?: listOf(),
      type =
        Enumeration.of(
          TriggerDefinition.TriggerType.fromCode(
            type
              ?: throw SerializationException(
                "Missing required property 'type' on TriggerDefinition"
              )
          ),
          _type,
        ),
      name = R5String.of(name, _name),
      code = code,
      subscriptionTopic = Canonical.of(subscriptionTopic, _subscriptionTopic),
      timing =
        TriggerDefinition.Timing.from(
          timingTiming,
          timingReference,
          Date.of(timingDate?.let { FhirDate.fromString(it) }, _timingDate),
          DateTime.of(timingDateTime?.let { FhirDateTime.fromString(it) }, _timingDateTime),
        ),
      `data` = `data` ?: listOf(),
      condition = condition,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TriggerDefinition) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it) }
    ((value.subscriptionTopic?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.subscriptionTopic?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, it)
    }
    when (val choice = value.timing) {
      null -> {}
      is TriggerDefinition.Timing.Timing -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.timingTimingSer, choice.value)
      }
      is TriggerDefinition.Timing.Reference -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.timingReferenceSer, choice.value)
      }
      is TriggerDefinition.Timing.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.typeSer, it)
        }
      }
      is TriggerDefinition.Timing.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.typeSer, it)
        }
      }
    }
    if (value.`data`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.dataSer, value.`data`)
    (value.condition)?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.conditionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val timingReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val dataSerInner: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val dataSer: KSerializer<List<DataRequirement>> = ListSerializer(Hoisted.dataSerInner)

    public val conditionSer: KSerializer<Expression> = Expression.serializer()
  }
}
