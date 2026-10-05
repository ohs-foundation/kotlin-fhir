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
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Period
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

internal object PatientContactSerializer : KSerializer<Patient.Contact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contact") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relationship",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("name", HumanName.serializer().descriptor, isOptional = true)
      element(
        "telecom",
        listSerialDescriptor(ContactPoint.serializer().descriptor),
        isOptional = true,
      )
      element("address", Address.serializer().descriptor, isOptional = true)
      element("gender", String.serializer().descriptor, isOptional = true)
      element("_gender", Element.serializer().descriptor, isOptional = true)
      element("organization", Reference.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Patient.Contact>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Patient.Contact =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Patient.Contact) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Patient.Contact {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationship: List<CodeableConcept>? = null
    var name: HumanName? = null
    var telecom: List<ContactPoint>? = null
    var address: Address? = null
    var gender: String? = null
    var _gender: Element? = null
    var organization: Reference? = null
    var period: Period? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          name = decoder.decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
        5 ->
          telecom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        6 ->
          address =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        7 -> gender = decoder.decodeStringElement(descriptor, i)
        8 ->
          _gender =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 ->
          organization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        10 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contact: " + i)
      }
    }
    return Patient.Contact(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relationship = relationship ?: listOf(),
      name = name,
      telecom = telecom ?: listOf(),
      address = address,
      gender = Enumeration.of(gender?.let { AdministrativeGender.fromCode(it) }, _gender),
      organization = organization,
      period = period,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Patient.Contact) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableConceptSerializer.listSerializer,
        value.relationship,
      )
    (value.name)?.let { encoder.encodeSerializableElement(descriptor, 4, HumanNameSerializer, it) }
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        ContactPointSerializer.listSerializer,
        value.telecom,
      )
    (value.address)?.let { encoder.encodeSerializableElement(descriptor, 6, AddressSerializer, it) }
    ((value.gender?.value?.code))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
    (value.organization)?.let {
      encoder.encodeSerializableElement(descriptor, 9, ReferenceSerializer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 10, PeriodSerializer, it) }
  }
}

internal object PatientCommunicationSerializer : KSerializer<Patient.Communication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Communication") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("language", CodeableConcept.serializer().descriptor, isOptional = true)
      element("preferred", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_preferred", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Patient.Communication>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Patient.Communication =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Patient.Communication) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Patient.Communication {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: CodeableConcept? = null
    var preferred: KotlinBoolean? = null
    var _preferred: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          language =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> preferred = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _preferred =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Communication: " + i)
      }
    }
    return Patient.Communication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language =
        language
          ?: throw SerializationException(
            "Missing required property 'language' on Patient.Communication"
          ),
      preferred = R5Boolean.of(preferred, _preferred),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Patient.Communication) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.language)
    ((value.preferred?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.preferred?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
  }
}

internal object PatientLinkSerializer : KSerializer<Patient.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("other", Reference.serializer().descriptor, isOptional = true)
      element("type", String.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Patient.Link>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Patient.Link =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Patient.Link) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Patient.Link {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var other: Reference? = null
    var type: String? = null
    var _type: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          other =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        4 -> type = decoder.decodeStringElement(descriptor, i)
        5 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + i)
      }
    }
    return Patient.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      other =
        other ?: throw SerializationException("Missing required property 'other' on Patient.Link"),
      type =
        Enumeration.of(type?.let { Patient.LinkType.fromCode(it) }, _type)
          ?: throw SerializationException("Missing required property 'type' on Patient.Link"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Patient.Link) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.other)
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
  }
}

