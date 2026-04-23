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

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Schedule
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object ScheduleSerializer : KSerializer<Schedule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Schedule") {
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
      element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_active", Element.serializer().descriptor, isOptional = true)
      element(
        "serviceCategory",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "serviceType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialty",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("actor", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("planningHorizon", Period.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Schedule =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Schedule) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Schedule {
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
    var active: KotlinBoolean? = null
    var _active: Element? = null
    var serviceCategory: List<CodeableConcept>? = null
    var serviceType: List<CodeableConcept>? = null
    var specialty: List<CodeableConcept>? = null
    var actor: List<Reference>? = null
    var planningHorizon: Period? = null
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
        12 -> active = decoder.decodeBooleanElement(__desc, 12)
        13 ->
          _active =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          serviceCategory =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.serviceCategorySer, null)
        15 ->
          serviceType =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.serviceCategorySer, null)
        16 ->
          specialty =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.serviceCategorySer, null)
        17 -> actor = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.actorSer, null)
        18 ->
          planningHorizon =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.planningHorizonSer, null)
        19 -> comment = decoder.decodeStringElement(__desc, 19)
        20 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Schedule: " + __i)
      }
    }
    return Schedule(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      active = R4bBoolean.of(active, _active),
      serviceCategory = serviceCategory ?: listOf(),
      serviceType = serviceType ?: listOf(),
      specialty = specialty ?: listOf(),
      actor = actor ?: listOf(),
      planningHorizon = planningHorizon,
      comment = R4bString.of(comment, _comment),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Schedule) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Schedule")
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
    ((value.active?.value))?.let { encoder.encodeBooleanElement(__desc, 12, it) }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.serviceCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        14,
        Hoisted.serviceCategorySer,
        value.serviceCategory,
      )
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.serviceCategorySer, value.serviceType)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.serviceCategorySer, value.specialty)
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.actorSer, value.actor)
    (value.planningHorizon)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.planningHorizonSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
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

    public val actorSerInner: KSerializer<Reference> = Reference.serializer()

    public val actorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.actorSerInner)

    public val planningHorizonSer: KSerializer<Period> = Period.serializer()
  }
}
