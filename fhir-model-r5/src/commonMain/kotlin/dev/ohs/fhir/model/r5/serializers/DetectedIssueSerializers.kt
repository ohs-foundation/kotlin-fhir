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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.DetectedIssue
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object DetectedIssueEvidenceSerializer : KSerializer<DetectedIssue.Evidence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Evidence") {
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
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("detail", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DetectedIssue.Evidence =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Evidence) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DetectedIssue.Evidence {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: List<CodeableConcept>? = null
    var detail: List<Reference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Evidence: " + i)
      }
    }
    return DetectedIssue.Evidence(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DetectedIssue.Evidence) {
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
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val detailSerInner: KSerializer<Reference> = Reference.serializer()

    public val detailSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.detailSerInner)
  }
}

internal object DetectedIssueMitigationSerializer : KSerializer<DetectedIssue.Mitigation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Mitigation") {
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
      element("action", CodeableConcept.serializer().descriptor, isOptional = true)
      element("date", String.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("author", Reference.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DetectedIssue.Mitigation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Mitigation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DetectedIssue.Mitigation {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: CodeableConcept? = null
    var date: String? = null
    var _date: Element? = null
    var author: Reference? = null
    var note: List<Annotation>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        4 -> date = decoder.decodeStringElement(descriptor, i)
        5 -> _date = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateSer, null)
        6 ->
          author = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authorSer, null)
        7 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mitigation: " + i)
      }
    }
    return DetectedIssue.Mitigation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action =
        action
          ?: throw SerializationException(
            "Missing required property 'action' on DetectedIssue.Mitigation"
          ),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      author = author,
      note = note ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DetectedIssue.Mitigation) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.actionSer, value.action)
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.dateSer, it)
    }
    (value.author)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.authorSer, it) }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()

    public val authorSer: KSerializer<Reference> = Reference.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object DetectedIssueSerializer : KSerializer<DetectedIssue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DetectedIssue") {
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("severity", String.serializer().descriptor, isOptional = true)
    b.element("_severity", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("identifiedDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_identifiedDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("identifiedPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("author", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "implicated",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "evidence",
      listSerialDescriptor(lazyDescriptor { DetectedIssue.Evidence.serializer().descriptor }),
      isOptional = true,
    )
    b.element("detail", String.serializer().descriptor, isOptional = true)
    b.element("_detail", Element.serializer().descriptor, isOptional = true)
    b.element("reference", String.serializer().descriptor, isOptional = true)
    b.element("_reference", Element.serializer().descriptor, isOptional = true)
    b.element(
      "mitigation",
      listSerialDescriptor(lazyDescriptor { DetectedIssue.Mitigation.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): DetectedIssue =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DetectedIssue")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): DetectedIssue {
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
    var status: String? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var severity: String? = null
    var _severity: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var identifiedDateTime: String? = null
    var _identifiedDateTime: Element? = null
    var identifiedPeriod: Period? = null
    var author: Reference? = null
    var implicated: List<Reference>? = null
    var evidence: List<DetectedIssue.Evidence>? = null
    var detail: String? = null
    var _detail: Element? = null
    var reference: String? = null
    var _reference: Element? = null
    var mitigation: List<DetectedIssue.Mitigation>? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        14 ->
          code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        15 -> severity = decoder.decodeStringElement(descriptor, i)
        16 ->
          _severity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        19 -> identifiedDateTime = decoder.decodeStringElement(descriptor, i)
        20 ->
          _identifiedDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          identifiedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifiedPeriodSer,
              null,
            )
        22 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        23 ->
          implicated =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicatedSer, null)
        24 ->
          evidence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.evidenceSer, null)
        25 -> detail = decoder.decodeStringElement(descriptor, i)
        26 ->
          _detail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> reference = decoder.decodeStringElement(descriptor, i)
        28 ->
          _reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          mitigation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mitigationSer, null)
        else -> throw SerializationException("Unexpected index decoding DetectedIssue: " + i)
      }
    }
    return DetectedIssue(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          DetectedIssue.DetectedIssueStatus.fromCode(
            status
              ?: throw SerializationException("Missing required property 'status' on DetectedIssue")
          ),
          _status,
        ),
      category = category ?: listOf(),
      code = code,
      severity =
        severity?.let {
          Enumeration.of(DetectedIssue.DetectedIssueSeverity.fromCode(it), _severity)
        },
      subject = subject,
      encounter = encounter,
      identified =
        DetectedIssue.Identified.from(
          DateTime.of(FhirDateTime.fromString(identifiedDateTime), _identifiedDateTime),
          identifiedPeriod,
        ),
      author = author,
      implicated = implicated ?: listOf(),
      evidence = evidence ?: listOf(),
      detail = Markdown.of(detail, _detail),
      reference = Uri.of(reference, _reference),
      mitigation = mitigation ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DetectedIssue,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    (value.code)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    ((value.severity?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.severity?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.subjectSer, it)
    }
    when (val choice = value.identified) {
      null -> {}
      is DetectedIssue.Identified.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            20 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is DetectedIssue.Identified.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          Hoisted.identifiedPeriodSer,
          choice.value,
        )
      }
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.implicated.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicatedSer,
        value.implicated,
      )
    if (value.evidence.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.evidenceSer,
        value.evidence,
      )
    ((value.detail?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.detail?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.reference?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.reference?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.mitigation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.mitigationSer,
        value.mitigation,
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val identifiedPeriodSer: KSerializer<Period> = Period.serializer()

    public val implicatedSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val evidenceSerInner: KSerializer<DetectedIssue.Evidence> =
      DetectedIssue.Evidence.serializer()

    public val evidenceSer: KSerializer<List<DetectedIssue.Evidence>> =
      ListSerializer(Hoisted.evidenceSerInner)

    public val mitigationSerInner: KSerializer<DetectedIssue.Mitigation> =
      DetectedIssue.Mitigation.serializer()

    public val mitigationSer: KSerializer<List<DetectedIssue.Mitigation>> =
      ListSerializer(Hoisted.mitigationSerInner)
  }
}

internal object DetectedIssuePolymorphicSerializer : KSerializer<DetectedIssue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DetectedIssue") { DetectedIssueSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue) {
    encoder.encodeStructure(descriptor) {
      DetectedIssueSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DetectedIssue =
    decoder.decodeStructure(descriptor) {
      DetectedIssueSerializer.deserializeInternal(this, descriptor, 0)
    }
}
