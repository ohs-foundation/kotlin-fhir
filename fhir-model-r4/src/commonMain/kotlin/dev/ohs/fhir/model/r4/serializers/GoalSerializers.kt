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
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Goal
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object GoalTargetSerializer : KSerializer<Goal.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("measure", CodeableConceptSerializer.descriptor)
      optionalElement("detailQuantity", QuantitySerializer.descriptor)
      optionalElement("detailRange", RangeSerializer.descriptor)
      optionalElement("detailCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("detailString", KotlinString.serializer().descriptor)
      optionalElement("_detailString", ElementSerializer.descriptor)
      optionalElement("detailBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_detailBoolean", ElementSerializer.descriptor)
      optionalElement("detailInteger", Int.serializer().descriptor)
      optionalElement("_detailInteger", ElementSerializer.descriptor)
      optionalElement("detailRatio", RatioSerializer.descriptor)
      optionalElement("dueDate", KotlinString.serializer().descriptor)
      optionalElement("_dueDate", ElementSerializer.descriptor)
      optionalElement("dueDuration", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Goal.Target>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Goal.Target =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var measure: CodeableConcept? = null
      var detailQuantity: Quantity? = null
      var detailRange: Range? = null
      var detailCodeableConcept: CodeableConcept? = null
      var detailString: KotlinString? = null
      var _detailString: Element? = null
      var detailBoolean: KotlinBoolean? = null
      var _detailBoolean: Element? = null
      var detailInteger: Int? = null
      var _detailInteger: Element? = null
      var detailRatio: Ratio? = null
      var dueDate: KotlinString? = null
      var _dueDate: Element? = null
      var dueDuration: Duration? = null
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
            measure =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            detailQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 -> detailRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          6 ->
            detailCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> detailString = decodeStringElement(descriptor, i)
          8 ->
            _detailString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> detailBoolean = decodeBooleanElement(descriptor, i)
          10 ->
            _detailBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> detailInteger = decodeIntElement(descriptor, i)
          12 ->
            _detailInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            detailRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          14 -> dueDate = decodeStringElement(descriptor, i)
          15 -> _dueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            dueDuration = decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Target: " + i)
        }
      }
      Goal.Target(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        measure = measure,
        detail =
          Goal.Target.Detail.from(
            detailQuantity,
            detailRange,
            detailCodeableConcept,
            R4String.of(detailString, _detailString),
            R4Boolean.of(detailBoolean, _detailBoolean),
            Integer.of(detailInteger, _detailInteger),
            detailRatio,
          ),
        due =
          Goal.Target.Due.from(
            Date.of(if (dueDate != null) FhirDate.fromString(dueDate) else null, _dueDate),
            dueDuration,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Goal.Target) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.measure)
      when (val choice = value.detail) {
        null -> {}
        is Goal.Target.Detail.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
        is Goal.Target.Detail.Range -> {
          encodeSerializableElement(descriptor, 5, RangeSerializer, choice.value)
        }
        is Goal.Target.Detail.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
        is Goal.Target.Detail.String -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Goal.Target.Detail.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is Goal.Target.Detail.Integer -> {
          encodeIntIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is Goal.Target.Detail.Ratio -> {
          encodeSerializableElement(descriptor, 13, RatioSerializer, choice.value)
        }
      }
      when (val choice = value.due) {
        null -> {}
        is Goal.Target.Due.Date -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is Goal.Target.Due.Duration -> {
          encodeSerializableElement(descriptor, 16, DurationSerializer, choice.value)
        }
      }
    }
  }
}

