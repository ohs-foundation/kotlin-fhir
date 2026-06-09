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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Schedule
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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

internal object ScheduleSerializer : KSerializer<Schedule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Schedule") {
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
    b.element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_active", Element.serializer().descriptor, isOptional = true)
    b.element(
      "serviceCategory",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "serviceType",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specialty",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("actor", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("planningHorizon", Period.serializer().descriptor, isOptional = true)
    b.element("comment", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_comment", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Schedule =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Schedule) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Schedule")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Schedule {
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
    var serviceType: List<CodeableReference>? = null
    var specialty: List<CodeableConcept>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var actor: List<Reference>? = null
    var planningHorizon: Period? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> active = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _active =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          serviceCategory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.serviceCategorySer,
              null,
            )
        14 ->
          serviceType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.serviceTypeSer, null)
        15 ->
          specialty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.serviceCategorySer,
              null,
            )
        16 -> name = decoder.decodeStringElement(descriptor, i)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        19 ->
          planningHorizon =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.planningHorizonSer,
              null,
            )
        20 -> comment = decoder.decodeStringElement(descriptor, i)
        21 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        else -> throw SerializationException("Unexpected index decoding Schedule: " + i)
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
      active = R5Boolean.of(active, _active),
      serviceCategory = serviceCategory ?: listOf(),
      serviceType = serviceType ?: listOf(),
      specialty = specialty ?: listOf(),
      name = R5String.of(name, _name),
      actor = actor ?: listOf(),
      planningHorizon = planningHorizon,
      comment = Markdown.of(comment, _comment),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Schedule,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.active?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.serviceCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.serviceCategorySer,
        value.serviceCategory,
      )
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.serviceTypeSer,
        value.serviceType,
      )
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.serviceCategorySer,
        value.specialty,
      )
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.actorSer,
        value.actor,
      )
    (value.planningHorizon)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.planningHorizonSer,
        it,
      )
    }
    ((value.comment?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
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

    public val actorSerInner: KSerializer<Reference> = Reference.serializer()

    public val actorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.actorSerInner)

    public val planningHorizonSer: KSerializer<Period> = Period.serializer()
  }
}

internal object SchedulePolymorphicSerializer : KSerializer<Schedule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Schedule") { ScheduleSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Schedule) {
    encoder.encodeStructure(descriptor) {
      ScheduleSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Schedule =
    decoder.decodeStructure(descriptor) {
      ScheduleSerializer.deserializeInternal(this, descriptor, 0)
    }
}
