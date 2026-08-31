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
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Investigation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClinicalImpression.Investigation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var item: List<Reference>? = null
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
        4 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Investigation: " + i)
      }
    }
    return ClinicalImpression.Investigation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on ClinicalImpression.Investigation"
          ),
      item = item ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClinicalImpression.Investigation,
  ) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemSer, value.item)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Finding) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClinicalImpression.Finding {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var basis: KotlinString? = null
    var _basis: Element? = null
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
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        4 ->
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        5 -> basis = decoder.decodeStringElement(descriptor, i)
        6 ->
          _basis = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basisSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Finding: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClinicalImpression.Finding) {
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
    (value.itemCodeableConcept)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemCodeableConceptSer, it)
    }
    (value.itemReference)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.itemReferenceSer, it)
    }
    ((value.basis?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.basis?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.basisSer, it)
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

internal object ClinicalImpressionSerializer : KSerializer<ClinicalImpression> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClinicalImpression") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("effectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_effectiveDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("assessor", Reference.serializer().descriptor, isOptional = true)
    b.element("previous", Reference.serializer().descriptor, isOptional = true)
    b.element("problem", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "investigation",
      listSerialDescriptor(
        lazyDescriptor { ClinicalImpression.Investigation.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "protocol",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_protocol", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("summary", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_summary", Element.serializer().descriptor, isOptional = true)
    b.element(
      "finding",
      listSerialDescriptor(lazyDescriptor { ClinicalImpression.Finding.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "prognosisCodeableConcept",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "prognosisReference",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): ClinicalImpression =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ClinicalImpression")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ClinicalImpression {
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
          statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        14 ->
          code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusReasonSer, null)
        15 -> description = decoder.decodeStringElement(descriptor, i)
        16 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        19 -> effectiveDateTime = decoder.decodeStringElement(descriptor, i)
        20 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        22 -> date = decoder.decodeStringElement(descriptor, i)
        23 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          assessor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        25 ->
          previous =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        26 ->
          problem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.problemSer, null)
        27 ->
          investigation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.investigationSer, null)
        28 ->
          protocol =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        29 ->
          _protocol =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer2, null)
        30 -> summary = decoder.decodeStringElement(descriptor, i)
        31 ->
          _summary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          finding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.findingSer, null)
        33 ->
          prognosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.prognosisCodeableConceptSer,
              null,
            )
        34 ->
          prognosisReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.problemSer, null)
        35 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.problemSer, null)
        36 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        else -> throw SerializationException("Unexpected index decoding ClinicalImpression: " + i)
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
        Enumeration.of(
          status?.let { ClinicalImpression.ClinicalImpressionStatus.fromCode(it) },
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on ClinicalImpression"
          ),
      statusReason = statusReason,
      code = code,
      description = R4String.of(description, _description),
      subject =
        subject
          ?: throw SerializationException(
            "Missing required property 'subject' on ClinicalImpression"
          ),
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
        (kotlin.collections.List(maxOf(protocol?.size ?: 0, _protocol?.size ?: 0)) { index ->
          Uri.of(protocol?.getOrNull(index)?.let { it }, _protocol?.getOrNull(index))!!
        }),
      summary = R4String.of(summary, _summary),
      finding = finding ?: listOf(),
      prognosisCodeableConcept = prognosisCodeableConcept ?: listOf(),
      prognosisReference = prognosisReference ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ClinicalImpression,
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
    ((value.status.value?.code))?.let {
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
    (value.statusReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.statusReasonSer,
        it,
      )
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      Hoisted.subjectSer,
      value.subject,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.subjectSer, it)
    }
    when (val choice = value.effective) {
      null -> {}
      is ClinicalImpression.Effective.DateTime -> {
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
      is ClinicalImpression.Effective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          Hoisted.effectivePeriodSer,
          choice.value,
        )
      }
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.assessor)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.previous)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.problem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.problemSer,
        value.problem,
      )
    if (value.investigation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.investigationSer,
        value.investigation,
      )
    (value.protocol.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.protocolSer, it)
    }
    (value.protocol.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.protocolSer2, it)
    }
    ((value.summary?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.summary?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.finding.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.findingSer,
        value.finding,
      )
    if (value.prognosisCodeableConcept.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.prognosisCodeableConceptSer,
        value.prognosisCodeableConcept,
      )
    if (value.prognosisReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.problemSer,
        value.prognosisReference,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.problemSer,
        value.supportingInfo,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
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

internal object ClinicalImpressionPolymorphicSerializer : KSerializer<ClinicalImpression> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClinicalImpression") {
      ClinicalImpressionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression) {
    encoder.encodeStructure(descriptor) {
      ClinicalImpressionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ClinicalImpression =
    decoder.decodeStructure(descriptor) {
      ClinicalImpressionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
