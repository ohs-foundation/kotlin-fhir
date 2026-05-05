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
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          function =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actorSer, null)
        5 ->
          onBehalfOf =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actorSer, null)
        6 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          action = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actionSer, null)
        4 ->
          manipulated =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.manipulatedSer, null)
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
      "instantiatesCanonical",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesUri",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("focus", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("occurrenceString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceString", Element.serializer().descriptor, isOptional = true)
    b.element("occurrenceAge", Age.serializer().descriptor, isOptional = true)
    b.element("occurrenceRange", Range.serializer().descriptor, isOptional = true)
    b.element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("recorded", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_recorded", Element.serializer().descriptor, isOptional = true)
    b.element("recorder", Reference.serializer().descriptor, isOptional = true)
    b.element("reportedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_reportedBoolean", Element.serializer().descriptor, isOptional = true)
    b.element("reportedReference", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(lazyDescriptor { Procedure.Performer.serializer().descriptor }),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "bodySite",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("outcome", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("report", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "complication",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "followUp",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "focalDevice",
      listSerialDescriptor(lazyDescriptor { Procedure.FocalDevice.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "used",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Procedure =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Procedure) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Procedure")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Procedure {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        15 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        16 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        17 -> status = decoder.decodeStringElement(__desc, __i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        20 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        21 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        22 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        23 ->
          focus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        24 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        25 -> occurrenceDateTime = decoder.decodeStringElement(__desc, __i)
        26 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        28 -> occurrenceString = decoder.decodeStringElement(__desc, __i)
        29 ->
          _occurrenceString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 ->
          occurrenceAge =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.occurrenceAgeSer, null)
        31 ->
          occurrenceRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.occurrenceRangeSer, null)
        32 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        33 -> recorded = decoder.decodeStringElement(__desc, __i)
        34 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        35 ->
          recorder =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        36 -> reportedBoolean = decoder.decodeBooleanElement(__desc, __i)
        37 ->
          _reportedBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        38 ->
          reportedReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        39 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerSer, null)
        40 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        41 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        42 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        43 ->
          outcome =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.statusReasonSer, null)
        44 ->
          report = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        45 ->
          complication =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        46 ->
          followUp =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        47 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        48 ->
          focalDevice =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.focalDeviceSer, null)
        49 -> used = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        50 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Procedure,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.statusReasonSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.categorySer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.statusReasonSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.focus)?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is Procedure.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 25 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Procedure.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          __desc,
          27 + __off,
          Hoisted.occurrencePeriodSer,
          __d.value,
        )
      }
      is Procedure.Occurrence.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Procedure.Occurrence.Age -> {
        encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.occurrenceAgeSer, __d.value)
      }
      is Procedure.Occurrence.Range -> {
        encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.occurrenceRangeSer, __d.value)
      }
      is Procedure.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          __desc,
          32 + __off,
          Hoisted.occurrenceTimingSer,
          __d.value,
        )
      }
    }
    ((value.recorded?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 33 + __off, it)
    }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.recorder)?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.reported) {
      null -> {}
      is Procedure.Reported.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 36 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is Procedure.Reported.Reference -> {
        encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.basedOnSerInner, __d.value)
      }
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.performerSer, value.performer)
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.reasonSer, value.reason)
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.categorySer, value.bodySite)
    (value.outcome)?.let {
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.statusReasonSer, it)
    }
    if (value.report.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.basedOnSer, value.report)
    if (value.complication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.reasonSer, value.complication)
    if (value.followUp.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.categorySer, value.followUp)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.noteSer, value.note)
    if (value.focalDevice.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        48 + __off,
        Hoisted.focalDeviceSer,
        value.focalDevice,
      )
    if (value.used.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.reasonSer, value.used)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        50 + __off,
        Hoisted.basedOnSer,
        value.supportingInfo,
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

internal object ProcedurePolymorphicSerializer : KSerializer<Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") { ProcedureSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Procedure) {
    encoder.encodeStructure(descriptor) {
      ProcedureSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Procedure =
    decoder.decodeStructure(descriptor) { ProcedureSerializer.deserializeJson(this, descriptor, 0) }
}
