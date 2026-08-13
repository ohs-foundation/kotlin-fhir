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
import dev.ohs.fhir.model.r5.Claim
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
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

internal object ClaimRelatedSerializer : KSerializer<Claim.Related> {
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

  override fun deserialize(decoder: Decoder): Claim.Related =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Related) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Related {
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
    return Claim.Related(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      claim = claim,
      relationship = relationship,
      reference = reference,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Related) {
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

internal object ClaimPayeeSerializer : KSerializer<Claim.Payee> {
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

  override fun deserialize(decoder: Decoder): Claim.Payee =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Payee) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Payee {
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
    return Claim.Payee(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Claim.Payee"),
      party = party,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Payee) {
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

internal object ClaimEventSerializer : KSerializer<Claim.Event> {
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

  override fun deserialize(decoder: Decoder): Claim.Event =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Event) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Event {
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
    return Claim.Event(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Claim.Event"),
      `when` =
        Claim.Event.When.from(
          DateTime.of(whenDateTime?.let { FhirDateTime.fromString(it) }, _whenDateTime),
          whenPeriod,
        ) ?: throw SerializationException("Missing required property 'when' on Claim.Event"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Event) {
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
      is Claim.Event.When.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.whenDateTimeSer, it)
        }
      }
      is Claim.Event.When.Period -> {
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

internal object ClaimCareTeamSerializer : KSerializer<Claim.CareTeam> {
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

  override fun deserialize(decoder: Decoder): Claim.CareTeam =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.CareTeam) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.CareTeam {
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
    return Claim.CareTeam(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException("Missing required property 'sequence' on Claim.CareTeam"),
      provider =
        provider
          ?: throw SerializationException("Missing required property 'provider' on Claim.CareTeam"),
      responsible = R5Boolean.of(responsible, _responsible),
      role = role,
      specialty = specialty,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.CareTeam) {
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

internal object ClaimSupportingInfoSerializer : KSerializer<Claim.SupportingInfo> {
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
      element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Claim.SupportingInfo =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.SupportingInfo) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.SupportingInfo {
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
    var reason: CodeableConcept? = null
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
          reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
      }
    }
    return Claim.SupportingInfo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.SupportingInfo"
          ),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on Claim.SupportingInfo"
          ),
      code = code,
      timing =
        Claim.SupportingInfo.Timing.from(
          Date.of(timingDate?.let { FhirDate.fromString(it) }, _timingDate),
          timingPeriod,
        ),
      `value` =
        Claim.SupportingInfo.Value.from(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.SupportingInfo) {
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
      is Claim.SupportingInfo.Timing.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.sequenceSer, it)
        }
      }
      is Claim.SupportingInfo.Timing.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.timingPeriodSer, choice.value)
      }
    }
    when (val choice = value.`value`) {
      null -> {}
      is Claim.SupportingInfo.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.sequenceSer, it)
        }
      }
      is Claim.SupportingInfo.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.sequenceSer, it)
        }
      }
      is Claim.SupportingInfo.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueQuantitySer, choice.value)
      }
      is Claim.SupportingInfo.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 15, Hoisted.valueAttachmentSer, choice.value)
      }
      is Claim.SupportingInfo.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 16, Hoisted.valueReferenceSer, choice.value)
      }
      is Claim.SupportingInfo.Value.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 17, Hoisted.valueIdentifierSer, choice.value)
      }
    }
    (value.reason)?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.categorySer, it)
    }
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
  }
}

internal object ClaimDiagnosisSerializer : KSerializer<Claim.Diagnosis> {
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

