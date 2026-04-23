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
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.ResearchStudy
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

internal object ResearchStudyArmSerializer : KSerializer<ResearchStudy.Arm> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Arm") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.Arm =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Arm) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.Arm {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> description = decoder.decodeStringElement(__desc, 6)
        7 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Arm: " + __i)
      }
    }
    return ResearchStudy.Arm(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name)!!,
      type = type,
      description = R4String.of(description, _description),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.Arm) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ResearchStudyObjectiveSerializer : KSerializer<ResearchStudy.Objective> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Objective") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.Objective =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Objective) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.Objective {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Objective: " + __i)
      }
    }
    return ResearchStudy.Objective(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name),
      type = type,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.Objective) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ResearchStudySerializer : KSerializer<ResearchStudy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchStudy") {
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
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element(
        "protocol",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("primaryPurposeType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("phase", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "focus",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "condition",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "keyword",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "location",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "enrollment",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
      element("sponsor", Reference.serializer().descriptor, isOptional = true)
      element("principalInvestigator", Reference.serializer().descriptor, isOptional = true)
      element("site", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("reasonStopped", CodeableConcept.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "arm",
        listSerialDescriptor(lazyDescriptor { ResearchStudy.Arm.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "objective",
        listSerialDescriptor(lazyDescriptor { ResearchStudy.Objective.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ResearchStudy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ResearchStudy {
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
    var title: KotlinString? = null
    var _title: Element? = null
    var protocol: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var primaryPurposeType: CodeableConcept? = null
    var phase: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var focus: List<CodeableConcept>? = null
    var condition: List<CodeableConcept>? = null
    var contact: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var keyword: List<CodeableConcept>? = null
    var location: List<CodeableConcept>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var enrollment: List<Reference>? = null
    var period: Period? = null
    var sponsor: Reference? = null
    var principalInvestigator: Reference? = null
    var site: List<Reference>? = null
    var reasonStopped: CodeableConcept? = null
    var note: List<Annotation>? = null
    var arm: List<ResearchStudy.Arm>? = null
    var objective: List<ResearchStudy.Objective>? = null
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
        12 -> title = decoder.decodeStringElement(__desc, 12)
        13 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          protocol =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.protocolSer, null)
        15 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.protocolSer, null)
        16 -> status = decoder.decodeStringElement(__desc, 16)
        17 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          primaryPurposeType =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        19 ->
          phase =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        20 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.categorySer, null)
        21 ->
          focus = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.categorySer, null)
        22 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.categorySer, null)
        23 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.contactSer, null)
        24 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.relatedArtifactSer, null)
        25 ->
          keyword = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.categorySer, null)
        26 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.categorySer, null)
        27 -> description = decoder.decodeStringElement(__desc, 27)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 ->
          enrollment =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.protocolSer, null)
        30 ->
          period = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.periodSer, null)
        31 ->
          sponsor =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.protocolSerInner, null)
        32 ->
          principalInvestigator =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.protocolSerInner, null)
        33 ->
          site = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.protocolSer, null)
        34 ->
          reasonStopped =
            decoder.decodeNullableSerializableElement(
              __desc,
              34,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        35 -> note = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.noteSer, null)
        36 -> arm = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.armSer, null)
        37 ->
          objective =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.objectiveSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ResearchStudy: " + __i)
      }
    }
    return ResearchStudy(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      title = R4String.of(title, _title),
      protocol = protocol ?: listOf(),
      partOf = partOf ?: listOf(),
      status = Enumeration.of(ResearchStudy.ResearchStudyStatus.fromCode(status!!), _status),
      primaryPurposeType = primaryPurposeType,
      phase = phase,
      category = category ?: listOf(),
      focus = focus ?: listOf(),
      condition = condition ?: listOf(),
      contact = contact ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      keyword = keyword ?: listOf(),
      location = location ?: listOf(),
      description = Markdown.of(description, _description),
      enrollment = enrollment ?: listOf(),
      period = period,
      sponsor = sponsor,
      principalInvestigator = principalInvestigator,
      site = site ?: listOf(),
      reasonStopped = reasonStopped,
      note = note ?: listOf(),
      arm = arm ?: listOf(),
      objective = objective ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ResearchStudy")
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
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.protocol.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.protocolSer, value.protocol)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.protocolSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.primaryPurposeType)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.primaryPurposeTypeSer, it)
    }
    (value.phase)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.primaryPurposeTypeSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.categorySer, value.category)
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.categorySer, value.focus)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.categorySer, value.condition)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.contactSer, value.contact)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.categorySer, value.keyword)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.categorySer, value.location)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    if (value.enrollment.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.protocolSer, value.enrollment)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 30, Hoisted.periodSer, it) }
    (value.sponsor)?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.protocolSerInner, it)
    }
    (value.principalInvestigator)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.protocolSerInner, it)
    }
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.protocolSer, value.site)
    (value.reasonStopped)?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.primaryPurposeTypeSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.noteSer, value.note)
    if (value.arm.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.armSer, value.arm)
    if (value.objective.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.objectiveSer, value.objective)
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

    public val protocolSerInner: KSerializer<Reference> = Reference.serializer()

    public val protocolSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.protocolSerInner)

    public val primaryPurposeTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.primaryPurposeTypeSer)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val armSerInner: KSerializer<ResearchStudy.Arm> = ResearchStudy.Arm.serializer()

    public val armSer: KSerializer<List<ResearchStudy.Arm>> = ListSerializer(Hoisted.armSerInner)

    public val objectiveSerInner: KSerializer<ResearchStudy.Objective> =
      ResearchStudy.Objective.serializer()

    public val objectiveSer: KSerializer<List<ResearchStudy.Objective>> =
      ListSerializer(Hoisted.objectiveSerInner)
  }
}
