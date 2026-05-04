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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.ExplanationOfBenefit
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
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

internal object ExplanationOfBenefitEventSerializer : KSerializer<ExplanationOfBenefit.Event> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Event") {
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
      element("whenDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_whenDateTime", Element.serializer().descriptor, isOptional = true)
      element("whenPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Event =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Event) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Event {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var whenDateTime: KotlinString? = null
    var _whenDateTime: Element? = null
    var whenPeriod: Period? = null
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
        4 -> whenDateTime = decoder.decodeStringElement(__desc, 4)
        5 ->
          _whenDateTime =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.whenDateTimeSer, null)
        6 ->
          whenPeriod =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.whenPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Event: " + __i)
      }
    }
    return ExplanationOfBenefit.Event(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `when` =
        ExplanationOfBenefit.Event.When.from(
          DateTime.of(FhirDateTime.fromString(whenDateTime), _whenDateTime),
          whenPeriod,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Event) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`when`) {
      null -> {}
      is ExplanationOfBenefit.Event.When.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.whenDateTimeSer, it)
        }
      }
      is ExplanationOfBenefit.Event.When.Period -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.whenPeriodSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val whenDateTimeSer: KSerializer<Element> = Element.serializer()

    public val whenPeriodSer: KSerializer<Period> = Period.serializer()
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
      element("specialty", CodeableConcept.serializer().descriptor, isOptional = true)
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
    var specialty: CodeableConcept? = null
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
        9 -> specialty = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.roleSer, null)
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
      responsible = R5Boolean.of(responsible, _responsible),
      role = role,
      specialty = specialty,
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
    (value.specialty)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.roleSer, it) }
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
      element("valueIdentifier", Identifier.serializer().descriptor, isOptional = true)
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
    var valueIdentifier: Identifier? = null
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
          valueIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.valueIdentifierSer, null)
        18 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.reasonSer, null)
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
          R5Boolean.of(valueBoolean, _valueBoolean),
          R5String.of(valueString, _valueString),
          valueQuantity,
          valueAttachment,
          valueReference,
          valueIdentifier,
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
      is ExplanationOfBenefit.SupportingInfo.Value.Identifier -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.valueIdentifierSer, __d.value)
      }
    }
    (value.reason)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.reasonSer, it) }
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

    public val valueIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

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
      focal = R5Boolean.of(focal, _focal)!!,
      coverage = coverage!!,
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { __i ->
          R5String.of(preAuthRef?.getOrNull(__i)?.let { it }, _preAuthRef?.getOrNull(__i))!!
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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
      element("request", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
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
      element("patientPaid", Money.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "bodySite",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.Item.BodySite.serializer().descriptor }
        ),
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
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefit.Item.ReviewOutcome.serializer().descriptor },
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
    var traceNumber: List<Identifier>? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var request: List<Reference>? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var locationCodeableConcept: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    var patientPaid: Money? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var bodySite: List<ExplanationOfBenefit.Item.BodySite>? = null
    var encounter: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.traceNumberSer, null)
        14 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.revenueSer, null)
        15 ->
          category = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.revenueSer, null)
        16 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.revenueSer, null)
        17 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.revenueSer, null)
        18 ->
          request = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.requestSer, null)
        19 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.modifierSer, null)
        20 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.modifierSer, null)
        21 -> servicedDate = decoder.decodeStringElement(__desc, 21)
        22 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.sequenceSer, null)
        23 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.servicedPeriodSer, null)
        24 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.revenueSer, null)
        25 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.locationAddressSer, null)
        26 ->
          locationReference =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.requestSerInner, null)
        27 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.patientPaidSer, null)
        28 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.quantitySer, null)
        29 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.patientPaidSer, null)
        30 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 30, BigDecimalSerializer, null)
        31 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.sequenceSer, null)
        32 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.patientPaidSer, null)
        33 ->
          net = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.patientPaidSer, null)
        34 -> udi = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.requestSer, null)
        35 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.bodySiteSer, null)
        36 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.requestSer, null)
        37 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.careTeamSequenceSer, null)
        38 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              __desc,
              38,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        39 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.reviewOutcomeSer, null)
        40 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.adjudicationSer, null)
        41 ->
          detail = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.detailSer, null)
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
      traceNumber = traceNumber ?: listOf(),
      revenue = revenue,
      category = category,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      request = request ?: listOf(),
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
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      udi = udi ?: listOf(),
      bodySite = bodySite ?: listOf(),
      encounter = encounter ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.revenueSer, it) }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.revenueSer, it)
    }
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.requestSer, value.request)
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.modifierSer, value.programCode)
    when (val __d = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.Item.Serviced.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.Item.Serviced.Period -> {
        encoder.encodeSerializableElement(__desc, 23, Hoisted.servicedPeriodSer, __d.value)
      }
    }
    when (val __d = value.location) {
      null -> {}
      is ExplanationOfBenefit.Item.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 24, Hoisted.revenueSer, __d.value)
      }
      is ExplanationOfBenefit.Item.Location.Address -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.locationAddressSer, __d.value)
      }
      is ExplanationOfBenefit.Item.Location.Reference -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.requestSerInner, __d.value)
      }
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 30, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.sequenceSer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 32, Hoisted.patientPaidSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 33, Hoisted.patientPaidSer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.requestSer, value.udi)
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.bodySiteSer, value.bodySite)
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.requestSer, value.encounter)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.careTeamSequenceSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.careTeamSequenceSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.detailSer, value.detail)
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

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val requestSerInner: KSerializer<Reference> = Reference.serializer()

    public val requestSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.requestSerInner)

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val bodySiteSerInner: KSerializer<ExplanationOfBenefit.Item.BodySite> =
      ExplanationOfBenefit.Item.BodySite.serializer()

    public val bodySiteSer: KSerializer<List<ExplanationOfBenefit.Item.BodySite>> =
      ListSerializer(Hoisted.bodySiteSerInner)

    public val reviewOutcomeSer: KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> =
      ExplanationOfBenefit.Item.ReviewOutcome.serializer()

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

