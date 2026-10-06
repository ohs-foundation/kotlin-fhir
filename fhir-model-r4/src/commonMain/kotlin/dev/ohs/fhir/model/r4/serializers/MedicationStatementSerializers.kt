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
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicationStatement
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder

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
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("medicationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("medicationReference", ReferenceSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("context", ReferenceSerializer.descriptor)
    b.optionalElement("effectiveDateTime", String.serializer().descriptor)
    b.optionalElement("_effectiveDateTime", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("dateAsserted", String.serializer().descriptor)
    b.optionalElement("_dateAsserted", ElementSerializer.descriptor)
    b.optionalElement("informationSource", ReferenceSerializer.descriptor)
    b.optionalElement("derivedFrom", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("dosage", DosageSerializer.listSerializer.descriptor)
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
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var statusReason: List<CodeableConcept>? = null
    var category: CodeableConcept? = null
    var medicationCodeableConcept: CodeableConcept? = null
    var medicationReference: Reference? = null
    var subject: Reference? = null
    var context: Reference? = null
    var effectiveDateTime: String? = null
    var _effectiveDateTime: Element? = null
    var effectivePeriod: Period? = null
    var dateAsserted: String? = null
    var _dateAsserted: Element? = null
    var informationSource: Reference? = null
    var derivedFrom: List<Reference>? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var dosage: List<Dosage>? = null
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
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          statusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          medicationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          medicationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 -> effectiveDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _effectiveDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        24 -> dateAsserted = decoder.decodeStringElement(descriptor, i)
        25 ->
          _dateAsserted =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          informationSource =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        29 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        30 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        31 ->
          dosage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
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
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) MedicationStatement.MedicationStatusCodes.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on MedicationStatement"
          ),
      statusReason = statusReason ?: listOf(),
      category = category,
      medication =
        MedicationStatement.Medication.from(medicationCodeableConcept, medicationReference)
          ?: throw SerializationException(
            "Missing required property 'medication' on MedicationStatement"
          ),
      subject =
        subject
          ?: throw SerializationException(
            "Missing required property 'subject' on MedicationStatement"
          ),
      context = context,
      effective =
        MedicationStatement.Effective.from(
          DateTime.of(
            if (effectiveDateTime != null) FhirDateTime.fromString(effectiveDateTime) else null,
            _effectiveDateTime,
          ),
          effectivePeriod,
        ),
      dateAsserted =
        DateTime.of(
          if (dateAsserted != null) FhirDateTime.fromString(dateAsserted) else null,
          _dateAsserted,
        ),
      informationSource = informationSource,
      derivedFrom = derivedFrom ?: listOf(),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      dosage = dosage ?: listOf(),
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.statusReason,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.category,
    )
    when (val choice = value.medication) {
      is MedicationStatement.Medication.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicationStatement.Medication.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          18 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.context,
    )
    when (val choice = value.effective) {
      null -> {}
      is MedicationStatement.Effective.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          21 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
      is MedicationStatement.Effective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.dateAsserted?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.dateAsserted)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.informationSource,
    )
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.derivedFrom,
      )
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosage,
      )
  }
}
