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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.ExplanationOfBenefit
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.NoteType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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

internal object ExplanationOfBenefitRelatedSerializer : KSerializer<ExplanationOfBenefit.Related> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Related") {
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
      element("claim", Reference.serializer().descriptor, isOptional = true)
      element("relationship", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reference", Identifier.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Related =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Related) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Related {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var claim: Reference? = null
    var relationship: CodeableConcept? = null
    var reference: Identifier? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> claim = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.claimSer, null)
        4 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.relationshipSer, null)
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Related: " + __i)
      }
    }
    return ExplanationOfBenefit.Related(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      claim = claim,
      relationship = relationship,
      reference = reference,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Related) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.claim)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.claimSer, it) }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.relationshipSer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.referenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val claimSer: KSerializer<Reference> = Reference.serializer()

    public val relationshipSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val referenceSer: KSerializer<Identifier> = Identifier.serializer()
  }
}

internal object ExplanationOfBenefitPayeeSerializer : KSerializer<ExplanationOfBenefit.Payee> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payee") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("party", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Payee =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payee) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Payee {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var party: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> party = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.partySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payee: " + __i)
      }
    }
    return ExplanationOfBenefit.Payee(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      party = party,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Payee) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.party)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.partySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val partySer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ExplanationOfBenefitCareTeamSerializer :
  KSerializer<ExplanationOfBenefit.CareTeam> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CareTeam") {
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
      element("provider", Reference.serializer().descriptor, isOptional = true)
      element("responsible", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_responsible", Element.serializer().descriptor, isOptional = true)
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("qualification", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.CareTeam =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.CareTeam) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.CareTeam {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var provider: Reference? = null
    var responsible: KotlinBoolean? = null
    var _responsible: Element? = null
    var role: CodeableConcept? = null
    var qualification: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 ->
          provider = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.providerSer, null)
        6 -> responsible = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _responsible =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.sequenceSer, null)
        8 -> role = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.roleSer, null)
        9 ->
          qualification =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CareTeam: " + __i)
      }
    }
    return ExplanationOfBenefit.CareTeam(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      provider = provider!!,
      responsible = R4Boolean.of(responsible, _responsible),
      role = role,
      qualification = qualification,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.CareTeam) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    (value.provider)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.providerSer, it) }
    ((value.responsible?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.responsible?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.sequenceSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.roleSer, it) }
    (value.qualification)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.roleSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val providerSer: KSerializer<Reference> = Reference.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ExplanationOfBenefitSupportingInfoSerializer :
  KSerializer<ExplanationOfBenefit.SupportingInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportingInfo") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("timingDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_timingDate", Element.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("reason", Coding.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.SupportingInfo =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.SupportingInfo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.SupportingInfo {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var category: CodeableConcept? = null
    var code: CodeableConcept? = null
    var timingDate: KotlinString? = null
    var _timingDate: Element? = null
    var timingPeriod: Period? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueQuantity: Quantity? = null
    var valueAttachment: Attachment? = null
    var valueReference: Reference? = null
    var reason: Coding? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 ->
          category = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.categorySer, null)
        6 -> code = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.categorySer, null)
        7 -> timingDate = decoder.decodeStringElement(__desc, 7)
        8 ->
          _timingDate =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.sequenceSer, null)
        9 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.timingPeriodSer, null)
        10 -> valueBoolean = decoder.decodeBooleanElement(__desc, 10)
        11 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.sequenceSer, null)
        12 -> valueString = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.sequenceSer, null)
        14 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.valueQuantitySer, null)
        15 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.valueAttachmentSer, null)
        16 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueReferenceSer, null)
        17 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.reasonSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + __i)
      }
    }
    return ExplanationOfBenefit.SupportingInfo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      category = category!!,
      code = code,
      timing =
        ExplanationOfBenefit.SupportingInfo.Timing.from(
          Date.of(FhirDate.fromString(timingDate), _timingDate),
          timingPeriod,
        ),
      `value` =
        ExplanationOfBenefit.SupportingInfo.Value.from(
          R4Boolean.of(valueBoolean, _valueBoolean),
          R4String.of(valueString, _valueString),
          valueQuantity,
          valueAttachment,
          valueReference,
        ),
      reason = reason,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.SupportingInfo,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.categorySer, it) }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.categorySer, it) }
    when (val __d = value.timing) {
      null -> {}
      is ExplanationOfBenefit.SupportingInfo.Timing.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Timing.Period -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.timingPeriodSer, __d.value)
      }
    }
    when (val __d = value.`value`) {
      null -> {}
      is ExplanationOfBenefit.SupportingInfo.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 14, Hoisted.valueQuantitySer, __d.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 15, Hoisted.valueAttachmentSer, __d.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 16, Hoisted.valueReferenceSer, __d.value)
      }
    }
    (value.reason)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.reasonSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val reasonSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object ExplanationOfBenefitDiagnosisSerializer :
  KSerializer<ExplanationOfBenefit.Diagnosis> {
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
      element(
        "diagnosisCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("diagnosisReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("onAdmission", CodeableConcept.serializer().descriptor, isOptional = true)
      element("packageCode", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Diagnosis =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Diagnosis) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Diagnosis {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var diagnosisCodeableConcept: CodeableConcept? = null
    var diagnosisReference: Reference? = null
    var type: List<CodeableConcept>? = null
    var onAdmission: CodeableConcept? = null
    var packageCode: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 ->
          diagnosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.diagnosisCodeableConceptSer,
              null,
            )
        6 ->
          diagnosisReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.diagnosisReferenceSer,
              null,
            )
        7 -> type = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeSer, null)
        8 ->
          onAdmission =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.diagnosisCodeableConceptSer,
              null,
            )
        9 ->
          packageCode =
            decoder.decodeNullableSerializableElement(
              __desc,
              9,
              Hoisted.diagnosisCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + __i)
      }
    }
    return ExplanationOfBenefit.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      diagnosis =
        ExplanationOfBenefit.Diagnosis.Diagnosis.from(
          diagnosisCodeableConcept,
          diagnosisReference,
        )!!,
      type = type ?: listOf(),
      onAdmission = onAdmission,
      packageCode = packageCode,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Diagnosis) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    when (val __d = value.diagnosis) {
      null -> {}
      is ExplanationOfBenefit.Diagnosis.Diagnosis.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.diagnosisCodeableConceptSer, __d.value)
      }
      is ExplanationOfBenefit.Diagnosis.Diagnosis.Reference -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.diagnosisReferenceSer, __d.value)
      }
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, value.type)
    (value.onAdmission)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.diagnosisCodeableConceptSer, it)
    }
    (value.packageCode)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.diagnosisCodeableConceptSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val diagnosisCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val diagnosisReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.diagnosisCodeableConceptSer)
  }
}

