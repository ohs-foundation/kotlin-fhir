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

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Signature
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.VerificationResult
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object VerificationResultPrimarySourceSerializer :
  KSerializer<VerificationResult.PrimarySource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PrimarySource") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("who", ReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("communicationMethod", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("validationStatus", CodeableConceptSerializer.descriptor)
      optionalElement("validationDate", KotlinString.serializer().descriptor)
      optionalElement("_validationDate", ElementSerializer.descriptor)
      optionalElement("canPushUpdates", CodeableConceptSerializer.descriptor)
      optionalElement("pushTypeAvailable", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<VerificationResult.PrimarySource>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): VerificationResult.PrimarySource {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var who: Reference? = null
    var type: List<CodeableConcept>? = null
    var communicationMethod: List<CodeableConcept>? = null
    var validationStatus: CodeableConcept? = null
    var validationDate: KotlinString? = null
    var _validationDate: Element? = null
    var canPushUpdates: CodeableConcept? = null
    var pushTypeAvailable: List<CodeableConcept>? = null
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
          who =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          communicationMethod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 ->
          validationStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 -> validationDate = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _validationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          canPushUpdates =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          pushTypeAvailable =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PrimarySource: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VerificationResult.PrimarySource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      who = who,
      type = type ?: listOf(),
      communicationMethod = communicationMethod ?: listOf(),
      validationStatus = validationStatus,
      validationDate =
        DateTime.of(
          if (validationDate != null) FhirDateTime.fromString(validationDate) else null,
          _validationDate,
        ),
      canPushUpdates = canPushUpdates,
      pushTypeAvailable = pushTypeAvailable ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.PrimarySource) {
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
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.who)
    if (value.type.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    if (value.communicationMethod.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        CodeableConceptSerializer.listSerializer,
        value.communicationMethod,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.validationStatus,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.validationDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.validationDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.canPushUpdates,
    )
    if (value.pushTypeAvailable.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        CodeableConceptSerializer.listSerializer,
        value.pushTypeAvailable,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object VerificationResultAttestationSerializer :
  KSerializer<VerificationResult.Attestation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Attestation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("who", ReferenceSerializer.descriptor)
      optionalElement("onBehalfOf", ReferenceSerializer.descriptor)
      optionalElement("communicationMethod", CodeableConceptSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("sourceIdentityCertificate", KotlinString.serializer().descriptor)
      optionalElement("_sourceIdentityCertificate", ElementSerializer.descriptor)
      optionalElement("proxyIdentityCertificate", KotlinString.serializer().descriptor)
      optionalElement("_proxyIdentityCertificate", ElementSerializer.descriptor)
      optionalElement("proxySignature", SignatureSerializer.descriptor)
      optionalElement("sourceSignature", SignatureSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<VerificationResult.Attestation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): VerificationResult.Attestation {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var who: Reference? = null
    var onBehalfOf: Reference? = null
    var communicationMethod: CodeableConcept? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var sourceIdentityCertificate: KotlinString? = null
    var _sourceIdentityCertificate: Element? = null
    var proxyIdentityCertificate: KotlinString? = null
    var _proxyIdentityCertificate: Element? = null
    var proxySignature: Signature? = null
    var sourceSignature: Signature? = null
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
          who =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          onBehalfOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 ->
          communicationMethod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> sourceIdentityCertificate = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _sourceIdentityCertificate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> proxyIdentityCertificate = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _proxyIdentityCertificate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          proxySignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        13 ->
          sourceSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attestation: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VerificationResult.Attestation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      who = who,
      onBehalfOf = onBehalfOf,
      communicationMethod = communicationMethod,
      date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
      sourceIdentityCertificate =
        R4String.of(sourceIdentityCertificate, _sourceIdentityCertificate),
      proxyIdentityCertificate = R4String.of(proxyIdentityCertificate, _proxyIdentityCertificate),
      proxySignature = proxySignature,
      sourceSignature = sourceSignature,
    )
  }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Attestation) {
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
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.who)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      ReferenceSerializer,
      value.onBehalfOf,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.communicationMethod,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.date)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.sourceIdentityCertificate?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.sourceIdentityCertificate)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.proxyIdentityCertificate?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.proxyIdentityCertificate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      SignatureSerializer,
      value.proxySignature,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      SignatureSerializer,
      value.sourceSignature,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object VerificationResultValidatorSerializer : KSerializer<VerificationResult.Validator> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Validator") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("organization", ReferenceSerializer.descriptor)
      optionalElement("identityCertificate", KotlinString.serializer().descriptor)
      optionalElement("_identityCertificate", ElementSerializer.descriptor)
      optionalElement("attestationSignature", SignatureSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<VerificationResult.Validator>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): VerificationResult.Validator {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var organization: Reference? = null
    var identityCertificate: KotlinString? = null
    var _identityCertificate: Element? = null
    var attestationSignature: Signature? = null
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
          organization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> identityCertificate = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _identityCertificate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          attestationSignature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Validator: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VerificationResult.Validator(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      organization =
        organization
          ?: throw SerializationException(
            "Missing required property 'organization' on VerificationResult.Validator"
          ),
      identityCertificate = R4String.of(identityCertificate, _identityCertificate),
      attestationSignature = attestationSignature,
    )
  }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Validator) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      ReferenceSerializer,
      value.organization,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.identityCertificate?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.identityCertificate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      SignatureSerializer,
      value.attestationSignature,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object VerificationResultSerializer : FhirResourceSerializer<VerificationResult> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("VerificationResult")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("target", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("targetLocation", stringNullableListSerializer.descriptor)
    b.optionalElement("_targetLocation", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("need", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusDate", KotlinString.serializer().descriptor)
    b.optionalElement("_statusDate", ElementSerializer.descriptor)
    b.optionalElement("validationType", CodeableConceptSerializer.descriptor)
    b.optionalElement("validationProcess", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("frequency", TimingSerializer.descriptor)
    b.optionalElement("lastPerformed", KotlinString.serializer().descriptor)
    b.optionalElement("_lastPerformed", ElementSerializer.descriptor)
    b.optionalElement("nextScheduled", KotlinString.serializer().descriptor)
    b.optionalElement("_nextScheduled", ElementSerializer.descriptor)
    b.optionalElement("failureAction", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "primarySource",
      VerificationResultPrimarySourceSerializer.listSerializer.descriptor,
    )
    b.optionalElement("attestation", VerificationResultAttestationSerializer.descriptor)
    b.optionalElement("validator", VerificationResultValidatorSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): VerificationResult {
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
    var target: List<Reference>? = null
    var targetLocation: List<KotlinString?>? = null
    var _targetLocation: List<Element?>? = null
    var need: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusDate: KotlinString? = null
    var _statusDate: Element? = null
    var validationType: CodeableConcept? = null
    var validationProcess: List<CodeableConcept>? = null
    var frequency: Timing? = null
    var lastPerformed: KotlinString? = null
    var _lastPerformed: Element? = null
    var nextScheduled: KotlinString? = null
    var _nextScheduled: Element? = null
    var failureAction: CodeableConcept? = null
    var primarySource: List<VerificationResult.PrimarySource>? = null
    var attestation: VerificationResult.Attestation? = null
    var validator: List<VerificationResult.Validator>? = null
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
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        11 ->
          targetLocation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _targetLocation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          need =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> statusDate = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _statusDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          validationType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          validationProcess =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          frequency =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        21 -> lastPerformed = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _lastPerformed =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> nextScheduled = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _nextScheduled =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          failureAction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          primarySource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VerificationResultPrimarySourceSerializer.listSerializer,
              null,
            )
        27 ->
          attestation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VerificationResultAttestationSerializer,
              null,
            )
        28 ->
          validator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VerificationResultValidatorSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding VerificationResult: " + i)
      }
    }
    return VerificationResult(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      target = target ?: listOf(),
      targetLocation =
        (kotlin.collections.List(maxOf(targetLocation?.size ?: 0, _targetLocation?.size ?: 0)) {
          index ->
          R4String.of(targetLocation?.getOrNull(index), _targetLocation?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'targetLocation' on VerificationResult has neither a value nor an id/extension"
            )
        }),
      need = need,
      status =
        Enumeration.of(
          if (status != null) VerificationResult.Status.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on VerificationResult"
          ),
      statusDate =
        DateTime.of(
          if (statusDate != null) FhirDateTime.fromString(statusDate) else null,
          _statusDate,
        ),
      validationType = validationType,
      validationProcess = validationProcess ?: listOf(),
      frequency = frequency,
      lastPerformed =
        DateTime.of(
          if (lastPerformed != null) FhirDateTime.fromString(lastPerformed) else null,
          _lastPerformed,
        ),
      nextScheduled =
        Date.of(
          if (nextScheduled != null) FhirDate.fromString(nextScheduled) else null,
          _nextScheduled,
        ),
      failureAction = failureAction,
      primarySource = primarySource ?: listOf(),
      attestation = attestation,
      validator = validator ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: VerificationResult,
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
    if (value.target.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.target,
      )
    if (value.targetLocation.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.targetLocation.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.targetLocation,
      )
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.need,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.statusDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.statusDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.validationType,
    )
    if (value.validationProcess.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.validationProcess,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      TimingSerializer,
      value.frequency,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.lastPerformed?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.lastPerformed)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.nextScheduled?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.nextScheduled)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.failureAction,
    )
    if (value.primarySource.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        VerificationResultPrimarySourceSerializer.listSerializer,
        value.primarySource,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      VerificationResultAttestationSerializer,
      value.attestation,
    )
    if (value.validator.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        VerificationResultValidatorSerializer.listSerializer,
        value.validator,
      )
  }
}
