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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Slot
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
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

internal object SlotSerializer : KSerializer<Slot> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Slot") {
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
        "serviceCategory",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "serviceType",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialty",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "appointmentType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("schedule", Reference.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("start", KotlinString.serializer().descriptor, isOptional = true)
      element("_start", Element.serializer().descriptor, isOptional = true)
      element("end", KotlinString.serializer().descriptor, isOptional = true)
      element("_end", Element.serializer().descriptor, isOptional = true)
      element("overbooked", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_overbooked", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Slot =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Slot) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Slot {
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
    var serviceCategory: List<CodeableConcept>? = null
    var serviceType: List<CodeableReference>? = null
    var specialty: List<CodeableConcept>? = null
    var appointmentType: List<CodeableConcept>? = null
    var schedule: Reference? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var start: KotlinString? = null
    var _start: Element? = null
    var end: KotlinString? = null
    var _end: Element? = null
    var overbooked: KotlinBoolean? = null
    var _overbooked: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
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
          serviceCategory =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.serviceCategorySer, null)
        13 ->
          serviceType =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.serviceTypeSer, null)
        14 ->
          specialty =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.serviceCategorySer, null)
        15 ->
          appointmentType =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.serviceCategorySer, null)
        16 ->
          schedule =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.scheduleSer, null)
        17 -> status = decoder.decodeStringElement(__desc, 17)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 -> start = decoder.decodeStringElement(__desc, 19)
        20 ->
          _start =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> end = decoder.decodeStringElement(__desc, 21)
        22 ->
          _end =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> overbooked = decoder.decodeBooleanElement(__desc, 23)
        24 ->
          _overbooked =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> comment = decoder.decodeStringElement(__desc, 25)
        26 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Slot: " + __i)
      }
    }
    return Slot(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      serviceCategory = serviceCategory ?: listOf(),
      serviceType = serviceType ?: listOf(),
      specialty = specialty ?: listOf(),
      appointmentType = appointmentType ?: listOf(),
      schedule = schedule!!,
      status = Enumeration.of(Slot.SlotStatus.fromCode(status!!), _status),
      start = Instant.of(FhirDateTime.fromString(start), _start)!!,
      end = Instant.of(FhirDateTime.fromString(end), _end)!!,
      overbooked = R5Boolean.of(overbooked, _overbooked),
      comment = R5String.of(comment, _comment),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Slot) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Slot")
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
    if (value.serviceCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        12,
        Hoisted.serviceCategorySer,
        value.serviceCategory,
      )
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.serviceTypeSer, value.serviceType)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.serviceCategorySer, value.specialty)
    if (value.appointmentType.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15,
        Hoisted.serviceCategorySer,
        value.appointmentType,
      )
    (value.schedule)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.scheduleSer, it) }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    ((value.start.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.start.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.end.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.end.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.overbooked?.value))?.let { encoder.encodeBooleanElement(__desc, 23, it) }
    (value.overbooked?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
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

    public val serviceCategorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val serviceCategorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.serviceCategorySerInner)

    public val serviceTypeSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val serviceTypeSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.serviceTypeSerInner)

    public val scheduleSer: KSerializer<Reference> = Reference.serializer()
  }
}