internal object ExplanationOfBenefitProcedureSerializer :
  KSerializer<ExplanationOfBenefit.Procedure> {
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
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element(
        "procedureCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("procedureReference", Reference.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Procedure =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Procedure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Procedure {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var type: List<CodeableConcept>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var procedureCodeableConcept: CodeableConcept? = null
    var procedureReference: Reference? = null
    var udi: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> date = decoder.decodeStringElement(__desc, 6)
        7 -> _date = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.sequenceSer, null)
        8 ->
          procedureCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSerInner, null)
        9 ->
          procedureReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              9,
              Hoisted.procedureReferenceSer,
              null,
            )
        10 -> udi = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.udiSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + __i)
      }
    }
    return ExplanationOfBenefit.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      type = type ?: listOf(),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      procedure =
        ExplanationOfBenefit.Procedure.Procedure.from(
          procedureCodeableConcept,
          procedureReference,
        )!!,
      udi = udi ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Procedure) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, value.type)
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.sequenceSer, it)
    }
    when (val __d = value.procedure) {
      null -> {}
      is ExplanationOfBenefit.Procedure.Procedure.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSerInner, __d.value)
      }
      is ExplanationOfBenefit.Procedure.Procedure.Reference -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.procedureReferenceSer, __d.value)
      }
    }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.udiSer, value.udi)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val procedureReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val udiSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.procedureReferenceSer)
  }
}

internal object ExplanationOfBenefitInsuranceSerializer :
  KSerializer<ExplanationOfBenefit.Insurance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Insurance") {
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
      element("focal", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_focal", Element.serializer().descriptor, isOptional = true)
      element("coverage", Reference.serializer().descriptor, isOptional = true)
      element(
        "preAuthRef",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_preAuthRef",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Insurance =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Insurance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Insurance {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var focal: KotlinBoolean? = null
    var _focal: Element? = null
    var coverage: Reference? = null
    var preAuthRef: List<KotlinString?>? = null
    var _preAuthRef: List<Element?>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> focal = decoder.decodeBooleanElement(__desc, 3)
        4 -> _focal = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.focalSer, null)
        5 ->
          coverage = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.coverageSer, null)
        6 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.preAuthRefSer, null)
        7 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.preAuthRefSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + __i)
      }
    }
    return ExplanationOfBenefit.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      focal = R4Boolean.of(focal, _focal)!!,
      coverage = coverage!!,
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { __i ->
          R4String.of(preAuthRef?.getOrNull(__i)?.let { it }, _preAuthRef?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Insurance) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.focal.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.focal.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.focalSer, it)
    }
    (value.coverage)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.coverageSer, it) }
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.preAuthRefSer, it)
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.preAuthRefSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val focalSer: KSerializer<Element> = Element.serializer()

    public val coverageSer: KSerializer<Reference> = Reference.serializer()

    public val preAuthRefSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val preAuthRefSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.preAuthRefSerInner).nullable)

    public val preAuthRefSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.focalSer).nullable)
  }
}

