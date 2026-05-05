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
import dev.ohs.fhir.model.r5.EncounterHistory
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

internal object EncounterHistoryLocationSerializer : KSerializer<EncounterHistory.Location> {
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
      element("form", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EncounterHistory.Location =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EncounterHistory.Location) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EncounterHistory.Location {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var location: Reference? = null
    var form: CodeableConcept? = null
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
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        4 -> form = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.formSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Location: " + __i)
      }
    }
    return EncounterHistory.Location(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      location = location!!,
      form = form,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: EncounterHistory.Location) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.locationSer, it) }
    (value.form)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.formSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val locationSer: KSerializer<Reference> = Reference.serializer()

    public val formSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object EncounterHistorySerializer : KSerializer<EncounterHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EncounterHistory") {
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
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("class", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "type",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "serviceType",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("subjectStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("actualPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("plannedStartDate", String.serializer().descriptor, isOptional = true)
    b.element("_plannedStartDate", Element.serializer().descriptor, isOptional = true)
    b.element("plannedEndDate", String.serializer().descriptor, isOptional = true)
    b.element("_plannedEndDate", Element.serializer().descriptor, isOptional = true)
    b.element("length", Duration.serializer().descriptor, isOptional = true)
    b.element(
      "location",
      listSerialDescriptor(lazyDescriptor { EncounterHistory.Location.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): EncounterHistory =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: EncounterHistory) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "EncounterHistory")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): EncounterHistory {
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
    var encounter: Reference? = null
    var identifier: List<Identifier>? = null
    var status: String? = null
    var _status: Element? = null
    var `class`: CodeableConcept? = null
    var type: List<CodeableConcept>? = null
    var serviceType: List<CodeableReference>? = null
    var subject: Reference? = null
    var subjectStatus: CodeableConcept? = null
    var actualPeriod: Period? = null
    var plannedStartDate: String? = null
    var _plannedStartDate: Element? = null
    var plannedEndDate: String? = null
    var _plannedEndDate: Element? = null
    var length: Duration? = null
    var location: List<EncounterHistory.Location>? = null
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
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.encounterSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(__desc, __i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          `class` = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.classSer, null)
        15 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        16 ->
          serviceType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.serviceTypeSer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.encounterSer, null)
        18 ->
          subjectStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.classSer, null)
        19 ->
          actualPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actualPeriodSer, null)
        20 -> plannedStartDate = decoder.decodeStringElement(__desc, __i)
        21 ->
          _plannedStartDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> plannedEndDate = decoder.decodeStringElement(__desc, __i)
        23 ->
          _plannedEndDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 ->
          length = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lengthSer, null)
        25 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        else -> throw SerializationException("Unexpected index decoding EncounterHistory: " + __i)
      }
    }
    return EncounterHistory(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      encounter = encounter,
      identifier = identifier ?: listOf(),
      status = Enumeration.of(EncounterHistory.EncounterStatus.fromCode(status!!), _status),
      `class` = `class`!!,
      type = type ?: listOf(),
      serviceType = serviceType ?: listOf(),
      subject = subject,
      subjectStatus = subjectStatus,
      actualPeriod = actualPeriod,
      plannedStartDate = DateTime.of(FhirDateTime.fromString(plannedStartDate), _plannedStartDate),
      plannedEndDate = DateTime.of(FhirDateTime.fromString(plannedEndDate), _plannedEndDate),
      length = length,
      location = location ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: EncounterHistory,
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
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.encounterSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.`class`)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.classSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.typeSer, value.type)
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        16 + __off,
        Hoisted.serviceTypeSer,
        value.serviceType,
      )
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.encounterSer, it)
    }
    (value.subjectStatus)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.classSer, it)
    }
    (value.actualPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.actualPeriodSer, it)
    }
    ((value.plannedStartDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 20 + __off, it)
    }
    (value.plannedStartDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.plannedEndDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 22 + __off, it)
    }
    (value.plannedEndDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.length)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.lengthSer, it)
    }
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.locationSer, value.location)
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

    public val encounterSer: KSerializer<Reference> = Reference.serializer()

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val classSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.classSer)

    public val serviceTypeSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val serviceTypeSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.serviceTypeSerInner)

    public val actualPeriodSer: KSerializer<Period> = Period.serializer()

    public val lengthSer: KSerializer<Duration> = Duration.serializer()

    public val locationSerInner: KSerializer<EncounterHistory.Location> =
      EncounterHistory.Location.serializer()

    public val locationSer: KSerializer<List<EncounterHistory.Location>> =
      ListSerializer(Hoisted.locationSerInner)
  }
}

internal object EncounterHistoryPolymorphicSerializer : KSerializer<EncounterHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EncounterHistory") {
      EncounterHistorySerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: EncounterHistory) {
    encoder.encodeStructure(descriptor) {
      EncounterHistorySerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): EncounterHistory =
    decoder.decodeStructure(descriptor) {
      EncounterHistorySerializer.deserializeJson(this, descriptor, 0)
    }
}