  override fun deserialize(decoder: Decoder): Claim.Diagnosis =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Diagnosis) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Diagnosis {
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
    return Claim.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Diagnosis"
          ),
      diagnosis =
        Claim.Diagnosis.Diagnosis.from(diagnosisCodeableConcept, diagnosisReference)
          ?: throw SerializationException(
            "Missing required property 'diagnosis' on Claim.Diagnosis"
          ),
      type = type ?: listOf(),
      onAdmission = onAdmission,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Diagnosis) {
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
      is Claim.Diagnosis.Diagnosis.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          5,
          Hoisted.diagnosisCodeableConceptSer,
          choice.value,
        )
      }
      is Claim.Diagnosis.Diagnosis.Reference -> {
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

internal object ClaimProcedureSerializer : KSerializer<Claim.Procedure> {
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

  override fun deserialize(decoder: Decoder): Claim.Procedure =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Procedure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Procedure {
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
    return Claim.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Procedure"
          ),
      type = type ?: listOf(),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      procedure =
        Claim.Procedure.Procedure.from(procedureCodeableConcept, procedureReference)
          ?: throw SerializationException(
            "Missing required property 'procedure' on Claim.Procedure"
          ),
      udi = udi ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Procedure) {
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
      is Claim.Procedure.Procedure.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSerInner, choice.value)
      }
      is Claim.Procedure.Procedure.Reference -> {
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

internal object ClaimInsuranceSerializer : KSerializer<Claim.Insurance> {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("focal", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_focal", Element.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("coverage", Reference.serializer().descriptor, isOptional = true)
      element("businessArrangement", KotlinString.serializer().descriptor, isOptional = true)
      element("_businessArrangement", Element.serializer().descriptor, isOptional = true)
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
      element("claimResponse", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Claim.Insurance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Insurance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Insurance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var focal: KotlinBoolean? = null
    var _focal: Element? = null
    var identifier: Identifier? = null
    var coverage: Reference? = null
    var businessArrangement: KotlinString? = null
    var _businessArrangement: Element? = null
    var preAuthRef: List<KotlinString?>? = null
    var _preAuthRef: List<Element?>? = null
    var claimResponse: Reference? = null
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
        5 -> focal = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _focal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        7 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        8 ->
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        9 -> businessArrangement = decoder.decodeStringElement(descriptor, i)
        10 ->
          _businessArrangement =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        11 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthRefSer, null)
        12 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.preAuthRefSer2, null)
        13 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
      }
    }
    return Claim.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Insurance"
          ),
      focal =
        R5Boolean.of(focal, _focal)
          ?: throw SerializationException("Missing required property 'focal' on Claim.Insurance"),
      identifier = identifier,
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on Claim.Insurance"
          ),
      businessArrangement = R5String.of(businessArrangement, _businessArrangement),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { index ->
          R5String.of(preAuthRef?.getOrNull(index)?.let { it }, _preAuthRef?.getOrNull(index))!!
        }),
      claimResponse = claimResponse,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Insurance) {
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
    ((value.focal.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.focal.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.sequenceSer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.identifierSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 8, Hoisted.coverageSer, value.coverage)
    ((value.businessArrangement?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.businessArrangement?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.sequenceSer, it)
    }
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.preAuthRefSer, it)
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.preAuthRefSer2, it)
    }
    (value.claimResponse)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.coverageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val coverageSer: KSerializer<Reference> = Reference.serializer()

    public val preAuthRefSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val preAuthRefSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.preAuthRefSerInner).nullable)

    public val preAuthRefSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.sequenceSer).nullable)
  }
}

internal object ClaimAccidentSerializer : KSerializer<Claim.Accident> {
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

