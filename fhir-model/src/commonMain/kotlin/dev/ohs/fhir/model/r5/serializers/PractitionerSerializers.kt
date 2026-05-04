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
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Practitioner
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.AdministrativeGender
import kotlin.Boolean as KotlinBoolean
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

internal object PractitionerQualificationSerializer : KSerializer<Practitioner.Qualification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Qualification") {
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element("issuer", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Practitioner.Qualification =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Practitioner.Qualification) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Practitioner.Qualification {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var code: CodeableConcept? = null
    var period: Period? = null
    var issuer: Reference? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 -> code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> period = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.periodSer, null)
        6 -> issuer = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.issuerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Qualification: " + __i)
      }
    }
    return Practitioner.Qualification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      code = code!!,
      period = period,
      issuer = issuer,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Practitioner.Qualification) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, value.identifier)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.periodSer, it) }
    (value.issuer)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.issuerSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val issuerSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object PractitionerCommunicationSerializer : KSerializer<Practitioner.Communication> {
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

  override fun deserialize(decoder: Decoder): Practitioner.Communication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Practitioner.Communication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Practitioner.Communication {
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
    return Practitioner.Communication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = language!!,
      preferred = R5Boolean.of(preferred, _preferred),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Practitioner.Communication) {
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

internal object PractitionerSerializer : KSerializer<Practitioner> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Practitioner") {
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
      element("photo", listSerialDescriptor(Attachment.serializer().descriptor), isOptional = true)
      element(
        "qualification",
        listSerialDescriptor(lazyDescriptor { Practitioner.Qualification.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "communication",
        listSerialDescriptor(lazyDescriptor { Practitioner.Communication.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Practitioner =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Practitioner) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Practitioner {
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
    var photo: List<Attachment>? = null
    var qualification: List<Practitioner.Qualification>? = null
    var communication: List<Practitioner.Communication>? = null
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
        25 -> photo = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.photoSer, null)
        26 ->
          qualification =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.qualificationSer, null)
        27 ->
          communication =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.communicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Practitioner: " + __i)
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
      active = R5Boolean.of(active, _active),
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      gender = gender?.let { Enumeration.of(AdministrativeGender.fromCode(it), _gender) },
      birthDate = Date.of(FhirDate.fromString(birthDate), _birthDate),
      deceased =
        Practitioner.Deceased.from(
          R5Boolean.of(deceasedBoolean, _deceasedBoolean),
          DateTime.of(FhirDateTime.fromString(deceasedDateTime), _deceasedDateTime),
        ),
      address = address ?: listOf(),
      photo = photo ?: listOf(),
      qualification = qualification ?: listOf(),
      communication = communication ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Practitioner) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Practitioner")
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
      is Practitioner.Deceased.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
        }
      }
      is Practitioner.Deceased.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.address.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.addressSer, value.address)
    if (value.photo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.photoSer, value.photo)
    if (value.qualification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.qualificationSer, value.qualification)
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.communicationSer, value.communication)
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

    public val photoSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val photoSer: KSerializer<List<Attachment>> = ListSerializer(Hoisted.photoSerInner)

    public val qualificationSerInner: KSerializer<Practitioner.Qualification> =
      Practitioner.Qualification.serializer()

    public val qualificationSer: KSerializer<List<Practitioner.Qualification>> =
      ListSerializer(Hoisted.qualificationSerInner)

    public val communicationSerInner: KSerializer<Practitioner.Communication> =
      Practitioner.Communication.serializer()

    public val communicationSer: KSerializer<List<Practitioner.Communication>> =
      ListSerializer(Hoisted.communicationSerInner)
  }
}
