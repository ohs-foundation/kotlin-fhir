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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.DeviceUseStatement
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
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

internal object DeviceUseStatementTimingSerializer : KSerializer<DeviceUseStatement.Timing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceUseStatement.Timing") {
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("timingDateTime", String.serializer().descriptor, isOptional = true)
      element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: DeviceUseStatement.Timing) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is DeviceUseStatement.Timing.Timing -> {
          encodeSerializableElement(__desc, 0, Hoisted.timingTimingSer, __d.value)
        }
        is DeviceUseStatement.Timing.Period -> {
          encodeSerializableElement(__desc, 1, Hoisted.timingPeriodSer, __d.value)
        }
        is DeviceUseStatement.Timing.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): DeviceUseStatement.Timing =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): DeviceUseStatement.Timing {
    val __desc = descriptor
    var timingTiming: Timing? = null
    var timingPeriod: Period? = null
    var timingDateTime: String? = null
    var _timingDateTime: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.timingTimingSer, null)
        1 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.timingPeriodSer, null)
        2 -> timingDateTime = decoder.decodeStringElement(__desc, 2)
        3 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding DeviceUseStatement.Timing: " + __i
          )
      }
    }
    return DeviceUseStatement.Timing.from(
      timingTiming,
      timingPeriod,
      DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
    )!!
  }

  private object Hoisted {
    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object DeviceUseStatementSerializer : KSerializer<DeviceUseStatement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceUseStatement") {
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
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element(
        "derivedFrom",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("timingDateTime", String.serializer().descriptor, isOptional = true)
      element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
      element("recordedOn", String.serializer().descriptor, isOptional = true)
      element("_recordedOn", Element.serializer().descriptor, isOptional = true)
      element("source", Reference.serializer().descriptor, isOptional = true)
      element("device", Reference.serializer().descriptor, isOptional = true)
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
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceUseStatement =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceUseStatement) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): DeviceUseStatement {
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
    var basedOn: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var subject: Reference? = null
    var derivedFrom: List<Reference>? = null
    var timingTiming: Timing? = null
    var timingPeriod: Period? = null
    var timingDateTime: String? = null
    var _timingDateTime: Element? = null
    var recordedOn: String? = null
    var _recordedOn: Element? = null
    var source: Reference? = null
    var device: Reference? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var bodySite: CodeableConcept? = null
    var note: List<Annotation>? = null
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
          basedOn = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.basedOnSerInner, null)
        16 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSer, null)
        17 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.timingTimingSer, null)
        18 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.timingPeriodSer, null)
        19 -> timingDateTime = decoder.decodeStringElement(__desc, 19)
        20 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> recordedOn = decoder.decodeStringElement(__desc, 21)
        22 ->
          _recordedOn =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          source =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.basedOnSerInner, null)
        24 ->
          device =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.basedOnSerInner, null)
        25 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.reasonCodeSer, null)
        26 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.basedOnSer, null)
        27 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.reasonCodeSerInner, null)
        28 -> note = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DeviceUseStatement: " + __i)
      }
    }
    return DeviceUseStatement(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      basedOn = basedOn ?: listOf(),
      status =
        Enumeration.of(DeviceUseStatement.DeviceUseStatementStatus.fromCode(status!!), _status),
      subject = subject!!,
      derivedFrom = derivedFrom ?: listOf(),
      timing =
        DeviceUseStatement.Timing.from(
          timingTiming,
          timingPeriod,
          DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
        ),
      recordedOn = DateTime.of(FhirDateTime.fromString(recordedOn), _recordedOn),
      source = source,
      device = device!!,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      bodySite = bodySite,
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceUseStatement) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "DeviceUseStatement")
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.basedOnSer, value.basedOn)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.basedOnSerInner, it)
    }
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSer, value.derivedFrom)
    when (val __d = value.timing) {
      null -> {}
      is DeviceUseStatement.Timing.Timing -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.timingTimingSer, __d.value)
      }
      is DeviceUseStatement.Timing.Period -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.timingPeriodSer, __d.value)
      }
      is DeviceUseStatement.Timing.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.recordedOn?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.recordedOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.source)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.basedOnSerInner, it)
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.basedOnSerInner, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.reasonCodeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.basedOnSer, value.reasonReference)
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.reasonCodeSerInner, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.noteSer, value.note)
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val reasonCodeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonCodeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.reasonCodeSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