internal object ExplanationOfBenefitAccidentSerializer :
  KSerializer<ExplanationOfBenefit.Accident> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Accident") {
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
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("locationAddress", Address.serializer().descriptor, isOptional = true)
      element("locationReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Accident =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Accident) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Accident {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var type: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> date = decoder.decodeStringElement(__desc, 3)
        4 -> _date = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.dateSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.locationAddressSer, null)
        7 ->
          locationReference =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.locationReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Accident: " + __i)
      }
    }
    return ExplanationOfBenefit.Accident(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      date = Date.of(FhirDate.fromString(date), _date),
      type = type,
      location = ExplanationOfBenefit.Accident.Location.from(locationAddress, locationReference),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Accident) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.dateSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    when (val __d = value.location) {
      null -> {}
      is ExplanationOfBenefit.Accident.Location.Address -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.locationAddressSer, __d.value)
      }
      is ExplanationOfBenefit.Accident.Location.Reference -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.locationReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val dateSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val locationReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ExplanationOfBenefitItemSerializer : KSerializer<ExplanationOfBenefit.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
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
      element(
        "careTeamSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_careTeamSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "diagnosisSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_diagnosisSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "procedureSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_procedureSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "informationSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_informationSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
      element("locationCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("locationAddress", Address.serializer().descriptor, isOptional = true)
      element("locationReference", Reference.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "subSite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "encounter",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "detail",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Detail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Item {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var careTeamSequence: List<Int?>? = null
    var _careTeamSequence: List<Element?>? = null
    var diagnosisSequence: List<Int?>? = null
    var _diagnosisSequence: List<Element?>? = null
    var procedureSequence: List<Int?>? = null
    var _procedureSequence: List<Element?>? = null
    var informationSequence: List<Int?>? = null
    var _informationSequence: List<Element?>? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var locationCodeableConcept: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var bodySite: CodeableConcept? = null
    var subSite: List<CodeableConcept>? = null
    var encounter: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var detail: List<ExplanationOfBenefit.Item.Detail>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 ->
          careTeamSequence =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.careTeamSequenceSer, null)
        6 ->
          _careTeamSequence =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.careTeamSequenceSer2, null)
        7 ->
          diagnosisSequence =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.careTeamSequenceSer, null)
        8 ->
          _diagnosisSequence =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.careTeamSequenceSer2, null)
        9 ->
          procedureSequence =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.careTeamSequenceSer, null)
        10 ->
          _procedureSequence =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        11 ->
          informationSequence =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.careTeamSequenceSer, null)
        12 ->
          _informationSequence =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        13 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.revenueSer, null)
        14 ->
          category = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.revenueSer, null)
        15 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.revenueSer, null)
        16 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.modifierSer, null)
        17 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.modifierSer, null)
        18 -> servicedDate = decoder.decodeStringElement(__desc, 18)
        19 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.sequenceSer, null)
        20 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.servicedPeriodSer, null)
        21 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.revenueSer, null)
        22 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.locationAddressSer, null)
        23 ->
          locationReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              23,
              Hoisted.locationReferenceSer,
              null,
            )
        24 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.quantitySer, null)
        25 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.unitPriceSer, null)
        26 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 26, BigDecimalSerializer, null)
        27 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.sequenceSer, null)
        28 ->
          net = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.unitPriceSer, null)
        29 -> udi = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.udiSer, null)
        30 ->
          bodySite = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.revenueSer, null)
        31 ->
          subSite = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.modifierSer, null)
        32 ->
          encounter = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.udiSer, null)
        33 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.careTeamSequenceSer, null)
        34 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              __desc,
              34,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        35 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.adjudicationSer, null)
        36 ->
          detail = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + __i)
      }
    }
    return ExplanationOfBenefit.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      careTeamSequence =
        (kotlin.collections.List(
          maxOf(careTeamSequence?.size ?: 0, _careTeamSequence?.size ?: 0)
        ) { __i ->
          PositiveInt.of(
            careTeamSequence?.getOrNull(__i)?.let { it },
            _careTeamSequence?.getOrNull(__i),
          )!!
        }),
      diagnosisSequence =
        (kotlin.collections.List(
          maxOf(diagnosisSequence?.size ?: 0, _diagnosisSequence?.size ?: 0)
        ) { __i ->
          PositiveInt.of(
            diagnosisSequence?.getOrNull(__i)?.let { it },
            _diagnosisSequence?.getOrNull(__i),
          )!!
        }),
      procedureSequence =
        (kotlin.collections.List(
          maxOf(procedureSequence?.size ?: 0, _procedureSequence?.size ?: 0)
        ) { __i ->
          PositiveInt.of(
            procedureSequence?.getOrNull(__i)?.let { it },
            _procedureSequence?.getOrNull(__i),
          )!!
        }),
      informationSequence =
        (kotlin.collections.List(
          maxOf(informationSequence?.size ?: 0, _informationSequence?.size ?: 0)
        ) { __i ->
          PositiveInt.of(
            informationSequence?.getOrNull(__i)?.let { it },
            _informationSequence?.getOrNull(__i),
          )!!
        }),
      revenue = revenue,
      category = category,
      productOrService = productOrService!!,
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      serviced =
        ExplanationOfBenefit.Item.Serviced.from(
          Date.of(FhirDate.fromString(servicedDate), _servicedDate),
          servicedPeriod,
        ),
      location =
        ExplanationOfBenefit.Item.Location.from(
          locationCodeableConcept,
          locationAddress,
          locationReference,
        ),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
      bodySite = bodySite,
      subSite = subSite ?: listOf(),
      encounter = encounter ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Item) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    (value.careTeamSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.careTeamSequenceSer, it)
    }
    (value.careTeamSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.careTeamSequenceSer2, it)
    }
    (value.diagnosisSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.careTeamSequenceSer, it)
    }
    (value.diagnosisSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.careTeamSequenceSer2, it)
    }
    (value.procedureSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.careTeamSequenceSer, it)
    }
    (value.procedureSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.careTeamSequenceSer2, it)
    }
    (value.informationSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.careTeamSequenceSer, it)
    }
    (value.informationSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.careTeamSequenceSer2, it)
    }
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.revenueSer, it) }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.modifierSer, value.programCode)
    when (val __d = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.Item.Serviced.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 19, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.Item.Serviced.Period -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.servicedPeriodSer, __d.value)
      }
    }
    when (val __d = value.location) {
      null -> {}
      is ExplanationOfBenefit.Item.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.revenueSer, __d.value)
      }
      is ExplanationOfBenefit.Item.Location.Address -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.locationAddressSer, __d.value)
      }
      is ExplanationOfBenefit.Item.Location.Reference -> {
        encoder.encodeSerializableElement(__desc, 23, Hoisted.locationReferenceSer, __d.value)
      }
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 26, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.sequenceSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.unitPriceSer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.udiSer, value.udi)
    (value.bodySite)?.let { encoder.encodeSerializableElement(__desc, 30, Hoisted.revenueSer, it) }
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.modifierSer, value.subSite)
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.udiSer, value.encounter)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.careTeamSequenceSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.careTeamSequenceSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val careTeamSequenceSerInner: KSerializer<Int> = Int.serializer()

    public val careTeamSequenceSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.careTeamSequenceSerInner).nullable)

    public val careTeamSequenceSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.sequenceSer).nullable)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val locationReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val udiSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.locationReferenceSer)

    public val adjudicationSerInner: KSerializer<ExplanationOfBenefit.Item.Adjudication> =
      ExplanationOfBenefit.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val detailSerInner: KSerializer<ExplanationOfBenefit.Item.Detail> =
      ExplanationOfBenefit.Item.Detail.serializer()

    public val detailSer: KSerializer<List<ExplanationOfBenefit.Item.Detail>> =
      ListSerializer(Hoisted.detailSerInner)
  }
}

internal object ExplanationOfBenefitItemAdjudicationSerializer :
  KSerializer<ExplanationOfBenefit.Item.Adjudication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Adjudication") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
      element("value", BigDecimalSerializer.descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Adjudication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Adjudication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Item.Adjudication {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var reason: CodeableConcept? = null
    var amount: Money? = null
    var `value`: BigDecimal? = null
    var _value: Element? = null
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
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        5 -> amount = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.amountSer, null)
        6 ->
          `value` = decoder.decodeNullableSerializableElement(__desc, 6, BigDecimalSerializer, null)
        7 -> _value = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Adjudication: " + __i)
      }
    }
    return ExplanationOfBenefit.Item.Adjudication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category!!,
      reason = reason,
      amount = amount,
      `value` = Decimal.of(`value`, _value),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.Adjudication,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.reason)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.amountSer, it) }
    ((value.`value`?.value))?.let {
      encoder.encodeSerializableElement(__desc, 6, BigDecimalSerializer, it)
    }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ExplanationOfBenefitItemDetailSerializer :
  KSerializer<ExplanationOfBenefit.Item.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
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
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "subDetail",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Detail.SubDetail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Detail =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Item.Detail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var subDetail: List<ExplanationOfBenefit.Item.Detail.SubDetail>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.revenueSer, null)
        6 ->
          category = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.revenueSer, null)
        7 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.revenueSer, null)
        8 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.modifierSer, null)
        9 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.modifierSer, null)
        10 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.quantitySer, null)
        11 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.unitPriceSer, null)
        12 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 12, BigDecimalSerializer, null)
        13 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.sequenceSer, null)
        14 ->
          net = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.unitPriceSer, null)
        15 -> udi = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.udiSer, null)
        16 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.noteNumberSer, null)
        17 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.noteNumberSer2, null)
        18 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.adjudicationSer, null)
        19 ->
          subDetail =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + __i)
      }
    }
    return ExplanationOfBenefit.Item.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      revenue = revenue,
      category = category,
      productOrService = productOrService!!,
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Item.Detail) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.revenueSer, it) }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.modifierSer, value.programCode)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 12, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.sequenceSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.unitPriceSer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.udiSer, value.udi)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.subDetailSer, value.subDetail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val udiSerInner: KSerializer<Reference> = Reference.serializer()

    public val udiSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.udiSerInner)

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.sequenceSer).nullable)

    public val adjudicationSerInner: KSerializer<ExplanationOfBenefit.Item.Adjudication> =
      ExplanationOfBenefit.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val subDetailSerInner: KSerializer<ExplanationOfBenefit.Item.Detail.SubDetail> =
      ExplanationOfBenefit.Item.Detail.SubDetail.serializer()

    public val subDetailSer: KSerializer<List<ExplanationOfBenefit.Item.Detail.SubDetail>> =
      ListSerializer(Hoisted.subDetailSerInner)
  }
}

