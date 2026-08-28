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
import dev.ohs.fhir.model.r5.FhirDecimal
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
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Related) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Related {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var claim: Reference? = null
    var relationship: CodeableConcept? = null
    var reference: Identifier? = null
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
          claim = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.claimSer, null)
        4 ->
          relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relationshipSer, null)
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Related: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Related) {
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
    (value.claim)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.claimSer, it) }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.relationshipSer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.referenceSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Event) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Event {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var whenDateTime: KotlinString? = null
    var _whenDateTime: Element? = null
    var whenPeriod: Period? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> whenDateTime = decoder.decodeStringElement(descriptor, i)
        5 ->
          _whenDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whenDateTimeSer, null)
        6 ->
          whenPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whenPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Event: " + i)
      }
    }
    return ExplanationOfBenefit.Event(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on ExplanationOfBenefit.Event"
          ),
      `when` =
        ExplanationOfBenefit.Event.When.from(
          DateTime.of(FhirDateTime.fromString(whenDateTime), _whenDateTime),
          whenPeriod,
        )
          ?: throw SerializationException(
            "Missing required property 'when' on ExplanationOfBenefit.Event"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Event) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.`when`) {
      is ExplanationOfBenefit.Event.When.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.whenDateTimeSer, it)
        }
      }
      is ExplanationOfBenefit.Event.When.Period -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.whenPeriodSer, choice.value)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payee) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Payee {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var party: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          party = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payee: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Payee) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    (value.party)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.partySer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.CareTeam) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.CareTeam {
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
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSer, null)
        6 -> responsible = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        8 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        9 ->
          specialty =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CareTeam: " + i)
      }
    }
    return ExplanationOfBenefit.CareTeam(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.CareTeam"
          ),
      provider =
        provider
          ?: throw SerializationException(
            "Missing required property 'provider' on ExplanationOfBenefit.CareTeam"
          ),
      responsible = R5Boolean.of(responsible, _responsible),
      role = role,
      specialty = specialty,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.CareTeam) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.providerSer, value.provider)
    ((value.responsible?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.responsible?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.sequenceSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 8, Hoisted.roleSer, it) }
    (value.specialty)?.let { encoder.encodeSerializableElement(descriptor, 9, Hoisted.roleSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.SupportingInfo) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.SupportingInfo {
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
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        6 ->
          code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        7 -> timingDate = decoder.decodeStringElement(descriptor, i)
        8 ->
          _timingDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        9 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingPeriodSer, null)
        10 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        11 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        12 -> valueString = decoder.decodeStringElement(descriptor, i)
        13 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        14 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        15 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        16 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        17 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueIdentifierSer,
              null,
            )
        18 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
      }
    }
    return ExplanationOfBenefit.SupportingInfo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.SupportingInfo"
          ),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ExplanationOfBenefit.SupportingInfo"
          ),
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.SupportingInfo,
  ) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.categorySer, value.category)
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.categorySer, it) }
    when (val choice = value.timing) {
      null -> {}
      is ExplanationOfBenefit.SupportingInfo.Timing.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Timing.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.timingPeriodSer, choice.value)
      }
    }
    when (val choice = value.`value`) {
      null -> {}
      is ExplanationOfBenefit.SupportingInfo.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueQuantitySer, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 15, Hoisted.valueAttachmentSer, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 16, Hoisted.valueReferenceSer, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 17, Hoisted.valueIdentifierSer, choice.value)
      }
    }
    (value.reason)?.let { encoder.encodeSerializableElement(descriptor, 18, Hoisted.reasonSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Diagnosis) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Diagnosis {
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
          diagnosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diagnosisCodeableConceptSer,
              null,
            )
        6 ->
          diagnosisReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diagnosisReferenceSer,
              null,
            )
        7 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 ->
          onAdmission =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diagnosisCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
      }
    }
    return ExplanationOfBenefit.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Diagnosis"
          ),
      diagnosis =
        ExplanationOfBenefit.Diagnosis.Diagnosis.from(diagnosisCodeableConcept, diagnosisReference)
          ?: throw SerializationException(
            "Missing required property 'diagnosis' on ExplanationOfBenefit.Diagnosis"
          ),
      type = type ?: listOf(),
      onAdmission = onAdmission,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Diagnosis,
  ) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    when (val choice = value.diagnosis) {
      is ExplanationOfBenefit.Diagnosis.Diagnosis.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          5,
          Hoisted.diagnosisCodeableConceptSer,
          choice.value,
        )
      }
      is ExplanationOfBenefit.Diagnosis.Diagnosis.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          6,
          Hoisted.diagnosisReferenceSer,
          choice.value,
        )
      }
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, value.type)
    (value.onAdmission)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.diagnosisCodeableConceptSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Procedure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Procedure {
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
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> date = decoder.decodeStringElement(descriptor, i)
        7 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        8 ->
          procedureCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSerInner, null)
        9 ->
          procedureReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.procedureReferenceSer,
              null,
            )
        10 -> udi = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.udiSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
      }
    }
    return ExplanationOfBenefit.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Procedure"
          ),
      type = type ?: listOf(),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      procedure =
        ExplanationOfBenefit.Procedure.Procedure.from(procedureCodeableConcept, procedureReference)
          ?: throw SerializationException(
            "Missing required property 'procedure' on ExplanationOfBenefit.Procedure"
          ),
      udi = udi ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Procedure,
  ) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, value.type)
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.sequenceSer, it)
    }
    when (val choice = value.procedure) {
      is ExplanationOfBenefit.Procedure.Procedure.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSerInner, choice.value)
      }
      is ExplanationOfBenefit.Procedure.Procedure.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          9,
          Hoisted.procedureReferenceSer,
          choice.value,
        )
      }
    }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.udiSer, value.udi)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Insurance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Insurance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var focal: KotlinBoolean? = null
    var _focal: Element? = null
    var coverage: Reference? = null
    var preAuthRef: List<KotlinString?>? = null
    var _preAuthRef: List<Element?>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> focal = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _focal = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.focalSer, null)
        5 ->
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        6 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthRefSer, null)
        7 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthRefSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
      }
    }
    return ExplanationOfBenefit.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      focal =
        R5Boolean.of(focal, _focal)
          ?: throw SerializationException(
            "Missing required property 'focal' on ExplanationOfBenefit.Insurance"
          ),
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on ExplanationOfBenefit.Insurance"
          ),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { index ->
          R5String.of(preAuthRef?.getOrNull(index)?.let { it }, _preAuthRef?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Insurance,
  ) {
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
    ((value.focal.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.focal.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.focalSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.coverageSer, value.coverage)
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.preAuthRefSer, it)
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.preAuthRefSer2, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Accident) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Accident {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var type: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> date = decoder.decodeStringElement(descriptor, i)
        4 -> _date = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.locationAddressSer,
              null,
            )
        7 ->
          locationReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.locationReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Accident: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Accident) {
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
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.dateSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.Accident.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.locationAddressSer, choice.value)
      }
      is ExplanationOfBenefit.Accident.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.locationReferenceSer, choice.value)
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
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Item {
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
    var factor: FhirDecimal? = null
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
          careTeamSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        6 ->
          _careTeamSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        7 ->
          diagnosisSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        8 ->
          _diagnosisSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        9 ->
          procedureSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        10 ->
          _procedureSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        11 ->
          informationSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        12 ->
          _informationSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        13 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.traceNumberSer, null)
        14 ->
          revenue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        16 ->
          productOrService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        17 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        18 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        19 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        20 ->
          programCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        21 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        22 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        23 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.servicedPeriodSer,
              null,
            )
        24 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        25 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.locationAddressSer,
              null,
            )
        26 ->
          locationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSerInner, null)
        27 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        28 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        29 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        30 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        31 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        32 ->
          tax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        33 ->
          net =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        34 ->
          udi = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        35 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bodySiteSer, null)
        36 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        37 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        38 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        39 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reviewOutcomeSer, null)
        40 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        41 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return ExplanationOfBenefit.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Item"
          ),
      careTeamSequence =
        (kotlin.collections.List(
          maxOf(careTeamSequence?.size ?: 0, _careTeamSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            careTeamSequence?.getOrNull(index)?.let { it },
            _careTeamSequence?.getOrNull(index),
          )!!
        }),
      diagnosisSequence =
        (kotlin.collections.List(
          maxOf(diagnosisSequence?.size ?: 0, _diagnosisSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            diagnosisSequence?.getOrNull(index)?.let { it },
            _diagnosisSequence?.getOrNull(index),
          )!!
        }),
      procedureSequence =
        (kotlin.collections.List(
          maxOf(procedureSequence?.size ?: 0, _procedureSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            procedureSequence?.getOrNull(index)?.let { it },
            _procedureSequence?.getOrNull(index),
          )!!
        }),
      informationSequence =
        (kotlin.collections.List(
          maxOf(informationSequence?.size ?: 0, _informationSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            informationSequence?.getOrNull(index)?.let { it },
            _informationSequence?.getOrNull(index),
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
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Item) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    (value.careTeamSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.careTeamSequenceSer, it)
    }
    (value.careTeamSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.careTeamSequenceSer2, it)
    }
    (value.diagnosisSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.careTeamSequenceSer, it)
    }
    (value.diagnosisSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.careTeamSequenceSer2, it)
    }
    (value.procedureSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.careTeamSequenceSer, it)
    }
    (value.procedureSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.careTeamSequenceSer2, it)
    }
    (value.informationSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.careTeamSequenceSer, it)
    }
    (value.informationSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.careTeamSequenceSer2, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.revenueSer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.revenueSer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.revenueSer, it)
    }
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.requestSer, value.request)
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.modifierSer, value.programCode)
    when (val choice = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.Item.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 21, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 22, Hoisted.sequenceSer, it)
        }
      }
      is ExplanationOfBenefit.Item.Serviced.Period -> {
        encoder.encodeSerializableElement(descriptor, 23, Hoisted.servicedPeriodSer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.Item.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 24, Hoisted.revenueSer, choice.value)
      }
      is ExplanationOfBenefit.Item.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 25, Hoisted.locationAddressSer, choice.value)
      }
      is ExplanationOfBenefit.Item.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 26, Hoisted.requestSerInner, choice.value)
      }
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 30, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 31, Hoisted.sequenceSer, it)
    }
    (value.tax)?.let {
      encoder.encodeSerializableElement(descriptor, 32, Hoisted.patientPaidSer, it)
    }
    (value.net)?.let {
      encoder.encodeSerializableElement(descriptor, 33, Hoisted.patientPaidSer, it)
    }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 34, Hoisted.requestSer, value.udi)
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 35, Hoisted.bodySiteSer, value.bodySite)
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 36, Hoisted.requestSer, value.encounter)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 37, Hoisted.careTeamSequenceSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 38, Hoisted.careTeamSequenceSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(descriptor, 39, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 40, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 41, Hoisted.detailSer, value.detail)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.BodySite) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Item.BodySite {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: List<CodeableReference>? = null
    var subSite: List<CodeableConcept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> site = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.siteSer, null)
        4 ->
          subSite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subSiteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BodySite: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.BodySite,
  ) {
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
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.siteSer, value.site)
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.subSiteSer, value.subSite)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.ReviewOutcome) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.Item.ReviewOutcome {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var decision: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    var preAuthRef: KotlinString? = null
    var _preAuthRef: Element? = null
    var preAuthPeriod: Period? = null
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
          decision =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.decisionSer, null)
        4 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        5 -> preAuthRef = decoder.decodeStringElement(descriptor, i)
        6 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthRefSer, null)
        7 ->
          preAuthPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReviewOutcome: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.ReviewOutcome,
  ) {
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
    (value.decision)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.decisionSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.reasonSer, value.reason)
    ((value.preAuthRef?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.preAuthRef?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.preAuthRefSer, it)
    }
    (value.preAuthPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.preAuthPeriodSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Adjudication) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.Item.Adjudication {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var reason: CodeableConcept? = null
    var amount: Money? = null
    var quantity: Quantity? = null
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
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        5 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        6 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Adjudication: " + i)
      }
    }
    return ExplanationOfBenefit.Item.Adjudication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ExplanationOfBenefit.Item.Adjudication"
          ),
      reason = reason,
      amount = amount,
      quantity = quantity,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.Adjudication,
  ) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, value.category)
    (value.reason)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.categorySer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.amountSer, it) }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.quantitySer, it)
    }
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
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Item.Detail {
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
    var factor: FhirDecimal? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.traceNumberSer, null)
        6 ->
          revenue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        7 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        8 ->
          productOrService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        9 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        10 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        11 ->
          programCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        12 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        13 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        14 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        15 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        16 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        17 ->
          tax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        18 ->
          net =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        19 -> udi = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.udiSer, null)
        20 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        21 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        22 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reviewOutcomeSer, null)
        23 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        24 ->
          subDetail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    return ExplanationOfBenefit.Item.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Item.Detail"
          ),
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
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.Detail,
  ) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.revenueSer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.revenueSer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.modifierSer, value.programCode)
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 15, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.sequenceSer, it)
    }
    (value.tax)?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.patientPaidSer, it)
    }
    (value.net)?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.patientPaidSer, it)
    }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.udiSer, value.udi)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.subDetailSer, value.subDetail)
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
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.Item.Detail.SubDetail {
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
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.traceNumberSer, null)
        6 ->
          revenue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        7 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        8 ->
          productOrService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        9 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        10 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        11 ->
          programCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        12 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        13 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        14 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        15 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        16 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        17 ->
          tax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        18 ->
          net =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        19 -> udi = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.udiSer, null)
        20 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        21 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        22 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reviewOutcomeSer, null)
        23 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
      }
    }
    return ExplanationOfBenefit.Item.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Item.Detail.SubDetail"
          ),
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
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Item.Detail.SubDetail,
  ) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.revenueSer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.revenueSer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.modifierSer, value.programCode)
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 15, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.sequenceSer, it)
    }
    (value.tax)?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.patientPaidSer, it)
    }
    (value.net)?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.patientPaidSer, it)
    }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.udiSer, value.udi)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.adjudicationSer, value.adjudication)
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
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.AddItem {
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
    var factor: FhirDecimal? = null
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          itemSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer2, null)
        5 ->
          detailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        6 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer2, null)
        7 ->
          subDetailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        8 ->
          _subDetailSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer2, null)
        9 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.traceNumberSer, null)
        10 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSer, null)
        11 ->
          revenue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        12 ->
          productOrService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        13 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        14 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSer, null)
        15 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        16 ->
          programCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        17 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        19 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.servicedPeriodSer,
              null,
            )
        20 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        21 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.locationAddressSer,
              null,
            )
        22 ->
          locationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSerInner, null)
        23 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        24 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        25 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        26 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        27 ->
          _factor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemSequenceSerInner2,
              null,
            )
        28 ->
          tax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        29 ->
          net =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        30 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.bodySiteSer, null)
        31 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer, null)
        32 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSequenceSer2, null)
        33 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reviewOutcomeSer, null)
        34 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        35 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AddItem: " + i)
      }
    }
    return ExplanationOfBenefit.AddItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence =
        (kotlin.collections.List(maxOf(itemSequence?.size ?: 0, _itemSequence?.size ?: 0)) { index
          ->
          PositiveInt.of(
            itemSequence?.getOrNull(index)?.let { it },
            _itemSequence?.getOrNull(index),
          )!!
        }),
      detailSequence =
        (kotlin.collections.List(maxOf(detailSequence?.size ?: 0, _detailSequence?.size ?: 0)) {
          index ->
          PositiveInt.of(
            detailSequence?.getOrNull(index)?.let { it },
            _detailSequence?.getOrNull(index),
          )!!
        }),
      subDetailSequence =
        (kotlin.collections.List(
          maxOf(subDetailSequence?.size ?: 0, _subDetailSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            subDetailSequence?.getOrNull(index)?.let { it },
            _subDetailSequence?.getOrNull(index),
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
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.AddItem) {
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
    (value.itemSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemSequenceSer, it)
    }
    (value.itemSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemSequenceSer2, it)
    }
    (value.detailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.itemSequenceSer, it)
    }
    (value.detailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.itemSequenceSer2, it)
    }
    (value.subDetailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.itemSequenceSer, it)
    }
    (value.subDetailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.itemSequenceSer2, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.traceNumberSer, value.traceNumber)
    if (value.provider.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.providerSer, value.provider)
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.revenueSer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.revenueSer, it)
    }
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.providerSer, value.request)
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.modifierSer, value.modifier)
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.modifierSer, value.programCode)
    when (val choice = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.itemSequenceSerInner2, it)
        }
      }
      is ExplanationOfBenefit.AddItem.Serviced.Period -> {
        encoder.encodeSerializableElement(descriptor, 19, Hoisted.servicedPeriodSer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 20, Hoisted.revenueSer, choice.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 21, Hoisted.locationAddressSer, choice.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 22, Hoisted.providerSerInner, choice.value)
      }
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 26, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.itemSequenceSerInner2, it)
    }
    (value.tax)?.let {
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.patientPaidSer, it)
    }
    (value.net)?.let {
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.patientPaidSer, it)
    }
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 30, Hoisted.bodySiteSer, value.bodySite)
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 31, Hoisted.itemSequenceSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 32, Hoisted.itemSequenceSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(descriptor, 33, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 34, Hoisted.adjudicationSer, value.adjudication)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 35, Hoisted.detailSer, value.detail)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.BodySite) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.AddItem.BodySite {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: List<CodeableReference>? = null
    var subSite: List<CodeableConcept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> site = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.siteSer, null)
        4 ->
          subSite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subSiteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BodySite: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.AddItem.BodySite,
  ) {
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
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.siteSer, value.site)
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.subSiteSer, value.subSite)
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
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.AddItem.Detail {
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
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var subDetail: List<ExplanationOfBenefit.AddItem.Detail.SubDetail>? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.traceNumberSer, null)
        4 ->
          revenue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        5 ->
          productOrService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        6 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        7 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        8 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        9 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        10 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        11 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        12 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.factorSer, null)
        13 ->
          tax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        14 ->
          net =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        15 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        16 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        17 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reviewOutcomeSer, null)
        18 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        19 ->
          subDetail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
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
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.AddItem.Detail,
  ) {
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.revenueSer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.modifierSer, value.modifier)
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 11, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.factorSer, it)
    }
    (value.tax)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.patientPaidSer, it)
    }
    (value.net)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.patientPaidSer, it)
    }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.adjudicationSer, value.adjudication)
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.subDetailSer, value.subDetail)
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
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.AddItem.Detail.SubDetail {
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
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var tax: Money? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.traceNumberSer, null)
        4 ->
          revenue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        5 ->
          productOrService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        6 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.revenueSer, null)
        7 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        8 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        9 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        10 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        11 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        12 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.factorSer, null)
        13 ->
          tax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        14 ->
          net =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        15 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer, null)
        16 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteNumberSer2, null)
        17 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reviewOutcomeSer, null)
        18 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
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
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))!!
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.AddItem.Detail.SubDetail,
  ) {
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.traceNumberSer, value.traceNumber)
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.revenueSer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.revenueSer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.revenueSer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.modifierSer, value.modifier)
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.patientPaidSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.patientPaidSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 11, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.factorSer, it)
    }
    (value.tax)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.patientPaidSer, it)
    }
    (value.net)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.patientPaidSer, it)
    }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.noteNumberSer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.noteNumberSer2, it)
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.reviewOutcomeSer, it)
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.adjudicationSer, value.adjudication)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Total) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Total {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
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
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Total: " + i)
      }
    }
    return ExplanationOfBenefit.Total(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ExplanationOfBenefit.Total"
          ),
      amount =
        amount
          ?: throw SerializationException(
            "Missing required property 'amount' on ExplanationOfBenefit.Total"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Total) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, value.category)
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.amountSer, value.amount)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payment) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.Payment {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          adjustment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjustmentSer, null)
        5 ->
          adjustmentReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> date = decoder.decodeStringElement(descriptor, i)
        7 -> _date = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateSer, null)
        8 ->
          amount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjustmentSer, null)
        9 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payment: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Payment) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    (value.adjustment)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.adjustmentSer, it)
    }
    (value.adjustmentReason)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.dateSer, it)
    }
    (value.amount)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.adjustmentSer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.identifierSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.ProcessNote) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.ProcessNote {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> number = decoder.decodeIntElement(descriptor, i)
        4 ->
          _number =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> text = decoder.decodeStringElement(descriptor, i)
        7 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        8 ->
          language = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.ProcessNote,
  ) {
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
    ((value.number?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.numberSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.numberSer, it)
    }
    (value.language)?.let { encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExplanationOfBenefit.BenefitBalance {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 -> excluded = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _excluded =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.excludedSer, null)
        6 -> name = decoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.excludedSer, null)
        8 -> description = decoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.excludedSer, null)
        10 ->
          network =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        11 ->
          unit = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        12 ->
          term = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        13 ->
          financial =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.financialSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BenefitBalance: " + i)
      }
    }
    return ExplanationOfBenefit.BenefitBalance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ExplanationOfBenefit.BenefitBalance"
          ),
      excluded = R5Boolean.of(excluded, _excluded),
      name = R5String.of(name, _name),
      description = R5String.of(description, _description),
      network = network,
      unit = unit,
      term = term,
      financial = financial ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.BenefitBalance,
  ) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, value.category)
    ((value.excluded?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.excluded?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.excludedSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.excludedSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.excludedSer, it)
    }
    (value.network)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.categorySer, it)
    }
    (value.unit)?.let { encoder.encodeSerializableElement(descriptor, 11, Hoisted.categorySer, it) }
    (value.term)?.let { encoder.encodeSerializableElement(descriptor, 12, Hoisted.categorySer, it) }
    if (value.financial.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.financialSer, value.financial)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance.Financial) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ExplanationOfBenefit.BenefitBalance.Financial {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> allowedUnsignedInt = decoder.decodeIntElement(descriptor, i)
        5 ->
          _allowedUnsignedInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        6 -> allowedString = decoder.decodeStringElement(descriptor, i)
        7 ->
          _allowedString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        8 ->
          allowedMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.allowedMoneySer, null)
        9 -> usedUnsignedInt = decoder.decodeIntElement(descriptor, i)
        10 ->
          _usedUnsignedInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        11 ->
          usedMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.allowedMoneySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Financial: " + i)
      }
    }
    return ExplanationOfBenefit.BenefitBalance.Financial(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on ExplanationOfBenefit.BenefitBalance.Financial"
          ),
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.BenefitBalance.Financial,
  ) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.allowed) {
      null -> {}
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.Money -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.allowedMoneySer, choice.value)
      }
    }
    when (val choice = value.used) {
      null -> {}
      is ExplanationOfBenefit.BenefitBalance.Financial.Used.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Used.Money -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.allowedMoneySer, choice.value)
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
    b.element(
      "traceNumber",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("use", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_use", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("billablePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("enterer", Reference.serializer().descriptor, isOptional = true)
    b.element("insurer", Reference.serializer().descriptor, isOptional = true)
    b.element("provider", Reference.serializer().descriptor, isOptional = true)
    b.element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("fundsReserveRequested", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("fundsReserve", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "related",
      listSerialDescriptor(lazyDescriptor { ExplanationOfBenefit.Related.serializer().descriptor }),
      isOptional = true,
    )
    b.element("prescription", Reference.serializer().descriptor, isOptional = true)
    b.element("originalPrescription", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "event",
      listSerialDescriptor(lazyDescriptor { ExplanationOfBenefit.Event.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "payee",
      lazyDescriptor { ExplanationOfBenefit.Payee.serializer().descriptor },
      isOptional = true,
    )
    b.element("referral", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "encounter",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("facility", Reference.serializer().descriptor, isOptional = true)
    b.element("claim", Reference.serializer().descriptor, isOptional = true)
    b.element("claimResponse", Reference.serializer().descriptor, isOptional = true)
    b.element("outcome", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outcome", Element.serializer().descriptor, isOptional = true)
    b.element("decision", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("disposition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_disposition", Element.serializer().descriptor, isOptional = true)
    b.element(
      "preAuthRef",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_preAuthRef",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "preAuthRefPeriod",
      listSerialDescriptor(Period.serializer().descriptor),
      isOptional = true,
    )
    b.element("diagnosisRelatedGroup", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "careTeam",
      listSerialDescriptor(
        lazyDescriptor { ExplanationOfBenefit.CareTeam.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(
        lazyDescriptor { ExplanationOfBenefit.SupportingInfo.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "diagnosis",
      listSerialDescriptor(
        lazyDescriptor { ExplanationOfBenefit.Diagnosis.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "procedure",
      listSerialDescriptor(
        lazyDescriptor { ExplanationOfBenefit.Procedure.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("precedence", Int.serializer().descriptor, isOptional = true)
    b.element("_precedence", Element.serializer().descriptor, isOptional = true)
    b.element(
      "insurance",
      listSerialDescriptor(
        lazyDescriptor { ExplanationOfBenefit.Insurance.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "accident",
      lazyDescriptor { ExplanationOfBenefit.Accident.serializer().descriptor },
      isOptional = true,
    )
    b.element("patientPaid", Money.serializer().descriptor, isOptional = true)
    b.element(
      "item",
      listSerialDescriptor(lazyDescriptor { ExplanationOfBenefit.Item.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "addItem",
      listSerialDescriptor(lazyDescriptor { ExplanationOfBenefit.AddItem.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "adjudication",
      listSerialDescriptor(
        lazyDescriptor { ExplanationOfBenefit.Item.Adjudication.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "total",
      listSerialDescriptor(lazyDescriptor { ExplanationOfBenefit.Total.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "payment",
      lazyDescriptor { ExplanationOfBenefit.Payment.serializer().descriptor },
      isOptional = true,
    )
    b.element("formCode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("form", Attachment.serializer().descriptor, isOptional = true)
    b.element(
      "processNote",
      listSerialDescriptor(
        lazyDescriptor { ExplanationOfBenefit.ProcessNote.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("benefitPeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "benefitBalance",
      listSerialDescriptor(
        lazyDescriptor { ExplanationOfBenefit.BenefitBalance.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ExplanationOfBenefit")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ExplanationOfBenefit {
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
        11 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        15 ->
          subType = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        16 -> use = decoder.decodeStringElement(descriptor, i)
        17 ->
          _use =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        19 ->
          billablePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.billablePeriodSer,
              null,
            )
        20 -> created = decoder.decodeStringElement(descriptor, i)
        21 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        23 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        24 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        25 ->
          priority = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        26 ->
          fundsReserveRequested =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        27 ->
          fundsReserve =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        28 ->
          related =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatedSer, null)
        29 ->
          prescription =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        30 ->
          originalPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        31 ->
          event = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSer, null)
        32 ->
          payee = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.payeeSer, null)
        33 ->
          referral =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        34 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.encounterSer, null)
        35 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        36 ->
          claim = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        37 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        38 -> outcome = decoder.decodeStringElement(descriptor, i)
        39 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        40 ->
          decision = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        41 -> disposition = decoder.decodeStringElement(descriptor, i)
        42 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthRefSer, null)
        44 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthRefSer2, null)
        45 ->
          preAuthRefPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.preAuthRefPeriodSer,
              null,
            )
        46 ->
          diagnosisRelatedGroup =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        47 ->
          careTeam =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.careTeamSer, null)
        48 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInfoSer,
              null,
            )
        49 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.diagnosisSer, null)
        50 ->
          procedure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.procedureSer, null)
        51 -> precedence = decoder.decodeIntElement(descriptor, i)
        52 ->
          _precedence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        53 ->
          insurance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.insuranceSer, null)
        54 ->
          accident =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.accidentSer, null)
        55 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        56 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        57 ->
          addItem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addItemSer, null)
        58 ->
          adjudication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.adjudicationSer, null)
        59 ->
          total = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.totalSer, null)
        60 ->
          payment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.paymentSer, null)
        61 ->
          formCode = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        62 -> form = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.formSer, null)
        63 ->
          processNote =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processNoteSer, null)
        64 ->
          benefitPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.billablePeriodSer,
              null,
            )
        65 ->
          benefitBalance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.benefitBalanceSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ExplanationOfBenefit: " + i)
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
        Enumeration.of(
          status?.let { ExplanationOfBenefit.ExplanationOfBenefitStatus.fromCode(it) },
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on ExplanationOfBenefit"
          ),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on ExplanationOfBenefit"
          ),
      subType = subType,
      use =
        Enumeration.of(use?.let { ExplanationOfBenefit.Use.fromCode(it) }, _use)
          ?: throw SerializationException(
            "Missing required property 'use' on ExplanationOfBenefit"
          ),
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on ExplanationOfBenefit"
          ),
      billablePeriod = billablePeriod,
      created =
        DateTime.of(FhirDateTime.fromString(created), _created)
          ?: throw SerializationException(
            "Missing required property 'created' on ExplanationOfBenefit"
          ),
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
        Enumeration.of(
          outcome?.let { ExplanationOfBenefit.ClaimProcessingCodes.fromCode(it) },
          _outcome,
        )
          ?: throw SerializationException(
            "Missing required property 'outcome' on ExplanationOfBenefit"
          ),
      decision = decision,
      disposition = R5String.of(disposition, _disposition),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { index ->
          R5String.of(preAuthRef?.getOrNull(index)?.let { it }, _preAuthRef?.getOrNull(index))!!
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ExplanationOfBenefit,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.identifierSer,
        value.traceNumber,
      )
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      Hoisted.typeSer,
      value.type,
    )
    (value.subType)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.use.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      Hoisted.patientSer,
      value.patient,
    )
    (value.billablePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.billablePeriodSer,
        it,
      )
    }
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.insurer)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.provider)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.priority)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.fundsReserveRequested)?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.fundsReserve)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.relatedSer,
        value.related,
      )
    (value.prescription)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.originalPrescription)?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, Hoisted.patientSer, it)
    }
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.eventSer,
        value.event,
      )
    (value.payee)?.let {
      encoder.encodeSerializableElement(descriptor, 32 + descriptorOffset, Hoisted.payeeSer, it)
    }
    (value.referral)?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, Hoisted.patientSer, it)
    }
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.encounterSer,
        value.encounter,
      )
    (value.facility)?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.claim)?.let {
      encoder.encodeSerializableElement(descriptor, 36 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.claimResponse)?.let {
      encoder.encodeSerializableElement(descriptor, 37 + descriptorOffset, Hoisted.patientSer, it)
    }
    ((value.outcome.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 38 + descriptorOffset, it)
    }
    (value.outcome.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.decision)?.let {
      encoder.encodeSerializableElement(descriptor, 40 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.disposition?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.preAuthRefSer,
        it,
      )
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.preAuthRefSer2,
        it,
      )
    }
    if (value.preAuthRefPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.preAuthRefPeriodSer,
        value.preAuthRefPeriod,
      )
    (value.diagnosisRelatedGroup)?.let {
      encoder.encodeSerializableElement(descriptor, 46 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.careTeamSer,
        value.careTeam,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.supportingInfoSer,
        value.supportingInfo,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.diagnosisSer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.procedureSer,
        value.procedure,
      )
    ((value.precedence?.value))?.let {
      encoder.encodeIntElement(descriptor, 51 + descriptorOffset, it)
    }
    (value.precedence?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.insuranceSer,
        value.insurance,
      )
    (value.accident)?.let {
      encoder.encodeSerializableElement(descriptor, 54 + descriptorOffset, Hoisted.accidentSer, it)
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.patientPaidSer,
        it,
      )
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        Hoisted.itemSer,
        value.item,
      )
    if (value.addItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.addItemSer,
        value.addItem,
      )
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        Hoisted.adjudicationSer,
        value.adjudication,
      )
    if (value.total.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        Hoisted.totalSer,
        value.total,
      )
    (value.payment)?.let {
      encoder.encodeSerializableElement(descriptor, 60 + descriptorOffset, Hoisted.paymentSer, it)
    }
    (value.formCode)?.let {
      encoder.encodeSerializableElement(descriptor, 61 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.form)?.let {
      encoder.encodeSerializableElement(descriptor, 62 + descriptorOffset, Hoisted.formSer, it)
    }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        Hoisted.processNoteSer,
        value.processNote,
      )
    (value.benefitPeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        64 + descriptorOffset,
        Hoisted.billablePeriodSer,
        it,
      )
    }
    if (value.benefitBalance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        Hoisted.benefitBalanceSer,
        value.benefitBalance,
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

internal object ExplanationOfBenefitPolymorphicSerializer : KSerializer<ExplanationOfBenefit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ExplanationOfBenefit") {
      ExplanationOfBenefitSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit) {
    encoder.encodeStructure(descriptor) {
      ExplanationOfBenefitSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit =
    decoder.decodeStructure(descriptor) {
      ExplanationOfBenefitSerializer.deserializeInternal(this, descriptor, 0)
    }
}
