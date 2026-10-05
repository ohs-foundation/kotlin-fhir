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
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Related>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          claim =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        4 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.claim)?.let { encoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, it) }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(descriptor, 5, IdentifierSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Event>> = ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> whenDateTime = decoder.decodeStringElement(descriptor, i)
        5 ->
          _whenDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          whenPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
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
          DateTime.of(whenDateTime?.let { FhirDateTime.fromString(it) }, _whenDateTime),
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`when`) {
      is ExplanationOfBenefit.Event.When.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.Event.When.Period -> {
        encoder.encodeSerializableElement(descriptor, 6, PeriodSerializer, choice.value)
      }
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Payee>> = ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          party =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    (value.party)?.let { encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, it) }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.CareTeam>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        6 -> responsible = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          role =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          specialty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.provider)
    ((value.responsible?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.responsible?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.role)?.let {
      encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, it)
    }
    (value.specialty)?.let {
      encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.SupportingInfo>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 -> timingDate = decoder.decodeStringElement(descriptor, i)
        8 ->
          _timingDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        10 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        11 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 -> valueString = decoder.decodeStringElement(descriptor, i)
        13 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        15 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        16 ->
          valueReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          valueIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        18 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
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
          Date.of(timingDate?.let { FhirDate.fromString(it) }, _timingDate),
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    when (val choice = value.timing) {
      null -> {}
      is ExplanationOfBenefit.SupportingInfo.Timing.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Timing.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.`value`) {
      null -> {}
      is ExplanationOfBenefit.SupportingInfo.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 14, QuantitySerializer, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 15, AttachmentSerializer, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 16, ReferenceSerializer, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 17, IdentifierSerializer, choice.value)
      }
    }
    (value.reason)?.let { encoder.encodeSerializableElement(descriptor, 18, CodingSerializer, it) }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Diagnosis>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          diagnosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          diagnosisReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        7 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          onAdmission =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    when (val choice = value.diagnosis) {
      is ExplanationOfBenefit.Diagnosis.Diagnosis.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
      }
      is ExplanationOfBenefit.Diagnosis.Diagnosis.Reference -> {
        encoder.encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
      }
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    (value.onAdmission)?.let {
      encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Procedure>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 -> date = decoder.decodeStringElement(descriptor, i)
        7 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          procedureCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          procedureReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        10 ->
          udi =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
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
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    when (val choice = value.procedure) {
      is ExplanationOfBenefit.Procedure.Procedure.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
      }
      is ExplanationOfBenefit.Procedure.Procedure.Reference -> {
        encoder.encodeSerializableElement(descriptor, 9, ReferenceSerializer, choice.value)
      }
    }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Insurance>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> focal = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _focal = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        6 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        7 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
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
          R5String.of(preAuthRef?.getOrNull(index)?.let { it }, _preAuthRef?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'preAuthRef' on ExplanationOfBenefit.Insurance has neither a value nor an id/extension"
            )
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ExplanationOfBenefit.Insurance,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.focal.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.focal.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.coverage)
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, stringNullableListSerializer, it)
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer.nullableListSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Accident>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> date = decoder.decodeStringElement(descriptor, i)
        4 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        7 ->
          locationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Accident: " + i)
      }
    }
    return ExplanationOfBenefit.Accident(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      date = Date.of(date?.let { FhirDate.fromString(it) }, _date),
      type = type,
      location = ExplanationOfBenefit.Accident.Location.from(locationAddress, locationReference),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Accident) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.Accident.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 6, AddressSerializer, choice.value)
      }
      is ExplanationOfBenefit.Accident.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item>> = ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          careTeamSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _careTeamSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          diagnosisSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        8 ->
          _diagnosisSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 ->
          procedureSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        10 ->
          _procedureSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 ->
          informationSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        12 ->
          _informationSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        14 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          request =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          programCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        21 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        22 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        24 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        26 ->
          locationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        28 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        29 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        30 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        31 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 -> tax = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        33 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        34 ->
          udi =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemBodySiteSerializer.listSerializer,
              null,
            )
        36 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        38 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        39 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemReviewOutcomeSerializer,
              null,
            )
        40 ->
          adjudication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        41 ->
          detail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemDetailSerializer.listSerializer,
              null,
            )
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
          )
            ?: throw SerializationException(
              "An entry of 'careTeamSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      diagnosisSequence =
        (kotlin.collections.List(
          maxOf(diagnosisSequence?.size ?: 0, _diagnosisSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            diagnosisSequence?.getOrNull(index)?.let { it },
            _diagnosisSequence?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'diagnosisSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      procedureSequence =
        (kotlin.collections.List(
          maxOf(procedureSequence?.size ?: 0, _procedureSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            procedureSequence?.getOrNull(index)?.let { it },
            _procedureSequence?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'procedureSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      informationSequence =
        (kotlin.collections.List(
          maxOf(informationSequence?.size ?: 0, _informationSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            informationSequence?.getOrNull(index)?.let { it },
            _informationSequence?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'informationSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
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
          Date.of(servicedDate?.let { FhirDate.fromString(it) }, _servicedDate),
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
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Item) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.careTeamSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, intNullableListSerializer, it)
    }
    (value.careTeamSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer.nullableListSerializer, it)
    }
    (value.diagnosisSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, intNullableListSerializer, it)
    }
    (value.diagnosisSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer.nullableListSerializer, it)
    }
    (value.procedureSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, intNullableListSerializer, it)
    }
    (value.procedureSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.informationSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, intNullableListSerializer, it)
    }
    (value.informationSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13,
        IdentifierSerializer.listSerializer,
        value.traceNumber,
      )
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 14, CodeableConceptSerializer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 15, CodeableConceptSerializer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 16, CodeableConceptSerializer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 17, CodeableConceptSerializer, it)
    }
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18,
        ReferenceSerializer.listSerializer,
        value.request,
      )
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    when (val choice = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.Item.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 21, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 22, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.Item.Serviced.Period -> {
        encoder.encodeSerializableElement(descriptor, 23, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.Item.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 24, CodeableConceptSerializer, choice.value)
      }
      is ExplanationOfBenefit.Item.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 25, AddressSerializer, choice.value)
      }
      is ExplanationOfBenefit.Item.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 26, ReferenceSerializer, choice.value)
      }
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 27, MoneySerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 28, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 29, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 30, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 31, ElementSerializer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(descriptor, 32, MoneySerializer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 33, MoneySerializer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35,
        ExplanationOfBenefitItemBodySiteSerializer.listSerializer,
        value.bodySite,
      )
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36,
        ReferenceSerializer.listSerializer,
        value.encounter,
      )
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 37, intNullableListSerializer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        it,
      )
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41,
        ExplanationOfBenefitItemDetailSerializer.listSerializer,
        value.detail,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.BodySite>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          site =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        4 ->
          subSite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableReferenceSerializer.listSerializer,
        value.site,
      )
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.subSite,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.ReviewOutcome>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          decision =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 -> preAuthRef = decoder.decodeStringElement(descriptor, i)
        6 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 ->
          preAuthPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.decision)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.reason,
      )
    ((value.preAuthRef?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.preAuthRef?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    (value.preAuthPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 7, PeriodSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        6 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.category)
    (value.reason)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 5, MoneySerializer, it) }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 6, QuantitySerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.Detail>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        6 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          programCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        13 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        14 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        16 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> tax = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        18 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        19 ->
          udi =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        21 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        22 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemReviewOutcomeSerializer,
              null,
            )
        23 ->
          adjudication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        24 ->
          subDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemDetailSubDetailSerializer.listSerializer,
              null,
            )
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
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.Item.Detail has neither a value nor an id/extension"
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        IdentifierSerializer.listSerializer,
        value.traceNumber,
      )
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 12, MoneySerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 13, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 14, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 15, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, ElementSerializer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(descriptor, 17, MoneySerializer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 18, MoneySerializer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 20, intNullableListSerializer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        it,
      )
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24,
        ExplanationOfBenefitItemDetailSubDetailSerializer.listSerializer,
        value.subDetail,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.Detail.SubDetail>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        6 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          programCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        13 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        14 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        16 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> tax = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        18 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        19 ->
          udi =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        21 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        22 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemReviewOutcomeSerializer,
              null,
            )
        23 ->
          adjudication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
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
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.Item.Detail.SubDetail has neither a value nor an id/extension"
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        IdentifierSerializer.listSerializer,
        value.traceNumber,
      )
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 12, MoneySerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 13, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 14, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 15, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, ElementSerializer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(descriptor, 17, MoneySerializer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 18, MoneySerializer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 20, intNullableListSerializer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        it,
      )
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          itemSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        4 ->
          _itemSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 ->
          detailSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _detailSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          subDetailSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        8 ->
          _subDetailSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        10 ->
          provider =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        11 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          request =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          programCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        20 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        22 ->
          locationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        24 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        25 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        26 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        27 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> tax = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        29 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        30 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAddItemBodySiteSerializer.listSerializer,
              null,
            )
        31 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        32 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        33 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemReviewOutcomeSerializer,
              null,
            )
        34 ->
          adjudication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        35 ->
          detail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAddItemDetailSerializer.listSerializer,
              null,
            )
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
          )
            ?: throw SerializationException(
              "An entry of 'itemSequence' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
            )
        }),
      detailSequence =
        (kotlin.collections.List(maxOf(detailSequence?.size ?: 0, _detailSequence?.size ?: 0)) {
          index ->
          PositiveInt.of(
            detailSequence?.getOrNull(index)?.let { it },
            _detailSequence?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'detailSequence' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
            )
        }),
      subDetailSequence =
        (kotlin.collections.List(
          maxOf(subDetailSequence?.size ?: 0, _subDetailSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            subDetailSequence?.getOrNull(index)?.let { it },
            _subDetailSequence?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'subDetailSequence' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
            )
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
          Date.of(servicedDate?.let { FhirDate.fromString(it) }, _servicedDate),
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
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
            )
        }),
      reviewOutcome = reviewOutcome,
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.AddItem) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.itemSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, intNullableListSerializer, it)
    }
    (value.itemSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer.nullableListSerializer, it)
    }
    (value.detailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, intNullableListSerializer, it)
    }
    (value.detailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer.nullableListSerializer, it)
    }
    (value.subDetailSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, intNullableListSerializer, it)
    }
    (value.subDetailSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer.nullableListSerializer, it)
    }
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        IdentifierSerializer.listSerializer,
        value.traceNumber,
      )
    if (value.provider.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        ReferenceSerializer.listSerializer,
        value.provider,
      )
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 11, CodeableConceptSerializer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 12, CodeableConceptSerializer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 13, CodeableConceptSerializer, it)
    }
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        ReferenceSerializer.listSerializer,
        value.request,
      )
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    when (val choice = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.AddItem.Serviced.Period -> {
        encoder.encodeSerializableElement(descriptor, 19, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 20, CodeableConceptSerializer, choice.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 21, AddressSerializer, choice.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 22, ReferenceSerializer, choice.value)
      }
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 23, MoneySerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 24, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 25, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 26, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 27, ElementSerializer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(descriptor, 28, MoneySerializer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 29, MoneySerializer, it) }
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30,
        ExplanationOfBenefitAddItemBodySiteSerializer.listSerializer,
        value.bodySite,
      )
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 31, intNullableListSerializer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        it,
      )
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35,
        ExplanationOfBenefitAddItemDetailSerializer.listSerializer,
        value.detail,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem.BodySite>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          site =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        4 ->
          subSite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableReferenceSerializer.listSerializer,
        value.site,
      )
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.subSite,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem.Detail>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        4 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        9 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        10 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        11 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        12 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> tax = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        14 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        16 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        17 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemReviewOutcomeSerializer,
              null,
            )
        18 ->
          adjudication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        19 ->
          subDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAddItemDetailSubDetailSerializer.listSerializer,
              null,
            )
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
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem.Detail has neither a value nor an id/extension"
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        IdentifierSerializer.listSerializer,
        value.traceNumber,
      )
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 8, MoneySerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 9, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 10, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 11, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(descriptor, 13, MoneySerializer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 14, MoneySerializer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15, intNullableListSerializer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        it,
      )
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19,
        ExplanationOfBenefitAddItemDetailSubDetailSerializer.listSerializer,
        value.subDetail,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem.Detail.SubDetail>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        4 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          productOrServiceEnd =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        9 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        10 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        11 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        12 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> tax = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        14 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        16 ->
          _noteNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        17 ->
          reviewOutcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemReviewOutcomeSerializer,
              null,
            )
        18 ->
          adjudication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
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
          PositiveInt.of(noteNumber?.getOrNull(index)?.let { it }, _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem.Detail.SubDetail has neither a value nor an id/extension"
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        IdentifierSerializer.listSerializer,
        value.traceNumber,
      )
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    (value.productOrServiceEnd)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 8, MoneySerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 9, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 10, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 11, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
    }
    (value.tax)?.let { encoder.encodeSerializableElement(descriptor, 13, MoneySerializer, it) }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 14, MoneySerializer, it) }
    (value.noteNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15, intNullableListSerializer, it)
    }
    (value.noteNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.reviewOutcome)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        it,
      )
    }
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Total>> = ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.category)
    encoder.encodeSerializableElement(descriptor, 4, MoneySerializer, value.amount)
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Payment>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          adjustment =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        5 ->
          adjustmentReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> date = decoder.decodeStringElement(descriptor, i)
        7 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        9 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
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
      date = Date.of(date?.let { FhirDate.fromString(it) }, _date),
      amount = amount,
      identifier = identifier,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExplanationOfBenefit.Payment) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    (value.adjustment)?.let {
      encoder.encodeSerializableElement(descriptor, 4, MoneySerializer, it)
    }
    (value.adjustmentReason)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 8, MoneySerializer, it) }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 9, IdentifierSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.ProcessNote>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> number = decoder.decodeIntElement(descriptor, i)
        4 ->
          _number =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> text = decoder.decodeStringElement(descriptor, i)
        7 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          language =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.number?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.number?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.language)?.let {
      encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.BenefitBalance>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> excluded = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _excluded =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> name = decoder.decodeStringElement(descriptor, i)
        7 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 -> description = decoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        10 ->
          network =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          unit =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          term =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          financial =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitBenefitBalanceFinancialSerializer.listSerializer,
              null,
            )
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.category)
    ((value.excluded?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.excluded?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer, it)
    }
    (value.network)?.let {
      encoder.encodeSerializableElement(descriptor, 10, CodeableConceptSerializer, it)
    }
    (value.unit)?.let {
      encoder.encodeSerializableElement(descriptor, 11, CodeableConceptSerializer, it)
    }
    (value.term)?.let {
      encoder.encodeSerializableElement(descriptor, 12, CodeableConceptSerializer, it)
    }
    if (value.financial.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13,
        ExplanationOfBenefitBenefitBalanceFinancialSerializer.listSerializer,
        value.financial,
      )
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

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.BenefitBalance.Financial>> =
    ListSerializer(this)

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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> allowedUnsignedInt = decoder.decodeIntElement(descriptor, i)
        5 ->
          _allowedUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> allowedString = decoder.decodeStringElement(descriptor, i)
        7 ->
          _allowedString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          allowedMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        9 -> usedUnsignedInt = decoder.decodeIntElement(descriptor, i)
        10 ->
          _usedUnsignedInt =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 ->
          usedMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
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
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.allowed) {
      null -> {}
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.Money -> {
        encoder.encodeSerializableElement(descriptor, 8, MoneySerializer, choice.value)
      }
    }
    when (val choice = value.used) {
      null -> {}
      is ExplanationOfBenefit.BenefitBalance.Financial.Used.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
        }
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Used.Money -> {
        encoder.encodeSerializableElement(descriptor, 11, MoneySerializer, choice.value)
      }
    }
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
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          traceNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          subType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 -> use = decoder.decodeStringElement(descriptor, i)
        17 ->
          _use = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          billablePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        20 -> created = decoder.decodeStringElement(descriptor, i)
        21 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        25 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          fundsReserveRequested =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          fundsReserve =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          related =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitRelatedSerializer.listSerializer,
              null,
            )
        29 ->
          prescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        30 ->
          originalPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        31 ->
          event =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitEventSerializer.listSerializer,
              null,
            )
        32 ->
          payee =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitPayeeSerializer,
              null,
            )
        33 ->
          referral =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        34 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        36 ->
          claim =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        37 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        38 -> outcome = decoder.decodeStringElement(descriptor, i)
        39 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 ->
          decision =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        41 -> disposition = decoder.decodeStringElement(descriptor, i)
        42 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        44 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        45 ->
          preAuthRefPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer.listSerializer,
              null,
            )
        46 ->
          diagnosisRelatedGroup =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        47 ->
          careTeam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitCareTeamSerializer.listSerializer,
              null,
            )
        48 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitSupportingInfoSerializer.listSerializer,
              null,
            )
        49 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitDiagnosisSerializer.listSerializer,
              null,
            )
        50 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitProcedureSerializer.listSerializer,
              null,
            )
        51 -> precedence = decoder.decodeIntElement(descriptor, i)
        52 ->
          _precedence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        53 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitInsuranceSerializer.listSerializer,
              null,
            )
        54 ->
          accident =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAccidentSerializer,
              null,
            )
        55 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        56 ->
          item =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemSerializer.listSerializer,
              null,
            )
        57 ->
          addItem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAddItemSerializer.listSerializer,
              null,
            )
        58 ->
          adjudication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        59 ->
          total =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitTotalSerializer.listSerializer,
              null,
            )
        60 ->
          payment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitPaymentSerializer,
              null,
            )
        61 ->
          formCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        62 ->
          form =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        63 ->
          processNote =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitProcessNoteSerializer.listSerializer,
              null,
            )
        64 ->
          benefitPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        65 ->
          benefitBalance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitBenefitBalanceSerializer.listSerializer,
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
        DateTime.of(created?.let { FhirDateTime.fromString(it) }, _created)
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
          R5String.of(preAuthRef?.getOrNull(index)?.let { it }, _preAuthRef?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'preAuthRef' on ExplanationOfBenefit has neither a value nor an id/extension"
            )
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
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.traceNumber,
      )
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    (value.subType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    ((value.use.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    (value.billablePeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, PeriodSerializer, it)
    }
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, ElementSerializer, it)
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.insurer)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.provider)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.priority)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.fundsReserveRequested)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.fundsReserve)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ExplanationOfBenefitRelatedSerializer.listSerializer,
        value.related,
      )
    (value.prescription)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.originalPrescription)?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, ReferenceSerializer, it)
    }
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ExplanationOfBenefitEventSerializer.listSerializer,
        value.event,
      )
    (value.payee)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ExplanationOfBenefitPayeeSerializer,
        it,
      )
    }
    (value.referral)?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, ReferenceSerializer, it)
    }
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.encounter,
      )
    (value.facility)?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.claim)?.let {
      encoder.encodeSerializableElement(descriptor, 36 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.claimResponse)?.let {
      encoder.encodeSerializableElement(descriptor, 37 + descriptorOffset, ReferenceSerializer, it)
    }
    ((value.outcome.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 38 + descriptorOffset, it)
    }
    (value.outcome.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 39 + descriptorOffset, ElementSerializer, it)
    }
    (value.decision)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    ((value.disposition?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 42 + descriptorOffset, ElementSerializer, it)
    }
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.preAuthRefPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        PeriodSerializer.listSerializer,
        value.preAuthRefPeriod,
      )
    (value.diagnosisRelatedGroup)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        ExplanationOfBenefitCareTeamSerializer.listSerializer,
        value.careTeam,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ExplanationOfBenefitSupportingInfoSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ExplanationOfBenefitDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ExplanationOfBenefitProcedureSerializer.listSerializer,
        value.procedure,
      )
    ((value.precedence?.value))?.let {
      encoder.encodeIntElement(descriptor, 51 + descriptorOffset, it)
    }
    (value.precedence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 52 + descriptorOffset, ElementSerializer, it)
    }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        ExplanationOfBenefitInsuranceSerializer.listSerializer,
        value.insurance,
      )
    (value.accident)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        ExplanationOfBenefitAccidentSerializer,
        it,
      )
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(descriptor, 55 + descriptorOffset, MoneySerializer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        ExplanationOfBenefitItemSerializer.listSerializer,
        value.item,
      )
    if (value.addItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        ExplanationOfBenefitAddItemSerializer.listSerializer,
        value.addItem,
      )
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.total.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        ExplanationOfBenefitTotalSerializer.listSerializer,
        value.total,
      )
    (value.payment)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        ExplanationOfBenefitPaymentSerializer,
        it,
      )
    }
    (value.formCode)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        61 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.form)?.let {
      encoder.encodeSerializableElement(descriptor, 62 + descriptorOffset, AttachmentSerializer, it)
    }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        ExplanationOfBenefitProcessNoteSerializer.listSerializer,
        value.processNote,
      )
    (value.benefitPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 64 + descriptorOffset, PeriodSerializer, it)
    }
    if (value.benefitBalance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        ExplanationOfBenefitBenefitBalanceSerializer.listSerializer,
        value.benefitBalance,
      )
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