internal object ExplanationOfBenefitItemDetailSubDetailSerializer :
  KSerializer<ExplanationOfBenefit.Item.Detail.SubDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubDetail") {
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
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Detail.SubDetail =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.Item.Detail.SubDetail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.revenueSer, null)
        6 ->
          category = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.revenueSer, null)
        7 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.revenueSer, null)
        8 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.modifierSer, null)
        9 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.modifierSer, null)
        10 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.quantitySer, null)
        11 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.unitPriceSer, null)
        12 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 12, BigDecimalSerializer, null)
        13 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.sequenceSer, null)
        14 ->
          net = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.unitPriceSer, null)
        15 -> udi = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.udiSer, null)
        16 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.noteNumberSer, null)
        17 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.noteNumberSer2, null)
        18 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + __i)
      }
    }
    return ExplanationOfBenefit.Item.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      revenue = revenue,
      category = category,
      productOrService = productOrService!!,
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      adjudication = adjudication ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.Detail.SubDetail,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.revenueSer, it) }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.modifierSer, value.programCode)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 12, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.sequenceSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.unitPriceSer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.udiSer, value.udi)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.adjudicationSer, value.adjudication)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val udiSerInner: KSerializer<Reference> = Reference.serializer()

    public val udiSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.udiSerInner)

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.sequenceSer).nullable)

    public val adjudicationSerInner: KSerializer<ExplanationOfBenefit.Item.Adjudication> =
      ExplanationOfBenefit.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)
  }
}

internal object ExplanationOfBenefitAddItemSerializer : KSerializer<ExplanationOfBenefit.AddItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AddItem") {
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
      element("itemSequence", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_itemSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "detailSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_detailSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "subDetailSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_subDetailSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "provider",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
      element("locationCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("locationAddress", Address.serializer().descriptor, isOptional = true)
      element("locationReference", Reference.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "subSite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "detail",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.AddItem.Detail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.AddItem {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemSequence: List<Int?>? = null
    var _itemSequence: List<Element?>? = null
    var detailSequence: List<Int?>? = null
    var _detailSequence: List<Element?>? = null
    var subDetailSequence: List<Int?>? = null
    var _subDetailSequence: List<Element?>? = null
    var provider: List<Reference>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var locationCodeableConcept: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var bodySite: CodeableConcept? = null
    var subSite: List<CodeableConcept>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var detail: List<ExplanationOfBenefit.AddItem.Detail>? = null
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
          itemSequence =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.itemSequenceSer, null)
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemSequenceSer2, null)
        5 ->
          detailSequence =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.itemSequenceSer, null)
        6 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.itemSequenceSer2, null)
        7 ->
          subDetailSequence =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.itemSequenceSer, null)
        8 ->
          _subDetailSequence =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.itemSequenceSer2, null)
        9 ->
          provider = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.providerSer, null)
        10 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.productOrServiceSer, null)
        11 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.modifierSer, null)
        12 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.modifierSer, null)
        13 -> servicedDate = decoder.decodeStringElement(__desc, 13)
        14 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        15 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.servicedPeriodSer, null)
        16 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.productOrServiceSer, null)
        17 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.locationAddressSer, null)
        18 ->
          locationReference =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.providerSerInner, null)
        19 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.quantitySer, null)
        20 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.unitPriceSer, null)
        21 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 21, BigDecimalSerializer, null)
        22 ->
          _factor =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        23 ->
          net = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.unitPriceSer, null)
        24 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.productOrServiceSer, null)
        25 ->
          subSite = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.modifierSer, null)
        26 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.itemSequenceSer, null)
        27 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.itemSequenceSer2, null)
        28 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.adjudicationSer, null)
        29 ->
          detail = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AddItem: " + __i)
      }
    }
    return ExplanationOfBenefit.AddItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence =
        (kotlin.collections.List(maxOf(itemSequence?.size ?: 0, _itemSequence?.size ?: 0)) { __i ->
          PositiveInt.of(itemSequence?.getOrNull(__i)?.let { it }, _itemSequence?.getOrNull(__i))!!
        }),
      detailSequence =
        (kotlin.collections.List(maxOf(detailSequence?.size ?: 0, _detailSequence?.size ?: 0)) { __i
          ->
          PositiveInt.of(
            detailSequence?.getOrNull(__i)?.let { it },
            _detailSequence?.getOrNull(__i),
          )!!
        }),
      subDetailSequence =
        (kotlin.collections.List(
          maxOf(subDetailSequence?.size ?: 0, _subDetailSequence?.size ?: 0)
        ) { __i ->
          PositiveInt.of(
            subDetailSequence?.getOrNull(__i)?.let { it },
            _subDetailSequence?.getOrNull(__i),
          )!!
        }),
      provider = provider ?: listOf(),
      productOrService = productOrService!!,
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      serviced =
        ExplanationOfBenefit.AddItem.Serviced.from(
          Date.of(FhirDate.fromString(servicedDate), _servicedDate),
          servicedPeriod,
        ),
      location =
        ExplanationOfBenefit.AddItem.Location.from(
          locationCodeableConcept,
          locationAddress,
          locationReference,
        ),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      bodySite = bodySite,
      subSite = subSite ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.AddItem) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.itemSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.itemSequenceSer, it)
    }
    (value.itemSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.itemSequenceSer2, it)
    }
    (value.detailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.itemSequenceSer, it)
    }
    (value.detailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.itemSequenceSer2, it)
    }
    (value.subDetailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.itemSequenceSer, it)
    }
    (value.subDetailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.itemSequenceSer2, it)
    }
    if (value.provider.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.providerSer, value.provider)
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.productOrServiceSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.modifierSer, value.programCode)
    when (val __d = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Serviced.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.itemSequenceSerInner2, it)
        }
      }
      is ExplanationOfBenefit.AddItem.Serviced.Period -> {
        encoder.encodeSerializableElement(__desc, 15, Hoisted.servicedPeriodSer, __d.value)
      }
    }
    when (val __d = value.location) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 16, Hoisted.productOrServiceSer, __d.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Address -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.locationAddressSer, __d.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Reference -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.providerSerInner, __d.value)
      }
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 21, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.itemSequenceSerInner2, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.unitPriceSer, it) }
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.productOrServiceSer, it)
    }
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.modifierSer, value.subSite)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.itemSequenceSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.itemSequenceSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSequenceSerInner: KSerializer<Int> = Int.serializer()

    public val itemSequenceSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.itemSequenceSerInner).nullable)

    public val itemSequenceSerInner2: KSerializer<Element> = Element.serializer()

    public val itemSequenceSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.itemSequenceSerInner2).nullable)

    public val providerSerInner: KSerializer<Reference> = Reference.serializer()

    public val providerSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.providerSerInner)

    public val productOrServiceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.productOrServiceSer)

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val adjudicationSerInner: KSerializer<ExplanationOfBenefit.Item.Adjudication> =
      ExplanationOfBenefit.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val detailSerInner: KSerializer<ExplanationOfBenefit.AddItem.Detail> =
      ExplanationOfBenefit.AddItem.Detail.serializer()

    public val detailSer: KSerializer<List<ExplanationOfBenefit.AddItem.Detail>> =
      ListSerializer(Hoisted.detailSerInner)
  }
}

