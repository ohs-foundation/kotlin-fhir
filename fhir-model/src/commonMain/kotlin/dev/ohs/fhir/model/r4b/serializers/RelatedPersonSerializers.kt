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
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedPerson
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.AdministrativeGender
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

internal object RelatedPersonCommunicationSerializer : KSerializer<RelatedPerson.Communication> {
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

  override fun deserialize(decoder: Decoder): RelatedPerson.Communication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RelatedPerson.Communication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RelatedPerson.Communication {
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
    return RelatedPerson.Communication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = language!!,
      preferred = R4bBoolean.of(preferred, _preferred),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RelatedPerson.Communication) {
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

internal object RelatedPersonSerializer : KSerializer<RelatedPerson> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedPerson") {
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
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element(
        "relationship",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
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
      element("address", listSerialDescriptor(Address.serializer().descriptor), isOptional = true)
      element("photo", listSerialDescriptor(Attachment.serializer().descriptor), isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element(
        "communication",
        listSerialDescriptor(
          lazyDescriptor { RelatedPerson.Communication.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RelatedPerson =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RelatedPerson) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): RelatedPerson {
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
    var patient: Reference? = null
    var relationship: List<CodeableConcept>? = null
    var name: List<HumanName>? = null
    var telecom: List<ContactPoint>? = null
    var gender: String? = null
    var _gender: Element? = null
    var birthDate: String? = null
    var _birthDate: Element? = null
    var address: List<Address>? = null
    var photo: List<Attachment>? = null
    var period: Period? = null
    var communication: List<RelatedPerson.Communication>? = null
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
        14 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.patientSer, null)
        15 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.relationshipSer, null)
        16 -> name = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.nameSer, null)
        17 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.telecomSer, null)
        18 -> gender = decoder.decodeStringElement(__desc, 18)
        19 ->
          _gender =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> birthDate = decoder.decodeStringElement(__desc, 20)
        21 ->
          _birthDate =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          address = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.addressSer, null)
        23 -> photo = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.photoSer, null)
        24 ->
          period = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.periodSer, null)
        25 ->
          communication =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.communicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedPerson: " + __i)
      }
    }
    return RelatedPerson(
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
      patient = patient!!,
      relationship = relationship ?: listOf(),
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      gender = gender?.let { Enumeration.of(AdministrativeGender.fromCode(it), _gender) },
      birthDate = Date.of(FhirDate.fromString(birthDate), _birthDate),
      address = address ?: listOf(),
      photo = photo ?: listOf(),
      period = period,
      communication = communication ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RelatedPerson) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "RelatedPerson")
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
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.patientSer, it) }
    if (value.relationship.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.relationshipSer, value.relationship)
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.nameSer, value.name)
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.telecomSer, value.telecom)
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.birthDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.birthDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    if (value.address.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.addressSer, value.address)
    if (value.photo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.photoSer, value.photo)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.periodSer, it) }
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.communicationSer, value.communication)
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

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val relationshipSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val relationshipSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.relationshipSerInner)

    public val nameSerInner: KSerializer<HumanName> = HumanName.serializer()

    public val nameSer: KSerializer<List<HumanName>> = ListSerializer(Hoisted.nameSerInner)

    public val telecomSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val telecomSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.telecomSerInner)

    public val addressSerInner: KSerializer<Address> = Address.serializer()

    public val addressSer: KSerializer<List<Address>> = ListSerializer(Hoisted.addressSerInner)

    public val photoSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val photoSer: KSerializer<List<Attachment>> = ListSerializer(Hoisted.photoSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val communicationSerInner: KSerializer<RelatedPerson.Communication> =
      RelatedPerson.Communication.serializer()

    public val communicationSer: KSerializer<List<RelatedPerson.Communication>> =
      ListSerializer(Hoisted.communicationSerInner)
  }
}
