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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.EpisodeOfCare
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
import kotlin.String
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

internal object EpisodeOfCareStatusHistorySerializer : KSerializer<EpisodeOfCare.StatusHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StatusHistory") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EpisodeOfCare.StatusHistory =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare.StatusHistory) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): EpisodeOfCare.StatusHistory {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var status: String? = null
    var _status: Element? = null
    var period: Period? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> status = decoder.decodeStringElement(descriptor, i)
        4 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        5 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StatusHistory: " + i)
      }
    }
    return EpisodeOfCare.StatusHistory(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status = Enumeration.of(EpisodeOfCare.EpisodeOfCareStatus.fromCode(status!!), _status),
      period = period!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: EpisodeOfCare.StatusHistory) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.statusSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val statusSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object EpisodeOfCareReasonSerializer : KSerializer<EpisodeOfCare.Reason> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Reason") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("use", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "value",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): EpisodeOfCare.Reason =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare.Reason) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): EpisodeOfCare.Reason {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var use: CodeableConcept? = null
    var `value`: List<CodeableReference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> use = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        4 ->
          `value` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reason: " + i)
      }
    }
    return EpisodeOfCare.Reason(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      use = use,
      `value` = `value` ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: EpisodeOfCare.Reason) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.use)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.useSer, it) }
    if (value.`value`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueSer, value.`value`)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val useSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val valueSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.valueSerInner)
  }
}

internal object EpisodeOfCareDiagnosisSerializer : KSerializer<EpisodeOfCare.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element(
        "condition",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("use", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EpisodeOfCare.Diagnosis =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare.Diagnosis) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): EpisodeOfCare.Diagnosis {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var condition: List<CodeableReference>? = null
    var use: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        4 -> use = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
      }
    }
    return EpisodeOfCare.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      condition = condition ?: listOf(),
      use = use,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: EpisodeOfCare.Diagnosis) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.conditionSer, value.condition)
    (value.use)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.useSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val conditionSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val conditionSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.conditionSerInner)

    public val useSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object EpisodeOfCareSerializer : KSerializer<EpisodeOfCare> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EpisodeOfCare") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "statusHistory",
      listSerialDescriptor(lazyDescriptor { EpisodeOfCare.StatusHistory.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "type",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reason",
      listSerialDescriptor(lazyDescriptor { EpisodeOfCare.Reason.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "diagnosis",
      listSerialDescriptor(lazyDescriptor { EpisodeOfCare.Diagnosis.serializer().descriptor }),
      isOptional = true,
    )
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("managingOrganization", Reference.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element(
      "referralRequest",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("careManager", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "careTeam",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("account", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): EpisodeOfCare =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "EpisodeOfCare")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): EpisodeOfCare {
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
    var statusHistory: List<EpisodeOfCare.StatusHistory>? = null
    var type: List<CodeableConcept>? = null
    var reason: List<EpisodeOfCare.Reason>? = null
    var diagnosis: List<EpisodeOfCare.Diagnosis>? = null
    var patient: Reference? = null
    var managingOrganization: Reference? = null
    var period: Period? = null
    var referralRequest: List<Reference>? = null
    var careManager: Reference? = null
    var careTeam: List<Reference>? = null
    var account: List<Reference>? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          statusHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusHistorySer, null)
        14 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        15 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        16 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.diagnosisSer, null)
        17 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        18 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        19 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        20 ->
          referralRequest =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referralRequestSer,
              null,
            )
        21 ->
          careManager =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        22 ->
          careTeam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referralRequestSer,
              null,
            )
        23 ->
          account =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referralRequestSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding EpisodeOfCare: " + i)
      }
    }
    return EpisodeOfCare(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(EpisodeOfCare.EpisodeOfCareStatus.fromCode(status!!), _status),
      statusHistory = statusHistory ?: listOf(),
      type = type ?: listOf(),
      reason = reason ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      patient = patient!!,
      managingOrganization = managingOrganization,
      period = period,
      referralRequest = referralRequest ?: listOf(),
      careManager = careManager,
      careTeam = careTeam ?: listOf(),
      account = account ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: EpisodeOfCare,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.statusHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.statusHistorySer,
        value.statusHistory,
      )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.typeSer,
        value.type,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.reasonSer,
        value.reason,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.diagnosisSer,
        value.diagnosis,
      )
    (value.patient)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.periodSer, it)
    }
    if (value.referralRequest.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.referralRequestSer,
        value.referralRequest,
      )
    (value.careManager)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.patientSer, it)
    }
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.referralRequestSer,
        value.careTeam,
      )
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.referralRequestSer,
        value.account,
      )
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

    public val statusHistorySerInner: KSerializer<EpisodeOfCare.StatusHistory> =
      EpisodeOfCare.StatusHistory.serializer()

    public val statusHistorySer: KSerializer<List<EpisodeOfCare.StatusHistory>> =
      ListSerializer(Hoisted.statusHistorySerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val reasonSerInner: KSerializer<EpisodeOfCare.Reason> = EpisodeOfCare.Reason.serializer()

    public val reasonSer: KSerializer<List<EpisodeOfCare.Reason>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val diagnosisSerInner: KSerializer<EpisodeOfCare.Diagnosis> =
      EpisodeOfCare.Diagnosis.serializer()

    public val diagnosisSer: KSerializer<List<EpisodeOfCare.Diagnosis>> =
      ListSerializer(Hoisted.diagnosisSerInner)

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val referralRequestSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)
  }
}

internal object EpisodeOfCarePolymorphicSerializer : KSerializer<EpisodeOfCare> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EpisodeOfCare") { EpisodeOfCareSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare) {
    encoder.encodeStructure(descriptor) {
      EpisodeOfCareSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): EpisodeOfCare =
    decoder.decodeStructure(descriptor) {
      EpisodeOfCareSerializer.deserializeInternal(this, descriptor, 0)
    }
}
