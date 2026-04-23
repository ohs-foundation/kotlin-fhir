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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.DeviceUsage
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
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

internal object DeviceUsageAdherenceSerializer : KSerializer<DeviceUsage.Adherence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Adherence") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DeviceUsage.Adherence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceUsage.Adherence) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DeviceUsage.Adherence {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> reason = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.reasonSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Adherence: " + __i)
      }
    }
    return DeviceUsage.Adherence(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      reason = reason ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceUsage.Adherence) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.reasonSer, value.reason)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSer)
  }
}

internal object DeviceUsageTimingSerializer : KSerializer<DeviceUsage.Timing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceUsage.Timing") {
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("timingDateTime", String.serializer().descriptor, isOptional = true)
      element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: DeviceUsage.Timing) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is DeviceUsage.Timing.Timing -> {
          encodeSerializableElement(__desc, 0, Hoisted.timingTimingSer, __d.value)
        }
        is DeviceUsage.Timing.Period -> {
          encodeSerializableElement(__desc, 1, Hoisted.timingPeriodSer, __d.value)
        }
        is DeviceUsage.Timing.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): DeviceUsage.Timing =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): DeviceUsage.Timing {
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
        else -> throw SerializationException("Unexpected index decoding DeviceUsage.Timing: " + __i)
      }
    }
    return DeviceUsage.Timing.from(
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

internal object DeviceUsageSerializer : KSerializer<DeviceUsage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceUsage") {
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
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element(
        "derivedFrom",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("context", Reference.serializer().descriptor, isOptional = true)
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("timingDateTime", String.serializer().descriptor, isOptional = true)
      element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
      element("dateAsserted", String.serializer().descriptor, isOptional = true)
      element("_dateAsserted", Element.serializer().descriptor, isOptional = true)
      element("usageStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "usageReason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "adherence",
        lazyDescriptor { DeviceUsage.Adherence.serializer().descriptor },
        isOptional = true,
      )
      element("informationSource", Reference.serializer().descriptor, isOptional = true)
      element("device", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("bodySite", CodeableReference.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceUsage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceUsage) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): DeviceUsage {
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
    var category: List<CodeableConcept>? = null
    var patient: Reference? = null
    var derivedFrom: List<Reference>? = null
    var context: Reference? = null
    var timingTiming: Timing? = null
    var timingPeriod: Period? = null
    var timingDateTime: String? = null
    var _timingDateTime: Element? = null
    var dateAsserted: String? = null
    var _dateAsserted: Element? = null
    var usageStatus: CodeableConcept? = null
    var usageReason: List<CodeableConcept>? = null
    var adherence: DeviceUsage.Adherence? = null
    var informationSource: Reference? = null
    var device: CodeableReference? = null
    var reason: List<CodeableReference>? = null
    var bodySite: CodeableReference? = null
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
          category =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSerInner, null)
        17 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSer, null)
        18 ->
          context =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.basedOnSerInner, null)
        19 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.timingTimingSer, null)
        20 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.timingPeriodSer, null)
        21 -> timingDateTime = decoder.decodeStringElement(__desc, 21)
        22 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> dateAsserted = decoder.decodeStringElement(__desc, 23)
        24 ->
          _dateAsserted =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          usageStatus =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.categorySerInner, null)
        26 ->
          usageReason =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.categorySer, null)
        27 ->
          adherence =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.adherenceSer, null)
        28 ->
          informationSource =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.basedOnSerInner, null)
        29 ->
          device = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.deviceSer, null)
        30 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.reasonSer, null)
        31 ->
          bodySite = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.deviceSer, null)
        32 -> note = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DeviceUsage: " + __i)
      }
    }
    return DeviceUsage(
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
      status = Enumeration.of(DeviceUsage.DeviceUsageStatus.fromCode(status!!), _status),
      category = category ?: listOf(),
      patient = patient!!,
      derivedFrom = derivedFrom ?: listOf(),
      context = context,
      timing =
        DeviceUsage.Timing.from(
          timingTiming,
          timingPeriod,
          DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
        ),
      dateAsserted = DateTime.of(FhirDateTime.fromString(dateAsserted), _dateAsserted),
      usageStatus = usageStatus,
      usageReason = usageReason ?: listOf(),
      adherence = adherence,
      informationSource = informationSource,
      device = device!!,
      reason = reason ?: listOf(),
      bodySite = bodySite,
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DeviceUsage) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "DeviceUsage")
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, value.category)
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSerInner, it)
    }
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSer, value.derivedFrom)
    (value.context)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.timing) {
      null -> {}
      is DeviceUsage.Timing.Timing -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.timingTimingSer, __d.value)
      }
      is DeviceUsage.Timing.Period -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.timingPeriodSer, __d.value)
      }
      is DeviceUsage.Timing.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.dateAsserted?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.dateAsserted?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    (value.usageStatus)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.categorySerInner, it)
    }
    if (value.usageReason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.categorySer, value.usageReason)
    (value.adherence)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.adherenceSer, it)
    }
    (value.informationSource)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.basedOnSerInner, it)
    }
    (value.device)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.deviceSer, it) }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.reasonSer, value.reason)
    (value.bodySite)?.let { encoder.encodeSerializableElement(__desc, 31, Hoisted.deviceSer, it) }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.noteSer, value.note)
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val adherenceSer: KSerializer<DeviceUsage.Adherence> = DeviceUsage.Adherence.serializer()

    public val deviceSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> = ListSerializer(Hoisted.deviceSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
