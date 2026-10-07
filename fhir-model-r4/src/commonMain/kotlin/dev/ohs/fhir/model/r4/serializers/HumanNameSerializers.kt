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

import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.String as R4String
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

internal object HumanNameSerializer : KSerializer<HumanName> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("HumanName") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("use", KotlinString.serializer().descriptor)
      optionalElement("_use", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("family", KotlinString.serializer().descriptor)
      optionalElement("_family", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("given", stringNullableListSerializer.descriptor)
      optionalElement(
        "_given",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement("prefix", stringNullableListSerializer.descriptor)
      optionalElement(
        "_prefix",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement("suffix", stringNullableListSerializer.descriptor)
      optionalElement(
        "_suffix",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement("period", lazyDescriptor { PeriodSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<HumanName>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): HumanName {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var family: KotlinString? = null
    var _family: Element? = null
    var given: List<KotlinString?>? = null
    var _given: List<Element?>? = null
    var prefix: List<KotlinString?>? = null
    var _prefix: List<Element?>? = null
    var suffix: List<KotlinString?>? = null
    var _suffix: List<Element?>? = null
    var period: Period? = null
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
        2 -> use = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> family = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _family =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          given =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _given =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 ->
          prefix =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        11 ->
          _prefix =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        12 ->
          suffix =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        13 ->
          _suffix =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        14 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding HumanName: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return HumanName(
      id = id,
      extension = extension ?: listOf(),
      use = Enumeration.of(if (use != null) HumanName.NameUse.fromCode(use) else null, _use),
      text = R4String.of(text, _text),
      family = R4String.of(family, _family),
      given =
        (kotlin.collections.List(maxOf(given?.size ?: 0, _given?.size ?: 0)) { index ->
          R4String.of(given?.getOrNull(index), _given?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'given' on HumanName has neither a value nor an id/extension"
            )
        }),
      prefix =
        (kotlin.collections.List(maxOf(prefix?.size ?: 0, _prefix?.size ?: 0)) { index ->
          R4String.of(prefix?.getOrNull(index), _prefix?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'prefix' on HumanName has neither a value nor an id/extension"
            )
        }),
      suffix =
        (kotlin.collections.List(maxOf(suffix?.size ?: 0, _suffix?.size ?: 0)) { index ->
          R4String.of(suffix?.getOrNull(index), _suffix?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'suffix' on HumanName has neither a value nor an id/extension"
            )
        }),
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: HumanName) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.use?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.use)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.text?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.text)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.family?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.family)
    if (value.given.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.given.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.given)
    }
    if (value.prefix.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        10,
        stringNullableListSerializer,
        value.prefix.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 11, value.prefix)
    }
    if (value.suffix.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        12,
        stringNullableListSerializer,
        value.suffix.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 13, value.suffix)
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 14, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}
