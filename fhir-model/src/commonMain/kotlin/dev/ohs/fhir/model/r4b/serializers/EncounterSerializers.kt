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
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter.StatusHistory) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Encounter.StatusHistory {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var status: String? = null
    var _status: Element? = null
    var period: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> status = decoder.decodeStringElement(__desc, 3)
        4 -> _status = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.statusSer, null)
        5 -> period = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StatusHistory: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.StatusHistory) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.statusSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.periodSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter.ClassHistory) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Encounter.ClassHistory {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `class`: Coding? = null
    var period: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> `class` = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.classSer, null)
        4 -> period = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ClassHistory: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.ClassHistory) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.`class`)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.classSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.periodSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Encounter.Participant {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var period: Period? = null
    var individual: Reference? = null
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
        4 -> period = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.periodSer, null)
        5 ->
          individual =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.individualSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, value.type)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.periodSer, it) }
    (value.individual)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.individualSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter.Diagnosis) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Encounter.Diagnosis {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var condition: Reference? = null
    var use: CodeableConcept? = null
    var rank: Int? = null
    var _rank: Element? = null
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
          condition =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.conditionSer, null)
        4 -> use = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.useSer, null)
        5 -> rank = decoder.decodeIntElement(__desc, 5)
        6 -> _rank = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.rankSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.Diagnosis) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.condition)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.conditionSer, it)
    }
    (value.use)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.useSer, it) }
    ((value.rank?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.rank?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.rankSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter.Hospitalization) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Encounter.Hospitalization {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          preAdmissionIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.preAdmissionIdentifierSer,
              null,
            )
        4 -> origin = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.originSer, null)
        5 ->
          admitSource =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.admitSourceSer, null)
        6 ->
          reAdmission =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.admitSourceSer, null)
        7 ->
          dietPreference =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.dietPreferenceSer, null)
        8 ->
          specialCourtesy =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.dietPreferenceSer, null)
        9 ->
          specialArrangement =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.dietPreferenceSer, null)
        10 ->
          destination =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.originSer, null)
        11 ->
          dischargeDisposition =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.admitSourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Hospitalization: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.Hospitalization) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.preAdmissionIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.preAdmissionIdentifierSer, it)
    }
    (value.origin)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.originSer, it) }
    (value.admitSource)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.admitSourceSer, it)
    }
    (value.reAdmission)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.admitSourceSer, it)
    }
    if (value.dietPreference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.dietPreferenceSer, value.dietPreference)
    if (value.specialCourtesy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.dietPreferenceSer, value.specialCourtesy)
    if (value.specialArrangement.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9,
        Hoisted.dietPreferenceSer,
        value.specialArrangement,
      )
    (value.destination)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.originSer, it)
    }
    (value.dischargeDisposition)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.admitSourceSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter.Location) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Encounter.Location {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var location: Reference? = null
    var status: String? = null
    var _status: Element? = null
    var physicalType: CodeableConcept? = null
    var period: Period? = null
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
          location = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.locationSer, null)
        4 -> status = decoder.decodeStringElement(__desc, 4)
        5 -> _status = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.statusSer, null)
        6 ->
          physicalType =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.physicalTypeSer, null)
        7 -> period = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Location: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.Location) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.locationSer, it) }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.statusSer, it)
    }
    (value.physicalType)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.physicalTypeSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.periodSer, it) }
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
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
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
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "statusHistory",
        listSerialDescriptor(lazyDescriptor { Encounter.StatusHistory.serializer().descriptor }),
        isOptional = true,
      )
      element("class", Coding.serializer().descriptor, isOptional = true)
      element(
        "classHistory",
        listSerialDescriptor(lazyDescriptor { Encounter.ClassHistory.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("serviceType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element(
        "episodeOfCare",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "participant",
        listSerialDescriptor(lazyDescriptor { Encounter.Participant.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "appointment",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
      element("length", Duration.serializer().descriptor, isOptional = true)
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "diagnosis",
        listSerialDescriptor(lazyDescriptor { Encounter.Diagnosis.serializer().descriptor }),
        isOptional = true,
      )
      element("account", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "hospitalization",
        lazyDescriptor { Encounter.Hospitalization.serializer().descriptor },
        isOptional = true,
      )
      element(
        "location",
        listSerialDescriptor(lazyDescriptor { Encounter.Location.serializer().descriptor }),
        isOptional = true,
      )
      element("serviceProvider", Reference.serializer().descriptor, isOptional = true)
      element("partOf", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Encounter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Encounter {
    val __desc = descriptor
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
        14 ->
          statusHistory =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.statusHistorySer, null)
        15 ->
          `class` = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.classSer, null)
        16 ->
          classHistory =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.classHistorySer, null)
        17 -> type = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.typeSer, null)
        18 ->
          serviceType =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.typeSerInner, null)
        19 ->
          priority =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.typeSerInner, null)
        20 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.subjectSer, null)
        21 ->
          episodeOfCare =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.episodeOfCareSer, null)
        22 ->
          basedOn =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.episodeOfCareSer, null)
        23 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.participantSer, null)
        24 ->
          appointment =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.episodeOfCareSer, null)
        25 ->
          period = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.periodSer, null)
        26 ->
          length = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.lengthSer, null)
        27 ->
          reasonCode = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.typeSer, null)
        28 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.episodeOfCareSer, null)
        29 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.diagnosisSer, null)
        30 ->
          account =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.episodeOfCareSer, null)
        31 ->
          hospitalization =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.hospitalizationSer, null)
        32 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.locationSer, null)
        33 ->
          serviceProvider =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.subjectSer, null)
        34 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.subjectSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Encounter: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Encounter")
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
    if (value.statusHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.statusHistorySer, value.statusHistory)
    (value.`class`)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.classSer, it) }
    if (value.classHistory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.classHistorySer, value.classHistory)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.typeSer, value.type)
    (value.serviceType)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.typeSerInner, it)
    }
    (value.priority)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.typeSerInner, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.subjectSer, it) }
    if (value.episodeOfCare.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.episodeOfCareSer, value.episodeOfCare)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.episodeOfCareSer, value.basedOn)
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.participantSer, value.participant)
    if (value.appointment.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.episodeOfCareSer, value.appointment)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.periodSer, it) }
    (value.length)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.lengthSer, it) }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.typeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.episodeOfCareSer, value.reasonReference)
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.diagnosisSer, value.diagnosis)
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.episodeOfCareSer, value.account)
    (value.hospitalization)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.hospitalizationSer, it)
    }
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.locationSer, value.location)
    (value.serviceProvider)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.subjectSer, it)
    }
    (value.partOf)?.let { encoder.encodeSerializableElement(__desc, 34, Hoisted.subjectSer, it) }
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