internal object ExplanationOfBenefitAddItemDetailSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
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
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "subDetail",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.AddItem.Detail.SubDetail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Detail =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.AddItem.Detail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var subDetail: List<ExplanationOfBenefit.AddItem.Detail.SubDetail>? = null
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
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.productOrServiceSer, null)
        4 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.modifierSer, null)
        5 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.quantitySer, null)
        6 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.unitPriceSer, null)
        7 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 7, BigDecimalSerializer, null)
        8 -> _factor = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.factorSer, null)
        9 -> net = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.unitPriceSer, null)
        10 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.noteNumberSer, null)
        11 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.noteNumberSer2, null)
        12 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.adjudicationSer, null)
        13 ->
          subDetail =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + __i)
      }
    }
    return ExplanationOfBenefit.AddItem.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productOrService = productOrService!!,
      modifier = modifier ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.AddItem.Detail,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.productOrServiceSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.modifierSer, value.modifier)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 7, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.factorSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.unitPriceSer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.subDetailSer, value.subDetail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productOrServiceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.productOrServiceSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val factorSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.factorSer).nullable)

    public val adjudicationSerInner: KSerializer<ExplanationOfBenefit.Item.Adjudication> =
      ExplanationOfBenefit.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val subDetailSerInner: KSerializer<ExplanationOfBenefit.AddItem.Detail.SubDetail> =
      ExplanationOfBenefit.AddItem.Detail.SubDetail.serializer()

    public val subDetailSer: KSerializer<List<ExplanationOfBenefit.AddItem.Detail.SubDetail>> =
      ListSerializer(Hoisted.subDetailSerInner)
  }
}

internal object ExplanationOfBenefitAddItemDetailSubDetailSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Detail.SubDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubDetail") {
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
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Detail.SubDetail =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.AddItem.Detail.SubDetail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
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
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.productOrServiceSer, null)
        4 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.modifierSer, null)
        5 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.quantitySer, null)
        6 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.unitPriceSer, null)
        7 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 7, BigDecimalSerializer, null)
        8 -> _factor = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.factorSer, null)
        9 -> net = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.unitPriceSer, null)
        10 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.noteNumberSer, null)
        11 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.noteNumberSer2, null)
        12 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + __i)
      }
    }
    return ExplanationOfBenefit.AddItem.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productOrService = productOrService!!,
      modifier = modifier ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      adjudication = adjudication ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.AddItem.Detail.SubDetail,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.productOrServiceSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.modifierSer, value.modifier)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 7, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.factorSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.unitPriceSer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.noteNumberSer2, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.adjudicationSer, value.adjudication)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productOrServiceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.productOrServiceSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val factorSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.factorSer).nullable)

    public val adjudicationSerInner: KSerializer<ExplanationOfBenefit.Item.Adjudication> =
      ExplanationOfBenefit.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)
  }
}

internal object ExplanationOfBenefitTotalSerializer : KSerializer<ExplanationOfBenefit.Total> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Total") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Total =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Total) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Total {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var amount: Money? = null
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
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 -> amount = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Total: " + __i)
      }
    }
    return ExplanationOfBenefit.Total(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category!!,
      amount = amount!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Total) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()
  }
}

internal object ExplanationOfBenefitPaymentSerializer : KSerializer<ExplanationOfBenefit.Payment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payment") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("adjustment", Money.serializer().descriptor, isOptional = true)
      element("adjustmentReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Payment =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payment) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Payment {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var adjustment: Money? = null
    var adjustmentReason: CodeableConcept? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var amount: Money? = null
    var identifier: Identifier? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          adjustment =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.adjustmentSer, null)
        5 ->
          adjustmentReason =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> date = decoder.decodeStringElement(__desc, 6)
        7 -> _date = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.dateSer, null)
        8 ->
          amount = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.adjustmentSer, null)
        9 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.identifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payment: " + __i)
      }
    }
    return ExplanationOfBenefit.Payment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      adjustment = adjustment,
      adjustmentReason = adjustmentReason,
      date = Date.of(FhirDate.fromString(date), _date),
      amount = amount,
      identifier = identifier,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Payment) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.adjustment)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.adjustmentSer, it)
    }
    (value.adjustmentReason)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.dateSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.adjustmentSer, it) }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.identifierSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val adjustmentSer: KSerializer<Money> = Money.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()
  }
}

