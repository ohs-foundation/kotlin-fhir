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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.UsageContext
import kotlin.String
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

internal object UsageContextValueSerializer : KSerializer<UsageContext.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UsageContext.Value") {
      element(
        "valueCodeableConcept",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueQuantity",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
      element("valueRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element(
        "valueReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun serialize(encoder: Encoder, `value`: UsageContext.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is UsageContext.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is UsageContext.Value.Quantity -> {
          encodeSerializableElement(__desc, 1, Hoisted.valueQuantitySer, __d.value)
        }
        is UsageContext.Value.Range -> {
          encodeSerializableElement(__desc, 2, Hoisted.valueRangeSer, __d.value)
        }
        is UsageContext.Value.Reference -> {
          encodeSerializableElement(__desc, 3, Hoisted.valueReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): UsageContext.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): UsageContext.Value {
    val __desc = descriptor
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        1 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.valueQuantitySer, null)
        2 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.valueRangeSer, null)
        3 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.valueReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding UsageContext.Value: " + __i)
      }
    }
    return UsageContext.Value.from(
      valueCodeableConcept,
      valueQuantity,
      valueRange,
      valueReference,
    )!!
  }

  private object Hoisted {
    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object UsageContextSerializer : KSerializer<UsageContext> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UsageContext") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("code", lazyDescriptor { Coding.serializer().descriptor }, isOptional = true)
      element(
        "valueCodeableConcept",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element(
        "valueQuantity",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
      element("valueRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element(
        "valueReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): UsageContext =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: UsageContext) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): UsageContext {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var code: Coding? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> code = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.codeSer, null)
        3 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        4 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueQuantitySer, null)
        5 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueRangeSer, null)
        6 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding UsageContext: " + __i)
      }
    }
    return UsageContext(
      id = id,
      extension = extension ?: listOf(),
      code = code!!,
      `value` =
        UsageContext.Value.from(valueCodeableConcept, valueQuantity, valueRange, valueReference)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: UsageContext) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.codeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is UsageContext.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.valueCodeableConceptSer, __d.value)
      }
      is UsageContext.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.valueQuantitySer, __d.value)
      }
      is UsageContext.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueRangeSer, __d.value)
      }
      is UsageContext.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.valueReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Coding> = Coding.serializer()

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}