internal object PatientSerializer : KSerializer<Patient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Patient") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_active", Element.serializer().descriptor, isOptional = true)
    b.element("name", listSerialDescriptor(HumanName.serializer().descriptor), isOptional = true)
    b.element(
      "telecom",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element("gender", String.serializer().descriptor, isOptional = true)
    b.element("_gender", Element.serializer().descriptor, isOptional = true)
    b.element("birthDate", String.serializer().descriptor, isOptional = true)
    b.element("_birthDate", Element.serializer().descriptor, isOptional = true)
    b.element("deceasedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_deceasedBoolean", Element.serializer().descriptor, isOptional = true)
    b.element("deceasedDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_deceasedDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("address", listSerialDescriptor(Address.serializer().descriptor), isOptional = true)
    b.element("maritalStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("multipleBirthBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_multipleBirthBoolean", Element.serializer().descriptor, isOptional = true)
    b.element("multipleBirthInteger", Int.serializer().descriptor, isOptional = true)
    b.element("_multipleBirthInteger", Element.serializer().descriptor, isOptional = true)
    b.element("photo", listSerialDescriptor(Attachment.serializer().descriptor), isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(lazyDescriptor { Patient.Contact.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "communication",
      listSerialDescriptor(lazyDescriptor { Patient.Communication.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "generalPractitioner",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("managingOrganization", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "link",
      listSerialDescriptor(lazyDescriptor { Patient.Link.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Patient =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Patient) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Patient")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Patient {
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
    var multipleBirthBoolean: KotlinBoolean? = null
    var _multipleBirthBoolean: Element? = null
    var multipleBirthInteger: Int? = null
    var _multipleBirthInteger: Element? = null
    var photo: List<Attachment>? = null
    var contact: List<Patient.Contact>? = null
    var communication: List<Patient.Communication>? = null
    var generalPractitioner: List<Reference>? = null
    var managingOrganization: Reference? = null
    var link: List<Patient.Link>? = null
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
        25 -> multipleBirthBoolean = decoder.decodeBooleanElement(descriptor, i)
        26 ->
          _multipleBirthBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> multipleBirthInteger = decoder.decodeIntElement(descriptor, i)
        28 ->
          _multipleBirthInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          photo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PatientContactSerializer.listSerializer,
              null,
            )
        31 ->
          communication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PatientCommunicationSerializer.listSerializer,
              null,
            )
        32 ->
          generalPractitioner =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        34 ->
          link =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PatientLinkSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Patient: " + i)
      }
    }
    return Patient(
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
      gender = Enumeration.of(gender?.let { AdministrativeGender.fromCode(it) }, _gender),
      birthDate = Date.of(birthDate?.let { FhirDate.fromString(it) }, _birthDate),
      deceased =
        Patient.Deceased.from(
          R5Boolean.of(deceasedBoolean, _deceasedBoolean),
          DateTime.of(deceasedDateTime?.let { FhirDateTime.fromString(it) }, _deceasedDateTime),
        ),
      address = address ?: listOf(),
      maritalStatus = maritalStatus,
      multipleBirth =
        Patient.MultipleBirth.from(
          R5Boolean.of(multipleBirthBoolean, _multipleBirthBoolean),
          Integer.of(multipleBirthInteger, _multipleBirthInteger),
        ),
      photo = photo ?: listOf(),
      contact = contact ?: listOf(),
      communication = communication ?: listOf(),
      generalPractitioner = generalPractitioner ?: listOf(),
      managingOrganization = managingOrganization,
      link = link ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Patient,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    ((value.active?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ElementSerializer, it)
    }
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
    ((value.gender?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, ElementSerializer, it)
    }
    ((value.birthDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.birthDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ElementSerializer, it)
    }
    when (val choice = value.deceased) {
      null -> {}
      is Patient.Deceased.Boolean -> {
        ((choice.value.value))?.let {
          encoder.encodeBooleanElement(descriptor, 19 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            20 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
      is Patient.Deceased.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            22 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
    }
    if (value.address.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        AddressSerializer.listSerializer,
        value.address,
      )
    (value.maritalStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    when (val choice = value.multipleBirth) {
      null -> {}
      is Patient.MultipleBirth.Boolean -> {
        ((choice.value.value))?.let {
          encoder.encodeBooleanElement(descriptor, 25 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            26 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
      is Patient.MultipleBirth.Integer -> {
        ((choice.value.value))?.let {
          encoder.encodeIntElement(descriptor, 27 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            28 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
    }
    if (value.photo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        AttachmentSerializer.listSerializer,
        value.photo,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        PatientContactSerializer.listSerializer,
        value.contact,
      )
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        PatientCommunicationSerializer.listSerializer,
        value.communication,
      )
    if (value.generalPractitioner.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.generalPractitioner,
      )
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, ReferenceSerializer, it)
    }
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        PatientLinkSerializer.listSerializer,
        value.link,
      )
  }
}

internal object PatientPolymorphicSerializer : KSerializer<Patient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Patient") { PatientSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Patient) {
    encoder.encodeStructure(descriptor) {
      PatientSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Patient =
    decoder.decodeStructure(descriptor) {
      PatientSerializer.deserializeInternal(this, descriptor, 0)
    }
}
