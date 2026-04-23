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

import dev.ohs.fhir.model.r5.Availability
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
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

internal object PractitionerRoleSerializer : KSerializer<PractitionerRole> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PractitionerRole") {
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
      element("period", Period.serializer().descriptor, isOptional = true)
      element("practitioner", Reference.serializer().descriptor, isOptional = true)
      element("organization", Reference.serializer().descriptor, isOptional = true)
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialty",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "location",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "healthcareService",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "contact",
        listSerialDescriptor(ExtendedContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "characteristic",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "communication",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "availability",
        listSerialDescriptor(Availability.serializer().descriptor),
        isOptional = true,
      )
      element(
        "endpoint",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PractitionerRole =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PractitionerRole) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): PractitionerRole {
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
    var period: Period? = null
    var practitioner: Reference? = null
    var organization: Reference? = null
    var code: List<CodeableConcept>? = null
    var specialty: List<CodeableConcept>? = null
    var location: List<Reference>? = null
    var healthcareService: List<Reference>? = null
    var contact: List<ExtendedContactDetail>? = null
    var characteristic: List<CodeableConcept>? = null
    var communication: List<CodeableConcept>? = null
    var availability: List<Availability>? = null
    var endpoint: List<Reference>? = null
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
          period = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.periodSer, null)
        15 ->
          practitioner =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.practitionerSer, null)
        16 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.practitionerSer, null)
        17 -> code = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.codeSer, null)
        18 ->
          specialty = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.codeSer, null)
        19 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.locationSer, null)
        20 ->
          healthcareService =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.locationSer, null)
        21 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.contactSer, null)
        22 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.codeSer, null)
        23 ->
          communication =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.codeSer, null)
        24 ->
          availability =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.availabilitySer, null)
        25 ->
          endpoint =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.locationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PractitionerRole: " + __i)
      }
    }
    return PractitionerRole(
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
      period = period,
      practitioner = practitioner,
      organization = organization,
      code = code ?: listOf(),
      specialty = specialty ?: listOf(),
      location = location ?: listOf(),
      healthcareService = healthcareService ?: listOf(),
      contact = contact ?: listOf(),
      characteristic = characteristic ?: listOf(),
      communication = communication ?: listOf(),
      availability = availability ?: listOf(),
      endpoint = endpoint ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PractitionerRole) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "PractitionerRole")
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
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.periodSer, it) }
    (value.practitioner)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.practitionerSer, it)
    }
    (value.organization)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.practitionerSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.codeSer, value.code)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.codeSer, value.specialty)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.locationSer, value.location)
    if (value.healthcareService.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.locationSer, value.healthcareService)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.contactSer, value.contact)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.codeSer, value.characteristic)
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.codeSer, value.communication)
    if (value.availability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.availabilitySer, value.availability)
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.locationSer, value.endpoint)
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

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val practitionerSer: KSerializer<Reference> = Reference.serializer()

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val locationSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.practitionerSer)

    public val contactSerInner: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val contactSer: KSerializer<List<ExtendedContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val availabilitySerInner: KSerializer<Availability> = Availability.serializer()

    public val availabilitySer: KSerializer<List<Availability>> =
      ListSerializer(Hoisted.availabilitySerInner)
  }
}