  override fun deserialize(decoder: Decoder): Claim.Accident =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Accident) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Accident {
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
    return Claim.Accident(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      date =
        Date.of(date?.let { FhirDate.fromString(it) }, _date)
          ?: throw SerializationException("Missing required property 'date' on Claim.Accident"),
      type = type,
      location = Claim.Accident.Location.from(locationAddress, locationReference),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Accident) {
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
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.dateSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    when (val choice = value.location) {
      null -> {}
      is Claim.Accident.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.locationAddressSer, choice.value)
      }
      is Claim.Accident.Location.Reference -> {
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

internal object ClaimItemSerializer : KSerializer<Claim.Item> {
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
        "traceNumber",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
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
        listSerialDescriptor(lazyDescriptor { Claim.Item.BodySite.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "encounter",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "detail",
        listSerialDescriptor(lazyDescriptor { Claim.Item.Detail.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Claim.Item =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Item {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var traceNumber: List<Identifier>? = null
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
    var bodySite: List<Claim.Item.BodySite>? = null
    var encounter: List<Reference>? = null
    var detail: List<Claim.Item.Detail>? = null
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
          careTeamSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        7 ->
          _careTeamSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        8 ->
          diagnosisSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        9 ->
          _diagnosisSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        10 ->
          procedureSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        11 ->
          _procedureSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
        12 ->
          informationSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer,
              null,
            )
        13 ->
          _informationSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.careTeamSequenceSer2,
              null,
            )
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
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return Claim.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException("Missing required property 'sequence' on Claim.Item"),
      traceNumber = traceNumber ?: listOf(),
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
      revenue = revenue,
      category = category,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      request = request ?: listOf(),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      serviced =
        Claim.Item.Serviced.from(
          Date.of(servicedDate?.let { FhirDate.fromString(it) }, _servicedDate),
          servicedPeriod,
        ),
      location =
        Claim.Item.Location.from(locationCodeableConcept, locationAddress, locationReference),
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      udi = udi ?: listOf(),
      bodySite = bodySite ?: listOf(),
      encounter = encounter ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Item) {
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
    (value.careTeamSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.careTeamSequenceSer, it)
    }
    (value.careTeamSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.careTeamSequenceSer2, it)
    }
    (value.diagnosisSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.careTeamSequenceSer, it)
    }
    (value.diagnosisSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.careTeamSequenceSer2, it)
    }
    (value.procedureSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.careTeamSequenceSer, it)
    }
    (value.procedureSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.careTeamSequenceSer2, it)
    }
    (value.informationSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.careTeamSequenceSer, it)
    }
    (value.informationSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.careTeamSequenceSer2, it)
    }
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
      is Claim.Item.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 21, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 22, Hoisted.sequenceSer, it)
        }
      }
      is Claim.Item.Serviced.Period -> {
        encoder.encodeSerializableElement(descriptor, 23, Hoisted.servicedPeriodSer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is Claim.Item.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 24, Hoisted.revenueSer, choice.value)
      }
      is Claim.Item.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 25, Hoisted.locationAddressSer, choice.value)
      }
      is Claim.Item.Location.Reference -> {
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
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 37, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val traceNumberSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val traceNumberSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.traceNumberSerInner)

    public val careTeamSequenceSerInner: KSerializer<Int> = Int.serializer()

    public val careTeamSequenceSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.careTeamSequenceSerInner).nullable)

    public val careTeamSequenceSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.sequenceSer).nullable)

    public val revenueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val requestSerInner: KSerializer<Reference> = Reference.serializer()

    public val requestSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.requestSerInner)

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.revenueSer)

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val locationAddressSer: KSerializer<Address> = Address.serializer()

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val bodySiteSerInner: KSerializer<Claim.Item.BodySite> = Claim.Item.BodySite.serializer()

    public val bodySiteSer: KSerializer<List<Claim.Item.BodySite>> =
      ListSerializer(Hoisted.bodySiteSerInner)

    public val detailSerInner: KSerializer<Claim.Item.Detail> = Claim.Item.Detail.serializer()

    public val detailSer: KSerializer<List<Claim.Item.Detail>> =
      ListSerializer(Hoisted.detailSerInner)
  }
}

internal object ClaimItemBodySiteSerializer : KSerializer<Claim.Item.BodySite> {
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