internal object ExplanationOfBenefitProcessNoteSerializer :
  KSerializer<ExplanationOfBenefit.ProcessNote> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProcessNote") {
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
      element("number", Int.serializer().descriptor, isOptional = true)
      element("_number", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element("language", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.ProcessNote =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.ProcessNote) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.ProcessNote {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var number: Int? = null
    var _number: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var language: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> number = decoder.decodeIntElement(__desc, 3)
        4 -> _number = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.numberSer, null)
        5 -> type = decoder.decodeStringElement(__desc, 5)
        6 -> _type = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.numberSer, null)
        7 -> text = decoder.decodeStringElement(__desc, 7)
        8 -> _text = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.numberSer, null)
        9 ->
          language = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + __i)
      }
    }
    return ExplanationOfBenefit.ProcessNote(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      number = PositiveInt.of(number, _number),
      type = type?.let { Enumeration.of(NoteType.fromCode(it), _type) },
      text = R4String.of(text, _text),
      language = language,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.ProcessNote) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.number?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.numberSer, it)
    }
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.numberSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.numberSer, it)
    }
    (value.language)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.languageSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val numberSer: KSerializer<Element> = Element.serializer()

    public val languageSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ExplanationOfBenefitBenefitBalanceSerializer :
  KSerializer<ExplanationOfBenefit.BenefitBalance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BenefitBalance") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("excluded", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_excluded", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("network", CodeableConcept.serializer().descriptor, isOptional = true)
      element("unit", CodeableConcept.serializer().descriptor, isOptional = true)
      element("term", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "financial",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.BenefitBalance.Financial.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.BenefitBalance {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var excluded: KotlinBoolean? = null
    var _excluded: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var network: CodeableConcept? = null
    var unit: CodeableConcept? = null
    var term: CodeableConcept? = null
    var financial: List<ExplanationOfBenefit.BenefitBalance.Financial>? = null
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
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 -> excluded = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _excluded =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.excludedSer, null)
        6 -> name = decoder.decodeStringElement(__desc, 6)
        7 -> _name = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.excludedSer, null)
        8 -> description = decoder.decodeStringElement(__desc, 8)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.excludedSer, null)
        10 ->
          network = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.categorySer, null)
        11 ->
          unit = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.categorySer, null)
        12 ->
          term = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.categorySer, null)
        13 ->
          financial =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.financialSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BenefitBalance: " + __i)
      }
    }
    return ExplanationOfBenefit.BenefitBalance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category!!,
      excluded = R4Boolean.of(excluded, _excluded),
      name = R4String.of(name, _name),
      description = R4String.of(description, _description),
      network = network,
      unit = unit,
      term = term,
      financial = financial ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.BenefitBalance,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    ((value.excluded?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.excluded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.excludedSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.excludedSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.excludedSer, it)
    }
    (value.network)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.categorySer, it) }
    (value.unit)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.categorySer, it) }
    (value.term)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.categorySer, it) }
    if (value.financial.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.financialSer, value.financial)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val excludedSer: KSerializer<Element> = Element.serializer()

    public val financialSerInner: KSerializer<ExplanationOfBenefit.BenefitBalance.Financial> =
      ExplanationOfBenefit.BenefitBalance.Financial.serializer()

    public val financialSer: KSerializer<List<ExplanationOfBenefit.BenefitBalance.Financial>> =
      ListSerializer(Hoisted.financialSerInner)
  }
}

internal object ExplanationOfBenefitBenefitBalanceFinancialSerializer :
  KSerializer<ExplanationOfBenefit.BenefitBalance.Financial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Financial") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("allowedUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_allowedUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("allowedString", KotlinString.serializer().descriptor, isOptional = true)
      element("_allowedString", Element.serializer().descriptor, isOptional = true)
      element("allowedMoney", Money.serializer().descriptor, isOptional = true)
      element("usedUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_usedUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("usedMoney", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance.Financial =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance.Financial) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.BenefitBalance.Financial {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var allowedUnsignedInt: Int? = null
    var _allowedUnsignedInt: Element? = null
    var allowedString: KotlinString? = null
    var _allowedString: Element? = null
    var allowedMoney: Money? = null
    var usedUnsignedInt: Int? = null
    var _usedUnsignedInt: Element? = null
    var usedMoney: Money? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> allowedUnsignedInt = decoder.decodeIntElement(__desc, 4)
        5 ->
          _allowedUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        6 -> allowedString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _allowedString =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        8 ->
          allowedMoney =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.allowedMoneySer, null)
        9 -> usedUnsignedInt = decoder.decodeIntElement(__desc, 9)
        10 ->
          _usedUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        11 ->
          usedMoney =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.allowedMoneySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Financial: " + __i)
      }
    }
    return ExplanationOfBenefit.BenefitBalance.Financial(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      allowed =
        ExplanationOfBenefit.BenefitBalance.Financial.Allowed.from(
          UnsignedInt.of(allowedUnsignedInt, _allowedUnsignedInt),
          R4String.of(allowedString, _allowedString),
          allowedMoney,
        ),
      used =
        ExplanationOfBenefit.BenefitBalance.Financial.Used.from(
          UnsignedInt.of(usedUnsignedInt, _usedUnsignedInt),
          usedMoney,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.BenefitBalance.Financial,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.allowed) {
      null -> {}
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.Money -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.allowedMoneySer, __d.value)
      }
    }
    when (val __d = value.used) {
      null -> {}
      is ExplanationOfBenefit.BenefitBalance.Financial.Used.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Used.Money -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.allowedMoneySer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val allowedUnsignedIntSer: KSerializer<Element> = Element.serializer()

    public val allowedMoneySer: KSerializer<Money> = Money.serializer()
  }
}

