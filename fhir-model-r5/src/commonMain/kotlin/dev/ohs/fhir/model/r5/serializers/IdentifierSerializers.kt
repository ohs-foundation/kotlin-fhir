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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object IdentifierSerializer : KSerializer<Identifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Identifier") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("use", KotlinString.serializer().descriptor)
      optionalElement("_use", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("system", KotlinString.serializer().descriptor)
      optionalElement("_system", ElementSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("assigner", lazyDescriptor { ReferenceSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Identifier>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Identifier =
    decoder.decodeStructure(descriptor) {
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
          2 -> use = decodeStringElement(descriptor, i)
          3 -> _use = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> system = decodeStringElement(descriptor, i)
          6 -> _system = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> `value` = decodeStringElement(descriptor, i)
          8 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          10 ->
            assigner = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Identifier: " + i)
        }
      }
      Identifier(
        id = id,
        extension = extension ?: listOf(),
        use =
          Enumeration.of(if (use != null) Identifier.IdentifierUse.fromCode(use) else null, _use),
        type = type,
        system = Uri.of(system, _system),
        `value` = R5String.of(`value`, _value),
        period = period,
        assigner = assigner,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Identifier) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.use?.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.use)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 5, value.system?.value)
      encodeElementIfNotNull(descriptor, 6, value.system)
      encodeStringIfNotNull(descriptor, 7, value.`value`?.value)
      encodeElementIfNotNull(descriptor, 8, value.`value`)
      encodeSerializableIfNotNull(descriptor, 9, PeriodSerializer, value.period)
      encodeSerializableIfNotNull(descriptor, 10, ReferenceSerializer, value.assigner)
    }
  }
}
