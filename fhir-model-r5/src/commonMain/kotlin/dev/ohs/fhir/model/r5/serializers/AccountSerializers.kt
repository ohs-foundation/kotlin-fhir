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

import dev.ohs.fhir.model.r5.Account
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object AccountCoverageSerializer : KSerializer<Account.Coverage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage") {
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
      element("coverage", Reference.serializer().descriptor, isOptional = true)
      element("priority", Int.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Account.Coverage =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Account.Coverage) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Account.Coverage {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var coverage: Reference? = null
    var priority: Int? = null
    var _priority: Element? = null
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
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        4 -> priority = decoder.decodeIntElement(descriptor, i)
        5 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prioritySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Coverage: " + i)
      }
    }
    return Account.Coverage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on Account.Coverage"
          ),
      priority = PositiveInt.of(priority, _priority),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Account.Coverage) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.coverageSer, value.coverage)
    ((value.priority?.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.prioritySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val coverageSer: KSerializer<Reference> = Reference.serializer()

    public val prioritySer: KSerializer<Element> = Element.serializer()
  }
}

internal object AccountGuarantorSerializer : KSerializer<Account.Guarantor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Guarantor") {
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
      element("party", Reference.serializer().descriptor, isOptional = true)
      element("onHold", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_onHold", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Account.Guarantor =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Account.Guarantor) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Account.Guarantor {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var party: Reference? = null
    var onHold: KotlinBoolean? = null
    var _onHold: Element? = null
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
        3 ->
          party = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partySer, null)
        4 -> onHold = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _onHold =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.onHoldSer, null)
        6 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Guarantor: " + i)
      }
    }
    return Account.Guarantor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      party =
        party
          ?: throw SerializationException("Missing required property 'party' on Account.Guarantor"),
      onHold = R5Boolean.of(onHold, _onHold),
      period = period,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Account.Guarantor) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.partySer, value.party)
    ((value.onHold?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.onHold?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.onHoldSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val partySer: KSerializer<Reference> = Reference.serializer()

    public val onHoldSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object AccountDiagnosisSerializer : KSerializer<Account.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("condition", CodeableReference.serializer().descriptor, isOptional = true)
      element("dateOfDiagnosis", KotlinString.serializer().descriptor, isOptional = true)
      element("_dateOfDiagnosis", Element.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("onAdmission", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_onAdmission", Element.serializer().descriptor, isOptional = true)
      element(
        "packageCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Account.Diagnosis =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Account.Diagnosis) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Account.Diagnosis {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var condition: CodeableReference? = null
    var dateOfDiagnosis: KotlinString? = null
    var _dateOfDiagnosis: Element? = null
    var type: List<CodeableConcept>? = null
    var onAdmission: KotlinBoolean? = null
    var _onAdmission: Element? = null
    var packageCode: List<CodeableConcept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        5 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        6 -> dateOfDiagnosis = decoder.decodeStringElement(descriptor, i)
        7 ->
          _dateOfDiagnosis =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        8 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        9 -> onAdmission = decoder.decodeBooleanElement(descriptor, i)
        10 ->
          _onAdmission =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        11 ->
          packageCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
      }
    }
    return Account.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence),
      condition =
        condition
          ?: throw SerializationException(
            "Missing required property 'condition' on Account.Diagnosis"
          ),
      dateOfDiagnosis = DateTime.of(FhirDateTime.fromString(dateOfDiagnosis), _dateOfDiagnosis),
      type = type ?: listOf(),
      onAdmission = R5Boolean.of(onAdmission, _onAdmission),
      packageCode = packageCode ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Account.Diagnosis) {
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
    ((value.sequence?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.conditionSer, value.condition)
    ((value.dateOfDiagnosis?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 6, it)
    }
    (value.dateOfDiagnosis?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.sequenceSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, value.type)
    ((value.onAdmission?.value))?.let { encoder.encodeBooleanElement(descriptor, 9, it) }
    (value.onAdmission?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.sequenceSer, it)
    }
    if (value.packageCode.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.typeSer, value.packageCode)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val conditionSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)
  }
}

