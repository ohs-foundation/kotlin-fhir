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
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object EncounterStatusHistorySerializer : KSerializer<Encounter.StatusHistory> {
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

  override fun deserialize(decoder: Decoder): Encounter.StatusHistory =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.StatusHistory) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Encounter.StatusHistory {
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
    return Encounter.StatusHistory(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status = Enumeration.of(Encounter.EncounterStatus.fromCode(status!!), _status),
      period = period!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Encounter.StatusHistory) {
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
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.periodSer, value.period)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val statusSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object EncounterClassHistorySerializer : KSerializer<Encounter.ClassHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClassHistory") {
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
      element("class", Coding.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Encounter.ClassHistory =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.ClassHistory) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Encounter.ClassHistory {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `class`: Coding? = null
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
          `class` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classSer, null)
        4 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ClassHistory: " + i)
      }
    }
    return Encounter.ClassHistory(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `class` = `class`!!,
      period = period!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Encounter.ClassHistory) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.classSer, value.`class`)
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.periodSer, value.period)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val classSer: KSerializer<Coding> = Coding.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object EncounterParticipantSerializer : KSerializer<Encounter.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
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
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
      element("individual", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Encounter.Participant =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Encounter.Participant {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var period: Period? = null
    var individual: Reference? = null
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
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        5 ->
          individual =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.individualSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    return Encounter.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: listOf(),
      period = period,
      individual = individual,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Encounter.Participant) {
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
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.periodSer, it) }
    (value.individual)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.individualSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val individualSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object EncounterDiagnosisSerializer : KSerializer<Encounter.Diagnosis> {
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
      element("condition", Reference.serializer().descriptor, isOptional = true)
      element("use", CodeableConcept.serializer().descriptor, isOptional = true)
      element("rank", Int.serializer().descriptor, isOptional = true)
      element("_rank", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Encounter.Diagnosis =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Diagnosis) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Encounter.Diagnosis {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var condition: Reference? = null
    var use: CodeableConcept? = null
    var rank: Int? = null
    var _rank: Element? = null
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
        5 -> rank = decoder.decodeIntElement(descriptor, i)
        6 -> _rank = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rankSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
      }
    }
    return Encounter.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      condition = condition!!,
      use = use,
      rank = PositiveInt.of(rank, _rank),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Encounter.Diagnosis) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.conditionSer, value.condition)
    (value.use)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.useSer, it) }
    ((value.rank?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.rank?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.rankSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val conditionSer: KSerializer<Reference> = Reference.serializer()

    public val useSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val rankSer: KSerializer<Element> = Element.serializer()
  }
}

internal object EncounterHospitalizationSerializer : KSerializer<Encounter.Hospitalization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Hospitalization") {
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
      element("preAdmissionIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("origin", Reference.serializer().descriptor, isOptional = true)
      element("admitSource", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reAdmission", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "dietPreference",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialCourtesy",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialArrangement",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("destination", Reference.serializer().descriptor, isOptional = true)
      element("dischargeDisposition", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Encounter.Hospitalization =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Hospitalization) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Encounter.Hospitalization {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var preAdmissionIdentifier: Identifier? = null
    var origin: Reference? = null
    var admitSource: CodeableConcept? = null
    var reAdmission: CodeableConcept? = null
    var dietPreference: List<CodeableConcept>? = null
    var specialCourtesy: List<CodeableConcept>? = null
    var specialArrangement: List<CodeableConcept>? = null
    var destination: Reference? = null
    var dischargeDisposition: CodeableConcept? = null
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
          preAdmissionIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.preAdmissionIdentifierSer,
              null,
            )
        4 ->
          origin = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.originSer, null)
        5 ->
          admitSource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.admitSourceSer, null)
        6 ->
          reAdmission =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.admitSourceSer, null)
        7 ->
          dietPreference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dietPreferenceSer,
              null,
            )
        8 ->
          specialCourtesy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dietPreferenceSer,
              null,
            )
        9 ->
          specialArrangement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dietPreferenceSer,
              null,
            )
        10 ->
          destination =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.originSer, null)
        11 ->
          dischargeDisposition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.admitSourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Hospitalization: " + i)
      }
    }
    return Encounter.Hospitalization(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      preAdmissionIdentifier = preAdmissionIdentifier,
      origin = origin,
      admitSource = admitSource,
      reAdmission = reAdmission,
      dietPreference = dietPreference ?: listOf(),
      specialCourtesy = specialCourtesy ?: listOf(),
      specialArrangement = specialArrangement ?: listOf(),
      destination = destination,
      dischargeDisposition = dischargeDisposition,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Encounter.Hospitalization) {
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
    (value.preAdmissionIdentifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.preAdmissionIdentifierSer, it)
    }
    (value.origin)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.originSer, it) }
    (value.admitSource)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.admitSourceSer, it)
    }
    (value.reAdmission)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.admitSourceSer, it)
    }
    if (value.dietPreference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        Hoisted.dietPreferenceSer,
        value.dietPreference,
      )
    if (value.specialCourtesy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        Hoisted.dietPreferenceSer,
        value.specialCourtesy,
      )
    if (value.specialArrangement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        Hoisted.dietPreferenceSer,
        value.specialArrangement,
      )
    (value.destination)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.originSer, it)
    }
    (value.dischargeDisposition)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.admitSourceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val preAdmissionIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val originSer: KSerializer<Reference> = Reference.serializer()

    public val admitSourceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val dietPreferenceSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.admitSourceSer)
  }
}