internal object ExplanationOfBenefitItemBodySiteSerializer :
  KSerializer<ExplanationOfBenefit.Item.BodySite> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodySite") {
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
      element(
        "site",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "subSite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.BodySite =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.BodySite) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Item.BodySite {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: List<CodeableReference>? = null
    var subSite: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> site = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.siteSer, null)
        4 ->
          subSite = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.subSiteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BodySite: " + __i)
      }
    }
    return ExplanationOfBenefit.Item.BodySite(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      site = site ?: listOf(),
      subSite = subSite ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.BodySite,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.siteSer, value.site)
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.subSiteSer, value.subSite)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val siteSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val siteSer: KSerializer<List<CodeableReference>> = ListSerializer(Hoisted.siteSerInner)

    public val subSiteSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subSiteSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.subSiteSerInner)
  }
}

internal object ExplanationOfBenefitItemReviewOutcomeSerializer :
  KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReviewOutcome") {
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
      element("decision", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("preAuthRef", KotlinString.serializer().descriptor, isOptional = true)
      element("_preAuthRef", Element.serializer().descriptor, isOptional = true)
      element("preAuthPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.ReviewOutcome =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.ReviewOutcome) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.Item.ReviewOutcome {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var decision: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    var preAuthRef: KotlinString? = null
    var _preAuthRef: Element? = null
    var preAuthPeriod: Period? = null
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
          decision = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.decisionSer, null)
        4 -> reason = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.reasonSer, null)
        5 -> preAuthRef = decoder.decodeStringElement(__desc, 5)
        6 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.preAuthRefSer, null)
        7 ->
          preAuthPeriod =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.preAuthPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReviewOutcome: " + __i)
      }
    }
    return ExplanationOfBenefit.Item.ReviewOutcome(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      decision = decision,
      reason = reason ?: listOf(),
      preAuthRef = R5String.of(preAuthRef, _preAuthRef),
      preAuthPeriod = preAuthPeriod,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.ReviewOutcome,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.decision)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.decisionSer, it) }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.reasonSer, value.reason)
    ((value.preAuthRef?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.preAuthRef?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.preAuthRefSer, it)
    }
    (value.preAuthPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.preAuthPeriodSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val decisionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.decisionSer)

    public val preAuthRefSer: KSerializer<Element> = Element.serializer()

    public val preAuthPeriodSer: KSerializer<Period> = Period.serializer()
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
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
    var quantity: Quantity? = null
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
          quantity = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.quantitySer, null)
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
      quantity = quantity,
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
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.quantitySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()
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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
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
      element("patientPaid", Money.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefit.Item.ReviewOutcome.serializer().descriptor },
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
    var traceNumber: List<Identifier>? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var patientPaid: Money? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.traceNumberSer, null)
        6 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.revenueSer, null)
        7 ->
          category = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.revenueSer, null)
        8 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.revenueSer, null)
        9 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.revenueSer, null)
        10 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.modifierSer, null)
        11 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.modifierSer, null)
        12 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.patientPaidSer, null)
        13 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.quantitySer, null)
        14 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.patientPaidSer, null)
        15 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 15, BigDecimalSerializer, null)
        16 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.sequenceSer, null)
        17 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.patientPaidSer, null)
        18 ->
          net = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.patientPaidSer, null)
        19 -> udi = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.udiSer, null)
        20 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.noteNumberSer, null)
        21 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.noteNumberSer2, null)
        22 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.reviewOutcomeSer, null)
        23 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.adjudicationSer, null)
        24 ->
          subDetail =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + __i)
      }
    }
    return ExplanationOfBenefit.Item.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      traceNumber = traceNumber ?: listOf(),
      revenue = revenue,
      category = category,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      udi = udi ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.revenueSer, it) }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.modifierSer, value.programCode)
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 15, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.sequenceSer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.patientPaidSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.patientPaidSer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.udiSer, value.udi)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.subDetailSer, value.subDetail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val udiSerInner: KSerializer<Reference> = Reference.serializer()

    public val udiSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.udiSerInner)

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.sequenceSer).nullable)

    public val reviewOutcomeSer: KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> =
      ExplanationOfBenefit.Item.ReviewOutcome.serializer()

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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
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
      element("patientPaid", Money.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefit.Item.ReviewOutcome.serializer().descriptor },
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
    var traceNumber: List<Identifier>? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var patientPaid: Money? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.traceNumberSer, null)
        6 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.revenueSer, null)
        7 ->
          category = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.revenueSer, null)
        8 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.revenueSer, null)
        9 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.revenueSer, null)
        10 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.modifierSer, null)
        11 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.modifierSer, null)
        12 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.patientPaidSer, null)
        13 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.quantitySer, null)
        14 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.patientPaidSer, null)
        15 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 15, BigDecimalSerializer, null)
        16 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.sequenceSer, null)
        17 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.patientPaidSer, null)
        18 ->
          net = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.patientPaidSer, null)
        19 -> udi = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.udiSer, null)
        20 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.noteNumberSer, null)
        21 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.noteNumberSer2, null)
        22 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.reviewOutcomeSer, null)
        23 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + __i)
      }
    }
    return ExplanationOfBenefit.Item.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      traceNumber = traceNumber ?: listOf(),
      revenue = revenue,
      category = category,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      udi = udi ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.revenueSer, it) }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.modifierSer, value.programCode)
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 15, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.sequenceSer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.patientPaidSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.patientPaidSer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.udiSer, value.udi)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.adjudicationSer, value.adjudication)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val udiSerInner: KSerializer<Reference> = Reference.serializer()

    public val udiSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.udiSerInner)

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.sequenceSer).nullable)

    public val reviewOutcomeSer: KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> =
      ExplanationOfBenefit.Item.ReviewOutcome.serializer()

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
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element(
        "provider",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
      element("request", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
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
      element("patientPaid", Money.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element(
        "bodySite",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefit.AddItem.BodySite.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefit.Item.ReviewOutcome.serializer().descriptor },
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
    var traceNumber: List<Identifier>? = null
    var provider: List<Reference>? = null
    var revenue: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var request: List<Reference>? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var locationCodeableConcept: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    var patientPaid: Money? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var bodySite: List<ExplanationOfBenefit.AddItem.BodySite>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.traceNumberSer, null)
        10 ->
          provider =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.providerSer, null)
        11 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.revenueSer, null)
        12 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.revenueSer, null)
        13 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.revenueSer, null)
        14 ->
          request = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.providerSer, null)
        15 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.modifierSer, null)
        16 ->
          programCode =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.modifierSer, null)
        17 -> servicedDate = decoder.decodeStringElement(__desc, 17)
        18 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        19 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.servicedPeriodSer, null)
        20 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.revenueSer, null)
        21 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.locationAddressSer, null)
        22 ->
          locationReference =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.providerSerInner, null)
        23 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.patientPaidSer, null)
        24 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.quantitySer, null)
        25 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.patientPaidSer, null)
        26 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 26, BigDecimalSerializer, null)
        27 ->
          _factor =
            decoder.decodeNullableSerializableElement(
              __desc,
              27,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        28 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.patientPaidSer, null)
        29 ->
          net = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.patientPaidSer, null)
        30 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.bodySiteSer, null)
        31 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.itemSequenceSer, null)
        32 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.itemSequenceSer2, null)
        33 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.reviewOutcomeSer, null)
        34 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.adjudicationSer, null)
        35 ->
          detail = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.detailSer, null)
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
      traceNumber = traceNumber ?: listOf(),
      provider = provider ?: listOf(),
      revenue = revenue,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      request = request ?: listOf(),
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
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      bodySite = bodySite ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.traceNumberSer, value.traceNumber)
    if (value.provider.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.providerSer, value.provider)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.revenueSer, it)
    }
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.providerSer, value.request)
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.modifierSer, value.programCode)
    when (val __d = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Serviced.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.itemSequenceSerInner2, it)
        }
      }
      is ExplanationOfBenefit.AddItem.Serviced.Period -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.servicedPeriodSer, __d.value)
      }
    }
    when (val __d = value.location) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.revenueSer, __d.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Address -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.locationAddressSer, __d.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Reference -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.providerSerInner, __d.value)
      }
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 26, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.itemSequenceSerInner2, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.patientPaidSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.patientPaidSer, it) }
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.bodySiteSer, value.bodySite)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.itemSequenceSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.itemSequenceSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.detailSer, value.detail)
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

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val providerSerInner: KSerializer<Reference> = Reference.serializer()

    public val providerSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.providerSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val bodySiteSerInner: KSerializer<ExplanationOfBenefit.AddItem.BodySite> =
      ExplanationOfBenefit.AddItem.BodySite.serializer()

    public val bodySiteSer: KSerializer<List<ExplanationOfBenefit.AddItem.BodySite>> =
      ListSerializer(Hoisted.bodySiteSerInner)

    public val reviewOutcomeSer: KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> =
      ExplanationOfBenefit.Item.ReviewOutcome.serializer()

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

