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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VirtualServiceDetail
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
      element("actor", Reference.serializer().descriptor, isOptional = true)
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
    var actor: Reference? = null
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
        5 -> actor = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.actorSer, null)
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
      actor = actor,
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
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object EncounterReasonSerializer : KSerializer<Encounter.Reason> {
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
      element(
        "use",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "value",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Encounter.Reason =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter.Reason) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Encounter.Reason {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var use: List<CodeableConcept>? = null
    var `value`: List<CodeableReference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> use = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.useSer, null)
        4 -> `value` = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reason: " + __i)
      }
    }
    return Encounter.Reason(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      use = use ?: listOf(),
      `value` = `value` ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.Reason) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.use.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.useSer, value.use)
    if (value.`value`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.valueSer, value.`value`)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val useSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val useSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.useSerInner)

    public val valueSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val valueSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.valueSerInner)
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
      element(
        "condition",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "use",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
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
    var condition: List<CodeableReference>? = null
    var use: List<CodeableConcept>? = null
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + __i)
      }
    }
    return Encounter.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      condition = condition ?: listOf(),
      use = use ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.Diagnosis) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.conditionSer, value.condition)
    if (value.use.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.useSer, value.use)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val conditionSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val conditionSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.conditionSerInner)

    public val useSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val useSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.useSerInner)
  }
}

