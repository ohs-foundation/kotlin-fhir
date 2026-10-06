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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Consent
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
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

internal object ConsentPolicyBasisSerializer : KSerializer<Consent.PolicyBasis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PolicyBasis") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
      optionalElement("url", String.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Consent.PolicyBasis>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Consent.PolicyBasis =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var reference: Reference? = null
      var url: String? = null
      var _url: Element? = null
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
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> url = decodeStringElement(descriptor, i)
          5 -> _url = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PolicyBasis: " + i)
        }
      }
      Consent.PolicyBasis(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        reference = reference,
        url = Url.of(url, _url),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Consent.PolicyBasis) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.reference)
      encodeStringIfNotNull(descriptor, 4, value.url?.value)
      encodeElementIfNotNull(descriptor, 5, value.url)
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
      optionalElement("verificationType", CodeableConceptSerializer.descriptor)
      optionalElement("verifiedBy", ReferenceSerializer.descriptor)
      optionalElement("verifiedWith", ReferenceSerializer.descriptor)
      optionalElement("verificationDate", stringNullableListSerializer.descriptor)
      optionalElement("_verificationDate", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Consent.Verification>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Consent.Verification =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var verified: KotlinBoolean? = null
      var _verified: Element? = null
      var verificationType: CodeableConcept? = null
      var verifiedBy: Reference? = null
      var verifiedWith: Reference? = null
      var verificationDate: List<String?>? = null
      var _verificationDate: List<Element?>? = null
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
            verificationType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            verifiedBy = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 ->
            verifiedWith =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            verificationDate =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          9 ->
            _verificationDate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Verification: " + i)
        }
      }
      Consent.Verification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        verified =
          R5Boolean.of(verified, _verified)
            ?: throw SerializationException(
              "Missing required property 'verified' on Consent.Verification"
            ),
        verificationType = verificationType,
        verifiedBy = verifiedBy,
        verifiedWith = verifiedWith,
        verificationDate =
          (kotlin.collections.List(
            maxOf(verificationDate?.size ?: 0, _verificationDate?.size ?: 0)
          ) { index ->
            DateTime.of(
              verificationDate?.getOrNull(index)?.let { FhirDateTime.fromString(it) },
              _verificationDate?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'verificationDate' on Consent.Verification has neither a value nor an id/extension"
              )
          }),
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
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.verificationType)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.verifiedBy)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.verifiedWith)
      if (value.verificationDate.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          8,
          stringNullableListSerializer,
          value.verificationDate.map { it.value?.toString() },
        )
        encodePrimitiveElementList(descriptor, 9, value.verificationDate)
      }
    }
  }
}

