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
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.DiagnosticReport
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object DiagnosticReportSupportingInfoSerializer :
  KSerializer<DiagnosticReport.SupportingInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportingInfo") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DiagnosticReport.SupportingInfo =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport.SupportingInfo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DiagnosticReport.SupportingInfo {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var reference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + __i)
      }
    }
    return DiagnosticReport.SupportingInfo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      reference = reference!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DiagnosticReport.SupportingInfo) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.referenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val referenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object DiagnosticReportMediaSerializer : KSerializer<DiagnosticReport.Media> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Media") {
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
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element("link", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DiagnosticReport.Media =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport.Media) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DiagnosticReport.Media {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var link: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> comment = decoder.decodeStringElement(__desc, __i)
        4 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.commentSer, null)
        5 -> link = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Media: " + __i)
      }
    }
    return DiagnosticReport.Media(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      comment = R5String.of(comment, _comment),
      link = link!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DiagnosticReport.Media) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.commentSer, it)
    }
    (value.link)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.linkSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val commentSer: KSerializer<Element> = Element.serializer()

    public val linkSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object DiagnosticReportSerializer : KSerializer<DiagnosticReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DiagnosticReport") {
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("issued", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_issued", Element.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "resultsInterpreter",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specimen",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("result", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("study", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "supportingInfo",
      listSerialDescriptor(
        lazyDescriptor { DiagnosticReport.SupportingInfo.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "media",
      listSerialDescriptor(lazyDescriptor { DiagnosticReport.Media.serializer().descriptor }),
      isOptional = true,
    )
    b.element("composition", Reference.serializer().descriptor, isOptional = true)
    b.element("conclusion", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_conclusion", Element.serializer().descriptor, isOptional = true)
    b.element(
      "conclusionCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "presentedForm",
      listSerialDescriptor(Attachment.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): DiagnosticReport =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DiagnosticReport")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): DiagnosticReport {
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
    var basedOn: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var effectiveDateTime: KotlinString? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var issued: KotlinString? = null
    var _issued: Element? = null
    var performer: List<Reference>? = null
    var resultsInterpreter: List<Reference>? = null
    var specimen: List<Reference>? = null
    var result: List<Reference>? = null
    var note: List<Annotation>? = null
    var study: List<Reference>? = null
    var supportingInfo: List<DiagnosticReport.SupportingInfo>? = null
    var media: List<DiagnosticReport.Media>? = null
    var composition: Reference? = null
    var conclusion: KotlinString? = null
    var _conclusion: Element? = null
    var conclusionCode: List<CodeableConcept>? = null
    var presentedForm: List<Attachment>? = null
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
          code =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        16 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        17 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        18 -> effectiveDateTime = decoder.decodeStringElement(__desc, __i)
        19 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectivePeriodSer, null)
        21 -> issued = decoder.decodeStringElement(__desc, __i)
        22 ->
          _issued =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        24 ->
          resultsInterpreter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        25 ->
          specimen =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        26 ->
          result = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        27 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        28 ->
          study = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        29 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.supportingInfoSer, null)
        30 -> media = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.mediaSer, null)
        31 ->
          composition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        32 -> conclusion = decoder.decodeStringElement(__desc, __i)
        33 ->
          _conclusion =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        34 ->
          conclusionCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        35 ->
          presentedForm =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.presentedFormSer, null)
        else -> throw SerializationException("Unexpected index decoding DiagnosticReport: " + __i)
      }
    }
    return DiagnosticReport(
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
      status = Enumeration.of(DiagnosticReport.DiagnosticReportStatus.fromCode(status!!), _status),
      category = category ?: listOf(),
      code = code!!,
      subject = subject,
      encounter = encounter,
      effective =
        DiagnosticReport.Effective.from(
          DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
          effectivePeriod,
        ),
      issued = Instant.of(FhirDateTime.fromString(issued), _issued),
      performer = performer ?: listOf(),
      resultsInterpreter = resultsInterpreter ?: listOf(),
      specimen = specimen ?: listOf(),
      result = result ?: listOf(),
      note = note ?: listOf(),
      study = study ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      media = media ?: listOf(),
      composition = composition,
      conclusion = Markdown.of(conclusion, _conclusion),
      conclusionCode = conclusionCode ?: listOf(),
      presentedForm = presentedForm ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: DiagnosticReport,
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
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.categorySerInner, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.effective) {
      null -> {}
      is DiagnosticReport.Effective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is DiagnosticReport.Effective.Period -> {
        encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.effectivePeriodSer, __d.value)
      }
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.basedOnSer, value.performer)
    if (value.resultsInterpreter.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24 + __off,
        Hoisted.basedOnSer,
        value.resultsInterpreter,
      )
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.basedOnSer, value.specimen)
    if (value.result.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.basedOnSer, value.result)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.noteSer, value.note)
    if (value.study.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.basedOnSer, value.study)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
        Hoisted.supportingInfoSer,
        value.supportingInfo,
      )
    if (value.media.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.mediaSer, value.media)
    (value.composition)?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.basedOnSerInner, it)
    }
    ((value.conclusion?.value))?.let { encoder.encodeStringElement(__desc, 32 + __off, it) }
    (value.conclusion?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.conclusionCode.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        34 + __off,
        Hoisted.categorySer,
        value.conclusionCode,
      )
    if (value.presentedForm.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        35 + __off,
        Hoisted.presentedFormSer,
        value.presentedForm,
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val supportingInfoSerInner: KSerializer<DiagnosticReport.SupportingInfo> =
      DiagnosticReport.SupportingInfo.serializer()

    public val supportingInfoSer: KSerializer<List<DiagnosticReport.SupportingInfo>> =
      ListSerializer(Hoisted.supportingInfoSerInner)

    public val mediaSerInner: KSerializer<DiagnosticReport.Media> =
      DiagnosticReport.Media.serializer()

    public val mediaSer: KSerializer<List<DiagnosticReport.Media>> =
      ListSerializer(Hoisted.mediaSerInner)

    public val presentedFormSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val presentedFormSer: KSerializer<List<Attachment>> =
      ListSerializer(Hoisted.presentedFormSerInner)
  }
}

internal object DiagnosticReportPolymorphicSerializer : KSerializer<DiagnosticReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DiagnosticReport") {
      DiagnosticReportSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport) {
    encoder.encodeStructure(descriptor) {
      DiagnosticReportSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DiagnosticReport =
    decoder.decodeStructure(descriptor) {
      DiagnosticReportSerializer.deserializeJson(this, descriptor, 0)
    }
}
