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

import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
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

internal object ExtendedContactDetailSerializer : FhirSerializer<ExtendedContactDetail> {
  override val descriptor: SerialDescriptor = buildDescriptor("ExtendedContactDetail", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ExtendedContactDetail>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.optionalElement("purpose", lazyDescriptor(LazyDescriptorId.CodeableConceptSerializer))
    b.optionalElement(
      "name",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.HumanNameSerializer)),
    )
    b.optionalElement(
      "telecom",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ContactPointSerializer)),
    )
    b.optionalElement("address", lazyDescriptor(LazyDescriptorId.AddressSerializer))
    b.optionalElement("organization", lazyDescriptor(LazyDescriptorId.ReferenceSerializer))
    b.optionalElement("period", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
  }

  override fun deserialize(decoder: Decoder): ExtendedContactDetail {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var purpose: CodeableConcept? = null
    var name: List<HumanName>? = null
    var telecom: List<ContactPoint>? = null
    var address: Address? = null
    var organization: Reference? = null
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
          purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        3 ->
          name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer.listSerializer,
              null,
            )
        4 ->
          telecom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        5 ->
          address =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        6 ->
          organization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        7 ->
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
    return ExtendedContactDetail(
      id = id,
      extension = listOrEmpty(extension),
      purpose = purpose,
      name = listOrEmpty(name),
      telecom = listOrEmpty(telecom),
      address = address,
      organization = organization,
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExtendedContactDetail) {
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
      CodeableConceptSerializer,
      value.purpose,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      HumanNameSerializer.listSerializer,
      value.name,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      ContactPointSerializer.listSerializer,
      value.telecom,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, AddressSerializer, value.address)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      ReferenceSerializer,
      value.organization,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}
