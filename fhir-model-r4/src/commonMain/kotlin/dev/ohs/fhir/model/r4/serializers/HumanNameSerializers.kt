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
import dev.ohs.fhir.model.r4.terminologies.NameUse
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

internal object HumanNameSerializer : FhirSerializer<HumanName> {
  override val descriptor: SerialDescriptor = buildDescriptor("HumanName", this)

  @JvmField internal val listSerializer: KSerializer<List<HumanName>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("use")
    b.strPrim("text")
    b.strPrim("family")
    b.strPrimList("given")
    b.strPrimList("prefix")
    b.strPrimList("suffix")
    b.optionalElement("period", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
  }

  override fun deserialize(decoder: Decoder): HumanName {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var use: NameUse? = null
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
        2 -> use = NameUse.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val given_ =
      List(maxSize(given, _given)) { index ->
        entryRequired(R4String.of(at(given, index), at(_given, index)), "HumanName", "given")
      }
    val prefix_ =
      List(maxSize(prefix, _prefix)) { index ->
        entryRequired(R4String.of(at(prefix, index), at(_prefix, index)), "HumanName", "prefix")
      }
    val suffix_ =
      List(maxSize(suffix, _suffix)) { index ->
        entryRequired(R4String.of(at(suffix, index), at(_suffix, index)), "HumanName", "suffix")
      }
    return HumanName(
      id = id,
      extension = listOrEmpty(extension),
      use = Enumeration.of(use, _use),
      text = R4String.of(text, _text),
      family = R4String.of(family, _family),
      given = given_,
      prefix = prefix_,
      suffix = suffix_,
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: HumanName) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
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
    if (!value.given.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.given.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.given)
    }
    if (!value.prefix.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        10,
        stringNullableListSerializer,
        value.prefix.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 11, value.prefix)
    }
    if (!value.suffix.isEmpty()) {
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
