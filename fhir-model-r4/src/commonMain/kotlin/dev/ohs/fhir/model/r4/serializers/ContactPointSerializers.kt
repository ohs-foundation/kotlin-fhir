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

import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.ContactPointSystem
import dev.ohs.fhir.model.r4.terminologies.ContactPointUse
import kotlin.Int
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

internal object ContactPointSerializer : FhirSerializer<ContactPoint> {
  override val descriptor: SerialDescriptor = buildDescriptor("ContactPoint", this)

  @JvmField internal val listSerializer: KSerializer<List<ContactPoint>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("system")
    b.strPrim("value")
    b.strPrim("use")
    b.intPrim("rank")
    b.optionalElement("period", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
  }

  override fun deserialize(decoder: Decoder): ContactPoint {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var system: ContactPointSystem? = null
    var _system: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var use: ContactPointUse? = null
    var _use: Element? = null
    var rank: Int? = null
    var _rank: Element? = null
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
        2 ->
          system = ContactPointSystem.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        3 ->
          _system =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> use = ContactPointUse.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        7 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> rank = compositeDecoder.decodeIntElement(descriptor, i)
        9 ->
          _rank =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
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
    return ContactPoint(
      id = id,
      extension = listOrEmpty(extension),
      system = Enumeration.of(system, _system),
      `value` = R4String.of(`value`, _value),
      use = Enumeration.of(use, _use),
      rank = PositiveInt.of(rank, _rank),
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ContactPoint) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.system?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.system)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.`value`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.`value`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.use?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.use)
    compositeEncoder.encodeIntIfNotNull(descriptor, 8, value.rank?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.rank)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 10, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}