internal object ConsentProvisionSerializer : KSerializer<Consent.Provision> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Provision") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("actor", ConsentProvisionActorSerializer.listSerializer.descriptor)
      optionalElement("action", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("securityLabel", CodingSerializer.listSerializer.descriptor)
      optionalElement("purpose", CodingSerializer.listSerializer.descriptor)
      optionalElement("documentType", CodingSerializer.listSerializer.descriptor)
      optionalElement("resourceType", CodingSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("dataPeriod", PeriodSerializer.descriptor)
      optionalElement("data", ConsentProvisionDataSerializer.listSerializer.descriptor)
      optionalElement("expression", ExpressionSerializer.descriptor)
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
      var period: Period? = null
      var actor: List<Consent.Provision.Actor>? = null
      var action: List<CodeableConcept>? = null
      var securityLabel: List<Coding>? = null
      var purpose: List<Coding>? = null
      var documentType: List<Coding>? = null
      var resourceType: List<Coding>? = null
      var code: List<CodeableConcept>? = null
      var dataPeriod: Period? = null
      var `data`: List<Consent.Provision.Data>? = null
      var expression: Expression? = null
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
          3 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          4 ->
            actor =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ConsentProvisionActorSerializer.listSerializer,
                null,
              )
          5 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            securityLabel =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          7 ->
            purpose =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          8 ->
            documentType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          9 ->
            resourceType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          10 ->
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          11 ->
            dataPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          12 ->
            `data` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ConsentProvisionDataSerializer.listSerializer,
                null,
              )
          13 ->
            expression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
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
        period = period,
        actor = actor ?: listOf(),
        action = action ?: listOf(),
        securityLabel = securityLabel ?: listOf(),
        purpose = purpose ?: listOf(),
        documentType = documentType ?: listOf(),
        resourceType = resourceType ?: listOf(),
        code = code ?: listOf(),
        dataPeriod = dataPeriod,
        `data` = `data` ?: listOf(),
        expression = expression,
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
      encodeSerializableIfNotNull(descriptor, 3, PeriodSerializer, value.period)
      if (value.actor.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ConsentProvisionActorSerializer.listSerializer,
          value.actor,
        )
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.action,
        )
      if (value.securityLabel.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodingSerializer.listSerializer,
          value.securityLabel,
        )
      if (value.purpose.isNotEmpty())
        encodeSerializableElement(descriptor, 7, CodingSerializer.listSerializer, value.purpose)
      if (value.documentType.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodingSerializer.listSerializer,
          value.documentType,
        )
      if (value.resourceType.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CodingSerializer.listSerializer,
          value.resourceType,
        )
      if (value.code.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CodeableConceptSerializer.listSerializer,
          value.code,
        )
      encodeSerializableIfNotNull(descriptor, 11, PeriodSerializer, value.dataPeriod)
      if (value.`data`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          ConsentProvisionDataSerializer.listSerializer,
          value.`data`,
        )
      encodeSerializableIfNotNull(descriptor, 13, ExpressionSerializer, value.expression)
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
        role = role,
        reference = reference,
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.role)
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.reference)
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
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("date", String.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("grantor", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("grantee", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("manager", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("controller", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("sourceAttachment", AttachmentSerializer.listSerializer.descriptor)
    b.optionalElement("sourceReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("regulatoryBasis", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("policyBasis", ConsentPolicyBasisSerializer.descriptor)
    b.optionalElement("policyText", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("verification", ConsentVerificationSerializer.listSerializer.descriptor)
    b.optionalElement("decision", String.serializer().descriptor)
    b.optionalElement("_decision", ElementSerializer.descriptor)
    b.optionalElement("provision", ConsentProvisionSerializer.listSerializer.descriptor)
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
    var category: List<CodeableConcept>? = null
    var subject: Reference? = null
    var date: String? = null
    var _date: Element? = null
    var period: Period? = null
    var grantor: List<Reference>? = null
    var grantee: List<Reference>? = null
    var manager: List<Reference>? = null
    var controller: List<Reference>? = null
    var sourceAttachment: List<Attachment>? = null
    var sourceReference: List<Reference>? = null
    var regulatoryBasis: List<CodeableConcept>? = null
    var policyBasis: Consent.PolicyBasis? = null
    var policyText: List<Reference>? = null
    var verification: List<Consent.Verification>? = null
    var decision: String? = null
    var _decision: Element? = null
    var provision: List<Consent.Provision>? = null
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
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        15 -> date = decoder.decodeStringElement(descriptor, i)
        16 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        18 ->
          grantor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          grantee =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          manager =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        21 ->
          controller =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          sourceAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        23 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          regulatoryBasis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        25 ->
          policyBasis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentPolicyBasisSerializer,
              null,
            )
        26 ->
          policyText =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          verification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentVerificationSerializer.listSerializer,
              null,
            )
        28 -> decision = decoder.decodeStringElement(descriptor, i)
        29 ->
          _decision =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          provision =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentProvisionSerializer.listSerializer,
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
      category = category ?: listOf(),
      subject = subject,
      date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
      period = period,
      grantor = grantor ?: listOf(),
      grantee = grantee ?: listOf(),
      manager = manager ?: listOf(),
      controller = controller ?: listOf(),
      sourceAttachment = sourceAttachment ?: listOf(),
      sourceReference = sourceReference ?: listOf(),
      regulatoryBasis = regulatoryBasis ?: listOf(),
      policyBasis = policyBasis,
      policyText = policyText ?: listOf(),
      verification = verification ?: listOf(),
      decision =
        Enumeration.of(
          if (decision != null) Consent.ConsentProvisionType.fromCode(decision) else null,
          _decision,
        ),
      provision = provision ?: listOf(),
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.date)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    if (value.grantor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.grantor,
      )
    if (value.grantee.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.grantee,
      )
    if (value.manager.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manager,
      )
    if (value.controller.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.controller,
      )
    if (value.sourceAttachment.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        AttachmentSerializer.listSerializer,
        value.sourceAttachment,
      )
    if (value.sourceReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.sourceReference,
      )
    if (value.regulatoryBasis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.regulatoryBasis,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ConsentPolicyBasisSerializer,
      value.policyBasis,
    )
    if (value.policyText.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.policyText,
      )
    if (value.verification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ConsentVerificationSerializer.listSerializer,
        value.verification,
      )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.decision?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.decision)
    if (value.provision.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ConsentProvisionSerializer.listSerializer,
        value.provision,
      )
  }
}