internal object AccountProcedureSerializer : KSerializer<Account.Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableReference.serializer().descriptor, isOptional = true)
      element("dateOfService", KotlinString.serializer().descriptor, isOptional = true)
      element("_dateOfService", Element.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "packageCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("device", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Account.Procedure =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Account.Procedure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Account.Procedure {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var code: CodeableReference? = null
    var dateOfService: KotlinString? = null
    var _dateOfService: Element? = null
    var type: List<CodeableConcept>? = null
    var packageCode: List<CodeableConcept>? = null
    var device: List<Reference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 -> dateOfService = decoder.decodeStringElement(descriptor, i)
        7 ->
          _dateOfService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        8 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        9 ->
          packageCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        10 ->
          device = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
      }
    }
    return Account.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence),
      code =
        code
          ?: throw SerializationException("Missing required property 'code' on Account.Procedure"),
      dateOfService = DateTime.of(FhirDateTime.fromString(dateOfService), _dateOfService),
      type = type ?: listOf(),
      packageCode = packageCode ?: listOf(),
      device = device ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Account.Procedure) {
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
    ((value.sequence?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, value.code)
    ((value.dateOfService?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 6, it)
    }
    (value.dateOfService?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.sequenceSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, value.type)
    if (value.packageCode.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.typeSer, value.packageCode)
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.deviceSer, value.device)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val deviceSerInner: KSerializer<Reference> = Reference.serializer()

    public val deviceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.deviceSerInner)
  }
}

internal object AccountRelatedAccountSerializer : KSerializer<Account.RelatedAccount> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedAccount") {
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
      element("relationship", CodeableConcept.serializer().descriptor, isOptional = true)
      element("account", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Account.RelatedAccount =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Account.RelatedAccount) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Account.RelatedAccount {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationship: CodeableConcept? = null
    var account: Reference? = null
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
          relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relationshipSer, null)
        4 ->
          account =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.accountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedAccount: " + i)
      }
    }
    return Account.RelatedAccount(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relationship = relationship,
      account =
        account
          ?: throw SerializationException(
            "Missing required property 'account' on Account.RelatedAccount"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Account.RelatedAccount) {
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
    (value.relationship)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.relationshipSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.accountSer, value.account)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val relationshipSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val accountSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object AccountBalanceSerializer : KSerializer<Account.Balance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Balance") {
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
      element("aggregate", CodeableConcept.serializer().descriptor, isOptional = true)
      element("term", CodeableConcept.serializer().descriptor, isOptional = true)
      element("estimate", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_estimate", Element.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Account.Balance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Account.Balance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Account.Balance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var aggregate: CodeableConcept? = null
    var term: CodeableConcept? = null
    var estimate: KotlinBoolean? = null
    var _estimate: Element? = null
    var amount: Money? = null
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
          aggregate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.aggregateSer, null)
        4 ->
          term =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.aggregateSer, null)
        5 -> estimate = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _estimate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.estimateSer, null)
        7 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Balance: " + i)
      }
    }
    return Account.Balance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      aggregate = aggregate,
      term = term,
      estimate = R5Boolean.of(estimate, _estimate),
      amount =
        amount
          ?: throw SerializationException("Missing required property 'amount' on Account.Balance"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Account.Balance) {
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
    (value.aggregate)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.aggregateSer, it)
    }
    (value.term)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.aggregateSer, it) }
    ((value.estimate?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.estimate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.estimateSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 7, Hoisted.amountSer, value.amount)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val aggregateSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val estimateSer: KSerializer<Element> = Element.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()
  }
}