internal object ExplanationOfBenefitAddItemBodySiteSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.BodySite> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodySite") {
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
      element(
        "site",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "subSite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.BodySite =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.BodySite) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ExplanationOfBenefit.AddItem.BodySite {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: List<CodeableReference>? = null
    var subSite: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> site = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.siteSer, null)
        4 ->
          subSite = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.subSiteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BodySite: " + __i)
      }
    }
    return ExplanationOfBenefit.AddItem.BodySite(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      site = site ?: listOf(),
      subSite = subSite ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.AddItem.BodySite,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.siteSer, value.site)
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.subSiteSer, value.subSite)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val siteSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val siteSer: KSerializer<List<CodeableReference>> = ListSerializer(Hoisted.siteSerInner)

    public val subSiteSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subSiteSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.subSiteSerInner)
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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("patientPaid", Money.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefit.Item.ReviewOutcome.serializer().descriptor },
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
    var traceNumber: List<Identifier>? = null
    var revenue: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var patientPaid: Money? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.traceNumberSer, null)
        4 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.revenueSer, null)
        5 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.revenueSer, null)
        6 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.revenueSer, null)
        7 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.modifierSer, null)
        8 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.patientPaidSer, null)
        9 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.quantitySer, null)
        10 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.patientPaidSer, null)
        11 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 11, BigDecimalSerializer, null)
        12 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.factorSer, null)
        13 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.patientPaidSer, null)
        14 ->
          net = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.patientPaidSer, null)
        15 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.noteNumberSer, null)
        16 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.noteNumberSer2, null)
        17 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.reviewOutcomeSer, null)
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
    return ExplanationOfBenefit.AddItem.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      traceNumber = traceNumber ?: listOf(),
      revenue = revenue,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      modifier = modifier ?: listOf(),
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.modifierSer, value.modifier)
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 11, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.factorSer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.patientPaidSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.patientPaidSer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.reviewOutcomeSer, it)
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

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val factorSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.factorSer).nullable)

    public val reviewOutcomeSer: KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> =
      ExplanationOfBenefit.Item.ReviewOutcome.serializer()

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
      element(
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrServiceEnd", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("patientPaid", Money.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("tax", Money.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("noteNumber", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element(
        "_noteNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefit.Item.ReviewOutcome.serializer().descriptor },
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
    var traceNumber: List<Identifier>? = null
    var revenue: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var productOrServiceEnd: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var patientPaid: Money? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.traceNumberSer, null)
        4 ->
          revenue = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.revenueSer, null)
        5 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.revenueSer, null)
        6 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.revenueSer, null)
        7 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.modifierSer, null)
        8 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.patientPaidSer, null)
        9 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.quantitySer, null)
        10 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.patientPaidSer, null)
        11 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 11, BigDecimalSerializer, null)
        12 ->
          _factor = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.factorSer, null)
        13 ->
          tax = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.patientPaidSer, null)
        14 ->
          net = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.patientPaidSer, null)
        15 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.noteNumberSer, null)
        16 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.noteNumberSer2, null)
        17 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.reviewOutcomeSer, null)
        18 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + __i)
      }
    }
    return ExplanationOfBenefit.AddItem.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      traceNumber = traceNumber ?: listOf(),
      revenue = revenue,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      modifier = modifier ?: listOf(),
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { __i ->
          PositiveInt.of(noteNumber?.getOrNull(__i)?.let { it }, _noteNumber?.getOrNull(__i))!!
        }),
      reviewOutcome = reviewOutcome,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.revenueSer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.modifierSer, value.modifier)
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 11, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.factorSer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.patientPaidSer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.patientPaidSer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.adjudicationSer, value.adjudication)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val factorSer: KSerializer<Element> = Element.serializer()

    public val noteNumberSerInner: KSerializer<Int> = Int.serializer()

    public val noteNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.noteNumberSerInner).nullable)

    public val noteNumberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.factorSer).nullable)

    public val reviewOutcomeSer: KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> =
      ExplanationOfBenefit.Item.ReviewOutcome.serializer()

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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
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
    var type: CodeableConcept? = null
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
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> text = decoder.decodeStringElement(__desc, 6)
        7 -> _text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.numberSer, null)
        8 -> language = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + __i)
      }
    }
    return ExplanationOfBenefit.ProcessNote(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      number = PositiveInt.of(number, _number),
      type = type,
      text = R5String.of(text, _text),
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
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.numberSer, it)
    }
    (value.language)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val numberSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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
      excluded = R5Boolean.of(excluded, _excluded),
      name = R5String.of(name, _name),
      description = R5String.of(description, _description),
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
          R5String.of(allowedString, _allowedString),
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
      element(
        "traceNumber",
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
        "event",
        listSerialDescriptor(lazyDescriptor { ExplanationOfBenefit.Event.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "payee",
        lazyDescriptor { ExplanationOfBenefit.Payee.serializer().descriptor },
        isOptional = true,
      )
      element("referral", Reference.serializer().descriptor, isOptional = true)
      element(
        "encounter",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("facility", Reference.serializer().descriptor, isOptional = true)
      element("claim", Reference.serializer().descriptor, isOptional = true)
      element("claimResponse", Reference.serializer().descriptor, isOptional = true)
      element("outcome", KotlinString.serializer().descriptor, isOptional = true)
      element("_outcome", Element.serializer().descriptor, isOptional = true)
      element("decision", CodeableConcept.serializer().descriptor, isOptional = true)
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
      element("diagnosisRelatedGroup", CodeableConcept.serializer().descriptor, isOptional = true)
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
      element("patientPaid", Money.serializer().descriptor, isOptional = true)
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
    var traceNumber: List<Identifier>? = null
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
    var event: List<ExplanationOfBenefit.Event>? = null
    var payee: ExplanationOfBenefit.Payee? = null
    var referral: Reference? = null
    var encounter: List<Reference>? = null
    var facility: Reference? = null
    var claim: Reference? = null
    var claimResponse: Reference? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var decision: CodeableConcept? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var preAuthRef: List<KotlinString?>? = null
    var _preAuthRef: List<Element?>? = null
    var preAuthRefPeriod: List<Period>? = null
    var diagnosisRelatedGroup: CodeableConcept? = null
    var careTeam: List<ExplanationOfBenefit.CareTeam>? = null
    var supportingInfo: List<ExplanationOfBenefit.SupportingInfo>? = null
    var diagnosis: List<ExplanationOfBenefit.Diagnosis>? = null
    var procedure: List<ExplanationOfBenefit.Procedure>? = null
    var precedence: Int? = null
    var _precedence: Element? = null
    var insurance: List<ExplanationOfBenefit.Insurance>? = null
    var accident: ExplanationOfBenefit.Accident? = null
    var patientPaid: Money? = null
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
        12 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.identifierSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> type = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.typeSer, null)
        16 -> subType = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.typeSer, null)
        17 -> use = decoder.decodeStringElement(__desc, 17)
        18 ->
          _use =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.patientSer, null)
        20 ->
          billablePeriod =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.billablePeriodSer, null)
        21 -> created = decoder.decodeStringElement(__desc, 21)
        22 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          enterer = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.patientSer, null)
        24 ->
          insurer = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.patientSer, null)
        25 ->
          provider = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.patientSer, null)
        26 ->
          priority = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.typeSer, null)
        27 ->
          fundsReserveRequested =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.typeSer, null)
        28 ->
          fundsReserve =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.typeSer, null)
        29 ->
          related = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.relatedSer, null)
        30 ->
          prescription =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.patientSer, null)
        31 ->
          originalPrescription =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.patientSer, null)
        32 -> event = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.eventSer, null)
        33 -> payee = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.payeeSer, null)
        34 ->
          referral = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.patientSer, null)
        35 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.encounterSer, null)
        36 ->
          facility = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.patientSer, null)
        37 ->
          claim = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.patientSer, null)
        38 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.patientSer, null)
        39 -> outcome = decoder.decodeStringElement(__desc, 39)
        40 ->
          _outcome =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.implicitRulesSer, null)
        41 ->
          decision = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.typeSer, null)
        42 -> disposition = decoder.decodeStringElement(__desc, 42)
        43 ->
          _disposition =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.preAuthRefSer, null)
        45 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.preAuthRefSer2, null)
        46 ->
          preAuthRefPeriod =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.preAuthRefPeriodSer, null)
        47 ->
          diagnosisRelatedGroup =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.typeSer, null)
        48 ->
          careTeam =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.careTeamSer, null)
        49 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.supportingInfoSer, null)
        50 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.diagnosisSer, null)
        51 ->
          procedure =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.procedureSer, null)
        52 -> precedence = decoder.decodeIntElement(__desc, 52)
        53 ->
          _precedence =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.implicitRulesSer, null)
        54 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.insuranceSer, null)
        55 ->
          accident =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.accidentSer, null)
        56 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.patientPaidSer, null)
        57 -> item = decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.itemSer, null)
        58 ->
          addItem = decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.addItemSer, null)
        59 ->
          adjudication =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.adjudicationSer, null)
        60 -> total = decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.totalSer, null)
        61 ->
          payment = decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.paymentSer, null)
        62 ->
          formCode = decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.typeSer, null)
        63 -> form = decoder.decodeNullableSerializableElement(__desc, 63, Hoisted.formSer, null)
        64 ->
          processNote =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.processNoteSer, null)
        65 ->
          benefitPeriod =
            decoder.decodeNullableSerializableElement(__desc, 65, Hoisted.billablePeriodSer, null)
        66 ->
          benefitBalance =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.benefitBalanceSer, null)
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
      traceNumber = traceNumber ?: listOf(),
      status =
        Enumeration.of(ExplanationOfBenefit.ExplanationOfBenefitStatus.fromCode(status!!), _status),
      type = type!!,
      subType = subType,
      use = Enumeration.of(ExplanationOfBenefit.Use.fromCode(use!!), _use),
      patient = patient!!,
      billablePeriod = billablePeriod,
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      enterer = enterer,
      insurer = insurer,
      provider = provider,
      priority = priority,
      fundsReserveRequested = fundsReserveRequested,
      fundsReserve = fundsReserve,
      related = related ?: listOf(),
      prescription = prescription,
      originalPrescription = originalPrescription,
      event = event ?: listOf(),
      payee = payee,
      referral = referral,
      encounter = encounter ?: listOf(),
      facility = facility,
      claim = claim,
      claimResponse = claimResponse,
      outcome =
        Enumeration.of(ExplanationOfBenefit.ClaimProcessingCodes.fromCode(outcome!!), _outcome),
      decision = decision,
      disposition = R5String.of(disposition, _disposition),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { __i ->
          R5String.of(preAuthRef?.getOrNull(__i)?.let { it }, _preAuthRef?.getOrNull(__i))!!
        }),
      preAuthRefPeriod = preAuthRefPeriod ?: listOf(),
      diagnosisRelatedGroup = diagnosisRelatedGroup,
      careTeam = careTeam ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      precedence = PositiveInt.of(precedence, _precedence),
      insurance = insurance ?: listOf(),
      accident = accident,
      patientPaid = patientPaid,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.identifierSer, value.traceNumber)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.typeSer, it) }
    (value.subType)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.typeSer, it) }
    ((value.use.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.patientSer, it) }
    (value.billablePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.billablePeriodSer, it)
    }
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.enterer)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.patientSer, it) }
    (value.insurer)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.patientSer, it) }
    (value.provider)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.patientSer, it) }
    (value.priority)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.typeSer, it) }
    (value.fundsReserveRequested)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.typeSer, it)
    }
    (value.fundsReserve)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.typeSer, it) }
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.relatedSer, value.related)
    (value.prescription)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.patientSer, it)
    }
    (value.originalPrescription)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.patientSer, it)
    }
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.eventSer, value.event)
    (value.payee)?.let { encoder.encodeSerializableElement(__desc, 33, Hoisted.payeeSer, it) }
    (value.referral)?.let { encoder.encodeSerializableElement(__desc, 34, Hoisted.patientSer, it) }
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.encounterSer, value.encounter)
    (value.facility)?.let { encoder.encodeSerializableElement(__desc, 36, Hoisted.patientSer, it) }
    (value.claim)?.let { encoder.encodeSerializableElement(__desc, 37, Hoisted.patientSer, it) }
    (value.claimResponse)?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.patientSer, it)
    }
    ((value.outcome.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 39, it) }
    (value.outcome.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.implicitRulesSer, it)
    }
    (value.decision)?.let { encoder.encodeSerializableElement(__desc, 41, Hoisted.typeSer, it) }
    ((value.disposition?.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.preAuthRefSer, it)
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.preAuthRefSer2, it)
    }
    if (value.preAuthRefPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        46,
        Hoisted.preAuthRefPeriodSer,
        value.preAuthRefPeriod,
      )
    (value.diagnosisRelatedGroup)?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.typeSer, it)
    }
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.careTeamSer, value.careTeam)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.supportingInfoSer, value.supportingInfo)
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.diagnosisSer, value.diagnosis)
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.procedureSer, value.procedure)
    ((value.precedence?.value))?.let { encoder.encodeIntElement(__desc, 52, it) }
    (value.precedence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 53, Hoisted.implicitRulesSer, it)
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54, Hoisted.insuranceSer, value.insurance)
    (value.accident)?.let { encoder.encodeSerializableElement(__desc, 55, Hoisted.accidentSer, it) }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(__desc, 56, Hoisted.patientPaidSer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 57, Hoisted.itemSer, value.item)
    if (value.addItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 58, Hoisted.addItemSer, value.addItem)
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 59, Hoisted.adjudicationSer, value.adjudication)
    if (value.total.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 60, Hoisted.totalSer, value.total)
    (value.payment)?.let { encoder.encodeSerializableElement(__desc, 61, Hoisted.paymentSer, it) }
    (value.formCode)?.let { encoder.encodeSerializableElement(__desc, 62, Hoisted.typeSer, it) }
    (value.form)?.let { encoder.encodeSerializableElement(__desc, 63, Hoisted.formSer, it) }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 64, Hoisted.processNoteSer, value.processNote)
    (value.benefitPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 65, Hoisted.billablePeriodSer, it)
    }
    if (value.benefitBalance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 66, Hoisted.benefitBalanceSer, value.benefitBalance)
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

    public val eventSerInner: KSerializer<ExplanationOfBenefit.Event> =
      ExplanationOfBenefit.Event.serializer()

    public val eventSer: KSerializer<List<ExplanationOfBenefit.Event>> =
      ListSerializer(Hoisted.eventSerInner)

    public val payeeSer: KSerializer<ExplanationOfBenefit.Payee> =
      ExplanationOfBenefit.Payee.serializer()

    public val encounterSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)

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

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

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
