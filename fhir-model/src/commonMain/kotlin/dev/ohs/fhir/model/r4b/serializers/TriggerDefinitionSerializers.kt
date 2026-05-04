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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.DataRequirement
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.TriggerDefinition
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TriggerDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TriggerDefinition {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(__desc, 2)
        3 -> _type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> name = decoder.decodeStringElement(__desc, 4)
        5 -> _name = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.timingTimingSer, null)
        7 ->
          timingReference =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.timingReferenceSer, null)
        8 -> timingDate = decoder.decodeStringElement(__desc, 8)
        9 ->
          _timingDate = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.typeSer, null)
        10 -> timingDateTime = decoder.decodeStringElement(__desc, 10)
        11 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.typeSer, null)
        12 -> `data` = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.dataSer, null)
        13 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.conditionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TriggerDefinition: " + __i)
      }
    }
    return TriggerDefinition(
      id = id,
      extension = extension ?: listOf(),
      type = Enumeration.of(TriggerDefinition.TriggerType.fromCode(type!!), _type),
      name = R4bString.of(name, _name),
      timing =
        TriggerDefinition.Timing.from(
          timingTiming,
          timingReference,
          Date.of(FhirDate.fromString(timingDate), _timingDate),
          DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
        ),
      `data` = `data` ?: listOf(),
      condition = condition,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TriggerDefinition) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it)
    }
    when (val __d = value.timing) {
      null -> {}
      is TriggerDefinition.Timing.Timing -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.timingTimingSer, __d.value)
      }
      is TriggerDefinition.Timing.Reference -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.timingReferenceSer, __d.value)
      }
      is TriggerDefinition.Timing.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.typeSer, it)
        }
      }
      is TriggerDefinition.Timing.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.typeSer, it)
        }
      }
    }
    if (value.`data`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.dataSer, value.`data`)
    (value.condition)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.conditionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val timingReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val dataSerInner: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val dataSer: KSerializer<List<DataRequirement>> = ListSerializer(Hoisted.dataSerInner)

    public val conditionSer: KSerializer<Expression> = Expression.serializer()
  }
}