internal object AccountSerializer : KSerializer<Account> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Account") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("billingStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("servicePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "coverage",
      listSerialDescriptor(lazyDescriptor { Account.Coverage.serializer().descriptor }),
      isOptional = true,
    )
    b.element("owner", Reference.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "guarantor",
      listSerialDescriptor(lazyDescriptor { Account.Guarantor.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "diagnosis",
      listSerialDescriptor(lazyDescriptor { Account.Diagnosis.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "procedure",
      listSerialDescriptor(lazyDescriptor { Account.Procedure.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "relatedAccount",
      listSerialDescriptor(lazyDescriptor { Account.RelatedAccount.serializer().descriptor }),
      isOptional = true,
    )
    b.element("currency", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "balance",
      listSerialDescriptor(lazyDescriptor { Account.Balance.serializer().descriptor }),
      isOptional = true,
    )
    b.element("calculatedAt", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_calculatedAt", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Account =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Account) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Account")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Account {
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
    var identifier: List<Identifier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var billingStatus: CodeableConcept? = null
    var type: CodeableConcept? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var subject: List<Reference>? = null
    var servicePeriod: Period? = null
    var coverage: List<Account.Coverage>? = null
    var owner: Reference? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var guarantor: List<Account.Guarantor>? = null
    var diagnosis: List<Account.Diagnosis>? = null
    var procedure: List<Account.Procedure>? = null
    var relatedAccount: List<Account.RelatedAccount>? = null
    var currency: CodeableConcept? = null
    var balance: List<Account.Balance>? = null
    var calculatedAt: KotlinString? = null
    var _calculatedAt: Element? = null
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
          billingStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.billingStatusSer, null)
        14 ->
          type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.billingStatusSer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        18 ->
          servicePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.servicePeriodSer, null)
        19 ->
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        20 ->
          owner =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSerInner, null)
        21 -> description = decoder.decodeStringElement(descriptor, i)
        22 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          guarantor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.guarantorSer, null)
        24 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.diagnosisSer, null)
        25 ->
          procedure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.procedureSer, null)
        26 ->
          relatedAccount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedAccountSer,
              null,
            )
        27 ->
          currency =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.billingStatusSer, null)
        28 ->
          balance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.balanceSer, null)
        29 -> calculatedAt = decoder.decodeStringElement(descriptor, i)
        30 ->
          _calculatedAt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        else -> throw SerializationException("Unexpected index decoding Account: " + i)
      }
    }
    return Account(
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
        Enumeration.of(status?.let { Account.AccountStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Account"),
      billingStatus = billingStatus,
      type = type,
      name = R5String.of(name, _name),
      subject = subject ?: listOf(),
      servicePeriod = servicePeriod,
      coverage = coverage ?: listOf(),
      owner = owner,
      description = Markdown.of(description, _description),
      guarantor = guarantor ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      relatedAccount = relatedAccount ?: listOf(),
      currency = currency,
      balance = balance ?: listOf(),
      calculatedAt = Instant.of(FhirDateTime.fromString(calculatedAt), _calculatedAt),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Account,
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
    ((value.status.value?.code))?.let {
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
    (value.billingStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.billingStatusSer,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.billingStatusSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.subjectSer,
        value.subject,
      )
    (value.servicePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.servicePeriodSer,
        it,
      )
    }
    if (value.coverage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.coverageSer,
        value.coverage,
      )
    (value.owner)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.subjectSerInner,
        it,
      )
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.guarantor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.guarantorSer,
        value.guarantor,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.diagnosisSer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.procedureSer,
        value.procedure,
      )
    if (value.relatedAccount.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.relatedAccountSer,
        value.relatedAccount,
      )
    (value.currency)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.billingStatusSer,
        it,
      )
    }
    if (value.balance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.balanceSer,
        value.balance,
      )
    ((value.calculatedAt?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.calculatedAt?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
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

    public val billingStatusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectSerInner: KSerializer<Reference> = Reference.serializer()

    public val subjectSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSerInner)

    public val servicePeriodSer: KSerializer<Period> = Period.serializer()

    public val coverageSerInner: KSerializer<Account.Coverage> = Account.Coverage.serializer()

    public val coverageSer: KSerializer<List<Account.Coverage>> =
      ListSerializer(Hoisted.coverageSerInner)

    public val guarantorSerInner: KSerializer<Account.Guarantor> = Account.Guarantor.serializer()

    public val guarantorSer: KSerializer<List<Account.Guarantor>> =
      ListSerializer(Hoisted.guarantorSerInner)

    public val diagnosisSerInner: KSerializer<Account.Diagnosis> = Account.Diagnosis.serializer()

    public val diagnosisSer: KSerializer<List<Account.Diagnosis>> =
      ListSerializer(Hoisted.diagnosisSerInner)

    public val procedureSerInner: KSerializer<Account.Procedure> = Account.Procedure.serializer()

    public val procedureSer: KSerializer<List<Account.Procedure>> =
      ListSerializer(Hoisted.procedureSerInner)

    public val relatedAccountSerInner: KSerializer<Account.RelatedAccount> =
      Account.RelatedAccount.serializer()

    public val relatedAccountSer: KSerializer<List<Account.RelatedAccount>> =
      ListSerializer(Hoisted.relatedAccountSerInner)

    public val balanceSerInner: KSerializer<Account.Balance> = Account.Balance.serializer()

    public val balanceSer: KSerializer<List<Account.Balance>> =
      ListSerializer(Hoisted.balanceSerInner)
  }
}

internal object AccountPolymorphicSerializer : KSerializer<Account> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Account") { AccountSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Account) {
    encoder.encodeStructure(descriptor) {
      AccountSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Account =
    decoder.decodeStructure(descriptor) {
      AccountSerializer.deserializeInternal(this, descriptor, 0)
    }
}