  override fun deserialize(decoder: Decoder): Claim.Item.BodySite =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.BodySite) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Item.BodySite {
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
    return Claim.Item.BodySite(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      site = site ?: listOf(),
      subSite = subSite ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Item.BodySite) {
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

internal object ClaimItemDetailSerializer : KSerializer<Claim.Item.Detail> {
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
      element(
        "subDetail",
        listSerialDescriptor(
          lazyDescriptor { Claim.Item.Detail.SubDetail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Claim.Item.Detail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Item.Detail {
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
    var subDetail: List<Claim.Item.Detail.SubDetail>? = null
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
          subDetail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subDetailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    return Claim.Item.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Item.Detail"
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
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Item.Detail) {
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
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.subDetailSer, value.subDetail)
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

    public val subDetailSerInner: KSerializer<Claim.Item.Detail.SubDetail> =
      Claim.Item.Detail.SubDetail.serializer()

    public val subDetailSer: KSerializer<List<Claim.Item.Detail.SubDetail>> =
      ListSerializer(Hoisted.subDetailSerInner)
  }
}

internal object ClaimItemDetailSubDetailSerializer : KSerializer<Claim.Item.Detail.SubDetail> {
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
    }

  override fun deserialize(decoder: Decoder): Claim.Item.Detail.SubDetail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Item.Detail.SubDetail {
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
      }
    }
    return Claim.Item.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Item.Detail.SubDetail"
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
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Item.Detail.SubDetail) {
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
  }
}

internal object ClaimSerializer : KSerializer<Claim> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Claim") {
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
    b.element("fundsReserve", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "related",
      listSerialDescriptor(lazyDescriptor { Claim.Related.serializer().descriptor }),
      isOptional = true,
    )
    b.element("prescription", Reference.serializer().descriptor, isOptional = true)
    b.element("originalPrescription", Reference.serializer().descriptor, isOptional = true)
    b.element("payee", lazyDescriptor { Claim.Payee.serializer().descriptor }, isOptional = true)
    b.element("referral", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "encounter",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("facility", Reference.serializer().descriptor, isOptional = true)
    b.element("diagnosisRelatedGroup", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "event",
      listSerialDescriptor(lazyDescriptor { Claim.Event.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "careTeam",
      listSerialDescriptor(lazyDescriptor { Claim.CareTeam.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(lazyDescriptor { Claim.SupportingInfo.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "diagnosis",
      listSerialDescriptor(lazyDescriptor { Claim.Diagnosis.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "procedure",
      listSerialDescriptor(lazyDescriptor { Claim.Procedure.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "insurance",
      listSerialDescriptor(lazyDescriptor { Claim.Insurance.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "accident",
      lazyDescriptor { Claim.Accident.serializer().descriptor },
      isOptional = true,
    )
    b.element("patientPaid", Money.serializer().descriptor, isOptional = true)
    b.element(
      "item",
      listSerialDescriptor(lazyDescriptor { Claim.Item.serializer().descriptor }),
      isOptional = true,
    )
    b.element("total", Money.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Claim =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Claim) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Claim")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Claim {
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
    var fundsReserve: CodeableConcept? = null
    var related: List<Claim.Related>? = null
    var prescription: Reference? = null
    var originalPrescription: Reference? = null
    var payee: Claim.Payee? = null
    var referral: Reference? = null
    var encounter: List<Reference>? = null
    var facility: Reference? = null
    var diagnosisRelatedGroup: CodeableConcept? = null
    var event: List<Claim.Event>? = null
    var careTeam: List<Claim.CareTeam>? = null
    var supportingInfo: List<Claim.SupportingInfo>? = null
    var diagnosis: List<Claim.Diagnosis>? = null
    var procedure: List<Claim.Procedure>? = null
    var insurance: List<Claim.Insurance>? = null
    var accident: Claim.Accident? = null
    var patientPaid: Money? = null
    var item: List<Claim.Item>? = null
    var total: Money? = null
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
          fundsReserve =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        27 ->
          related =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatedSer, null)
        28 ->
          prescription =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        29 ->
          originalPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        30 ->
          payee = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.payeeSer, null)
        31 ->
          referral =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        32 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.encounterSer, null)
        33 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        34 ->
          diagnosisRelatedGroup =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        35 ->
          event = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSer, null)
        36 ->
          careTeam =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.careTeamSer, null)
        37 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInfoSer,
              null,
            )
        38 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.diagnosisSer, null)
        39 ->
          procedure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.procedureSer, null)
        40 ->
          insurance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.insuranceSer, null)
        41 ->
          accident =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.accidentSer, null)
        42 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        43 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        44 ->
          total =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientPaidSer, null)
        else -> throw SerializationException("Unexpected index decoding Claim: " + i)
      }
    }
    return Claim(
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
          Claim.FinancialResourceStatusCodes.fromCode(
            status ?: throw SerializationException("Missing required property 'status' on Claim")
          ),
          _status,
        ),
      type = type ?: throw SerializationException("Missing required property 'type' on Claim"),
      subType = subType,
      use =
        Enumeration.of(
          Claim.Use.fromCode(
            use ?: throw SerializationException("Missing required property 'use' on Claim")
          ),
          _use,
        ),
      patient =
        patient ?: throw SerializationException("Missing required property 'patient' on Claim"),
      billablePeriod = billablePeriod,
      created =
        DateTime.of(created?.let { FhirDateTime.fromString(it) }, _created)
          ?: throw SerializationException("Missing required property 'created' on Claim"),
      enterer = enterer,
      insurer = insurer,
      provider = provider,
      priority = priority,
      fundsReserve = fundsReserve,
      related = related ?: listOf(),
      prescription = prescription,
      originalPrescription = originalPrescription,
      payee = payee,
      referral = referral,
      encounter = encounter ?: listOf(),
      facility = facility,
      diagnosisRelatedGroup = diagnosisRelatedGroup,
      event = event ?: listOf(),
      careTeam = careTeam ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      insurance = insurance ?: listOf(),
      accident = accident,
      patientPaid = patientPaid,
      item = item ?: listOf(),
      total = total,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Claim,
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
    ((value.status.value?.getCode()))?.let {
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
    ((value.use.value?.getCode()))?.let {
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
    (value.fundsReserve)?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.relatedSer,
        value.related,
      )
    (value.prescription)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.originalPrescription)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.payee)?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, Hoisted.payeeSer, it)
    }
    (value.referral)?.let {
      encoder.encodeSerializableElement(descriptor, 31 + descriptorOffset, Hoisted.patientSer, it)
    }
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.encounterSer,
        value.encounter,
      )
    (value.facility)?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.diagnosisRelatedGroup)?.let {
      encoder.encodeSerializableElement(descriptor, 34 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.eventSer,
        value.event,
      )
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.careTeamSer,
        value.careTeam,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.supportingInfoSer,
        value.supportingInfo,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.diagnosisSer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.procedureSer,
        value.procedure,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.insuranceSer,
        value.insurance,
      )
    (value.accident)?.let {
      encoder.encodeSerializableElement(descriptor, 41 + descriptorOffset, Hoisted.accidentSer, it)
    }
    (value.patientPaid)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.patientPaidSer,
        it,
      )
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.itemSer,
        value.item,
      )
    (value.total)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.patientPaidSer,
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val billablePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedSerInner: KSerializer<Claim.Related> = Claim.Related.serializer()

    public val relatedSer: KSerializer<List<Claim.Related>> =
      ListSerializer(Hoisted.relatedSerInner)

    public val payeeSer: KSerializer<Claim.Payee> = Claim.Payee.serializer()

    public val encounterSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)

    public val eventSerInner: KSerializer<Claim.Event> = Claim.Event.serializer()

    public val eventSer: KSerializer<List<Claim.Event>> = ListSerializer(Hoisted.eventSerInner)

    public val careTeamSerInner: KSerializer<Claim.CareTeam> = Claim.CareTeam.serializer()

    public val careTeamSer: KSerializer<List<Claim.CareTeam>> =
      ListSerializer(Hoisted.careTeamSerInner)

    public val supportingInfoSerInner: KSerializer<Claim.SupportingInfo> =
      Claim.SupportingInfo.serializer()

    public val supportingInfoSer: KSerializer<List<Claim.SupportingInfo>> =
      ListSerializer(Hoisted.supportingInfoSerInner)

    public val diagnosisSerInner: KSerializer<Claim.Diagnosis> = Claim.Diagnosis.serializer()

    public val diagnosisSer: KSerializer<List<Claim.Diagnosis>> =
      ListSerializer(Hoisted.diagnosisSerInner)

    public val procedureSerInner: KSerializer<Claim.Procedure> = Claim.Procedure.serializer()

    public val procedureSer: KSerializer<List<Claim.Procedure>> =
      ListSerializer(Hoisted.procedureSerInner)

    public val insuranceSerInner: KSerializer<Claim.Insurance> = Claim.Insurance.serializer()

    public val insuranceSer: KSerializer<List<Claim.Insurance>> =
      ListSerializer(Hoisted.insuranceSerInner)

    public val accidentSer: KSerializer<Claim.Accident> = Claim.Accident.serializer()

    public val patientPaidSer: KSerializer<Money> = Money.serializer()

    public val itemSerInner: KSerializer<Claim.Item> = Claim.Item.serializer()

    public val itemSer: KSerializer<List<Claim.Item>> = ListSerializer(Hoisted.itemSerInner)
  }
}

internal object ClaimPolymorphicSerializer : KSerializer<Claim> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Claim") { ClaimSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Claim) {
    encoder.encodeStructure(descriptor) {
      ClaimSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Claim =
    decoder.decodeStructure(descriptor) {
      ClaimSerializer.deserializeInternal(this, descriptor, 0)
    }
}
