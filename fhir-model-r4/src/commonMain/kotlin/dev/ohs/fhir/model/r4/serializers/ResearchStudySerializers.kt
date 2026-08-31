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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Arm) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.Arm {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> description = decoder.decodeStringElement(descriptor, i)
        7 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Arm: " + i)
      }
    }
    return ResearchStudy.Arm(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R4String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on ResearchStudy.Arm"),
      type = type,
      description = R4String.of(description, _description),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.Arm) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Objective) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.Objective {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Objective: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.Objective) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ResearchStudy")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ResearchStudy {
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
        11 -> title = decoder.decodeStringElement(descriptor, i)
        12 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          protocol =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        14 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          primaryPurposeType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        18 ->
          phase =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        19 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        20 ->
          focus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        21 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        22 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        23 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        24 ->
          keyword =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        25 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        26 -> description = decoder.decodeStringElement(descriptor, i)
        27 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 ->
          enrollment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        29 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        30 ->
          sponsor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSerInner, null)
        31 ->
          principalInvestigator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSerInner, null)
        32 ->
          site = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        33 ->
          reasonStopped =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        34 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        35 -> arm = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.armSer, null)
        36 ->
          objective =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.objectiveSer, null)
        else -> throw SerializationException("Unexpected index decoding ResearchStudy: " + i)
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
      status =
        Enumeration.of(status?.let { ResearchStudy.ResearchStudyStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on ResearchStudy"),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ResearchStudy,
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
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.protocol.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.protocolSer,
        value.protocol,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.protocolSer,
        value.partOf,
      )
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.primaryPurposeType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.primaryPurposeTypeSer,
        it,
      )
    }
    (value.phase)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.primaryPurposeTypeSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.categorySer,
        value.focus,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.categorySer,
        value.condition,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.categorySer,
        value.keyword,
      )
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.categorySer,
        value.location,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.enrollment.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.protocolSer,
        value.enrollment,
      )
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.periodSer, it)
    }
    (value.sponsor)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.protocolSerInner,
        it,
      )
    }
    (value.principalInvestigator)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.protocolSerInner,
        it,
      )
    }
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.protocolSer,
        value.site,
      )
    (value.reasonStopped)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.primaryPurposeTypeSer,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.arm.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.armSer,
        value.arm,
      )
    if (value.objective.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.objectiveSer,
        value.objective,
      )
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
      ResearchStudySerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ResearchStudy =
    decoder.decodeStructure(descriptor) {
      ResearchStudySerializer.deserializeInternal(this, descriptor, 0)
    }
}
