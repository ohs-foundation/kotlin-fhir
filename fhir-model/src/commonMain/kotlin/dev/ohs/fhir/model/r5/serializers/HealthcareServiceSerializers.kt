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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Availability
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.HealthcareService
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
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

internal object HealthcareServiceEligibilitySerializer :
  KSerializer<HealthcareService.Eligibility> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Eligibility") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): HealthcareService.Eligibility =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: HealthcareService.Eligibility) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): HealthcareService.Eligibility {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> comment = decoder.decodeStringElement(__desc, 4)
        5 ->
          _comment = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.commentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Eligibility: " + __i)
      }
    }
    return HealthcareService.Eligibility(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      comment = Markdown.of(comment, _comment),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: HealthcareService.Eligibility) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.commentSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val commentSer: KSerializer<Element> = Element.serializer()
  }
}

internal object HealthcareServiceSerializer : KSerializer<HealthcareService> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("HealthcareService") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
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
      element("providedBy", Reference.serializer().descriptor, isOptional = true)
      element(
        "offeredIn",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "type",
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element("extraDetails", KotlinString.serializer().descriptor, isOptional = true)
      element("_extraDetails", Element.serializer().descriptor, isOptional = true)
      element("photo", Attachment.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ExtendedContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "coverageArea",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "serviceProvisionCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "eligibility",
        listSerialDescriptor(
          lazyDescriptor { HealthcareService.Eligibility.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "program",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
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
        "referralMethod",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("appointmentRequired", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_appointmentRequired", Element.serializer().descriptor, isOptional = true)
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

  override fun deserialize(decoder: Decoder): HealthcareService =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: HealthcareService) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): HealthcareService {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var active: KotlinBoolean? = null
    var _active: Element? = null
    var providedBy: Reference? = null
    var offeredIn: List<Reference>? = null
    var category: List<CodeableConcept>? = null
    var type: List<CodeableConcept>? = null
    var specialty: List<CodeableConcept>? = null
    var location: List<Reference>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var extraDetails: KotlinString? = null
    var _extraDetails: Element? = null
    var photo: Attachment? = null
    var contact: List<ExtendedContactDetail>? = null
    var coverageArea: List<Reference>? = null
    var serviceProvisionCode: List<CodeableConcept>? = null
    var eligibility: List<HealthcareService.Eligibility>? = null
    var program: List<CodeableConcept>? = null
    var characteristic: List<CodeableConcept>? = null
    var communication: List<CodeableConcept>? = null
    var referralMethod: List<CodeableConcept>? = null
    var appointmentRequired: KotlinBoolean? = null
    var _appointmentRequired: Element? = null
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
          providedBy =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.providedBySer, null)
        15 ->
          offeredIn =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.offeredInSer, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.categorySer, null)
        17 ->
          type = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.categorySer, null)
        18 ->
          specialty =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.categorySer, null)
        19 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.offeredInSer, null)
        20 -> name = decoder.decodeStringElement(__desc, 20)
        21 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> comment = decoder.decodeStringElement(__desc, 22)
        23 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> extraDetails = decoder.decodeStringElement(__desc, 24)
        25 ->
          _extraDetails =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> photo = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.photoSer, null)
        27 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.contactSer, null)
        28 ->
          coverageArea =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.offeredInSer, null)
        29 ->
          serviceProvisionCode =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.categorySer, null)
        30 ->
          eligibility =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.eligibilitySer, null)
        31 ->
          program = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.categorySer, null)
        32 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.categorySer, null)
        33 ->
          communication =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.categorySer, null)
        34 ->
          referralMethod =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.categorySer, null)
        35 -> appointmentRequired = decoder.decodeBooleanElement(__desc, 35)
        36 ->
          _appointmentRequired =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 ->
          availability =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.availabilitySer, null)
        38 ->
          endpoint =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.offeredInSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding HealthcareService: " + __i)
      }
    }
    return HealthcareService(
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
      providedBy = providedBy,
      offeredIn = offeredIn ?: listOf(),
      category = category ?: listOf(),
      type = type ?: listOf(),
      specialty = specialty ?: listOf(),
      location = location ?: listOf(),
      name = R5String.of(name, _name),
      comment = Markdown.of(comment, _comment),
      extraDetails = Markdown.of(extraDetails, _extraDetails),
      photo = photo,
      contact = contact ?: listOf(),
      coverageArea = coverageArea ?: listOf(),
      serviceProvisionCode = serviceProvisionCode ?: listOf(),
      eligibility = eligibility ?: listOf(),
      program = program ?: listOf(),
      characteristic = characteristic ?: listOf(),
      communication = communication ?: listOf(),
      referralMethod = referralMethod ?: listOf(),
      appointmentRequired = R5Boolean.of(appointmentRequired, _appointmentRequired),
      availability = availability ?: listOf(),
      endpoint = endpoint ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: HealthcareService) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "HealthcareService")
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
    (value.providedBy)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.providedBySer, it)
    }
    if (value.offeredIn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.offeredInSer, value.offeredIn)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.categorySer, value.category)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.categorySer, value.type)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.categorySer, value.specialty)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.offeredInSer, value.location)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.extraDetails?.value))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.extraDetails?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    (value.photo)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.photoSer, it) }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.contactSer, value.contact)
    if (value.coverageArea.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.offeredInSer, value.coverageArea)
    if (value.serviceProvisionCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.categorySer, value.serviceProvisionCode)
    if (value.eligibility.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.eligibilitySer, value.eligibility)
    if (value.program.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.categorySer, value.program)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.categorySer, value.characteristic)
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.categorySer, value.communication)
    if (value.referralMethod.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.categorySer, value.referralMethod)
    ((value.appointmentRequired?.value))?.let { encoder.encodeBooleanElement(__desc, 35, it) }
    (value.appointmentRequired?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    if (value.availability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.availabilitySer, value.availability)
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.offeredInSer, value.endpoint)
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

    public val providedBySer: KSerializer<Reference> = Reference.serializer()

    public val offeredInSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.providedBySer)

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val photoSer: KSerializer<Attachment> = Attachment.serializer()

    public val contactSerInner: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val contactSer: KSerializer<List<ExtendedContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val eligibilitySerInner: KSerializer<HealthcareService.Eligibility> =
      HealthcareService.Eligibility.serializer()

    public val eligibilitySer: KSerializer<List<HealthcareService.Eligibility>> =
      ListSerializer(Hoisted.eligibilitySerInner)

    public val availabilitySerInner: KSerializer<Availability> = Availability.serializer()

    public val availabilitySer: KSerializer<List<Availability>> =
      ListSerializer(Hoisted.availabilitySerInner)
  }
}
