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
import dev.ohs.fhir.model.r5.terminologies.IdentityAssuranceLevel
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

  override fun deserialize(decoder: Decoder): Person.Communication {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: CodeableConcept? = null
    var preferred: KotlinBoolean? = null
    var _preferred: Element? = null
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
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> preferred = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _preferred =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Communication: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Person.Communication(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.language,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.preferred?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.preferred)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): Person.Link {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var target: Reference? = null
    var assurance: String? = null
    var _assurance: Element? = null
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
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> assurance = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _assurance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Person.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      target =
        target ?: throw SerializationException("Missing required property 'target' on Person.Link"),
      assurance =
        Enumeration.of(
          if (assurance != null) IdentityAssuranceLevel.fromCode(assurance) else null,
          _assurance,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Person.Link) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.target)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.assurance?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.assurance)
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> active = compositeDecoder.decodeBooleanElement(descriptor, i)
        12 ->
          _active =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer.listSerializer,
              null,
            )
        14 ->
          telecom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        15 -> gender = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _gender =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> birthDate = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _birthDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> deceasedBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        20 ->
          _deceasedBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> deceasedDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _deceasedDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          address =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer.listSerializer,
              null,
            )
        24 ->
          maritalStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          photo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        26 ->
          communication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PersonCommunicationSerializer.listSerializer,
              null,
            )
        27 ->
          managingOrganization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        28 ->
          link =
            compositeDecoder.decodeNullableSerializableElement(
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Person,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 11 + descriptorOffset, value.active?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.active)
    if (value.name.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        HumanNameSerializer.listSerializer,
        value.name,
      )
    if (value.telecom.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.telecom,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.gender?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.gender)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.birthDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.birthDate)
    when (val choice = value.deceased) {
      null -> {}
      is Person.Deceased.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(
          descriptor,
          19 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, choice.value)
      }
      is Person.Deceased.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          21 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
    }
    if (value.address.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        AddressSerializer.listSerializer,
        value.address,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.maritalStatus,
    )
    if (value.photo.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        AttachmentSerializer.listSerializer,
        value.photo,
      )
    if (value.communication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        PersonCommunicationSerializer.listSerializer,
        value.communication,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.managingOrganization,
    )
    if (value.link.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        PersonLinkSerializer.listSerializer,
        value.link,
      )
  }
}
