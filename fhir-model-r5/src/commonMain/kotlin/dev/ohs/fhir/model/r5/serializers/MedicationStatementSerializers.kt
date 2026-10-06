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
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Dosage
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MedicationStatement
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Timing
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

internal object MedicationStatementAdherenceSerializer :
  KSerializer<MedicationStatement.Adherence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Adherence") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("reason", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationStatement.Adherence>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationStatement.Adherence =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var reason: CodeableConcept? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            reason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Adherence: " + i)
        }
      }
      MedicationStatement.Adherence(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on MedicationStatement.Adherence"
            ),
        reason = reason,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationStatement.Adherence) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.reason)
    }
  }
}

internal object MedicationStatementSerializer : FhirResourceSerializer<MedicationStatement> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicationStatement")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("medication", CodeableReferenceSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("effectiveDateTime", String.serializer().descriptor)
    b.optionalElement("_effectiveDateTime", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("effectiveTiming", TimingSerializer.descriptor)
    b.optionalElement("dateAsserted", String.serializer().descriptor)
    b.optionalElement("_dateAsserted", ElementSerializer.descriptor)
    b.optionalElement("informationSource", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("derivedFrom", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("relatedClinicalInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("renderedDosageInstruction", String.serializer().descriptor)
    b.optionalElement("_renderedDosageInstruction", ElementSerializer.descriptor)
    b.optionalElement("dosage", DosageSerializer.listSerializer.descriptor)
    b.optionalElement("adherence", MedicationStatementAdherenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationStatement {
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
    var partOf: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var medication: CodeableReference? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var effectiveDateTime: String? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var effectiveTiming: Timing? = null
    var dateAsserted: String? = null
    var _dateAsserted: Element? = null
    var informationSource: List<Reference>? = null
    var derivedFrom: List<Reference>? = null
    var reason: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var relatedClinicalInformation: List<Reference>? = null
    var renderedDosageInstruction: String? = null
    var _renderedDosageInstruction: Element? = null
    var dosage: List<Dosage>? = null
    var adherence: MedicationStatement.Adherence? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          medication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        16 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 -> effectiveDateTime = decoder.decodeStringElement(descriptor, i)
        19 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        21 ->
          effectiveTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        22 -> dateAsserted = decoder.decodeStringElement(descriptor, i)
        23 ->
          _dateAsserted =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          informationSource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        25 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        28 ->
          relatedClinicalInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 -> renderedDosageInstruction = decoder.decodeStringElement(descriptor, i)
        30 ->
          _renderedDosageInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          dosage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        32 ->
          adherence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationStatementAdherenceSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MedicationStatement: " + i)
      }
    }
    return MedicationStatement(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) MedicationStatement.MedicationStatementStatusCodes.fromCode(status)
          else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on MedicationStatement"
          ),
      category = category ?: listOf(),
      medication =
        medication
          ?: throw SerializationException(
            "Missing required property 'medication' on MedicationStatement"
          ),
      subject =
        subject
          ?: throw SerializationException(
            "Missing required property 'subject' on MedicationStatement"
          ),
      encounter = encounter,
      effective =
        MedicationStatement.Effective.from(
          DateTime.of(
            if (effectiveDateTime != null) FhirDateTime.fromString(effectiveDateTime) else null,
            _effectiveDateTime,
          ),
          effectivePeriod,
          effectiveTiming,
        ),
      dateAsserted =
        DateTime.of(
          if (dateAsserted != null) FhirDateTime.fromString(dateAsserted) else null,
          _dateAsserted,
        ),
      informationSource = informationSource ?: listOf(),
      derivedFrom = derivedFrom ?: listOf(),
      reason = reason ?: listOf(),
      note = note ?: listOf(),
      relatedClinicalInformation = relatedClinicalInformation ?: listOf(),
      renderedDosageInstruction =
        Markdown.of(renderedDosageInstruction, _renderedDosageInstruction),
      dosage = dosage ?: listOf(),
      adherence = adherence,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationStatement,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      CodeableReferenceSerializer,
      value.medication,
    )
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.effective) {
      null -> {}
      is MedicationStatement.Effective.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          18 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, choice.value)
      }
      is MedicationStatement.Effective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          20 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is MedicationStatement.Effective.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.dateAsserted?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.dateAsserted)
    if (value.informationSource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.informationSource,
      )
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.derivedFrom,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.relatedClinicalInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.relatedClinicalInformation,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.renderedDosageInstruction?.value,
    )
    encoder.encodeElementIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.renderedDosageInstruction,
    )
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosage,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      MedicationStatementAdherenceSerializer,
      value.adherence,
    )
  }
}
