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
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Person
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.AdministrativeGender
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

internal object PersonLinkSerializer : KSerializer<Person.Link> {
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
      element("target", Reference.serializer().descriptor, isOptional = true)
      element("assurance", String.serializer().descriptor, isOptional = true)
      element("_assurance", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Person.Link =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Person.Link) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Person.Link {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var target: Reference? = null
    var assurance: String? = null
    var _assurance: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> target = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.targetSer, null)
        4 -> assurance = decoder.decodeStringElement(__desc, 4)
        5 ->
          _assurance =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.assuranceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + __i)
      }
    }
    return Person.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      target = target!!,
      assurance =
        assurance?.let { Enumeration.of(Person.IdentityAssuranceLevel.fromCode(it), _assurance) },
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Person.Link) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.target)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.targetSer, it) }
    ((value.assurance?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.assurance?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.assuranceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val targetSer: KSerializer<Reference> = Reference.serializer()

    public val assuranceSer: KSerializer<Element> = Element.serializer()
  }
}

internal object PersonSerializer : KSerializer<Person> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Person") {
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
      element("photo", Attachment.serializer().descriptor, isOptional = true)
      element("managingOrganization", Reference.serializer().descriptor, isOptional = true)
      element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_active", Element.serializer().descriptor, isOptional = true)
      element(
        "link",
        listSerialDescriptor(lazyDescriptor { Person.Link.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Person =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Person) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Person {
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
    var name: List<HumanName>? = null
    var telecom: List<ContactPoint>? = null
    var gender: String? = null
    var _gender: Element? = null
    var birthDate: String? = null
    var _birthDate: Element? = null
    var address: List<Address>? = null
    var photo: Attachment? = null
    var managingOrganization: Reference? = null
    var active: KotlinBoolean? = null
    var _active: Element? = null
    var link: List<Person.Link>? = null
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
        12 -> name = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.nameSer, null)
        13 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.telecomSer, null)
        14 -> gender = decoder.decodeStringElement(__desc, 14)
        15 ->
          _gender =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> birthDate = decoder.decodeStringElement(__desc, 16)
        17 ->
          _birthDate =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          address = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.addressSer, null)
        19 -> photo = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.photoSer, null)
        20 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(
              __desc,
              20,
              Hoisted.managingOrganizationSer,
              null,
            )
        21 -> active = decoder.decodeBooleanElement(__desc, 21)
        22 ->
          _active =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> link = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.linkSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Person: " + __i)
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
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      gender = gender?.let { Enumeration.of(AdministrativeGender.fromCode(it), _gender) },
      birthDate = Date.of(FhirDate.fromString(birthDate), _birthDate),
      address = address ?: listOf(),
      photo = photo,
      managingOrganization = managingOrganization,
      active = R4Boolean.of(active, _active),
      link = link ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Person) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Person")
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
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.nameSer, value.name)
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.telecomSer, value.telecom)
    ((value.gender?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.gender?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.birthDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.birthDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    if (value.address.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.addressSer, value.address)
    (value.photo)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.photoSer, it) }
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.managingOrganizationSer, it)
    }
    ((value.active?.value))?.let { encoder.encodeBooleanElement(__desc, 21, it) }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.linkSer, value.link)
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

    public val photoSer: KSerializer<Attachment> = Attachment.serializer()

    public val managingOrganizationSer: KSerializer<Reference> = Reference.serializer()

    public val linkSerInner: KSerializer<Person.Link> = Person.Link.serializer()

    public val linkSer: KSerializer<List<Person.Link>> = ListSerializer(Hoisted.linkSerInner)
  }
}
