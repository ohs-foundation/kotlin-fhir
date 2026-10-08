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
import dev.ohs.fhir.model.r5.terminologies.ConsentDataMeaning
import dev.ohs.fhir.model.r5.terminologies.ConsentProvisionType
import dev.ohs.fhir.model.r5.terminologies.ConsentState
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

  override fun deserialize(decoder: Decoder): Consent.PolicyBasis {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var url: String? = null
    var _url: Element? = null
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
          reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PolicyBasis: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Consent.PolicyBasis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference,
      url = Url.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Consent.PolicyBasis) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      ReferenceSerializer,
      value.reference,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.url)
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
      optionalElement("verificationType", CodeableConceptSerializer.descriptor)
      optionalElement("verifiedBy", ReferenceSerializer.descriptor)
      optionalElement("verifiedWith", ReferenceSerializer.descriptor)
      optionalElement("verificationDate", stringNullableListSerializer.descriptor)
      optionalElement("_verificationDate", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Consent.Verification>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Consent.Verification {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          verificationType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          verifiedBy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        7 ->
          verifiedWith =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 ->
          verificationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _verificationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
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
      CodeableConceptSerializer,
      value.verificationType,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      ReferenceSerializer,
      value.verifiedBy,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      ReferenceSerializer,
      value.verifiedWith,
    )
    if (value.verificationDate.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.verificationDate.map { it.value?.toString() },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.verificationDate)
    }
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): Consent.Provision {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        4 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentProvisionActorSerializer.listSerializer,
              null,
            )
        5 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 ->
          securityLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        7 ->
          purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        8 ->
          documentType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        9 ->
          resourceType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        10 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          dataPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        12 ->
          `data` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentProvisionDataSerializer.listSerializer,
              null,
            )
        13 ->
          expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
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
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, PeriodSerializer, value.period)
    if (value.actor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        ConsentProvisionActorSerializer.listSerializer,
        value.actor,
      )
    if (value.action.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        CodeableConceptSerializer.listSerializer,
        value.action,
      )
    if (value.securityLabel.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        CodingSerializer.listSerializer,
        value.securityLabel,
      )
    if (value.purpose.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        CodingSerializer.listSerializer,
        value.purpose,
      )
    if (value.documentType.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        CodingSerializer.listSerializer,
        value.documentType,
      )
    if (value.resourceType.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        CodingSerializer.listSerializer,
        value.resourceType,
      )
    if (value.code.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 11, PeriodSerializer, value.dataPeriod)
    if (value.`data`.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        ConsentProvisionDataSerializer.listSerializer,
        value.`data`,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      ExpressionSerializer,
      value.expression,
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
      role = role,
      reference = reference,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      ReferenceSerializer,
      value.reference,
    )
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
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        15 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        18 ->
          grantor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          grantee =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          manager =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        21 ->
          controller =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          sourceAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        23 ->
          sourceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          regulatoryBasis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        25 ->
          policyBasis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentPolicyBasisSerializer,
              null,
            )
        26 ->
          policyText =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          verification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConsentVerificationSerializer.listSerializer,
              null,
            )
        28 -> decision = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _decision =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          provision =
            compositeDecoder.decodeNullableSerializableElement(
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
        Enumeration.of(if (status != null) ConsentState.fromCode(status) else null, _status)
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
          if (decision != null) ConsentProvisionType.fromCode(decision) else null,
          _decision,
        ),
      provision = provision ?: listOf(),
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
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    if (value.grantor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.grantor,
      )
    if (value.grantee.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.grantee,
      )
    if (value.manager.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manager,
      )
    if (value.controller.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.controller,
      )
    if (value.sourceAttachment.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        AttachmentSerializer.listSerializer,
        value.sourceAttachment,
      )
    if (value.sourceReference.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.sourceReference,
      )
    if (value.regulatoryBasis.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.regulatoryBasis,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ConsentPolicyBasisSerializer,
      value.policyBasis,
    )
    if (value.policyText.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.policyText,
      )
    if (value.verification.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ConsentVerificationSerializer.listSerializer,
        value.verification,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.decision?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.decision)
    if (value.provision.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ConsentProvisionSerializer.listSerializer,
        value.provision,
      )
  }
}
