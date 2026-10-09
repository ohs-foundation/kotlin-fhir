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

import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.RatioRange
import kotlin.OptIn
import kotlin.String
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

internal object RatioRangeSerializer : FhirSerializer<RatioRange> {
  override val descriptor: SerialDescriptor = buildDescriptor("RatioRange", this)

  @JvmField internal val listSerializer: KSerializer<List<RatioRange>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.optionalElement("lowNumerator", lazyDescriptor(LazyDescriptorId.QuantitySerializer))
    b.optionalElement("highNumerator", lazyDescriptor(LazyDescriptorId.QuantitySerializer))
    b.optionalElement("denominator", lazyDescriptor(LazyDescriptorId.QuantitySerializer))
  }

  override fun deserialize(decoder: Decoder): RatioRange {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var lowNumerator: Quantity? = null
    var highNumerator: Quantity? = null
    var denominator: Quantity? = null
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
          lowNumerator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        3 ->
          highNumerator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        4 ->
          denominator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RatioRange(
      id = id,
      extension = listOrEmpty(extension),
      lowNumerator = lowNumerator,
      highNumerator = highNumerator,
      denominator = denominator,
    )
  }

  override fun serialize(encoder: Encoder, `value`: RatioRange) {
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
      QuantitySerializer,
      value.lowNumerator,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      QuantitySerializer,
      value.highNumerator,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      QuantitySerializer,
      value.denominator,
    )
    compositeEncoder.endStructure(descriptor)
  }
}
