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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Consent
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.Uri
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

  override fun deserialize(decoder: Decoder): Consent.Policy =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var authority: String? = null
      var _authority: Element? = null
      var uri: String? = null
      var _uri: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> authority = decodeStringElement(descriptor, i)
          4 ->
            _authority = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> uri = decodeStringElement(descriptor, i)
          6 -> _uri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Policy: " + i)
        }
      }
      Consent.Policy(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        authority = Uri.of(authority, _authority),
        uri = Uri.of(uri, _uri),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Consent.Policy) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.authority?.value)
      encodeElementIfNotNull(descriptor, 4, value.authority)
      encodeStringIfNotNull(descriptor, 5, value.uri?.value)
      encodeElementIfNotNull(descriptor, 6, value.uri)
    }
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

  override fun deserialize(decoder: Decoder): Consent.Verification =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var verified: KotlinBoolean? = null
      var _verified: Element? = null
      var verifiedWith: Reference? = null
      var verificationDate: String? = null
      var _verificationDate: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> verified = decodeBooleanElement(descriptor, i)
          4 -> _verified = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            verifiedWith =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> verificationDate = decodeStringElement(descriptor, i)
          7 ->
            _verificationDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Verification: " + i)
        }
      }
      Consent.Verification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        verified =
          R4bBoolean.of(verified, _verified)
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeBooleanIfNotNull(descriptor, 3, value.verified.value)
      encodeElementIfNotNull(descriptor, 4, value.verified)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.verifiedWith)
      encodeStringIfNotNull(descriptor, 6, value.verificationDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.verificationDate)
    }
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

  override fun deserialize(decoder: Decoder): Consent.Provision =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          6 ->
            actor =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ConsentProvisionActorSerializer.listSerializer,
                null,
              )
          7 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 ->
            securityLabel =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          9 ->
            purpose =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          10 ->
            `class` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          11 ->
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          12 ->
            dataPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          13 ->
            `data` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ConsentProvisionDataSerializer.listSerializer,
                null,
              )
          14 ->
            provision =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ConsentProvisionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Provision: " + i)
        }
      }
      Consent.Provision(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) Consent.ConsentProvisionType.fromCode(type) else null,
            _type,
          ),
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeSerializableIfNotNull(descriptor, 5, PeriodSerializer, value.period)
      if (value.actor.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ConsentProvisionActorSerializer.listSerializer,
          value.actor,
        )
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.action,
        )
      if (value.securityLabel.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodingSerializer.listSerializer,
          value.securityLabel,
        )
      if (value.purpose.isNotEmpty())
        encodeSerializableElement(descriptor, 9, CodingSerializer.listSerializer, value.purpose)
      if (value.`class`.isNotEmpty())
        encodeSerializableElement(descriptor, 10, CodingSerializer.listSerializer, value.`class`)
      if (value.code.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer.listSerializer,
          value.code,
        )
      encodeSerializableIfNotNull(descriptor, 12, PeriodSerializer, value.dataPeriod)
      if (value.`data`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          ConsentProvisionDataSerializer.listSerializer,
          value.`data`,
        )
      if (value.provision.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          ConsentProvisionSerializer.listSerializer,
          value.provision,
        )
    }
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

  override fun deserialize(decoder: Decoder): Consent.Provision.Actor =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var role: CodeableConcept? = null
      var reference: Reference? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Actor: " + i)
        }
      }
      Consent.Provision.Actor(
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.role)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.reference)
    }
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

  override fun deserialize(decoder: Decoder): Consent.Provision.Data =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var meaning: String? = null
      var _meaning: Element? = null
      var reference: Reference? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> meaning = decodeStringElement(descriptor, i)
          4 -> _meaning = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Data: " + i)
        }
      }
      Consent.Provision.Data(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        meaning =
          Enumeration.of(
            if (meaning != null) Consent.ConsentDataMeaning.fromCode(meaning) else null,
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
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.meaning.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.meaning)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.reference)
    }
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
    decoder: CompositeDecoder,
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          scope =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 -> dateTime = decoder.decodeStringElement(descriptor, i)
        17 ->
          _dateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          organization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          sourceAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        21 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          policy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentPolicySerializer.listSerializer,
              null,
            )
        23 ->
          policyRule =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        24 ->
          verification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentVerificationSerializer.listSerializer,
              null,
            )
        25 ->
          provision =
            decoder.decodeNullableSerializableElement(
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
        Enumeration.of(if (status != null) Consent.ConsentState.fromCode(status) else null, _status)
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
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Consent,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.scope,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.dateTime?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.dateTime)
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.performer,
      )
    if (value.organization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.organization,
      )
    when (val choice = value.source) {
      null -> {}
      is Consent.Source.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          20 + descriptorOffset,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Consent.Source.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    if (value.policy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        ConsentPolicySerializer.listSerializer,
        value.policy,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      CodeableConceptSerializer,
      value.policyRule,
    )
    if (value.verification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ConsentVerificationSerializer.listSerializer,
        value.verification,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ConsentProvisionSerializer,
      value.provision,
    )
  }
}