internal object ExplanationOfBenefitSerializer : KSerializer<ExplanationOfBenefit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ExplanationOfBenefit") {
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", Element.serializer().descriptor, isOptional = true)
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("billablePeriod", Period.serializer().descriptor, isOptional = true)
      element("created", KotlinString.serializer().descriptor, isOptional = true)
      element("_created", Element.serializer().descriptor, isOptional = true)
      element("enterer", Reference.serializer().descriptor, isOptional = true)
      element("insurer", Reference.serializer().descriptor, isOptional = true)
      element("provider", Reference.serializer().descriptor, isOptional = true)
      element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
      element("fundsReserveRequested", CodeableConcept.serializer().descriptor, isOptional = true)
      element("fundsReserve", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "related",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Related.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("prescription", Reference.serializer().descriptor, isOptional = true)
      element("originalPrescription", Reference.serializer().descriptor, isOptional = true)
      element(
        "payee",
        lazyDescriptor { ExplanationOfBenefit.Payee.serializer().descriptor },
        isOptional = true,
      )
      element("referral", Reference.serializer().descriptor, isOptional = true)
      element("facility", Reference.serializer().descriptor, isOptional = true)
      element("claim", Reference.serializer().descriptor, isOptional = true)
      element("claimResponse", Reference.serializer().descriptor, isOptional = true)
      element("outcome", KotlinString.serializer().descriptor, isOptional = true)
      element("_outcome", Element.serializer().descriptor, isOptional = true)
      element("disposition", KotlinString.serializer().descriptor, isOptional = true)
      element("_disposition", Element.serializer().descriptor, isOptional = true)
      element(
        "preAuthRef",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_preAuthRef",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "preAuthRefPeriod",
        listSerialDescriptor(Period.serializer().descriptor),
        isOptional = true,
      )
      element(
        "careTeam",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.CareTeam.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "supportingInfo",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.SupportingInfo.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "diagnosis",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Diagnosis.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "procedure",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Procedure.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("precedence", Int.serializer().descriptor, isOptional = true)
      element("_precedence", Element.serializer().descriptor, isOptional = true)
      element(
        "insurance",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Insurance.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "accident",
        lazyDescriptor { ExplanationOfBenefit.Accident.serializer().descriptor },
        isOptional = true,
      )
      element(
        "item",
        listSerialDescriptor(lazyDescriptor { ExplanationOfBenefit.Item.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "addItem",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.AddItem.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.Adjudication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "total",
        listSerialDescriptor(lazyDescriptor { ExplanationOfBenefit.Total.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "payment",
        lazyDescriptor { ExplanationOfBenefit.Payment.serializer().descriptor },
        isOptional = true,
      )
      element("formCode", CodeableConcept.serializer().descriptor, isOptional = true)
      element("form", Attachment.serializer().descriptor, isOptional = true)
      element(
        "processNote",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.ProcessNote.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("benefitPeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "benefitBalance",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.BenefitBalance.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit {
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
    var identifier: List<Identifier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var subType: CodeableConcept? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var patient: Reference? = null
    var billablePeriod: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var enterer: Reference? = null
    var insurer: Reference? = null
    var provider: Reference? = null
    var priority: CodeableConcept? = null
    var fundsReserveRequested: CodeableConcept? = null
    var fundsReserve: CodeableConcept? = null
    var related: List<ExplanationOfBenefit.Related>? = null
    var prescription: Reference? = null
    var originalPrescription: Reference? = null
    var payee: ExplanationOfBenefit.Payee? = null
    var referral: Reference? = null
    var facility: Reference? = null
    var claim: Reference? = null
    var claimResponse: Reference? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var preAuthRef: List<KotlinString?>? = null
    var _preAuthRef: List<Element?>? = null
    var preAuthRefPeriod: List<Period>? = null
    var careTeam: List<ExplanationOfBenefit.CareTeam>? = null
    var supportingInfo: List<ExplanationOfBenefit.SupportingInfo>? = null
    var diagnosis: List<ExplanationOfBenefit.Diagnosis>? = null
    var procedure: List<ExplanationOfBenefit.Procedure>? = null
    var precedence: Int? = null
    var _precedence: Element? = null
    var insurance: List<ExplanationOfBenefit.Insurance>? = null
    var accident: ExplanationOfBenefit.Accident? = null
    var item: List<ExplanationOfBenefit.Item>? = null
    var addItem: List<ExplanationOfBenefit.AddItem>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var total: List<ExplanationOfBenefit.Total>? = null
    var payment: ExplanationOfBenefit.Payment? = null
    var formCode: CodeableConcept? = null
    var form: Attachment? = null
    var processNote: List<ExplanationOfBenefit.ProcessNote>? = null
    var benefitPeriod: Period? = null
    var benefitBalance: List<ExplanationOfBenefit.BenefitBalance>? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> type = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.typeSer, null)
        15 -> subType = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.typeSer, null)
        16 -> use = decoder.decodeStringElement(__desc, 16)
        17 ->
          _use =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.patientSer, null)
        19 ->
          billablePeriod =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.billablePeriodSer, null)
        20 -> created = decoder.decodeStringElement(__desc, 20)
        21 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          enterer = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.patientSer, null)
        23 ->
          insurer = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.patientSer, null)
        24 ->
          provider = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.patientSer, null)
        25 ->
          priority = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.typeSer, null)
        26 ->
          fundsReserveRequested =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.typeSer, null)
        27 ->
          fundsReserve =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.typeSer, null)
        28 ->
          related = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.relatedSer, null)
        29 ->
          prescription =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.patientSer, null)
        30 ->
          originalPrescription =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.patientSer, null)
        31 -> payee = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.payeeSer, null)
        32 ->
          referral = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.patientSer, null)
        33 ->
          facility = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.patientSer, null)
        34 ->
          claim = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.patientSer, null)
        35 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.patientSer, null)
        36 -> outcome = decoder.decodeStringElement(__desc, 36)
        37 ->
          _outcome =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> disposition = decoder.decodeStringElement(__desc, 38)
        39 ->
          _disposition =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.preAuthRefSer, null)
        41 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.preAuthRefSer2, null)
        42 ->
          preAuthRefPeriod =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.preAuthRefPeriodSer, null)
        43 ->
          careTeam =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.careTeamSer, null)
        44 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.supportingInfoSer, null)
        45 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.diagnosisSer, null)
        46 ->
          procedure =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.procedureSer, null)
        47 -> precedence = decoder.decodeIntElement(__desc, 47)
        48 ->
          _precedence =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.implicitRulesSer, null)
        49 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.insuranceSer, null)
        50 ->
          accident =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.accidentSer, null)
        51 -> item = decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.itemSer, null)
        52 ->
          addItem = decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.addItemSer, null)
        53 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.adjudicationSer, null)
        54 -> total = decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.totalSer, null)
        55 ->
          payment = decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.paymentSer, null)
        56 ->
          formCode = decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.typeSer, null)
        57 -> form = decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.formSer, null)
        58 ->
          processNote =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.processNoteSer, null)
        59 ->
          benefitPeriod =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.billablePeriodSer, null)
        60 ->
          benefitBalance =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.benefitBalanceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ExplanationOfBenefit: " + __i)
      }
    }
    return ExplanationOfBenefit(
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
        Enumeration.of(ExplanationOfBenefit.ExplanationOfBenefitStatus.fromCode(status!!), _status),
      type = type!!,
      subType = subType,
      use = Enumeration.of(ExplanationOfBenefit.Use.fromCode(use!!), _use),
      patient = patient!!,
      billablePeriod = billablePeriod,
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      enterer = enterer,
      insurer = insurer!!,
      provider = provider!!,
      priority = priority,
      fundsReserveRequested = fundsReserveRequested,
      fundsReserve = fundsReserve,
      related = related ?: listOf(),
      prescription = prescription,
      originalPrescription = originalPrescription,
      payee = payee,
      referral = referral,
      facility = facility,
      claim = claim,
      claimResponse = claimResponse,
      outcome =
        Enumeration.of(ExplanationOfBenefit.ClaimProcessingCodes.fromCode(outcome!!), _outcome),
      disposition = R4String.of(disposition, _disposition),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { __i ->
          R4String.of(preAuthRef?.getOrNull(__i)?.let { it }, _preAuthRef?.getOrNull(__i))!!
        }),
      preAuthRefPeriod = preAuthRefPeriod ?: listOf(),
      careTeam = careTeam ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      precedence = PositiveInt.of(precedence, _precedence),
      insurance = insurance ?: listOf(),
      accident = accident,
      item = item ?: listOf(),
      addItem = addItem ?: listOf(),
      adjudication = adjudication ?: listOf(),
      total = total ?: listOf(),
      payment = payment,
      formCode = formCode,
      form = form,
      processNote = processNote ?: listOf(),
      benefitPeriod = benefitPeriod,
      benefitBalance = benefitBalance ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ExplanationOfBenefit")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.typeSer, it) }
    (value.subType)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.typeSer, it) }
    ((value.use.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.patientSer, it) }
    (value.billablePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.billablePeriodSer, it)
    }
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    (value.enterer)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.patientSer, it) }
    (value.insurer)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.patientSer, it) }
    (value.provider)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.patientSer, it) }
    (value.priority)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.typeSer, it) }
    (value.fundsReserveRequested)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.typeSer, it)
    }
    (value.fundsReserve)?.let { encoder.encodeSerializableElement(__desc, 27, Hoisted.typeSer, it) }
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.relatedSer, value.related)
    (value.prescription)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.patientSer, it)
    }
    (value.originalPrescription)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.patientSer, it)
    }
    (value.payee)?.let { encoder.encodeSerializableElement(__desc, 31, Hoisted.payeeSer, it) }
    (value.referral)?.let { encoder.encodeSerializableElement(__desc, 32, Hoisted.patientSer, it) }
    (value.facility)?.let { encoder.encodeSerializableElement(__desc, 33, Hoisted.patientSer, it) }
    (value.claim)?.let { encoder.encodeSerializableElement(__desc, 34, Hoisted.patientSer, it) }
    (value.claimResponse)?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.patientSer, it)
    }
    ((value.outcome.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.outcome.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.disposition?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.preAuthRefSer, it)
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.preAuthRefSer2, it)
    }
    if (value.preAuthRefPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        42,
        Hoisted.preAuthRefPeriodSer,
        value.preAuthRefPeriod,
      )
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.careTeamSer, value.careTeam)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.supportingInfoSer, value.supportingInfo)
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.diagnosisSer, value.diagnosis)
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.procedureSer, value.procedure)
    ((value.precedence?.value))?.let { encoder.encodeIntElement(__desc, 47, it) }
    (value.precedence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.implicitRulesSer, it)
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.insuranceSer, value.insurance)
    (value.accident)?.let { encoder.encodeSerializableElement(__desc, 50, Hoisted.accidentSer, it) }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.itemSer, value.item)
    if (value.addItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52, Hoisted.addItemSer, value.addItem)
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.adjudicationSer, value.adjudication)
    if (value.total.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54, Hoisted.totalSer, value.total)
    (value.payment)?.let { encoder.encodeSerializableElement(__desc, 55, Hoisted.paymentSer, it) }
    (value.formCode)?.let { encoder.encodeSerializableElement(__desc, 56, Hoisted.typeSer, it) }
    (value.form)?.let { encoder.encodeSerializableElement(__desc, 57, Hoisted.formSer, it) }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 58, Hoisted.processNoteSer, value.processNote)
    (value.benefitPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 59, Hoisted.billablePeriodSer, it)
    }
    if (value.benefitBalance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 60, Hoisted.benefitBalanceSer, value.benefitBalance)
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val billablePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedSerInner: KSerializer<ExplanationOfBenefit.Related> =
      ExplanationOfBenefit.Related.serializer()

    public val relatedSer: KSerializer<List<ExplanationOfBenefit.Related>> =
      ListSerializer(Hoisted.relatedSerInner)

    public val payeeSer: KSerializer<ExplanationOfBenefit.Payee> =
      ExplanationOfBenefit.Payee.serializer()

    public val preAuthRefSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val preAuthRefSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.preAuthRefSerInner).nullable)

    public val preAuthRefSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val preAuthRefPeriodSer: KSerializer<List<Period>> =
      ListSerializer(Hoisted.billablePeriodSer)

    public val careTeamSerInner: KSerializer<ExplanationOfBenefit.CareTeam> =
      ExplanationOfBenefit.CareTeam.serializer()

    public val careTeamSer: KSerializer<List<ExplanationOfBenefit.CareTeam>> =
      ListSerializer(Hoisted.careTeamSerInner)

    public val supportingInfoSerInner: KSerializer<ExplanationOfBenefit.SupportingInfo> =
      ExplanationOfBenefit.SupportingInfo.serializer()

    public val supportingInfoSer: KSerializer<List<ExplanationOfBenefit.SupportingInfo>> =
      ListSerializer(Hoisted.supportingInfoSerInner)

    public val diagnosisSerInner: KSerializer<ExplanationOfBenefit.Diagnosis> =
      ExplanationOfBenefit.Diagnosis.serializer()

    public val diagnosisSer: KSerializer<List<ExplanationOfBenefit.Diagnosis>> =
      ListSerializer(Hoisted.diagnosisSerInner)

    public val procedureSerInner: KSerializer<ExplanationOfBenefit.Procedure> =
      ExplanationOfBenefit.Procedure.serializer()

    public val procedureSer: KSerializer<List<ExplanationOfBenefit.Procedure>> =
      ListSerializer(Hoisted.procedureSerInner)

    public val insuranceSerInner: KSerializer<ExplanationOfBenefit.Insurance> =
      ExplanationOfBenefit.Insurance.serializer()

    public val insuranceSer: KSerializer<List<ExplanationOfBenefit.Insurance>> =
      ListSerializer(Hoisted.insuranceSerInner)

    public val accidentSer: KSerializer<ExplanationOfBenefit.Accident> =
      ExplanationOfBenefit.Accident.serializer()

    public val itemSerInner: KSerializer<ExplanationOfBenefit.Item> =
      ExplanationOfBenefit.Item.serializer()

    public val itemSer: KSerializer<List<ExplanationOfBenefit.Item>> =
      ListSerializer(Hoisted.itemSerInner)

    public val addItemSerInner: KSerializer<ExplanationOfBenefit.AddItem> =
      ExplanationOfBenefit.AddItem.serializer()

    public val addItemSer: KSerializer<List<ExplanationOfBenefit.AddItem>> =
      ListSerializer(Hoisted.addItemSerInner)

    public val adjudicationSerInner: KSerializer<ExplanationOfBenefit.Item.Adjudication> =
      ExplanationOfBenefit.Item.Adjudication.serializer()

    public val adjudicationSer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
      ListSerializer(Hoisted.adjudicationSerInner)

    public val totalSerInner: KSerializer<ExplanationOfBenefit.Total> =
      ExplanationOfBenefit.Total.serializer()

    public val totalSer: KSerializer<List<ExplanationOfBenefit.Total>> =
      ListSerializer(Hoisted.totalSerInner)

    public val paymentSer: KSerializer<ExplanationOfBenefit.Payment> =
      ExplanationOfBenefit.Payment.serializer()

    public val formSer: KSerializer<Attachment> = Attachment.serializer()

    public val processNoteSerInner: KSerializer<ExplanationOfBenefit.ProcessNote> =
      ExplanationOfBenefit.ProcessNote.serializer()

    public val processNoteSer: KSerializer<List<ExplanationOfBenefit.ProcessNote>> =
      ListSerializer(Hoisted.processNoteSerInner)

    public val benefitBalanceSerInner: KSerializer<ExplanationOfBenefit.BenefitBalance> =
      ExplanationOfBenefit.BenefitBalance.serializer()

    public val benefitBalanceSer: KSerializer<List<ExplanationOfBenefit.BenefitBalance>> =
      ListSerializer(Hoisted.benefitBalanceSerInner)
  }
}
