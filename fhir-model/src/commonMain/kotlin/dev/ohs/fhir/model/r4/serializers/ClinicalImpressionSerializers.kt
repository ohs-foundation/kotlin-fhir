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
import dev.ohs.fhir.model.r4.ClinicalImpression
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
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
import kotlinx.serialization.builtins.nullable
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

internal object ClinicalImpressionInvestigationSerializer :
  KSerializer<ClinicalImpression.Investigation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Investigation") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("item", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClinicalImpression.Investigation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Investigation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClinicalImpression.Investigation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var item: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> item = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Investigation: " + __i)
      }
    }
    return ClinicalImpression.Investigation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      item = item ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClinicalImpression.Investigation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.itemSer, value.item)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val itemSerInner: KSerializer<Reference> = Reference.serializer()

    public val itemSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.itemSerInner)
  }
}

internal object ClinicalImpressionFindingSerializer : KSerializer<ClinicalImpression.Finding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Finding") {
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
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
      element("basis", KotlinString.serializer().descriptor, isOptional = true)
      element("_basis", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClinicalImpression.Finding =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Finding) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClinicalImpression.Finding {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var basis: KotlinString? = null
    var _basis: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        4 ->
          itemReference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.itemReferenceSer, null)
        5 -> basis = decoder.decodeStringElement(__desc, 5)
        6 -> _basis = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.basisSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Finding: " + __i)
      }
    }
    return ClinicalImpression.Finding(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemCodeableConcept = itemCodeableConcept,
      itemReference = itemReference,
      basis = R4String.of(basis, _basis),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClinicalImpression.Finding) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.itemCodeableConcept)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.itemCodeableConceptSer, it)
    }
    (value.itemReference)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.itemReferenceSer, it)
    }
    ((value.basis?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.basis?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.basisSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val basisSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ClinicalImpressionEffectiveSerializer : KSerializer<ClinicalImpression.Effective> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClinicalImpression.Effective") {
      element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Effective) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ClinicalImpression.Effective.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ClinicalImpression.Effective.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.effectivePeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ClinicalImpression.Effective =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ClinicalImpression.Effective {
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
            "Unexpected index decoding ClinicalImpression.Effective: " + __i
          )
      }
    }
    return ClinicalImpression.Effective.from(
      DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
      effectivePeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object ClinicalImpressionSerializer : KSerializer<ClinicalImpression> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClinicalImpression") {
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
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("assessor", Reference.serializer().descriptor, isOptional = true)
      element("previous", Reference.serializer().descriptor, isOptional = true)
      element("problem", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "investigation",
        listSerialDescriptor(
          lazyDescriptor { ClinicalImpression.Investigation.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "protocol",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_protocol", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("summary", KotlinString.serializer().descriptor, isOptional = true)
      element("_summary", Element.serializer().descriptor, isOptional = true)
      element(
        "finding",
        listSerialDescriptor(lazyDescriptor { ClinicalImpression.Finding.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "prognosisCodeableConcept",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "prognosisReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "supportingInfo",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClinicalImpression =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ClinicalImpression {
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
    var statusReason: CodeableConcept? = null
    var code: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var effectiveDateTime: KotlinString? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var assessor: Reference? = null
    var previous: Reference? = null
    var problem: List<Reference>? = null
    var investigation: List<ClinicalImpression.Investigation>? = null
    var protocol: List<KotlinString?>? = null
    var _protocol: List<Element?>? = null
    var summary: KotlinString? = null
    var _summary: Element? = null
    var finding: List<ClinicalImpression.Finding>? = null
    var prognosisCodeableConcept: List<CodeableConcept>? = null
    var prognosisReference: List<Reference>? = null
    var supportingInfo: List<Reference>? = null
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
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.statusReasonSer, null)
        15 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.statusReasonSer, null)
        16 -> description = decoder.decodeStringElement(__desc, 16)
        17 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.subjectSer, null)
        20 -> effectiveDateTime = decoder.decodeStringElement(__desc, 20)
        21 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.effectivePeriodSer, null)
        23 -> date = decoder.decodeStringElement(__desc, 23)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          assessor = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.subjectSer, null)
        26 ->
          previous = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.subjectSer, null)
        27 ->
          problem = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.problemSer, null)
        28 ->
          investigation =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.investigationSer, null)
        29 ->
          protocol =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.protocolSer, null)
        30 ->
          _protocol =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.protocolSer2, null)
        31 -> summary = decoder.decodeStringElement(__desc, 31)
        32 ->
          _summary =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          finding = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.findingSer, null)
        34 ->
          prognosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              34,
              Hoisted.prognosisCodeableConceptSer,
              null,
            )
        35 ->
          prognosisReference =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.problemSer, null)
        36 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.problemSer, null)
        37 -> note = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ClinicalImpression: " + __i)
      }
    }
    return ClinicalImpression(
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
        Enumeration.of(ClinicalImpression.ClinicalImpressionStatus.fromCode(status!!), _status),
      statusReason = statusReason,
      code = code,
      description = R4String.of(description, _description),
      subject = subject!!,
      encounter = encounter,
      effective =
        ClinicalImpression.Effective.from(
          DateTime.of(FhirDateTime.fromString(effectiveDateTime), _effectiveDateTime),
          effectivePeriod,
        ),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      assessor = assessor,
      previous = previous,
      problem = problem ?: listOf(),
      investigation = investigation ?: listOf(),
      protocol =
        (kotlin.collections.List(maxOf(protocol?.size ?: 0, _protocol?.size ?: 0)) { __i ->
          Uri.of(protocol?.getOrNull(__i)?.let { it }, _protocol?.getOrNull(__i))!!
        }),
      summary = R4String.of(summary, _summary),
      finding = finding ?: listOf(),
      prognosisCodeableConcept = prognosisCodeableConcept ?: listOf(),
      prognosisReference = prognosisReference ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClinicalImpression) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ClinicalImpression")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.statusReasonSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.statusReasonSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.subjectSer, it) }
    when (val __d = value.effective) {
      null -> {}
      is ClinicalImpression.Effective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
        }
      }
      is ClinicalImpression.Effective.Period -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.effectivePeriodSer, __d.value)
      }
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    (value.assessor)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.subjectSer, it) }
    (value.previous)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.subjectSer, it) }
    if (value.problem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.problemSer, value.problem)
    if (value.investigation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.investigationSer, value.investigation)
    (value.protocol.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.protocolSer, it)
    }
    (value.protocol.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.protocolSer2, it)
    }
    ((value.summary?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.summary?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    if (value.finding.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.findingSer, value.finding)
    if (value.prognosisCodeableConcept.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        34,
        Hoisted.prognosisCodeableConceptSer,
        value.prognosisCodeableConcept,
      )
    if (value.prognosisReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.problemSer, value.prognosisReference)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.problemSer, value.supportingInfo)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.noteSer, value.note)
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

    public val statusReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val problemSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val investigationSerInner: KSerializer<ClinicalImpression.Investigation> =
      ClinicalImpression.Investigation.serializer()

    public val investigationSer: KSerializer<List<ClinicalImpression.Investigation>> =
      ListSerializer(Hoisted.investigationSerInner)

    public val protocolSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val protocolSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.protocolSerInner).nullable)

    public val protocolSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val findingSerInner: KSerializer<ClinicalImpression.Finding> =
      ClinicalImpression.Finding.serializer()

    public val findingSer: KSerializer<List<ClinicalImpression.Finding>> =
      ListSerializer(Hoisted.findingSerInner)

    public val prognosisCodeableConceptSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
