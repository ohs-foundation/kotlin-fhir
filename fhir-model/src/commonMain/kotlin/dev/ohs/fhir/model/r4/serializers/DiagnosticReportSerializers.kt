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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.DiagnosticReport
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> comment = decoder.decodeStringElement(__desc, 3)
        4 ->
          _comment = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.commentSer, null)
        5 -> link = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.linkSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Media: " + __i)
      }
    }
    return DiagnosticReport.Media(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      comment = R4String.of(comment, _comment),
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

internal object DiagnosticReportEffectiveSerializer : KSerializer<DiagnosticReport.Effective> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DiagnosticReport.Effective") {
      element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport.Effective) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is DiagnosticReport.Effective.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is DiagnosticReport.Effective.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.effectivePeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): DiagnosticReport.Effective =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): DiagnosticReport.Effective {
    val __desc = descriptor
    var effectiveDateTime: KotlinString? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> effectiveDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.effectivePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding DiagnosticReport.Effective: " + __i
          )
      }
    }
    return DiagnosticReport.Effective.from(
      DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
      effectivePeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object DiagnosticReportSerializer : KSerializer<DiagnosticReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DiagnosticReport") {
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
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("issued", KotlinString.serializer().descriptor, isOptional = true)
      element("_issued", Element.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "resultsInterpreter",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specimen",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("result", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "imagingStudy",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "media",
        listSerialDescriptor(lazyDescriptor { DiagnosticReport.Media.serializer().descriptor }),
        isOptional = true,
      )
      element("conclusion", KotlinString.serializer().descriptor, isOptional = true)
      element("_conclusion", Element.serializer().descriptor, isOptional = true)
      element(
        "conclusionCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "presentedForm",
        listSerialDescriptor(Attachment.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): DiagnosticReport =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DiagnosticReport) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): DiagnosticReport {
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
    var imagingStudy: List<Reference>? = null
    var media: List<DiagnosticReport.Media>? = null
    var conclusion: KotlinString? = null
    var _conclusion: Element? = null
    var conclusionCode: List<CodeableConcept>? = null
    var presentedForm: List<Attachment>? = null
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
          basedOn = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.categorySerInner, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSerInner, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.basedOnSerInner, null)
        19 -> effectiveDateTime = decoder.decodeStringElement(__desc, 19)
        20 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.effectivePeriodSer, null)
        22 -> issued = decoder.decodeStringElement(__desc, 22)
        23 ->
          _issued =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.basedOnSer, null)
        25 ->
          resultsInterpreter =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.basedOnSer, null)
        26 ->
          specimen = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.basedOnSer, null)
        27 ->
          result = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.basedOnSer, null)
        28 ->
          imagingStudy =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.basedOnSer, null)
        29 -> media = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.mediaSer, null)
        30 -> conclusion = decoder.decodeStringElement(__desc, 30)
        31 ->
          _conclusion =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          conclusionCode =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.categorySer, null)
        33 ->
          presentedForm =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.presentedFormSer, null)
        CompositeDecoder.DECODE_DONE -> break
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
      imagingStudy = imagingStudy ?: listOf(),
      media = media ?: listOf(),
      conclusion = R4String.of(conclusion, _conclusion),
      conclusionCode = conclusionCode ?: listOf(),
      presentedForm = presentedForm ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DiagnosticReport) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "DiagnosticReport")
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.basedOnSer, value.basedOn)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.categorySerInner, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.effective) {
      null -> {}
      is DiagnosticReport.Effective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
        }
      }
      is DiagnosticReport.Effective.Period -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.effectivePeriodSer, __d.value)
      }
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.basedOnSer, value.performer)
    if (value.resultsInterpreter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.basedOnSer, value.resultsInterpreter)
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.basedOnSer, value.specimen)
    if (value.result.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.basedOnSer, value.result)
    if (value.imagingStudy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.basedOnSer, value.imagingStudy)
    if (value.media.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.mediaSer, value.media)
    ((value.conclusion?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.conclusion?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    if (value.conclusionCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.categorySer, value.conclusionCode)
    if (value.presentedForm.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.presentedFormSer, value.presentedForm)
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

    public val mediaSerInner: KSerializer<DiagnosticReport.Media> =
      DiagnosticReport.Media.serializer()

    public val mediaSer: KSerializer<List<DiagnosticReport.Media>> =
      ListSerializer(Hoisted.mediaSerInner)

    public val presentedFormSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val presentedFormSer: KSerializer<List<Attachment>> =
      ListSerializer(Hoisted.presentedFormSerInner)
  }
}
