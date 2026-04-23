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
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Signature
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.VerificationResult
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object VerificationResultPrimarySourceSerializer :
  KSerializer<VerificationResult.PrimarySource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PrimarySource") {
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
      element("who", Reference.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "communicationMethod",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("validationStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("validationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_validationDate", Element.serializer().descriptor, isOptional = true)
      element("canPushUpdates", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "pushTypeAvailable",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): VerificationResult.PrimarySource =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.PrimarySource) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): VerificationResult.PrimarySource {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> who = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.whoSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 ->
          communicationMethod =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 ->
          validationStatus =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSerInner, null)
        7 -> validationDate = decoder.decodeStringElement(__desc, 7)
        8 ->
          _validationDate =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.validationDateSer, null)
        9 ->
          canPushUpdates =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.typeSerInner, null)
        10 ->
          pushTypeAvailable =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PrimarySource: " + __i)
      }
    }
    return VerificationResult.PrimarySource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      who = who,
      type = type ?: listOf(),
      communicationMethod = communicationMethod ?: listOf(),
      validationStatus = validationStatus,
      validationDate = DateTime.of(FhirDateTime.fromString(validationDate), _validationDate),
      canPushUpdates = canPushUpdates,
      pushTypeAvailable = pushTypeAvailable ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: VerificationResult.PrimarySource) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.who)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.whoSer, it) }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, value.type)
    if (value.communicationMethod.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, value.communicationMethod)
    (value.validationStatus)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSerInner, it)
    }
    ((value.validationDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.validationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.validationDateSer, it)
    }
    (value.canPushUpdates)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.typeSerInner, it)
    }
    if (value.pushTypeAvailable.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.typeSer, value.pushTypeAvailable)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val whoSer: KSerializer<Reference> = Reference.serializer()

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val validationDateSer: KSerializer<Element> = Element.serializer()
  }
}

internal object VerificationResultAttestationSerializer :
  KSerializer<VerificationResult.Attestation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Attestation") {
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
      element("who", Reference.serializer().descriptor, isOptional = true)
      element("onBehalfOf", Reference.serializer().descriptor, isOptional = true)
      element("communicationMethod", CodeableConcept.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("sourceIdentityCertificate", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceIdentityCertificate", Element.serializer().descriptor, isOptional = true)
      element("proxyIdentityCertificate", KotlinString.serializer().descriptor, isOptional = true)
      element("_proxyIdentityCertificate", Element.serializer().descriptor, isOptional = true)
      element("proxySignature", Signature.serializer().descriptor, isOptional = true)
      element("sourceSignature", Signature.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): VerificationResult.Attestation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Attestation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): VerificationResult.Attestation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> who = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.whoSer, null)
        4 -> onBehalfOf = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.whoSer, null)
        5 ->
          communicationMethod =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.communicationMethodSer,
              null,
            )
        6 -> date = decoder.decodeStringElement(__desc, 6)
        7 -> _date = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.dateSer, null)
        8 -> sourceIdentityCertificate = decoder.decodeStringElement(__desc, 8)
        9 ->
          _sourceIdentityCertificate =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.dateSer, null)
        10 -> proxyIdentityCertificate = decoder.decodeStringElement(__desc, 10)
        11 ->
          _proxyIdentityCertificate =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.dateSer, null)
        12 ->
          proxySignature =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.proxySignatureSer, null)
        13 ->
          sourceSignature =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.proxySignatureSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attestation: " + __i)
      }
    }
    return VerificationResult.Attestation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      who = who,
      onBehalfOf = onBehalfOf,
      communicationMethod = communicationMethod,
      date = Date.of(FhirDate.fromString(date), _date),
      sourceIdentityCertificate =
        R4bString.of(sourceIdentityCertificate, _sourceIdentityCertificate),
      proxyIdentityCertificate = R4bString.of(proxyIdentityCertificate, _proxyIdentityCertificate),
      proxySignature = proxySignature,
      sourceSignature = sourceSignature,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: VerificationResult.Attestation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.who)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.whoSer, it) }
    (value.onBehalfOf)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.whoSer, it) }
    (value.communicationMethod)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.communicationMethodSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.dateSer, it)
    }
    ((value.sourceIdentityCertificate?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.sourceIdentityCertificate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.dateSer, it)
    }
    ((value.proxyIdentityCertificate?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.proxyIdentityCertificate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.dateSer, it)
    }
    (value.proxySignature)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.proxySignatureSer, it)
    }
    (value.sourceSignature)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.proxySignatureSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val whoSer: KSerializer<Reference> = Reference.serializer()

    public val communicationMethodSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()

    public val proxySignatureSer: KSerializer<Signature> = Signature.serializer()
  }
}

internal object VerificationResultValidatorSerializer : KSerializer<VerificationResult.Validator> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Validator") {
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
      element("organization", Reference.serializer().descriptor, isOptional = true)
      element("identityCertificate", KotlinString.serializer().descriptor, isOptional = true)
      element("_identityCertificate", Element.serializer().descriptor, isOptional = true)
      element("attestationSignature", Signature.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): VerificationResult.Validator =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Validator) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): VerificationResult.Validator {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var organization: Reference? = null
    var identityCertificate: KotlinString? = null
    var _identityCertificate: Element? = null
    var attestationSignature: Signature? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.organizationSer, null)
        4 -> identityCertificate = decoder.decodeStringElement(__desc, 4)
        5 ->
          _identityCertificate =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.identityCertificateSer,
              null,
            )
        6 ->
          attestationSignature =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.attestationSignatureSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Validator: " + __i)
      }
    }
    return VerificationResult.Validator(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      organization = organization!!,
      identityCertificate = R4bString.of(identityCertificate, _identityCertificate),
      attestationSignature = attestationSignature,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: VerificationResult.Validator) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.organization)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.organizationSer, it)
    }
    ((value.identityCertificate?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.identityCertificate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.identityCertificateSer, it)
    }
    (value.attestationSignature)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.attestationSignatureSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val organizationSer: KSerializer<Reference> = Reference.serializer()

    public val identityCertificateSer: KSerializer<Element> = Element.serializer()

    public val attestationSignatureSer: KSerializer<Signature> = Signature.serializer()
  }
}

