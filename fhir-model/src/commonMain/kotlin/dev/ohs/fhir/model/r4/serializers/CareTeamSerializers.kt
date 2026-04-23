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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.CareTeam
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object CareTeamParticipantSerializer : KSerializer<CareTeam.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
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
      element(
        "role",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("member", Reference.serializer().descriptor, isOptional = true)
      element("onBehalfOf", Reference.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CareTeam.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CareTeam.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CareTeam.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: List<CodeableConcept>? = null
    var member: Reference? = null
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
        3 -> role = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.roleSer, null)
        4 -> member = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.memberSer, null)
        5 ->
          onBehalfOf = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.memberSer, null)
        6 -> period = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return CareTeam.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role = role ?: listOf(),
      member = member,
      onBehalfOf = onBehalfOf,
      period = period,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CareTeam.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.role.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.roleSer, value.role)
    (value.member)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.memberSer, it) }
    (value.onBehalfOf)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.memberSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val roleSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val roleSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.roleSerInner)

    public val memberSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object CareTeamSerializer : KSerializer<CareTeam> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CareTeam") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element(
        "participant",
        listSerialDescriptor(lazyDescriptor { CareTeam.Participant.serializer().descriptor }),
        isOptional = true,
      )
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
      element(
        "managingOrganization",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "telecom",
        listSerialDescriptor(ContactPoint.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CareTeam =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CareTeam) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CareTeam {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var period: Period? = null
    var participant: List<CareTeam.Participant>? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var managingOrganization: List<Reference>? = null
    var telecom: List<ContactPoint>? = null
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.categorySer, null)
        15 -> name = decoder.decodeStringElement(__desc, 15)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.subjectSer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 ->
          period = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.periodSer, null)
        20 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.participantSer, null)
        21 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.categorySer, null)
        22 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.reasonReferenceSer, null)
        23 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.reasonReferenceSer, null)
        24 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.telecomSer, null)
        25 -> note = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CareTeam: " + __i)
      }
    }
    return CareTeam(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = status?.let { Enumeration.of(CareTeam.CareTeamStatus.fromCode(it), _status) },
      category = category ?: listOf(),
      name = R4String.of(name, _name),
      subject = subject,
      encounter = encounter,
      period = period,
      participant = participant ?: listOf(),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      managingOrganization = managingOrganization ?: listOf(),
      telecom = telecom ?: listOf(),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CareTeam) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "CareTeam")
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
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.categorySer, value.category)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.subjectSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.periodSer, it) }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.participantSer, value.participant)
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.categorySer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    if (value.managingOrganization.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23,
        Hoisted.reasonReferenceSer,
        value.managingOrganization,
      )
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.telecomSer, value.telecom)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.noteSer, value.note)
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val participantSerInner: KSerializer<CareTeam.Participant> =
      CareTeam.Participant.serializer()

    public val participantSer: KSerializer<List<CareTeam.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val reasonReferenceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val telecomSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val telecomSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.telecomSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
