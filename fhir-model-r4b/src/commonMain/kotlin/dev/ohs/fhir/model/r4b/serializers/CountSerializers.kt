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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Count
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.QuantityComparator
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

internal object CountSerializer : FhirSerializer<Count> {
  override val descriptor: SerialDescriptor = buildDescriptor("Count", this)

  @JvmField internal val listSerializer: KSerializer<List<Count>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.prim("value", FhirDecimalSerializer.descriptor)
    b.strPrim("comparator")
    b.strPrim("unit")
    b.strPrim("system")
    b.strPrim("code")
  }

  override fun deserialize(decoder: Decoder): Count {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var `value`: FhirDecimal? = null
    var _value: Element? = null
    var comparator: QuantityComparator? = null
    var _comparator: Element? = null
    var unit: KotlinString? = null
    var _unit: Element? = null
    var system: KotlinString? = null
    var _system: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
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
        2 ->
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        3 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 ->
          comparator =
            QuantityComparator.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _comparator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> unit = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _unit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> system = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> code = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Count(
      id = id,
      extension = listOrEmpty(extension),
      `value` = Decimal.of(`value`, _value),
      comparator = Enumeration.of(comparator, _comparator),
      unit = R4bString.of(unit, _unit),
      system = Uri.of(system, _system),
      code = Code.of(code, _code),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Count) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      2,
      FhirDecimalSerializer,
      value.`value`?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.`value`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.comparator?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.comparator)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.unit?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.unit)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.system?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.system)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.code?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.code)
    compositeEncoder.endStructure(descriptor)
  }
}
