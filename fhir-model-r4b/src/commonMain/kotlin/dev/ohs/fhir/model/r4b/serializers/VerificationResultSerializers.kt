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

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.Signature
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.VerificationResult
import dev.ohs.fhir.model.r4b.terminologies.Status
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object VerificationResultPrimarySourceSerializer :
  FhirSerializer<VerificationResult.PrimarySource> {
  override val descriptor: SerialDescriptor = buildDescriptor("PrimarySource", this)

  @JvmField
  internal val listSerializer: KSerializer<List<VerificationResult.PrimarySource>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("who", ReferenceSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("communicationMethod", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("validationStatus", CodeableConceptSerializer.descriptor)
    b.strPrim("validationDate")
    b.optionalElement("canPushUpdates", CodeableConceptSerializer.descriptor)
    b.optionalElement("pushTypeAvailable", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VerificationResult.PrimarySource {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var who: Reference? = null
    var type: List<CodeableConcept>? = null
    var communicationMethod: List<CodeableConcept>? = null
    var validationStatus: CodeableConcept? = null
    var validationDate: FhirDateTime? = null
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
        7 ->
          validationDate =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VerificationResult.PrimarySource(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      who = who,
      type = listOrEmpty(type),
      communicationMethod = listOrEmpty(communicationMethod),
      validationStatus = validationStatus,
      validationDate = DateTime.of(validationDate, _validationDate),
      canPushUpdates = canPushUpdates,
      pushTypeAvailable = listOrEmpty(pushTypeAvailable),
    )
  }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.PrimarySource) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.who)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.type,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      CodeableConceptSerializer.listSerializer,
      value.pushTypeAvailable,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object VerificationResultAttestationSerializer :
  FhirSerializer<VerificationResult.Attestation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Attestation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<VerificationResult.Attestation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("who", ReferenceSerializer.descriptor)
    b.optionalElement("onBehalfOf", ReferenceSerializer.descriptor)
    b.optionalElement("communicationMethod", CodeableConceptSerializer.descriptor)
    b.strPrim("date")
    b.strPrim("sourceIdentityCertificate")
    b.strPrim("proxyIdentityCertificate")
    b.optionalElement("proxySignature", SignatureSerializer.descriptor)
    b.optionalElement("sourceSignature", SignatureSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VerificationResult.Attestation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var who: Reference? = null
    var onBehalfOf: Reference? = null
    var communicationMethod: CodeableConcept? = null
    var date: FhirDate? = null
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
        6 -> date = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VerificationResult.Attestation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      who = who,
      onBehalfOf = onBehalfOf,
      communicationMethod = communicationMethod,
      date = Date.of(date, _date),
      sourceIdentityCertificate =
        R4bString.of(sourceIdentityCertificate, _sourceIdentityCertificate),
      proxyIdentityCertificate = R4bString.of(proxyIdentityCertificate, _proxyIdentityCertificate),
      proxySignature = proxySignature,
      sourceSignature = sourceSignature,
    )
  }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Attestation) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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

internal object VerificationResultValidatorSerializer :
  FhirSerializer<VerificationResult.Validator> {
  override val descriptor: SerialDescriptor = buildDescriptor("Validator", this)

  @JvmField
  internal val listSerializer: KSerializer<List<VerificationResult.Validator>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("organization", ReferenceSerializer.descriptor)
    b.strPrim("identityCertificate")
    b.optionalElement("attestationSignature", SignatureSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VerificationResult.Validator {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VerificationResult.Validator(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      organization = required(organization, "VerificationResult.Validator", "organization"),
      identityCertificate = R4bString.of(identityCertificate, _identityCertificate),
      attestationSignature = attestationSignature,
    )
  }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Validator) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("target", ReferenceSerializer.listSerializer.descriptor)
    b.strPrimList("targetLocation")
    b.optionalElement("need", CodeableConceptSerializer.descriptor)
    b.strPrim("status")
    b.strPrim("statusDate")
    b.optionalElement("validationType", CodeableConceptSerializer.descriptor)
    b.optionalElement("validationProcess", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("frequency", TimingSerializer.descriptor)
    b.strPrim("lastPerformed")
    b.strPrim("nextScheduled")
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
    var status: Status? = null
    var _status: Element? = null
    var statusDate: FhirDateTime? = null
    var _statusDate: Element? = null
    var validationType: CodeableConcept? = null
    var validationProcess: List<CodeableConcept>? = null
    var frequency: Timing? = null
    var lastPerformed: FhirDateTime? = null
    var _lastPerformed: Element? = null
    var nextScheduled: FhirDate? = null
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
        14 -> status = Status.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        15 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          statusDate = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        21 ->
          lastPerformed =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        22 ->
          _lastPerformed =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          nextScheduled = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    val targetLocation_ =
      List(maxSize(targetLocation, _targetLocation)) { index ->
        entryRequired(
          R4bString.of(at(targetLocation, index), at(_targetLocation, index)),
          "VerificationResult",
          "targetLocation",
        )
      }
    return VerificationResult(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      target = listOrEmpty(target),
      targetLocation = targetLocation_,
      need = need,
      status = required(Enumeration.of(status, _status), "VerificationResult", "status"),
      statusDate = DateTime.of(statusDate, _statusDate),
      validationType = validationType,
      validationProcess = listOrEmpty(validationProcess),
      frequency = frequency,
      lastPerformed = DateTime.of(lastPerformed, _lastPerformed),
      nextScheduled = Date.of(nextScheduled, _nextScheduled),
      failureAction = failureAction,
      primarySource = listOrEmpty(primarySource),
      attestation = attestation,
      validator = listOrEmpty(validator),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.target,
    )
    if (!value.targetLocation.isEmpty()) {
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
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      28 + descriptorOffset,
      VerificationResultValidatorSerializer.listSerializer,
      value.validator,
    )
  }
}
