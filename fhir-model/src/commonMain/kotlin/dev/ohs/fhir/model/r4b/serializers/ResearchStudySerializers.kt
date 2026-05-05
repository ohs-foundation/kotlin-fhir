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
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.ResearchStudy
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.String as KotlinString
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 -> description = decoder.decodeStringElement(__desc, __i)
        7 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Arm: " + __i)
      }
    }
    return ResearchStudy.Arm(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name)!!,
      type = type,
      description = R4bString.of(description, _description),
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, __i)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Objective: " + __i)
      }
    }
    return ResearchStudy.Objective(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name),
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
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element(
      "protocol",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("primaryPurposeType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("phase", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "focus",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "condition",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "keyword",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "location",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "enrollment",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("sponsor", Reference.serializer().descriptor, isOptional = true)
    b.element("principalInvestigator", Reference.serializer().descriptor, isOptional = true)
    b.element("site", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("reasonStopped", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "arm",
      listSerialDescriptor(lazyDescriptor { ResearchStudy.Arm.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "objective",
      listSerialDescriptor(lazyDescriptor { ResearchStudy.Objective.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ResearchStudy =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ResearchStudy")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): ResearchStudy {
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
        11 -> title = decoder.decodeStringElement(__desc, __i)
        12 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          protocol =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.protocolSer, null)
        14 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.protocolSer, null)
        15 -> status = decoder.decodeStringElement(__desc, __i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          primaryPurposeType =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        18 ->
          phase =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        19 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        20 ->
          focus = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        21 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        22 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        23 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relatedArtifactSer, null)
        24 ->
          keyword =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        25 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        26 -> description = decoder.decodeStringElement(__desc, __i)
        27 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 ->
          enrollment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.protocolSer, null)
        29 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        30 ->
          sponsor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.protocolSerInner, null)
        31 ->
          principalInvestigator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.protocolSerInner, null)
        32 ->
          site = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.protocolSer, null)
        33 ->
          reasonStopped =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        34 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        35 -> arm = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.armSer, null)
        36 ->
          objective =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.objectiveSer, null)
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
      title = R4bString.of(title, _title),
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: ResearchStudy,
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
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.protocol.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.protocolSer, value.protocol)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.protocolSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.primaryPurposeType)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.primaryPurposeTypeSer, it)
    }
    (value.phase)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.primaryPurposeTypeSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.categorySer, value.category)
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.categorySer, value.focus)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.categorySer, value.condition)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.contactSer, value.contact)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23 + __off,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.categorySer, value.keyword)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.categorySer, value.location)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 26 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.enrollment.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.protocolSer, value.enrollment)
    (value.period)?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.periodSer, it)
    }
    (value.sponsor)?.let {
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.protocolSerInner, it)
    }
    (value.principalInvestigator)?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.protocolSerInner, it)
    }
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.protocolSer, value.site)
    (value.reasonStopped)?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.primaryPurposeTypeSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.noteSer, value.note)
    if (value.arm.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.armSer, value.arm)
    if (value.objective.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.objectiveSer, value.objective)
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

internal object ResearchStudyPolymorphicSerializer : KSerializer<ResearchStudy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchStudy") { ResearchStudySerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy) {
    encoder.encodeStructure(descriptor) {
      ResearchStudySerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ResearchStudy =
    decoder.decodeStructure(descriptor) {
      ResearchStudySerializer.deserializeJson(this, descriptor, 0)
    }
}
