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
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
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

internal object DeviceUsageSerializer : KSerializer<DeviceUsage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceUsage") {
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "derivedFrom",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("context", Reference.serializer().descriptor, isOptional = true)
    b.element("timingTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("timingPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("timingDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("dateAsserted", String.serializer().descriptor, isOptional = true)
    b.element("_dateAsserted", Element.serializer().descriptor, isOptional = true)
    b.element("usageStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "usageReason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "adherence",
      lazyDescriptor { DeviceUsage.Adherence.serializer().descriptor },
      isOptional = true,
    )
    b.element("informationSource", Reference.serializer().descriptor, isOptional = true)
    b.element("device", CodeableReference.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("bodySite", CodeableReference.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): DeviceUsage =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: DeviceUsage) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DeviceUsage")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): DeviceUsage {
    val __desc = desc
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
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        12 -> status = decoder.decodeStringElement(__desc, __i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        16 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        17 ->
          context =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        18 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.timingTimingSer, null)
        19 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.timingPeriodSer, null)
        20 -> timingDateTime = decoder.decodeStringElement(__desc, __i)
        21 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> dateAsserted = decoder.decodeStringElement(__desc, __i)
        23 ->
          _dateAsserted =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 ->
          usageStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        25 ->
          usageReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        26 ->
          adherence =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.adherenceSer, null)
        27 ->
          informationSource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        28 ->
          device = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.deviceSer, null)
        29 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        30 ->
          bodySite = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.deviceSer, null)
        31 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: DeviceUsage,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.basedOnSer, value.basedOn)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.categorySer, value.category)
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.basedOnSer, value.derivedFrom)
    (value.context)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.timing) {
      null -> {}
      is DeviceUsage.Timing.Timing -> {
        encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.timingTimingSer, __d.value)
      }
      is DeviceUsage.Timing.Period -> {
        encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.timingPeriodSer, __d.value)
      }
      is DeviceUsage.Timing.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.dateAsserted?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 22 + __off, it)
    }
    (value.dateAsserted?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.usageStatus)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.categorySerInner, it)
    }
    if (value.usageReason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.categorySer, value.usageReason)
    (value.adherence)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.adherenceSer, it)
    }
    (value.informationSource)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.deviceSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.reasonSer, value.reason)
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.deviceSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.noteSer, value.note)
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

internal object DeviceUsagePolymorphicSerializer : KSerializer<DeviceUsage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceUsage") { DeviceUsageSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: DeviceUsage) {
    encoder.encodeStructure(descriptor) {
      DeviceUsageSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DeviceUsage =
    decoder.decodeStructure(descriptor) {
      DeviceUsageSerializer.deserializeJson(this, descriptor, 0)
    }
}
