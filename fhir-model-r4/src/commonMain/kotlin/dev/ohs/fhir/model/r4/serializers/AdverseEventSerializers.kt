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
import dev.ohs.fhir.model.r4.terminologies.AdverseEventActuality
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

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instance: Reference? = null
    var causality: List<AdverseEvent.SuspectEntity.Causality>? = null
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
          instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          causality =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventSuspectEntityCausalitySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SuspectEntity: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.SuspectEntity(
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.instance)
    if (value.causality.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        AdverseEventSuspectEntityCausalitySerializer.listSerializer,
        value.causality,
      )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Causality {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var assessment: CodeableConcept? = null
    var productRelatedness: KotlinString? = null
    var _productRelatedness: Element? = null
    var author: Reference? = null
    var method: CodeableConcept? = null
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
          assessment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> productRelatedness = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _productRelatedness =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        7 ->
          method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Causality: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.SuspectEntity.Causality(
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
      value.assessment,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.productRelatedness?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.productRelatedness)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.author)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.method,
    )
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
              IdentifierSerializer,
              null,
            )
        11 -> actuality = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _actuality =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          event =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> detected = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _detected =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> recordedDate = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _recordedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          resultingCondition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        25 ->
          seriousness =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          severity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          recorder =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        29 ->
          contributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        30 ->
          suspectEntity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventSuspectEntitySerializer.listSerializer,
              null,
            )
        31 ->
          subjectMedicalHistory =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          referenceDocument =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          study =
            compositeDecoder.decodeNullableSerializableElement(
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
          if (actuality != null) AdverseEventActuality.fromCode(actuality) else null,
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AdverseEvent,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.actuality.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.actuality)
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.event,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.detected?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.detected)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.recordedDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.recordedDate)
    if (value.resultingCondition.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.resultingCondition,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.seriousness,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.severity,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.outcome,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.recorder,
    )
    if (value.contributor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.contributor,
      )
    if (value.suspectEntity.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        AdverseEventSuspectEntitySerializer.listSerializer,
        value.suspectEntity,
      )
    if (value.subjectMedicalHistory.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subjectMedicalHistory,
      )
    if (value.referenceDocument.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.referenceDocument,
      )
    if (value.study.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.study,
      )
  }
}