internal object EncounterLocationSerializer : KSerializer<Encounter.Location> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Location") {
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
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("physicalType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Encounter.Location =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Location) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Encounter.Location {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var location: Reference? = null
    var status: String? = null
    var _status: Element? = null
    var physicalType: CodeableConcept? = null
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
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        4 -> status = decoder.decodeStringElement(descriptor, i)
        5 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        6 ->
          physicalType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.physicalTypeSer, null)
        7 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Location: " + i)
      }
    }
    return Encounter.Location(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      location = location!!,
      status =
        status?.let { Enumeration.of(Encounter.EncounterLocationStatus.fromCode(it), _status) },
      physicalType = physicalType,
      period = period,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Encounter.Location) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.locationSer, value.location)
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.statusSer, it)
    }
    (value.physicalType)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.physicalTypeSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val locationSer: KSerializer<Reference> = Reference.serializer()

    public val statusSer: KSerializer<Element> = Element.serializer()

    public val physicalTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object EncounterSerializer : KSerializer<Encounter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Encounter") {
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
      listSerialDescriptor(lazyDescriptor { Encounter.StatusHistory.serializer().descriptor }),
      isOptional = true,
    )
    b.element("class", Coding.serializer().descriptor, isOptional = true)
    b.element(
      "classHistory",
      listSerialDescriptor(lazyDescriptor { Encounter.ClassHistory.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "type",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("serviceType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "episodeOfCare",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "participant",
      listSerialDescriptor(lazyDescriptor { Encounter.Participant.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "appointment",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("length", Duration.serializer().descriptor, isOptional = true)
    b.element(
      "reasonCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reasonReference",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "diagnosis",
      listSerialDescriptor(lazyDescriptor { Encounter.Diagnosis.serializer().descriptor }),
      isOptional = true,
    )
    b.element("account", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "hospitalization",
      lazyDescriptor { Encounter.Hospitalization.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "location",
      listSerialDescriptor(lazyDescriptor { Encounter.Location.serializer().descriptor }),
      isOptional = true,
    )
    b.element("serviceProvider", Reference.serializer().descriptor, isOptional = true)
    b.element("partOf", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Encounter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Encounter) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Encounter")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Encounter {
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
    var statusHistory: List<Encounter.StatusHistory>? = null
    var `class`: Coding? = null
    var classHistory: List<Encounter.ClassHistory>? = null
    var type: List<CodeableConcept>? = null
    var serviceType: CodeableConcept? = null
    var priority: CodeableConcept? = null
    var subject: Reference? = null
    var episodeOfCare: List<Reference>? = null
    var basedOn: List<Reference>? = null
    var participant: List<Encounter.Participant>? = null
    var appointment: List<Reference>? = null
    var period: Period? = null
    var length: Duration? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var diagnosis: List<Encounter.Diagnosis>? = null
    var account: List<Reference>? = null
    var hospitalization: Encounter.Hospitalization? = null
    var location: List<Encounter.Location>? = null
    var serviceProvider: Reference? = null
    var partOf: Reference? = null
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
        14 ->
          `class` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classSer, null)
        15 ->
          classHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classHistorySer, null)
        16 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        17 ->
          serviceType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSerInner, null)
        18 ->
          priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSerInner, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        20 ->
          episodeOfCare =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.episodeOfCareSer, null)
        21 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.episodeOfCareSer, null)
        22 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        23 ->
          appointment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.episodeOfCareSer, null)
        24 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        25 ->
          length = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.lengthSer, null)
        26 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        27 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.episodeOfCareSer, null)
        28 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.diagnosisSer, null)
        29 ->
          account =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.episodeOfCareSer, null)
        30 ->
          hospitalization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.hospitalizationSer,
              null,
            )
        31 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        32 ->
          serviceProvider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        33 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        else -> throw SerializationException("Unexpected index decoding Encounter: " + i)
      }
    }
    return Encounter(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(Encounter.EncounterStatus.fromCode(status!!), _status),
      statusHistory = statusHistory ?: listOf(),
      `class` = `class`!!,
      classHistory = classHistory ?: listOf(),
      type = type ?: listOf(),
      serviceType = serviceType,
      priority = priority,
      subject = subject,
      episodeOfCare = episodeOfCare ?: listOf(),
      basedOn = basedOn ?: listOf(),
      participant = participant ?: listOf(),
      appointment = appointment ?: listOf(),
      period = period,
      length = length,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      account = account ?: listOf(),
      hospitalization = hospitalization,
      location = location ?: listOf(),
      serviceProvider = serviceProvider,
      partOf = partOf,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Encounter,
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
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      Hoisted.classSer,
      value.`class`,
    )
    if (value.classHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.classHistorySer,
        value.classHistory,
      )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.typeSer,
        value.type,
      )
    (value.serviceType)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.typeSerInner, it)
    }
    (value.priority)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.typeSerInner, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.episodeOfCare.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.episodeOfCareSer,
        value.episodeOfCare,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.episodeOfCareSer,
        value.basedOn,
      )
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.participantSer,
        value.participant,
      )
    if (value.appointment.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.episodeOfCareSer,
        value.appointment,
      )
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.periodSer, it)
    }
    (value.length)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.lengthSer, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.typeSer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.episodeOfCareSer,
        value.reasonReference,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.diagnosisSer,
        value.diagnosis,
      )
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.episodeOfCareSer,
        value.account,
      )
    (value.hospitalization)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.hospitalizationSer,
        it,
      )
    }
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.locationSer,
        value.location,
      )
    (value.serviceProvider)?.let {
      encoder.encodeSerializableElement(descriptor, 32 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.partOf)?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, Hoisted.subjectSer, it)
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

    public val statusHistorySerInner: KSerializer<Encounter.StatusHistory> =
      Encounter.StatusHistory.serializer()

    public val statusHistorySer: KSerializer<List<Encounter.StatusHistory>> =
      ListSerializer(Hoisted.statusHistorySerInner)

    public val classSer: KSerializer<Coding> = Coding.serializer()

    public val classHistorySerInner: KSerializer<Encounter.ClassHistory> =
      Encounter.ClassHistory.serializer()

    public val classHistorySer: KSerializer<List<Encounter.ClassHistory>> =
      ListSerializer(Hoisted.classHistorySerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val episodeOfCareSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val participantSerInner: KSerializer<Encounter.Participant> =
      Encounter.Participant.serializer()

    public val participantSer: KSerializer<List<Encounter.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val lengthSer: KSerializer<Duration> = Duration.serializer()

    public val diagnosisSerInner: KSerializer<Encounter.Diagnosis> =
      Encounter.Diagnosis.serializer()

    public val diagnosisSer: KSerializer<List<Encounter.Diagnosis>> =
      ListSerializer(Hoisted.diagnosisSerInner)

    public val hospitalizationSer: KSerializer<Encounter.Hospitalization> =
      Encounter.Hospitalization.serializer()

    public val locationSerInner: KSerializer<Encounter.Location> = Encounter.Location.serializer()

    public val locationSer: KSerializer<List<Encounter.Location>> =
      ListSerializer(Hoisted.locationSerInner)
  }
}

internal object EncounterPolymorphicSerializer : KSerializer<Encounter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Encounter") { EncounterSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter) {
    encoder.encodeStructure(descriptor) {
      EncounterSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Encounter =
    decoder.decodeStructure(descriptor) {
      EncounterSerializer.deserializeInternal(this, descriptor, 0)
    }
}
