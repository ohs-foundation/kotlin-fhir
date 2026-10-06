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
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
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
import dev.ohs.fhir.model.r5.MedicationAdministration
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object MedicationAdministrationPerformerSerializer :
  KSerializer<MedicationAdministration.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", CodeableReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationAdministration.Performer>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationAdministration.Performer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var function: CodeableConcept? = null
      var actor: CodeableReference? = null
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
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            actor =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Performer: " + i)
        }
      }
      MedicationAdministration.Performer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        function = function,
        actor =
          actor
            ?: throw SerializationException(
              "Missing required property 'actor' on MedicationAdministration.Performer"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Performer) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.function)
      encodeSerializableElement(descriptor, 4, CodeableReferenceSerializer, value.actor)
    }
  }
}

internal object MedicationAdministrationDosageSerializer :
  KSerializer<MedicationAdministration.Dosage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("site", CodeableConceptSerializer.descriptor)
      optionalElement("route", CodeableConceptSerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.descriptor)
      optionalElement("dose", QuantitySerializer.descriptor)
      optionalElement("rateRatio", RatioSerializer.descriptor)
      optionalElement("rateQuantity", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicationAdministration.Dosage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicationAdministration.Dosage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var text: KotlinString? = null
      var _text: Element? = null
      var site: CodeableConcept? = null
      var route: CodeableConcept? = null
      var method: CodeableConcept? = null
      var dose: Quantity? = null
      var rateRatio: Ratio? = null
      var rateQuantity: Quantity? = null
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
          3 -> text = decodeStringElement(descriptor, i)
          4 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            site = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            route =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            method =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 -> dose = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> rateRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          10 ->
            rateQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Dosage: " + i)
        }
      }
      MedicationAdministration.Dosage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        text = R5String.of(text, _text),
        site = site,
        route = route,
        method = method,
        dose = dose,
        rate = MedicationAdministration.Dosage.Rate.from(rateRatio, rateQuantity),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicationAdministration.Dosage) {
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
      encodeStringIfNotNull(descriptor, 3, value.text?.value)
      encodeElementIfNotNull(descriptor, 4, value.text)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.site)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.route)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.method)
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.dose)
      when (val choice = value.rate) {
        null -> {}
        is MedicationAdministration.Dosage.Rate.Ratio -> {
          encodeSerializableElement(descriptor, 9, RatioSerializer, choice.value)
        }
        is MedicationAdministration.Dosage.Rate.Quantity -> {
          encodeSerializableElement(descriptor, 10, QuantitySerializer, choice.value)
        }
      }
    }
  }
}

internal object MedicationAdministrationSerializer :
  FhirResourceSerializer<MedicationAdministration> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicationAdministration")

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
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("statusReason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("medication", CodeableReferenceSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("occurenceDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_occurenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurenceTiming", TimingSerializer.descriptor)
    b.optionalElement("recorded", KotlinString.serializer().descriptor)
    b.optionalElement("_recorded", ElementSerializer.descriptor)
    b.optionalElement("isSubPotent", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_isSubPotent", ElementSerializer.descriptor)
    b.optionalElement("subPotentReason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "performer",
      MedicationAdministrationPerformerSerializer.listSerializer.descriptor,
    )
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.descriptor)
    b.optionalElement("device", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("dosage", MedicationAdministrationDosageSerializer.descriptor)
    b.optionalElement("eventHistory", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicationAdministration {
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
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: List<CodeableConcept>? = null
    var category: List<CodeableConcept>? = null
    var medication: CodeableReference? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var occurenceDateTime: KotlinString? = null
    var _occurenceDateTime: Element? = null
    var occurencePeriod: Period? = null
    var occurenceTiming: Timing? = null
    var recorded: KotlinString? = null
    var _recorded: Element? = null
    var isSubPotent: KotlinBoolean? = null
    var _isSubPotent: Element? = null
    var subPotentReason: List<CodeableConcept>? = null
    var performer: List<MedicationAdministration.Performer>? = null
    var reason: List<CodeableReference>? = null
    var request: Reference? = null
    var device: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var dosage: MedicationAdministration.Dosage? = null
    var eventHistory: List<Reference>? = null
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
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 ->
          medication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        18 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        21 -> occurenceDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _occurenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          occurencePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        24 ->
          occurenceTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        25 -> recorded = decoder.decodeStringElement(descriptor, i)
        26 ->
          _recorded =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> isSubPotent = decoder.decodeBooleanElement(descriptor, i)
        28 ->
          _isSubPotent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          subPotentReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        30 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationAdministrationPerformerSerializer.listSerializer,
              null,
            )
        31 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        33 ->
          device =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        34 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        35 ->
          dosage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicationAdministrationDosageSerializer,
              null,
            )
        36 ->
          eventHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding MedicationAdministration: " + i)
      }
    }
    return MedicationAdministration(
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
          if (status != null)
            MedicationAdministration.MedicationAdministrationStatusCodes.fromCode(status)
          else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on MedicationAdministration"
          ),
      statusReason = statusReason ?: listOf(),
      category = category ?: listOf(),
      medication =
        medication
          ?: throw SerializationException(
            "Missing required property 'medication' on MedicationAdministration"
          ),
      subject =
        subject
          ?: throw SerializationException(
            "Missing required property 'subject' on MedicationAdministration"
          ),
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      occurence =
        MedicationAdministration.Occurence.from(
          DateTime.of(
            if (occurenceDateTime != null) FhirDateTime.fromString(occurenceDateTime) else null,
            _occurenceDateTime,
          ),
          occurencePeriod,
          occurenceTiming,
        )
          ?: throw SerializationException(
            "Missing required property 'occurence' on MedicationAdministration"
          ),
      recorded =
        DateTime.of(if (recorded != null) FhirDateTime.fromString(recorded) else null, _recorded),
      isSubPotent = R5Boolean.of(isSubPotent, _isSubPotent),
      subPotentReason = subPotentReason ?: listOf(),
      performer = performer ?: listOf(),
      reason = reason ?: listOf(),
      request = request,
      device = device ?: listOf(),
      note = note ?: listOf(),
      dosage = dosage,
      eventHistory = eventHistory ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicationAdministration,
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      CodeableReferenceSerializer,
      value.medication,
    )
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    when (val choice = value.occurence) {
      is MedicationAdministration.Occurence.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          21 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
      is MedicationAdministration.Occurence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is MedicationAdministration.Occurence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.recorded?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.recorded)
    encoder.encodeBooleanIfNotNull(descriptor, 27 + descriptorOffset, value.isSubPotent?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.isSubPotent)
    if (value.subPotentReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.subPotentReason,
      )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        MedicationAdministrationPerformerSerializer.listSerializer,
        value.performer,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.request,
    )
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.device,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      MedicationAdministrationDosageSerializer,
      value.dosage,
    )
    if (value.eventHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.eventHistory,
      )
  }
}
