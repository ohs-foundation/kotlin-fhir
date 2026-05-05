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

import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
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

internal object ExtendedContactDetailSerializer : KSerializer<ExtendedContactDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ExtendedContactDetail") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "purpose",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element(
        "name",
        listSerialDescriptor(lazyDescriptor { HumanName.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "telecom",
        listSerialDescriptor(lazyDescriptor { ContactPoint.serializer().descriptor }),
        isOptional = true,
      )
      element("address", lazyDescriptor { Address.serializer().descriptor }, isOptional = true)
      element(
        "organization",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element("period", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExtendedContactDetail =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExtendedContactDetail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExtendedContactDetail {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var purpose: CodeableConcept? = null
    var name: List<HumanName>? = null
    var telecom: List<ContactPoint>? = null
    var address: Address? = null
    var organization: Reference? = null
    var period: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          purpose = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.purposeSer, null)
        3 -> name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        4 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.telecomSer, null)
        5 ->
          address = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.addressSer, null)
        6 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.organizationSer, null)
        7 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ExtendedContactDetail: " + __i)
      }
    }
    return ExtendedContactDetail(
      id = id,
      extension = extension ?: listOf(),
      purpose = purpose,
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      address = address,
      organization = organization,
      period = period,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExtendedContactDetail) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    (value.purpose)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.purposeSer, it) }
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.nameSer, value.name)
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.telecomSer, value.telecom)
    (value.address)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.addressSer, it) }
    (value.organization)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.organizationSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val purposeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val nameSerInner: KSerializer<HumanName> = HumanName.serializer()

    public val nameSer: KSerializer<List<HumanName>> = ListSerializer(Hoisted.nameSerInner)

    public val telecomSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val telecomSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.telecomSerInner)

    public val addressSer: KSerializer<Address> = Address.serializer()

    public val organizationSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}
