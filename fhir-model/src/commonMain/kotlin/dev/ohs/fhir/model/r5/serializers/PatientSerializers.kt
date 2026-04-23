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
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.AdministrativeGender
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.relationshipSer, null)
        4 -> name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.telecomSer, null)
        6 ->
          address = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.addressSer, null)
        7 -> gender = decoder.decodeStringElement(__desc, 7)
        8 -> _gender = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.genderSer, null)
        9 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.organizationSer, null)
        10 ->
          period = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.periodSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          language = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.languageSer, null)
        4 -> preferred = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _preferred =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.preferredSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Communication: " + __i)
      }
    }
    return Patient.Communication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = language!!,
      preferred = R5Boolean.of(preferred, _preferred),
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> other = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.otherSer, null)
        4 -> type = decoder.decodeStringElement(__desc, 4)
        5 -> _type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
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

internal object PatientDeceasedSerializer : KSerializer<Patient.Deceased> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Patient.Deceased") {
      element("deceasedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_deceasedBoolean", Element.serializer().descriptor, isOptional = true)
      element("deceasedDateTime", String.serializer().descriptor, isOptional = true)
      element("_deceasedDateTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Patient.Deceased) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Patient.Deceased.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Patient.Deceased.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Patient.Deceased =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Patient.Deceased {
    val __desc = descriptor
    var deceasedBoolean: KotlinBoolean? = null
    var _deceasedBoolean: Element? = null
    var deceasedDateTime: String? = null
    var _deceasedDateTime: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> deceasedBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> deceasedDateTime = decoder.decodeStringElement(__desc, 2)
        3 ->
          _deceasedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Patient.Deceased: " + __i)
      }
    }
    return Patient.Deceased.from(
      R5Boolean.of(deceasedBoolean, _deceasedBoolean),
      DateTime.of(FhirDateTime.fromString(deceasedDateTime), _deceasedDateTime),
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object PatientMultipleBirthSerializer : KSerializer<Patient.MultipleBirth> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Patient.MultipleBirth") {
      element("multipleBirthBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_multipleBirthBoolean", Element.serializer().descriptor, isOptional = true)
      element("multipleBirthInteger", Int.serializer().descriptor, isOptional = true)
      element("_multipleBirthInteger", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Patient.MultipleBirth) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Patient.MultipleBirth.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Patient.MultipleBirth.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Patient.MultipleBirth =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Patient.MultipleBirth {
    val __desc = descriptor
    var multipleBirthBoolean: KotlinBoolean? = null
    var _multipleBirthBoolean: Element? = null
    var multipleBirthInteger: Int? = null
    var _multipleBirthInteger: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> multipleBirthBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _multipleBirthBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> multipleBirthInteger = decoder.decodeIntElement(__desc, 2)
        3 ->
          _multipleBirthInteger =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding Patient.MultipleBirth: " + __i)
      }
    }
    return Patient.MultipleBirth.from(
      R5Boolean.of(multipleBirthBoolean, _multipleBirthBoolean),
      Integer.of(multipleBirthInteger, _multipleBirthInteger),
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object PatientSerializer : KSerializer<Patient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Patient") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_active", Element.serializer().descriptor, isOptional = true)
      element("name", listSerialDescriptor(HumanName.serializer().descriptor), isOptional = true)
      element(
        "telecom",
        listSerialDescriptor(ContactPoint.serializer().descriptor),
        isOptional = true,
      )
      element("gender", String.serializer().descriptor, isOptional = true)
      element("_gender", Element.serializer().descriptor, isOptional = true)
      element("birthDate", String.serializer().descriptor, isOptional = true)
      element("_birthDate", Element.serializer().descriptor, isOptional = true)
      element("deceasedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_deceasedBoolean", Element.serializer().descriptor, isOptional = true)
      element("deceasedDateTime", String.serializer().descriptor, isOptional = true)
      element("_deceasedDateTime", Element.serializer().descriptor, isOptional = true)
      element("address", listSerialDescriptor(Address.serializer().descriptor), isOptional = true)
      element("maritalStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("multipleBirthBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_multipleBirthBoolean", Element.serializer().descriptor, isOptional = true)
      element("multipleBirthInteger", Int.serializer().descriptor, isOptional = true)
      element("_multipleBirthInteger", Element.serializer().descriptor, isOptional = true)
      element("photo", listSerialDescriptor(Attachment.serializer().descriptor), isOptional = true)
      element(
        "contact",
        listSerialDescriptor(lazyDescriptor { Patient.Contact.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "communication",
        listSerialDescriptor(lazyDescriptor { Patient.Communication.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "generalPractitioner",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("managingOrganization", Reference.serializer().descriptor, isOptional = true)
      element(
        "link",
        listSerialDescriptor(lazyDescriptor { Patient.Link.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Patient =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Patient) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Patient {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> active = decoder.decodeBooleanElement(__desc, 12)
        13 ->
          _active =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> name = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.nameSer, null)
        15 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.telecomSer, null)
        16 -> gender = decoder.decodeStringElement(__desc, 16)
        17 ->
          _gender =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> birthDate = decoder.decodeStringElement(__desc, 18)
        19 ->
          _birthDate =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> deceasedBoolean = decoder.decodeBooleanElement(__desc, 20)
        21 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> deceasedDateTime = decoder.decodeStringElement(__desc, 22)
        23 ->
          _deceasedDateTime =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          address = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.addressSer, null)
        25 ->
          maritalStatus =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.maritalStatusSer, null)
        26 -> multipleBirthBoolean = decoder.decodeBooleanElement(__desc, 26)
        27 ->
          _multipleBirthBoolean =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> multipleBirthInteger = decoder.decodeIntElement(__desc, 28)
        29 ->
          _multipleBirthInteger =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> photo = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.photoSer, null)
        31 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.contactSer, null)
        32 ->
          communication =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.communicationSer, null)
        33 ->
          generalPractitioner =
            decoder.decodeNullableSerializableElement(
              __desc,
              33,
              Hoisted.generalPractitionerSer,
              null,
            )
        34 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(
              __desc,
              34,
              Hoisted.generalPractitionerSerInner,
              null,
            )
        35 -> link = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.linkSer, null)
        CompositeDecoder.DECODE_DONE -> break
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
      active = R5Boolean.of(active, _active),
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      gender = gender?.let { Enumeration.of(AdministrativeGender.fromCode(it), _gender) },
      birthDate = Date.of(FhirDate.fromString(birthDate), _birthDate),
      deceased =
        Patient.Deceased.from(
          R5Boolean.of(deceasedBoolean, _deceasedBoolean),
          DateTime.of(FhirDateTime.fromString(deceasedDateTime), _deceasedDateTime),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Patient) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Patient")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.active?.value))?.let { encoder.encodeBooleanElement(__desc, 12, it) }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.nameSer, value.name)
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.telecomSer, value.telecom)
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.birthDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.birthDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.deceased) {
      null -> {}
      is Patient.Deceased.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
        }
      }
      is Patient.Deceased.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.address.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.addressSer, value.address)
    (value.maritalStatus)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.maritalStatusSer, it)
    }
    when (val __d = value.multipleBirth) {
      null -> {}
      is Patient.MultipleBirth.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 26, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
        }
      }
      is Patient.MultipleBirth.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 28, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.photo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.photoSer, value.photo)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.contactSer, value.contact)
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.communicationSer, value.communication)
    if (value.generalPractitioner.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        33,
        Hoisted.generalPractitionerSer,
        value.generalPractitioner,
      )
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.generalPractitionerSerInner, it)
    }
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.linkSer, value.link)
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
