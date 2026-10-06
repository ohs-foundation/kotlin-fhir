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
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Person
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.AdministrativeGender
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

internal object PersonCommunicationSerializer : KSerializer<Person.Communication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Communication") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.descriptor)
      optionalElement("preferred", KotlinBoolean.serializer().descriptor)
      optionalElement("_preferred", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Person.Communication>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Person.Communication =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var language: CodeableConcept? = null
      var preferred: KotlinBoolean? = null
      var _preferred: Element? = null
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
            language =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> preferred = decodeBooleanElement(descriptor, i)
          5 ->
            _preferred = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Communication: " + i)
        }
      }
      Person.Communication(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        language =
          language
            ?: throw SerializationException(
              "Missing required property 'language' on Person.Communication"
            ),
        preferred = R5Boolean.of(preferred, _preferred),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Person.Communication) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.language)
      encodeBooleanIfNotNull(descriptor, 4, value.preferred?.value)
      encodeElementIfNotNull(descriptor, 5, value.preferred)
    }
  }
}

internal object PersonLinkSerializer : KSerializer<Person.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("target", ReferenceSerializer.descriptor)
      optionalElement("assurance", String.serializer().descriptor)
      optionalElement("_assurance", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Person.Link>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Person.Link =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var target: Reference? = null
      var assurance: String? = null
      var _assurance: Element? = null
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
          3 -> target = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> assurance = decodeStringElement(descriptor, i)
          5 ->
            _assurance = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Link: " + i)
        }
      }
      Person.Link(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        target =
          target
            ?: throw SerializationException("Missing required property 'target' on Person.Link"),
        assurance =
          Enumeration.of(
            if (assurance != null) Person.IdentityAssuranceLevel.fromCode(assurance) else null,
            _assurance,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Person.Link) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.target)
      encodeStringIfNotNull(descriptor, 4, value.assurance?.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.assurance)
    }
  }
}

internal object PersonSerializer : FhirResourceSerializer<Person> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Person")

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
    b.optionalElement("gender", String.serializer().descriptor)
    b.optionalElement("_gender", ElementSerializer.descriptor)
    b.optionalElement("birthDate", String.serializer().descriptor)
    b.optionalElement("_birthDate", ElementSerializer.descriptor)
    b.optionalElement("deceasedBoolean", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_deceasedBoolean", ElementSerializer.descriptor)
    b.optionalElement("deceasedDateTime", String.serializer().descriptor)
    b.optionalElement("_deceasedDateTime", ElementSerializer.descriptor)
    b.optionalElement("address", AddressSerializer.listSerializer.descriptor)
    b.optionalElement("maritalStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("photo", AttachmentSerializer.listSerializer.descriptor)
    b.optionalElement("communication", PersonCommunicationSerializer.listSerializer.descriptor)
    b.optionalElement("managingOrganization", ReferenceSerializer.descriptor)
    b.optionalElement("link", PersonLinkSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Person {
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
    var gender: String? = null
    var _gender: Element? = null
    var birthDate: String? = null
    var _birthDate: Element? = null
    var deceasedBoolean: KotlinBoolean? = null
    var _deceasedBoolean: Element? = null
    var deceasedDateTime: String? = null
    var _deceasedDateTime: Element? = null
    var address: List<Address>? = null
    var maritalStatus: CodeableConcept? = null
    var photo: List<Attachment>? = null
    var communication: List<Person.Communication>? = null
    var managingOrganization: Reference? = null
    var link: List<Person.Link>? = null
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
        15 -> gender = decoder.decodeStringElement(descriptor, i)
        16 ->
          _gender =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> birthDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _birthDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> deceasedBoolean = decoder.decodeBooleanElement(descriptor, i)
        20 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> deceasedDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _deceasedDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          address =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer.listSerializer,
              null,
            )
        24 ->
          maritalStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          photo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        26 ->
          communication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PersonCommunicationSerializer.listSerializer,
              null,
            )
        27 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          link =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PersonLinkSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Person: " + i)
      }
    }
    return Person(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      active = R5Boolean.of(active, _active),
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      gender =
        Enumeration.of(
          if (gender != null) AdministrativeGender.fromCode(gender) else null,
          _gender,
        ),
      birthDate =
        Date.of(if (birthDate != null) FhirDate.fromString(birthDate) else null, _birthDate),
      deceased =
        Person.Deceased.from(
          R5Boolean.of(deceasedBoolean, _deceasedBoolean),
          DateTime.of(
            if (deceasedDateTime != null) FhirDateTime.fromString(deceasedDateTime) else null,
            _deceasedDateTime,
          ),
        ),
      address = address ?: listOf(),
      maritalStatus = maritalStatus,
      photo = photo ?: listOf(),
      communication = communication ?: listOf(),
      managingOrganization = managingOrganization,
      link = link ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Person,
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
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.gender?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.gender)
    encoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.birthDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.birthDate)
    when (val choice = value.deceased) {
      null -> {}
      is Person.Deceased.Boolean -> {
        encoder.encodeBooleanIfNotNull(descriptor, 19 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, choice.value)
      }
      is Person.Deceased.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          21 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
    }
    if (value.address.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        AddressSerializer.listSerializer,
        value.address,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.maritalStatus,
    )
    if (value.photo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        AttachmentSerializer.listSerializer,
        value.photo,
      )
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        PersonCommunicationSerializer.listSerializer,
        value.communication,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.managingOrganization,
    )
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        PersonLinkSerializer.listSerializer,
        value.link,
      )
  }
}
