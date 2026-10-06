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

import dev.ohs.fhir.model.r4.AdverseEvent
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
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
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

internal object AdverseEventSuspectEntitySerializer : KSerializer<AdverseEvent.SuspectEntity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SuspectEntity") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("instance", ReferenceSerializer.descriptor)
      optionalElement(
        "causality",
        AdverseEventSuspectEntityCausalitySerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.SuspectEntity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var instance: Reference? = null
      var causality: List<AdverseEvent.SuspectEntity.Causality>? = null
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
            instance = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            causality =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AdverseEventSuspectEntityCausalitySerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SuspectEntity: " + i)
        }
      }
      AdverseEvent.SuspectEntity(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        instance =
          instance
            ?: throw SerializationException(
              "Missing required property 'instance' on AdverseEvent.SuspectEntity"
            ),
        causality = causality ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.instance)
      if (value.causality.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          AdverseEventSuspectEntityCausalitySerializer.listSerializer,
          value.causality,
        )
    }
  }
}

internal object AdverseEventSuspectEntityCausalitySerializer :
  KSerializer<AdverseEvent.SuspectEntity.Causality> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Causality") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("assessment", CodeableConceptSerializer.descriptor)
      optionalElement("productRelatedness", KotlinString.serializer().descriptor)
      optionalElement("_productRelatedness", ElementSerializer.descriptor)
      optionalElement("author", ReferenceSerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.SuspectEntity.Causality>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Causality =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var assessment: CodeableConcept? = null
      var productRelatedness: KotlinString? = null
      var _productRelatedness: Element? = null
      var author: Reference? = null
      var method: CodeableConcept? = null
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
            assessment =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> productRelatedness = decodeStringElement(descriptor, i)
          5 ->
            _productRelatedness =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> author = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 ->
            method =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Causality: " + i)
        }
      }
      AdverseEvent.SuspectEntity.Causality(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        assessment = assessment,
        productRelatedness = R4String.of(productRelatedness, _productRelatedness),
        author = author,
        method = method,
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.assessment)
      encodeStringIfNotNull(descriptor, 4, value.productRelatedness?.value)
      encodeElementIfNotNull(descriptor, 5, value.productRelatedness)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.author)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.method)
    }
  }
}

internal object AdverseEventSerializer : FhirResourceSerializer<AdverseEvent> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("AdverseEvent")

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
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("actuality", KotlinString.serializer().descriptor)
    b.optionalElement("_actuality", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("event", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("detected", KotlinString.serializer().descriptor)
    b.optionalElement("_detected", ElementSerializer.descriptor)
    b.optionalElement("recordedDate", KotlinString.serializer().descriptor)
    b.optionalElement("_recordedDate", ElementSerializer.descriptor)
    b.optionalElement("resultingCondition", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("seriousness", CodeableConceptSerializer.descriptor)
    b.optionalElement("severity", CodeableConceptSerializer.descriptor)
    b.optionalElement("outcome", CodeableConceptSerializer.descriptor)
    b.optionalElement("recorder", ReferenceSerializer.descriptor)
    b.optionalElement("contributor", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "suspectEntity",
      AdverseEventSuspectEntitySerializer.listSerializer.descriptor,
    )
    b.optionalElement("subjectMedicalHistory", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("referenceDocument", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("study", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): AdverseEvent {
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
    var identifier: Identifier? = null
    var actuality: KotlinString? = null
    var _actuality: Element? = null
    var category: List<CodeableConcept>? = null
    var event: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var detected: KotlinString? = null
    var _detected: Element? = null
    var recordedDate: KotlinString? = null
    var _recordedDate: Element? = null
    var resultingCondition: List<Reference>? = null
    var location: Reference? = null
    var seriousness: CodeableConcept? = null
    var severity: CodeableConcept? = null
    var outcome: CodeableConcept? = null
    var recorder: Reference? = null
    var contributor: List<Reference>? = null
    var suspectEntity: List<AdverseEvent.SuspectEntity>? = null
    var subjectMedicalHistory: List<Reference>? = null
    var referenceDocument: List<Reference>? = null
    var study: List<Reference>? = null
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
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        11 -> actuality = decoder.decodeStringElement(descriptor, i)
        12 ->
          _actuality =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          event =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 -> date = decoder.decodeStringElement(descriptor, i)
        18 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> detected = decoder.decodeStringElement(descriptor, i)
        20 ->
          _detected =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> recordedDate = decoder.decodeStringElement(descriptor, i)
        22 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          resultingCondition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        25 ->
          seriousness =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          severity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          outcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          recorder =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          contributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        30 ->
          suspectEntity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventSuspectEntitySerializer.listSerializer,
              null,
            )
        31 ->
          subjectMedicalHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          referenceDocument =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          study =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding AdverseEvent: " + i)
      }
    }
    return AdverseEvent(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      actuality =
        Enumeration.of(
          if (actuality != null) AdverseEvent.AdverseEventActuality.fromCode(actuality) else null,
          _actuality,
        ) ?: throw SerializationException("Missing required property 'actuality' on AdverseEvent"),
      category = category ?: listOf(),
      event = event,
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on AdverseEvent"),
      encounter = encounter,
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      detected =
        DateTime.of(if (detected != null) FhirDateTime.fromString(detected) else null, _detected),
      recordedDate =
        DateTime.of(
          if (recordedDate != null) FhirDateTime.fromString(recordedDate) else null,
          _recordedDate,
        ),
      resultingCondition = resultingCondition ?: listOf(),
      location = location,
      seriousness = seriousness,
      severity = severity,
      outcome = outcome,
      recorder = recorder,
      contributor = contributor ?: listOf(),
      suspectEntity = suspectEntity ?: listOf(),
      subjectMedicalHistory = subjectMedicalHistory ?: listOf(),
      referenceDocument = referenceDocument ?: listOf(),
      study = study ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AdverseEvent,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.actuality.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.actuality)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.event,
    )
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.detected?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.detected)
    encoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.recordedDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.recordedDate)
    if (value.resultingCondition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.resultingCondition,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.seriousness,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.severity,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.outcome,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.recorder,
    )
    if (value.contributor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.contributor,
      )
    if (value.suspectEntity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        AdverseEventSuspectEntitySerializer.listSerializer,
        value.suspectEntity,
      )
    if (value.subjectMedicalHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subjectMedicalHistory,
      )
    if (value.referenceDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.referenceDocument,
      )
    if (value.study.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.study,
      )
  }
}
