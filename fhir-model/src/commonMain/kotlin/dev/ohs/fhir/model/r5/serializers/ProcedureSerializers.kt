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

import dev.ohs.fhir.model.r5.Age
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Procedure
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object ProcedurePerformerSerializer : KSerializer<Procedure.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
      element("onBehalfOf", Reference.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Procedure.Performer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Procedure.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Procedure.Performer {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
    var onBehalfOf: Reference? = null
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
          function = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        5 ->
          onBehalfOf = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.actorSer, null)
        6 -> period = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + __i)
      }
    }
    return Procedure.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
      onBehalfOf = onBehalfOf,
      period = period,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Procedure.Performer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.functionSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
    (value.onBehalfOf)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.actorSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object ProcedureFocalDeviceSerializer : KSerializer<Procedure.FocalDevice> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("FocalDevice") {
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
      element("action", CodeableConcept.serializer().descriptor, isOptional = true)
      element("manipulated", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Procedure.FocalDevice =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Procedure.FocalDevice) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Procedure.FocalDevice {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: CodeableConcept? = null
    var manipulated: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> action = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.actionSer, null)
        4 ->
          manipulated =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.manipulatedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding FocalDevice: " + __i)
      }
    }
    return Procedure.FocalDevice(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action,
      manipulated = manipulated!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Procedure.FocalDevice) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.action)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.actionSer, it) }
    (value.manipulated)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.manipulatedSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val manipulatedSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ProcedureSerializer : KSerializer<Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
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
        "instantiatesCanonical",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesCanonical",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesUri",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("focus", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurrenceString", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceString", Element.serializer().descriptor, isOptional = true)
      element("occurrenceAge", Age.serializer().descriptor, isOptional = true)
      element("occurrenceRange", Range.serializer().descriptor, isOptional = true)
      element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
      element("recorded", KotlinString.serializer().descriptor, isOptional = true)
      element("_recorded", Element.serializer().descriptor, isOptional = true)
      element("recorder", Reference.serializer().descriptor, isOptional = true)
      element("reportedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_reportedBoolean", Element.serializer().descriptor, isOptional = true)
      element("reportedReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(lazyDescriptor { Procedure.Performer.serializer().descriptor }),
        isOptional = true,
      )
      element("location", Reference.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "bodySite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("outcome", CodeableConcept.serializer().descriptor, isOptional = true)
      element("report", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "complication",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "followUp",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "focalDevice",
        listSerialDescriptor(lazyDescriptor { Procedure.FocalDevice.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "used",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "supportingInfo",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Procedure =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Procedure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Procedure {
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
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var focus: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceString: KotlinString? = null
    var _occurrenceString: Element? = null
    var occurrenceAge: Age? = null
    var occurrenceRange: Range? = null
    var occurrenceTiming: Timing? = null
    var recorded: KotlinString? = null
    var _recorded: Element? = null
    var recorder: Reference? = null
    var reportedBoolean: KotlinBoolean? = null
    var _reportedBoolean: Element? = null
    var reportedReference: Reference? = null
    var performer: List<Procedure.Performer>? = null
    var location: Reference? = null
    var reason: List<CodeableReference>? = null
    var bodySite: List<CodeableConcept>? = null
    var outcome: CodeableConcept? = null
    var report: List<Reference>? = null
    var complication: List<CodeableReference>? = null
    var followUp: List<CodeableConcept>? = null
    var note: List<Annotation>? = null
    var focalDevice: List<Procedure.FocalDevice>? = null
    var used: List<CodeableReference>? = null
    var supportingInfo: List<Reference>? = null
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
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        13 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        14 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        15 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        16 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSer, null)
        17 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSer, null)
        18 -> status = decoder.decodeStringElement(__desc, 18)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.statusReasonSer, null)
        21 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.categorySer, null)
        22 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.statusReasonSer, null)
        23 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.basedOnSerInner, null)
        24 ->
          focus =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.basedOnSerInner, null)
        25 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.basedOnSerInner, null)
        26 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 26)
        27 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.occurrencePeriodSer, null)
        29 -> occurrenceString = decoder.decodeStringElement(__desc, 29)
        30 ->
          _occurrenceString =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          occurrenceAge =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.occurrenceAgeSer, null)
        32 ->
          occurrenceRange =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.occurrenceRangeSer, null)
        33 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.occurrenceTimingSer, null)
        34 -> recorded = decoder.decodeStringElement(__desc, 34)
        35 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 ->
          recorder =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.basedOnSerInner, null)
        37 -> reportedBoolean = decoder.decodeBooleanElement(__desc, 37)
        38 ->
          _reportedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 ->
          reportedReference =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.basedOnSerInner, null)
        40 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.performerSer, null)
        41 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.basedOnSerInner, null)
        42 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.reasonSer, null)
        43 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.categorySer, null)
        44 ->
          outcome =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.statusReasonSer, null)
        45 ->
          report = decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.basedOnSer, null)
        46 ->
          complication =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.reasonSer, null)
        47 ->
          followUp =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.categorySer, null)
        48 -> note = decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.noteSer, null)
        49 ->
          focalDevice =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.focalDeviceSer, null)
        50 -> used = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.reasonSer, null)
        51 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.basedOnSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + __i)
      }
    }
    return Procedure(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { __i ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(__i)?.let { it },
            _instantiatesCanonical?.getOrNull(__i),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          __i ->
          Uri.of(instantiatesUri?.getOrNull(__i)?.let { it }, _instantiatesUri?.getOrNull(__i))!!
        }),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      status = Enumeration.of(Procedure.EventStatus.fromCode(status!!), _status),
      statusReason = statusReason,
      category = category ?: listOf(),
      code = code,
      subject = subject!!,
      focus = focus,
      encounter = encounter,
      occurrence =
        Procedure.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
          R5String.of(occurrenceString, _occurrenceString),
          occurrenceAge,
          occurrenceRange,
          occurrenceTiming,
        ),
      recorded = DateTime.of(FhirDateTime.fromString(recorded), _recorded),
      recorder = recorder,
      reported =
        Procedure.Reported.from(R5Boolean.of(reportedBoolean, _reportedBoolean), reportedReference),
      performer = performer ?: listOf(),
      location = location,
      reason = reason ?: listOf(),
      bodySite = bodySite ?: listOf(),
      outcome = outcome,
      report = report ?: listOf(),
      complication = complication ?: listOf(),
      followUp = followUp ?: listOf(),
      note = note ?: listOf(),
      focalDevice = focalDevice ?: listOf(),
      used = used ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Procedure) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Procedure")
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
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.statusReasonSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.categorySer, value.category)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.statusReasonSer, it) }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.basedOnSerInner, it)
    }
    (value.focus)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is Procedure.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
        }
      }
      is Procedure.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 28, Hoisted.occurrencePeriodSer, __d.value)
      }
      is Procedure.Occurrence.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
        }
      }
      is Procedure.Occurrence.Age -> {
        encoder.encodeSerializableElement(__desc, 31, Hoisted.occurrenceAgeSer, __d.value)
      }
      is Procedure.Occurrence.Range -> {
        encoder.encodeSerializableElement(__desc, 32, Hoisted.occurrenceRangeSer, __d.value)
      }
      is Procedure.Occurrence.Timing -> {
        encoder.encodeSerializableElement(__desc, 33, Hoisted.occurrenceTimingSer, __d.value)
      }
    }
    ((value.recorded?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    (value.recorder)?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.reported) {
      null -> {}
      is Procedure.Reported.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 37, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
        }
      }
      is Procedure.Reported.Reference -> {
        encoder.encodeSerializableElement(__desc, 39, Hoisted.basedOnSerInner, __d.value)
      }
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.performerSer, value.performer)
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.basedOnSerInner, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.reasonSer, value.reason)
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.categorySer, value.bodySite)
    (value.outcome)?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.statusReasonSer, it)
    }
    if (value.report.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.basedOnSer, value.report)
    if (value.complication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.reasonSer, value.complication)
    if (value.followUp.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.categorySer, value.followUp)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.noteSer, value.note)
    if (value.focalDevice.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.focalDeviceSer, value.focalDevice)
    if (value.used.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.reasonSer, value.used)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.basedOnSer, value.supportingInfo)
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

    public val instantiatesCanonicalSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceAgeSer: KSerializer<Age> = Age.serializer()

    public val occurrenceRangeSer: KSerializer<Range> = Range.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()

    public val performerSerInner: KSerializer<Procedure.Performer> =
      Procedure.Performer.serializer()

    public val performerSer: KSerializer<List<Procedure.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val focalDeviceSerInner: KSerializer<Procedure.FocalDevice> =
      Procedure.FocalDevice.serializer()

    public val focalDeviceSer: KSerializer<List<Procedure.FocalDevice>> =
      ListSerializer(Hoisted.focalDeviceSerInner)
  }
}
