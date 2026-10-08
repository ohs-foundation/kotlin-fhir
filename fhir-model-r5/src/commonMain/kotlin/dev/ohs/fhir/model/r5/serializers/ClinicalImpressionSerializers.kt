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
import dev.ohs.fhir.model.r5.ClinicalImpression
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.EventStatus
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

internal object ClinicalImpressionFindingSerializer : KSerializer<ClinicalImpression.Finding> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Finding") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("item", CodeableReferenceSerializer.descriptor)
      optionalElement("basis", KotlinString.serializer().descriptor)
      optionalElement("_basis", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ClinicalImpression.Finding>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ClinicalImpression.Finding {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
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
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 -> basis = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
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
      item = item,
      basis = R5String.of(basis, _basis),
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
      CodeableReferenceSerializer,
      value.item,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.basis?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.basis)
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
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("effectiveDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_effectiveDateTime", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.descriptor)
    b.optionalElement("previous", ReferenceSerializer.descriptor)
    b.optionalElement("problem", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("changePattern", CodeableConceptSerializer.descriptor)
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
    var description: KotlinString? = null
    var _description: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var effectiveDateTime: KotlinString? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var performer: Reference? = null
    var previous: Reference? = null
    var problem: List<Reference>? = null
    var changePattern: CodeableConcept? = null
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
        14 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 -> effectiveDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _effectiveDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        21 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          previous =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        25 ->
          problem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          changePattern =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          protocol =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        28 ->
          _protocol =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        29 -> summary = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _summary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          finding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClinicalImpressionFindingSerializer.listSerializer,
              null,
            )
        32 ->
          prognosisCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        33 ->
          prognosisReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        34 ->
          supportingInfo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
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
        Enumeration.of(if (status != null) EventStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on ClinicalImpression"
          ),
      statusReason = statusReason,
      description = R5String.of(description, _description),
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
      performer = performer,
      previous = previous,
      problem = problem ?: listOf(),
      changePattern = changePattern,
      protocol =
        (kotlin.collections.List(maxOf(protocol?.size ?: 0, _protocol?.size ?: 0)) { index ->
          Uri.of(protocol?.getOrNull(index), _protocol?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'protocol' on ClinicalImpression has neither a value nor an id/extension"
            )
        }),
      summary = R5String.of(summary, _summary),
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.description)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.effective) {
      null -> {}
      is ClinicalImpression.Effective.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          18 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, choice.value)
      }
      is ClinicalImpression.Effective.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          20 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.performer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.previous,
    )
    if (value.problem.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.problem,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.changePattern,
    )
    if (value.protocol.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        27 + descriptorOffset,
        stringNullableListSerializer,
        value.protocol.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 28 + descriptorOffset, value.protocol)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.summary?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.summary)
    if (value.finding.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ClinicalImpressionFindingSerializer.listSerializer,
        value.finding,
      )
    if (value.prognosisCodeableConcept.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.prognosisCodeableConcept,
      )
    if (value.prognosisReference.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.prognosisReference,
      )
    if (value.supportingInfo.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
