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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Consent
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.ConsentDataMeaning
import dev.ohs.fhir.model.r4.terminologies.ConsentProvisionType
import dev.ohs.fhir.model.r4.terminologies.ConsentState
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

internal object ConsentPolicySerializer : KSerializer<Consent.Policy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Policy") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("authority", String.serializer().descriptor)
      optionalElement("_authority", ElementSerializer.descriptor)
      optionalElement("uri", String.serializer().descriptor)
      optionalElement("_uri", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Consent.Policy>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Consent.Policy {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var authority: String? = null
    var _authority: Element? = null
    var uri: String? = null
    var _uri: Element? = null
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
        3 -> authority = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _authority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> uri = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _uri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Policy: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Consent.Policy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      authority = Uri.of(authority, _authority),
      uri = Uri.of(uri, _uri),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Consent.Policy) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.authority?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.authority)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.uri?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.uri)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConsentVerificationSerializer : KSerializer<Consent.Verification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Verification") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("verified", KotlinBoolean.serializer().descriptor)
      optionalElement("_verified", ElementSerializer.descriptor)
      optionalElement("verifiedWith", ReferenceSerializer.descriptor)
      optionalElement("verificationDate", String.serializer().descriptor)
      optionalElement("_verificationDate", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Consent.Verification>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Consent.Verification {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var verified: KotlinBoolean? = null
    var _verified: Element? = null
    var verifiedWith: Reference? = null
    var verificationDate: String? = null
    var _verificationDate: Element? = null
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
        3 -> verified = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _verified =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          verifiedWith =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 -> verificationDate = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _verificationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Verification: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Consent.Verification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      verified =
        R4Boolean.of(verified, _verified)
          ?: throw SerializationException(
            "Missing required property 'verified' on Consent.Verification"
          ),
      verifiedWith = verifiedWith,
      verificationDate =
        DateTime.of(
          if (verificationDate != null) FhirDateTime.fromString(verificationDate) else null,
          _verificationDate,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Consent.Verification) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.verified.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.verified)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      ReferenceSerializer,
      value.verifiedWith,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.verificationDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.verificationDate)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConsentProvisionSerializer : KSerializer<Consent.Provision> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Provision") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", String.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("actor", ConsentProvisionActorSerializer.listSerializer.descriptor)
      optionalElement("action", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("securityLabel", CodingSerializer.listSerializer.descriptor)
      optionalElement("purpose", CodingSerializer.listSerializer.descriptor)
      optionalElement("class", CodingSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("dataPeriod", PeriodSerializer.descriptor)
      optionalElement("data", ConsentProvisionDataSerializer.listSerializer.descriptor)
      optionalElement(
        "provision",
        listSerialDescriptor(lazyDescriptor { ConsentProvisionSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Consent.Provision>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Consent.Provision {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: String? = null
    var _type: Element? = null
    var period: Period? = null
    var actor: List<Consent.Provision.Actor>? = null
    var action: List<CodeableConcept>? = null
    var securityLabel: List<Coding>? = null
    var purpose: List<Coding>? = null
    var `class`: List<Coding>? = null
    var code: List<CodeableConcept>? = null
    var dataPeriod: Period? = null
    var `data`: List<Consent.Provision.Data>? = null
    var provision: List<Consent.Provision>? = null
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
        3 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        6 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentProvisionActorSerializer.listSerializer,
              null,
            )
        7 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          securityLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        9 ->
          purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        10 ->
          `class` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        11 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          dataPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        13 ->
          `data` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentProvisionDataSerializer.listSerializer,
              null,
            )
        14 ->
          provision =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentProvisionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Provision: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Consent.Provision(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(if (type != null) ConsentProvisionType.fromCode(type) else null, _type),
      period = period,
      actor = actor ?: listOf(),
      action = action ?: listOf(),
      securityLabel = securityLabel ?: listOf(),
      purpose = purpose ?: listOf(),
      `class` = `class` ?: listOf(),
      code = code ?: listOf(),
      dataPeriod = dataPeriod,
      `data` = `data` ?: listOf(),
      provision = provision ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, PeriodSerializer, value.period)
    if (value.actor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        ConsentProvisionActorSerializer.listSerializer,
        value.actor,
      )
    if (value.action.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.action,
      )
    if (value.securityLabel.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        CodingSerializer.listSerializer,
        value.securityLabel,
      )
    if (value.purpose.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        CodingSerializer.listSerializer,
        value.purpose,
      )
    if (value.`class`.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        CodingSerializer.listSerializer,
        value.`class`,
      )
    if (value.code.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 12, PeriodSerializer, value.dataPeriod)
    if (value.`data`.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13,
        ConsentProvisionDataSerializer.listSerializer,
        value.`data`,
      )
    if (value.provision.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        14,
        ConsentProvisionSerializer.listSerializer,
        value.provision,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConsentProvisionActorSerializer : KSerializer<Consent.Provision.Actor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Actor") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Consent.Provision.Actor>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Consent.Provision.Actor {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: CodeableConcept? = null
    var reference: Reference? = null
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
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Actor: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Consent.Provision.Actor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role =
        role
          ?: throw SerializationException(
            "Missing required property 'role' on Consent.Provision.Actor"
          ),
      reference =
        reference
          ?: throw SerializationException(
            "Missing required property 'reference' on Consent.Provision.Actor"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Actor) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.role)
    compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.reference)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConsentProvisionDataSerializer : KSerializer<Consent.Provision.Data> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Data") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("meaning", String.serializer().descriptor)
      optionalElement("_meaning", ElementSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Consent.Provision.Data>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Consent.Provision.Data {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var meaning: String? = null
    var _meaning: Element? = null
    var reference: Reference? = null
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
        3 -> meaning = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _meaning =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Data: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Consent.Provision.Data(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      meaning =
        Enumeration.of(
          if (meaning != null) ConsentDataMeaning.fromCode(meaning) else null,
          _meaning,
        )
          ?: throw SerializationException(
            "Missing required property 'meaning' on Consent.Provision.Data"
          ),
      reference =
        reference
          ?: throw SerializationException(
            "Missing required property 'reference' on Consent.Provision.Data"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Data) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.meaning.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.meaning)
    compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.reference)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ConsentSerializer : FhirResourceSerializer<Consent> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Consent")

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
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("scope", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("dateTime", String.serializer().descriptor)
    b.optionalElement("_dateTime", ElementSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("organization", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("sourceAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("sourceReference", ReferenceSerializer.descriptor)
    b.optionalElement("policy", ConsentPolicySerializer.listSerializer.descriptor)
    b.optionalElement("policyRule", CodeableConceptSerializer.descriptor)
    b.optionalElement("verification", ConsentVerificationSerializer.listSerializer.descriptor)
    b.optionalElement("provision", ConsentProvisionSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Consent {
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
    var status: String? = null
    var _status: Element? = null
    var scope: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var patient: Reference? = null
    var dateTime: String? = null
    var _dateTime: Element? = null
    var performer: List<Reference>? = null
    var organization: List<Reference>? = null
    var sourceAttachment: Attachment? = null
    var sourceReference: Reference? = null
    var policy: List<Consent.Policy>? = null
    var policyRule: CodeableConcept? = null
    var verification: List<Consent.Verification>? = null
    var provision: Consent.Provision? = null
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
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          scope =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 -> dateTime = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _dateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          organization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          sourceAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        21 ->
          sourceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          policy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentPolicySerializer.listSerializer,
              null,
            )
        23 ->
          policyRule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        24 ->
          verification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentVerificationSerializer.listSerializer,
              null,
            )
        25 ->
          provision =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentProvisionSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Consent: " + i)
      }
    }
    return Consent(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(if (status != null) ConsentState.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Consent"),
      scope = scope ?: throw SerializationException("Missing required property 'scope' on Consent"),
      category = category ?: listOf(),
      patient = patient,
      dateTime =
        DateTime.of(if (dateTime != null) FhirDateTime.fromString(dateTime) else null, _dateTime),
      performer = performer ?: listOf(),
      organization = organization ?: listOf(),
      source = Consent.Source.from(sourceAttachment, sourceReference),
      policy = policy ?: listOf(),
      policyRule = policyRule,
      verification = verification ?: listOf(),
      provision = provision,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Consent,
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.scope,
    )
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.dateTime?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.dateTime)
    if (value.performer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.performer,
      )
    if (value.organization.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.organization,
      )
    when (val choice = value.source) {
      null -> {}
      is Consent.Source.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          20 + descriptorOffset,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Consent.Source.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    if (value.policy.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        ConsentPolicySerializer.listSerializer,
        value.policy,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      CodeableConceptSerializer,
      value.policyRule,
    )
    if (value.verification.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ConsentVerificationSerializer.listSerializer,
        value.verification,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ConsentProvisionSerializer,
      value.provision,
    )
  }
}
