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
import kotlin.Int
import kotlin.String as KotlinString
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 -> comment = decoder.decodeStringElement(__desc, __i)
        5 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.commentSer, null)
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
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
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
    b.element("providedBy", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "offeredIn",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "type",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specialty",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "location",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("comment", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_comment", Element.serializer().descriptor, isOptional = true)
    b.element("extraDetails", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_extraDetails", Element.serializer().descriptor, isOptional = true)
    b.element("photo", Attachment.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ExtendedContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "coverageArea",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "serviceProvisionCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "eligibility",
      listSerialDescriptor(
        lazyDescriptor { HealthcareService.Eligibility.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "program",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "characteristic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "communication",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "referralMethod",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("appointmentRequired", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_appointmentRequired", Element.serializer().descriptor, isOptional = true)
    b.element(
      "availability",
      listSerialDescriptor(Availability.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): HealthcareService =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: HealthcareService) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "HealthcareService")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): HealthcareService {
    val __desc = desc
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
        13 ->
          providedBy =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.providedBySer, null)
        14 ->
          offeredIn =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.offeredInSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        16 ->
          type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        17 ->
          specialty =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        18 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.offeredInSer, null)
        19 -> name = decoder.decodeStringElement(__desc, __i)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> comment = decoder.decodeStringElement(__desc, __i)
        22 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> extraDetails = decoder.decodeStringElement(__desc, __i)
        24 ->
          _extraDetails =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 -> photo = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.photoSer, null)
        26 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        27 ->
          coverageArea =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.offeredInSer, null)
        28 ->
          serviceProvisionCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        29 ->
          eligibility =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eligibilitySer, null)
        30 ->
          program =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        31 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        32 ->
          communication =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        33 ->
          referralMethod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        34 -> appointmentRequired = decoder.decodeBooleanElement(__desc, __i)
        35 ->
          _appointmentRequired =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        36 ->
          availability =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.availabilitySer, null)
        37 ->
          endpoint =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.offeredInSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: HealthcareService,
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
    (value.providedBy)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.providedBySer, it)
    }
    if (value.offeredIn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.offeredInSer, value.offeredIn)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.categorySer, value.category)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.categorySer, value.type)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.categorySer, value.specialty)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.offeredInSer, value.location)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.extraDetails?.value))?.let { encoder.encodeStringElement(__desc, 23 + __off, it) }
    (value.extraDetails?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.photo)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.photoSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.contactSer, value.contact)
    if (value.coverageArea.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        27 + __off,
        Hoisted.offeredInSer,
        value.coverageArea,
      )
    if (value.serviceProvisionCode.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        28 + __off,
        Hoisted.categorySer,
        value.serviceProvisionCode,
      )
    if (value.eligibility.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
        Hoisted.eligibilitySer,
        value.eligibility,
      )
    if (value.program.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.categorySer, value.program)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        31 + __off,
        Hoisted.categorySer,
        value.characteristic,
      )
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        32 + __off,
        Hoisted.categorySer,
        value.communication,
      )
    if (value.referralMethod.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        33 + __off,
        Hoisted.categorySer,
        value.referralMethod,
      )
    ((value.appointmentRequired?.value))?.let {
      encoder.encodeBooleanElement(__desc, 34 + __off, it)
    }
    (value.appointmentRequired?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.availability.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        36 + __off,
        Hoisted.availabilitySer,
        value.availability,
      )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.offeredInSer, value.endpoint)
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

internal object HealthcareServicePolymorphicSerializer : KSerializer<HealthcareService> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("HealthcareService") {
      HealthcareServiceSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: HealthcareService) {
    encoder.encodeStructure(descriptor) {
      HealthcareServiceSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): HealthcareService =
    decoder.decodeStructure(descriptor) {
      HealthcareServiceSerializer.deserializeJson(this, descriptor, 0)
    }
}
