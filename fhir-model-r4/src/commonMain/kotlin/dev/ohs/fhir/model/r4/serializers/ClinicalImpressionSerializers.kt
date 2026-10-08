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
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.ClinicalImpressionStatus
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

internal object ClinicalImpressionInvestigationSerializer :
  KSerializer<ClinicalImpression.Investigation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Investigation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("item", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ClinicalImpression.Investigation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalImpression.Investigation {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var item: List<Reference>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Investigation: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Investigation) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    if (value.item.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        ReferenceSerializer.listSerializer,
        value.item,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalImpressionFindingSerializer : KSerializer<ClinicalImpression.Finding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Finding") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("itemReference", ReferenceSerializer.descriptor)
      optionalElement("basis", KotlinString.serializer().descriptor)
      optionalElement("_basis", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ClinicalImpression.Finding>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalImpression.Finding {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemCodeableConcept: CodeableConcept? = null
    var itemReference: Reference? = null
    var basis: KotlinString? = null
    var _basis: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          itemCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          itemReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 -> basis = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _basis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Finding: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ClinicalImpression.Finding(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemCodeableConcept = itemCodeableConcept,
      itemReference = itemReference,
      basis = R4String.of(basis, _basis),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Finding) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.itemCodeableConcept,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      ReferenceSerializer,
      value.itemReference,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.basis?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.basis)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClinicalImpressionSerializer : FhirResourceSerializer<ClinicalImpression> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ClinicalImpression")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("effectiveDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_effectiveDateTime", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("assessor", ReferenceSerializer.descriptor)
    b.optionalElement("previous", ReferenceSerializer.descriptor)
    b.optionalElement("problem", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "investigation",
      ClinicalImpressionInvestigationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("protocol", stringNullableListSerializer.descriptor)
    b.optionalElement("_protocol", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("summary", KotlinString.serializer().descriptor)
    b.optionalElement("_summary", ElementSerializer.descriptor)
    b.optionalElement("finding", ClinicalImpressionFindingSerializer.listSerializer.descriptor)
    b.optionalElement(
      "prognosisCodeableConcept",
      CodeableConceptSerializer.listSerializer.descriptor,
    )
    b.optionalElement("prognosisReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInfo", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          statusReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 -> effectiveDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _effectiveDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        22 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          assessor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        25 ->
          previous =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        26 ->
          problem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          investigation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalImpressionInvestigationSerializer.listSerializer,
              null,
            )
        28 ->
          protocol =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        29 ->
          _protocol =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        30 -> summary = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _summary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          finding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalImpressionFindingSerializer.listSerializer,
              null,
            )
        33 ->
          prognosisCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        34 ->
          prognosisReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
          supportingInfo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        36 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
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
          if (status != null) ClinicalImpressionStatus.fromCode(status) else null,
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
          DateTime.of(
            if (effectiveDateTime != null) FhirDateTime.fromString(effectiveDateTime) else null,
            _effectiveDateTime,
          ),
          effectivePeriod,
        ),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      assessor = assessor,
      previous = previous,
      problem = problem ?: listOf(),
      investigation = investigation ?: listOf(),
      protocol =
        (kotlin.collections.List(maxOf(protocol?.size ?: 0, _protocol?.size ?: 0)) { index ->
          Uri.of(protocol?.getOrNull(index), _protocol?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'protocol' on ClinicalImpression has neither a value nor an id/extension"
            )
        }),
      summary = R4String.of(summary, _summary),
      finding = finding ?: listOf(),
      prognosisCodeableConcept = prognosisCodeableConcept ?: listOf(),
      prognosisReference = prognosisReference ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ClinicalImpression,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.statusReason,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.description)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.effective) {
      null -> {}
      is ClinicalImpression.Effective.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          19 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, choice.value)
      }
      is ClinicalImpression.Effective.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.assessor,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.previous,
    )
    if (value.problem.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.problem,
      )
    if (value.investigation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ClinicalImpressionInvestigationSerializer.listSerializer,
        value.investigation,
      )
    if (value.protocol.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        28 + descriptorOffset,
        stringNullableListSerializer,
        value.protocol.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 29 + descriptorOffset, value.protocol)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.summary?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.summary)
    if (value.finding.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ClinicalImpressionFindingSerializer.listSerializer,
        value.finding,
      )
    if (value.prognosisCodeableConcept.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.prognosisCodeableConcept,
      )
    if (value.prognosisReference.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.prognosisReference,
      )
    if (value.supportingInfo.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
