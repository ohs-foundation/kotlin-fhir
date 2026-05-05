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
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Signature
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.VerificationResult
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> who = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.whoSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 ->
          communicationMethod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 ->
          validationStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSerInner, null)
        7 -> validationDate = decoder.decodeStringElement(__desc, __i)
        8 ->
          _validationDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.validationDateSer, null)
        9 ->
          canPushUpdates =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSerInner, null)
        10 ->
          pushTypeAvailable =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> who = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.whoSer, null)
        4 ->
          onBehalfOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.whoSer, null)
        5 ->
          communicationMethod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.communicationMethodSer,
              null,
            )
        6 -> date = decoder.decodeStringElement(__desc, __i)
        7 -> _date = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer, null)
        8 -> sourceIdentityCertificate = decoder.decodeStringElement(__desc, __i)
        9 ->
          _sourceIdentityCertificate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer, null)
        10 -> proxyIdentityCertificate = decoder.decodeStringElement(__desc, __i)
        11 ->
          _proxyIdentityCertificate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer, null)
        12 ->
          proxySignature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.proxySignatureSer, null)
        13 ->
          sourceSignature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.proxySignatureSer, null)
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
        R4String.of(sourceIdentityCertificate, _sourceIdentityCertificate),
      proxyIdentityCertificate = R4String.of(proxyIdentityCertificate, _proxyIdentityCertificate),
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.organizationSer, null)
        4 -> identityCertificate = decoder.decodeStringElement(__desc, __i)
        5 ->
          _identityCertificate =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.identityCertificateSer,
              null,
            )
        6 ->
          attestationSignature =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
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
      identityCertificate = R4String.of(identityCertificate, _identityCertificate),
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
    b.element("target", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "targetLocation",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_targetLocation",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("need", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_statusDate", Element.serializer().descriptor, isOptional = true)
    b.element("validationType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "validationProcess",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("frequency", Timing.serializer().descriptor, isOptional = true)
    b.element("lastPerformed", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastPerformed", Element.serializer().descriptor, isOptional = true)
    b.element("nextScheduled", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_nextScheduled", Element.serializer().descriptor, isOptional = true)
    b.element("failureAction", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "primarySource",
      listSerialDescriptor(
        lazyDescriptor { VerificationResult.PrimarySource.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "attestation",
      lazyDescriptor { VerificationResult.Attestation.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "validator",
      listSerialDescriptor(lazyDescriptor { VerificationResult.Validator.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): VerificationResult =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: VerificationResult) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "VerificationResult")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): VerificationResult {
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
          target = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetSer, null)
        11 ->
          targetLocation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetLocationSer, null)
        12 ->
          _targetLocation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetLocationSer2, null)
        13 -> need = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.needSer, null)
        14 -> status = decoder.decodeStringElement(__desc, __i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 -> statusDate = decoder.decodeStringElement(__desc, __i)
        17 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 ->
          validationType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.needSer, null)
        19 ->
          validationProcess =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.validationProcessSer,
              null,
            )
        20 ->
          frequency =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.frequencySer, null)
        21 -> lastPerformed = decoder.decodeStringElement(__desc, __i)
        22 ->
          _lastPerformed =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> nextScheduled = decoder.decodeStringElement(__desc, __i)
        24 ->
          _nextScheduled =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          failureAction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.needSer, null)
        26 ->
          primarySource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.primarySourceSer, null)
        27 ->
          attestation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.attestationSer, null)
        28 ->
          validator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.validatorSer, null)
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
          R4String.of(targetLocation?.getOrNull(__i)?.let { it }, _targetLocation?.getOrNull(__i))!!
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: VerificationResult,
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
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.targetSer, value.target)
    (value.targetLocation.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.targetLocationSer, it)
    }
    (value.targetLocation.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.targetLocationSer2, it)
    }
    (value.need)?.let { encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.needSer, it) }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.statusDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 16 + __off, it)
    }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.validationType)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.needSer, it)
    }
    if (value.validationProcess.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19 + __off,
        Hoisted.validationProcessSer,
        value.validationProcess,
      )
    (value.frequency)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.frequencySer, it)
    }
    ((value.lastPerformed?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 21 + __off, it)
    }
    (value.lastPerformed?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.nextScheduled?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 23 + __off, it)
    }
    (value.nextScheduled?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.failureAction)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.needSer, it)
    }
    if (value.primarySource.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26 + __off,
        Hoisted.primarySourceSer,
        value.primarySource,
      )
    (value.attestation)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.attestationSer, it)
    }
    if (value.validator.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.validatorSer, value.validator)
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

internal object VerificationResultPolymorphicSerializer : KSerializer<VerificationResult> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("VerificationResult") {
      VerificationResultSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: VerificationResult) {
    encoder.encodeStructure(descriptor) {
      VerificationResultSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): VerificationResult =
    decoder.decodeStructure(descriptor) {
      VerificationResultSerializer.deserializeJson(this, descriptor, 0)
    }
}
