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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object IdentifierSerializer : KSerializer<Identifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Identifier") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("type", lazyDescriptor { CodeableConcept.serializer().descriptor }, isOptional = true)
      element("system", KotlinString.serializer().descriptor, isOptional = true)
      element("_system", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("period", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
      element("assigner", lazyDescriptor { Reference.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Identifier =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Identifier) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Identifier {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var type: CodeableConcept? = null
    var system: KotlinString? = null
    var _system: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var period: Period? = null
    var assigner: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> use = decoder.decodeStringElement(__desc, 2)
        3 -> _use = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.useSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> system = decoder.decodeStringElement(__desc, 5)
        6 -> _system = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.useSer, null)
        7 -> `value` = decoder.decodeStringElement(__desc, 7)
        8 -> _value = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.useSer, null)
        9 -> period = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.periodSer, null)
        10 ->
          assigner =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.assignerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Identifier: " + __i)
      }
    }
    return Identifier(
      id = id,
      extension = extension ?: listOf(),
      use = use?.let { Enumeration.of(Identifier.IdentifierUse.fromCode(it), _use) },
      type = type,
      system = Uri.of(system, _system),
      `value` = R5String.of(`value`, _value),
      period = period,
      assigner = assigner,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Identifier) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.use?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.use?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.useSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    ((value.system?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.useSer, it)
    }
    ((value.`value`?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.useSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.periodSer, it) }
    (value.assigner)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.assignerSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val useSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val assignerSer: KSerializer<Reference> = Reference.serializer()
  }
}