internal object VerificationResultSerializer : KSerializer<VerificationResult> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("VerificationResult") {
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
      element("target", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "targetLocation",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_targetLocation",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("need", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_statusDate", Element.serializer().descriptor, isOptional = true)
      element("validationType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "validationProcess",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("frequency", Timing.serializer().descriptor, isOptional = true)
      element("lastPerformed", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastPerformed", Element.serializer().descriptor, isOptional = true)
      element("nextScheduled", KotlinString.serializer().descriptor, isOptional = true)
      element("_nextScheduled", Element.serializer().descriptor, isOptional = true)
      element("failureAction", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "primarySource",
        listSerialDescriptor(
          lazyDescriptor { VerificationResult.PrimarySource.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "attestation",
        lazyDescriptor { VerificationResult.Attestation.serializer().descriptor },
        isOptional = true,
      )
      element(
        "validator",
        listSerialDescriptor(
          lazyDescriptor { VerificationResult.Validator.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): VerificationResult =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: VerificationResult) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): VerificationResult {
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
          target = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.targetSer, null)
        12 ->
          targetLocation =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.targetLocationSer, null)
        13 ->
          _targetLocation =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.targetLocationSer2, null)
        14 -> need = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.needSer, null)
        15 -> status = decoder.decodeStringElement(__desc, 15)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 -> statusDate = decoder.decodeStringElement(__desc, 17)
        18 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          validationType =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.needSer, null)
        20 ->
          validationProcess =
            decoder.decodeNullableSerializableElement(
              __desc,
              20,
              Hoisted.validationProcessSer,
              null,
            )
        21 ->
          frequency =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.frequencySer, null)
        22 -> lastPerformed = decoder.decodeStringElement(__desc, 22)
        23 ->
          _lastPerformed =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> nextScheduled = decoder.decodeStringElement(__desc, 24)
        25 ->
          _nextScheduled =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          failureAction =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.needSer, null)
        27 ->
          primarySource =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.primarySourceSer, null)
        28 ->
          attestation =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.attestationSer, null)
        29 ->
          validator =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.validatorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding VerificationResult: " + __i)
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
        (kotlin.collections.List(maxOf(targetLocation?.size ?: 0, _targetLocation?.size ?: 0)) { __i
          ->
          R4bString.of(
            targetLocation?.getOrNull(__i)?.let { it },
            _targetLocation?.getOrNull(__i),
          )!!
        }),
      need = need,
      status = Enumeration.of(VerificationResult.Status.fromCode(status!!), _status),
      statusDate = DateTime.of(FhirDateTime.fromString(statusDate), _statusDate),
      validationType = validationType,
      validationProcess = validationProcess ?: listOf(),
      frequency = frequency,
      lastPerformed = DateTime.of(FhirDateTime.fromString(lastPerformed), _lastPerformed),
      nextScheduled = Date.of(FhirDate.fromString(nextScheduled), _nextScheduled),
      failureAction = failureAction,
      primarySource = primarySource ?: listOf(),
      attestation = attestation,
      validator = validator ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: VerificationResult) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "VerificationResult")
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
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.targetSer, value.target)
    (value.targetLocation.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.targetLocationSer, it)
    }
    (value.targetLocation.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.targetLocationSer2, it)
    }
    (value.need)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.needSer, it) }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    (value.validationType)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.needSer, it)
    }
    if (value.validationProcess.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20,
        Hoisted.validationProcessSer,
        value.validationProcess,
      )
    (value.frequency)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.frequencySer, it)
    }
    ((value.lastPerformed?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.lastPerformed?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.nextScheduled?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.nextScheduled?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    (value.failureAction)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.needSer, it)
    }
    if (value.primarySource.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.primarySourceSer, value.primarySource)
    (value.attestation)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.attestationSer, it)
    }
    if (value.validator.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.validatorSer, value.validator)
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

    public val targetSerInner: KSerializer<Reference> = Reference.serializer()

    public val targetSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.targetSerInner)

    public val targetLocationSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val targetLocationSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.targetLocationSerInner).nullable)

    public val targetLocationSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val needSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val validationProcessSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.needSer)

    public val frequencySer: KSerializer<Timing> = Timing.serializer()

    public val primarySourceSerInner: KSerializer<VerificationResult.PrimarySource> =
      VerificationResult.PrimarySource.serializer()

    public val primarySourceSer: KSerializer<List<VerificationResult.PrimarySource>> =
      ListSerializer(Hoisted.primarySourceSerInner)

    public val attestationSer: KSerializer<VerificationResult.Attestation> =
      VerificationResult.Attestation.serializer()

    public val validatorSerInner: KSerializer<VerificationResult.Validator> =
      VerificationResult.Validator.serializer()

    public val validatorSer: KSerializer<List<VerificationResult.Validator>> =
      ListSerializer(Hoisted.validatorSerInner)
  }
}
