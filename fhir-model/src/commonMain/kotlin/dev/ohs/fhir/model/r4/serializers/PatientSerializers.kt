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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.AdministrativeGender
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
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

  override fun deserialize(decoder: Decoder): Patient.Contact =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Patient.Contact) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Patient.Contact {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relationshipSer, null)
        4 -> name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.telecomSer, null)
        6 ->
          address = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.addressSer, null)
        7 -> gender = decoder.decodeStringElement(__desc, __i)
        8 ->
          _gender = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.genderSer, null)
        9 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.organizationSer, null)
        10 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contact: " + __i)
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
      gender = gender?.let { Enumeration.of(AdministrativeGender.fromCode(it), _gender) },
      organization = organization,
      period = period,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Patient.Contact) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.relationshipSer, value.relationship)
    (value.name)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it) }
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.telecomSer, value.telecom)
    (value.address)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.addressSer, it) }
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.genderSer, it)
    }
    (value.organization)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.organizationSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val relationshipSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val relationshipSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.relationshipSerInner)

    public val nameSer: KSerializer<HumanName> = HumanName.serializer()

    public val telecomSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val telecomSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.telecomSerInner)

    public val addressSer: KSerializer<Address> = Address.serializer()

    public val genderSer: KSerializer<Element> = Element.serializer()

    public val organizationSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
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

  override fun deserialize(decoder: Decoder): Patient.Communication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Patient.Communication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Patient.Communication {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: CodeableConcept? = null
    var preferred: KotlinBoolean? = null
    var _preferred: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.languageSer, null)
        4 -> preferred = decoder.decodeBooleanElement(__desc, __i)
        5 ->
          _preferred =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.preferredSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Communication: " + __i)
      }
    }
    return Patient.Communication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = language!!,
      preferred = R4Boolean.of(preferred, _preferred),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Patient.Communication) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.language)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.languageSer, it) }
    ((value.preferred?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.preferred?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.preferredSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val languageSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val preferredSer: KSerializer<Element> = Element.serializer()
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

  override fun deserialize(decoder: Decoder): Patient.Link =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Patient.Link) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Patient.Link {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var other: Reference? = null
    var type: String? = null
    var _type: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> other = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.otherSer, null)
        4 -> type = decoder.decodeStringElement(__desc, __i)
        5 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + __i)
      }
    }
    return Patient.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      other = other!!,
      type = Enumeration.of(Patient.LinkType.fromCode(type!!), _type),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Patient.Link) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.other)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.otherSer, it) }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val otherSer: KSerializer<Reference> = Reference.serializer()

    public val typeSer: KSerializer<Element> = Element.serializer()
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Patient) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Patient")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Patient {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> active = decoder.decodeBooleanElement(__desc, __i)
        12 ->
          _active =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 -> name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        14 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.telecomSer, null)
        15 -> gender = decoder.decodeStringElement(__desc, __i)
        16 ->
          _gender =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 -> birthDate = decoder.decodeStringElement(__desc, __i)
        18 ->
          _birthDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> deceasedBoolean = decoder.decodeBooleanElement(__desc, __i)
        20 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> deceasedDateTime = decoder.decodeStringElement(__desc, __i)
        22 ->
          _deceasedDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 ->
          address = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.addressSer, null)
        24 ->
          maritalStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.maritalStatusSer, null)
        25 -> multipleBirthBoolean = decoder.decodeBooleanElement(__desc, __i)
        26 ->
          _multipleBirthBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 -> multipleBirthInteger = decoder.decodeIntElement(__desc, __i)
        28 ->
          _multipleBirthInteger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        29 -> photo = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.photoSer, null)
        30 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        31 ->
          communication =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.communicationSer, null)
        32 ->
          generalPractitioner =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.generalPractitionerSer,
              null,
            )
        33 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.generalPractitionerSerInner,
              null,
            )
        34 -> link = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkSer, null)
        else -> throw SerializationException("Unexpected index decoding Patient: " + __i)
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
      active = R4Boolean.of(active, _active),
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      gender = gender?.let { Enumeration.of(AdministrativeGender.fromCode(it), _gender) },
      birthDate = Date.of(FhirDate.fromString(birthDate), _birthDate),
      deceased =
        Patient.Deceased.from(
          R4Boolean.of(deceasedBoolean, _deceasedBoolean),
          DateTime.of(FhirDateTime.fromString(deceasedDateTime), _deceasedDateTime),
        ),
      address = address ?: listOf(),
      maritalStatus = maritalStatus,
      multipleBirth =
        Patient.MultipleBirth.from(
          R4Boolean.of(multipleBirthBoolean, _multipleBirthBoolean),
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Patient,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.active?.value))?.let { encoder.encodeBooleanElement(__desc, 11 + __off, it) }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.nameSer, value.name)
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.telecomSer, value.telecom)
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.birthDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 17 + __off, it)
    }
    (value.birthDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.deceased) {
      null -> {}
      is Patient.Deceased.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 19 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Patient.Deceased.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.address.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.addressSer, value.address)
    (value.maritalStatus)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.maritalStatusSer, it)
    }
    when (val __d = value.multipleBirth) {
      null -> {}
      is Patient.MultipleBirth.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 25 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Patient.MultipleBirth.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 27 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.photo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.photoSer, value.photo)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.contactSer, value.contact)
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        31 + __off,
        Hoisted.communicationSer,
        value.communication,
      )
    if (value.generalPractitioner.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        32 + __off,
        Hoisted.generalPractitionerSer,
        value.generalPractitioner,
      )
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.generalPractitionerSerInner, it)
    }
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.linkSer, value.link)
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val nameSerInner: KSerializer<HumanName> = HumanName.serializer()

    public val nameSer: KSerializer<List<HumanName>> = ListSerializer(Hoisted.nameSerInner)

    public val telecomSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val telecomSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.telecomSerInner)

    public val addressSerInner: KSerializer<Address> = Address.serializer()

    public val addressSer: KSerializer<List<Address>> = ListSerializer(Hoisted.addressSerInner)

    public val maritalStatusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val photoSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val photoSer: KSerializer<List<Attachment>> = ListSerializer(Hoisted.photoSerInner)

    public val contactSerInner: KSerializer<Patient.Contact> = Patient.Contact.serializer()

    public val contactSer: KSerializer<List<Patient.Contact>> =
      ListSerializer(Hoisted.contactSerInner)

    public val communicationSerInner: KSerializer<Patient.Communication> =
      Patient.Communication.serializer()

    public val communicationSer: KSerializer<List<Patient.Communication>> =
      ListSerializer(Hoisted.communicationSerInner)

    public val generalPractitionerSerInner: KSerializer<Reference> = Reference.serializer()

    public val generalPractitionerSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.generalPractitionerSerInner)

    public val linkSerInner: KSerializer<Patient.Link> = Patient.Link.serializer()

    public val linkSer: KSerializer<List<Patient.Link>> = ListSerializer(Hoisted.linkSerInner)
  }
}

internal object PatientPolymorphicSerializer : KSerializer<Patient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Patient") { PatientSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Patient) {
    encoder.encodeStructure(descriptor) {
      PatientSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Patient =
    decoder.decodeStructure(descriptor) { PatientSerializer.deserializeJson(this, descriptor, 0) }
}
