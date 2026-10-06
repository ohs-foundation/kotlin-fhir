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

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Practitioner
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.AdministrativeGender
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object PractitionerQualificationSerializer : KSerializer<Practitioner.Qualification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Qualification") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("issuer", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Practitioner.Qualification>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Practitioner.Qualification =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: List<Identifier>? = null
      var code: CodeableConcept? = null
      var period: Period? = null
      var issuer: Reference? = null
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
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          6 -> issuer = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Qualification: " + i)
        }
      }
      Practitioner.Qualification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on Practitioner.Qualification"
            ),
        period = period,
        issuer = issuer,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Practitioner.Qualification) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 5, PeriodSerializer, value.period)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.issuer)
    }
  }
}

internal object PractitionerSerializer : FhirResourceSerializer<Practitioner> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Practitioner")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("active", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_active", ElementSerializer.descriptor)
    b.optionalElement("name", HumanNameSerializer.listSerializer.descriptor)
    b.optionalElement("telecom", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("address", AddressSerializer.listSerializer.descriptor)
    b.optionalElement("gender", String.serializer().descriptor)
    b.optionalElement("_gender", ElementSerializer.descriptor)
    b.optionalElement("birthDate", String.serializer().descriptor)
    b.optionalElement("_birthDate", ElementSerializer.descriptor)
    b.optionalElement("photo", AttachmentSerializer.listSerializer.descriptor)
    b.optionalElement(
      "qualification",
      PractitionerQualificationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("communication", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Practitioner {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var active: KotlinBoolean? = null
    var _active: Element? = null
    var name: List<HumanName>? = null
    var telecom: List<ContactPoint>? = null
    var address: List<Address>? = null
    var gender: String? = null
    var _gender: Element? = null
    var birthDate: String? = null
    var _birthDate: Element? = null
    var photo: List<Attachment>? = null
    var qualification: List<Practitioner.Qualification>? = null
    var communication: List<CodeableConcept>? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> active = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _active =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer.listSerializer,
              null,
            )
        14 ->
          telecom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        15 ->
          address =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer.listSerializer,
              null,
            )
        16 -> gender = decoder.decodeStringElement(descriptor, i)
        17 ->
          _gender =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> birthDate = decoder.decodeStringElement(descriptor, i)
        19 ->
          _birthDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          photo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        21 ->
          qualification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PractitionerQualificationSerializer.listSerializer,
              null,
            )
        22 ->
          communication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Practitioner: " + i)
      }
    }
    return Practitioner(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      active = R4bBoolean.of(active, _active),
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      address = address ?: listOf(),
      gender =
        Enumeration.of(
          if (gender != null) AdministrativeGender.fromCode(gender) else null,
          _gender,
        ),
      birthDate =
        Date.of(if (birthDate != null) FhirDate.fromString(birthDate) else null, _birthDate),
      photo = photo ?: listOf(),
      qualification = qualification ?: listOf(),
      communication = communication ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Practitioner,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeBooleanIfNotNull(descriptor, 11 + descriptorOffset, value.active?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.active)
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        HumanNameSerializer.listSerializer,
        value.name,
      )
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.telecom,
      )
    if (value.address.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        AddressSerializer.listSerializer,
        value.address,
      )
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.gender?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.gender)
    encoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.birthDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.birthDate)
    if (value.photo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        AttachmentSerializer.listSerializer,
        value.photo,
      )
    if (value.qualification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        PractitionerQualificationSerializer.listSerializer,
        value.qualification,
      )
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.communication,
      )
  }
}