internal object EncounterAdmissionSerializer : KSerializer<Encounter.Admission> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Admission") {
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
      element("destination", Reference.serializer().descriptor, isOptional = true)
      element("dischargeDisposition", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Encounter.Admission =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Encounter.Admission) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Encounter.Admission {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var preAdmissionIdentifier: Identifier? = null
    var origin: Reference? = null
    var admitSource: CodeableConcept? = null
    var reAdmission: CodeableConcept? = null
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
          destination =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.originSer, null)
        8 ->
          dischargeDisposition =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.admitSourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Admission: " + __i)
      }
    }
    return Encounter.Admission(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      preAdmissionIdentifier = preAdmissionIdentifier,
      origin = origin,
      admitSource = admitSource,
      reAdmission = reAdmission,
      destination = destination,
      dischargeDisposition = dischargeDisposition,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Encounter.Admission) {
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
    (value.destination)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.originSer, it) }
    (value.dischargeDisposition)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.admitSourceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val preAdmissionIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val originSer: KSerializer<Reference> = Reference.serializer()

    public val admitSourceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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
      element("form", CodeableConcept.serializer().descriptor, isOptional = true)
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
    var form: CodeableConcept? = null
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
        6 -> form = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.formSer, null)
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
      form = form,
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
    (value.form)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.formSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val locationSer: KSerializer<Reference> = Reference.serializer()

    public val statusSer: KSerializer<Element> = Element.serializer()

    public val formSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

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
        "class",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "serviceType",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("subjectStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "episodeOfCare",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "careTeam",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("partOf", Reference.serializer().descriptor, isOptional = true)
      element("serviceProvider", Reference.serializer().descriptor, isOptional = true)
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
      element(
        "virtualService",
        listSerialDescriptor(VirtualServiceDetail.serializer().descriptor),
        isOptional = true,
      )
      element("actualPeriod", Period.serializer().descriptor, isOptional = true)
      element("plannedStartDate", String.serializer().descriptor, isOptional = true)
      element("_plannedStartDate", Element.serializer().descriptor, isOptional = true)
      element("plannedEndDate", String.serializer().descriptor, isOptional = true)
      element("_plannedEndDate", Element.serializer().descriptor, isOptional = true)
      element("length", Duration.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(lazyDescriptor { Encounter.Reason.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "diagnosis",
        listSerialDescriptor(lazyDescriptor { Encounter.Diagnosis.serializer().descriptor }),
        isOptional = true,
      )
      element("account", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "dietPreference",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialArrangement",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialCourtesy",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "admission",
        lazyDescriptor { Encounter.Admission.serializer().descriptor },
        isOptional = true,
      )
      element(
        "location",
        listSerialDescriptor(lazyDescriptor { Encounter.Location.serializer().descriptor }),
        isOptional = true,
      )
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
    var `class`: List<CodeableConcept>? = null
    var priority: CodeableConcept? = null
    var type: List<CodeableConcept>? = null
    var serviceType: List<CodeableReference>? = null
    var subject: Reference? = null
    var subjectStatus: CodeableConcept? = null
    var episodeOfCare: List<Reference>? = null
    var basedOn: List<Reference>? = null
    var careTeam: List<Reference>? = null
    var partOf: Reference? = null
    var serviceProvider: Reference? = null
    var participant: List<Encounter.Participant>? = null
    var appointment: List<Reference>? = null
    var virtualService: List<VirtualServiceDetail>? = null
    var actualPeriod: Period? = null
    var plannedStartDate: String? = null
    var _plannedStartDate: Element? = null
    var plannedEndDate: String? = null
    var _plannedEndDate: Element? = null
    var length: Duration? = null
    var reason: List<Encounter.Reason>? = null
    var diagnosis: List<Encounter.Diagnosis>? = null
    var account: List<Reference>? = null
    var dietPreference: List<CodeableConcept>? = null
    var specialArrangement: List<CodeableConcept>? = null
    var specialCourtesy: List<CodeableConcept>? = null
    var admission: Encounter.Admission? = null
    var location: List<Encounter.Location>? = null
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
          `class` = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.classSer, null)
        15 ->
          priority =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.classSerInner, null)
        16 -> type = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.classSer, null)
        17 ->
          serviceType =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.serviceTypeSer, null)
        18 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 ->
          subjectStatus =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.classSerInner, null)
        20 ->
          episodeOfCare =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.episodeOfCareSer, null)
        21 ->
          basedOn =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.episodeOfCareSer, null)
        22 ->
          careTeam =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.episodeOfCareSer, null)
        23 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.subjectSer, null)
        24 ->
          serviceProvider =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.subjectSer, null)
        25 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.participantSer, null)
        26 ->
          appointment =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.episodeOfCareSer, null)
        27 ->
          virtualService =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.virtualServiceSer, null)
        28 ->
          actualPeriod =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.actualPeriodSer, null)
        29 -> plannedStartDate = decoder.decodeStringElement(__desc, 29)
        30 ->
          _plannedStartDate =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> plannedEndDate = decoder.decodeStringElement(__desc, 31)
        32 ->
          _plannedEndDate =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          length = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.lengthSer, null)
        34 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.reasonSer, null)
        35 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.diagnosisSer, null)
        36 ->
          account =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.episodeOfCareSer, null)
        37 ->
          dietPreference =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.classSer, null)
        38 ->
          specialArrangement =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.classSer, null)
        39 ->
          specialCourtesy =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.classSer, null)
        40 ->
          admission =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.admissionSer, null)
        41 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.locationSer, null)
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
      `class` = `class` ?: listOf(),
      priority = priority,
      type = type ?: listOf(),
      serviceType = serviceType ?: listOf(),
      subject = subject,
      subjectStatus = subjectStatus,
      episodeOfCare = episodeOfCare ?: listOf(),
      basedOn = basedOn ?: listOf(),
      careTeam = careTeam ?: listOf(),
      partOf = partOf,
      serviceProvider = serviceProvider,
      participant = participant ?: listOf(),
      appointment = appointment ?: listOf(),
      virtualService = virtualService ?: listOf(),
      actualPeriod = actualPeriod,
      plannedStartDate = DateTime.of(FhirDateTime.fromString(plannedStartDate), _plannedStartDate),
      plannedEndDate = DateTime.of(FhirDateTime.fromString(plannedEndDate), _plannedEndDate),
      length = length,
      reason = reason ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      account = account ?: listOf(),
      dietPreference = dietPreference ?: listOf(),
      specialArrangement = specialArrangement ?: listOf(),
      specialCourtesy = specialCourtesy ?: listOf(),
      admission = admission,
      location = location ?: listOf(),
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
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.classSer, value.`class`)
    (value.priority)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.classSerInner, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.classSer, value.type)
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.serviceTypeSer, value.serviceType)
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, it) }
    (value.subjectStatus)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.classSerInner, it)
    }
    if (value.episodeOfCare.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.episodeOfCareSer, value.episodeOfCare)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.episodeOfCareSer, value.basedOn)
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.episodeOfCareSer, value.careTeam)
    (value.partOf)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.subjectSer, it) }
    (value.serviceProvider)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.subjectSer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.participantSer, value.participant)
    if (value.appointment.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.episodeOfCareSer, value.appointment)
    if (value.virtualService.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.virtualServiceSer, value.virtualService)
    (value.actualPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.actualPeriodSer, it)
    }
    ((value.plannedStartDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 29, it)
    }
    (value.plannedStartDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    ((value.plannedEndDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.plannedEndDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    (value.length)?.let { encoder.encodeSerializableElement(__desc, 33, Hoisted.lengthSer, it) }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.reasonSer, value.reason)
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.diagnosisSer, value.diagnosis)
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.episodeOfCareSer, value.account)
    if (value.dietPreference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.classSer, value.dietPreference)
    if (value.specialArrangement.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.classSer, value.specialArrangement)
    if (value.specialCourtesy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.classSer, value.specialCourtesy)
    (value.admission)?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.admissionSer, it)
    }
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.locationSer, value.location)
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

    public val classSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.classSerInner)

    public val serviceTypeSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val serviceTypeSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.serviceTypeSerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val episodeOfCareSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val participantSerInner: KSerializer<Encounter.Participant> =
      Encounter.Participant.serializer()

    public val participantSer: KSerializer<List<Encounter.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val virtualServiceSerInner: KSerializer<VirtualServiceDetail> =
      VirtualServiceDetail.serializer()

    public val virtualServiceSer: KSerializer<List<VirtualServiceDetail>> =
      ListSerializer(Hoisted.virtualServiceSerInner)

    public val actualPeriodSer: KSerializer<Period> = Period.serializer()

    public val lengthSer: KSerializer<Duration> = Duration.serializer()

    public val reasonSerInner: KSerializer<Encounter.Reason> = Encounter.Reason.serializer()

    public val reasonSer: KSerializer<List<Encounter.Reason>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val diagnosisSerInner: KSerializer<Encounter.Diagnosis> =
      Encounter.Diagnosis.serializer()

    public val diagnosisSer: KSerializer<List<Encounter.Diagnosis>> =
      ListSerializer(Hoisted.diagnosisSerInner)

    public val admissionSer: KSerializer<Encounter.Admission> = Encounter.Admission.serializer()

    public val locationSerInner: KSerializer<Encounter.Location> = Encounter.Location.serializer()

    public val locationSer: KSerializer<List<Encounter.Location>> =
      ListSerializer(Hoisted.locationSerInner)
  }
}
