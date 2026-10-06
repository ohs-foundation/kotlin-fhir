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

import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.String as R5String
import kotlin.Int
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

internal object ContactPointSerializer : KSerializer<ContactPoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContactPoint") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("system", KotlinString.serializer().descriptor)
      optionalElement("_system", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("use", KotlinString.serializer().descriptor)
      optionalElement("_use", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("rank", Int.serializer().descriptor)
      optionalElement("_rank", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("period", lazyDescriptor { PeriodSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<ContactPoint>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ContactPoint =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var system: KotlinString? = null
      var _system: Element? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
      var use: KotlinString? = null
      var _use: Element? = null
      var rank: Int? = null
      var _rank: Element? = null
      var period: Period? = null
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
          2 -> system = decodeStringElement(descriptor, i)
          3 -> _system = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> `value` = decodeStringElement(descriptor, i)
          5 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> use = decodeStringElement(descriptor, i)
          7 -> _use = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> rank = decodeIntElement(descriptor, i)
          9 -> _rank = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ContactPoint: " + i)
        }
      }
      ContactPoint(
        id = id,
        extension = extension ?: listOf(),
        system =
          Enumeration.of(
            if (system != null) ContactPoint.ContactPointSystem.fromCode(system) else null,
            _system,
          ),
        `value` = R5String.of(`value`, _value),
        use =
          Enumeration.of(
            if (use != null) ContactPoint.ContactPointUse.fromCode(use) else null,
            _use,
          ),
        rank = PositiveInt.of(rank, _rank),
        period = period,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ContactPoint) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.system?.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.system)
      encodeStringIfNotNull(descriptor, 4, value.`value`?.value)
      encodeElementIfNotNull(descriptor, 5, value.`value`)
      encodeStringIfNotNull(descriptor, 6, value.use?.value?.code)
      encodeElementIfNotNull(descriptor, 7, value.use)
      encodeIntIfNotNull(descriptor, 8, value.rank?.value)
      encodeElementIfNotNull(descriptor, 9, value.rank)
      encodeSerializableIfNotNull(descriptor, 10, PeriodSerializer, value.period)
    }
  }
}
