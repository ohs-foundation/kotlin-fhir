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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

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

  override fun deserialize(decoder: Decoder): VerificationResult.PrimarySource =
    decoder.decodeStructure(descriptor) {
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
          3 -> who = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            communicationMethod =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            validationStatus =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> validationDate = decodeStringElement(descriptor, i)
          8 ->
            _validationDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            canPushUpdates =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            pushTypeAvailable =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PrimarySource: " + i)
        }
      }
      VerificationResult.PrimarySource(
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.who)
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      if (value.communicationMethod.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.communicationMethod,
        )
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.validationStatus)
      encodeStringIfNotNull(descriptor, 7, value.validationDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.validationDate)
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.canPushUpdates)
      if (value.pushTypeAvailable.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CodeableConceptSerializer.listSerializer,
          value.pushTypeAvailable,
        )
    }
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

  override fun deserialize(decoder: Decoder): VerificationResult.Attestation =
    decoder.decodeStructure(descriptor) {
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
          3 -> who = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            onBehalfOf = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 ->
            communicationMethod =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> date = decodeStringElement(descriptor, i)
          7 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> sourceIdentityCertificate = decodeStringElement(descriptor, i)
          9 ->
            _sourceIdentityCertificate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> proxyIdentityCertificate = decodeStringElement(descriptor, i)
          11 ->
            _proxyIdentityCertificate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            proxySignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          13 ->
            sourceSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Attestation: " + i)
        }
      }
      VerificationResult.Attestation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        who = who,
        onBehalfOf = onBehalfOf,
        communicationMethod = communicationMethod,
        date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
        sourceIdentityCertificate =
          R4bString.of(sourceIdentityCertificate, _sourceIdentityCertificate),
        proxyIdentityCertificate =
          R4bString.of(proxyIdentityCertificate, _proxyIdentityCertificate),
        proxySignature = proxySignature,
        sourceSignature = sourceSignature,
      )
    }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Attestation) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.who)
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.onBehalfOf)
      encodeSerializableIfNotNull(
        descriptor,
        5,
        CodeableConceptSerializer,
        value.communicationMethod,
      )
      encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.date)
      encodeStringIfNotNull(descriptor, 8, value.sourceIdentityCertificate?.value)
      encodeElementIfNotNull(descriptor, 9, value.sourceIdentityCertificate)
      encodeStringIfNotNull(descriptor, 10, value.proxyIdentityCertificate?.value)
      encodeElementIfNotNull(descriptor, 11, value.proxyIdentityCertificate)
      encodeSerializableIfNotNull(descriptor, 12, SignatureSerializer, value.proxySignature)
      encodeSerializableIfNotNull(descriptor, 13, SignatureSerializer, value.sourceSignature)
    }
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

  override fun deserialize(decoder: Decoder): VerificationResult.Validator =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var organization: Reference? = null
      var identityCertificate: KotlinString? = null
      var _identityCertificate: Element? = null
      var attestationSignature: Signature? = null
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
            organization =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> identityCertificate = decodeStringElement(descriptor, i)
          5 ->
            _identityCertificate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            attestationSignature =
              decodeNullableSerializableElement(descriptor, i, SignatureSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Validator: " + i)
        }
      }
      VerificationResult.Validator(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        organization =
          organization
            ?: throw SerializationException(
              "Missing required property 'organization' on VerificationResult.Validator"
            ),
        identityCertificate = R4bString.of(identityCertificate, _identityCertificate),
        attestationSignature = attestationSignature,
      )
    }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Validator) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.organization)
      encodeStringIfNotNull(descriptor, 4, value.identityCertificate?.value)
      encodeElementIfNotNull(descriptor, 5, value.identityCertificate)
      encodeSerializableIfNotNull(descriptor, 6, SignatureSerializer, value.attestationSignature)
    }
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
    decoder: CompositeDecoder,
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
          target =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        11 ->
          targetLocation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _targetLocation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          need =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 -> status = decoder.decodeStringElement(descriptor, i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> statusDate = decoder.decodeStringElement(descriptor, i)
        17 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          validationType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          validationProcess =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          frequency =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        21 -> lastPerformed = decoder.decodeStringElement(descriptor, i)
        22 ->
          _lastPerformed =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> nextScheduled = decoder.decodeStringElement(descriptor, i)
        24 ->
          _nextScheduled =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          failureAction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          primarySource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VerificationResultPrimarySourceSerializer.listSerializer,
              null,
            )
        27 ->
          attestation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VerificationResultAttestationSerializer,
              null,
            )
        28 ->
          validator =
            decoder.decodeNullableSerializableElement(
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
          R4bString.of(targetLocation?.getOrNull(index), _targetLocation?.getOrNull(index))
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
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: VerificationResult,
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
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.target,
      )
    if (value.targetLocation.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.targetLocation.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 12 + descriptorOffset, value.targetLocation)
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.need,
    )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.statusDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.statusDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.validationType,
    )
    if (value.validationProcess.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.validationProcess,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      TimingSerializer,
      value.frequency,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.lastPerformed?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.lastPerformed)
    encoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.nextScheduled?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.nextScheduled)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.failureAction,
    )
    if (value.primarySource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        VerificationResultPrimarySourceSerializer.listSerializer,
        value.primarySource,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      VerificationResultAttestationSerializer,
      value.attestation,
    )
    if (value.validator.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        VerificationResultValidatorSerializer.listSerializer,
        value.validator,
      )
  }
}