internal object GoalSerializer : FhirResourceSerializer<Goal> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Goal")

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
    b.optionalElement("lifecycleStatus", KotlinString.serializer().descriptor)
    b.optionalElement("_lifecycleStatus", ElementSerializer.descriptor)
    b.optionalElement("achievementStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("priority", CodeableConceptSerializer.descriptor)
    b.optionalElement("description", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("startDate", KotlinString.serializer().descriptor)
    b.optionalElement("_startDate", ElementSerializer.descriptor)
    b.optionalElement("startCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("target", GoalTargetSerializer.listSerializer.descriptor)
    b.optionalElement("statusDate", KotlinString.serializer().descriptor)
    b.optionalElement("_statusDate", ElementSerializer.descriptor)
    b.optionalElement("statusReason", KotlinString.serializer().descriptor)
    b.optionalElement("_statusReason", ElementSerializer.descriptor)
    b.optionalElement("expressedBy", ReferenceSerializer.descriptor)
    b.optionalElement("addresses", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("outcomeCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("outcomeReference", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Goal {
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
    var lifecycleStatus: KotlinString? = null
    var _lifecycleStatus: Element? = null
    var achievementStatus: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var priority: CodeableConcept? = null
    var description: CodeableConcept? = null
    var subject: Reference? = null
    var startDate: KotlinString? = null
    var _startDate: Element? = null
    var startCodeableConcept: CodeableConcept? = null
    var target: List<Goal.Target>? = null
    var statusDate: KotlinString? = null
    var _statusDate: Element? = null
    var statusReason: KotlinString? = null
    var _statusReason: Element? = null
    var expressedBy: Reference? = null
    var addresses: List<Reference>? = null
    var note: List<Annotation>? = null
    var outcomeCode: List<CodeableConcept>? = null
    var outcomeReference: List<Reference>? = null
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
        11 -> lifecycleStatus = decoder.decodeStringElement(descriptor, i)
        12 ->
          _lifecycleStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          achievementStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          description =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 -> startDate = decoder.decodeStringElement(descriptor, i)
        19 ->
          _startDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          startCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 ->
          target =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GoalTargetSerializer.listSerializer,
              null,
            )
        22 -> statusDate = decoder.decodeStringElement(descriptor, i)
        23 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> statusReason = decoder.decodeStringElement(descriptor, i)
        25 ->
          _statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          expressedBy =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          addresses =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        29 ->
          outcomeCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        30 ->
          outcomeReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Goal: " + i)
      }
    }
    return Goal(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      lifecycleStatus =
        Enumeration.of(
          if (lifecycleStatus != null) Goal.GoalLifecycleStatus.fromCode(lifecycleStatus) else null,
          _lifecycleStatus,
        ) ?: throw SerializationException("Missing required property 'lifecycleStatus' on Goal"),
      achievementStatus = achievementStatus,
      category = category ?: listOf(),
      priority = priority,
      description =
        description
          ?: throw SerializationException("Missing required property 'description' on Goal"),
      subject =
        subject ?: throw SerializationException("Missing required property 'subject' on Goal"),
      start =
        Goal.Start.from(
          Date.of(if (startDate != null) FhirDate.fromString(startDate) else null, _startDate),
          startCodeableConcept,
        ),
      target = target ?: listOf(),
      statusDate =
        Date.of(if (statusDate != null) FhirDate.fromString(statusDate) else null, _statusDate),
      statusReason = R4String.of(statusReason, _statusReason),
      expressedBy = expressedBy,
      addresses = addresses ?: listOf(),
      note = note ?: listOf(),
      outcomeCode = outcomeCode ?: listOf(),
      outcomeReference = outcomeReference ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Goal,
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
    encoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.lifecycleStatus.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.lifecycleStatus)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.achievementStatus,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.description,
    )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    when (val choice = value.start) {
      null -> {}
      is Goal.Start.Date -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          18 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, choice.value)
      }
      is Goal.Start.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          20 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        GoalTargetSerializer.listSerializer,
        value.target,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.statusDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.statusDate)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.statusReason?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.statusReason)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.expressedBy,
    )
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.addresses,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.outcomeCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.outcomeCode,
      )
    if (value.outcomeReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.outcomeReference,
      )
  }
}
